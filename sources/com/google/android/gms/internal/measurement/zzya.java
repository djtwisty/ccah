package com.google.android.gms.internal.measurement;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzya {
    private final ByteBuffer zzbur;
    private zztv zzcer;
    private int zzces;

    private zzya(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private zzya(ByteBuffer byteBuffer) {
        this.zzbur = byteBuffer;
        this.zzbur.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static zzya zzo(byte[] bArr) {
        return zzk(bArr, 0, bArr.length);
    }

    public static zzya zzk(byte[] bArr, int i, int i2) {
        return new zzya(bArr, 0, i2);
    }

    private final zztv zzyz() {
        if (this.zzcer == null) {
            this.zzcer = zztv.zza(this.zzbur);
            this.zzces = this.zzbur.position();
        } else if (this.zzces != this.zzbur.position()) {
            this.zzcer.write(this.zzbur.array(), this.zzces, this.zzbur.position() - this.zzces);
            this.zzces = this.zzbur.position();
        }
        return this.zzcer;
    }

    public final void zza(int i, double d) {
        zzc(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.zzbur.remaining() < 8) {
            throw new zzyb(this.zzbur.position(), this.zzbur.limit());
        }
        this.zzbur.putLong(doubleToLongBits);
    }

    public final void zza(int i, float f) {
        zzc(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zzbur.remaining() < 4) {
            throw new zzyb(this.zzbur.position(), this.zzbur.limit());
        }
        this.zzbur.putInt(floatToIntBits);
    }

    public final void zza(int i, long j) {
        zzc(i, 0);
        zzbf(j);
    }

    public final void zzi(int i, long j) {
        zzc(i, 0);
        zzbf(j);
    }

    public final void zzd(int i, int i2) {
        zzc(i, 0);
        if (i2 >= 0) {
            zzcd(i2);
        } else {
            zzbf((long) i2);
        }
    }

    public final void zzb(int i, boolean z) {
        int i2 = 0;
        zzc(i, 0);
        if (z) {
            i2 = 1;
        }
        byte b = (byte) i2;
        if (this.zzbur.hasRemaining()) {
            this.zzbur.put(b);
            return;
        }
        throw new zzyb(this.zzbur.position(), this.zzbur.limit());
    }

    public final void zzb(int i, String str) {
        zzc(i, 2);
        try {
            int zzbl = zzbl(str.length());
            if (zzbl == zzbl(str.length() * 3)) {
                int position = this.zzbur.position();
                if (this.zzbur.remaining() < zzbl) {
                    throw new zzyb(zzbl + position, this.zzbur.limit());
                }
                this.zzbur.position(position + zzbl);
                zzd((CharSequence) str, this.zzbur);
                int position2 = this.zzbur.position();
                this.zzbur.position(position);
                zzcd((position2 - position) - zzbl);
                this.zzbur.position(position2);
                return;
            }
            zzcd(zza(str));
            zzd((CharSequence) str, this.zzbur);
        } catch (Throwable e) {
            zzyb zzyb = new zzyb(this.zzbur.position(), this.zzbur.limit());
            zzyb.initCause(e);
            throw zzyb;
        }
    }

    public final void zza(int i, zzyi zzyi) {
        zzc(i, 2);
        zzb(zzyi);
    }

    public final void zze(int i, zzvv zzvv) {
        zztv zzyz = zzyz();
        zzyz.zza(i, zzvv);
        zzyz.flush();
        this.zzces = this.zzbur.position();
    }

    private static int zza(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new IllegalArgumentException("Unpaired surrogate at index " + i2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i2 = i3 + i;
                if (i2 < length) {
                    return i2;
                }
                throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
            }
        }
        i2 = i3;
        if (i2 < length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i = 0;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byte[] array = byteBuffer.array();
                r1 = byteBuffer.arrayOffset() + byteBuffer.position();
                r2 = byteBuffer.remaining();
                int length = charSequence.length();
                int i2 = r1 + r2;
                while (i < length && i + r1 < i2) {
                    r2 = charSequence.charAt(i);
                    if (r2 >= '') {
                        break;
                    }
                    array[r1 + i] = (byte) r2;
                    i++;
                }
                if (i == length) {
                    i = r1 + length;
                } else {
                    r2 = r1 + i;
                    while (i < length) {
                        char charAt = charSequence.charAt(i);
                        if (charAt < '' && r2 < i2) {
                            r1 = r2 + 1;
                            array[r2] = (byte) charAt;
                        } else if (charAt < 'ࠀ' && r2 <= i2 - 2) {
                            r7 = r2 + 1;
                            array[r2] = (byte) ((charAt >>> 6) | 960);
                            r1 = r7 + 1;
                            array[r7] = (byte) ((charAt & 63) | 128);
                        } else if ((charAt < '?' || '?' < charAt) && r2 <= i2 - 3) {
                            r1 = r2 + 1;
                            array[r2] = (byte) ((charAt >>> 12) | 480);
                            r2 = r1 + 1;
                            array[r1] = (byte) (((charAt >>> 6) & 63) | 128);
                            r1 = r2 + 1;
                            array[r2] = (byte) ((charAt & 63) | 128);
                        } else if (r2 <= i2 - 4) {
                            if (i + 1 != charSequence.length()) {
                                i++;
                                char charAt2 = charSequence.charAt(i);
                                if (Character.isSurrogatePair(charAt, charAt2)) {
                                    int toCodePoint = Character.toCodePoint(charAt, charAt2);
                                    r1 = r2 + 1;
                                    array[r2] = (byte) ((toCodePoint >>> 18) | 240);
                                    r2 = r1 + 1;
                                    array[r1] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                                    r7 = r2 + 1;
                                    array[r2] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                                    r1 = r7 + 1;
                                    array[r7] = (byte) ((toCodePoint & 63) | 128);
                                }
                            }
                            throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
                        } else {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt + " at index " + r2);
                        }
                        i++;
                        r2 = r1;
                    }
                    i = r2;
                }
                byteBuffer.position(i - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            r1 = charSequence.length();
            while (i < r1) {
                r2 = charSequence.charAt(i);
                if (r2 < '') {
                    byteBuffer.put((byte) r2);
                } else if (r2 < 'ࠀ') {
                    byteBuffer.put((byte) ((r2 >>> 6) | 960));
                    byteBuffer.put((byte) ((r2 & 63) | 128));
                } else if (r2 < '?' || '?' < r2) {
                    byteBuffer.put((byte) ((r2 >>> 12) | 480));
                    byteBuffer.put((byte) (((r2 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((r2 & 63) | 128));
                } else {
                    if (i + 1 != charSequence.length()) {
                        i++;
                        char charAt3 = charSequence.charAt(i);
                        if (Character.isSurrogatePair(r2, charAt3)) {
                            r2 = Character.toCodePoint(r2, charAt3);
                            byteBuffer.put((byte) ((r2 >>> 18) | 240));
                            byteBuffer.put((byte) (((r2 >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((r2 >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((r2 & 63) | 128));
                        }
                    }
                    throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
                }
                i++;
            }
        }
    }

    public final void zzb(zzyi zzyi) {
        zzcd(zzyi.zzzh());
        zzyi.zza(this);
    }

    public static int zzd(int i, long j) {
        return zzbd(i) + zzbg(j);
    }

    public static int zzh(int i, int i2) {
        return zzbd(i) + zzbe(i2);
    }

    public static int zzc(int i, String str) {
        return zzbd(i) + zzgc(str);
    }

    public static int zzb(int i, zzyi zzyi) {
        int zzbd = zzbd(i);
        int zzvx = zzyi.zzvx();
        return zzbd + (zzvx + zzbl(zzvx));
    }

    public static int zzbe(int i) {
        if (i >= 0) {
            return zzbl(i);
        }
        return 10;
    }

    public static int zzgc(String str) {
        int zza = zza(str);
        return zza + zzbl(zza);
    }

    public final void zzza() {
        if (this.zzbur.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzbur.remaining())}));
        }
    }

    private final void zzcc(int i) {
        byte b = (byte) i;
        if (this.zzbur.hasRemaining()) {
            this.zzbur.put(b);
            return;
        }
        throw new zzyb(this.zzbur.position(), this.zzbur.limit());
    }

    public final void zzp(byte[] bArr) {
        int length = bArr.length;
        if (this.zzbur.remaining() >= length) {
            this.zzbur.put(bArr, 0, length);
            return;
        }
        throw new zzyb(this.zzbur.position(), this.zzbur.limit());
    }

    public final void zzc(int i, int i2) {
        zzcd((i << 3) | i2);
    }

    public static int zzbd(int i) {
        return zzbl(i << 3);
    }

    public final void zzcd(int i) {
        while ((i & -128) != 0) {
            zzcc((i & 127) | 128);
            i >>>= 7;
        }
        zzcc(i);
    }

    public static int zzbl(int i) {
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

    private final void zzbf(long j) {
        while ((-128 & j) != 0) {
            zzcc((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzcc((int) j);
    }

    public static int zzbg(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }
}
