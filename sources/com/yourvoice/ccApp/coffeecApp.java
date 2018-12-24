package com.yourvoice.ccApp;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.gson.Gson;
import com.yourvoice.ccApp.androidcomponent.C0482a;
import com.yourvoice.ccApp.androidcomponent.C0485d;
import com.yourvoice.ccApp.androidcomponent.C0490h;
import com.yourvoice.ccApp.androidcomponent.C0491i;
import com.yourvoice.ccApp.androidcomponent.C0492j;
import com.yourvoice.ccApp.androidcomponent.C0493k;
import com.yourvoice.ccApp.androidcomponent.YVService;
import java.util.Calendar;
import org.apache.cordova.CordovaActivity;

public class coffeecApp extends CordovaActivity {
    /* renamed from: a */
    short f840a = (short) 0;
    /* renamed from: b */
    String f841b = "body";
    /* renamed from: c */
    WebView f842c;

    /* renamed from: com.yourvoice.ccApp.coffeecApp$a */
    public class C0494a {
        /* renamed from: a */
        Context f838a;
        /* renamed from: b */
        final /* synthetic */ coffeecApp f839b;

        C0494a(coffeecApp coffeecapp, Context context) {
            this.f839b = coffeecapp;
            this.f838a = context;
        }

        @JavascriptInterface
        public void showBadge(String str) {
            C0492j.m1269a(this.f839b, "badge_count", Integer.parseInt(str));
            this.f839b.m1288a();
        }

        @JavascriptInterface
        public void showToast() {
            String str = "";
            try {
                C0492j.m1270a(this.f839b, "current_version", this.f839b.getPackageManager().getPackageInfo(this.f839b.getPackageName(), 0).versionName);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            C0492j.m1272b(this.f839b, "pervious_version", "0");
            try {
                if (C0493k.m1281b(this.f839b) && !C0492j.m1272b(this.f839b, "username", "").equals("") && !C0492j.m1272b(this.f839b, "password", "").equals("")) {
                    Calendar instance = Calendar.getInstance();
                    ((AlarmManager) this.f839b.getSystemService("alarm")).setRepeating(0, instance.getTimeInMillis(), 600000, PendingIntent.getService(this.f839b, 0, new Intent(this.f839b, YVService.class), 0));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @JavascriptInterface
        public String AuthenticationToken(String str, String str2) {
            C0492j.m1270a(this.f839b, "username", str);
            C0492j.m1270a(this.f839b, "password", str2);
            return this.f839b.m1287a("grant_type=password&client_id=" + Uri.encode(C0490h.f829h) + "&client_secret=" + Uri.encode(C0490h.f830i) + "&scope=" + Uri.encode(C0490h.f828g) + "&username=" + Uri.encode(C0492j.m1272b(this.f839b, "username", "")) + "&password=" + Uri.encode(C0492j.m1272b(this.f839b, "password", "")));
        }

        @JavascriptInterface
        public String AuthenticationToken() {
            return this.f839b.m1287a("grant_type=password&client_id=" + Uri.encode(C0490h.f829h) + "&client_secret=" + Uri.encode(C0490h.f830i) + "&scope=" + Uri.encode(C0490h.f828g) + "&username=" + Uri.encode(C0492j.m1272b(this.f839b, "username", "")) + "&password=" + Uri.encode(C0492j.m1272b(this.f839b, "password", "")));
        }

        @JavascriptInterface
        public String GetValue(String str) {
            String str2 = "";
            if (str.equals("AccessToken")) {
                return C0492j.m1272b(this.f839b, "access_token", "0");
            }
            if (str.equals("TokenExpire")) {
                return C0492j.m1272b(this.f839b, "expires_in", "0");
            }
            if (str.equals("RefreshToken")) {
                return C0492j.m1272b(this.f839b, "refresh_token", "0");
            }
            return str2;
        }

        @JavascriptInterface
        public String RfreshToken(String str) {
            return this.f839b.m1287a("grant_type=refresh_token&client_id=" + Uri.encode(C0490h.f829h) + "&client_secret=" + Uri.encode(C0490h.f830i) + "&scope=" + Uri.encode(C0490h.f828g) + "&refresh_token=" + Uri.encode(str));
        }

        @JavascriptInterface
        public String RecoverToken() {
            return this.f839b.m1287a("grant_type=client_credentials&client_id=" + Uri.encode(C0490h.f829h) + "&client_secret=" + Uri.encode(C0490h.f830i) + "&scope=" + Uri.encode(C0490h.f828g));
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (C0490h.f827f <= 0) {
                C0493k.m1280b();
                C0490h.f827f++;
            }
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", 0);
            boolean contains = sharedPreferences.contains("FirstRun");
            super.init();
            if (getIntent() != null) {
                this.f840a = getIntent().getShortExtra(C0490h.f825d, Short.parseShort("0"));
                this.f841b = getIntent().getStringExtra(C0490h.f826e);
            }
            this.f842c = (WebView) this.appView.getEngine().getView();
            this.f842c.getSettings().setJavaScriptEnabled(true);
            this.f842c.addJavascriptInterface(new C0494a(this, this), "AndroidFunction");
            if (!contains) {
                Editor edit = sharedPreferences.edit();
                edit.putBoolean("FirstRun", true);
                edit.commit();
                super.loadUrl("file:///android_asset/www/splashTutorial.html");
            } else if (this.f841b == null || this.f841b.isEmpty() || !this.f841b.contains("https://robertopquodcom.typeform.com")) {
                super.loadUrl("file:///android_asset/www/splashLogin.html?type=" + this.f840a);
            } else {
                super.loadUrl("file:///android_asset/www/survey.html?body=" + this.f841b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m1287a(String str) {
        String str2 = "error";
        try {
            String a = C0491i.m1268a(C0490h.f831j, str);
            if (!C0493k.m1277a(a)) {
                return str2;
            }
            C0492j.m1270a((Context) this, "initial_time", C0493k.m1273a());
            C0493k.m1276a(this, a);
            C0485d c0485d = (C0485d) new Gson().fromJson(a, C0485d.class);
            if (c0485d.m1252i().isEmpty() || c0485d.m1252i() == null) {
                return Param.SUCCESS;
            }
            return c0485d.m1253j();
        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }
    }

    /* renamed from: a */
    private void m1288a() {
        C0482a.m1233a(this, C0492j.m1271b((Context) this, "badge_count", 0));
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            this.f840a = getIntent().getShortExtra(C0490h.f825d, Short.parseShort("0"));
            this.f841b = getIntent().getStringExtra(C0490h.f826e);
            if (this.f841b == null || this.f841b.isEmpty() || !this.f841b.contains("https://robertopquodcom.typeform.com/to/OlTnBt")) {
                super.loadUrl("file:///android_asset/www/splashLogin.html?type=" + this.f840a);
            } else {
                super.loadUrl("file:///android_asset/www/survey.html?body=" + this.f841b);
            }
        }
    }
}
