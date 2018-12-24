package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.p017e.C0238a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.internal.zzbw;
import com.google.android.gms.measurement.internal.zzcu;
import com.google.android.gms.measurement.internal.zzcv;
import com.google.android.gms.measurement.internal.zzcw;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzfv;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@Deprecated
public class AppMeasurement {
    @ShowFirstParty
    @KeepForSdk
    public static final String CRASH_ORIGIN = "crash";
    @ShowFirstParty
    @KeepForSdk
    public static final String FCM_ORIGIN = "fcm";
    @ShowFirstParty
    @KeepForSdk
    public static final String FIAM_ORIGIN = "fiam";
    private final zzbw zzada;

    @ShowFirstParty
    @KeepForSdk
    public static class ConditionalUserProperty {
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public boolean mActive;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mAppId;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mName;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mOrigin;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mTriggerEventName;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public long mTriggeredTimestamp;
        @Keep
        @ShowFirstParty
        @KeepForSdk
        public Object mValue;

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            if (conditionalUserProperty.mValue != null) {
                this.mValue = zzdw.zze(conditionalUserProperty.mValue);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static final class Event extends zzcu {
        @ShowFirstParty
        @KeepForSdk
        public static final String AD_REWARD = "_ar";
        @ShowFirstParty
        @KeepForSdk
        public static final String APP_EXCEPTION = "_ae";

        private Event() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzcx {
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzcy {
        @ShowFirstParty
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    @ShowFirstParty
    @KeepForSdk
    public static final class Param extends zzcv {
        @ShowFirstParty
        @KeepForSdk
        public static final String FATAL = "fatal";
        @ShowFirstParty
        @KeepForSdk
        public static final String TIMESTAMP = "timestamp";
        @ShowFirstParty
        @KeepForSdk
        public static final String TYPE = "type";

        private Param() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static final class UserProperty extends zzcw {
        @ShowFirstParty
        @KeepForSdk
        public static final String FIREBASE_LAST_NOTIFICATION = "_ln";

        private UserProperty() {
        }
    }

    @Keep
    @ShowFirstParty
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zzbw.zza(context, null).zzkm();
    }

    @ShowFirstParty
    public final void logEvent(String str, Bundle bundle) {
        this.zzada.zzgj().zza("app", str, bundle, true);
    }

    @ShowFirstParty
    public final void setUserProperty(String str, String str2) {
        this.zzada.zzgj().zzb("app", str, (Object) str2, false);
    }

    @KeepForSdk
    @Deprecated
    public void setMeasurementEnabled(boolean z) {
        this.zzada.zzgj().setMeasurementEnabled(z);
    }

    public final void zzd(boolean z) {
        this.zzada.zzgj().zzd(z);
    }

    @ShowFirstParty
    public final void setMinimumSessionDuration(long j) {
        this.zzada.zzgj().setMinimumSessionDuration(j);
    }

    @ShowFirstParty
    public final void setSessionTimeoutDuration(long j) {
        this.zzada.zzgj().setSessionTimeoutDuration(j);
    }

    public AppMeasurement(zzbw zzbw) {
        Preconditions.checkNotNull(zzbw);
        this.zzada = zzbw;
    }

    @Keep
    @ShowFirstParty
    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.zzada.zzgj().logEvent(str, str2, bundle);
    }

    @ShowFirstParty
    @KeepForSdk
    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzada.zzgj().logEvent(str, str2, bundle, true, false, j);
    }

    @ShowFirstParty
    @KeepForSdk
    public void setUserPropertyInternal(String str, String str2, Object obj) {
        Preconditions.checkNotEmpty(str);
        this.zzada.zzgj().zzb(str, str2, obj, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        List<zzfv> zzk = this.zzada.zzgj().zzk(z);
        Map<String, Object> c0238a = new C0238a(zzk.size());
        for (zzfv zzfv : zzk) {
            c0238a.put(zzfv.name, zzfv.getValue());
        }
        return c0238a;
    }

    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zzada.zzgj().zza((zzcx) eventInterceptor);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzada.zzgj().zza((zzcy) onEventListener);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzada.zzgj().zzb((zzcy) onEventListener);
    }

    @Keep
    public String getCurrentScreenName() {
        return this.zzada.zzgj().getCurrentScreenName();
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.zzada.zzgj().getCurrentScreenClass();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzada.zzgj().zzgc();
    }

    @Keep
    public String getGmpAppId() {
        return this.zzada.zzgj().getGmpAppId();
    }

    @Keep
    public long generateEventId() {
        return this.zzada.zzgr().zzmj();
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zzada.zzgi().beginAdUnitExposure(str, this.zzada.zzbx().elapsedRealtime());
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zzada.zzgi().endAdUnitExposure(str, this.zzada.zzbx().elapsedRealtime());
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.zzada.zzgj().setConditionalUserProperty(conditionalUserProperty);
    }

    @Keep
    @VisibleForTesting
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.zzada.zzgj().setConditionalUserPropertyAs(conditionalUserProperty);
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzada.zzgj().clearConditionalUserProperty(str, str2, bundle);
    }

    @Keep
    @VisibleForTesting
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        this.zzada.zzgj().clearConditionalUserPropertyAs(str, str2, str3, bundle);
    }

    @Keep
    @VisibleForTesting
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzada.zzgj().getUserProperties(str, str2, z);
    }

    @Keep
    @VisibleForTesting
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        return this.zzada.zzgj().getUserPropertiesAs(str, str2, str3, z);
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.zzada.zzgj().getConditionalUserProperties(str, str2);
    }

    @Keep
    @VisibleForTesting
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        return this.zzada.zzgj().getConditionalUserPropertiesAs(str, str2, str3);
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    public int getMaxUserProperties(String str) {
        this.zzada.zzgj();
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @KeepForSdk
    public Boolean getBoolean() {
        return this.zzada.zzgj().zzkx();
    }

    @KeepForSdk
    public String getString() {
        return this.zzada.zzgj().zzky();
    }

    @KeepForSdk
    public Long getLong() {
        return this.zzada.zzgj().zzkz();
    }

    @KeepForSdk
    public Integer getInteger() {
        return this.zzada.zzgj().zzla();
    }

    @KeepForSdk
    public Double getDouble() {
        return this.zzada.zzgj().zzlb();
    }
}
