package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzrd {
    public static zzqp<?> zzr(Object obj) {
        if (obj == null) {
            return zzqv.zzbpq;
        }
        if (obj instanceof zzqp) {
            return (zzqp) obj;
        }
        if (obj instanceof Boolean) {
            return new zzqs((Boolean) obj);
        }
        if (obj instanceof Short) {
            return new zzqt(Double.valueOf(((Short) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzqt(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Long) {
            return new zzqt(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Float) {
            return new zzqt(Double.valueOf(((Float) obj).doubleValue()));
        }
        if (obj instanceof Double) {
            return new zzqt((Double) obj);
        }
        if (obj instanceof Byte) {
            return new zzrb(obj.toString());
        }
        if (obj instanceof Character) {
            return new zzrb(obj.toString());
        }
        if (obj instanceof String) {
            return new zzrb((String) obj);
        }
        if (obj instanceof List) {
            List arrayList = new ArrayList();
            for (Object zzr : (List) obj) {
                arrayList.add(zzr(zzr));
            }
            return new zzqw(arrayList);
        } else if (obj instanceof Map) {
            r2 = new HashMap();
            for (Entry entry : ((Map) obj).entrySet()) {
                Preconditions.checkArgument(entry.getKey() instanceof String);
                r2.put((String) entry.getKey(), zzr(entry.getValue()));
            }
            return new zzqz(r2);
        } else if (obj instanceof Bundle) {
            r2 = new HashMap();
            for (String str : ((Bundle) obj).keySet()) {
                r2.put(str, zzr(((Bundle) obj).get(str)));
            }
            return new zzqz(r2);
        } else {
            String valueOf = String.valueOf(obj.getClass());
            throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 20).append("Type not supported: ").append(valueOf).toString());
        }
    }

    public static Object zzj(zzqp<?> zzqp) {
        if (zzqp == null) {
            return null;
        }
        if (zzqp == zzqv.zzbpq) {
            return null;
        }
        if (zzqp instanceof zzqs) {
            return (Boolean) ((zzqs) zzqp).value();
        }
        if (zzqp instanceof zzqt) {
            double doubleValue = ((Double) ((zzqt) zzqp).value()).doubleValue();
            if (Double.isInfinite(doubleValue) || doubleValue - Math.floor(doubleValue) >= 1.0E-5d) {
                return ((Double) ((zzqt) zzqp).value()).toString();
            }
            return Integer.valueOf((int) doubleValue);
        } else if (zzqp instanceof zzrb) {
            return (String) ((zzrb) zzqp).value();
        } else {
            if (zzqp instanceof zzqw) {
                List arrayList = new ArrayList();
                for (zzqp zzj : (List) ((zzqw) zzqp).value()) {
                    Object zzj2 = zzj(zzj);
                    if (zzj2 == null) {
                        zzhk.m1081e(String.format("Failure to convert a list element to object: %s (%s)", new Object[]{zzj, zzj.getClass().getCanonicalName()}));
                        return null;
                    }
                    arrayList.add(zzj2);
                }
                return arrayList;
            } else if (zzqp instanceof zzqz) {
                Map hashMap = new HashMap();
                for (Entry entry : ((Map) ((zzqz) zzqp).value()).entrySet()) {
                    Object zzj3 = zzj((zzqp) entry.getValue());
                    if (zzj3 == null) {
                        zzhk.m1081e(String.format("Failure to convert a map's value to object: %s (%s)", new Object[]{entry.getValue(), ((zzqp) entry.getValue()).getClass().getCanonicalName()}));
                        return null;
                    }
                    hashMap.put((String) entry.getKey(), zzj3);
                }
                return hashMap;
            } else {
                String valueOf = String.valueOf(zzqp.getClass());
                zzhk.m1081e(new StringBuilder(String.valueOf(valueOf).length() + 49).append("Converting to Object from unknown abstract type: ").append(valueOf).toString());
                return null;
            }
        }
    }

    public static Bundle zzl(Map<String, zzqp<?>> map) {
        if (map == null) {
            return null;
        }
        Bundle bundle = new Bundle(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getValue() instanceof zzrb) {
                bundle.putString((String) entry.getKey(), (String) ((zzrb) entry.getValue()).value());
            } else if (entry.getValue() instanceof zzqs) {
                bundle.putBoolean((String) entry.getKey(), ((Boolean) ((zzqs) entry.getValue()).value()).booleanValue());
            } else if (entry.getValue() instanceof zzqt) {
                bundle.putDouble((String) entry.getKey(), ((Double) ((zzqt) entry.getValue()).value()).doubleValue());
            } else if (entry.getValue() instanceof zzqz) {
                bundle.putBundle((String) entry.getKey(), zzl((Map) ((zzqz) entry.getValue()).value()));
            } else {
                throw new IllegalArgumentException(String.format("Invalid param type for key '%s'. Only boolean, double and string types and maps of thereof are supported.", new Object[]{entry.getKey()}));
            }
        }
        return bundle;
    }

    public static Map<String, Object> zzg(Bundle bundle) {
        Map<String, Object> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                hashMap.put(str, zzg((Bundle) obj));
            } else if (obj instanceof List) {
                hashMap.put(str, zzh((List) obj));
            } else {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    private static List<Object> zzh(List<Object> list) {
        List<Object> arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof Bundle) {
                arrayList.add(zzg((Bundle) next));
            } else if (next instanceof List) {
                arrayList.add(zzh((List) next));
            } else {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static zzqp zzk(zzqp<?> zzqp) {
        if (zzqp instanceof zzqz) {
            Set<String> hashSet = new HashSet();
            Map map = (Map) ((zzqz) zzqp).value();
            for (Entry entry : map.entrySet()) {
                if (entry.getValue() == zzqv.zzbpr) {
                    hashSet.add((String) entry.getKey());
                }
            }
            for (String remove : hashSet) {
                map.remove(remove);
            }
        }
        return zzqp;
    }

    public static zzqp zza(zzia zzia, zzqp zzqp) {
        Preconditions.checkNotNull(zzqp);
        if (!(zzl(zzqp) || (zzqp instanceof zzqu) || (zzqp instanceof zzqw) || (zzqp instanceof zzqz))) {
            if (zzqp instanceof zzra) {
                zzqp = zza(zzia, (zzra) zzqp);
            } else {
                throw new UnsupportedOperationException("Attempting to evaluate unknown type");
            }
        }
        if (zzqp == null) {
            throw new IllegalArgumentException("AbstractType evaluated to Java null");
        } else if (!(zzqp instanceof zzra)) {
            return zzqp;
        } else {
            throw new IllegalArgumentException("AbstractType evaluated to illegal type Statement.");
        }
    }

    public static zzqv zza(zzia zzia, List<zzqp<?>> list) {
        for (zzqp zzqp : list) {
            Preconditions.checkArgument(zzqp instanceof zzra);
            zzqp zzqp2 = zza(zzia, zzqp2);
            if (zzm(zzqp2)) {
                return (zzqv) zzqp2;
            }
        }
        return zzqv.zzbpr;
    }

    public static boolean zzl(zzqp zzqp) {
        if ((zzqp instanceof zzqs) || (zzqp instanceof zzqt) || (zzqp instanceof zzrb) || zzqp == zzqv.zzbpq || zzqp == zzqv.zzbpr) {
            return true;
        }
        return false;
    }

    public static boolean zzm(zzqp zzqp) {
        return zzqp == zzqv.zzbpp || zzqp == zzqv.zzbpo || ((zzqp instanceof zzqv) && ((zzqv) zzqp).zzsv());
    }

    public static zzqp zza(zzia zzia, zzra zzra) {
        String zzsx = zzra.zzsx();
        List zzsy = zzra.zzsy();
        zzqp zzeq = zzia.zzeq(zzsx);
        if (zzeq == null) {
            throw new UnsupportedOperationException(new StringBuilder(String.valueOf(zzsx).length() + 28).append("Function '").append(zzsx).append("' is not supported").toString());
        } else if (zzeq instanceof zzqu) {
            return ((zzjo) ((zzqu) zzeq).value()).zzb(zzia, (zzqp[]) zzsy.toArray(new zzqp[zzsy.size()]));
        } else {
            throw new UnsupportedOperationException(new StringBuilder(String.valueOf(zzsx).length() + 29).append("Function '").append(zzsx).append("' is not a function").toString());
        }
    }
}
