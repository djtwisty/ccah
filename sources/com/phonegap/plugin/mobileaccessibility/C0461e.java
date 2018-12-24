package com.phonegap.plugin.mobileaccessibility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptioningChangeListener;

@TargetApi(19)
/* renamed from: com.phonegap.plugin.mobileaccessibility.e */
public class C0461e extends C0458d {
    /* renamed from: e */
    private CaptioningManager f693e;
    /* renamed from: f */
    private CaptioningChangeListener f694f;
    /* renamed from: g */
    private TouchExplorationStateChangeListener f695g;

    /* renamed from: com.phonegap.plugin.mobileaccessibility.e$1 */
    class C04591 extends CaptioningChangeListener {
        /* renamed from: a */
        final /* synthetic */ C0461e f691a;

        C04591(C0461e c0461e) {
            this.f691a = c0461e;
        }

        public void onEnabledChanged(boolean z) {
            this.f691a.m1139a(z);
        }
    }

    /* renamed from: com.phonegap.plugin.mobileaccessibility.e$a */
    private class C0460a implements TouchExplorationStateChangeListener {
        /* renamed from: a */
        final /* synthetic */ C0461e f692a;

        private C0460a(C0461e c0461e) {
            this.f692a = c0461e;
        }

        public void onTouchExplorationStateChanged(boolean z) {
            this.f692a.a.m1126c(z);
        }
    }

    /* renamed from: a */
    public void mo1621a(MobileAccessibility mobileAccessibility) {
        super.mo1621a(mobileAccessibility);
        this.f693e = (CaptioningManager) mobileAccessibility.cordova.getActivity().getSystemService("captioning");
    }

    /* renamed from: b */
    public boolean mo1624b() {
        return this.c.getEnabledAccessibilityServiceList(33).size() > 0;
    }

    /* renamed from: a */
    public boolean mo1623a() {
        return this.f693e.isEnabled();
    }

    /* renamed from: c */
    public boolean mo1625c() {
        return this.c.isTouchExplorationEnabled();
    }

    /* renamed from: d */
    public void mo1626d() {
        super.mo1626d();
        if (this.f694f == null) {
            this.f694f = new C04591(this);
        }
        this.f693e.addCaptioningChangeListener(this.f694f);
        if (this.f695g == null) {
            this.f695g = new C0460a();
        }
        this.c.addTouchExplorationStateChangeListener(this.f695g);
    }

    /* renamed from: e */
    public void mo1627e() {
        super.mo1627e();
        if (this.f694f != null) {
            this.f693e.removeCaptioningChangeListener(this.f694f);
            this.f694f = null;
        }
        if (this.f695g != null) {
            this.c.removeTouchExplorationStateChangeListener(this.f695g);
            this.f695g = null;
        }
    }
}
