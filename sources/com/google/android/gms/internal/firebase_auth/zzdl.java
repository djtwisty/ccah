package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzl;
import com.google.firebase.auth.api.internal.zzff;
import com.google.zxing.client.android.Intents.WifiConnect;

public final class zzdl implements zzff<zzl> {
    private String zzgc;
    private String zzgh;
    private String zzgi;
    private String zzgw;
    private String zzhw;
    private String zzhx;
    private zzdp zzpr = new zzdp();
    private zzdp zzps = new zzdp();
    private boolean zzpt = true;
    private String zzpu;

    public final boolean zzch(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzps.zzeb().contains(str);
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final String getDisplayName() {
        return this.zzhw;
    }

    public final String zzal() {
        return this.zzhx;
    }

    public final zzdl zzci(String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzdl zzcj(String str) {
        if (str == null) {
            this.zzps.zzeb().add("EMAIL");
        } else {
            this.zzgh = str;
        }
        return this;
    }

    public final zzdl zzck(String str) {
        if (str == null) {
            this.zzps.zzeb().add(WifiConnect.PASSWORD);
        } else {
            this.zzgi = str;
        }
        return this;
    }

    public final zzdl zzcl(String str) {
        if (str == null) {
            this.zzps.zzeb().add("DISPLAY_NAME");
        } else {
            this.zzhw = str;
        }
        return this;
    }

    public final zzdl zzcm(String str) {
        if (str == null) {
            this.zzps.zzeb().add("PHOTO_URL");
        } else {
            this.zzhx = str;
        }
        return this;
    }

    public final zzdl zzcn(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzpr.zzeb().add(str);
        return this;
    }

    public final zzdl zzco(String str) {
        this.zzpu = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzdl zzcp(String str) {
        this.zzgw = str;
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzhc zzds() {
        /*
        r8 = this;
        r2 = 0;
        r0 = com.google.android.gms.internal.firebase_auth.zzj.zzl.zzai();
        r1 = r8.zzpt;
        r0 = r0.zzf(r1);
        r1 = r8.zzpr;
        r1 = r1.zzeb();
        r4 = r0.zzd(r1);
        r0 = r8.zzps;
        r5 = r0.zzeb();
        r0 = r5.size();
        r6 = new com.google.android.gms.internal.firebase_auth.zzo[r0];
        r1 = r2;
    L_0x0022:
        r0 = r5.size();
        if (r1 >= r0) goto L_0x0076;
    L_0x0028:
        r0 = r5.get(r1);
        r0 = (java.lang.String) r0;
        r3 = -1;
        r7 = r0.hashCode();
        switch(r7) {
            case -333046776: goto L_0x004c;
            case 66081660: goto L_0x0042;
            case 1939891618: goto L_0x0060;
            case 1999612571: goto L_0x0056;
            default: goto L_0x0036;
        };
    L_0x0036:
        r0 = r3;
    L_0x0037:
        switch(r0) {
            case 0: goto L_0x006a;
            case 1: goto L_0x006d;
            case 2: goto L_0x0070;
            case 3: goto L_0x0073;
            default: goto L_0x003a;
        };
    L_0x003a:
        r0 = com.google.android.gms.internal.firebase_auth.zzo.USER_ATTRIBUTE_NAME_UNSPECIFIED;
    L_0x003c:
        r6[r1] = r0;
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0022;
    L_0x0042:
        r7 = "EMAIL";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0036;
    L_0x004a:
        r0 = r2;
        goto L_0x0037;
    L_0x004c:
        r7 = "DISPLAY_NAME";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0036;
    L_0x0054:
        r0 = 1;
        goto L_0x0037;
    L_0x0056:
        r7 = "PASSWORD";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0036;
    L_0x005e:
        r0 = 2;
        goto L_0x0037;
    L_0x0060:
        r7 = "PHOTO_URL";
        r0 = r0.equals(r7);
        if (r0 == 0) goto L_0x0036;
    L_0x0068:
        r0 = 3;
        goto L_0x0037;
    L_0x006a:
        r0 = com.google.android.gms.internal.firebase_auth.zzo.EMAIL;
        goto L_0x003c;
    L_0x006d:
        r0 = com.google.android.gms.internal.firebase_auth.zzo.DISPLAY_NAME;
        goto L_0x003c;
    L_0x0070:
        r0 = com.google.android.gms.internal.firebase_auth.zzo.PASSWORD;
        goto L_0x003c;
    L_0x0073:
        r0 = com.google.android.gms.internal.firebase_auth.zzo.PHOTO_URL;
        goto L_0x003c;
    L_0x0076:
        r0 = java.util.Arrays.asList(r6);
        r0 = r4.zzc(r0);
        r1 = r8.zzgc;
        if (r1 == 0) goto L_0x0087;
    L_0x0082:
        r1 = r8.zzgc;
        r0.zzan(r1);
    L_0x0087:
        r1 = r8.zzgh;
        if (r1 == 0) goto L_0x0090;
    L_0x008b:
        r1 = r8.zzgh;
        r0.zzap(r1);
    L_0x0090:
        r1 = r8.zzgi;
        if (r1 == 0) goto L_0x0099;
    L_0x0094:
        r1 = r8.zzgi;
        r0.zzaq(r1);
    L_0x0099:
        r1 = r8.zzhw;
        if (r1 == 0) goto L_0x00a2;
    L_0x009d:
        r1 = r8.zzhw;
        r0.zzao(r1);
    L_0x00a2:
        r1 = r8.zzhx;
        if (r1 == 0) goto L_0x00ab;
    L_0x00a6:
        r1 = r8.zzhx;
        r0.zzas(r1);
    L_0x00ab:
        r1 = r8.zzpu;
        if (r1 == 0) goto L_0x00b4;
    L_0x00af:
        r1 = r8.zzpu;
        r0.zzar(r1);
    L_0x00b4:
        r1 = r8.zzgw;
        if (r1 == 0) goto L_0x00bd;
    L_0x00b8:
        r1 = r8.zzgw;
        r0.zzat(r1);
    L_0x00bd:
        r0 = r0.zzhn();
        r0 = (com.google.android.gms.internal.firebase_auth.zzft) r0;
        r0 = (com.google.android.gms.internal.firebase_auth.zzj.zzl) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzdl.zzds():com.google.android.gms.internal.firebase_auth.zzhc");
    }
}
