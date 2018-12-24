package android.support.v4.p012a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p012a.C0124c.C0121a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.a.d */
final class C0126d implements Parcelable {
    public static final Creator<C0126d> CREATOR = new C01251();
    /* renamed from: a */
    final int[] f148a;
    /* renamed from: b */
    final int f149b;
    /* renamed from: c */
    final int f150c;
    /* renamed from: d */
    final String f151d;
    /* renamed from: e */
    final int f152e;
    /* renamed from: f */
    final int f153f;
    /* renamed from: g */
    final CharSequence f154g;
    /* renamed from: h */
    final int f155h;
    /* renamed from: i */
    final CharSequence f156i;
    /* renamed from: j */
    final ArrayList<String> f157j;
    /* renamed from: k */
    final ArrayList<String> f158k;
    /* renamed from: l */
    final boolean f159l;

    /* renamed from: android.support.v4.a.d$1 */
    static class C01251 implements Creator<C0126d> {
        C01251() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m231a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m232a(i);
        }

        /* renamed from: a */
        public C0126d m231a(Parcel parcel) {
            return new C0126d(parcel);
        }

        /* renamed from: a */
        public C0126d[] m232a(int i) {
            return new C0126d[i];
        }
    }

    public C0126d(C0124c c0124c) {
        int size = c0124c.f128c.size();
        this.f148a = new int[(size * 6)];
        if (c0124c.f135j) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                C0121a c0121a = (C0121a) c0124c.f128c.get(i2);
                int i3 = i + 1;
                this.f148a[i] = c0121a.f120a;
                int i4 = i3 + 1;
                this.f148a[i3] = c0121a.f121b != null ? c0121a.f121b.mIndex : -1;
                int i5 = i4 + 1;
                this.f148a[i4] = c0121a.f122c;
                i3 = i5 + 1;
                this.f148a[i5] = c0121a.f123d;
                i5 = i3 + 1;
                this.f148a[i3] = c0121a.f124e;
                i = i5 + 1;
                this.f148a[i5] = c0121a.f125f;
            }
            this.f149b = c0124c.f133h;
            this.f150c = c0124c.f134i;
            this.f151d = c0124c.f137l;
            this.f152e = c0124c.f139n;
            this.f153f = c0124c.f140o;
            this.f154g = c0124c.f141p;
            this.f155h = c0124c.f142q;
            this.f156i = c0124c.f143r;
            this.f157j = c0124c.f144s;
            this.f158k = c0124c.f145t;
            this.f159l = c0124c.f146u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0126d(Parcel parcel) {
        this.f148a = parcel.createIntArray();
        this.f149b = parcel.readInt();
        this.f150c = parcel.readInt();
        this.f151d = parcel.readString();
        this.f152e = parcel.readInt();
        this.f153f = parcel.readInt();
        this.f154g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f155h = parcel.readInt();
        this.f156i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f157j = parcel.createStringArrayList();
        this.f158k = parcel.createStringArrayList();
        this.f159l = parcel.readInt() != 0;
    }

    /* renamed from: a */
    public C0124c m233a(C0162o c0162o) {
        C0124c c0124c = new C0124c(c0162o);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f148a.length) {
            C0121a c0121a = new C0121a();
            int i3 = i2 + 1;
            c0121a.f120a = this.f148a[i2];
            if (C0162o.f229a) {
                Log.v("FragmentManager", "Instantiate " + c0124c + " op #" + i + " base fragment #" + this.f148a[i3]);
            }
            i2 = i3 + 1;
            int i4 = this.f148a[i3];
            if (i4 >= 0) {
                c0121a.f121b = (C0131i) c0162o.f240f.get(i4);
            } else {
                c0121a.f121b = null;
            }
            i3 = i2 + 1;
            c0121a.f122c = this.f148a[i2];
            i2 = i3 + 1;
            c0121a.f123d = this.f148a[i3];
            i3 = i2 + 1;
            c0121a.f124e = this.f148a[i2];
            i2 = i3 + 1;
            c0121a.f125f = this.f148a[i3];
            c0124c.f129d = c0121a.f122c;
            c0124c.f130e = c0121a.f123d;
            c0124c.f131f = c0121a.f124e;
            c0124c.f132g = c0121a.f125f;
            c0124c.m217a(c0121a);
            i++;
        }
        c0124c.f133h = this.f149b;
        c0124c.f134i = this.f150c;
        c0124c.f137l = this.f151d;
        c0124c.f139n = this.f152e;
        c0124c.f135j = true;
        c0124c.f140o = this.f153f;
        c0124c.f141p = this.f154g;
        c0124c.f142q = this.f155h;
        c0124c.f143r = this.f156i;
        c0124c.f144s = this.f157j;
        c0124c.f145t = this.f158k;
        c0124c.f146u = this.f159l;
        c0124c.m216a(1);
        return c0124c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeIntArray(this.f148a);
        parcel.writeInt(this.f149b);
        parcel.writeInt(this.f150c);
        parcel.writeString(this.f151d);
        parcel.writeInt(this.f152e);
        parcel.writeInt(this.f153f);
        TextUtils.writeToParcel(this.f154g, parcel, 0);
        parcel.writeInt(this.f155h);
        TextUtils.writeToParcel(this.f156i, parcel, 0);
        parcel.writeStringList(this.f157j);
        parcel.writeStringList(this.f158k);
        if (this.f159l) {
            i2 = 1;
        }
        parcel.writeInt(i2);
    }
}
