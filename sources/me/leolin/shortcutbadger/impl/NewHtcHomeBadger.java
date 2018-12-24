package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C0498a;

public class NewHtcHomeBadger implements C0498a {
    /* renamed from: a */
    public void mo1636a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i);
        context.sendBroadcast(intent);
        intent = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent.putExtra("packagename", componentName.getPackageName());
        intent.putExtra("count", i);
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public List<String> mo1635a() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }
}
