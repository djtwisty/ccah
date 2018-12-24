package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

final class zzgz extends Thread implements zzgy {
    private static zzgz zzbjf;
    private volatile boolean closed = false;
    private final LinkedBlockingQueue<Runnable> zzbcm = new LinkedBlockingQueue();
    private volatile boolean zzbcn = false;
    private volatile zzhb zzbjg;
    private final Context zzri;
    private final Clock zzrz = DefaultClock.getInstance();

    static zzgz zzz(Context context) {
        if (zzbjf == null) {
            zzbjf = new zzgz(context);
        }
        return zzbjf;
    }

    private zzgz(Context context) {
        super("GAThread");
        if (context != null) {
            this.zzri = context.getApplicationContext();
        } else {
            this.zzri = context;
        }
        start();
    }

    public final void zzb(String str, String str2, String str3, Map<String, String> map, String str4) {
        zzh(new zzha(this, this, this.zzrz.currentTimeMillis(), str, str2, str3, map, str4));
    }

    public final void zzh(Runnable runnable) {
        this.zzbcm.add(runnable);
    }

    public final void run() {
        while (true) {
            boolean z = this.closed;
            try {
                Runnable runnable = (Runnable) this.zzbcm.take();
                if (!this.zzbcn) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                try {
                    zzhk.zzdm(e.toString());
                } catch (Throwable e2) {
                    String str = "Error on Google TagManager Thread: ";
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    PrintStream printStream = new PrintStream(byteArrayOutputStream);
                    zzsr.zza(e2, printStream);
                    printStream.flush();
                    String valueOf = String.valueOf(new String(byteArrayOutputStream.toByteArray()));
                    zzhk.m1081e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    zzhk.m1081e("Google TagManager is shutting down.");
                    this.zzbcn = true;
                }
            }
        }
    }
}
