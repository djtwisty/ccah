package android.support.v4.p014c.p015a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* renamed from: android.support.v4.c.a.b */
class C0223b extends Drawable implements Callback, C0222e {
    /* renamed from: a */
    static final Mode f440a = Mode.SRC_IN;
    /* renamed from: b */
    C0220a f441b;
    /* renamed from: c */
    Drawable f442c;
    /* renamed from: d */
    private int f443d;
    /* renamed from: e */
    private Mode f444e;
    /* renamed from: f */
    private boolean f445f;
    /* renamed from: g */
    private boolean f446g;

    /* renamed from: android.support.v4.c.a.b$a */
    protected static abstract class C0220a extends ConstantState {
        /* renamed from: a */
        int f436a;
        /* renamed from: b */
        ConstantState f437b;
        /* renamed from: c */
        ColorStateList f438c = null;
        /* renamed from: d */
        Mode f439d = C0223b.f440a;

        public abstract Drawable newDrawable(Resources resources);

        C0220a(C0220a c0220a, Resources resources) {
            if (c0220a != null) {
                this.f436a = c0220a.f436a;
                this.f437b = c0220a.f437b;
                this.f438c = c0220a.f438c;
                this.f439d = c0220a.f439d;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.f437b != null ? this.f437b.getChangingConfigurations() : 0) | this.f436a;
        }

        /* renamed from: a */
        boolean m668a() {
            return this.f437b != null;
        }
    }

    /* renamed from: android.support.v4.c.a.b$b */
    private static class C0221b extends C0220a {
        C0221b(C0220a c0220a, Resources resources) {
            super(c0220a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0223b(this, resources);
        }
    }

    C0223b(C0220a c0220a, Resources resources) {
        this.f441b = c0220a;
        m669a(resources);
    }

    C0223b(Drawable drawable) {
        this.f441b = mo122a();
        m673a(drawable);
    }

    /* renamed from: a */
    private void m669a(Resources resources) {
        if (this.f441b != null && this.f441b.f437b != null) {
            m673a(m671a(this.f441b.f437b, resources));
        }
    }

    /* renamed from: a */
    protected Drawable m671a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    public void jumpToCurrentState() {
        this.f442c.jumpToCurrentState();
    }

    public void draw(Canvas canvas) {
        this.f442c.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f442c != null) {
            this.f442c.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.f442c.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.f441b != null ? this.f441b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f442c.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.f442c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f442c.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.f442c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f442c.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!mo123b() || this.f441b == null) ? null : this.f441b.f438c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f442c.isStateful();
    }

    public boolean setState(int[] iArr) {
        return m670a(iArr) || this.f442c.setState(iArr);
    }

    public int[] getState() {
        return this.f442c.getState();
    }

    public Drawable getCurrent() {
        return this.f442c.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f442c.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.f442c.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.f442c.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.f442c.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f442c.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.f442c.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.f442c.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.f442c.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.f441b == null || !this.f441b.m668a()) {
            return null;
        }
        this.f441b.f436a = getChangingConfigurations();
        return this.f441b;
    }

    public Drawable mutate() {
        if (!this.f446g && super.mutate() == this) {
            this.f441b = mo122a();
            if (this.f442c != null) {
                this.f442c.mutate();
            }
            if (this.f441b != null) {
                this.f441b.f437b = this.f442c != null ? this.f442c.getConstantState() : null;
            }
            this.f446g = true;
        }
        return this;
    }

    /* renamed from: a */
    C0220a mo122a() {
        return new C0221b(this.f441b, null);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.f442c.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f441b.f438c = colorStateList;
        m670a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f441b.f439d = mode;
        m670a(getState());
    }

    /* renamed from: a */
    private boolean m670a(int[] iArr) {
        if (!mo123b()) {
            return false;
        }
        ColorStateList colorStateList = this.f441b.f438c;
        Mode mode = this.f441b.f439d;
        if (colorStateList == null || mode == null) {
            this.f445f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f445f && colorForState == this.f443d && mode == this.f444e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f443d = colorForState;
        this.f444e = mode;
        this.f445f = true;
        return true;
    }

    /* renamed from: a */
    public final void m673a(Drawable drawable) {
        if (this.f442c != null) {
            this.f442c.setCallback(null);
        }
        this.f442c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f441b != null) {
                this.f441b.f437b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* renamed from: b */
    protected boolean mo123b() {
        return true;
    }
}
