package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzz;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public final class zzac {
    private static long zzrr = 3600000;
    private static final zzz<String> zzrs = zzz.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", Param.TIMESTAMP);
    private static final zzac zzrt = new zzac();
    private Task<AuthResult> zzru;
    private long zzrv = 0;

    private zzac() {
    }

    public static zzac zzen() {
        return zzrt;
    }

    public static void zza(Context context, zzdr zzdr, String str, String str2) {
        Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzdr));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong(Param.TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    public static void zza(Context context, Status status) {
        Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.getStatusCode());
        edit.putString("statusMessage", status.getStatusMessage());
        edit.putLong(Param.TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(com.google.firebase.auth.FirebaseAuth r13) {
        /*
        r12 = this;
        r10 = 0;
        r1 = 0;
        r8 = 0;
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
        r0 = r13.zzcc();
        r0 = r0.getApplicationContext();
        r2 = "com.google.firebase.auth.internal.ProcessDeathHelper";
        r3 = r0.getSharedPreferences(r2, r1);
        r0 = "firebaseAppName";
        r2 = "";
        r0 = r3.getString(r0, r2);
        r2 = r13.zzcc();
        r2 = r2.getName();
        r0 = r2.equals(r0);
        if (r0 != 0) goto L_0x002c;
    L_0x002b:
        return;
    L_0x002c:
        r0 = "verifyAssertionRequest";
        r0 = r3.contains(r0);
        if (r0 == 0) goto L_0x00e4;
    L_0x0034:
        r0 = "verifyAssertionRequest";
        r2 = "";
        r0 = r3.getString(r0, r2);
        r2 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR;
        r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromString(r0, r2);
        r0 = (com.google.android.gms.internal.firebase_auth.zzdr) r0;
        r2 = "operation";
        r4 = "";
        r4 = r3.getString(r2, r4);
        r2 = "tenantId";
        r2 = r3.getString(r2, r8);
        r5 = "firebaseUserUid";
        r6 = "";
        r5 = r3.getString(r5, r6);
        r6 = "timestamp";
        r6 = r3.getLong(r6, r10);
        r12.zzrv = r6;
        if (r2 == 0) goto L_0x006a;
    L_0x0064:
        r13.zzc(r2);
        r0.zzcr(r2);
    L_0x006a:
        r2 = -1;
        r6 = r4.hashCode();
        switch(r6) {
            case -1843829902: goto L_0x008f;
            case -286760092: goto L_0x0085;
            case 1731327805: goto L_0x007c;
            default: goto L_0x0072;
        };
    L_0x0072:
        r1 = r2;
    L_0x0073:
        switch(r1) {
            case 0: goto L_0x0099;
            case 1: goto L_0x00a4;
            case 2: goto L_0x00c4;
            default: goto L_0x0076;
        };
    L_0x0076:
        r12.zzru = r8;
    L_0x0078:
        zza(r3);
        goto L_0x002b;
    L_0x007c:
        r6 = "com.google.firebase.auth.internal.SIGN_IN";
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x0072;
    L_0x0084:
        goto L_0x0073;
    L_0x0085:
        r1 = "com.google.firebase.auth.internal.LINK";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0072;
    L_0x008d:
        r1 = 1;
        goto L_0x0073;
    L_0x008f:
        r1 = "com.google.firebase.auth.internal.REAUTHENTICATE";
        r1 = r4.equals(r1);
        if (r1 == 0) goto L_0x0072;
    L_0x0097:
        r1 = 2;
        goto L_0x0073;
    L_0x0099:
        r0 = com.google.firebase.auth.zzd.zza(r0);
        r0 = r13.signInWithCredential(r0);
        r12.zzru = r0;
        goto L_0x0078;
    L_0x00a4:
        r1 = r13.getCurrentUser();
        r1 = r1.getUid();
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x00c1;
    L_0x00b2:
        r1 = r13.getCurrentUser();
        r0 = com.google.firebase.auth.zzd.zza(r0);
        r0 = r1.linkWithCredential(r0);
        r12.zzru = r0;
        goto L_0x0078;
    L_0x00c1:
        r12.zzru = r8;
        goto L_0x0078;
    L_0x00c4:
        r1 = r13.getCurrentUser();
        r1 = r1.getUid();
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x00e1;
    L_0x00d2:
        r1 = r13.getCurrentUser();
        r0 = com.google.firebase.auth.zzd.zza(r0);
        r0 = r1.reauthenticateAndRetrieveData(r0);
        r12.zzru = r0;
        goto L_0x0078;
    L_0x00e1:
        r12.zzru = r8;
        goto L_0x0078;
    L_0x00e4:
        r0 = "statusCode";
        r0 = r3.contains(r0);
        if (r0 == 0) goto L_0x002b;
    L_0x00ec:
        r0 = "statusCode";
        r1 = 17062; // 0x42a6 float:2.3909E-41 double:8.4297E-320;
        r0 = r3.getInt(r0, r1);
        r1 = "statusMessage";
        r2 = "";
        r1 = r3.getString(r1, r2);
        r2 = new com.google.android.gms.common.api.Status;
        r2.<init>(r0, r1);
        r0 = "timestamp";
        r0 = r3.getLong(r0, r10);
        r12.zzrv = r0;
        zza(r3);
        r0 = com.google.firebase.auth.api.internal.zzds.zzb(r2);
        r0 = com.google.android.gms.tasks.Tasks.forException(r0);
        r12.zzru = r0;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzac.zzh(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final void zza(Context context) {
        Preconditions.checkNotNull(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzru = null;
        this.zzrv = 0;
    }

    private static void zza(SharedPreferences sharedPreferences) {
        Editor edit = sharedPreferences.edit();
        zzz zzz = zzrs;
        int size = zzz.size();
        int i = 0;
        while (i < size) {
            Object obj = zzz.get(i);
            i++;
            edit.remove((String) obj);
        }
        edit.commit();
    }
}
