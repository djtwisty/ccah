package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.C0302d.C0301a;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new C02881();
        /* renamed from: a */
        private final MediaDescriptionCompat f563a;
        /* renamed from: b */
        private final long f564b;
        /* renamed from: c */
        private Object f565c;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$1 */
        static class C02881 implements Creator<QueueItem> {
            C02881() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m893a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m894a(i);
            }

            /* renamed from: a */
            public QueueItem m893a(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: a */
            public QueueItem[] m894a(int i) {
                return new QueueItem[i];
            }
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.f563a = mediaDescriptionCompat;
                this.f564b = j;
                this.f565c = obj;
            }
        }

        QueueItem(Parcel parcel) {
            this.f563a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f564b = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f563a.writeToParcel(parcel, i);
            parcel.writeLong(this.f564b);
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: a */
        public static QueueItem m895a(Object obj) {
            if (obj == null || VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.m802a(C0301a.m1024a(obj)), C0301a.m1025b(obj));
        }

        /* renamed from: a */
        public static List<QueueItem> m896a(List<?> list) {
            if (list == null || VERSION.SDK_INT < 21) {
                return null;
            }
            List<QueueItem> arrayList = new ArrayList();
            for (Object a : list) {
                arrayList.add(m895a(a));
            }
            return arrayList;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f563a + ", Id=" + this.f564b + " }";
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new C02891();
        /* renamed from: a */
        private ResultReceiver f566a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1 */
        static class C02891 implements Creator<ResultReceiverWrapper> {
            C02891() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m897a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m898a(i);
            }

            /* renamed from: a */
            public ResultReceiverWrapper m897a(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: a */
            public ResultReceiverWrapper[] m898a(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f566a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f566a.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C02901();
        /* renamed from: a */
        private final Object f567a;
        /* renamed from: b */
        private final C0295b f568b;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$1 */
        static class C02901 implements Creator<Token> {
            C02901() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m899a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m900a(i);
            }

            /* renamed from: a */
            public Token m899a(Parcel parcel) {
                Object readParcelable;
                if (VERSION.SDK_INT >= 21) {
                    readParcelable = parcel.readParcelable(null);
                } else {
                    readParcelable = parcel.readStrongBinder();
                }
                return new Token(readParcelable);
            }

            /* renamed from: a */
            public Token[] m900a(int i) {
                return new Token[i];
            }
        }

        Token(Object obj) {
            this(obj, null);
        }

        Token(Object obj, C0295b c0295b) {
            this.f567a = obj;
            this.f568b = c0295b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f567a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f567a);
            }
        }

        public int hashCode() {
            if (this.f567a == null) {
                return 0;
            }
            return this.f567a.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.f567a == null) {
                if (token.f567a != null) {
                    return false;
                }
                return true;
            } else if (token.f567a == null) {
                return false;
            } else {
                return this.f567a.equals(token.f567a);
            }
        }
    }
}
