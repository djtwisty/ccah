package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzeb extends zzf {
    private final zzes zzasb;
    private zzaj zzasc;
    private volatile Boolean zzasd;
    private final zzy zzase;
    private final zzfj zzasf;
    private final List<Runnable> zzasg = new ArrayList();
    private final zzy zzash;

    protected zzeb(zzbw zzbw) {
        super(zzbw);
        this.zzasf = new zzfj(zzbw.zzbx());
        this.zzasb = new zzes(this);
        this.zzase = new zzec(this, zzbw);
        this.zzash = new zzek(this, zzbw);
    }

    protected final boolean zzgy() {
        return false;
    }

    public final boolean isConnected() {
        zzaf();
        zzcl();
        return this.zzasc != null;
    }

    protected final void zzlg() {
        zzaf();
        zzcl();
        zzf(new zzel(this, zzl(true)));
    }

    @VisibleForTesting
    final void zza(zzaj zzaj, AbstractSafeParcelable abstractSafeParcelable, zzk zzk) {
        zzaf();
        zzgg();
        zzcl();
        boolean zzlh = zzlh();
        int i = 100;
        for (int i2 = 0; i2 < 1001 && r4 == 100; i2++) {
            Object zzr;
            ArrayList arrayList;
            int size;
            int i3;
            AbstractSafeParcelable abstractSafeParcelable2;
            List arrayList2 = new ArrayList();
            if (zzlh) {
                zzr = zzgn().zzr(100);
                if (zzr != null) {
                    arrayList2.addAll(zzr);
                    i = zzr.size();
                    if (abstractSafeParcelable != null && r4 < 100) {
                        arrayList2.add(abstractSafeParcelable);
                    }
                    arrayList = (ArrayList) arrayList2;
                    size = arrayList.size();
                    i3 = 0;
                    while (i3 < size) {
                        zzr = arrayList.get(i3);
                        i3++;
                        abstractSafeParcelable2 = (AbstractSafeParcelable) zzr;
                        if (abstractSafeParcelable2 instanceof zzag) {
                            try {
                                zzaj.zza((zzag) abstractSafeParcelable2, zzk);
                            } catch (RemoteException e) {
                                zzgt().zzjg().zzg("Failed to send event to the service", e);
                            }
                        } else if (abstractSafeParcelable2 instanceof zzfv) {
                            try {
                                zzaj.zza((zzfv) abstractSafeParcelable2, zzk);
                            } catch (RemoteException e2) {
                                zzgt().zzjg().zzg("Failed to send attribute to the service", e2);
                            }
                        } else if (abstractSafeParcelable2 instanceof zzo) {
                            zzgt().zzjg().zzby("Discarding data. Unrecognized parcel type.");
                        } else {
                            try {
                                zzaj.zza((zzo) abstractSafeParcelable2, zzk);
                            } catch (RemoteException e22) {
                                zzgt().zzjg().zzg("Failed to send conditional property to the service", e22);
                            }
                        }
                    }
                }
            }
            i = 0;
            arrayList2.add(abstractSafeParcelable);
            arrayList = (ArrayList) arrayList2;
            size = arrayList.size();
            i3 = 0;
            while (i3 < size) {
                zzr = arrayList.get(i3);
                i3++;
                abstractSafeParcelable2 = (AbstractSafeParcelable) zzr;
                if (abstractSafeParcelable2 instanceof zzag) {
                    zzaj.zza((zzag) abstractSafeParcelable2, zzk);
                } else if (abstractSafeParcelable2 instanceof zzfv) {
                    zzaj.zza((zzfv) abstractSafeParcelable2, zzk);
                } else if (abstractSafeParcelable2 instanceof zzo) {
                    zzgt().zzjg().zzby("Discarding data. Unrecognized parcel type.");
                } else {
                    zzaj.zza((zzo) abstractSafeParcelable2, zzk);
                }
            }
        }
    }

    protected final void zzc(zzag zzag, String str) {
        Preconditions.checkNotNull(zzag);
        zzaf();
        zzcl();
        boolean zzlh = zzlh();
        boolean z = zzlh && zzgn().zza(zzag);
        zzf(new zzem(this, zzlh, z, zzag, zzl(true), str));
    }

    protected final void zzd(zzo zzo) {
        Preconditions.checkNotNull(zzo);
        zzaf();
        zzcl();
        zzgw();
        zzf(new zzen(this, true, zzgn().zzc(zzo), new zzo(zzo), zzl(true), zzo));
    }

    protected final void zza(AtomicReference<List<zzo>> atomicReference, String str, String str2, String str3) {
        zzaf();
        zzcl();
        zzf(new zzeo(this, atomicReference, str, str2, str3, zzl(false)));
    }

    protected final void zza(AtomicReference<List<zzfv>> atomicReference, String str, String str2, String str3, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzep(this, atomicReference, str, str2, str3, z, zzl(false)));
    }

    protected final void zza(zzdq zzdq, String str, String str2, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzeq(this, str, str2, z, zzl(false), zzdq));
    }

    protected final void zzb(zzfv zzfv) {
        zzaf();
        zzcl();
        boolean z = zzlh() && zzgn().zza(zzfv);
        zzf(new zzer(this, z, zzfv, zzl(true)));
    }

    protected final void zza(AtomicReference<List<zzfv>> atomicReference, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzed(this, atomicReference, zzl(false), z));
    }

    protected final void resetAnalyticsData() {
        zzaf();
        zzgg();
        zzcl();
        zzk zzl = zzl(false);
        if (zzlh()) {
            zzgn().resetAnalyticsData();
        }
        zzf(new zzee(this, zzl));
    }

    private final boolean zzlh() {
        zzgw();
        return true;
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzaf();
        zzcl();
        zzf(new zzef(this, atomicReference, zzl(false)));
    }

    public final void getAppInstanceId(zzdq zzdq) {
        zzaf();
        zzcl();
        zzf(new zzeg(this, zzl(false), zzdq));
    }

    protected final void zzld() {
        zzaf();
        zzcl();
        zzf(new zzeh(this, zzl(true)));
    }

    protected final void zza(zzdx zzdx) {
        zzaf();
        zzcl();
        zzf(new zzei(this, zzdx));
    }

    private final void zzcy() {
        zzaf();
        this.zzasf.start();
        this.zzase.zzh(((Long) zzai.zzaka.get()).longValue());
    }

    final void zzdj() {
        Object obj = 1;
        zzaf();
        zzcl();
        if (!isConnected()) {
            if (this.zzasd == null) {
                boolean z;
                zzaf();
                zzcl();
                Boolean zzjx = zzgu().zzjx();
                if (zzjx == null || !zzjx.booleanValue()) {
                    Object obj2;
                    zzgw();
                    if (zzgk().zzje() != 1) {
                        zzgt().zzjo().zzby("Checking service availability");
                        int zzs = zzgr().zzs(12451000);
                        int i;
                        switch (zzs) {
                            case 0:
                                zzgt().zzjo().zzby("Service available");
                                i = 1;
                                z = true;
                                break;
                            case 1:
                                zzgt().zzjo().zzby("Service missing");
                                i = 1;
                                z = false;
                                break;
                            case 2:
                                zzgt().zzjn().zzby("Service container out of date");
                                if (zzgr().zzml() >= 14500) {
                                    zzjx = zzgu().zzjx();
                                    if (zzjx == null || zzjx.booleanValue()) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    obj2 = null;
                                    break;
                                }
                                i = 1;
                                z = false;
                                break;
                                break;
                            case 3:
                                zzgt().zzjj().zzby("Service disabled");
                                obj2 = null;
                                z = false;
                                break;
                            case 9:
                                zzgt().zzjj().zzby("Service invalid");
                                obj2 = null;
                                z = false;
                                break;
                            case 18:
                                zzgt().zzjj().zzby("Service updating");
                                i = 1;
                                z = true;
                                break;
                            default:
                                zzgt().zzjj().zzg("Unexpected service status", Integer.valueOf(zzs));
                                obj2 = null;
                                z = false;
                                break;
                        }
                    }
                    obj2 = 1;
                    z = true;
                    if (!z && zzgv().zzif()) {
                        zzgt().zzjg().zzby("No way to upload. Consider using the full version of Analytics");
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        zzgu().zzg(z);
                    }
                } else {
                    z = true;
                }
                this.zzasd = Boolean.valueOf(z);
            }
            if (this.zzasd.booleanValue()) {
                this.zzasb.zzll();
            } else if (!zzgv().zzif()) {
                zzgw();
                List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                    obj = null;
                }
                if (obj != null) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context context = getContext();
                    zzgw();
                    intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zzasb.zzb(intent);
                    return;
                }
                zzgt().zzjg().zzby("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    final Boolean zzli() {
        return this.zzasd;
    }

    @VisibleForTesting
    protected final void zza(zzaj zzaj) {
        zzaf();
        Preconditions.checkNotNull(zzaj);
        this.zzasc = zzaj;
        zzcy();
        zzlj();
    }

    public final void disconnect() {
        zzaf();
        zzcl();
        this.zzasb.zzlk();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzasb);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.zzasc = null;
    }

    private final void onServiceDisconnected(ComponentName componentName) {
        zzaf();
        if (this.zzasc != null) {
            this.zzasc = null;
            zzgt().zzjo().zzg("Disconnected from device MeasurementService", componentName);
            zzaf();
            zzdj();
        }
    }

    private final void zzcz() {
        zzaf();
        if (isConnected()) {
            zzgt().zzjo().zzby("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    private final void zzf(Runnable runnable) {
        zzaf();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzasg.size()) >= 1000) {
            zzgt().zzjg().zzby("Discarding data. Max runnable queue size reached");
        } else {
            this.zzasg.add(runnable);
            this.zzash.zzh(60000);
            zzdj();
        }
    }

    private final void zzlj() {
        zzaf();
        zzgt().zzjo().zzg("Processing queued up service tasks", Integer.valueOf(this.zzasg.size()));
        for (Runnable run : this.zzasg) {
            try {
                run.run();
            } catch (Exception e) {
                zzgt().zzjg().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzasg.clear();
        this.zzash.cancel();
    }

    private final zzk zzl(boolean z) {
        zzgw();
        return zzgk().zzbs(z ? zzgt().zzjq() : null);
    }

    public final void zza(zzdq zzdq, zzag zzag, String str) {
        zzaf();
        zzcl();
        if (zzgr().zzs(12451000) != 0) {
            zzgt().zzjj().zzby("Not bundling data. Service unavailable or out of date");
            zzgr().zza(zzdq, new byte[0]);
            return;
        }
        zzf(new zzej(this, zzag, str, zzdq));
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
