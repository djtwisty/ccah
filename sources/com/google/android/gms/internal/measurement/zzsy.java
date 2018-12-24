package com.google.android.gms.internal.measurement;

public abstract class zzsy<MessageType extends zzsx<MessageType, BuilderType>, BuilderType extends zzsy<MessageType, BuilderType>> implements zzvw {
    protected abstract BuilderType zza(MessageType messageType);

    public abstract BuilderType zzty();

    public /* synthetic */ Object clone() {
        return zzty();
    }

    public final /* synthetic */ zzvw zza(zzvv zzvv) {
        if (zzwj().getClass().isInstance(zzvv)) {
            return zza((zzsx) zzvv);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
