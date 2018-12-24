package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p017e.C0238a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new C02721();
    /* renamed from: a */
    static final C0238a<String, Integer> f539a = new C0238a();
    /* renamed from: c */
    private static final String[] f540c = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    /* renamed from: d */
    private static final String[] f541d = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    /* renamed from: e */
    private static final String[] f542e = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    /* renamed from: b */
    final Bundle f543b;
    /* renamed from: f */
    private Object f544f;

    /* renamed from: android.support.v4.media.MediaMetadataCompat$1 */
    static class C02721 implements Creator<MediaMetadataCompat> {
        C02721() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m804a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m805a(i);
        }

        /* renamed from: a */
        public MediaMetadataCompat m804a(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: a */
        public MediaMetadataCompat[] m805a(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    static {
        f539a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f539a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f539a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f539a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f539a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f539a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f539a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f539a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f539a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f539a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f539a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f539a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f539a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f539a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f539a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f539a.put("android.media.metadata.ART", Integer.valueOf(2));
        f539a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f539a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f539a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f539a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f539a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f539a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f539a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f539a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f539a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f539a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        f539a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        f539a.put("android.media.metadata.BT_FOLDER_TYPE", Integer.valueOf(0));
        f539a.put("android.media.metadata.MEDIA_URI", Integer.valueOf(1));
        f539a.put("android.media.metadata.ADVERTISEMENT", Integer.valueOf(0));
        f539a.put("android.media.metadata.DOWNLOAD_STATUS", Integer.valueOf(0));
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f543b = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f543b);
    }

    /* renamed from: a */
    public static MediaMetadataCompat m806a(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        C0278c.m829a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.f544f = obj;
        return mediaMetadataCompat;
    }
}
