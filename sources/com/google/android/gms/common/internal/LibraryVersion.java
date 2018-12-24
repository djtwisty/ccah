package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.cookie.ClientCookie;

@KeepForSdk
public class LibraryVersion {
    private static final GmsLogger zzel = new GmsLogger("LibraryVersion", "");
    private static LibraryVersion zzem = new LibraryVersion();
    private ConcurrentHashMap<String, String> zzen = new ConcurrentHashMap();

    @KeepForSdk
    public static LibraryVersion getInstance() {
        return zzem;
    }

    @VisibleForTesting
    protected LibraryVersion() {
    }

    @KeepForSdk
    public String getVersion(String str) {
        String str2;
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.zzen.containsKey(str)) {
            return (String) this.zzen.get(str);
        }
        Properties properties = new Properties();
        String str3;
        try {
            InputStream resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", new Object[]{str}));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                String property = properties.getProperty(ClientCookie.VERSION_ATTR, null);
                zzel.m1066v("LibraryVersion", new StringBuilder((String.valueOf(str).length() + 12) + String.valueOf(property).length()).append(str).append(" version is ").append(property).toString());
                str2 = property;
            } else {
                GmsLogger gmsLogger = zzel;
                String str4 = "LibraryVersion";
                str3 = "Failed to get app version for libraryName: ";
                str2 = String.valueOf(str);
                gmsLogger.m1062e(str4, str2.length() != 0 ? str3.concat(str2) : new String(str3));
                str2 = null;
            }
        } catch (Throwable e) {
            Throwable th = e;
            GmsLogger gmsLogger2 = zzel;
            str3 = "LibraryVersion";
            String str5 = "Failed to get app version for libraryName: ";
            str2 = String.valueOf(str);
            gmsLogger2.m1063e(str3, str2.length() != 0 ? str5.concat(str2) : new String(str5), th);
            str2 = null;
        }
        if (str2 == null) {
            str2 = "UNKNOWN";
            zzel.m1060d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
        }
        this.zzen.put(str, str2);
        return str2;
    }
}
