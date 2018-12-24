package com.google.zxing.client.android.result;

import android.app.Activity;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.Result;
import com.google.zxing.client.result.ISBNParsedResult;
import com.google.zxing.client.result.ParsedResult;

public final class ISBNResultHandler extends ResultHandler {
    private static final int[] buttons = new int[]{C0306R.string.button_product_search, C0306R.string.button_book_search, C0306R.string.button_search_book_contents, C0306R.string.button_custom_product_search};

    public ISBNResultHandler(Activity activity, ParsedResult parsedResult, Result result) {
        super(activity, parsedResult, result);
    }

    public int getButtonCount() {
        return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public void handleButtonPress(int i) {
        ISBNParsedResult iSBNParsedResult = (ISBNParsedResult) getResult();
        switch (i) {
            case 0:
                openProductSearch(iSBNParsedResult.getISBN());
                return;
            case 1:
                openBookSearch(iSBNParsedResult.getISBN());
                return;
            case 2:
                searchBookContents(iSBNParsedResult.getISBN());
                return;
            case 3:
                openURL(fillInCustomSearchURL(iSBNParsedResult.getISBN()));
                return;
            default:
                return;
        }
    }

    public int getDisplayTitle() {
        return C0306R.string.result_isbn;
    }
}
