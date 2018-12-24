package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzum<T extends zzub> {
    private static final Logger logger = Logger.getLogger(zztv.class.getName());
    private static String zzbyb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzum() {
    }

    protected abstract T zzwd();

    static <T extends zzub> T zzd(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzum.class.getClassLoader();
        if (cls.equals(zzub.class)) {
            str = zzbyb;
        } else if (cls.getPackage().equals(zzum.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzub) cls.cast(((zzum) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzwd());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        } catch (Throwable e2) {
            throw new IllegalStateException(e2);
        } catch (Throwable e22) {
            throw new IllegalStateException(e22);
        } catch (Throwable e222) {
            throw new IllegalStateException(e222);
        } catch (ClassNotFoundException e3) {
            Iterator it = ServiceLoader.load(zzum.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzub) cls.cast(((zzum) it.next()).zzwd()));
                } catch (Throwable e4) {
                    Logger logger = logger;
                    Level level = Level.SEVERE;
                    String str2 = "com.google.protobuf.GeneratedExtensionRegistryLoader";
                    String str3 = "load";
                    String str4 = "Unable to load ";
                    String valueOf = String.valueOf(cls.getSimpleName());
                    if (valueOf.length() != 0) {
                        valueOf = str4.concat(valueOf);
                    } else {
                        valueOf = new String(str4);
                    }
                    logger.logp(level, str2, str3, valueOf, e4);
                }
            }
            if (arrayList.size() == 1) {
                return (zzub) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzub) cls.getMethod("combine", new Class[]{Collection.class}).invoke(null, new Object[]{arrayList});
            } catch (Throwable e2222) {
                throw new IllegalStateException(e2222);
            } catch (Throwable e22222) {
                throw new IllegalStateException(e22222);
            } catch (Throwable e222222) {
                throw new IllegalStateException(e222222);
            }
        }
    }
}
