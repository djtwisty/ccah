package com.google.zxing.client.android.result;

import android.app.Activity;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.result.EmailAddressParsedResult;
import com.google.zxing.client.result.ParsedResult;

public final class EmailAddressResultHandler extends ResultHandler {
    private static final int[] buttons = new int[]{C0306R.string.button_email, C0306R.string.button_add_contact};

    public EmailAddressResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public void handleButtonPress(int i) {
        EmailAddressParsedResult emailAddressParsedResult = (EmailAddressParsedResult) getResult();
        switch (i) {
            case 0:
                sendEmail(emailAddressParsedResult.getTos(), emailAddressParsedResult.getCCs(), emailAddressParsedResult.getBCCs(), emailAddressParsedResult.getSubject(), emailAddressParsedResult.getBody());
                return;
            case 1:
                addEmailOnlyContact(emailAddressParsedResult.getTos(), null);
                return;
            default:
                return;
        }
    }

    public int getDisplayTitle() {
        return C0306R.string.result_email_address;
    }
}
