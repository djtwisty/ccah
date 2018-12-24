package android.support.v4.p016d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016d.C0228a.C0230a;

/* renamed from: android.support.v4.d.b */
public class C0234b implements Parcelable {
    public static final Creator<C0234b> CREATOR = new C02311();
    /* renamed from: a */
    final boolean f453a = false;
    /* renamed from: b */
    final Handler f454b = null;
    /* renamed from: c */
    C0228a f455c;

    /* renamed from: android.support.v4.d.b$1 */
    static class C02311 implements Creator<C0234b> {
        C02311() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m682a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m683a(i);
        }

        /* renamed from: a */
        public C0234b m682a(Parcel parcel) {
            return new C0234b(parcel);
        }

        /* renamed from: a */
        public C0234b[] m683a(int i) {
            return new C0234b[i];
        }
    }

    /* renamed from: android.support.v4.d.b$a */
    class C0232a extends C0230a {
        /* renamed from: a */
        final /* synthetic */ C0234b f449a;

        C0232a(C0234b c0234b) {
            this.f449a = c0234b;
        }

        /* renamed from: a */
        public void mo126a(int i, Bundle bundle) {
            if (this.f449a.f454b != null) {
                this.f449a.f454b.post(new C0233b(this.f449a, i, bundle));
            } else {
                this.f449a.mo140a(i, bundle);
            }
        }
    }

    /* renamed from: android.support.v4.d.b$b */
    class C0233b implements Runnable {
        /* renamed from: a */
        final int f450a;
        /* renamed from: b */
        final Bundle f451b;
        /* renamed from: c */
        final /* synthetic */ C0234b f452c;

        C0233b(C0234b c0234b, int i, Bundle bundle) {
            this.f452c = c0234b;
            this.f450a = i;
            this.f451b = bundle;
        }

        public void run() {
            this.f452c.mo140a(this.f450a, this.f451b);
        }
    }

    /* renamed from: a */
    protected void mo140a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f455c == null) {
                this.f455c = new C0232a(this);
            }
            parcel.writeStrongBinder(this.f455c.asBinder());
        }
    }

    C0234b(Parcel parcel) {
        this.f455c = C0230a.m681a(parcel.readStrongBinder());
    }
}
