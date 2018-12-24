package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfe.zza;
import com.google.android.gms.internal.measurement.zzfe.zzb;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzuo;
import com.google.android.gms.internal.measurement.zzya;
import com.google.android.gms.internal.measurement.zzyi;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class zzdv extends zzfn {
    public zzdv(zzfo zzfo) {
        super(zzfo);
    }

    protected final boolean zzgy() {
        return false;
    }

    public final byte[] zzb(zzag zzag, String str) {
        zzaf();
        this.zzada.zzgf();
        Preconditions.checkNotNull(zzag);
        Preconditions.checkNotEmpty(str);
        if (!zzgv().zze(str, zzai.zzalf)) {
            zzgt().zzjn().zzg("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        } else if ("_iap".equals(zzag.name) || "_iapx".equals(zzag.name)) {
            zzyi zzfv = new zzfv();
            zzjt().beginTransaction();
            byte[] bArr;
            try {
                zzg zzbm = zzjt().zzbm(str);
                if (zzbm == null) {
                    zzgt().zzjn().zzg("Log and bundle not available. package_name", str);
                    bArr = new byte[0];
                    return bArr;
                } else if (zzbm.isMeasurementEnabled()) {
                    Integer num;
                    zzfw zzfw = new zzfw();
                    zzfv.zzaxf = new zzfw[]{zzfw};
                    zzfw.zzaxh = Integer.valueOf(1);
                    zzfw.zzaxp = "android";
                    zzfw.zztt = zzbm.zzal();
                    zzfw.zzafp = zzbm.zzhg();
                    zzfw.zzts = zzbm.zzak();
                    long zzhf = zzbm.zzhf();
                    if (zzhf == -2147483648L) {
                        num = null;
                    } else {
                        num = Integer.valueOf((int) zzhf);
                    }
                    zzfw.zzayb = num;
                    zzfw.zzaxt = Long.valueOf(zzbm.zzhh());
                    zzfw.zzafi = zzbm.getGmpAppId();
                    if (TextUtils.isEmpty(zzfw.zzafi)) {
                        zzfw.zzawp = zzbm.zzhb();
                    }
                    zzfw.zzaxx = Long.valueOf(zzbm.zzhi());
                    if (this.zzada.isEnabled() && zzq.zzie() && zzgv().zzas(zzfw.zztt)) {
                        zzfw.zzayh = null;
                    }
                    Pair zzbz = zzgu().zzbz(zzbm.zzal());
                    if (!(!zzbm.zzhw() || zzbz == null || TextUtils.isEmpty((CharSequence) zzbz.first))) {
                        zzfw.zzaxv = zzr((String) zzbz.first, Long.toString(zzag.zzaig));
                        zzfw.zzaxw = (Boolean) zzbz.second;
                    }
                    zzgp().zzcl();
                    zzfw.zzaxr = Build.MODEL;
                    zzgp().zzcl();
                    zzfw.zzaxq = VERSION.RELEASE;
                    zzfw.zzaxs = Integer.valueOf((int) zzgp().zziw());
                    zzfw.zzahr = zzgp().zzix();
                    try {
                        zzac zzac;
                        long j;
                        zzfw.zzafh = zzr(zzbm.getAppInstanceId(), Long.toString(zzag.zzaig));
                        zzfw.zzafk = zzbm.getFirebaseInstanceId();
                        String str2 = zzfw.zztt;
                        List<zzfx> zzbl = zzjt().zzbl(str2);
                        if (zzgv().zzau(str)) {
                            for (zzfx zzfx : zzbl) {
                                if ("_lte".equals(zzfx.name)) {
                                    break;
                                }
                            }
                            zzfx zzfx2 = null;
                            if (zzfx2 == null || zzfx2.value == null) {
                                zzfx2 = new zzfx(str2, "auto", "_lte", zzbx().currentTimeMillis(), Long.valueOf(0));
                                zzbl.add(zzfx2);
                                zzjt().zza(zzfx2);
                            }
                        }
                        zzfz[] zzfzArr = new zzfz[zzbl.size()];
                        for (int i = 0; i < zzbl.size(); i++) {
                            zzfz zzfz = new zzfz();
                            zzfzArr[i] = zzfz;
                            zzfz.name = ((zzfx) zzbl.get(i)).name;
                            zzfz.zzayu = Long.valueOf(((zzfx) zzbl.get(i)).zzauk);
                            zzjr().zza(zzfz, ((zzfx) zzbl.get(i)).value);
                        }
                        zzfw.zzaxj = zzfzArr;
                        Bundle zziy = zzag.zzahu.zziy();
                        zziy.putLong("_c", 1);
                        zzgt().zzjn().zzby("Marking in-app purchase as real-time");
                        zziy.putLong("_r", 1);
                        zziy.putString("_o", zzag.origin);
                        if (zzgr().zzcz(zzfw.zztt)) {
                            zzgr().zza(zziy, "_dbg", Long.valueOf(1));
                            zzgr().zza(zziy, "_r", Long.valueOf(1));
                        }
                        zzac zzg = zzjt().zzg(str, zzag.name);
                        if (zzg == null) {
                            zzac = new zzac(str, zzag.name, 0, 0, zzag.zzaig, 0, null, null, null, null);
                            j = 0;
                        } else {
                            j = zzg.zzahx;
                            zzac = zzg.zzae(zzag.zzaig);
                        }
                        zzjt().zza(zzac);
                        zzab zzab = new zzab(this.zzada, zzag.origin, str, zzag.name, zzag.zzaig, j, zziy);
                        zzft zzft = new zzft();
                        zzfw.zzaxi = new zzft[]{zzft};
                        zzft.zzaxb = Long.valueOf(zzab.timestamp);
                        zzft.name = zzab.name;
                        zzft.zzaxc = Long.valueOf(zzab.zzaht);
                        zzft.zzaxa = new zzfu[zzab.zzahu.size()];
                        Iterator it = zzab.zzahu.iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            zzfu zzfu = new zzfu();
                            int i3 = i2 + 1;
                            zzft.zzaxa[i2] = zzfu;
                            zzfu.name = str3;
                            zzjr().zza(zzfu, zzab.zzahu.get(str3));
                            i2 = i3;
                        }
                        zzfw.zzayk = (zzb) ((zzuo) zzb.zzmp().zzb((zza) ((zzuo) zza.zzmn().zzan(zzac.zzahv).zzda(zzag.name).zzwo())).zzwo());
                        zzfw.zzaya = zzjs().zza(zzbm.zzal(), null, zzfw.zzaxj);
                        zzfw.zzaxl = zzft.zzaxb;
                        zzfw.zzaxm = zzft.zzaxb;
                        zzhf = zzbm.zzhe();
                        zzfw.zzaxo = zzhf != 0 ? Long.valueOf(zzhf) : null;
                        long zzhd = zzbm.zzhd();
                        if (zzhd != 0) {
                            zzhf = zzhd;
                        }
                        zzfw.zzaxn = zzhf != 0 ? Long.valueOf(zzhf) : null;
                        zzbm.zzhm();
                        zzfw.zzaxy = Integer.valueOf((int) zzbm.zzhj());
                        zzfw.zzaxu = Long.valueOf(zzgv().zzhh());
                        zzfw.zzaxk = Long.valueOf(zzbx().currentTimeMillis());
                        zzfw.zzaxz = Boolean.TRUE;
                        zzbm.zzo(zzfw.zzaxl.longValue());
                        zzbm.zzp(zzfw.zzaxm.longValue());
                        zzjt().zza(zzbm);
                        zzjt().setTransactionSuccessful();
                        zzjt().endTransaction();
                        try {
                            bArr = new byte[zzfv.zzvx()];
                            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
                            zzfv.zza(zzk);
                            zzk.zzza();
                            return zzjr().zzb(bArr);
                        } catch (IOException e) {
                            zzgt().zzjg().zze("Data loss. Failed to bundle and serialize. appId", zzas.zzbw(str), e);
                            return null;
                        }
                    } catch (SecurityException e2) {
                        zzgt().zzjn().zzg("app instance id encryption failed", e2.getMessage());
                        bArr = new byte[0];
                        zzjt().endTransaction();
                        return bArr;
                    }
                } else {
                    zzgt().zzjn().zzg("Log and bundle disabled. package_name", str);
                    bArr = new byte[0];
                    zzjt().endTransaction();
                    return bArr;
                }
            } catch (SecurityException e22) {
                zzgt().zzjn().zzg("Resettable device id encryption failed", e22.getMessage());
                bArr = new byte[0];
                return bArr;
            } finally {
                zzjt().endTransaction();
            }
        } else {
            zzgt().zzjn().zze("Generating a payload for this event is not available. package_name, event_name", str, zzag.name);
            return null;
        }
    }

    private static String zzr(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
