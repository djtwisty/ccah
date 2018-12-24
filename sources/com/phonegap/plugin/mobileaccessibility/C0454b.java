package com.phonegap.plugin.mobileaccessibility;

import android.annotation.TargetApi;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;

@TargetApi(4)
/* renamed from: com.phonegap.plugin.mobileaccessibility.b */
public class C0454b extends C0452a {
    /* renamed from: c */
    AccessibilityManager f687c;
    /* renamed from: d */
    View f688d;

    /* renamed from: com.phonegap.plugin.mobileaccessibility.b$1 */
    static /* synthetic */ class C04531 {
        /* renamed from: a */
        static final /* synthetic */ int[] f686a = new int[TextSize.values().length];

        static {
            try {
                f686a[TextSize.LARGEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f686a[TextSize.LARGER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f686a[TextSize.SMALLER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f686a[TextSize.SMALLEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: a */
    public void mo1621a(MobileAccessibility mobileAccessibility) {
        this.a = mobileAccessibility;
        try {
            this.f688d = (WebView) mobileAccessibility.webView;
        } catch (ClassCastException e) {
            try {
                this.f688d = (View) mobileAccessibility.webView.getClass().getMethod("getView", new Class[0]).invoke(mobileAccessibility.webView, new Object[0]);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
        this.f687c = (AccessibilityManager) this.a.cordova.getActivity().getSystemService("accessibility");
    }

    /* renamed from: a */
    public boolean mo1623a() {
        return false;
    }

    /* renamed from: b */
    public boolean mo1624b() {
        return this.f687c.isEnabled();
    }

    /* renamed from: c */
    public boolean mo1625c() {
        return false;
    }

    /* renamed from: a */
    public void m1139a(boolean z) {
        this.a.m1125b(z);
    }

    /* renamed from: d */
    public void mo1626d() {
    }

    /* renamed from: e */
    public void mo1627e() {
    }

    /* renamed from: a */
    public void mo1622a(CharSequence charSequence) {
        if (this.f687c.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(8);
            obtain.getText().add(charSequence);
            obtain.setEnabled(this.f688d.isEnabled());
            obtain.setClassName(this.f688d.getClass().getName());
            obtain.setPackageName(this.f688d.getContext().getPackageName());
            obtain.setContentDescription(null);
            this.f687c.sendAccessibilityEvent(obtain);
        }
    }

    /* renamed from: f */
    public double mo1628f() {
        TextSize textSize;
        TextSize textSize2 = TextSize.NORMAL;
        try {
            Object invoke = this.f688d.getClass().getMethod("getSettings", new Class[0]).invoke(this.f688d, new Object[0]);
            textSize = (TextSize) invoke.getClass().getMethod("getTextSize", new Class[0]).invoke(invoke, new Object[0]);
        } catch (ClassCastException e) {
            e.printStackTrace();
            textSize = textSize2;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            textSize = textSize2;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            textSize = textSize2;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            textSize = textSize2;
        }
        switch (C04531.f686a[textSize.ordinal()]) {
            case 1:
                return 200.0d;
            case 2:
                return 150.0d;
            case 3:
                return 75.0d;
            case 4:
                return 50.0d;
            default:
                return 100.0d;
        }
    }

    /* renamed from: a */
    public void mo1620a(double d) {
        TextSize textSize = TextSize.SMALLEST;
        if (d > 115.0d) {
            textSize = TextSize.LARGEST;
        } else if (d > 100.0d) {
            textSize = TextSize.LARGER;
        } else if (d == 100.0d) {
            textSize = TextSize.NORMAL;
        } else if (d > 50.0d) {
            textSize = TextSize.SMALLER;
        }
        try {
            Object invoke = this.f688d.getClass().getMethod("getSettings", new Class[0]).invoke(this.f688d, new Object[0]);
            invoke.getClass().getMethod("setTextSize", new Class[]{TextSize.class}).invoke(invoke, new Object[]{textSize});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }
}
