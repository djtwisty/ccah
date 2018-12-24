package com.google.android.gms.tagmanager;

import android.content.Intent;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzcp extends IInterface {
    void initialize(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd);

    void preview(Intent intent, IObjectWrapper iObjectWrapper);

    void previewIntent(Intent intent, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzcm zzcm, zzcd zzcd);
}
