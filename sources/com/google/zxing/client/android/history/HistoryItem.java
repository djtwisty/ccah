package com.google.zxing.client.android.history;

import com.google.zxing.Result;

public final class HistoryItem {
    private final String details;
    private final String display;
    private final Result result;

    HistoryItem(Result result, String str, String str2) {
        this.result = result;
        this.display = str;
        this.details = str2;
    }

    public Result getResult() {
        return this.result;
    }

    public String getDisplayAndDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.display == null || this.display.isEmpty()) {
            stringBuilder.append(this.result.getText());
        } else {
            stringBuilder.append(this.display);
        }
        if (!(this.details == null || this.details.isEmpty())) {
            stringBuilder.append(" : ").append(this.details);
        }
        return stringBuilder.toString();
    }
}
