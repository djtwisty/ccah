package com.google.android.gms.internal.measurement;

public abstract class zzsx<MessageType extends zzsx<MessageType, BuilderType>, BuilderType extends zzsy<MessageType, BuilderType>> implements zzvv {
    private static boolean zzbtj = false;
    protected int zzbti = 0;

    public final zzte zztw() {
        try {
            zztm zzao = zzte.zzao(zzvx());
            zzb(zzao.zzui());
            return zzao.zzuh();
        } catch (Throwable e) {
            String str = "ByteString";
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder((String.valueOf(name).length() + 62) + String.valueOf(str).length()).append("Serializing ").append(name).append(" to a ").append(str).append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    int zztx() {
        throw new UnsupportedOperationException();
    }

    void zzai(int i) {
        throw new UnsupportedOperationException();
    }
}
