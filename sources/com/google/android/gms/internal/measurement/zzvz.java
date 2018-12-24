package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.internal.measurement.zzuo.zze;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.aztec.encoder.Encoder;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.LangUtils;
import sun.misc.Unsafe;

final class zzvz<T> implements zzwl<T> {
    private static final int[] zzcao = new int[0];
    private static final Unsafe zzcap = zzxj.zzyq();
    private final int[] zzcaq;
    private final Object[] zzcar;
    private final int zzcas;
    private final int zzcat;
    private final zzvv zzcau;
    private final boolean zzcav;
    private final boolean zzcaw;
    private final boolean zzcax;
    private final boolean zzcay;
    private final int[] zzcaz;
    private final int zzcba;
    private final int zzcbb;
    private final zzwc zzcbc;
    private final zzvf zzcbd;
    private final zzxd<?, ?> zzcbe;
    private final zzuc<?> zzcbf;
    private final zzvq zzcbg;

    private zzvz(int[] iArr, Object[] objArr, int i, int i2, zzvv zzvv, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzwc zzwc, zzvf zzvf, zzxd<?, ?> zzxd, zzuc<?> zzuc, zzvq zzvq) {
        this.zzcaq = iArr;
        this.zzcar = objArr;
        this.zzcas = i;
        this.zzcat = i2;
        this.zzcaw = zzvv instanceof zzuo;
        this.zzcax = z;
        boolean z3 = zzuc != null && zzuc.zze(zzvv);
        this.zzcav = z3;
        this.zzcay = false;
        this.zzcaz = iArr2;
        this.zzcba = i3;
        this.zzcbb = i4;
        this.zzcbc = zzwc;
        this.zzcbd = zzvf;
        this.zzcbe = zzxd;
        this.zzcbf = zzuc;
        this.zzcau = zzvv;
        this.zzcbg = zzvq;
    }

    static <T> zzvz<T> zza(Class<T> cls, zzvt zzvt, zzwc zzwc, zzvf zzvf, zzxd<?, ?> zzxd, zzuc<?> zzuc, zzvq zzvq) {
        if (zzvt instanceof zzwj) {
            int i;
            int i2;
            int i3;
            char charAt;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int[] iArr;
            int i10;
            int i11;
            char charAt2;
            char charAt3;
            zzwj zzwj = (zzwj) zzvt;
            boolean z = zzwj.zzxm() == zze.zzbyt;
            String zzxv = zzwj.zzxv();
            int length = zzxv.length();
            int i12 = 1;
            char charAt4 = zzxv.charAt(0);
            if (charAt4 >= '?') {
                i = charAt4 & 8191;
                i2 = 13;
                while (true) {
                    i3 = i12 + 1;
                    charAt = zzxv.charAt(i12);
                    if (charAt < '?') {
                        break;
                    }
                    i |= (charAt & 8191) << i2;
                    i2 += 13;
                    i12 = i3;
                }
                i4 = (charAt << i2) | i;
            } else {
                char c = charAt4;
                i3 = 1;
            }
            i12 = i3 + 1;
            i2 = zzxv.charAt(i3);
            if (i2 >= 55296) {
                i = i2 & 8191;
                i2 = 13;
                while (true) {
                    i3 = i12 + 1;
                    charAt = zzxv.charAt(i12);
                    if (charAt < '?') {
                        break;
                    }
                    i |= (charAt & 8191) << i2;
                    i2 += 13;
                    i12 = i3;
                }
                i2 = (charAt << i2) | i;
                i5 = i3;
            } else {
                i5 = i12;
            }
            if (i2 == 0) {
                i3 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                iArr = zzcao;
                i10 = 0;
                i11 = 0;
            } else {
                char charAt5;
                char charAt6;
                char charAt7;
                char charAt8;
                i12 = i5 + 1;
                i2 = zzxv.charAt(i5);
                if (i2 >= 55296) {
                    i = i2 & 8191;
                    i2 = 13;
                    while (true) {
                        i3 = i12 + 1;
                        charAt = zzxv.charAt(i12);
                        if (charAt < '?') {
                            break;
                        }
                        i |= (charAt & 8191) << i2;
                        i2 += 13;
                        i12 = i3;
                    }
                    i2 = (charAt << i2) | i;
                } else {
                    i3 = i12;
                }
                i6 = i3 + 1;
                i = zzxv.charAt(i3);
                if (i >= 55296) {
                    i12 = i & 8191;
                    i = 13;
                    i3 = i6;
                    while (true) {
                        i6 = i3 + 1;
                        charAt5 = zzxv.charAt(i3);
                        if (charAt5 < '?') {
                            break;
                        }
                        i12 |= (charAt5 & 8191) << i;
                        i += 13;
                        i3 = i6;
                    }
                    i = (charAt5 << i) | i12;
                }
                i7 = i6 + 1;
                charAt = zzxv.charAt(i6);
                if (charAt >= '?') {
                    i3 = charAt & 8191;
                    i12 = 13;
                    i6 = i7;
                    while (true) {
                        i7 = i6 + 1;
                        charAt6 = zzxv.charAt(i6);
                        if (charAt6 < '?') {
                            break;
                        }
                        i3 |= (charAt6 & 8191) << i12;
                        i12 += 13;
                        i6 = i7;
                    }
                    charAt = (charAt6 << i12) | i3;
                }
                int i13 = i7 + 1;
                charAt5 = zzxv.charAt(i7);
                if (charAt5 >= '?') {
                    i6 = charAt5 & 8191;
                    i3 = 13;
                    i7 = i13;
                    while (true) {
                        i13 = i7 + 1;
                        charAt2 = zzxv.charAt(i7);
                        if (charAt2 < '?') {
                            break;
                        }
                        i6 |= (charAt2 & 8191) << i3;
                        i3 += 13;
                        i7 = i13;
                    }
                    i6 = (charAt2 << i3) | i6;
                } else {
                    charAt6 = charAt5;
                }
                i9 = i13 + 1;
                charAt5 = zzxv.charAt(i13);
                if (charAt5 >= '?') {
                    i7 = charAt5 & 8191;
                    i3 = 13;
                    i13 = i9;
                    while (true) {
                        i9 = i13 + 1;
                        charAt7 = zzxv.charAt(i13);
                        if (charAt7 < '?') {
                            break;
                        }
                        i7 |= (charAt7 & 8191) << i3;
                        i3 += 13;
                        i13 = i9;
                    }
                    i7 = (charAt7 << i3) | i7;
                } else {
                    charAt2 = charAt5;
                }
                i10 = i9 + 1;
                charAt5 = zzxv.charAt(i9);
                if (charAt5 >= '?') {
                    i13 = charAt5 & 8191;
                    i3 = 13;
                    i9 = i10;
                    while (true) {
                        i10 = i9 + 1;
                        charAt8 = zzxv.charAt(i9);
                        if (charAt8 < '?') {
                            break;
                        }
                        i13 |= (charAt8 & 8191) << i3;
                        i3 += 13;
                        i9 = i10;
                    }
                    i8 = (charAt8 << i3) | i13;
                } else {
                    char c2 = charAt5;
                }
                i9 = i10 + 1;
                i3 = zzxv.charAt(i10);
                if (i3 >= 55296) {
                    i13 = i3 & 8191;
                    i3 = 13;
                    while (true) {
                        i10 = i9 + 1;
                        charAt8 = zzxv.charAt(i9);
                        if (charAt8 < '?') {
                            break;
                        }
                        i13 |= (charAt8 & 8191) << i3;
                        i3 += 13;
                        i9 = i10;
                    }
                    i3 = (charAt8 << i3) | i13;
                } else {
                    i10 = i9;
                }
                i5 = i10 + 1;
                charAt7 = zzxv.charAt(i10);
                if (charAt7 >= '?') {
                    i9 = charAt7 & 8191;
                    i13 = 13;
                    i10 = i5;
                    while (true) {
                        i5 = i10 + 1;
                        charAt3 = zzxv.charAt(i10);
                        if (charAt3 < '?') {
                            break;
                        }
                        i9 |= (charAt3 & 8191) << i13;
                        i13 += 13;
                        i10 = i5;
                    }
                    i9 = (charAt3 << i13) | i9;
                } else {
                    charAt8 = charAt7;
                }
                iArr = new int[(i3 + (i9 + i8))];
                i10 = i + (i2 << 1);
                charAt5 = charAt;
                i11 = i2;
            }
            Unsafe unsafe = zzcap;
            Object[] zzxw = zzwj.zzxw();
            int i14 = 0;
            Class cls2 = zzwj.zzxo().getClass();
            int[] iArr2 = new int[(i7 * 3)];
            Object[] objArr = new Object[(i7 << 1)];
            int i15 = i9 + i8;
            int i16 = 0;
            int i17 = i9;
            int i18 = i10;
            int i19;
            for (i5 = 
/*
Method generation error in method: com.google.android.gms.internal.measurement.zzvz.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzvt, com.google.android.gms.internal.measurement.zzwc, com.google.android.gms.internal.measurement.zzvf, com.google.android.gms.internal.measurement.zzxd, com.google.android.gms.internal.measurement.zzuc, com.google.android.gms.internal.measurement.zzvq):com.google.android.gms.internal.measurement.zzvz<T>, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r14_2 'i5' int) = (r14_1 'i5' int), (r14_39 'i5' int) binds: {(r14_1 'i5' int)=B:21:0x0071, (r14_39 'i5' int)=B:87:0x021b} in method: com.google.android.gms.internal.measurement.zzvz.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzvt, com.google.android.gms.internal.measurement.zzwc, com.google.android.gms.internal.measurement.zzvf, com.google.android.gms.internal.measurement.zzxd, com.google.android.gms.internal.measurement.zzuc, com.google.android.gms.internal.measurement.zzvq):com.google.android.gms.internal.measurement.zzvz<T>, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:187)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:12)
	at jadx.core.ProcessClass.process(ProcessClass.java:40)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/587003819.run(Unknown Source)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 23 more

*/

            private static Field zza(Class<?> cls, String str) {
                Field declaredField;
                try {
                    declaredField = cls.getDeclaredField(str);
                } catch (NoSuchFieldException e) {
                    Field[] declaredFields = cls.getDeclaredFields();
                    int length = declaredFields.length;
                    int i = 0;
                    while (i < length) {
                        declaredField = declaredFields[i];
                        if (!str.equals(declaredField.getName())) {
                            i++;
                        }
                    }
                    String name = cls.getName();
                    String arrays = Arrays.toString(declaredFields);
                    throw new RuntimeException(new StringBuilder(((String.valueOf(str).length() + 40) + String.valueOf(name).length()) + String.valueOf(arrays).length()).append("Field ").append(str).append(" for ").append(name).append(" not found. Known fields are ").append(arrays).toString());
                }
                return declaredField;
            }

            public final T newInstance() {
                return this.zzcbc.newInstance(this.zzcau);
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(T r12, T r13) {
                /*
                r11 = this;
                r1 = 1;
                r10 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
                r0 = 0;
                r2 = r11.zzcaq;
                r4 = r2.length;
                r3 = r0;
            L_0x0009:
                if (r3 >= r4) goto L_0x01e0;
            L_0x000b:
                r2 = r11.zzbt(r3);
                r5 = r2 & r10;
                r6 = (long) r5;
                r5 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
                r2 = r2 & r5;
                r2 = r2 >>> 20;
                switch(r2) {
                    case 0: goto L_0x001e;
                    case 1: goto L_0x003a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0068;
                    case 4: goto L_0x007c;
                    case 5: goto L_0x008e;
                    case 6: goto L_0x00a3;
                    case 7: goto L_0x00b6;
                    case 8: goto L_0x00c9;
                    case 9: goto L_0x00e0;
                    case 10: goto L_0x00f7;
                    case 11: goto L_0x010e;
                    case 12: goto L_0x0121;
                    case 13: goto L_0x0134;
                    case 14: goto L_0x0147;
                    case 15: goto L_0x015c;
                    case 16: goto L_0x016f;
                    case 17: goto L_0x0184;
                    case 18: goto L_0x019b;
                    case 19: goto L_0x019b;
                    case 20: goto L_0x019b;
                    case 21: goto L_0x019b;
                    case 22: goto L_0x019b;
                    case 23: goto L_0x019b;
                    case 24: goto L_0x019b;
                    case 25: goto L_0x019b;
                    case 26: goto L_0x019b;
                    case 27: goto L_0x019b;
                    case 28: goto L_0x019b;
                    case 29: goto L_0x019b;
                    case 30: goto L_0x019b;
                    case 31: goto L_0x019b;
                    case 32: goto L_0x019b;
                    case 33: goto L_0x019b;
                    case 34: goto L_0x019b;
                    case 35: goto L_0x019b;
                    case 36: goto L_0x019b;
                    case 37: goto L_0x019b;
                    case 38: goto L_0x019b;
                    case 39: goto L_0x019b;
                    case 40: goto L_0x019b;
                    case 41: goto L_0x019b;
                    case 42: goto L_0x019b;
                    case 43: goto L_0x019b;
                    case 44: goto L_0x019b;
                    case 45: goto L_0x019b;
                    case 46: goto L_0x019b;
                    case 47: goto L_0x019b;
                    case 48: goto L_0x019b;
                    case 49: goto L_0x019b;
                    case 50: goto L_0x01a9;
                    case 51: goto L_0x01b7;
                    case 52: goto L_0x01b7;
                    case 53: goto L_0x01b7;
                    case 54: goto L_0x01b7;
                    case 55: goto L_0x01b7;
                    case 56: goto L_0x01b7;
                    case 57: goto L_0x01b7;
                    case 58: goto L_0x01b7;
                    case 59: goto L_0x01b7;
                    case 60: goto L_0x01b7;
                    case 61: goto L_0x01b7;
                    case 62: goto L_0x01b7;
                    case 63: goto L_0x01b7;
                    case 64: goto L_0x01b7;
                    case 65: goto L_0x01b7;
                    case 66: goto L_0x01b7;
                    case 67: goto L_0x01b7;
                    case 68: goto L_0x01b7;
                    default: goto L_0x001a;
                };
            L_0x001a:
                r2 = r1;
            L_0x001b:
                if (r2 != 0) goto L_0x01db;
            L_0x001d:
                return r0;
            L_0x001e:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0038;
            L_0x0024:
                r8 = com.google.android.gms.internal.measurement.zzxj.zzo(r12, r6);
                r8 = java.lang.Double.doubleToLongBits(r8);
                r6 = com.google.android.gms.internal.measurement.zzxj.zzo(r13, r6);
                r6 = java.lang.Double.doubleToLongBits(r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x0038:
                r2 = r0;
                goto L_0x001b;
            L_0x003a:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0052;
            L_0x0040:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzn(r12, r6);
                r2 = java.lang.Float.floatToIntBits(r2);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzn(r13, r6);
                r5 = java.lang.Float.floatToIntBits(r5);
                if (r2 == r5) goto L_0x001a;
            L_0x0052:
                r2 = r0;
                goto L_0x001b;
            L_0x0054:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0066;
            L_0x005a:
                r8 = com.google.android.gms.internal.measurement.zzxj.zzl(r12, r6);
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x0066:
                r2 = r0;
                goto L_0x001b;
            L_0x0068:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x007a;
            L_0x006e:
                r8 = com.google.android.gms.internal.measurement.zzxj.zzl(r12, r6);
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x007a:
                r2 = r0;
                goto L_0x001b;
            L_0x007c:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x008c;
            L_0x0082:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x008c:
                r2 = r0;
                goto L_0x001b;
            L_0x008e:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00a0;
            L_0x0094:
                r8 = com.google.android.gms.internal.measurement.zzxj.zzl(r12, r6);
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x00a0:
                r2 = r0;
                goto L_0x001b;
            L_0x00a3:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00b3;
            L_0x00a9:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x00b3:
                r2 = r0;
                goto L_0x001b;
            L_0x00b6:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00c6;
            L_0x00bc:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzm(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzm(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x00c6:
                r2 = r0;
                goto L_0x001b;
            L_0x00c9:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00dd;
            L_0x00cf:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzp(r13, r6);
                r2 = com.google.android.gms.internal.measurement.zzwn.zze(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x00dd:
                r2 = r0;
                goto L_0x001b;
            L_0x00e0:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00f4;
            L_0x00e6:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzp(r13, r6);
                r2 = com.google.android.gms.internal.measurement.zzwn.zze(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x00f4:
                r2 = r0;
                goto L_0x001b;
            L_0x00f7:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x010b;
            L_0x00fd:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzp(r13, r6);
                r2 = com.google.android.gms.internal.measurement.zzwn.zze(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x010b:
                r2 = r0;
                goto L_0x001b;
            L_0x010e:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x011e;
            L_0x0114:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x011e:
                r2 = r0;
                goto L_0x001b;
            L_0x0121:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0131;
            L_0x0127:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x0131:
                r2 = r0;
                goto L_0x001b;
            L_0x0134:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0144;
            L_0x013a:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x0144:
                r2 = r0;
                goto L_0x001b;
            L_0x0147:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0159;
            L_0x014d:
                r8 = com.google.android.gms.internal.measurement.zzxj.zzl(r12, r6);
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x0159:
                r2 = r0;
                goto L_0x001b;
            L_0x015c:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x016c;
            L_0x0162:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x016c:
                r2 = r0;
                goto L_0x001b;
            L_0x016f:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0181;
            L_0x0175:
                r8 = com.google.android.gms.internal.measurement.zzxj.zzl(r12, r6);
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x0181:
                r2 = r0;
                goto L_0x001b;
            L_0x0184:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0198;
            L_0x018a:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzp(r13, r6);
                r2 = com.google.android.gms.internal.measurement.zzwn.zze(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x0198:
                r2 = r0;
                goto L_0x001b;
            L_0x019b:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzp(r13, r6);
                r2 = com.google.android.gms.internal.measurement.zzwn.zze(r2, r5);
                goto L_0x001b;
            L_0x01a9:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzp(r13, r6);
                r2 = com.google.android.gms.internal.measurement.zzwn.zze(r2, r5);
                goto L_0x001b;
            L_0x01b7:
                r2 = r11.zzbu(r3);
                r5 = r2 & r10;
                r8 = (long) r5;
                r5 = com.google.android.gms.internal.measurement.zzxj.zzk(r12, r8);
                r2 = r2 & r10;
                r8 = (long) r2;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r13, r8);
                if (r5 != r2) goto L_0x01d8;
            L_0x01ca:
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r12, r6);
                r5 = com.google.android.gms.internal.measurement.zzxj.zzp(r13, r6);
                r2 = com.google.android.gms.internal.measurement.zzwn.zze(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x01d8:
                r2 = r0;
                goto L_0x001b;
            L_0x01db:
                r2 = r3 + 3;
                r3 = r2;
                goto L_0x0009;
            L_0x01e0:
                r2 = r11.zzcbe;
                r2 = r2.zzal(r12);
                r3 = r11.zzcbe;
                r3 = r3.zzal(r13);
                r2 = r2.equals(r3);
                if (r2 == 0) goto L_0x001d;
            L_0x01f2:
                r0 = r11.zzcav;
                if (r0 == 0) goto L_0x0208;
            L_0x01f6:
                r0 = r11.zzcbf;
                r0 = r0.zzw(r12);
                r1 = r11.zzcbf;
                r1 = r1.zzw(r13);
                r0 = r0.equals(r1);
                goto L_0x001d;
            L_0x0208:
                r0 = r1;
                goto L_0x001d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvz.equals(java.lang.Object, java.lang.Object):boolean");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final int hashCode(T r10) {
                /*
                r9 = this;
                r1 = 37;
                r0 = 0;
                r2 = r9.zzcaq;
                r4 = r2.length;
                r3 = r0;
                r2 = r0;
            L_0x0008:
                if (r3 >= r4) goto L_0x0254;
            L_0x000a:
                r0 = r9.zzbt(r3);
                r5 = r9.zzcaq;
                r5 = r5[r3];
                r6 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
                r6 = r6 & r0;
                r6 = (long) r6;
                r8 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
                r0 = r0 & r8;
                r0 = r0 >>> 20;
                switch(r0) {
                    case 0: goto L_0x0024;
                    case 1: goto L_0x0034;
                    case 2: goto L_0x0040;
                    case 3: goto L_0x004c;
                    case 4: goto L_0x0058;
                    case 5: goto L_0x0060;
                    case 6: goto L_0x006c;
                    case 7: goto L_0x0074;
                    case 8: goto L_0x0080;
                    case 9: goto L_0x008e;
                    case 10: goto L_0x009c;
                    case 11: goto L_0x00a9;
                    case 12: goto L_0x00b2;
                    case 13: goto L_0x00bb;
                    case 14: goto L_0x00c4;
                    case 15: goto L_0x00d1;
                    case 16: goto L_0x00da;
                    case 17: goto L_0x00e7;
                    case 18: goto L_0x00f6;
                    case 19: goto L_0x00f6;
                    case 20: goto L_0x00f6;
                    case 21: goto L_0x00f6;
                    case 22: goto L_0x00f6;
                    case 23: goto L_0x00f6;
                    case 24: goto L_0x00f6;
                    case 25: goto L_0x00f6;
                    case 26: goto L_0x00f6;
                    case 27: goto L_0x00f6;
                    case 28: goto L_0x00f6;
                    case 29: goto L_0x00f6;
                    case 30: goto L_0x00f6;
                    case 31: goto L_0x00f6;
                    case 32: goto L_0x00f6;
                    case 33: goto L_0x00f6;
                    case 34: goto L_0x00f6;
                    case 35: goto L_0x00f6;
                    case 36: goto L_0x00f6;
                    case 37: goto L_0x00f6;
                    case 38: goto L_0x00f6;
                    case 39: goto L_0x00f6;
                    case 40: goto L_0x00f6;
                    case 41: goto L_0x00f6;
                    case 42: goto L_0x00f6;
                    case 43: goto L_0x00f6;
                    case 44: goto L_0x00f6;
                    case 45: goto L_0x00f6;
                    case 46: goto L_0x00f6;
                    case 47: goto L_0x00f6;
                    case 48: goto L_0x00f6;
                    case 49: goto L_0x00f6;
                    case 50: goto L_0x0103;
                    case 51: goto L_0x0110;
                    case 52: goto L_0x0127;
                    case 53: goto L_0x013a;
                    case 54: goto L_0x014d;
                    case 55: goto L_0x0160;
                    case 56: goto L_0x016f;
                    case 57: goto L_0x0182;
                    case 58: goto L_0x0191;
                    case 59: goto L_0x01a4;
                    case 60: goto L_0x01b9;
                    case 61: goto L_0x01cc;
                    case 62: goto L_0x01df;
                    case 63: goto L_0x01ee;
                    case 64: goto L_0x01fd;
                    case 65: goto L_0x020c;
                    case 66: goto L_0x021f;
                    case 67: goto L_0x022e;
                    case 68: goto L_0x0241;
                    default: goto L_0x001f;
                };
            L_0x001f:
                r0 = r2;
            L_0x0020:
                r3 = r3 + 3;
                r2 = r0;
                goto L_0x0008;
            L_0x0024:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.measurement.zzxj.zzo(r10, r6);
                r6 = java.lang.Double.doubleToLongBits(r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0034:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzn(r10, r6);
                r2 = java.lang.Float.floatToIntBits(r2);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0040:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x004c:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0058:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0060:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x006c:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0074:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzm(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzu(r2);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0080:
                r2 = r2 * 53;
                r0 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                r0 = (java.lang.String) r0;
                r0 = r0.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x008e:
                r0 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                if (r0 == 0) goto L_0x0276;
            L_0x0094:
                r0 = r0.hashCode();
            L_0x0098:
                r2 = r2 * 53;
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x009c:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                r2 = r2.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00a9:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00b2:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00bb:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00c4:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00d1:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00da:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.measurement.zzxj.zzl(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00e7:
                r0 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                if (r0 == 0) goto L_0x0273;
            L_0x00ed:
                r0 = r0.hashCode();
            L_0x00f1:
                r2 = r2 * 53;
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00f6:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                r2 = r2.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0103:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                r2 = r2.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0110:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0116:
                r0 = r2 * 53;
                r6 = zzf(r10, r6);
                r6 = java.lang.Double.doubleToLongBits(r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0127:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x012d:
                r0 = r2 * 53;
                r2 = zzg(r10, r6);
                r2 = java.lang.Float.floatToIntBits(r2);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x013a:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0140:
                r0 = r2 * 53;
                r6 = zzi(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x014d:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0153:
                r0 = r2 * 53;
                r6 = zzi(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0160:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0166:
                r0 = r2 * 53;
                r2 = zzh(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x016f:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0175:
                r0 = r2 * 53;
                r6 = zzi(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0182:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0188:
                r0 = r2 * 53;
                r2 = zzh(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0191:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0197:
                r0 = r2 * 53;
                r2 = zzj(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzu(r2);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01a4:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x01aa:
                r2 = r2 * 53;
                r0 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                r0 = (java.lang.String) r0;
                r0 = r0.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01b9:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x01bf:
                r0 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                r2 = r2 * 53;
                r0 = r0.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01cc:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x01d2:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                r2 = r2.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01df:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x01e5:
                r0 = r2 * 53;
                r2 = zzh(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01ee:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x01f4:
                r0 = r2 * 53;
                r2 = zzh(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01fd:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0203:
                r0 = r2 * 53;
                r2 = zzh(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x020c:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0212:
                r0 = r2 * 53;
                r6 = zzi(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x021f:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0225:
                r0 = r2 * 53;
                r2 = zzh(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x022e:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0234:
                r0 = r2 * 53;
                r6 = zzi(r10, r6);
                r2 = com.google.android.gms.internal.measurement.zzuq.zzbd(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0241:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0247:
                r0 = com.google.android.gms.internal.measurement.zzxj.zzp(r10, r6);
                r2 = r2 * 53;
                r0 = r0.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0254:
                r0 = r2 * 53;
                r1 = r9.zzcbe;
                r1 = r1.zzal(r10);
                r1 = r1.hashCode();
                r0 = r0 + r1;
                r1 = r9.zzcav;
                if (r1 == 0) goto L_0x0272;
            L_0x0265:
                r0 = r0 * 53;
                r1 = r9.zzcbf;
                r1 = r1.zzw(r10);
                r1 = r1.hashCode();
                r0 = r0 + r1;
            L_0x0272:
                return r0;
            L_0x0273:
                r0 = r1;
                goto L_0x00f1;
            L_0x0276:
                r0 = r1;
                goto L_0x0098;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvz.hashCode(java.lang.Object):int");
            }

            public final void zzd(T t, T t2) {
                if (t2 == null) {
                    throw new NullPointerException();
                }
                for (int i = 0; i < this.zzcaq.length; i += 3) {
                    int zzbt = zzbt(i);
                    long j = (long) (1048575 & zzbt);
                    int i2 = this.zzcaq[i];
                    switch ((zzbt & 267386880) >>> 20) {
                        case 0:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzo(t2, j));
                            zzc(t, i);
                            break;
                        case 1:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzn(t2, j));
                            zzc(t, i);
                            break;
                        case 2:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        case 3:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        case 4:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zzb((Object) t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        case 5:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        case 6:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zzb((Object) t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        case 7:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzm(t2, j));
                            zzc(t, i);
                            break;
                        case 8:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzp(t2, j));
                            zzc(t, i);
                            break;
                        case 9:
                            zza((Object) t, (Object) t2, i);
                            break;
                        case 10:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzp(t2, j));
                            zzc(t, i);
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zzb((Object) t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        case 12:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zzb((Object) t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        case 13:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zzb((Object) t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        case 14:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        case 15:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zzb((Object) t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        case 16:
                            if (!zzb((Object) t2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        case 17:
                            zza((Object) t, (Object) t2, i);
                            break;
                        case 18:
                        case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case HTTP.SP /*32*/:
                        case Encoder.DEFAULT_EC_PERCENT /*33*/:
                        case 34:
                        case 35:
                        case 36:
                        case LangUtils.HASH_OFFSET /*37*/:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            this.zzcbd.zza(t, t2, j);
                            break;
                        case 50:
                            zzwn.zza(this.zzcbg, (Object) t, (Object) t2, j);
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                            if (!zza((Object) t2, i2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzp(t2, j));
                            zzb((Object) t, i2, i);
                            break;
                        case 60:
                            zzb((Object) t, (Object) t2, i);
                            break;
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                            if (!zza((Object) t2, i2, i)) {
                                break;
                            }
                            zzxj.zza((Object) t, j, zzxj.zzp(t2, j));
                            zzb((Object) t, i2, i);
                            break;
                        case 68:
                            zzb((Object) t, (Object) t2, i);
                            break;
                        default:
                            break;
                    }
                }
                if (!this.zzcax) {
                    zzwn.zza(this.zzcbe, (Object) t, (Object) t2);
                    if (this.zzcav) {
                        zzwn.zza(this.zzcbf, (Object) t, (Object) t2);
                    }
                }
            }

            private final void zza(T t, T t2, int i) {
                long zzbt = (long) (zzbt(i) & 1048575);
                if (zzb((Object) t2, i)) {
                    Object zzp = zzxj.zzp(t, zzbt);
                    Object zzp2 = zzxj.zzp(t2, zzbt);
                    if (zzp != null && zzp2 != null) {
                        zzxj.zza((Object) t, zzbt, zzuq.zzb(zzp, zzp2));
                        zzc(t, i);
                    } else if (zzp2 != null) {
                        zzxj.zza((Object) t, zzbt, zzp2);
                        zzc(t, i);
                    }
                }
            }

            private final void zzb(T t, T t2, int i) {
                int zzbt = zzbt(i);
                int i2 = this.zzcaq[i];
                long j = (long) (zzbt & 1048575);
                if (zza((Object) t2, i2, i)) {
                    Object zzp = zzxj.zzp(t, j);
                    Object zzp2 = zzxj.zzp(t2, j);
                    if (zzp != null && zzp2 != null) {
                        zzxj.zza((Object) t, j, zzuq.zzb(zzp, zzp2));
                        zzb((Object) t, i2, i);
                    } else if (zzp2 != null) {
                        zzxj.zza((Object) t, j, zzp2);
                        zzb((Object) t, i2, i);
                    }
                }
            }

            public final int zzai(T t) {
                int i;
                int i2;
                int zzbt;
                int i3;
                int i4;
                int i5;
                Object zzp;
                if (this.zzcax) {
                    Unsafe unsafe = zzcap;
                    i = 0;
                    for (i2 = 0; i2 < this.zzcaq.length; i2 += 3) {
                        zzbt = zzbt(i2);
                        i3 = (267386880 & zzbt) >>> 20;
                        i4 = this.zzcaq[i2];
                        long j = (long) (zzbt & 1048575);
                        if (i3 < zzui.DOUBLE_LIST_PACKED.id() || i3 > zzui.SINT64_LIST_PACKED.id()) {
                            i5 = 0;
                        } else {
                            i5 = this.zzcaq[i2 + 2] & 1048575;
                        }
                        switch (i3) {
                            case 0:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzb(i4, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                break;
                            case 1:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzb(i4, 0.0f);
                                break;
                            case 2:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzd(i4, zzxj.zzl(t, j));
                                break;
                            case 3:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zze(i4, zzxj.zzl(t, j));
                                break;
                            case 4:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzh(i4, zzxj.zzk(t, j));
                                break;
                            case 5:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzg(i4, 0);
                                break;
                            case 6:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzk(i4, 0);
                                break;
                            case 7:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzc(i4, true);
                                break;
                            case 8:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                zzp = zzxj.zzp(t, j);
                                if (!(zzp instanceof zzte)) {
                                    i += zztv.zzc(i4, (String) zzp);
                                    break;
                                }
                                i += zztv.zzc(i4, (zzte) zzp);
                                break;
                            case 9:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zzwn.zzc(i4, zzxj.zzp(t, j), zzbq(i2));
                                break;
                            case 10:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzc(i4, (zzte) zzxj.zzp(t, j));
                                break;
                            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzi(i4, zzxj.zzk(t, j));
                                break;
                            case 12:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzm(i4, zzxj.zzk(t, j));
                                break;
                            case 13:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzl(i4, 0);
                                break;
                            case 14:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzh(i4, 0);
                                break;
                            case 15:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzj(i4, zzxj.zzk(t, j));
                                break;
                            case 16:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzf(i4, zzxj.zzl(t, j));
                                break;
                            case 17:
                                if (!zzb((Object) t, i2)) {
                                    break;
                                }
                                i += zztv.zzc(i4, (zzvv) zzxj.zzp(t, j), zzbq(i2));
                                break;
                            case 18:
                                i += zzwn.zzw(i4, zze(t, j), false);
                                break;
                            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                                i += zzwn.zzv(i4, zze(t, j), false);
                                break;
                            case 20:
                                i += zzwn.zzo(i4, zze(t, j), false);
                                break;
                            case 21:
                                i += zzwn.zzp(i4, zze(t, j), false);
                                break;
                            case 22:
                                i += zzwn.zzs(i4, zze(t, j), false);
                                break;
                            case 23:
                                i += zzwn.zzw(i4, zze(t, j), false);
                                break;
                            case 24:
                                i += zzwn.zzv(i4, zze(t, j), false);
                                break;
                            case 25:
                                i += zzwn.zzx(i4, zze(t, j), false);
                                break;
                            case 26:
                                i += zzwn.zzc(i4, zze(t, j));
                                break;
                            case 27:
                                i += zzwn.zzc(i4, zze(t, j), zzbq(i2));
                                break;
                            case 28:
                                i += zzwn.zzd(i4, zze(t, j));
                                break;
                            case 29:
                                i += zzwn.zzt(i4, zze(t, j), false);
                                break;
                            case 30:
                                i += zzwn.zzr(i4, zze(t, j), false);
                                break;
                            case 31:
                                i += zzwn.zzv(i4, zze(t, j), false);
                                break;
                            case HTTP.SP /*32*/:
                                i += zzwn.zzw(i4, zze(t, j), false);
                                break;
                            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                                i += zzwn.zzu(i4, zze(t, j), false);
                                break;
                            case 34:
                                i += zzwn.zzq(i4, zze(t, j), false);
                                break;
                            case 35:
                                zzbt = zzwn.zzag((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 36:
                                zzbt = zzwn.zzaf((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case LangUtils.HASH_OFFSET /*37*/:
                                zzbt = zzwn.zzy((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 38:
                                zzbt = zzwn.zzz((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 39:
                                zzbt = zzwn.zzac((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 40:
                                zzbt = zzwn.zzag((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 41:
                                zzbt = zzwn.zzaf((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 42:
                                zzbt = zzwn.zzah((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 43:
                                zzbt = zzwn.zzad((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 44:
                                zzbt = zzwn.zzab((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 45:
                                zzbt = zzwn.zzaf((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 46:
                                zzbt = zzwn.zzag((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 47:
                                zzbt = zzwn.zzae((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 48:
                                zzbt = zzwn.zzaa((List) unsafe.getObject(t, j));
                                if (zzbt > 0) {
                                    if (this.zzcay) {
                                        unsafe.putInt(t, (long) i5, zzbt);
                                    }
                                    i += zzbt + (zztv.zzbd(i4) + zztv.zzbf(zzbt));
                                    break;
                                }
                                break;
                            case 49:
                                i += zzwn.zzd(i4, zze(t, j), zzbq(i2));
                                break;
                            case 50:
                                i += this.zzcbg.zzb(i4, zzxj.zzp(t, j), zzbr(i2));
                                break;
                            case 51:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzb(i4, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                break;
                            case 52:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzb(i4, 0.0f);
                                break;
                            case 53:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzd(i4, zzi(t, j));
                                break;
                            case 54:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zze(i4, zzi(t, j));
                                break;
                            case 55:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzh(i4, zzh(t, j));
                                break;
                            case 56:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzg(i4, 0);
                                break;
                            case 57:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzk(i4, 0);
                                break;
                            case 58:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzc(i4, true);
                                break;
                            case 59:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                zzp = zzxj.zzp(t, j);
                                if (!(zzp instanceof zzte)) {
                                    i += zztv.zzc(i4, (String) zzp);
                                    break;
                                }
                                i += zztv.zzc(i4, (zzte) zzp);
                                break;
                            case 60:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzwn.zzc(i4, zzxj.zzp(t, j), zzbq(i2));
                                break;
                            case 61:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzc(i4, (zzte) zzxj.zzp(t, j));
                                break;
                            case 62:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzi(i4, zzh(t, j));
                                break;
                            case 63:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzm(i4, zzh(t, j));
                                break;
                            case 64:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzl(i4, 0);
                                break;
                            case 65:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzh(i4, 0);
                                break;
                            case 66:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzj(i4, zzh(t, j));
                                break;
                            case 67:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzf(i4, zzi(t, j));
                                break;
                            case 68:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zztv.zzc(i4, (zzvv) zzxj.zzp(t, j), zzbq(i2));
                                break;
                            default:
                                break;
                        }
                    }
                    return zza(this.zzcbe, (Object) t) + i;
                }
                int i6 = 0;
                Unsafe unsafe2 = zzcap;
                i5 = -1;
                i = 0;
                for (i2 = 0; i2 < this.zzcaq.length; i2 += 3) {
                    int zzbt2 = zzbt(i2);
                    int i7 = this.zzcaq[i2];
                    int i8 = (267386880 & zzbt2) >>> 20;
                    zzbt = 0;
                    if (i8 <= 17) {
                        i4 = this.zzcaq[i2 + 2];
                        zzbt = 1048575 & i4;
                        i3 = 1 << (i4 >>> 20);
                        if (zzbt != i5) {
                            i = unsafe2.getInt(t, (long) zzbt);
                            i5 = zzbt;
                        }
                        zzbt = i3;
                    } else if (!this.zzcay || i8 < zzui.DOUBLE_LIST_PACKED.id() || i8 > zzui.SINT64_LIST_PACKED.id()) {
                        i4 = 0;
                    } else {
                        i4 = this.zzcaq[i2 + 2] & 1048575;
                    }
                    long j2 = (long) (1048575 & zzbt2);
                    switch (i8) {
                        case 0:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzb(i7, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        case 1:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzb(i7, 0.0f);
                            break;
                        case 2:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzd(i7, unsafe2.getLong(t, j2));
                            break;
                        case 3:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zze(i7, unsafe2.getLong(t, j2));
                            break;
                        case 4:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzh(i7, unsafe2.getInt(t, j2));
                            break;
                        case 5:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzg(i7, 0);
                            break;
                        case 6:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzk(i7, 0);
                            break;
                        case 7:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzc(i7, true);
                            break;
                        case 8:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            zzp = unsafe2.getObject(t, j2);
                            if (!(zzp instanceof zzte)) {
                                i6 += zztv.zzc(i7, (String) zzp);
                                break;
                            }
                            i6 += zztv.zzc(i7, (zzte) zzp);
                            break;
                        case 9:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zzwn.zzc(i7, unsafe2.getObject(t, j2), zzbq(i2));
                            break;
                        case 10:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzc(i7, (zzte) unsafe2.getObject(t, j2));
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzi(i7, unsafe2.getInt(t, j2));
                            break;
                        case 12:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzm(i7, unsafe2.getInt(t, j2));
                            break;
                        case 13:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzl(i7, 0);
                            break;
                        case 14:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzh(i7, 0);
                            break;
                        case 15:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzj(i7, unsafe2.getInt(t, j2));
                            break;
                        case 16:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzf(i7, unsafe2.getLong(t, j2));
                            break;
                        case 17:
                            if ((zzbt & i) == 0) {
                                break;
                            }
                            i6 += zztv.zzc(i7, (zzvv) unsafe2.getObject(t, j2), zzbq(i2));
                            break;
                        case 18:
                            i6 += zzwn.zzw(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                            i6 += zzwn.zzv(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 20:
                            i6 += zzwn.zzo(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 21:
                            i6 += zzwn.zzp(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 22:
                            i6 += zzwn.zzs(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 23:
                            i6 += zzwn.zzw(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 24:
                            i6 += zzwn.zzv(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 25:
                            i6 += zzwn.zzx(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 26:
                            i6 += zzwn.zzc(i7, (List) unsafe2.getObject(t, j2));
                            break;
                        case 27:
                            i6 += zzwn.zzc(i7, (List) unsafe2.getObject(t, j2), zzbq(i2));
                            break;
                        case 28:
                            i6 += zzwn.zzd(i7, (List) unsafe2.getObject(t, j2));
                            break;
                        case 29:
                            i6 += zzwn.zzt(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 30:
                            i6 += zzwn.zzr(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 31:
                            i6 += zzwn.zzv(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case HTTP.SP /*32*/:
                            i6 += zzwn.zzw(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case Encoder.DEFAULT_EC_PERCENT /*33*/:
                            i6 += zzwn.zzu(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 34:
                            i6 += zzwn.zzq(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 35:
                            zzbt = zzwn.zzag((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 36:
                            zzbt = zzwn.zzaf((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case LangUtils.HASH_OFFSET /*37*/:
                            zzbt = zzwn.zzy((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 38:
                            zzbt = zzwn.zzz((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 39:
                            zzbt = zzwn.zzac((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 40:
                            zzbt = zzwn.zzag((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 41:
                            zzbt = zzwn.zzaf((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 42:
                            zzbt = zzwn.zzah((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 43:
                            zzbt = zzwn.zzad((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 44:
                            zzbt = zzwn.zzab((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 45:
                            zzbt = zzwn.zzaf((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 46:
                            zzbt = zzwn.zzag((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 47:
                            zzbt = zzwn.zzae((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 48:
                            zzbt = zzwn.zzaa((List) unsafe2.getObject(t, j2));
                            if (zzbt > 0) {
                                if (this.zzcay) {
                                    unsafe2.putInt(t, (long) i4, zzbt);
                                }
                                i6 += zzbt + (zztv.zzbd(i7) + zztv.zzbf(zzbt));
                                break;
                            }
                            break;
                        case 49:
                            i6 += zzwn.zzd(i7, (List) unsafe2.getObject(t, j2), zzbq(i2));
                            break;
                        case 50:
                            i6 += this.zzcbg.zzb(i7, unsafe2.getObject(t, j2), zzbr(i2));
                            break;
                        case 51:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzb(i7, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        case 52:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzb(i7, 0.0f);
                            break;
                        case 53:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzd(i7, zzi(t, j2));
                            break;
                        case 54:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zze(i7, zzi(t, j2));
                            break;
                        case 55:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzh(i7, zzh(t, j2));
                            break;
                        case 56:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzg(i7, 0);
                            break;
                        case 57:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzk(i7, 0);
                            break;
                        case 58:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzc(i7, true);
                            break;
                        case 59:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            zzp = unsafe2.getObject(t, j2);
                            if (!(zzp instanceof zzte)) {
                                i6 += zztv.zzc(i7, (String) zzp);
                                break;
                            }
                            i6 += zztv.zzc(i7, (zzte) zzp);
                            break;
                        case 60:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzwn.zzc(i7, unsafe2.getObject(t, j2), zzbq(i2));
                            break;
                        case 61:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzc(i7, (zzte) unsafe2.getObject(t, j2));
                            break;
                        case 62:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzi(i7, zzh(t, j2));
                            break;
                        case 63:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzm(i7, zzh(t, j2));
                            break;
                        case 64:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzl(i7, 0);
                            break;
                        case 65:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzh(i7, 0);
                            break;
                        case 66:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzj(i7, zzh(t, j2));
                            break;
                        case 67:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzf(i7, zzi(t, j2));
                            break;
                        case 68:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zztv.zzc(i7, (zzvv) unsafe2.getObject(t, j2), zzbq(i2));
                            break;
                        default:
                            break;
                    }
                }
                zzbt = zza(this.zzcbe, (Object) t) + i6;
                if (this.zzcav) {
                    return zzbt + this.zzcbf.zzw(t).zzvx();
                }
                return zzbt;
            }

            private static <UT, UB> int zza(zzxd<UT, UB> zzxd, T t) {
                return zzxd.zzai(zzxd.zzal(t));
            }

            private static <E> List<E> zze(Object obj, long j) {
                return (List) zzxj.zzp(obj, j);
            }

            public final void zza(T t, zzxy zzxy) {
                Iterator it;
                Entry entry;
                zzuf zzw;
                int length;
                int zzbt;
                int i;
                Entry entry2;
                if (zzxy.zzvm() == zze.zzbyw) {
                    zza(this.zzcbe, (Object) t, zzxy);
                    it = null;
                    entry = null;
                    if (this.zzcav) {
                        zzw = this.zzcbf.zzw(t);
                        if (!zzw.isEmpty()) {
                            it = zzw.descendingIterator();
                            entry = (Entry) it.next();
                        }
                    }
                    length = this.zzcaq.length - 3;
                    while (length >= 0) {
                        zzbt = zzbt(length);
                        i = this.zzcaq[length];
                        entry2 = entry;
                        while (entry2 != null && this.zzcbf.zzb(entry2) > i) {
                            this.zzcbf.zza(zzxy, entry2);
                            entry2 = it.hasNext() ? (Entry) it.next() : null;
                        }
                        switch ((267386880 & zzbt) >>> 20) {
                            case 0:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i, zzxj.zzo(t, (long) (1048575 & zzbt)));
                                break;
                            case 1:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i, zzxj.zzn(t, (long) (1048575 & zzbt)));
                                break;
                            case 2:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzi(i, zzxj.zzl(t, (long) (1048575 & zzbt)));
                                break;
                            case 3:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i, zzxj.zzl(t, (long) (1048575 & zzbt)));
                                break;
                            case 4:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzd(i, zzxj.zzk(t, (long) (1048575 & zzbt)));
                                break;
                            case 5:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzc(i, zzxj.zzl(t, (long) (1048575 & zzbt)));
                                break;
                            case 6:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzg(i, zzxj.zzk(t, (long) (1048575 & zzbt)));
                                break;
                            case 7:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzb(i, zzxj.zzm(t, (long) (1048575 & zzbt)));
                                break;
                            case 8:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zza(i, zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy);
                                break;
                            case 9:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i, zzxj.zzp(t, (long) (1048575 & zzbt)), zzbq(length));
                                break;
                            case 10:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i, (zzte) zzxj.zzp(t, (long) (1048575 & zzbt)));
                                break;
                            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zze(i, zzxj.zzk(t, (long) (1048575 & zzbt)));
                                break;
                            case 12:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzo(i, zzxj.zzk(t, (long) (1048575 & zzbt)));
                                break;
                            case 13:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzn(i, zzxj.zzk(t, (long) (1048575 & zzbt)));
                                break;
                            case 14:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzj(i, zzxj.zzl(t, (long) (1048575 & zzbt)));
                                break;
                            case 15:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzf(i, zzxj.zzk(t, (long) (1048575 & zzbt)));
                                break;
                            case 16:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzb(i, zzxj.zzl(t, (long) (1048575 & zzbt)));
                                break;
                            case 17:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzb(i, zzxj.zzp(t, (long) (1048575 & zzbt)), zzbq(length));
                                break;
                            case 18:
                                zzwn.zza(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                                zzwn.zzb(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 20:
                                zzwn.zzc(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 21:
                                zzwn.zzd(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 22:
                                zzwn.zzh(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 23:
                                zzwn.zzf(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 24:
                                zzwn.zzk(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 25:
                                zzwn.zzn(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 26:
                                zzwn.zza(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy);
                                break;
                            case 27:
                                zzwn.zza(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, zzbq(length));
                                break;
                            case 28:
                                zzwn.zzb(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy);
                                break;
                            case 29:
                                zzwn.zzi(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 30:
                                zzwn.zzm(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 31:
                                zzwn.zzl(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case HTTP.SP /*32*/:
                                zzwn.zzg(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                                zzwn.zzj(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 34:
                                zzwn.zze(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, false);
                                break;
                            case 35:
                                zzwn.zza(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 36:
                                zzwn.zzb(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case LangUtils.HASH_OFFSET /*37*/:
                                zzwn.zzc(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 38:
                                zzwn.zzd(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 39:
                                zzwn.zzh(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 40:
                                zzwn.zzf(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 41:
                                zzwn.zzk(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 42:
                                zzwn.zzn(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 43:
                                zzwn.zzi(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 44:
                                zzwn.zzm(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 45:
                                zzwn.zzl(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 46:
                                zzwn.zzg(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 47:
                                zzwn.zzj(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 48:
                                zzwn.zze(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, true);
                                break;
                            case 49:
                                zzwn.zzb(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy, zzbq(length));
                                break;
                            case 50:
                                zza(zzxy, i, zzxj.zzp(t, (long) (1048575 & zzbt)), length);
                                break;
                            case 51:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zza(i, zzf(t, (long) (1048575 & zzbt)));
                                break;
                            case 52:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zza(i, zzg(t, (long) (1048575 & zzbt)));
                                break;
                            case 53:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzi(i, zzi(t, (long) (1048575 & zzbt)));
                                break;
                            case 54:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zza(i, zzi(t, (long) (1048575 & zzbt)));
                                break;
                            case 55:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzd(i, zzh(t, (long) (1048575 & zzbt)));
                                break;
                            case 56:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzc(i, zzi(t, (long) (1048575 & zzbt)));
                                break;
                            case 57:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzg(i, zzh(t, (long) (1048575 & zzbt)));
                                break;
                            case 58:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzb(i, zzj(t, (long) (1048575 & zzbt)));
                                break;
                            case 59:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zza(i, zzxj.zzp(t, (long) (1048575 & zzbt)), zzxy);
                                break;
                            case 60:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zza(i, zzxj.zzp(t, (long) (1048575 & zzbt)), zzbq(length));
                                break;
                            case 61:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zza(i, (zzte) zzxj.zzp(t, (long) (1048575 & zzbt)));
                                break;
                            case 62:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zze(i, zzh(t, (long) (1048575 & zzbt)));
                                break;
                            case 63:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzo(i, zzh(t, (long) (1048575 & zzbt)));
                                break;
                            case 64:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzn(i, zzh(t, (long) (1048575 & zzbt)));
                                break;
                            case 65:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzj(i, zzi(t, (long) (1048575 & zzbt)));
                                break;
                            case 66:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzf(i, zzh(t, (long) (1048575 & zzbt)));
                                break;
                            case 67:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzb(i, zzi(t, (long) (1048575 & zzbt)));
                                break;
                            case 68:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzxy.zzb(i, zzxj.zzp(t, (long) (1048575 & zzbt)), zzbq(length));
                                break;
                            default:
                                break;
                        }
                        length -= 3;
                        entry = entry2;
                    }
                    while (entry != null) {
                        this.zzcbf.zza(zzxy, entry);
                        entry = it.hasNext() ? (Entry) it.next() : null;
                    }
                } else if (this.zzcax) {
                    it = null;
                    entry = null;
                    if (this.zzcav) {
                        zzw = this.zzcbf.zzw(t);
                        if (!zzw.isEmpty()) {
                            it = zzw.iterator();
                            entry = (Entry) it.next();
                        }
                    }
                    zzbt = this.zzcaq.length;
                    length = 0;
                    while (length < zzbt) {
                        i = zzbt(length);
                        int i2 = this.zzcaq[length];
                        entry2 = entry;
                        while (entry2 != null && this.zzcbf.zzb(entry2) <= i2) {
                            this.zzcbf.zza(zzxy, entry2);
                            entry2 = it.hasNext() ? (Entry) it.next() : null;
                        }
                        switch ((267386880 & i) >>> 20) {
                            case 0:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i2, zzxj.zzo(t, (long) (1048575 & i)));
                                break;
                            case 1:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i2, zzxj.zzn(t, (long) (1048575 & i)));
                                break;
                            case 2:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzi(i2, zzxj.zzl(t, (long) (1048575 & i)));
                                break;
                            case 3:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i2, zzxj.zzl(t, (long) (1048575 & i)));
                                break;
                            case 4:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzd(i2, zzxj.zzk(t, (long) (1048575 & i)));
                                break;
                            case 5:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzc(i2, zzxj.zzl(t, (long) (1048575 & i)));
                                break;
                            case 6:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzg(i2, zzxj.zzk(t, (long) (1048575 & i)));
                                break;
                            case 7:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzb(i2, zzxj.zzm(t, (long) (1048575 & i)));
                                break;
                            case 8:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zza(i2, zzxj.zzp(t, (long) (1048575 & i)), zzxy);
                                break;
                            case 9:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i2, zzxj.zzp(t, (long) (1048575 & i)), zzbq(length));
                                break;
                            case 10:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zza(i2, (zzte) zzxj.zzp(t, (long) (1048575 & i)));
                                break;
                            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zze(i2, zzxj.zzk(t, (long) (1048575 & i)));
                                break;
                            case 12:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzo(i2, zzxj.zzk(t, (long) (1048575 & i)));
                                break;
                            case 13:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzn(i2, zzxj.zzk(t, (long) (1048575 & i)));
                                break;
                            case 14:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzj(i2, zzxj.zzl(t, (long) (1048575 & i)));
                                break;
                            case 15:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzf(i2, zzxj.zzk(t, (long) (1048575 & i)));
                                break;
                            case 16:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzb(i2, zzxj.zzl(t, (long) (1048575 & i)));
                                break;
                            case 17:
                                if (!zzb((Object) t, length)) {
                                    break;
                                }
                                zzxy.zzb(i2, zzxj.zzp(t, (long) (1048575 & i)), zzbq(length));
                                break;
                            case 18:
                                zzwn.zza(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                                zzwn.zzb(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 20:
                                zzwn.zzc(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 21:
                                zzwn.zzd(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 22:
                                zzwn.zzh(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 23:
                                zzwn.zzf(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 24:
                                zzwn.zzk(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 25:
                                zzwn.zzn(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 26:
                                zzwn.zza(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy);
                                break;
                            case 27:
                                zzwn.zza(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, zzbq(length));
                                break;
                            case 28:
                                zzwn.zzb(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy);
                                break;
                            case 29:
                                zzwn.zzi(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 30:
                                zzwn.zzm(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 31:
                                zzwn.zzl(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case HTTP.SP /*32*/:
                                zzwn.zzg(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                                zzwn.zzj(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 34:
                                zzwn.zze(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, false);
                                break;
                            case 35:
                                zzwn.zza(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 36:
                                zzwn.zzb(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case LangUtils.HASH_OFFSET /*37*/:
                                zzwn.zzc(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 38:
                                zzwn.zzd(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 39:
                                zzwn.zzh(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 40:
                                zzwn.zzf(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 41:
                                zzwn.zzk(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 42:
                                zzwn.zzn(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 43:
                                zzwn.zzi(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 44:
                                zzwn.zzm(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 45:
                                zzwn.zzl(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 46:
                                zzwn.zzg(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 47:
                                zzwn.zzj(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 48:
                                zzwn.zze(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, true);
                                break;
                            case 49:
                                zzwn.zzb(this.zzcaq[length], (List) zzxj.zzp(t, (long) (1048575 & i)), zzxy, zzbq(length));
                                break;
                            case 50:
                                zza(zzxy, i2, zzxj.zzp(t, (long) (1048575 & i)), length);
                                break;
                            case 51:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zza(i2, zzf(t, (long) (1048575 & i)));
                                break;
                            case 52:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zza(i2, zzg(t, (long) (1048575 & i)));
                                break;
                            case 53:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzi(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 54:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zza(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 55:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzd(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 56:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzc(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 57:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzg(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 58:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzb(i2, zzj(t, (long) (1048575 & i)));
                                break;
                            case 59:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zza(i2, zzxj.zzp(t, (long) (1048575 & i)), zzxy);
                                break;
                            case 60:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zza(i2, zzxj.zzp(t, (long) (1048575 & i)), zzbq(length));
                                break;
                            case 61:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zza(i2, (zzte) zzxj.zzp(t, (long) (1048575 & i)));
                                break;
                            case 62:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zze(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 63:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzo(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 64:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzn(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 65:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzj(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 66:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzf(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 67:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzb(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 68:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzxy.zzb(i2, zzxj.zzp(t, (long) (1048575 & i)), zzbq(length));
                                break;
                            default:
                                break;
                        }
                        length += 3;
                        entry = entry2;
                    }
                    while (entry != null) {
                        this.zzcbf.zza(zzxy, entry);
                        entry = it.hasNext() ? (Entry) it.next() : null;
                    }
                    zza(this.zzcbe, (Object) t, zzxy);
                } else {
                    zzb((Object) t, zzxy);
                }
            }

            private final void zzb(T t, zzxy zzxy) {
                Iterator it = null;
                Entry entry = null;
                if (this.zzcav) {
                    zzuf zzw = this.zzcbf.zzw(t);
                    if (!zzw.isEmpty()) {
                        it = zzw.iterator();
                        entry = (Entry) it.next();
                    }
                }
                int i = -1;
                int i2 = 0;
                int length = this.zzcaq.length;
                Unsafe unsafe = zzcap;
                int i3 = 0;
                Entry entry2 = entry;
                while (i3 < length) {
                    int i4;
                    int i5;
                    int zzbt = zzbt(i3);
                    int i6 = this.zzcaq[i3];
                    int i7 = (267386880 & zzbt) >>> 20;
                    if (this.zzcax || i7 > 17) {
                        i4 = 0;
                        i5 = i2;
                    } else {
                        int i8;
                        i4 = this.zzcaq[i3 + 2];
                        int i9 = i4 & 1048575;
                        if (i9 != i) {
                            i8 = unsafe.getInt(t, (long) i9);
                        } else {
                            i8 = i2;
                            i9 = i;
                        }
                        i4 = 1 << (i4 >>> 20);
                        i5 = i8;
                        i = i9;
                    }
                    while (entry2 != null && this.zzcbf.zzb(entry2) <= i6) {
                        this.zzcbf.zza(zzxy, entry2);
                        entry2 = it.hasNext() ? (Entry) it.next() : null;
                    }
                    long j = (long) (1048575 & zzbt);
                    switch (i7) {
                        case 0:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zza(i6, zzxj.zzo(t, j));
                            break;
                        case 1:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zza(i6, zzxj.zzn(t, j));
                            break;
                        case 2:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzi(i6, unsafe.getLong(t, j));
                            break;
                        case 3:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zza(i6, unsafe.getLong(t, j));
                            break;
                        case 4:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzd(i6, unsafe.getInt(t, j));
                            break;
                        case 5:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzc(i6, unsafe.getLong(t, j));
                            break;
                        case 6:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzg(i6, unsafe.getInt(t, j));
                            break;
                        case 7:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzb(i6, zzxj.zzm(t, j));
                            break;
                        case 8:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zza(i6, unsafe.getObject(t, j), zzxy);
                            break;
                        case 9:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zza(i6, unsafe.getObject(t, j), zzbq(i3));
                            break;
                        case 10:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zza(i6, (zzte) unsafe.getObject(t, j));
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zze(i6, unsafe.getInt(t, j));
                            break;
                        case 12:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzo(i6, unsafe.getInt(t, j));
                            break;
                        case 13:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzn(i6, unsafe.getInt(t, j));
                            break;
                        case 14:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzj(i6, unsafe.getLong(t, j));
                            break;
                        case 15:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzf(i6, unsafe.getInt(t, j));
                            break;
                        case 16:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzb(i6, unsafe.getLong(t, j));
                            break;
                        case 17:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzxy.zzb(i6, unsafe.getObject(t, j), zzbq(i3));
                            break;
                        case 18:
                            zzwn.zza(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                            zzwn.zzb(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 20:
                            zzwn.zzc(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 21:
                            zzwn.zzd(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 22:
                            zzwn.zzh(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 23:
                            zzwn.zzf(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 24:
                            zzwn.zzk(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 25:
                            zzwn.zzn(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 26:
                            zzwn.zza(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy);
                            break;
                        case 27:
                            zzwn.zza(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, zzbq(i3));
                            break;
                        case 28:
                            zzwn.zzb(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy);
                            break;
                        case 29:
                            zzwn.zzi(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 30:
                            zzwn.zzm(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 31:
                            zzwn.zzl(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case HTTP.SP /*32*/:
                            zzwn.zzg(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case Encoder.DEFAULT_EC_PERCENT /*33*/:
                            zzwn.zzj(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 34:
                            zzwn.zze(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, false);
                            break;
                        case 35:
                            zzwn.zza(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 36:
                            zzwn.zzb(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case LangUtils.HASH_OFFSET /*37*/:
                            zzwn.zzc(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 38:
                            zzwn.zzd(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 39:
                            zzwn.zzh(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 40:
                            zzwn.zzf(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 41:
                            zzwn.zzk(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 42:
                            zzwn.zzn(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 43:
                            zzwn.zzi(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 44:
                            zzwn.zzm(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 45:
                            zzwn.zzl(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 46:
                            zzwn.zzg(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 47:
                            zzwn.zzj(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 48:
                            zzwn.zze(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, true);
                            break;
                        case 49:
                            zzwn.zzb(this.zzcaq[i3], (List) unsafe.getObject(t, j), zzxy, zzbq(i3));
                            break;
                        case 50:
                            zza(zzxy, i6, unsafe.getObject(t, j), i3);
                            break;
                        case 51:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zza(i6, zzf(t, j));
                            break;
                        case 52:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zza(i6, zzg(t, j));
                            break;
                        case 53:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzi(i6, zzi(t, j));
                            break;
                        case 54:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zza(i6, zzi(t, j));
                            break;
                        case 55:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzd(i6, zzh(t, j));
                            break;
                        case 56:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzc(i6, zzi(t, j));
                            break;
                        case 57:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzg(i6, zzh(t, j));
                            break;
                        case 58:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzb(i6, zzj(t, j));
                            break;
                        case 59:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zza(i6, unsafe.getObject(t, j), zzxy);
                            break;
                        case 60:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zza(i6, unsafe.getObject(t, j), zzbq(i3));
                            break;
                        case 61:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zza(i6, (zzte) unsafe.getObject(t, j));
                            break;
                        case 62:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zze(i6, zzh(t, j));
                            break;
                        case 63:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzo(i6, zzh(t, j));
                            break;
                        case 64:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzn(i6, zzh(t, j));
                            break;
                        case 65:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzj(i6, zzi(t, j));
                            break;
                        case 66:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzf(i6, zzh(t, j));
                            break;
                        case 67:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzb(i6, zzi(t, j));
                            break;
                        case 68:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzxy.zzb(i6, unsafe.getObject(t, j), zzbq(i3));
                            break;
                        default:
                            break;
                    }
                    i3 += 3;
                    i2 = i5;
                }
                for (entry = entry2; entry != null; entry = it.hasNext() ? (Entry) it.next() : null) {
                    this.zzcbf.zza(zzxy, entry);
                }
                zza(this.zzcbe, (Object) t, zzxy);
            }

            private final <K, V> void zza(zzxy zzxy, int i, Object obj, int i2) {
                if (obj != null) {
                    zzxy.zza(i, this.zzcbg.zzah(zzbr(i2)), this.zzcbg.zzad(obj));
                }
            }

            private static <UT, UB> void zza(zzxd<UT, UB> zzxd, T t, zzxy zzxy) {
                zzxd.zza(zzxd.zzal(t), zzxy);
            }

            public final void zza(T t, zzwk zzwk, zzub zzub) {
                Throwable th;
                if (zzub == null) {
                    throw new NullPointerException();
                }
                zzxd zzxd = this.zzcbe;
                zzuc zzuc = this.zzcbf;
                Object obj = null;
                zzuf zzuf = null;
                while (true) {
                    int i;
                    int i2;
                    int length;
                    Object zzag;
                    int i3;
                    int zzvh = zzwk.zzvh();
                    if (zzvh < this.zzcas || zzvh > this.zzcat) {
                        i = -1;
                    } else {
                        i2 = 0;
                        length = (this.zzcaq.length / 3) - 1;
                        while (i2 <= length) {
                            int i4 = (length + i2) >>> 1;
                            i = i4 * 3;
                            int i5 = this.zzcaq[i];
                            if (zzvh != i5) {
                                if (zzvh < i5) {
                                    length = i4 - 1;
                                } else {
                                    i2 = i4 + 1;
                                }
                            }
                        }
                        i = -1;
                    }
                    Object zzp;
                    if (i >= 0) {
                        length = zzbt(i);
                        zzut zzbs;
                        List zza;
                        switch ((267386880 & length) >>> 20) {
                            case 0:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.readDouble());
                                zzc(t, i);
                                continue;
                            case 1:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.readFloat());
                                zzc(t, i);
                                continue;
                            case 2:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzul());
                                zzc(t, i);
                                continue;
                            case 3:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzuk());
                                zzc(t, i);
                                continue;
                            case 4:
                                zzxj.zzb((Object) t, (long) (length & 1048575), zzwk.zzum());
                                zzc(t, i);
                                continue;
                            case 5:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzun());
                                zzc(t, i);
                                continue;
                            case 6:
                                zzxj.zzb((Object) t, (long) (length & 1048575), zzwk.zzuo());
                                zzc(t, i);
                                continue;
                            case 7:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzup());
                                zzc(t, i);
                                continue;
                            case 8:
                                zza((Object) t, length, zzwk);
                                zzc(t, i);
                                continue;
                            case 9:
                                if (!zzb((Object) t, i)) {
                                    zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zza(zzbq(i), zzub));
                                    zzc(t, i);
                                    break;
                                }
                                zzxj.zza((Object) t, (long) (length & 1048575), zzuq.zzb(zzxj.zzp(t, (long) (1048575 & length)), zzwk.zza(zzbq(i), zzub)));
                                continue;
                            case 10:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzur());
                                zzc(t, i);
                                continue;
                            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                zzxj.zzb((Object) t, (long) (length & 1048575), zzwk.zzus());
                                zzc(t, i);
                                continue;
                            case 12:
                                i2 = zzwk.zzut();
                                zzbs = zzbs(i);
                                if (zzbs != null && !zzbs.zzb(i2)) {
                                    obj = zzwn.zza(zzvh, i2, obj, zzxd);
                                    break;
                                }
                                zzxj.zzb((Object) t, (long) (length & 1048575), i2);
                                zzc(t, i);
                                continue;
                                break;
                            case 13:
                                zzxj.zzb((Object) t, (long) (length & 1048575), zzwk.zzuu());
                                zzc(t, i);
                                continue;
                            case 14:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzuv());
                                zzc(t, i);
                                continue;
                            case 15:
                                zzxj.zzb((Object) t, (long) (length & 1048575), zzwk.zzuw());
                                zzc(t, i);
                                continue;
                            case 16:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzux());
                                zzc(t, i);
                                continue;
                            case 17:
                                if (!zzb((Object) t, i)) {
                                    zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzb(zzbq(i), zzub));
                                    zzc(t, i);
                                    break;
                                }
                                zzxj.zza((Object) t, (long) (length & 1048575), zzuq.zzb(zzxj.zzp(t, (long) (1048575 & length)), zzwk.zzb(zzbq(i), zzub)));
                                continue;
                            case 18:
                                zzwk.zzi(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                                zzwk.zzj(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 20:
                                zzwk.zzl(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 21:
                                zzwk.zzk(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 22:
                                zzwk.zzm(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 23:
                                zzwk.zzn(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 24:
                                zzwk.zzo(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 25:
                                zzwk.zzp(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 26:
                                if (!zzbv(length)) {
                                    zzwk.readStringList(this.zzcbd.zza(t, (long) (length & 1048575)));
                                    break;
                                } else {
                                    zzwk.zzq(this.zzcbd.zza(t, (long) (length & 1048575)));
                                    continue;
                                }
                            case 27:
                                zzwk.zza(this.zzcbd.zza(t, (long) (length & 1048575)), zzbq(i), zzub);
                                continue;
                            case 28:
                                zzwk.zzr(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 29:
                                zzwk.zzs(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 30:
                                zza = this.zzcbd.zza(t, (long) (length & 1048575));
                                zzwk.zzt(zza);
                                obj = zzwn.zza(zzvh, zza, zzbs(i), obj, zzxd);
                                continue;
                            case 31:
                                zzwk.zzu(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case HTTP.SP /*32*/:
                                zzwk.zzv(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                                zzwk.zzw(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 34:
                                zzwk.zzx(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 35:
                                zzwk.zzi(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 36:
                                zzwk.zzj(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case LangUtils.HASH_OFFSET /*37*/:
                                zzwk.zzl(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 38:
                                zzwk.zzk(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 39:
                                zzwk.zzm(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 40:
                                zzwk.zzn(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 41:
                                zzwk.zzo(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 42:
                                zzwk.zzp(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 43:
                                zzwk.zzs(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 44:
                                zza = this.zzcbd.zza(t, (long) (length & 1048575));
                                zzwk.zzt(zza);
                                obj = zzwn.zza(zzvh, zza, zzbs(i), obj, zzxd);
                                continue;
                            case 45:
                                zzwk.zzu(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 46:
                                zzwk.zzv(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 47:
                                zzwk.zzw(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 48:
                                zzwk.zzx(this.zzcbd.zza(t, (long) (length & 1048575)));
                                continue;
                            case 49:
                                long j = (long) (length & 1048575);
                                zzwk.zzb(this.zzcbd.zza(t, j), zzbq(i), zzub);
                                continue;
                            case 50:
                                Object zzbr = zzbr(i);
                                long zzbt = (long) (zzbt(i) & 1048575);
                                zzp = zzxj.zzp(t, zzbt);
                                if (zzp == null) {
                                    zzag = this.zzcbg.zzag(zzbr);
                                    zzxj.zza((Object) t, zzbt, zzag);
                                } else if (this.zzcbg.zzae(zzp)) {
                                    zzag = this.zzcbg.zzag(zzbr);
                                    this.zzcbg.zzc(zzag, zzp);
                                    zzxj.zza((Object) t, zzbt, zzag);
                                } else {
                                    zzag = zzp;
                                }
                                zzwk.zza(this.zzcbg.zzac(zzag), this.zzcbg.zzah(zzbr), zzub);
                                continue;
                            case 51:
                                zzxj.zza((Object) t, (long) (length & 1048575), Double.valueOf(zzwk.readDouble()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 52:
                                zzxj.zza((Object) t, (long) (length & 1048575), Float.valueOf(zzwk.readFloat()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 53:
                                zzxj.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzwk.zzul()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 54:
                                zzxj.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzwk.zzuk()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 55:
                                zzxj.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzwk.zzum()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 56:
                                zzxj.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzwk.zzun()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 57:
                                zzxj.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzwk.zzuo()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 58:
                                zzxj.zza((Object) t, (long) (length & 1048575), Boolean.valueOf(zzwk.zzup()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 59:
                                zza((Object) t, length, zzwk);
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 60:
                                if (zza((Object) t, zzvh, i)) {
                                    zzxj.zza((Object) t, (long) (length & 1048575), zzuq.zzb(zzxj.zzp(t, (long) (1048575 & length)), zzwk.zza(zzbq(i), zzub)));
                                } else {
                                    zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zza(zzbq(i), zzub));
                                    zzc(t, i);
                                }
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 61:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzur());
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 62:
                                zzxj.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzwk.zzus()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 63:
                                i2 = zzwk.zzut();
                                zzbs = zzbs(i);
                                if (zzbs != null && !zzbs.zzb(i2)) {
                                    obj = zzwn.zza(zzvh, i2, obj, zzxd);
                                    break;
                                }
                                zzxj.zza((Object) t, (long) (length & 1048575), Integer.valueOf(i2));
                                zzb((Object) t, zzvh, i);
                                continue;
                                break;
                            case 64:
                                zzxj.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzwk.zzuu()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 65:
                                zzxj.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzwk.zzuv()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 66:
                                zzxj.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzwk.zzuw()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 67:
                                zzxj.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzwk.zzux()));
                                zzb((Object) t, zzvh, i);
                                continue;
                            case 68:
                                zzxj.zza((Object) t, (long) (length & 1048575), zzwk.zzb(zzbq(i), zzub));
                                zzb((Object) t, zzvh, i);
                                continue;
                            default:
                                if (obj == null) {
                                    try {
                                        zzag = zzxd.zzyk();
                                    } catch (zzuw e) {
                                        break;
                                    }
                                }
                                zzag = obj;
                                try {
                                    if (zzxd.zza(zzag, zzwk)) {
                                        obj = zzag;
                                        continue;
                                    } else {
                                        for (i3 = this.zzcba; i3 < this.zzcbb; i3++) {
                                            zzag = zza((Object) t, this.zzcaz[i3], zzag, zzxd);
                                        }
                                        if (zzag != null) {
                                            zzxd.zzg(t, zzag);
                                            return;
                                        }
                                        return;
                                    }
                                } catch (zzuw e2) {
                                    obj = zzag;
                                    break;
                                }
                        }
                        try {
                            zzxd.zza(zzwk);
                            if (obj == null) {
                                zzag = zzxd.zzam(t);
                            } else {
                                zzag = obj;
                            }
                            if (zzxd.zza(zzag, zzwk)) {
                                obj = zzag;
                            } else {
                                for (i3 = this.zzcba; i3 < this.zzcbb; i3++) {
                                    zzag = zza((Object) t, this.zzcaz[i3], zzag, zzxd);
                                }
                                if (zzag != null) {
                                    zzxd.zzg(t, zzag);
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            zzag = obj;
                        }
                    } else if (zzvh == BaseClientBuilder.API_PRIORITY_OTHER) {
                        for (i3 = this.zzcba; i3 < this.zzcbb; i3++) {
                            obj = zza((Object) t, this.zzcaz[i3], obj, zzxd);
                        }
                        if (obj != null) {
                            zzxd.zzg(t, obj);
                            return;
                        }
                        return;
                    } else {
                        if (this.zzcav) {
                            zzp = zzuc.zza(zzub, this.zzcau, zzvh);
                        } else {
                            zzp = null;
                        }
                        if (zzp != null) {
                            if (zzuf == null) {
                                zzuf = zzuc.zzx(t);
                            }
                            obj = zzuc.zza(zzwk, zzp, zzub, zzuf, obj, zzxd);
                        } else {
                            zzxd.zza(zzwk);
                            if (obj == null) {
                                zzag = zzxd.zzam(t);
                            } else {
                                zzag = obj;
                            }
                            try {
                                if (zzxd.zza(zzag, zzwk)) {
                                    obj = zzag;
                                } else {
                                    for (i3 = this.zzcba; i3 < this.zzcbb; i3++) {
                                        zzag = zza((Object) t, this.zzcaz[i3], zzag, zzxd);
                                    }
                                    if (zzag != null) {
                                        zzxd.zzg(t, zzag);
                                        return;
                                    }
                                    return;
                                }
                            } catch (Throwable th22) {
                                th = th22;
                            }
                        }
                    }
                }
                for (i3 = this.zzcba; i3 < this.zzcbb; i3++) {
                    zzag = zza((Object) t, this.zzcaz[i3], zzag, zzxd);
                }
                if (zzag != null) {
                    zzxd.zzg(t, zzag);
                }
                throw th;
            }

            private final zzwl zzbq(int i) {
                int i2 = (i / 3) << 1;
                zzwl zzwl = (zzwl) this.zzcar[i2];
                if (zzwl != null) {
                    return zzwl;
                }
                zzwl = zzwh.zzxt().zzi((Class) this.zzcar[i2 + 1]);
                this.zzcar[i2] = zzwl;
                return zzwl;
            }

            private final Object zzbr(int i) {
                return this.zzcar[(i / 3) << 1];
            }

            private final zzut zzbs(int i) {
                return (zzut) this.zzcar[((i / 3) << 1) + 1];
            }

            public final void zzy(T t) {
                int i;
                for (i = this.zzcba; i < this.zzcbb; i++) {
                    long zzbt = (long) (zzbt(this.zzcaz[i]) & 1048575);
                    Object zzp = zzxj.zzp(t, zzbt);
                    if (zzp != null) {
                        zzxj.zza((Object) t, zzbt, this.zzcbg.zzaf(zzp));
                    }
                }
                int length = this.zzcaz.length;
                for (i = this.zzcbb; i < length; i++) {
                    this.zzcbd.zzb(t, (long) this.zzcaz[i]);
                }
                this.zzcbe.zzy(t);
                if (this.zzcav) {
                    this.zzcbf.zzy(t);
                }
            }

            private final <UT, UB> UB zza(Object obj, int i, UB ub, zzxd<UT, UB> zzxd) {
                int i2 = this.zzcaq[i];
                Object zzp = zzxj.zzp(obj, (long) (zzbt(i) & 1048575));
                if (zzp == null) {
                    return ub;
                }
                zzut zzbs = zzbs(i);
                if (zzbs == null) {
                    return ub;
                }
                return zza(i, i2, this.zzcbg.zzac(zzp), zzbs, ub, zzxd);
            }

            private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzut zzut, UB ub, zzxd<UT, UB> zzxd) {
                zzvo zzah = this.zzcbg.zzah(zzbr(i));
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!zzut.zzb(((Integer) entry.getValue()).intValue())) {
                        if (ub == null) {
                            ub = zzxd.zzyk();
                        }
                        zztm zzao = zzte.zzao(zzvn.zza(zzah, entry.getKey(), entry.getValue()));
                        try {
                            zzvn.zza(zzao.zzui(), zzah, entry.getKey(), entry.getValue());
                            zzxd.zza((Object) ub, i2, zzao.zzuh());
                            it.remove();
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                return ub;
            }

            public final boolean zzaj(T t) {
                int i = 0;
                int i2 = -1;
                for (int i3 = 0; i3 < this.zzcba; i3++) {
                    int i4;
                    int i5;
                    int i6 = this.zzcaz[i3];
                    int i7 = this.zzcaq[i6];
                    int zzbt = zzbt(i6);
                    if (this.zzcax) {
                        i4 = 0;
                    } else {
                        i5 = this.zzcaq[i6 + 2];
                        int i8 = i5 & 1048575;
                        i5 = 1 << (i5 >>> 20);
                        if (i8 != i2) {
                            i = zzcap.getInt(t, (long) i8);
                            i4 = i5;
                            i2 = i8;
                        } else {
                            i4 = i5;
                        }
                    }
                    if ((268435456 & zzbt) != 0) {
                        i5 = 1;
                    } else {
                        boolean z = false;
                    }
                    if (i5 != 0 && !zza((Object) t, i6, i, i4)) {
                        return false;
                    }
                    switch ((267386880 & zzbt) >>> 20) {
                        case 9:
                        case 17:
                            if (zza((Object) t, i6, i, i4) && !zza((Object) t, zzbt, zzbq(i6))) {
                                return false;
                            }
                        case 27:
                        case 49:
                            List list = (List) zzxj.zzp(t, (long) (zzbt & 1048575));
                            if (!list.isEmpty()) {
                                zzwl zzbq = zzbq(i6);
                                for (i4 = 0; i4 < list.size(); i4++) {
                                    if (!zzbq.zzaj(list.get(i4))) {
                                        z = false;
                                        if (z) {
                                            break;
                                        }
                                        return false;
                                    }
                                }
                            }
                            z = true;
                            if (z) {
                                return false;
                            }
                        case 50:
                            Map zzad = this.zzcbg.zzad(zzxj.zzp(t, (long) (zzbt & 1048575)));
                            if (!zzad.isEmpty()) {
                                if (this.zzcbg.zzah(zzbr(i6)).zzcak.zzyv() == zzxx.MESSAGE) {
                                    zzwl zzwl = null;
                                    for (Object next : zzad.values()) {
                                        if (zzwl == null) {
                                            zzwl = zzwh.zzxt().zzi(next.getClass());
                                        }
                                        if (!zzwl.zzaj(next)) {
                                            z = false;
                                            if (z) {
                                                break;
                                            }
                                            return false;
                                        }
                                    }
                                }
                            }
                            z = true;
                            if (z) {
                                return false;
                            }
                        case 60:
                        case 68:
                            if (zza((Object) t, i7, i6) && !zza((Object) t, zzbt, zzbq(i6))) {
                                return false;
                            }
                        default:
                            break;
                    }
                }
                if (!this.zzcav || this.zzcbf.zzw(t).isInitialized()) {
                    return true;
                }
                return false;
            }

            private static boolean zza(Object obj, int i, zzwl zzwl) {
                return zzwl.zzaj(zzxj.zzp(obj, (long) (1048575 & i)));
            }

            private static void zza(int i, Object obj, zzxy zzxy) {
                if (obj instanceof String) {
                    zzxy.zzb(i, (String) obj);
                } else {
                    zzxy.zza(i, (zzte) obj);
                }
            }

            private final void zza(Object obj, int i, zzwk zzwk) {
                if (zzbv(i)) {
                    zzxj.zza(obj, (long) (i & 1048575), zzwk.zzuq());
                } else if (this.zzcaw) {
                    zzxj.zza(obj, (long) (i & 1048575), zzwk.readString());
                } else {
                    zzxj.zza(obj, (long) (i & 1048575), zzwk.zzur());
                }
            }

            private final int zzbt(int i) {
                return this.zzcaq[i + 1];
            }

            private final int zzbu(int i) {
                return this.zzcaq[i + 2];
            }

            private static boolean zzbv(int i) {
                return (536870912 & i) != 0;
            }

            private static <T> double zzf(T t, long j) {
                return ((Double) zzxj.zzp(t, j)).doubleValue();
            }

            private static <T> float zzg(T t, long j) {
                return ((Float) zzxj.zzp(t, j)).floatValue();
            }

            private static <T> int zzh(T t, long j) {
                return ((Integer) zzxj.zzp(t, j)).intValue();
            }

            private static <T> long zzi(T t, long j) {
                return ((Long) zzxj.zzp(t, j)).longValue();
            }

            private static <T> boolean zzj(T t, long j) {
                return ((Boolean) zzxj.zzp(t, j)).booleanValue();
            }

            private final boolean zzc(T t, T t2, int i) {
                return zzb((Object) t, i) == zzb((Object) t2, i);
            }

            private final boolean zza(T t, int i, int i2, int i3) {
                if (this.zzcax) {
                    return zzb((Object) t, i);
                }
                return (i2 & i3) != 0;
            }

            private final boolean zzb(T t, int i) {
                if (this.zzcax) {
                    int zzbt;
                    zzbt = zzbt(i);
                    long j = (long) (zzbt & 1048575);
                    switch ((zzbt & 267386880) >>> 20) {
                        case 0:
                            if (zzxj.zzo(t, j) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                return true;
                            }
                            return false;
                        case 1:
                            return zzxj.zzn(t, j) != 0.0f;
                        case 2:
                            return zzxj.zzl(t, j) != 0;
                        case 3:
                            return zzxj.zzl(t, j) != 0;
                        case 4:
                            return zzxj.zzk(t, j) != 0;
                        case 5:
                            return zzxj.zzl(t, j) != 0;
                        case 6:
                            return zzxj.zzk(t, j) != 0;
                        case 7:
                            return zzxj.zzm(t, j);
                        case 8:
                            Object zzp = zzxj.zzp(t, j);
                            if (zzp instanceof String) {
                                return !((String) zzp).isEmpty();
                            } else {
                                if (zzp instanceof zzte) {
                                    return !zzte.zzbtq.equals(zzp);
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        case 9:
                            return zzxj.zzp(t, j) != null;
                        case 10:
                            return !zzte.zzbtq.equals(zzxj.zzp(t, j));
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            return zzxj.zzk(t, j) != 0;
                        case 12:
                            return zzxj.zzk(t, j) != 0;
                        case 13:
                            return zzxj.zzk(t, j) != 0;
                        case 14:
                            return zzxj.zzl(t, j) != 0;
                        case 15:
                            return zzxj.zzk(t, j) != 0;
                        case 16:
                            return zzxj.zzl(t, j) != 0;
                        case 17:
                            return zzxj.zzp(t, j) != null;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
                zzbt = zzbu(i);
                return (zzxj.zzk(t, (long) (zzbt & 1048575)) & (1 << (zzbt >>> 20))) != 0;
            }

            private final void zzc(T t, int i) {
                if (!this.zzcax) {
                    int zzbu = zzbu(i);
                    long j = (long) (zzbu & 1048575);
                    zzxj.zzb((Object) t, j, zzxj.zzk(t, j) | (1 << (zzbu >>> 20)));
                }
            }

            private final boolean zza(T t, int i, int i2) {
                return zzxj.zzk(t, (long) (zzbu(i2) & 1048575)) == i;
            }

            private final void zzb(T t, int i, int i2) {
                zzxj.zzb((Object) t, (long) (zzbu(i2) & 1048575), i);
            }
        }
