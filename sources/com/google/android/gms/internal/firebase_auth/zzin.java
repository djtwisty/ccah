package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zzb;

public final class zzin extends zzft<zzin, zza> implements zzhe {
    private static final zzin zzabn = new zzin();
    private static volatile zzhm<zzin> zzm;
    private long zzabl;
    private int zzabm;

    public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzin, zza> implements zzhe {
        private zza() {
            super(zzin.zzabn);
        }
    }

    private zzin() {
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzio.zzn[i - 1]) {
            case 1:
                return new zzin();
            case 2:
                return new zza();
            case 3:
                Object[] objArr = new Object[]{"zzabl", "zzabm"};
                return new zzhq(zzabn, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", objArr);
            case 4:
                return zzabn;
            case 5:
                Object obj3 = zzm;
                if (obj3 != null) {
                    return obj3;
                }
                synchronized (zzin.class) {
                    obj3 = zzm;
                    if (obj3 == null) {
                        obj3 = new zzb(zzabn);
                        zzm = obj3;
                    }
                }
                return obj3;
            case 6:
                return Byte.valueOf((byte) 1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzft.zza(zzin.class, zzabn);
    }
}
