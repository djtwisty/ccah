package org.apache.cordova;

import android.content.Context;

public class BuildHelper {
    private static String TAG = "BuildHelper";

    public static Object getBuildConfigValue(Context context, String str) {
        Object obj = null;
        try {
            obj = Class.forName(context.getPackageName() + ".BuildConfig").getField(str).get(null);
        } catch (ClassNotFoundException e) {
            LOG.m1345d(TAG, "Unable to get the BuildConfig, is this built with ANT?");
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            LOG.m1345d(TAG, str + " is not a valid field. Check your build.gradle");
        } catch (IllegalAccessException e3) {
            LOG.m1345d(TAG, "Illegal Access Exception: Let's print a stack trace.");
            e3.printStackTrace();
        }
        return obj;
    }
}
