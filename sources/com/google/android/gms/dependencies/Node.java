package com.google.android.gms.dependencies;

import p000a.p003c.p005b.C0024c;

public final class Node {
    private final Node child;
    private final Dependency dependency;

    public static /* synthetic */ Node copy$default(Node node, Node node2, Dependency dependency, int i, Object obj) {
        if ((i & 1) != 0) {
            node2 = node.child;
        }
        if ((i & 2) != 0) {
            dependency = node.dependency;
        }
        return node.copy(node2, dependency);
    }

    public final Node component1() {
        return this.child;
    }

    public final Dependency component2() {
        return this.dependency;
    }

    public final Node copy(Node node, Dependency dependency) {
        C0024c.m22b(dependency, "dependency");
        return new Node(node, dependency);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001c;
    L_0x0002:
        r0 = r3 instanceof com.google.android.gms.dependencies.Node;
        if (r0 == 0) goto L_0x001e;
    L_0x0006:
        r3 = (com.google.android.gms.dependencies.Node) r3;
        r0 = r2.child;
        r1 = r3.child;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x0012:
        r0 = r2.dependency;
        r1 = r3.dependency;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dependencies.Node.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        Node node = this.child;
        int hashCode = (node != null ? node.hashCode() : 0) * 31;
        Dependency dependency = this.dependency;
        if (dependency != null) {
            i = dependency.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Node(child=" + this.child + ", dependency=" + this.dependency + ")";
    }

    public Node(Node node, Dependency dependency) {
        C0024c.m22b(dependency, "dependency");
        this.child = node;
        this.dependency = dependency;
    }

    public final Node getChild() {
        return this.child;
    }

    public final Dependency getDependency() {
        return this.dependency;
    }
}
