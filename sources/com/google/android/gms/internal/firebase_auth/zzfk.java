package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzfk<FieldDescriptorType extends zzfm<FieldDescriptorType>> {
    private static final zzfk zzue = new zzfk(true);
    private final zzhz<FieldDescriptorType, Object> zzub = zzhz.zzbb(16);
    private boolean zzuc;
    private boolean zzud = false;

    private zzfk() {
    }

    private zzfk(boolean z) {
        zzev();
    }

    public static <T extends zzfm<T>> zzfk<T> zzgv() {
        return zzue;
    }

    final boolean isEmpty() {
        return this.zzub.isEmpty();
    }

    public final void zzev() {
        if (!this.zzuc) {
            this.zzub.zzev();
            this.zzuc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzuc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfk)) {
            return false;
        }
        return this.zzub.equals(((zzfk) obj).zzub);
    }

    public final int hashCode() {
        return this.zzub.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzud) {
            return new zzgi(this.zzub.entrySet().iterator());
        }
        return this.zzub.entrySet().iterator();
    }

    final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzud) {
            return new zzgi(this.zzub.zzjh().iterator());
        }
        return this.zzub.zzjh().iterator();
    }

    private final Object zza(FieldDescriptorType fieldDescriptorType) {
        Object obj = this.zzub.get(fieldDescriptorType);
        if (obj instanceof zzgf) {
            return zzgf.zzia();
        }
        return obj;
    }

    private final void zza(FieldDescriptorType fieldDescriptorType, Object obj) {
        Object obj2;
        if (!fieldDescriptorType.zzha()) {
            zza(fieldDescriptorType.zzgy(), obj);
            obj2 = obj;
        } else if (obj instanceof List) {
            obj2 = new ArrayList();
            obj2.addAll((List) obj);
            ArrayList arrayList = (ArrayList) obj2;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                i++;
                zza(fieldDescriptorType.zzgy(), obj3);
            }
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj2 instanceof zzgf) {
            this.zzud = true;
        }
        this.zzub.zza((Comparable) fieldDescriptorType, obj2);
    }

    private static void zza(zzjf zzjf, Object obj) {
        boolean z = false;
        zzfv.checkNotNull(obj);
        switch (zzjf.zzjy()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if ((obj instanceof zzeh) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzfw)) {
                    z = true;
                    break;
                }
            case MESSAGE:
                if ((obj instanceof zzhc) || (obj instanceof zzgf)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzub.zzjf(); i++) {
            if (!zzb(this.zzub.zzbc(i))) {
                return false;
            }
        }
        for (Entry zzb : this.zzub.zzjg()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Entry<FieldDescriptorType, Object> entry) {
        zzfm zzfm = (zzfm) entry.getKey();
        if (zzfm.zzgz() == zzjk.MESSAGE) {
            if (zzfm.zzha()) {
                for (zzhc isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof zzhc) {
                if (!((zzhc) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof zzgf) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public final void zza(zzfk<FieldDescriptorType> zzfk) {
        for (int i = 0; i < zzfk.zzub.zzjf(); i++) {
            zzc(zzfk.zzub.zzbc(i));
        }
        for (Entry zzc : zzfk.zzub.zzjg()) {
            zzc(zzc);
        }
    }

    private static Object zzg(Object obj) {
        if (obj instanceof zzhi) {
            return ((zzhi) obj).zziq();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        Object obj2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj2, 0, bArr.length);
        return obj2;
    }

    private final void zzc(Entry<FieldDescriptorType, Object> entry) {
        Comparable comparable = (zzfm) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzgf) {
            value = zzgf.zzia();
        }
        Object zza;
        if (comparable.zzha()) {
            zza = zza((zzfm) comparable);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzg : (List) value) {
                ((List) zza).add(zzg(zzg));
            }
            this.zzub.zza(comparable, zza);
        } else if (comparable.zzgz() == zzjk.MESSAGE) {
            zza = zza((zzfm) comparable);
            if (zza == null) {
                this.zzub.zza(comparable, zzg(value));
                return;
            }
            if (zza instanceof zzhi) {
                value = comparable.zza((zzhi) zza, (zzhi) value);
            } else {
                value = comparable.zza(((zzhc) zza).zzhg(), (zzhc) value).zzhn();
            }
            this.zzub.zza(comparable, value);
        } else {
            this.zzub.zza(comparable, zzg(value));
        }
    }

    static void zza(zzfa zzfa, zzjf zzjf, int i, Object obj) {
        if (zzjf == zzjf.GROUP) {
            zzfv.zzg((zzhc) obj);
            zzhc zzhc = (zzhc) obj;
            zzfa.zzf(i, 3);
            zzhc.zzb(zzfa);
            zzfa.zzf(i, 4);
            return;
        }
        zzfa.zzf(i, zzjf.zzjz());
        switch (zzfl.zzto[zzjf.ordinal()]) {
            case 1:
                zzfa.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzfa.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzfa.zzb(((Long) obj).longValue());
                return;
            case 4:
                zzfa.zzb(((Long) obj).longValue());
                return;
            case 5:
                zzfa.zzac(((Integer) obj).intValue());
                return;
            case 6:
                zzfa.zzd(((Long) obj).longValue());
                return;
            case 7:
                zzfa.zzaf(((Integer) obj).intValue());
                return;
            case 8:
                zzfa.zzs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzhc) obj).zzb(zzfa);
                return;
            case 10:
                zzfa.zzc((zzhc) obj);
                return;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                if (obj instanceof zzeh) {
                    zzfa.zza((zzeh) obj);
                    return;
                } else {
                    zzfa.zzda((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzeh) {
                    zzfa.zza((zzeh) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzfa.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzfa.zzad(((Integer) obj).intValue());
                return;
            case 14:
                zzfa.zzaf(((Integer) obj).intValue());
                return;
            case 15:
                zzfa.zzd(((Long) obj).longValue());
                return;
            case 16:
                zzfa.zzae(((Integer) obj).intValue());
                return;
            case 17:
                zzfa.zzc(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfw) {
                    zzfa.zzac(((zzfw) obj).zzbi());
                    return;
                } else {
                    zzfa.zzac(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzgw() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzub.zzjf(); i2++) {
            Entry zzbc = this.zzub.zzbc(i2);
            i += zzb((zzfm) zzbc.getKey(), zzbc.getValue());
        }
        for (Entry entry : this.zzub.zzjg()) {
            i += zzb((zzfm) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int zzgx() {
        int i = 0;
        int i2 = 0;
        while (i < this.zzub.zzjf()) {
            i++;
            i2 = zzd(this.zzub.zzbc(i)) + i2;
        }
        for (Entry zzd : this.zzub.zzjg()) {
            i2 += zzd(zzd);
        }
        return i2;
    }

    private static int zzd(Entry<FieldDescriptorType, Object> entry) {
        zzfm zzfm = (zzfm) entry.getKey();
        Object value = entry.getValue();
        if (zzfm.zzgz() != zzjk.MESSAGE || zzfm.zzha() || zzfm.zzhb()) {
            return zzb(zzfm, value);
        }
        if (value instanceof zzgf) {
            return zzfa.zzb(((zzfm) entry.getKey()).zzbi(), (zzgf) value);
        }
        return zzfa.zzb(((zzfm) entry.getKey()).zzbi(), (zzhc) value);
    }

    static int zza(zzjf zzjf, int i, Object obj) {
        int i2;
        int zzag = zzfa.zzag(i);
        if (zzjf == zzjf.GROUP) {
            zzfv.zzg((zzhc) obj);
            i2 = zzag << 1;
        } else {
            i2 = zzag;
        }
        return i2 + zzb(zzjf, obj);
    }

    private static int zzb(zzjf zzjf, Object obj) {
        switch (zzfl.zzto[zzjf.ordinal()]) {
            case 1:
                return zzfa.zzb(((Double) obj).doubleValue());
            case 2:
                return zzfa.zzb(((Float) obj).floatValue());
            case 3:
                return zzfa.zze(((Long) obj).longValue());
            case 4:
                return zzfa.zzf(((Long) obj).longValue());
            case 5:
                return zzfa.zzah(((Integer) obj).intValue());
            case 6:
                return zzfa.zzh(((Long) obj).longValue());
            case 7:
                return zzfa.zzak(((Integer) obj).intValue());
            case 8:
                return zzfa.zzt(((Boolean) obj).booleanValue());
            case 9:
                return zzfa.zze((zzhc) obj);
            case 10:
                if (obj instanceof zzgf) {
                    return zzfa.zza((zzgf) obj);
                }
                return zzfa.zzd((zzhc) obj);
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                if (obj instanceof zzeh) {
                    return zzfa.zzb((zzeh) obj);
                }
                return zzfa.zzdb((String) obj);
            case 12:
                if (obj instanceof zzeh) {
                    return zzfa.zzb((zzeh) obj);
                }
                return zzfa.zzc((byte[]) obj);
            case 13:
                return zzfa.zzai(((Integer) obj).intValue());
            case 14:
                return zzfa.zzal(((Integer) obj).intValue());
            case 15:
                return zzfa.zzi(((Long) obj).longValue());
            case 16:
                return zzfa.zzaj(((Integer) obj).intValue());
            case 17:
                return zzfa.zzg(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfw) {
                    return zzfa.zzam(((zzfw) obj).zzbi());
                }
                return zzfa.zzam(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(zzfm<?> zzfm, Object obj) {
        int i = 0;
        zzjf zzgy = zzfm.zzgy();
        int zzbi = zzfm.zzbi();
        if (!zzfm.zzha()) {
            return zza(zzgy, zzbi, obj);
        }
        if (zzfm.zzhb()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzgy, zzb);
            }
            return zzfa.zzao(i) + (zzfa.zzag(zzbi) + i);
        }
        for (Object zzb2 : (List) obj) {
            i += zza(zzgy, zzbi, zzb2);
        }
        return i;
    }

    public final /* synthetic */ Object clone() {
        zzfk zzfk = new zzfk();
        for (int i = 0; i < this.zzub.zzjf(); i++) {
            Entry zzbc = this.zzub.zzbc(i);
            zzfk.zza((zzfm) zzbc.getKey(), zzbc.getValue());
        }
        for (Entry entry : this.zzub.zzjg()) {
            zzfk.zza((zzfm) entry.getKey(), entry.getValue());
        }
        zzfk.zzud = this.zzud;
        return zzfk;
    }
}
