package com.google.android.gms.internal.measurement;

import android.os.Handler.Callback;
import android.os.Message;

final class zzii implements Callback {
    private final /* synthetic */ zzih zzbkw;

    zzii(zzih zzih) {
        this.zzbkw = zzih;
    }

    public final boolean handleMessage(Message message) {
        if (1 == message.what && zzid.zzbfx.equals(message.obj)) {
            this.zzbkw.zzbkv.dispatch();
            if (!this.zzbkw.zzbkv.isPowerSaveMode()) {
                this.zzbkw.zzh((long) this.zzbkw.zzbkv.zzbgb);
            }
        }
        return true;
    }
}
