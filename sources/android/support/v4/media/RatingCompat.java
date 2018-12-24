package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C02731();
    /* renamed from: a */
    private final int f545a;
    /* renamed from: b */
    private final float f546b;

    /* renamed from: android.support.v4.media.RatingCompat$1 */
    static class C02731 implements Creator<RatingCompat> {
        C02731() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m807a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m808a(i);
        }

        /* renamed from: a */
        public RatingCompat m807a(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: a */
        public RatingCompat[] m808a(int i) {
            return new RatingCompat[i];
        }
    }

    RatingCompat(int i, float f) {
        this.f545a = i;
        this.f546b = f;
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder().append("Rating:style=").append(this.f545a).append(" rating=");
        if (this.f546b < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(this.f546b);
        }
        return append.append(str).toString();
    }

    public int describeContents() {
        return this.f545a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f545a);
        parcel.writeFloat(this.f546b);
    }
}
