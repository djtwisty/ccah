package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016d.C0234b;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {
    /* renamed from: a */
    static final boolean f521a = Log.isLoggable("MediaBrowserCompat", 3);

    private static class CustomActionResultReceiver extends C0234b {
        /* renamed from: d */
        private final String f511d;
        /* renamed from: e */
        private final Bundle f512e;
        /* renamed from: f */
        private final C0267a f513f;

        /* renamed from: a */
        protected void mo140a(int i, Bundle bundle) {
            if (this.f513f != null) {
                switch (i) {
                    case -1:
                        this.f513f.m786c(this.f511d, this.f512e, bundle);
                        return;
                    case 0:
                        this.f513f.m785b(this.f511d, this.f512e, bundle);
                        return;
                    case 1:
                        this.f513f.m784a(this.f511d, this.f512e, bundle);
                        return;
                    default:
                        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f512e + ", resultData=" + bundle + ")");
                        return;
                }
            }
        }
    }

    private static class ItemReceiver extends C0234b {
        /* renamed from: d */
        private final String f514d;
        /* renamed from: e */
        private final C0268b f515e;

        /* renamed from: a */
        protected void mo140a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
                Parcelable parcelable = bundle.getParcelable("media_item");
                if (parcelable == null || (parcelable instanceof MediaItem)) {
                    this.f515e.m787a((MediaItem) parcelable);
                    return;
                } else {
                    this.f515e.m788a(this.f514d);
                    return;
                }
            }
            this.f515e.m788a(this.f514d);
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR = new C02661();
        /* renamed from: a */
        private final int f516a;
        /* renamed from: b */
        private final MediaDescriptionCompat f517b;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$1 */
        static class C02661 implements Creator<MediaItem> {
            C02661() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m781a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m782a(i);
            }

            /* renamed from: a */
            public MediaItem m781a(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: a */
            public MediaItem[] m782a(int i) {
                return new MediaItem[i];
            }
        }

        MediaItem(Parcel parcel) {
            this.f516a = parcel.readInt();
            this.f517b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f516a);
            this.f517b.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.f516a);
            stringBuilder.append(", mDescription=").append(this.f517b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class SearchResultReceiver extends C0234b {
        /* renamed from: d */
        private final String f518d;
        /* renamed from: e */
        private final Bundle f519e;
        /* renamed from: f */
        private final C0269c f520f;

        /* renamed from: a */
        protected void mo140a(int i, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i == 0 && bundle != null && bundle.containsKey("search_results")) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
                List list = null;
                if (parcelableArray != null) {
                    List arrayList = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add((MediaItem) parcelable);
                    }
                    list = arrayList;
                }
                this.f520f.m790a(this.f518d, this.f519e, list);
                return;
            }
            this.f520f.m789a(this.f518d, this.f519e);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$a */
    public static abstract class C0267a {
        /* renamed from: a */
        public void m784a(String str, Bundle bundle, Bundle bundle2) {
        }

        /* renamed from: b */
        public void m785b(String str, Bundle bundle, Bundle bundle2) {
        }

        /* renamed from: c */
        public void m786c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$b */
    public static abstract class C0268b {
        /* renamed from: a */
        public void m787a(MediaItem mediaItem) {
        }

        /* renamed from: a */
        public void m788a(String str) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$c */
    public static abstract class C0269c {
        /* renamed from: a */
        public void m790a(String str, Bundle bundle, List<MediaItem> list) {
        }

        /* renamed from: a */
        public void m789a(String str, Bundle bundle) {
        }
    }
}
