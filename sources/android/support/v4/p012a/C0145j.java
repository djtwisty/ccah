package android.support.v4.p012a;

import android.app.Activity;
import android.arch.lifecycle.C0078b;
import android.arch.lifecycle.C0078b.C0077b;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.p012a.C0101a.C0094a;
import android.support.v4.p012a.C0101a.C0095b;
import android.support.v4.p017e.C0237i;
import android.support.v4.p017e.C0251j;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.a.j */
public class C0145j extends C0128f implements C0094a, C0095b {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final C0146l mFragments = C0146l.m306a(new C0143a(this));
    final Handler mHandler = new C01411(this);
    int mNextCandidateRequestIndex;
    C0251j<String> mPendingFragmentActivityResults;
    boolean mReallyStopped = true;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped = true;

    /* renamed from: android.support.v4.a.j$1 */
    class C01411 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C0145j f184a;

        C01411(C0145j c0145j) {
            this.f184a = c0145j;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f184a.mStopped) {
                        this.f184a.doReallyStop(false);
                        return;
                    }
                    return;
                case 2:
                    this.f184a.onResumeFragments();
                    this.f184a.mFragments.m336o();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* renamed from: android.support.v4.a.j$a */
    class C0143a extends C0142m<C0145j> {
        /* renamed from: a */
        final /* synthetic */ C0145j f195a;

        /* renamed from: g */
        public /* synthetic */ Object mo83g() {
            return m301c();
        }

        public C0143a(C0145j c0145j) {
            this.f195a = c0145j;
            super(c0145j);
        }

        /* renamed from: a */
        public void mo75a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f195a.dump(str, fileDescriptor, printWriter, strArr);
        }

        /* renamed from: a */
        public boolean mo76a(C0131i c0131i) {
            return !this.f195a.isFinishing();
        }

        /* renamed from: b */
        public LayoutInflater mo78b() {
            return this.f195a.getLayoutInflater().cloneInContext(this.f195a);
        }

        /* renamed from: c */
        public C0145j m301c() {
            return this.f195a;
        }

        /* renamed from: d */
        public void mo80d() {
            this.f195a.supportInvalidateOptionsMenu();
        }

        /* renamed from: a */
        public void mo72a(C0131i c0131i, Intent intent, int i, Bundle bundle) {
            this.f195a.startActivityFromFragment(c0131i, intent, i, bundle);
        }

        /* renamed from: a */
        public void mo73a(C0131i c0131i, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            this.f195a.startIntentSenderFromFragment(c0131i, intentSender, i, intent, i2, i3, i4, bundle);
        }

        /* renamed from: a */
        public void mo74a(C0131i c0131i, String[] strArr, int i) {
            this.f195a.requestPermissionsFromFragment(c0131i, strArr, i);
        }

        /* renamed from: a */
        public boolean mo77a(String str) {
            return C0101a.m134a(this.f195a, str);
        }

        /* renamed from: e */
        public boolean mo81e() {
            return this.f195a.getWindow() != null;
        }

        /* renamed from: f */
        public int mo82f() {
            Window window = this.f195a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        /* renamed from: b */
        public void mo79b(C0131i c0131i) {
            this.f195a.onAttachFragment(c0131i);
        }

        /* renamed from: a */
        public View mo70a(int i) {
            return this.f195a.findViewById(i);
        }

        /* renamed from: a */
        public boolean mo71a() {
            Window window = this.f195a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* renamed from: android.support.v4.a.j$b */
    static final class C0144b {
        /* renamed from: a */
        Object f196a;
        /* renamed from: b */
        C0163p f197b;
        /* renamed from: c */
        C0237i<String, C0183v> f198c;

        C0144b() {
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.m323c();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.mPendingFragmentActivityResults.m756a(i4);
            this.mPendingFragmentActivityResults.m762c(i4);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C0131i a = this.mFragments.m307a(str);
            if (a == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.onActivityResult(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        C0149n a = this.mFragments.m308a();
        boolean d = a.mo103d();
        if (d && VERSION.SDK_INT <= 25) {
            return;
        }
        if (d || !a.mo101b()) {
            super.onBackPressed();
        }
    }

    public void supportFinishAfterTransition() {
        C0101a.m129a(this);
    }

    public void setEnterSharedElementCallback(an anVar) {
        C0101a.m132a((Activity) this, anVar);
    }

    public void setExitSharedElementCallback(an anVar) {
        C0101a.m136b(this, anVar);
    }

    public void supportPostponeEnterTransition() {
        C0101a.m135b(this);
    }

    public void supportStartPostponedEnterTransition() {
        C0101a.m137c(this);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.m315a(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.m321b(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.m310a(configuration);
    }

    public C0078b getLifecycle() {
        return super.getLifecycle();
    }

    protected void onCreate(Bundle bundle) {
        this.mFragments.m312a(null);
        super.onCreate(bundle);
        C0144b c0144b = (C0144b) getLastNonConfigurationInstance();
        if (c0144b != null) {
            this.mFragments.m313a(c0144b.f198c);
        }
        if (bundle != null) {
            this.mFragments.m311a(bundle.getParcelable(FRAGMENTS_TAG), c0144b != null ? c0144b.f197b : null);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new C0251j(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.m760b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new C0251j();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.m327f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            return super.onCreatePanelMenu(i, menu) | this.mFragments.m317a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.m309a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.m334m();
        this.mFragments.m338q();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.m335n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.m318a(menuItem);
            case 6:
                return this.mFragments.m322b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.m320b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.m331j();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.m323c();
    }

    public void onStateNotSaved() {
        this.mFragments.m323c();
    }

    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.m336o();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.m336o();
    }

    protected void onResumeFragments() {
        this.mFragments.m330i();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.m316a(menu);
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        C0163p e = this.mFragments.m326e();
        C0237i s = this.mFragments.m340s();
        if (e == null && s == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        Object c0144b = new C0144b();
        c0144b.f196a = onRetainCustomNonConfigurationInstance;
        c0144b.f197b = e;
        c0144b.f198c = s;
        return c0144b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        C0145j.markState(getSupportFragmentManager(), C0077b.CREATED);
        Parcelable d = this.mFragments.m325d();
        if (d != null) {
            bundle.putParcelable(FRAGMENTS_TAG, d);
        }
        if (this.mPendingFragmentActivityResults.m758b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.m758b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.m758b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.m758b(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.m763d(i);
                strArr[i] = (String) this.mPendingFragmentActivityResults.m764e(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.m328g();
        }
        this.mFragments.m323c();
        this.mFragments.m336o();
        this.mFragments.m337p();
        this.mFragments.m329h();
        this.mFragments.m339r();
    }

    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        C0145j.markState(getSupportFragmentManager(), C0077b.CREATED);
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.m332k();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        C0144b c0144b = (C0144b) getLastNonConfigurationInstance();
        return c0144b != null ? c0144b.f196a : null;
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        this.mFragments.m314a(str2, fileDescriptor, printWriter, strArr);
        this.mFragments.m308a().mo100a(str, fileDescriptor, printWriter, strArr);
    }

    void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(1);
            onReallyStop();
        } else if (z) {
            this.mFragments.m337p();
            this.mFragments.m324c(true);
        }
    }

    void onReallyStop() {
        this.mFragments.m324c(this.mRetaining);
        this.mFragments.m333l();
    }

    public void onAttachFragment(C0131i c0131i) {
    }

    public C0149n getSupportFragmentManager() {
        return this.mFragments.m308a();
    }

    public C0183v getSupportLoaderManager() {
        return this.mFragments.m319b();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.mStartedActivityFromFragment || i == -1)) {
            C0127e.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            C0127e.checkForValidRequestCode(i);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.mPendingFragmentActivityResults.m756a(i3);
            this.mPendingFragmentActivityResults.m762c(i3);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C0131i a = this.mFragments.m307a(str);
            if (a == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + str);
            } else {
                a.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(C0131i c0131i, Intent intent, int i) {
        startActivityFromFragment(c0131i, intent, i, null);
    }

    public void startActivityFromFragment(C0131i c0131i, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                C0101a.m130a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            C0127e.checkForValidRequestCode(i);
            C0101a.m130a(this, intent, ((allocateRequestIndex(c0131i) + 1) << 16) + (65535 & i), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public void startIntentSenderFromFragment(C0131i c0131i, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mStartedIntentSenderFromFragment = true;
        if (i == -1) {
            try {
                C0101a.m131a(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            C0127e.checkForValidRequestCode(i);
            C0101a.m131a(this, intentSender, ((allocateRequestIndex(c0131i) + 1) << 16) + (65535 & i), intent, i2, i3, i4, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    private int allocateRequestIndex(C0131i c0131i) {
        if (this.mPendingFragmentActivityResults.m758b() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.mPendingFragmentActivityResults.m765f(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        }
        int i = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.m760b(i, c0131i.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        return i;
    }

    void requestPermissionsFromFragment(C0131i c0131i, String[] strArr, int i) {
        if (i == -1) {
            C0101a.m133a(this, strArr, i);
            return;
        }
        C0127e.checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            C0101a.m133a(this, strArr, ((allocateRequestIndex(c0131i) + 1) << 16) + (65535 & i));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    private static void markState(C0149n c0149n, C0077b c0077b) {
        for (C0131i c0131i : c0149n.mo102c()) {
            if (c0131i != null) {
                c0131i.mLifecycleRegistry.m110a(c0077b);
                C0145j.markState(c0131i.getChildFragmentManager(), c0077b);
            }
        }
    }
}
