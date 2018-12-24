package com.phonegap.plugin.mobileaccessibility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import java.lang.reflect.InvocationTargetException;

@TargetApi(14)
/* renamed from: com.phonegap.plugin.mobileaccessibility.c */
public class C0457c extends C0454b {
    /* renamed from: e */
    private AccessibilityStateChangeListener f690e;

    /* renamed from: com.phonegap.plugin.mobileaccessibility.c$a */
    private class C0456a implements AccessibilityStateChangeListener {
        /* renamed from: a */
        final /* synthetic */ C0457c f689a;

        private C0456a(C0457c c0457c) {
            this.f689a = c0457c;
        }

        public void onAccessibilityStateChanged(boolean z) {
            this.f689a.a.m1124a(z);
        }
    }

    /* renamed from: b */
    public boolean mo1624b() {
        return this.c.getEnabledAccessibilityServiceList(1).size() > 0;
    }

    /* renamed from: d */
    public void mo1626d() {
        if (this.f690e == null) {
            this.f690e = new C0456a();
        }
        this.c.addAccessibilityStateChangeListener(this.f690e);
    }

    /* renamed from: e */
    public void mo1627e() {
        this.c.removeAccessibilityStateChangeListener(this.f690e);
        this.f690e = null;
    }

    /* renamed from: f */
    public double mo1628f() {
        double d = 100.0d;
        try {
            Object invoke = this.d.getClass().getMethod("getSettings", new Class[0]).invoke(this.d, new Object[0]);
            d = Double.valueOf(invoke.getClass().getMethod("getTextZoom", new Class[0]).invoke(invoke, new Object[0]).toString()).doubleValue();
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        return d;
    }

    /* renamed from: a */
    public void mo1620a(double d) {
        try {
            Object invoke = this.d.getClass().getMethod("getSettings", new Class[0]).invoke(this.d, new Object[0]);
            invoke.getClass().getMethod("setTextZoom", new Class[]{Integer.TYPE}).invoke(invoke, new Object[]{Integer.valueOf((int) d)});
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
    }
}
