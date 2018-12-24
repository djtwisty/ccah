package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C02911();
    /* renamed from: a */
    public int f569a;
    /* renamed from: b */
    public int f570b;
    /* renamed from: c */
    public int f571c;
    /* renamed from: d */
    public int f572d;
    /* renamed from: e */
    public int f573e;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo$1 */
    static class C02911 implements Creator<ParcelableVolumeInfo> {
        C02911() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m901a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m902a(i);
        }

        /* renamed from: a */
        public ParcelableVolumeInfo m901a(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: a */
        public ParcelableVolumeInfo[] m902a(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f569a = parcel.readInt();
        this.f571c = parcel.readInt();
        this.f572d = parcel.readInt();
        this.f573e = parcel.readInt();
        this.f570b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f569a);
        parcel.writeInt(this.f571c);
        parcel.writeInt(this.f572d);
        parcel.writeInt(this.f573e);
        parcel.writeInt(this.f570b);
    }
}
