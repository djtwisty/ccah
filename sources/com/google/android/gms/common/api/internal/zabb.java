package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zal;

final class zabb extends zal {
    private final /* synthetic */ zaaw zahg;

    zabb(zaaw zaaw, Looper looper) {
        this.zahg = zaaw;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.zahg.zaav();
                return;
            case 2:
                this.zahg.resume();
                return;
            default:
                Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                return;
        }
    }
}
