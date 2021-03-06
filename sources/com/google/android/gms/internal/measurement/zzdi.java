package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(24)
public final class zzdi {
    private static final Method zzacv = zzfu();
    private static final Method zzacw = zzfv();
    private static volatile zzdk zzacx = zzdj.zzacy;
    private final JobScheduler zzacu;

    private static Method zzfu() {
        if (VERSION.SDK_INT >= 24) {
            try {
                return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[]{JobInfo.class, String.class, Integer.TYPE, String.class});
            } catch (NoSuchMethodException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
            }
        }
        return null;
    }

    private static Method zzfv() {
        Method method = null;
        if (VERSION.SDK_INT >= 24) {
            try {
                method = UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        return method;
    }

    private static int zzfw() {
        Throwable e;
        if (zzacw != null) {
            try {
                return ((Integer) zzacw.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException e2) {
                e = e2;
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
                return 0;
            } catch (InvocationTargetException e3) {
                e = e3;
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
                return 0;
            }
        }
        return 0;
    }

    private zzdi(JobScheduler jobScheduler) {
        this.zzacu = jobScheduler;
    }

    private final int zza(JobInfo jobInfo, String str, int i, String str2) {
        Throwable e;
        if (zzacv != null) {
            try {
                return ((Integer) zzacv.invoke(this.zzacu, new Object[]{jobInfo, str, Integer.valueOf(i), str2})).intValue();
            } catch (IllegalAccessException e2) {
                e = e2;
                Log.e(str2, "error calling scheduleAsPackage", e);
                return this.zzacu.schedule(jobInfo);
            } catch (InvocationTargetException e3) {
                e = e3;
                Log.e(str2, "error calling scheduleAsPackage", e);
                return this.zzacu.schedule(jobInfo);
            }
        }
        return this.zzacu.schedule(jobInfo);
    }

    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (zzacv != null && zzacx.zzfy() && context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0) {
            return new zzdi(jobScheduler).zza(jobInfo, str, zzfw(), str2);
        }
        return jobScheduler.schedule(jobInfo);
    }
}
