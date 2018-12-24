package com.google.zxing.client.android.result.supplement;

import android.text.Html;
import android.widget.TextView;
import com.google.zxing.client.android.HttpHelper;
import com.google.zxing.client.android.HttpHelper.ContentType;
import com.google.zxing.client.android.history.HistoryManager;
import com.google.zxing.client.result.URIParsedResult;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class TitleRetriever extends SupplementalInfoRetriever {
    private static final int MAX_TITLE_LEN = 100;
    private static final Pattern TITLE_PATTERN = Pattern.compile("<title>([^<]+)");
    private final String httpUrl;

    TitleRetriever(TextView textView, URIParsedResult uRIParsedResult, HistoryManager historyManager) {
        super(textView, historyManager);
        this.httpUrl = uRIParsedResult.getURI();
    }

    void retrieveSupplementalInfo() {
        try {
            CharSequence downloadViaHttp = HttpHelper.downloadViaHttp(this.httpUrl, ContentType.HTML, 4096);
            if (downloadViaHttp != null && downloadViaHttp.length() > 0) {
                Matcher matcher = TITLE_PATTERN.matcher(downloadViaHttp);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (group != null && !group.isEmpty()) {
                        group = Html.fromHtml(group).toString();
                        if (group.length() > 100) {
                            group = group.substring(0, 100) + "...";
                        }
                        append(this.httpUrl, null, new String[]{group}, this.httpUrl);
                    }
                }
            }
        } catch (IOException e) {
        }
    }
}
