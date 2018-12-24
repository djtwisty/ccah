package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzhs extends zzeh {
    private static final int[] zzaai;
    private final int zzaaj;
    private final zzeh zzaak;
    private final zzeh zzaal;
    private final int zzaam;
    private final int zzaan;

    private zzhs(zzeh zzeh, zzeh zzeh2) {
        this.zzaak = zzeh;
        this.zzaal = zzeh2;
        this.zzaam = zzeh.size();
        this.zzaaj = this.zzaam + zzeh2.size();
        this.zzaan = Math.max(zzeh.zzfc(), zzeh2.zzfc()) + 1;
    }

    static zzeh zza(zzeh zzeh, zzeh zzeh2) {
        if (zzeh2.size() == 0) {
            return zzeh;
        }
        if (zzeh.size() == 0) {
            return zzeh2;
        }
        int size = zzeh2.size() + zzeh.size();
        if (size < 128) {
            return zzb(zzeh, zzeh2);
        }
        if (zzeh instanceof zzhs) {
            zzhs zzhs = (zzhs) zzeh;
            if (zzhs.zzaal.size() + zzeh2.size() < 128) {
                return new zzhs(zzhs.zzaak, zzb(zzhs.zzaal, zzeh2));
            } else if (zzhs.zzaak.zzfc() > zzhs.zzaal.zzfc() && zzhs.zzfc() > zzeh2.zzfc()) {
                return new zzhs(zzhs.zzaak, new zzhs(zzhs.zzaal, zzeh2));
            }
        }
        if (size >= zzaai[Math.max(zzeh.zzfc(), zzeh2.zzfc()) + 1]) {
            return new zzhs(zzeh, zzeh2);
        }
        return new zzhu().zzc(zzeh, zzeh2);
    }

    private static zzeh zzb(zzeh zzeh, zzeh zzeh2) {
        int size = zzeh.size();
        int size2 = zzeh2.size();
        byte[] bArr = new byte[(size + size2)];
        zzeh.zza(bArr, 0, 0, size);
        zzeh2.zza(bArr, 0, size, size2);
        return zzeh.zza(bArr);
    }

    public final byte zzk(int i) {
        zzeh.zze(i, this.zzaaj);
        return zzl(i);
    }

    final byte zzl(int i) {
        if (i < this.zzaam) {
            return this.zzaak.zzl(i);
        }
        return this.zzaal.zzl(i - this.zzaam);
    }

    public final int size() {
        return this.zzaaj;
    }

    public final zzeo zzez() {
        return new zzht(this);
    }

    protected final int zzfc() {
        return this.zzaan;
    }

    protected final boolean zzfd() {
        return this.zzaaj >= zzaai[this.zzaan];
    }

    public final zzeh zzd(int i, int i2) {
        int zzd = zzeh.zzd(i, i2, this.zzaaj);
        if (zzd == 0) {
            return zzeh.zzso;
        }
        if (zzd == this.zzaaj) {
            return this;
        }
        if (i2 <= this.zzaam) {
            return this.zzaak.zzd(i, i2);
        }
        if (i >= this.zzaam) {
            return this.zzaal.zzd(i - this.zzaam, i2 - this.zzaam);
        }
        zzeh zzeh = this.zzaak;
        return new zzhs(zzeh.zzd(i, zzeh.size()), this.zzaal.zzd(0, i2 - this.zzaam));
    }

    protected final void zzb(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.zzaam) {
            this.zzaak.zzb(bArr, i, i2, i3);
        } else if (i >= this.zzaam) {
            this.zzaal.zzb(bArr, i - this.zzaam, i2, i3);
        } else {
            int i4 = this.zzaam - i;
            this.zzaak.zzb(bArr, i, i2, i4);
            this.zzaal.zzb(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    final void zza(zzeg zzeg) {
        this.zzaak.zza(zzeg);
        this.zzaal.zza(zzeg);
    }

    protected final String zza(Charset charset) {
        byte[] bArr;
        int size = size();
        if (size == 0) {
            bArr = zzfv.EMPTY_BYTE_ARRAY;
        } else {
            bArr = new byte[size];
            zzb(bArr, 0, 0, size);
        }
        return new String(bArr, charset);
    }

    public final boolean zzfb() {
        if (this.zzaal.zzb(this.zzaak.zzb(0, 0, this.zzaam), 0, this.zzaal.size()) == 0) {
            return true;
        }
        return false;
    }

    protected final int zzb(int i, int i2, int i3) {
        if (i2 + i3 <= this.zzaam) {
            return this.zzaak.zzb(i, i2, i3);
        }
        if (i2 >= this.zzaam) {
            return this.zzaal.zzb(i, i2 - this.zzaam, i3);
        }
        int i4 = this.zzaam - i2;
        return this.zzaal.zzb(this.zzaak.zzb(i, i2, i4), 0, i3 - i4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeh)) {
            return false;
        }
        zzeh zzeh = (zzeh) obj;
        if (this.zzaaj != zzeh.size()) {
            return false;
        }
        if (this.zzaaj == 0) {
            return true;
        }
        int zzfe = zzfe();
        int zzfe2 = zzeh.zzfe();
        if (zzfe != 0 && zzfe2 != 0 && zzfe != zzfe2) {
            return false;
        }
        Iterator zzhv = new zzhv(this, null);
        zzeh zzeh2 = (zzeq) zzhv.next();
        Iterator zzhv2 = new zzhv(zzeh, null);
        int i = 0;
        zzeh zzeh3 = (zzeq) zzhv2.next();
        int i2 = 0;
        zzeh zzeh4 = zzeh2;
        int i3 = 0;
        while (true) {
            boolean zza;
            int size = zzeh4.size() - i3;
            int size2 = zzeh3.size() - i2;
            int min = Math.min(size, size2);
            if (i3 == 0) {
                zza = zzeh4.zza(zzeh3, i2, min);
            } else {
                zza = zzeh3.zza(zzeh4, i3, min);
            }
            if (!zza) {
                return false;
            }
            zzfe2 = i + min;
            if (zzfe2 >= this.zzaaj) {
                break;
            }
            if (min == size) {
                zzeh4 = (zzeq) zzhv.next();
                i3 = 0;
            } else {
                i3 += min;
            }
            if (min == size2) {
                i = zzfe2;
                zzeh3 = (zzeq) zzhv2.next();
                i2 = 0;
            } else {
                i = zzfe2;
                i2 += min;
            }
        }
        if (zzfe2 == this.zzaaj) {
            return true;
        }
        throw new IllegalStateException();
    }

    protected final int zzc(int i, int i2, int i3) {
        if (i2 + i3 <= this.zzaam) {
            return this.zzaak.zzc(i, i2, i3);
        }
        if (i2 >= this.zzaam) {
            return this.zzaal.zzc(i, i2 - this.zzaam, i3);
        }
        int i4 = this.zzaam - i2;
        return this.zzaal.zzc(this.zzaak.zzc(i, i2, i4), 0, i3 - i4);
    }

    public final /* synthetic */ Iterator iterator() {
        return zzez();
    }

    static {
        List arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
        zzaai = new int[arrayList.size()];
        for (i3 = 0; i3 < zzaai.length; i3++) {
            zzaai[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
    }
}
