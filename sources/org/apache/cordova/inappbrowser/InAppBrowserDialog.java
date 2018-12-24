package org.apache.cordova.inappbrowser;

import android.app.Dialog;
import android.content.Context;

public class InAppBrowserDialog extends Dialog {
    Context context;
    InAppBrowser inAppBrowser = null;

    public InAppBrowserDialog(Context context, int i) {
        super(context, i);
        this.context = context;
    }

    public void setInAppBroswer(InAppBrowser inAppBrowser) {
        this.inAppBrowser = inAppBrowser;
    }

    public void onBackPressed() {
        if (this.inAppBrowser == null) {
            dismiss();
        } else if (this.inAppBrowser.hardwareBack() && this.inAppBrowser.canGoBack()) {
            this.inAppBrowser.goBack();
        } else {
            this.inAppBrowser.closeDialog();
        }
    }
}
