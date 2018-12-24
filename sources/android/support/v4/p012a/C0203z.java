package android.support.v4.p012a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p012a.aa.C0104a;
import android.support.v4.p012a.ab.C0105a;
import android.support.v4.p012a.ac.C0106a;
import android.support.v4.p012a.ad.C0107a;
import android.support.v4.p012a.ae.C0109a;
import android.support.v4.p012a.ae.C0109a.C0108a;
import android.support.v4.p012a.af.C0110a;
import android.support.v4.p012a.ag.C0111a;
import android.support.v4.p012a.al.C0118a;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.a.z */
public class C0203z {
    /* renamed from: a */
    static final C0194l f406a;

    /* renamed from: android.support.v4.a.z$a */
    public static class C0189a extends C0109a {
        /* renamed from: e */
        public static final C0108a f352e = new C01881();
        /* renamed from: a */
        final Bundle f353a;
        /* renamed from: b */
        public int f354b;
        /* renamed from: c */
        public CharSequence f355c;
        /* renamed from: d */
        public PendingIntent f356d;
        /* renamed from: f */
        private final aj[] f357f;
        /* renamed from: g */
        private final aj[] f358g;
        /* renamed from: h */
        private boolean f359h;

        /* renamed from: android.support.v4.a.z$a$1 */
        static class C01881 implements C0108a {
            C01881() {
            }
        }

        /* renamed from: h */
        public /* synthetic */ C0118a[] mo110h() {
            return m579g();
        }

        /* renamed from: i */
        public /* synthetic */ C0118a[] mo111i() {
            return m578f();
        }

        public C0189a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null, null, true);
        }

        C0189a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, aj[] ajVarArr, aj[] ajVarArr2, boolean z) {
            this.f354b = i;
            this.f355c = C0192c.m592d(charSequence);
            this.f356d = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f353a = bundle;
            this.f357f = ajVarArr;
            this.f358g = ajVarArr2;
            this.f359h = z;
        }

        /* renamed from: a */
        public int mo105a() {
            return this.f354b;
        }

        /* renamed from: b */
        public CharSequence mo106b() {
            return this.f355c;
        }

        /* renamed from: c */
        public PendingIntent mo107c() {
            return this.f356d;
        }

        /* renamed from: d */
        public Bundle mo108d() {
            return this.f353a;
        }

        /* renamed from: e */
        public boolean mo109e() {
            return this.f359h;
        }

        /* renamed from: f */
        public aj[] m578f() {
            return this.f357f;
        }

        /* renamed from: g */
        public aj[] m579g() {
            return this.f358g;
        }
    }

    /* renamed from: android.support.v4.a.z$m */
    public static abstract class C0190m {
        /* renamed from: a */
        protected C0192c f360a;
        /* renamed from: b */
        CharSequence f361b;
        /* renamed from: c */
        CharSequence f362c;
        /* renamed from: d */
        boolean f363d = false;

        /* renamed from: a */
        public void m584a(C0192c c0192c) {
            if (this.f360a != c0192c) {
                this.f360a = c0192c;
                if (this.f360a != null) {
                    this.f360a.m599a(this);
                }
            }
        }

        /* renamed from: a */
        public void mo112a(C0103y c0103y) {
        }

        /* renamed from: b */
        public RemoteViews m585b(C0103y c0103y) {
            return null;
        }

        /* renamed from: c */
        public RemoteViews m586c(C0103y c0103y) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews m587d(C0103y c0103y) {
            return null;
        }

        /* renamed from: a */
        public void m582a(Bundle bundle) {
        }
    }

    /* renamed from: android.support.v4.a.z$b */
    public static class C0191b extends C0190m {
        /* renamed from: e */
        private CharSequence f364e;

        /* renamed from: a */
        public C0191b m588a(CharSequence charSequence) {
            this.f364e = C0192c.m592d(charSequence);
            return this;
        }

        /* renamed from: a */
        public void mo112a(C0103y c0103y) {
            if (VERSION.SDK_INT >= 16) {
                af.m171a(c0103y, this.b, this.d, this.c, this.f364e);
            }
        }
    }

    /* renamed from: android.support.v4.a.z$c */
    public static class C0192c {
        /* renamed from: A */
        Bundle f365A;
        /* renamed from: B */
        int f366B;
        /* renamed from: C */
        int f367C;
        /* renamed from: D */
        Notification f368D;
        /* renamed from: E */
        RemoteViews f369E;
        /* renamed from: F */
        RemoteViews f370F;
        /* renamed from: G */
        RemoteViews f371G;
        /* renamed from: H */
        String f372H;
        /* renamed from: I */
        int f373I;
        /* renamed from: J */
        String f374J;
        /* renamed from: K */
        long f375K;
        /* renamed from: L */
        public Notification f376L;
        /* renamed from: M */
        public ArrayList<String> f377M;
        /* renamed from: N */
        private int f378N;
        /* renamed from: a */
        public Context f379a;
        /* renamed from: b */
        public CharSequence f380b;
        /* renamed from: c */
        public CharSequence f381c;
        /* renamed from: d */
        PendingIntent f382d;
        /* renamed from: e */
        PendingIntent f383e;
        /* renamed from: f */
        RemoteViews f384f;
        /* renamed from: g */
        public Bitmap f385g;
        /* renamed from: h */
        public CharSequence f386h;
        /* renamed from: i */
        public int f387i;
        /* renamed from: j */
        int f388j;
        /* renamed from: k */
        boolean f389k;
        /* renamed from: l */
        public boolean f390l;
        /* renamed from: m */
        public C0190m f391m;
        /* renamed from: n */
        public CharSequence f392n;
        /* renamed from: o */
        public CharSequence[] f393o;
        /* renamed from: p */
        int f394p;
        /* renamed from: q */
        int f395q;
        /* renamed from: r */
        boolean f396r;
        /* renamed from: s */
        String f397s;
        /* renamed from: t */
        boolean f398t;
        /* renamed from: u */
        String f399u;
        /* renamed from: v */
        public ArrayList<C0189a> f400v;
        /* renamed from: w */
        boolean f401w;
        /* renamed from: x */
        boolean f402x;
        /* renamed from: y */
        boolean f403y;
        /* renamed from: z */
        String f404z;

        public C0192c(Context context, String str) {
            this.f389k = true;
            this.f400v = new ArrayList();
            this.f401w = false;
            this.f366B = 0;
            this.f367C = 0;
            this.f373I = 0;
            this.f378N = 0;
            this.f376L = new Notification();
            this.f379a = context;
            this.f372H = str;
            this.f376L.when = System.currentTimeMillis();
            this.f376L.audioStreamType = -1;
            this.f388j = 0;
            this.f377M = new ArrayList();
        }

        @Deprecated
        public C0192c(Context context) {
            this(context, null);
        }

        /* renamed from: a */
        public C0192c m596a(long j) {
            this.f376L.when = j;
            return this;
        }

        /* renamed from: a */
        public C0192c m594a(int i) {
            this.f376L.icon = i;
            return this;
        }

        /* renamed from: a */
        public C0192c m600a(CharSequence charSequence) {
            this.f380b = C0192c.m592d(charSequence);
            return this;
        }

        /* renamed from: b */
        public C0192c m605b(CharSequence charSequence) {
            this.f381c = C0192c.m592d(charSequence);
            return this;
        }

        /* renamed from: a */
        public C0192c m597a(PendingIntent pendingIntent) {
            this.f382d = pendingIntent;
            return this;
        }

        /* renamed from: b */
        public C0192c m604b(PendingIntent pendingIntent) {
            this.f376L.deleteIntent = pendingIntent;
            return this;
        }

        /* renamed from: c */
        public C0192c m609c(CharSequence charSequence) {
            this.f376L.tickerText = C0192c.m592d(charSequence);
            return this;
        }

        /* renamed from: a */
        public C0192c m598a(Uri uri) {
            this.f376L.sound = uri;
            this.f376L.audioStreamType = -1;
            return this;
        }

        /* renamed from: a */
        public C0192c m602a(boolean z) {
            m591a(16, z);
            return this;
        }

        /* renamed from: b */
        public C0192c m606b(boolean z) {
            this.f401w = z;
            return this;
        }

        /* renamed from: a */
        private void m591a(int i, boolean z) {
            if (z) {
                Notification notification = this.f376L;
                notification.flags |= i;
                return;
            }
            notification = this.f376L;
            notification.flags &= i ^ -1;
        }

        /* renamed from: b */
        public C0192c m603b(int i) {
            this.f388j = i;
            return this;
        }

        /* renamed from: a */
        public C0192c m595a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f400v.add(new C0189a(i, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: a */
        public C0192c m599a(C0190m c0190m) {
            if (this.f391m != c0190m) {
                this.f391m = c0190m;
                if (this.f391m != null) {
                    this.f391m.m584a(this);
                }
            }
            return this;
        }

        /* renamed from: c */
        public C0192c m608c(int i) {
            this.f366B = i;
            return this;
        }

        /* renamed from: d */
        public C0192c m610d(int i) {
            this.f367C = i;
            return this;
        }

        /* renamed from: a */
        public C0192c m601a(String str) {
            this.f372H = str;
            return this;
        }

        /* renamed from: a */
        public Notification m593a() {
            return C0203z.f406a.mo113a(this, m607b());
        }

        /* renamed from: b */
        protected C0193d m607b() {
            return new C0193d();
        }

        /* renamed from: d */
        protected static CharSequence m592d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    /* renamed from: android.support.v4.a.z$d */
    protected static class C0193d {
        protected C0193d() {
        }

        /* renamed from: a */
        public Notification m611a(C0192c c0192c, C0103y c0103y) {
            RemoteViews b = c0192c.f391m != null ? c0192c.f391m.m585b(c0103y) : null;
            Notification b2 = c0103y.mo47b();
            if (b != null) {
                b2.contentView = b;
            } else if (c0192c.f369E != null) {
                b2.contentView = c0192c.f369E;
            }
            if (VERSION.SDK_INT >= 16 && c0192c.f391m != null) {
                b = c0192c.f391m.m586c(c0103y);
                if (b != null) {
                    b2.bigContentView = b;
                }
            }
            if (VERSION.SDK_INT >= 21 && c0192c.f391m != null) {
                b = c0192c.f391m.m587d(c0103y);
                if (b != null) {
                    b2.headsUpContentView = b;
                }
            }
            return b2;
        }
    }

    /* renamed from: android.support.v4.a.z$l */
    interface C0194l {
        /* renamed from: a */
        Notification mo113a(C0192c c0192c, C0193d c0193d);
    }

    /* renamed from: android.support.v4.a.z$k */
    static class C0195k implements C0194l {

        /* renamed from: android.support.v4.a.z$k$a */
        public static class C0202a implements C0103y {
            /* renamed from: a */
            private Builder f405a;

            C0202a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
                this.f405a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setProgress(i2, i3, z);
            }

            /* renamed from: a */
            public Builder mo45a() {
                return this.f405a;
            }

            /* renamed from: b */
            public Notification mo47b() {
                return this.f405a.getNotification();
            }
        }

        C0195k() {
        }

        /* renamed from: a */
        public Notification mo113a(C0192c c0192c, C0193d c0193d) {
            return c0193d.m611a(c0192c, new C0202a(c0192c.f379a, c0192c.f376L, c0192c.f380b, c0192c.f381c, c0192c.f386h, c0192c.f384f, c0192c.f387i, c0192c.f382d, c0192c.f383e, c0192c.f385g, c0192c.f394p, c0192c.f395q, c0192c.f396r));
        }
    }

    /* renamed from: android.support.v4.a.z$e */
    static class C0196e extends C0195k {
        C0196e() {
        }

        /* renamed from: a */
        public Notification mo113a(C0192c c0192c, C0193d c0193d) {
            C0103y c0110a = new C0110a(c0192c.f379a, c0192c.f376L, c0192c.f380b, c0192c.f381c, c0192c.f386h, c0192c.f384f, c0192c.f387i, c0192c.f382d, c0192c.f383e, c0192c.f385g, c0192c.f394p, c0192c.f395q, c0192c.f396r, c0192c.f390l, c0192c.f388j, c0192c.f392n, c0192c.f401w, c0192c.f365A, c0192c.f397s, c0192c.f398t, c0192c.f399u, c0192c.f369E, c0192c.f370F);
            C0203z.m623a(c0110a, c0192c.f400v);
            if (c0192c.f391m != null) {
                c0192c.f391m.mo112a(c0110a);
            }
            Notification a = c0193d.m611a(c0192c, c0110a);
            if (c0192c.f391m != null) {
                Bundle a2 = C0203z.m622a(a);
                if (a2 != null) {
                    c0192c.f391m.m582a(a2);
                }
            }
            return a;
        }
    }

    /* renamed from: android.support.v4.a.z$f */
    static class C0197f extends C0196e {
        C0197f() {
        }

        /* renamed from: a */
        public Notification mo113a(C0192c c0192c, C0193d c0193d) {
            C0103y c0111a = new C0111a(c0192c.f379a, c0192c.f376L, c0192c.f380b, c0192c.f381c, c0192c.f386h, c0192c.f384f, c0192c.f387i, c0192c.f382d, c0192c.f383e, c0192c.f385g, c0192c.f394p, c0192c.f395q, c0192c.f396r, c0192c.f389k, c0192c.f390l, c0192c.f388j, c0192c.f392n, c0192c.f401w, c0192c.f377M, c0192c.f365A, c0192c.f397s, c0192c.f398t, c0192c.f399u, c0192c.f369E, c0192c.f370F);
            C0203z.m623a(c0111a, c0192c.f400v);
            if (c0192c.f391m != null) {
                c0192c.f391m.mo112a(c0111a);
            }
            return c0193d.m611a(c0192c, c0111a);
        }
    }

    /* renamed from: android.support.v4.a.z$g */
    static class C0198g extends C0197f {
        C0198g() {
        }

        /* renamed from: a */
        public Notification mo113a(C0192c c0192c, C0193d c0193d) {
            C0103y c0104a = new C0104a(c0192c.f379a, c0192c.f376L, c0192c.f380b, c0192c.f381c, c0192c.f386h, c0192c.f384f, c0192c.f387i, c0192c.f382d, c0192c.f383e, c0192c.f385g, c0192c.f394p, c0192c.f395q, c0192c.f396r, c0192c.f389k, c0192c.f390l, c0192c.f388j, c0192c.f392n, c0192c.f401w, c0192c.f377M, c0192c.f365A, c0192c.f397s, c0192c.f398t, c0192c.f399u, c0192c.f369E, c0192c.f370F, c0192c.f378N);
            C0203z.m623a(c0104a, c0192c.f400v);
            if (c0192c.f391m != null) {
                c0192c.f391m.mo112a(c0104a);
            }
            Notification a = c0193d.m611a(c0192c, c0104a);
            if (c0192c.f391m != null) {
                c0192c.f391m.m582a(C0203z.m622a(a));
            }
            return a;
        }
    }

    /* renamed from: android.support.v4.a.z$h */
    static class C0199h extends C0198g {
        C0199h() {
        }

        /* renamed from: a */
        public Notification mo113a(C0192c c0192c, C0193d c0193d) {
            C0103y c0105a = new C0105a(c0192c.f379a, c0192c.f376L, c0192c.f380b, c0192c.f381c, c0192c.f386h, c0192c.f384f, c0192c.f387i, c0192c.f382d, c0192c.f383e, c0192c.f385g, c0192c.f394p, c0192c.f395q, c0192c.f396r, c0192c.f389k, c0192c.f390l, c0192c.f388j, c0192c.f392n, c0192c.f401w, c0192c.f404z, c0192c.f377M, c0192c.f365A, c0192c.f366B, c0192c.f367C, c0192c.f368D, c0192c.f397s, c0192c.f398t, c0192c.f399u, c0192c.f369E, c0192c.f370F, c0192c.f371G, c0192c.f378N);
            C0203z.m623a(c0105a, c0192c.f400v);
            if (c0192c.f391m != null) {
                c0192c.f391m.mo112a(c0105a);
            }
            Notification a = c0193d.m611a(c0192c, c0105a);
            if (c0192c.f391m != null) {
                c0192c.f391m.m582a(C0203z.m622a(a));
            }
            return a;
        }
    }

    /* renamed from: android.support.v4.a.z$i */
    static class C0200i extends C0199h {
        C0200i() {
        }

        /* renamed from: a */
        public Notification mo113a(C0192c c0192c, C0193d c0193d) {
            C0103y c0106a = new C0106a(c0192c.f379a, c0192c.f376L, c0192c.f380b, c0192c.f381c, c0192c.f386h, c0192c.f384f, c0192c.f387i, c0192c.f382d, c0192c.f383e, c0192c.f385g, c0192c.f394p, c0192c.f395q, c0192c.f396r, c0192c.f389k, c0192c.f390l, c0192c.f388j, c0192c.f392n, c0192c.f401w, c0192c.f404z, c0192c.f377M, c0192c.f365A, c0192c.f366B, c0192c.f367C, c0192c.f368D, c0192c.f397s, c0192c.f398t, c0192c.f399u, c0192c.f393o, c0192c.f369E, c0192c.f370F, c0192c.f371G, c0192c.f378N);
            C0203z.m623a(c0106a, c0192c.f400v);
            if (c0192c.f391m != null) {
                c0192c.f391m.mo112a(c0106a);
            }
            Notification a = c0193d.m611a(c0192c, c0106a);
            if (c0192c.f391m != null) {
                c0192c.f391m.m582a(C0203z.m622a(a));
            }
            return a;
        }
    }

    /* renamed from: android.support.v4.a.z$j */
    static class C0201j extends C0200i {
        C0201j() {
        }

        /* renamed from: a */
        public Notification mo113a(C0192c c0192c, C0193d c0193d) {
            C0103y c0107a = new C0107a(c0192c.f379a, c0192c.f376L, c0192c.f380b, c0192c.f381c, c0192c.f386h, c0192c.f384f, c0192c.f387i, c0192c.f382d, c0192c.f383e, c0192c.f385g, c0192c.f394p, c0192c.f395q, c0192c.f396r, c0192c.f389k, c0192c.f390l, c0192c.f388j, c0192c.f392n, c0192c.f401w, c0192c.f404z, c0192c.f377M, c0192c.f365A, c0192c.f366B, c0192c.f367C, c0192c.f368D, c0192c.f397s, c0192c.f398t, c0192c.f399u, c0192c.f393o, c0192c.f369E, c0192c.f370F, c0192c.f371G, c0192c.f372H, c0192c.f373I, c0192c.f374J, c0192c.f375K, c0192c.f402x, c0192c.f403y, c0192c.f378N);
            C0203z.m623a(c0107a, c0192c.f400v);
            if (c0192c.f391m != null) {
                c0192c.f391m.mo112a(c0107a);
            }
            Notification a = c0193d.m611a(c0192c, c0107a);
            if (c0192c.f391m != null) {
                c0192c.f391m.m582a(C0203z.m622a(a));
            }
            return a;
        }
    }

    /* renamed from: a */
    static void m623a(C0102x c0102x, ArrayList<C0189a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0102x.mo46a((C0189a) it.next());
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f406a = new C0201j();
        } else if (VERSION.SDK_INT >= 24) {
            f406a = new C0200i();
        } else if (VERSION.SDK_INT >= 21) {
            f406a = new C0199h();
        } else if (VERSION.SDK_INT >= 20) {
            f406a = new C0198g();
        } else if (VERSION.SDK_INT >= 19) {
            f406a = new C0197f();
        } else if (VERSION.SDK_INT >= 16) {
            f406a = new C0196e();
        } else {
            f406a = new C0195k();
        }
    }

    /* renamed from: a */
    public static Bundle m622a(Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (VERSION.SDK_INT >= 16) {
            return af.m169a(notification);
        }
        return null;
    }
}
