package com.google.android.gms.internal.measurement;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

final class zzgb implements zzgd {
    private final /* synthetic */ zzga zzbia;

    zzgb(zzga zzga) {
        this.zzbia = zzga;
    }

    public final Info zznj() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzbia.zzri);
        } catch (Throwable e) {
            zzhk.zzb("IllegalStateException getting Advertising Id Info", e);
        } catch (Throwable e2) {
            zzhk.zzb("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
        } catch (Throwable e22) {
            zzhk.zzb("IOException getting Ad Id Info", e22);
        } catch (Throwable e222) {
            this.zzbia.zzbhx = false;
            zzhk.zzb("GooglePlayServicesNotAvailableException getting Advertising Id Info", e222);
        } catch (Throwable e2222) {
            zzhk.zzb("Unknown exception. Could not get the Advertising Id Info.", e2222);
        }
        return info;
    }
}
