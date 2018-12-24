package org.apache.cordova;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaActivity extends Activity {
    private static int ACTIVITY_EXITING = 2;
    private static int ACTIVITY_RUNNING = 1;
    private static int ACTIVITY_STARTING = 0;
    public static String TAG = "CordovaActivity";
    protected CordovaWebView appView;
    protected CordovaInterfaceImpl cordovaInterface;
    protected boolean immersiveMode;
    protected boolean keepRunning = true;
    protected String launchUrl;
    protected ArrayList<PluginEntry> pluginEntries;
    protected CordovaPreferences preferences;

    public void onCreate(Bundle bundle) {
        loadConfig();
        LOG.setLogLevel(this.preferences.getString("loglevel", "ERROR"));
        LOG.m1351i(TAG, "Apache Cordova native platform version 6.2.3 is starting");
        LOG.m1345d(TAG, "CordovaActivity.onCreate()");
        if (!this.preferences.getBoolean("ShowTitle", false)) {
            getWindow().requestFeature(1);
        }
        if (this.preferences.getBoolean("SetFullscreen", false)) {
            LOG.m1345d(TAG, "The SetFullscreen configuration is deprecated in favor of Fullscreen, and will be removed in a future version.");
            this.preferences.set("Fullscreen", true);
        }
        if (!this.preferences.getBoolean("Fullscreen", false)) {
            getWindow().setFlags(2048, 2048);
        } else if (VERSION.SDK_INT < 19 || this.preferences.getBoolean("FullscreenNotImmersive", false)) {
            getWindow().setFlags(1024, 1024);
        } else {
            this.immersiveMode = true;
        }
        super.onCreate(bundle);
        this.cordovaInterface = makeCordovaInterface();
        if (bundle != null) {
            this.cordovaInterface.restoreInstanceState(bundle);
        }
    }

    protected void init() {
        this.appView = makeWebView();
        createViews();
        if (!this.appView.isInitialized()) {
            this.appView.init(this.cordovaInterface, this.pluginEntries, this.preferences);
        }
        this.cordovaInterface.onCordovaInit(this.appView.getPluginManager());
        if ("media".equals(this.preferences.getString("DefaultVolumeStream", "").toLowerCase(Locale.ENGLISH))) {
            setVolumeControlStream(3);
        }
    }

    protected void loadConfig() {
        ConfigXmlParser configXmlParser = new ConfigXmlParser();
        configXmlParser.parse((Context) this);
        this.preferences = configXmlParser.getPreferences();
        this.preferences.setPreferencesBundle(getIntent().getExtras());
        this.launchUrl = configXmlParser.getLaunchUrl();
        this.pluginEntries = configXmlParser.getPluginEntries();
        Config.parser = configXmlParser;
    }

    protected void createViews() {
        this.appView.getView().setId(100);
        this.appView.getView().setLayoutParams(new LayoutParams(-1, -1));
        setContentView(this.appView.getView());
        if (this.preferences.contains("BackgroundColor")) {
            try {
                this.appView.getView().setBackgroundColor(this.preferences.getInteger("BackgroundColor", -16777216));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        this.appView.getView().requestFocusFromTouch();
    }

    protected CordovaWebView makeWebView() {
        return new CordovaWebViewImpl(makeWebViewEngine());
    }

    protected CordovaWebViewEngine makeWebViewEngine() {
        return CordovaWebViewImpl.createEngine(this, this.preferences);
    }

    protected CordovaInterfaceImpl makeCordovaInterface() {
        return new CordovaInterfaceImpl(this) {
            public Object onMessage(String str, Object obj) {
                return CordovaActivity.this.onMessage(str, obj);
            }
        };
    }

    public void loadUrl(String str) {
        if (this.appView == null) {
            init();
        }
        this.keepRunning = this.preferences.getBoolean("KeepRunning", true);
        this.appView.loadUrlIntoView(str, true);
    }

    protected void onPause() {
        super.onPause();
        LOG.m1345d(TAG, "Paused the activity.");
        if (this.appView != null) {
            boolean z = this.keepRunning || this.cordovaInterface.activityResultCallback != null;
            this.appView.handlePause(z);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.appView != null) {
            this.appView.onNewIntent(intent);
        }
    }

    protected void onResume() {
        super.onResume();
        LOG.m1345d(TAG, "Resumed the activity.");
        if (this.appView != null) {
            getWindow().getDecorView().requestFocus();
            this.appView.handleResume(this.keepRunning);
        }
    }

    protected void onStop() {
        super.onStop();
        LOG.m1345d(TAG, "Stopped the activity.");
        if (this.appView != null) {
            this.appView.handleStop();
        }
    }

    protected void onStart() {
        super.onStart();
        LOG.m1345d(TAG, "Started the activity.");
        if (this.appView != null) {
            this.appView.handleStart();
        }
    }

    public void onDestroy() {
        LOG.m1345d(TAG, "CordovaActivity.onDestroy()");
        super.onDestroy();
        if (this.appView != null) {
            this.appView.handleDestroy();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.immersiveMode) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    @SuppressLint({"NewApi"})
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.cordovaInterface.setActivityResultRequestCode(i);
        super.startActivityForResult(intent, i, bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        LOG.m1345d(TAG, "Incoming Result. Request code = " + i);
        super.onActivityResult(i, i2, intent);
        this.cordovaInterface.onActivityResult(i, i2, intent);
    }

    public void onReceivedError(int i, String str, String str2) {
        final String string = this.preferences.getString("errorUrl", null);
        if (string == null || str2.equals(string) || this.appView == null) {
            final boolean z = i != -2;
            final CordovaActivity cordovaActivity = this;
            final String str3 = str;
            final String str4 = str2;
            runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        cordovaActivity.appView.getView().setVisibility(8);
                        cordovaActivity.displayError("Application Error", str3 + " (" + str4 + ")", "OK", z);
                    }
                }
            });
            return;
        }
        runOnUiThread(new Runnable() {
            public void run() {
                this.appView.showWebPage(string, false, true, null);
            }
        });
    }

    public void displayError(String str, String str2, String str3, boolean z) {
        final CordovaActivity cordovaActivity = this;
        final String str4 = str2;
        final String str5 = str;
        final String str6 = str3;
        final boolean z2 = z;
        runOnUiThread(new Runnable() {

            /* renamed from: org.apache.cordova.CordovaActivity$4$1 */
            class C05031 implements OnClickListener {
                C05031() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (z2) {
                        CordovaActivity.this.finish();
                    }
                }
            }

            public void run() {
                try {
                    Builder builder = new Builder(cordovaActivity);
                    builder.setMessage(str4);
                    builder.setTitle(str5);
                    builder.setCancelable(false);
                    builder.setPositiveButton(str6, new C05031());
                    builder.create();
                    builder.show();
                } catch (Exception e) {
                    CordovaActivity.this.finish();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.appView != null) {
            this.appView.getPluginManager().postMessage("onCreateOptionsMenu", menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.appView != null) {
            this.appView.getPluginManager().postMessage("onPrepareOptionsMenu", menu);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.appView != null) {
            this.appView.getPluginManager().postMessage("onOptionsItemSelected", menuItem);
        }
        return true;
    }

    public Object onMessage(String str, Object obj) {
        if ("onReceivedError".equals(str)) {
            JSONObject jSONObject = (JSONObject) obj;
            try {
                onReceivedError(jSONObject.getInt("errorCode"), jSONObject.getString("description"), jSONObject.getString(ImagesContract.URL));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if ("exit".equals(str)) {
            finish();
        }
        return null;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.cordovaInterface.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.appView != null) {
            PluginManager pluginManager = this.appView.getPluginManager();
            if (pluginManager != null) {
                pluginManager.onConfigurationChanged(configuration);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            this.cordovaInterface.onRequestPermissionResult(i, strArr, iArr);
        } catch (JSONException e) {
            LOG.m1345d(TAG, "JSONException: Parameters fed into the method are not valid");
            e.printStackTrace();
        }
    }
}
