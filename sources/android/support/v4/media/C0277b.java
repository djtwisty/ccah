package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.support.v4.media.C0275a.C0274a;

/* renamed from: android.support.v4.media.b */
class C0277b extends C0275a {

    /* renamed from: android.support.v4.media.b$a */
    static class C0276a extends C0274a {
        /* renamed from: b */
        public static void m827b(Object obj, Uri uri) {
            ((Builder) obj).setMediaUri(uri);
        }
    }

    /* renamed from: h */
    public static Uri m828h(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
