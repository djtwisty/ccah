package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.support.v4.p017e.C0237i;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.base.C0319R;
import com.google.android.gms.common.C0320R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;

public final class ConnectionErrorMessages {
    private static final C0237i<String, String> zaof = new C0237i();

    public static String getErrorTitle(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0319R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(C0319R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(C0319R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zaa(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zaa(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zaa(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zaa(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    public static String getErrorNotificationTitle(Context context, int i) {
        String zaa;
        if (i == 6) {
            zaa = zaa(context, "common_google_play_services_resolution_required_title");
        } else {
            zaa = getErrorTitle(context, i);
        }
        if (zaa == null) {
            return context.getResources().getString(C0319R.string.common_google_play_services_notification_ticker);
        }
        return zaa;
    }

    public static String getErrorMessage(Context context, int i) {
        Resources resources = context.getResources();
        String appName = getAppName(context);
        switch (i) {
            case 1:
                return resources.getString(C0319R.string.common_google_play_services_install_text, new Object[]{appName});
            case 2:
                if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                    return resources.getString(C0319R.string.common_google_play_services_wear_update_text);
                }
                return resources.getString(C0319R.string.common_google_play_services_update_text, new Object[]{appName});
            case 3:
                return resources.getString(C0319R.string.common_google_play_services_enable_text, new Object[]{appName});
            case 5:
                return zaa(context, "common_google_play_services_invalid_account_text", appName);
            case 7:
                return zaa(context, "common_google_play_services_network_error_text", appName);
            case 9:
                return resources.getString(C0319R.string.common_google_play_services_unsupported_text, new Object[]{appName});
            case 16:
                return zaa(context, "common_google_play_services_api_unavailable_text", appName);
            case 17:
                return zaa(context, "common_google_play_services_sign_in_failed_text", appName);
            case 18:
                return resources.getString(C0319R.string.common_google_play_services_updating_text, new Object[]{appName});
            case 20:
                return zaa(context, "common_google_play_services_restricted_profile_text", appName);
            default:
                return resources.getString(C0320R.string.common_google_play_services_unknown_issue, new Object[]{appName});
        }
    }

    public static String getErrorNotificationMessage(Context context, int i) {
        if (i == 6) {
            return zaa(context, "common_google_play_services_resolution_required_text", getAppName(context));
        }
        return getErrorMessage(context, i);
    }

    public static String getErrorDialogButtonMessage(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0319R.string.common_google_play_services_install_button);
            case 2:
                return resources.getString(C0319R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(C0319R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    public static String getAppName(Context context) {
        CharSequence charSequence;
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (NameNotFoundException e) {
            charSequence = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(charSequence)) {
                return charSequence;
            }
            return packageName;
        } catch (NullPointerException e2) {
            charSequence = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(charSequence)) {
                return packageName;
            }
            return charSequence;
        }
    }

    private static String zaa(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zaa = zaa(context, str);
        if (zaa == null) {
            zaa = resources.getString(C0320R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zaa, new Object[]{str2});
    }

    private static String zaa(Context context, String str) {
        synchronized (zaof) {
            String str2 = (String) zaof.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String str3 = "GoogleApiAvailability";
                String str4 = "Missing resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            str2 = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(str2)) {
                str3 = "GoogleApiAvailability";
                str4 = "Got empty resource: ";
                str2 = String.valueOf(str);
                Log.w(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4));
                return null;
            }
            zaof.put(str, str2);
            return str2;
        }
    }

    public static String getDefaultNotificationChannelName(Context context) {
        return context.getResources().getString(C0319R.string.common_google_play_services_notification_channel_name);
    }

    private ConnectionErrorMessages() {
    }
}
