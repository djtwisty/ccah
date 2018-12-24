package com.google.zxing.client.android.history;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.Result;
import java.util.ArrayList;

final class HistoryItemAdapter extends ArrayAdapter<HistoryItem> {
    private final Context activity;

    HistoryItemAdapter(Context context) {
        super(context, C0306R.layout.history_list_item, new ArrayList());
        this.activity = context;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        CharSequence text;
        CharSequence displayAndDetails;
        if (!(view instanceof LinearLayout)) {
            view = LayoutInflater.from(this.activity).inflate(C0306R.layout.history_list_item, viewGroup, false);
        }
        HistoryItem historyItem = (HistoryItem) getItem(i);
        Result result = historyItem.getResult();
        if (result != null) {
            text = result.getText();
            displayAndDetails = historyItem.getDisplayAndDetails();
        } else {
            Resources resources = getContext().getResources();
            text = resources.getString(C0306R.string.history_empty);
            Object string = resources.getString(C0306R.string.history_empty_detail);
        }
        ((TextView) view.findViewById(C0306R.id.history_title)).setText(text);
        ((TextView) view.findViewById(C0306R.id.history_detail)).setText(displayAndDetails);
        return view;
    }
}
