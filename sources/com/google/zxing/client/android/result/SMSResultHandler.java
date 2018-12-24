package com.google.zxing.client.android.result;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.SMSParsedResult;

public final class SMSResultHandler extends ResultHandler {
    private static final int[] buttons = new int[]{C0306R.string.button_sms, C0306R.string.button_mms};

    public SMSResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public void handleButtonPress(int i) {
        SMSParsedResult sMSParsedResult = (SMSParsedResult) getResult();
        String str = sMSParsedResult.getNumbers()[0];
        switch (i) {
            case 0:
                sendSMS(str, sMSParsedResult.getBody());
                return;
            case 1:
                sendMMS(str, sMSParsedResult.getSubject(), sMSParsedResult.getBody());
                return;
            default:
                return;
        }
    }

    public CharSequence getDisplayContents() {
        SMSParsedResult sMSParsedResult = (SMSParsedResult) getResult();
        String[] numbers = sMSParsedResult.getNumbers();
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = PhoneNumberUtils.formatNumber(numbers[i]);
        }
        StringBuilder stringBuilder = new StringBuilder(50);
        ParsedResult.maybeAppend(strArr, stringBuilder);
        ParsedResult.maybeAppend(sMSParsedResult.getSubject(), stringBuilder);
        ParsedResult.maybeAppend(sMSParsedResult.getBody(), stringBuilder);
        return stringBuilder.toString();
    }

    public int getDisplayTitle() {
        return C0306R.string.result_sms;
    }
}
