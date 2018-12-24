package org.apache.cordova.dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Notification extends CordovaPlugin {
    private static final String LOG_TAG = "Notification";
    public int confirmResult = -1;
    public ProgressDialog progressDialog = null;
    public ProgressDialog spinnerDialog = null;

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        if (this.cordova.getActivity().isFinishing()) {
            return true;
        }
        if (str.equals("beep")) {
            beep(jSONArray.getLong(0));
        } else if (str.equals("alert")) {
            alert(jSONArray.getString(0), jSONArray.getString(1), jSONArray.getString(2), callbackContext);
            return true;
        } else if (str.equals("confirm")) {
            confirm(jSONArray.getString(0), jSONArray.getString(1), jSONArray.getJSONArray(2), callbackContext);
            return true;
        } else if (str.equals("prompt")) {
            prompt(jSONArray.getString(0), jSONArray.getString(1), jSONArray.getJSONArray(2), jSONArray.getString(3), callbackContext);
            return true;
        } else if (str.equals("activityStart")) {
            activityStart(jSONArray.getString(0), jSONArray.getString(1));
        } else if (str.equals("activityStop")) {
            activityStop();
        } else if (str.equals("progressStart")) {
            progressStart(jSONArray.getString(0), jSONArray.getString(1));
        } else if (str.equals("progressValue")) {
            progressValue(jSONArray.getInt(0));
        } else if (!str.equals("progressStop")) {
            return false;
        } else {
            progressStop();
        }
        callbackContext.success();
        return true;
    }

    public void beep(final long j) {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                Ringtone ringtone = RingtoneManager.getRingtone(Notification.this.cordova.getActivity().getBaseContext(), RingtoneManager.getDefaultUri(2));
                if (ringtone != null) {
                    for (long j = 0; j < j; j++) {
                        ringtone.play();
                        long j2 = 5000;
                        while (ringtone.isPlaying() && j2 > 0) {
                            j2 -= 100;
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
        });
    }

    public synchronized void alert(String str, String str2, String str3, CallbackContext callbackContext) {
        final CordovaInterface cordovaInterface = this.cordova;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final CallbackContext callbackContext2 = callbackContext;
        this.cordova.getActivity().runOnUiThread(new Runnable() {

            /* renamed from: org.apache.cordova.dialogs.Notification$2$1 */
            class C05291 implements OnClickListener {
                C05291() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    callbackContext2.sendPluginResult(new PluginResult(Status.OK, 0));
                }
            }

            /* renamed from: org.apache.cordova.dialogs.Notification$2$2 */
            class C05302 implements OnCancelListener {
                C05302() {
                }

                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    callbackContext2.sendPluginResult(new PluginResult(Status.OK, 0));
                }
            }

            public void run() {
                Builder access$000 = Notification.this.createDialog(cordovaInterface);
                access$000.setMessage(str4);
                access$000.setTitle(str5);
                access$000.setCancelable(true);
                access$000.setPositiveButton(str6, new C05291());
                access$000.setOnCancelListener(new C05302());
                Notification.this.changeTextDirection(access$000);
            }
        });
    }

    public synchronized void confirm(String str, String str2, JSONArray jSONArray, CallbackContext callbackContext) {
        final CordovaInterface cordovaInterface = this.cordova;
        final String str3 = str;
        final String str4 = str2;
        final JSONArray jSONArray2 = jSONArray;
        final CallbackContext callbackContext2 = callbackContext;
        this.cordova.getActivity().runOnUiThread(new Runnable() {

            /* renamed from: org.apache.cordova.dialogs.Notification$3$1 */
            class C05321 implements OnClickListener {
                C05321() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    callbackContext2.sendPluginResult(new PluginResult(Status.OK, 1));
                }
            }

            /* renamed from: org.apache.cordova.dialogs.Notification$3$2 */
            class C05332 implements OnClickListener {
                C05332() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    callbackContext2.sendPluginResult(new PluginResult(Status.OK, 2));
                }
            }

            /* renamed from: org.apache.cordova.dialogs.Notification$3$3 */
            class C05343 implements OnClickListener {
                C05343() {
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    callbackContext2.sendPluginResult(new PluginResult(Status.OK, 3));
                }
            }

            /* renamed from: org.apache.cordova.dialogs.Notification$3$4 */
            class C05354 implements OnCancelListener {
                C05354() {
                }

                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    callbackContext2.sendPluginResult(new PluginResult(Status.OK, 0));
                }
            }

            public void run() {
                Builder access$000 = Notification.this.createDialog(cordovaInterface);
                access$000.setMessage(str3);
                access$000.setTitle(str4);
                access$000.setCancelable(true);
                if (jSONArray2.length() > 0) {
                    try {
                        access$000.setNegativeButton(jSONArray2.getString(0), new C05321());
                    } catch (JSONException e) {
                        LOG.m1345d(Notification.LOG_TAG, "JSONException on first button.");
                    }
                }
                if (jSONArray2.length() > 1) {
                    try {
                        access$000.setNeutralButton(jSONArray2.getString(1), new C05332());
                    } catch (JSONException e2) {
                        LOG.m1345d(Notification.LOG_TAG, "JSONException on second button.");
                    }
                }
                if (jSONArray2.length() > 2) {
                    try {
                        access$000.setPositiveButton(jSONArray2.getString(2), new C05343());
                    } catch (JSONException e3) {
                        LOG.m1345d(Notification.LOG_TAG, "JSONException on third button.");
                    }
                }
                access$000.setOnCancelListener(new C05354());
                Notification.this.changeTextDirection(access$000);
            }
        });
    }

    public synchronized void prompt(String str, String str2, JSONArray jSONArray, String str3, CallbackContext callbackContext) {
        final CordovaInterface cordovaInterface = this.cordova;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        final JSONArray jSONArray2 = jSONArray;
        final CallbackContext callbackContext2 = callbackContext;
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                final View editText = new EditText(cordovaInterface.getActivity());
                editText.setHint(str4);
                Builder access$000 = Notification.this.createDialog(cordovaInterface);
                access$000.setMessage(str5);
                access$000.setTitle(str6);
                access$000.setCancelable(true);
                access$000.setView(editText);
                final JSONObject jSONObject = new JSONObject();
                if (jSONArray2.length() > 0) {
                    try {
                        access$000.setNegativeButton(jSONArray2.getString(0), new OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                try {
                                    jSONObject.put("buttonIndex", 1);
                                    jSONObject.put("input1", editText.getText().toString().trim().length() == 0 ? str4 : editText.getText());
                                } catch (Throwable e) {
                                    LOG.m1346d(Notification.LOG_TAG, "JSONException on first button.", e);
                                }
                                callbackContext2.sendPluginResult(new PluginResult(Status.OK, jSONObject));
                            }
                        });
                    } catch (JSONException e) {
                        LOG.m1345d(Notification.LOG_TAG, "JSONException on first button.");
                    }
                }
                if (jSONArray2.length() > 1) {
                    try {
                        access$000.setNeutralButton(jSONArray2.getString(1), new OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                try {
                                    jSONObject.put("buttonIndex", 2);
                                    jSONObject.put("input1", editText.getText().toString().trim().length() == 0 ? str4 : editText.getText());
                                } catch (Throwable e) {
                                    LOG.m1346d(Notification.LOG_TAG, "JSONException on second button.", e);
                                }
                                callbackContext2.sendPluginResult(new PluginResult(Status.OK, jSONObject));
                            }
                        });
                    } catch (JSONException e2) {
                        LOG.m1345d(Notification.LOG_TAG, "JSONException on second button.");
                    }
                }
                if (jSONArray2.length() > 2) {
                    try {
                        access$000.setPositiveButton(jSONArray2.getString(2), new OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                try {
                                    jSONObject.put("buttonIndex", 3);
                                    jSONObject.put("input1", editText.getText().toString().trim().length() == 0 ? str4 : editText.getText());
                                } catch (Throwable e) {
                                    LOG.m1346d(Notification.LOG_TAG, "JSONException on third button.", e);
                                }
                                callbackContext2.sendPluginResult(new PluginResult(Status.OK, jSONObject));
                            }
                        });
                    } catch (JSONException e3) {
                        LOG.m1345d(Notification.LOG_TAG, "JSONException on third button.");
                    }
                }
                access$000.setOnCancelListener(new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        try {
                            jSONObject.put("buttonIndex", 0);
                            jSONObject.put("input1", editText.getText().toString().trim().length() == 0 ? str4 : editText.getText());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        callbackContext2.sendPluginResult(new PluginResult(Status.OK, jSONObject));
                    }
                });
                Notification.this.changeTextDirection(access$000);
            }
        });
    }

    public synchronized void activityStart(String str, String str2) {
        if (this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
        }
        final CordovaInterface cordovaInterface = this.cordova;
        final Notification notification = this;
        final String str3 = str;
        final String str4 = str2;
        this.cordova.getActivity().runOnUiThread(new Runnable() {

            /* renamed from: org.apache.cordova.dialogs.Notification$5$1 */
            class C05421 implements OnCancelListener {
                C05421() {
                }

                public void onCancel(DialogInterface dialogInterface) {
                    notification.spinnerDialog = null;
                }
            }

            public void run() {
                notification.spinnerDialog = Notification.this.createProgressDialog(cordovaInterface);
                notification.spinnerDialog.setTitle(str3);
                notification.spinnerDialog.setMessage(str4);
                notification.spinnerDialog.setCancelable(true);
                notification.spinnerDialog.setIndeterminate(true);
                notification.spinnerDialog.setOnCancelListener(new C05421());
                notification.spinnerDialog.show();
            }
        });
    }

    public synchronized void activityStop() {
        if (this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
        }
    }

    public synchronized void progressStart(String str, String str2) {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
        final CordovaInterface cordovaInterface = this.cordova;
        final Notification notification = this;
        final String str3 = str;
        final String str4 = str2;
        this.cordova.getActivity().runOnUiThread(new Runnable() {

            /* renamed from: org.apache.cordova.dialogs.Notification$6$1 */
            class C05441 implements OnCancelListener {
                C05441() {
                }

                public void onCancel(DialogInterface dialogInterface) {
                    notification.progressDialog = null;
                }
            }

            public void run() {
                notification.progressDialog = Notification.this.createProgressDialog(cordovaInterface);
                notification.progressDialog.setProgressStyle(1);
                notification.progressDialog.setTitle(str3);
                notification.progressDialog.setMessage(str4);
                notification.progressDialog.setCancelable(true);
                notification.progressDialog.setMax(100);
                notification.progressDialog.setProgress(0);
                notification.progressDialog.setOnCancelListener(new C05441());
                notification.progressDialog.show();
            }
        });
    }

    public synchronized void progressValue(int i) {
        if (this.progressDialog != null) {
            this.progressDialog.setProgress(i);
        }
    }

    public synchronized void progressStop() {
        if (this.progressDialog != null) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
    }

    @SuppressLint({"NewApi"})
    private Builder createDialog(CordovaInterface cordovaInterface) {
        if (VERSION.SDK_INT >= 11) {
            return new Builder(cordovaInterface.getActivity(), 5);
        }
        return new Builder(cordovaInterface.getActivity());
    }

    @SuppressLint({"InlinedApi"})
    private ProgressDialog createProgressDialog(CordovaInterface cordovaInterface) {
        if (VERSION.SDK_INT >= 14) {
            return new ProgressDialog(cordovaInterface.getActivity(), 5);
        }
        return new ProgressDialog(cordovaInterface.getActivity());
    }

    @SuppressLint({"NewApi"})
    private void changeTextDirection(Builder builder) {
        int i = VERSION.SDK_INT;
        builder.create();
        AlertDialog show = builder.show();
        if (i >= 17) {
            ((TextView) show.findViewById(16908299)).setTextDirection(5);
        }
    }
}
