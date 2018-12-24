package com.yourvoice.ccApp.androidcomponent;

import android.content.Context;
import android.content.SharedPreferences.Editor;

/* renamed from: com.yourvoice.ccApp.androidcomponent.j */
public class C0492j {
    /* renamed from: a */
    public static void m1270a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    /* renamed from: b */
    public static String m1272b(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str, str2);
    }

    /* renamed from: a */
    public static void m1269a(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    /* renamed from: b */
    public static int m1271b(Context context, String str, int i) {
        return context.getSharedPreferences(str, 0).getInt(str, i);
    }
}
