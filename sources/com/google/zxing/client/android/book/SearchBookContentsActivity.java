package com.google.zxing.client.android.book;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.android.HttpHelper;
import com.google.zxing.client.android.HttpHelper.ContentType;
import com.google.zxing.client.android.Intents.SearchBookContents;
import com.google.zxing.client.android.LocaleManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SearchBookContentsActivity extends Activity {
    private static final Pattern GT_ENTITY_PATTERN = Pattern.compile("&gt;");
    private static final Pattern LT_ENTITY_PATTERN = Pattern.compile("&lt;");
    private static final Pattern QUOTE_ENTITY_PATTERN = Pattern.compile("&#39;");
    private static final Pattern QUOT_ENTITY_PATTERN = Pattern.compile("&quot;");
    private static final String TAG = SearchBookContentsActivity.class.getSimpleName();
    private static final Pattern TAG_PATTERN = Pattern.compile("\\<.*?\\>");
    private final OnClickListener buttonListener = new C04071();
    private TextView headerView;
    private String isbn;
    private final OnKeyListener keyListener = new C04082();
    private AsyncTask<String, ?, ?> networkTask;
    private View queryButton;
    private EditText queryTextView;
    private ListView resultListView;

    /* renamed from: com.google.zxing.client.android.book.SearchBookContentsActivity$1 */
    class C04071 implements OnClickListener {
        C04071() {
        }

        public void onClick(View view) {
            SearchBookContentsActivity.this.launchSearch();
        }
    }

    /* renamed from: com.google.zxing.client.android.book.SearchBookContentsActivity$2 */
    class C04082 implements OnKeyListener {
        C04082() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66 || keyEvent.getAction() != 0) {
                return false;
            }
            SearchBookContentsActivity.this.launchSearch();
            return true;
        }
    }

    private final class NetworkTask extends AsyncTask<String, Object, JSONObject> {
        private NetworkTask() {
        }

        protected JSONObject doInBackground(String... strArr) {
            try {
                String str = strArr[0];
                String str2 = strArr[1];
                if (LocaleManager.isBookSearchUrl(str2)) {
                    str = "http://www.google.com/books?id=" + str2.substring(str2.indexOf(61) + 1) + "&jscmd=SearchWithinVolume2&q=" + str;
                } else {
                    str = "http://www.google.com/books?vid=isbn" + str2 + "&jscmd=SearchWithinVolume2&q=" + str;
                }
                return new JSONObject(HttpHelper.downloadViaHttp(str, ContentType.JSON).toString());
            } catch (Throwable e) {
                Log.w(SearchBookContentsActivity.TAG, "Error accessing book search", e);
                return null;
            } catch (Throwable e2) {
                Log.w(SearchBookContentsActivity.TAG, "Error accessing book search", e2);
                return null;
            }
        }

        protected void onPostExecute(JSONObject jSONObject) {
            if (jSONObject == null) {
                SearchBookContentsActivity.this.headerView.setText(C0306R.string.msg_sbc_failed);
            } else {
                handleSearchResults(jSONObject);
            }
            SearchBookContentsActivity.this.queryTextView.setEnabled(true);
            SearchBookContentsActivity.this.queryTextView.selectAll();
            SearchBookContentsActivity.this.queryButton.setEnabled(true);
        }

        private void handleSearchResults(JSONObject jSONObject) {
            try {
                int i = jSONObject.getInt("number_of_results");
                SearchBookContentsActivity.this.headerView.setText(SearchBookContentsActivity.this.getString(C0306R.string.msg_sbc_results) + " : " + i);
                if (i > 0) {
                    JSONArray jSONArray = jSONObject.getJSONArray("search_results");
                    SearchBookContentsResult.setQuery(SearchBookContentsActivity.this.queryTextView.getText().toString());
                    List arrayList = new ArrayList(i);
                    for (int i2 = 0; i2 < i; i2++) {
                        arrayList.add(parseResult(jSONArray.getJSONObject(i2)));
                    }
                    SearchBookContentsActivity.this.resultListView.setOnItemClickListener(new BrowseBookListener(SearchBookContentsActivity.this, arrayList));
                    SearchBookContentsActivity.this.resultListView.setAdapter(new SearchBookContentsAdapter(SearchBookContentsActivity.this, arrayList));
                    return;
                }
                if ("false".equals(jSONObject.optString("searchable"))) {
                    SearchBookContentsActivity.this.headerView.setText(C0306R.string.msg_sbc_book_not_searchable);
                }
                SearchBookContentsActivity.this.resultListView.setAdapter(null);
            } catch (Throwable e) {
                Log.w(SearchBookContentsActivity.TAG, "Bad JSON from book search", e);
                SearchBookContentsActivity.this.resultListView.setAdapter(null);
                SearchBookContentsActivity.this.headerView.setText(C0306R.string.msg_sbc_failed);
            }
        }

        private SearchBookContentsResult parseResult(JSONObject jSONObject) {
            try {
                String str;
                boolean z;
                String string = jSONObject.getString("page_id");
                String optString = jSONObject.optString("page_number");
                CharSequence optString2 = jSONObject.optString("snippet_text");
                if (optString == null || optString.isEmpty()) {
                    str = "";
                } else {
                    str = SearchBookContentsActivity.this.getString(C0306R.string.msg_sbc_page) + ' ' + optString;
                }
                if (optString2 == null || optString2.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    optString = SearchBookContentsActivity.QUOT_ENTITY_PATTERN.matcher(SearchBookContentsActivity.QUOTE_ENTITY_PATTERN.matcher(SearchBookContentsActivity.GT_ENTITY_PATTERN.matcher(SearchBookContentsActivity.LT_ENTITY_PATTERN.matcher(SearchBookContentsActivity.TAG_PATTERN.matcher(optString2).replaceAll("")).replaceAll("<")).replaceAll(">")).replaceAll("'")).replaceAll("\"");
                } else {
                    optString = '(' + SearchBookContentsActivity.this.getString(C0306R.string.msg_sbc_snippet_unavailable) + ')';
                }
                return new SearchBookContentsResult(string, str, optString, z);
            } catch (Throwable e) {
                Log.w(SearchBookContentsActivity.TAG, e);
                return new SearchBookContentsResult(SearchBookContentsActivity.this.getString(C0306R.string.msg_sbc_no_page_returned), "", "", false);
            }
        }
    }

    String getISBN() {
        return this.isbn;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeExpiredCookie();
        Intent intent = getIntent();
        if (intent == null || !SearchBookContents.ACTION.equals(intent.getAction())) {
            finish();
            return;
        }
        this.isbn = intent.getStringExtra(SearchBookContents.ISBN);
        if (LocaleManager.isBookSearchUrl(this.isbn)) {
            setTitle(getString(C0306R.string.sbc_name));
        } else {
            setTitle(getString(C0306R.string.sbc_name) + ": ISBN " + this.isbn);
        }
        setContentView(C0306R.layout.search_book_contents);
        this.queryTextView = (EditText) findViewById(C0306R.id.query_text_view);
        CharSequence stringExtra = intent.getStringExtra(SearchBookContents.QUERY);
        if (!(stringExtra == null || stringExtra.isEmpty())) {
            this.queryTextView.setText(stringExtra);
        }
        this.queryTextView.setOnKeyListener(this.keyListener);
        this.queryButton = findViewById(C0306R.id.query_button);
        this.queryButton.setOnClickListener(this.buttonListener);
        this.resultListView = (ListView) findViewById(C0306R.id.result_list_view);
        this.headerView = (TextView) LayoutInflater.from(this).inflate(C0306R.layout.search_book_contents_header, this.resultListView, false);
        this.resultListView.addHeaderView(this.headerView);
    }

    protected void onResume() {
        super.onResume();
        this.queryTextView.selectAll();
    }

    protected void onPause() {
        AsyncTask asyncTask = this.networkTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.networkTask = null;
        }
        super.onPause();
    }

    private void launchSearch() {
        String obj = this.queryTextView.getText().toString();
        if (obj != null && !obj.isEmpty()) {
            AsyncTask asyncTask = this.networkTask;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            this.networkTask = new NetworkTask();
            this.networkTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{obj, this.isbn});
            this.headerView.setText(C0306R.string.msg_sbc_searching_book);
            this.resultListView.setAdapter(null);
            this.queryTextView.setEnabled(false);
            this.queryButton.setEnabled(false);
        }
    }
}
