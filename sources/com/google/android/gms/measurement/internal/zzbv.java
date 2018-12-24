package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

final class zzbv extends Thread {
    private final /* synthetic */ zzbr zzapb;
    private final Object zzape = new Object();
    private final BlockingQueue<zzbu<?>> zzapf;

    public zzbv(zzbr zzbr, String str, BlockingQueue<zzbu<?>> blockingQueue) {
        this.zzapb = zzbr;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzapf = blockingQueue;
        setName(str);
    }

    public final void run() {
        Object obj = null;
        while (obj == null) {
            try {
                this.zzapb.zzaox.acquire();
                obj = 1;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        int threadPriority = Process.getThreadPriority(Process.myTid());
        while (true) {
            zzbu zzbu = (zzbu) this.zzapf.poll();
            if (zzbu != null) {
                Process.setThreadPriority(zzbu.zzapd ? threadPriority : 10);
                zzbu.run();
            } else {
                try {
                    synchronized (this.zzape) {
                        if (this.zzapf.peek() == null && !this.zzapb.zzaoy) {
                            try {
                                this.zzape.wait(30000);
                            } catch (InterruptedException e2) {
                                zza(e2);
                            }
                        }
                    }
                    synchronized (this.zzapb.zzaow) {
                        if (this.zzapf.peek() == null) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (this.zzapb.zzaow) {
                        this.zzapb.zzaox.release();
                        this.zzapb.zzaow.notifyAll();
                        if (this == this.zzapb.zzaoq) {
                            this.zzapb.zzaoq = null;
                        } else if (this == this.zzapb.zzaor) {
                            this.zzapb.zzaor = null;
                        } else {
                            this.zzapb.zzgt().zzjg().zzby("Current scheduler thread is neither worker nor network");
                        }
                    }
                }
            }
        }
        synchronized (this.zzapb.zzaow) {
            this.zzapb.zzaox.release();
            this.zzapb.zzaow.notifyAll();
            if (this == this.zzapb.zzaoq) {
                this.zzapb.zzaoq = null;
            } else if (this == this.zzapb.zzaor) {
                this.zzapb.zzaor = null;
            } else {
                this.zzapb.zzgt().zzjg().zzby("Current scheduler thread is neither worker nor network");
            }
        }
    }

    public final void zzki() {
        synchronized (this.zzape) {
            this.zzape.notifyAll();
        }
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzapb.zzgt().zzjj().zzg(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
