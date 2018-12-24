package android.support.v4.p012a;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: android.support.v4.a.ai */
class ai implements OnAttachStateChangeListener, OnPreDrawListener {
    /* renamed from: a */
    private final View f107a;
    /* renamed from: b */
    private ViewTreeObserver f108b;
    /* renamed from: c */
    private final Runnable f109c;

    private ai(View view, Runnable runnable) {
        this.f107a = view;
        this.f108b = view.getViewTreeObserver();
        this.f109c = runnable;
    }

    /* renamed from: a */
    public static ai m177a(View view, Runnable runnable) {
        ai aiVar = new ai(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(aiVar);
        view.addOnAttachStateChangeListener(aiVar);
        return aiVar;
    }

    public boolean onPreDraw() {
        m178a();
        this.f109c.run();
        return true;
    }

    /* renamed from: a */
    public void m178a() {
        if (this.f108b.isAlive()) {
            this.f108b.removeOnPreDrawListener(this);
        } else {
            this.f107a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f107a.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        this.f108b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        m178a();
    }
}
