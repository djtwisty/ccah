package com.google.zxing.client.android.history;

import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents.History;

public final class HistoryActivity extends ListActivity {
    private static final String TAG = HistoryActivity.class.getSimpleName();
    private ArrayAdapter<HistoryItem> adapter;
    private HistoryManager historyManager;
    private CharSequence originalTitle;

    /* renamed from: com.google.zxing.client.android.history.HistoryActivity$1 */
    class C04121 implements OnClickListener {
        C04121() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            HistoryActivity.this.historyManager.clearHistory();
            dialogInterface.dismiss();
            HistoryActivity.this.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.historyManager = new HistoryManager(this);
        this.adapter = new HistoryItemAdapter(this);
        setListAdapter(this.adapter);
        registerForContextMenu(getListView());
        this.originalTitle = getTitle();
    }

    protected void onResume() {
        super.onResume();
        reloadHistoryItems();
    }

    private void reloadHistoryItems() {
        Iterable<HistoryItem> buildHistoryItems = this.historyManager.buildHistoryItems();
        this.adapter.clear();
        for (HistoryItem add : buildHistoryItems) {
            this.adapter.add(add);
        }
        setTitle(this.originalTitle + " (" + this.adapter.getCount() + ')');
        if (this.adapter.isEmpty()) {
            this.adapter.add(new HistoryItem(null, null, null));
        }
    }

    protected void onListItemClick(ListView listView, View view, int i, long j) {
        if (((HistoryItem) this.adapter.getItem(i)).getResult() != null) {
            Intent intent = new Intent(this, CaptureActivity.class);
            intent.putExtra(History.ITEM_NUMBER, i);
            setResult(-1, intent);
            finish();
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = ((AdapterContextMenuInfo) contextMenuInfo).position;
        if (i >= this.adapter.getCount() || ((HistoryItem) this.adapter.getItem(i)).getResult() != null) {
            contextMenu.add(0, i, i, C0306R.string.history_clear_one_history_text);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        this.historyManager.deleteHistoryItem(menuItem.getItemId());
        reloadHistoryItems();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.historyManager.hasHistoryItems()) {
            getMenuInflater().inflate(C0306R.menu.history, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        Builder builder;
        if (itemId == C0306R.id.menu_history_send) {
            Parcelable saveHistory = HistoryManager.saveHistory(this.historyManager.buildHistory().toString());
            if (saveHistory == null) {
                builder = new Builder(this);
                builder.setMessage(C0306R.string.msg_unmount_usb);
                builder.setPositiveButton(C0306R.string.button_ok, null);
                builder.show();
                return true;
            }
            Intent intent = new Intent("android.intent.action.SEND", Uri.parse("mailto:"));
            intent.addFlags(524288);
            String string = getResources().getString(C0306R.string.history_email_title);
            intent.putExtra("android.intent.extra.SUBJECT", string);
            intent.putExtra("android.intent.extra.TEXT", string);
            intent.putExtra("android.intent.extra.STREAM", saveHistory);
            intent.setType("text/csv");
            try {
                startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.w(TAG, e.toString());
                return true;
            }
        } else if (itemId != C0306R.id.menu_history_clear_text) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            builder = new Builder(this);
            builder.setMessage(C0306R.string.msg_sure);
            builder.setCancelable(true);
            builder.setPositiveButton(C0306R.string.button_ok, new C04121());
            builder.setNegativeButton(C0306R.string.button_cancel, null);
            builder.show();
            return true;
        }
    }
}
