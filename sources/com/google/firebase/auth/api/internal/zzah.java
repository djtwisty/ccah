package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseError;
import java.util.concurrent.Future;

public abstract class zzah<T extends zzaj> {
    private static Logger zzgg = new Logger("BiChannelGoogleApi", "FirebaseAuth: ");
    private zzai<T> zzjp;

    abstract Future<zzai<T>> zzcw();

    public final <ResultT, A extends AnyClient> Task<ResultT> zza(zzam<A, ResultT> zzam) {
        GoogleApi zzbq = zzbq(zzam.zzda());
        if (zzbq == null) {
            return zzcx();
        }
        return zzbq.doRead(zzam.zzdb());
    }

    public final <ResultT, A extends AnyClient> Task<ResultT> zzb(zzam<A, ResultT> zzam) {
        GoogleApi zzbq = zzbq(zzam.zzda());
        if (zzbq == null) {
            return zzcx();
        }
        return zzbq.doWrite(zzam.zzdb());
    }

    private static <ResultT> Task<ResultT> zzcx() {
        return Tasks.forException(zzds.zzb(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable")));
    }

    private final GoogleApi<T> zzbq(String str) {
        zzai zzcy = zzcy();
        if (zzcy.zzjs.zzbr(str)) {
            Logger logger = zzgg;
            String valueOf = String.valueOf(zzcy.zzjr);
            logger.m1075w(new StringBuilder(String.valueOf(valueOf).length() + 43).append("getGoogleApiForMethod() returned Fallback: ").append(valueOf).toString(), new Object[0]);
            return zzcy.zzjr;
        }
        logger = zzgg;
        valueOf = String.valueOf(zzcy.zzjq);
        logger.m1075w(new StringBuilder(String.valueOf(valueOf).length() + 38).append("getGoogleApiForMethod() returned Gms: ").append(valueOf).toString(), new Object[0]);
        return zzcy.zzjq;
    }

    private final zzai<T> zzcy() {
        zzai<T> zzai;
        synchronized (this) {
            if (this.zzjp == null) {
                try {
                    this.zzjp = (zzai) zzcw().get();
                } catch (Exception e) {
                    String str = "There was an error while initializing the connection to Google Play Services: ";
                    String valueOf = String.valueOf(e.getMessage());
                    throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
            zzai = this.zzjp;
        }
        return zzai;
    }
}
