package com.google.zxing.client.android.result.supplement;

import android.content.Context;
import android.widget.TextView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.android.HttpHelper;
import com.google.zxing.client.android.HttpHelper.ContentType;
import com.google.zxing.client.android.LocaleManager;
import com.google.zxing.client.android.history.HistoryManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

final class BookResultInfoRetriever extends SupplementalInfoRetriever {
    private final Context context;
    private final String isbn;
    private final String source;

    BookResultInfoRetriever(TextView textView, String str, HistoryManager historyManager, Context context) {
        super(textView, historyManager);
        this.isbn = str;
        this.source = context.getString(C0306R.string.msg_google_books);
        this.context = context;
    }

    void retrieveSupplementalInfo() {
        String str = null;
        CharSequence downloadViaHttp = HttpHelper.downloadViaHttp("https://www.googleapis.com/books/v1/volumes?q=isbn:" + this.isbn, ContentType.JSON);
        if (downloadViaHttp.length() != 0) {
            try {
                JSONArray optJSONArray = ((JSONObject) new JSONTokener(downloadViaHttp.toString()).nextValue()).optJSONArray("items");
                if (optJSONArray != null && !optJSONArray.isNull(0)) {
                    JSONObject jSONObject = ((JSONObject) optJSONArray.get(0)).getJSONObject("volumeInfo");
                    if (jSONObject != null) {
                        Collection collection;
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("pageCount");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("authors");
                        if (optJSONArray2 == null || optJSONArray2.isNull(0)) {
                            collection = null;
                        } else {
                            collection = new ArrayList(optJSONArray2.length());
                            for (int i = 0; i < optJSONArray2.length(); i++) {
                                collection.add(optJSONArray2.getString(i));
                            }
                        }
                        Collection arrayList = new ArrayList();
                        SupplementalInfoRetriever.maybeAddText(optString, arrayList);
                        SupplementalInfoRetriever.maybeAddTextSeries(collection, arrayList);
                        if (!(optString2 == null || optString2.isEmpty())) {
                            str = optString2 + "pp.";
                        }
                        SupplementalInfoRetriever.maybeAddText(str, arrayList);
                        append(this.isbn, this.source, (String[]) arrayList.toArray(new String[arrayList.size()]), ("http://www.google." + LocaleManager.getBookSearchCountryTLD(this.context) + "/search?tbm=bks&source=zxing&q=") + this.isbn);
                    }
                }
            } catch (Throwable e) {
                throw new IOException(e);
            }
        }
    }
}
