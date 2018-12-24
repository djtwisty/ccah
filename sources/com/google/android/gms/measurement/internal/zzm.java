package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v4.p017e.C0238a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.android.gms.internal.measurement.zzyi;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzm extends zzfn {
    zzm(zzfo zzfo) {
        super(zzfo);
    }

    protected final boolean zzgy() {
        return false;
    }

    final zzfr[] zza(String str, zzft[] zzftArr, zzfz[] zzfzArr) {
        BitSet bitSet;
        BitSet bitSet2;
        Map c0238a;
        int i;
        Map map;
        int i2;
        Object obj;
        zzfr zzfr;
        Long l;
        zzcr zzjt;
        int i3;
        int length;
        Map map2;
        zzfr zzfr2;
        C0238a c0238a2;
        C0238a c0238a3;
        Preconditions.checkNotEmpty(str);
        HashSet hashSet = new HashSet();
        C0238a c0238a4 = new C0238a();
        Map c0238a5 = new C0238a();
        C0238a c0238a6 = new C0238a();
        C0238a c0238a7 = new C0238a();
        C0238a c0238a8 = new C0238a();
        boolean zzbb = zzgv().zzbb(str);
        Map zzbp = zzjt().zzbp(str);
        if (zzbp != null) {
            for (Integer intValue : zzbp.keySet()) {
                int intValue2 = intValue.intValue();
                zzfx zzfx = (zzfx) zzbp.get(Integer.valueOf(intValue2));
                bitSet = (BitSet) c0238a5.get(Integer.valueOf(intValue2));
                bitSet2 = (BitSet) c0238a6.get(Integer.valueOf(intValue2));
                if (zzbb) {
                    c0238a = new C0238a();
                    if (!(zzfx == null || zzfx.zzayp == null)) {
                        for (zzfs zzfs : zzfx.zzayp) {
                            if (zzfs.zzawx != null) {
                                c0238a.put(zzfs.zzawx, zzfs.zzawy);
                            }
                        }
                    }
                    c0238a7.put(Integer.valueOf(intValue2), c0238a);
                    map = c0238a;
                } else {
                    map = null;
                }
                if (bitSet == null) {
                    bitSet = new BitSet();
                    c0238a5.put(Integer.valueOf(intValue2), bitSet);
                    bitSet2 = new BitSet();
                    c0238a6.put(Integer.valueOf(intValue2), bitSet2);
                }
                for (i2 = 0; i2 < (zzfx.zzayn.length << 6); i2++) {
                    obj = null;
                    if (zzfu.zza(zzfx.zzayn, i2)) {
                        zzgt().zzjo().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i2));
                        bitSet2.set(i2);
                        if (zzfu.zza(zzfx.zzayo, i2)) {
                            bitSet.set(i2);
                            obj = 1;
                        }
                    }
                    if (map != null && r6 == null) {
                        map.remove(Integer.valueOf(i2));
                    }
                }
                zzfr = new zzfr();
                c0238a4.put(Integer.valueOf(intValue2), zzfr);
                zzfr.zzawv = Boolean.valueOf(false);
                zzfr.zzawu = zzfx;
                zzfr.zzawt = new zzfx();
                zzfr.zzawt.zzayo = zzfu.zza(bitSet);
                zzfr.zzawt.zzayn = zzfu.zza(bitSet2);
                if (zzbb) {
                    zzfr.zzawt.zzayp = zzb(map);
                    c0238a8.put(Integer.valueOf(intValue2), new C0238a());
                }
            }
        }
        if (zzftArr != null) {
            zzft zzft = null;
            long j = 0;
            l = null;
            C0238a c0238a9 = new C0238a();
            for (zzft zzft2 : zzftArr) {
                zzfu[] zzfuArr;
                String str2;
                Long l2;
                long j2;
                zzft zzft3;
                zzac zzg;
                zzac zzac;
                Map map3;
                int intValue3;
                BitSet bitSet3;
                Map map4;
                BitSet bitSet4;
                String str3 = zzft2.name;
                zzfu[] zzfuArr2 = zzft2.zzaxa;
                if (zzgv().zzd(str, zzai.zzaki)) {
                    zzjr();
                    Long l3 = (Long) zzfu.zzb(zzft2, "_eid");
                    Object obj2 = l3 != null ? 1 : null;
                    Object obj3 = (obj2 == null || !str3.equals("_ep")) ? null : 1;
                    if (obj3 != null) {
                        zzjr();
                        str3 = (String) zzfu.zzb(zzft2, "_en");
                        if (TextUtils.isEmpty(str3)) {
                            zzgt().zzjg().zzg("Extra parameter without an event name. eventId", l3);
                        } else {
                            Long l4;
                            int i4;
                            if (zzft == null || l == null || l3.longValue() != l.longValue()) {
                                Pair zza = zzjt().zza(str, l3);
                                if (zza == null || zza.first == null) {
                                    zzgt().zzjg().zze("Extra parameter without existing main event. eventName, eventId", str3, l3);
                                } else {
                                    zzft zzft4 = (zzft) zza.first;
                                    j = ((Long) zza.second).longValue();
                                    zzjr();
                                    l4 = (Long) zzfu.zzb(zzft4, "_eid");
                                    zzft = zzft4;
                                }
                            } else {
                                l4 = l;
                            }
                            j--;
                            if (j <= 0) {
                                zzjt = zzjt();
                                zzjt.zzaf();
                                zzjt.zzgt().zzjo().zzg("Clearing complex main event info. appId", str);
                                try {
                                    zzjt.getWritableDatabase().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                                } catch (SQLiteException e) {
                                    zzjt.zzgt().zzjg().zzg("Error clearing complex main event", e);
                                }
                            } else {
                                zzjt().zza(str, l3, j, zzft);
                            }
                            zzfu[] zzfuArr3 = new zzfu[(zzft.zzaxa.length + zzfuArr2.length)];
                            i3 = 0;
                            zzfu[] zzfuArr4 = zzft.zzaxa;
                            int length2 = zzfuArr4.length;
                            i2 = 0;
                            while (i2 < length2) {
                                zzfu zzfu = zzfuArr4[i2];
                                zzjr();
                                if (zzfu.zza(zzft2, zzfu.name) == null) {
                                    i4 = i3 + 1;
                                    zzfuArr3[i3] = zzfu;
                                } else {
                                    i4 = i3;
                                }
                                i2++;
                                i3 = i4;
                            }
                            if (i3 > 0) {
                                zzfu[] zzfuArr5;
                                length = zzfuArr2.length;
                                i4 = 0;
                                while (i4 < length) {
                                    i2 = i3 + 1;
                                    zzfuArr3[i3] = zzfuArr2[i4];
                                    i4++;
                                    i3 = i2;
                                }
                                if (i3 == zzfuArr3.length) {
                                    zzfuArr5 = zzfuArr3;
                                } else {
                                    zzfuArr5 = (zzfu[]) Arrays.copyOf(zzfuArr3, i3);
                                }
                                zzfuArr = zzfuArr5;
                                str2 = str3;
                                l2 = l4;
                                j2 = j;
                                zzft3 = zzft;
                            } else {
                                zzgt().zzjj().zzg("No unique parameters in main event. eventName", str3);
                                zzfuArr = zzfuArr2;
                                str2 = str3;
                                l2 = l4;
                                j2 = j;
                                zzft3 = zzft;
                            }
                        }
                    } else if (obj2 != null) {
                        zzjr();
                        Long valueOf = Long.valueOf(0);
                        l = zzfu.zzb(zzft2, "_epc");
                        if (l != null) {
                            valueOf = l;
                        }
                        j = valueOf.longValue();
                        if (j <= 0) {
                            zzgt().zzjj().zzg("Complex event with zero extra param count. eventName", str3);
                            zzfuArr = zzfuArr2;
                            str2 = str3;
                            l2 = l3;
                            j2 = j;
                            zzft3 = zzft2;
                        } else {
                            zzjt().zza(str, l3, j, zzft2);
                            zzfuArr = zzfuArr2;
                            str2 = str3;
                            l2 = l3;
                            j2 = j;
                            zzft3 = zzft2;
                        }
                    }
                    zzg = zzjt().zzg(str, zzft2.name);
                    if (zzg != null) {
                        zzgt().zzjj().zze("Event aggregate wasn't created during raw event logging. appId, event", zzas.zzbw(str), zzgq().zzbt(str2));
                        zzac = new zzac(str, zzft2.name, 1, 1, zzft2.zzaxb.longValue(), 0, null, null, null, null);
                    } else {
                        zzac = new zzac(zzg.zztt, zzg.name, zzg.zzahv + 1, zzg.zzahw + 1, zzg.zzahx, zzg.zzahy, zzg.zzahz, zzg.zzaia, zzg.zzaib, zzg.zzaic);
                    }
                    zzjt().zza(zzac);
                    j = zzac.zzahv;
                    map2 = (Map) c0238a9.get(str2);
                    if (map2 != null) {
                        map2 = zzjt().zzl(str, str2);
                        if (map2 == null) {
                            map2 = new C0238a();
                        }
                        c0238a9.put(str2, map2);
                        map3 = map2;
                    } else {
                        map3 = map2;
                    }
                    for (Integer intValue4 : r9.keySet()) {
                        intValue3 = intValue4.intValue();
                        if (hashSet.contains(Integer.valueOf(intValue3))) {
                            zzfr2 = (zzfr) c0238a4.get(Integer.valueOf(intValue3));
                            bitSet = (BitSet) c0238a5.get(Integer.valueOf(intValue3));
                            bitSet2 = (BitSet) c0238a6.get(Integer.valueOf(intValue3));
                            c0238a = null;
                            zzbp = null;
                            if (zzbb) {
                                c0238a = (Map) c0238a7.get(Integer.valueOf(intValue3));
                                zzbp = (Map) c0238a8.get(Integer.valueOf(intValue3));
                            }
                            if (zzfr2 != null) {
                                zzfr2 = new zzfr();
                                c0238a4.put(Integer.valueOf(intValue3), zzfr2);
                                zzfr2.zzawv = Boolean.valueOf(true);
                                bitSet3 = new BitSet();
                                c0238a5.put(Integer.valueOf(intValue3), bitSet3);
                                bitSet2 = new BitSet();
                                c0238a6.put(Integer.valueOf(intValue3), bitSet2);
                                if (zzbb) {
                                    map4 = c0238a;
                                    bitSet4 = bitSet2;
                                } else {
                                    c0238a2 = new C0238a();
                                    c0238a7.put(Integer.valueOf(intValue3), c0238a2);
                                    c0238a3 = new C0238a();
                                    c0238a8.put(Integer.valueOf(intValue3), c0238a3);
                                    zzbp = c0238a3;
                                    map4 = c0238a2;
                                    bitSet4 = bitSet2;
                                }
                            } else {
                                map4 = c0238a;
                                bitSet4 = bitSet2;
                                bitSet3 = bitSet;
                            }
                            for (zzfj zzfj : (List) r9.get(Integer.valueOf(intValue3))) {
                                if (zzgt().isLoggable(2)) {
                                    zzgt().zzjo().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), zzfj.zzavk, zzgq().zzbt(zzfj.zzavl));
                                    zzgt().zzjo().zzg("Filter definition", zzjr().zza(zzfj));
                                }
                                if (zzfj.zzavk != null || zzfj.zzavk.intValue() > 256) {
                                    zzgt().zzjj().zze("Invalid event filter ID. appId, id", zzas.zzbw(str), String.valueOf(zzfj.zzavk));
                                } else if (zzbb) {
                                    Object obj4 = (zzfj == null || zzfj.zzavh == null || !zzfj.zzavh.booleanValue()) ? null : 1;
                                    Object obj5 = (zzfj == null || zzfj.zzavi == null || !zzfj.zzavi.booleanValue()) ? null : 1;
                                    if (bitSet3.get(zzfj.zzavk.intValue()) && obj4 == null && obj5 == null) {
                                        zzgt().zzjo().zze("Event filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID", Integer.valueOf(intValue3), zzfj.zzavk);
                                    } else {
                                        r4 = zza(zzfj, str2, zzfuArr, j);
                                        r5 = zzgt().zzjo();
                                        String str4 = "Event filter result";
                                        if (r4 == null) {
                                            obj3 = "null";
                                        } else {
                                            r2 = r4;
                                        }
                                        r5.zzg(str4, obj3);
                                        if (r4 == null) {
                                            hashSet.add(Integer.valueOf(intValue3));
                                        } else {
                                            bitSet4.set(zzfj.zzavk.intValue());
                                            if (r4.booleanValue()) {
                                                bitSet3.set(zzfj.zzavk.intValue());
                                                if (!((obj4 == null && obj5 == null) || zzft2.zzaxb == null)) {
                                                    if (obj5 != null) {
                                                        zzb(zzbp, zzfj.zzavk.intValue(), zzft2.zzaxb.longValue());
                                                    } else {
                                                        zza(map4, zzfj.zzavk.intValue(), zzft2.zzaxb.longValue());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else if (bitSet3.get(zzfj.zzavk.intValue())) {
                                    zzgt().zzjo().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), zzfj.zzavk);
                                } else {
                                    r4 = zza(zzfj, str2, zzfuArr, j);
                                    r5 = zzgt().zzjo();
                                    String str5 = "Event filter result";
                                    if (r4 == null) {
                                        obj3 = "null";
                                    } else {
                                        r2 = r4;
                                    }
                                    r5.zzg(str5, obj3);
                                    if (r4 == null) {
                                        hashSet.add(Integer.valueOf(intValue3));
                                    } else {
                                        bitSet4.set(zzfj.zzavk.intValue());
                                        if (r4.booleanValue()) {
                                            bitSet3.set(zzfj.zzavk.intValue());
                                        }
                                    }
                                }
                            }
                        } else {
                            zzgt().zzjo().zzg("Skipping failed audience ID", Integer.valueOf(intValue3));
                        }
                    }
                    l = l2;
                    j = j2;
                    zzft = zzft3;
                }
                zzfuArr = zzfuArr2;
                str2 = str3;
                l2 = l;
                j2 = j;
                zzft3 = zzft;
                zzg = zzjt().zzg(str, zzft2.name);
                if (zzg != null) {
                    zzac = new zzac(zzg.zztt, zzg.name, zzg.zzahv + 1, zzg.zzahw + 1, zzg.zzahx, zzg.zzahy, zzg.zzahz, zzg.zzaia, zzg.zzaib, zzg.zzaic);
                } else {
                    zzgt().zzjj().zze("Event aggregate wasn't created during raw event logging. appId, event", zzas.zzbw(str), zzgq().zzbt(str2));
                    zzac = new zzac(str, zzft2.name, 1, 1, zzft2.zzaxb.longValue(), 0, null, null, null, null);
                }
                zzjt().zza(zzac);
                j = zzac.zzahv;
                map2 = (Map) c0238a9.get(str2);
                if (map2 != null) {
                    map3 = map2;
                } else {
                    map2 = zzjt().zzl(str, str2);
                    if (map2 == null) {
                        map2 = new C0238a();
                    }
                    c0238a9.put(str2, map2);
                    map3 = map2;
                }
                while (r15.hasNext()) {
                    intValue3 = intValue4.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        zzfr2 = (zzfr) c0238a4.get(Integer.valueOf(intValue3));
                        bitSet = (BitSet) c0238a5.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) c0238a6.get(Integer.valueOf(intValue3));
                        c0238a = null;
                        zzbp = null;
                        if (zzbb) {
                            c0238a = (Map) c0238a7.get(Integer.valueOf(intValue3));
                            zzbp = (Map) c0238a8.get(Integer.valueOf(intValue3));
                        }
                        if (zzfr2 != null) {
                            map4 = c0238a;
                            bitSet4 = bitSet2;
                            bitSet3 = bitSet;
                        } else {
                            zzfr2 = new zzfr();
                            c0238a4.put(Integer.valueOf(intValue3), zzfr2);
                            zzfr2.zzawv = Boolean.valueOf(true);
                            bitSet3 = new BitSet();
                            c0238a5.put(Integer.valueOf(intValue3), bitSet3);
                            bitSet2 = new BitSet();
                            c0238a6.put(Integer.valueOf(intValue3), bitSet2);
                            if (zzbb) {
                                map4 = c0238a;
                                bitSet4 = bitSet2;
                            } else {
                                c0238a2 = new C0238a();
                                c0238a7.put(Integer.valueOf(intValue3), c0238a2);
                                c0238a3 = new C0238a();
                                c0238a8.put(Integer.valueOf(intValue3), c0238a3);
                                zzbp = c0238a3;
                                map4 = c0238a2;
                                bitSet4 = bitSet2;
                            }
                        }
                        for (zzfj zzfj2 : (List) r9.get(Integer.valueOf(intValue3))) {
                            if (zzgt().isLoggable(2)) {
                                zzgt().zzjo().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), zzfj2.zzavk, zzgq().zzbt(zzfj2.zzavl));
                                zzgt().zzjo().zzg("Filter definition", zzjr().zza(zzfj2));
                            }
                            if (zzfj2.zzavk != null) {
                            }
                            zzgt().zzjj().zze("Invalid event filter ID. appId, id", zzas.zzbw(str), String.valueOf(zzfj2.zzavk));
                        }
                    } else {
                        zzgt().zzjo().zzg("Skipping failed audience ID", Integer.valueOf(intValue3));
                    }
                }
                l = l2;
                j = j2;
                zzft = zzft3;
            }
        }
        if (zzfzArr != null) {
            Map c0238a10 = new C0238a();
            for (zzfz zzfz : zzfzArr) {
                map2 = (Map) c0238a10.get(zzfz.name);
                if (map2 == null) {
                    map2 = zzjt().zzm(str, zzfz.name);
                    if (map2 == null) {
                        map2 = new C0238a();
                    }
                    c0238a10.put(zzfz.name, map2);
                    map = map2;
                } else {
                    map = map2;
                }
                for (Integer intValue42 : r7.keySet()) {
                    int intValue5 = intValue42.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue5))) {
                        zzgt().zzjo().zzg("Skipping failed audience ID", Integer.valueOf(intValue5));
                    } else {
                        BitSet bitSet5;
                        zzfr2 = (zzfr) c0238a4.get(Integer.valueOf(intValue5));
                        bitSet = (BitSet) c0238a5.get(Integer.valueOf(intValue5));
                        bitSet2 = (BitSet) c0238a6.get(Integer.valueOf(intValue5));
                        zzbp = null;
                        Map map5 = null;
                        if (zzbb) {
                            map5 = (Map) c0238a8.get(Integer.valueOf(intValue5));
                            zzbp = (Map) c0238a7.get(Integer.valueOf(intValue5));
                        }
                        if (zzfr2 == null) {
                            zzfr2 = new zzfr();
                            c0238a4.put(Integer.valueOf(intValue5), zzfr2);
                            zzfr2.zzawv = Boolean.valueOf(true);
                            bitSet5 = new BitSet();
                            c0238a5.put(Integer.valueOf(intValue5), bitSet5);
                            bitSet2 = new BitSet();
                            c0238a6.put(Integer.valueOf(intValue5), bitSet2);
                            if (zzbb) {
                                c0238a2 = new C0238a();
                                c0238a7.put(Integer.valueOf(intValue5), c0238a2);
                                c0238a3 = new C0238a();
                                c0238a8.put(Integer.valueOf(intValue5), c0238a3);
                                c0238a = c0238a3;
                                zzbp = c0238a2;
                            } else {
                                c0238a = map5;
                            }
                        } else {
                            c0238a = map5;
                            bitSet5 = bitSet;
                        }
                        for (zzfm zzfm : (List) r7.get(Integer.valueOf(intValue5))) {
                            if (zzgt().isLoggable(2)) {
                                zzgt().zzjo().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue5), zzfm.zzavk, zzgq().zzbv(zzfm.zzawa));
                                zzgt().zzjo().zzg("Filter definition", zzjr().zza(zzfm));
                            }
                            if (zzfm.zzavk == null || zzfm.zzavk.intValue() > 256) {
                                zzgt().zzjj().zze("Invalid property filter ID. appId, id", zzas.zzbw(str), String.valueOf(zzfm.zzavk));
                                hashSet.add(Integer.valueOf(intValue5));
                                break;
                            } else if (zzbb) {
                                Object obj6 = (zzfm == null || zzfm.zzavh == null || !zzfm.zzavh.booleanValue()) ? null : 1;
                                r3 = (zzfm == null || zzfm.zzavi == null || !zzfm.zzavi.booleanValue()) ? null : 1;
                                if (bitSet5.get(zzfm.zzavk.intValue()) && obj6 == null && r3 == null) {
                                    zzgt().zzjo().zze("Property filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID", Integer.valueOf(intValue5), zzfm.zzavk);
                                } else {
                                    Boolean zza2 = zza(zzfm, zzfz);
                                    zzau zzjo = zzgt().zzjo();
                                    String str6 = "Property filter result";
                                    if (zza2 == null) {
                                        obj = "null";
                                    } else {
                                        r6 = zza2;
                                    }
                                    zzjo.zzg(str6, obj);
                                    if (zza2 == null) {
                                        hashSet.add(Integer.valueOf(intValue5));
                                    } else {
                                        bitSet2.set(zzfm.zzavk.intValue());
                                        bitSet5.set(zzfm.zzavk.intValue(), zza2.booleanValue());
                                        if (zza2.booleanValue() && !((obj6 == null && r3 == null) || zzfz.zzayu == null)) {
                                            if (r3 != null) {
                                                zzb(c0238a, zzfm.zzavk.intValue(), zzfz.zzayu.longValue());
                                            } else {
                                                zza(zzbp, zzfm.zzavk.intValue(), zzfz.zzayu.longValue());
                                            }
                                        }
                                    }
                                }
                            } else if (bitSet5.get(zzfm.zzavk.intValue())) {
                                zzgt().zzjo().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue5), zzfm.zzavk);
                            } else {
                                r6 = zza(zzfm, zzfz);
                                zzau zzjo2 = zzgt().zzjo();
                                String str7 = "Property filter result";
                                if (r6 == null) {
                                    r3 = "null";
                                } else {
                                    Boolean bool = r6;
                                }
                                zzjo2.zzg(str7, r3);
                                if (r6 == null) {
                                    hashSet.add(Integer.valueOf(intValue5));
                                } else {
                                    bitSet2.set(zzfm.zzavk.intValue());
                                    if (r6.booleanValue()) {
                                        bitSet5.set(zzfm.zzavk.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zzfr[] zzfrArr = new zzfr[c0238a5.size()];
        i3 = 0;
        for (Integer intValue422 : c0238a5.keySet()) {
            length = intValue422.intValue();
            if (!hashSet.contains(Integer.valueOf(length))) {
                zzfr2 = (zzfr) c0238a4.get(Integer.valueOf(length));
                if (zzfr2 == null) {
                    zzfr = new zzfr();
                } else {
                    zzfr = zzfr2;
                }
                int i5 = i3 + 1;
                zzfrArr[i3] = zzfr;
                zzfr.zzave = Integer.valueOf(length);
                zzfr.zzawt = new zzfx();
                zzfr.zzawt.zzayo = zzfu.zza((BitSet) c0238a5.get(Integer.valueOf(length)));
                zzfr.zzawt.zzayn = zzfu.zza((BitSet) c0238a6.get(Integer.valueOf(length)));
                if (zzbb) {
                    zzfy[] zzfyArr;
                    zzfr.zzawt.zzayp = zzb((Map) c0238a7.get(Integer.valueOf(length)));
                    zzfx zzfx2 = zzfr.zzawt;
                    map2 = (Map) c0238a8.get(Integer.valueOf(length));
                    if (map2 == null) {
                        zzfyArr = new zzfy[0];
                    } else {
                        zzfy[] zzfyArr2 = new zzfy[map2.size()];
                        i = 0;
                        for (Integer num : map2.keySet()) {
                            zzfy zzfy = new zzfy();
                            zzfy.zzawx = num;
                            List<Long> list = (List) map2.get(num);
                            if (list != null) {
                                Collections.sort(list);
                                long[] jArr = new long[list.size()];
                                int i6 = 0;
                                for (Long l5 : list) {
                                    int i7 = i6 + 1;
                                    jArr[i6] = l5.longValue();
                                    i6 = i7;
                                }
                                zzfy.zzays = jArr;
                            }
                            i3 = i + 1;
                            zzfyArr2[i] = zzfy;
                            i = i3;
                        }
                        zzfyArr = zzfyArr2;
                    }
                    zzfx2.zzayq = zzfyArr;
                }
                zzjt = zzjt();
                zzyi zzyi = zzfr.zzawt;
                zzjt.zzcl();
                zzjt.zzaf();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzyi);
                try {
                    byte[] bArr = new byte[zzyi.zzvx()];
                    zzya zzk = zzya.zzk(bArr, 0, bArr.length);
                    zzyi.zza(zzk);
                    zzk.zzza();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(length));
                    contentValues.put("current_results", bArr);
                    try {
                        if (zzjt.getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                            zzjt.zzgt().zzjg().zzg("Failed to insert filter results (got -1). appId", zzas.zzbw(str));
                        }
                        i3 = i5;
                    } catch (SQLiteException e2) {
                        zzjt.zzgt().zzjg().zze("Error storing filter results. appId", zzas.zzbw(str), e2);
                        i3 = i5;
                    }
                } catch (IOException e3) {
                    zzjt.zzgt().zzjg().zze("Configuration loss. Failed to serialize filter results. appId", zzas.zzbw(str), e3);
                    i3 = i5;
                }
            }
        }
        return (zzfr[]) Arrays.copyOf(zzfrArr, i3);
    }

    private final Boolean zza(zzfj zzfj, String str, zzfu[] zzfuArr, long j) {
        Boolean zza;
        if (zzfj.zzavo != null) {
            zza = zza(j, zzfj.zzavo);
            if (zza == null) {
                return null;
            }
            if (!zza.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (zzfk zzfk : zzfj.zzavm) {
            if (TextUtils.isEmpty(zzfk.zzavt)) {
                zzgt().zzjj().zzg("null or empty param name in filter. event", zzgq().zzbt(str));
                return null;
            }
            hashSet.add(zzfk.zzavt);
        }
        Map c0238a = new C0238a();
        for (zzfu zzfu : zzfuArr) {
            if (hashSet.contains(zzfu.name)) {
                if (zzfu.zzaxe != null) {
                    c0238a.put(zzfu.name, zzfu.zzaxe);
                } else if (zzfu.zzaun != null) {
                    c0238a.put(zzfu.name, zzfu.zzaun);
                } else if (zzfu.zzaml != null) {
                    c0238a.put(zzfu.name, zzfu.zzaml);
                } else {
                    zzgt().zzjj().zze("Unknown value for param. event, param", zzgq().zzbt(str), zzgq().zzbu(zzfu.name));
                    return null;
                }
            }
        }
        for (zzfk zzfk2 : zzfj.zzavm) {
            boolean equals = Boolean.TRUE.equals(zzfk2.zzavs);
            String str2 = zzfk2.zzavt;
            if (TextUtils.isEmpty(str2)) {
                zzgt().zzjj().zzg("Event has empty param name. event", zzgq().zzbt(str));
                return null;
            }
            Object obj = c0238a.get(str2);
            if (obj instanceof Long) {
                if (zzfk2.zzavr == null) {
                    zzgt().zzjj().zze("No number filter for long param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                zza = zza(((Long) obj).longValue(), zzfk2.zzavr);
                if (zza == null) {
                    return null;
                }
                if (((!zza.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (zzfk2.zzavr == null) {
                    zzgt().zzjj().zze("No number filter for double param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                zza = zza(((Double) obj).doubleValue(), zzfk2.zzavr);
                if (zza == null) {
                    return null;
                }
                if (((!zza.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (zzfk2.zzavq != null) {
                    zza = zza((String) obj, zzfk2.zzavq);
                } else if (zzfk2.zzavr == null) {
                    zzgt().zzjj().zze("No filter for String param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                } else if (zzfu.zzcs((String) obj)) {
                    zza = zza((String) obj, zzfk2.zzavr);
                } else {
                    zzgt().zzjj().zze("Invalid param value for number filter. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                if (zza == null) {
                    return null;
                }
                if (((!zza.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                zzgt().zzjo().zze("Missing param for filter. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                return Boolean.valueOf(false);
            } else {
                zzgt().zzjj().zze("Unknown param type. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private final Boolean zza(zzfm zzfm, zzfz zzfz) {
        zzfk zzfk = zzfm.zzawb;
        if (zzfk == null) {
            zzgt().zzjj().zzg("Missing property filter. property", zzgq().zzbv(zzfz.name));
            return null;
        }
        boolean equals = Boolean.TRUE.equals(zzfk.zzavs);
        if (zzfz.zzaxe != null) {
            if (zzfk.zzavr != null) {
                return zza(zza(zzfz.zzaxe.longValue(), zzfk.zzavr), equals);
            }
            zzgt().zzjj().zzg("No number filter for long property. property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfz.zzaun != null) {
            if (zzfk.zzavr != null) {
                return zza(zza(zzfz.zzaun.doubleValue(), zzfk.zzavr), equals);
            }
            zzgt().zzjj().zzg("No number filter for double property. property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfz.zzaml == null) {
            zzgt().zzjj().zzg("User property has no value, property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfk.zzavq != null) {
            return zza(zza(zzfz.zzaml, zzfk.zzavq), equals);
        } else {
            if (zzfk.zzavr == null) {
                zzgt().zzjj().zzg("No string or number filter defined. property", zzgq().zzbv(zzfz.name));
                return null;
            } else if (zzfu.zzcs(zzfz.zzaml)) {
                return zza(zza(zzfz.zzaml, zzfk.zzavr), equals);
            } else {
                zzgt().zzjj().zze("Invalid user property value for Numeric number filter. property, value", zzgq().zzbv(zzfz.name), zzfz.zzaml);
                return null;
            }
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzfn zzfn) {
        int i = 0;
        String str2 = null;
        Preconditions.checkNotNull(zzfn);
        if (str == null || zzfn.zzawc == null || zzfn.zzawc.intValue() == 0) {
            return null;
        }
        boolean z;
        String str3;
        List list;
        if (zzfn.zzawc.intValue() == 6) {
            if (zzfn.zzawf == null || zzfn.zzawf.length == 0) {
                return null;
            }
        } else if (zzfn.zzawd == null) {
            return null;
        }
        int intValue = zzfn.zzawc.intValue();
        if (zzfn.zzawe == null || !zzfn.zzawe.booleanValue()) {
            z = false;
        } else {
            z = true;
        }
        if (z || intValue == 1 || intValue == 6) {
            str3 = zzfn.zzawd;
        } else {
            str3 = zzfn.zzawd.toUpperCase(Locale.ENGLISH);
        }
        if (zzfn.zzawf == null) {
            list = null;
        } else {
            String[] strArr = zzfn.zzawf;
            if (z) {
                list = Arrays.asList(strArr);
            } else {
                list = new ArrayList();
                int length = strArr.length;
                while (i < length) {
                    list.add(strArr[i].toUpperCase(Locale.ENGLISH));
                    i++;
                }
            }
        }
        if (intValue == 1) {
            str2 = str3;
        }
        return zza(str, intValue, z, str3, list, str2);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!(z || i == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException e) {
                    zzgt().zzjj().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(long j, zzfl zzfl) {
        try {
            return zza(new BigDecimal(j), zzfl, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(double d, zzfl zzfl) {
        try {
            return zza(new BigDecimal(d), zzfl, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(String str, zzfl zzfl) {
        Boolean bool = null;
        if (zzfu.zzcs(str)) {
            try {
                bool = zza(new BigDecimal(str), zzfl, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            } catch (NumberFormatException e) {
            }
        }
        return bool;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.android.gms.common.util.VisibleForTesting
    private static java.lang.Boolean zza(java.math.BigDecimal r10, com.google.android.gms.internal.measurement.zzfl r11, double r12) {
        /*
        r8 = 4;
        r7 = -1;
        r1 = 0;
        r0 = 1;
        r2 = 0;
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r11);
        r3 = r11.zzavu;
        if (r3 == 0) goto L_0x0014;
    L_0x000c:
        r3 = r11.zzavu;
        r3 = r3.intValue();
        if (r3 != 0) goto L_0x0016;
    L_0x0014:
        r0 = r2;
    L_0x0015:
        return r0;
    L_0x0016:
        r3 = r11.zzavu;
        r3 = r3.intValue();
        if (r3 != r8) goto L_0x0028;
    L_0x001e:
        r3 = r11.zzavx;
        if (r3 == 0) goto L_0x0026;
    L_0x0022:
        r3 = r11.zzavy;
        if (r3 != 0) goto L_0x002e;
    L_0x0026:
        r0 = r2;
        goto L_0x0015;
    L_0x0028:
        r3 = r11.zzavw;
        if (r3 != 0) goto L_0x002e;
    L_0x002c:
        r0 = r2;
        goto L_0x0015;
    L_0x002e:
        r3 = r11.zzavu;
        r6 = r3.intValue();
        r3 = r11.zzavu;
        r3 = r3.intValue();
        if (r3 != r8) goto L_0x0066;
    L_0x003c:
        r3 = r11.zzavx;
        r3 = com.google.android.gms.measurement.internal.zzfu.zzcs(r3);
        if (r3 == 0) goto L_0x004c;
    L_0x0044:
        r3 = r11.zzavy;
        r3 = com.google.android.gms.measurement.internal.zzfu.zzcs(r3);
        if (r3 != 0) goto L_0x004e;
    L_0x004c:
        r0 = r2;
        goto L_0x0015;
    L_0x004e:
        r4 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0063 }
        r3 = r11.zzavx;	 Catch:{ NumberFormatException -> 0x0063 }
        r4.<init>(r3);	 Catch:{ NumberFormatException -> 0x0063 }
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0063 }
        r5 = r11.zzavy;	 Catch:{ NumberFormatException -> 0x0063 }
        r3.<init>(r5);	 Catch:{ NumberFormatException -> 0x0063 }
        r5 = r2;
    L_0x005d:
        if (r6 != r8) goto L_0x007d;
    L_0x005f:
        if (r4 != 0) goto L_0x007f;
    L_0x0061:
        r0 = r2;
        goto L_0x0015;
    L_0x0063:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0015;
    L_0x0066:
        r3 = r11.zzavw;
        r3 = com.google.android.gms.measurement.internal.zzfu.zzcs(r3);
        if (r3 != 0) goto L_0x0070;
    L_0x006e:
        r0 = r2;
        goto L_0x0015;
    L_0x0070:
        r5 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x007a }
        r3 = r11.zzavw;	 Catch:{ NumberFormatException -> 0x007a }
        r5.<init>(r3);	 Catch:{ NumberFormatException -> 0x007a }
        r3 = r2;
        r4 = r2;
        goto L_0x005d;
    L_0x007a:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0015;
    L_0x007d:
        if (r5 == 0) goto L_0x0082;
    L_0x007f:
        switch(r6) {
            case 1: goto L_0x0084;
            case 2: goto L_0x0091;
            case 3: goto L_0x009f;
            case 4: goto L_0x00ed;
            default: goto L_0x0082;
        };
    L_0x0082:
        r0 = r2;
        goto L_0x0015;
    L_0x0084:
        r2 = r10.compareTo(r5);
        if (r2 != r7) goto L_0x008f;
    L_0x008a:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x008f:
        r0 = r1;
        goto L_0x008a;
    L_0x0091:
        r2 = r10.compareTo(r5);
        if (r2 != r0) goto L_0x009d;
    L_0x0097:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x009d:
        r0 = r1;
        goto L_0x0097;
    L_0x009f:
        r2 = 0;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x00df;
    L_0x00a5:
        r2 = new java.math.BigDecimal;
        r2.<init>(r12);
        r3 = new java.math.BigDecimal;
        r4 = 2;
        r3.<init>(r4);
        r2 = r2.multiply(r3);
        r2 = r5.subtract(r2);
        r2 = r10.compareTo(r2);
        if (r2 != r0) goto L_0x00dd;
    L_0x00be:
        r2 = new java.math.BigDecimal;
        r2.<init>(r12);
        r3 = new java.math.BigDecimal;
        r4 = 2;
        r3.<init>(r4);
        r2 = r2.multiply(r3);
        r2 = r5.add(r2);
        r2 = r10.compareTo(r2);
        if (r2 != r7) goto L_0x00dd;
    L_0x00d7:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x00dd:
        r0 = r1;
        goto L_0x00d7;
    L_0x00df:
        r2 = r10.compareTo(r5);
        if (r2 != 0) goto L_0x00eb;
    L_0x00e5:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x00eb:
        r0 = r1;
        goto L_0x00e5;
    L_0x00ed:
        r2 = r10.compareTo(r4);
        if (r2 == r7) goto L_0x00ff;
    L_0x00f3:
        r2 = r10.compareTo(r3);
        if (r2 == r0) goto L_0x00ff;
    L_0x00f9:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x00ff:
        r0 = r1;
        goto L_0x00f9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzm.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzfl, double):java.lang.Boolean");
    }

    private static zzfs[] zzb(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        zzfs[] zzfsArr = new zzfs[map.size()];
        int i = 0;
        for (Integer num : map.keySet()) {
            zzfs zzfs = new zzfs();
            zzfs.zzawx = num;
            zzfs.zzawy = (Long) map.get(num);
            int i2 = i + 1;
            zzfsArr[i] = zzfs;
            i = i2;
        }
        return zzfsArr;
    }

    private static void zza(Map<Integer, Long> map, int i, long j) {
        Long l = (Long) map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void zzb(Map<Integer, List<Long>> map, int i, long j) {
        List list = (List) map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }
}
