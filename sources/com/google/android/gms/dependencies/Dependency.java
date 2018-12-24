package com.google.android.gms.dependencies;

import com.google.gms.googleservices.GoogleServicesPlugin;
import java.util.logging.Logger;
import p000a.p003c.p005b.C0024c;

public final class Dependency {
    public static final Companion Companion = new Companion();
    private final ArtifactVersion fromArtifactVersion;
    private final Logger logger;
    private final Artifact toArtifact;
    private final String toArtifactVersionString;
    private final VersionEvaluator versionEvaluator;

    public static final class Companion {
        private Companion() {
        }

        public final Dependency fromArtifactVersions(ArtifactVersion artifactVersion, ArtifactVersion artifactVersion2) {
            C0024c.m22b(artifactVersion, "fromArtifactVersion");
            C0024c.m22b(artifactVersion2, "toArtifactVersion");
            return new Dependency(artifactVersion, artifactVersion2.getArtifact(), artifactVersion2.getVersion());
        }
    }

    public static /* synthetic */ Dependency copy$default(Dependency dependency, ArtifactVersion artifactVersion, Artifact artifact, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            artifactVersion = dependency.fromArtifactVersion;
        }
        if ((i & 2) != 0) {
            artifact = dependency.toArtifact;
        }
        if ((i & 4) != 0) {
            str = dependency.toArtifactVersionString;
        }
        return dependency.copy(artifactVersion, artifact, str);
    }

    public final ArtifactVersion component1() {
        return this.fromArtifactVersion;
    }

    public final Artifact component2() {
        return this.toArtifact;
    }

    public final String component3() {
        return this.toArtifactVersionString;
    }

    public final Dependency copy(ArtifactVersion artifactVersion, Artifact artifact, String str) {
        C0024c.m22b(artifactVersion, "fromArtifactVersion");
        C0024c.m22b(artifact, "toArtifact");
        C0024c.m22b(str, "toArtifactVersionString");
        return new Dependency(artifactVersion, artifact, str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x0026;
    L_0x0002:
        r0 = r3 instanceof com.google.android.gms.dependencies.Dependency;
        if (r0 == 0) goto L_0x0028;
    L_0x0006:
        r3 = (com.google.android.gms.dependencies.Dependency) r3;
        r0 = r2.fromArtifactVersion;
        r1 = r3.fromArtifactVersion;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x0028;
    L_0x0012:
        r0 = r2.toArtifact;
        r1 = r3.toArtifact;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x0028;
    L_0x001c:
        r0 = r2.toArtifactVersionString;
        r1 = r3.toArtifactVersionString;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dependencies.Dependency.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        ArtifactVersion artifactVersion = this.fromArtifactVersion;
        int hashCode = (artifactVersion != null ? artifactVersion.hashCode() : 0) * 31;
        Artifact artifact = this.toArtifact;
        int hashCode2 = ((artifact != null ? artifact.hashCode() : 0) + hashCode) * 31;
        String str = this.toArtifactVersionString;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Dependency(fromArtifactVersion=" + this.fromArtifactVersion + ", toArtifact=" + this.toArtifact + ", toArtifactVersionString=" + this.toArtifactVersionString + ")";
    }

    public Dependency(ArtifactVersion artifactVersion, Artifact artifact, String str) {
        C0024c.m22b(artifactVersion, "fromArtifactVersion");
        C0024c.m22b(artifact, "toArtifact");
        C0024c.m22b(str, "toArtifactVersionString");
        this.fromArtifactVersion = artifactVersion;
        this.toArtifact = artifact;
        this.toArtifactVersionString = str;
        Object logger = Logger.getLogger("Dependency");
        C0024c.m19a(logger, "Logger.getLogger(\"Dependency\")");
        this.logger = logger;
        boolean z = this.toArtifact.getGroupId().equals("com.google.android.gms") || this.toArtifact.getGroupId().equals(GoogleServicesPlugin.MODULE_GROUP_FIREBASE);
        this.versionEvaluator = VersionEvaluators.INSTANCE.getEvaluator(this.toArtifactVersionString, z);
    }

    public final ArtifactVersion getFromArtifactVersion() {
        return this.fromArtifactVersion;
    }

    public final Artifact getToArtifact() {
        return this.toArtifact;
    }

    public final String getToArtifactVersionString() {
        return this.toArtifactVersionString;
    }

    public final boolean isVersionCompatible(String str) {
        C0024c.m22b(str, "versionString");
        if (this.versionEvaluator.isCompatible(str)) {
            return true;
        }
        this.logger.fine("Failed comparing " + this.toArtifactVersionString + " with" + ' ' + str + " using " + this.versionEvaluator.getClass());
        return false;
    }

    public final String getDisplayString() {
        return this.fromArtifactVersion.getGradleRef() + " -> " + this.toArtifact.getGradleRef() + "@" + this.toArtifactVersionString;
    }
}
