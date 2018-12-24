package com.google.zxing.client.android.result;

import android.app.Activity;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.result.GeoParsedResult;
import com.google.zxing.client.result.ParsedResult;

public final class GeoResultHandler extends ResultHandler {
    private static final int[] buttons = new int[]{C0306R.string.button_show_map, C0306R.string.button_get_directions};

    public GeoResultHandler(Activity activity, ParsedResult parsedResult) {
        super(activity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i) {
        return buttons[i];
    }

    public void handleButtonPress(int i) {
        GeoParsedResult geoParsedResult = (GeoParsedResult) getResult();
        switch (i) {
            case 0:
                openMap(geoParsedResult.getGeoURI());
                return;
            case 1:
                getDirections(geoParsedResult.getLatitude(), geoParsedResult.getLongitude());
                return;
            default:
                return;
        }
    }

    public int getDisplayTitle() {
        return C0306R.string.result_geo;
    }
}
