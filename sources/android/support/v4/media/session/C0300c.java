package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.QueueItem;
import android.media.session.PlaybackState;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.List;

/* renamed from: android.support.v4.media.session.c */
class C0300c {

    /* renamed from: android.support.v4.media.session.c$a */
    public interface C0284a {
        /* renamed from: a */
        void mo153a();

        /* renamed from: a */
        void mo154a(int i, int i2, int i3, int i4, int i5);

        /* renamed from: a */
        void mo155a(Bundle bundle);

        /* renamed from: a */
        void mo156a(CharSequence charSequence);

        /* renamed from: a */
        void mo157a(Object obj);

        /* renamed from: a */
        void mo158a(String str, Bundle bundle);

        /* renamed from: a */
        void mo159a(List<?> list);

        /* renamed from: b */
        void mo160b(Object obj);
    }

    /* renamed from: android.support.v4.media.session.c$b */
    static class C0298b<T extends C0284a> extends Callback {
        /* renamed from: a */
        protected final T f593a;

        public C0298b(T t) {
            this.f593a = t;
        }

        public void onSessionDestroyed() {
            this.f593a.mo153a();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            this.f593a.mo158a(str, bundle);
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f593a.mo157a((Object) playbackState);
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f593a.mo160b(mediaMetadata);
        }

        public void onQueueChanged(List<QueueItem> list) {
            this.f593a.mo159a((List) list);
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f593a.mo156a(charSequence);
        }

        public void onExtrasChanged(Bundle bundle) {
            this.f593a.mo155a(bundle);
        }

        public void onAudioInfoChanged(PlaybackInfo playbackInfo) {
            this.f593a.mo154a(playbackInfo.getPlaybackType(), C0299c.m1022b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }

    /* renamed from: android.support.v4.media.session.c$c */
    public static class C0299c {
        /* renamed from: a */
        public static AudioAttributes m1021a(Object obj) {
            return ((PlaybackInfo) obj).getAudioAttributes();
        }

        /* renamed from: b */
        public static int m1022b(Object obj) {
            return C0299c.m1020a(C0299c.m1021a(obj));
        }

        /* renamed from: a */
        private static int m1020a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            switch (audioAttributes.getUsage()) {
                case 1:
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                case 12:
                case 14:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 13:
                    return 1;
                default:
                    return 3;
            }
        }
    }

    /* renamed from: a */
    public static Object m1023a(C0284a c0284a) {
        return new C0298b(c0284a);
    }
}
