package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzya;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class zzfu extends zzfn {
    zzfu(zzfo zzfo) {
        super(zzfo);
    }

    protected final boolean zzgy() {
        return false;
    }

    final void zza(zzfz zzfz, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfz.zzaml = null;
        zzfz.zzaxe = null;
        zzfz.zzaun = null;
        if (obj instanceof String) {
            zzfz.zzaml = (String) obj;
        } else if (obj instanceof Long) {
            zzfz.zzaxe = (Long) obj;
        } else if (obj instanceof Double) {
            zzfz.zzaun = (Double) obj;
        } else {
            zzgt().zzjg().zzg("Ignoring invalid (type) user attribute value", obj);
        }
    }

    final void zza(com.google.android.gms.internal.measurement.zzfu zzfu, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfu.zzaml = null;
        zzfu.zzaxe = null;
        zzfu.zzaun = null;
        if (obj instanceof String) {
            zzfu.zzaml = (String) obj;
        } else if (obj instanceof Long) {
            zzfu.zzaxe = (Long) obj;
        } else if (obj instanceof Double) {
            zzfu.zzaun = (Double) obj;
        } else {
            zzgt().zzjg().zzg("Ignoring invalid (type) event param value", obj);
        }
    }

    final byte[] zza(zzfv zzfv) {
        try {
            byte[] bArr = new byte[zzfv.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfv.zza(zzk);
            zzk.zzza();
            return bArr;
        } catch (IOException e) {
            zzgt().zzjg().zzg("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    static com.google.android.gms.internal.measurement.zzfu zza(zzft zzft, String str) {
        for (com.google.android.gms.internal.measurement.zzfu zzfu : zzft.zzaxa) {
            if (zzfu.name.equals(str)) {
                return zzfu;
            }
        }
        return null;
    }

    static Object zzb(zzft zzft, String str) {
        com.google.android.gms.internal.measurement.zzfu zza = zza(zzft, str);
        if (zza != null) {
            if (zza.zzaml != null) {
                return zza.zzaml;
            }
            if (zza.zzaxe != null) {
                return zza.zzaxe;
            }
            if (zza.zzaun != null) {
                return zza.zzaun;
            }
        }
        return null;
    }

    static com.google.android.gms.internal.measurement.zzfu[] zza(com.google.android.gms.internal.measurement.zzfu[] zzfuArr, String str, Object obj) {
        for (com.google.android.gms.internal.measurement.zzfu zzfu : zzfuArr) {
            if (str.equals(zzfu.name)) {
                zzfu.zzaxe = null;
                zzfu.zzaml = null;
                zzfu.zzaun = null;
                if (obj instanceof Long) {
                    zzfu.zzaxe = (Long) obj;
                    return zzfuArr;
                } else if (obj instanceof String) {
                    zzfu.zzaml = (String) obj;
                    return zzfuArr;
                } else if (!(obj instanceof Double)) {
                    return zzfuArr;
                } else {
                    zzfu.zzaun = (Double) obj;
                    return zzfuArr;
                }
            }
        }
        Object obj2 = new com.google.android.gms.internal.measurement.zzfu[(zzfuArr.length + 1)];
        System.arraycopy(zzfuArr, 0, obj2, 0, zzfuArr.length);
        com.google.android.gms.internal.measurement.zzfu zzfu2 = new com.google.android.gms.internal.measurement.zzfu();
        zzfu2.name = str;
        if (obj instanceof Long) {
            zzfu2.zzaxe = (Long) obj;
        } else if (obj instanceof String) {
            zzfu2.zzaml = (String) obj;
        } else if (obj instanceof Double) {
            zzfu2.zzaun = (Double) obj;
        }
        obj2[zzfuArr.length] = zzfu2;
        return obj2;
    }

    final String zzb(zzfv zzfv) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (zzfv.zzaxf != null) {
            for (zzfw zzfw : zzfv.zzaxf) {
                if (!(zzfw == null || zzfw == null)) {
                    zza(stringBuilder, 1);
                    stringBuilder.append("bundle {\n");
                    zza(stringBuilder, 1, "protocol_version", zzfw.zzaxh);
                    zza(stringBuilder, 1, "platform", zzfw.zzaxp);
                    zza(stringBuilder, 1, "gmp_version", zzfw.zzaxt);
                    zza(stringBuilder, 1, "uploading_gmp_version", zzfw.zzaxu);
                    zza(stringBuilder, 1, "config_version", zzfw.zzayf);
                    zza(stringBuilder, 1, "gmp_app_id", zzfw.zzafi);
                    zza(stringBuilder, 1, "admob_app_id", zzfw.zzawp);
                    zza(stringBuilder, 1, "app_id", zzfw.zztt);
                    zza(stringBuilder, 1, "app_version", zzfw.zzts);
                    zza(stringBuilder, 1, "app_version_major", zzfw.zzayb);
                    zza(stringBuilder, 1, "firebase_instance_id", zzfw.zzafk);
                    zza(stringBuilder, 1, "dev_cert_hash", zzfw.zzaxx);
                    zza(stringBuilder, 1, "app_store", zzfw.zzafp);
                    zza(stringBuilder, 1, "upload_timestamp_millis", zzfw.zzaxk);
                    zza(stringBuilder, 1, "start_timestamp_millis", zzfw.zzaxl);
                    zza(stringBuilder, 1, "end_timestamp_millis", zzfw.zzaxm);
                    zza(stringBuilder, 1, "previous_bundle_start_timestamp_millis", zzfw.zzaxn);
                    zza(stringBuilder, 1, "previous_bundle_end_timestamp_millis", zzfw.zzaxo);
                    zza(stringBuilder, 1, "app_instance_id", zzfw.zzafh);
                    zza(stringBuilder, 1, "resettable_device_id", zzfw.zzaxv);
                    zza(stringBuilder, 1, "device_id", zzfw.zzaye);
                    zza(stringBuilder, 1, "ds_id", zzfw.zzayh);
                    zza(stringBuilder, 1, "limited_ad_tracking", zzfw.zzaxw);
                    zza(stringBuilder, 1, "os_version", zzfw.zzaxq);
                    zza(stringBuilder, 1, "device_model", zzfw.zzaxr);
                    zza(stringBuilder, 1, "user_default_language", zzfw.zzahr);
                    zza(stringBuilder, 1, "time_zone_offset_minutes", zzfw.zzaxs);
                    zza(stringBuilder, 1, "bundle_sequential_index", zzfw.zzaxy);
                    zza(stringBuilder, 1, "service_upload", zzfw.zzaxz);
                    zza(stringBuilder, 1, "health_monitor", zzfw.zzagm);
                    if (!(zzfw.zzayg == null || zzfw.zzayg.longValue() == 0)) {
                        zza(stringBuilder, 1, "android_id", zzfw.zzayg);
                    }
                    if (zzfw.zzayj != null) {
                        zza(stringBuilder, 1, "retry_counter", zzfw.zzayj);
                    }
                    zzfz[] zzfzArr = zzfw.zzaxj;
                    if (zzfzArr != null) {
                        for (zzfz zzfz : zzfzArr) {
                            if (zzfz != null) {
                                zza(stringBuilder, 2);
                                stringBuilder.append("user_property {\n");
                                zza(stringBuilder, 2, "set_timestamp_millis", zzfz.zzayu);
                                zza(stringBuilder, 2, "name", zzgq().zzbv(zzfz.name));
                                zza(stringBuilder, 2, "string_value", zzfz.zzaml);
                                zza(stringBuilder, 2, "int_value", zzfz.zzaxe);
                                zza(stringBuilder, 2, "double_value", zzfz.zzaun);
                                zza(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    zzfr[] zzfrArr = zzfw.zzaya;
                    String str = zzfw.zztt;
                    if (zzfrArr != null) {
                        for (zzfr zzfr : zzfrArr) {
                            if (zzfr != null) {
                                zza(stringBuilder, 2);
                                stringBuilder.append("audience_membership {\n");
                                zza(stringBuilder, 2, "audience_id", zzfr.zzave);
                                zza(stringBuilder, 2, "new_audience", zzfr.zzawv);
                                zza(stringBuilder, 2, "current_data", zzfr.zzawt, str);
                                zza(stringBuilder, 2, "previous_data", zzfr.zzawu, str);
                                zza(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    zzft[] zzftArr = zzfw.zzaxi;
                    if (zzftArr != null) {
                        for (zzft zzft : zzftArr) {
                            if (zzft != null) {
                                zza(stringBuilder, 2);
                                stringBuilder.append("event {\n");
                                zza(stringBuilder, 2, "name", zzgq().zzbt(zzft.name));
                                zza(stringBuilder, 2, "timestamp_millis", zzft.zzaxb);
                                zza(stringBuilder, 2, "previous_timestamp_millis", zzft.zzaxc);
                                zza(stringBuilder, 2, "count", zzft.count);
                                com.google.android.gms.internal.measurement.zzfu[] zzfuArr = zzft.zzaxa;
                                if (zzfuArr != null) {
                                    for (com.google.android.gms.internal.measurement.zzfu zzfu : zzfuArr) {
                                        if (zzfu != null) {
                                            zza(stringBuilder, 3);
                                            stringBuilder.append("param {\n");
                                            zza(stringBuilder, 3, "name", zzgq().zzbu(zzfu.name));
                                            zza(stringBuilder, 3, "string_value", zzfu.zzaml);
                                            zza(stringBuilder, 3, "int_value", zzfu.zzaxe);
                                            zza(stringBuilder, 3, "double_value", zzfu.zzaun);
                                            zza(stringBuilder, 3);
                                            stringBuilder.append("}\n");
                                        }
                                    }
                                }
                                zza(stringBuilder, 2);
                                stringBuilder.append("}\n");
                            }
                        }
                    }
                    zza(stringBuilder, 1);
                    stringBuilder.append("}\n");
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    final String zza(zzfj zzfj) {
        int i = 0;
        if (zzfj == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        zza(stringBuilder, 0, "filter_id", zzfj.zzavk);
        zza(stringBuilder, 0, "event_name", zzgq().zzbt(zzfj.zzavl));
        zza(stringBuilder, 1, "event_count_filter", zzfj.zzavo);
        stringBuilder.append("  filters {\n");
        zzfk[] zzfkArr = zzfj.zzavm;
        int length = zzfkArr.length;
        while (i < length) {
            zza(stringBuilder, 2, zzfkArr[i]);
            i++;
        }
        zza(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    final String zza(zzfm zzfm) {
        if (zzfm == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        zza(stringBuilder, 0, "filter_id", zzfm.zzavk);
        zza(stringBuilder, 0, "property_name", zzgq().zzbv(zzfm.zzawa));
        zza(stringBuilder, 1, zzfm.zzawb);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private final void zza(StringBuilder stringBuilder, int i, String str, zzfx zzfx, String str2) {
        if (zzfx != null) {
            int i2;
            long[] jArr;
            int length;
            int i3;
            Long valueOf;
            int i4;
            zza(stringBuilder, 3);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (zzfx.zzayo != null) {
                zza(stringBuilder, 4);
                stringBuilder.append("results: ");
                i2 = 0;
                jArr = zzfx.zzayo;
                length = jArr.length;
                i3 = 0;
                while (i3 < length) {
                    valueOf = Long.valueOf(jArr[i3]);
                    i4 = i2 + 1;
                    if (i2 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i2 = i4;
                }
                stringBuilder.append('\n');
            }
            if (zzfx.zzayn != null) {
                zza(stringBuilder, 4);
                stringBuilder.append("status: ");
                i2 = 0;
                jArr = zzfx.zzayn;
                length = jArr.length;
                i3 = 0;
                while (i3 < length) {
                    valueOf = Long.valueOf(jArr[i3]);
                    i4 = i2 + 1;
                    if (i2 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i2 = i4;
                }
                stringBuilder.append('\n');
            }
            if (zzgv().zzbb(str2)) {
                if (zzfx.zzayp != null) {
                    zza(stringBuilder, 4);
                    stringBuilder.append("dynamic_filter_timestamps: {");
                    i2 = 0;
                    zzfs[] zzfsArr = zzfx.zzayp;
                    length = zzfsArr.length;
                    i3 = 0;
                    while (i3 < length) {
                        zzfs zzfs = zzfsArr[i3];
                        i4 = i2 + 1;
                        if (i2 != 0) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(zzfs.zzawx).append(":").append(zzfs.zzawy);
                        i3++;
                        i2 = i4;
                    }
                    stringBuilder.append("}\n");
                }
                if (zzfx.zzayq != null) {
                    zza(stringBuilder, 4);
                    stringBuilder.append("sequence_filter_timestamps: {");
                    i2 = 0;
                    zzfy[] zzfyArr = zzfx.zzayq;
                    int length2 = zzfyArr.length;
                    int i5 = 0;
                    while (i5 < length2) {
                        zzfy zzfy = zzfyArr[i5];
                        length = i2 + 1;
                        if (i2 != 0) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(zzfy.zzawx).append(": [");
                        i2 = 0;
                        long[] jArr2 = zzfy.zzays;
                        int length3 = jArr2.length;
                        i3 = 0;
                        while (i3 < length3) {
                            long j = jArr2[i3];
                            i4 = i2 + 1;
                            if (i2 != 0) {
                                stringBuilder.append(", ");
                            }
                            stringBuilder.append(j);
                            i3++;
                            i2 = i4;
                        }
                        stringBuilder.append("]");
                        i5++;
                        i2 = length;
                    }
                    stringBuilder.append("}\n");
                }
            }
            zza(stringBuilder, 3);
            stringBuilder.append("}\n");
        }
    }

    private final void zza(StringBuilder stringBuilder, int i, String str, zzfl zzfl) {
        if (zzfl != null) {
            zza(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (zzfl.zzavu != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (zzfl.zzavu.intValue()) {
                    case 1:
                        obj = "LESS_THAN";
                        break;
                    case 2:
                        obj = "GREATER_THAN";
                        break;
                    case 3:
                        obj = "EQUAL";
                        break;
                    case 4:
                        obj = "BETWEEN";
                        break;
                }
                zza(stringBuilder, i, "comparison_type", obj);
            }
            zza(stringBuilder, i, "match_as_float", zzfl.zzavv);
            zza(stringBuilder, i, "comparison_value", zzfl.zzavw);
            zza(stringBuilder, i, "min_comparison_value", zzfl.zzavx);
            zza(stringBuilder, i, "max_comparison_value", zzfl.zzavy);
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private final void zza(StringBuilder stringBuilder, int i, zzfk zzfk) {
        if (zzfk != null) {
            zza(stringBuilder, i);
            stringBuilder.append("filter {\n");
            zza(stringBuilder, i, "complement", zzfk.zzavs);
            zza(stringBuilder, i, "param_name", zzgq().zzbu(zzfk.zzavt));
            int i2 = i + 1;
            String str = "string_filter";
            zzfn zzfn = zzfk.zzavq;
            if (zzfn != null) {
                zza(stringBuilder, i2);
                stringBuilder.append(str);
                stringBuilder.append(" {\n");
                if (zzfn.zzawc != null) {
                    Object obj = "UNKNOWN_MATCH_TYPE";
                    switch (zzfn.zzawc.intValue()) {
                        case 1:
                            obj = "REGEXP";
                            break;
                        case 2:
                            obj = "BEGINS_WITH";
                            break;
                        case 3:
                            obj = "ENDS_WITH";
                            break;
                        case 4:
                            obj = "PARTIAL";
                            break;
                        case 5:
                            obj = "EXACT";
                            break;
                        case 6:
                            obj = "IN_LIST";
                            break;
                    }
                    zza(stringBuilder, i2, "match_type", obj);
                }
                zza(stringBuilder, i2, "expression", zzfn.zzawd);
                zza(stringBuilder, i2, "case_sensitive", zzfn.zzawe);
                if (zzfn.zzawf.length > 0) {
                    zza(stringBuilder, i2 + 1);
                    stringBuilder.append("expression_list {\n");
                    for (String str2 : zzfn.zzawf) {
                        zza(stringBuilder, i2 + 2);
                        stringBuilder.append(str2);
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append("}\n");
                }
                zza(stringBuilder, i2);
                stringBuilder.append("}\n");
            }
            zza(stringBuilder, i + 1, "number_filter", zzfk.zzavr);
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            zza(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    final <T extends Parcelable> T zza(byte[] bArr, Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        T t;
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            t = (Parcelable) creator.createFromParcel(obtain);
            return t;
        } catch (ParseException e) {
            t = zzgt().zzjg();
            t.zzby("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    final boolean zze(zzag zzag, zzk zzk) {
        Preconditions.checkNotNull(zzag);
        Preconditions.checkNotNull(zzk);
        if (!TextUtils.isEmpty(zzk.zzafi) || !TextUtils.isEmpty(zzk.zzafv)) {
            return true;
        }
        zzgw();
        return false;
    }

    static boolean zzcs(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(long[] jArr, int i) {
        if (i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0) {
            return true;
        }
        return false;
    }

    static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i << 6) + i2 < bitSet.length()) {
                if (bitSet.get((i << 6) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    final boolean zzb(long j, long j2) {
        if (j == 0 || j2 <= 0 || Math.abs(zzbx().currentTimeMillis() - j) > j2) {
            return true;
        }
        return false;
    }

    final byte[] zza(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzgt().zzjg().zzg("Failed to ungzip content", e);
            throw e;
        }
    }

    final byte[] zzb(byte[] bArr) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzgt().zzjg().zzg("Failed to gzip content", e);
            throw e;
        }
    }

    final int[] zzmi() {
        Map zzm = zzai.zzm(this.zzamv.getContext());
        if (zzm == null || zzm.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList();
        int intValue = ((Integer) zzai.zzakg.get()).intValue();
        for (Entry entry : zzm.entrySet()) {
            if (((String) entry.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzgt().zzjj().zzg("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzgt().zzjj().zzg("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        intValue = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            int i2 = intValue + 1;
            iArr[intValue] = ((Integer) obj).intValue();
            intValue = i2;
        }
        return iArr;
    }

    public final /* bridge */ /* synthetic */ zzfu zzjr() {
        return super.zzjr();
    }

    public final /* bridge */ /* synthetic */ zzm zzjs() {
        return super.zzjs();
    }

    public final /* bridge */ /* synthetic */ zzt zzjt() {
        return super.zzjt();
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
