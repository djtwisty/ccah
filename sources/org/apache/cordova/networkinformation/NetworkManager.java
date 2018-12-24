package org.apache.cordova.networkinformation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.Locale;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkManager extends CordovaPlugin {
    public static final String CDMA = "cdma";
    public static final String CELLULAR = "cellular";
    public static final String EDGE = "edge";
    public static final String EHRPD = "ehrpd";
    public static final String FOUR_G = "4g";
    public static final String GPRS = "gprs";
    public static final String GSM = "gsm";
    public static final String HSDPA = "hsdpa";
    public static final String HSPA = "hspa";
    public static final String HSPA_PLUS = "hspa+";
    public static final String HSUPA = "hsupa";
    private static final String LOG_TAG = "NetworkManager";
    public static final String LTE = "lte";
    public static final String MOBILE = "mobile";
    public static int NOT_REACHABLE = 0;
    public static final String ONEXRTT = "1xrtt";
    public static int REACHABLE_VIA_CARRIER_DATA_NETWORK = 1;
    public static int REACHABLE_VIA_WIFI_NETWORK = 2;
    public static final String THREE_G = "3g";
    public static final String TWO_G = "2g";
    public static final String TYPE_2G = "2g";
    public static final String TYPE_3G = "3g";
    public static final String TYPE_4G = "4g";
    public static final String TYPE_ETHERNET = "ethernet";
    public static final String TYPE_ETHERNET_SHORT = "eth";
    public static final String TYPE_NONE = "none";
    public static final String TYPE_UNKNOWN = "unknown";
    public static final String TYPE_WIFI = "wifi";
    public static final String UMB = "umb";
    public static final String UMTS = "umts";
    public static final String WIFI = "wifi";
    public static final String WIMAX = "wimax";
    private CallbackContext connectionCallbackContext;
    private JSONObject lastInfo = null;
    BroadcastReceiver receiver;
    ConnectivityManager sockMan;

    /* renamed from: org.apache.cordova.networkinformation.NetworkManager$1 */
    class C05751 extends BroadcastReceiver {
        C05751() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetworkManager.this.webView != null) {
                NetworkManager.this.updateConnectionInfo(NetworkManager.this.sockMan.getActiveNetworkInfo());
            }
        }
    }

    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.sockMan = (ConnectivityManager) cordovaInterface.getActivity().getSystemService("connectivity");
        this.connectionCallbackContext = null;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (this.receiver == null) {
            this.receiver = new C05751();
            cordovaWebView.getContext().registerReceiver(this.receiver, intentFilter);
        }
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        if (!str.equals("getConnectionInfo")) {
            return false;
        }
        this.connectionCallbackContext = callbackContext;
        String str2 = "";
        try {
            str2 = getConnectionInfo(this.sockMan.getActiveNetworkInfo()).get(Param.TYPE).toString();
        } catch (JSONException e) {
            LOG.m1345d(LOG_TAG, e.getLocalizedMessage());
        }
        PluginResult pluginResult = new PluginResult(Status.OK, str2);
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }

    public void onDestroy() {
        if (this.receiver != null) {
            try {
                this.webView.getContext().unregisterReceiver(this.receiver);
            } catch (Throwable e) {
                LOG.m1349e(LOG_TAG, "Error unregistering network receiver: " + e.getMessage(), e);
            } finally {
                this.receiver = null;
            }
        }
    }

    private void updateConnectionInfo(NetworkInfo networkInfo) {
        JSONObject connectionInfo = getConnectionInfo(networkInfo);
        if (!connectionInfo.equals(this.lastInfo)) {
            String str = "";
            try {
                str = connectionInfo.get(Param.TYPE).toString();
            } catch (JSONException e) {
                LOG.m1345d(LOG_TAG, e.getLocalizedMessage());
            }
            sendUpdate(str);
            this.lastInfo = connectionInfo;
        }
    }

    private JSONObject getConnectionInfo(NetworkInfo networkInfo) {
        String extraInfo;
        String str = TYPE_NONE;
        String str2 = "";
        if (networkInfo != null) {
            if (networkInfo.isConnected()) {
                str2 = getType(networkInfo);
            } else {
                str2 = TYPE_NONE;
            }
            extraInfo = networkInfo.getExtraInfo();
            str = str2;
        } else {
            extraInfo = str2;
        }
        LOG.m1345d(LOG_TAG, "Connection Type: " + str);
        LOG.m1345d(LOG_TAG, "Connection Extra Info: " + extraInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Param.TYPE, str);
            jSONObject.put("extraInfo", extraInfo);
        } catch (JSONException e) {
            LOG.m1345d(LOG_TAG, e.getLocalizedMessage());
        }
        return jSONObject;
    }

    private void sendUpdate(String str) {
        if (this.connectionCallbackContext != null) {
            PluginResult pluginResult = new PluginResult(Status.OK, str);
            pluginResult.setKeepCallback(true);
            this.connectionCallbackContext.sendPluginResult(pluginResult);
        }
        this.webView.postMessage("networkconnection", str);
    }

    private String getType(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return TYPE_NONE;
        }
        String toLowerCase = networkInfo.getTypeName().toLowerCase(Locale.US);
        LOG.m1345d(LOG_TAG, "toLower : " + toLowerCase.toLowerCase());
        LOG.m1345d(LOG_TAG, "wifi : wifi");
        if (toLowerCase.equals("wifi")) {
            return "wifi";
        }
        if (toLowerCase.toLowerCase().equals(TYPE_ETHERNET) || toLowerCase.toLowerCase().startsWith(TYPE_ETHERNET_SHORT)) {
            return TYPE_ETHERNET;
        }
        if (toLowerCase.equals(MOBILE) || toLowerCase.equals(CELLULAR)) {
            toLowerCase = networkInfo.getSubtypeName().toLowerCase(Locale.US);
            if (toLowerCase.equals(GSM) || toLowerCase.equals(GPRS) || toLowerCase.equals(EDGE) || toLowerCase.equals("2g")) {
                return "2g";
            }
            if (toLowerCase.startsWith(CDMA) || toLowerCase.equals(UMTS) || toLowerCase.equals(ONEXRTT) || toLowerCase.equals(EHRPD) || toLowerCase.equals(HSUPA) || toLowerCase.equals(HSDPA) || toLowerCase.equals(HSPA) || toLowerCase.equals("3g")) {
                return "3g";
            }
            if (toLowerCase.equals(LTE) || toLowerCase.equals(UMB) || toLowerCase.equals(HSPA_PLUS) || toLowerCase.equals("4g")) {
                return "4g";
            }
        }
        return TYPE_UNKNOWN;
    }
}
