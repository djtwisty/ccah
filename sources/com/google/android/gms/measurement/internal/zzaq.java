package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

public final class zzaq extends zzcs {
    private static final AtomicReference<String[]> zzalp = new AtomicReference();
    private static final AtomicReference<String[]> zzalq = new AtomicReference();
    private static final AtomicReference<String[]> zzalr = new AtomicReference();

    zzaq(zzbw zzbw) {
        super(zzbw);
    }

    protected final boolean zzgy() {
        return false;
    }

    private final boolean zzjf() {
        zzgw();
        return this.zzada.zzkn() && this.zzada.zzgt().isLoggable(3);
    }

    protected final String zzbt(String str) {
        if (str == null) {
            return null;
        }
        return zzjf() ? zza(str, zzcu.zzaqr, zzcu.zzaqq, zzalp) : str;
    }

    protected final String zzbu(String str) {
        if (str == null) {
            return null;
        }
        return zzjf() ? zza(str, zzcv.zzaqt, zzcv.zzaqs, zzalq) : str;
    }

    protected final String zzbv(String str) {
        if (str == null) {
            return null;
        }
        if (!zzjf()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzcw.zzaqv, zzcw.zzaqu, zzalr);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experiment_id");
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        int i = 0;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        while (i < strArr.length) {
            if (zzfy.zzv(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(strArr2[i]);
                        stringBuilder.append("(");
                        stringBuilder.append(strArr[i]);
                        stringBuilder.append(")");
                        strArr3[i] = stringBuilder.toString();
                    }
                    str = strArr3[i];
                }
                return str;
            }
            i++;
        }
        return str;
    }

    protected final String zzb(zzag zzag) {
        if (zzag == null) {
            return null;
        }
        if (!zzjf()) {
            return zzag.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin=");
        stringBuilder.append(zzag.origin);
        stringBuilder.append(",name=");
        stringBuilder.append(zzbt(zzag.name));
        stringBuilder.append(",params=");
        stringBuilder.append(zzb(zzag.zzahu));
        return stringBuilder.toString();
    }

    protected final String zza(zzab zzab) {
        if (zzab == null) {
            return null;
        }
        if (!zzjf()) {
            return zzab.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{appId='");
        stringBuilder.append(zzab.zztt);
        stringBuilder.append("', name='");
        stringBuilder.append(zzbt(zzab.name));
        stringBuilder.append("', params=");
        stringBuilder.append(zzb(zzab.zzahu));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private final String zzb(zzad zzad) {
        if (zzad == null) {
            return null;
        }
        if (zzjf()) {
            return zzd(zzad.zziy());
        }
        return zzad.toString();
    }

    protected final String zzd(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzjf()) {
            return bundle.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("Bundle[{");
            }
            stringBuilder.append(zzbu(str));
            stringBuilder.append("=");
            stringBuilder.append(bundle.get(str));
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
