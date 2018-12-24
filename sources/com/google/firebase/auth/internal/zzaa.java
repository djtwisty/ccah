package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.GetTokenResult;
import java.util.Collections;
import java.util.Map;

public final class zzaa {
    private static final Logger zzgg = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zzcv(String str) {
        Map zzcw;
        try {
            zzcw = zzab.zzcw(str);
        } catch (Throwable e) {
            zzgg.m1071e("Error parsing token claims", e, new Object[0]);
            zzcw = Collections.EMPTY_MAP;
        }
        return new GetTokenResult(str, zzcw);
    }
}
