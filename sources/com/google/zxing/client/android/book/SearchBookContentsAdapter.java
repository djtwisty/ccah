package com.google.zxing.client.android.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import java.util.List;

final class SearchBookContentsAdapter extends ArrayAdapter<SearchBookContentsResult> {
    SearchBookContentsAdapter(Context context, List<SearchBookContentsResult> list) {
        super(context, C0306R.layout.search_book_contents_list_item, 0, list);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (SearchBookContentsListItem) LayoutInflater.from(getContext()).inflate(C0306R.layout.search_book_contents_list_item, viewGroup, false);
        } else {
            if (view instanceof SearchBookContentsListItem) {
                SearchBookContentsListItem searchBookContentsListItem = (SearchBookContentsListItem) view;
            }
            return view;
        }
        view.set((SearchBookContentsResult) getItem(i));
        return view;
    }
}
