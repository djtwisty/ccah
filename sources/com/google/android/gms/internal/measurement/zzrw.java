package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

public class zzrw {
    private static volatile UserManager zzbqz;
    private static volatile boolean zzbra = (!zztj());

    private zzrw() {
    }

    public static boolean zztj() {
        return VERSION.SDK_INT >= 24;
    }

    public static boolean isUserUnlocked(Context context) {
        return !zztj() || zzab(context);
    }

    @TargetApi(24)
    private static boolean zzab(Context context) {
        boolean z = zzbra;
        if (z) {
            return z;
        }
        int i = 1;
        boolean z2 = z;
        while (i <= 2) {
            UserManager zzac = zzac(context);
            if (zzac == null) {
                zzbra = true;
                return true;
            }
            try {
                z2 = zzac.isUserUnlocked() || !zzac.isUserRunning(Process.myUserHandle());
                zzbra = z2;
                z = z2;
                if (z) {
                    return z;
                }
                zzbqz = null;
                return z;
            } catch (Throwable e) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked", e);
                zzbqz = null;
                i++;
            }
        }
        z = z2;
        if (z) {
            return z;
        }
        zzbqz = null;
        return z;
    }

    @TargetApi(24)
    private static UserManager zzac(Context context) {
        UserManager userManager = zzbqz;
        if (userManager == null) {
            synchronized (zzrw.class) {
                userManager = zzbqz;
                if (userManager == null) {
                    userManager = (UserManager) context.getSystemService(UserManager.class);
                    zzbqz = userManager;
                }
            }
        }
        return userManager;
    }
}
