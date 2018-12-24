package com.google.android.gms.internal.firebase_auth;

abstract class zzja {
    zzja() {
    }

    abstract int zzb(int i, byte[] bArr, int i2, int i3);

    abstract int zzb(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract String zzg(byte[] bArr, int i, int i2);

    final boolean zze(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }
}
