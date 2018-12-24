package com.google.android.gms.internal.config;

import android.content.Context;
import android.util.Log;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzam implements Runnable {
    private final Context mContext;
    private final zzaq zzak;
    private final zzan zzas;
    private final zzan zzat;
    private final zzan zzau;

    public zzam(Context context, zzan zzan, zzan zzan2, zzan zzan3, zzaq zzaq) {
        this.mContext = context;
        this.zzas = zzan;
        this.zzat = zzan2;
        this.zzau = zzan3;
        this.zzak = zzaq;
    }

    private static zzar zza(zzan zzan) {
        zzar zzar = new zzar();
        if (zzan.zzq() != null) {
            Map zzq = zzan.zzq();
            List arrayList = new ArrayList();
            if (zzq != null) {
                for (String str : zzq.keySet()) {
                    List arrayList2 = new ArrayList();
                    Map map = (Map) zzq.get(str);
                    if (map != null) {
                        for (String str2 : map.keySet()) {
                            zzas zzas = new zzas();
                            zzas.zzbh = str2;
                            zzas.zzbi = (byte[]) map.get(str2);
                            arrayList2.add(zzas);
                        }
                    }
                    zzau zzau = new zzau();
                    zzau.zzbn = str;
                    zzau.zzbo = (zzas[]) arrayList2.toArray(new zzas[arrayList2.size()]);
                    arrayList.add(zzau);
                }
            }
            zzar.zzbe = (zzau[]) arrayList.toArray(new zzau[arrayList.size()]);
        }
        if (zzan.zzh() != null) {
            List zzh = zzan.zzh();
            zzar.zzbf = (byte[][]) zzh.toArray(new byte[zzh.size()][]);
        }
        zzar.timestamp = zzan.getTimestamp();
        return zzar;
    }

    public final void run() {
        zzbh zzav = new zzav();
        if (this.zzas != null) {
            zzav.zzbp = zza(this.zzas);
        }
        if (this.zzat != null) {
            zzav.zzbq = zza(this.zzat);
        }
        if (this.zzau != null) {
            zzav.zzbr = zza(this.zzau);
        }
        if (this.zzak != null) {
            zzat zzat = new zzat();
            zzat.zzbj = this.zzak.getLastFetchStatus();
            zzat.zzbk = this.zzak.isDeveloperModeEnabled();
            zzav.zzbs = zzat;
        }
        if (!(this.zzak == null || this.zzak.zzs() == null)) {
            List arrayList = new ArrayList();
            Map zzs = this.zzak.zzs();
            for (String str : zzs.keySet()) {
                if (zzs.get(str) != null) {
                    zzaw zzaw = new zzaw();
                    zzaw.zzbn = str;
                    zzaw.zzbv = ((zzal) zzs.get(str)).zzp();
                    zzaw.resourceId = ((zzal) zzs.get(str)).getResourceId();
                    arrayList.add(zzaw);
                }
            }
            zzav.zzbt = (zzaw[]) arrayList.toArray(new zzaw[arrayList.size()]);
        }
        byte[] bArr = new byte[zzav.zzai()];
        try {
            zzaz zzb = zzaz.zzb(bArr, 0, bArr.length);
            zzav.zza(zzb);
            zzb.zzad();
            try {
                FileOutputStream openFileOutput = this.mContext.openFileOutput("persisted_config", 0);
                openFileOutput.write(bArr);
                openFileOutput.close();
            } catch (Throwable e) {
                Log.e("AsyncPersisterTask", "Could not persist config.", e);
            }
        } catch (Throwable e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }
}
