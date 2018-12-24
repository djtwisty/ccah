package com.google.zxing.client.android.result.supplement;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.android.HttpHelper;
import com.google.zxing.client.android.HttpHelper.ContentType;
import com.google.zxing.client.android.LocaleManager;
import com.google.zxing.client.android.history.HistoryManager;
import java.net.URLEncoder;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

final class ProductResultInfoRetriever extends SupplementalInfoRetriever {
    private static final Pattern[] PRODUCT_NAME_PRICE_PATTERNS = new Pattern[]{Pattern.compile(",event\\)\">([^<]+)</a></h3>.+<span class=psrp>([^<]+)</span>"), Pattern.compile("owb63p\">([^<]+).+zdi3pb\">([^<]+)")};
    private final Context context;
    private final String productID;
    private final String source;

    ProductResultInfoRetriever(TextView textView, String str, HistoryManager historyManager, Context context) {
        super(textView, historyManager);
        this.productID = str;
        this.source = context.getString(C0306R.string.msg_google_product);
        this.context = context;
    }

    void retrieveSupplementalInfo() {
        String str = "https://www.google." + LocaleManager.getProductSearchCountryTLD(this.context) + "/m/products?ie=utf8&oe=utf8&scoring=p&source=zxing&q=" + URLEncoder.encode(this.productID, HTTP.UTF_8);
        CharSequence downloadViaHttp = HttpHelper.downloadViaHttp(str, ContentType.HTML);
        for (Pattern matcher : PRODUCT_NAME_PRICE_PATTERNS) {
            if (matcher.matcher(downloadViaHttp).find()) {
                append(this.productID, this.source, new String[]{unescapeHTML(matcher.matcher(downloadViaHttp).group(1)), unescapeHTML(matcher.matcher(downloadViaHttp).group(2))}, str);
                return;
            }
        }
    }

    private static String unescapeHTML(String str) {
        return Html.fromHtml(str).toString();
    }
}
