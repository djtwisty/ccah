package android.support.v4.p014c.p015a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.p014c.p015a.C0223b.C0220a;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.c.a.d */
class C0227d extends C0225c {
    /* renamed from: d */
    private static Method f447d;

    /* renamed from: android.support.v4.c.a.d$a */
    private static class C0226a extends C0220a {
        C0226a(C0220a c0220a, Resources resources) {
            super(c0220a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0227d(this, resources);
        }
    }

    C0227d(Drawable drawable) {
        super(drawable);
        m676c();
    }

    C0227d(C0220a c0220a, Resources resources) {
        super(c0220a, resources);
        m676c();
    }

    public void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void setTintList(ColorStateList colorStateList) {
        if (mo123b()) {
            super.setTintList(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public void setTint(int i) {
        if (mo123b()) {
            super.setTint(i);
        } else {
            this.c.setTint(i);
        }
    }

    public void setTintMode(Mode mode) {
        if (mo123b()) {
            super.setTintMode(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    /* renamed from: b */
    protected boolean mo123b() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    C0220a mo122a() {
        return new C0226a(this.b, null);
    }

    /* renamed from: c */
    private void m676c() {
        if (f447d == null) {
            try {
                f447d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Throwable e) {
                Log.w("DrawableWrapperApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }
}
