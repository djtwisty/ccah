package com.google.firebase.auth;

import android.app.Activity;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzjo;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.api.internal.zzao;
import com.google.firebase.auth.api.internal.zzds;
import com.google.firebase.auth.api.internal.zzed;
import com.google.firebase.auth.api.internal.zzeg;
import com.google.firebase.auth.api.internal.zzem;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzw;
import com.google.firebase.auth.internal.zzz;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class FirebaseAuth implements InternalAuthProvider {
    private FirebaseApp zzgm;
    private final List<IdTokenListener> zzgn;
    private final List<com.google.firebase.auth.internal.IdTokenListener> zzgo;
    private List<AuthStateListener> zzgp;
    private zzao zzgq;
    private FirebaseUser zzgr;
    private zzk zzgs;
    private final Object zzgt;
    private String zzgu;
    private final Object zzgv;
    private String zzgw;
    private final zzad zzgx;
    private final zzz zzgy;
    private zzae zzgz;
    private zzag zzha;

    public interface AuthStateListener {
        void onAuthStateChanged(FirebaseAuth firebaseAuth);
    }

    public interface IdTokenListener {
        void onIdTokenChanged(FirebaseAuth firebaseAuth);
    }

    @VisibleForTesting
    class zza implements com.google.firebase.auth.internal.zza {
        private final /* synthetic */ FirebaseAuth zzhc;

        zza(FirebaseAuth firebaseAuth) {
            this.zzhc = firebaseAuth;
        }

        public final void zza(zzcz zzcz, FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzcz);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzcz);
            this.zzhc.zza(firebaseUser, zzcz, true);
        }
    }

    @VisibleForTesting
    class zzb extends zza implements com.google.firebase.auth.internal.zza, zzw {
        private final /* synthetic */ FirebaseAuth zzhc;

        zzb(FirebaseAuth firebaseAuth) {
            this.zzhc = firebaseAuth;
            super(firebaseAuth);
        }

        public final void zza(Status status) {
            if (status.getStatusCode() == FirebaseError.ERROR_USER_NOT_FOUND || status.getStatusCode() == FirebaseError.ERROR_USER_TOKEN_EXPIRED || status.getStatusCode() == FirebaseError.ERROR_USER_DISABLED) {
                this.zzhc.signOut();
            }
        }
    }

    class zzc extends zza implements com.google.firebase.auth.internal.zza, zzw {
        zzc(FirebaseAuth firebaseAuth) {
            super(firebaseAuth);
        }

        public final void zza(Status status) {
        }
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    @Keep
    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zzed.zza(firebaseApp.getApplicationContext(), new zzeg(firebaseApp.getOptions().getApiKey()).zzdk()), new zzad(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey()), zzz.zzem());
    }

    @VisibleForTesting
    private FirebaseAuth(FirebaseApp firebaseApp, zzao zzao, zzad zzad, zzz zzz) {
        this.zzgt = new Object();
        this.zzgv = new Object();
        this.zzgm = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzgq = (zzao) Preconditions.checkNotNull(zzao);
        this.zzgx = (zzad) Preconditions.checkNotNull(zzad);
        this.zzgs = new zzk();
        this.zzgy = (zzz) Preconditions.checkNotNull(zzz);
        this.zzgn = new CopyOnWriteArrayList();
        this.zzgo = new CopyOnWriteArrayList();
        this.zzgp = new CopyOnWriteArrayList();
        this.zzha = zzag.zzeq();
        this.zzgr = this.zzgx.zzeo();
        if (this.zzgr != null) {
            zzcz zzh = this.zzgx.zzh(this.zzgr);
            if (zzh != null) {
                zza(this.zzgr, zzh, false);
            }
        }
        this.zzgy.zzg(this);
    }

    public FirebaseUser getCurrentUser() {
        return this.zzgr;
    }

    public String getUid() {
        return this.zzgr == null ? null : this.zzgr.getUid();
    }

    public final void zza(FirebaseUser firebaseUser, zzcz zzcz, boolean z) {
        Object obj;
        Object obj2 = null;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcz);
        if (this.zzgr == null) {
            obj2 = 1;
            obj = 1;
        } else {
            obj = !this.zzgr.zzcg().zzdw().equals(zzcz.zzdw()) ? 1 : null;
            boolean equals = this.zzgr.getUid().equals(firebaseUser.getUid());
            if (equals && obj == null) {
                obj = null;
            } else {
                int i = 1;
            }
            if (!equals) {
                int i2 = 1;
            }
        }
        Preconditions.checkNotNull(firebaseUser);
        if (this.zzgr == null) {
            this.zzgr = firebaseUser;
        } else {
            this.zzgr.zza(firebaseUser.getProviderData());
            if (!firebaseUser.isAnonymous()) {
                this.zzgr.zzce();
            }
        }
        if (z) {
            this.zzgx.zzg(this.zzgr);
        }
        if (obj != null) {
            if (this.zzgr != null) {
                this.zzgr.zza(zzcz);
            }
            zzb(this.zzgr);
        }
        if (obj2 != null) {
            zzc(this.zzgr);
        }
        if (z) {
            this.zzgx.zza(firebaseUser, zzcz);
        }
        zzcb().zzc(this.zzgr.zzcg());
    }

    public final void zzca() {
        if (this.zzgr != null) {
            zzad zzad = this.zzgx;
            Preconditions.checkNotNull(this.zzgr);
            zzad.clear(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{r1.getUid()}));
            this.zzgr = null;
        }
        this.zzgx.clear("com.google.firebase.auth.FIREBASE_USER");
        zzb(null);
        zzc(null);
    }

    @VisibleForTesting
    private final synchronized void zza(zzae zzae) {
        this.zzgz = zzae;
        this.zzgm.setIdTokenListenersCountChangedListener(zzae);
    }

    @VisibleForTesting
    private final synchronized zzae zzcb() {
        if (this.zzgz == null) {
            zza(new zzae(this.zzgm));
        }
        return this.zzgz;
    }

    public FirebaseApp getApp() {
        return this.zzgm;
    }

    public final FirebaseApp zzcc() {
        return this.zzgm;
    }

    public void addIdTokenListener(IdTokenListener idTokenListener) {
        this.zzgn.add(idTokenListener);
        this.zzha.execute(new zzi(this, idTokenListener));
    }

    @KeepForSdk
    public void addIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzgo.add(idTokenListener);
        zzcb().zzf(this.zzgo.size());
    }

    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        this.zzgn.remove(idTokenListener);
    }

    @KeepForSdk
    public void removeIdTokenListener(com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzgo.remove(idTokenListener);
        zzcb().zzf(this.zzgo.size());
    }

    public void addAuthStateListener(AuthStateListener authStateListener) {
        this.zzgp.add(authStateListener);
        this.zzha.execute(new zzj(this, authStateListener));
    }

    public void removeAuthStateListener(AuthStateListener authStateListener) {
        this.zzgp.remove(authStateListener);
    }

    private final void zzb(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(uid).length() + 45).append("Notifying id token listeners about user ( ").append(uid).append(" ).").toString());
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        this.zzha.execute(new zzk(this, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzci() : null)));
    }

    private final void zzc(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(uid).length() + 47).append("Notifying auth state listeners about user ( ").append(uid).append(" ).").toString());
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        this.zzha.execute(new zzl(this));
    }

    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zza(this.zzgr, z);
    }

    public final Task<GetTokenResult> zza(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzds.zzb(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzcz zzcg = firebaseUser.zzcg();
        if (!zzcg.isValid() || z) {
            return this.zzgq.zza(this.zzgm, firebaseUser, zzcg.zzr(), new zzm(this));
        }
        return Tasks.forResult(zzaa.zzcv(zzcg.zzdw()));
    }

    public Task<AuthResult> signInWithCredential(AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (emailAuthCredential.zzbz()) {
                return this.zzgq.zza(this.zzgm, emailAuthCredential, new zza(this));
            }
            return this.zzgq.zzb(this.zzgm, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), this.zzgw, new zza(this));
        } else if (!(authCredential instanceof PhoneAuthCredential)) {
            return this.zzgq.zza(this.zzgm, authCredential, this.zzgw, new zza(this));
        } else {
            return this.zzgq.zza(this.zzgm, (PhoneAuthCredential) authCredential, this.zzgw, new zza(this));
        }
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        if (EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!"password".equals(emailAuthCredential.getSignInMethod())) {
                return this.zzgq.zza(this.zzgm, firebaseUser, emailAuthCredential, new zzb(this));
            }
            return this.zzgq.zza(this.zzgm, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), firebaseUser.zzcf(), new zzb(this));
        } else if (authCredential instanceof PhoneAuthCredential) {
            return this.zzgq.zza(this.zzgm, firebaseUser, (PhoneAuthCredential) authCredential, this.zzgw, new zzb(this));
        } else {
            return this.zzgq.zza(this.zzgm, firebaseUser, authCredential, firebaseUser.zzcf(), new zzb(this));
        }
    }

    public final Task<AuthResult> zzb(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        if (EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!"password".equals(emailAuthCredential.getSignInMethod())) {
                return this.zzgq.zzb(this.zzgm, firebaseUser, emailAuthCredential, new zzb(this));
            }
            return this.zzgq.zzb(this.zzgm, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), firebaseUser.zzcf(), new zzb(this));
        } else if (authCredential instanceof PhoneAuthCredential) {
            return this.zzgq.zzb(this.zzgm, firebaseUser, (PhoneAuthCredential) authCredential, this.zzgw, new zzb(this));
        } else {
            return this.zzgq.zzb(this.zzgm, firebaseUser, authCredential, firebaseUser.zzcf(), new zzb(this));
        }
    }

    public Task<AuthResult> signInWithCustomToken(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zza(this.zzgm, str, new zza(this));
    }

    public Task<AuthResult> signInWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zzb(this.zzgm, str, str2, this.zzgw, new zza(this));
    }

    public Task<AuthResult> signInWithEmailLink(String str, String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public Task<AuthResult> signInAnonymously() {
        if (this.zzgr == null || !this.zzgr.isAnonymous()) {
            return this.zzgq.zza(this.zzgm, new zza(this), this.zzgw);
        }
        zzl zzl = (zzl) this.zzgr;
        zzl.zzr(false);
        return Tasks.forResult(new zzf(zzl));
    }

    public final void zza(String str, long j, TimeUnit timeUnit, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, boolean z) {
        long convert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (convert < 0 || convert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        OnVerificationStateChangedCallbacks zzn;
        zzdj zzdj = new zzdj(str, convert, z, this.zzgu, this.zzgw);
        if (this.zzgs.zzee() && str.equals(this.zzgs.getPhoneNumber())) {
            zzn = new zzn(this, onVerificationStateChangedCallbacks);
        } else {
            zzn = onVerificationStateChangedCallbacks;
        }
        this.zzgq.zza(this.zzgm, zzdj, zzn, activity, executor);
    }

    public Task<Void> updateCurrentUser(FirebaseUser firebaseUser) {
        if (firebaseUser == null) {
            throw new IllegalArgumentException("Cannot update current user with null user!");
        } else if ((firebaseUser.zzcf() != null && !firebaseUser.zzcf().equals(this.zzgw)) || (this.zzgw != null && !this.zzgw.equals(firebaseUser.zzcf()))) {
            return Tasks.forException(zzds.zzb(new Status(17072)));
        } else {
            String apiKey = firebaseUser.zzcc().getOptions().getApiKey();
            String apiKey2 = this.zzgm.getOptions().getApiKey();
            if (!firebaseUser.zzcg().isValid() || !apiKey2.equals(apiKey)) {
                return zza(firebaseUser, new zzc(this));
            }
            zza(zzl.zza(this.zzgm, firebaseUser), firebaseUser.zzcg(), true);
            return Tasks.forResult(null);
        }
    }

    public final Task<Void> zzd(FirebaseUser firebaseUser) {
        return zza(firebaseUser, new zzb(this));
    }

    private final Task<Void> zza(FirebaseUser firebaseUser, zzah zzah) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zza(this.zzgm, firebaseUser, zzah);
    }

    public final Task<AuthResult> zzc(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zza(this.zzgm, firebaseUser, authCredential, new zzb(this));
    }

    public final Task<AuthResult> zza(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zzd(this.zzgm, firebaseUser, str, new zzb(this));
    }

    public Task<AuthResult> createUserWithEmailAndPassword(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zza(this.zzgm, str, str2, this.zzgw, new zza(this));
    }

    @Deprecated
    public Task<ProviderQueryResult> fetchProvidersForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zza(this.zzgm, str, this.zzgw);
    }

    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzb(this.zzgm, str, this.zzgw);
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zzgq.zza(this.zzgm, firebaseUser, userProfileChangeRequest, new zzb(this));
    }

    public final Task<Void> zzb(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzb(this.zzgm, firebaseUser, str, new zzb(this));
    }

    public final Task<Void> zza(FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zzgq.zza(this.zzgm, firebaseUser, phoneAuthCredential, new zzb(this));
    }

    public final Task<Void> zzc(FirebaseUser firebaseUser, String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzc(this.zzgm, firebaseUser, str, new zzb(this));
    }

    public Task<Void> sendPasswordResetEmail(String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    public Task<Void> sendPasswordResetEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzbs();
        }
        if (this.zzgu != null) {
            actionCodeSettings.zzbm(this.zzgu);
        }
        actionCodeSettings.zza(zzjo.PASSWORD_RESET);
        return this.zzgq.zza(this.zzgm, str, actionCodeSettings, this.zzgw);
    }

    public Task<Void> sendSignInLinkToEmail(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            if (this.zzgu != null) {
                actionCodeSettings.zzbm(this.zzgu);
            }
            return this.zzgq.zzb(this.zzgm, str, actionCodeSettings, this.zzgw);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    public boolean isSignInWithEmailLink(String str) {
        return EmailAuthCredential.isSignInWithEmailLink(str);
    }

    public final Task<Void> zza(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzgu != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzbs();
            }
            actionCodeSettings.zzbm(this.zzgu);
        }
        return this.zzgq.zza(this.zzgm, actionCodeSettings, str);
    }

    public Task<ActionCodeResult> checkActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzc(this.zzgm, str, this.zzgw);
    }

    public Task<Void> applyActionCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzd(this.zzgm, str, this.zzgw);
    }

    public Task<String> verifyPasswordResetCode(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zze(this.zzgm, str, this.zzgw);
    }

    public Task<Void> confirmPasswordReset(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zza(this.zzgm, str, str2, this.zzgw);
    }

    public final Task<Void> zze(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zza(firebaseUser, new zzo(this, firebaseUser));
    }

    public void signOut() {
        zzca();
        if (this.zzgz != null) {
            this.zzgz.cancel();
        }
    }

    public void setLanguageCode(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzgt) {
            this.zzgu = str;
        }
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzgt) {
            str = this.zzgu;
        }
        return str;
    }

    public final void zzc(String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzgv) {
            this.zzgw = str;
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzgt) {
            this.zzgu = zzem.zzdo();
        }
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzgs;
    }

    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zzgq.setFirebaseUIVersion(str);
    }
}
