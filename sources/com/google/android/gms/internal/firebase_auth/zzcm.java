package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzft.zza;
import com.google.android.gms.internal.firebase_auth.zzj.zzd;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.api.internal.zzff;
import java.util.Set;

public final class zzcm implements zzff<zzd> {
    private static final Logger zzgg = new Logger("EmailLinkSignInRequest", new String[0]);
    private final String zzgc;
    private final String zzgh;
    private final String zzgj;

    public zzcm(EmailAuthCredential emailAuthCredential, String str) {
        this.zzgh = Preconditions.checkNotEmpty(emailAuthCredential.getEmail());
        this.zzgj = Preconditions.checkNotEmpty(emailAuthCredential.zzbw());
        this.zzgc = str;
    }

    private static String zzb(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(parse.getQueryParameter("link")).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException e) {
            Object[] objArr = new Object[1];
            String message = e.getMessage();
            objArr[0] = new StringBuilder((String.valueOf(str2).length() + 19) + String.valueOf(message).length()).append("No ").append(str2).append(" in signInLink: ").append(message).toString();
            zzgg.m1074v("EmailLinkSignInRequest", objArr);
        }
    }

    public final /* synthetic */ zzhc zzds() {
        zza zzl = zzd.zzp().zzl(this.zzgh);
        String zzb = zzb(this.zzgj, "oobCode");
        String zzb2 = zzb(this.zzgj, "tenantId");
        if (zzb != null) {
            zzl.zzk(zzb);
        }
        if (zzb2 != null) {
            zzl.zzn(zzb2);
        }
        if (this.zzgc != null) {
            zzl.zzm(this.zzgc);
        }
        return (zzd) ((zzft) zzl.zzhn());
    }
}
