package com.google.zxing.client.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;

final class InactivityTimer {
    private static final long INACTIVITY_DELAY_MS = 300000;
    private static final String TAG = InactivityTimer.class.getSimpleName();
    private final Activity activity;
    private AsyncTask<Object, Object, Object> inactivityTask;
    private final BroadcastReceiver powerStatusReceiver = new PowerStatusReceiver();
    private boolean registered = false;

    private final class InactivityAsyncTask extends AsyncTask<Object, Object, Object> {
        private InactivityAsyncTask() {
        }

        protected Object doInBackground(Object... objArr) {
            try {
                Thread.sleep(InactivityTimer.INACTIVITY_DELAY_MS);
                Log.i(InactivityTimer.TAG, "Finishing activity due to inactivity");
                InactivityTimer.this.activity.finish();
            } catch (InterruptedException e) {
            }
            return null;
        }
    }

    private final class PowerStatusReceiver extends BroadcastReceiver {
        private PowerStatusReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if ((intent.getIntExtra("plugged", -1) <= 0 ? 1 : null) != null) {
                    InactivityTimer.this.onActivity();
                } else {
                    InactivityTimer.this.cancel();
                }
            }
        }
    }

    InactivityTimer(Activity activity) {
        this.activity = activity;
        onActivity();
    }

    synchronized void onActivity() {
        cancel();
        this.inactivityTask = new InactivityAsyncTask();
        this.inactivityTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    synchronized void onPause() {
        cancel();
        if (this.registered) {
            this.activity.unregisterReceiver(this.powerStatusReceiver);
            this.registered = false;
        } else {
            Log.w(TAG, "PowerStatusReceiver was never registered?");
        }
    }

    synchronized void onResume() {
        if (this.registered) {
            Log.w(TAG, "PowerStatusReceiver was already registered?");
        } else {
            this.activity.registerReceiver(this.powerStatusReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.registered = true;
        }
        onActivity();
    }

    private synchronized void cancel() {
        AsyncTask asyncTask = this.inactivityTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.inactivityTask = null;
        }
    }

    void shutdown() {
        cancel();
    }
}
