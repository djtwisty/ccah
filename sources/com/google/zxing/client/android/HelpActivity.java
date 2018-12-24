package com.google.zxing.client.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;

public final class HelpActivity extends Activity {
    private static final String BASE_URL = ("file:///android_asset/html-" + LocaleManager.getTranslatedAssetLanguage() + '/');
    private WebView webView;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0306R.layout.help);
        this.webView = (WebView) findViewById(C0306R.id.help_contents);
        if (bundle == null) {
            this.webView.loadUrl(BASE_URL + "index.html");
        } else {
            this.webView.restoreState(bundle);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.webView.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.webView.goBack();
        return true;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.webView.saveState(bundle);
    }
}
