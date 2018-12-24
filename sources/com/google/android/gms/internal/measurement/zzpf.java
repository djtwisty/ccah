package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

@VisibleForTesting
final class zzpf extends zzpc {
    private final zzpe zzbnw;
    private final List<Integer> zzbnx;
    private final int zzbny;
    private final /* synthetic */ zzpd zzbnz;

    zzpf(zzpd zzpd, int i, zzpl zzpl, zzph zzph, List<Integer> list, int i2, zzpe zzpe, zzgo zzgo) {
        this.zzbnz = zzpd;
        super(i, zzpl, zzph, zzgo);
        this.zzbnw = zzpe;
        this.zzbnx = list;
        this.zzbny = i2;
    }

    protected final void zza(zzpm zzpm) {
        String valueOf;
        Object obj;
        String zzsb;
        if (zzpm.getStatus() == Status.RESULT_SUCCESS) {
            String str = "Container resource successfully loaded from ";
            valueOf = String.valueOf(zzpm.zzsb());
            if (valueOf.length() != 0) {
                valueOf = str.concat(valueOf);
            } else {
                valueOf = new String(str);
            }
            zzhk.m1082v(valueOf);
            if (zzpm.getSource() == 0) {
                zzpn zzrz = zzpm.zzrz();
                if (!zzrz.zzsd().zzru()) {
                    this.zzbnz.zza(zzpm.getStatus(), zzrz);
                    if (zzrz.zzsc() != null && zzrz.zzsc().length > 0) {
                        this.zzbnz.zzbnt.zzb(zzrz.zzsd().zzrt(), zzrz.zzsc());
                        obj = 1;
                        if (obj != null) {
                            this.zzbnw.zza(zzpm);
                            return;
                        }
                        zzsb = zzpm.zzsb();
                        valueOf = zzpm.getStatus().isSuccess() ? "SUCCESS" : "FAILURE";
                        zzhk.m1082v(new StringBuilder((String.valueOf(zzsb).length() + 54) + String.valueOf(valueOf).length()).append("Cannot fetch a valid resource from ").append(zzsb).append(". Response status: ").append(valueOf).toString());
                        if (zzpm.getStatus().isSuccess()) {
                            zzsb = "Response source: ";
                            valueOf = String.valueOf(zzpm.zzsb());
                            zzhk.m1082v(valueOf.length() != 0 ? zzsb.concat(valueOf) : new String(zzsb));
                            zzhk.m1082v("Response size: " + zzpm.zzrz().zzsc().length);
                        }
                        this.zzbnz.zza(this.zzbnp, this.zzbnx, this.zzbny + 1, this.zzbnw, this.zzbns);
                    }
                }
            }
            int i = 1;
            if (obj != null) {
                zzsb = zzpm.zzsb();
                if (zzpm.getStatus().isSuccess()) {
                }
                zzhk.m1082v(new StringBuilder((String.valueOf(zzsb).length() + 54) + String.valueOf(valueOf).length()).append("Cannot fetch a valid resource from ").append(zzsb).append(". Response status: ").append(valueOf).toString());
                if (zzpm.getStatus().isSuccess()) {
                    zzsb = "Response source: ";
                    valueOf = String.valueOf(zzpm.zzsb());
                    if (valueOf.length() != 0) {
                    }
                    zzhk.m1082v(valueOf.length() != 0 ? zzsb.concat(valueOf) : new String(zzsb));
                    zzhk.m1082v("Response size: " + zzpm.zzrz().zzsc().length);
                }
                this.zzbnz.zza(this.zzbnp, this.zzbnx, this.zzbny + 1, this.zzbnw, this.zzbns);
            }
            this.zzbnw.zza(zzpm);
            return;
        }
        obj = null;
        if (obj != null) {
            this.zzbnw.zza(zzpm);
            return;
        }
        zzsb = zzpm.zzsb();
        if (zzpm.getStatus().isSuccess()) {
        }
        zzhk.m1082v(new StringBuilder((String.valueOf(zzsb).length() + 54) + String.valueOf(valueOf).length()).append("Cannot fetch a valid resource from ").append(zzsb).append(". Response status: ").append(valueOf).toString());
        if (zzpm.getStatus().isSuccess()) {
            zzsb = "Response source: ";
            valueOf = String.valueOf(zzpm.zzsb());
            if (valueOf.length() != 0) {
            }
            zzhk.m1082v(valueOf.length() != 0 ? zzsb.concat(valueOf) : new String(zzsb));
            zzhk.m1082v("Response size: " + zzpm.zzrz().zzsc().length);
        }
        this.zzbnz.zza(this.zzbnp, this.zzbnx, this.zzbny + 1, this.zzbnw, this.zzbns);
    }
}
