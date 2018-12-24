package org.apache.cordova.firebase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.p012a.ah;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import me.leolin.shortcutbadger.ShortcutBadger;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebasePlugin extends CordovaPlugin {
    protected static final String KEY = "badge";
    private static boolean inBackground = true;
    private static CallbackContext notificationCallbackContext;
    private static ArrayList<Bundle> notificationStack = null;
    private static CallbackContext tokenRefreshCallbackContext;
    private final String TAG = "FirebasePlugin";
    private OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAnalytics mFirebaseAnalytics;

    protected void pluginInitialize() {
        final Context applicationContext = this.cordova.getActivity().getApplicationContext();
        final Bundle extras = this.cordova.getActivity().getIntent().getExtras();
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                Log.d("FirebasePlugin", "Starting Firebase plugin");
                FirebasePlugin.this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(applicationContext);
                FirebasePlugin.this.mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
                if (extras != null && extras.size() > 1) {
                    if (FirebasePlugin.notificationStack == null) {
                        FirebasePlugin.notificationStack = new ArrayList();
                    }
                    if (extras.containsKey("google.message_id")) {
                        extras.putBoolean("tap", true);
                        FirebasePlugin.notificationStack.add(extras);
                    }
                }
            }
        });
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        if (str.equals("getInstanceId")) {
            getInstanceId(callbackContext);
            return true;
        } else if (str.equals("getToken")) {
            getToken(callbackContext);
            return true;
        } else if (str.equals("hasPermission")) {
            hasPermission(callbackContext);
            return true;
        } else if (str.equals("setBadgeNumber")) {
            setBadgeNumber(callbackContext, jSONArray.getInt(0));
            return true;
        } else if (str.equals("getBadgeNumber")) {
            getBadgeNumber(callbackContext);
            return true;
        } else if (str.equals("subscribe")) {
            subscribe(callbackContext, jSONArray.getString(0));
            return true;
        } else if (str.equals("unsubscribe")) {
            unsubscribe(callbackContext, jSONArray.getString(0));
            return true;
        } else if (str.equals("unregister")) {
            unregister(callbackContext);
            return true;
        } else if (str.equals("onNotificationOpen")) {
            onNotificationOpen(callbackContext);
            return true;
        } else if (str.equals("onTokenRefresh")) {
            onTokenRefresh(callbackContext);
            return true;
        } else if (str.equals("logEvent")) {
            logEvent(callbackContext, jSONArray.getString(0), jSONArray.getJSONObject(1));
            return true;
        } else if (str.equals("logError")) {
            logError(callbackContext, jSONArray.getString(0));
            return true;
        } else if (str.equals("setScreenName")) {
            setScreenName(callbackContext, jSONArray.getString(0));
            return true;
        } else if (str.equals("setUserId")) {
            setUserId(callbackContext, jSONArray.getString(0));
            return true;
        } else if (str.equals("setUserProperty")) {
            setUserProperty(callbackContext, jSONArray.getString(0), jSONArray.getString(1));
            return true;
        } else if (str.equals("activateFetched")) {
            activateFetched(callbackContext);
            return true;
        } else if (str.equals("fetch")) {
            if (jSONArray.length() > 0) {
                fetch(callbackContext, jSONArray.getLong(0));
                return true;
            }
            fetch(callbackContext);
            return true;
        } else if (str.equals("getByteArray")) {
            if (jSONArray.length() > 1) {
                getByteArray(callbackContext, jSONArray.getString(0), jSONArray.getString(1));
                return true;
            }
            getByteArray(callbackContext, jSONArray.getString(0), null);
            return true;
        } else if (str.equals("getValue")) {
            if (jSONArray.length() > 1) {
                getValue(callbackContext, jSONArray.getString(0), jSONArray.getString(1));
                return true;
            }
            getValue(callbackContext, jSONArray.getString(0), null);
            return true;
        } else if (str.equals("getInfo")) {
            getInfo(callbackContext);
            return true;
        } else if (str.equals("setConfigSettings")) {
            setConfigSettings(callbackContext, jSONArray.getJSONObject(0));
            return true;
        } else if (str.equals("setDefaults")) {
            if (jSONArray.length() > 1) {
                setDefaults(callbackContext, jSONArray.getJSONObject(0), jSONArray.getString(1));
                return true;
            }
            setDefaults(callbackContext, jSONArray.getJSONObject(0), null);
            return true;
        } else if (!str.equals("verifyPhoneNumber")) {
            return false;
        } else {
            verifyPhoneNumber(callbackContext, jSONArray.getString(0), jSONArray.getInt(1));
            return true;
        }
    }

    public void onPause(boolean z) {
        inBackground = true;
    }

    public void onResume(boolean z) {
        inBackground = false;
    }

    public void onReset() {
        notificationCallbackContext = null;
        tokenRefreshCallbackContext = null;
    }

    private void onNotificationOpen(CallbackContext callbackContext) {
        notificationCallbackContext = callbackContext;
        if (notificationStack != null) {
            Iterator it = notificationStack.iterator();
            while (it.hasNext()) {
                sendNotification((Bundle) it.next());
            }
            notificationStack.clear();
        }
    }

    private void onTokenRefresh(final CallbackContext callbackContext) {
        tokenRefreshCallbackContext = callbackContext;
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    String token = FirebaseInstanceId.getInstance().getToken();
                    if (token != null) {
                        FirebasePlugin.sendToken(token);
                    }
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    public static void sendNotification(Bundle bundle) {
        if (hasNotificationsCallback()) {
            CallbackContext callbackContext = notificationCallbackContext;
            if (callbackContext != null && bundle != null) {
                JSONObject jSONObject = new JSONObject();
                for (String str : bundle.keySet()) {
                    try {
                        jSONObject.put(str, bundle.get(str));
                    } catch (JSONException e) {
                        callbackContext.error(e.getMessage());
                        return;
                    }
                }
                PluginResult pluginResult = new PluginResult(Status.OK, jSONObject);
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
                return;
            }
            return;
        }
        if (notificationStack == null) {
            notificationStack = new ArrayList();
        }
        notificationStack.add(bundle);
    }

    public static void sendToken(String str) {
        if (tokenRefreshCallbackContext != null) {
            CallbackContext callbackContext = tokenRefreshCallbackContext;
            if (callbackContext != null && str != null) {
                PluginResult pluginResult = new PluginResult(Status.OK, str);
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
            }
        }
    }

    public static boolean inBackground() {
        return inBackground;
    }

    public static boolean hasNotificationsCallback() {
        return notificationCallbackContext != null;
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("google.message_id")) {
            extras.putBoolean("tap", true);
            sendNotification(extras);
        }
    }

    private void getInstanceId(final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    callbackContext.success(FirebaseInstanceId.getInstance().getToken());
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void getToken(final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    callbackContext.success(FirebaseInstanceId.getInstance().getToken());
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void hasPermission(final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    boolean a = ah.m175a(FirebasePlugin.this.cordova.getActivity()).m176a();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("isEnabled", a);
                    callbackContext.success(jSONObject);
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void setBadgeNumber(final CallbackContext callbackContext, final int i) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Context activity = FirebasePlugin.this.cordova.getActivity();
                    Editor edit = activity.getSharedPreferences(FirebasePlugin.KEY, 0).edit();
                    edit.putInt(FirebasePlugin.KEY, i);
                    edit.apply();
                    ShortcutBadger.m1323a(activity, i);
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void getBadgeNumber(final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    callbackContext.success(FirebasePlugin.this.cordova.getActivity().getSharedPreferences(FirebasePlugin.KEY, 0).getInt(FirebasePlugin.KEY, 0));
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void subscribe(final CallbackContext callbackContext, final String str) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebaseMessaging.getInstance().subscribeToTopic(str);
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void unsubscribe(final CallbackContext callbackContext, final String str) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebaseMessaging.getInstance().unsubscribeFromTopic(str);
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void unregister(final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebaseInstanceId.getInstance().deleteInstanceId();
                    String token = FirebaseInstanceId.getInstance().getToken();
                    if (token != null) {
                        FirebasePlugin.sendToken(token);
                    }
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void logEvent(final CallbackContext callbackContext, final String str, JSONObject jSONObject) {
        final Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            Object obj = jSONObject.get(str2);
            if ((obj instanceof Integer) || (obj instanceof Double)) {
                bundle.putFloat(str2, ((Number) obj).floatValue());
            } else {
                bundle.putString(str2, obj.toString());
            }
        }
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebasePlugin.this.mFirebaseAnalytics.logEvent(str, bundle);
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void logError(final CallbackContext callbackContext, final String str) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebaseCrash.report(new Exception(str));
                    callbackContext.success(1);
                } catch (Exception e) {
                    FirebaseCrash.log(e.getMessage());
                    e.printStackTrace();
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void setScreenName(final CallbackContext callbackContext, final String str) {
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                try {
                    FirebasePlugin.this.mFirebaseAnalytics.setCurrentScreen(FirebasePlugin.this.cordova.getActivity(), str, null);
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void setUserId(final CallbackContext callbackContext, final String str) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebasePlugin.this.mFirebaseAnalytics.setUserId(str);
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void setUserProperty(final CallbackContext callbackContext, final String str, final String str2) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebasePlugin.this.mFirebaseAnalytics.setUserProperty(str, str2);
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void activateFetched(final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    callbackContext.success(String.valueOf(FirebaseRemoteConfig.getInstance().activateFetched()));
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void fetch(CallbackContext callbackContext) {
        fetch(callbackContext, FirebaseRemoteConfig.getInstance().fetch());
    }

    private void fetch(CallbackContext callbackContext, long j) {
        fetch(callbackContext, FirebaseRemoteConfig.getInstance().fetch(j));
    }

    private void fetch(final CallbackContext callbackContext, final Task<Void> task) {
        this.cordova.getThreadPool().execute(new Runnable() {

            /* renamed from: org.apache.cordova.firebase.FirebasePlugin$17$1 */
            class C05531 implements OnFailureListener {
                C05531() {
                }

                public void onFailure(Exception exception) {
                    callbackContext.error(exception.getMessage());
                }
            }

            /* renamed from: org.apache.cordova.firebase.FirebasePlugin$17$2 */
            class C05542 implements OnSuccessListener<Void> {
                C05542() {
                }

                public void onSuccess(Void voidR) {
                    callbackContext.success();
                }
            }

            public void run() {
                try {
                    task.addOnSuccessListener(new C05542()).addOnFailureListener(new C05531());
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void getByteArray(final CallbackContext callbackContext, final String str, final String str2) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Object byteArray;
                    if (str2 == null) {
                        byteArray = FirebaseRemoteConfig.getInstance().getByteArray(str);
                    } else {
                        byteArray = FirebaseRemoteConfig.getInstance().getByteArray(str, str2);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("base64", Base64.encodeToString(byteArray, 0));
                    jSONObject.put("array", new JSONArray(byteArray));
                    callbackContext.success(jSONObject);
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void getValue(final CallbackContext callbackContext, final String str, final String str2) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebaseRemoteConfigValue value;
                    if (str2 == null) {
                        value = FirebaseRemoteConfig.getInstance().getValue(str);
                    } else {
                        value = FirebaseRemoteConfig.getInstance().getValue(str, str2);
                    }
                    callbackContext.success(value.asString());
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void getInfo(final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebaseRemoteConfigInfo info = FirebaseRemoteConfig.getInstance().getInfo();
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("developerModeEnabled", info.getConfigSettings().isDeveloperModeEnabled());
                    jSONObject.put("configSettings", jSONObject2);
                    jSONObject.put("fetchTimeMillis", info.getFetchTimeMillis());
                    jSONObject.put("lastFetchStatus", info.getLastFetchStatus());
                    callbackContext.success(jSONObject);
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void setConfigSettings(final CallbackContext callbackContext, final JSONObject jSONObject) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    FirebaseRemoteConfig.getInstance().setConfigSettings(new Builder().setDeveloperModeEnabled(jSONObject.getBoolean("developerModeEnabled")).build());
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void setDefaults(final CallbackContext callbackContext, final JSONObject jSONObject, final String str) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    if (str == null) {
                        FirebaseRemoteConfig.getInstance().setDefaults(FirebasePlugin.defaultsToMap(jSONObject));
                    } else {
                        FirebaseRemoteConfig.getInstance().setDefaults(FirebasePlugin.defaultsToMap(jSONObject), str);
                    }
                    callbackContext.success();
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private static Map<String, Object> defaultsToMap(JSONObject jSONObject) {
        Map<String, Object> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof Integer) {
                obj = new Long((long) ((Integer) obj).intValue());
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray.length() == 1 && (jSONArray.get(0) instanceof String)) {
                    obj = Base64.decode(jSONArray.getString(0), 0);
                } else {
                    Object obj2 = new byte[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        obj2[i] = (byte) jSONArray.getInt(i);
                    }
                    obj = obj2;
                }
            }
            hashMap.put(str, obj);
        }
        return hashMap;
    }

    public void verifyPhoneNumber(final CallbackContext callbackContext, final String str, final int i) {
        this.cordova.getThreadPool().execute(new Runnable() {

            /* renamed from: org.apache.cordova.firebase.FirebasePlugin$23$1 */
            class C05561 extends OnVerificationStateChangedCallbacks {
                C05561() {
                }

                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    Log.d("FirebasePlugin", "success: verifyPhoneNumber.onVerificationCompleted - doing nothing. sign in with token from onCodeSent");
                }

                public void onVerificationFailed(FirebaseException firebaseException) {
                    Log.w("FirebasePlugin", "failed: verifyPhoneNumber.onVerificationFailed ", firebaseException);
                    String str = ("unknown error verifying number" + " Error instance: " + firebaseException.getClass().getName()) + " Error code: " + ((FirebaseAuthException) firebaseException).getErrorCode().toString();
                    if (firebaseException instanceof FirebaseAuthInvalidCredentialsException) {
                        str = "Invalid phone number";
                    } else if (firebaseException instanceof FirebaseTooManyRequestsException) {
                        str = "The SMS quota for the project has been exceeded";
                    }
                    callbackContext.error(str);
                }

                public void onCodeSent(String str, ForceResendingToken forceResendingToken) {
                    Log.d("FirebasePlugin", "success: verifyPhoneNumber.onCodeSent");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("verificationId", str);
                        PluginResult pluginResult = new PluginResult(Status.OK, jSONObject);
                        pluginResult.setKeepCallback(true);
                        callbackContext.sendPluginResult(pluginResult);
                    } catch (JSONException e) {
                        callbackContext.error(e.getMessage());
                    }
                }
            }

            public void run() {
                try {
                    FirebasePlugin.this.mCallbacks = new C05561();
                    PhoneAuthProvider.getInstance().verifyPhoneNumber(str, (long) i, TimeUnit.SECONDS, FirebasePlugin.this.cordova.getActivity(), FirebasePlugin.this.mCallbacks);
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }
}
