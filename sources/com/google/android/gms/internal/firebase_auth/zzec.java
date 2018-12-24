package com.google.android.gms.internal.firebase_auth;

import java.io.InputStream;

public abstract class zzec<MessageType extends zzhc> implements zzhm<MessageType> {
    private static final zzfg zzsj = zzfg.zzgq();

    private final MessageType zza(InputStream inputStream, zzfg zzfg) {
        zzet zza;
        if (inputStream == null) {
            byte[] bArr = zzfv.EMPTY_BYTE_ARRAY;
            zza = zzet.zza(bArr, 0, bArr.length, false);
        } else {
            zza = new zzew(inputStream, 4096, null);
        }
        zzhc zzhc = (zzhc) zza(zza, zzfg);
        try {
            zza.zzn(0);
            return zzhc;
        } catch (zzgc e) {
            throw e.zzh(zzhc);
        }
    }

    public final /* synthetic */ Object zzb(InputStream inputStream, zzfg zzfg) {
        zzhc zza = zza(inputStream, zzfg);
        if (zza == null || zza.isInitialized()) {
            return zza;
        }
        zzip zzip;
        if (zza instanceof zzdz) {
            zzip = new zzip((zzdz) zza);
        } else if (zza instanceof zzeb) {
            zzip = new zzip((zzeb) zza);
        } else {
            zzip = new zzip(zza);
        }
        throw new zzgc(zzip.getMessage()).zzh(zza);
    }
}
