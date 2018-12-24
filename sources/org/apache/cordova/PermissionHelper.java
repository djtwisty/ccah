package org.apache.cordova;

import java.util.Arrays;

public class PermissionHelper {
    private static final String LOG_TAG = "CordovaPermissionHelper";

    public static void requestPermission(CordovaPlugin cordovaPlugin, int i, String str) {
        requestPermissions(cordovaPlugin, i, new String[]{str});
    }

    public static void requestPermissions(CordovaPlugin cordovaPlugin, int i, String[] strArr) {
        try {
            CordovaInterface.class.getDeclaredMethod("requestPermissions", new Class[]{CordovaPlugin.class, Integer.TYPE, String[].class}).invoke(cordovaPlugin.cordova, new Object[]{cordovaPlugin, Integer.valueOf(i), strArr});
        } catch (NoSuchMethodException e) {
            LOG.m1345d(LOG_TAG, "No need to request permissions " + Arrays.toString(strArr));
            deliverPermissionResult(cordovaPlugin, i, strArr);
        } catch (Throwable e2) {
            LOG.m1349e(LOG_TAG, "IllegalAccessException when requesting permissions " + Arrays.toString(strArr), e2);
        } catch (Throwable e22) {
            LOG.m1349e(LOG_TAG, "invocationTargetException when requesting permissions " + Arrays.toString(strArr), e22);
        }
    }

    public static boolean hasPermission(CordovaPlugin cordovaPlugin, String str) {
        try {
            return ((Boolean) CordovaInterface.class.getDeclaredMethod("hasPermission", new Class[]{String.class}).invoke(cordovaPlugin.cordova, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException e) {
            LOG.m1345d(LOG_TAG, "No need to check for permission " + str);
            return true;
        } catch (Throwable e2) {
            LOG.m1349e(LOG_TAG, "IllegalAccessException when checking permission " + str, e2);
            return false;
        } catch (Throwable e22) {
            LOG.m1349e(LOG_TAG, "invocationTargetException when checking permission " + str, e22);
            return false;
        }
    }

    private static void deliverPermissionResult(CordovaPlugin cordovaPlugin, int i, String[] strArr) {
        Arrays.fill(new int[strArr.length], 0);
        try {
            CordovaPlugin.class.getDeclaredMethod("onRequestPermissionResult", new Class[]{Integer.TYPE, String[].class, int[].class}).invoke(cordovaPlugin, new Object[]{Integer.valueOf(i), strArr, r0});
        } catch (Throwable e) {
            LOG.m1349e(LOG_TAG, "NoSuchMethodException when delivering permissions results", e);
        } catch (Throwable e2) {
            LOG.m1349e(LOG_TAG, "IllegalAccessException when delivering permissions results", e2);
        } catch (Throwable e22) {
            LOG.m1349e(LOG_TAG, "InvocationTargetException when delivering permissions results", e22);
        }
    }
}
