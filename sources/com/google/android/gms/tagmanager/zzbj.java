package com.google.android.gms.tagmanager;

import java.util.Map;

final class zzbj extends zzce {
    zzbj() {
    }

    public final void zzb(String str, Map map) {
        CustomTagProvider customTagProvider;
        if (zzbf.zzbby.containsKey(str)) {
            customTagProvider = (CustomTagProvider) zzbf.zzbby.get(str);
        } else {
            customTagProvider = (CustomTagProvider) zzbf.zza(str, CustomTagProvider.class);
            zzbf.zzbby.put(str, customTagProvider);
        }
        if (customTagProvider != null) {
            customTagProvider.execute(map);
        }
    }

    public final String zzc(String str, Map map) {
        CustomVariableProvider customVariableProvider;
        if (zzbf.zzbbz.containsKey(str)) {
            customVariableProvider = (CustomVariableProvider) zzbf.zzbbz.get(str);
        } else {
            customVariableProvider = (CustomVariableProvider) zzbf.zza(str, CustomVariableProvider.class);
            zzbf.zzbbz.put(str, customVariableProvider);
        }
        if (customVariableProvider != null) {
            return customVariableProvider.getValue(map);
        }
        return null;
    }
}
