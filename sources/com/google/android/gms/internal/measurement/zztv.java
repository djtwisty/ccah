package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zztv extends zztd {
    private static final Logger logger = Logger.getLogger(zztv.class.getName());
    private static final boolean zzbum = zzxj.zzyo();
    zztx zzbun = this;

    static class zza extends zztv {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if (((i | i2) | (bArr.length - (i + i2))) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            } else {
                this.buffer = bArr;
                this.offset = i;
                this.position = i;
                this.limit = i + i2;
            }
        }

        public final void zzc(int i, int i2) {
            zzba((i << 3) | i2);
        }

        public final void zzd(int i, int i2) {
            zzc(i, 0);
            zzaz(i2);
        }

        public final void zze(int i, int i2) {
            zzc(i, 0);
            zzba(i2);
        }

        public final void zzg(int i, int i2) {
            zzc(i, 5);
            zzbc(i2);
        }

        public final void zza(int i, long j) {
            zzc(i, 0);
            zzat(j);
        }

        public final void zzc(int i, long j) {
            zzc(i, 1);
            zzav(j);
        }

        public final void zzb(int i, boolean z) {
            int i2 = 0;
            zzc(i, 0);
            if (z) {
                i2 = 1;
            }
            zzc((byte) i2);
        }

        public final void zzb(int i, String str) {
            zzc(i, 2);
            zzgb(str);
        }

        public final void zza(int i, zzte zzte) {
            zzc(i, 2);
            zza(zzte);
        }

        public final void zza(zzte zzte) {
            zzba(zzte.size());
            zzte.zza((zztd) this);
        }

        public final void zze(byte[] bArr, int i, int i2) {
            zzba(i2);
            write(bArr, 0, i2);
        }

        public final void zza(int i, zzvv zzvv) {
            zzc(i, 2);
            zzb(zzvv);
        }

        final void zza(int i, zzvv zzvv, zzwl zzwl) {
            zzc(i, 2);
            zzsx zzsx = (zzsx) zzvv;
            int zztx = zzsx.zztx();
            if (zztx == -1) {
                zztx = zzwl.zzai(zzsx);
                zzsx.zzai(zztx);
            }
            zzba(zztx);
            zzwl.zza(zzvv, this.zzbun);
        }

        public final void zzb(int i, zzvv zzvv) {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvv);
            zzc(1, 4);
        }

        public final void zzb(int i, zzte zzte) {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzte);
            zzc(1, 4);
        }

        public final void zzb(zzvv zzvv) {
            zzba(zzvv.zzvx());
            zzvv.zzb(this);
        }

        final void zza(zzvv zzvv, zzwl zzwl) {
            zzsx zzsx = (zzsx) zzvv;
            int zztx = zzsx.zztx();
            if (zztx == -1) {
                zztx = zzwl.zzai(zzsx);
                zzsx.zzai(zztx);
            }
            zzba(zztx);
            zzwl.zza(zzvv, this.zzbun);
        }

        public final void zzc(byte b) {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzaz(int i) {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat((long) i);
            }
        }

        public final void zzba(int i) {
            byte[] bArr;
            int i2;
            if (!zztv.zzbum || zzvj() < 10) {
                while ((i & -128) != 0) {
                    try {
                        bArr = this.buffer;
                        i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (Throwable e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
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
                zzxj.zza(bArr, (long) i2, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            bArr = this.buffer;
            i2 = this.position;
            this.position = i2 + 1;
            zzxj.zza(bArr, (long) i2, (byte) i);
        }

        public final void zzbc(int i) {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzat(long j) {
            byte[] bArr;
            int i;
            if (!zztv.zzbum || zzvj() < 10) {
                while ((j & -128) != 0) {
                    try {
                        bArr = this.buffer;
                        i = this.position;
                        this.position = i + 1;
                        bArr[i] = (byte) ((((int) j) & 127) | 128);
                        j >>>= 7;
                    } catch (Throwable e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
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
                zzxj.zza(bArr, (long) i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            bArr = this.buffer;
            i = this.position;
            this.position = i + 1;
            zzxj.zza(bArr, (long) i, (byte) ((int) j));
        }

        public final void zzav(long j) {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public final void zzgb(String str) {
            int i = this.position;
            try {
                int zzbf = zztv.zzbf(str.length() * 3);
                int zzbf2 = zztv.zzbf(str.length());
                if (zzbf2 == zzbf) {
                    this.position = i + zzbf2;
                    zzbf = zzxl.zza(str, this.buffer, this.position, zzvj());
                    this.position = i;
                    zzba((zzbf - i) - zzbf2);
                    this.position = zzbf;
                    return;
                }
                zzba(zzxl.zza(str));
                this.position = zzxl.zza(str, this.buffer, this.position, zzvj());
            } catch (zzxp e) {
                this.position = i;
                zza(str, e);
            } catch (Throwable e2) {
                throw new zzc(e2);
            }
        }

        public void flush() {
        }

        public final int zzvj() {
            return this.limit - this.position;
        }

        public final int zzvl() {
            return this.position - this.offset;
        }
    }

    static final class zzb extends zza {
        private final ByteBuffer zzbuo;
        private int zzbup;

        zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzbuo = byteBuffer;
            this.zzbup = byteBuffer.position();
        }

        public final void flush() {
            this.zzbuo.position(this.zzbup + zzvl());
        }
    }

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzc(String str) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzc(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), th);
        }
    }

    static final class zzd extends zztv {
        private final int zzbup;
        private final ByteBuffer zzbuq;
        private final ByteBuffer zzbur;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zzbuq = byteBuffer;
            this.zzbur = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzbup = byteBuffer.position();
        }

        public final void zzc(int i, int i2) {
            zzba((i << 3) | i2);
        }

        public final void zzd(int i, int i2) {
            zzc(i, 0);
            zzaz(i2);
        }

        public final void zze(int i, int i2) {
            zzc(i, 0);
            zzba(i2);
        }

        public final void zzg(int i, int i2) {
            zzc(i, 5);
            zzbc(i2);
        }

        public final void zza(int i, long j) {
            zzc(i, 0);
            zzat(j);
        }

        public final void zzc(int i, long j) {
            zzc(i, 1);
            zzav(j);
        }

        public final void zzb(int i, boolean z) {
            int i2 = 0;
            zzc(i, 0);
            if (z) {
                i2 = 1;
            }
            zzc((byte) i2);
        }

        public final void zzb(int i, String str) {
            zzc(i, 2);
            zzgb(str);
        }

        public final void zza(int i, zzte zzte) {
            zzc(i, 2);
            zza(zzte);
        }

        public final void zza(int i, zzvv zzvv) {
            zzc(i, 2);
            zzb(zzvv);
        }

        final void zza(int i, zzvv zzvv, zzwl zzwl) {
            zzc(i, 2);
            zza(zzvv, zzwl);
        }

        public final void zzb(int i, zzvv zzvv) {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvv);
            zzc(1, 4);
        }

        public final void zzb(int i, zzte zzte) {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzte);
            zzc(1, 4);
        }

        public final void zzb(zzvv zzvv) {
            zzba(zzvv.zzvx());
            zzvv.zzb(this);
        }

        final void zza(zzvv zzvv, zzwl zzwl) {
            zzsx zzsx = (zzsx) zzvv;
            int zztx = zzsx.zztx();
            if (zztx == -1) {
                zztx = zzwl.zzai(zzsx);
                zzsx.zzai(zztx);
            }
            zzba(zztx);
            zzwl.zza(zzvv, this.zzbun);
        }

        public final void zzc(byte b) {
            try {
                this.zzbur.put(b);
            } catch (Throwable e) {
                throw new zzc(e);
            }
        }

        public final void zza(zzte zzte) {
            zzba(zzte.size());
            zzte.zza((zztd) this);
        }

        public final void zze(byte[] bArr, int i, int i2) {
            zzba(i2);
            write(bArr, 0, i2);
        }

        public final void zzaz(int i) {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat((long) i);
            }
        }

        public final void zzba(int i) {
            while ((i & -128) != 0) {
                this.zzbur.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.zzbur.put((byte) i);
            } catch (Throwable e) {
                throw new zzc(e);
            }
        }

        public final void zzbc(int i) {
            try {
                this.zzbur.putInt(i);
            } catch (Throwable e) {
                throw new zzc(e);
            }
        }

        public final void zzat(long j) {
            while ((-128 & j) != 0) {
                this.zzbur.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.zzbur.put((byte) ((int) j));
            } catch (Throwable e) {
                throw new zzc(e);
            }
        }

        public final void zzav(long j) {
            try {
                this.zzbur.putLong(j);
            } catch (Throwable e) {
                throw new zzc(e);
            }
        }

        public final void write(byte[] bArr, int i, int i2) {
            try {
                this.zzbur.put(bArr, i, i2);
            } catch (Throwable e) {
                throw new zzc(e);
            } catch (Throwable e2) {
                throw new zzc(e2);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public final void zzgb(String str) {
            int position = this.zzbur.position();
            try {
                int zzbf = zztv.zzbf(str.length() * 3);
                int zzbf2 = zztv.zzbf(str.length());
                if (zzbf2 == zzbf) {
                    zzbf = this.zzbur.position() + zzbf2;
                    this.zzbur.position(zzbf);
                    zzgd(str);
                    zzbf2 = this.zzbur.position();
                    this.zzbur.position(position);
                    zzba(zzbf2 - zzbf);
                    this.zzbur.position(zzbf2);
                    return;
                }
                zzba(zzxl.zza(str));
                zzgd(str);
            } catch (zzxp e) {
                this.zzbur.position(position);
                zza(str, e);
            } catch (Throwable e2) {
                throw new zzc(e2);
            }
        }

        public final void flush() {
            this.zzbuq.position(this.zzbur.position());
        }

        public final int zzvj() {
            return this.zzbur.remaining();
        }

        private final void zzgd(String str) {
            try {
                zzxl.zza(str, this.zzbur);
            } catch (Throwable e) {
                throw new zzc(e);
            }
        }
    }

    static final class zze extends zztv {
        private final ByteBuffer zzbuq;
        private final ByteBuffer zzbur;
        private final long zzbus;
        private final long zzbut;
        private final long zzbuu;
        private final long zzbuv = (this.zzbuu - 10);
        private long zzbuw = this.zzbut;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzbuq = byteBuffer;
            this.zzbur = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzbus = zzxj.zzb(byteBuffer);
            this.zzbut = this.zzbus + ((long) byteBuffer.position());
            this.zzbuu = this.zzbus + ((long) byteBuffer.limit());
        }

        public final void zzc(int i, int i2) {
            zzba((i << 3) | i2);
        }

        public final void zzd(int i, int i2) {
            zzc(i, 0);
            zzaz(i2);
        }

        public final void zze(int i, int i2) {
            zzc(i, 0);
            zzba(i2);
        }

        public final void zzg(int i, int i2) {
            zzc(i, 5);
            zzbc(i2);
        }

        public final void zza(int i, long j) {
            zzc(i, 0);
            zzat(j);
        }

        public final void zzc(int i, long j) {
            zzc(i, 1);
            zzav(j);
        }

        public final void zzb(int i, boolean z) {
            int i2 = 0;
            zzc(i, 0);
            if (z) {
                i2 = 1;
            }
            zzc((byte) i2);
        }

        public final void zzb(int i, String str) {
            zzc(i, 2);
            zzgb(str);
        }

        public final void zza(int i, zzte zzte) {
            zzc(i, 2);
            zza(zzte);
        }

        public final void zza(int i, zzvv zzvv) {
            zzc(i, 2);
            zzb(zzvv);
        }

        final void zza(int i, zzvv zzvv, zzwl zzwl) {
            zzc(i, 2);
            zza(zzvv, zzwl);
        }

        public final void zzb(int i, zzvv zzvv) {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzvv);
            zzc(1, 4);
        }

        public final void zzb(int i, zzte zzte) {
            zzc(1, 3);
            zze(2, i);
            zza(3, zzte);
            zzc(1, 4);
        }

        public final void zzb(zzvv zzvv) {
            zzba(zzvv.zzvx());
            zzvv.zzb(this);
        }

        final void zza(zzvv zzvv, zzwl zzwl) {
            zzsx zzsx = (zzsx) zzvv;
            int zztx = zzsx.zztx();
            if (zztx == -1) {
                zztx = zzwl.zzai(zzsx);
                zzsx.zzai(zztx);
            }
            zzba(zztx);
            zzwl.zza(zzvv, this.zzbun);
        }

        public final void zzc(byte b) {
            if (this.zzbuw >= this.zzbuu) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzbuw), Long.valueOf(this.zzbuu), Integer.valueOf(1)}));
            }
            long j = this.zzbuw;
            this.zzbuw = 1 + j;
            zzxj.zza(j, b);
        }

        public final void zza(zzte zzte) {
            zzba(zzte.size());
            zzte.zza((zztd) this);
        }

        public final void zze(byte[] bArr, int i, int i2) {
            zzba(i2);
            write(bArr, 0, i2);
        }

        public final void zzaz(int i) {
            if (i >= 0) {
                zzba(i);
            } else {
                zzat((long) i);
            }
        }

        public final void zzba(int i) {
            long j;
            if (this.zzbuw <= this.zzbuv) {
                while ((i & -128) != 0) {
                    j = this.zzbuw;
                    this.zzbuw = j + 1;
                    zzxj.zza(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                j = this.zzbuw;
                this.zzbuw = j + 1;
                zzxj.zza(j, (byte) i);
                return;
            }
            while (this.zzbuw < this.zzbuu) {
                if ((i & -128) == 0) {
                    j = this.zzbuw;
                    this.zzbuw = j + 1;
                    zzxj.zza(j, (byte) i);
                    return;
                }
                j = this.zzbuw;
                this.zzbuw = j + 1;
                zzxj.zza(j, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzbuw), Long.valueOf(this.zzbuu), Integer.valueOf(1)}));
        }

        public final void zzbc(int i) {
            this.zzbur.putInt((int) (this.zzbuw - this.zzbus), i);
            this.zzbuw += 4;
        }

        public final void zzat(long j) {
            long j2;
            if (this.zzbuw <= this.zzbuv) {
                while ((j & -128) != 0) {
                    j2 = this.zzbuw;
                    this.zzbuw = j2 + 1;
                    zzxj.zza(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                j2 = this.zzbuw;
                this.zzbuw = j2 + 1;
                zzxj.zza(j2, (byte) ((int) j));
                return;
            }
            while (this.zzbuw < this.zzbuu) {
                if ((j & -128) == 0) {
                    j2 = this.zzbuw;
                    this.zzbuw = j2 + 1;
                    zzxj.zza(j2, (byte) ((int) j));
                    return;
                }
                j2 = this.zzbuw;
                this.zzbuw = j2 + 1;
                zzxj.zza(j2, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzbuw), Long.valueOf(this.zzbuu), Integer.valueOf(1)}));
        }

        public final void zzav(long j) {
            this.zzbur.putLong((int) (this.zzbuw - this.zzbus), j);
            this.zzbuw += 8;
        }

        public final void write(byte[] bArr, int i, int i2) {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i && this.zzbuu - ((long) i2) >= this.zzbuw) {
                zzxj.zza(bArr, (long) i, this.zzbuw, (long) i2);
                this.zzbuw += (long) i2;
            } else if (bArr == null) {
                throw new NullPointerException(Param.VALUE);
            } else {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zzbuw), Long.valueOf(this.zzbuu), Integer.valueOf(i2)}));
            }
        }

        public final void zza(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }

        public final void zzgb(String str) {
            long j = this.zzbuw;
            try {
                int zzbf = zztv.zzbf(str.length() * 3);
                int zzbf2 = zztv.zzbf(str.length());
                if (zzbf2 == zzbf) {
                    zzbf = ((int) (this.zzbuw - this.zzbus)) + zzbf2;
                    this.zzbur.position(zzbf);
                    zzxl.zza(str, this.zzbur);
                    zzbf = this.zzbur.position() - zzbf;
                    zzba(zzbf);
                    this.zzbuw = ((long) zzbf) + this.zzbuw;
                    return;
                }
                zzbf = zzxl.zza(str);
                zzba(zzbf);
                zzbc(this.zzbuw);
                zzxl.zza(str, this.zzbur);
                this.zzbuw = ((long) zzbf) + this.zzbuw;
            } catch (zzxp e) {
                this.zzbuw = j;
                zzbc(this.zzbuw);
                zza(str, e);
            } catch (Throwable e2) {
                throw new zzc(e2);
            } catch (Throwable e22) {
                throw new zzc(e22);
            }
        }

        public final void flush() {
            this.zzbuq.position((int) (this.zzbuw - this.zzbus));
        }

        public final int zzvj() {
            return (int) (this.zzbuu - this.zzbuw);
        }

        private final void zzbc(long j) {
            this.zzbur.position((int) (j - this.zzbus));
        }
    }

    public static zztv zzj(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public abstract void flush();

    public abstract void write(byte[] bArr, int i, int i2);

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzte zzte);

    public abstract void zza(int i, zzvv zzvv);

    abstract void zza(int i, zzvv zzvv, zzwl zzwl);

    public abstract void zza(zzte zzte);

    abstract void zza(zzvv zzvv, zzwl zzwl);

    public abstract void zzat(long j);

    public abstract void zzav(long j);

    public abstract void zzaz(int i);

    public abstract void zzb(int i, zzte zzte);

    public abstract void zzb(int i, zzvv zzvv);

    public abstract void zzb(int i, String str);

    public abstract void zzb(int i, boolean z);

    public abstract void zzb(zzvv zzvv);

    public abstract void zzba(int i);

    public abstract void zzbc(int i);

    public abstract void zzc(byte b);

    public abstract void zzc(int i, int i2);

    public abstract void zzc(int i, long j);

    public abstract void zzd(int i, int i2);

    public abstract void zze(int i, int i2);

    abstract void zze(byte[] bArr, int i, int i2);

    public abstract void zzg(int i, int i2);

    public abstract void zzgb(String str);

    public abstract int zzvj();

    public static zztv zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (zzxj.zzyp()) {
            return new zze(byteBuffer);
        } else {
            return new zzd(byteBuffer);
        }
    }

    private zztv() {
    }

    public final void zzf(int i, int i2) {
        zze(i, zzbk(i2));
    }

    public final void zzb(int i, long j) {
        zza(i, zzbb(j));
    }

    public final void zza(int i, float f) {
        zzg(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzbb(int i) {
        zzba(zzbk(i));
    }

    public final void zzau(long j) {
        zzat(zzbb(j));
    }

    public final void zza(float f) {
        zzbc(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d) {
        zzav(Double.doubleToRawLongBits(d));
    }

    public final void zzs(boolean z) {
        zzc((byte) (z ? 1 : 0));
    }

    public static int zzh(int i, int i2) {
        return zzbd(i) + zzbe(i2);
    }

    public static int zzi(int i, int i2) {
        return zzbd(i) + zzbf(i2);
    }

    public static int zzj(int i, int i2) {
        return zzbd(i) + zzbf(zzbk(i2));
    }

    public static int zzk(int i, int i2) {
        return zzbd(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzbd(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzbd(i) + zzax(j);
    }

    public static int zze(int i, long j) {
        return zzbd(i) + zzax(j);
    }

    public static int zzf(int i, long j) {
        return zzbd(i) + zzax(zzbb(j));
    }

    public static int zzg(int i, long j) {
        return zzbd(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzbd(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzbd(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzbd(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzbd(i) + 1;
    }

    public static int zzm(int i, int i2) {
        return zzbd(i) + zzbe(i2);
    }

    public static int zzc(int i, String str) {
        return zzbd(i) + zzgc(str);
    }

    public static int zzc(int i, zzte zzte) {
        int zzbd = zzbd(i);
        int size = zzte.size();
        return zzbd + (size + zzbf(size));
    }

    public static int zza(int i, zzvc zzvc) {
        int zzbd = zzbd(i);
        int zzvx = zzvc.zzvx();
        return zzbd + (zzvx + zzbf(zzvx));
    }

    public static int zzc(int i, zzvv zzvv) {
        return zzbd(i) + zzc(zzvv);
    }

    static int zzb(int i, zzvv zzvv, zzwl zzwl) {
        return zzbd(i) + zzb(zzvv, zzwl);
    }

    public static int zzd(int i, zzvv zzvv) {
        return ((zzbd(1) << 1) + zzi(2, i)) + zzc(3, zzvv);
    }

    public static int zzd(int i, zzte zzte) {
        return ((zzbd(1) << 1) + zzi(2, i)) + zzc(3, zzte);
    }

    public static int zzb(int i, zzvc zzvc) {
        return ((zzbd(1) << 1) + zzi(2, i)) + zza(3, zzvc);
    }

    public static int zzbd(int i) {
        return zzbf(i << 3);
    }

    public static int zzbe(int i) {
        if (i >= 0) {
            return zzbf(i);
        }
        return 10;
    }

    public static int zzbf(int i) {
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

    public static int zzbg(int i) {
        return zzbf(zzbk(i));
    }

    public static int zzbh(int i) {
        return 4;
    }

    public static int zzbi(int i) {
        return 4;
    }

    public static int zzaw(long j) {
        return zzax(j);
    }

    public static int zzax(long j) {
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

    public static int zzay(long j) {
        return zzax(zzbb(j));
    }

    public static int zzaz(long j) {
        return 8;
    }

    public static int zzba(long j) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzt(boolean z) {
        return 1;
    }

    public static int zzbj(int i) {
        return zzbe(i);
    }

    public static int zzgc(String str) {
        int zza;
        try {
            zza = zzxl.zza(str);
        } catch (zzxp e) {
            zza = str.getBytes(zzuq.UTF_8).length;
        }
        return zza + zzbf(zza);
    }

    public static int zza(zzvc zzvc) {
        int zzvx = zzvc.zzvx();
        return zzvx + zzbf(zzvx);
    }

    public static int zzb(zzte zzte) {
        int size = zzte.size();
        return size + zzbf(size);
    }

    public static int zzk(byte[] bArr) {
        int length = bArr.length;
        return length + zzbf(length);
    }

    public static int zzc(zzvv zzvv) {
        int zzvx = zzvv.zzvx();
        return zzvx + zzbf(zzvx);
    }

    static int zzb(zzvv zzvv, zzwl zzwl) {
        zzsx zzsx = (zzsx) zzvv;
        int zztx = zzsx.zztx();
        if (zztx == -1) {
            zztx = zzwl.zzai(zzsx);
            zzsx.zzai(zztx);
        }
        return zztx + zzbf(zztx);
    }

    private static int zzbk(int i) {
        return (i << 1) ^ (i >> 31);
    }

    private static long zzbb(long j) {
        return (j << 1) ^ (j >> 63);
    }

    final void zza(String str, zzxp zzxp) {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzxp);
        byte[] bytes = str.getBytes(zzuq.UTF_8);
        try {
            zzba(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (Throwable e) {
            throw new zzc(e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzvv zzvv, zzwl zzwl) {
        int zzbd = zzbd(i) << 1;
        zzsx zzsx = (zzsx) zzvv;
        int zztx = zzsx.zztx();
        if (zztx == -1) {
            zztx = zzwl.zzai(zzsx);
            zzsx.zzai(zztx);
        }
        return zztx + zzbd;
    }

    @Deprecated
    public static int zzd(zzvv zzvv) {
        return zzvv.zzvx();
    }

    @Deprecated
    public static int zzbl(int i) {
        return zzbf(i);
    }
}
