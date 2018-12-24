package android.support.v4.p012a;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.p012a.al.C0118a;

/* renamed from: android.support.v4.a.ak */
class ak {
    /* renamed from: a */
    static RemoteInput[] m191a(C0118a[] c0118aArr) {
        if (c0118aArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0118aArr.length];
        for (int i = 0; i < c0118aArr.length; i++) {
            C0118a c0118a = c0118aArr[i];
            remoteInputArr[i] = new Builder(c0118a.mo48a()).setLabel(c0118a.mo49b()).setChoices(c0118a.mo50c()).setAllowFreeFormInput(c0118a.mo52e()).addExtras(c0118a.mo53f()).build();
        }
        return remoteInputArr;
    }
}
