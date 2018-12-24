package com.google.android.gms.internal.config;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzaz {
    private final ByteBuffer zzcg;

    private zzaz(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private zzaz(ByteBuffer byteBuffer) {
        this.zzcg = byteBuffer;
        this.zzcg.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static zzaz zza(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static zzaz zzb(byte[] bArr, int i, int i2) {
        return new zzaz(bArr, 0, i2);
    }

    public final void zzc(int i, int i2) {
        zze(1, 0);
        if (i2 >= 0) {
            zzm(i2);
            return;
        }
        long j = (long) i2;
        while ((-128 & j) != 0) {
            byte b = (byte) ((((int) j) & 127) | 128);
            if (this.zzcg.hasRemaining()) {
                this.zzcg.put(b);
                j >>>= 7;
            } else {
                throw new zzba(this.zzcg.position(), this.zzcg.limit());
            }
        }
        byte b2 = (byte) ((int) j);
        if (this.zzcg.hasRemaining()) {
            this.zzcg.put(b2);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }

    public final void zza(int i, long j) {
        zze(i, 1);
        if (this.zzcg.remaining() < 8) {
            throw new zzba(this.zzcg.position(), this.zzcg.limit());
        }
        this.zzcg.putLong(j);
    }

    public final void zza(int i, String str) {
        zze(i, 2);
        try {
            int zzn = zzn(str.length());
            if (zzn == zzn(str.length() * 3)) {
                int position = this.zzcg.position();
                if (this.zzcg.remaining() < zzn) {
                    throw new zzba(zzn + position, this.zzcg.limit());
                }
                this.zzcg.position(position + zzn);
                zza((CharSequence) str, this.zzcg);
                int position2 = this.zzcg.position();
                this.zzcg.position(position);
                zzm((position2 - position) - zzn);
                this.zzcg.position(position2);
                return;
            }
            zzm(zza((CharSequence) str));
            zza((CharSequence) str, this.zzcg);
        } catch (Throwable e) {
            zzba zzba = new zzba(this.zzcg.position(), this.zzcg.limit());
            zzba.initCause(e);
            throw zzba;
        }
    }

    public final void zza(int i, zzbh zzbh) {
        zze(i, 2);
        if (zzbh.zzcq < 0) {
            zzbh.zzai();
        }
        zzm(zzbh.zzcq);
        zzbh.zza(this);
    }

    public final void zza(int i, byte[] bArr) {
        zze(i, 2);
        zzm(bArr.length);
        zzc(bArr);
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

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
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

    public static int zzd(int i, int i2) {
        return zzl(1) + zzj(i2);
    }

    public static int zzb(int i, String str) {
        int zzl = zzl(i);
        int zza = zza((CharSequence) str);
        return zzl + (zza + zzn(zza));
    }

    public static int zzb(int i, zzbh zzbh) {
        int zzl = zzl(i);
        int zzai = zzbh.zzai();
        return zzl + (zzai + zzn(zzai));
    }

    public static int zzj(int i) {
        if (i >= 0) {
            return zzn(i);
        }
        return 10;
    }

    public static int zzb(byte[] bArr) {
        return zzn(bArr.length) + bArr.length;
    }

    public final void zzad() {
        if (this.zzcg.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzcg.remaining())}));
        }
    }

    public final void zza(byte b) {
        if (this.zzcg.hasRemaining()) {
            this.zzcg.put(b);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }

    private final void zzk(int i) {
        byte b = (byte) i;
        if (this.zzcg.hasRemaining()) {
            this.zzcg.put(b);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }

    public final void zzc(byte[] bArr) {
        int length = bArr.length;
        if (this.zzcg.remaining() >= length) {
            this.zzcg.put(bArr, 0, length);
            return;
        }
        throw new zzba(this.zzcg.position(), this.zzcg.limit());
    }

    public final void zze(int i, int i2) {
        zzm((i << 3) | i2);
    }

    public static int zzl(int i) {
        return zzn(i << 3);
    }

    public final void zzm(int i) {
        while ((i & -128) != 0) {
            zzk((i & 127) | 128);
            i >>>= 7;
        }
        zzk(i);
    }

    public static int zzn(int i) {
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
}
