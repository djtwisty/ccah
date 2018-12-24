package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zaan extends zaau {
    final /* synthetic */ zaak zagi;
    private final Map<Client, zaam> zagk;

    public zaan(zaak zaak, Map<Client, zaam> map) {
        this.zagi = zaak;
        super(zaak);
        this.zagk = map;
    }

    public final void zaan() {
        int i = 0;
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(this.zagi.zaex);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (Client client : this.zagk.keySet()) {
            if (!client.requiresGooglePlayServices() || ((zaam) this.zagk.get(client)).zaeb) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i2 = -1;
        ArrayList arrayList3;
        int i3;
        if (!arrayList.isEmpty()) {
            arrayList3 = (ArrayList) arrayList;
            int size = arrayList3.size();
            i3 = 0;
            while (i3 < size) {
                Object obj = arrayList3.get(i3);
                i3++;
                i2 = googleApiAvailabilityCache.getClientAvailability(this.zagi.mContext, (Client) obj);
                if (i2 != 0) {
                    break;
                }
            }
        }
        arrayList3 = (ArrayList) arrayList2;
        i3 = arrayList3.size();
        while (i < i3) {
            obj = arrayList3.get(i);
            i++;
            i2 = googleApiAvailabilityCache.getClientAvailability(this.zagi.mContext, (Client) obj);
            if (i2 == 0) {
                break;
            }
        }
        int i4 = i2;
        if (i4 != 0) {
            this.zagi.zafs.zaa(new zaao(this, this.zagi, new ConnectionResult(i4, null)));
            return;
        }
        if (this.zagi.zagc) {
            this.zagi.zaga.connect();
        }
        for (Client client2 : this.zagk.keySet()) {
            ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) this.zagk.get(client2);
            if (!client2.requiresGooglePlayServices() || googleApiAvailabilityCache.getClientAvailability(this.zagi.mContext, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                this.zagi.zafs.zaa(new zaap(this, this.zagi, connectionProgressReportCallbacks));
            }
        }
    }
}
