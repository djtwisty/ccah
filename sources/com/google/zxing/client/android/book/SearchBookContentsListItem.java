package com.google.zxing.client.android.book;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import java.util.Locale;

public final class SearchBookContentsListItem extends LinearLayout {
    private TextView pageNumberView;
    private TextView snippetView;

    SearchBookContentsListItem(Context context) {
        super(context);
    }

    public SearchBookContentsListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.pageNumberView = (TextView) findViewById(C0306R.id.page_number_view);
        this.snippetView = (TextView) findViewById(C0306R.id.snippet_view);
    }

    public void set(SearchBookContentsResult searchBookContentsResult) {
        this.pageNumberView.setText(searchBookContentsResult.getPageNumber());
        CharSequence snippet = searchBookContentsResult.getSnippet();
        if (snippet.isEmpty()) {
            this.snippetView.setText("");
        } else if (searchBookContentsResult.getValidSnippet()) {
            String toLowerCase = SearchBookContentsResult.getQuery().toLowerCase(Locale.getDefault());
            String toLowerCase2 = snippet.toLowerCase(Locale.getDefault());
            CharSequence spannableString = new SpannableString(snippet);
            StyleSpan styleSpan = new StyleSpan(1);
            int length = toLowerCase.length();
            int i = 0;
            while (true) {
                i = toLowerCase2.indexOf(toLowerCase, i);
                if (i < 0) {
                    this.snippetView.setText(spannableString);
                    return;
                } else {
                    spannableString.setSpan(styleSpan, i, i + length, 0);
                    i += length;
                }
            }
        } else {
            this.snippetView.setText(snippet);
        }
    }
}
