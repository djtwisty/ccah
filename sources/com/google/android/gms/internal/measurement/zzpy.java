package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzpy implements Runnable {
    private final zzpc zzbor;
    private final zzpx zzbos;
    private final zzpl zzbot;
    private final zzpu zzbou;
    private final Context zzri;

    public zzpy(Context context, zzpl zzpl, zzpc zzpc) {
        this(context, zzpl, zzpc, new zzpx(), new zzpu());
    }

    @VisibleForTesting
    private zzpy(Context context, zzpl zzpl, zzpc zzpc, zzpx zzpx, zzpu zzpu) {
        this.zzri = (Context) Preconditions.checkNotNull(context);
        this.zzbor = (zzpc) Preconditions.checkNotNull(zzpc);
        this.zzbot = zzpl;
        this.zzbos = zzpx;
        this.zzbou = zzpu;
    }

    public final void run() {
        int i;
        String valueOf;
        if (!zzx("android.permission.INTERNET")) {
            zzhk.m1081e("Missing android.permission.INTERNET. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.INTERNET\" />");
            i = 0;
        } else if (zzx("android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzri.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                zzhk.zzab("No network connectivity - Offline");
                i = 0;
            } else {
                i = 1;
            }
        } else {
            zzhk.m1081e("Missing android.permission.ACCESS_NETWORK_STATE. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
            i = 0;
        }
        if (i == 0) {
            this.zzbor.zza(0, 0);
            return;
        }
        zzhk.m1082v("Starting to load resource from Network.");
        zzpw zzpv = new zzpv();
        InputStream inputStream = null;
        String str;
        try {
            String zzb = this.zzbou.zzb(this.zzbot.zzry());
            str = "Loading resource from ";
            valueOf = String.valueOf(zzb);
            if (valueOf.length() != 0) {
                valueOf = str.concat(valueOf);
            } else {
                valueOf = new String(str);
            }
            zzhk.m1082v(valueOf);
            inputStream = zzpv.zzez(zzb);
        } catch (FileNotFoundException e) {
            valueOf = "NetworkLoader: No data was retrieved from the given url: ";
            String valueOf2 = String.valueOf(zzb);
            zzhk.m1081e(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
            this.zzbor.zza(2, 0);
            zzpv.close();
            return;
        } catch (zzqa e2) {
            str = "NetworkLoader: Error when loading resource for url: ";
            valueOf = String.valueOf(zzb);
            zzhk.m1081e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.zzbor.zza(3, 0);
        } catch (Throwable e3) {
            valueOf = e3.getMessage();
            zzhk.zza(new StringBuilder((String.valueOf(zzb).length() + 54) + String.valueOf(valueOf).length()).append("NetworkLoader: Error when loading resource from url: ").append(zzb).append(" ").append(valueOf).toString(), e3);
            this.zzbor.zza(1, 0);
            zzpv.close();
            return;
        } catch (Throwable th) {
            zzpv.close();
        }
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copyStream(inputStream, byteArrayOutputStream);
            this.zzbor.zzf(byteArrayOutputStream.toByteArray());
            zzpv.close();
        } catch (Throwable e32) {
            valueOf = e32.getMessage();
            zzhk.zza(new StringBuilder((String.valueOf(zzb).length() + 66) + String.valueOf(valueOf).length()).append("NetworkLoader: Error when parsing downloaded resources from url: ").append(zzb).append(" ").append(valueOf).toString(), e32);
            this.zzbor.zza(2, 0);
            zzpv.close();
        }
    }

    @VisibleForTesting
    private final boolean zzx(String str) {
        return this.zzri.getPackageManager().checkPermission(str, this.zzri.getPackageName()) == 0;
    }
}
