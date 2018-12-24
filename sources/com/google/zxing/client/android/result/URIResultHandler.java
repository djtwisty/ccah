package com.google.zxing.client.android.result;

import android.app.Activity;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.android.LocaleManager;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.URIParsedResult;
import java.util.Locale;

public final class URIResultHandler extends ResultHandler {
    private static final String[] SECURE_PROTOCOLS = new String[]{"otpauth:"};
    private static final int[] buttons = new int[]{C0306R.string.button_open_browser, C0306R.string.button_share_by_email, C0306R.string.button_share_by_sms, C0306R.string.button_search_book_contents};

    public URIResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
    }

    public int getButtonCount() {
        if (LocaleManager.isBookSearchUrl(((URIParsedResult) getResult()).getURI())) {
            return buttons.length;
        }
        return buttons.length - 1;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public Integer getDefaultButtonID() {
        return Integer.valueOf(0);
    }

    public void handleButtonPress(int i) {
        String uri = ((URIParsedResult) getResult()).getURI();
        switch (i) {
            case 0:
                openURL(uri);
                return;
            case 1:
                shareByEmail(uri);
                return;
            case 2:
                shareBySMS(uri);
                return;
            case 3:
                searchBookContents(uri);
                return;
            default:
                return;
        }
    }

    public int getDisplayTitle() {
        return C0306R.string.result_uri;
    }

    public boolean areContentsSecure() {
        String toLowerCase = ((URIParsedResult) getResult()).getURI().toLowerCase(Locale.ENGLISH);
        for (String startsWith : SECURE_PROTOCOLS) {
            if (toLowerCase.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }
}
