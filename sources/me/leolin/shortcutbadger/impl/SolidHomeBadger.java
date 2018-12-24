package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C0498a;

public class SolidHomeBadger implements C0498a {
    /* renamed from: a */
    public void mo1636a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.majeur.launcher.intent.action.UPDATE_BADGE");
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_PACKAGE", componentName.getPackageName());
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_COUNT", i);
        intent.putExtra("com.majeur.launcher.intent.extra.BADGE_CLASS", componentName.getClassName());
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public List<String> mo1635a() {
        return Arrays.asList(new String[]{"com.majeur.launcher"});
    }
}
