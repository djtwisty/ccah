package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzfa extends zzeg {
    private static final Logger logger = Logger.getLogger(zzfa.class.getName());
    private static final boolean zztp = zziw.zzjs();
    zzfc zztq = this;

    static class zza extends zzfa {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if (((i2 | 0) | (bArr.length - (i2 + 0))) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i2)}));
            } else {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i2 + 0;
            }
        }

        public final void zzf(int i, int i2) {
            zzad((i << 3) | i2);
        }

        public final void zzg(int i, int i2) {
            zzf(i, 0);
            zzac(i2);
        }

        public final void zzh(int i, int i2) {
            zzf(i, 0);
            zzad(i2);
        }

        public final void zzj(int i, int i2) {
            zzf(i, 5);
            zzaf(i2);
        }

        public final void zza(int i, long j) {
            zzf(i, 0);
            zzb(j);
        }

        public final void zzc(int i, long j) {
            zzf(i, 1);
            zzd(j);
        }

        public final void zzb(int i, boolean z) {
            int i2 = 0;
            zzf(i, 0);
            if (z) {
                i2 = 1;
            }
            zzc((byte) i2);
        }

        public final void zza(int i, String str) {
            zzf(i, 2);
            zzda(str);
        }

        public final void zza(int i, zzeh zzeh) {
            zzf(i, 2);
            zza(zzeh);
        }

        public final void zza(zzeh zzeh) {
            zzad(zzeh.size());
            zzeh.zza((zzeg) this);
        }

        public final void zzd(byte[] bArr, int i, int i2) {
            zzad(i2);
            write(bArr, 0, i2);
        }

        final void zza(int i, zzhc zzhc, zzhw zzhw) {
            zzf(i, 2);
            zzdz zzdz = (zzdz) zzhc;
            int zzes = zzdz.zzes();
            if (zzes == -1) {
                zzes = zzhw.zzp(zzdz);
                zzdz.zzg(zzes);
            }
            zzad(zzes);
            zzhw.zza(zzhc, this.zztq);
        }

        public final void zza(int i, zzhc zzhc) {
            zzf(1, 3);
            zzh(2, i);
            zzf(3, 2);
            zzc(zzhc);
            zzf(1, 4);
        }

        public final void zzb(int i, zzeh zzeh) {
            zzf(1, 3);
            zzh(2, i);
            zza(3, zzeh);
            zzf(1, 4);
        }

        public final void zzc(zzhc zzhc) {
            zzad(zzhc.zzgw());
            zzhc.zzb(this);
        }

        public final void zzc(byte b) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (Throwable e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzac(int i) {
            if (i >= 0) {
                zzad(i);
            } else {
                zzb((long) i);
            }
        }

        public final void zzad(int i) {
            byte[] bArr;
            int i2;
            if (!zzfa.zztp || zzgi() < 10) {
                while ((i & -128) != 0) {
                    try {
                        bArr = this.buffer;
                        i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (Throwable e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                    }
                }
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                return;
            }
            while ((i & -128) != 0) {
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                zziw.zza(bArr, (long) i2, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            zziw.zza(bArr, (long) i2, (byte) i);
        }

        public final void zzaf(int i) {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (i >> 8);
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (i >> 16);
                bArr = this.buffer;
                i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) (i >>> 24);
            } catch (Throwable e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzb(long j) {
            byte[] bArr;
            int i;
            if (!zzfa.zztp || zzgi() < 10) {
                while ((j & -128) != 0) {
                    try {
                        bArr = this.buffer;
                        i = this.position;
                        this.position = i + 1;
                        bArr[i] = (byte) ((((int) j) & 127) | 128);
                        j >>>= 7;
                    } catch (Throwable e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                    }
                }
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                return;
            }
            while ((j & -128) != 0) {
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                zziw.zza(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            zziw.zza(bArr, (long) i, (byte) ((int) j));
        }

        public final void zzd(long j) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 8));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 16));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 24));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 32));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 40));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 48));
                bArr = this.buffer;
                i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) (j >> 56));
            } catch (Throwable e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (Throwable e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public final void zzda(String str) {
            int i = this.position;
            try {
                int zzai = zzfa.zzai(str.length() * 3);
                int zzai2 = zzfa.zzai(str.length());
                if (zzai2 == zzai) {
                    this.position = i + zzai2;
                    zzai = zziy.zza(str, this.buffer, this.position, zzgi());
                    this.position = i;
                    zzad((zzai - i) - zzai2);
                    this.position = zzai;
                    return;
                }
                zzad(zziy.zza(str));
                this.position = zziy.zza(str, this.buffer, this.position, zzgi());
            } catch (zzjc e) {
                this.position = i;
                zza(str, e);
            } catch (Throwable e2) {
                throw new zzb(e2);
            }
        }

        public final int zzgi() {
            return this.limit - this.position;
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzb(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), th);
        }
    }

    public static zzfa zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzeh zzeh);

    public abstract void zza(int i, zzhc zzhc);

    abstract void zza(int i, zzhc zzhc, zzhw zzhw);

    public abstract void zza(int i, String str);

    public abstract void zza(zzeh zzeh);

    public abstract void zzac(int i);

    public abstract void zzad(int i);

    public abstract void zzaf(int i);

    public abstract void zzb(int i, zzeh zzeh);

    public abstract void zzb(int i, boolean z);

    public abstract void zzb(long j);

    public abstract void zzc(byte b);

    public abstract void zzc(int i, long j);

    public abstract void zzc(zzhc zzhc);

    public abstract void zzd(long j);

    abstract void zzd(byte[] bArr, int i, int i2);

    public abstract void zzda(String str);

    public abstract void zzf(int i, int i2);

    public abstract void zzg(int i, int i2);

    public abstract int zzgi();

    public abstract void zzh(int i, int i2);

    public abstract void zzj(int i, int i2);

    private zzfa() {
    }

    public final void zzi(int i, int i2) {
        zzh(i, zzan(i2));
    }

    public final void zzb(int i, long j) {
        zza(i, zzj(j));
    }

    public final void zza(int i, float f) {
        zzj(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzae(int i) {
        zzad(zzan(i));
    }

    public final void zzc(long j) {
        zzb(zzj(j));
    }

    public final void zza(float f) {
        zzaf(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) {
        zzd(Double.doubleToRawLongBits(d));
    }

    public final void zzs(boolean z) {
        zzc((byte) (z ? 1 : 0));
    }

    public static int zzk(int i, int i2) {
        return zzag(i) + zzah(i2);
    }

    public static int zzl(int i, int i2) {
        return zzag(i) + zzai(i2);
    }

    public static int zzm(int i, int i2) {
        return zzag(i) + zzai(zzan(i2));
    }

    public static int zzn(int i, int i2) {
        return zzag(i) + 4;
    }

    public static int zzo(int i, int i2) {
        return zzag(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzag(i) + zzf(j);
    }

    public static int zze(int i, long j) {
        return zzag(i) + zzf(j);
    }

    public static int zzf(int i, long j) {
        return zzag(i) + zzf(zzj(j));
    }

    public static int zzg(int i, long j) {
        return zzag(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzag(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzag(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzag(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzag(i) + 1;
    }

    public static int zzp(int i, int i2) {
        return zzag(i) + zzah(i2);
    }

    public static int zzb(int i, String str) {
        return zzag(i) + zzdb(str);
    }

    public static int zzc(int i, zzeh zzeh) {
        int zzag = zzag(i);
        int size = zzeh.size();
        return zzag + (size + zzai(size));
    }

    public static int zza(int i, zzgj zzgj) {
        int zzag = zzag(i);
        int zzgw = zzgj.zzgw();
        return zzag + (zzgw + zzai(zzgw));
    }

    static int zzb(int i, zzhc zzhc, zzhw zzhw) {
        return zzag(i) + zza(zzhc, zzhw);
    }

    public static int zzb(int i, zzhc zzhc) {
        return ((zzag(1) << 1) + zzl(2, i)) + (zzag(3) + zzd(zzhc));
    }

    public static int zzd(int i, zzeh zzeh) {
        return ((zzag(1) << 1) + zzl(2, i)) + zzc(3, zzeh);
    }

    public static int zzb(int i, zzgj zzgj) {
        return ((zzag(1) << 1) + zzl(2, i)) + zza(3, zzgj);
    }

    public static int zzag(int i) {
        return zzai(i << 3);
    }

    public static int zzah(int i) {
        if (i >= 0) {
            return zzai(i);
        }
        return 10;
    }

    public static int zzai(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public static int zzaj(int i) {
        return zzai(zzan(i));
    }

    public static int zzak(int i) {
        return 4;
    }

    public static int zzal(int i) {
        return 4;
    }

    public static int zze(long j) {
        return zzf(j);
    }

    public static int zzf(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        long j2;
        int i = 2;
        if ((-34359738368L & j) != 0) {
            i = 6;
            j2 = j >>> 28;
        } else {
            j2 = j;
        }
        if ((-2097152 & j2) != 0) {
            i += 2;
            j2 >>>= 14;
        }
        if ((j2 & -16384) != 0) {
            return i + 1;
        }
        return i;
    }

    public static int zzg(long j) {
        return zzf(zzj(j));
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(long j) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzt(boolean z) {
        return 1;
    }

    public static int zzam(int i) {
        return zzah(i);
    }

    public static int zzdb(String str) {
        int zza;
        try {
            zza = zziy.zza(str);
        } catch (zzjc e) {
            zza = str.getBytes(zzfv.UTF_8).length;
        }
        return zza + zzai(zza);
    }

    public static int zza(zzgj zzgj) {
        int zzgw = zzgj.zzgw();
        return zzgw + zzai(zzgw);
    }

    public static int zzb(zzeh zzeh) {
        int size = zzeh.size();
        return size + zzai(size);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return length + zzai(length);
    }

    public static int zzd(zzhc zzhc) {
        int zzgw = zzhc.zzgw();
        return zzgw + zzai(zzgw);
    }

    static int zza(zzhc zzhc, zzhw zzhw) {
        zzdz zzdz = (zzdz) zzhc;
        int zzes = zzdz.zzes();
        if (zzes == -1) {
            zzes = zzhw.zzp(zzdz);
            zzdz.zzg(zzes);
        }
        return zzes + zzai(zzes);
    }

    private static int zzan(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private static long zzj(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public final void zzgj() {
        if (zzgi() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zza(String str, zzjc zzjc) {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzjc);
        byte[] bytes = str.getBytes(zzfv.UTF_8);
        try {
            zzad(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (Throwable e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzhc zzhc, zzhw zzhw) {
        int zzag = zzag(i) << 1;
        zzdz zzdz = (zzdz) zzhc;
        int zzes = zzdz.zzes();
        if (zzes == -1) {
            zzes = zzhw.zzp(zzdz);
            zzdz.zzg(zzes);
        }
        return zzes + zzag;
    }

    @Deprecated
    public static int zze(zzhc zzhc) {
        return zzhc.zzgw();
    }

    @Deprecated
    public static int zzao(int i) {
        return zzai(i);
    }
}
