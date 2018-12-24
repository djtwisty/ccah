package com.google.gms.googleservices;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.resources.TextResource;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

public class GoogleServicesTask extends DefaultTask {
    private static final Pattern GOOGLE_APP_ID_REGEX = Pattern.compile("(\\d+):(\\d+):(\\p{Alnum}+):(\\p{XDigit}+)");
    private static final String GOOGLE_APP_ID_VERSION = "1";
    private static final String OAUTH_CLIENT_TYPE_WEB = "3";
    private static final String STATUS_DISABLED = "1";
    private static final String STATUS_ENABLED = "2";
    @OutputDirectory
    public File intermediateDir;
    @Input
    public String packageNameXOR1;
    @Input
    public TextResource packageNameXOR2;
    @InputFile
    @Optional
    public File quickstartFile;
    @Input
    public String searchedLocation;

    @TaskAction
    public void action() {
        if (this.quickstartFile.isFile()) {
            getProject().getLogger().warn("Parsing json file: " + this.quickstartFile.getPath());
            deleteFolder(this.intermediateDir);
            if (this.intermediateDir.mkdirs()) {
                JsonElement parse = new JsonParser().parse(Files.newReader(this.quickstartFile, Charsets.UTF_8));
                if (parse.isJsonObject()) {
                    JsonObject asJsonObject = parse.getAsJsonObject();
                    Map treeMap = new TreeMap();
                    Map treeMap2 = new TreeMap();
                    handleProjectNumberAndProjectId(asJsonObject, treeMap);
                    handleFirebaseUrl(asJsonObject, treeMap);
                    asJsonObject = getClientForPackageName(asJsonObject);
                    if (asJsonObject != null) {
                        handleAnalytics(asJsonObject, treeMap);
                        handleMapsService(asJsonObject, treeMap);
                        handleGoogleApiKey(asJsonObject, treeMap);
                        handleGoogleAppId(asJsonObject, treeMap);
                        handleWebClientId(asJsonObject, treeMap);
                        File file = new File(this.intermediateDir, "values");
                        if (file.exists() || file.mkdirs()) {
                            Files.write(getValuesContent(treeMap, treeMap2), new File(file, "values.xml"), Charsets.UTF_8);
                            return;
                        }
                        throw new GradleException("Failed to create folder: " + file);
                    }
                    throw new GradleException("No matching client found for package name '" + getPackageName() + "'");
                }
                throw new GradleException("Malformed root json");
            }
            throw new GradleException("Failed to create folder: " + this.intermediateDir);
        }
        throw new GradleException(String.format("File %s is missing. The Google Services Plugin cannot function without it. %n Searched Location: %s", new Object[]{this.quickstartFile.getName(), this.searchedLocation}));
    }

    private void handleFirebaseUrl(JsonObject jsonObject, Map<String, String> map) {
        JsonObject asJsonObject = jsonObject.getAsJsonObject("project_info");
        if (asJsonObject == null) {
            throw new GradleException("Missing project_info object");
        }
        JsonPrimitive asJsonPrimitive = asJsonObject.getAsJsonPrimitive("firebase_url");
        if (asJsonPrimitive != null) {
            map.put("firebase_database_url", asJsonPrimitive.getAsString());
        }
    }

    private void handleProjectNumberAndProjectId(JsonObject jsonObject, Map<String, String> map) {
        JsonObject asJsonObject = jsonObject.getAsJsonObject("project_info");
        if (asJsonObject == null) {
            throw new GradleException("Missing project_info object");
        }
        JsonPrimitive asJsonPrimitive = asJsonObject.getAsJsonPrimitive("project_number");
        if (asJsonPrimitive == null) {
            throw new GradleException("Missing project_info/project_number object");
        }
        map.put("gcm_defaultSenderId", asJsonPrimitive.getAsString());
        asJsonPrimitive = asJsonObject.getAsJsonPrimitive("project_id");
        if (asJsonPrimitive == null) {
            throw new GradleException("Missing project_info/project_id object");
        }
        map.put("project_id", asJsonPrimitive.getAsString());
        JsonPrimitive asJsonPrimitive2 = asJsonObject.getAsJsonPrimitive("storage_bucket");
        if (asJsonPrimitive2 != null) {
            map.put("google_storage_bucket", asJsonPrimitive2.getAsString());
        }
    }

    private void handleWebClientId(JsonObject jsonObject, Map<String, String> map) {
        JsonArray asJsonArray = jsonObject.getAsJsonArray("oauth_client");
        if (asJsonArray != null) {
            int size = asJsonArray.size();
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement = asJsonArray.get(i);
                if (jsonElement != null && jsonElement.isJsonObject()) {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    JsonPrimitive asJsonPrimitive = asJsonObject.getAsJsonPrimitive("client_type");
                    if (asJsonPrimitive != null) {
                        if (OAUTH_CLIENT_TYPE_WEB.equals(asJsonPrimitive.getAsString())) {
                            JsonPrimitive asJsonPrimitive2 = asJsonObject.getAsJsonPrimitive("client_id");
                            if (asJsonPrimitive2 != null) {
                                map.put("default_web_client_id", asJsonPrimitive2.getAsString());
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private void handleAnalytics(JsonObject jsonObject, Map<String, String> map) {
        JsonObject serviceByName = getServiceByName(jsonObject, "analytics_service");
        if (serviceByName != null) {
            serviceByName = serviceByName.getAsJsonObject("analytics_property");
            if (serviceByName != null) {
                JsonPrimitive asJsonPrimitive = serviceByName.getAsJsonPrimitive("tracking_id");
                if (asJsonPrimitive != null) {
                    map.put("ga_trackingId", asJsonPrimitive.getAsString());
                    File file = new File(this.intermediateDir, "xml");
                    if (file.exists() || file.mkdirs()) {
                        Files.write(getGlobalTrackerContent(asJsonPrimitive.getAsString()), new File(file, "global_tracker.xml"), Charsets.UTF_8);
                        return;
                    }
                    throw new GradleException("Failed to create folder: " + file);
                }
            }
        }
    }

    private void handleMapsService(JsonObject jsonObject, Map<String, String> map) {
        if (getServiceByName(jsonObject, "maps_service") != null) {
            String androidApiKey = getAndroidApiKey(jsonObject);
            if (androidApiKey != null) {
                map.put("google_maps_key", androidApiKey);
                return;
            }
            throw new GradleException("Missing api_key/current_key object");
        }
    }

    private void handleGoogleApiKey(JsonObject jsonObject, Map<String, String> map) {
        String androidApiKey = getAndroidApiKey(jsonObject);
        if (androidApiKey != null) {
            map.put("google_api_key", androidApiKey);
            map.put("google_crash_reporting_api_key", androidApiKey);
            return;
        }
        throw new GradleException("Missing api_key/current_key object");
    }

    private String getAndroidApiKey(JsonObject jsonObject) {
        JsonArray asJsonArray = jsonObject.getAsJsonArray("api_key");
        if (asJsonArray != null) {
            int size = asJsonArray.size();
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement = asJsonArray.get(i);
                if (jsonElement != null && jsonElement.isJsonObject()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonObject().getAsJsonPrimitive("current_key");
                    if (asJsonPrimitive != null) {
                        return asJsonPrimitive.getAsString();
                    }
                }
            }
        }
        return null;
    }

    private static void findStringByName(JsonObject jsonObject, String str, Map<String, String> map) {
        JsonPrimitive asJsonPrimitive = jsonObject.getAsJsonPrimitive(str);
        if (asJsonPrimitive != null) {
            map.put(str, asJsonPrimitive.getAsString());
        }
    }

    private JsonObject getClientForPackageName(JsonObject jsonObject) {
        JsonArray asJsonArray = jsonObject.getAsJsonArray("client");
        if (asJsonArray != null) {
            int size = asJsonArray.size();
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement = asJsonArray.get(i);
                if (jsonElement != null && jsonElement.isJsonObject()) {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("client_info");
                    if (asJsonObject2 != null) {
                        asJsonObject2 = asJsonObject2.getAsJsonObject("android_client_info");
                        if (asJsonObject2 != null) {
                            JsonPrimitive asJsonPrimitive = asJsonObject2.getAsJsonPrimitive("package_name");
                            if (asJsonPrimitive != null && getPackageName().equals(asJsonPrimitive.getAsString())) {
                                return asJsonObject;
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private void handleGoogleAppId(JsonObject jsonObject, Map<String, String> map) {
        JsonObject asJsonObject = jsonObject.getAsJsonObject("client_info");
        if (asJsonObject == null) {
            throw new GradleException("Client does not have client info");
        }
        JsonPrimitive asJsonPrimitive = asJsonObject.getAsJsonPrimitive("mobilesdk_app_id");
        Object asString = asJsonPrimitive == null ? null : asJsonPrimitive.getAsString();
        if (Strings.isNullOrEmpty(asString)) {
            throw new GradleException("Missing Google App Id. Please follow instructions on https://firebase.google.com/ to get a valid config file that contains a Google App Id");
        }
        Matcher matcher = GOOGLE_APP_ID_REGEX.matcher(asString);
        if (matcher.matches()) {
            if ("1".equals(matcher.group(1))) {
                String group = matcher.group(3);
                if (group.equals("android")) {
                    map.put("google_app_id", asString);
                    return;
                }
                throw new GradleException("Expect Google App Id for Android App, but get " + group);
            }
            throw new GradleException("Google App Id Version is incompatible with this plugin. Please update the plugin version.");
        }
        throw new GradleException("Unexpected format of Google App ID. Please follow instructions on https://firebase.google.com/ to get a config file that contains a valid Google App Id or update the plugin version if you believe your Google App Id [" + asString + "] is correct.");
    }

    private JsonObject getServiceByName(JsonObject jsonObject, String str) {
        JsonObject asJsonObject = jsonObject.getAsJsonObject("services");
        if (asJsonObject == null) {
            return null;
        }
        asJsonObject = asJsonObject.getAsJsonObject(str);
        if (asJsonObject == null) {
            return null;
        }
        JsonPrimitive asJsonPrimitive = asJsonObject.getAsJsonPrimitive("status");
        if (asJsonPrimitive == null) {
            return null;
        }
        String asString = asJsonPrimitive.getAsString();
        if ("1".equals(asString)) {
            return null;
        }
        if (STATUS_ENABLED.equals(asString)) {
            return asJsonObject;
        }
        getLogger().warn(String.format("Status with value '%1$s' for service '%2$s' is unknown", new Object[]{asString, str}));
        return null;
    }

    private static String getGlobalTrackerContent(String str) {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n    <string name=\"ga_trackingId\" translatable=\"false\">" + str + "</string>\n</resources>\n";
    }

    private static String getValuesContent(Map<String, String> map, Map<String, Map<String, String>> map2) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            stringBuilder.append("    <string name=\"").append(str).append("\" translatable=\"false\"");
            if (map2.containsKey(str)) {
                for (Entry entry2 : ((Map) map2.get(str)).entrySet()) {
                    stringBuilder.append(" ").append((String) entry2.getKey()).append("=\"").append((String) entry2.getValue()).append("\"");
                }
            }
            stringBuilder.append(">").append((String) entry.getValue()).append("</string>\n");
        }
        stringBuilder.append("</resources>\n");
        return stringBuilder.toString();
    }

    private static void deleteFolder(File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteFolder(file2);
                    } else if (!file2.delete()) {
                        throw new GradleException("Failed to delete: " + file2);
                    }
                }
            }
            if (!file.delete()) {
                throw new GradleException("Failed to delete: " + file);
            }
        }
    }

    private String getPackageName() {
        if (this.packageNameXOR1 == null) {
            return this.packageNameXOR2.asString();
        }
        return this.packageNameXOR1;
    }
}
