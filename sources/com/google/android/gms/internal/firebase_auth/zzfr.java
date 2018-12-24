package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzfr<T extends zzfg> {
    private static final Logger logger = Logger.getLogger(zzfa.class.getName());
    private static String zzww = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzfr() {
    }

    protected abstract T zzhc();

    static <T extends zzfg> T zza(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzfr.class.getClassLoader();
        if (cls.equals(zzfg.class)) {
            str = zzww;
        } else if (cls.getPackage().equals(zzfr.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzfg) cls.cast(((zzfr) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzhc());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        } catch (Throwable e2) {
            throw new IllegalStateException(e2);
        } catch (Throwable e22) {
            throw new IllegalStateException(e22);
        } catch (Throwable e222) {
            throw new IllegalStateException(e222);
        } catch (ClassNotFoundException e3) {
            Iterator it = ServiceLoader.load(zzfr.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzfg) cls.cast(((zzfr) it.next()).zzhc()));
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
                return (zzfg) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzfg) cls.getMethod("combine", new Class[]{Collection.class}).invoke(null, new Object[]{arrayList});
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
