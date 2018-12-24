package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_auth.zze;

public final class zzdr extends GmsClient<zzea> implements zzdq {
    private static Logger zzgg = new Logger("FirebaseAuth", "FirebaseAuth:");
    private final Context zzjx;
    private final zzef zzmh;

    public zzdr(Context context, Looper looper, ClientSettings clientSettings, zzef zzef, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzjx = (Context) Preconditions.checkNotNull(context);
        this.zzmh = zzef;
    }

    protected final String getStartServiceAction() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    protected final String getServiceDescriptor() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final java.lang.String getStartServicePackage() {
        /*
        r4 = this;
        r2 = -1;
        r1 = 0;
        r0 = "firebear.preference";
        r0 = com.google.firebase.auth.api.internal.zzfe.getProperty(r0);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x0010;
    L_0x000e:
        r0 = "default";
    L_0x0010:
        r3 = r0.hashCode();
        switch(r3) {
            case 103145323: goto L_0x0047;
            case 1544803905: goto L_0x0051;
            default: goto L_0x0017;
        };
    L_0x0017:
        r3 = r2;
    L_0x0018:
        switch(r3) {
            case 0: goto L_0x001d;
            case 1: goto L_0x001d;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = "default";
    L_0x001d:
        r3 = r0.hashCode();
        switch(r3) {
            case 103145323: goto L_0x005b;
            default: goto L_0x0024;
        };
    L_0x0024:
        r0 = r2;
    L_0x0025:
        switch(r0) {
            case 0: goto L_0x0065;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = zzgg;
        r2 = "Loading module via FirebaseOptions.";
        r3 = new java.lang.Object[r1];
        r0.m1073i(r2, r3);
        r0 = r4.zzmh;
        r0 = r0.zzjt;
        if (r0 == 0) goto L_0x0075;
    L_0x0037:
        r0 = zzgg;
        r2 = "Preparing to create service connection to fallback implementation";
        r1 = new java.lang.Object[r1];
        r0.m1073i(r2, r1);
        r0 = r4.zzjx;
        r0 = r0.getPackageName();
    L_0x0046:
        return r0;
    L_0x0047:
        r3 = "local";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0017;
    L_0x004f:
        r3 = r1;
        goto L_0x0018;
    L_0x0051:
        r3 = "default";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0017;
    L_0x0059:
        r3 = 1;
        goto L_0x0018;
    L_0x005b:
        r3 = "local";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0024;
    L_0x0063:
        r0 = r1;
        goto L_0x0025;
    L_0x0065:
        r0 = zzgg;
        r2 = "Loading fallback module override.";
        r1 = new java.lang.Object[r1];
        r0.m1073i(r2, r1);
        r0 = r4.zzjx;
        r0 = r0.getPackageName();
        goto L_0x0046;
    L_0x0075:
        r0 = zzgg;
        r2 = "Preparing to create service connection to gms implementation";
        r1 = new java.lang.Object[r1];
        r0.m1073i(r2, r1);
        r0 = "com.google.android.gms";
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzdr.getStartServicePackage():java.lang.String");
    }

    public final boolean requiresGooglePlayServices() {
        return DynamiteModule.getLocalVersion(this.zzjx, "com.google.firebase.auth") == 0;
    }

    protected final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        if (getServiceRequestExtraArgs == null) {
            getServiceRequestExtraArgs = new Bundle();
        }
        if (this.zzmh != null) {
            getServiceRequestExtraArgs.putString("com.google.firebase.auth.API_KEY", this.zzmh.getApiKey());
        }
        return getServiceRequestExtraArgs;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final Feature[] getApiFeatures() {
        return zze.zzg;
    }

    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        if (queryLocalInterface instanceof zzea) {
            return (zzea) queryLocalInterface;
        }
        return new zzec(iBinder);
    }

    @KeepForSdk
    public final /* synthetic */ zzea zzdh() {
        return (zzea) super.getService();
    }
}
