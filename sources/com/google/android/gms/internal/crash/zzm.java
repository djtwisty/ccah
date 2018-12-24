package com.google.android.gms.internal.crash;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzm extends IInterface {
    void log(String str);

    void zza(IObjectWrapper iObjectWrapper);

    void zza(IObjectWrapper iObjectWrapper, zzk zzk);

    void zza(String str, long j, Bundle bundle);

    void zza(List<String> list);

    void zza(boolean z);

    void zzb(IObjectWrapper iObjectWrapper);

    void zzb(String str);

    void zzb(boolean z);

    boolean zzd();
}
