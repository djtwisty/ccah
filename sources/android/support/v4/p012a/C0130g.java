package android.support.v4.p012a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.a.g */
public final class C0130g {

    /* renamed from: android.support.v4.a.g$a */
    static class C0129a {
        /* renamed from: a */
        private static Method f160a;
        /* renamed from: b */
        private static boolean f161b;

        /* renamed from: a */
        public static IBinder m234a(Bundle bundle, String str) {
            if (!f161b) {
                try {
                    f160a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f160a.setAccessible(true);
                } catch (Throwable e) {
                    Throwable e2;
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e2);
                }
                f161b = true;
            }
            if (f160a != null) {
                try {
                    return (IBinder) f160a.invoke(bundle, new Object[]{str});
                } catch (InvocationTargetException e3) {
                    e2 = e3;
                } catch (IllegalAccessException e4) {
                    e2 = e4;
                } catch (IllegalArgumentException e5) {
                    e2 = e5;
                }
            }
            return null;
            Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
            f160a = null;
            return null;
        }
    }

    /* renamed from: a */
    public static IBinder m235a(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return C0129a.m234a(bundle, str);
    }
}
