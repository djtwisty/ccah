package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.support.v4.p012a.C0145j;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class LifecycleActivity {
    private final Object zzbd;

    public LifecycleActivity(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zzbd = activity;
    }

    @KeepForSdk
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean isSupport() {
        return this.zzbd instanceof C0145j;
    }

    @KeepForSdk
    public boolean isChimera() {
        return false;
    }

    public final boolean zzh() {
        return this.zzbd instanceof Activity;
    }

    @KeepForSdk
    public Activity asActivity() {
        return (Activity) this.zzbd;
    }

    @KeepForSdk
    public C0145j asFragmentActivity() {
        return (C0145j) this.zzbd;
    }

    @KeepForSdk
    public Object asObject() {
        return this.zzbd;
    }
}
