package com.google.android.gms.dynamic;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

final class zae implements OnClickListener {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Intent zarn;

    zae(Context context, Intent intent) {
        this.val$context = context;
        this.zarn = intent;
    }

    public final void onClick(View view) {
        try {
            this.val$context.startActivity(this.zarn);
        } catch (Throwable e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
