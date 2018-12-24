package com.google.zxing.client.android.result.supplement;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.widget.TextView;
import com.google.zxing.client.android.history.HistoryManager;
import com.google.zxing.client.result.ISBNParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ProductParsedResult;
import com.google.zxing.client.result.URIParsedResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;
import org.apache.http.HttpHost;

public abstract class SupplementalInfoRetriever extends AsyncTask<Object, Object, Object> {
    private static final String TAG = "SupplementalInfo";
    private final WeakReference<HistoryManager> historyManagerRef;
    private final Collection<Spannable> newContents = new ArrayList();
    private final Collection<String[]> newHistories = new ArrayList();
    private final WeakReference<TextView> textViewRef;

    abstract void retrieveSupplementalInfo();

    public static void maybeInvokeRetrieval(TextView textView, ParsedResult parsedResult, HistoryManager historyManager, Context context) {
        try {
            if (parsedResult instanceof URIParsedResult) {
                new URIResultInfoRetriever(textView, (URIParsedResult) parsedResult, historyManager, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                new TitleRetriever(textView, (URIParsedResult) parsedResult, historyManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            } else if (parsedResult instanceof ProductParsedResult) {
                new ProductResultInfoRetriever(textView, ((ProductParsedResult) parsedResult).getProductID(), historyManager, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            } else if (parsedResult instanceof ISBNParsedResult) {
                String isbn = ((ISBNParsedResult) parsedResult).getISBN();
                new ProductResultInfoRetriever(textView, isbn, historyManager, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                new BookResultInfoRetriever(textView, isbn, historyManager, context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
            }
        } catch (RejectedExecutionException e) {
        }
    }

    SupplementalInfoRetriever(TextView textView, HistoryManager historyManager) {
        this.textViewRef = new WeakReference(textView);
        this.historyManagerRef = new WeakReference(historyManager);
    }

    public final Object doInBackground(Object... objArr) {
        try {
            retrieveSupplementalInfo();
        } catch (Throwable e) {
            Log.w(TAG, e);
        }
        return null;
    }

    protected final void onPostExecute(Object obj) {
        TextView textView = (TextView) this.textViewRef.get();
        if (textView != null) {
            for (CharSequence append : this.newContents) {
                textView.append(append);
            }
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        HistoryManager historyManager = (HistoryManager) this.historyManagerRef.get();
        if (historyManager != null) {
            for (String[] strArr : this.newHistories) {
                historyManager.addHistoryItemDetails(strArr[0], strArr[1]);
            }
        }
    }

    final void append(String str, String str2, String[] strArr, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str2 != null) {
            stringBuilder.append(str2).append(' ');
        }
        int length = stringBuilder.length();
        int i = 1;
        for (String str4 : strArr) {
            if (i != 0) {
                stringBuilder.append(str4);
                i = 0;
            } else {
                stringBuilder.append(" [");
                stringBuilder.append(str4);
                stringBuilder.append(']');
            }
        }
        i = stringBuilder.length();
        Spannable spannableString = new SpannableString(stringBuilder.toString() + "\n\n");
        if (str3 != null) {
            if (str3.startsWith("HTTP://")) {
                str3 = HttpHost.DEFAULT_SCHEME_NAME + str3.substring(4);
            } else if (str3.startsWith("HTTPS://")) {
                str3 = "https" + str3.substring(5);
            }
            spannableString.setSpan(new URLSpan(str3), length, i, 33);
        }
        this.newContents.add(spannableString);
        this.newHistories.add(new String[]{str, r2});
    }

    static void maybeAddText(String str, Collection<String> collection) {
        if (str != null && !str.isEmpty()) {
            collection.add(str);
        }
    }

    static void maybeAddTextSeries(Collection<String> collection, Collection<String> collection2) {
        if (collection != null && !collection.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            for (String str : collection) {
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(str);
            }
            collection2.add(stringBuilder.toString());
        }
    }
}
