package com.google.zxing.client.android.result;

import android.app.Activity;
import android.telephony.PhoneNumberUtils;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.TelParsedResult;

public final class TelResultHandler extends ResultHandler {
    private static final int[] buttons = new int[]{C0306R.string.button_dial, C0306R.string.button_add_contact};

    public TelResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public void handleButtonPress(int i) {
        TelParsedResult telParsedResult = (TelParsedResult) getResult();
        switch (i) {
            case 0:
                dialPhoneFromUri(telParsedResult.getTelURI());
                getActivity().finish();
                return;
            case 1:
                addPhoneOnlyContact(new String[]{telParsedResult.getNumber()}, null);
                return;
            default:
                return;
        }
    }

    public CharSequence getDisplayContents() {
        return PhoneNumberUtils.formatNumber(getResult().getDisplayResult().replace("\r", ""));
    }

    public int getDisplayTitle() {
        return C0306R.string.result_tel;
    }
}
