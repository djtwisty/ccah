package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzh;
import com.google.android.gms.internal.firebase_auth.zzj.zzh.zza;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcx implements zzff<zzh> {
    private String zzgc;
    private String zzgh;
    private String zzgw;
    private ActionCodeSettings zzig;
    private String zzpf;

    public zzcx(zzjo zzjo) {
        String str;
        switch (zzcy.zzpg[zzjo.ordinal()]) {
            case 1:
                str = "PASSWORD_RESET";
                break;
            case 2:
                str = "VERIFY_EMAIL";
                break;
            case 3:
                str = "EMAIL_SIGNIN";
                break;
            default:
                str = "REQUEST_TYPE_UNSET_ENUM_VALUE";
                break;
        }
        this.zzpf = str;
    }

    public final zzcx zzcb(String str) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzcx zzcc(String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzcx zza(ActionCodeSettings actionCodeSettings) {
        this.zzig = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final zzcx zzcd(String str) {
        this.zzgw = str;
        return this;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    public final /* synthetic */ zzhc zzds() {
        zzjo zzjo;
        zza zzz = zzh.zzz();
        String str = this.zzpf;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1452371317:
                if (str.equals("PASSWORD_RESET")) {
                    obj = null;
                    break;
                }
                break;
            case -1341836234:
                if (str.equals("VERIFY_EMAIL")) {
                    obj = 1;
                    break;
                }
                break;
            case 870738373:
                if (str.equals("EMAIL_SIGNIN")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                zzjo = zzjo.PASSWORD_RESET;
                break;
            case 1:
                zzjo = zzjo.VERIFY_EMAIL;
                break;
            case 2:
                zzjo = zzjo.EMAIL_SIGNIN;
                break;
            default:
                zzjo = zzjo.OOB_REQ_TYPE_UNSPECIFIED;
                break;
        }
        zzft.zza zzb = zzz.zzb(zzjo);
        if (this.zzgh != null) {
            zzb.zzv(this.zzgh);
        }
        if (this.zzgc != null) {
            zzb.zzw(this.zzgc);
        }
        if (this.zzig != null) {
            zzb.zzc(this.zzig.getAndroidInstallApp()).zzd(this.zzig.canHandleCodeInApp());
            if (this.zzig.getUrl() != null) {
                zzb.zzx(this.zzig.getUrl());
            }
            if (this.zzig.getIOSBundle() != null) {
                zzb.zzy(this.zzig.getIOSBundle());
            }
            if (this.zzig.zzbt() != null) {
                zzb.zzz(this.zzig.zzbt());
            }
            if (this.zzig.getAndroidPackageName() != null) {
                zzb.zzaa(this.zzig.getAndroidPackageName());
            }
            if (this.zzig.getAndroidMinimumVersion() != null) {
                zzb.zzab(this.zzig.getAndroidMinimumVersion());
            }
            if (this.zzig.zzbv() != null) {
                zzb.zzad(this.zzig.zzbv());
            }
        }
        if (this.zzgw != null) {
            zzb.zzac(this.zzgw);
        }
        return (zzh) ((zzft) zzb.zzhn());
    }
}
