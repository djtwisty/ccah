package com.google.android.gms.dependencies;

import java.util.List;
import p000a.C0028c;
import p000a.p003c.p005b.C0024c;
import p000a.p009g.C0059n;

public final class SemVerInfo {
    public static final Companion Companion = new Companion();
    private final int major;
    private final int minor;
    private final int patch;

    public static final class Companion {
        private Companion() {
        }

        public final SemVerInfo parseString(String str) {
            C0024c.m22b(str, "versionString");
            List a = C0059n.m69a((CharSequence) C0059n.m65a(str).toString(), new String[]{"."}, false, 0, 6, null);
            if (a.size() != 3) {
                throw new IllegalArgumentException("Version string didn't have 3 parts divided by periods: " + str);
            }
            Object valueOf = Integer.valueOf((String) a.get(0));
            Object valueOf2 = Integer.valueOf((String) a.get(1));
            String str2 = (String) a.get(2);
            int a2 = C0059n.m61a((CharSequence) str2, "-", 0, false, 6, null);
            if (a2 != -1) {
                if (str2 == null) {
                    throw new C0028c("null cannot be cast to non-null type java.lang.String");
                }
                str2 = str2.substring(0, a2);
                C0024c.m19a((Object) str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            Object valueOf3 = Integer.valueOf(str2);
            C0024c.m19a(valueOf, "major");
            int intValue = valueOf.intValue();
            C0024c.m19a(valueOf2, "minor");
            int intValue2 = valueOf2.intValue();
            C0024c.m19a(valueOf3, "patch");
            return new SemVerInfo(intValue, intValue2, valueOf3.intValue());
        }
    }

    public static /* synthetic */ SemVerInfo copy$default(SemVerInfo semVerInfo, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = semVerInfo.major;
        }
        if ((i4 & 2) != 0) {
            i2 = semVerInfo.minor;
        }
        if ((i4 & 4) != 0) {
            i3 = semVerInfo.patch;
        }
        return semVerInfo.copy(i, i2, i3);
    }

    public final int component1() {
        return this.major;
    }

    public final int component2() {
        return this.minor;
    }

    public final int component3() {
        return this.patch;
    }

    public final SemVerInfo copy(int i, int i2, int i3) {
        return new SemVerInfo(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof SemVerInfo)) {
                return false;
            }
            SemVerInfo semVerInfo = (SemVerInfo) obj;
            if (!(this.major == semVerInfo.major)) {
                return false;
            }
            if (!(this.minor == semVerInfo.minor)) {
                return false;
            }
            if (!(this.patch == semVerInfo.patch)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.major) * 31) + Integer.hashCode(this.minor)) * 31) + Integer.hashCode(this.patch);
    }

    public String toString() {
        return "SemVerInfo(major=" + this.major + ", minor=" + this.minor + ", patch=" + this.patch + ")";
    }

    public SemVerInfo(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }
}
