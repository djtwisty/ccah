package org.apache.cordova.engine;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.Arrays;
import org.apache.cordova.CordovaDialogsHelper;
import org.apache.cordova.CordovaDialogsHelper.Result;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;

public class SystemWebChromeClient extends WebChromeClient {
    private static final int FILECHOOSER_RESULTCODE = 5173;
    private static final String LOG_TAG = "SystemWebChromeClient";
    private long MAX_QUOTA = 104857600;
    private Context appContext;
    private CordovaDialogsHelper dialogsHelper;
    private View mCustomView;
    private CustomViewCallback mCustomViewCallback;
    private View mVideoProgressView;
    protected final SystemWebViewEngine parentEngine;

    public SystemWebChromeClient(SystemWebViewEngine systemWebViewEngine) {
        this.parentEngine = systemWebViewEngine;
        this.appContext = systemWebViewEngine.webView.getContext();
        this.dialogsHelper = new CordovaDialogsHelper(this.appContext);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
        this.dialogsHelper.showAlert(str2, new Result() {
            public void gotResult(boolean z, String str) {
                if (z) {
                    jsResult.confirm();
                } else {
                    jsResult.cancel();
                }
            }
        });
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
        this.dialogsHelper.showConfirm(str2, new Result() {
            public void gotResult(boolean z, String str) {
                if (z) {
                    jsResult.confirm();
                } else {
                    jsResult.cancel();
                }
            }
        });
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        String promptOnJsPrompt = this.parentEngine.bridge.promptOnJsPrompt(str, str2, str3);
        if (promptOnJsPrompt != null) {
            jsPromptResult.confirm(promptOnJsPrompt);
        } else {
            this.dialogsHelper.showPrompt(str2, str3, new Result() {
                public void gotResult(boolean z, String str) {
                    if (z) {
                        jsPromptResult.confirm(str);
                    } else {
                        jsPromptResult.cancel();
                    }
                }
            });
        }
        return true;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        LOG.m1347d(LOG_TAG, "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
        quotaUpdater.updateQuota(this.MAX_QUOTA);
    }

    public void onConsoleMessage(String str, int i, String str2) {
        if (VERSION.SDK_INT == 7) {
            LOG.m1347d(LOG_TAG, "%s: Line %d : %s", str2, Integer.valueOf(i), str);
            super.onConsoleMessage(str, i, str2);
        }
    }

    @TargetApi(8)
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.message() != null) {
            LOG.m1347d(LOG_TAG, "%s: Line %d : %s", consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.message());
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
        CordovaPlugin plugin = this.parentEngine.pluginManager.getPlugin("Geolocation");
        if (plugin != null && !plugin.hasPermisssion()) {
            plugin.requestPermissions(0);
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        this.parentEngine.getCordovaWebView().showCustomView(view, customViewCallback);
    }

    public void onHideCustomView() {
        this.parentEngine.getCordovaWebView().hideCustomView();
    }

    public View getVideoLoadingProgressView() {
        if (this.mVideoProgressView == null) {
            View linearLayout = new LinearLayout(this.parentEngine.getView().getContext());
            linearLayout.setOrientation(1);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            linearLayout.setLayoutParams(layoutParams);
            View progressBar = new ProgressBar(this.parentEngine.getView().getContext());
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            progressBar.setLayoutParams(layoutParams2);
            linearLayout.addView(progressBar);
            this.mVideoProgressView = linearLayout;
        }
        return this.mVideoProgressView;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, "*/*");
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final ValueCallback<Uri> valueCallback, String str, String str2) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.parentEngine.cordova.startActivityForResult(new CordovaPlugin() {
            public void onActivityResult(int i, int i2, Intent intent) {
                Object data = (intent == null || i2 != -1) ? null : intent.getData();
                LOG.m1345d(SystemWebChromeClient.LOG_TAG, "Receive file chooser URL: " + data);
                valueCallback.onReceiveValue(data);
            }
        }, intent, FILECHOOSER_RESULTCODE);
    }

    @TargetApi(21)
    public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        try {
            this.parentEngine.cordova.startActivityForResult(new CordovaPlugin() {
                public void onActivityResult(int i, int i2, Intent intent) {
                    Object parseResult = FileChooserParams.parseResult(i2, intent);
                    LOG.m1345d(SystemWebChromeClient.LOG_TAG, "Receive file chooser URL: " + parseResult);
                    valueCallback.onReceiveValue(parseResult);
                }
            }, fileChooserParams.createIntent(), FILECHOOSER_RESULTCODE);
        } catch (Throwable e) {
            LOG.m1360w("No activity found to handle file chooser intent.", e);
            valueCallback.onReceiveValue(null);
        }
        return true;
    }

    @TargetApi(21)
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        LOG.m1345d(LOG_TAG, "onPermissionRequest: " + Arrays.toString(permissionRequest.getResources()));
        permissionRequest.grant(permissionRequest.getResources());
    }

    public void destroyLastDialog() {
        this.dialogsHelper.destroyLastDialog();
    }
}
