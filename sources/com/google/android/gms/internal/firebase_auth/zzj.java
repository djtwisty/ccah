package com.google.android.gms.internal.firebase_auth;

import java.util.List;

public final class zzj {

    public static final class zza extends zzft<zza, zza> implements zzhe {
        private static final zza zzae = new zza();
        private static volatile zzhm<zza> zzm;
        private String zzaa = "";
        private zzgb<zzh> zzab = zzft.zzhf();
        private String zzac = "";
        private long zzad;
        private int zzi;
        private String zzo = "";
        private String zzp = "";
        private String zzq = "";
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private String zzu = "";
        private String zzv = "";
        private String zzw = "";
        private String zzx = "";
        private String zzy = "";
        private String zzz = "";

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zza, zza> implements zzhe {
            private zza() {
                super(zza.zzae);
            }

            public final zza zzd(String str) {
                zzhj();
                ((zza) this.zzxc).zza(str);
                return this;
            }

            public final zza zze(String str) {
                zzhj();
                ((zza) this.zzxc).zzb(str);
                return this;
            }

            public final zza zzf(String str) {
                zzhj();
                ((zza) this.zzxc).zzc(str);
                return this;
            }
        }

        private zza() {
        }

        private final void zza(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzo = str;
        }

        private final void zzb(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 2;
            this.zzp = str;
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 8192;
            this.zzac = str;
        }

        public static zza zzc() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzae.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", zzh.class, "zzac", "zzad"};
                    return zzft.zza(zzae, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\u001b\u000f\b\r\u0010\u0003\u000e", objArr);
                case 4:
                    return zzae;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zza.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzae);
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
            zzft.zza(zza.class, zzae);
        }
    }

    public static final class zzb extends zzft<zzb, zza> implements zzhe {
        private static final zzb zzan = new zzb();
        private static volatile zzhm<zzb> zzm;
        private String zzaf = "";
        private String zzag = "";
        private zzgb<String> zzah = zzft.zzhf();
        private boolean zzai;
        private boolean zzaj;
        private boolean zzak;
        private zzgb<String> zzal = zzft.zzhf();
        private byte zzam = (byte) 2;
        private int zzi;
        private String zzr = "";
        private String zzz = "";

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzb, zza> implements zzhe {
            private zza() {
                super(zzb.zzan);
            }
        }

        private zzb() {
        }

        public final String zze() {
            return this.zzag;
        }

        public final List<String> zzf() {
            return this.zzah;
        }

        public final int zzg() {
            return this.zzah.size();
        }

        public final boolean zzh() {
            return this.zzai;
        }

        public final String getProviderId() {
            return this.zzr;
        }

        public final boolean zzi() {
            return this.zzaj;
        }

        public final List<String> zzj() {
            return this.zzal;
        }

        public final int zzk() {
            return this.zzal.size();
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaf", "zzag", "zzah", "zzai", "zzr", "zzaj", "zzak", "zzz", "zzal"};
                    return zzft.zza(zzan, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\u001a\u0004\u0007\u0002\u0005\b\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\b\u0006\t\u001a", objArr);
                case 4:
                    return zzan;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzb.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzan);
                            zzm = obj3;
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhm<zzb> zzl() {
            return (zzhm) zzan.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzb.class, zzan);
        }
    }

    public static final class zzc extends zzft<zzc, zza> implements zzhe {
        private static final zzc zzar = new zzc();
        private static volatile zzhm<zzc> zzm;
        private String zzao = "";
        private long zzap;
        private String zzaq = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzc, zza> implements zzhe {
            private zza() {
                super(zzc.zzar);
            }

            public final zza zzh(String str) {
                zzhj();
                ((zzc) this.zzxc).zzg(str);
                return this;
            }
        }

        private zzc() {
        }

        private final void zzg(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 4;
            this.zzaq = str;
        }

        public static zza zzn() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzar.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzao", "zzap", "zzaq"};
                    return zzft.zza(zzar, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002", objArr);
                case 4:
                    return zzar;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzc.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzar);
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
            zzft.zza(zzc.class, zzar);
        }
    }

    public static final class zzd extends zzft<zzd, zza> implements zzhe {
        private static final zzd zzau = new zzd();
        private static volatile zzhm<zzd> zzm;
        private String zzac = "";
        private long zzad;
        private String zzaq = "";
        private String zzas = "";
        private String zzat = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzd, zza> implements zzhe {
            private zza() {
                super(zzd.zzau);
            }

            public final zza zzk(String str) {
                zzhj();
                ((zzd) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzl(String str) {
                zzhj();
                ((zzd) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzm(String str) {
                zzhj();
                ((zzd) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzn(String str) {
                zzhj();
                ((zzd) this.zzxc).zzc(str);
                return this;
            }
        }

        private zzd() {
        }

        private final void zzi(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzas = str;
        }

        private final void zzj(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 2;
            this.zzat = str;
        }

        private final void zzg(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 4;
            this.zzaq = str;
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 8;
            this.zzac = str;
        }

        public static zza zzp() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzau.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzas", "zzat", "zzaq", "zzac", "zzad"};
                    return zzft.zza(zzau, "\u0001\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0006\b\u0003\u0007\u0003\u0004", objArr);
                case 4:
                    return zzau;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzd.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzau);
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
            zzft.zza(zzd.class, zzau);
        }
    }

    public static final class zze extends zzft<zze, zza> implements zzhe {
        private static final zze zzay = new zze();
        private static volatile zzhm<zze> zzm;
        private String zzaf = "";
        private byte zzam = (byte) 2;
        private String zzao = "";
        private String zzaq = "";
        private String zzat = "";
        private String zzav = "";
        private long zzaw;
        private boolean zzax;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zze, zza> implements zzhe {
            private zza() {
                super(zze.zzay);
            }
        }

        private zze() {
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String getLocalId() {
            return this.zzao;
        }

        public final boolean zzt() {
            return this.zzax;
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaf", "zzaq", "zzat", "zzav", "zzaw", "zzao", "zzax"};
                    return zzft.zza(zzay, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u0002\u0004\u0006\b\u0005\u0007\u0007\u0006", objArr);
                case 4:
                    return zzay;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zze.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzay);
                            zzm = obj3;
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhm<zze> zzl() {
            return (zzhm) zzay.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zze.class, zzay);
        }
    }

    public static final class zzf extends zzft<zzf, zza> implements zzhe {
        private static final zzf zzbb = new zzf();
        private static volatile zzhm<zzf> zzm;
        private long zzap;
        private String zzaq = "";
        private zzgb<String> zzaz = zzft.zzhf();
        private zzgb<String> zzba = zzft.zzhf();
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzf, zza> implements zzhe {
            private zza() {
                super(zzf.zzbb);
            }

            public final zza zzo(String str) {
                zzhj();
                ((zzf) this.zzxc).zzg(str);
                return this;
            }
        }

        private zzf() {
        }

        private final void zzg(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzaq = str;
        }

        public static zza zzv() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzbb.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaq", "zzaz", "zzba", "zzap"};
                    return zzft.zza(zzbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\b\u0000\u0002\u001a\u0003\u001a\u0004\u0002\u0001", objArr);
                case 4:
                    return zzbb;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzf.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzbb);
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
            zzft.zza(zzf.class, zzbb);
        }
    }

    public static final class zzg extends zzft<zzg, zza> implements zzhe {
        private static final zzg zzbd = new zzg();
        private static volatile zzhm<zzg> zzm;
        private String zzaf = "";
        private byte zzam = (byte) 2;
        private zzgb<zzr> zzbc = zzft.zzhf();
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzg, zza> implements zzhe {
            private zza() {
                super(zzg.zzbd);
            }
        }

        private zzg() {
        }

        public final int zzx() {
            return this.zzbc.size();
        }

        public final zzr zza(int i) {
            return (zzr) this.zzbc.get(i);
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaf", "zzbc", zzr.class};
                    return zzft.zza(zzbd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\u001b", objArr);
                case 4:
                    return zzbd;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzg.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzbd);
                            zzm = obj3;
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhm<zzg> zzl() {
            return (zzhm) zzbd.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzg.class, zzbd);
        }
    }

    public static final class zzh extends zzft<zzh, zza> implements zzhe {
        private static final zzh zzbs = new zzh();
        private static volatile zzhm<zzh> zzm;
        private String zzac = "";
        private long zzad;
        private String zzaq = "";
        private String zzat = "";
        private int zzbe;
        private String zzbf = "";
        private String zzbg = "";
        private String zzbh = "";
        private String zzbi = "";
        private String zzbj = "";
        private String zzbk = "";
        private String zzbl = "";
        private String zzbm = "";
        private boolean zzbn;
        private String zzbo = "";
        private boolean zzbp;
        private String zzbq = "";
        private boolean zzbr;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzh, zza> implements zzhe {
            private zza() {
                super(zzh.zzbs);
            }

            public final zza zzb(zzjo zzjo) {
                zzhj();
                ((zzh) this.zzxc).zza(zzjo);
                return this;
            }

            public final zza zzv(String str) {
                zzhj();
                ((zzh) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzw(String str) {
                zzhj();
                ((zzh) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzx(String str) {
                zzhj();
                ((zzh) this.zzxc).zzp(str);
                return this;
            }

            public final zza zzy(String str) {
                zzhj();
                ((zzh) this.zzxc).zzq(str);
                return this;
            }

            public final zza zzz(String str) {
                zzhj();
                ((zzh) this.zzxc).zzr(str);
                return this;
            }

            public final zza zzaa(String str) {
                zzhj();
                ((zzh) this.zzxc).zzs(str);
                return this;
            }

            public final zza zzc(boolean z) {
                zzhj();
                ((zzh) this.zzxc).zza(z);
                return this;
            }

            public final zza zzab(String str) {
                zzhj();
                ((zzh) this.zzxc).zzt(str);
                return this;
            }

            public final zza zzd(boolean z) {
                zzhj();
                ((zzh) this.zzxc).zzb(z);
                return this;
            }

            public final zza zzac(String str) {
                zzhj();
                ((zzh) this.zzxc).zzc(str);
                return this;
            }

            public final zza zzad(String str) {
                zzhj();
                ((zzh) this.zzxc).zzu(str);
                return this;
            }
        }

        private zzh() {
        }

        private final void zza(zzjo zzjo) {
            if (zzjo == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzbe = zzjo.zzbi();
        }

        private final void zzj(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 2;
            this.zzat = str;
        }

        private final void zzg(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 64;
            this.zzaq = str;
        }

        private final void zzp(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 128;
            this.zzbj = str;
        }

        private final void zzq(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 256;
            this.zzbk = str;
        }

        private final void zzr(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 512;
            this.zzbl = str;
        }

        private final void zzs(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1024;
            this.zzbm = str;
        }

        private final void zza(boolean z) {
            this.zzi |= 2048;
            this.zzbn = z;
        }

        private final void zzt(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 4096;
            this.zzbo = str;
        }

        private final void zzb(boolean z) {
            this.zzi |= 8192;
            this.zzbp = z;
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 16384;
            this.zzac = str;
        }

        private final void zzu(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 65536;
            this.zzbq = str;
        }

        public static zza zzz() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzbs.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzbe", zzjo.zzbj(), "zzat", "zzbf", "zzbg", "zzbh", "zzbi", "zzaq", "zzbj", "zzbk", "zzbl", "zzbm", "zzbn", "zzbo", "zzbp", "zzac", "zzad", "zzbq", "zzbr"};
                    return zzft.zza(zzbs, "\u0001\u0012\u0000\u0001\u0001\u0013\u0012\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\u0007\u000b\r\b\f\u000e\u0007\r\u000f\b\u000e\u0010\u0003\u000f\u0012\b\u0010\u0013\u0007\u0011", objArr);
                case 4:
                    return zzbs;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzh.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzbs);
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
            zzft.zza(zzh.class, zzbs);
        }
    }

    public static final class zzi extends zzft<zzi, zza> implements zzhe {
        private static final zzi zzbv = new zzi();
        private static volatile zzhm<zzi> zzm;
        private String zzac = "";
        private long zzad;
        private String zzas = "";
        private String zzat = "";
        private String zzbt = "";
        private String zzbu = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzi, zza> implements zzhe {
            private zza() {
                super(zzi.zzbv);
            }

            public final zza zzaf(String str) {
                zzhj();
                ((zzi) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzag(String str) {
                zzhj();
                ((zzi) this.zzxc).zzae(str);
                return this;
            }

            public final zza zzah(String str) {
                zzhj();
                ((zzi) this.zzxc).zzc(str);
                return this;
            }
        }

        private zzi() {
        }

        private final void zzi(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzas = str;
        }

        private final void zzae(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 2;
            this.zzbt = str;
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 16;
            this.zzac = str;
        }

        public static zza zzab() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzbv.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzas", "zzbt", "zzbu", "zzat", "zzac", "zzad"};
                    return zzft.zza(zzbv, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0006\b\u0004\u0007\u0003\u0005", objArr);
                case 4:
                    return zzbv;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzi.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzbv);
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
            zzft.zza(zzi.class, zzbv);
        }
    }

    public static final class zzj extends zzft<zzj, zza> implements zzhe {
        private static final zzj zzbx = new zzj();
        private static volatile zzhm<zzj> zzm;
        private String zzaf = "";
        private byte zzam = (byte) 2;
        private String zzat = "";
        private String zzbi = "";
        private int zzbw;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzj, zza> implements zzhe {
            private zza() {
                super(zzj.zzbx);
            }
        }

        private zzj() {
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String zzad() {
            return this.zzbi;
        }

        public final zzjo zzae() {
            zzjo zzbg = zzjo.zzbg(this.zzbw);
            return zzbg == null ? zzjo.OOB_REQ_TYPE_UNSPECIFIED : zzbg;
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaf", "zzat", "zzbi", "zzbw", zzjo.zzbj()};
                    return zzft.zza(zzbx, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\f\u0003", objArr);
                case 4:
                    return zzbx;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzj.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzbx);
                            zzm = obj3;
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhm<zzj> zzl() {
            return (zzhm) zzbx.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzj.class, zzbx);
        }
    }

    public static final class zzk extends zzft<zzk, zza> implements zzhe {
        private static final zzk zzcc = new zzk();
        private static volatile zzhm<zzk> zzm;
        private String zzac = "";
        private long zzad;
        private String zzby = "";
        private String zzbz = "";
        private String zzca = "";
        private String zzcb = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzk, zza> implements zzhe {
            private zza() {
                super(zzk.zzcc);
            }

            public final zza zzaj(String str) {
                zzhj();
                ((zzk) this.zzxc).zzai(str);
                return this;
            }

            public final zza zzak(String str) {
                zzhj();
                ((zzk) this.zzxc).zzc(str);
                return this;
            }
        }

        private zzk() {
        }

        private final void zzai(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzby = str;
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 16;
            this.zzac = str;
        }

        public static zza zzag() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzcc.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzby", "zzbz", "zzca", "zzcb", "zzac", "zzad"};
                    return zzft.zza(zzcc, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0003\u0005", objArr);
                case 4:
                    return zzcc;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzk.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzcc);
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
            zzft.zza(zzk.class, zzcc);
        }
    }

    public static final class zzl extends zzft<zzl, zza> implements zzhe {
        private static final zzga<Integer, zzo> zzcp = new zzl();
        private static final zzl zzcu = new zzl();
        private static volatile zzhm<zzl> zzm;
        private String zzac = "";
        private long zzad;
        private String zzao = "";
        private long zzap;
        private String zzaq = "";
        private String zzas = "";
        private String zzat = "";
        private String zzcd = "";
        private String zzce = "";
        private zzgb<String> zzcf = zzft.zzhf();
        private boolean zzcg;
        private boolean zzch;
        private String zzci = "";
        private String zzcj = "";
        private zzin zzck;
        private boolean zzcl;
        private String zzcm = "";
        private String zzcn = "";
        private zzfz zzco = zzft.zzhe();
        private boolean zzcq;
        private zzgb<String> zzcr = zzft.zzhf();
        private long zzcs;
        private long zzct;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzl, zza> implements zzhe {
            private zza() {
                super(zzl.zzcu);
            }

            public final zza zzan(String str) {
                zzhj();
                ((zzl) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzao(String str) {
                zzhj();
                ((zzl) this.zzxc).zzal(str);
                return this;
            }

            public final zza zzap(String str) {
                zzhj();
                ((zzl) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzaq(String str) {
                zzhj();
                ((zzl) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzar(String str) {
                zzhj();
                ((zzl) this.zzxc).zzi(str);
                return this;
            }

            public final zza zzas(String str) {
                zzhj();
                ((zzl) this.zzxc).zzam(str);
                return this;
            }

            public final zza zzc(Iterable<? extends zzo> iterable) {
                zzhj();
                ((zzl) this.zzxc).zza(iterable);
                return this;
            }

            public final zza zzf(boolean z) {
                zzhj();
                ((zzl) this.zzxc).zze(z);
                return this;
            }

            public final zza zzd(Iterable<String> iterable) {
                zzhj();
                ((zzl) this.zzxc).zzb(iterable);
                return this;
            }

            public final zza zzat(String str) {
                zzhj();
                ((zzl) this.zzxc).zzc(str);
                return this;
            }
        }

        private zzl() {
        }

        private final void zzg(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzaq = str;
        }

        private final void zzal(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 4;
            this.zzcd = str;
        }

        private final void zzj(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 8;
            this.zzat = str;
        }

        private final void setPassword(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 16;
            this.zzce = str;
        }

        private final void zzi(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 32;
            this.zzas = str;
        }

        private final void zzam(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 16384;
            this.zzcn = str;
        }

        private final void zza(Iterable<? extends zzo> iterable) {
            if (!this.zzco.zzeu()) {
                zzfz zzfz = this.zzco;
                int size = zzfz.size();
                this.zzco = zzfz.zzar(size == 0 ? 10 : size << 1);
            }
            for (zzo zzbi : iterable) {
                this.zzco.zzas(zzbi.zzbi());
            }
        }

        private final void zze(boolean z) {
            this.zzi |= 32768;
            this.zzcq = z;
        }

        private final void zzb(Iterable<String> iterable) {
            if (!this.zzcr.zzeu()) {
                zzgb zzgb = this.zzcr;
                int size = zzgb.size();
                this.zzcr = zzgb.zzj(size == 0 ? 10 : size << 1);
            }
            zzdz.zza(iterable, this.zzcr);
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 262144;
            this.zzac = str;
        }

        public static zza zzai() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzcu.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaq", "zzao", "zzcd", "zzat", "zzce", "zzcf", "zzas", "zzcg", "zzch", "zzci", "zzcj", "zzck", "zzcl", "zzcm", "zzap", "zzcn", "zzco", zzo.zzbj(), "zzcq", "zzcr", "zzcs", "zzct", "zzac", "zzad"};
                    return zzft.zza(zzcu, "\u0001\u0017\u0000\u0001\u0002\u001a\u0017\u0000\u0003\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u001a\b\b\u0005\t\u0007\u0006\n\u0007\u0007\u000b\b\b\f\b\t\r\t\n\u000e\u0007\u000b\u000f\b\f\u0010\u0002\r\u0011\b\u000e\u0012\u001e\u0013\u0007\u000f\u0014\u001a\u0015\u0002\u0010\u0016\u0002\u0011\u0019\b\u0012\u001a\u0003\u0013", objArr);
                case 4:
                    return zzcu;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzl.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzcu);
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
            zzft.zza(zzl.class, zzcu);
        }
    }

    public static final class zzm extends zzft<zzm, zza> implements zzhe {
        private static final zzm zzcx = new zzm();
        private static volatile zzhm<zzm> zzm;
        private String zzaf = "";
        private byte zzam = (byte) 2;
        private String zzao = "";
        private String zzaq = "";
        private String zzat = "";
        private String zzav = "";
        private long zzaw;
        private String zzbi = "";
        private String zzcd = "";
        private zzgb<String> zzcf = zzft.zzhf();
        private boolean zzcg;
        private String zzcn = "";
        private zzgb<zzm> zzcv = zzft.zzhf();
        private String zzcw = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzm, zza> implements zzhe {
            private zza() {
                super(zzm.zzcx);
            }
        }

        private zzm() {
        }

        @Deprecated
        public final String getEmail() {
            return this.zzat;
        }

        @Deprecated
        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        @Deprecated
        public final List<zzm> zzak() {
            return this.zzcv;
        }

        @Deprecated
        public final String zzal() {
            return this.zzcn;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String zzam() {
            return this.zzcw;
        }

        public final boolean zzan() {
            return this.zzcg;
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaf", "zzao", "zzat", "zzcd", "zzcf", "zzaq", "zzcv", zzm.class, "zzbi", "zzcn", "zzav", "zzaw", "zzcw", "zzcg"};
                    return zzft.zza(zzcx, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u001a\u0006\b\u0004\u0007\u001b\b\b\u0005\t\b\u0006\n\b\u0007\u000b\u0002\b\f\b\t\r\u0007\n", objArr);
                case 4:
                    return zzcx;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzm.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzcx);
                            zzm = obj3;
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhm<zzm> zzl() {
            return (zzhm) zzcx.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzm.class, zzcx);
        }
    }

    public static final class zzn extends zzft<zzn, zza> implements zzhe {
        private static final zzn zzcz = new zzn();
        private static volatile zzhm<zzn> zzm;
        private String zzac = "";
        private long zzad;
        private String zzaq = "";
        private String zzat = "";
        private String zzcd = "";
        private String zzce = "";
        private boolean zzcg;
        private String zzci = "";
        private String zzcj = "";
        private String zzcm = "";
        private String zzcn = "";
        private boolean zzcy;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzn, zza> implements zzhe {
            private zza() {
                super(zzn.zzcz);
            }

            public final zza zzau(String str) {
                zzhj();
                ((zzn) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzav(String str) {
                zzhj();
                ((zzn) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzaw(String str) {
                zzhj();
                ((zzn) this.zzxc).zzc(str);
                return this;
            }
        }

        private zzn() {
        }

        private final void zzj(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzat = str;
        }

        private final void setPassword(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 2;
            this.zzce = str;
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1024;
            this.zzac = str;
        }

        public static zza zzap() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzcz.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzat", "zzce", "zzcd", "zzci", "zzcj", "zzcm", "zzaq", "zzcg", "zzcn", "zzcy", "zzac", "zzad"};
                    return zzft.zza(zzcz, "\u0001\f\u0000\u0001\u0001\u000e\f\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0007\u0007\t\b\b\n\u0007\t\r\b\n\u000e\u0003\u000b", objArr);
                case 4:
                    return zzcz;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzn.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzcz);
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
            zzft.zza(zzn.class, zzcz);
        }
    }

    public static final class zzo extends zzft<zzo, zza> implements zzhe {
        private static final zzo zzda = new zzo();
        private static volatile zzhm<zzo> zzm;
        private String zzaf = "";
        private byte zzam = (byte) 2;
        private String zzao = "";
        private String zzaq = "";
        private String zzat = "";
        private String zzav = "";
        private long zzaw;
        private String zzcd = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzo, zza> implements zzhe {
            private zza() {
                super(zzo.zzda);
            }
        }

        private zzo() {
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaf", "zzaq", "zzcd", "zzat", "zzav", "zzaw", "zzao"};
                    return zzft.zza(zzda, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005\b\b\u0006", objArr);
                case 4:
                    return zzda;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzo.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzda);
                            zzm = obj3;
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhm<zzo> zzl() {
            return (zzhm) zzda.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzo.class, zzda);
        }
    }

    public static final class zzp extends zzft<zzp, zza> implements zzhe {
        private static final zzp zzdi = new zzp();
        private static volatile zzhm<zzp> zzm;
        private String zzac = "";
        private long zzad;
        private long zzap;
        private String zzaq = "";
        private String zzcm = "";
        private boolean zzcq;
        private String zzdb = "";
        private String zzdc = "";
        private String zzdd = "";
        private boolean zzde;
        private boolean zzdf;
        private boolean zzdg = true;
        private String zzdh = "";
        private int zzi;
        private String zzz = "";

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzp, zza> implements zzhe {
            private zza() {
                super(zzp.zzdi);
            }

            public final zza zzbb(String str) {
                zzhj();
                ((zzp) this.zzxc).zzax(str);
                return this;
            }

            public final zza zzbc(String str) {
                zzhj();
                ((zzp) this.zzxc).zzay(str);
                return this;
            }

            public final zza zzbd(String str) {
                zzhj();
                ((zzp) this.zzxc).zzaz(str);
                return this;
            }

            public final zza zzbe(String str) {
                zzhj();
                ((zzp) this.zzxc).zzg(str);
                return this;
            }

            public final zza zzi(boolean z) {
                zzhj();
                ((zzp) this.zzxc).zze(z);
                return this;
            }

            public final zza zzj(boolean z) {
                zzhj();
                ((zzp) this.zzxc).zzg(z);
                return this;
            }

            public final zza zzk(boolean z) {
                zzhj();
                ((zzp) this.zzxc).zzh(z);
                return this;
            }

            public final zza zzbf(String str) {
                zzhj();
                ((zzp) this.zzxc).zzc(str);
                return this;
            }

            public final zza zzbg(String str) {
                zzhj();
                ((zzp) this.zzxc).zzba(str);
                return this;
            }
        }

        private zzp() {
        }

        private final void zzax(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzdb = str;
        }

        private final void zzay(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 2;
            this.zzdc = str;
        }

        private final void zzaz(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 16;
            this.zzz = str;
        }

        private final void zzg(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 128;
            this.zzaq = str;
        }

        private final void zze(boolean z) {
            this.zzi |= 256;
            this.zzcq = z;
        }

        private final void zzg(boolean z) {
            this.zzi |= 512;
            this.zzdf = z;
        }

        private final void zzh(boolean z) {
            this.zzi |= 1024;
            this.zzdg = z;
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 2048;
            this.zzac = str;
        }

        private final void zzba(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 8192;
            this.zzdh = str;
        }

        public static zza zzas() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzdi.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzdb", "zzdc", "zzdd", "zzde", "zzz", "zzcm", "zzap", "zzaq", "zzcq", "zzdf", "zzdg", "zzac", "zzad", "zzdh"};
                    return zzft.zza(zzdi, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\u0002\u0006\b\b\u0007\t\u0007\b\n\u0007\t\u000b\u0007\n\r\b\u000b\u000e\u0003\f\u000f\b\r", objArr);
                case 4:
                    return zzdi;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzp.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzdi);
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
            zzft.zza(zzp.class, zzdi);
        }
    }

    public static final class zzq extends zzft<zzq, zza> implements zzhe {
        private static final zzq zzel = new zzq();
        private static volatile zzhm<zzq> zzm;
        private String zzac = "";
        private String zzao = "";
        private String zzaq = "";
        private String zzat = "";
        private String zzav = "";
        private long zzaw;
        private boolean zzax;
        private String zzcd = "";
        private boolean zzcg;
        private String zzcn = "";
        private String zzdh = "";
        private int zzdj;
        private String zzdk = "";
        private String zzdl = "";
        private String zzdm = "";
        private String zzdn = "";
        private String zzdo = "";
        private String zzdp = "";
        private String zzdq = "";
        private String zzdr = "";
        private String zzds = "";
        private String zzdt = "";
        private String zzdu = "";
        private boolean zzdv;
        private String zzdw = "";
        private zzgb<String> zzdx = zzft.zzhf();
        private boolean zzdy;
        private String zzdz = "";
        private String zzea = "";
        private String zzeb = "";
        private String zzec = "";
        private long zzed;
        private String zzee = "";
        private boolean zzef;
        private String zzeg = "";
        private String zzeh = "";
        private String zzei = "";
        private String zzej = "";
        private String zzek = "";
        private int zzi;
        private String zzr = "";
        private String zzt = "";
        private String zzv = "";

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzq, zza> implements zzhe {
            private zza() {
                super(zzq.zzel);
            }
        }

        private zzq() {
        }

        public final String getProviderId() {
            return this.zzr;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String zzal() {
            return this.zzcn;
        }

        public final String getLocalId() {
            return this.zzao;
        }

        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final boolean zzau() {
            return this.zzdy;
        }

        public final String zzav() {
            return this.zzeb;
        }

        public final boolean zzaw() {
            return this.zzef;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final String zzax() {
            return this.zzeh;
        }

        public final String getRawUserInfo() {
            return this.zzej;
        }

        public final String getErrorMessage() {
            return this.zzek;
        }

        public final boolean zzt() {
            return this.zzax;
        }

        public final String zzay() {
            return this.zzdh;
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzdj", "zzdk", "zzr", "zzat", "zzcg", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzcn", "zzdr", "zzds", "zzt", "zzdt", "zzdu", "zzao", "zzdv", "zzcd", "zzaq", "zzdw", "zzv", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", "zzeg", "zzav", "zzaw", "zzeh", "zzei", "zzej", "zzek", "zzax", "zzdh", "zzac"};
                    return zzft.zza(zzel, "\u0001)\u0000\u0002\u0001+)\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\b\r\u000f\b\u000e\u0010\b\u000f\u0011\b\u0010\u0012\u0007\u0011\u0013\b\u0012\u0014\b\u0013\u0015\b\u0014\u0017\b\u0015\u0018\u001a\u0019\u0007\u0016\u001a\b\u0017\u001b\b\u0018\u001c\b\u0019\u001d\b\u001a\u001e\u0002\u001b\u001f\b\u001c \u0007\u001d!\b\u001e\"\b\u001f#\u0002 $\b!%\b\"&\b#'\b$(\u0007%*\b&+\b'", objArr);
                case 4:
                    return zzel;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzq.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzel);
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

        public static zzhm<zzq> zzl() {
            return (zzhm) zzel.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzq.class, zzel);
        }
    }

    public static final class zzr extends zzft<zzr, zza> implements zzhe {
        private static final zzr zzen = new zzr();
        private static volatile zzhm<zzr> zzm;
        private long zzap;
        private String zzcm = "";
        private boolean zzcq;
        private String zzem = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzr, zza> implements zzhe {
            private zza() {
                super(zzr.zzen);
            }

            public final zza zzbi(String str) {
                zzhj();
                ((zzr) this.zzxc).zzbh(str);
                return this;
            }

            public final zza zzl(boolean z) {
                zzhj();
                ((zzr) this.zzxc).zze(z);
                return this;
            }
        }

        private zzr() {
        }

        private final void zzbh(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzem = str;
        }

        private final void zze(boolean z) {
            this.zzi |= 4;
            this.zzcq = z;
        }

        public static zza zzba() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzen.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzem", "zzcm", "zzcq", "zzap"};
                    return zzft.zza(zzen, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u0002\u0003", objArr);
                case 4:
                    return zzen;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzr.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzen);
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
            zzft.zza(zzr.class, zzen);
        }
    }

    public static final class zzs extends zzft<zzs, zza> implements zzhe {
        private static final zzs zzeo = new zzs();
        private static volatile zzhm<zzs> zzm;
        private String zzaf = "";
        private byte zzam = (byte) 2;
        private String zzaq = "";
        private String zzav = "";
        private long zzaw;
        private boolean zzax;
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzs, zza> implements zzhe {
            private zza() {
                super(zzs.zzeo);
            }
        }

        private zzs() {
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        public final boolean zzt() {
            return this.zzax;
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaf", "zzaq", "zzav", "zzaw", "zzax"};
                    return zzft.zza(zzeo, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0007\u0004", objArr);
                case 4:
                    return zzeo;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzs.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzeo);
                            zzm = obj3;
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhm<zzs> zzl() {
            return (zzhm) zzeo.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzs.class, zzeo);
        }
    }

    public static final class zzt extends zzft<zzt, zza> implements zzhe {
        private static final zzt zzeq = new zzt();
        private static volatile zzhm<zzt> zzm;
        private String zzac = "";
        private long zzad;
        private long zzap;
        private String zzaq = "";
        private String zzat = "";
        private String zzce = "";
        private String zzci = "";
        private String zzcj = "";
        private String zzcm = "";
        private boolean zzcq;
        private String zzdd = "";
        private String zzep = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzt, zza> implements zzhe {
            private zza() {
                super(zzt.zzeq);
            }

            public final zza zzbj(String str) {
                zzhj();
                ((zzt) this.zzxc).zzj(str);
                return this;
            }

            public final zza zzbk(String str) {
                zzhj();
                ((zzt) this.zzxc).setPassword(str);
                return this;
            }

            public final zza zzm(boolean z) {
                zzhj();
                ((zzt) this.zzxc).zze(z);
                return this;
            }

            public final zza zzbl(String str) {
                zzhj();
                ((zzt) this.zzxc).zzc(str);
                return this;
            }
        }

        private zzt() {
        }

        private final void zzj(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1;
            this.zzat = str;
        }

        private final void setPassword(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 2;
            this.zzce = str;
        }

        private final void zze(boolean z) {
            this.zzi |= 512;
            this.zzcq = z;
        }

        private final void zzc(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzi |= 1024;
            this.zzac = str;
        }

        public static zza zzbd() {
            return (zza) ((com.google.android.gms.internal.firebase_auth.zzft.zza) zzeq.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxj, null, null));
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzat", "zzce", "zzdd", "zzci", "zzcj", "zzep", "zzcm", "zzap", "zzaq", "zzcq", "zzac", "zzad"};
                    return zzft.zza(zzeq, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0007\t\u000b\b\n\f\u0003\u000b", objArr);
                case 4:
                    return zzeq;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzt.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzeq);
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
            zzft.zza(zzt.class, zzeq);
        }
    }

    public static final class zzu extends zzft<zzu, zza> implements zzhe {
        private static final zzu zzer = new zzu();
        private static volatile zzhm<zzu> zzm;
        private String zzaf = "";
        private boolean zzai;
        private byte zzam = (byte) 2;
        private String zzao = "";
        private String zzaq = "";
        private String zzat = "";
        private String zzav = "";
        private long zzaw;
        private String zzcd = "";
        private String zzcn = "";
        private String zzeb = "";
        private long zzed;
        private String zzee = "";
        private int zzi;

        public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzu, zza> implements zzhe {
            private zza() {
                super(zzu.zzer);
            }
        }

        private zzu() {
        }

        public final String getLocalId() {
            return this.zzao;
        }

        public final String getEmail() {
            return this.zzat;
        }

        public final String getDisplayName() {
            return this.zzcd;
        }

        public final String getIdToken() {
            return this.zzaq;
        }

        public final String zzal() {
            return this.zzcn;
        }

        public final String zzr() {
            return this.zzav;
        }

        public final long zzs() {
            return this.zzaw;
        }

        protected final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzk.zzn[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza();
                case 3:
                    Object[] objArr = new Object[]{"zzi", "zzaf", "zzao", "zzat", "zzcd", "zzaq", "zzai", "zzcn", "zzeb", "zzed", "zzee", "zzav", "zzaw"};
                    return zzft.zza(zzer, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0007\u0005\u0007\b\u0006\b\b\u0007\t\u0002\b\n\b\t\u000b\b\n\f\u0002\u000b", objArr);
                case 4:
                    return zzer;
                case 5:
                    Object obj3 = zzm;
                    if (obj3 != null) {
                        return obj3;
                    }
                    synchronized (zzu.class) {
                        obj3 = zzm;
                        if (obj3 == null) {
                            obj3 = new com.google.android.gms.internal.firebase_auth.zzft.zzb(zzer);
                            zzm = obj3;
                        }
                    }
                    return obj3;
                case 6:
                    return Byte.valueOf(this.zzam);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzam = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzhm<zzu> zzl() {
            return (zzhm) zzer.zza(com.google.android.gms.internal.firebase_auth.zzft.zze.zzxl, null, null);
        }

        static {
            zzft.zza(zzu.class, zzer);
        }
    }
}
