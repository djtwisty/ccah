package android.support.v4.p013b;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.support.v4.p012a.C0120b;

/* renamed from: android.support.v4.b.e */
public final class C0212e {
    /* renamed from: a */
    public static int m655a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0120b.m203a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0120b.m202a(context, a, str2) != 0 ? -2 : 0;
    }

    /* renamed from: a */
    public static int m654a(Context context, String str) {
        return C0212e.m655a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    /* renamed from: b */
    public static int m656b(Context context, String str) {
        return C0212e.m655a(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }
}
