package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzqw extends zzqp<List<zzqp<?>>> {
    private static final Map<String, zzjo> zzbpl;
    private final ArrayList<zzqp<?>> zzbpu;

    public zzqw(List<zzqp<?>> list) {
        Preconditions.checkNotNull(list);
        this.zzbpu = new ArrayList(list);
    }

    public final void zza(int i, zzqp<?> zzqp) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i >= this.zzbpu.size()) {
            setSize(i + 1);
        }
        this.zzbpu.set(i, zzqp);
    }

    public final void setSize(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid array length");
        if (this.zzbpu.size() != i) {
            if (this.zzbpu.size() < i) {
                this.zzbpu.ensureCapacity(i);
                for (int size = this.zzbpu.size(); size < i; size++) {
                    this.zzbpu.add(null);
                }
                return;
            }
            this.zzbpu.subList(i, this.zzbpu.size()).clear();
        }
    }

    public final zzqp<?> zzae(int i) {
        if (i < 0 || i >= this.zzbpu.size()) {
            return zzqv.zzbpr;
        }
        zzqp<?> zzqp = (zzqp) this.zzbpu.get(i);
        return zzqp == null ? zzqv.zzbpr : zzqp;
    }

    public final boolean zzaf(int i) {
        return i >= 0 && i < this.zzbpu.size() && this.zzbpu.get(i) != null;
    }

    public final Iterator<zzqp<?>> zzst() {
        return new zzqy(this, new zzqx(this), super.zzsu());
    }

    public final boolean zzff(String str) {
        return zzbpl.containsKey(str);
    }

    public final zzjo zzfg(String str) {
        if (zzff(str)) {
            return (zzjo) zzbpl.get(str);
        }
        throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 51).append("Native Method ").append(str).append(" is not defined for type ListWrapper.").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqw) {
            List list = (List) ((zzqw) obj).value();
            if (this.zzbpu.size() == list.size()) {
                boolean z = true;
                for (int i = 0; i < this.zzbpu.size(); i++) {
                    if (this.zzbpu.get(i) != null) {
                        z = ((zzqp) this.zzbpu.get(i)).equals(list.get(i));
                    } else if (list.get(i) == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        break;
                    }
                }
                return z;
            }
        }
        return false;
    }

    public final String toString() {
        return this.zzbpu.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzbpu;
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("concat", new zzjr());
        hashMap.put("every", new zzjs());
        hashMap.put("filter", new zzjt());
        hashMap.put("forEach", new zzju());
        hashMap.put("indexOf", new zzjv());
        hashMap.put("hasOwnProperty", zzlp.zzbmp);
        hashMap.put("join", new zzjw());
        hashMap.put("lastIndexOf", new zzjx());
        hashMap.put("map", new zzjy());
        hashMap.put("pop", new zzjz());
        hashMap.put("push", new zzka());
        hashMap.put("reduce", new zzkb());
        hashMap.put("reduceRight", new zzkc());
        hashMap.put("reverse", new zzkd());
        hashMap.put("shift", new zzke());
        hashMap.put("slice", new zzkf());
        hashMap.put("some", new zzkg());
        hashMap.put("sort", new zzkh());
        hashMap.put("splice", new zzkl());
        hashMap.put("toString", new zzmr());
        hashMap.put("unshift", new zzkm());
        zzbpl = Collections.unmodifiableMap(hashMap);
    }
}
