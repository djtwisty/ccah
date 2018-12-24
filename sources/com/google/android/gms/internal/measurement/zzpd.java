package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzpd {
    private String zzbaw;
    private final zzpo zzbnt;
    @VisibleForTesting
    private final Map<String, zzpg<zzqb>> zzbnu;
    private final Map<String, zzpz> zzbnv;
    private final Context zzri;
    private final Clock zzrz;

    public zzpd(Context context) {
        this(context, new HashMap(), new zzpo(context), DefaultClock.getInstance());
    }

    @VisibleForTesting
    private zzpd(Context context, Map<String, zzpz> map, zzpo zzpo, Clock clock) {
        this.zzbaw = null;
        this.zzbnu = new HashMap();
        this.zzri = context.getApplicationContext();
        this.zzrz = clock;
        this.zzbnt = zzpo;
        this.zzbnv = map;
    }

    public final void zza(String str, String str2, String str3, List<Integer> list, zzpe zzpe, zzgo zzgo) {
        boolean z;
        Preconditions.checkArgument(!list.isEmpty());
        zzpl zzpl = new zzpl();
        zzhs zzrf = zzhs.zzrf();
        if (zzrf.isPreview() && str.equals(zzrf.getContainerId())) {
            z = true;
        } else {
            z = false;
        }
        zza(zzpl.zza(new zzoz(str, str2, str3, z, zzhs.zzrf().zzrg())), Collections.unmodifiableList(list), 0, zzpe, zzgo);
    }

    @VisibleForTesting
    final void zza(zzpl zzpl, List<Integer> list, int i, zzpe zzpe, zzgo zzgo) {
        zzgo zzgo2 = zzgo;
        zzpe zzpe2 = zzpe;
        int i2 = i;
        List<Integer> list2 = list;
        zzpl zzpl2 = zzpl;
        zzpd zzpd = this;
        while (true) {
            if (i2 == 0) {
                zzhk.m1082v("Starting to fetch a new resource");
            }
            if (i2 >= list2.size()) {
                String str = "There is no valid resource for the container: ";
                String valueOf = String.valueOf(zzpl2.zzry().getContainerId());
                valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
                zzhk.m1082v(valueOf);
                zzpe2.zza(new zzpm(new Status(16, valueOf), ((Integer) list2.get(i2 - 1)).intValue()));
                return;
            }
            zzoz zzry;
            String containerId;
            switch (((Integer) list2.get(i2)).intValue()) {
                case 0:
                    Object obj;
                    zzoz zzry2 = zzpl2.zzry();
                    zzpg zzpg = (zzpg) zzpd.zzbnu.get(zzry2.getContainerId());
                    if (zzpl2.zzry().zzru()) {
                        obj = 1;
                    } else {
                        long zzrx;
                        if (zzpg != null) {
                            zzrx = zzpg.zzrx();
                        } else {
                            zzrx = zzpd.zzbnt.zzew(zzry2.getContainerId());
                        }
                        if (zzrx + 900000 < zzpd.zzrz.currentTimeMillis()) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        zzpz zzpz;
                        zzpz zzpz2 = (zzpz) zzpd.zzbnv.get(zzpl2.getId());
                        if (zzpz2 == null) {
                            zzpz2 = new zzpz();
                            zzpd.zzbnv.put(zzpl2.getId(), zzpz2);
                            zzpz = zzpz2;
                        } else {
                            zzpz = zzpz2;
                        }
                        valueOf = zzry2.getContainerId();
                        zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Attempting to fetch container ").append(valueOf).append(" from network").toString());
                        zzpz.zza(zzpd.zzri, zzpl2, 0, new zzpf(zzpd, 0, zzpl2, zzpi.zzbob, list2, i2, zzpe2, zzgo2));
                        return;
                    }
                    i2++;
                case 1:
                    zzry = zzpl2.zzry();
                    containerId = zzry.getContainerId();
                    zzhk.m1082v(new StringBuilder(String.valueOf(containerId).length() + 52).append("Attempting to fetch container ").append(containerId).append(" from a saved resource").toString());
                    zzpd.zzbnt.zza(zzry.zzrt(), new zzpf(zzpd, 1, zzpl2, zzpi.zzbob, list2, i2, zzpe2, null));
                    return;
                case 2:
                    zzry = zzpl2.zzry();
                    containerId = zzry.getContainerId();
                    zzhk.m1082v(new StringBuilder(String.valueOf(containerId).length() + 56).append("Attempting to fetch container ").append(containerId).append(" from the default resource").toString());
                    zzpd.zzbnt.zza(zzry.zzrt(), zzry.zzrr(), new zzpf(zzpd, 2, zzpl2, zzpi.zzbob, list2, i2, zzpe2, null));
                    return;
                default:
                    throw new UnsupportedOperationException("Unknown fetching source: " + i2);
            }
        }
    }

    @VisibleForTesting
    final void zza(Status status, zzpn zzpn) {
        String containerId = zzpn.zzsd().getContainerId();
        zzqb zzse = zzpn.zzse();
        if (this.zzbnu.containsKey(containerId)) {
            zzpg zzpg = (zzpg) this.zzbnu.get(containerId);
            zzpg.zzas(this.zzrz.currentTimeMillis());
            if (status == Status.RESULT_SUCCESS) {
                zzpg.zzb(status);
                zzpg.zzq(zzse);
                return;
            }
            return;
        }
        this.zzbnu.put(containerId, new zzpg(status, zzse, this.zzrz.currentTimeMillis()));
    }
}
