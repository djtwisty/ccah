package org.apache.cordova;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import java.io.FileNotFoundException;
import org.apache.cordova.CordovaResourceApi.OpenForReadResult;
import org.json.JSONArray;

public class CordovaPlugin {
    static final /* synthetic */ boolean $assertionsDisabled = (!CordovaPlugin.class.desiredAssertionStatus());
    public CordovaInterface cordova;
    protected CordovaPreferences preferences;
    private String serviceName;
    public CordovaWebView webView;

    public final void privateInitialize(String str, CordovaInterface cordovaInterface, CordovaWebView cordovaWebView, CordovaPreferences cordovaPreferences) {
        if ($assertionsDisabled || this.cordova == null) {
            this.serviceName = str;
            this.cordova = cordovaInterface;
            this.webView = cordovaWebView;
            this.preferences = cordovaPreferences;
            initialize(cordovaInterface, cordovaWebView);
            pluginInitialize();
            return;
        }
        throw new AssertionError();
    }

    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
    }

    protected void pluginInitialize() {
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public boolean execute(String str, String str2, CallbackContext callbackContext) {
        return execute(str, new JSONArray(str2), callbackContext);
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        return execute(str, new CordovaArgs(jSONArray), callbackContext);
    }

    public boolean execute(String str, CordovaArgs cordovaArgs, CallbackContext callbackContext) {
        return false;
    }

    public void onPause(boolean z) {
    }

    public void onResume(boolean z) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onDestroy() {
    }

    public Bundle onSaveInstanceState() {
        return null;
    }

    public void onRestoreStateForActivityResult(Bundle bundle, CallbackContext callbackContext) {
    }

    public Object onMessage(String str, Object obj) {
        return null;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public Boolean shouldAllowRequest(String str) {
        return null;
    }

    public Boolean shouldAllowNavigation(String str) {
        return null;
    }

    public Boolean shouldAllowBridgeAccess(String str) {
        return shouldAllowNavigation(str);
    }

    public Boolean shouldOpenExternalUrl(String str) {
        return null;
    }

    public boolean onOverrideUrlLoading(String str) {
        return false;
    }

    public Uri remapUri(Uri uri) {
        return null;
    }

    public OpenForReadResult handleOpenForRead(Uri uri) {
        throw new FileNotFoundException("Plugin can't handle uri: " + uri);
    }

    protected Uri toPluginUri(Uri uri) {
        return new Builder().scheme(CordovaResourceApi.PLUGIN_URI_SCHEME).authority(this.serviceName).appendQueryParameter("origUri", uri.toString()).build();
    }

    protected Uri fromPluginUri(Uri uri) {
        return Uri.parse(uri.getQueryParameter("origUri"));
    }

    public void onReset() {
    }

    public boolean onReceivedHttpAuthRequest(CordovaWebView cordovaWebView, ICordovaHttpAuthHandler iCordovaHttpAuthHandler, String str, String str2) {
        return false;
    }

    public boolean onReceivedClientCertRequest(CordovaWebView cordovaWebView, ICordovaClientCertRequest iCordovaClientCertRequest) {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void requestPermissions(int i) {
    }

    public boolean hasPermisssion() {
        return true;
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
    }
}
