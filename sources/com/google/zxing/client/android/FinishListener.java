package com.google.zxing.client.android;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;

public final class FinishListener implements OnCancelListener, OnClickListener {
    private final Activity activityToFinish;

    public FinishListener(Activity activity) {
        this.activityToFinish = activity;
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    private void run() {
        this.activityToFinish.finish();
    }
}
