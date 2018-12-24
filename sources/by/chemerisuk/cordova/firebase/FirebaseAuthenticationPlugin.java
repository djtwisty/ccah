package by.chemerisuk.cordova.firebase;

import android.util.Log;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import java.util.concurrent.TimeUnit;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

public class FirebaseAuthenticationPlugin extends CordovaPlugin implements OnCompleteListener<AuthResult> {
    /* renamed from: a */
    private FirebaseAuth f612a;
    /* renamed from: b */
    private PhoneAuthProvider f613b;
    /* renamed from: c */
    private CallbackContext f614c;

    protected void pluginInitialize() {
        Log.d("FirebaseAuthentication", "Starting Firebase Authentication plugin");
        this.f612a = FirebaseAuth.getInstance();
        this.f613b = PhoneAuthProvider.getInstance();
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        if (str.equals("getIdToken")) {
            m1045a(jSONArray.getBoolean(0), callbackContext);
            return true;
        } else if (str.equals("signInWithEmailAndPassword")) {
            m1043a(jSONArray.getString(0), jSONArray.getString(1), callbackContext);
            return true;
        } else if (str.equals("signInWithVerificationId")) {
            m1048b(jSONArray.getString(0), jSONArray.getString(1), callbackContext);
            return true;
        } else if (str.equals("verifyPhoneNumber")) {
            m1042a(jSONArray.getString(0), jSONArray.getLong(1), callbackContext);
            return true;
        } else if (!str.equals("signOut")) {
            return false;
        } else {
            m1044a(callbackContext);
            return true;
        }
    }

    /* renamed from: a */
    private void m1045a(final boolean z, final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ FirebaseAuthenticationPlugin f597c;

            /* renamed from: by.chemerisuk.cordova.firebase.FirebaseAuthenticationPlugin$1$1 */
            class C03071 implements OnCompleteListener<GetTokenResult> {
                /* renamed from: a */
                final /* synthetic */ C03081 f594a;

                C03071(C03081 c03081) {
                    this.f594a = c03081;
                }

                public void onComplete(Task<GetTokenResult> task) {
                    if (task.isSuccessful()) {
                        callbackContext.success(((GetTokenResult) task.getResult()).getToken());
                    } else {
                        callbackContext.error(task.getException().getMessage());
                    }
                }
            }

            public void run() {
                FirebaseUser currentUser = this.f597c.f612a.getCurrentUser();
                if (currentUser == null) {
                    callbackContext.error("User is not authorized");
                } else {
                    currentUser.getIdToken(z).addOnCompleteListener(this.f597c.cordova.getActivity(), new C03071(this));
                }
            }
        });
    }

    public void onComplete(Task<AuthResult> task) {
        if (this.f614c != null) {
            if (task.isSuccessful()) {
                this.f614c.success(m1047b(((AuthResult) task.getResult()).getUser()));
            } else {
                this.f614c.error(task.getException().getMessage());
            }
            this.f614c = null;
        }
    }

    /* renamed from: a */
    private void m1043a(final String str, final String str2, CallbackContext callbackContext) {
        this.f614c = callbackContext;
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ FirebaseAuthenticationPlugin f600c;

            public void run() {
                this.f600c.f612a.signInWithEmailAndPassword(str, str2).addOnCompleteListener(this.f600c.cordova.getActivity(), this.f600c);
            }
        });
    }

    /* renamed from: b */
    private void m1048b(String str, String str2, final CallbackContext callbackContext) {
        final PhoneAuthCredential credential = PhoneAuthProvider.getCredential(str, str2);
        this.f614c = callbackContext;
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ FirebaseAuthenticationPlugin f604c;

            /* renamed from: by.chemerisuk.cordova.firebase.FirebaseAuthenticationPlugin$3$1 */
            class C03101 implements OnCompleteListener<Void> {
                /* renamed from: a */
                final /* synthetic */ C03113 f601a;

                C03101(C03113 c03113) {
                    this.f601a = c03113;
                }

                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        callbackContext.success(FirebaseAuthenticationPlugin.m1047b(this.f601a.f604c.f612a.getCurrentUser()));
                    } else {
                        callbackContext.error(task.getException().getMessage());
                    }
                }
            }

            public void run() {
                FirebaseUser currentUser = this.f604c.f612a.getCurrentUser();
                if (currentUser == null) {
                    this.f604c.f612a.signInWithCredential(credential).addOnCompleteListener(this.f604c.cordova.getActivity(), this.f604c);
                } else {
                    currentUser.updatePhoneNumber(credential).addOnCompleteListener(this.f604c.cordova.getActivity(), new C03101(this));
                }
            }
        });
    }

    /* renamed from: a */
    private void m1042a(String str, long j, CallbackContext callbackContext) {
        try {
            final String str2 = str;
            final long j2 = j;
            final CallbackContext callbackContext2 = callbackContext;
            this.cordova.getThreadPool().execute(new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ FirebaseAuthenticationPlugin f609d;

                /* renamed from: by.chemerisuk.cordova.firebase.FirebaseAuthenticationPlugin$4$1 */
                class C03121 extends OnVerificationStateChangedCallbacks {
                    /* renamed from: a */
                    final /* synthetic */ C03134 f605a;

                    C03121(C03134 c03134) {
                        this.f605a = c03134;
                    }

                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        if (this.f605a.f609d.f612a.getCurrentUser() != null) {
                        }
                    }

                    public void onCodeSent(String str, ForceResendingToken forceResendingToken) {
                        callbackContext2.success(str);
                    }

                    public void onVerificationFailed(FirebaseException firebaseException) {
                        callbackContext2.error(firebaseException.getMessage());
                    }
                }

                public void run() {
                    this.f609d.f613b.verifyPhoneNumber(str2, j2, TimeUnit.MILLISECONDS, this.f609d.cordova.getActivity(), new C03121(this));
                }
            });
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m1044a(final CallbackContext callbackContext) {
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ FirebaseAuthenticationPlugin f611b;

            public void run() {
                this.f611b.f612a.signOut();
                callbackContext.success();
            }
        });
    }

    /* renamed from: b */
    private static JSONObject m1047b(FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", firebaseUser.getUid());
            jSONObject.put("displayName", firebaseUser.getDisplayName());
            jSONObject.put(Scopes.EMAIL, firebaseUser.getEmail());
            jSONObject.put("phoneNumber", firebaseUser.getPhoneNumber());
            jSONObject.put("photoURL", firebaseUser.getPhotoUrl());
            jSONObject.put("providerId", firebaseUser.getProviderId());
        } catch (Throwable e) {
            Log.e("FirebaseAuthentication", "Fail to process getProfileData", e);
        }
        return jSONObject;
    }
}
