package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzci;
import com.google.android.gms.internal.firebase_auth.zzcm;
import com.google.android.gms.internal.firebase_auth.zzcp;
import com.google.android.gms.internal.firebase_auth.zzcq;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcx;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdf;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.android.gms.internal.firebase_auth.zzdm;
import com.google.android.gms.internal.firebase_auth.zzdn;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzdu;
import com.google.android.gms.internal.firebase_auth.zzdx;
import com.google.android.gms.internal.firebase_auth.zzjo;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.zzd;

public final class zza {
    private final zzex zzip;
    private final zzdu zziq;

    public zza(zzex zzex, zzdu zzdu) {
        this.zzip = (zzex) Preconditions.checkNotNull(zzex);
        this.zziq = (zzdu) Preconditions.checkNotNull(zzdu);
    }

    public final void zza(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzcp(str), new zzb(this, zzdp));
    }

    public final void zzb(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdu(str), new zzm(this, zzdp));
    }

    public final void zza(zzdr zzdr, zzdp zzdp) {
        Preconditions.checkNotNull(zzdr);
        Preconditions.checkNotNull(zzdp);
        if (this.zziq.zzdi().booleanValue()) {
            zzdr.zzq(this.zziq.zzdi().booleanValue());
        }
        this.zzip.zza(zzdr, new zzx(this, zzdp));
    }

    public final void zzc(String str, zzdp zzdp) {
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdn(str), new zzab(this, zzdp));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzdp);
        zza(str, new zzac(this, userProfileChangeRequest, zzdp));
    }

    public final void zza(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str, new zzad(this, str2, zzdp));
    }

    public final void zzb(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str, new zzae(this, str2, zzdp));
    }

    public final void zzc(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzdl zzdl = new zzdl();
        zzdl.zzco(str);
        zzdl.zzcp(str2);
        this.zzip.zza(zzdl, new zzaf(this, zzdp));
    }

    private final void zza(String str, zzez<zzcz> zzez) {
        Preconditions.checkNotNull(zzez);
        Preconditions.checkNotEmpty(str);
        zzcz zzcf = zzcz.zzcf(str);
        if (zzcf.isValid()) {
            zzez.onSuccess(zzcf);
            return;
        }
        this.zzip.zza(new zzcp(zzcf.zzr()), new zzag(this, zzez));
    }

    public final void zza(String str, String str2, String str3, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdn(str, str2, null, str3), new zzc(this, zzdp));
    }

    public final void zzb(String str, String str2, String str3, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdx(str, str2, str3), new zzd(this, zzdp));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzdp zzdp) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzdp);
        if (emailAuthCredential.zzby()) {
            zza(emailAuthCredential.zzbx(), new zze(this, emailAuthCredential, zzdp));
        } else {
            zza(new zzcm(emailAuthCredential, null), zzdp);
        }
    }

    private final void zza(zzcm zzcm, zzdp zzdp) {
        Preconditions.checkNotNull(zzcm);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(zzcm, new zzf(this, zzdp));
    }

    private final void zza(zzdp zzdp, zzcz zzcz, zzdl zzdl, zzey zzey) {
        Preconditions.checkNotNull(zzdp);
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzdl);
        Preconditions.checkNotNull(zzey);
        this.zzip.zza(new zzcq(zzcz.zzdw()), new zzg(this, zzey, zzdp, zzcz, zzdl));
    }

    private final void zza(zzdp zzdp, zzcz zzcz, zzct zzct, zzdl zzdl, zzey zzey) {
        Preconditions.checkNotNull(zzdp);
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzct);
        Preconditions.checkNotNull(zzdl);
        Preconditions.checkNotNull(zzey);
        this.zzip.zza(zzdl, new zzh(this, zzdl, zzct, zzdp, zzcz, zzey));
    }

    private static zzcz zza(zzcz zzcz, zzdm zzdm) {
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzdm);
        Object idToken = zzdm.getIdToken();
        Object zzr = zzdm.zzr();
        if (TextUtils.isEmpty(idToken) || TextUtils.isEmpty(zzr)) {
            return zzcz;
        }
        return new zzcz(zzr, idToken, Long.valueOf(zzdm.zzs()), zzcz.zzdx());
    }

    private final void zza(zzcz zzcz, String str, String str2, Boolean bool, zzd zzd, zzdp zzdp, zzey zzey) {
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzey);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzcq(zzcz.zzdw()), new zzi(this, zzey, str2, str, bool, zzd, zzdp, zzcz));
    }

    public final void zzd(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzci(str, str2), new zzj(this, zzdp));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, String str2, zzdp zzdp) {
        zzcx zzcx;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzjo zzbg = zzjo.zzbg(actionCodeSettings.getRequestType());
        if (zzbg != null) {
            zzcx = new zzcx(zzbg);
        } else {
            zzcx = new zzcx(zzjo.OOB_REQ_TYPE_UNSPECIFIED);
        }
        zzcx.zzcb(str);
        zzcx.zza(actionCodeSettings);
        zzcx.zzcd(str2);
        this.zzip.zza(zzcx, new zzk(this, zzdp));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzcx zzcx = new zzcx(zzjo.VERIFY_EMAIL);
        zzcx.zzcc(str);
        if (actionCodeSettings != null) {
            zzcx.zza(actionCodeSettings);
        }
        this.zzip.zza(zzcx, new zzl(this, zzdp));
    }

    public final void zze(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdf(str, null, str2), new zzn(this, zzdp));
    }

    public final void zzc(String str, String str2, String str3, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdf(str, str2, str3), new zzo(this, zzdp));
    }

    public final void zzd(String str, String str2, String str3, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzdp);
        zza(str3, new zzp(this, str, str2, zzdp));
    }

    public final void zza(String str, zzdr zzdr, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        Preconditions.checkNotNull(zzdp);
        zza(str, new zzq(this, zzdr, zzdp));
    }

    public final void zzd(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, new zzs(this, zzdp));
    }

    public final void zzf(String str, String str2, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str2, new zzt(this, str, zzdp));
    }

    public final void zze(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, new zzv(this, zzdp));
    }

    public final void zzf(String str, zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, new zzy(this, zzdp));
    }

    public final void zzg(String str, zzdp zzdp) {
        Preconditions.checkNotNull(zzdp);
        this.zzip.zzb(str, new zzaa(this, zzdp));
    }
}
