package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

@KeepForSdk
public class ProcessUtils {
    private static String zzhe = null;
    private static int zzhf = 0;

    private ProcessUtils() {
    }

    @KeepForSdk
    public static String getMyProcessName() {
        if (zzhe == null) {
            if (zzhf == 0) {
                zzhf = Process.myPid();
            }
            zzhe = zzd(zzhf);
        }
        return zzhe;
    }

    private static String zzd(int i) {
        Throwable th;
        Closeable closeable;
        String str = null;
        if (i > 0) {
            Closeable zzj;
            try {
                zzj = zzj("/proc/" + i + "/cmdline");
                try {
                    str = zzj.readLine().trim();
                    IOUtils.closeQuietly(zzj);
                } catch (IOException e) {
                    IOUtils.closeQuietly(zzj);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = zzj;
                    IOUtils.closeQuietly(closeable);
                    throw th;
                }
            } catch (IOException e2) {
                zzj = str;
                IOUtils.closeQuietly(zzj);
                return str;
            } catch (Throwable th3) {
                th = th3;
                closeable = str;
                IOUtils.closeQuietly(closeable);
                throw th;
            }
        }
        return str;
    }

    private static BufferedReader zzj(String str) {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            return bufferedReader;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
