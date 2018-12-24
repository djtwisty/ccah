package com.google.android.gms.dependencies;

import java.util.List;
import p000a.p003c.p005b.C0024c;
import p000a.p009g.C0059n;

public final class Artifact {
    public static final Companion Companion = new Companion();
    private final String artifactId;
    private final String groupId;

    public static final class Companion {
        private Companion() {
        }

        public final Artifact fromGradleRef(String str) {
            C0024c.m22b(str, "referenceString");
            List a = C0059n.m69a((CharSequence) str, new String[]{":"}, false, 0, 6, null);
            if (a.size() >= 2) {
                return new Artifact((String) a.get(0), (String) a.get(1));
            }
            throw new IllegalArgumentException("Invalid Gradle reference string: " + str);
        }
    }

    public static /* synthetic */ Artifact copy$default(Artifact artifact, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = artifact.groupId;
        }
        if ((i & 2) != 0) {
            str2 = artifact.artifactId;
        }
        return artifact.copy(str, str2);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.artifactId;
    }

    public final Artifact copy(String str, String str2) {
        C0024c.m22b(str, "groupId");
        C0024c.m22b(str2, "artifactId");
        return new Artifact(str, str2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001c;
    L_0x0002:
        r0 = r3 instanceof com.google.android.gms.dependencies.Artifact;
        if (r0 == 0) goto L_0x001e;
    L_0x0006:
        r3 = (com.google.android.gms.dependencies.Artifact) r3;
        r0 = r2.groupId;
        r1 = r3.groupId;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x0012:
        r0 = r2.artifactId;
        r1 = r3.artifactId;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dependencies.Artifact.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        String str = this.groupId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.artifactId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Artifact(groupId=" + this.groupId + ", artifactId=" + this.artifactId + ")";
    }

    public Artifact(String str, String str2) {
        C0024c.m22b(str, "groupId");
        C0024c.m22b(str2, "artifactId");
        this.groupId = str;
        this.artifactId = str2;
    }

    public final String getArtifactId() {
        return this.artifactId;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGradleRef() {
        return this.groupId + ':' + this.artifactId;
    }
}
