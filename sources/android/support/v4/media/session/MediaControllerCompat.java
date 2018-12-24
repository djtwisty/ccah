package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.C0279a.C0280a;
import android.support.v4.media.session.C0295b.C0297a;
import android.support.v4.media.session.C0300c.C0284a;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.support.v4.p012a.C0130g;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    static class MediaControllerImplApi21 {
        /* renamed from: a */
        private final List<C0286a> f549a;
        /* renamed from: b */
        private C0295b f550b;
        /* renamed from: c */
        private HashMap<C0286a, C0282a> f551c;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            /* renamed from: a */
            private WeakReference<MediaControllerImplApi21> f547a;

            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f547a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    mediaControllerImplApi21.f550b = C0297a.m1019a(C0130g.m235a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    mediaControllerImplApi21.m862a();
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
        private static class C0282a extends C0281c {
            C0282a(C0286a c0286a) {
                super(c0286a);
            }

            /* renamed from: a */
            public void mo141a() {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo144a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo149a(List<QueueItem> list) {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo147a(CharSequence charSequence) {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo143a(Bundle bundle) {
                throw new AssertionError();
            }

            /* renamed from: a */
            public void mo145a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        private void m862a() {
            if (this.f550b != null) {
                synchronized (this.f549a) {
                    for (C0286a c0286a : this.f549a) {
                        C0279a c0282a = new C0282a(c0286a);
                        this.f551c.put(c0286a, c0282a);
                        c0286a.f556b = true;
                        try {
                            this.f550b.mo169a(c0282a);
                        } catch (Throwable e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    this.f549a.clear();
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$a */
    public static abstract class C0286a implements DeathRecipient {
        /* renamed from: a */
        C0283a f555a;
        /* renamed from: b */
        boolean f556b;
        /* renamed from: c */
        private final Object f557c;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$c */
        private static class C0281c extends C0280a {
            /* renamed from: a */
            private final WeakReference<C0286a> f548a;

            C0281c(C0286a c0286a) {
                this.f548a = new WeakReference(c0286a);
            }

            /* renamed from: a */
            public void mo148a(String str, Bundle bundle) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(1, str, bundle);
                }
            }

            /* renamed from: a */
            public void mo141a() {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(8, null, null);
                }
            }

            /* renamed from: a */
            public void mo146a(PlaybackStateCompat playbackStateCompat) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(2, playbackStateCompat, null);
                }
            }

            /* renamed from: a */
            public void mo144a(MediaMetadataCompat mediaMetadataCompat) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(3, mediaMetadataCompat, null);
                }
            }

            /* renamed from: a */
            public void mo149a(List<QueueItem> list) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(5, list, null);
                }
            }

            /* renamed from: a */
            public void mo147a(CharSequence charSequence) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(6, charSequence, null);
                }
            }

            /* renamed from: b */
            public void mo152b(boolean z) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(11, Boolean.valueOf(z), null);
                }
            }

            /* renamed from: a */
            public void mo142a(int i) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(9, Integer.valueOf(i), null);
                }
            }

            /* renamed from: a */
            public void mo150a(boolean z) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(10, Boolean.valueOf(z), null);
                }
            }

            /* renamed from: b */
            public void mo151b(int i) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(12, Integer.valueOf(i), null);
                }
            }

            /* renamed from: a */
            public void mo143a(Bundle bundle) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    c0286a.m882a(7, bundle, null);
                }
            }

            /* renamed from: a */
            public void mo145a(ParcelableVolumeInfo parcelableVolumeInfo) {
                C0286a c0286a = (C0286a) this.f548a.get();
                if (c0286a != null) {
                    Object c0287b;
                    if (parcelableVolumeInfo != null) {
                        c0287b = new C0287b(parcelableVolumeInfo.f569a, parcelableVolumeInfo.f570b, parcelableVolumeInfo.f571c, parcelableVolumeInfo.f572d, parcelableVolumeInfo.f573e);
                    } else {
                        c0287b = null;
                    }
                    c0286a.m882a(4, c0287b, null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a */
        private class C0283a extends Handler {
            /* renamed from: a */
            boolean f552a;
            /* renamed from: b */
            final /* synthetic */ C0286a f553b;

            public void handleMessage(Message message) {
                if (this.f552a) {
                    switch (message.what) {
                        case 1:
                            this.f553b.m888a((String) message.obj, message.getData());
                            return;
                        case 2:
                            this.f553b.m886a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.f553b.m884a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.f553b.m885a((C0287b) message.obj);
                            return;
                        case 5:
                            this.f553b.m889a((List) message.obj);
                            return;
                        case 6:
                            this.f553b.m887a((CharSequence) message.obj);
                            return;
                        case 7:
                            this.f553b.m883a((Bundle) message.obj);
                            return;
                        case 8:
                            this.f553b.m880a();
                            return;
                        case 9:
                            this.f553b.m881a(((Integer) message.obj).intValue());
                            return;
                        case 10:
                            this.f553b.m892b(((Boolean) message.obj).booleanValue());
                            return;
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                            this.f553b.m890a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.f553b.m891b(((Integer) message.obj).intValue());
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$b */
        private static class C0285b implements C0284a {
            /* renamed from: a */
            private final WeakReference<C0286a> f554a;

            C0285b(C0286a c0286a) {
                this.f554a = new WeakReference(c0286a);
            }

            /* renamed from: a */
            public void mo153a() {
                C0286a c0286a = (C0286a) this.f554a.get();
                if (c0286a != null) {
                    c0286a.m880a();
                }
            }

            /* renamed from: a */
            public void mo158a(String str, Bundle bundle) {
                C0286a c0286a = (C0286a) this.f554a.get();
                if (c0286a == null) {
                    return;
                }
                if (!c0286a.f556b || VERSION.SDK_INT >= 23) {
                    c0286a.m888a(str, bundle);
                }
            }

            /* renamed from: a */
            public void mo157a(Object obj) {
                C0286a c0286a = (C0286a) this.f554a.get();
                if (c0286a != null && !c0286a.f556b) {
                    c0286a.m886a(PlaybackStateCompat.m908a(obj));
                }
            }

            /* renamed from: b */
            public void mo160b(Object obj) {
                C0286a c0286a = (C0286a) this.f554a.get();
                if (c0286a != null) {
                    c0286a.m884a(MediaMetadataCompat.m806a(obj));
                }
            }

            /* renamed from: a */
            public void mo159a(List<?> list) {
                C0286a c0286a = (C0286a) this.f554a.get();
                if (c0286a != null) {
                    c0286a.m889a(QueueItem.m896a((List) list));
                }
            }

            /* renamed from: a */
            public void mo156a(CharSequence charSequence) {
                C0286a c0286a = (C0286a) this.f554a.get();
                if (c0286a != null) {
                    c0286a.m887a(charSequence);
                }
            }

            /* renamed from: a */
            public void mo155a(Bundle bundle) {
                C0286a c0286a = (C0286a) this.f554a.get();
                if (c0286a != null) {
                    c0286a.m883a(bundle);
                }
            }

            /* renamed from: a */
            public void mo154a(int i, int i2, int i3, int i4, int i5) {
                C0286a c0286a = (C0286a) this.f554a.get();
                if (c0286a != null) {
                    c0286a.m885a(new C0287b(i, i2, i3, i4, i5));
                }
            }
        }

        public C0286a() {
            if (VERSION.SDK_INT >= 21) {
                this.f557c = C0300c.m1023a(new C0285b(this));
            } else {
                this.f557c = new C0281c(this);
            }
        }

        /* renamed from: a */
        public void m880a() {
        }

        /* renamed from: a */
        public void m888a(String str, Bundle bundle) {
        }

        /* renamed from: a */
        public void m886a(PlaybackStateCompat playbackStateCompat) {
        }

        /* renamed from: a */
        public void m884a(MediaMetadataCompat mediaMetadataCompat) {
        }

        /* renamed from: a */
        public void m889a(List<QueueItem> list) {
        }

        /* renamed from: a */
        public void m887a(CharSequence charSequence) {
        }

        /* renamed from: a */
        public void m883a(Bundle bundle) {
        }

        /* renamed from: a */
        public void m885a(C0287b c0287b) {
        }

        /* renamed from: a */
        public void m890a(boolean z) {
        }

        /* renamed from: a */
        public void m881a(int i) {
        }

        @Deprecated
        /* renamed from: b */
        public void m892b(boolean z) {
        }

        /* renamed from: b */
        public void m891b(int i) {
        }

        /* renamed from: a */
        void m882a(int i, Object obj, Bundle bundle) {
            if (this.f555a != null) {
                Message obtainMessage = this.f555a.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$b */
    public static final class C0287b {
        /* renamed from: a */
        private final int f558a;
        /* renamed from: b */
        private final int f559b;
        /* renamed from: c */
        private final int f560c;
        /* renamed from: d */
        private final int f561d;
        /* renamed from: e */
        private final int f562e;

        C0287b(int i, int i2, int i3, int i4, int i5) {
            this.f558a = i;
            this.f559b = i2;
            this.f560c = i3;
            this.f561d = i4;
            this.f562e = i5;
        }
    }
}
