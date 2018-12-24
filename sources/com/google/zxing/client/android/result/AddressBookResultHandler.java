package com.google.zxing.client.android.result;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class AddressBookResultHandler extends ResultHandler {
    private static final int[] BUTTON_TEXTS = new int[]{C0306R.string.button_add_contact, C0306R.string.button_show_map, C0306R.string.button_dial, C0306R.string.button_email};
    private static final DateFormat[] DATE_FORMATS = new DateFormat[]{new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH), new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)};
    private int buttonCount;
    private final boolean[] fields = new boolean[4];

    static {
        for (DateFormat lenient : DATE_FORMATS) {
            lenient.setLenient(false);
        }
    }

    private int mapIndexToAction(int i) {
        if (i < this.buttonCount) {
            int i2 = -1;
            for (int i3 = 0; i3 < 4; i3++) {
                if (this.fields[i3]) {
                    i2++;
                }
                if (i2 == i) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public AddressBookResultHandler(Activity activity, ParsedResult parsedResult) {
        boolean z = true;
        int i = 0;
        super(activity, parsedResult);
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) parsedResult;
        String[] addresses = addressBookParsedResult.getAddresses();
        String[] phoneNumbers = addressBookParsedResult.getPhoneNumbers();
        String[] emails = addressBookParsedResult.getEmails();
        this.fields[0] = true;
        boolean[] zArr = this.fields;
        boolean z2 = (addresses == null || addresses.length <= 0 || addresses[0] == null || addresses[0].isEmpty()) ? false : true;
        zArr[1] = z2;
        zArr = this.fields;
        if (phoneNumbers == null || phoneNumbers.length <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[2] = z2;
        boolean[] zArr2 = this.fields;
        if (emails == null || emails.length <= 0) {
            z = false;
        }
        zArr2[3] = z;
        this.buttonCount = 0;
        while (i < 4) {
            if (this.fields[i]) {
                this.buttonCount++;
            }
            i++;
        }
    }

    public int getButtonCount() {
        return this.buttonCount;
    }

    public int getButtonText(int i) {
        return BUTTON_TEXTS[mapIndexToAction(i)];
    }

    public void handleButtonPress(int i) {
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) getResult();
        String[] addresses = addressBookParsedResult.getAddresses();
        String str = (addresses == null || addresses.length < 1) ? null : addresses[0];
        addresses = addressBookParsedResult.getAddressTypes();
        String str2 = (addresses == null || addresses.length < 1) ? null : addresses[0];
        switch (mapIndexToAction(i)) {
            case 0:
                addContact(addressBookParsedResult.getNames(), addressBookParsedResult.getNicknames(), addressBookParsedResult.getPronunciation(), addressBookParsedResult.getPhoneNumbers(), addressBookParsedResult.getPhoneTypes(), addressBookParsedResult.getEmails(), addressBookParsedResult.getEmailTypes(), addressBookParsedResult.getNote(), addressBookParsedResult.getInstantMessenger(), str, str2, addressBookParsedResult.getOrg(), addressBookParsedResult.getTitle(), addressBookParsedResult.getURLs(), addressBookParsedResult.getBirthday(), addressBookParsedResult.getGeo());
                return;
            case 1:
                searchMap(str);
                return;
            case 2:
                dialPhone(addressBookParsedResult.getPhoneNumbers()[0]);
                return;
            case 3:
                sendEmail(addressBookParsedResult.getEmails(), null, null, null, null);
                return;
            default:
                return;
        }
    }

    private static Date parseDate(String str) {
        DateFormat[] dateFormatArr = DATE_FORMATS;
        int i = 0;
        while (i < dateFormatArr.length) {
            try {
                return dateFormatArr[i].parse(str);
            } catch (ParseException e) {
                i++;
            }
        }
        return null;
    }

    public CharSequence getDisplayContents() {
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) getResult();
        StringBuilder stringBuilder = new StringBuilder(100);
        ParsedResult.maybeAppend(addressBookParsedResult.getNames(), stringBuilder);
        int length = stringBuilder.length();
        String pronunciation = addressBookParsedResult.getPronunciation();
        if (!(pronunciation == null || pronunciation.isEmpty())) {
            stringBuilder.append("\n(");
            stringBuilder.append(pronunciation);
            stringBuilder.append(')');
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getTitle(), stringBuilder);
        ParsedResult.maybeAppend(addressBookParsedResult.getOrg(), stringBuilder);
        ParsedResult.maybeAppend(addressBookParsedResult.getAddresses(), stringBuilder);
        String[] phoneNumbers = addressBookParsedResult.getPhoneNumbers();
        if (phoneNumbers != null) {
            for (String str : phoneNumbers) {
                if (str != null) {
                    ParsedResult.maybeAppend(PhoneNumberUtils.formatNumber(str), stringBuilder);
                }
            }
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getEmails(), stringBuilder);
        ParsedResult.maybeAppend(addressBookParsedResult.getURLs(), stringBuilder);
        pronunciation = addressBookParsedResult.getBirthday();
        if (!(pronunciation == null || pronunciation.isEmpty())) {
            Date parseDate = parseDate(pronunciation);
            if (parseDate != null) {
                ParsedResult.maybeAppend(DateFormat.getDateInstance(2).format(Long.valueOf(parseDate.getTime())), stringBuilder);
            }
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getNote(), stringBuilder);
        if (length <= 0) {
            return stringBuilder.toString();
        }
        CharSequence spannableString = new SpannableString(stringBuilder.toString());
        spannableString.setSpan(new StyleSpan(1), 0, length, 0);
        return spannableString;
    }

    public int getDisplayTitle() {
        return C0306R.string.result_address_book;
    }
}
