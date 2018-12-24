package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.io.InputStream;

final class zzpp implements zzpt {
    private final /* synthetic */ Context val$context;

    zzpp(Context context) {
        this.val$context = context;
    }

    public final InputStream open(String str) {
        return this.val$context.getAssets().open(str);
    }
}
