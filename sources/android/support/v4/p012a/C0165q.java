package android.support.v4.p012a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.a.q */
final class C0165q implements Parcelable {
    public static final Creator<C0165q> CREATOR = new C01641();
    /* renamed from: a */
    C0167r[] f262a;
    /* renamed from: b */
    int[] f263b;
    /* renamed from: c */
    C0126d[] f264c;
    /* renamed from: d */
    int f265d = -1;
    /* renamed from: e */
    int f266e;

    /* renamed from: android.support.v4.a.q$1 */
    static class C01641 implements Creator<C0165q> {
        C01641() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m487a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m488a(i);
        }

        /* renamed from: a */
        public C0165q m487a(Parcel parcel) {
            return new C0165q(parcel);
        }

        /* renamed from: a */
        public C0165q[] m488a(int i) {
            return new C0165q[i];
        }
    }

    public C0165q(Parcel parcel) {
        this.f262a = (C0167r[]) parcel.createTypedArray(C0167r.CREATOR);
        this.f263b = parcel.createIntArray();
        this.f264c = (C0126d[]) parcel.createTypedArray(C0126d.CREATOR);
        this.f265d = parcel.readInt();
        this.f266e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f262a, i);
        parcel.writeIntArray(this.f263b);
        parcel.writeTypedArray(this.f264c, i);
        parcel.writeInt(this.f265d);
        parcel.writeInt(this.f266e);
    }
}
