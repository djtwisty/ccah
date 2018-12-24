package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import org.json.JSONException;

final class zzpj implements zzph {
    zzpj() {
    }

    public final zzpm zzh(byte[] bArr) {
        if (bArr == null) {
            throw new zzpa("Cannot parse a null byte[]");
        } else if (bArr.length == 0) {
            throw new zzpa("Cannot parse a 0 length byte[]");
        } else {
            try {
                zzqb zzet = zzpb.zzet(new String(bArr));
                if (zzet != null) {
                    zzhk.m1082v("The container was successfully parsed from the resource");
                }
                return new zzpm(Status.RESULT_SUCCESS, 0, new zzpn(zzet), zzpi.zzboc.zzh(bArr).zzsa());
            } catch (JSONException e) {
                throw new zzpa("The resource data is corrupted. The container cannot be extracted from the JSON data");
            } catch (zzpa e2) {
                throw new zzpa("The resource data is invalid. The container cannot be extracted from the JSON data");
            }
        }
    }
}
