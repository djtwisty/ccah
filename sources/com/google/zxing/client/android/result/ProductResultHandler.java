package com.google.zxing.client.android.result;

import android.app.Activity;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.Result;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ProductParsedResult;

public final class ProductResultHandler extends ResultHandler {
    private static final int[] buttons = new int[]{C0306R.string.button_product_search, C0306R.string.button_web_search, C0306R.string.button_custom_product_search};

    public ProductResultHandler(Activity activity, ParsedResult parsedResult, Result result) {
        super(activity, parsedResult, result);
    }

    public int getButtonCount() {
        return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public void handleButtonPress(int i) {
        String productIDFromResult = getProductIDFromResult(getResult());
        switch (i) {
            case 0:
                openProductSearch(productIDFromResult);
                return;
            case 1:
                webSearch(productIDFromResult);
                return;
            case 2:
                openURL(fillInCustomSearchURL(productIDFromResult));
                return;
            default:
                return;
        }
    }

    private static String getProductIDFromResult(ParsedResult parsedResult) {
        if (parsedResult instanceof ProductParsedResult) {
            return ((ProductParsedResult) parsedResult).getNormalizedProductID();
        }
        if (parsedResult instanceof ExpandedProductParsedResult) {
            return ((ExpandedProductParsedResult) parsedResult).getRawText();
        }
        throw new IllegalArgumentException(parsedResult.getClass().toString());
    }

    public int getDisplayTitle() {
        return C0306R.string.result_product;
    }
}
