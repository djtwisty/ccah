package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzuo<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsx<MessageType, BuilderType> {
    private static Map<Object, zzuo<?, ?>> zzbyf = new ConcurrentHashMap();
    protected zzxe zzbyd = zzxe.zzyl();
    private int zzbye = -1;

    public static abstract class zza<MessageType extends zzuo<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzsy<MessageType, BuilderType> {
        private final MessageType zzbyg;
        protected MessageType zzbyh;
        private boolean zzbyi = false;

        protected zza(MessageType messageType) {
            this.zzbyg = messageType;
            this.zzbyh = (zzuo) messageType.zza(zze.zzbyn, null, null);
        }

        protected final void zzwk() {
            if (this.zzbyi) {
                zzuo zzuo = (zzuo) this.zzbyh.zza(zze.zzbyn, null, null);
                zza(zzuo, this.zzbyh);
                this.zzbyh = zzuo;
                this.zzbyi = false;
            }
        }

        public final boolean isInitialized() {
            return zzuo.zza(this.zzbyh, false);
        }

        public MessageType zzwl() {
            if (this.zzbyi) {
                return this.zzbyh;
            }
            zzuo zzuo = this.zzbyh;
            zzwh.zzxt().zzak(zzuo).zzy(zzuo);
            this.zzbyi = true;
            return this.zzbyh;
        }

        public final MessageType zzwm() {
            boolean z;
            zzuo zzuo = (zzuo) zzwn();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zzuo.zza(zze.zzbyk, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z = true;
            } else if (byteValue == (byte) 0) {
                z = false;
            } else {
                boolean zzaj = zzwh.zzxt().zzak(zzuo).zzaj(zzuo);
                if (booleanValue) {
                    Object obj;
                    int i = zze.zzbyl;
                    if (zzaj) {
                        obj = zzuo;
                    } else {
                        obj = null;
                    }
                    zzuo.zza(i, obj, null);
                }
                z = zzaj;
            }
            if (z) {
                return zzuo;
            }
            throw new zzxc(zzuo);
        }

        public final BuilderType zza(MessageType messageType) {
            zzwk();
            zza(this.zzbyh, messageType);
            return this;
        }

        private static void zza(MessageType messageType, MessageType messageType2) {
            zzwh.zzxt().zzak(messageType).zzd(messageType, messageType2);
        }

        protected final /* synthetic */ zzsy zza(zzsx zzsx) {
            return zza((zzuo) zzsx);
        }

        public final /* synthetic */ zzsy zzty() {
            return (zza) clone();
        }

        public /* synthetic */ zzvv zzwn() {
            return zzwl();
        }

        public /* synthetic */ zzvv zzwo() {
            return zzwm();
        }

        public final /* synthetic */ zzvv zzwj() {
            return this.zzbyg;
        }

        public /* synthetic */ Object clone() {
            zza zza = (zza) this.zzbyg.zza(zze.zzbyo, null, null);
            zza.zza((zzuo) zzwn());
            return zza;
        }
    }

    public static class zzb<T extends zzuo<T, ?>> extends zzsz<T> {
        private final T zzbyg;

        public zzb(T t) {
            this.zzbyg = t;
        }

        public final /* synthetic */ Object zza(zztq zztq, zzub zzub) {
            return zzuo.zza(this.zzbyg, zztq, zzub);
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzuo<MessageType, BuilderType> implements zzvx {
        protected zzuf<Object> zzbyj = zzuf.zzvw();
    }

    public static class zzd<ContainingType extends zzvv, Type> extends zztz<ContainingType, Type> {
    }

    public enum zze {
        public static final int zzbyk = 1;
        public static final int zzbyl = 2;
        public static final int zzbym = 3;
        public static final int zzbyn = 4;
        public static final int zzbyo = 5;
        public static final int zzbyp = 6;
        public static final int zzbyq = 7;
        private static final /* synthetic */ int[] zzbyr = new int[]{zzbyk, zzbyl, zzbym, zzbyn, zzbyo, zzbyp, zzbyq};
        public static final int zzbys = 1;
        public static final int zzbyt = 2;
        private static final /* synthetic */ int[] zzbyu = new int[]{zzbys, zzbyt};
        public static final int zzbyv = 1;
        public static final int zzbyw = 2;
        private static final /* synthetic */ int[] zzbyx = new int[]{zzbyv, zzbyw};

        public static int[] zzwp() {
            return (int[]) zzbyr.clone();
        }
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzvy.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzbti != 0) {
            return this.zzbti;
        }
        this.zzbti = zzwh.zzxt().zzak(this).hashCode(this);
        return this.zzbti;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzuo) zza(zze.zzbyp, null, null)).getClass().isInstance(obj)) {
            return zzwh.zzxt().zzak(this).equals(this, (zzuo) obj);
        }
        return false;
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzbyk, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return false;
        }
        boolean zzaj = zzwh.zzxt().zzak(this).zzaj(this);
        if (booleanValue) {
            Object obj;
            int i = zze.zzbyl;
            if (zzaj) {
                obj = this;
            } else {
                obj = null;
            }
            zza(i, obj, null);
        }
        return zzaj;
    }

    public final BuilderType zzwf() {
        zza zza = (zza) zza(zze.zzbyo, null, null);
        zza.zza(this);
        return zza;
    }

    final int zztx() {
        return this.zzbye;
    }

    final void zzai(int i) {
        this.zzbye = i;
    }

    public final void zzb(zztv zztv) {
        zzwh.zzxt().zzi(getClass()).zza(this, zztx.zza(zztv));
    }

    public final int zzvx() {
        if (this.zzbye == -1) {
            this.zzbye = zzwh.zzxt().zzak(this).zzai(this);
        }
        return this.zzbye;
    }

    static <T extends zzuo<?, ?>> T zzg(Class<T> cls) {
        T t = (zzuo) zzbyf.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzuo) zzbyf.get(cls);
            } catch (Throwable e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzuo) ((zzuo) zzxj.zzk(cls)).zza(zze.zzbyp, null, null);
            if (t == null) {
                throw new IllegalStateException();
            }
            zzbyf.put(cls, t);
        }
        return t;
    }

    protected static <T extends zzuo<?, ?>> void zza(Class<T> cls, T t) {
        zzbyf.put(cls, t);
    }

    protected static Object zza(zzvv zzvv, String str, Object[] objArr) {
        return new zzwj(zzvv, str, objArr);
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

    protected static final <T extends zzuo<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzbyk, null, null)).byteValue();
        if (byteValue == (byte) 1) {
            return true;
        }
        if (byteValue == (byte) 0) {
            return false;
        }
        return zzwh.zzxt().zzak(t).zzaj(t);
    }

    protected static <E> zzuu<E> zzwg() {
        return zzwi.zzxu();
    }

    static <T extends zzuo<T, ?>> T zza(T t, zztq zztq, zzub zzub) {
        zzuo zzuo = (zzuo) t.zza(zze.zzbyn, null, null);
        try {
            zzwh.zzxt().zzak(zzuo).zza(zzuo, zztt.zza(zztq), zzub);
            zzwh.zzxt().zzak(zzuo).zzy(zzuo);
            return zzuo;
        } catch (IOException e) {
            if (e.getCause() instanceof zzuv) {
                throw ((zzuv) e.getCause());
            }
            throw new zzuv(e.getMessage()).zzg(zzuo);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzuv) {
                throw ((zzuv) e2.getCause());
            }
            throw e2;
        }
    }

    public final /* synthetic */ zzvw zzwh() {
        zza zza = (zza) zza(zze.zzbyo, null, null);
        zza.zza(this);
        return zza;
    }

    public final /* synthetic */ zzvw zzwi() {
        return (zza) zza(zze.zzbyo, null, null);
    }

    public final /* synthetic */ zzvv zzwj() {
        return (zzuo) zza(zze.zzbyp, null, null);
    }
}
