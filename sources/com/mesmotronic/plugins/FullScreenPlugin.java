package com.mesmotronic.plugins;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;

public class FullScreenPlugin extends CordovaPlugin {
    /* renamed from: a */
    private CallbackContext f654a;
    /* renamed from: b */
    private Activity f655b;
    /* renamed from: c */
    private Window f656c;
    /* renamed from: d */
    private View f657d;
    /* renamed from: e */
    private int f658e = 0;
    /* renamed from: f */
    private final Handler f659f = new Handler();
    /* renamed from: g */
    private final Runnable f660g = new C04331(this);

    /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$1 */
    class C04331 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ FullScreenPlugin f642a;

        C04331(FullScreenPlugin fullScreenPlugin) {
            this.f642a = fullScreenPlugin;
        }

        public void run() {
            this.f642a.m1099f();
        }
    }

    /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$4 */
    class C04364 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ FullScreenPlugin f647a;

        C04364(FullScreenPlugin fullScreenPlugin) {
            this.f647a = fullScreenPlugin;
        }

        public void run() {
            try {
                Point point = new Point();
                this.f647a.f657d.getDisplay().getRealSize(point);
                this.f647a.f654a.sendPluginResult(new PluginResult(Status.OK, point.x));
            } catch (Exception e) {
                this.f647a.f654a.error(e.getMessage());
            }
        }
    }

    /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$5 */
    class C04375 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ FullScreenPlugin f648a;

        C04375(FullScreenPlugin fullScreenPlugin) {
            this.f648a = fullScreenPlugin;
        }

        public void run() {
            try {
                Point point = new Point();
                this.f648a.f657d.getDisplay().getRealSize(point);
                this.f648a.f654a.sendPluginResult(new PluginResult(Status.OK, point.y));
            } catch (Exception e) {
                this.f648a.f654a.error(e.getMessage());
            }
        }
    }

    /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$6 */
    class C04396 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ FullScreenPlugin f650a;

        /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$6$1 */
        class C04381 implements OnSystemUiVisibilityChangeListener {
            /* renamed from: a */
            final /* synthetic */ C04396 f649a;

            C04381(C04396 c04396) {
                this.f649a = c04396;
            }

            public void onSystemUiVisibilityChange(int i) {
                if ((this.f649a.f650a.f658e & 2) != 0 && (i & 2) == 0) {
                    this.f649a.f650a.m1092k();
                }
                this.f649a.f650a.f658e = i;
            }
        }

        C04396(FullScreenPlugin fullScreenPlugin) {
            this.f650a = fullScreenPlugin;
        }

        public void run() {
            try {
                this.f650a.m1093a();
                this.f650a.f658e = 1798;
                this.f650a.f657d.setOnSystemUiVisibilityChangeListener(new C04381(this));
                this.f650a.f657d.setSystemUiVisibility(1798);
                this.f650a.f654a.success();
            } catch (Exception e) {
                this.f650a.f654a.error(e.getMessage());
            }
        }
    }

    /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$7 */
    class C04407 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ FullScreenPlugin f651a;

        C04407(FullScreenPlugin fullScreenPlugin) {
            this.f651a = fullScreenPlugin;
        }

        public void run() {
            try {
                this.f651a.m1093a();
                this.f651a.f656c.clearFlags(201327616);
                this.f651a.f657d.setOnSystemUiVisibilityChangeListener(null);
                this.f651a.f657d.setSystemUiVisibility(0);
                this.f651a.f654a.sendPluginResult(new PluginResult(Status.OK, true));
                this.f651a.f654a.success();
            } catch (Exception e) {
                this.f651a.f654a.error(e.getMessage());
            }
        }
    }

    /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$8 */
    class C04418 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ FullScreenPlugin f652a;

        C04418(FullScreenPlugin fullScreenPlugin) {
            this.f652a = fullScreenPlugin;
        }

        public void run() {
            try {
                this.f652a.m1093a();
                this.f652a.f656c.setFlags(67108864, 67108864);
                this.f652a.f657d.setSystemUiVisibility(1280);
                this.f652a.f654a.success();
            } catch (Exception e) {
                this.f652a.f654a.error(e.getMessage());
            }
        }
    }

    /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$9 */
    class C04429 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ FullScreenPlugin f653a;

        C04429(FullScreenPlugin fullScreenPlugin) {
            this.f653a = fullScreenPlugin;
        }

        public void run() {
            try {
                this.f653a.m1093a();
                this.f653a.f656c.setFlags(134217728, 134217728);
                this.f653a.f656c.setFlags(67108864, 67108864);
                this.f653a.f657d.setSystemUiVisibility(768);
                this.f653a.f654a.success();
            } catch (Exception e) {
                this.f653a.f654a.error(e.getMessage());
            }
        }
    }

    public void initialize(final CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.cordova.getActivity().runOnUiThread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ FullScreenPlugin f646b;

            public void run() {
                cordovaInterface.getActivity().getWindow().clearFlags(2048);
                this.f646b.m1086a(this.f646b.preferences.getString("StatusBarBackgroundColor", "#000000"));
            }
        });
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        this.f654a = callbackContext;
        this.f655b = this.cordova.getActivity();
        this.f656c = this.f655b.getWindow();
        this.f657d = this.f656c.getDecorView();
        if ("isSupported".equals(str)) {
            return m1095b();
        }
        if ("isImmersiveModeSupported".equals(str)) {
            return m1096c();
        }
        if ("immersiveWidth".equals(str)) {
            return m1097d();
        }
        if ("immersiveHeight".equals(str)) {
            return m1098e();
        }
        if ("leanMode".equals(str)) {
            return m1099f();
        }
        if ("showSystemUI".equals(str)) {
            return m1100g();
        }
        if ("showUnderStatusBar".equals(str)) {
            return m1101h();
        }
        if ("showUnderSystemUI".equals(str)) {
            return m1102i();
        }
        if ("immersiveMode".equals(str)) {
            return m1103j();
        }
        if ("setSystemUiVisibility".equals(str)) {
            return m1094a(jSONArray.getInt(0));
        }
        return false;
    }

    /* renamed from: a */
    protected void m1093a() {
        this.f657d.setOnFocusChangeListener(null);
        this.f657d.setOnSystemUiVisibilityChangeListener(null);
        this.f656c.clearFlags(2048);
    }

    /* renamed from: b */
    protected boolean m1095b() {
        boolean z = VERSION.SDK_INT >= 14;
        this.f654a.sendPluginResult(new PluginResult(Status.OK, z));
        return z;
    }

    /* renamed from: c */
    protected boolean m1096c() {
        boolean z = VERSION.SDK_INT >= 19;
        this.f654a.sendPluginResult(new PluginResult(Status.OK, z));
        return z;
    }

    /* renamed from: d */
    protected boolean m1097d() {
        this.f655b.runOnUiThread(new C04364(this));
        return true;
    }

    /* renamed from: e */
    protected boolean m1098e() {
        this.f655b.runOnUiThread(new C04375(this));
        return true;
    }

    /* renamed from: f */
    protected boolean m1099f() {
        if (m1095b()) {
            this.f655b.runOnUiThread(new C04396(this));
            return true;
        }
        this.f654a.error("Not supported");
        return false;
    }

    /* renamed from: k */
    private void m1092k() {
        this.f659f.removeCallbacks(this.f660g);
        this.f659f.postDelayed(this.f660g, 3000);
    }

    /* renamed from: g */
    protected boolean m1100g() {
        if (m1095b()) {
            this.f655b.runOnUiThread(new C04407(this));
            return true;
        }
        this.f654a.error("Not supported");
        return false;
    }

    /* renamed from: h */
    protected boolean m1101h() {
        if (m1096c()) {
            this.f655b.runOnUiThread(new C04418(this));
            return true;
        }
        this.f654a.error("Not supported");
        return false;
    }

    /* renamed from: i */
    protected boolean m1102i() {
        if (m1096c()) {
            this.f655b.runOnUiThread(new C04429(this));
            return true;
        }
        this.f654a.error("Not supported");
        return false;
    }

    /* renamed from: j */
    protected boolean m1103j() {
        if (m1096c()) {
            this.f655b.runOnUiThread(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ FullScreenPlugin f641a;

                /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$10$1 */
                class C04311 implements OnFocusChangeListener {
                    /* renamed from: a */
                    final /* synthetic */ AnonymousClass10 f639a;

                    C04311(AnonymousClass10 anonymousClass10) {
                        this.f639a = anonymousClass10;
                    }

                    public void onFocusChange(View view, boolean z) {
                        if (z) {
                            this.f639a.f641a.f657d.setSystemUiVisibility(5894);
                        }
                    }
                }

                /* renamed from: com.mesmotronic.plugins.FullScreenPlugin$10$2 */
                class C04322 implements OnSystemUiVisibilityChangeListener {
                    /* renamed from: a */
                    final /* synthetic */ AnonymousClass10 f640a;

                    C04322(AnonymousClass10 anonymousClass10) {
                        this.f640a = anonymousClass10;
                    }

                    public void onSystemUiVisibilityChange(int i) {
                        this.f640a.f641a.f657d.setSystemUiVisibility(5894);
                    }
                }

                {
                    this.f641a = r1;
                }

                public void run() {
                    try {
                        this.f641a.m1093a();
                        this.f641a.f656c.addFlags(1024);
                        this.f641a.f657d.setSystemUiVisibility(5894);
                        this.f641a.f657d.setOnFocusChangeListener(new C04311(this));
                        this.f641a.f657d.setOnSystemUiVisibilityChangeListener(new C04322(this));
                        this.f641a.f654a.success();
                    } catch (Exception e) {
                        this.f641a.f654a.error(e.getMessage());
                    }
                }
            });
            return true;
        }
        this.f654a.error("Not supported");
        return false;
    }

    /* renamed from: a */
    protected boolean m1094a(final int i) {
        if (m1095b()) {
            this.f655b.runOnUiThread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ FullScreenPlugin f644b;

                public void run() {
                    try {
                        this.f644b.m1093a();
                        this.f644b.f657d.setSystemUiVisibility(i);
                        this.f644b.f654a.success();
                    } catch (Exception e) {
                        this.f644b.f654a.error(e.getMessage());
                    }
                }
            });
            return true;
        }
        this.f654a.error("Not supported");
        return false;
    }

    /* renamed from: a */
    private void m1086a(String str) {
        if (VERSION.SDK_INT >= 21 && str != null && !str.isEmpty()) {
            Window window = this.cordova.getActivity().getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            try {
                window.getClass().getDeclaredMethod("setStatusBarColor", new Class[]{Integer.TYPE}).invoke(window, new Object[]{Integer.valueOf(Color.parseColor(str))});
            } catch (IllegalArgumentException e) {
            } catch (Exception e2) {
            }
        }
    }
}
