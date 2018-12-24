package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import org.json.JSONException;

final class zzpk implements zzph {
    zzpk() {
    }

    public final zzpm zzh(byte[] bArr) {
        if (bArr == null) {
            throw new zzpa("Cannot parse a null byte[]");
        } else if (bArr.length == 0) {
            throw new zzpa("Cannot parse a 0 length byte[]");
        } else {
            try {
                zzqj zzeu = zzpb.zzeu(new String(bArr));
                if (zzeu != null) {
                    zzhk.m1082v("The runtime configuration was successfully parsed from the resource");
                }
                return new zzpm(Status.RESULT_SUCCESS, 0, null, zzeu);
            } catch (JSONException e) {
                throw new zzpa("The resource data is corrupted. The runtime configuration cannot be extracted from the JSON data");
            } catch (zzpa e2) {
                throw new zzpa("The resource data is invalid. The runtime  configuration cannot be extracted from the JSON data");
            }
        }
    }
}
