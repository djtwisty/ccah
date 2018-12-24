package com.google.android.gms.dependencies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import org.gradle.internal.impldep.com.google.common.annotations.VisibleForTesting;
import p000a.p003c.p005b.C0024c;

public final class ArtifactDependencyManager {
    private final HashMap<Artifact, ArrayList<Dependency>> dependencies = new HashMap();
    private final Object dependencyLock = new Object();

    @VisibleForTesting
    public static /* synthetic */ void dependencies$annotations() {
    }

    public final HashMap<Artifact, ArrayList<Dependency>> getDependencies$strict_version_matcher_plugin() {
        return this.dependencies;
    }

    public final void addDependency(Dependency dependency) {
        C0024c.m22b(dependency, "dependency");
        synchronized (this.dependencyLock) {
            ArrayList arrayList = (ArrayList) this.dependencies.get(dependency.getToArtifact());
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                this.dependencies.put(dependency.getToArtifact(), arrayList2);
                arrayList = arrayList2;
            }
            arrayList.add(dependency);
        }
    }

    public final Collection<Dependency> getDependencies(Artifact artifact) {
        Collection<Dependency> hashSet;
        C0024c.m22b(artifact, "artifact");
        synchronized (this.dependencyLock) {
            if (this.dependencies.get(artifact) == null) {
                hashSet = new HashSet();
            } else {
                hashSet = new HashSet((Collection) this.dependencies.get(artifact));
            }
        }
        return hashSet;
    }
}
