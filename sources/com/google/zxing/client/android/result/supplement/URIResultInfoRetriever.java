package com.google.zxing.client.android.result.supplement;

import android.content.Context;
import android.widget.TextView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.android.HttpHelper;
import com.google.zxing.client.android.history.HistoryManager;
import com.google.zxing.client.result.URIParsedResult;
import java.net.URI;
import java.net.URISyntaxException;

final class URIResultInfoRetriever extends SupplementalInfoRetriever {
    private static final int MAX_REDIRECTS = 5;
    private final String redirectString;
    private final URIParsedResult result;

    URIResultInfoRetriever(TextView textView, URIParsedResult uRIParsedResult, HistoryManager historyManager, Context context) {
        super(textView, historyManager);
        this.redirectString = context.getString(C0306R.string.msg_redirect);
        this.result = uRIParsedResult;
    }

    void retrieveSupplementalInfo() {
        try {
            URI uri = new URI(this.result.getURI());
            int i = 0;
            URI unredirect = HttpHelper.unredirect(uri);
            URI uri2 = uri;
            while (true) {
                int i2 = i + 1;
                if (i < 5 && !r5.equals(unredirect)) {
                    append(this.result.getDisplayResult(), null, new String[]{this.redirectString + " : " + unredirect}, unredirect.toString());
                    i = i2;
                    uri2 = unredirect;
                    unredirect = HttpHelper.unredirect(unredirect);
                } else {
                    return;
                }
            }
        } catch (URISyntaxException e) {
        }
    }
}
