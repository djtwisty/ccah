package android.support.v4.p012a;

import android.app.Activity;
import android.arch.lifecycle.C0078b;
import android.arch.lifecycle.C0078b.C0077b;
import android.arch.lifecycle.C0079c;
import android.arch.lifecycle.C0082d;
import android.arch.lifecycle.C0086g;
import android.os.Bundle;
import android.support.v4.p017e.C0237i;

/* renamed from: android.support.v4.a.ap */
public class ap extends Activity implements C0079c {
    private C0237i<Class<? extends C0119a>, C0119a> mExtraDataMap = new C0237i();
    private C0082d mLifecycleRegistry = new C0082d(this);

    /* renamed from: android.support.v4.a.ap$a */
    public static class C0119a {
    }

    public void putExtraData(C0119a c0119a) {
        this.mExtraDataMap.put(c0119a.getClass(), c0119a);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0086g.m116a((Activity) this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.m110a(C0077b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public <T extends C0119a> T getExtraData(Class<T> cls) {
        return (C0119a) this.mExtraDataMap.get(cls);
    }

    public C0078b getLifecycle() {
        return this.mLifecycleRegistry;
    }
}
