package android.support.v4.p012a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* renamed from: android.support.v4.a.r */
final class C0167r implements Parcelable {
    public static final Creator<C0167r> CREATOR = new C01661();
    /* renamed from: a */
    final String f267a;
    /* renamed from: b */
    final int f268b;
    /* renamed from: c */
    final boolean f269c;
    /* renamed from: d */
    final int f270d;
    /* renamed from: e */
    final int f271e;
    /* renamed from: f */
    final String f272f;
    /* renamed from: g */
    final boolean f273g;
    /* renamed from: h */
    final boolean f274h;
    /* renamed from: i */
    final Bundle f275i;
    /* renamed from: j */
    final boolean f276j;
    /* renamed from: k */
    Bundle f277k;
    /* renamed from: l */
    C0131i f278l;

    /* renamed from: android.support.v4.a.r$1 */
    static class C01661 implements Creator<C0167r> {
        C01661() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m489a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m490a(i);
        }

        /* renamed from: a */
        public C0167r m489a(Parcel parcel) {
            return new C0167r(parcel);
        }

        /* renamed from: a */
        public C0167r[] m490a(int i) {
            return new C0167r[i];
        }
    }

    public C0167r(C0131i c0131i) {
        this.f267a = c0131i.getClass().getName();
        this.f268b = c0131i.mIndex;
        this.f269c = c0131i.mFromLayout;
        this.f270d = c0131i.mFragmentId;
        this.f271e = c0131i.mContainerId;
        this.f272f = c0131i.mTag;
        this.f273g = c0131i.mRetainInstance;
        this.f274h = c0131i.mDetached;
        this.f275i = c0131i.mArguments;
        this.f276j = c0131i.mHidden;
    }

    public C0167r(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f267a = parcel.readString();
        this.f268b = parcel.readInt();
        this.f269c = parcel.readInt() != 0;
        this.f270d = parcel.readInt();
        this.f271e = parcel.readInt();
        this.f272f = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f273g = z;
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f274h = z;
        this.f275i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f276j = z2;
        this.f277k = parcel.readBundle();
    }

    /* renamed from: a */
    public C0131i m491a(C0142m c0142m, C0134k c0134k, C0131i c0131i, C0163p c0163p) {
        if (this.f278l == null) {
            Context i = c0142m.m282i();
            if (this.f275i != null) {
                this.f275i.setClassLoader(i.getClassLoader());
            }
            if (c0134k != null) {
                this.f278l = c0134k.mo69a(i, this.f267a, this.f275i);
            } else {
                this.f278l = C0131i.instantiate(i, this.f267a, this.f275i);
            }
            if (this.f277k != null) {
                this.f277k.setClassLoader(i.getClassLoader());
                this.f278l.mSavedFragmentState = this.f277k;
            }
            this.f278l.setIndex(this.f268b, c0131i);
            this.f278l.mFromLayout = this.f269c;
            this.f278l.mRestored = true;
            this.f278l.mFragmentId = this.f270d;
            this.f278l.mContainerId = this.f271e;
            this.f278l.mTag = this.f272f;
            this.f278l.mRetainInstance = this.f273g;
            this.f278l.mDetached = this.f274h;
            this.f278l.mHidden = this.f276j;
            this.f278l.mFragmentManager = c0142m.f188d;
            if (C0162o.f229a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f278l);
            }
        }
        this.f278l.mChildNonConfig = c0163p;
        return this.f278l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f267a);
        parcel.writeInt(this.f268b);
        parcel.writeInt(this.f269c ? 1 : 0);
        parcel.writeInt(this.f270d);
        parcel.writeInt(this.f271e);
        parcel.writeString(this.f272f);
        if (this.f273g) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f274h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f275i);
        if (!this.f276j) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.f277k);
    }
}
