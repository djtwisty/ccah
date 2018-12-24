package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

final class zzbf {
    private static volatile DynamiteModule zzbbw;
    private static volatile zzcp zzbbx;
    private static final Map<String, CustomTagProvider> zzbby = new HashMap();
    private static final Map<String, CustomVariableProvider> zzbbz = new HashMap();

    private zzbf() {
    }

    static IBinder zzq(Context context) {
        try {
            return zzct.asInterface(zzt(context).instantiate("com.google.android.gms.tagmanager.TagManagerServiceProviderImpl")).getService(ObjectWrapper.wrap(context), zzu(context), new zzbj()).asBinder();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    static void zzr(Context context) {
        zzcp zzs = zzs(context);
        synchronized (zzbf.class) {
            try {
                zzs.initialize(ObjectWrapper.wrap(context), zzu(context), new zzbj());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    static void zza(Intent intent, Context context) {
        zzcp zzs = zzs(context);
        synchronized (zzbf.class) {
            try {
                zzs.previewIntent(intent, ObjectWrapper.wrap(context), ObjectWrapper.wrap(zzbbw.getModuleContext()), zzu(context), new zzbj());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static zzcp zzs(Context context) {
        zzcp zzcp = zzbbx;
        if (zzcp == null) {
            synchronized (zzbf.class) {
                zzcp = zzbbx;
                if (zzcp == null) {
                    try {
                        zzcp = zzcq.asInterface(zzt(context).instantiate("com.google.android.gms.tagmanager.TagManagerApiImpl"));
                        zzbbx = zzcp;
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return zzcp;
    }

    private static DynamiteModule zzt(Context context) {
        DynamiteModule dynamiteModule = zzbbw;
        if (dynamiteModule == null) {
            synchronized (zzbf.class) {
                dynamiteModule = zzbbw;
                if (zzbbw == null) {
                    dynamiteModule = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, ModuleDescriptor.MODULE_ID);
                    zzbbw = dynamiteModule;
                }
            }
        }
        return dynamiteModule;
    }

    private static zzcm zzu(Context context) {
        return new zzbg(AppMeasurement.getInstance(context));
    }

    private static Object zza(String str, Class<?> cls) {
        Object obj = null;
        Object obj2 = null;
        try {
            Class cls2 = Class.forName(str);
            for (Object equals : cls2.getInterfaces()) {
                if (equals.equals(cls)) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                String canonicalName = cls.getCanonicalName();
                Log.e("GoogleTagManagerAPI", new StringBuilder((String.valueOf(str).length() + 30) + String.valueOf(canonicalName).length()).append(str).append(" doesn't implement ").append(canonicalName).append(" interface.").toString());
            } else {
                try {
                    obj2 = cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (NoSuchMethodException e) {
                    Log.e("GoogleTagManagerAPI", String.valueOf(str).concat(" doesn't have a valid no-arg constructor"));
                } catch (SecurityException e2) {
                    Log.e("GoogleTagManagerAPI", String.valueOf(str).concat(" doesn't have an accessible no-arg constructor"));
                } catch (InvocationTargetException e3) {
                    Log.e("GoogleTagManagerAPI", String.valueOf(str).concat(" construction threw an exception."));
                } catch (InstantiationException e4) {
                    Log.e("GoogleTagManagerAPI", String.valueOf(str).concat(" is an abstract class."));
                } catch (IllegalAccessException e5) {
                    Log.e("GoogleTagManagerAPI", String.valueOf(str).concat(" doesn't have an accessible no-arg constructor"));
                }
            }
        } catch (ClassNotFoundException e6) {
            Log.e("GoogleTagManagerAPI", String.valueOf(str).concat(" can't be found in the application."));
        }
        return obj2;
    }
}
