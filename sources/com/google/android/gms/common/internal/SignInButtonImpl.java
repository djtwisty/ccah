package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.p014c.p015a.C0219a;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.base.C0319R;
import com.google.android.gms.common.util.DeviceProperties;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
    }

    public final void configure(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
        int zaa = zaa(i2, C0319R.drawable.common_google_signin_btn_icon_dark, C0319R.drawable.common_google_signin_btn_icon_light, C0319R.drawable.common_google_signin_btn_icon_light);
        int zaa2 = zaa(i2, C0319R.drawable.common_google_signin_btn_text_dark, C0319R.drawable.common_google_signin_btn_text_light, C0319R.drawable.common_google_signin_btn_text_light);
        switch (i) {
            case 0:
            case 1:
                break;
            case 2:
                zaa2 = zaa;
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        Drawable a = C0219a.m665a(resources.getDrawable(zaa2));
        C0219a.m666a(a, resources.getColorStateList(C0319R.color.common_google_signin_btn_tint));
        C0219a.m667a(a, Mode.SRC_ATOP);
        setBackgroundDrawable(a);
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zaa(i2, C0319R.color.common_google_signin_btn_text_dark, C0319R.color.common_google_signin_btn_text_light, C0319R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C0319R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C0319R.string.common_signin_button_text_long));
                break;
            case 2:
                setText(null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }

    private static int zaa(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }
}
