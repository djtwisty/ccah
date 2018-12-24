package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.internal.firebase_auth.zzft.zze;
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

final class zzhg<T> implements zzhw<T> {
    private static final int[] zzzj = new int[0];
    private static final Unsafe zzzk = zziw.zzju();
    private final zzfh<?> zzaaa;
    private final zzgx zzaab;
    private final int[] zzzl;
    private final Object[] zzzm;
    private final int zzzn;
    private final int zzzo;
    private final zzhc zzzp;
    private final boolean zzzq;
    private final boolean zzzr;
    private final boolean zzzs;
    private final boolean zzzt;
    private final int[] zzzu;
    private final int zzzv;
    private final int zzzw;
    private final zzhj zzzx;
    private final zzgm zzzy;
    private final zziq<?, ?> zzzz;

    private zzhg(int[] iArr, Object[] objArr, int i, int i2, zzhc zzhc, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzhj zzhj, zzgm zzgm, zziq<?, ?> zziq, zzfh<?> zzfh, zzgx zzgx) {
        this.zzzl = iArr;
        this.zzzm = objArr;
        this.zzzn = i;
        this.zzzo = i2;
        this.zzzr = zzhc instanceof zzft;
        this.zzzs = z;
        boolean z3 = zzfh != null && zzfh.zzf(zzhc);
        this.zzzq = z3;
        this.zzzt = false;
        this.zzzu = iArr2;
        this.zzzv = i3;
        this.zzzw = i4;
        this.zzzx = zzhj;
        this.zzzy = zzgm;
        this.zzzz = zziq;
        this.zzaaa = zzfh;
        this.zzzp = zzhc;
        this.zzaab = zzgx;
    }

    static <T> zzhg<T> zza(Class<T> cls, zzha zzha, zzhj zzhj, zzgm zzgm, zziq<?, ?> zziq, zzfh<?> zzfh, zzgx zzgx) {
        if (zzha instanceof zzhq) {
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
            zzhq zzhq = (zzhq) zzha;
            boolean z = zzhq.zzin() == zze.zzxo;
            String zziw = zzhq.zziw();
            int length = zziw.length();
            int i12 = 1;
            char charAt4 = zziw.charAt(0);
            if (charAt4 >= '?') {
                i = charAt4 & 8191;
                i2 = 13;
                while (true) {
                    i3 = i12 + 1;
                    charAt = zziw.charAt(i12);
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
            i2 = zziw.charAt(i3);
            if (i2 >= 55296) {
                i = i2 & 8191;
                i2 = 13;
                while (true) {
                    i3 = i12 + 1;
                    charAt = zziw.charAt(i12);
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
                iArr = zzzj;
                i10 = 0;
                i11 = 0;
            } else {
                char charAt5;
                char charAt6;
                char charAt7;
                char charAt8;
                i12 = i5 + 1;
                i2 = zziw.charAt(i5);
                if (i2 >= 55296) {
                    i = i2 & 8191;
                    i2 = 13;
                    while (true) {
                        i3 = i12 + 1;
                        charAt = zziw.charAt(i12);
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
                i = zziw.charAt(i3);
                if (i >= 55296) {
                    i12 = i & 8191;
                    i = 13;
                    i3 = i6;
                    while (true) {
                        i6 = i3 + 1;
                        charAt5 = zziw.charAt(i3);
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
                charAt = zziw.charAt(i6);
                if (charAt >= '?') {
                    i3 = charAt & 8191;
                    i12 = 13;
                    i6 = i7;
                    while (true) {
                        i7 = i6 + 1;
                        charAt6 = zziw.charAt(i6);
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
                charAt5 = zziw.charAt(i7);
                if (charAt5 >= '?') {
                    i6 = charAt5 & 8191;
                    i3 = 13;
                    i7 = i13;
                    while (true) {
                        i13 = i7 + 1;
                        charAt2 = zziw.charAt(i7);
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
                charAt5 = zziw.charAt(i13);
                if (charAt5 >= '?') {
                    i7 = charAt5 & 8191;
                    i3 = 13;
                    i13 = i9;
                    while (true) {
                        i9 = i13 + 1;
                        charAt7 = zziw.charAt(i13);
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
                charAt5 = zziw.charAt(i9);
                if (charAt5 >= '?') {
                    i13 = charAt5 & 8191;
                    i3 = 13;
                    i9 = i10;
                    while (true) {
                        i10 = i9 + 1;
                        charAt8 = zziw.charAt(i9);
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
                i3 = zziw.charAt(i10);
                if (i3 >= 55296) {
                    i13 = i3 & 8191;
                    i3 = 13;
                    while (true) {
                        i10 = i9 + 1;
                        charAt8 = zziw.charAt(i9);
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
                charAt7 = zziw.charAt(i10);
                if (charAt7 >= '?') {
                    i9 = charAt7 & 8191;
                    i13 = 13;
                    i10 = i5;
                    while (true) {
                        i5 = i10 + 1;
                        charAt3 = zziw.charAt(i10);
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
            Unsafe unsafe = zzzk;
            Object[] zzix = zzhq.zzix();
            int i14 = 0;
            Class cls2 = zzhq.zzip().getClass();
            int[] iArr2 = new int[(i7 * 3)];
            Object[] objArr = new Object[(i7 << 1)];
            int i15 = i9 + i8;
            int i16 = 0;
            int i17 = i9;
            int i18 = i10;
            int i19;
            for (i5 = 
/*
Method generation error in method: com.google.android.gms.internal.firebase_auth.zzhg.zza(java.lang.Class, com.google.android.gms.internal.firebase_auth.zzha, com.google.android.gms.internal.firebase_auth.zzhj, com.google.android.gms.internal.firebase_auth.zzgm, com.google.android.gms.internal.firebase_auth.zziq, com.google.android.gms.internal.firebase_auth.zzfh, com.google.android.gms.internal.firebase_auth.zzgx):com.google.android.gms.internal.firebase_auth.zzhg<T>, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r14_2 'i5' int) = (r14_1 'i5' int), (r14_39 'i5' int) binds: {(r14_39 'i5' int)=B:87:0x021b, (r14_1 'i5' int)=B:21:0x0071} in method: com.google.android.gms.internal.firebase_auth.zzhg.zza(java.lang.Class, com.google.android.gms.internal.firebase_auth.zzha, com.google.android.gms.internal.firebase_auth.zzhj, com.google.android.gms.internal.firebase_auth.zzgm, com.google.android.gms.internal.firebase_auth.zziq, com.google.android.gms.internal.firebase_auth.zzfh, com.google.android.gms.internal.firebase_auth.zzgx):com.google.android.gms.internal.firebase_auth.zzhg<T>, dex: classes.dex
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
                return this.zzzx.newInstance(this.zzzp);
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(T r12, T r13) {
                /*
                r11 = this;
                r1 = 1;
                r10 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
                r0 = 0;
                r2 = r11.zzzl;
                r4 = r2.length;
                r3 = r0;
            L_0x0009:
                if (r3 >= r4) goto L_0x01e0;
            L_0x000b:
                r2 = r11.zzax(r3);
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
                r8 = com.google.android.gms.internal.firebase_auth.zziw.zzo(r12, r6);
                r8 = java.lang.Double.doubleToLongBits(r8);
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzo(r13, r6);
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
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzn(r12, r6);
                r2 = java.lang.Float.floatToIntBits(r2);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzn(r13, r6);
                r5 = java.lang.Float.floatToIntBits(r5);
                if (r2 == r5) goto L_0x001a;
            L_0x0052:
                r2 = r0;
                goto L_0x001b;
            L_0x0054:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0066;
            L_0x005a:
                r8 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r12, r6);
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x0066:
                r2 = r0;
                goto L_0x001b;
            L_0x0068:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x007a;
            L_0x006e:
                r8 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r12, r6);
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x007a:
                r2 = r0;
                goto L_0x001b;
            L_0x007c:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x008c;
            L_0x0082:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x008c:
                r2 = r0;
                goto L_0x001b;
            L_0x008e:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00a0;
            L_0x0094:
                r8 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r12, r6);
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x00a0:
                r2 = r0;
                goto L_0x001b;
            L_0x00a3:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00b3;
            L_0x00a9:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x00b3:
                r2 = r0;
                goto L_0x001b;
            L_0x00b6:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00c6;
            L_0x00bc:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzm(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzm(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x00c6:
                r2 = r0;
                goto L_0x001b;
            L_0x00c9:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00dd;
            L_0x00cf:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r13, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x00dd:
                r2 = r0;
                goto L_0x001b;
            L_0x00e0:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x00f4;
            L_0x00e6:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r13, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x00f4:
                r2 = r0;
                goto L_0x001b;
            L_0x00f7:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x010b;
            L_0x00fd:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r13, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x010b:
                r2 = r0;
                goto L_0x001b;
            L_0x010e:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x011e;
            L_0x0114:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x011e:
                r2 = r0;
                goto L_0x001b;
            L_0x0121:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0131;
            L_0x0127:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x0131:
                r2 = r0;
                goto L_0x001b;
            L_0x0134:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0144;
            L_0x013a:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x0144:
                r2 = r0;
                goto L_0x001b;
            L_0x0147:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0159;
            L_0x014d:
                r8 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r12, r6);
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x0159:
                r2 = r0;
                goto L_0x001b;
            L_0x015c:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x016c;
            L_0x0162:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r13, r6);
                if (r2 == r5) goto L_0x001a;
            L_0x016c:
                r2 = r0;
                goto L_0x001b;
            L_0x016f:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0181;
            L_0x0175:
                r8 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r12, r6);
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r13, r6);
                r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1));
                if (r2 == 0) goto L_0x001a;
            L_0x0181:
                r2 = r0;
                goto L_0x001b;
            L_0x0184:
                r2 = r11.zzc(r12, r13, r3);
                if (r2 == 0) goto L_0x0198;
            L_0x018a:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r13, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x0198:
                r2 = r0;
                goto L_0x001b;
            L_0x019b:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r13, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r2, r5);
                goto L_0x001b;
            L_0x01a9:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r13, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r2, r5);
                goto L_0x001b;
            L_0x01b7:
                r2 = r11.zzay(r3);
                r5 = r2 & r10;
                r8 = (long) r5;
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r12, r8);
                r2 = r2 & r10;
                r8 = (long) r2;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r13, r8);
                if (r5 != r2) goto L_0x01d8;
            L_0x01ca:
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r12, r6);
                r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r13, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r2, r5);
                if (r2 != 0) goto L_0x001a;
            L_0x01d8:
                r2 = r0;
                goto L_0x001b;
            L_0x01db:
                r2 = r3 + 3;
                r3 = r2;
                goto L_0x0009;
            L_0x01e0:
                r2 = r11.zzzz;
                r2 = r2.zzs(r12);
                r3 = r11.zzzz;
                r3 = r3.zzs(r13);
                r2 = r2.equals(r3);
                if (r2 == 0) goto L_0x001d;
            L_0x01f2:
                r0 = r11.zzzq;
                if (r0 == 0) goto L_0x0208;
            L_0x01f6:
                r0 = r11.zzaaa;
                r0 = r0.zzd(r12);
                r1 = r11.zzaaa;
                r1 = r1.zzd(r13);
                r0 = r0.equals(r1);
                goto L_0x001d;
            L_0x0208:
                r0 = r1;
                goto L_0x001d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.equals(java.lang.Object, java.lang.Object):boolean");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final int hashCode(T r10) {
                /*
                r9 = this;
                r1 = 37;
                r0 = 0;
                r2 = r9.zzzl;
                r4 = r2.length;
                r3 = r0;
                r2 = r0;
            L_0x0008:
                if (r3 >= r4) goto L_0x0254;
            L_0x000a:
                r0 = r9.zzax(r3);
                r5 = r9.zzzl;
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
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzo(r10, r6);
                r6 = java.lang.Double.doubleToLongBits(r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0034:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzn(r10, r6);
                r2 = java.lang.Float.floatToIntBits(r2);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0040:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x004c:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0058:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0060:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x006c:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0074:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzm(r10, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzu(r2);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0080:
                r2 = r2 * 53;
                r0 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
                r0 = (java.lang.String) r0;
                r0 = r0.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x008e:
                r0 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
                if (r0 == 0) goto L_0x0276;
            L_0x0094:
                r0 = r0.hashCode();
            L_0x0098:
                r2 = r2 * 53;
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x009c:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
                r2 = r2.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00a9:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00b2:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00bb:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00c4:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00d1:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00da:
                r0 = r2 * 53;
                r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00e7:
                r0 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
                if (r0 == 0) goto L_0x0273;
            L_0x00ed:
                r0 = r0.hashCode();
            L_0x00f1:
                r2 = r2 * 53;
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x00f6:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
                r2 = r2.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0103:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
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
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
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
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x014d:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0153:
                r0 = r2 * 53;
                r6 = zzi(r10, r6);
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
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
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
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
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzu(r2);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01a4:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x01aa:
                r2 = r2 * 53;
                r0 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
                r0 = (java.lang.String) r0;
                r0 = r0.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01b9:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x01bf:
                r0 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
                r2 = r2 * 53;
                r0 = r0.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x01cc:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x01d2:
                r0 = r2 * 53;
                r2 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
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
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
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
                r2 = com.google.android.gms.internal.firebase_auth.zzfv.zzk(r6);
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0241:
                r0 = r9.zza(r10, r5, r3);
                if (r0 == 0) goto L_0x001f;
            L_0x0247:
                r0 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6);
                r2 = r2 * 53;
                r0 = r0.hashCode();
                r0 = r0 + r2;
                goto L_0x0020;
            L_0x0254:
                r0 = r2 * 53;
                r1 = r9.zzzz;
                r1 = r1.zzs(r10);
                r1 = r1.hashCode();
                r0 = r0 + r1;
                r1 = r9.zzzq;
                if (r1 == 0) goto L_0x0272;
            L_0x0265:
                r0 = r0 * 53;
                r1 = r9.zzaaa;
                r1 = r1.zzd(r10);
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.hashCode(java.lang.Object):int");
            }

            public final void zzc(T t, T t2) {
                if (t2 == null) {
                    throw new NullPointerException();
                }
                for (int i = 0; i < this.zzzl.length; i += 3) {
                    int zzax = zzax(i);
                    long j = (long) (1048575 & zzax);
                    int i2 = this.zzzl[i];
                    switch ((zzax & 267386880) >>> 20) {
                        case 0:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzo(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 1:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzn(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 2:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 3:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 4:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 5:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 6:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 7:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzm(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 8:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzp(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 9:
                            zza((Object) t, (Object) t2, i);
                            break;
                        case 10:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzp(t2, j));
                            zzb((Object) t, i);
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 12:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 13:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 14:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 15:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb((Object) t, i);
                            break;
                        case 16:
                            if (!zza((Object) t2, i)) {
                                break;
                            }
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb((Object) t, i);
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
                            this.zzzy.zza(t, t2, j);
                            break;
                        case 50:
                            zzhy.zza(this.zzaab, (Object) t, (Object) t2, j);
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
                            zziw.zza((Object) t, j, zziw.zzp(t2, j));
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
                            zziw.zza((Object) t, j, zziw.zzp(t2, j));
                            zzb((Object) t, i2, i);
                            break;
                        case 68:
                            zzb((Object) t, (Object) t2, i);
                            break;
                        default:
                            break;
                    }
                }
                if (!this.zzzs) {
                    zzhy.zza(this.zzzz, (Object) t, (Object) t2);
                    if (this.zzzq) {
                        zzhy.zza(this.zzaaa, (Object) t, (Object) t2);
                    }
                }
            }

            private final void zza(T t, T t2, int i) {
                long zzax = (long) (zzax(i) & 1048575);
                if (zza((Object) t2, i)) {
                    Object zzp = zziw.zzp(t, zzax);
                    Object zzp2 = zziw.zzp(t2, zzax);
                    if (zzp != null && zzp2 != null) {
                        zziw.zza((Object) t, zzax, zzfv.zza(zzp, zzp2));
                        zzb((Object) t, i);
                    } else if (zzp2 != null) {
                        zziw.zza((Object) t, zzax, zzp2);
                        zzb((Object) t, i);
                    }
                }
            }

            private final void zzb(T t, T t2, int i) {
                int zzax = zzax(i);
                int i2 = this.zzzl[i];
                long j = (long) (zzax & 1048575);
                if (zza((Object) t2, i2, i)) {
                    Object zzp = zziw.zzp(t, j);
                    Object zzp2 = zziw.zzp(t2, j);
                    if (zzp != null && zzp2 != null) {
                        zziw.zza((Object) t, j, zzfv.zza(zzp, zzp2));
                        zzb((Object) t, i2, i);
                    } else if (zzp2 != null) {
                        zziw.zza((Object) t, j, zzp2);
                        zzb((Object) t, i2, i);
                    }
                }
            }

            public final int zzp(T t) {
                int i;
                int i2;
                int zzax;
                int i3;
                int i4;
                int i5;
                Object zzp;
                if (this.zzzs) {
                    Unsafe unsafe = zzzk;
                    i = 0;
                    for (i2 = 0; i2 < this.zzzl.length; i2 += 3) {
                        zzax = zzax(i2);
                        i3 = (267386880 & zzax) >>> 20;
                        i4 = this.zzzl[i2];
                        long j = (long) (zzax & 1048575);
                        if (i3 < zzfn.DOUBLE_LIST_PACKED.id() || i3 > zzfn.SINT64_LIST_PACKED.id()) {
                            i5 = 0;
                        } else {
                            i5 = this.zzzl[i2 + 2] & 1048575;
                        }
                        switch (i3) {
                            case 0:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzb(i4, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                break;
                            case 1:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzb(i4, 0.0f);
                                break;
                            case 2:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzd(i4, zziw.zzl(t, j));
                                break;
                            case 3:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zze(i4, zziw.zzl(t, j));
                                break;
                            case 4:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzk(i4, zziw.zzk(t, j));
                                break;
                            case 5:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzg(i4, 0);
                                break;
                            case 6:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzn(i4, 0);
                                break;
                            case 7:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzc(i4, true);
                                break;
                            case 8:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                zzp = zziw.zzp(t, j);
                                if (!(zzp instanceof zzeh)) {
                                    i += zzfa.zzb(i4, (String) zzp);
                                    break;
                                }
                                i += zzfa.zzc(i4, (zzeh) zzp);
                                break;
                            case 9:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzhy.zzc(i4, zziw.zzp(t, j), zzau(i2));
                                break;
                            case 10:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzc(i4, (zzeh) zziw.zzp(t, j));
                                break;
                            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzl(i4, zziw.zzk(t, j));
                                break;
                            case 12:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzp(i4, zziw.zzk(t, j));
                                break;
                            case 13:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzo(i4, 0);
                                break;
                            case 14:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzh(i4, 0);
                                break;
                            case 15:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzm(i4, zziw.zzk(t, j));
                                break;
                            case 16:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzf(i4, zziw.zzl(t, j));
                                break;
                            case 17:
                                if (!zza((Object) t, i2)) {
                                    break;
                                }
                                i += zzfa.zzc(i4, (zzhc) zziw.zzp(t, j), zzau(i2));
                                break;
                            case 18:
                                i += zzhy.zzw(i4, zze(t, j), false);
                                break;
                            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                                i += zzhy.zzv(i4, zze(t, j), false);
                                break;
                            case 20:
                                i += zzhy.zzo(i4, zze(t, j), false);
                                break;
                            case 21:
                                i += zzhy.zzp(i4, zze(t, j), false);
                                break;
                            case 22:
                                i += zzhy.zzs(i4, zze(t, j), false);
                                break;
                            case 23:
                                i += zzhy.zzw(i4, zze(t, j), false);
                                break;
                            case 24:
                                i += zzhy.zzv(i4, zze(t, j), false);
                                break;
                            case 25:
                                i += zzhy.zzx(i4, zze(t, j), false);
                                break;
                            case 26:
                                i += zzhy.zzc(i4, zze(t, j));
                                break;
                            case 27:
                                i += zzhy.zzc(i4, zze(t, j), zzau(i2));
                                break;
                            case 28:
                                i += zzhy.zzd(i4, zze(t, j));
                                break;
                            case 29:
                                i += zzhy.zzt(i4, zze(t, j), false);
                                break;
                            case 30:
                                i += zzhy.zzr(i4, zze(t, j), false);
                                break;
                            case 31:
                                i += zzhy.zzv(i4, zze(t, j), false);
                                break;
                            case HTTP.SP /*32*/:
                                i += zzhy.zzw(i4, zze(t, j), false);
                                break;
                            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                                i += zzhy.zzu(i4, zze(t, j), false);
                                break;
                            case 34:
                                i += zzhy.zzq(i4, zze(t, j), false);
                                break;
                            case 35:
                                zzax = zzhy.zzab((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 36:
                                zzax = zzhy.zzaa((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case LangUtils.HASH_OFFSET /*37*/:
                                zzax = zzhy.zzt((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 38:
                                zzax = zzhy.zzu((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 39:
                                zzax = zzhy.zzx((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 40:
                                zzax = zzhy.zzab((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 41:
                                zzax = zzhy.zzaa((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 42:
                                zzax = zzhy.zzac((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 43:
                                zzax = zzhy.zzy((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 44:
                                zzax = zzhy.zzw((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 45:
                                zzax = zzhy.zzaa((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 46:
                                zzax = zzhy.zzab((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 47:
                                zzax = zzhy.zzz((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 48:
                                zzax = zzhy.zzv((List) unsafe.getObject(t, j));
                                if (zzax > 0) {
                                    if (this.zzzt) {
                                        unsafe.putInt(t, (long) i5, zzax);
                                    }
                                    i += zzax + (zzfa.zzag(i4) + zzfa.zzai(zzax));
                                    break;
                                }
                                break;
                            case 49:
                                i += zzhy.zzd(i4, zze(t, j), zzau(i2));
                                break;
                            case 50:
                                i += this.zzaab.zzb(i4, zziw.zzp(t, j), zzav(i2));
                                break;
                            case 51:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzb(i4, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                break;
                            case 52:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzb(i4, 0.0f);
                                break;
                            case 53:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzd(i4, zzi(t, j));
                                break;
                            case 54:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zze(i4, zzi(t, j));
                                break;
                            case 55:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzk(i4, zzh(t, j));
                                break;
                            case 56:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzg(i4, 0);
                                break;
                            case 57:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzn(i4, 0);
                                break;
                            case 58:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzc(i4, true);
                                break;
                            case 59:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                zzp = zziw.zzp(t, j);
                                if (!(zzp instanceof zzeh)) {
                                    i += zzfa.zzb(i4, (String) zzp);
                                    break;
                                }
                                i += zzfa.zzc(i4, (zzeh) zzp);
                                break;
                            case 60:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzhy.zzc(i4, zziw.zzp(t, j), zzau(i2));
                                break;
                            case 61:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzc(i4, (zzeh) zziw.zzp(t, j));
                                break;
                            case 62:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzl(i4, zzh(t, j));
                                break;
                            case 63:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzp(i4, zzh(t, j));
                                break;
                            case 64:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzo(i4, 0);
                                break;
                            case 65:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzh(i4, 0);
                                break;
                            case 66:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzm(i4, zzh(t, j));
                                break;
                            case 67:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzf(i4, zzi(t, j));
                                break;
                            case 68:
                                if (!zza((Object) t, i4, i2)) {
                                    break;
                                }
                                i += zzfa.zzc(i4, (zzhc) zziw.zzp(t, j), zzau(i2));
                                break;
                            default:
                                break;
                        }
                    }
                    return zza(this.zzzz, (Object) t) + i;
                }
                int i6 = 0;
                Unsafe unsafe2 = zzzk;
                i5 = -1;
                i = 0;
                for (i2 = 0; i2 < this.zzzl.length; i2 += 3) {
                    int zzax2 = zzax(i2);
                    int i7 = this.zzzl[i2];
                    int i8 = (267386880 & zzax2) >>> 20;
                    zzax = 0;
                    if (i8 <= 17) {
                        i4 = this.zzzl[i2 + 2];
                        zzax = 1048575 & i4;
                        i3 = 1 << (i4 >>> 20);
                        if (zzax != i5) {
                            i = unsafe2.getInt(t, (long) zzax);
                            i5 = zzax;
                        }
                        zzax = i3;
                    } else if (!this.zzzt || i8 < zzfn.DOUBLE_LIST_PACKED.id() || i8 > zzfn.SINT64_LIST_PACKED.id()) {
                        i4 = 0;
                    } else {
                        i4 = this.zzzl[i2 + 2] & 1048575;
                    }
                    long j2 = (long) (1048575 & zzax2);
                    switch (i8) {
                        case 0:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzb(i7, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        case 1:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzb(i7, 0.0f);
                            break;
                        case 2:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzd(i7, unsafe2.getLong(t, j2));
                            break;
                        case 3:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zze(i7, unsafe2.getLong(t, j2));
                            break;
                        case 4:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzk(i7, unsafe2.getInt(t, j2));
                            break;
                        case 5:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzg(i7, 0);
                            break;
                        case 6:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzn(i7, 0);
                            break;
                        case 7:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzc(i7, true);
                            break;
                        case 8:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            zzp = unsafe2.getObject(t, j2);
                            if (!(zzp instanceof zzeh)) {
                                i6 += zzfa.zzb(i7, (String) zzp);
                                break;
                            }
                            i6 += zzfa.zzc(i7, (zzeh) zzp);
                            break;
                        case 9:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzhy.zzc(i7, unsafe2.getObject(t, j2), zzau(i2));
                            break;
                        case 10:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzc(i7, (zzeh) unsafe2.getObject(t, j2));
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzl(i7, unsafe2.getInt(t, j2));
                            break;
                        case 12:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzp(i7, unsafe2.getInt(t, j2));
                            break;
                        case 13:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzo(i7, 0);
                            break;
                        case 14:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzh(i7, 0);
                            break;
                        case 15:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzm(i7, unsafe2.getInt(t, j2));
                            break;
                        case 16:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzf(i7, unsafe2.getLong(t, j2));
                            break;
                        case 17:
                            if ((zzax & i) == 0) {
                                break;
                            }
                            i6 += zzfa.zzc(i7, (zzhc) unsafe2.getObject(t, j2), zzau(i2));
                            break;
                        case 18:
                            i6 += zzhy.zzw(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                            i6 += zzhy.zzv(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 20:
                            i6 += zzhy.zzo(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 21:
                            i6 += zzhy.zzp(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 22:
                            i6 += zzhy.zzs(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 23:
                            i6 += zzhy.zzw(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 24:
                            i6 += zzhy.zzv(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 25:
                            i6 += zzhy.zzx(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 26:
                            i6 += zzhy.zzc(i7, (List) unsafe2.getObject(t, j2));
                            break;
                        case 27:
                            i6 += zzhy.zzc(i7, (List) unsafe2.getObject(t, j2), zzau(i2));
                            break;
                        case 28:
                            i6 += zzhy.zzd(i7, (List) unsafe2.getObject(t, j2));
                            break;
                        case 29:
                            i6 += zzhy.zzt(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 30:
                            i6 += zzhy.zzr(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 31:
                            i6 += zzhy.zzv(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case HTTP.SP /*32*/:
                            i6 += zzhy.zzw(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case Encoder.DEFAULT_EC_PERCENT /*33*/:
                            i6 += zzhy.zzu(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 34:
                            i6 += zzhy.zzq(i7, (List) unsafe2.getObject(t, j2), false);
                            break;
                        case 35:
                            zzax = zzhy.zzab((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 36:
                            zzax = zzhy.zzaa((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case LangUtils.HASH_OFFSET /*37*/:
                            zzax = zzhy.zzt((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 38:
                            zzax = zzhy.zzu((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 39:
                            zzax = zzhy.zzx((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 40:
                            zzax = zzhy.zzab((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 41:
                            zzax = zzhy.zzaa((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 42:
                            zzax = zzhy.zzac((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 43:
                            zzax = zzhy.zzy((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 44:
                            zzax = zzhy.zzw((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 45:
                            zzax = zzhy.zzaa((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 46:
                            zzax = zzhy.zzab((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 47:
                            zzax = zzhy.zzz((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 48:
                            zzax = zzhy.zzv((List) unsafe2.getObject(t, j2));
                            if (zzax > 0) {
                                if (this.zzzt) {
                                    unsafe2.putInt(t, (long) i4, zzax);
                                }
                                i6 += zzax + (zzfa.zzag(i7) + zzfa.zzai(zzax));
                                break;
                            }
                            break;
                        case 49:
                            i6 += zzhy.zzd(i7, (List) unsafe2.getObject(t, j2), zzau(i2));
                            break;
                        case 50:
                            i6 += this.zzaab.zzb(i7, unsafe2.getObject(t, j2), zzav(i2));
                            break;
                        case 51:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzb(i7, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                            break;
                        case 52:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzb(i7, 0.0f);
                            break;
                        case 53:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzd(i7, zzi(t, j2));
                            break;
                        case 54:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zze(i7, zzi(t, j2));
                            break;
                        case 55:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzk(i7, zzh(t, j2));
                            break;
                        case 56:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzg(i7, 0);
                            break;
                        case 57:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzn(i7, 0);
                            break;
                        case 58:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzc(i7, true);
                            break;
                        case 59:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            zzp = unsafe2.getObject(t, j2);
                            if (!(zzp instanceof zzeh)) {
                                i6 += zzfa.zzb(i7, (String) zzp);
                                break;
                            }
                            i6 += zzfa.zzc(i7, (zzeh) zzp);
                            break;
                        case 60:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzhy.zzc(i7, unsafe2.getObject(t, j2), zzau(i2));
                            break;
                        case 61:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzc(i7, (zzeh) unsafe2.getObject(t, j2));
                            break;
                        case 62:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzl(i7, zzh(t, j2));
                            break;
                        case 63:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzp(i7, zzh(t, j2));
                            break;
                        case 64:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzo(i7, 0);
                            break;
                        case 65:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzh(i7, 0);
                            break;
                        case 66:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzm(i7, zzh(t, j2));
                            break;
                        case 67:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzf(i7, zzi(t, j2));
                            break;
                        case 68:
                            if (!zza((Object) t, i7, i2)) {
                                break;
                            }
                            i6 += zzfa.zzc(i7, (zzhc) unsafe2.getObject(t, j2), zzau(i2));
                            break;
                        default:
                            break;
                    }
                }
                zzax = zza(this.zzzz, (Object) t) + i6;
                if (this.zzzq) {
                    return zzax + this.zzaaa.zzd(t).zzgw();
                }
                return zzax;
            }

            private static <UT, UB> int zza(zziq<UT, UB> zziq, T t) {
                return zziq.zzp(zziq.zzs(t));
            }

            private static <E> List<E> zze(Object obj, long j) {
                return (List) zziw.zzp(obj, j);
            }

            public final void zza(T t, zzjl zzjl) {
                Iterator it;
                Entry entry;
                zzfk zzd;
                int length;
                int zzax;
                int i;
                Entry entry2;
                if (zzjl.zzgl() == zze.zzxr) {
                    zza(this.zzzz, (Object) t, zzjl);
                    it = null;
                    entry = null;
                    if (this.zzzq) {
                        zzd = this.zzaaa.zzd(t);
                        if (!zzd.isEmpty()) {
                            it = zzd.descendingIterator();
                            entry = (Entry) it.next();
                        }
                    }
                    length = this.zzzl.length - 3;
                    while (length >= 0) {
                        zzax = zzax(length);
                        i = this.zzzl[length];
                        entry2 = entry;
                        while (entry2 != null && this.zzaaa.zza(entry2) > i) {
                            this.zzaaa.zza(zzjl, entry2);
                            entry2 = it.hasNext() ? (Entry) it.next() : null;
                        }
                        switch ((267386880 & zzax) >>> 20) {
                            case 0:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i, zziw.zzo(t, (long) (1048575 & zzax)));
                                break;
                            case 1:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i, zziw.zzn(t, (long) (1048575 & zzax)));
                                break;
                            case 2:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzi(i, zziw.zzl(t, (long) (1048575 & zzax)));
                                break;
                            case 3:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i, zziw.zzl(t, (long) (1048575 & zzax)));
                                break;
                            case 4:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzg(i, zziw.zzk(t, (long) (1048575 & zzax)));
                                break;
                            case 5:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzc(i, zziw.zzl(t, (long) (1048575 & zzax)));
                                break;
                            case 6:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzj(i, zziw.zzk(t, (long) (1048575 & zzax)));
                                break;
                            case 7:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzb(i, zziw.zzm(t, (long) (1048575 & zzax)));
                                break;
                            case 8:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zza(i, zziw.zzp(t, (long) (1048575 & zzax)), zzjl);
                                break;
                            case 9:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i, zziw.zzp(t, (long) (1048575 & zzax)), zzau(length));
                                break;
                            case 10:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i, (zzeh) zziw.zzp(t, (long) (1048575 & zzax)));
                                break;
                            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzh(i, zziw.zzk(t, (long) (1048575 & zzax)));
                                break;
                            case 12:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzr(i, zziw.zzk(t, (long) (1048575 & zzax)));
                                break;
                            case 13:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzq(i, zziw.zzk(t, (long) (1048575 & zzax)));
                                break;
                            case 14:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzj(i, zziw.zzl(t, (long) (1048575 & zzax)));
                                break;
                            case 15:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzi(i, zziw.zzk(t, (long) (1048575 & zzax)));
                                break;
                            case 16:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzb(i, zziw.zzl(t, (long) (1048575 & zzax)));
                                break;
                            case 17:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzb(i, zziw.zzp(t, (long) (1048575 & zzax)), zzau(length));
                                break;
                            case 18:
                                zzhy.zza(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                                zzhy.zzb(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 20:
                                zzhy.zzc(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 21:
                                zzhy.zzd(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 22:
                                zzhy.zzh(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 23:
                                zzhy.zzf(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 24:
                                zzhy.zzk(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 25:
                                zzhy.zzn(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 26:
                                zzhy.zza(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl);
                                break;
                            case 27:
                                zzhy.zza(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, zzau(length));
                                break;
                            case 28:
                                zzhy.zzb(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl);
                                break;
                            case 29:
                                zzhy.zzi(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 30:
                                zzhy.zzm(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 31:
                                zzhy.zzl(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case HTTP.SP /*32*/:
                                zzhy.zzg(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                                zzhy.zzj(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 34:
                                zzhy.zze(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, false);
                                break;
                            case 35:
                                zzhy.zza(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 36:
                                zzhy.zzb(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case LangUtils.HASH_OFFSET /*37*/:
                                zzhy.zzc(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 38:
                                zzhy.zzd(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 39:
                                zzhy.zzh(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 40:
                                zzhy.zzf(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 41:
                                zzhy.zzk(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 42:
                                zzhy.zzn(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 43:
                                zzhy.zzi(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 44:
                                zzhy.zzm(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 45:
                                zzhy.zzl(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 46:
                                zzhy.zzg(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 47:
                                zzhy.zzj(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 48:
                                zzhy.zze(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, true);
                                break;
                            case 49:
                                zzhy.zzb(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & zzax)), zzjl, zzau(length));
                                break;
                            case 50:
                                zza(zzjl, i, zziw.zzp(t, (long) (1048575 & zzax)), length);
                                break;
                            case 51:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zza(i, zzf(t, (long) (1048575 & zzax)));
                                break;
                            case 52:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zza(i, zzg(t, (long) (1048575 & zzax)));
                                break;
                            case 53:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzi(i, zzi(t, (long) (1048575 & zzax)));
                                break;
                            case 54:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zza(i, zzi(t, (long) (1048575 & zzax)));
                                break;
                            case 55:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzg(i, zzh(t, (long) (1048575 & zzax)));
                                break;
                            case 56:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzc(i, zzi(t, (long) (1048575 & zzax)));
                                break;
                            case 57:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzj(i, zzh(t, (long) (1048575 & zzax)));
                                break;
                            case 58:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzb(i, zzj(t, (long) (1048575 & zzax)));
                                break;
                            case 59:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zza(i, zziw.zzp(t, (long) (1048575 & zzax)), zzjl);
                                break;
                            case 60:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zza(i, zziw.zzp(t, (long) (1048575 & zzax)), zzau(length));
                                break;
                            case 61:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zza(i, (zzeh) zziw.zzp(t, (long) (1048575 & zzax)));
                                break;
                            case 62:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzh(i, zzh(t, (long) (1048575 & zzax)));
                                break;
                            case 63:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzr(i, zzh(t, (long) (1048575 & zzax)));
                                break;
                            case 64:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzq(i, zzh(t, (long) (1048575 & zzax)));
                                break;
                            case 65:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzj(i, zzi(t, (long) (1048575 & zzax)));
                                break;
                            case 66:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzi(i, zzh(t, (long) (1048575 & zzax)));
                                break;
                            case 67:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzb(i, zzi(t, (long) (1048575 & zzax)));
                                break;
                            case 68:
                                if (!zza((Object) t, i, length)) {
                                    break;
                                }
                                zzjl.zzb(i, zziw.zzp(t, (long) (1048575 & zzax)), zzau(length));
                                break;
                            default:
                                break;
                        }
                        length -= 3;
                        entry = entry2;
                    }
                    while (entry != null) {
                        this.zzaaa.zza(zzjl, entry);
                        entry = it.hasNext() ? (Entry) it.next() : null;
                    }
                } else if (this.zzzs) {
                    it = null;
                    entry = null;
                    if (this.zzzq) {
                        zzd = this.zzaaa.zzd(t);
                        if (!zzd.isEmpty()) {
                            it = zzd.iterator();
                            entry = (Entry) it.next();
                        }
                    }
                    zzax = this.zzzl.length;
                    length = 0;
                    while (length < zzax) {
                        i = zzax(length);
                        int i2 = this.zzzl[length];
                        entry2 = entry;
                        while (entry2 != null && this.zzaaa.zza(entry2) <= i2) {
                            this.zzaaa.zza(zzjl, entry2);
                            entry2 = it.hasNext() ? (Entry) it.next() : null;
                        }
                        switch ((267386880 & i) >>> 20) {
                            case 0:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i2, zziw.zzo(t, (long) (1048575 & i)));
                                break;
                            case 1:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i2, zziw.zzn(t, (long) (1048575 & i)));
                                break;
                            case 2:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzi(i2, zziw.zzl(t, (long) (1048575 & i)));
                                break;
                            case 3:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i2, zziw.zzl(t, (long) (1048575 & i)));
                                break;
                            case 4:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzg(i2, zziw.zzk(t, (long) (1048575 & i)));
                                break;
                            case 5:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzc(i2, zziw.zzl(t, (long) (1048575 & i)));
                                break;
                            case 6:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzj(i2, zziw.zzk(t, (long) (1048575 & i)));
                                break;
                            case 7:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzb(i2, zziw.zzm(t, (long) (1048575 & i)));
                                break;
                            case 8:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zza(i2, zziw.zzp(t, (long) (1048575 & i)), zzjl);
                                break;
                            case 9:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i2, zziw.zzp(t, (long) (1048575 & i)), zzau(length));
                                break;
                            case 10:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zza(i2, (zzeh) zziw.zzp(t, (long) (1048575 & i)));
                                break;
                            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzh(i2, zziw.zzk(t, (long) (1048575 & i)));
                                break;
                            case 12:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzr(i2, zziw.zzk(t, (long) (1048575 & i)));
                                break;
                            case 13:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzq(i2, zziw.zzk(t, (long) (1048575 & i)));
                                break;
                            case 14:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzj(i2, zziw.zzl(t, (long) (1048575 & i)));
                                break;
                            case 15:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzi(i2, zziw.zzk(t, (long) (1048575 & i)));
                                break;
                            case 16:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzb(i2, zziw.zzl(t, (long) (1048575 & i)));
                                break;
                            case 17:
                                if (!zza((Object) t, length)) {
                                    break;
                                }
                                zzjl.zzb(i2, zziw.zzp(t, (long) (1048575 & i)), zzau(length));
                                break;
                            case 18:
                                zzhy.zza(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                                zzhy.zzb(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 20:
                                zzhy.zzc(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 21:
                                zzhy.zzd(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 22:
                                zzhy.zzh(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 23:
                                zzhy.zzf(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 24:
                                zzhy.zzk(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 25:
                                zzhy.zzn(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 26:
                                zzhy.zza(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl);
                                break;
                            case 27:
                                zzhy.zza(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, zzau(length));
                                break;
                            case 28:
                                zzhy.zzb(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl);
                                break;
                            case 29:
                                zzhy.zzi(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 30:
                                zzhy.zzm(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 31:
                                zzhy.zzl(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case HTTP.SP /*32*/:
                                zzhy.zzg(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                                zzhy.zzj(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 34:
                                zzhy.zze(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, false);
                                break;
                            case 35:
                                zzhy.zza(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 36:
                                zzhy.zzb(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case LangUtils.HASH_OFFSET /*37*/:
                                zzhy.zzc(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 38:
                                zzhy.zzd(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 39:
                                zzhy.zzh(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 40:
                                zzhy.zzf(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 41:
                                zzhy.zzk(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 42:
                                zzhy.zzn(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 43:
                                zzhy.zzi(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 44:
                                zzhy.zzm(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 45:
                                zzhy.zzl(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 46:
                                zzhy.zzg(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 47:
                                zzhy.zzj(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 48:
                                zzhy.zze(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, true);
                                break;
                            case 49:
                                zzhy.zzb(this.zzzl[length], (List) zziw.zzp(t, (long) (1048575 & i)), zzjl, zzau(length));
                                break;
                            case 50:
                                zza(zzjl, i2, zziw.zzp(t, (long) (1048575 & i)), length);
                                break;
                            case 51:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zza(i2, zzf(t, (long) (1048575 & i)));
                                break;
                            case 52:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zza(i2, zzg(t, (long) (1048575 & i)));
                                break;
                            case 53:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzi(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 54:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zza(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 55:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzg(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 56:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzc(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 57:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzj(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 58:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzb(i2, zzj(t, (long) (1048575 & i)));
                                break;
                            case 59:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zza(i2, zziw.zzp(t, (long) (1048575 & i)), zzjl);
                                break;
                            case 60:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zza(i2, zziw.zzp(t, (long) (1048575 & i)), zzau(length));
                                break;
                            case 61:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zza(i2, (zzeh) zziw.zzp(t, (long) (1048575 & i)));
                                break;
                            case 62:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzh(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 63:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzr(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 64:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzq(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 65:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzj(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 66:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzi(i2, zzh(t, (long) (1048575 & i)));
                                break;
                            case 67:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzb(i2, zzi(t, (long) (1048575 & i)));
                                break;
                            case 68:
                                if (!zza((Object) t, i2, length)) {
                                    break;
                                }
                                zzjl.zzb(i2, zziw.zzp(t, (long) (1048575 & i)), zzau(length));
                                break;
                            default:
                                break;
                        }
                        length += 3;
                        entry = entry2;
                    }
                    while (entry != null) {
                        this.zzaaa.zza(zzjl, entry);
                        entry = it.hasNext() ? (Entry) it.next() : null;
                    }
                    zza(this.zzzz, (Object) t, zzjl);
                } else {
                    zzb((Object) t, zzjl);
                }
            }

            private final void zzb(T t, zzjl zzjl) {
                Iterator it = null;
                Entry entry = null;
                if (this.zzzq) {
                    zzfk zzd = this.zzaaa.zzd(t);
                    if (!zzd.isEmpty()) {
                        it = zzd.iterator();
                        entry = (Entry) it.next();
                    }
                }
                int i = -1;
                int i2 = 0;
                int length = this.zzzl.length;
                Unsafe unsafe = zzzk;
                int i3 = 0;
                Entry entry2 = entry;
                while (i3 < length) {
                    int i4;
                    int i5;
                    int zzax = zzax(i3);
                    int i6 = this.zzzl[i3];
                    int i7 = (267386880 & zzax) >>> 20;
                    if (this.zzzs || i7 > 17) {
                        i4 = 0;
                        i5 = i2;
                    } else {
                        int i8;
                        i4 = this.zzzl[i3 + 2];
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
                    while (entry2 != null && this.zzaaa.zza(entry2) <= i6) {
                        this.zzaaa.zza(zzjl, entry2);
                        entry2 = it.hasNext() ? (Entry) it.next() : null;
                    }
                    long j = (long) (1048575 & zzax);
                    switch (i7) {
                        case 0:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zza(i6, zziw.zzo(t, j));
                            break;
                        case 1:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zza(i6, zziw.zzn(t, j));
                            break;
                        case 2:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzi(i6, unsafe.getLong(t, j));
                            break;
                        case 3:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zza(i6, unsafe.getLong(t, j));
                            break;
                        case 4:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzg(i6, unsafe.getInt(t, j));
                            break;
                        case 5:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzc(i6, unsafe.getLong(t, j));
                            break;
                        case 6:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzj(i6, unsafe.getInt(t, j));
                            break;
                        case 7:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzb(i6, zziw.zzm(t, j));
                            break;
                        case 8:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zza(i6, unsafe.getObject(t, j), zzjl);
                            break;
                        case 9:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zza(i6, unsafe.getObject(t, j), zzau(i3));
                            break;
                        case 10:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zza(i6, (zzeh) unsafe.getObject(t, j));
                            break;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzh(i6, unsafe.getInt(t, j));
                            break;
                        case 12:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzr(i6, unsafe.getInt(t, j));
                            break;
                        case 13:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzq(i6, unsafe.getInt(t, j));
                            break;
                        case 14:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzj(i6, unsafe.getLong(t, j));
                            break;
                        case 15:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzi(i6, unsafe.getInt(t, j));
                            break;
                        case 16:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzb(i6, unsafe.getLong(t, j));
                            break;
                        case 17:
                            if ((i5 & i4) == 0) {
                                break;
                            }
                            zzjl.zzb(i6, unsafe.getObject(t, j), zzau(i3));
                            break;
                        case 18:
                            zzhy.zza(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                            zzhy.zzb(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 20:
                            zzhy.zzc(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 21:
                            zzhy.zzd(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 22:
                            zzhy.zzh(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 23:
                            zzhy.zzf(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 24:
                            zzhy.zzk(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 25:
                            zzhy.zzn(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 26:
                            zzhy.zza(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl);
                            break;
                        case 27:
                            zzhy.zza(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, zzau(i3));
                            break;
                        case 28:
                            zzhy.zzb(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl);
                            break;
                        case 29:
                            zzhy.zzi(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 30:
                            zzhy.zzm(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 31:
                            zzhy.zzl(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case HTTP.SP /*32*/:
                            zzhy.zzg(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case Encoder.DEFAULT_EC_PERCENT /*33*/:
                            zzhy.zzj(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 34:
                            zzhy.zze(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, false);
                            break;
                        case 35:
                            zzhy.zza(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 36:
                            zzhy.zzb(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case LangUtils.HASH_OFFSET /*37*/:
                            zzhy.zzc(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 38:
                            zzhy.zzd(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 39:
                            zzhy.zzh(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 40:
                            zzhy.zzf(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 41:
                            zzhy.zzk(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 42:
                            zzhy.zzn(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 43:
                            zzhy.zzi(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 44:
                            zzhy.zzm(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 45:
                            zzhy.zzl(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 46:
                            zzhy.zzg(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 47:
                            zzhy.zzj(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 48:
                            zzhy.zze(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, true);
                            break;
                        case 49:
                            zzhy.zzb(this.zzzl[i3], (List) unsafe.getObject(t, j), zzjl, zzau(i3));
                            break;
                        case 50:
                            zza(zzjl, i6, unsafe.getObject(t, j), i3);
                            break;
                        case 51:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zza(i6, zzf(t, j));
                            break;
                        case 52:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zza(i6, zzg(t, j));
                            break;
                        case 53:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzi(i6, zzi(t, j));
                            break;
                        case 54:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zza(i6, zzi(t, j));
                            break;
                        case 55:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzg(i6, zzh(t, j));
                            break;
                        case 56:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzc(i6, zzi(t, j));
                            break;
                        case 57:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzj(i6, zzh(t, j));
                            break;
                        case 58:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzb(i6, zzj(t, j));
                            break;
                        case 59:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zza(i6, unsafe.getObject(t, j), zzjl);
                            break;
                        case 60:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zza(i6, unsafe.getObject(t, j), zzau(i3));
                            break;
                        case 61:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zza(i6, (zzeh) unsafe.getObject(t, j));
                            break;
                        case 62:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzh(i6, zzh(t, j));
                            break;
                        case 63:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzr(i6, zzh(t, j));
                            break;
                        case 64:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzq(i6, zzh(t, j));
                            break;
                        case 65:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzj(i6, zzi(t, j));
                            break;
                        case 66:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzi(i6, zzh(t, j));
                            break;
                        case 67:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzb(i6, zzi(t, j));
                            break;
                        case 68:
                            if (!zza((Object) t, i6, i3)) {
                                break;
                            }
                            zzjl.zzb(i6, unsafe.getObject(t, j), zzau(i3));
                            break;
                        default:
                            break;
                    }
                    i3 += 3;
                    i2 = i5;
                }
                for (entry = entry2; entry != null; entry = it.hasNext() ? (Entry) it.next() : null) {
                    this.zzaaa.zza(zzjl, entry);
                }
                zza(this.zzzz, (Object) t, zzjl);
            }

            private final <K, V> void zza(zzjl zzjl, int i, Object obj, int i2) {
                if (obj != null) {
                    zzjl.zza(i, this.zzaab.zzo(zzav(i2)), this.zzaab.zzk(obj));
                }
            }

            private static <UT, UB> void zza(zziq<UT, UB> zziq, T t, zzjl zzjl) {
                zziq.zza(zziq.zzs(t), zzjl);
            }

            public final void zza(T t, zzhr zzhr, zzfg zzfg) {
                Throwable th;
                if (zzfg == null) {
                    throw new NullPointerException();
                }
                zziq zziq = this.zzzz;
                zzfh zzfh = this.zzaaa;
                Object obj = null;
                zzfk zzfk = null;
                while (true) {
                    int i;
                    int i2;
                    int length;
                    Object zzn;
                    int i3;
                    int zzgg = zzhr.zzgg();
                    if (zzgg < this.zzzn || zzgg > this.zzzo) {
                        i = -1;
                    } else {
                        i2 = 0;
                        length = (this.zzzl.length / 3) - 1;
                        while (i2 <= length) {
                            int i4 = (length + i2) >>> 1;
                            i = i4 * 3;
                            int i5 = this.zzzl[i];
                            if (zzgg != i5) {
                                if (zzgg < i5) {
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
                        length = zzax(i);
                        zzfy zzaw;
                        List zza;
                        switch ((267386880 & length) >>> 20) {
                            case 0:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.readDouble());
                                zzb((Object) t, i);
                                continue;
                            case 1:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.readFloat());
                                zzb((Object) t, i);
                                continue;
                            case 2:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzfk());
                                zzb((Object) t, i);
                                continue;
                            case 3:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzfj());
                                zzb((Object) t, i);
                                continue;
                            case 4:
                                zziw.zzb((Object) t, (long) (length & 1048575), zzhr.zzfl());
                                zzb((Object) t, i);
                                continue;
                            case 5:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzfm());
                                zzb((Object) t, i);
                                continue;
                            case 6:
                                zziw.zzb((Object) t, (long) (length & 1048575), zzhr.zzfn());
                                zzb((Object) t, i);
                                continue;
                            case 7:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzfo());
                                zzb((Object) t, i);
                                continue;
                            case 8:
                                zza((Object) t, length, zzhr);
                                zzb((Object) t, i);
                                continue;
                            case 9:
                                if (!zza((Object) t, i)) {
                                    zziw.zza((Object) t, (long) (length & 1048575), zzhr.zza(zzau(i), zzfg));
                                    zzb((Object) t, i);
                                    break;
                                }
                                zziw.zza((Object) t, (long) (length & 1048575), zzfv.zza(zziw.zzp(t, (long) (1048575 & length)), zzhr.zza(zzau(i), zzfg)));
                                continue;
                            case 10:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzfq());
                                zzb((Object) t, i);
                                continue;
                            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                zziw.zzb((Object) t, (long) (length & 1048575), zzhr.zzfr());
                                zzb((Object) t, i);
                                continue;
                            case 12:
                                i2 = zzhr.zzfs();
                                zzaw = zzaw(i);
                                if (zzaw != null && !zzaw.zzc(i2)) {
                                    obj = zzhy.zza(zzgg, i2, obj, zziq);
                                    break;
                                }
                                zziw.zzb((Object) t, (long) (length & 1048575), i2);
                                zzb((Object) t, i);
                                continue;
                                break;
                            case 13:
                                zziw.zzb((Object) t, (long) (length & 1048575), zzhr.zzft());
                                zzb((Object) t, i);
                                continue;
                            case 14:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzfu());
                                zzb((Object) t, i);
                                continue;
                            case 15:
                                zziw.zzb((Object) t, (long) (length & 1048575), zzhr.zzfv());
                                zzb((Object) t, i);
                                continue;
                            case 16:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzfw());
                                zzb((Object) t, i);
                                continue;
                            case 17:
                                if (!zza((Object) t, i)) {
                                    zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzb(zzau(i), zzfg));
                                    zzb((Object) t, i);
                                    break;
                                }
                                zziw.zza((Object) t, (long) (length & 1048575), zzfv.zza(zziw.zzp(t, (long) (1048575 & length)), zzhr.zzb(zzau(i), zzfg)));
                                continue;
                            case 18:
                                zzhr.zzd(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                                zzhr.zze(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 20:
                                zzhr.zzg(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 21:
                                zzhr.zzf(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 22:
                                zzhr.zzh(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 23:
                                zzhr.zzi(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 24:
                                zzhr.zzj(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 25:
                                zzhr.zzk(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 26:
                                if (!zzaz(length)) {
                                    zzhr.readStringList(this.zzzy.zza(t, (long) (length & 1048575)));
                                    break;
                                } else {
                                    zzhr.zzl(this.zzzy.zza(t, (long) (length & 1048575)));
                                    continue;
                                }
                            case 27:
                                zzhr.zza(this.zzzy.zza(t, (long) (length & 1048575)), zzau(i), zzfg);
                                continue;
                            case 28:
                                zzhr.zzm(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 29:
                                zzhr.zzn(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 30:
                                zza = this.zzzy.zza(t, (long) (length & 1048575));
                                zzhr.zzo(zza);
                                obj = zzhy.zza(zzgg, zza, zzaw(i), obj, zziq);
                                continue;
                            case 31:
                                zzhr.zzp(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case HTTP.SP /*32*/:
                                zzhr.zzq(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                                zzhr.zzr(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 34:
                                zzhr.zzs(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 35:
                                zzhr.zzd(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 36:
                                zzhr.zze(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case LangUtils.HASH_OFFSET /*37*/:
                                zzhr.zzg(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 38:
                                zzhr.zzf(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 39:
                                zzhr.zzh(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 40:
                                zzhr.zzi(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 41:
                                zzhr.zzj(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 42:
                                zzhr.zzk(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 43:
                                zzhr.zzn(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 44:
                                zza = this.zzzy.zza(t, (long) (length & 1048575));
                                zzhr.zzo(zza);
                                obj = zzhy.zza(zzgg, zza, zzaw(i), obj, zziq);
                                continue;
                            case 45:
                                zzhr.zzp(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 46:
                                zzhr.zzq(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 47:
                                zzhr.zzr(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 48:
                                zzhr.zzs(this.zzzy.zza(t, (long) (length & 1048575)));
                                continue;
                            case 49:
                                long j = (long) (length & 1048575);
                                zzhr.zzb(this.zzzy.zza(t, j), zzau(i), zzfg);
                                continue;
                            case 50:
                                Object zzav = zzav(i);
                                long zzax = (long) (zzax(i) & 1048575);
                                zzp = zziw.zzp(t, zzax);
                                if (zzp == null) {
                                    zzn = this.zzaab.zzn(zzav);
                                    zziw.zza((Object) t, zzax, zzn);
                                } else if (this.zzaab.zzl(zzp)) {
                                    zzn = this.zzaab.zzn(zzav);
                                    this.zzaab.zzb(zzn, zzp);
                                    zziw.zza((Object) t, zzax, zzn);
                                } else {
                                    zzn = zzp;
                                }
                                zzhr.zza(this.zzaab.zzj(zzn), this.zzaab.zzo(zzav), zzfg);
                                continue;
                            case 51:
                                zziw.zza((Object) t, (long) (length & 1048575), Double.valueOf(zzhr.readDouble()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 52:
                                zziw.zza((Object) t, (long) (length & 1048575), Float.valueOf(zzhr.readFloat()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 53:
                                zziw.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzhr.zzfk()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 54:
                                zziw.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzhr.zzfj()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 55:
                                zziw.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzhr.zzfl()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 56:
                                zziw.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzhr.zzfm()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 57:
                                zziw.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzhr.zzfn()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 58:
                                zziw.zza((Object) t, (long) (length & 1048575), Boolean.valueOf(zzhr.zzfo()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 59:
                                zza((Object) t, length, zzhr);
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 60:
                                if (zza((Object) t, zzgg, i)) {
                                    zziw.zza((Object) t, (long) (length & 1048575), zzfv.zza(zziw.zzp(t, (long) (1048575 & length)), zzhr.zza(zzau(i), zzfg)));
                                } else {
                                    zziw.zza((Object) t, (long) (length & 1048575), zzhr.zza(zzau(i), zzfg));
                                    zzb((Object) t, i);
                                }
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 61:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzfq());
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 62:
                                zziw.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzhr.zzfr()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 63:
                                i2 = zzhr.zzfs();
                                zzaw = zzaw(i);
                                if (zzaw != null && !zzaw.zzc(i2)) {
                                    obj = zzhy.zza(zzgg, i2, obj, zziq);
                                    break;
                                }
                                zziw.zza((Object) t, (long) (length & 1048575), Integer.valueOf(i2));
                                zzb((Object) t, zzgg, i);
                                continue;
                                break;
                            case 64:
                                zziw.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzhr.zzft()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 65:
                                zziw.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzhr.zzfu()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 66:
                                zziw.zza((Object) t, (long) (length & 1048575), Integer.valueOf(zzhr.zzfv()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 67:
                                zziw.zza((Object) t, (long) (length & 1048575), Long.valueOf(zzhr.zzfw()));
                                zzb((Object) t, zzgg, i);
                                continue;
                            case 68:
                                zziw.zza((Object) t, (long) (length & 1048575), zzhr.zzb(zzau(i), zzfg));
                                zzb((Object) t, zzgg, i);
                                continue;
                            default:
                                if (obj == null) {
                                    try {
                                        zzn = zziq.zzjo();
                                    } catch (zzgd e) {
                                        break;
                                    }
                                }
                                zzn = obj;
                                try {
                                    if (zziq.zza(zzn, zzhr)) {
                                        obj = zzn;
                                        continue;
                                    } else {
                                        for (i3 = this.zzzv; i3 < this.zzzw; i3++) {
                                            zzn = zza((Object) t, this.zzzu[i3], zzn, zziq);
                                        }
                                        if (zzn != null) {
                                            zziq.zzf(t, zzn);
                                            return;
                                        }
                                        return;
                                    }
                                } catch (zzgd e2) {
                                    obj = zzn;
                                    break;
                                }
                        }
                        try {
                            zziq.zza(zzhr);
                            if (obj == null) {
                                zzn = zziq.zzt(t);
                            } else {
                                zzn = obj;
                            }
                            if (zziq.zza(zzn, zzhr)) {
                                obj = zzn;
                            } else {
                                for (i3 = this.zzzv; i3 < this.zzzw; i3++) {
                                    zzn = zza((Object) t, this.zzzu[i3], zzn, zziq);
                                }
                                if (zzn != null) {
                                    zziq.zzf(t, zzn);
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            zzn = obj;
                        }
                    } else if (zzgg == BaseClientBuilder.API_PRIORITY_OTHER) {
                        for (i3 = this.zzzv; i3 < this.zzzw; i3++) {
                            obj = zza((Object) t, this.zzzu[i3], obj, zziq);
                        }
                        if (obj != null) {
                            zziq.zzf(t, obj);
                            return;
                        }
                        return;
                    } else {
                        if (this.zzzq) {
                            zzp = zzfh.zza(zzfg, this.zzzp, zzgg);
                        } else {
                            zzp = null;
                        }
                        if (zzp != null) {
                            if (zzfk == null) {
                                zzfk = zzfh.zze(t);
                            }
                            obj = zzfh.zza(zzhr, zzp, zzfg, zzfk, obj, zziq);
                        } else {
                            zziq.zza(zzhr);
                            if (obj == null) {
                                zzn = zziq.zzt(t);
                            } else {
                                zzn = obj;
                            }
                            try {
                                if (zziq.zza(zzn, zzhr)) {
                                    obj = zzn;
                                } else {
                                    for (i3 = this.zzzv; i3 < this.zzzw; i3++) {
                                        zzn = zza((Object) t, this.zzzu[i3], zzn, zziq);
                                    }
                                    if (zzn != null) {
                                        zziq.zzf(t, zzn);
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
                for (i3 = this.zzzv; i3 < this.zzzw; i3++) {
                    zzn = zza((Object) t, this.zzzu[i3], zzn, zziq);
                }
                if (zzn != null) {
                    zziq.zzf(t, zzn);
                }
                throw th;
            }

            private final zzhw zzau(int i) {
                int i2 = (i / 3) << 1;
                zzhw zzhw = (zzhw) this.zzzm[i2];
                if (zzhw != null) {
                    return zzhw;
                }
                zzhw = zzho.zziu().zzf((Class) this.zzzm[i2 + 1]);
                this.zzzm[i2] = zzhw;
                return zzhw;
            }

            private final Object zzav(int i) {
                return this.zzzm[(i / 3) << 1];
            }

            private final zzfy zzaw(int i) {
                return (zzfy) this.zzzm[((i / 3) << 1) + 1];
            }

            public final void zzf(T t) {
                int i;
                for (i = this.zzzv; i < this.zzzw; i++) {
                    long zzax = (long) (zzax(this.zzzu[i]) & 1048575);
                    Object zzp = zziw.zzp(t, zzax);
                    if (zzp != null) {
                        zziw.zza((Object) t, zzax, this.zzaab.zzm(zzp));
                    }
                }
                int length = this.zzzu.length;
                for (i = this.zzzw; i < length; i++) {
                    this.zzzy.zzb(t, (long) this.zzzu[i]);
                }
                this.zzzz.zzf(t);
                if (this.zzzq) {
                    this.zzaaa.zzf((Object) t);
                }
            }

            private final <UT, UB> UB zza(Object obj, int i, UB ub, zziq<UT, UB> zziq) {
                int i2 = this.zzzl[i];
                Object zzp = zziw.zzp(obj, (long) (zzax(i) & 1048575));
                if (zzp == null) {
                    return ub;
                }
                zzfy zzaw = zzaw(i);
                if (zzaw == null) {
                    return ub;
                }
                return zza(i, i2, this.zzaab.zzj(zzp), zzaw, ub, zziq);
            }

            private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfy zzfy, UB ub, zziq<UT, UB> zziq) {
                zzgv zzo = this.zzaab.zzo(zzav(i));
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!zzfy.zzc(((Integer) entry.getValue()).intValue())) {
                        if (ub == null) {
                            ub = zziq.zzjo();
                        }
                        zzep zzm = zzeh.zzm(zzgu.zza(zzo, entry.getKey(), entry.getValue()));
                        try {
                            zzgu.zza(zzm.zzfh(), zzo, entry.getKey(), entry.getValue());
                            zziq.zza((Object) ub, i2, zzm.zzfg());
                            it.remove();
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                return ub;
            }

            public final boolean zzq(T t) {
                int i = 0;
                int i2 = -1;
                for (int i3 = 0; i3 < this.zzzv; i3++) {
                    int i4;
                    int i5;
                    int i6 = this.zzzu[i3];
                    int i7 = this.zzzl[i6];
                    int zzax = zzax(i6);
                    if (this.zzzs) {
                        i4 = 0;
                    } else {
                        i5 = this.zzzl[i6 + 2];
                        int i8 = i5 & 1048575;
                        i5 = 1 << (i5 >>> 20);
                        if (i8 != i2) {
                            i = zzzk.getInt(t, (long) i8);
                            i4 = i5;
                            i2 = i8;
                        } else {
                            i4 = i5;
                        }
                    }
                    if ((268435456 & zzax) != 0) {
                        i5 = 1;
                    } else {
                        boolean z = false;
                    }
                    if (i5 != 0 && !zza((Object) t, i6, i, i4)) {
                        return false;
                    }
                    switch ((267386880 & zzax) >>> 20) {
                        case 9:
                        case 17:
                            if (zza((Object) t, i6, i, i4) && !zza((Object) t, zzax, zzau(i6))) {
                                return false;
                            }
                        case 27:
                        case 49:
                            List list = (List) zziw.zzp(t, (long) (zzax & 1048575));
                            if (!list.isEmpty()) {
                                zzhw zzau = zzau(i6);
                                for (i4 = 0; i4 < list.size(); i4++) {
                                    if (!zzau.zzq(list.get(i4))) {
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
                            Map zzk = this.zzaab.zzk(zziw.zzp(t, (long) (zzax & 1048575)));
                            if (!zzk.isEmpty()) {
                                if (this.zzaab.zzo(zzav(i6)).zzze.zzjy() == zzjk.MESSAGE) {
                                    zzhw zzhw = null;
                                    for (Object next : zzk.values()) {
                                        if (zzhw == null) {
                                            zzhw = zzho.zziu().zzf(next.getClass());
                                        }
                                        if (!zzhw.zzq(next)) {
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
                            if (zza((Object) t, i7, i6) && !zza((Object) t, zzax, zzau(i6))) {
                                return false;
                            }
                        default:
                            break;
                    }
                }
                if (!this.zzzq || this.zzaaa.zzd(t).isInitialized()) {
                    return true;
                }
                return false;
            }

            private static boolean zza(Object obj, int i, zzhw zzhw) {
                return zzhw.zzq(zziw.zzp(obj, (long) (1048575 & i)));
            }

            private static void zza(int i, Object obj, zzjl zzjl) {
                if (obj instanceof String) {
                    zzjl.zza(i, (String) obj);
                } else {
                    zzjl.zza(i, (zzeh) obj);
                }
            }

            private final void zza(Object obj, int i, zzhr zzhr) {
                if (zzaz(i)) {
                    zziw.zza(obj, (long) (i & 1048575), zzhr.zzfp());
                } else if (this.zzzr) {
                    zziw.zza(obj, (long) (i & 1048575), zzhr.readString());
                } else {
                    zziw.zza(obj, (long) (i & 1048575), zzhr.zzfq());
                }
            }

            private final int zzax(int i) {
                return this.zzzl[i + 1];
            }

            private final int zzay(int i) {
                return this.zzzl[i + 2];
            }

            private static boolean zzaz(int i) {
                return (536870912 & i) != 0;
            }

            private static <T> double zzf(T t, long j) {
                return ((Double) zziw.zzp(t, j)).doubleValue();
            }

            private static <T> float zzg(T t, long j) {
                return ((Float) zziw.zzp(t, j)).floatValue();
            }

            private static <T> int zzh(T t, long j) {
                return ((Integer) zziw.zzp(t, j)).intValue();
            }

            private static <T> long zzi(T t, long j) {
                return ((Long) zziw.zzp(t, j)).longValue();
            }

            private static <T> boolean zzj(T t, long j) {
                return ((Boolean) zziw.zzp(t, j)).booleanValue();
            }

            private final boolean zzc(T t, T t2, int i) {
                return zza((Object) t, i) == zza((Object) t2, i);
            }

            private final boolean zza(T t, int i, int i2, int i3) {
                if (this.zzzs) {
                    return zza((Object) t, i);
                }
                return (i2 & i3) != 0;
            }

            private final boolean zza(T t, int i) {
                if (this.zzzs) {
                    int zzax;
                    zzax = zzax(i);
                    long j = (long) (zzax & 1048575);
                    switch ((zzax & 267386880) >>> 20) {
                        case 0:
                            if (zziw.zzo(t, j) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                return true;
                            }
                            return false;
                        case 1:
                            return zziw.zzn(t, j) != 0.0f;
                        case 2:
                            return zziw.zzl(t, j) != 0;
                        case 3:
                            return zziw.zzl(t, j) != 0;
                        case 4:
                            return zziw.zzk(t, j) != 0;
                        case 5:
                            return zziw.zzl(t, j) != 0;
                        case 6:
                            return zziw.zzk(t, j) != 0;
                        case 7:
                            return zziw.zzm(t, j);
                        case 8:
                            Object zzp = zziw.zzp(t, j);
                            if (zzp instanceof String) {
                                return !((String) zzp).isEmpty();
                            } else {
                                if (zzp instanceof zzeh) {
                                    return !zzeh.zzso.equals(zzp);
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        case 9:
                            return zziw.zzp(t, j) != null;
                        case 10:
                            return !zzeh.zzso.equals(zziw.zzp(t, j));
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            return zziw.zzk(t, j) != 0;
                        case 12:
                            return zziw.zzk(t, j) != 0;
                        case 13:
                            return zziw.zzk(t, j) != 0;
                        case 14:
                            return zziw.zzl(t, j) != 0;
                        case 15:
                            return zziw.zzk(t, j) != 0;
                        case 16:
                            return zziw.zzl(t, j) != 0;
                        case 17:
                            return zziw.zzp(t, j) != null;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
                zzax = zzay(i);
                return (zziw.zzk(t, (long) (zzax & 1048575)) & (1 << (zzax >>> 20))) != 0;
            }

            private final void zzb(T t, int i) {
                if (!this.zzzs) {
                    int zzay = zzay(i);
                    long j = (long) (zzay & 1048575);
                    zziw.zzb((Object) t, j, zziw.zzk(t, j) | (1 << (zzay >>> 20)));
                }
            }

            private final boolean zza(T t, int i, int i2) {
                return zziw.zzk(t, (long) (zzay(i2) & 1048575)) == i;
            }

            private final void zzb(T t, int i, int i2) {
                zziw.zzb((Object) t, (long) (zzay(i2) & 1048575), i);
            }
        }
