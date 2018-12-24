package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.C0498a;
import me.leolin.shortcutbadger.C0499b;

public class NovaHomeBadger implements C0498a {
    /* renamed from: a */
    public void mo1636a(Context context, ComponentName componentName, int i) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("tag", componentName.getPackageName() + "/" + componentName.getClassName());
            contentValues.put("count", Integer.valueOf(i));
            context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
        } catch (IllegalArgumentException e) {
        } catch (Exception e2) {
            throw new C0499b(e2.getMessage());
        }
    }

    /* renamed from: a */
    public List<String> mo1635a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }
}
