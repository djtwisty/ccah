package com.google.android.gms.internal.measurement;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tagmanager.impl.C0327R;

public final class zzhq {
    private final Intent intent;
    private final zzin zzbgt;
    private final Context zzbjw;
    private final Context zzbjx;

    public zzhq(Intent intent, Context context, Context context2, zzin zzin) {
        this.zzbjw = context;
        this.zzbjx = context2;
        this.intent = intent;
        this.zzbgt = zzin;
    }

    public final void zzre() {
        try {
            this.zzbgt.zzc(this.intent.getData());
            CharSequence string = this.zzbjx.getResources().getString(C0327R.string.tagmanager_preview_dialog_title);
            CharSequence string2 = this.zzbjx.getResources().getString(C0327R.string.tagmanager_preview_dialog_message);
            CharSequence string3 = this.zzbjx.getResources().getString(C0327R.string.tagmanager_preview_dialog_button);
            AlertDialog create = new Builder(this.zzbjw).create();
            create.setTitle(string);
            create.setMessage(string2);
            create.setButton(-1, string3, new zzhr(this));
            create.show();
        } catch (Exception e) {
            String str = "Calling preview threw an exception: ";
            String valueOf = String.valueOf(e.getMessage());
            zzhk.m1081e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
