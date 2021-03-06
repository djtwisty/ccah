package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v4.p017e.C0238a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.OptionalApiSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class zax implements zabs {
    private final Looper zabj;
    private final GoogleApiManager zabm;
    private final Lock zaen;
    private final ClientSettings zaes;
    private final Map<AnyClientKey<?>, zaw<?>> zaet = new HashMap();
    private final Map<AnyClientKey<?>, zaw<?>> zaeu = new HashMap();
    private final Map<Api<?>, Boolean> zaev;
    private final zaaw zaew;
    private final GoogleApiAvailabilityLight zaex;
    private final Condition zaey;
    private final boolean zaez;
    private final boolean zafa;
    private final Queue<ApiMethodImpl<?, ?>> zafb = new LinkedList();
    private boolean zafc;
    private Map<zai<?>, ConnectionResult> zafd;
    private Map<zai<?>, ConnectionResult> zafe;
    private zaaa zaff;
    private ConnectionResult zafg;

    public zax(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<AnyClientKey<?>, Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zaaw zaaw, boolean z) {
        this.zaen = lock;
        this.zabj = looper;
        this.zaey = lock.newCondition();
        this.zaex = googleApiAvailabilityLight;
        this.zaew = zaaw;
        this.zaev = map2;
        this.zaes = clientSettings;
        this.zaez = z;
        Map hashMap = new HashMap();
        for (Api api : map2.keySet()) {
            hashMap.put(api.getClientKey(), api);
        }
        Map hashMap2 = new HashMap();
        arrayList = arrayList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            zaq zaq = (zaq) obj;
            hashMap2.put(zaq.mApi, zaq);
        }
        Object obj2 = null;
        Object obj3 = 1;
        Object obj4 = null;
        for (Entry entry : map.entrySet()) {
            Object obj5;
            Object obj6;
            Object obj7;
            Api api2 = (Api) hashMap.get(entry.getKey());
            Client client = (Client) entry.getValue();
            if (client.requiresGooglePlayServices()) {
                obj5 = 1;
                if (((Boolean) this.zaev.get(api2)).booleanValue()) {
                    obj6 = obj3;
                    obj7 = obj4;
                } else {
                    obj6 = obj3;
                    obj7 = 1;
                }
            } else {
                obj5 = obj2;
                obj6 = null;
                obj7 = obj4;
            }
            zaw zaw = new zaw(context, api2, looper, client, (zaq) hashMap2.get(api2), clientSettings, abstractClientBuilder);
            this.zaet.put((AnyClientKey) entry.getKey(), zaw);
            if (client.requiresSignIn()) {
                this.zaeu.put((AnyClientKey) entry.getKey(), zaw);
            }
            obj2 = obj5;
            obj3 = obj6;
            obj4 = obj7;
        }
        boolean z2 = obj2 != null && obj3 == null && obj4 == null;
        this.zafa = z2;
        this.zabm = GoogleApiManager.zabc();
    }

    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        if (this.zaez && zab((ApiMethodImpl) t)) {
            return t;
        }
        if (isConnected()) {
            this.zaew.zahe.zab(t);
            return ((zaw) this.zaet.get(t.getClientKey())).doRead((ApiMethodImpl) t);
        }
        this.zafb.add(t);
        return t;
    }

    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AnyClientKey clientKey = t.getClientKey();
        if (this.zaez && zab((ApiMethodImpl) t)) {
            return t;
        }
        this.zaew.zahe.zab(t);
        return ((zaw) this.zaet.get(clientKey)).doWrite((ApiMethodImpl) t);
    }

    private final <T extends ApiMethodImpl<? extends Result, ? extends AnyClient>> boolean zab(T t) {
        AnyClientKey clientKey = t.getClientKey();
        ConnectionResult zaa = zaa(clientKey);
        if (zaa == null || zaa.getErrorCode() != 4) {
            return false;
        }
        t.setFailedResult(new Status(4, null, this.zabm.zaa(((zaw) this.zaet.get(clientKey)).zak(), System.identityHashCode(this.zaew))));
        return true;
    }

    public final void connect() {
        this.zaen.lock();
        try {
            if (!this.zafc) {
                this.zafc = true;
                this.zafd = null;
                this.zafe = null;
                this.zaff = null;
                this.zafg = null;
                this.zabm.zao();
                this.zabm.zaa(this.zaet.values()).addOnCompleteListener(new HandlerExecutor(this.zabj), new zaz());
                this.zaen.unlock();
            }
        } finally {
            this.zaen.unlock();
        }
    }

    public final ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zaey.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zafg != null) {
            return this.zafg;
        }
        return new ConnectionResult(13, null);
    }

    public final ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long toNanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (toNanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            }
            toNanos = this.zaey.awaitNanos(toNanos);
        }
        if (isConnected()) {
            return ConnectionResult.RESULT_SUCCESS;
        }
        if (this.zafg != null) {
            return this.zafg;
        }
        return new ConnectionResult(13, null);
    }

    public final void disconnect() {
        this.zaen.lock();
        try {
            this.zafc = false;
            this.zafd = null;
            this.zafe = null;
            if (this.zaff != null) {
                this.zaff.cancel();
                this.zaff = null;
            }
            this.zafg = null;
            while (!this.zafb.isEmpty()) {
                ApiMethodImpl apiMethodImpl = (ApiMethodImpl) this.zafb.remove();
                apiMethodImpl.zaa(null);
                apiMethodImpl.cancel();
            }
            this.zaey.signalAll();
        } finally {
            this.zaen.unlock();
        }
    }

    public final ConnectionResult getConnectionResult(Api<?> api) {
        return zaa(api.getClientKey());
    }

    private final ConnectionResult zaa(AnyClientKey<?> anyClientKey) {
        this.zaen.lock();
        try {
            zaw zaw = (zaw) this.zaet.get(anyClientKey);
            if (this.zafd == null || zaw == null) {
                this.zaen.unlock();
                return null;
            }
            ConnectionResult connectionResult = (ConnectionResult) this.zafd.get(zaw.zak());
            return connectionResult;
        } finally {
            this.zaen.unlock();
        }
    }

    public final boolean isConnected() {
        this.zaen.lock();
        try {
            boolean z = this.zafd != null && this.zafg == null;
            this.zaen.unlock();
            return z;
        } catch (Throwable th) {
            this.zaen.unlock();
        }
    }

    public final boolean isConnecting() {
        this.zaen.lock();
        try {
            boolean z = this.zafd == null && this.zafc;
            this.zaen.unlock();
            return z;
        } catch (Throwable th) {
            this.zaen.unlock();
        }
    }

    private final boolean zaac() {
        this.zaen.lock();
        try {
            if (this.zafc && this.zaez) {
                for (AnyClientKey zaa : this.zaeu.keySet()) {
                    ConnectionResult zaa2 = zaa(zaa);
                    if (zaa2 != null) {
                        if (!zaa2.isSuccess()) {
                        }
                    }
                    this.zaen.unlock();
                    return false;
                }
                this.zaen.unlock();
                return true;
            }
            this.zaen.unlock();
            return false;
        } catch (Throwable th) {
            this.zaen.unlock();
        }
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        this.zaen.lock();
        try {
            if (!this.zafc || zaac()) {
                this.zaen.unlock();
                return false;
            }
            this.zabm.zao();
            this.zaff = new zaaa(this, signInConnectionListener);
            this.zabm.zaa(this.zaeu.values()).addOnCompleteListener(new HandlerExecutor(this.zabj), this.zaff);
            return true;
        } finally {
            this.zaen.unlock();
        }
    }

    public final void maybeSignOut() {
        this.zaen.lock();
        try {
            this.zabm.maybeSignOut();
            if (this.zaff != null) {
                this.zaff.cancel();
                this.zaff = null;
            }
            if (this.zafe == null) {
                this.zafe = new C0238a(this.zaeu.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            for (zaw zak : this.zaeu.values()) {
                this.zafe.put(zak.zak(), connectionResult);
            }
            if (this.zafd != null) {
                this.zafd.putAll(this.zafe);
            }
            this.zaen.unlock();
        } catch (Throwable th) {
            this.zaen.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final void zaw() {
    }

    private final void zaad() {
        if (this.zaes == null) {
            this.zaew.zagz = Collections.emptySet();
            return;
        }
        Set hashSet = new HashSet(this.zaes.getRequiredScopes());
        Map optionalApiSettings = this.zaes.getOptionalApiSettings();
        for (Api api : optionalApiSettings.keySet()) {
            ConnectionResult connectionResult = getConnectionResult(api);
            if (connectionResult != null && connectionResult.isSuccess()) {
                hashSet.addAll(((OptionalApiSettings) optionalApiSettings.get(api)).mScopes);
            }
        }
        this.zaew.zagz = hashSet;
    }

    private final void zaae() {
        while (!this.zafb.isEmpty()) {
            execute((ApiMethodImpl) this.zafb.remove());
        }
        this.zaew.zab(null);
    }

    private final boolean zaa(zaw<?> zaw, ConnectionResult connectionResult) {
        return !connectionResult.isSuccess() && !connectionResult.hasResolution() && ((Boolean) this.zaev.get(zaw.getApi())).booleanValue() && zaw.zaab().requiresGooglePlayServices() && this.zaex.isUserResolvableError(connectionResult.getErrorCode());
    }

    private final ConnectionResult zaaf() {
        int i = 0;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        for (zaw zaw : this.zaet.values()) {
            Api api = zaw.getApi();
            ConnectionResult connectionResult3 = (ConnectionResult) this.zafd.get(zaw.zak());
            if (!connectionResult3.isSuccess() && (!((Boolean) this.zaev.get(api)).booleanValue() || connectionResult3.hasResolution() || this.zaex.isUserResolvableError(connectionResult3.getErrorCode()))) {
                int priority;
                if (connectionResult3.getErrorCode() == 4 && this.zaez) {
                    priority = api.zah().getPriority();
                    if (connectionResult == null || i > priority) {
                        i = priority;
                        connectionResult = connectionResult3;
                    }
                } else {
                    priority = api.zah().getPriority();
                    if (connectionResult2 != null && i2 <= priority) {
                        priority = i2;
                        connectionResult3 = connectionResult2;
                    }
                    i2 = priority;
                    connectionResult2 = connectionResult3;
                }
            }
        }
        return (connectionResult2 == null || connectionResult == null || i2 <= i) ? connectionResult2 : connectionResult;
    }
}
