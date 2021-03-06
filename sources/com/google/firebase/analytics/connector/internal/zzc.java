package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.android.gms.measurement.internal.zzcu;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzc {
    private static final Set<String> zzbsw = new HashSet(Arrays.asList(new String[]{"_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}));
    private static final List<String> zzbsx = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", Event.APP_OPEN});
    private static final List<String> zzbsy = Arrays.asList(new String[]{"auto", "app", "am"});
    private static final List<String> zzbsz = Arrays.asList(new String[]{"_r", "_dbg"});
    private static final List<String> zzbta = Arrays.asList((String[]) ArrayUtils.concat(UserProperty.zzaqu, UserProperty.zzaqv));
    private static final List<String> zzbtb = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    public static boolean zzft(String str) {
        return !zzbsy.contains(str);
    }

    public static boolean zza(String str, Bundle bundle) {
        if (zzbsx.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String containsKey : zzbsz) {
                if (bundle.containsKey(containsKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean zzfu(String str) {
        return !zzbsw.contains(str);
    }

    public static boolean zzz(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc");
        } else {
            if (UserProperty.FIREBASE_LAST_NOTIFICATION.equals(str2)) {
                return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals(AppMeasurement.FIAM_ORIGIN);
            } else {
                if (zzbta.contains(str2)) {
                    return false;
                }
                for (String matches : zzbtb) {
                    if (str2.matches(matches)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static boolean zza(ConditionalUserProperty conditionalUserProperty) {
        if (conditionalUserProperty == null) {
            return false;
        }
        String str = conditionalUserProperty.origin;
        if (str == null || str.isEmpty()) {
            return false;
        }
        if ((conditionalUserProperty.value != null && zzdw.zze(conditionalUserProperty.value) == null) || !zzft(str) || !zzz(str, conditionalUserProperty.name)) {
            return false;
        }
        if (conditionalUserProperty.expiredEventName != null && (!zza(conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams) || !zzb(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
            return false;
        }
        if (conditionalUserProperty.triggeredEventName != null && (!zza(conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams) || !zzb(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
            return false;
        }
        if (conditionalUserProperty.timedOutEventName == null || (zza(conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams) && zzb(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams))) {
            return true;
        }
        return false;
    }

    public static boolean zzb(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzft(str)) {
            return false;
        }
        if (bundle == null) {
            return false;
        }
        for (String containsKey : zzbsz) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case 101200:
                if (str.equals(AppMeasurement.FCM_ORIGIN)) {
                    obj = null;
                    break;
                }
                break;
            case 101230:
                if (str.equals("fdl")) {
                    int i = 1;
                    break;
                }
                break;
            case 3142703:
                if (str.equals(AppMeasurement.FIAM_ORIGIN)) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                bundle.putString("_cis", "fcm_integration");
                return true;
            case 1:
                bundle.putString("_cis", "fdl_integration");
                return true;
            case 2:
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    public static AppMeasurement.ConditionalUserProperty zzb(ConditionalUserProperty conditionalUserProperty) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty2.mOrigin = conditionalUserProperty.origin;
        conditionalUserProperty2.mActive = conditionalUserProperty.active;
        conditionalUserProperty2.mCreationTimestamp = conditionalUserProperty.creationTimestamp;
        conditionalUserProperty2.mExpiredEventName = conditionalUserProperty.expiredEventName;
        if (conditionalUserProperty.expiredEventParams != null) {
            conditionalUserProperty2.mExpiredEventParams = new Bundle(conditionalUserProperty.expiredEventParams);
        }
        conditionalUserProperty2.mName = conditionalUserProperty.name;
        conditionalUserProperty2.mTimedOutEventName = conditionalUserProperty.timedOutEventName;
        if (conditionalUserProperty.timedOutEventParams != null) {
            conditionalUserProperty2.mTimedOutEventParams = new Bundle(conditionalUserProperty.timedOutEventParams);
        }
        conditionalUserProperty2.mTimeToLive = conditionalUserProperty.timeToLive;
        conditionalUserProperty2.mTriggeredEventName = conditionalUserProperty.triggeredEventName;
        if (conditionalUserProperty.triggeredEventParams != null) {
            conditionalUserProperty2.mTriggeredEventParams = new Bundle(conditionalUserProperty.triggeredEventParams);
        }
        conditionalUserProperty2.mTriggeredTimestamp = conditionalUserProperty.triggeredTimestamp;
        conditionalUserProperty2.mTriggerEventName = conditionalUserProperty.triggerEventName;
        conditionalUserProperty2.mTriggerTimeout = conditionalUserProperty.triggerTimeout;
        if (conditionalUserProperty.value != null) {
            conditionalUserProperty2.mValue = zzdw.zze(conditionalUserProperty.value);
        }
        return conditionalUserProperty2;
    }

    public static ConditionalUserProperty zzd(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty();
        conditionalUserProperty2.origin = conditionalUserProperty.mOrigin;
        conditionalUserProperty2.active = conditionalUserProperty.mActive;
        conditionalUserProperty2.creationTimestamp = conditionalUserProperty.mCreationTimestamp;
        conditionalUserProperty2.expiredEventName = conditionalUserProperty.mExpiredEventName;
        if (conditionalUserProperty.mExpiredEventParams != null) {
            conditionalUserProperty2.expiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
        }
        conditionalUserProperty2.name = conditionalUserProperty.mName;
        conditionalUserProperty2.timedOutEventName = conditionalUserProperty.mTimedOutEventName;
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            conditionalUserProperty2.timedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
        }
        conditionalUserProperty2.timeToLive = conditionalUserProperty.mTimeToLive;
        conditionalUserProperty2.triggeredEventName = conditionalUserProperty.mTriggeredEventName;
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            conditionalUserProperty2.triggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
        }
        conditionalUserProperty2.triggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
        conditionalUserProperty2.triggerEventName = conditionalUserProperty.mTriggerEventName;
        conditionalUserProperty2.triggerTimeout = conditionalUserProperty.mTriggerTimeout;
        if (conditionalUserProperty.mValue != null) {
            conditionalUserProperty2.value = zzdw.zze(conditionalUserProperty.mValue);
        }
        return conditionalUserProperty2;
    }

    public static boolean zzfv(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int codePointAt = str.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            return false;
        }
        int length = str.length();
        codePointAt = Character.charCount(codePointAt);
        while (codePointAt < length) {
            int codePointAt2 = str.codePointAt(codePointAt);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                return false;
            }
            codePointAt += Character.charCount(codePointAt2);
        }
        return true;
    }

    public static boolean zzfw(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int codePointAt = str.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            return false;
        }
        int length = str.length();
        codePointAt = Character.charCount(codePointAt);
        while (codePointAt < length) {
            int codePointAt2 = str.codePointAt(codePointAt);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                return false;
            }
            codePointAt += Character.charCount(codePointAt2);
        }
        return true;
    }

    public static String zzfx(String str) {
        String zzcn = zzcu.zzcn(str);
        if (zzcn != null) {
            return zzcn;
        }
        return str;
    }

    public static String zzfy(String str) {
        String zzco = zzcu.zzco(str);
        if (zzco != null) {
            return zzco;
        }
        return str;
    }
}
