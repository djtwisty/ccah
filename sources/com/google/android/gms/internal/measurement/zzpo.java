package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class zzpo {
    private final ExecutorService zzadl;
    private final zzpt zzboj;
    private final Context zzri;

    public zzpo(Context context) {
        this(context, Executors.newSingleThreadExecutor(), new zzpp(context));
    }

    @VisibleForTesting
    private zzpo(Context context, ExecutorService executorService, zzpt zzpt) {
        this.zzri = context;
        this.zzadl = executorService;
        this.zzboj = zzpt;
    }

    public final void zza(String str, zzpc zzpc) {
        this.zzadl.execute(new zzpq(this, str, zzpc));
    }

    @VisibleForTesting
    final void zzb(String str, zzpc zzpc) {
        zzhk.m1082v("Starting to load a saved resource file from Disk.");
        try {
            zzpc.zzf(zza(new FileInputStream(zzex(str))));
        } catch (FileNotFoundException e) {
            String str2 = "Saved resource not found: ";
            String valueOf = String.valueOf(zzey(str));
            zzhk.m1081e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            zzpc.zza(0, 1);
        }
    }

    public final void zza(String str, String str2, zzpc zzpc) {
        this.zzadl.execute(new zzpr(this, str, str2, zzpc));
    }

    @VisibleForTesting
    final void zzb(String str, String str2, zzpc zzpc) {
        zzhk.m1082v("Starting to load a default asset file from Disk.");
        if (str2 == null) {
            zzhk.m1082v("Default asset file is not specified. Not proceeding with the loading");
            zzpc.zza(0, 2);
            return;
        }
        try {
            InputStream open = this.zzboj.open(str2);
            if (open != null) {
                zzpc.zzf(zza(open));
            } else {
                zzpc.zza(0, 2);
            }
        } catch (IOException e) {
            zzhk.m1081e(new StringBuilder((String.valueOf(str).length() + 42) + String.valueOf(str2).length()).append("Default asset file not found. ").append(str).append(". Filename: ").append(str2).toString());
            zzpc.zza(0, 2);
        }
    }

    public final void zzb(String str, byte[] bArr) {
        this.zzadl.execute(new zzps(this, str, bArr));
    }

    @VisibleForTesting
    final void zzc(String str, byte[] bArr) {
        File zzex = zzex(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzex);
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                    zzhk.m1082v(new StringBuilder(String.valueOf(str).length() + 24).append("Resource ").append(str).append(" saved on Disk.").toString());
                } catch (IOException e) {
                    zzhk.m1081e("Error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                zzhk.m1081e("Error writing resource to disk. Removing resource from disk");
                zzex.delete();
                try {
                    fileOutputStream.close();
                    zzhk.m1082v(new StringBuilder(String.valueOf(str).length() + 24).append("Resource ").append(str).append(" saved on Disk.").toString());
                } catch (IOException e3) {
                    zzhk.m1081e("Error closing stream for writing resource to disk");
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                    zzhk.m1082v(new StringBuilder(String.valueOf(str).length() + 24).append("Resource ").append(str).append(" saved on Disk.").toString());
                } catch (IOException e4) {
                    zzhk.m1081e("Error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            zzhk.m1081e("Error opening resource file for writing");
        }
    }

    public final long zzew(String str) {
        File zzex = zzex(str);
        return zzex.exists() ? zzex.lastModified() : 0;
    }

    @VisibleForTesting
    private final File zzex(String str) {
        return new File(this.zzri.getDir("google_tagmanager", 0), zzey(str));
    }

    private static String zzey(String str) {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private static byte[] zza(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            IOUtils.copyStream(inputStream, byteArrayOutputStream);
        } catch (IOException e) {
            zzhk.zzab("Failed to read the resource from disk");
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                zzhk.zzab("Error closing stream for reading resource from disk");
                return null;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
