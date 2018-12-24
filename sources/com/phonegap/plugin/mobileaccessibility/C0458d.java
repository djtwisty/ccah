package com.phonegap.plugin.mobileaccessibility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityEvent;

@TargetApi(16)
/* renamed from: com.phonegap.plugin.mobileaccessibility.d */
public class C0458d extends C0457c {
    /* renamed from: a */
    public void mo1621a(MobileAccessibility mobileAccessibility) {
        super.mo1621a(mobileAccessibility);
        this.b = this.d.getParentForAccessibility();
    }

    /* renamed from: a */
    public void mo1622a(CharSequence charSequence) {
        if (this.c.isEnabled() && this.b != null) {
            this.c.interrupt();
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            this.d.onInitializeAccessibilityEvent(obtain);
            obtain.getText().add(charSequence);
            obtain.setContentDescription(null);
            this.b.requestSendAccessibilityEvent(this.d, obtain);
        }
    }
}
