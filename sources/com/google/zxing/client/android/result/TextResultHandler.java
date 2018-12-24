package com.google.zxing.client.android.result;

import android.app.Activity;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;

public final class TextResultHandler extends ResultHandler {
    private static final int[] buttons = new int[]{C0306R.string.button_web_search, C0306R.string.button_share_by_email, C0306R.string.button_share_by_sms, C0306R.string.button_custom_product_search};

    public TextResultHandler(Activity activity, ParsedResult parsedResult, Result result) {
        super(activity, parsedResult, result);
    }

    public int getButtonCount() {
        return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public void handleButtonPress(int i) {
        String displayResult = getResult().getDisplayResult();
        switch (i) {
            case 0:
                webSearch(displayResult);
                return;
            case 1:
                shareByEmail(displayResult);
                return;
            case 2:
                shareBySMS(displayResult);
                return;
            case 3:
                openURL(fillInCustomSearchURL(displayResult));
                return;
            default:
                return;
        }
    }

    public int getDisplayTitle() {
        return C0306R.string.result_text;
    }
}
