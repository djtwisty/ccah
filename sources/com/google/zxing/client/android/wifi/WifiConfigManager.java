package com.google.zxing.client.android.wifi;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.util.Log;
import com.google.zxing.client.result.WifiParsedResult;
import java.util.regex.Pattern;

public final class WifiConfigManager extends AsyncTask<WifiParsedResult, Object, Object> {
    private static final Pattern HEX_DIGITS = Pattern.compile("[0-9A-Fa-f]+");
    private static final String TAG = WifiConfigManager.class.getSimpleName();
    private final WifiManager wifiManager;

    public WifiConfigManager(WifiManager wifiManager) {
        this.wifiManager = wifiManager;
    }

    protected Object doInBackground(WifiParsedResult... wifiParsedResultArr) {
        int i = 0;
        WifiParsedResult wifiParsedResult = wifiParsedResultArr[0];
        if (!this.wifiManager.isWifiEnabled()) {
            Log.i(TAG, "Enabling wi-fi...");
            if (this.wifiManager.setWifiEnabled(true)) {
                Log.i(TAG, "Wi-fi enabled");
                while (!this.wifiManager.isWifiEnabled()) {
                    if (i >= 10) {
                        Log.i(TAG, "Took too long to enable wi-fi, quitting");
                        break;
                    }
                    Log.i(TAG, "Still waiting for wi-fi to enable...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    i++;
                }
            } else {
                Log.w(TAG, "Wi-fi could not be enabled!");
            }
            return null;
        }
        String networkEncryption = wifiParsedResult.getNetworkEncryption();
        try {
            NetworkType forIntentValue = NetworkType.forIntentValue(networkEncryption);
            if (forIntentValue == NetworkType.NO_PASSWORD) {
                changeNetworkUnEncrypted(this.wifiManager, wifiParsedResult);
            } else {
                String password = wifiParsedResult.getPassword();
                if (password != null && !password.isEmpty()) {
                    if (forIntentValue == NetworkType.WEP) {
                        changeNetworkWEP(this.wifiManager, wifiParsedResult);
                    } else if (forIntentValue == NetworkType.WPA) {
                        changeNetworkWPA(this.wifiManager, wifiParsedResult);
                    }
                }
            }
        } catch (IllegalArgumentException e2) {
            Log.w(TAG, "Bad network type; see NetworkType values: " + networkEncryption);
        }
        return null;
    }

    private static void updateNetwork(WifiManager wifiManager, WifiConfiguration wifiConfiguration) {
        Integer findNetworkInExistingConfig = findNetworkInExistingConfig(wifiManager, wifiConfiguration.SSID);
        if (findNetworkInExistingConfig != null) {
            Log.i(TAG, "Removing old configuration for network " + wifiConfiguration.SSID);
            wifiManager.removeNetwork(findNetworkInExistingConfig.intValue());
            wifiManager.saveConfiguration();
        }
        int addNetwork = wifiManager.addNetwork(wifiConfiguration);
        if (addNetwork < 0) {
            Log.w(TAG, "Unable to add network " + wifiConfiguration.SSID);
        } else if (wifiManager.enableNetwork(addNetwork, true)) {
            Log.i(TAG, "Associating to network " + wifiConfiguration.SSID);
            wifiManager.saveConfiguration();
        } else {
            Log.w(TAG, "Failed to enable network " + wifiConfiguration.SSID);
        }
    }

    private static WifiConfiguration changeNetworkCommon(WifiParsedResult wifiParsedResult) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = quoteNonHex(wifiParsedResult.getSsid(), new int[0]);
        wifiConfiguration.hiddenSSID = wifiParsedResult.isHidden();
        return wifiConfiguration;
    }

    private static void changeNetworkWEP(WifiManager wifiManager, WifiParsedResult wifiParsedResult) {
        WifiConfiguration changeNetworkCommon = changeNetworkCommon(wifiParsedResult);
        changeNetworkCommon.wepKeys[0] = quoteNonHex(wifiParsedResult.getPassword(), 10, 26, 58);
        changeNetworkCommon.wepTxKeyIndex = 0;
        changeNetworkCommon.allowedAuthAlgorithms.set(1);
        changeNetworkCommon.allowedKeyManagement.set(0);
        changeNetworkCommon.allowedGroupCiphers.set(2);
        changeNetworkCommon.allowedGroupCiphers.set(3);
        changeNetworkCommon.allowedGroupCiphers.set(0);
        changeNetworkCommon.allowedGroupCiphers.set(1);
        updateNetwork(wifiManager, changeNetworkCommon);
    }

    private static void changeNetworkWPA(WifiManager wifiManager, WifiParsedResult wifiParsedResult) {
        WifiConfiguration changeNetworkCommon = changeNetworkCommon(wifiParsedResult);
        changeNetworkCommon.preSharedKey = quoteNonHex(wifiParsedResult.getPassword(), 64);
        changeNetworkCommon.allowedAuthAlgorithms.set(0);
        changeNetworkCommon.allowedProtocols.set(0);
        changeNetworkCommon.allowedProtocols.set(1);
        changeNetworkCommon.allowedKeyManagement.set(1);
        changeNetworkCommon.allowedKeyManagement.set(2);
        changeNetworkCommon.allowedPairwiseCiphers.set(1);
        changeNetworkCommon.allowedPairwiseCiphers.set(2);
        changeNetworkCommon.allowedGroupCiphers.set(2);
        changeNetworkCommon.allowedGroupCiphers.set(3);
        updateNetwork(wifiManager, changeNetworkCommon);
    }

    private static void changeNetworkUnEncrypted(WifiManager wifiManager, WifiParsedResult wifiParsedResult) {
        WifiConfiguration changeNetworkCommon = changeNetworkCommon(wifiParsedResult);
        changeNetworkCommon.allowedKeyManagement.set(0);
        updateNetwork(wifiManager, changeNetworkCommon);
    }

    private static Integer findNetworkInExistingConfig(WifiManager wifiManager, String str) {
        Iterable<WifiConfiguration> configuredNetworks = wifiManager.getConfiguredNetworks();
        if (configuredNetworks != null) {
            for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                String str2 = wifiConfiguration.SSID;
                if (str2 != null && str2.equals(str)) {
                    return Integer.valueOf(wifiConfiguration.networkId);
                }
            }
        }
        return null;
    }

    private static String quoteNonHex(String str, int... iArr) {
        return isHexOfLength(str, iArr) ? str : convertToQuotedString(str);
    }

    private static String convertToQuotedString(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') ? str : '\"' + str + '\"';
    }

    private static boolean isHexOfLength(CharSequence charSequence, int... iArr) {
        if (charSequence == null || !HEX_DIGITS.matcher(charSequence).matches()) {
            return false;
        }
        if (iArr.length == 0) {
            return true;
        }
        for (int i : iArr) {
            if (charSequence.length() == i) {
                return true;
            }
        }
        return false;
    }
}
