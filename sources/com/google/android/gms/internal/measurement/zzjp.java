package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;

public final class zzjp {
    public static boolean zza(zzqp<?> zzqp) {
        Preconditions.checkArgument(zzqp != null);
        if (zzqp == zzqv.zzbpr || zzqp == zzqv.zzbpq) {
            return false;
        }
        if (zzqp instanceof zzqs) {
            return ((Boolean) ((zzqs) zzqp).value()).booleanValue();
        }
        if (zzqp instanceof zzqt) {
            if (((Double) ((zzqt) zzqp).value()).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || ((Double) ((zzqt) zzqp).value()).doubleValue() == -0.0d || Double.isNaN(((Double) ((zzqt) zzqp).value()).doubleValue())) {
                return false;
            }
        } else if (zzqp instanceof zzrb) {
            if (((String) ((zzrb) zzqp).value()).isEmpty()) {
                return false;
            }
        } else if (zzf(zzqp)) {
            String zzqp2 = zzqp.toString();
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(zzqp2).length() + 33).append("Illegal type given to isTruthy: ").append(zzqp2).append(".").toString());
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double zzb(com.google.android.gms.internal.measurement.zzqp<?> r10) {
        /*
        r3 = 1;
        r4 = 0;
        r6 = 9221120237041090560; // 0x7ff8000000000000 float:0.0 double:NaN;
        r8 = 0;
        r0 = r10;
    L_0x0007:
        if (r0 == 0) goto L_0x0013;
    L_0x0009:
        r1 = r3;
    L_0x000a:
        com.google.android.gms.common.internal.Preconditions.checkArgument(r1);
        r1 = com.google.android.gms.internal.measurement.zzqv.zzbpr;
        if (r0 != r1) goto L_0x0015;
    L_0x0011:
        r0 = r6;
    L_0x0012:
        return r0;
    L_0x0013:
        r1 = r4;
        goto L_0x000a;
    L_0x0015:
        r1 = com.google.android.gms.internal.measurement.zzqv.zzbpq;
        if (r0 != r1) goto L_0x001b;
    L_0x0019:
        r0 = r8;
        goto L_0x0012;
    L_0x001b:
        r1 = r0 instanceof com.google.android.gms.internal.measurement.zzqs;
        if (r1 == 0) goto L_0x0032;
    L_0x001f:
        r0 = (com.google.android.gms.internal.measurement.zzqs) r0;
        r0 = r0.value();
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0030;
    L_0x002d:
        r0 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        goto L_0x0012;
    L_0x0030:
        r0 = r8;
        goto L_0x0012;
    L_0x0032:
        r1 = r0 instanceof com.google.android.gms.internal.measurement.zzqt;
        if (r1 == 0) goto L_0x0043;
    L_0x0036:
        r0 = (com.google.android.gms.internal.measurement.zzqt) r0;
        r0 = r0.value();
        r0 = (java.lang.Double) r0;
        r0 = r0.doubleValue();
        goto L_0x0012;
    L_0x0043:
        r1 = r0 instanceof com.google.android.gms.internal.measurement.zzqw;
        if (r1 == 0) goto L_0x0072;
    L_0x0047:
        r1 = r0;
        r1 = (com.google.android.gms.internal.measurement.zzqw) r1;
        r2 = r1.value();
        r2 = (java.util.List) r2;
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x0058;
    L_0x0056:
        r0 = r8;
        goto L_0x0012;
    L_0x0058:
        r2 = r1.value();
        r2 = (java.util.List) r2;
        r2 = r2.size();
        if (r2 != r3) goto L_0x0095;
    L_0x0064:
        r0 = new com.google.android.gms.internal.measurement.zzrb;
        r1 = r1.zzae(r4);
        r1 = zzd(r1);
        r0.<init>(r1);
        goto L_0x0007;
    L_0x0072:
        r1 = r0 instanceof com.google.android.gms.internal.measurement.zzrb;
        if (r1 == 0) goto L_0x0095;
    L_0x0076:
        r0 = (com.google.android.gms.internal.measurement.zzrb) r0;
        r1 = r0.value();
        r1 = (java.lang.String) r1;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0086;
    L_0x0084:
        r0 = r8;
        goto L_0x0012;
    L_0x0086:
        r0 = r0.value();	 Catch:{ NumberFormatException -> 0x0091 }
        r0 = (java.lang.String) r0;	 Catch:{ NumberFormatException -> 0x0091 }
        r0 = java.lang.Double.parseDouble(r0);	 Catch:{ NumberFormatException -> 0x0091 }
        goto L_0x0012;
    L_0x0091:
        r0 = move-exception;
        r0 = r6;
        goto L_0x0012;
    L_0x0095:
        r1 = zzf(r0);
        if (r1 == 0) goto L_0x00c8;
    L_0x009b:
        r1 = new java.lang.IllegalArgumentException;
        r0 = r0.toString();
        r2 = java.lang.String.valueOf(r0);
        r2 = r2.length();
        r2 = r2 + 41;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Illegal type given to numberEquivalent: ";
        r2 = r3.append(r2);
        r0 = r2.append(r0);
        r2 = ".";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x00c8:
        r0 = r6;
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjp.zzb(com.google.android.gms.internal.measurement.zzqp):double");
    }

    public static double zzc(zzqp<?> zzqp) {
        double zzb = zzb(zzqp);
        if (Double.isNaN(zzb)) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (zzb == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || zzb == -0.0d || Double.isInfinite(zzb)) {
            return zzb;
        }
        return Math.signum(zzb) * Math.floor(Math.abs(zzb));
    }

    public static String zzd(zzqp<?> zzqp) {
        int i = 1;
        Preconditions.checkArgument(zzqp != null);
        if (zzqp == zzqv.zzbpr) {
            return "undefined";
        }
        if (zzqp == zzqv.zzbpq) {
            return "null";
        }
        if (zzqp instanceof zzqs) {
            return ((Boolean) ((zzqs) zzqp).value()).booleanValue() ? "true" : "false";
        } else {
            String d;
            if (zzqp instanceof zzqt) {
                d = Double.toString(((Double) ((zzqt) zzqp).value()).doubleValue());
                int indexOf = d.indexOf("E");
                if (indexOf > 0) {
                    int parseInt = Integer.parseInt(d.substring(indexOf + 1, d.length()));
                    int i2;
                    if (parseInt < 0) {
                        if (parseInt <= -7) {
                            return d.replace("E", "e");
                        }
                        String replace = d.substring(0, indexOf).replace(".", "");
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("0.");
                        for (i2 = parseInt; i2 + 1 < 0; i2++) {
                            stringBuilder.append("0");
                        }
                        stringBuilder.append(replace);
                        return stringBuilder.toString();
                    } else if (parseInt >= 21) {
                        return d.replace("E", "e+");
                    } else {
                        String replace2 = d.substring(0, indexOf).replace(".", "");
                        i2 = parseInt + 1;
                        parseInt = replace2.length();
                        if (!replace2.startsWith("-")) {
                            i = 0;
                        }
                        i2 -= parseInt - i;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        if (i2 < 0) {
                            i2 += replace2.length();
                            stringBuilder2.append(replace2.substring(0, i2));
                            stringBuilder2.append(".");
                            stringBuilder2.append(replace2.substring(i2, replace2.length()));
                        } else {
                            stringBuilder2.append(replace2);
                            while (i2 > 0) {
                                stringBuilder2.append("0");
                                i2--;
                            }
                        }
                        return stringBuilder2.toString();
                    }
                } else if (!d.endsWith(".0")) {
                    return d;
                } else {
                    d = d.substring(0, d.length() - 2);
                    if (d.equals("-0")) {
                        return "0";
                    }
                    return d;
                }
            }
            if (zzqp instanceof zzqu) {
                zzjo zzjo = (zzjo) ((zzqu) zzqp).value();
                if (zzjo instanceof zzjn) {
                    return ((zzjn) zzjo).getName();
                }
            } else if (zzqp instanceof zzqw) {
                Iterable arrayList = new ArrayList();
                for (zzqp zzqp2 : (List) ((zzqw) zzqp).value()) {
                    if (zzqp2 == zzqv.zzbpq || zzqp2 == zzqv.zzbpr) {
                        arrayList.add("");
                    } else {
                        arrayList.add(zzd(zzqp2));
                    }
                }
                return TextUtils.join(",", arrayList);
            } else if (zzqp instanceof zzqz) {
                return "[object Object]";
            } else {
                if (zzqp instanceof zzrb) {
                    return (String) ((zzrb) zzqp).value();
                }
            }
            if (zzf(zzqp)) {
                d = zzqp.toString();
                d = new StringBuilder(String.valueOf(d).length() + 41).append("Illegal type given to stringEquivalent: ").append(d).append(".").toString();
            } else {
                d = "Unknown type in stringEquivalent.";
            }
            throw new IllegalArgumentException(d);
        }
    }

    public static double zza(zzqp<?> zzqp, zzqp<?> zzqp2) {
        boolean z = true;
        Preconditions.checkArgument(zzqp != null);
        if (zzqp2 == null) {
            z = false;
        }
        Preconditions.checkArgument(z);
        double zzb = zzb(zzqp);
        double zzb2 = zzb(zzqp2);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return Double.NaN;
        }
        if ((zzb == Double.POSITIVE_INFINITY && zzb2 == Double.NEGATIVE_INFINITY) || (zzb == Double.NEGATIVE_INFINITY && zzb2 == Double.POSITIVE_INFINITY)) {
            return Double.NaN;
        }
        if (Double.isInfinite(zzb) && !Double.isInfinite(zzb2)) {
            return zzb;
        }
        if (Double.isInfinite(zzb) || !Double.isInfinite(zzb2)) {
            return zzb + zzb2;
        }
        return zzb2;
    }

    public static boolean zzb(zzqp<?> zzqp, zzqp<?> zzqp2) {
        boolean z;
        if (zzqp != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzqp2 != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        String zzqp3;
        if (zzf(zzqp)) {
            zzqp3 = zzqp.toString();
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(zzqp3).length() + 50).append("Illegal type given to abstractRelationalCompare: ").append(zzqp3).append(".").toString());
        } else if (zzf(zzqp2)) {
            zzqp3 = zzqp2.toString();
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(zzqp3).length() + 50).append("Illegal type given to abstractRelationalCompare: ").append(zzqp3).append(".").toString());
        } else {
            zzqp zzrb;
            zzqp zzrb2;
            if ((zzqp instanceof zzqz) || (zzqp instanceof zzqw) || (zzqp instanceof zzqu)) {
                zzrb = new zzrb(zzd(zzqp));
            } else {
                zzqp<?> zzqp4 = zzqp;
            }
            if ((zzqp2 instanceof zzqz) || (zzqp2 instanceof zzqw) || (zzqp2 instanceof zzqu)) {
                zzrb2 = new zzrb(zzd(zzqp2));
            } else {
                zzqp<?> zzqp5 = zzqp2;
            }
            if (!(zzrb instanceof zzrb) || !(zzrb2 instanceof zzrb)) {
                double zzb = zzb(zzrb);
                double zzb2 = zzb(zzrb2);
                if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
                    return false;
                }
                if (zzb == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && zzb2 == -0.0d) {
                    return false;
                }
                if ((zzb == -0.0d && zzb2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) || zzb == Double.POSITIVE_INFINITY) {
                    return false;
                }
                if (zzb2 == Double.POSITIVE_INFINITY) {
                    return true;
                }
                if (zzb2 == Double.NEGATIVE_INFINITY) {
                    return false;
                }
                if (zzb == Double.NEGATIVE_INFINITY) {
                    return true;
                }
                if (Double.compare(zzb, zzb2) < 0) {
                    return true;
                }
                return false;
            } else if (((String) ((zzrb) zzrb).value()).compareTo((String) ((zzrb) zzrb2).value()) < 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static String zze(zzqp<?> zzqp) {
        if (zzqp == zzqv.zzbpr) {
            return "Undefined";
        }
        if (zzqp == zzqv.zzbpq) {
            return "Null";
        }
        if (zzqp instanceof zzqs) {
            return "Boolean";
        }
        if (zzqp instanceof zzqt) {
            return "Number";
        }
        if (zzqp instanceof zzrb) {
            return "String";
        }
        return "Object";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzc(com.google.android.gms.internal.measurement.zzqp<?> r8, com.google.android.gms.internal.measurement.zzqp<?> r9) {
        /*
        r3 = 1;
        r4 = 0;
        r1 = r9;
        r0 = r8;
    L_0x0004:
        if (r0 == 0) goto L_0x0043;
    L_0x0006:
        r2 = r3;
    L_0x0007:
        com.google.android.gms.common.internal.Preconditions.checkArgument(r2);
        if (r1 == 0) goto L_0x0045;
    L_0x000c:
        r2 = r3;
    L_0x000d:
        com.google.android.gms.common.internal.Preconditions.checkArgument(r2);
        r2 = zzf(r0);
        if (r2 == 0) goto L_0x0047;
    L_0x0016:
        r1 = new java.lang.IllegalArgumentException;
        r0 = r0.toString();
        r2 = java.lang.String.valueOf(r0);
        r2 = r2.length();
        r2 = r2 + 48;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Illegal type given to abstractEqualityCompare: ";
        r2 = r3.append(r2);
        r0 = r2.append(r0);
        r2 = ".";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0043:
        r2 = r4;
        goto L_0x0007;
    L_0x0045:
        r2 = r4;
        goto L_0x000d;
    L_0x0047:
        r2 = zzf(r1);
        if (r2 == 0) goto L_0x007a;
    L_0x004d:
        r0 = new java.lang.IllegalArgumentException;
        r1 = r1.toString();
        r2 = java.lang.String.valueOf(r1);
        r2 = r2.length();
        r2 = r2 + 48;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Illegal type given to abstractEqualityCompare: ";
        r2 = r3.append(r2);
        r1 = r2.append(r1);
        r2 = ".";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x007a:
        r5 = zze(r0);
        r2 = zze(r1);
        r6 = r5.equals(r2);
        if (r6 == 0) goto L_0x012c;
    L_0x0088:
        r2 = -1;
        r6 = r5.hashCode();
        switch(r6) {
            case -1950496919: goto L_0x00a8;
            case -1939501217: goto L_0x00c6;
            case -1808118735: goto L_0x00b2;
            case 2439591: goto L_0x009e;
            case 965837104: goto L_0x0094;
            case 1729365000: goto L_0x00bc;
            default: goto L_0x0090;
        };
    L_0x0090:
        switch(r2) {
            case 0: goto L_0x00d0;
            case 1: goto L_0x00d0;
            case 2: goto L_0x00d2;
            case 3: goto L_0x00fd;
            case 4: goto L_0x0112;
            case 5: goto L_0x0127;
            default: goto L_0x0093;
        };
    L_0x0093:
        return r4;
    L_0x0094:
        r6 = "Undefined";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0090;
    L_0x009c:
        r2 = r4;
        goto L_0x0090;
    L_0x009e:
        r6 = "Null";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0090;
    L_0x00a6:
        r2 = r3;
        goto L_0x0090;
    L_0x00a8:
        r6 = "Number";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0090;
    L_0x00b0:
        r2 = 2;
        goto L_0x0090;
    L_0x00b2:
        r6 = "String";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0090;
    L_0x00ba:
        r2 = 3;
        goto L_0x0090;
    L_0x00bc:
        r6 = "Boolean";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0090;
    L_0x00c4:
        r2 = 4;
        goto L_0x0090;
    L_0x00c6:
        r6 = "Object";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0090;
    L_0x00ce:
        r2 = 5;
        goto L_0x0090;
    L_0x00d0:
        r4 = r3;
        goto L_0x0093;
    L_0x00d2:
        r0 = (com.google.android.gms.internal.measurement.zzqt) r0;
        r0 = r0.value();
        r0 = (java.lang.Double) r0;
        r6 = r0.doubleValue();
        r0 = r1;
        r0 = (com.google.android.gms.internal.measurement.zzqt) r0;
        r0 = r0.value();
        r0 = (java.lang.Double) r0;
        r0 = r0.doubleValue();
        r2 = java.lang.Double.isNaN(r6);
        if (r2 != 0) goto L_0x0093;
    L_0x00f1:
        r2 = java.lang.Double.isNaN(r0);
        if (r2 != 0) goto L_0x0093;
    L_0x00f7:
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 != 0) goto L_0x0093;
    L_0x00fb:
        r4 = r3;
        goto L_0x0093;
    L_0x00fd:
        r0 = (com.google.android.gms.internal.measurement.zzrb) r0;
        r0 = r0.value();
        r0 = (java.lang.String) r0;
        r1 = (com.google.android.gms.internal.measurement.zzrb) r1;
        r1 = r1.value();
        r1 = (java.lang.String) r1;
        r4 = r0.equals(r1);
        goto L_0x0093;
    L_0x0112:
        r0 = (com.google.android.gms.internal.measurement.zzqs) r0;
        r0 = r0.value();
        r0 = (java.lang.Boolean) r0;
        r1 = (com.google.android.gms.internal.measurement.zzqs) r1;
        r1 = r1.value();
        r1 = (java.lang.Boolean) r1;
        if (r0 != r1) goto L_0x0093;
    L_0x0124:
        r4 = r3;
        goto L_0x0093;
    L_0x0127:
        if (r0 != r1) goto L_0x0093;
    L_0x0129:
        r4 = r3;
        goto L_0x0093;
    L_0x012c:
        r6 = com.google.android.gms.internal.measurement.zzqv.zzbpr;
        if (r0 == r6) goto L_0x0134;
    L_0x0130:
        r6 = com.google.android.gms.internal.measurement.zzqv.zzbpq;
        if (r0 != r6) goto L_0x013f;
    L_0x0134:
        r6 = com.google.android.gms.internal.measurement.zzqv.zzbpr;
        if (r1 == r6) goto L_0x013c;
    L_0x0138:
        r6 = com.google.android.gms.internal.measurement.zzqv.zzbpq;
        if (r1 != r6) goto L_0x013f;
    L_0x013c:
        r4 = r3;
        goto L_0x0093;
    L_0x013f:
        r6 = "Number";
        r6 = r5.equals(r6);
        if (r6 == 0) goto L_0x015f;
    L_0x0147:
        r6 = "String";
        r6 = r2.equals(r6);
        if (r6 == 0) goto L_0x015f;
    L_0x014f:
        r9 = new com.google.android.gms.internal.measurement.zzqt;
        r6 = zzb(r1);
        r1 = java.lang.Double.valueOf(r6);
        r9.<init>(r1);
        r1 = r9;
        goto L_0x0004;
    L_0x015f:
        r6 = "String";
        r6 = r5.equals(r6);
        if (r6 == 0) goto L_0x017f;
    L_0x0167:
        r6 = "Number";
        r6 = r2.equals(r6);
        if (r6 == 0) goto L_0x017f;
    L_0x016f:
        r8 = new com.google.android.gms.internal.measurement.zzqt;
        r6 = zzb(r0);
        r0 = java.lang.Double.valueOf(r6);
        r8.<init>(r0);
        r0 = r8;
        goto L_0x0004;
    L_0x017f:
        r6 = "Boolean";
        r6 = r5.equals(r6);
        if (r6 == 0) goto L_0x0197;
    L_0x0187:
        r8 = new com.google.android.gms.internal.measurement.zzqt;
        r6 = zzb(r0);
        r0 = java.lang.Double.valueOf(r6);
        r8.<init>(r0);
        r0 = r8;
        goto L_0x0004;
    L_0x0197:
        r6 = "Boolean";
        r6 = r2.equals(r6);
        if (r6 == 0) goto L_0x01af;
    L_0x019f:
        r9 = new com.google.android.gms.internal.measurement.zzqt;
        r6 = zzb(r1);
        r1 = java.lang.Double.valueOf(r6);
        r9.<init>(r1);
        r1 = r9;
        goto L_0x0004;
    L_0x01af:
        r6 = "String";
        r6 = r5.equals(r6);
        if (r6 != 0) goto L_0x01bf;
    L_0x01b7:
        r6 = "Number";
        r6 = r5.equals(r6);
        if (r6 == 0) goto L_0x01d3;
    L_0x01bf:
        r6 = "Object";
        r6 = r2.equals(r6);
        if (r6 == 0) goto L_0x01d3;
    L_0x01c7:
        r9 = new com.google.android.gms.internal.measurement.zzrb;
        r1 = zzd(r1);
        r9.<init>(r1);
        r1 = r9;
        goto L_0x0004;
    L_0x01d3:
        r6 = "Object";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x0093;
    L_0x01db:
        r5 = "String";
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x01eb;
    L_0x01e3:
        r5 = "Number";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x0093;
    L_0x01eb:
        r8 = new com.google.android.gms.internal.measurement.zzrb;
        r0 = zzd(r0);
        r8.<init>(r0);
        r0 = r8;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjp.zzc(com.google.android.gms.internal.measurement.zzqp, com.google.android.gms.internal.measurement.zzqp):boolean");
    }

    public static boolean zzd(zzqp<?> zzqp, zzqp<?> zzqp2) {
        boolean z;
        if (zzqp != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzqp2 != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        String zzqp3;
        if (zzf(zzqp)) {
            zzqp3 = zzqp.toString();
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(zzqp3).length() + 46).append("Illegal type given to strictEqualityCompare: ").append(zzqp3).append(".").toString());
        } else if (zzf(zzqp2)) {
            zzqp3 = zzqp2.toString();
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(zzqp3).length() + 46).append("Illegal type given to strictEqualityCompare: ").append(zzqp3).append(".").toString());
        } else {
            zzqp3 = zze(zzqp);
            if (!zzqp3.equals(zze(zzqp2))) {
                return false;
            }
            z = true;
            switch (zzqp3.hashCode()) {
                case -1950496919:
                    if (zzqp3.equals("Number")) {
                        z = true;
                        break;
                    }
                    break;
                case -1808118735:
                    if (zzqp3.equals("String")) {
                        z = true;
                        break;
                    }
                    break;
                case 2439591:
                    if (zzqp3.equals("Null")) {
                        z = true;
                        break;
                    }
                    break;
                case 965837104:
                    if (zzqp3.equals("Undefined")) {
                        z = false;
                        break;
                    }
                    break;
                case 1729365000:
                    if (zzqp3.equals("Boolean")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                case true:
                    return true;
                case true:
                    double doubleValue = ((Double) ((zzqt) zzqp).value()).doubleValue();
                    double doubleValue2 = ((Double) ((zzqt) zzqp2).value()).doubleValue();
                    if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || doubleValue != doubleValue2) {
                        return false;
                    }
                    return true;
                case true:
                    if (((String) ((zzrb) zzqp).value()).equals((String) ((zzrb) zzqp2).value())) {
                        return true;
                    }
                    return false;
                case true:
                    if (((Boolean) ((zzqs) zzqp).value()) == ((Boolean) ((zzqs) zzqp2).value())) {
                        return true;
                    }
                    return false;
                default:
                    if (zzqp == zzqp2) {
                        return true;
                    }
                    return false;
            }
        }
    }

    private static boolean zzf(zzqp<?> zzqp) {
        return (zzqp instanceof zzra) || !(!(zzqp instanceof zzqv) || zzqp == zzqv.zzbpr || zzqp == zzqv.zzbpq);
    }
}
