package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.C0275a.C0274a;
import android.support.v4.media.C0277b.C0276a;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C02701();
    /* renamed from: a */
    private final String f530a;
    /* renamed from: b */
    private final CharSequence f531b;
    /* renamed from: c */
    private final CharSequence f532c;
    /* renamed from: d */
    private final CharSequence f533d;
    /* renamed from: e */
    private final Bitmap f534e;
    /* renamed from: f */
    private final Uri f535f;
    /* renamed from: g */
    private final Bundle f536g;
    /* renamed from: h */
    private final Uri f537h;
    /* renamed from: i */
    private Object f538i;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$1 */
    static class C02701 implements Creator<MediaDescriptionCompat> {
        C02701() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m791a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m792a(i);
        }

        /* renamed from: a */
        public MediaDescriptionCompat m791a(Parcel parcel) {
            if (VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.m802a(C0275a.m818a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] m792a(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    public static final class C0271a {
        /* renamed from: a */
        private String f522a;
        /* renamed from: b */
        private CharSequence f523b;
        /* renamed from: c */
        private CharSequence f524c;
        /* renamed from: d */
        private CharSequence f525d;
        /* renamed from: e */
        private Bitmap f526e;
        /* renamed from: f */
        private Uri f527f;
        /* renamed from: g */
        private Bundle f528g;
        /* renamed from: h */
        private Uri f529h;

        /* renamed from: a */
        public C0271a m797a(String str) {
            this.f522a = str;
            return this;
        }

        /* renamed from: a */
        public C0271a m796a(CharSequence charSequence) {
            this.f523b = charSequence;
            return this;
        }

        /* renamed from: b */
        public C0271a m800b(CharSequence charSequence) {
            this.f524c = charSequence;
            return this;
        }

        /* renamed from: c */
        public C0271a m801c(CharSequence charSequence) {
            this.f525d = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0271a m793a(Bitmap bitmap) {
            this.f526e = bitmap;
            return this;
        }

        /* renamed from: a */
        public C0271a m794a(Uri uri) {
            this.f527f = uri;
            return this;
        }

        /* renamed from: a */
        public C0271a m795a(Bundle bundle) {
            this.f528g = bundle;
            return this;
        }

        /* renamed from: b */
        public C0271a m799b(Uri uri) {
            this.f529h = uri;
            return this;
        }

        /* renamed from: a */
        public MediaDescriptionCompat m798a() {
            return new MediaDescriptionCompat(this.f522a, this.f523b, this.f524c, this.f525d, this.f526e, this.f527f, this.f528g, this.f529h);
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f530a = str;
        this.f531b = charSequence;
        this.f532c = charSequence2;
        this.f533d = charSequence3;
        this.f534e = bitmap;
        this.f535f = uri;
        this.f536g = bundle;
        this.f537h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f530a = parcel.readString();
        this.f531b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f532c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f533d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f534e = (Bitmap) parcel.readParcelable(null);
        this.f535f = (Uri) parcel.readParcelable(null);
        this.f536g = parcel.readBundle();
        this.f537h = (Uri) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.f530a);
            TextUtils.writeToParcel(this.f531b, parcel, i);
            TextUtils.writeToParcel(this.f532c, parcel, i);
            TextUtils.writeToParcel(this.f533d, parcel, i);
            parcel.writeParcelable(this.f534e, i);
            parcel.writeParcelable(this.f535f, i);
            parcel.writeBundle(this.f536g);
            parcel.writeParcelable(this.f537h, i);
            return;
        }
        C0275a.m820a(m803a(), parcel, i);
    }

    public String toString() {
        return this.f531b + ", " + this.f532c + ", " + this.f533d;
    }

    /* renamed from: a */
    public Object m803a() {
        if (this.f538i != null || VERSION.SDK_INT < 21) {
            return this.f538i;
        }
        Object a = C0274a.m809a();
        C0274a.m815a(a, this.f530a);
        C0274a.m814a(a, this.f531b);
        C0274a.m816b(a, this.f532c);
        C0274a.m817c(a, this.f533d);
        C0274a.m811a(a, this.f534e);
        C0274a.m812a(a, this.f535f);
        Bundle bundle = this.f536g;
        if (VERSION.SDK_INT < 23 && this.f537h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f537h);
        }
        C0274a.m813a(a, bundle);
        if (VERSION.SDK_INT >= 23) {
            C0276a.m827b(a, this.f537h);
        }
        this.f538i = C0274a.m810a(a);
        return this.f538i;
    }

    /* renamed from: a */
    public static MediaDescriptionCompat m802a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat a;
        C0271a c0271a = new C0271a();
        c0271a.m797a(C0275a.m819a(obj));
        c0271a.m796a(C0275a.m821b(obj));
        c0271a.m800b(C0275a.m822c(obj));
        c0271a.m801c(C0275a.m823d(obj));
        c0271a.m793a(C0275a.m824e(obj));
        c0271a.m794a(C0275a.m825f(obj));
        Bundle g = C0275a.m826g(obj);
        if (g == null) {
            uri = null;
        } else {
            uri = (Uri) g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && g.size() == 2) {
                bundle = null;
                c0271a.m795a(bundle);
                if (uri != null) {
                    c0271a.m799b(uri);
                } else if (VERSION.SDK_INT >= 23) {
                    c0271a.m799b(C0277b.m828h(obj));
                }
                a = c0271a.m798a();
                a.f538i = obj;
                return a;
            }
            g.remove("android.support.v4.media.description.MEDIA_URI");
            g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = g;
        c0271a.m795a(bundle);
        if (uri != null) {
            c0271a.m799b(uri);
        } else if (VERSION.SDK_INT >= 23) {
            c0271a.m799b(C0277b.m828h(obj));
        }
        a = c0271a.m798a();
        a.f538i = obj;
        return a;
    }
}
