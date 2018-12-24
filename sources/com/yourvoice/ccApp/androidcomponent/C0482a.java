package com.yourvoice.ccApp.androidcomponent;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

/* renamed from: com.yourvoice.ccApp.androidcomponent.a */
public class C0482a {
    /* renamed from: a */
    public static void m1233a(Context context, int i) {
        C0482a.m1234b(context, i);
        C0482a.m1235c(context, i);
    }

    /* renamed from: b */
    private static void m1234b(Context context, int i) {
        String a = C0482a.m1232a(context);
        if (a != null) {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i);
            intent.putExtra("badge_count_package_name", context.getPackageName());
            intent.putExtra("badge_count_class_name", a);
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: c */
    private static void m1235c(Context context, int i) {
        String a = C0482a.m1232a(context);
        if (a != null) {
            Intent intent = new Intent();
            intent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", a);
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", context.getPackageName());
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    private static String m1232a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                return resolveInfo.activityInfo.name;
            }
        }
        return null;
    }
}
