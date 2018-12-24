package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzhv implements Iterator<zzeq> {
    private final ArrayDeque<zzhs> zzaas;
    private zzeq zzaat;

    private zzhv(zzeh zzeh) {
        this.zzaas = new ArrayDeque();
        this.zzaat = zze(zzeh);
    }

    private final zzeq zze(zzeh zzeh) {
        zzeh zzeh2 = zzeh;
        while (zzeh2 instanceof zzhs) {
            zzhs zzhs = (zzhs) zzeh2;
            this.zzaas.push(zzhs);
            zzeh2 = zzhs.zzaak;
        }
        return (zzeq) zzeh2;
    }

    public final boolean hasNext() {
        return this.zzaat != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        if (this.zzaat == null) {
            throw new NoSuchElementException();
        }
        zzeq zze;
        zzeq zzeq = this.zzaat;
        while (!this.zzaas.isEmpty()) {
            Object obj;
            zze = zze(((zzhs) this.zzaas.pop()).zzaal);
            if (zze.size() == 0) {
                obj = 1;
                continue;
            } else {
                obj = null;
                continue;
            }
            if (obj == null) {
                break;
            }
        }
        zze = null;
        this.zzaat = zze;
        return zzeq;
    }
}
