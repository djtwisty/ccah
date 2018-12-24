package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Random;

@ShowFirstParty
public final class zzgo {
    private final String zzazo;
    private final Random zzbav;
    private final Context zzri;

    public zzgo(Context context, String str) {
        this(context, str, new Random());
    }

    private zzgo(Context context, String str, Random random) {
        this.zzri = (Context) Preconditions.checkNotNull(context);
        this.zzazo = (String) Preconditions.checkNotNull(str);
        this.zzbav = random;
    }

    public final long zznz() {
        return 43200000 + zzd(7200000, 259200000);
    }

    public final long zzoa() {
        return 3600000 + zzd(600000, 86400000);
    }

    public final long zzqr() {
        if (Math.max(0, zzod().getLong("FORBIDDEN_COUNT", 0)) == 0) {
            return 0;
        }
        return zzd(10000, 600000) + 10000;
    }

    public final boolean zzqs() {
        return Math.max(0, zzod().getLong("FORBIDDEN_COUNT", 0)) > 0;
    }

    private final long zzd(long j, long j2) {
        SharedPreferences zzod = zzod();
        long max = Math.max(0, zzod.getLong("FORBIDDEN_COUNT", 0));
        return (long) (((float) (((long) ((((float) max) / ((float) ((Math.max(0, zzod.getLong("SUCCESSFUL_COUNT", 0)) + max) + 1))) * ((float) (j2 - j)))) + j)) * this.zzbav.nextFloat());
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzob() {
        long j;
        SharedPreferences zzod = zzod();
        long j2 = zzod.getLong("FORBIDDEN_COUNT", 0);
        long j3 = zzod.getLong("SUCCESSFUL_COUNT", 0);
        Editor edit = zzod.edit();
        if (j2 == 0) {
            j = 3;
        } else {
            j = Math.min(10, 1 + j2);
        }
        j2 = Math.max(0, Math.min(j3, 10 - j));
        edit.putLong("FORBIDDEN_COUNT", j);
        edit.putLong("SUCCESSFUL_COUNT", j2);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    public final void zzoc() {
        SharedPreferences zzod = zzod();
        long j = zzod.getLong("SUCCESSFUL_COUNT", 0);
        long j2 = zzod.getLong("FORBIDDEN_COUNT", 0);
        j = Math.min(10, j + 1);
        j2 = Math.max(0, Math.min(j2, 10 - j));
        Editor edit = zzod.edit();
        edit.putLong("SUCCESSFUL_COUNT", j);
        edit.putLong("FORBIDDEN_COUNT", j2);
        edit.apply();
    }

    private final SharedPreferences zzod() {
        Context context = this.zzri;
        String valueOf = String.valueOf("v5_gtmContainerRefreshPolicy_");
        String valueOf2 = String.valueOf(this.zzazo);
        return context.getSharedPreferences(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), 0);
    }
}
