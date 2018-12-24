package com.yourvoice.ccApp.androidcomponent;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import com.google.gson.Gson;
import com.yourvoice.ccApp.C0479R;
import com.yourvoice.ccApp.androidcomponent.C0490h.C0489a;
import com.yourvoice.ccApp.coffeecApp;

public class YVService extends Service {
    /* renamed from: a */
    C0487f f779a = null;
    /* renamed from: b */
    C0486e f780b = null;
    /* renamed from: c */
    int f781c = 10;
    /* renamed from: d */
    int f782d = 1;
    /* renamed from: e */
    private Thread f783e;
    /* renamed from: f */
    private Thread f784f;

    /* renamed from: com.yourvoice.ccApp.androidcomponent.YVService$a */
    class C0480a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ YVService f774a;
        /* renamed from: b */
        private boolean f775b = true;

        C0480a(YVService yVService) {
            this.f774a = yVService;
        }

        public void run() {
            while (this.f775b) {
                try {
                    long currentTimeMillis = System.currentTimeMillis() + ((long) C0490h.m1262a().intValue());
                    while (this.f775b && currentTimeMillis > System.currentTimeMillis()) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                    }
                    if (!this.f775b) {
                        return;
                    }
                    if (C0493k.m1282c(this.f774a)) {
                        if (C0492j.m1272b(this.f774a, "refresh_token", "").equals("")) {
                            if (!(!C0493k.m1281b(this.f774a) || C0492j.m1272b(this.f774a, "username", "").equals("") || C0492j.m1272b(this.f774a, "password", "").equals(""))) {
                                this.f774a.m1231d();
                            }
                        } else if (C0493k.m1281b(this.f774a) && !C0492j.m1272b(this.f774a, "refresh_token", "").equals("")) {
                            this.f774a.m1230c();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.yourvoice.ccApp.androidcomponent.YVService$b */
    class C0481b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ YVService f776a;
        /* renamed from: b */
        private boolean f777b = true;
        /* renamed from: c */
        private int f778c = 2000;

        C0481b(YVService yVService) {
            this.f776a = yVService;
        }

        public void run() {
            while (this.f777b) {
                try {
                    long currentTimeMillis = System.currentTimeMillis() + ((long) this.f778c);
                    this.f778c = 60000;
                    while (this.f777b && currentTimeMillis > System.currentTimeMillis()) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                    }
                    if (!this.f777b) {
                        return;
                    }
                    if (C0493k.m1281b(this.f776a)) {
                        String b = C0492j.m1272b(this.f776a, "initial_notification_time", "");
                        if (C0493k.m1281b(this.f776a)) {
                            if (b.equals("")) {
                                this.f776a.m1227a(C0493k.m1285f(this.f776a), this.f776a.f781c, this.f776a.f782d);
                            } else if (C0493k.m1284e(this.f776a)) {
                                this.f776a.m1227a(C0493k.m1285f(this.f776a), this.f776a.f781c, this.f776a.f782d);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this) {
            if (this.f783e == null) {
                this.f783e = new Thread(new C0480a(this), "RefreshTokenThread");
                this.f783e.setDaemon(true);
                this.f783e.start();
            }
            if (this.f784f == null) {
                this.f784f = new Thread(new C0481b(this), "RequestForNotificationThread");
                this.f784f.setDaemon(true);
                this.f784f.start();
            }
        }
        return 1;
    }

    /* renamed from: a */
    private void m1221a() {
        if (C0492j.m1272b((Context) this, "refresh_token", "").equals("")) {
            if (C0493k.m1281b(this) && !C0492j.m1272b((Context) this, "username", "").equals("") && !C0492j.m1272b((Context) this, "password", "").equals("")) {
                m1231d();
            }
        } else if (C0493k.m1281b(this) && !C0492j.m1272b((Context) this, "refresh_token", "").equals("")) {
            m1230c();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        sendBroadcast(new Intent("YouWillNeverKillMe"));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    /* renamed from: b */
    private void m1228b() {
        try {
            if (!(!C0492j.m1272b((Context) this, "access_token", "").equals("") || C0492j.m1272b((Context) this, "username", "").equals("") || C0492j.m1272b((Context) this, "password", "").equals(""))) {
                m1231d();
            }
            if (!C0492j.m1272b((Context) this, "access_token", "").equals("")) {
                String a = C0491i.m1265a(this, C0489a.f821b, C0492j.m1272b((Context) this, "access_token", ""));
                if (C0493k.m1277a(a)) {
                    this.f780b = (C0486e) new Gson().fromJson(a, C0486e.class);
                    if (this.f780b != null) {
                        m1225a(this.f780b);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1225a(C0486e c0486e) {
        try {
            if (c0486e.m1254a() == (short) 0) {
                C0492j.m1269a((Context) this, "badge_count", c0486e.m1255b());
                C0482a.m1233a(this, C0492j.m1271b((Context) this, "badge_count", 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m1230c() {
        String str = "";
        try {
            str = C0491i.m1268a(C0490h.f831j, "grant_type=refresh_token&client_id=" + Uri.encode(C0490h.f829h) + "&client_secret=" + Uri.encode(C0490h.f830i) + "&scope=" + Uri.encode(C0490h.f828g) + "&refresh_token=" + Uri.encode(C0492j.m1272b((Context) this, "refresh_token", "")));
            Log.e("TAG", " post : result :: " + str);
            if (C0493k.m1277a(str)) {
                C0492j.m1270a((Context) this, "initial_time", C0493k.m1273a());
                C0493k.m1276a(this, str);
                return;
            }
            C0493k.m1275a((Context) this);
        } catch (Exception e) {
            C0490h.m1263b();
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m1231d() {
        try {
            String a = C0491i.m1268a(C0490h.f831j, "grant_type=password&client_id=" + Uri.encode(C0490h.f829h) + "&client_secret=" + Uri.encode(C0490h.f830i) + "&scope=" + Uri.encode(C0490h.f828g) + "&username=" + Uri.encode(C0492j.m1272b((Context) this, "username", "")) + "&password=" + Uri.encode(C0492j.m1272b((Context) this, "password", "")));
            if (C0493k.m1277a(a)) {
                C0492j.m1270a((Context) this, "initial_time", C0493k.m1273a());
                C0493k.m1276a(this, a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1227a(String str, int i, int i2) {
        try {
            if (!(!C0492j.m1272b((Context) this, "access_token", "").equals("") || C0492j.m1272b((Context) this, "username", "").equals("") || C0492j.m1272b((Context) this, "password", "").equals(""))) {
                m1231d();
            }
            if (C0493k.m1282c(this)) {
                m1221a();
            }
            if (!C0492j.m1272b((Context) this, "access_token", "").equals("")) {
                String a = C0491i.m1266a(this, C0489a.f820a, str, i, i2, C0492j.m1272b((Context) this, "access_token", ""));
                if (C0493k.m1277a(a)) {
                    this.f779a = (C0487f) new Gson().fromJson(a, C0487f.class);
                    if (this.f779a != null) {
                        m1226a(this.f779a, i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1226a(C0487f c0487f, int i) {
        if (c0487f.m1258c() == (short) 0 && c0487f.m1257b() != null && c0487f.m1257b().size() > 0) {
            for (int i2 = 0; i2 < c0487f.m1257b().size(); i2++) {
                C0483b c0483b = new C0483b();
                if (C0493k.m1277a(((C0488g) c0487f.m1257b().get(i2)).m1259a())) {
                    c0483b.m1237a(((C0488g) c0487f.m1257b().get(i2)).m1259a());
                }
                if (C0493k.m1277a(((C0488g) c0487f.m1257b().get(i2)).m1260b())) {
                    c0483b.m1240b(((C0488g) c0487f.m1257b().get(i2)).m1260b());
                }
                c0483b.m1238a(((C0488g) c0487f.m1257b().get(i2)).m1261c());
                try {
                    if (((C0488g) c0487f.m1257b().get(i2)).m1261c() == (short) 3) {
                        m1228b();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                m1224a(c0483b, i2);
            }
        }
        if (c0487f.m1256a() != 0) {
            m1227a(C0493k.m1285f(this), i, this.f782d + i);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m1224a(C0483b c0483b, int i) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        String str = "";
        if (C0493k.m1277a(c0483b.m1239b())) {
            c0483b.m1239b();
        }
        int currentTimeMillis = (int) System.currentTimeMillis();
        getApplicationContext();
        CharSequence a = c0483b.m1236a();
        CharSequence b = c0483b.m1239b();
        Builder builder = new Builder(this);
        builder.setStyle(new BigTextStyle(builder).bigText(b).setBigContentTitle(a)).setContentTitle(a).setContentText(b).setSmallIcon(C0479R.drawable.notification_icon);
        Intent intent = new Intent(this, coffeecApp.class);
        intent.putExtra(C0490h.f825d, c0483b.m1241c());
        intent.putExtra(C0490h.f826e, c0483b.m1239b());
        intent.setAction("myString" + currentTimeMillis);
        PendingIntent activity = PendingIntent.getActivity(this, currentTimeMillis, intent, 0);
        intent.setData(Uri.parse("mystring" + currentTimeMillis));
        builder.setContentIntent(activity);
        notificationManager.notify(currentTimeMillis, builder.build());
    }

    @SuppressLint({"NewApi"})
    public void onTaskRemoved(Intent intent) {
        Intent intent2 = new Intent(getApplicationContext(), getClass());
        intent2.setPackage(getPackageName());
        ((AlarmManager) getApplicationContext().getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + 1000, PendingIntent.getService(getApplicationContext(), 1, intent2, 1073741824));
        super.onTaskRemoved(intent);
    }
}
