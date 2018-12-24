package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.C0078b.C0076a;
import android.os.Bundle;

/* renamed from: android.arch.lifecycle.g */
public class C0086g extends Fragment {
    /* renamed from: a */
    private C0085a f66a;

    /* renamed from: android.arch.lifecycle.g$a */
    interface C0085a {
        /* renamed from: a */
        void m113a();

        /* renamed from: b */
        void m114b();

        /* renamed from: c */
        void m115c();
    }

    /* renamed from: a */
    public static void m116a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new C0086g(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: a */
    private void m118a(C0085a c0085a) {
        if (c0085a != null) {
            c0085a.m113a();
        }
    }

    /* renamed from: b */
    private void m119b(C0085a c0085a) {
        if (c0085a != null) {
            c0085a.m114b();
        }
    }

    /* renamed from: c */
    private void m120c(C0085a c0085a) {
        if (c0085a != null) {
            c0085a.m115c();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m118a(this.f66a);
        m117a(C0076a.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        m119b(this.f66a);
        m117a(C0076a.ON_START);
    }

    public void onResume() {
        super.onResume();
        m120c(this.f66a);
        m117a(C0076a.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        m117a(C0076a.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        m117a(C0076a.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        m117a(C0076a.ON_DESTROY);
        this.f66a = null;
    }

    /* renamed from: a */
    private void m117a(C0076a c0076a) {
        Activity activity = getActivity();
        if (activity instanceof C0083e) {
            ((C0083e) activity).m111a().m109a(c0076a);
        } else if (activity instanceof C0079c) {
            C0078b lifecycle = ((C0079c) activity).getLifecycle();
            if (lifecycle instanceof C0082d) {
                ((C0082d) lifecycle).m109a(c0076a);
            }
        }
    }
}
