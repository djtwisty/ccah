package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;

@VisibleForTesting
public final class zzak extends zzau {
    private static boolean zzvk;
    private Info zzvl;
    private final zzdc zzvm;
    private String zzvn;
    private boolean zzvo = false;
    private final Object zzvp = new Object();

    zzak(zzaw zzaw) {
        super(zzaw);
        this.zzvm = new zzdc(zzaw.zzbx());
    }

    protected final void zzag() {
    }

    public final boolean zzbg() {
        zzcl();
        Info zzbo = zzbo();
        if (zzbo == null || zzbo.isLimitAdTrackingEnabled()) {
            return false;
        }
        return true;
    }

    public final String zzbn() {
        CharSequence id;
        zzcl();
        Info zzbo = zzbo();
        if (zzbo != null) {
            id = zzbo.getId();
        } else {
            id = null;
        }
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }

    private final synchronized Info zzbo() {
        if (this.zzvm.zzj(1000)) {
            this.zzvm.start();
            Info zzbp = zzbp();
            if (zza(this.zzvl, zzbp)) {
                this.zzvl = zzbp;
            } else {
                zzu("Failed to reset client id on adid change. Not using adid");
                this.zzvl = new Info("", false);
            }
        }
        return this.zzvl;
    }

    private final boolean zza(Info info, Info info2) {
        Object obj = null;
        CharSequence id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zzdr = zzcg().zzdr();
        synchronized (this.zzvp) {
            String valueOf;
            String valueOf2;
            if (!this.zzvo) {
                this.zzvn = zzbq();
                this.zzvo = true;
            } else if (TextUtils.isEmpty(this.zzvn)) {
                if (info != null) {
                    obj = info.getId();
                }
                if (obj == null) {
                    valueOf = String.valueOf(id);
                    String valueOf3 = String.valueOf(zzdr);
                    boolean zzp = zzp(valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf));
                    return zzp;
                }
                valueOf2 = String.valueOf(obj);
                valueOf = String.valueOf(zzdr);
                this.zzvn = zzo(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            }
            valueOf2 = String.valueOf(id);
            valueOf = String.valueOf(zzdr);
            obj = zzo(valueOf.length() != 0 ? valueOf2.concat(valueOf) : new String(valueOf2));
            if (TextUtils.isEmpty(obj)) {
                return false;
            } else if (obj.equals(this.zzvn)) {
                return true;
            } else {
                if (TextUtils.isEmpty(this.zzvn)) {
                    valueOf = zzdr;
                } else {
                    zzq("Resetting the client id because Advertising Id changed.");
                    obj = zzcg().zzds();
                    zza("New client Id", obj);
                }
                String valueOf4 = String.valueOf(id);
                valueOf3 = String.valueOf(obj);
                zzp = zzp(valueOf3.length() != 0 ? valueOf4.concat(valueOf3) : new String(valueOf4));
                return zzp;
            }
        }
    }

    private final Info zzbp() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException e) {
            zzt("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (Exception e2) {
            if (!zzvk) {
                zzvk = true;
                zzd("Error getting advertiser id", e2);
            }
        }
        return info;
    }

    private static String zzo(String str) {
        if (zzdg.zzah("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzdg.zzah("MD5").digest(str.getBytes()))});
    }

    private final boolean zzp(String str) {
        try {
            String zzo = zzo(str);
            zzq("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzo.getBytes());
            openFileOutput.close();
            this.zzvn = zzo;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private final String zzbq() {
        Object e;
        String str = null;
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzt("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzq("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e2) {
                    return str2;
                } catch (IOException e3) {
                    e = e3;
                    str = str2;
                    zzd("Error reading Hash file, deleting it", e);
                    getContext().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e4) {
            return null;
        } catch (IOException e5) {
            e = e5;
            zzd("Error reading Hash file, deleting it", e);
            getContext().deleteFile("gaClientIdData");
            return str;
        }
    }
}
