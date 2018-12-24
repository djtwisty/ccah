package me.leolin.shortcutbadger;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import java.util.LinkedList;
import java.util.List;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import me.leolin.shortcutbadger.impl.ApexHomeBadger;
import me.leolin.shortcutbadger.impl.AsusHomeLauncher;
import me.leolin.shortcutbadger.impl.DefaultBadger;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import me.leolin.shortcutbadger.impl.NovaHomeBadger;
import me.leolin.shortcutbadger.impl.SolidHomeBadger;
import me.leolin.shortcutbadger.impl.SonyHomeBadger;
import me.leolin.shortcutbadger.impl.XiaomiHomeBadger;

public final class ShortcutBadger {
    /* renamed from: a */
    private static final String f852a = ShortcutBadger.class.getSimpleName();
    /* renamed from: b */
    private static final List<Class<? extends C0498a>> f853b = new LinkedList();
    /* renamed from: c */
    private static C0498a f854c;
    /* renamed from: d */
    private static ComponentName f855d;

    static {
        f853b.add(AdwHomeBadger.class);
        f853b.add(ApexHomeBadger.class);
        f853b.add(NewHtcHomeBadger.class);
        f853b.add(NovaHomeBadger.class);
        f853b.add(SolidHomeBadger.class);
        f853b.add(SonyHomeBadger.class);
        f853b.add(XiaomiHomeBadger.class);
        f853b.add(AsusHomeLauncher.class);
    }

    /* renamed from: a */
    public static boolean m1323a(Context context, int i) {
        try {
            m1324b(context, i);
            return true;
        } catch (C0499b e) {
            Log.e(f852a, "Unable to execute badge:" + e.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public static void m1324b(Context context, int i) {
        if (f854c == null) {
            m1322a(context);
        }
        try {
            f854c.mo1636a(context, f855d, i);
        } catch (Throwable th) {
            C0499b c0499b = new C0499b("Unable to execute badge:" + th.getMessage());
        }
    }

    /* renamed from: a */
    private static void m1322a(Context context) {
        f855d = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()).getComponent();
        Log.d(f852a, "Finding badger");
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            String str = context.getPackageManager().resolveActivity(intent, 65536).activityInfo.packageName;
            if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
                f854c = new XiaomiHomeBadger();
                return;
            }
            for (Class newInstance : f853b) {
                C0498a c0498a = (C0498a) newInstance.newInstance();
                if (c0498a.mo1635a().contains(str)) {
                    f854c = c0498a;
                    break;
                }
            }
            if (f854c == null) {
                f854c = new DefaultBadger();
            }
            Log.d(f852a, "Current badger:" + f854c.getClass().getCanonicalName());
        } catch (Throwable e) {
            Log.e(f852a, e.getMessage(), e);
        }
    }

    private ShortcutBadger() {
    }
}
