package android.support.v4.p012a;

import android.os.Bundle;
import android.support.v4.p012a.al.C0118a;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: android.support.v4.a.am */
class am {
    /* renamed from: a */
    static Bundle m192a(C0118a c0118a) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", c0118a.mo48a());
        bundle.putCharSequence("label", c0118a.mo49b());
        bundle.putCharSequenceArray("choices", c0118a.mo50c());
        bundle.putBoolean("allowFreeFormInput", c0118a.mo52e());
        bundle.putBundle("extras", c0118a.mo53f());
        Set<String> d = c0118a.mo51d();
        if (!(d == null || d.isEmpty())) {
            ArrayList arrayList = new ArrayList(d.size());
            for (String add : d) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* renamed from: a */
    static Bundle[] m193a(C0118a[] c0118aArr) {
        if (c0118aArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[c0118aArr.length];
        for (int i = 0; i < c0118aArr.length; i++) {
            bundleArr[i] = am.m192a(c0118aArr[i]);
        }
        return bundleArr;
    }
}
