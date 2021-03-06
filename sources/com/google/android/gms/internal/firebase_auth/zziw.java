package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zziw {
    private static final Logger logger = Logger.getLogger(zziw.class.getName());
    private static final boolean zzabw = zzk(Long.TYPE);
    private static final boolean zzabx = zzk(Integer.TYPE);
    private static final zzd zzaby;
    private static final boolean zzabz = zzjw();
    private static final long zzaca = ((long) zzi(byte[].class));
    private static final long zzacb = ((long) zzi(boolean[].class));
    private static final long zzacc = ((long) zzj(boolean[].class));
    private static final long zzacd = ((long) zzi(int[].class));
    private static final long zzace = ((long) zzj(int[].class));
    private static final long zzacf = ((long) zzi(long[].class));
    private static final long zzacg = ((long) zzj(long[].class));
    private static final long zzach = ((long) zzi(float[].class));
    private static final long zzaci = ((long) zzj(float[].class));
    private static final long zzacj = ((long) zzi(double[].class));
    private static final long zzack = ((long) zzj(double[].class));
    private static final long zzacl = ((long) zzi(Object[].class));
    private static final long zzacm = ((long) zzj(Object[].class));
    private static final long zzacn;
    private static final boolean zzaco;
    private static final Class<?> zzsk = zzee.zzey();
    private static final boolean zztp = zzjv();
    private static final Unsafe zzzk = zzju();

    static abstract class zzd {
        Unsafe zzacp;

        zzd(Unsafe unsafe) {
            this.zzacp = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzacp.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzacp.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzacp.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzacp.putLong(obj, j, j2);
        }
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zziw.zzaco) {
                return zziw.zzq(obj, j);
            }
            return zziw.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zziw.zzaco) {
                zziw.zza(obj, j, b);
            } else {
                zziw.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zziw.zzaco) {
                return zziw.zzs(obj, j);
            }
            return zziw.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zziw.zzaco) {
                zziw.zzb(obj, j, z);
            } else {
                zziw.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zziw.zzaco) {
                return zziw.zzq(obj, j);
            }
            return zziw.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zziw.zzaco) {
                zziw.zza(obj, j, b);
            } else {
                zziw.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zziw.zzaco) {
                return zziw.zzs(obj, j);
            }
            return zziw.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zziw.zzaco) {
                zziw.zzb(obj, j, z);
            } else {
                zziw.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzacp.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzacp.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzacp.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzacp.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzacp.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzacp.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzacp.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzacp.putDouble(obj, j, d);
        }
    }

    private zziw() {
    }

    static boolean zzjs() {
        return zztp;
    }

    static boolean zzjt() {
        return zzabz;
    }

    static <T> T zzh(Class<T> cls) {
        try {
            return zzzk.allocateInstance(cls);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zztp) {
            return zzaby.zzacp.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zztp) {
            return zzaby.zzacp.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzaby.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzaby.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzaby.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzaby.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzaby.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzaby.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzaby.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzaby.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzaby.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzaby.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzaby.zzacp.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzaby.zzacp.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzaby.zzy(bArr, zzaca + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzaby.zze(bArr, zzaca + j, b);
    }

    static Unsafe zzju() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzix());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzjv() {
        if (zzzk == null) {
            return false;
        }
        try {
            Class cls = zzzk.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzee.zzex()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zzjw() {
        if (zzzk == null) {
            return false;
        }
        try {
            Class cls = zzzk.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzjx() == null) {
                return false;
            }
            if (zzee.zzex()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzee.zzex()) {
            return false;
        }
        try {
            Class cls2 = zzsk;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static Field zzjx() {
        Field zzb;
        if (zzee.zzex()) {
            zzb = zzb(Buffer.class, "effectiveDirectAddress");
            if (zzb != null) {
                return zzb;
            }
        }
        zzb = zzb(Buffer.class, "address");
        return (zzb == null || zzb.getType() != Long.TYPE) ? null : zzb;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    private static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((-1 ^ j) & 3) << 3)));
    }

    private static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((3 & j) << 3)));
    }

    private static void zza(Object obj, long j, byte b) {
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j & -4, (zzk(obj, j & -4) & ((255 << i) ^ -1)) | ((b & 255) << i));
    }

    private static void zzb(Object obj, long j, byte b) {
        int i = (((int) j) & 3) << 3;
        zzb(obj, j & -4, (zzk(obj, j & -4) & ((255 << i) ^ -1)) | ((b & 255) << i));
    }

    private static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != (byte) 0;
    }

    private static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != (byte) 0;
    }

    private static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, (byte) (z ? 1 : 0));
    }

    private static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, (byte) (z ? 1 : 0));
    }

    static {
        long j;
        boolean z;
        zzd zzd = null;
        if (zzzk != null) {
            if (!zzee.zzex()) {
                zzd = new zzc(zzzk);
            } else if (zzabw) {
                zzd = new zzb(zzzk);
            } else if (zzabx) {
                zzd = new zza(zzzk);
            }
        }
        zzaby = zzd;
        Field zzjx = zzjx();
        if (zzjx == null || zzaby == null) {
            j = -1;
        } else {
            j = zzaby.zzacp.objectFieldOffset(zzjx);
        }
        zzacn = j;
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z = true;
        } else {
            z = false;
        }
        zzaco = z;
    }
}
