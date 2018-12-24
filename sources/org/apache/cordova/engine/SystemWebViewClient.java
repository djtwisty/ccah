package org.apache.cordova.engine;

import android.annotation.TargetApi;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import org.apache.cordova.AuthenticationToken;
import org.apache.cordova.CordovaClientCertRequest;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaResourceApi.OpenForReadResult;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.apache.http.protocol.HTTP;

public class SystemWebViewClient extends WebViewClient {
    private static final String TAG = "SystemWebViewClient";
    private Hashtable<String, AuthenticationToken> authenticationTokens = new Hashtable();
    private boolean doClearHistory = false;
    boolean isCurrentlyLoading;
    protected final SystemWebViewEngine parentEngine;

    public SystemWebViewClient(SystemWebViewEngine systemWebViewEngine) {
        this.parentEngine = systemWebViewEngine;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.parentEngine.client.onNavigationAttempt(str);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AuthenticationToken authenticationToken = getAuthenticationToken(str, str2);
        if (authenticationToken != null) {
            httpAuthHandler.proceed(authenticationToken.getUserName(), authenticationToken.getPassword());
            return;
        }
        PluginManager pluginManager = this.parentEngine.pluginManager;
        if (pluginManager == null || !pluginManager.onReceivedHttpAuthRequest(null, new CordovaHttpAuthHandler(httpAuthHandler), str, str2)) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            this.parentEngine.client.clearLoadTimeoutTimer();
        }
    }

    @TargetApi(21)
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        PluginManager pluginManager = this.parentEngine.pluginManager;
        if (pluginManager == null || !pluginManager.onReceivedClientCertRequest(null, new CordovaClientCertRequest(clientCertRequest))) {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            this.parentEngine.client.clearLoadTimeoutTimer();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.isCurrentlyLoading = true;
        this.parentEngine.bridge.reset();
        this.parentEngine.client.onPageStarted(str);
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.isCurrentlyLoading || str.startsWith("about:")) {
            this.isCurrentlyLoading = false;
            if (this.doClearHistory) {
                webView.clearHistory();
                this.doClearHistory = false;
            }
            this.parentEngine.client.onPageFinishedLoading(str);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.isCurrentlyLoading) {
            LOG.m1347d(TAG, "CordovaWebViewClient.onReceivedError: Error code=%s Description=%s URL=%s", Integer.valueOf(i), str, str2);
            if (i == -10) {
                this.parentEngine.client.clearLoadTimeoutTimer();
                if (webView.canGoBack()) {
                    webView.goBack();
                    return;
                }
                super.onReceivedError(webView, i, str, str2);
            }
            this.parentEngine.client.onReceivedError(i, str, str2);
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            if ((this.parentEngine.cordova.getActivity().getPackageManager().getApplicationInfo(this.parentEngine.cordova.getActivity().getPackageName(), 128).flags & 2) != 0) {
                sslErrorHandler.proceed();
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        } catch (NameNotFoundException e) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void setAuthenticationToken(AuthenticationToken authenticationToken, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        this.authenticationTokens.put(str.concat(str2), authenticationToken);
    }

    public AuthenticationToken removeAuthenticationToken(String str, String str2) {
        return (AuthenticationToken) this.authenticationTokens.remove(str.concat(str2));
    }

    public AuthenticationToken getAuthenticationToken(String str, String str2) {
        AuthenticationToken authenticationToken = (AuthenticationToken) this.authenticationTokens.get(str.concat(str2));
        if (authenticationToken != null) {
            return authenticationToken;
        }
        authenticationToken = (AuthenticationToken) this.authenticationTokens.get(str);
        if (authenticationToken == null) {
            authenticationToken = (AuthenticationToken) this.authenticationTokens.get(str2);
        }
        if (authenticationToken == null) {
            return (AuthenticationToken) this.authenticationTokens.get("");
        }
        return authenticationToken;
    }

    public void clearAuthenticationTokens() {
        this.authenticationTokens.clear();
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (this.parentEngine.pluginManager.shouldAllowRequest(str)) {
                CordovaResourceApi cordovaResourceApi = this.parentEngine.resourceApi;
                Uri parse = Uri.parse(str);
                Uri remapUri = cordovaResourceApi.remapUri(parse);
                if (parse.equals(remapUri) && !needsSpecialsInAssetUrlFix(parse) && !needsKitKatContentUrlFix(parse)) {
                    return null;
                }
                OpenForReadResult openForRead = cordovaResourceApi.openForRead(remapUri, true);
                return new WebResourceResponse(openForRead.mimeType, HTTP.UTF_8, openForRead.inputStream);
            }
            LOG.m1357w(TAG, "URL blocked by whitelist: " + str);
            return new WebResourceResponse("text/plain", HTTP.UTF_8, null);
        } catch (Throwable e) {
            if (!(e instanceof FileNotFoundException)) {
                LOG.m1349e(TAG, "Error occurred while loading a file (returning a 404).", e);
            }
            return new WebResourceResponse("text/plain", HTTP.UTF_8, null);
        }
    }

    private static boolean needsKitKatContentUrlFix(Uri uri) {
        return VERSION.SDK_INT >= 19 && Param.CONTENT.equals(uri.getScheme());
    }

    private static boolean needsSpecialsInAssetUrlFix(Uri uri) {
        if (CordovaResourceApi.getUriType(uri) != 1) {
            return false;
        }
        if (uri.getQuery() != null || uri.getFragment() != null) {
            return true;
        }
        if (!uri.toString().contains("%")) {
            return false;
        }
        switch (VERSION.SDK_INT) {
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }
}
