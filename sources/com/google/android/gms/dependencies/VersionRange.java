package com.google.android.gms.dependencies;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p003c.p005b.C0024c;
import p000a.p009g.C0059n;

public final class VersionRange {
    public static final Companion Companion = new Companion();
    private static final Pattern VERSION_RANGE_PATTERN = Pattern.compile("\\[(\\d+\\.)*(\\d+)+(-\\w)*\\]");
    private final boolean closedEnd;
    private final boolean closedStart;
    private final Version rangeEnd;
    private final Version rangeStart;

    public static final class Companion {
        private Companion() {
        }

        public final int versionCompare(String str, String str2) {
            int i = 0;
            C0024c.m22b(str, "str1");
            C0024c.m22b(str2, "str2");
            List a = C0059n.m69a((CharSequence) str, new String[]{"\\."}, false, 0, 6, null);
            List a2 = C0059n.m69a((CharSequence) str2, new String[]{"\\."}, false, 0, 6, null);
            while (i < a.size() && i < a2.size() && C0024c.m21a((String) a.get(i), (String) a2.get(i))) {
                i++;
            }
            if (i >= a.size() || i >= a2.size()) {
                return Integer.signum(a.size() - a2.size());
            }
            Object valueOf = Integer.valueOf((String) a.get(i));
            C0024c.m19a(valueOf, "Integer.valueOf(vals1[i])");
            int intValue = valueOf.intValue();
            valueOf = Integer.valueOf((String) a2.get(i));
            C0024c.m19a(valueOf, "Integer.valueOf(vals2[i])");
            return Integer.signum(Integer.compare(intValue, valueOf.intValue()));
        }

        public final Pattern getVERSION_RANGE_PATTERN() {
            return VersionRange.VERSION_RANGE_PATTERN;
        }

        public final VersionRange fromString(String str) {
            C0024c.m22b(str, "versionRange");
            Matcher matcher = getVERSION_RANGE_PATTERN().matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            Version fromString = Version.Companion.fromString(matcher.group(1));
            if (fromString != null) {
                return new VersionRange(true, true, fromString, fromString);
            }
            return null;
        }
    }

    public static /* synthetic */ VersionRange copy$default(VersionRange versionRange, boolean z, boolean z2, Version version, Version version2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = versionRange.closedStart;
        }
        if ((i & 2) != 0) {
            z2 = versionRange.closedEnd;
        }
        if ((i & 4) != 0) {
            version = versionRange.rangeStart;
        }
        if ((i & 8) != 0) {
            version2 = versionRange.rangeEnd;
        }
        return versionRange.copy(z, z2, version, version2);
    }

    public final boolean component1() {
        return this.closedStart;
    }

    public final boolean component2() {
        return this.closedEnd;
    }

    public final Version component3() {
        return this.rangeStart;
    }

    public final Version component4() {
        return this.rangeEnd;
    }

    public final VersionRange copy(boolean z, boolean z2, Version version, Version version2) {
        C0024c.m22b(version, "rangeStart");
        C0024c.m22b(version2, "rangeEnd");
        return new VersionRange(z, z2, version, version2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof VersionRange)) {
                return false;
            }
            VersionRange versionRange = (VersionRange) obj;
            if (!(this.closedStart == versionRange.closedStart)) {
                return false;
            }
            if (!((this.closedEnd == versionRange.closedEnd) && C0024c.m21a(this.rangeStart, versionRange.rangeStart) && C0024c.m21a(this.rangeEnd, versionRange.rangeEnd))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        int i3 = this.closedStart;
        if (i3 != 0) {
            i3 = 1;
        }
        int i4 = i3 * 31;
        boolean z = this.closedEnd;
        if (!z) {
            boolean z2 = z;
        }
        i = (i4 + i) * 31;
        Version version = this.rangeStart;
        i3 = ((version != null ? version.hashCode() : 0) + i) * 31;
        Version version2 = this.rangeEnd;
        if (version2 != null) {
            i2 = version2.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        return "VersionRange(closedStart=" + this.closedStart + ", closedEnd=" + this.closedEnd + ", rangeStart=" + this.rangeStart + ", rangeEnd=" + this.rangeEnd + ")";
    }

    public VersionRange(boolean z, boolean z2, Version version, Version version2) {
        C0024c.m22b(version, "rangeStart");
        C0024c.m22b(version2, "rangeEnd");
        this.closedStart = z;
        this.closedEnd = z2;
        this.rangeStart = version;
        this.rangeEnd = version2;
    }

    public final boolean getClosedEnd() {
        return this.closedEnd;
    }

    public final boolean getClosedStart() {
        return this.closedStart;
    }

    public final Version getRangeEnd() {
        return this.rangeEnd;
    }

    public final Version getRangeStart() {
        return this.rangeStart;
    }

    public final String toVersionString() {
        return (this.closedStart ? "[" : "(") + this.rangeStart.getTrimmedString() + "," + this.rangeEnd.getTrimmedString() + (this.closedEnd ? "]" : ")");
    }

    public final boolean versionInRange(Version version) {
        C0024c.m22b(version, "compareTo");
        if (this.closedStart) {
            if (Companion.versionCompare(this.rangeStart.getTrimmedString(), version.getTrimmedString()) > 0) {
                return false;
            }
        } else if (Companion.versionCompare(this.rangeStart.getTrimmedString(), version.getTrimmedString()) >= 0) {
            return false;
        }
        if (this.closedEnd) {
            if (Companion.versionCompare(this.rangeEnd.getTrimmedString(), version.getTrimmedString()) < 0) {
                return false;
            }
        } else if (Companion.versionCompare(this.rangeEnd.getTrimmedString(), version.getTrimmedString()) <= 0) {
            return false;
        }
        return true;
    }
}
