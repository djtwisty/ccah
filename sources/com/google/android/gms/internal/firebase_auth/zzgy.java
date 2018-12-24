package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class zzgy implements zzgx {
    zzgy() {
    }

    public final Map<?, ?> zzj(Object obj) {
        return (zzgw) obj;
    }

    public final zzgv<?, ?> zzo(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzk(Object obj) {
        return (zzgw) obj;
    }

    public final boolean zzl(Object obj) {
        return !((zzgw) obj).isMutable();
    }

    public final Object zzm(Object obj) {
        ((zzgw) obj).zzev();
        return obj;
    }

    public final Object zzn(Object obj) {
        return zzgw.zzih().zzii();
    }

    public final Object zzb(Object obj, Object obj2) {
        obj = (zzgw) obj;
        zzgw zzgw = (zzgw) obj2;
        if (!zzgw.isEmpty()) {
            if (!obj.isMutable()) {
                obj = obj.zzii();
            }
            obj.zza(zzgw);
        }
        return obj;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzgw zzgw = (zzgw) obj;
        if (!zzgw.isEmpty()) {
            Iterator it = zzgw.entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                entry.getKey();
                entry.getValue();
                throw new NoSuchMethodError();
            }
        }
        return 0;
    }
}
