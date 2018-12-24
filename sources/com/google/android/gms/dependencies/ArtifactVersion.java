package com.google.android.gms.dependencies;

import java.util.List;
import org.apache.http.cookie.ClientCookie;
import p000a.p003c.p005b.C0024c;
import p000a.p009g.C0059n;

public final class ArtifactVersion {
    public static final Companion Companion = new Companion();
    private final String artifactId;
    private final String groupId;
    private final String version;

    public static final class Companion {
        private Companion() {
        }

        public final ArtifactVersion fromGradleRef(String str) {
            C0024c.m22b(str, "referenceString");
            List a = C0059n.m69a((CharSequence) str, new String[]{":"}, false, 0, 6, null);
            if (a.size() >= 3) {
                return new ArtifactVersion((String) a.get(0), (String) a.get(1), (String) a.get(2));
            }
            throw new IllegalArgumentException("Invalid Gradle reference string: " + str);
        }

        public final ArtifactVersion fromGradleRefOrNull(String str) {
            C0024c.m22b(str, "referenceString");
            List a = C0059n.m69a((CharSequence) str, new String[]{":"}, false, 0, 6, null);
            if (a.size() < 3) {
                return null;
            }
            return new ArtifactVersion((String) a.get(0), (String) a.get(1), (String) a.get(2));
        }
    }

    public static /* synthetic */ ArtifactVersion copy$default(ArtifactVersion artifactVersion, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = artifactVersion.groupId;
        }
        if ((i & 2) != 0) {
            str2 = artifactVersion.artifactId;
        }
        if ((i & 4) != 0) {
            str3 = artifactVersion.version;
        }
        return artifactVersion.copy(str, str2, str3);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.artifactId;
    }

    public final String component3() {
        return this.version;
    }

    public final ArtifactVersion copy(String str, String str2, String str3) {
        C0024c.m22b(str, "groupId");
        C0024c.m22b(str2, "artifactId");
        C0024c.m22b(str3, ClientCookie.VERSION_ATTR);
        return new ArtifactVersion(str, str2, str3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0026;
    L_0x0002:
        r0 = r3 instanceof com.google.android.gms.dependencies.ArtifactVersion;
        if (r0 == 0) goto L_0x0028;
    L_0x0006:
        r3 = (com.google.android.gms.dependencies.ArtifactVersion) r3;
        r0 = r2.groupId;
        r1 = r3.groupId;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x0028;
    L_0x0012:
        r0 = r2.artifactId;
        r1 = r3.artifactId;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x0028;
    L_0x001c:
        r0 = r2.version;
        r1 = r3.version;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x0028;
    L_0x0026:
        r0 = 1;
    L_0x0027:
        return r0;
    L_0x0028:
        r0 = 0;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dependencies.ArtifactVersion.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        String str = this.groupId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        str = this.artifactId;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        String str2 = this.version;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ArtifactVersion(groupId=" + this.groupId + ", artifactId=" + this.artifactId + ", version=" + this.version + ")";
    }

    public ArtifactVersion(String str, String str2, String str3) {
        C0024c.m22b(str, "groupId");
        C0024c.m22b(str2, "artifactId");
        C0024c.m22b(str3, ClientCookie.VERSION_ATTR);
        this.groupId = str;
        this.artifactId = str2;
        this.version = str3;
    }

    public final String getArtifactId() {
        return this.artifactId;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Artifact getArtifact() {
        return new Artifact(this.groupId, this.artifactId);
    }

    public final String getGradleRef() {
        return this.groupId + ':' + this.artifactId + ':' + this.version;
    }
}
