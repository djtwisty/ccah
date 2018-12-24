package com.google.android.gms.dependencies;

import com.google.gms.googleservices.GoogleServicesPlugin;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.gradle.api.GradleException;
import org.gradle.api.artifacts.DependencyResolutionListener;
import org.gradle.api.artifacts.ResolvableDependencies;
import org.gradle.api.artifacts.result.DependencyResult;
import org.gradle.api.artifacts.result.ResolutionResult;
import org.gradle.api.artifacts.result.ResolvedComponentResult;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;

public class DependencyInspector implements DependencyResolutionListener {
    private static final String GRADLE_PROJECT = "gradle.project";
    private static Logger logger = Logging.getLogger(DependencyInspector.class);
    private final DependencyAnalyzer dependencyAnalyzer;
    private final String exceptionMessageAddendum;
    private final String projectName;

    public DependencyInspector(DependencyAnalyzer dependencyAnalyzer, String str, String str2) {
        this.dependencyAnalyzer = dependencyAnalyzer;
        this.exceptionMessageAddendum = str2;
        this.projectName = str;
    }

    private static String simplifyKnownGroupIds(String str) {
        return str.replace("com.google.android.gms", "c.g.a.g").replace(GoogleServicesPlugin.MODULE_GROUP_FIREBASE, "c.g.f");
    }

    private static void printNode(int i, Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("--");
        }
        stringBuilder.append(" ");
        Dependency dependency = node.getDependency();
        String replace;
        if (GRADLE_PROJECT.equals(node.getDependency().getFromArtifactVersion().getGroupId())) {
            replace = dependency.getFromArtifactVersion().getGradleRef().replace(GRADLE_PROJECT, "");
            logger.info(stringBuilder.toString() + replace + " task/module dep -> " + simplifyKnownGroupIds(dependency.getToArtifact().getGradleRef()) + "@" + dependency.getToArtifactVersionString());
        } else {
            replace = simplifyKnownGroupIds(dependency.getFromArtifactVersion().getGradleRef());
            logger.info(stringBuilder.toString() + replace + " library depends -> " + simplifyKnownGroupIds(dependency.getToArtifact().getGradleRef()) + "@" + dependency.getToArtifactVersionString());
        }
        if (node.getChild() != null) {
            printNode(i + 1, node.getChild());
        }
    }

    private void registerDependencies(ResolvableDependencies resolvableDependencies, String str, String str2) {
        for (DependencyResult dependencyResult : resolvableDependencies.getResolutionResult().getAllDependencies()) {
            ArtifactVersion fromGradleRef;
            if (dependencyResult.getFrom() == null || "".equals(dependencyResult.getFrom().getId().getDisplayName())) {
                fromGradleRef = ArtifactVersion.Companion.fromGradleRef("gradle.project:" + str + "-" + str2 + ":0.0.0");
            } else {
                String str3 = "" + dependencyResult.getFrom().getId().getDisplayName();
                if (str3.startsWith("project ")) {
                    fromGradleRef = ArtifactVersion.Companion.fromGradleRef("gradle.project:" + str + "-" + str2 + "-" + str3.split(":")[1] + ":0.0.0");
                } else {
                    try {
                        fromGradleRef = ArtifactVersion.Companion.fromGradleRef(str3);
                    } catch (IllegalArgumentException e) {
                        logger.info("Skipping misunderstood FROM dep string: " + str3);
                    }
                }
            }
            if (dependencyResult.getRequested() != null) {
                String str4 = "" + dependencyResult.getRequested();
                try {
                    this.dependencyAnalyzer.registerDependency(Dependency.Companion.fromArtifactVersions(fromGradleRef, ArtifactVersion.Companion.fromGradleRef(str4)));
                } catch (IllegalArgumentException e2) {
                    logger.info("Skipping misunderstood TO dep string: " + str4);
                }
            }
        }
    }

    public void beforeResolve(ResolvableDependencies resolvableDependencies) {
    }

    public void afterResolve(ResolvableDependencies resolvableDependencies) {
        String name = resolvableDependencies.getName();
        if (name.contains("ompile")) {
            logger.info("Registered task dependencies: " + this.projectName + ":" + name);
            if (!(resolvableDependencies.getResolutionResult() == null || resolvableDependencies.getResolutionResult().getAllDependencies() == null)) {
                registerDependencies(resolvableDependencies, this.projectName, name);
            }
            logger.info("Starting dependency analysis");
            ResolutionResult resolutionResult = resolvableDependencies.getResolutionResult();
            HashMap hashMap = new HashMap();
            for (ResolvedComponentResult id : resolutionResult.getAllComponents()) {
                ArtifactVersion fromGradleRefOrNull = ArtifactVersion.Companion.fromGradleRefOrNull(id.getId().toString());
                if (fromGradleRefOrNull != null) {
                    hashMap.put(fromGradleRefOrNull.getArtifact(), fromGradleRefOrNull);
                }
            }
            if (hashMap.size() >= 1) {
                for (Dependency dependency : this.dependencyAnalyzer.getActiveDependencies(hashMap.values())) {
                    ArtifactVersion artifactVersion = (ArtifactVersion) hashMap.get(dependency.getToArtifact());
                    if (!dependency.isVersionCompatible(artifactVersion.getVersion())) {
                        logger.warn("Dependency resolved to an incompatible version: " + dependency);
                        Collection<Node> paths = this.dependencyAnalyzer.getPaths(artifactVersion.getArtifact());
                        logger.info("Dependency Resolution Help: Displaying all currently known paths to any version of the dependency: " + dependency.getToArtifact());
                        logger.info("NOTE: com.google.android.gms translated to c.g.a.g for brevity. Same for com.google.firebase -> c.g.f");
                        for (Node printNode : paths) {
                            printNode(1, printNode);
                        }
                        throw new GradleException(getErrorMessage(dependency, artifactVersion, paths));
                    }
                }
            }
        }
    }

    private String getErrorMessage(Dependency dependency, ArtifactVersion artifactVersion, Collection<Node> collection) {
        StringBuilder append = new StringBuilder("In project '").append(this.projectName).append("' a resolved Google Play services library dependency depends on another at an exact version (e.g. \"").append(dependency.getToArtifactVersionString()).append("\", but isn't being resolved to that version. Behavior exhibited by the library will be unknown.").append(System.lineSeparator()).append(System.lineSeparator()).append("Dependency failing: ").append(dependency.getDisplayString()).append(", but ").append(dependency.getToArtifact().getArtifactId()).append(" version was ").append(artifactVersion.getVersion()).append(".").append(System.lineSeparator()).append(System.lineSeparator()).append("The following dependencies are project dependencies that are direct or have transitive dependencies that lead to the artifact with the issue.");
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Node node : collection) {
            String[] split = node.getDependency().getFromArtifactVersion().getArtifactId().split("-");
            if (split[0].equals(split[2])) {
                stringBuilder.append("-- Project '").append(split[0]).append("' depends onto ");
            } else {
                stringBuilder.append("-- Project '").append(split[0]).append("' depends on project '").append(split[2]).append("' which depends onto ");
            }
            stringBuilder.append(node.getDependency().getToArtifact().getGroupId()).append(":").append(node.getDependency().getToArtifact().getArtifactId()).append("@").append(node.getDependency().getToArtifactVersionString());
            hashSet.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            append.append(System.lineSeparator()).append((String) it.next());
        }
        append.append(System.lineSeparator()).append(System.lineSeparator()).append("For extended debugging info execute Gradle from the command line with ").append("./gradlew --info :").append(this.projectName).append(":assembleDebug to see the dependency paths to the artifact. ");
        if (!(this.exceptionMessageAddendum == null || "".equals(this.exceptionMessageAddendum.trim()))) {
            append.append(this.exceptionMessageAddendum);
        }
        return append.toString().replaceAll(".{120}(?=.)", "$0" + System.lineSeparator());
    }
}
