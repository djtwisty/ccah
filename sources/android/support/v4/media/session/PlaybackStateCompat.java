package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.C0304e.C0303a;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C02921();
    /* renamed from: a */
    final int f579a;
    /* renamed from: b */
    final long f580b;
    /* renamed from: c */
    final long f581c;
    /* renamed from: d */
    final float f582d;
    /* renamed from: e */
    final long f583e;
    /* renamed from: f */
    final int f584f;
    /* renamed from: g */
    final CharSequence f585g;
    /* renamed from: h */
    final long f586h;
    /* renamed from: i */
    List<CustomAction> f587i;
    /* renamed from: j */
    final long f588j;
    /* renamed from: k */
    final Bundle f589k;
    /* renamed from: l */
    private Object f590l;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$1 */
    static class C02921 implements Creator<PlaybackStateCompat> {
        C02921() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m903a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m904a(i);
        }

        /* renamed from: a */
        public PlaybackStateCompat m903a(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: a */
        public PlaybackStateCompat[] m904a(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new C02931();
        /* renamed from: a */
        private final String f574a;
        /* renamed from: b */
        private final CharSequence f575b;
        /* renamed from: c */
        private final int f576c;
        /* renamed from: d */
        private final Bundle f577d;
        /* renamed from: e */
        private Object f578e;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$1 */
        static class C02931 implements Creator<CustomAction> {
            C02931() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m905a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m906a(i);
            }

            /* renamed from: a */
            public CustomAction m905a(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: a */
            public CustomAction[] m906a(int i) {
                return new CustomAction[i];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f574a = str;
            this.f575b = charSequence;
            this.f576c = i;
            this.f577d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f574a = parcel.readString();
            this.f575b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f576c = parcel.readInt();
            this.f577d = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f574a);
            TextUtils.writeToParcel(this.f575b, parcel, i);
            parcel.writeInt(this.f576c);
            parcel.writeBundle(this.f577d);
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: a */
        public static CustomAction m907a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0303a.m1026a(obj), C0303a.m1027b(obj), C0303a.m1028c(obj), C0303a.m1029d(obj));
            customAction.f578e = obj;
            return customAction;
        }

        public String toString() {
            return "Action:mName='" + this.f575b + ", mIcon=" + this.f576c + ", mExtras=" + this.f577d;
        }
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f579a = i;
        this.f580b = j;
        this.f581c = j2;
        this.f582d = f;
        this.f583e = j3;
        this.f584f = i2;
        this.f585g = charSequence;
        this.f586h = j4;
        this.f587i = new ArrayList(list);
        this.f588j = j5;
        this.f589k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f579a = parcel.readInt();
        this.f580b = parcel.readLong();
        this.f582d = parcel.readFloat();
        this.f586h = parcel.readLong();
        this.f581c = parcel.readLong();
        this.f583e = parcel.readLong();
        this.f585g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f587i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f588j = parcel.readLong();
        this.f589k = parcel.readBundle();
        this.f584f = parcel.readInt();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.f579a);
        stringBuilder.append(", position=").append(this.f580b);
        stringBuilder.append(", buffered position=").append(this.f581c);
        stringBuilder.append(", speed=").append(this.f582d);
        stringBuilder.append(", updated=").append(this.f586h);
        stringBuilder.append(", actions=").append(this.f583e);
        stringBuilder.append(", error code=").append(this.f584f);
        stringBuilder.append(", error message=").append(this.f585g);
        stringBuilder.append(", custom actions=").append(this.f587i);
        stringBuilder.append(", active item id=").append(this.f588j);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f579a);
        parcel.writeLong(this.f580b);
        parcel.writeFloat(this.f582d);
        parcel.writeLong(this.f586h);
        parcel.writeLong(this.f581c);
        parcel.writeLong(this.f583e);
        TextUtils.writeToParcel(this.f585g, parcel, i);
        parcel.writeTypedList(this.f587i);
        parcel.writeLong(this.f588j);
        parcel.writeBundle(this.f589k);
        parcel.writeInt(this.f584f);
    }

    /* renamed from: a */
    public static PlaybackStateCompat m908a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Bundle a;
        List<Object> h = C0304e.m1037h(obj);
        List list = null;
        if (h != null) {
            list = new ArrayList(h.size());
            for (Object a2 : h) {
                list.add(CustomAction.m907a(a2));
            }
        }
        if (VERSION.SDK_INT >= 22) {
            a = C0305f.m1039a(obj);
        } else {
            a = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0304e.m1030a(obj), C0304e.m1031b(obj), C0304e.m1032c(obj), C0304e.m1033d(obj), C0304e.m1034e(obj), 0, C0304e.m1035f(obj), C0304e.m1036g(obj), list, C0304e.m1038i(obj), a);
        playbackStateCompat.f590l = obj;
        return playbackStateCompat;
    }
}
