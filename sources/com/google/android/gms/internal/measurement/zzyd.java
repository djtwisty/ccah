package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.ConnectionResult;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzyd<M extends zzyc<M>, T> {
    public final int tag;
    private final int type;
    private final zzuo<?, ?> zzbyg;
    protected final Class<T> zzceu;
    protected final boolean zzcev;

    public static <M extends zzyc<M>, T extends zzyi> zzyd<M, T> zza(int i, Class<T> cls, long j) {
        return new zzyd(11, cls, 810, false);
    }

    private zzyd(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, 810, false);
    }

    private zzyd(int i, Class<T> cls, zzuo<?, ?> zzuo, int i2, boolean z) {
        this.type = i;
        this.zzceu = cls;
        this.tag = i2;
        this.zzcev = false;
        this.zzbyg = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzyd)) {
            return false;
        }
        zzyd zzyd = (zzyd) obj;
        if (this.type == zzyd.type && this.zzceu == zzyd.zzceu && this.tag == zzyd.tag && this.zzcev == zzyd.zzcev) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzcev ? 1 : 0) + ((((((this.type + 1147) * 31) + this.zzceu.hashCode()) * 31) + this.tag) * 31);
    }

    final T zzai(List<zzyk> list) {
        int i = 0;
        if (list == null) {
            return null;
        }
        if (this.zzcev) {
            int i2;
            List arrayList = new ArrayList();
            for (i2 = 0; i2 < list.size(); i2++) {
                zzyk zzyk = (zzyk) list.get(i2);
                if (zzyk.zzbtx.length != 0) {
                    arrayList.add(zze(zzxz.zzn(zzyk.zzbtx)));
                }
            }
            i2 = arrayList.size();
            if (i2 == 0) {
                return null;
            }
            T cast = this.zzceu.cast(Array.newInstance(this.zzceu.getComponentType(), i2));
            while (i < i2) {
                Array.set(cast, i, arrayList.get(i));
                i++;
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zzceu.cast(zze(zzxz.zzn(((zzyk) list.get(list.size() - 1)).zzbtx)));
        }
    }

    private final Object zze(zzxz zzxz) {
        String valueOf;
        Class componentType = this.zzcev ? this.zzceu.getComponentType() : this.zzceu;
        try {
            zzyi zzyi;
            switch (this.type) {
                case 10:
                    zzyi = (zzyi) componentType.newInstance();
                    zzxz.zza(zzyi, this.tag >>> 3);
                    return zzyi;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    zzyi = (zzyi) componentType.newInstance();
                    zzxz.zza(zzyi);
                    return zzyi;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    protected final void zza(Object obj, zzya zzya) {
        try {
            zzya.zzcd(this.tag);
            switch (this.type) {
                case 10:
                    int i = this.tag >>> 3;
                    ((zzyi) obj).zza(zzya);
                    zzya.zzc(i, 4);
                    return;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    zzya.zzb((zzyi) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected final int zzao(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzya.zzbd(i) << 1) + ((zzyi) obj).zzvx();
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return zzya.zzb(i, (zzyi) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }
}
