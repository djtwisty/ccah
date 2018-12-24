package com.google.zxing.client.android.book;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.zxing.client.android.LocaleManager;
import java.util.List;

final class BrowseBookListener implements OnItemClickListener {
    private final SearchBookContentsActivity activity;
    private final List<SearchBookContentsResult> items;

    BrowseBookListener(SearchBookContentsActivity searchBookContentsActivity, List<SearchBookContentsResult> list) {
        this.activity = searchBookContentsActivity;
        this.items = list;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 1) {
            int i2 = i - 1;
            if (i2 < this.items.size()) {
                String pageId = ((SearchBookContentsResult) this.items.get(i2)).getPageId();
                String query = SearchBookContentsResult.getQuery();
                if (LocaleManager.isBookSearchUrl(this.activity.getISBN()) && !pageId.isEmpty()) {
                    String isbn = this.activity.getISBN();
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://books.google." + LocaleManager.getBookSearchCountryTLD(this.activity) + "/books?id=" + isbn.substring(isbn.indexOf(61) + 1) + "&pg=" + pageId + "&vq=" + query));
                    intent.addFlags(524288);
                    this.activity.startActivity(intent);
                }
            }
        }
    }
}
