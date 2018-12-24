package com.google.firebase.auth.api.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzjo;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzn;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.auth.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class zzao extends zzah {
    private final Context zzjx;
    private final zzef zzjy;
    private final Future<zzai<zzef>> zzjz = zzcw();

    zzao(Context context, zzef zzef) {
        this.zzjx = context;
        this.zzjy = zzef;
    }

    final Future<zzai<zzef>> zzcw() {
        if (this.zzjz != null) {
            return this.zzjz;
        }
        return Executors.newSingleThreadExecutor().submit(new zzdo(this.zzjy, this.zzjx));
    }

    public final Task<GetTokenResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzah zzah) {
        zzam zzam = (zzbe) new zzbe(str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zza(zzam), zzam);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, zza zza) {
        zzam zzam = (zzcq) new zzcq(str).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, AuthCredential authCredential, String str, zza zza) {
        zzam zzam = (zzco) new zzco(authCredential, str).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzah zzah) {
        zzam zzam = (zzbo) new zzbo(authCredential, str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, zzah zzah) {
        zzam zzam = (zzbq) new zzbq(authCredential, str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, zza zza, String str) {
        zzam zzam = (zzcm) new zzcm(str).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzam), zzam);
    }

    public final void zza(FirebaseApp firebaseApp, zzdj zzdj, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        zzam zzam = (zzdm) new zzdm(zzdj).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor);
        zza(zzb(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzah zzah) {
        zzam zzam = (zzdi) new zzdi(userProfileChangeRequest).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzah zzah) {
        zzam zzam = (zzdc) new zzdc(str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zzc(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzah zzah) {
        zzam zzam = (zzde) new zzde(str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzah zzah) {
        zzam zzam = (zzdg) new zzdg(phoneAuthCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, String str, String str2, String str3, zza zza) {
        zzam zzam = (zzaw) new zzaw(str, str2, str3).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, String str, String str2, String str3, zza zza) {
        zzam zzam = (zzcs) new zzcs(str, str2, str3).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, zza zza) {
        zzam zzam = (zzcu) new zzcu(emailAuthCredential).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzah zzah) {
        zzam zzam = (zzbw) new zzbw(str, str2, str3).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, zzah zzah) {
        zzam zzam = (zzby) new zzby(str, str2, str3).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzah zzah) {
        zzam zzam = (zzbs) new zzbs(emailAuthCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, zzah zzah) {
        zzam zzam = (zzbu) new zzbu(emailAuthCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, zza zza) {
        zzam zzam = (zzcw) new zzcw(phoneAuthCredential, str).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzah zzah) {
        zzam zzam = (zzca) new zzca(phoneAuthCredential, str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zzb(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, zzah zzah) {
        zzam zzam = (zzcc) new zzcc(phoneAuthCredential, str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzam), zzam);
    }

    public final Task<ProviderQueryResult> zza(FirebaseApp firebaseApp, String str, String str2) {
        zzam zzam = (zzba) new zzba(str, str2).zza(firebaseApp);
        return zza(zza(zzam), zzam);
    }

    public final Task<SignInMethodQueryResult> zzb(FirebaseApp firebaseApp, String str, String str2) {
        zzam zzam = (zzbc) new zzbc(str, str2).zza(firebaseApp);
        return zza(zza(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zza(zzjo.PASSWORD_RESET);
        zzam zzam = (zzci) new zzci(str, actionCodeSettings, str2, "sendPasswordResetEmail").zza(firebaseApp);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zzb(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.zza(zzjo.EMAIL_SIGNIN);
        zzam zzam = (zzci) new zzci(str, actionCodeSettings, str2, "sendSignInLinkToEmail").zza(firebaseApp);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, ActionCodeSettings actionCodeSettings, String str) {
        zzam zzam = (zzcg) new zzcg(str, actionCodeSettings).zza(firebaseApp);
        return zza(zzb(zzam), zzam);
    }

    public final Task<ActionCodeResult> zzc(FirebaseApp firebaseApp, String str, String str2) {
        zzam zzam = (zzas) new zzas(str, str2).zza(firebaseApp);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zzd(FirebaseApp firebaseApp, String str, String str2) {
        zzam zzam = (zzaq) new zzaq(str, str2).zza(firebaseApp);
        return zza(zzb(zzam), zzam);
    }

    public final Task<String> zze(FirebaseApp firebaseApp, String str, String str2) {
        zzam zzam = (zzdk) new zzdk(str, str2).zza(firebaseApp);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, String str, String str2, String str3) {
        zzam zzam = (zzau) new zzau(str, str2, str3).zza(firebaseApp);
        return zza(zzb(zzam), zzam);
    }

    public final Task<AuthResult> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzah zzah) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzah);
        List providers = firebaseUser.getProviders();
        if (providers != null && providers.contains(authCredential.getProvider())) {
            return Tasks.forException(zzds.zzb(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        zzam zzam;
        if (authCredential instanceof EmailAuthCredential) {
            if (((EmailAuthCredential) authCredential).zzbz()) {
                zzam = (zzbm) new zzbm((EmailAuthCredential) authCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
                return zza(zzb(zzam), zzam);
            }
            zzam = (zzbg) new zzbg((EmailAuthCredential) authCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
            return zza(zzb(zzam), zzam);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzam = (zzbk) new zzbk((PhoneAuthCredential) authCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
            return zza(zzb(zzam), zzam);
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzah);
            zzam = (zzbi) new zzbi(authCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
            return zza(zzb(zzam), zzam);
        }
    }

    public final Task<AuthResult> zzd(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzah zzah) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzah);
        List providers = firebaseUser.getProviders();
        if ((providers != null && !providers.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzds.zzb(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case 1216985755:
                if (str.equals("password")) {
                    obj = null;
                    break;
                }
                break;
        }
        zzam zzam;
        switch (obj) {
            case null:
                zzam = (zzcy) new zzcy().zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
                return zza(zzb(zzam), zzam);
            default:
                zzam = (zzda) new zzda(str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
                return zza(zzb(zzam), zzam);
        }
    }

    public final Task<Void> zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzah zzah) {
        zzam zzam = (zzce) new zzce().zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zza(zzam), zzam);
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, zzv zzv) {
        zzam zzam = (zzay) new zzay().zzf(firebaseUser).zzb(zzv).zza((zzw) zzv);
        return zza(zzb(zzam), zzam);
    }

    public final Task<Void> setFirebaseUIVersion(String str) {
        zzam zzck = new zzck(str);
        return zza(zzb(zzck), zzck);
    }

    @VisibleForTesting
    static zzl zza(FirebaseApp firebaseApp, zzct zzct) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzct);
        List arrayList = new ArrayList();
        arrayList.add(new zzh(zzct, FirebaseAuthProvider.PROVIDER_ID));
        List zzdu = zzct.zzdu();
        if (!(zzdu == null || zzdu.isEmpty())) {
            for (int i = 0; i < zzdu.size(); i++) {
                arrayList.add(new zzh((zzdb) zzdu.get(i)));
            }
        }
        zzl zzl = new zzl(firebaseApp, arrayList);
        zzl.zza(new zzn(zzct.getLastSignInTimestamp(), zzct.getCreationTimestamp()));
        zzl.zzr(zzct.isNewUser());
        zzl.zzb(zzct.zzcv());
        return zzl;
    }

    @VisibleForTesting
    private final <ResultT> Task<ResultT> zza(Task<ResultT> task, zzam<zzdq, ResultT> zzam) {
        return task.continueWithTask(new zzap(this, zzam));
    }
}
