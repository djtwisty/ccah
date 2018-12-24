package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;

public final class zzo {
    private static zzo zzam;
    private Context zzf;

    public static synchronized zzo zzl() {
        zzo zzo;
        synchronized (zzo.class) {
            if (zzam == null) {
                zzam = new zzo();
            }
            zzo = zzam;
        }
        return zzo;
    }

    public final void init(Context context) {
        this.zzf = context;
    }

    public final zzm zzm() {
        try {
            DynamiteModule load = DynamiteModule.load(this.zzf, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, "com.google.android.gms.crash");
            Preconditions.checkNotNull(load);
            IBinder instantiate = load.instantiate("com.google.firebase.crash.internal.api.FirebaseCrashApiImpl");
            if (instantiate == null) {
                return null;
            }
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.firebase.crash.internal.IFirebaseCrashApi");
            if (queryLocalInterface instanceof zzm) {
                return (zzm) queryLocalInterface;
            }
            return new zzn(instantiate);
        } catch (Throwable e) {
            CrashUtils.addDynamiteErrorToDropBox(this.zzf, e);
            throw new zzp(e);
        }
    }

    private zzo() {
    }
}
