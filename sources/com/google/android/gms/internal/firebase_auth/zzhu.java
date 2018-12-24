package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayDeque;
import java.util.Arrays;

final class zzhu {
    private final ArrayDeque<zzeh> zzaar;

    private zzhu() {
        this.zzaar = new ArrayDeque();
    }

    private final zzeh zzc(zzeh zzeh, zzeh zzeh2) {
        zzd(zzeh);
        zzd(zzeh2);
        zzeh zzeh3 = (zzeh) this.zzaar.pop();
        while (!this.zzaar.isEmpty()) {
            zzeh3 = new zzhs((zzeh) this.zzaar.pop(), zzeh3);
        }
        return zzeh3;
    }

    private final void zzd(zzeh zzeh) {
        zzeh zzeh2 = zzeh;
        while (!zzeh2.zzfd()) {
            if (zzeh2 instanceof zzhs) {
                zzhs zzhs = (zzhs) zzeh2;
                zzd(zzhs.zzaak);
                zzeh2 = zzhs.zzaal;
            } else {
                String valueOf = String.valueOf(zzeh2.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 49).append("Has a new type of ByteString been created? Found ").append(valueOf).toString());
            }
        }
        int zzba = zzba(zzeh2.size());
        int i = zzhs.zzaai[zzba + 1];
        if (this.zzaar.isEmpty() || ((zzeh) this.zzaar.peek()).size() >= i) {
            this.zzaar.push(zzeh2);
            return;
        }
        int i2 = zzhs.zzaai[zzba];
        zzeh zzeh3 = (zzeh) this.zzaar.pop();
        while (!this.zzaar.isEmpty() && ((zzeh) this.zzaar.peek()).size() < i2) {
            zzeh3 = new zzhs((zzeh) this.zzaar.pop(), zzeh3);
        }
        zzeh2 = new zzhs(zzeh3, zzeh2);
        while (!this.zzaar.isEmpty()) {
            if (((zzeh) this.zzaar.peek()).size() >= zzhs.zzaai[zzba(zzeh2.size()) + 1]) {
                break;
            }
            zzeh2 = new zzhs((zzeh) this.zzaar.pop(), zzeh2);
        }
        this.zzaar.push(zzeh2);
    }

    private static int zzba(int i) {
        int binarySearch = Arrays.binarySearch(zzhs.zzaai, i);
        if (binarySearch < 0) {
            return (-(binarySearch + 1)) - 1;
        }
        return binarySearch;
    }
}
