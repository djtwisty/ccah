package com.google.zxing.client.android.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;

public final class ClipboardInterface {
    private static final String TAG = ClipboardInterface.class.getSimpleName();

    private ClipboardInterface() {
    }

    public static CharSequence getText(Context context) {
        return hasText(context) ? getManager(context).getPrimaryClip().getItemAt(0).coerceToText(context) : null;
    }

    public static void setText(CharSequence charSequence, Context context) {
        Throwable e;
        if (charSequence != null) {
            try {
                getManager(context).setPrimaryClip(ClipData.newPlainText(null, charSequence));
                return;
            } catch (NullPointerException e2) {
                e = e2;
            } catch (IllegalStateException e3) {
                e = e3;
            }
        } else {
            return;
        }
        Log.w(TAG, "Clipboard bug", e);
    }

    public static boolean hasText(Context context) {
        ClipData primaryClip = getManager(context).getPrimaryClip();
        return primaryClip != null && primaryClip.getItemCount() > 0;
    }

    private static ClipboardManager getManager(Context context) {
        return (ClipboardManager) context.getSystemService("clipboard");
    }
}
