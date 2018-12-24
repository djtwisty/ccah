package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzft<MessageType extends zzft<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdz<MessageType, BuilderType> {
    private static Map<Object, zzft<?, ?>> zzxa = new ConcurrentHashMap();
    protected zzir zzwy = zzir.zzjp();
    private int zzwz = -1;

    public static abstract class zza<MessageType extends zzft<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzea<MessageType, BuilderType> {
        private final MessageType zzxb;
        protected MessageType zzxc;
        private boolean zzxd = false;

        protected zza(MessageType messageType) {
            this.zzxb = messageType;
            this.zzxc = (zzft) messageType.zza(zze.zzxi, null, null);
        }

        protected final void zzhj() {
            if (this.zzxd) {
                zzft zzft = (zzft) this.zzxc.zza(zze.zzxi, null, null);
                zza(zzft, this.zzxc);
                this.zzxc = zzft;
                this.zzxd = false;
            }
        }

        public final boolean isInitialized() {
            return zzft.zza(this.zzxc, false);
        }

        public MessageType zzhk() {
            if (this.zzxd) {
                return this.zzxc;
            }
            zzft zzft = this.zzxc;
            zzho.zziu().zzr(zzft).zzf(zzft);
            this.zzxd = true;
            return this.zzxc;
        }

        public final MessageType zzhl() {
            boolean z;
            zzft zzft = (zzft) zzhm();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zzft.zza(zze.zzxf, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z = true;
            } else if (byteValue == (byte) 0) {
                z = false;
            } else {
                boolean zzq = zzho.zziu().zzr(zzft).zzq(zzft);
                if (booleanValue) {
                    Object obj;
                    int i = zze.zzxg;
                    if (zzq) {
                        obj = zzft;
                    } else {
                        obj = null;
                    }
                    zzft.zza(i, obj, null);
                }
                z = zzq;
            }
            if (z) {
                return zzft;
            }
            throw new zzip(zzft);
        }

        public final BuilderType zza(MessageType messageType) {
            zzhj();
            zza(this.zzxc, messageType);
            return this;
        }

        private static void zza(MessageType messageType, MessageType messageType2) {
            zzho.zziu().zzr(messageType).zzc(messageType, messageType2);
        }

        protected final /* synthetic */ zzea zza(zzdz zzdz) {
            return zza((zzft) zzdz);
        }

        public final /* synthetic */ zzea zzet() {
            return (zza) clone();
        }

        public /* synthetic */ zzhc zzhm() {
            return zzhk();
        }

        public /* synthetic */ zzhc zzhn() {
            return zzhl();
        }

        public final /* synthetic */ zzhc zzhi() {
            return this.zzxb;
        }

        public /* synthetic */ Object clone() {
            zza zza = (zza) this.zzxb.zza(zze.zzxj, null, null);
            zza.zza((zzft) zzhm());
            return zza;
        }
    }

    public static class zzb<T extends zzft<T, ?>> extends zzec<T> {
        private final T zzxb;

        public zzb(T t) {
            this.zzxb = t;
        }

        public final /* synthetic */ Object zza(zzet zzet, zzfg zzfg) {
            return zzft.zza(this.zzxb, zzet, zzfg);
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzft<MessageType, BuilderType> implements zzhe {
        protected zzfk<Object> zzxe = zzfk.zzgv();
    }

    public static class zzd<ContainingType extends zzhc, Type> extends zzfe<ContainingType, Type> {
    }

    public enum zze {
        public static final int zzxf = 1;
        public static final int zzxg = 2;
        public static final int zzxh = 3;
        public static final int zzxi = 4;
        public static final int zzxj = 5;
        public static final int zzxk = 6;
        public static final int zzxl = 7;
        private static final /* synthetic */ int[] zzxm = new int[]{zzxf, zzxg, zzxh, zzxi, zzxj, zzxk, zzxl};
        public static final int zzxn = 1;
        public static final int zzxo = 2;
        private static final /* synthetic */ int[] zzxp = new int[]{zzxn, zzxo};
        public static final int zzxq = 1;
        public static final int zzxr = 2;
        private static final /* synthetic */ int[] zzxs = new int[]{zzxq, zzxr};

        public static int[] zzho() {
            return (int[]) zzxm.clone();
        }
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzhf.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzsf != 0) {
            return this.zzsf;
        }
        this.zzsf = zzho.zziu().zzr(this).hashCode(this);
        return this.zzsf;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzft) zza(zze.zzxk, null, null)).getClass().isInstance(obj)) {
            return zzho.zziu().zzr(this).equals(this, (zzft) obj);
        }
        return false;
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzxf, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return false;
        }
        boolean zzq = zzho.zziu().zzr(this).zzq(this);
        if (booleanValue) {
            Object obj;
            int i = zze.zzxg;
            if (zzq) {
                obj = this;
            } else {
                obj = null;
            }
            zza(i, obj, null);
        }
        return zzq;
    }

    final int zzes() {
        return this.zzwz;
    }

    final void zzg(int i) {
        this.zzwz = i;
    }

    public final void zzb(zzfa zzfa) {
        zzho.zziu().zzf(getClass()).zza(this, zzfc.zza(zzfa));
    }

    public final int zzgw() {
        if (this.zzwz == -1) {
            this.zzwz = zzho.zziu().zzr(this).zzp(this);
        }
        return this.zzwz;
    }

    static <T extends zzft<?, ?>> T zzd(Class<T> cls) {
        T t = (zzft) zzxa.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzft) zzxa.get(cls);
            } catch (Throwable e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzft) ((zzft) zziw.zzh(cls)).zza(zze.zzxk, null, null);
            if (t == null) {
                throw new IllegalStateException();
            }
            zzxa.put(cls, t);
        }
        return t;
    }

    protected static <T extends zzft<?, ?>> void zza(Class<T> cls, T t) {
        zzxa.put(cls, t);
    }

    protected static Object zza(zzhc zzhc, String str, Object[] objArr) {
        return new zzhq(zzhc, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }

    protected static final <T extends zzft<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzxf, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return false;
        }
        return zzho.zziu().zzr(t).zzq(t);
    }

    protected static zzfz zzhe() {
        return zzfu.zzhp();
    }

    protected static <E> zzgb<E> zzhf() {
        return zzhp.zziv();
    }

    static <T extends zzft<T, ?>> T zza(T t, zzet zzet, zzfg zzfg) {
        zzft zzft = (zzft) t.zza(zze.zzxi, null, null);
        try {
            zzho.zziu().zzr(zzft).zza(zzft, zzey.zza(zzet), zzfg);
            zzho.zziu().zzr(zzft).zzf(zzft);
            return zzft;
        } catch (IOException e) {
            if (e.getCause() instanceof zzgc) {
                throw ((zzgc) e.getCause());
            }
            throw new zzgc(e.getMessage()).zzh(zzft);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzgc) {
                throw ((zzgc) e2.getCause());
            }
            throw e2;
        }
    }

    public final /* synthetic */ zzhd zzhg() {
        zza zza = (zza) zza(zze.zzxj, null, null);
        zza.zza(this);
        return zza;
    }

    public final /* synthetic */ zzhd zzhh() {
        return (zza) zza(zze.zzxj, null, null);
    }

    public final /* synthetic */ zzhc zzhi() {
        return (zzft) zza(zze.zzxk, null, null);
    }
}
