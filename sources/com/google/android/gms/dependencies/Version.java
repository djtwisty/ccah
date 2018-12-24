package com.google.android.gms.dependencies;

import p000a.p003c.p005b.C0024c;
import p000a.p009g.C0059n;

public final class Version {
    public static final Companion Companion = new Companion();
    private final String rawString;
    private final String trimmedString;

    public static final class Companion {
        private Companion() {
        }

        public final Version fromString(String str) {
            if (str == null) {
                return null;
            }
            return new Version(str, (String) C0059n.m69a((CharSequence) str, new String[]{"-"}, false, 0, 6, null).get(0));
        }
    }

    public static /* synthetic */ Version copy$default(Version version, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = version.rawString;
        }
        if ((i & 2) != 0) {
            str2 = version.trimmedString;
        }
        return version.copy(str, str2);
    }

    public final String component1() {
        return this.rawString;
    }

    public final String component2() {
        return this.trimmedString;
    }

    public final Version copy(String str, String str2) {
        C0024c.m22b(str, "rawString");
        C0024c.m22b(str2, "trimmedString");
        return new Version(str, str2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001c;
    L_0x0002:
        r0 = r3 instanceof com.google.android.gms.dependencies.Version;
        if (r0 == 0) goto L_0x001e;
    L_0x0006:
        r3 = (com.google.android.gms.dependencies.Version) r3;
        r0 = r2.rawString;
        r1 = r3.rawString;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x0012:
        r0 = r2.trimmedString;
        r1 = r3.trimmedString;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x001c:
        r0 = 1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = 0;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dependencies.Version.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        String str = this.rawString;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.trimmedString;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Version(rawString=" + this.rawString + ", trimmedString=" + this.trimmedString + ")";
    }

    public Version(String str, String str2) {
        C0024c.m22b(str, "rawString");
        C0024c.m22b(str2, "trimmedString");
        this.rawString = str;
        this.trimmedString = str2;
    }

    public final String getRawString() {
        return this.rawString;
    }

    public final String getTrimmedString() {
        return this.trimmedString;
    }
}
