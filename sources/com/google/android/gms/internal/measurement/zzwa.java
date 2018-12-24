package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzwa<T> implements zzwl<T> {
    private final zzvv zzcau;
    private final boolean zzcav;
    private final zzxd<?, ?> zzcbe;
    private final zzuc<?> zzcbf;

    private zzwa(zzxd<?, ?> zzxd, zzuc<?> zzuc, zzvv zzvv) {
        this.zzcbe = zzxd;
        this.zzcav = zzuc.zze(zzvv);
        this.zzcbf = zzuc;
        this.zzcau = zzvv;
    }

    static <T> zzwa<T> zza(zzxd<?, ?> zzxd, zzuc<?> zzuc, zzvv zzvv) {
        return new zzwa(zzxd, zzuc, zzvv);
    }

    public final T newInstance() {
        return this.zzcau.zzwi().zzwn();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzcbe.zzal(t).equals(this.zzcbe.zzal(t2))) {
            return false;
        }
        if (this.zzcav) {
            return this.zzcbf.zzw(t).equals(this.zzcbf.zzw(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzcbe.zzal(t).hashCode();
        if (this.zzcav) {
            return (hashCode * 53) + this.zzcbf.zzw(t).hashCode();
        }
        return hashCode;
    }

    public final void zzd(T t, T t2) {
        zzwn.zza(this.zzcbe, (Object) t, (Object) t2);
        if (this.zzcav) {
            zzwn.zza(this.zzcbf, (Object) t, (Object) t2);
        }
    }

    public final void zza(T t, zzxy zzxy) {
        Iterator it = this.zzcbf.zzw(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzuh zzuh = (zzuh) entry.getKey();
            if (zzuh.zzwa() != zzxx.MESSAGE || zzuh.zzwb() || zzuh.zzwc()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzva) {
                zzxy.zza(zzuh.zzc(), ((zzva) entry).zzxa().zztw());
            } else {
                zzxy.zza(zzuh.zzc(), entry.getValue());
            }
        }
        zzxd zzxd = this.zzcbe;
        zzxd.zzc(zzxd.zzal(t), zzxy);
    }

    public final void zza(T t, zzwk zzwk, zzub zzub) {
        zzxd zzxd = this.zzcbe;
        zzuc zzuc = this.zzcbf;
        Object zzam = zzxd.zzam(t);
        zzuf zzx = zzuc.zzx(t);
        while (zzwk.zzvh() != BaseClientBuilder.API_PRIORITY_OTHER) {
            try {
                boolean zza;
                int tag = zzwk.getTag();
                Object zza2;
                if (tag != 11) {
                    if ((tag & 7) == 2) {
                        zza2 = zzuc.zza(zzub, this.zzcau, tag >>> 3);
                        if (zza2 != null) {
                            zzuc.zza(zzwk, zza2, zzub, zzx);
                        } else {
                            zza = zzxd.zza(zzam, zzwk);
                            continue;
                        }
                    } else {
                        zza = zzwk.zzvi();
                        continue;
                    }
                    if (!zza) {
                        return;
                    }
                }
                int i = 0;
                zza2 = null;
                zzte zzte = null;
                while (zzwk.zzvh() != BaseClientBuilder.API_PRIORITY_OTHER) {
                    int tag2 = zzwk.getTag();
                    if (tag2 == 16) {
                        i = zzwk.zzus();
                        zza2 = zzuc.zza(zzub, this.zzcau, i);
                    } else if (tag2 == 26) {
                        if (zza2 != null) {
                            zzuc.zza(zzwk, zza2, zzub, zzx);
                        } else {
                            zzte = zzwk.zzur();
                        }
                    } else if (!zzwk.zzvi()) {
                        break;
                    }
                }
                if (zzwk.getTag() != 12) {
                    throw zzuv.zzwt();
                } else if (zzte != null) {
                    if (zza2 != null) {
                        zzuc.zza(zzte, zza2, zzub, zzx);
                    } else {
                        zzxd.zza(zzam, i, zzte);
                    }
                }
                zza = true;
                continue;
                if (zza) {
                    return;
                }
            } finally {
                zzxd.zzg(t, zzam);
            }
        }
        zzxd.zzg(t, zzam);
    }

    public final void zzy(T t) {
        this.zzcbe.zzy(t);
        this.zzcbf.zzy(t);
    }

    public final boolean zzaj(T t) {
        return this.zzcbf.zzw(t).isInitialized();
    }

    public final int zzai(T t) {
        zzxd zzxd = this.zzcbe;
        int zzan = zzxd.zzan(zzxd.zzal(t)) + 0;
        if (this.zzcav) {
            return zzan + this.zzcbf.zzw(t).zzvy();
        }
        return zzan;
    }
}
