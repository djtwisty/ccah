package com.google.android.gms.internal.measurement;

public final class zzpn {
    private final zzqb zzbke;
    private final byte[] zzbog;
    private final long zzboh;
    private final zzoz zzboi;

    public zzpn(zzqb zzqb) {
        this(null, null, zzqb, 0);
    }

    public zzpn(zzoz zzoz, byte[] bArr, zzqb zzqb, long j) {
        this.zzboi = zzoz;
        this.zzbog = bArr;
        this.zzbke = zzqb;
        this.zzboh = j;
    }

    public final byte[] zzsc() {
        return this.zzbog;
    }

    public final zzoz zzsd() {
        return this.zzboi;
    }

    public final zzqb zzse() {
        return this.zzbke;
    }

    public final long zzsf() {
        return this.zzboh;
    }
}
