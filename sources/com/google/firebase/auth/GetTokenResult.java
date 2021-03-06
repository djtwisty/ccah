package com.google.firebase.auth;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.annotations.PublicApi;
import java.util.Map;

@PublicApi
public class GetTokenResult {
    private String zza;
    private Map<String, Object> zzb;

    @KeepForSdk
    public GetTokenResult(String str, Map<String, Object> map) {
        this.zza = str;
        this.zzb = map;
    }

    @PublicApi
    public String getToken() {
        return this.zza;
    }

    @PublicApi
    public long getExpirationTimestamp() {
        return zza("exp");
    }

    @PublicApi
    public long getAuthTimestamp() {
        return zza("auth_time");
    }

    @PublicApi
    public long getIssuedAtTimestamp() {
        return zza("iat");
    }

    @PublicApi
    public String getSignInProvider() {
        Map map = (Map) this.zzb.get(FirebaseAuthProvider.PROVIDER_ID);
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    @PublicApi
    public Map<String, Object> getClaims() {
        return this.zzb;
    }

    private long zza(String str) {
        Integer num = (Integer) this.zzb.get(str);
        return num == null ? 0 : num.longValue();
    }
}
