package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.p012a.C0131i;

final class zad extends DialogRedirect {
    private final /* synthetic */ C0131i val$fragment;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zaog;

    zad(Intent intent, C0131i c0131i, int i) {
        this.zaog = intent;
        this.val$fragment = c0131i;
        this.val$requestCode = i;
    }

    public final void redirect() {
        if (this.zaog != null) {
            this.val$fragment.startActivityForResult(this.zaog, this.val$requestCode);
        }
    }
}
