package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class zzh implements Publisher, Subscriber {
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> zza = new HashMap();
    private Queue<Event<?>> zzb = new ArrayDeque();
    private final Executor zzc;

    zzh(Executor executor) {
        this.zzc = executor;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void publish(com.google.firebase.events.Event<?> r4) {
        /*
        r3 = this;
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r4);
        monitor-enter(r3);
        r0 = r3.zzb;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r0 = r3.zzb;	 Catch:{ all -> 0x0032 }
        r0.add(r4);	 Catch:{ all -> 0x0032 }
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
    L_0x000e:
        return;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        r0 = r3.zza(r4);
        r2 = r0.iterator();
    L_0x0018:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x000e;
    L_0x001e:
        r0 = r2.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getValue();
        r1 = (java.util.concurrent.Executor) r1;
        r0 = com.google.firebase.components.zzi.zza(r0, r4);
        r1.execute(r0);
        goto L_0x0018;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0032 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.zzh.publish(com.google.firebase.events.Event):void");
    }

    private synchronized Set<Entry<EventHandler<Object>, Executor>> zza(Event<?> event) {
        Map map;
        map = (Map) this.zza.get(event.getType());
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    public synchronized <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(eventHandler);
        Preconditions.checkNotNull(executor);
        if (!this.zza.containsKey(cls)) {
            this.zza.put(cls, new ConcurrentHashMap());
        }
        ((ConcurrentHashMap) this.zza.get(cls)).put(eventHandler, executor);
    }

    public <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler) {
        subscribe(cls, this.zzc, eventHandler);
    }

    public synchronized <T> void unsubscribe(Class<T> cls, EventHandler<? super T> eventHandler) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(eventHandler);
        if (this.zza.containsKey(cls)) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.zza.get(cls);
            concurrentHashMap.remove(eventHandler);
            if (concurrentHashMap.isEmpty()) {
                this.zza.remove(cls);
            }
        }
    }

    final void zza() {
        Queue queue = null;
        synchronized (this) {
            if (this.zzb != null) {
                queue = this.zzb;
                this.zzb = null;
            }
        }
        if (r0 != null) {
            for (Event publish : r0) {
                publish(publish);
            }
        }
    }
}
