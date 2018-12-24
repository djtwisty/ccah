package com.google.android.gms.internal.firebase_auth;

public abstract class zzea<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzea<MessageType, BuilderType>> implements zzhd {
    protected abstract BuilderType zza(MessageType messageType);

    public abstract BuilderType zzet();

    public /* synthetic */ Object clone() {
        return zzet();
    }

    public final /* synthetic */ zzhd zzb(zzhc zzhc) {
        if (zzhi().getClass().isInstance(zzhc)) {
            return zza((zzdz) zzhc);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
