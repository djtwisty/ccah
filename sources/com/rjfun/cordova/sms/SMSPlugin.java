package com.rjfun.cordova.sms;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement.Param;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public class SMSPlugin extends CordovaPlugin {
    /* renamed from: a */
    private ContentObserver f769a = null;
    /* renamed from: b */
    private BroadcastReceiver f770b = null;
    /* renamed from: c */
    private boolean f771c = false;
    /* renamed from: d */
    private String f772d = "";
    /* renamed from: e */
    private String f773e = "";

    /* renamed from: com.rjfun.cordova.sms.SMSPlugin$2 */
    class C04762 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ SMSPlugin f767a;

        C04762(SMSPlugin sMSPlugin) {
            this.f767a = sMSPlugin;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d("SMSPlugin", "onRecieve: " + action);
            if ("android.provider.Telephony.SMS_RECEIVED".equals(action)) {
                if (this.f767a.f771c) {
                    abortBroadcast();
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Object[] objArr = (Object[]) extras.get("pdus");
                    if (objArr.length != 0) {
                        for (Object obj : objArr) {
                            this.f767a.m1208b(this.f767a.m1200a(SmsMessage.createFromPdu((byte[]) obj)));
                        }
                    }
                }
            }
        }
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        PluginResult pluginResult;
        if ("setOptions".equals(str)) {
            m1211a(jSONArray.optJSONObject(0));
            pluginResult = new PluginResult(Status.OK);
        } else if ("startWatch".equals(str)) {
            pluginResult = m1194a(callbackContext);
        } else if ("stopWatch".equals(str)) {
            pluginResult = m1206b(callbackContext);
        } else if ("enableIntercept".equals(str)) {
            pluginResult = m1198a(jSONArray.optBoolean(0), callbackContext);
        } else if ("deleteSMS".equals(str)) {
            pluginResult = m1207b(jSONArray.optJSONObject(0), callbackContext);
        } else if ("restoreSMS".equals(str)) {
            pluginResult = m1196a(jSONArray.optJSONArray(0), callbackContext);
        } else if ("listSMS".equals(str)) {
            pluginResult = m1197a(jSONArray.optJSONObject(0), callbackContext);
        } else if ("sendSMS".equals(str)) {
            pluginResult = m1195a(jSONArray.optJSONArray(0), jSONArray.optString(1), callbackContext);
        } else {
            Log.d("SMSPlugin", String.format("Invalid action passed: %s", new Object[]{str}));
            pluginResult = new PluginResult(Status.INVALID_ACTION);
        }
        if (pluginResult != null) {
            callbackContext.sendPluginResult(pluginResult);
        }
        return true;
    }

    public void onDestroy() {
        m1206b(null);
    }

    /* renamed from: a */
    public void m1211a(JSONObject jSONObject) {
        Log.d("SMSPlugin", "setOptions");
    }

    /* renamed from: a */
    private PluginResult m1194a(CallbackContext callbackContext) {
        Log.d("SMSPlugin", "startWatch");
        if (this.f769a == null) {
            m1212b();
        }
        if (this.f770b == null) {
            m1210a();
        }
        if (callbackContext != null) {
            callbackContext.success();
        }
        return null;
    }

    /* renamed from: b */
    private PluginResult m1206b(CallbackContext callbackContext) {
        Log.d("SMSPlugin", "stopWatch");
        Activity activity = this.cordova.getActivity();
        if (this.f770b != null) {
            activity.unregisterReceiver(this.f770b);
            this.f770b = null;
            Log.d("SMSPlugin", "broadcast receiver unregistered");
        }
        if (this.f769a != null) {
            activity.getContentResolver().unregisterContentObserver(this.f769a);
            this.f769a = null;
            Log.d("SMSPlugin", "sms inbox observer unregistered");
        }
        if (callbackContext != null) {
            callbackContext.success();
        }
        return null;
    }

    /* renamed from: a */
    private PluginResult m1198a(boolean z, CallbackContext callbackContext) {
        Log.d("SMSPlugin", "enableIntercept");
        this.f771c = z;
        if (callbackContext != null) {
            callbackContext.success();
        }
        return null;
    }

    /* renamed from: a */
    private PluginResult m1195a(JSONArray jSONArray, String str, CallbackContext callbackContext) {
        Log.d("SMSPlugin", "sendSMS");
        if (this.cordova.getActivity().getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            int length = jSONArray.length();
            if (length > 0) {
                PendingIntent broadcast = PendingIntent.getBroadcast(this.cordova.getActivity(), 0, new Intent("SENDING_SMS"), 0);
                SmsManager smsManager = SmsManager.getDefault();
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i);
                    if (optString.length() > 0) {
                        smsManager.sendTextMessage(optString, null, str, broadcast, (PendingIntent) null);
                    }
                }
            } else {
                PendingIntent activity = PendingIntent.getActivity(this.cordova.getActivity(), 0, new Intent("android.intent.action.VIEW"), 0);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("sms_body", str);
                intent.setType("vnd.android-dir/mms-sms");
                try {
                    activity.send(this.cordova.getActivity().getApplicationContext(), 0, intent);
                } catch (CanceledException e) {
                    e.printStackTrace();
                }
            }
            callbackContext.sendPluginResult(new PluginResult(Status.OK, "OK"));
        } else {
            callbackContext.sendPluginResult(new PluginResult(Status.ERROR, "SMS is not supported"));
        }
        return null;
    }

    /* renamed from: a */
    private PluginResult m1197a(JSONObject jSONObject, CallbackContext callbackContext) {
        Activity activity = this.cordova.getActivity();
        Log.i("SMSPlugin", "listSMS");
        String optString = jSONObject.has("box") ? jSONObject.optString("box") : "inbox";
        int optInt = jSONObject.has("read") ? jSONObject.optInt("read") : -1;
        int optInt2 = jSONObject.has("_id") ? jSONObject.optInt("_id") : -1;
        String optString2 = jSONObject.optString("address");
        String optString3 = jSONObject.optString("body");
        int optInt3 = jSONObject.has("indexFrom") ? jSONObject.optInt("indexFrom") : 0;
        int optInt4 = jSONObject.has("maxCount") ? jSONObject.optInt("maxCount") : 10;
        JSONArray jSONArray = new JSONArray();
        Cursor query = activity.getContentResolver().query(Uri.parse("content://sms/" + optString), (String[]) null, "", (String[]) null, null);
        int i = 0;
        while (query.moveToNext()) {
            boolean equals = optInt2 > -1 ? optInt2 == query.getInt(query.getColumnIndex("_id")) : optInt > -1 ? optInt == query.getInt(query.getColumnIndex("read")) : optString2.length() > 0 ? optString2.equals(query.getString(query.getColumnIndex("address")).trim()) : optString3.length() > 0 ? optString3.equals(query.getString(query.getColumnIndex("body")).trim()) : true;
            if (equals && i >= optInt3) {
                if (i >= optInt3 + optInt4) {
                    break;
                }
                i++;
                JSONObject a = m1199a(query);
                if (a == null) {
                    callbackContext.error("failed to get json from cursor");
                    query.close();
                    return null;
                }
                jSONArray.put(a);
            }
        }
        query.close();
        callbackContext.success(jSONArray);
        return null;
    }

    /* renamed from: a */
    private JSONObject m1199a(Cursor cursor) {
        JSONObject jSONObject = new JSONObject();
        int columnCount = cursor.getColumnCount();
        String[] columnNames = cursor.getColumnNames();
        int i = 0;
        while (i < columnCount) {
            try {
                switch (cursor.getType(i)) {
                    case 0:
                        jSONObject.put(columnNames[i], null);
                        break;
                    case 1:
                        jSONObject.put(columnNames[i], cursor.getLong(i));
                        break;
                    case 2:
                        jSONObject.put(columnNames[i], (double) cursor.getFloat(i));
                        break;
                    case 3:
                        jSONObject.put(columnNames[i], cursor.getString(i));
                        break;
                    case 4:
                        jSONObject.put(columnNames[i], cursor.getBlob(i));
                        break;
                    default:
                        break;
                }
                i++;
            } catch (Exception e) {
                return null;
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m1204a(final String str, JSONObject jSONObject) {
        final String jSONObject2 = jSONObject.toString();
        Log.d("SMSPlugin", "Event: " + str + ", " + jSONObject2);
        this.cordova.getActivity().runOnUiThread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ SMSPlugin f766c;

            public void run() {
                this.f766c.webView.loadUrl(String.format("javascript:cordova.fireDocumentEvent(\"%s\", {\"data\":%s});", new Object[]{str, jSONObject2}));
            }
        });
    }

    /* renamed from: b */
    private void m1208b(JSONObject jSONObject) {
        String optString = jSONObject.optString("address");
        String optString2 = jSONObject.optString("body");
        if (!optString.equals(this.f772d) || !optString2.equals(this.f773e)) {
            this.f772d = optString;
            this.f773e = optString2;
            m1204a("onSMSArrive", jSONObject);
        }
    }

    /* renamed from: a */
    protected void m1210a() {
        int i = 0;
        Activity activity = this.cordova.getActivity();
        this.f770b = new C04762(this);
        String[] strArr = new String[]{"android.provider.Telephony.SMS_RECEIVED"};
        while (i < strArr.length) {
            IntentFilter intentFilter = new IntentFilter(strArr[i]);
            intentFilter.setPriority(100);
            activity.registerReceiver(this.f770b, intentFilter);
            Log.d("SMSPlugin", "broadcast receiver registered for: " + strArr[i]);
            i++;
        }
    }

    /* renamed from: b */
    protected void m1212b() {
        Activity activity = this.cordova.getActivity();
        this.f769a = new ContentObserver(this, new Handler()) {
            /* renamed from: a */
            final /* synthetic */ SMSPlugin f768a;

            public void onChange(boolean z) {
                onChange(z, null);
            }

            public void onChange(boolean z, Uri uri) {
                int parseInt;
                Uri parse;
                Cursor query;
                JSONObject a;
                ContentResolver contentResolver = this.f768a.cordova.getActivity().getContentResolver();
                Log.d("SMSPlugin", "onChange, selfChange: " + z + ", uri: " + uri);
                if (uri != null) {
                    String uri2 = uri.toString();
                    if (uri2.startsWith("content://sms/")) {
                        try {
                            parseInt = Integer.parseInt(uri2.substring("content://sms/".length()));
                            try {
                                Log.d("SMSPlugin", "sms id: " + parseInt);
                            } catch (NumberFormatException e) {
                            }
                        } catch (NumberFormatException e2) {
                            parseInt = -1;
                        }
                        if (parseInt != -1) {
                            parse = Uri.parse("content://sms/inbox");
                        } else {
                            parse = uri;
                        }
                        query = contentResolver.query(parse, null, null, null, "_id desc");
                        if (query != null) {
                            parseInt = query.getCount();
                            Log.d("SMSPlugin", "n = " + parseInt);
                            if (parseInt > 0 && query.moveToFirst()) {
                                a = this.f768a.m1199a(query);
                                if (a == null) {
                                    this.f768a.m1208b(a);
                                } else {
                                    Log.d("SMSPlugin", "fetch record return null");
                                }
                            }
                            query.close();
                        }
                    }
                }
                parseInt = -1;
                if (parseInt != -1) {
                    parse = uri;
                } else {
                    parse = Uri.parse("content://sms/inbox");
                }
                query = contentResolver.query(parse, null, null, null, "_id desc");
                if (query != null) {
                    parseInt = query.getCount();
                    Log.d("SMSPlugin", "n = " + parseInt);
                    a = this.f768a.m1199a(query);
                    if (a == null) {
                        Log.d("SMSPlugin", "fetch record return null");
                    } else {
                        this.f768a.m1208b(a);
                    }
                    query.close();
                }
            }
        };
        activity.getContentResolver().registerContentObserver(Uri.parse("content://sms/inbox"), true, this.f769a);
        Log.d("SMSPlugin", "sms inbox observer registered");
    }

    /* renamed from: b */
    private PluginResult m1207b(JSONObject jSONObject, CallbackContext callbackContext) {
        Log.d("SMSPlugin", "deleteSMS");
        String optString = jSONObject.has("box") ? jSONObject.optString("box") : "inbox";
        int optInt = jSONObject.has("read") ? jSONObject.optInt("read") : -1;
        int optInt2 = jSONObject.has("_id") ? jSONObject.optInt("_id") : -1;
        String optString2 = jSONObject.optString("address");
        String optString3 = jSONObject.optString("body");
        Activity activity = this.cordova.getActivity();
        try {
            Uri parse = Uri.parse("content://sms/" + optString);
            Cursor query = activity.getContentResolver().query(parse, (String[]) null, "", (String[]) null, null);
            int i = 0;
            while (query.moveToNext()) {
                int i2 = query.getInt(query.getColumnIndex("_id"));
                Object obj = (optInt2 <= -1 || optInt2 != i2) ? null : 1;
                Object obj2 = (optInt <= -1 || optInt != query.getInt(query.getColumnIndex("read"))) ? null : 1;
                Object obj3 = (optString2.length() <= 0 || !query.getString(query.getColumnIndex("address")).trim().equals(optString2)) ? null : 1;
                Object obj4 = (optString3.length() <= 0 || !query.getString(query.getColumnIndex("body")).trim().equals(optString3)) ? null : 1;
                if (obj != null || obj2 != null || obj3 != null || obj4 != null) {
                    activity.getContentResolver().delete(parse, "_id=" + i2, (String[]) null);
                    i++;
                }
            }
            callbackContext.success(i);
        } catch (Exception e) {
            callbackContext.error(e.toString());
        }
        return null;
    }

    /* renamed from: a */
    private JSONObject m1200a(SmsMessage smsMessage) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("address", smsMessage.getOriginatingAddress());
            jSONObject.put("body", smsMessage.getMessageBody());
            jSONObject.put("date_sent", smsMessage.getTimestampMillis());
            jSONObject.put("date", System.currentTimeMillis());
            jSONObject.put("read", 0);
            jSONObject.put("seen", 0);
            jSONObject.put("status", smsMessage.getStatus());
            jSONObject.put(Param.TYPE, 1);
            jSONObject.put("service_center", smsMessage.getServiceCenterAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: c */
    private ContentValues m1209c(JSONObject jSONObject) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", jSONObject.optString("address"));
        contentValues.put("body", jSONObject.optString("body"));
        contentValues.put("date_sent", Long.valueOf(jSONObject.optLong("date_sent")));
        contentValues.put("read", Integer.valueOf(jSONObject.optInt("read")));
        contentValues.put("seen", Integer.valueOf(jSONObject.optInt("seen")));
        contentValues.put(Param.TYPE, Integer.valueOf(jSONObject.optInt(Param.TYPE)));
        contentValues.put("service_center", jSONObject.optString("service_center"));
        return contentValues;
    }

    /* renamed from: a */
    private PluginResult m1196a(JSONArray jSONArray, CallbackContext callbackContext) {
        ContentResolver contentResolver = this.cordova.getActivity().getContentResolver();
        Uri parse = Uri.parse("content://sms/inbox");
        int length = jSONArray.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                Log.d("SMSPlugin", optJSONObject.toString());
                Log.d("SMSPlugin", "inserted: " + contentResolver.insert(parse, m1209c(optJSONObject)).toString());
                i++;
            }
        }
        if (callbackContext != null) {
            callbackContext.success(i);
        }
        return null;
    }
}
