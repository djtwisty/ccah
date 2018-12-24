package org.apache.cordova;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import java.util.Collection;
import java.util.LinkedHashMap;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONException;

public class PluginManager {
    private static final int SLOW_EXEC_WARNING_THRESHOLD = (Debug.isDebuggerConnected() ? 60 : 16);
    private static String TAG = "PluginManager";
    private final CordovaWebView app;
    private final CordovaInterface ctx;
    private final LinkedHashMap<String, PluginEntry> entryMap = new LinkedHashMap();
    private boolean isInitialized;
    private CordovaPlugin permissionRequester;
    private final LinkedHashMap<String, CordovaPlugin> pluginMap = new LinkedHashMap();

    public PluginManager(CordovaWebView cordovaWebView, CordovaInterface cordovaInterface, Collection<PluginEntry> collection) {
        this.ctx = cordovaInterface;
        this.app = cordovaWebView;
        setPluginEntries(collection);
    }

    public Collection<PluginEntry> getPluginEntries() {
        return this.entryMap.values();
    }

    public void setPluginEntries(Collection<PluginEntry> collection) {
        if (this.isInitialized) {
            onPause(false);
            onDestroy();
            this.pluginMap.clear();
            this.entryMap.clear();
        }
        for (PluginEntry addService : collection) {
            addService(addService);
        }
        if (this.isInitialized) {
            startupPlugins();
        }
    }

    public void init() {
        LOG.m1345d(TAG, "init()");
        this.isInitialized = true;
        onPause(false);
        onDestroy();
        this.pluginMap.clear();
        startupPlugins();
    }

    private void startupPlugins() {
        for (PluginEntry pluginEntry : this.entryMap.values()) {
            if (pluginEntry.onload) {
                getPlugin(pluginEntry.service);
            } else {
                this.pluginMap.put(pluginEntry.service, null);
            }
        }
    }

    public void exec(String str, String str2, String str3, String str4) {
        CordovaPlugin plugin = getPlugin(str);
        if (plugin == null) {
            LOG.m1345d(TAG, "exec() call to unknown plugin: " + str);
            this.app.sendPluginResult(new PluginResult(Status.CLASS_NOT_FOUND_EXCEPTION), str3);
            return;
        }
        CallbackContext callbackContext = new CallbackContext(str3, this.app);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            boolean execute = plugin.execute(str2, str4, callbackContext);
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis > ((long) SLOW_EXEC_WARNING_THRESHOLD)) {
                LOG.m1357w(TAG, "THREAD WARNING: exec() call to " + str + "." + str2 + " blocked the main thread for " + currentTimeMillis + "ms. Plugin should use CordovaInterface.getThreadPool().");
            }
            if (!execute) {
                callbackContext.sendPluginResult(new PluginResult(Status.INVALID_ACTION));
            }
        } catch (JSONException e) {
            callbackContext.sendPluginResult(new PluginResult(Status.JSON_EXCEPTION));
        } catch (Throwable e2) {
            LOG.m1349e(TAG, "Uncaught exception from plugin", e2);
            callbackContext.error(e2.getMessage());
        }
    }

    public CordovaPlugin getPlugin(String str) {
        CordovaPlugin cordovaPlugin = (CordovaPlugin) this.pluginMap.get(str);
        if (cordovaPlugin != null) {
            return cordovaPlugin;
        }
        PluginEntry pluginEntry = (PluginEntry) this.entryMap.get(str);
        if (pluginEntry == null) {
            return null;
        }
        if (pluginEntry.plugin != null) {
            cordovaPlugin = pluginEntry.plugin;
        } else {
            cordovaPlugin = instantiatePlugin(pluginEntry.pluginClass);
        }
        cordovaPlugin.privateInitialize(str, this.ctx, this.app, this.app.getPreferences());
        this.pluginMap.put(str, cordovaPlugin);
        return cordovaPlugin;
    }

    public void addService(String str, String str2) {
        addService(new PluginEntry(str, str2, false));
    }

    public void addService(PluginEntry pluginEntry) {
        this.entryMap.put(pluginEntry.service, pluginEntry);
        if (pluginEntry.plugin != null) {
            pluginEntry.plugin.privateInitialize(pluginEntry.service, this.ctx, this.app, this.app.getPreferences());
            this.pluginMap.put(pluginEntry.service, pluginEntry.plugin);
        }
    }

    public void onPause(boolean z) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onPause(z);
            }
        }
    }

    public boolean onReceivedHttpAuthRequest(CordovaWebView cordovaWebView, ICordovaHttpAuthHandler iCordovaHttpAuthHandler, String str, String str2) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null && cordovaPlugin.onReceivedHttpAuthRequest(this.app, iCordovaHttpAuthHandler, str, str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean onReceivedClientCertRequest(CordovaWebView cordovaWebView, ICordovaClientCertRequest iCordovaClientCertRequest) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null && cordovaPlugin.onReceivedClientCertRequest(this.app, iCordovaClientCertRequest)) {
                return true;
            }
        }
        return false;
    }

    public void onResume(boolean z) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onResume(z);
            }
        }
    }

    public void onStart() {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onStart();
            }
        }
    }

    public void onStop() {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onStop();
            }
        }
    }

    public void onDestroy() {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onDestroy();
            }
        }
    }

    public Object postMessage(String str, Object obj) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                Object onMessage = cordovaPlugin.onMessage(str, obj);
                if (onMessage != null) {
                    return onMessage;
                }
            }
        }
        return this.ctx.onMessage(str, obj);
    }

    public void onNewIntent(Intent intent) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onNewIntent(intent);
            }
        }
    }

    public boolean shouldAllowRequest(String str) {
        for (PluginEntry pluginEntry : this.entryMap.values()) {
            CordovaPlugin cordovaPlugin = (CordovaPlugin) this.pluginMap.get(pluginEntry.service);
            if (cordovaPlugin != null) {
                Boolean shouldAllowRequest = cordovaPlugin.shouldAllowRequest(str);
                if (shouldAllowRequest != null) {
                    return shouldAllowRequest.booleanValue();
                }
            }
        }
        if (str.startsWith("blob:") || str.startsWith("data:") || str.startsWith("about:blank") || str.startsWith("https://ssl.gstatic.com/accessibility/javascript/android/")) {
            return true;
        }
        if (!str.startsWith("file://")) {
            return false;
        }
        return !str.contains("/app_webview/");
    }

    public boolean shouldAllowNavigation(String str) {
        for (PluginEntry pluginEntry : this.entryMap.values()) {
            CordovaPlugin cordovaPlugin = (CordovaPlugin) this.pluginMap.get(pluginEntry.service);
            if (cordovaPlugin != null) {
                Boolean shouldAllowNavigation = cordovaPlugin.shouldAllowNavigation(str);
                if (shouldAllowNavigation != null) {
                    return shouldAllowNavigation.booleanValue();
                }
            }
        }
        return str.startsWith("file://") || str.startsWith("about:blank");
    }

    public boolean shouldAllowBridgeAccess(String str) {
        for (PluginEntry pluginEntry : this.entryMap.values()) {
            CordovaPlugin cordovaPlugin = (CordovaPlugin) this.pluginMap.get(pluginEntry.service);
            if (cordovaPlugin != null) {
                Boolean shouldAllowBridgeAccess = cordovaPlugin.shouldAllowBridgeAccess(str);
                if (shouldAllowBridgeAccess != null) {
                    return shouldAllowBridgeAccess.booleanValue();
                }
            }
        }
        return str.startsWith("file://");
    }

    public Boolean shouldOpenExternalUrl(String str) {
        for (PluginEntry pluginEntry : this.entryMap.values()) {
            CordovaPlugin cordovaPlugin = (CordovaPlugin) this.pluginMap.get(pluginEntry.service);
            if (cordovaPlugin != null) {
                Boolean shouldOpenExternalUrl = cordovaPlugin.shouldOpenExternalUrl(str);
                if (shouldOpenExternalUrl != null) {
                    return shouldOpenExternalUrl;
                }
            }
        }
        return Boolean.valueOf(false);
    }

    public boolean onOverrideUrlLoading(String str) {
        for (PluginEntry pluginEntry : this.entryMap.values()) {
            CordovaPlugin cordovaPlugin = (CordovaPlugin) this.pluginMap.get(pluginEntry.service);
            if (cordovaPlugin != null && cordovaPlugin.onOverrideUrlLoading(str)) {
                return true;
            }
        }
        return false;
    }

    public void onReset() {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onReset();
            }
        }
    }

    Uri remapUri(Uri uri) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                Uri remapUri = cordovaPlugin.remapUri(uri);
                if (remapUri != null) {
                    return remapUri;
                }
            }
        }
        return null;
    }

    private CordovaPlugin instantiatePlugin(String str) {
        Class cls;
        CordovaPlugin cordovaPlugin;
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    cls = Class.forName(str);
                    if (((cls == null ? 1 : 0) & CordovaPlugin.class.isAssignableFrom(cls)) == 0) {
                        cordovaPlugin = (CordovaPlugin) cls.newInstance();
                    } else {
                        cordovaPlugin = null;
                    }
                    return cordovaPlugin;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error adding plugin " + str + ".");
                return null;
            }
        }
        cls = null;
        if (cls == null) {
        }
        if (((cls == null ? 1 : 0) & CordovaPlugin.class.isAssignableFrom(cls)) == 0) {
            cordovaPlugin = null;
        } else {
            cordovaPlugin = (CordovaPlugin) cls.newInstance();
        }
        return cordovaPlugin;
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                cordovaPlugin.onConfigurationChanged(configuration);
            }
        }
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        for (CordovaPlugin cordovaPlugin : this.pluginMap.values()) {
            if (cordovaPlugin != null) {
                Bundle onSaveInstanceState = cordovaPlugin.onSaveInstanceState();
                if (onSaveInstanceState != null) {
                    bundle.putBundle(cordovaPlugin.getServiceName(), onSaveInstanceState);
                }
            }
        }
        return bundle;
    }
}
