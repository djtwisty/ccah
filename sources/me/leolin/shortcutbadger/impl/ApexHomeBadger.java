package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C0498a;

public class ApexHomeBadger implements C0498a {
    /* renamed from: a */
    public void mo1636a(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", componentName.getPackageName());
        intent.putExtra("count", i);
        intent.putExtra("class", componentName.getClassName());
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public List<String> mo1635a() {
        return Arrays.asList(new String[]{"com.anddoes.launcher"});
    }
}
