package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;

public final class zzjm {

    public static final class zza extends zzft<zza, zza> implements zzhe {
        private static final zza zzaea = new zza();
        private static volatile zzhm<zza> zzm;
        private String zzadw = "";
        private String zzadx = "";
        private String zzady = "";
        private String zzadz = "";
        private String zzav = "";

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zza, zza> implements zzhe {
            private zza() {
                super(zza.zzaea);
            }

            public final zza zzdf(String str) {
                zzhj();
                ((zza) this.zzxc).zzde(str);
                return this;
            }

            public final zza zzdg(String str) {
                zzhj();
                ((zza) this.zzxc).zzce(str);
                return this;
            }
        }

        private zza() {
        }

        private final void zzde(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzadw = str;
        }

        private final void zzce(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzav = str;
        }

        public static zza zzka() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzaea.zza(zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzjn.zzn[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzadw", "zzadx", "zzav", "zzady", "zzadz"};
                    return zzft.zza(zzaea, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", objArr);
                case 4:
                    return zzaea;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zza.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzaea);
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
            zzft.zza(zza.class, zzaea);
        }
    }

    public static final class zzb extends zzft<zzb, zza> implements zzhe {
        private static final zzb zzaef = new zzb();
        private static volatile zzhm<zzb> zzm;
        private String zzaeb = "";
        private String zzaec = "";
        private String zzaed = "";
        private long zzaee;
        private String zzaq = "";
        private String zzav = "";
        private long zzaw;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzb, zza> implements zzhe {
            private zza() {
                super(zzb.zzaef);
            }
        }

        private zzb() {
        }

        public final String zzdw() {
            return this.zzaeb;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String zzdx() {
            return this.zzaec;
        }

        public final String zzr() {
            return this.zzav;
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzjn.zzn[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzaeb", "zzaw", "zzaec", "zzav", "zzaq", "zzaed", "zzaee"};
                    return zzft.zza(zzaef, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002", objArr);
                case 4:
                    return zzaef;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzb.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzaef);
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

        public static zzhm<zzb> zzl() {
            return (zzhm) zzaef.zza(zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzb.class, zzaef);
        }
    }
}
