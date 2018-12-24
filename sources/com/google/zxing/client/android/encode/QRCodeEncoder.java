package com.google.zxing.client.android.encode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.Contents.Type;
import com.google.zxing.client.android.Intents.Encode;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.common.BitMatrix;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;

final class QRCodeEncoder {
    private static final int BLACK = -16777216;
    private static final String TAG = QRCodeEncoder.class.getSimpleName();
    private static final int WHITE = -1;
    private final Context activity;
    private String contents;
    private final int dimension;
    private String displayContents;
    private BarcodeFormat format;
    private String title;
    private final boolean useVCard;

    QRCodeEncoder(Context context, Intent intent, int i, boolean z) {
        this.activity = context;
        this.dimension = i;
        this.useVCard = z;
        String action = intent.getAction();
        if (Encode.ACTION.equals(action)) {
            encodeContentsFromZXingIntent(intent);
        } else if ("android.intent.action.SEND".equals(action)) {
            encodeContentsFromShareIntent(intent);
        }
    }

    String getContents() {
        return this.contents;
    }

    String getDisplayContents() {
        return this.displayContents;
    }

    String getTitle() {
        return this.title;
    }

    boolean isUseVCard() {
        return this.useVCard;
    }

    private void encodeContentsFromZXingIntent(Intent intent) {
        String stringExtra = intent.getStringExtra(Encode.FORMAT);
        this.format = null;
        if (stringExtra != null) {
            try {
                this.format = BarcodeFormat.valueOf(stringExtra);
            } catch (IllegalArgumentException e) {
            }
        }
        if (this.format == null || this.format == BarcodeFormat.QR_CODE) {
            stringExtra = intent.getStringExtra(Encode.TYPE);
            if (stringExtra != null && !stringExtra.isEmpty()) {
                this.format = BarcodeFormat.QR_CODE;
                encodeQRCodeContents(intent, stringExtra);
                return;
            }
            return;
        }
        stringExtra = intent.getStringExtra(Encode.DATA);
        if (stringExtra != null && !stringExtra.isEmpty()) {
            this.contents = stringExtra;
            this.displayContents = stringExtra;
            this.title = this.activity.getString(C0306R.string.contents_text);
        }
    }

    private void encodeContentsFromShareIntent(Intent intent) {
        if (intent.hasExtra("android.intent.extra.STREAM")) {
            encodeFromStreamExtra(intent);
        } else {
            encodeFromTextExtras(intent);
        }
    }

    private void encodeFromTextExtras(Intent intent) {
        String trim = ContactEncoder.trim(intent.getStringExtra("android.intent.extra.TEXT"));
        if (trim == null) {
            trim = ContactEncoder.trim(intent.getStringExtra("android.intent.extra.HTML_TEXT"));
            if (trim == null) {
                trim = ContactEncoder.trim(intent.getStringExtra("android.intent.extra.SUBJECT"));
                if (trim == null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("android.intent.extra.EMAIL");
                    if (stringArrayExtra != null) {
                        trim = ContactEncoder.trim(stringArrayExtra[0]);
                    } else {
                        trim = "?";
                    }
                }
            }
        }
        if (trim == null || trim.isEmpty()) {
            throw new WriterException("Empty EXTRA_TEXT");
        }
        this.contents = trim;
        this.format = BarcodeFormat.QR_CODE;
        if (intent.hasExtra("android.intent.extra.SUBJECT")) {
            this.displayContents = intent.getStringExtra("android.intent.extra.SUBJECT");
        } else if (intent.hasExtra("android.intent.extra.TITLE")) {
            this.displayContents = intent.getStringExtra("android.intent.extra.TITLE");
        } else {
            this.displayContents = this.contents;
        }
        this.title = this.activity.getString(C0306R.string.contents_text);
    }

    private void encodeFromStreamExtra(Intent intent) {
        Throwable e;
        this.format = BarcodeFormat.QR_CODE;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            throw new WriterException("No extras");
        }
        Uri uri = (Uri) extras.getParcelable("android.intent.extra.STREAM");
        if (uri == null) {
            throw new WriterException("No EXTRA_STREAM");
        }
        InputStream openInputStream;
        try {
            openInputStream = this.activity.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                try {
                    throw new WriterException("Can't open stream for " + uri);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        throw new WriterException(e);
                    } catch (Throwable th) {
                        e = th;
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw e;
                    }
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            String str = new String(toByteArray, 0, toByteArray.length, HTTP.UTF_8);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException e4) {
                }
            }
            Log.d(TAG, "Encoding share intent content:");
            Log.d(TAG, str);
            ParsedResult parseResult = ResultParser.parseResult(new Result(str, toByteArray, null, BarcodeFormat.QR_CODE));
            if (parseResult instanceof AddressBookParsedResult) {
                encodeQRCodeContents((AddressBookParsedResult) parseResult);
                if (this.contents == null || this.contents.isEmpty()) {
                    throw new WriterException("No content to encode");
                }
                return;
            }
            throw new WriterException("Result was not an address");
        } catch (IOException e5) {
            e = e5;
            openInputStream = null;
            throw new WriterException(e);
        } catch (Throwable th2) {
            e = th2;
            openInputStream = null;
            if (openInputStream != null) {
                openInputStream.close();
            }
            throw e;
        }
    }

    private void encodeQRCodeContents(Intent intent, String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1309271157:
                if (str.equals(Type.PHONE)) {
                    i = 2;
                    break;
                }
                break;
            case -670199783:
                if (str.equals(Type.CONTACT)) {
                    i = 4;
                    break;
                }
                break;
            case 709220992:
                if (str.equals(Type.SMS)) {
                    i = 3;
                    break;
                }
                break;
            case 1349204356:
                if (str.equals(Type.LOCATION)) {
                    i = 5;
                    break;
                }
                break;
            case 1778595596:
                if (str.equals(Type.TEXT)) {
                    i = 0;
                    break;
                }
                break;
            case 1833351709:
                if (str.equals(Type.EMAIL)) {
                    i = 1;
                    break;
                }
                break;
        }
        String stringExtra;
        Bundle bundleExtra;
        switch (i) {
            case 0:
                stringExtra = intent.getStringExtra(Encode.DATA);
                if (stringExtra != null && !stringExtra.isEmpty()) {
                    this.contents = stringExtra;
                    this.displayContents = stringExtra;
                    this.title = this.activity.getString(C0306R.string.contents_text);
                    return;
                }
                return;
            case 1:
                stringExtra = ContactEncoder.trim(intent.getStringExtra(Encode.DATA));
                if (stringExtra != null) {
                    this.contents = "mailto:" + stringExtra;
                    this.displayContents = stringExtra;
                    this.title = this.activity.getString(C0306R.string.contents_email);
                    return;
                }
                return;
            case 2:
                stringExtra = ContactEncoder.trim(intent.getStringExtra(Encode.DATA));
                if (stringExtra != null) {
                    this.contents = "tel:" + stringExtra;
                    this.displayContents = PhoneNumberUtils.formatNumber(stringExtra);
                    this.title = this.activity.getString(C0306R.string.contents_phone);
                    return;
                }
                return;
            case 3:
                stringExtra = ContactEncoder.trim(intent.getStringExtra(Encode.DATA));
                if (stringExtra != null) {
                    this.contents = "sms:" + stringExtra;
                    this.displayContents = PhoneNumberUtils.formatNumber(stringExtra);
                    this.title = this.activity.getString(C0306R.string.contents_sms);
                    return;
                }
                return;
            case 4:
                bundleExtra = intent.getBundleExtra(Encode.DATA);
                if (bundleExtra != null) {
                    ContactEncoder vCardContactEncoder;
                    String string = bundleExtra.getString("name");
                    String string2 = bundleExtra.getString("company");
                    String string3 = bundleExtra.getString("postal");
                    List allBundleValues = getAllBundleValues(bundleExtra, Contents.PHONE_KEYS);
                    List allBundleValues2 = getAllBundleValues(bundleExtra, Contents.PHONE_TYPE_KEYS);
                    List allBundleValues3 = getAllBundleValues(bundleExtra, Contents.EMAIL_KEYS);
                    String string4 = bundleExtra.getString(Contents.URL_KEY);
                    List singletonList = string4 == null ? null : Collections.singletonList(string4);
                    String string5 = bundleExtra.getString(Contents.NOTE_KEY);
                    if (this.useVCard) {
                        vCardContactEncoder = new VCardContactEncoder();
                    } else {
                        vCardContactEncoder = new MECARDContactEncoder();
                    }
                    String[] encode = vCardContactEncoder.encode(Collections.singletonList(string), string2, Collections.singletonList(string3), allBundleValues, allBundleValues2, allBundleValues3, singletonList, string5);
                    if (!encode[1].isEmpty()) {
                        this.contents = encode[0];
                        this.displayContents = encode[1];
                        this.title = this.activity.getString(C0306R.string.contents_contact);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                bundleExtra = intent.getBundleExtra(Encode.DATA);
                if (bundleExtra != null) {
                    float f = bundleExtra.getFloat("LAT", Float.MAX_VALUE);
                    float f2 = bundleExtra.getFloat("LONG", Float.MAX_VALUE);
                    if (f != Float.MAX_VALUE && f2 != Float.MAX_VALUE) {
                        this.contents = "geo:" + f + ',' + f2;
                        this.displayContents = f + "," + f2;
                        this.title = this.activity.getString(C0306R.string.contents_location);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static List<String> getAllBundleValues(Bundle bundle, String[] strArr) {
        List<String> arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            Object obj = bundle.get(str);
            arrayList.add(obj == null ? null : obj.toString());
        }
        return arrayList;
    }

    private void encodeQRCodeContents(AddressBookParsedResult addressBookParsedResult) {
        String[] encode = (this.useVCard ? new VCardContactEncoder() : new MECARDContactEncoder()).encode(toList(addressBookParsedResult.getNames()), addressBookParsedResult.getOrg(), toList(addressBookParsedResult.getAddresses()), toList(addressBookParsedResult.getPhoneNumbers()), null, toList(addressBookParsedResult.getEmails()), toList(addressBookParsedResult.getURLs()), null);
        if (!encode[1].isEmpty()) {
            this.contents = encode[0];
            this.displayContents = encode[1];
            this.title = this.activity.getString(C0306R.string.contents_contact);
        }
    }

    private static List<String> toList(String[] strArr) {
        return strArr == null ? null : Arrays.asList(strArr);
    }

    Bitmap encodeAsBitmap() {
        Object obj = this.contents;
        if (obj == null) {
            return null;
        }
        Map enumMap;
        String guessAppropriateEncoding = guessAppropriateEncoding(obj);
        if (guessAppropriateEncoding != null) {
            enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.CHARACTER_SET, guessAppropriateEncoding);
        } else {
            enumMap = null;
        }
        try {
            BitMatrix encode = new MultiFormatWriter().encode(obj, this.format, this.dimension, this.dimension, enumMap);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[(width * height)];
            for (int i = 0; i < height; i++) {
                int i2 = i * width;
                for (int i3 = 0; i3 < width; i3++) {
                    iArr[i2 + i3] = encode.get(i3, i) ? BLACK : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return createBitmap;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static String guessAppropriateEncoding(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > 'ÿ') {
                return HTTP.UTF_8;
            }
        }
        return null;
    }
}
