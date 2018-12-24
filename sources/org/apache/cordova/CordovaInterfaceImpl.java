package org.apache.cordova;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;

public class CordovaInterfaceImpl implements CordovaInterface {
    private static final String TAG = "CordovaInterfaceImpl";
    protected Activity activity;
    protected CordovaPlugin activityResultCallback;
    protected int activityResultRequestCode;
    protected boolean activityWasDestroyed;
    protected String initCallbackService;
    protected CallbackMap permissionResultCallbacks;
    protected PluginManager pluginManager;
    protected Bundle savedPluginState;
    protected ActivityResultHolder savedResult;
    protected ExecutorService threadPool;

    private static class ActivityResultHolder {
        private Intent intent;
        private int requestCode;
        private int resultCode;

        public ActivityResultHolder(int i, int i2, Intent intent) {
            this.requestCode = i;
            this.resultCode = i2;
            this.intent = intent;
        }
    }

    public CordovaInterfaceImpl(Activity activity) {
        this(activity, Executors.newCachedThreadPool());
    }

    public CordovaInterfaceImpl(Activity activity, ExecutorService executorService) {
        this.activityWasDestroyed = false;
        this.activity = activity;
        this.threadPool = executorService;
        this.permissionResultCallbacks = new CallbackMap();
    }

    public void startActivityForResult(CordovaPlugin cordovaPlugin, Intent intent, int i) {
        setActivityResultCallback(cordovaPlugin);
        try {
            this.activity.startActivityForResult(intent, i);
        } catch (RuntimeException e) {
            this.activityResultCallback = null;
            throw e;
        }
    }

    public void setActivityResultCallback(CordovaPlugin cordovaPlugin) {
        if (this.activityResultCallback != null) {
            this.activityResultCallback.onActivityResult(this.activityResultRequestCode, 0, null);
        }
        this.activityResultCallback = cordovaPlugin;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public Object onMessage(String str, Object obj) {
        if ("exit".equals(str)) {
            this.activity.finish();
        }
        return null;
    }

    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    public void onCordovaInit(PluginManager pluginManager) {
        this.pluginManager = pluginManager;
        if (this.savedResult != null) {
            onActivityResult(this.savedResult.requestCode, this.savedResult.resultCode, this.savedResult.intent);
        } else if (this.activityWasDestroyed) {
            this.activityWasDestroyed = false;
            if (pluginManager != null) {
                CoreAndroid coreAndroid = (CoreAndroid) pluginManager.getPlugin(CoreAndroid.PLUGIN_NAME);
                if (coreAndroid != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("action", "resume");
                    } catch (Throwable e) {
                        LOG.m1349e(TAG, "Failed to create event message", e);
                    }
                    coreAndroid.sendResumeEvent(new PluginResult(Status.OK, jSONObject));
                }
            }
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        CordovaPlugin cordovaPlugin = this.activityResultCallback;
        if (cordovaPlugin == null && this.initCallbackService != null) {
            this.savedResult = new ActivityResultHolder(i, i2, intent);
            if (this.pluginManager != null) {
                cordovaPlugin = this.pluginManager.getPlugin(this.initCallbackService);
                if (cordovaPlugin != null) {
                    cordovaPlugin.onRestoreStateForActivityResult(this.savedPluginState.getBundle(cordovaPlugin.getServiceName()), new ResumeCallback(cordovaPlugin.getServiceName(), this.pluginManager));
                }
            }
        }
        this.activityResultCallback = null;
        if (cordovaPlugin != null) {
            LOG.m1345d(TAG, "Sending activity result to plugin");
            this.initCallbackService = null;
            this.savedResult = null;
            cordovaPlugin.onActivityResult(i, i2, intent);
            return true;
        }
        LOG.m1357w(TAG, "Got an activity result, but no plugin was registered to receive it" + (this.savedResult != null ? " yet!" : "."));
        return false;
    }

    public void setActivityResultRequestCode(int i) {
        this.activityResultRequestCode = i;
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.activityResultCallback != null) {
            bundle.putString("callbackService", this.activityResultCallback.getServiceName());
        }
        if (this.pluginManager != null) {
            bundle.putBundle("plugin", this.pluginManager.onSaveInstanceState());
        }
    }

    public void restoreInstanceState(Bundle bundle) {
        this.initCallbackService = bundle.getString("callbackService");
        this.savedPluginState = bundle.getBundle("plugin");
        this.activityWasDestroyed = true;
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        Pair andRemoveCallback = this.permissionResultCallbacks.getAndRemoveCallback(i);
        if (andRemoveCallback != null) {
            ((CordovaPlugin) andRemoveCallback.first).onRequestPermissionResult(((Integer) andRemoveCallback.second).intValue(), strArr, iArr);
        }
    }

    public void requestPermission(CordovaPlugin cordovaPlugin, int i, String str) {
        requestPermissions(cordovaPlugin, i, new String[]{str});
    }

    public void requestPermissions(CordovaPlugin cordovaPlugin, int i, String[] strArr) {
        getActivity().requestPermissions(strArr, this.permissionResultCallbacks.registerCallback(cordovaPlugin, i));
    }

    public boolean hasPermission(String str) {
        if (VERSION.SDK_INT < 23 || this.activity.checkSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }
}
