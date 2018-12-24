package com.google.android.gms.internal.config;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zze {
    public static final Api<NoOptions> API = new Api("Config.API", zze, CLIENT_KEY);
    private static final ClientKey<zzw> CLIENT_KEY = new ClientKey();
    private static final AbstractClientBuilder<zzw, NoOptions> zze = new zzf();
    public static final zzg zzf = new zzo();
}
