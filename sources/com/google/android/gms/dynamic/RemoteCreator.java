package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class RemoteCreator<T> {
    private final String zzib;
    private T zzic;

    @KeepForSdk
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    @KeepForSdk
    protected RemoteCreator(String str) {
        this.zzib = str;
    }

    @KeepForSdk
    protected abstract T getRemoteCreator(IBinder iBinder);

    @KeepForSdk
    protected final T getRemoteCreatorInstance(Context context) {
        if (this.zzic == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.zzic = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zzib).newInstance());
            } catch (Throwable e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new RemoteCreatorException("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new RemoteCreatorException("Could not access creator.", e22);
            }
        }
        return this.zzic;
    }
}
