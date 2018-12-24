package com.google.android.gms.dependencies;

import org.apache.http.cookie.ClientCookie;
import p000a.p003c.p005b.C0024c;
import p000a.p009g.C0058m;
import p000a.p009g.C0059n;

public final class VersionEvaluators {
    public static final VersionEvaluators INSTANCE = new VersionEvaluators();

    public static final class AlwaysCompatibleEvaluator implements VersionEvaluator {
        public boolean isCompatible(String str) {
            C0024c.m22b(str, ClientCookie.VERSION_ATTR);
            return true;
        }
    }

    public static final class ExactVersionEvaluator implements VersionEvaluator {
        private String versionString;

        public ExactVersionEvaluator(String str) {
            C0024c.m22b(str, "versionString");
            this.versionString = str;
        }

        public final String getVersionString$strict_version_matcher_plugin() {
            return this.versionString;
        }

        public final void setVersionString$strict_version_matcher_plugin(String str) {
            C0024c.m22b(str, "<set-?>");
            this.versionString = str;
        }

        public boolean isCompatible(String str) {
            C0024c.m22b(str, ClientCookie.VERSION_ATTR);
            return C0024c.m21a((Object) str, this.versionString);
        }
    }

    public static final class SemVerVersionEvaluator implements VersionEvaluator {
        private SemVerInfo versionInfo;

        public SemVerVersionEvaluator(String str) {
            C0024c.m22b(str, "versionString");
            this.versionInfo = SemVerInfo.Companion.parseString(str);
        }

        public final SemVerInfo getVersionInfo$strict_version_matcher_plugin() {
            return this.versionInfo;
        }

        public final void setVersionInfo$strict_version_matcher_plugin(SemVerInfo semVerInfo) {
            C0024c.m22b(semVerInfo, "<set-?>");
            this.versionInfo = semVerInfo;
        }

        public boolean isCompatible(String str) {
            C0024c.m22b(str, ClientCookie.VERSION_ATTR);
            SemVerInfo parseString = SemVerInfo.Companion.parseString(str);
            return parseString.component1() == this.versionInfo.getMajor() && parseString.component2() >= this.versionInfo.getMinor();
        }
    }

    private VersionEvaluators() {
    }

    public final VersionEvaluator getEvaluator(String str, boolean z) {
        C0024c.m22b(str, "versionString");
        boolean z2;
        if (C0059n.m61a((CharSequence) str, ",", 0, false, 6, null) > 0 || C0059n.m61a((CharSequence) str, ")", 0, false, 6, null) > 0 || C0059n.m61a((CharSequence) str, "(", 0, false, 6, null) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (C0058m.m55a(str, "[", false, 2, null) && C0058m.m57b(str, "]", false, 2, null)) {
            Object substring = str.substring(1, str.length() - 1);
            C0024c.m19a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return new ExactVersionEvaluator(substring);
        }
        AlwaysCompatibleEvaluator alwaysCompatibleEvaluator;
        if (!z || r0) {
            alwaysCompatibleEvaluator = new AlwaysCompatibleEvaluator();
        } else {
            alwaysCompatibleEvaluator = new AlwaysCompatibleEvaluator();
        }
        return alwaysCompatibleEvaluator;
    }
}
