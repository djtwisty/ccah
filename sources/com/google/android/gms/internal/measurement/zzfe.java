package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;

public final class zzfe {

    public static final class zza extends zzuo<zza, zza> implements zzvx {
        private static final zza zzauw = new zza();
        private static volatile zzwf<zza> zznw;
        private String zzauu = "";
        private long zzauv;
        private int zznr;

        public static final class zza extends com.google.android.gms.internal.measurement.zzuo.zza<zza, zza> implements zzvx {
            private zza() {
                super(zza.zzauw);
            }

            public final zza zzda(String str) {
                zzwk();
                ((zza) this.zzbyh).setName(str);
                return this;
            }

            public final zza zzan(long j) {
                zzwk();
                ((zza) this.zzbyh).zzam(j);
                return this;
            }
        }

        private zza() {
        }

        private final void setName(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zznr |= 1;
            this.zzauu = str;
        }

        private final void zzam(long j) {
            this.zznr |= 2;
            this.zzauv = j;
        }

        public static zza zzmn() {
            return (zza) ((com.google.android.gms.internal.measurement.zzuo.zza) zzauw.zza(zze.zzbyo, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzff.zznq[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zznr", "zzauu", "zzauv"};
                    return zzuo.zza(zzauw, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", objArr);
                case 4:
                    return zzauw;
                case 5:
                    Object obj3 = zznw;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zza.class) {
                        obj3 = zznw;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.measurement.zzuo.zzb(zzauw);
                            zznw = obj3;
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
            zzuo.zza(zza.class, zzauw);
        }
    }

    public static final class zzb extends zzuo<zzb, zza> implements zzvx {
        private static final zzb zzauz = new zzb();
        private static volatile zzwf<zzb> zznw;
        private int zzaux = 1;
        private zzuu<zza> zzauy = zzuo.zzwg();
        private int zznr;

        public static final class zza extends com.google.android.gms.internal.measurement.zzuo.zza<zzb, zza> implements zzvx {
            private zza() {
                super(zzb.zzauz);
            }

            public final zza zzb(zza zza) {
                zzwk();
                ((zzb) this.zzbyh).zza(zza);
                return this;
            }
        }

        public enum zzb implements zzur {
            RADS(1),
            PROVISIONING(2);
            
            private static final zzus<zzb> zzoa = null;
            private final int value;

            public final int zzc() {
                return this.value;
            }

            public static zzb zzt(int i) {
                switch (i) {
                    case 1:
                        return RADS;
                    case 2:
                        return PROVISIONING;
                    default:
                        return null;
                }
            }

            public static zzut zzd() {
                return zzfh.zzoc;
            }

            private zzb(int i) {
                this.value = i;
            }

            static {
                zzoa = new zzfg();
            }
        }

        private zzb() {
        }

        private final void zza(zza zza) {
            if (zza == null) {
                throw new NullPointerException();
            }
            if (!this.zzauy.zztz()) {
                zzuu zzuu = this.zzauy;
                int size = zzuu.size();
                this.zzauy = zzuu.zzal(size == 0 ? 10 : size << 1);
            }
            this.zzauy.add(zza);
        }

        public static zza zzmp() {
            return (zza) ((com.google.android.gms.internal.measurement.zzuo.zza) zzauz.zza(zze.zzbyo, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzff.zznq[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zznr", "zzaux", zzb.zzd(), "zzauy", zza.class};
                    return zzuo.zza(zzauz, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", objArr);
                case 4:
                    return zzauz;
                case 5:
                    Object obj3 = zznw;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzb.class) {
                        obj3 = zznw;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.measurement.zzuo.zzb(zzauz);
                            zznw = obj3;
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

        public static zzwf<zzb> zza() {
            return (zzwf) zzauz.zza(zze.zzbyq, null, null);
        }

        static {
            zzuo.zza(zzb.class, zzauz);
        }
    }
}
