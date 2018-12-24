package com.google.android.gms.internal.config;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.DataHolder.Builder;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.HashMap;
import java.util.Map.Entry;

final class zzp extends zzs {
    private final /* synthetic */ zzi zzo;

    zzp(zzo zzo, GoogleApiClient googleApiClient, zzi zzi) {
        this.zzo = zzi;
        super(googleApiClient);
    }

    protected final void zza(Context context, zzah zzah) {
        String id;
        String token;
        Throwable e;
        Builder buildDataHolder = DataBufferSafeParcelable.buildDataHolder();
        for (Entry entry : this.zzo.zzc().entrySet()) {
            DataBufferSafeParcelable.addValue(buildDataHolder, new zzz((String) entry.getKey(), (String) entry.getValue()));
        }
        DataHolder build = buildDataHolder.build(0);
        try {
            id = FirebaseInstanceId.getInstance().getId();
            try {
                token = FirebaseInstanceId.getInstance().getToken();
            } catch (IllegalStateException e2) {
                e = e2;
                if (Log.isLoggable("ConfigApiImpl", 3)) {
                    Log.d("ConfigApiImpl", "Cannot retrieve instanceId or instanceIdToken.", e);
                }
                token = null;
                zzah.zza(this.zzp, new zzab(context.getPackageName(), this.zzo.zzb(), build, this.zzo.getGmpAppId(), id, token, null, this.zzo.zzd(), zzn.zzb(context), this.zzo.zze(), this.zzo.zzf()));
            }
        } catch (IllegalStateException e3) {
            e = e3;
            id = null;
            if (Log.isLoggable("ConfigApiImpl", 3)) {
                Log.d("ConfigApiImpl", "Cannot retrieve instanceId or instanceIdToken.", e);
            }
            token = null;
            zzah.zza(this.zzp, new zzab(context.getPackageName(), this.zzo.zzb(), build, this.zzo.getGmpAppId(), id, token, null, this.zzo.zzd(), zzn.zzb(context), this.zzo.zze(), this.zzo.zzf()));
        }
        try {
            zzah.zza(this.zzp, new zzab(context.getPackageName(), this.zzo.zzb(), build, this.zzo.getGmpAppId(), id, token, null, this.zzo.zzd(), zzn.zzb(context), this.zzo.zze(), this.zzo.zzf()));
        } finally {
            build.close();
        }
    }

    protected final /* synthetic */ Result createFailedResult(Status status) {
        return new zzu(status, new HashMap());
    }
}
