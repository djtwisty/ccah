package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzdz<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzea<MessageType, BuilderType>> implements zzhc {
    private static boolean zzsg = false;
    protected int zzsf = 0;

    public final zzeh zzer() {
        try {
            zzep zzm = zzeh.zzm(zzgw());
            zzb(zzm.zzfh());
            return zzm.zzfg();
        } catch (Throwable e) {
            String str = "ByteString";
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder((String.valueOf(name).length() + 62) + String.valueOf(str).length()).append("Serializing ").append(name).append(" to a ").append(str).append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzgw()];
            zzfa zzb = zzfa.zzb(bArr);
            zzb(zzb);
            zzb.zzgj();
            return bArr;
        } catch (Throwable e) {
            String str = "byte array";
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder((String.valueOf(name).length() + 62) + String.valueOf(str).length()).append("Serializing ").append(name).append(" to a ").append(str).append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    int zzes() {
        throw new UnsupportedOperationException();
    }

    void zzg(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfv.checkNotNull(iterable);
        int size;
        if (iterable instanceof zzgl) {
            List zzic = ((zzgl) iterable).zzic();
            zzgl zzgl = (zzgl) list;
            int size2 = list.size();
            for (Object next : zzic) {
                if (next == null) {
                    String str = "Element at index " + (zzgl.size() - size2) + " is null.";
                    for (size = zzgl.size() - 1; size >= size2; size--) {
                        zzgl.remove(size);
                    }
                    throw new NullPointerException(str);
                } else if (next instanceof zzeh) {
                    zzgl.zzc((zzeh) next);
                } else {
                    zzgl.add((String) next);
                }
            }
        } else if (iterable instanceof zzhn) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            size = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    String str2 = "Element at index " + (list.size() - size) + " is null.";
                    for (int size3 = list.size() - 1; size3 >= size; size3--) {
                        list.remove(size3);
                    }
                    throw new NullPointerException(str2);
                }
                list.add(next2);
            }
        }
    }
}
