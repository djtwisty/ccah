package com.google.firebase.auth.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.p012a.C0145j;
import android.support.v4.p013b.C0211d;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.firebase.FirebaseError;

@KeepName
public class FederatedSignInActivity extends C0145j {
    private static final zzz zzgy = zzz.zzem();
    private static boolean zzrl = false;
    private boolean zzrm = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.LINK".equals(action) && !"com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            String str = "IdpSignInActivity";
            String str2 = "Unknown action: ";
            action = String.valueOf(action);
            Log.e(str, action.length() != 0 ? str2.concat(action) : new String(str2));
            zzel();
        } else if (zzrl) {
            finish();
        } else {
            zzrl = true;
            if (bundle != null) {
                this.zzrm = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
            }
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzrm);
    }

    protected void onResume() {
        boolean z;
        super.onResume();
        Intent intent = getIntent();
        if ("com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED".equals(intent.getAction())) {
            Log.e("IdpSignInActivity", "Web sign-in failed, finishing");
            if (zzai.zza(intent)) {
                zze(zzai.zzb(intent));
                z = true;
            } else {
                zzel();
                z = true;
            }
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION") && intent.hasExtra("com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.SIGN_IN".equals(stringExtra) || "com.google.firebase.auth.internal.LINK".equals(stringExtra) || "com.google.firebase.auth.internal.REAUTHENTICATE".equals(stringExtra)) {
                zzdr zzdr = (zzdr) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzdr.CREATOR);
                String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.EXTRA_TENANT_ID");
                zzdr.zzcr(stringExtra2);
                zzrl = false;
                Intent intent2 = new Intent();
                SafeParcelableSerializer.serializeToIntentExtra(zzdr, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", stringExtra);
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (C0211d.m648a((Context) this).m653a(intent2)) {
                    zzgy.zza(this);
                } else {
                    zzac.zza(getApplicationContext(), zzdr, stringExtra, stringExtra2);
                }
                finish();
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z) {
            if (this.zzrm) {
                zzel();
                return;
            }
            Intent intent3 = new Intent("com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN");
            intent3.setPackage("com.google.android.gms");
            intent3.putExtras(getIntent().getExtras());
            intent3.putExtra("com.google.firebase.auth.internal.OPERATION", getIntent().getAction());
            try {
                startActivityForResult(intent3, 40963);
            } catch (ActivityNotFoundException e) {
                String str = "Could not launch web sign-in Intent. Google Play service is unavailable";
                Log.w("IdpSignInActivity", str);
                zze(new Status(FirebaseError.ERROR_INTERNAL_ERROR, str));
            }
            this.zzrm = true;
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private final void zzel() {
        zzrl = false;
        this.zzrm = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (C0211d.m648a((Context) this).m653a(intent)) {
            zzgy.zza(this);
        } else {
            zzac.zza(this, zzq.zzcu("WEB_CONTEXT_CANCELED"));
        }
        finish();
    }

    private final void zze(Status status) {
        zzrl = false;
        Intent intent = new Intent();
        zzai.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (C0211d.m648a((Context) this).m653a(intent)) {
            zzgy.zza(this);
        } else {
            zzac.zza(getApplicationContext(), status);
        }
        finish();
    }
}
