package android.support.v4.p012a;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/* renamed from: android.support.v4.a.ah */
public final class ah {
    /* renamed from: a */
    private static final Object f102a = new Object();
    /* renamed from: b */
    private static Set<String> f103b = new HashSet();
    /* renamed from: e */
    private static final Object f104e = new Object();
    /* renamed from: c */
    private final Context f105c;
    /* renamed from: d */
    private final NotificationManager f106d = ((NotificationManager) this.f105c.getSystemService("notification"));

    /* renamed from: a */
    public static ah m175a(Context context) {
        return new ah(context);
    }

    private ah(Context context) {
        this.f105c = context;
    }

    /* renamed from: a */
    public boolean m176a() {
        if (VERSION.SDK_INT >= 24) {
            return this.f106d.areNotificationsEnabled();
        }
        if (VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f105c.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f105c.getApplicationInfo();
        String packageName = this.f105c.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            return ((Integer) Class.forName(AppOpsManager.class.getName()).getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) Class.forName(AppOpsManager.class.getName()).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() == 0;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (NoSuchMethodException e2) {
            return true;
        } catch (NoSuchFieldException e3) {
            return true;
        } catch (InvocationTargetException e4) {
            return true;
        } catch (IllegalAccessException e5) {
            return true;
        } catch (RuntimeException e6) {
            return true;
        }
    }
}
