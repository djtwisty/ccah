package org.apache.cordova;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class CordovaDialogsHelper {
    private final Context context;
    private AlertDialog lastHandledDialog;

    public interface Result {
        void gotResult(boolean z, String str);
    }

    public CordovaDialogsHelper(Context context) {
        this.context = context;
    }

    public void showAlert(String str, final Result result) {
        Builder builder = new Builder(this.context);
        builder.setMessage(str);
        builder.setTitle("Alert");
        builder.setCancelable(true);
        builder.setPositiveButton(17039370, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                result.gotResult(true, null);
            }
        });
        builder.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                result.gotResult(false, null);
            }
        });
        builder.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return true;
                }
                result.gotResult(true, null);
                return false;
            }
        });
        this.lastHandledDialog = builder.show();
    }

    public void showConfirm(String str, final Result result) {
        Builder builder = new Builder(this.context);
        builder.setMessage(str);
        builder.setTitle("Confirm");
        builder.setCancelable(true);
        builder.setPositiveButton(17039370, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                result.gotResult(true, null);
            }
        });
        builder.setNegativeButton(17039360, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                result.gotResult(false, null);
            }
        });
        builder.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                result.gotResult(false, null);
            }
        });
        builder.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return true;
                }
                result.gotResult(false, null);
                return false;
            }
        });
        this.lastHandledDialog = builder.show();
    }

    public void showPrompt(String str, String str2, final Result result) {
        Builder builder = new Builder(this.context);
        builder.setMessage(str);
        final View editText = new EditText(this.context);
        if (str2 != null) {
            editText.setText(str2);
        }
        builder.setView(editText);
        builder.setCancelable(false);
        builder.setPositiveButton(17039370, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                result.gotResult(true, editText.getText().toString());
            }
        });
        builder.setNegativeButton(17039360, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                result.gotResult(false, null);
            }
        });
        this.lastHandledDialog = builder.show();
    }

    public void destroyLastDialog() {
        if (this.lastHandledDialog != null) {
            this.lastHandledDialog.cancel();
        }
    }
}
