package org.apache.cordova.engine;

import android.webkit.JavascriptInterface;
import org.apache.cordova.CordovaBridge;
import org.apache.cordova.ExposedJsApi;

class SystemExposedJsApi implements ExposedJsApi {
    private final CordovaBridge bridge;

    SystemExposedJsApi(CordovaBridge cordovaBridge) {
        this.bridge = cordovaBridge;
    }

    @JavascriptInterface
    public String exec(int i, String str, String str2, String str3, String str4) {
        return this.bridge.jsExec(i, str, str2, str3, str4);
    }

    @JavascriptInterface
    public void setNativeToJsBridgeMode(int i, int i2) {
        this.bridge.jsSetNativeToJsBridgeMode(i, i2);
    }

    @JavascriptInterface
    public String retrieveJsMessages(int i, boolean z) {
        return this.bridge.jsRetrieveJsMessages(i, z);
    }
}
