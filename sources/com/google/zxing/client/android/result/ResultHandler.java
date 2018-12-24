package com.google.zxing.client.android.result;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.android.gms.actions.SearchIntents;
import com.google.zxing.Result;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.Intents.SearchBookContents;
import com.google.zxing.client.android.LocaleManager;
import com.google.zxing.client.android.PreferencesActivity;
import com.google.zxing.client.android.book.SearchBookContentsActivity;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.ResultParser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.cordova.networkinformation.NetworkManager;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

public abstract class ResultHandler {
    private static final String[] ADDRESS_TYPE_STRINGS = new String[]{"home", "work"};
    private static final int[] ADDRESS_TYPE_VALUES = new int[]{1, 2};
    private static final String[] EMAIL_TYPE_STRINGS = new String[]{"home", "work", NetworkManager.MOBILE};
    private static final int[] EMAIL_TYPE_VALUES = new int[]{1, 2, 4};
    public static final int MAX_BUTTON_COUNT = 4;
    private static final int NO_TYPE = -1;
    private static final String[] PHONE_TYPE_STRINGS = new String[]{"home", "work", NetworkManager.MOBILE, "fax", "pager", "main"};
    private static final int[] PHONE_TYPE_VALUES = new int[]{1, 3, 2, 4, 6, 12};
    private static final String TAG = ResultHandler.class.getSimpleName();
    private final Activity activity;
    private final String customProductSearch;
    private final Result rawResult;
    private final ParsedResult result;

    public abstract int getButtonCount();

    public abstract int getButtonText(int i);

    public abstract int getDisplayTitle();

    public abstract void handleButtonPress(int i);

    ResultHandler(Activity activity, ParsedResult parsedResult) {
        this(activity, parsedResult, null);
    }

    ResultHandler(Activity activity, ParsedResult parsedResult, Result result) {
        this.result = parsedResult;
        this.activity = activity;
        this.rawResult = result;
        this.customProductSearch = parseCustomSearchURL();
    }

    public final ParsedResult getResult() {
        return this.result;
    }

    final boolean hasCustomProductSearch() {
        return this.customProductSearch != null;
    }

    final Activity getActivity() {
        return this.activity;
    }

    public Integer getDefaultButtonID() {
        return null;
    }

    public boolean areContentsSecure() {
        return false;
    }

    public CharSequence getDisplayContents() {
        return this.result.getDisplayResult().replace("\r", "");
    }

    public final ParsedResultType getType() {
        return this.result.getType();
    }

    final void addPhoneOnlyContact(String[] strArr, String[] strArr2) {
        addContact(null, null, null, strArr, strArr2, null, null, null, null, null, null, null, null, null, null, null);
    }

    final void addEmailOnlyContact(String[] strArr, String[] strArr2) {
        addContact(null, null, null, null, null, strArr, strArr2, null, null, null, null, null, null, null, null, null);
    }

    final void addContact(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String str4, String str5, String str6, String str7, String[] strArr7, String str8, String[] strArr8) {
        int toPhoneContractType;
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/contact");
        putExtra(intent, "name", strArr != null ? strArr[0] : null);
        putExtra(intent, "phonetic_name", str);
        int min = Math.min(strArr3 != null ? strArr3.length : 0, Contents.PHONE_KEYS.length);
        int i = 0;
        while (i < min) {
            putExtra(intent, Contents.PHONE_KEYS[i], strArr3[i]);
            if (strArr4 != null && i < strArr4.length) {
                toPhoneContractType = toPhoneContractType(strArr4[i]);
                if (toPhoneContractType >= 0) {
                    intent.putExtra(Contents.PHONE_TYPE_KEYS[i], toPhoneContractType);
                }
            }
            i++;
        }
        min = Math.min(strArr5 != null ? strArr5.length : 0, Contents.EMAIL_KEYS.length);
        i = 0;
        while (i < min) {
            putExtra(intent, Contents.EMAIL_KEYS[i], strArr5[i]);
            if (strArr6 != null && i < strArr6.length) {
                toPhoneContractType = toEmailContractType(strArr6[i]);
                if (toPhoneContractType >= 0) {
                    intent.putExtra(Contents.EMAIL_TYPE_KEYS[i], toPhoneContractType);
                }
            }
            i++;
        }
        ArrayList arrayList = new ArrayList();
        if (strArr7 != null) {
            for (String str9 : strArr7) {
                if (str9 != null && !str9.isEmpty()) {
                    ContentValues contentValues = new ContentValues(2);
                    contentValues.put("mimetype", "vnd.android.cursor.item/website");
                    contentValues.put("data1", str9);
                    arrayList.add(contentValues);
                    break;
                }
            }
        }
        if (str8 != null) {
            contentValues = new ContentValues(3);
            contentValues.put("mimetype", "vnd.android.cursor.item/contact_event");
            contentValues.put("data2", Integer.valueOf(3));
            contentValues.put("data1", str8);
            arrayList.add(contentValues);
        }
        if (strArr2 != null) {
            for (String str92 : strArr2) {
                if (str92 != null && !str92.isEmpty()) {
                    contentValues = new ContentValues(3);
                    contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
                    contentValues.put("data2", Integer.valueOf(1));
                    contentValues.put("data1", str92);
                    arrayList.add(contentValues);
                    break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            intent.putParcelableArrayListExtra("data", arrayList);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (str2 != null) {
            stringBuilder.append('\n').append(str2);
        }
        if (strArr8 != null) {
            stringBuilder.append('\n').append(strArr8[0]).append(',').append(strArr8[1]);
        }
        if (stringBuilder.length() > 0) {
            putExtra(intent, "notes", stringBuilder.substring(1));
        }
        putExtra(intent, "im_handle", str3);
        putExtra(intent, "postal", str4);
        if (str5 != null) {
            i = toAddressContractType(str5);
            if (i >= 0) {
                intent.putExtra("postal_type", i);
            }
        }
        putExtra(intent, "company", str6);
        putExtra(intent, "job_title", str7);
        launchIntent(intent);
    }

    private static int toEmailContractType(String str) {
        return doToContractType(str, EMAIL_TYPE_STRINGS, EMAIL_TYPE_VALUES);
    }

    private static int toPhoneContractType(String str) {
        return doToContractType(str, PHONE_TYPE_STRINGS, PHONE_TYPE_VALUES);
    }

    private static int toAddressContractType(String str) {
        return doToContractType(str, ADDRESS_TYPE_STRINGS, ADDRESS_TYPE_VALUES);
    }

    private static int doToContractType(String str, String[] strArr, int[] iArr) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (str.startsWith(str2) || str.startsWith(str2.toUpperCase(Locale.ENGLISH))) {
                return iArr[i];
            }
        }
        return -1;
    }

    final void shareByEmail(String str) {
        sendEmail(null, null, null, null, str);
    }

    final void sendEmail(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND", Uri.parse("mailto:"));
        if (!(strArr == null || strArr.length == 0)) {
            intent.putExtra("android.intent.extra.EMAIL", strArr);
        }
        if (!(strArr2 == null || strArr2.length == 0)) {
            intent.putExtra("android.intent.extra.CC", strArr2);
        }
        if (!(strArr3 == null || strArr3.length == 0)) {
            intent.putExtra("android.intent.extra.BCC", strArr3);
        }
        putExtra(intent, "android.intent.extra.SUBJECT", str);
        putExtra(intent, "android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        launchIntent(intent);
    }

    final void shareBySMS(String str) {
        sendSMSFromUri("smsto:", str);
    }

    final void sendSMS(String str, String str2) {
        sendSMSFromUri("smsto:" + str, str2);
    }

    private void sendSMSFromUri(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
        putExtra(intent, "sms_body", str2);
        intent.putExtra("compose_mode", true);
        launchIntent(intent);
    }

    final void sendMMS(String str, String str2, String str3) {
        sendMMSFromUri("mmsto:" + str, str2, str3);
    }

    private void sendMMSFromUri(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
        if (str2 == null || str2.isEmpty()) {
            putExtra(intent, "subject", this.activity.getString(C0306R.string.msg_default_mms_subject));
        } else {
            putExtra(intent, "subject", str2);
        }
        putExtra(intent, "sms_body", str3);
        intent.putExtra("compose_mode", true);
        launchIntent(intent);
    }

    final void dialPhone(String str) {
        launchIntent(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    final void dialPhoneFromUri(String str) {
        launchIntent(new Intent("android.intent.action.DIAL", Uri.parse(str)));
    }

    final void openMap(String str) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    final void searchMap(String str) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + Uri.encode(str))));
    }

    final void getDirections(double d, double d2) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google." + LocaleManager.getCountryTLD(this.activity) + "/maps?f=d&daddr=" + d + ',' + d2)));
    }

    final void openProductSearch(String str) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse("http://www.google." + LocaleManager.getProductSearchCountryTLD(this.activity) + "/m/products?q=" + str + "&source=zxing")));
    }

    final void openBookSearch(String str) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse("http://books.google." + LocaleManager.getBookSearchCountryTLD(this.activity) + "/books?vid=isbn" + str)));
    }

    final void searchBookContents(String str) {
        Intent intent = new Intent(SearchBookContents.ACTION);
        intent.setClassName(this.activity, SearchBookContentsActivity.class.getName());
        putExtra(intent, SearchBookContents.ISBN, str);
        launchIntent(intent);
    }

    final void openURL(String str) {
        if (str.startsWith("HTTP://")) {
            str = HttpHost.DEFAULT_SCHEME_NAME + str.substring(4);
        } else if (str.startsWith("HTTPS://")) {
            str = "https" + str.substring(5);
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        try {
            launchIntent(intent);
        } catch (ActivityNotFoundException e) {
            Log.w(TAG, "Nothing available to handle " + intent);
        }
    }

    final void webSearch(String str) {
        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
        intent.putExtra(SearchIntents.EXTRA_QUERY, str);
        launchIntent(intent);
    }

    final void rawLaunchIntent(Intent intent) {
        if (intent != null) {
            intent.addFlags(524288);
            Log.d(TAG, "Launching intent: " + intent + " with extras: " + intent.getExtras());
            this.activity.startActivity(intent);
        }
    }

    final void launchIntent(Intent intent) {
        try {
            rawLaunchIntent(intent);
        } catch (ActivityNotFoundException e) {
            Builder builder = new Builder(this.activity);
            builder.setTitle(C0306R.string.app_name);
            builder.setMessage(C0306R.string.msg_intent_failed);
            builder.setPositiveButton(C0306R.string.button_ok, null);
            builder.show();
        }
    }

    private static void putExtra(Intent intent, String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra(str, str2);
        }
    }

    private String parseCustomSearchURL() {
        String string = PreferenceManager.getDefaultSharedPreferences(this.activity).getString(PreferencesActivity.KEY_CUSTOM_PRODUCT_SEARCH, null);
        if (string == null || !string.trim().isEmpty()) {
            return string;
        }
        return null;
    }

    final String fillInCustomSearchURL(String str) {
        if (this.customProductSearch == null) {
            return str;
        }
        try {
            str = URLEncoder.encode(str, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
        }
        String str2 = this.customProductSearch;
        if (this.rawResult != null) {
            str2 = str2.replaceFirst("%f(?![0-9a-f])", this.rawResult.getBarcodeFormat().toString());
            if (str2.contains("%t")) {
                str2 = str2.replace("%t", ResultParser.parseResult(this.rawResult).getType().toString());
            }
        }
        return str2.replace("%s", str);
    }
}
