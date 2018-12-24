package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.Logger;

final class zzjk implements Logger {
    zzjk() {
    }

    public final void error(String str) {
        zzhk.m1081e(str);
    }

    public final void error(Exception exception) {
        zzhk.zza("", exception);
    }

    public final void info(String str) {
        zzhk.zzdm(str);
    }

    public final void verbose(String str) {
        zzhk.m1082v(str);
    }

    public final void warn(String str) {
        zzhk.zzab(str);
    }

    public final void setLogLevel(int i) {
        zzhk.zzab("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    public final int getLogLevel() {
        zzhk.getLogLevel();
        return 3;
    }
}
