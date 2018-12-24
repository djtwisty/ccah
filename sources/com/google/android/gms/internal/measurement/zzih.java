package com.google.android.gms.internal.measurement;

import android.os.Handler;
import android.os.Message;

final class zzih implements zzig {
    private Handler handler;
    final /* synthetic */ zzid zzbkv;

    private zzih(zzid zzid) {
        this.zzbkv = zzid;
        this.handler = new Handler(this.zzbkv.zzbfy.getMainLooper(), new zzii(this));
    }

    public final void zzqh() {
        this.handler.removeMessages(1, zzid.zzbfx);
        this.handler.sendMessage(obtainMessage());
    }

    public final void cancel() {
        this.handler.removeMessages(1, zzid.zzbfx);
    }

    public final void zzh(long j) {
        this.handler.removeMessages(1, zzid.zzbfx);
        this.handler.sendMessageDelayed(obtainMessage(), j);
    }

    private final Message obtainMessage() {
        return this.handler.obtainMessage(1, zzid.zzbfx);
    }
}
