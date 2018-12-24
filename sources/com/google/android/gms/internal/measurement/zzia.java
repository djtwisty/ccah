package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

public final class zzia {
    private zzia zzbkn;
    private Map<String, zzqp> zzbko;

    public zzia() {
        this(null);
    }

    private zzia(zzia zzia) {
        this.zzbko = null;
        this.zzbkn = zzia;
    }

    public final zzia zzri() {
        return new zzia(this);
    }

    public final boolean has(String str) {
        while (true) {
            if (this.zzbko != null && this.zzbko.containsKey(str)) {
                return true;
            }
            if (this.zzbkn == null) {
                return false;
            }
            this = this.zzbkn;
        }
    }

    public final zzqp<?> zzeq(String str) {
        while (true) {
            if (this.zzbko == null || !this.zzbko.containsKey(str)) {
                if (this.zzbkn == null) {
                    break;
                }
                this = this.zzbkn;
            } else {
                return (zzqp) this.zzbko.get(str);
            }
        }
        String str2 = "Trying to get a non existent symbol: ";
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public final void zza(String str, zzqp<?> zzqp) {
        if (this.zzbko == null) {
            this.zzbko = new HashMap();
        }
        this.zzbko.put(str, zzqp);
    }

    public final void zzb(String str, zzqp<?> zzqp) {
        while (true) {
            if (this.zzbko != null && this.zzbko.containsKey(str)) {
                this.zzbko.put(str, zzqp);
                return;
            } else if (this.zzbkn == null) {
                break;
            } else {
                this = this.zzbkn;
            }
        }
        String str2 = "Trying to modify a non existent symbol: ";
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public final void remove(String str) {
        while (true) {
            Preconditions.checkState(has(str));
            if (this.zzbko == null || !this.zzbko.containsKey(str)) {
                this = this.zzbkn;
            } else {
                this.zzbko.remove(str);
                return;
            }
        }
    }
}
