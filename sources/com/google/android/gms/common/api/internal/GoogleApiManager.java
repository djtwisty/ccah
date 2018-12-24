package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.p017e.C0238a;
import android.support.v4.p017e.C0240b;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public class GoogleApiManager implements Callback {
    private static final Object lock = new Object();
    public static final Status zahw = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zahx = new Status(4, "The user must be signed in to make this API call.");
    private static GoogleApiManager zaib;
    private final Handler handler;
    private long zahy = 5000;
    private long zahz = 120000;
    private long zaia = 10000;
    private final Context zaic;
    private final GoogleApiAvailability zaid;
    private final GoogleApiAvailabilityCache zaie;
    private final AtomicInteger zaif = new AtomicInteger(1);
    private final AtomicInteger zaig = new AtomicInteger(0);
    private final Map<zai<?>, zaa<?>> zaih = new ConcurrentHashMap(5, 0.75f, 1);
    private zaae zaii = null;
    private final Set<zai<?>> zaij = new C0240b();
    private final Set<zai<?>> zaik = new C0240b();

    public class zaa<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener, zar {
        private final zai<O> zafp;
        final /* synthetic */ GoogleApiManager zail;
        private final Queue<zab> zaim = new LinkedList();
        private final Client zain;
        private final AnyClient zaio;
        private final zaab zaip;
        private final Set<zak> zaiq = new HashSet();
        private final Map<ListenerKey<?>, zabw> zair = new HashMap();
        private final int zais;
        private final zace zait;
        private boolean zaiu;
        private final List<zab> zaiv = new ArrayList();
        private ConnectionResult zaiw = null;

        public zaa(GoogleApiManager googleApiManager, GoogleApi<O> googleApi) {
            this.zail = googleApiManager;
            this.zain = googleApi.zaa(googleApiManager.handler.getLooper(), this);
            if (this.zain instanceof SimpleClientAdapter) {
                this.zaio = ((SimpleClientAdapter) this.zain).getClient();
            } else {
                this.zaio = this.zain;
            }
            this.zafp = googleApi.zak();
            this.zaip = new zaab();
            this.zais = googleApi.getInstanceId();
            if (this.zain.requiresSignIn()) {
                this.zait = googleApi.zaa(googleApiManager.zaic, googleApiManager.handler);
            } else {
                this.zait = null;
            }
        }

        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == this.zail.handler.getLooper()) {
                zabg();
            } else {
                this.zail.handler.post(new zabj(this));
            }
        }

        private final void zabg() {
            zabl();
            zai(ConnectionResult.RESULT_SUCCESS);
            zabn();
            Iterator it = this.zair.values().iterator();
            while (it.hasNext()) {
                zabw zabw = (zabw) it.next();
                if (zaa(zabw.zajw.getRequiredFeatures()) != null) {
                    it.remove();
                } else {
                    try {
                        zabw.zajw.registerListener(this.zaio, new TaskCompletionSource());
                    } catch (DeadObjectException e) {
                        onConnectionSuspended(1);
                        this.zain.disconnect();
                    } catch (RemoteException e2) {
                        it.remove();
                    }
                }
            }
            zabi();
            zabo();
        }

        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == this.zail.handler.getLooper()) {
                zabh();
            } else {
                this.zail.handler.post(new zabk(this));
            }
        }

        private final void zabh() {
            zabl();
            this.zaiu = true;
            this.zaip.zaai();
            this.zail.handler.sendMessageDelayed(Message.obtain(this.zail.handler, 9, this.zafp), this.zail.zahy);
            this.zail.handler.sendMessageDelayed(Message.obtain(this.zail.handler, 11, this.zafp), this.zail.zahz);
            this.zail.zaie.flush();
        }

        public final void zag(ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(this.zail.handler);
            this.zain.disconnect();
            onConnectionFailed(connectionResult);
        }

        private final boolean zah(ConnectionResult connectionResult) {
            boolean z;
            synchronized (GoogleApiManager.lock) {
                if (this.zail.zaii == null || !this.zail.zaij.contains(this.zafp)) {
                    z = false;
                } else {
                    this.zail.zaii.zab(connectionResult, this.zais);
                    z = true;
                }
            }
            return z;
        }

        public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() == this.zail.handler.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                this.zail.handler.post(new zabl(this, connectionResult));
            }
        }

        public final void onConnectionFailed(ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(this.zail.handler);
            if (this.zait != null) {
                this.zait.zabs();
            }
            zabl();
            this.zail.zaie.flush();
            zai(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                zac(GoogleApiManager.zahx);
            } else if (this.zaim.isEmpty()) {
                this.zaiw = connectionResult;
            } else if (!zah(connectionResult) && !this.zail.zac(connectionResult, this.zais)) {
                if (connectionResult.getErrorCode() == 18) {
                    this.zaiu = true;
                }
                if (this.zaiu) {
                    this.zail.handler.sendMessageDelayed(Message.obtain(this.zail.handler, 9, this.zafp), this.zail.zahy);
                    return;
                }
                String zan = this.zafp.zan();
                zac(new Status(17, new StringBuilder(String.valueOf(zan).length() + 38).append("API: ").append(zan).append(" is not available on this device.").toString()));
            }
        }

        private final void zabi() {
            ArrayList arrayList = new ArrayList(this.zaim);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zab zab = (zab) obj;
                if (!this.zain.isConnected()) {
                    return;
                }
                if (zab(zab)) {
                    this.zaim.remove(zab);
                }
            }
        }

        public final void zaa(zab zab) {
            Preconditions.checkHandlerThread(this.zail.handler);
            if (!this.zain.isConnected()) {
                this.zaim.add(zab);
                if (this.zaiw == null || !this.zaiw.hasResolution()) {
                    connect();
                } else {
                    onConnectionFailed(this.zaiw);
                }
            } else if (zab(zab)) {
                zabo();
            } else {
                this.zaim.add(zab);
            }
        }

        public final void zabj() {
            Preconditions.checkHandlerThread(this.zail.handler);
            zac(GoogleApiManager.zahw);
            this.zaip.zaah();
            for (ListenerKey zah : (ListenerKey[]) this.zair.keySet().toArray(new ListenerKey[this.zair.size()])) {
                zaa(new zah(zah, new TaskCompletionSource()));
            }
            zai(new ConnectionResult(4));
            if (this.zain.isConnected()) {
                this.zain.onUserSignOut(new zabm(this));
            }
        }

        public final Client zaab() {
            return this.zain;
        }

        public final Map<ListenerKey<?>, zabw> zabk() {
            return this.zair;
        }

        public final void zabl() {
            Preconditions.checkHandlerThread(this.zail.handler);
            this.zaiw = null;
        }

        public final ConnectionResult zabm() {
            Preconditions.checkHandlerThread(this.zail.handler);
            return this.zaiw;
        }

        private final boolean zab(zab zab) {
            if (zab instanceof zac) {
                zac zac = (zac) zab;
                Feature zaa = zaa(zac.zab(this));
                if (zaa == null) {
                    zac(zab);
                    return true;
                }
                if (zac.zac(this)) {
                    zab zab2 = new zab(this.zafp, zaa);
                    int indexOf = this.zaiv.indexOf(zab2);
                    if (indexOf >= 0) {
                        zab2 = (zab) this.zaiv.get(indexOf);
                        this.zail.handler.removeMessages(15, zab2);
                        this.zail.handler.sendMessageDelayed(Message.obtain(this.zail.handler, 15, zab2), this.zail.zahy);
                    } else {
                        this.zaiv.add(zab2);
                        this.zail.handler.sendMessageDelayed(Message.obtain(this.zail.handler, 15, zab2), this.zail.zahy);
                        this.zail.handler.sendMessageDelayed(Message.obtain(this.zail.handler, 16, zab2), this.zail.zahz);
                        ConnectionResult connectionResult = new ConnectionResult(2, null);
                        if (!zah(connectionResult)) {
                            this.zail.zac(connectionResult, this.zais);
                        }
                    }
                } else {
                    zac.zaa(new UnsupportedApiCallException(zaa));
                }
                return false;
            }
            zac(zab);
            return true;
        }

        private final void zac(zab zab) {
            zab.zaa(this.zaip, requiresSignIn());
            try {
                zab.zaa(this);
            } catch (DeadObjectException e) {
                onConnectionSuspended(1);
                this.zain.disconnect();
            }
        }

        public final void zac(Status status) {
            Preconditions.checkHandlerThread(this.zail.handler);
            for (zab zaa : this.zaim) {
                zaa.zaa(status);
            }
            this.zaim.clear();
        }

        public final void resume() {
            Preconditions.checkHandlerThread(this.zail.handler);
            if (this.zaiu) {
                connect();
            }
        }

        private final void zabn() {
            if (this.zaiu) {
                this.zail.handler.removeMessages(11, this.zafp);
                this.zail.handler.removeMessages(9, this.zafp);
                this.zaiu = false;
            }
        }

        public final void zaav() {
            Preconditions.checkHandlerThread(this.zail.handler);
            if (this.zaiu) {
                Status status;
                zabn();
                if (this.zail.zaid.isGooglePlayServicesAvailable(this.zail.zaic) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                zac(status);
                this.zain.disconnect();
            }
        }

        private final void zabo() {
            this.zail.handler.removeMessages(12, this.zafp);
            this.zail.handler.sendMessageDelayed(this.zail.handler.obtainMessage(12, this.zafp), this.zail.zaia);
        }

        public final boolean zabp() {
            return zac(true);
        }

        private final boolean zac(boolean z) {
            Preconditions.checkHandlerThread(this.zail.handler);
            if (!this.zain.isConnected() || this.zair.size() != 0) {
                return false;
            }
            if (!this.zaip.zaag()) {
                this.zain.disconnect();
                return true;
            } else if (!z) {
                return false;
            } else {
                zabo();
                return false;
            }
        }

        public final void connect() {
            Preconditions.checkHandlerThread(this.zail.handler);
            if (!this.zain.isConnected() && !this.zain.isConnecting()) {
                int clientAvailability = this.zail.zaie.getClientAvailability(this.zail.zaic, this.zain);
                if (clientAvailability != 0) {
                    onConnectionFailed(new ConnectionResult(clientAvailability, null));
                    return;
                }
                zach zac = new zac(this.zail, this.zain, this.zafp);
                if (this.zain.requiresSignIn()) {
                    this.zait.zaa(zac);
                }
                this.zain.connect(zac);
            }
        }

        public final void zaa(zak zak) {
            Preconditions.checkHandlerThread(this.zail.handler);
            this.zaiq.add(zak);
        }

        private final void zai(ConnectionResult connectionResult) {
            for (zak zak : this.zaiq) {
                String str = null;
                if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.zain.getEndpointPackageName();
                }
                zak.zaa(this.zafp, connectionResult, str);
            }
            this.zaiq.clear();
        }

        final boolean isConnected() {
            return this.zain.isConnected();
        }

        public final boolean requiresSignIn() {
            return this.zain.requiresSignIn();
        }

        public final int getInstanceId() {
            return this.zais;
        }

        final zad zabq() {
            return this.zait == null ? null : this.zait.zabq();
        }

        private final Feature zaa(Feature[] featureArr) {
            if (featureArr == null || featureArr.length == 0) {
                return null;
            }
            Feature[] availableFeatures = this.zain.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new Feature[0];
            }
            Map c0238a = new C0238a(availableFeatures.length);
            for (Feature feature : availableFeatures) {
                c0238a.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                if (!c0238a.containsKey(feature2.getName()) || ((Long) c0238a.get(feature2.getName())).longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
            return null;
        }

        private final void zaa(zab zab) {
            if (!this.zaiv.contains(zab) || this.zaiu) {
                return;
            }
            if (this.zain.isConnected()) {
                zabi();
            } else {
                connect();
            }
        }

        private final void zab(zab zab) {
            if (this.zaiv.remove(zab)) {
                this.zail.handler.removeMessages(15, zab);
                this.zail.handler.removeMessages(16, zab);
                Object zad = zab.zajb;
                ArrayList arrayList = new ArrayList(this.zaim.size());
                for (zab zab2 : this.zaim) {
                    if (zab2 instanceof zac) {
                        Object[] zab3 = ((zac) zab2).zab(this);
                        if (zab3 != null && ArrayUtils.contains(zab3, zad)) {
                            arrayList.add(zab2);
                        }
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zab zab4 = (zab) obj;
                    this.zaim.remove(zab4);
                    zab4.zaa(new UnsupportedApiCallException(zad));
                }
            }
        }
    }

    private static class zab {
        private final zai<?> zaja;
        private final Feature zajb;

        private zab(zai<?> zai, Feature feature) {
            this.zaja = zai;
            this.zajb = feature;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof zab)) {
                return false;
            }
            zab zab = (zab) obj;
            if (Objects.equal(this.zaja, zab.zaja) && Objects.equal(this.zajb, zab.zajb)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zaja, this.zajb);
        }

        public final String toString() {
            return Objects.toStringHelper(this).add("key", this.zaja).add("feature", this.zajb).toString();
        }
    }

    private class zac implements zach, ConnectionProgressReportCallbacks {
        private final zai<?> zafp;
        final /* synthetic */ GoogleApiManager zail;
        private final Client zain;
        private IAccountAccessor zajc = null;
        private Set<Scope> zajd = null;
        private boolean zaje = false;

        public zac(GoogleApiManager googleApiManager, Client client, zai<?> zai) {
            this.zail = googleApiManager;
            this.zain = client;
            this.zafp = zai;
        }

        public final void onReportServiceBinding(ConnectionResult connectionResult) {
            this.zail.handler.post(new zabo(this, connectionResult));
        }

        public final void zag(ConnectionResult connectionResult) {
            ((zaa) this.zail.zaih.get(this.zafp)).zag(connectionResult);
        }

        public final void zaa(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zag(new ConnectionResult(4));
                return;
            }
            this.zajc = iAccountAccessor;
            this.zajd = set;
            zabr();
        }

        private final void zabr() {
            if (this.zaje && this.zajc != null) {
                this.zain.getRemoteService(this.zajc, this.zajd);
            }
        }
    }

    public static GoogleApiManager zab(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (lock) {
            if (zaib == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zaib = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = zaib;
        }
        return googleApiManager;
    }

    public static GoogleApiManager zabc() {
        GoogleApiManager googleApiManager;
        synchronized (lock) {
            Preconditions.checkNotNull(zaib, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zaib;
        }
        return googleApiManager;
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (lock) {
            if (zaib != null) {
                GoogleApiManager googleApiManager = zaib;
                googleApiManager.zaig.incrementAndGet();
                googleApiManager.handler.sendMessageAtFrontOfQueue(googleApiManager.handler.obtainMessage(10));
            }
        }
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zaic = context;
        this.handler = new zal(looper, this);
        this.zaid = googleApiAvailability;
        this.zaie = new GoogleApiAvailabilityCache(googleApiAvailability);
        this.handler.sendMessage(this.handler.obtainMessage(6));
    }

    public final int zabd() {
        return this.zaif.getAndIncrement();
    }

    public final void zaa(GoogleApi<?> googleApi) {
        this.handler.sendMessage(this.handler.obtainMessage(7, googleApi));
    }

    private final void zab(GoogleApi<?> googleApi) {
        zai zak = googleApi.zak();
        zaa zaa = (zaa) this.zaih.get(zak);
        if (zaa == null) {
            zaa = new zaa(this, googleApi);
            this.zaih.put(zak, zaa);
        }
        if (zaa.requiresSignIn()) {
            this.zaik.add(zak);
        }
        zaa.connect();
    }

    public final void zaa(zaae zaae) {
        synchronized (lock) {
            if (this.zaii != zaae) {
                this.zaii = zaae;
                this.zaij.clear();
            }
            this.zaij.addAll(zaae.zaaj());
        }
    }

    final void zab(zaae zaae) {
        synchronized (lock) {
            if (this.zaii == zaae) {
                this.zaii = null;
                this.zaij.clear();
            }
        }
    }

    public final Task<Map<zai<?>, String>> zaa(Iterable<? extends GoogleApi<?>> iterable) {
        zak zak = new zak(iterable);
        this.handler.sendMessage(this.handler.obtainMessage(2, zak));
        return zak.getTask();
    }

    public final void zao() {
        this.handler.sendMessage(this.handler.obtainMessage(3));
    }

    final void maybeSignOut() {
        this.zaig.incrementAndGet();
        this.handler.sendMessage(this.handler.obtainMessage(10));
    }

    public final Task<Boolean> zac(GoogleApi<?> googleApi) {
        zaaf zaaf = new zaaf(googleApi.zak());
        this.handler.sendMessage(this.handler.obtainMessage(14, zaaf));
        return zaaf.zaal().getTask();
    }

    public final <O extends ApiOptions> void zaa(GoogleApi<O> googleApi, int i, ApiMethodImpl<? extends Result, AnyClient> apiMethodImpl) {
        this.handler.sendMessage(this.handler.obtainMessage(4, new zabv(new zae(i, apiMethodImpl), this.zaig.get(), googleApi)));
    }

    public final <O extends ApiOptions, ResultT> void zaa(GoogleApi<O> googleApi, int i, TaskApiCall<AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        this.handler.sendMessage(this.handler.obtainMessage(4, new zabv(new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper), this.zaig.get(), googleApi)));
    }

    public final <O extends ApiOptions> Task<Void> zaa(GoogleApi<O> googleApi, RegisterListenerMethod<AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<AnyClient, ?> unregisterListenerMethod) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.handler.sendMessage(this.handler.obtainMessage(8, new zabv(new zaf(new zabw(registerListenerMethod, unregisterListenerMethod), taskCompletionSource), this.zaig.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends ApiOptions> Task<Boolean> zaa(GoogleApi<O> googleApi, ListenerKey<?> listenerKey) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.handler.sendMessage(this.handler.obtainMessage(13, new zabv(new zah(listenerKey, taskCompletionSource), this.zaig.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public boolean handleMessage(Message message) {
        zai zak;
        zaa zaa;
        zab zab;
        switch (message.what) {
            case 1:
                long j;
                if (((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                } else {
                    j = 300000;
                }
                this.zaia = j;
                this.handler.removeMessages(12);
                for (zai obtainMessage : this.zaih.keySet()) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(12, obtainMessage), this.zaia);
                }
                break;
            case 2:
                zak zak2 = (zak) message.obj;
                for (zai zak3 : zak2.zap()) {
                    zaa zaa2 = (zaa) this.zaih.get(zak3);
                    if (zaa2 == null) {
                        zak2.zaa(zak3, new ConnectionResult(13), null);
                        break;
                    } else if (zaa2.isConnected()) {
                        zak2.zaa(zak3, ConnectionResult.RESULT_SUCCESS, zaa2.zaab().getEndpointPackageName());
                    } else if (zaa2.zabm() != null) {
                        zak2.zaa(zak3, zaa2.zabm(), null);
                    } else {
                        zaa2.zaa(zak2);
                        zaa2.connect();
                    }
                }
                break;
            case 3:
                for (zaa zaa3 : this.zaih.values()) {
                    zaa3.zabl();
                    zaa3.connect();
                }
                break;
            case 4:
            case 8:
            case 13:
                zabv zabv = (zabv) message.obj;
                zaa = (zaa) this.zaih.get(zabv.zajs.zak());
                if (zaa == null) {
                    zab(zabv.zajs);
                    zaa = (zaa) this.zaih.get(zabv.zajs.zak());
                }
                if (zaa.requiresSignIn() && this.zaig.get() != zabv.zajr) {
                    zabv.zajq.zaa(zahw);
                    zaa.zabj();
                    break;
                }
                zaa.zaa(zabv.zajq);
                break;
                break;
            case 5:
                String errorString;
                String errorMessage;
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zaa zaa4 : this.zaih.values()) {
                    if (zaa4.getInstanceId() == i) {
                        if (zaa4 != null) {
                            Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
                            break;
                        }
                        errorString = this.zaid.getErrorString(connectionResult.getErrorCode());
                        errorMessage = connectionResult.getErrorMessage();
                        zaa4.zac(new Status(17, new StringBuilder((String.valueOf(errorString).length() + 69) + String.valueOf(errorMessage).length()).append("Error resolution was canceled by the user, original error message: ").append(errorString).append(": ").append(errorMessage).toString()));
                        break;
                    }
                }
                zaa4 = null;
                if (zaa4 != null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
                } else {
                    errorString = this.zaid.getErrorString(connectionResult.getErrorCode());
                    errorMessage = connectionResult.getErrorMessage();
                    zaa4.zac(new Status(17, new StringBuilder((String.valueOf(errorString).length() + 69) + String.valueOf(errorMessage).length()).append("Error resolution was canceled by the user, original error message: ").append(errorString).append(": ").append(errorMessage).toString()));
                }
            case 6:
                if (PlatformVersion.isAtLeastIceCreamSandwich() && (this.zaic.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.initialize((Application) this.zaic.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabi(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zaia = 300000;
                        break;
                    }
                }
                break;
            case 7:
                zab((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zaih.containsKey(message.obj)) {
                    ((zaa) this.zaih.get(message.obj)).resume();
                    break;
                }
                break;
            case 10:
                for (zai obtainMessage2 : this.zaik) {
                    ((zaa) this.zaih.remove(obtainMessage2)).zabj();
                }
                this.zaik.clear();
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                if (this.zaih.containsKey(message.obj)) {
                    ((zaa) this.zaih.get(message.obj)).zaav();
                    break;
                }
                break;
            case 12:
                if (this.zaih.containsKey(message.obj)) {
                    ((zaa) this.zaih.get(message.obj)).zabp();
                    break;
                }
                break;
            case 14:
                zaaf zaaf = (zaaf) message.obj;
                zak3 = zaaf.zak();
                if (!this.zaih.containsKey(zak3)) {
                    zaaf.zaal().setResult(Boolean.valueOf(false));
                    break;
                }
                zaaf.zaal().setResult(Boolean.valueOf(((zaa) this.zaih.get(zak3)).zac(false)));
                break;
            case 15:
                zab = (zab) message.obj;
                if (this.zaih.containsKey(zab.zaja)) {
                    ((zaa) this.zaih.get(zab.zaja)).zaa(zab);
                    break;
                }
                break;
            case 16:
                zab = (zab) message.obj;
                if (this.zaih.containsKey(zab.zaja)) {
                    ((zaa) this.zaih.get(zab.zaja)).zab(zab);
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }

    final PendingIntent zaa(zai<?> zai, int i) {
        zaa zaa = (zaa) this.zaih.get(zai);
        if (zaa == null) {
            return null;
        }
        zad zabq = zaa.zabq();
        if (zabq == null) {
            return null;
        }
        return PendingIntent.getActivity(this.zaic, i, zabq.getSignInIntent(), 134217728);
    }

    final boolean zac(ConnectionResult connectionResult, int i) {
        return this.zaid.zaa(this.zaic, connectionResult, i);
    }

    public final void zaa(ConnectionResult connectionResult, int i) {
        if (!zac(connectionResult, i)) {
            this.handler.sendMessage(this.handler.obtainMessage(5, i, 0, connectionResult));
        }
    }
}
