package com.pbakondy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Sim extends CordovaPlugin {
    /* renamed from: a */
    private CallbackContext f661a;

    @SuppressLint({"HardwareIds"})
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        Integer num;
        Integer num2;
        JSONArray jSONArray2;
        String iccId;
        int mcc;
        int mnc;
        int simSlotIndex;
        int subscriptionId;
        boolean isNetworkRoaming;
        Object deviceId;
        JSONException jSONException;
        Integer num3;
        Object obj;
        String simCountryIso;
        String simOperator;
        Object obj2;
        Object obj3;
        int networkType;
        Object obj4;
        String simSerialNumber;
        Object obj5;
        Object obj6;
        JSONObject jSONObject;
        Exception exception;
        this.cordova.getActivity().requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, 0);
        this.f661a = callbackContext;
        if ("getSimInfo".equals(str)) {
            Context applicationContext = this.cordova.getActivity().getApplicationContext();
            TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
            Integer num4 = null;
            try {
                if (VERSION.SDK_INT >= 23) {
                    num4 = Integer.valueOf(telephonyManager.getPhoneCount());
                }
                if (VERSION.SDK_INT < 22 || !m1105a("android.permission.READ_PHONE_STATE")) {
                    num = null;
                    num2 = null;
                    jSONArray2 = null;
                } else {
                    SubscriptionManager subscriptionManager = (SubscriptionManager) applicationContext.getSystemService("telephony_subscription_service");
                    num2 = Integer.valueOf(subscriptionManager.getActiveSubscriptionInfoCount());
                    try {
                        Integer valueOf = Integer.valueOf(subscriptionManager.getActiveSubscriptionInfoCountMax());
                        try {
                            jSONArray2 = new JSONArray();
                            try {
                                for (SubscriptionInfo subscriptionInfo : subscriptionManager.getActiveSubscriptionInfoList()) {
                                    CharSequence carrierName = subscriptionInfo.getCarrierName();
                                    String countryIso = subscriptionInfo.getCountryIso();
                                    int dataRoaming = subscriptionInfo.getDataRoaming();
                                    CharSequence displayName = subscriptionInfo.getDisplayName();
                                    iccId = subscriptionInfo.getIccId();
                                    mcc = subscriptionInfo.getMcc();
                                    mnc = subscriptionInfo.getMnc();
                                    String number = subscriptionInfo.getNumber();
                                    simSlotIndex = subscriptionInfo.getSimSlotIndex();
                                    subscriptionId = subscriptionInfo.getSubscriptionId();
                                    isNetworkRoaming = subscriptionManager.isNetworkRoaming(simSlotIndex);
                                    if (VERSION.SDK_INT >= 23) {
                                        deviceId = telephonyManager.getDeviceId(simSlotIndex);
                                    } else {
                                        deviceId = null;
                                    }
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("carrierName", carrierName.toString());
                                    jSONObject2.put("displayName", displayName.toString());
                                    jSONObject2.put("countryCode", countryIso);
                                    jSONObject2.put("mcc", mcc);
                                    jSONObject2.put("mnc", mnc);
                                    jSONObject2.put("isNetworkRoaming", isNetworkRoaming);
                                    jSONObject2.put("isDataRoaming", dataRoaming == 1);
                                    jSONObject2.put("simSlotIndex", simSlotIndex);
                                    jSONObject2.put("phoneNumber", number);
                                    if (deviceId != null) {
                                        jSONObject2.put("deviceId", deviceId);
                                    }
                                    jSONObject2.put("simSerialNumber", iccId);
                                    jSONObject2.put("subscriptionId", subscriptionId);
                                    jSONArray2.put(jSONObject2);
                                }
                                num = valueOf;
                            } catch (JSONException e) {
                                jSONException = e;
                                num = valueOf;
                                jSONException.printStackTrace();
                                num3 = num4;
                                obj = null;
                                simCountryIso = telephonyManager.getSimCountryIso();
                                simOperator = telephonyManager.getSimOperator();
                                iccId = telephonyManager.getSimOperatorName();
                                obj2 = null;
                                obj3 = null;
                                deviceId = null;
                                mcc = telephonyManager.getCallState();
                                mnc = telephonyManager.getDataActivity();
                                networkType = telephonyManager.getNetworkType();
                                simSlotIndex = telephonyManager.getPhoneType();
                                subscriptionId = telephonyManager.getSimState();
                                isNetworkRoaming = telephonyManager.isNetworkRoaming();
                                if (m1105a("android.permission.READ_PHONE_STATE")) {
                                    obj4 = null;
                                } else {
                                    obj = telephonyManager.getLine1Number();
                                    obj2 = telephonyManager.getDeviceId();
                                    obj3 = telephonyManager.getDeviceSoftwareVersion();
                                    simSerialNumber = telephonyManager.getSimSerialNumber();
                                    obj4 = telephonyManager.getSubscriberId();
                                    deviceId = simSerialNumber;
                                }
                                obj5 = "";
                                obj6 = "";
                                if (simOperator.length() >= 3) {
                                    obj5 = simOperator.substring(0, 3);
                                    obj6 = simOperator.substring(3);
                                }
                                jSONObject = new JSONObject();
                                jSONObject.put("carrierName", iccId);
                                jSONObject.put("countryCode", simCountryIso);
                                jSONObject.put("mcc", obj5);
                                jSONObject.put("mnc", obj6);
                                jSONObject.put("callState", mcc);
                                jSONObject.put("dataActivity", mnc);
                                jSONObject.put("networkType", networkType);
                                jSONObject.put("phoneType", simSlotIndex);
                                jSONObject.put("simState", subscriptionId);
                                jSONObject.put("isNetworkRoaming", isNetworkRoaming);
                                if (num3 != null) {
                                    jSONObject.put("phoneCount", num3.intValue());
                                }
                                if (num2 != null) {
                                    jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
                                }
                                if (num != null) {
                                    jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
                                }
                                if (m1105a("android.permission.READ_PHONE_STATE")) {
                                    jSONObject.put("phoneNumber", obj);
                                    jSONObject.put("deviceId", obj2);
                                    jSONObject.put("deviceSoftwareVersion", obj3);
                                    jSONObject.put("simSerialNumber", deviceId);
                                    jSONObject.put("subscriberId", obj4);
                                }
                                jSONObject.put("cards", jSONArray2);
                                callbackContext.success(jSONObject);
                                return true;
                            } catch (Exception e2) {
                                exception = e2;
                                num = valueOf;
                                exception.printStackTrace();
                                num3 = num4;
                                obj = null;
                                simCountryIso = telephonyManager.getSimCountryIso();
                                simOperator = telephonyManager.getSimOperator();
                                iccId = telephonyManager.getSimOperatorName();
                                obj2 = null;
                                obj3 = null;
                                deviceId = null;
                                mcc = telephonyManager.getCallState();
                                mnc = telephonyManager.getDataActivity();
                                networkType = telephonyManager.getNetworkType();
                                simSlotIndex = telephonyManager.getPhoneType();
                                subscriptionId = telephonyManager.getSimState();
                                isNetworkRoaming = telephonyManager.isNetworkRoaming();
                                if (m1105a("android.permission.READ_PHONE_STATE")) {
                                    obj = telephonyManager.getLine1Number();
                                    obj2 = telephonyManager.getDeviceId();
                                    obj3 = telephonyManager.getDeviceSoftwareVersion();
                                    simSerialNumber = telephonyManager.getSimSerialNumber();
                                    obj4 = telephonyManager.getSubscriberId();
                                    deviceId = simSerialNumber;
                                } else {
                                    obj4 = null;
                                }
                                obj5 = "";
                                obj6 = "";
                                if (simOperator.length() >= 3) {
                                    obj5 = simOperator.substring(0, 3);
                                    obj6 = simOperator.substring(3);
                                }
                                jSONObject = new JSONObject();
                                jSONObject.put("carrierName", iccId);
                                jSONObject.put("countryCode", simCountryIso);
                                jSONObject.put("mcc", obj5);
                                jSONObject.put("mnc", obj6);
                                jSONObject.put("callState", mcc);
                                jSONObject.put("dataActivity", mnc);
                                jSONObject.put("networkType", networkType);
                                jSONObject.put("phoneType", simSlotIndex);
                                jSONObject.put("simState", subscriptionId);
                                jSONObject.put("isNetworkRoaming", isNetworkRoaming);
                                if (num3 != null) {
                                    jSONObject.put("phoneCount", num3.intValue());
                                }
                                if (num2 != null) {
                                    jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
                                }
                                if (num != null) {
                                    jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
                                }
                                if (m1105a("android.permission.READ_PHONE_STATE")) {
                                    jSONObject.put("phoneNumber", obj);
                                    jSONObject.put("deviceId", obj2);
                                    jSONObject.put("deviceSoftwareVersion", obj3);
                                    jSONObject.put("simSerialNumber", deviceId);
                                    jSONObject.put("subscriberId", obj4);
                                }
                                jSONObject.put("cards", jSONArray2);
                                callbackContext.success(jSONObject);
                                return true;
                            }
                        } catch (JSONException e3) {
                            jSONException = e3;
                            num = valueOf;
                            jSONArray2 = null;
                            jSONException.printStackTrace();
                            num3 = num4;
                            obj = null;
                            simCountryIso = telephonyManager.getSimCountryIso();
                            simOperator = telephonyManager.getSimOperator();
                            iccId = telephonyManager.getSimOperatorName();
                            obj2 = null;
                            obj3 = null;
                            deviceId = null;
                            mcc = telephonyManager.getCallState();
                            mnc = telephonyManager.getDataActivity();
                            networkType = telephonyManager.getNetworkType();
                            simSlotIndex = telephonyManager.getPhoneType();
                            subscriptionId = telephonyManager.getSimState();
                            isNetworkRoaming = telephonyManager.isNetworkRoaming();
                            if (m1105a("android.permission.READ_PHONE_STATE")) {
                                obj4 = null;
                            } else {
                                obj = telephonyManager.getLine1Number();
                                obj2 = telephonyManager.getDeviceId();
                                obj3 = telephonyManager.getDeviceSoftwareVersion();
                                simSerialNumber = telephonyManager.getSimSerialNumber();
                                obj4 = telephonyManager.getSubscriberId();
                                deviceId = simSerialNumber;
                            }
                            obj5 = "";
                            obj6 = "";
                            if (simOperator.length() >= 3) {
                                obj5 = simOperator.substring(0, 3);
                                obj6 = simOperator.substring(3);
                            }
                            jSONObject = new JSONObject();
                            jSONObject.put("carrierName", iccId);
                            jSONObject.put("countryCode", simCountryIso);
                            jSONObject.put("mcc", obj5);
                            jSONObject.put("mnc", obj6);
                            jSONObject.put("callState", mcc);
                            jSONObject.put("dataActivity", mnc);
                            jSONObject.put("networkType", networkType);
                            jSONObject.put("phoneType", simSlotIndex);
                            jSONObject.put("simState", subscriptionId);
                            jSONObject.put("isNetworkRoaming", isNetworkRoaming);
                            if (num3 != null) {
                                jSONObject.put("phoneCount", num3.intValue());
                            }
                            if (num2 != null) {
                                jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
                            }
                            if (num != null) {
                                jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
                            }
                            if (m1105a("android.permission.READ_PHONE_STATE")) {
                                jSONObject.put("phoneNumber", obj);
                                jSONObject.put("deviceId", obj2);
                                jSONObject.put("deviceSoftwareVersion", obj3);
                                jSONObject.put("simSerialNumber", deviceId);
                                jSONObject.put("subscriberId", obj4);
                            }
                            jSONObject.put("cards", jSONArray2);
                            callbackContext.success(jSONObject);
                            return true;
                        } catch (Exception e22) {
                            exception = e22;
                            num = valueOf;
                            jSONArray2 = null;
                            exception.printStackTrace();
                            num3 = num4;
                            obj = null;
                            simCountryIso = telephonyManager.getSimCountryIso();
                            simOperator = telephonyManager.getSimOperator();
                            iccId = telephonyManager.getSimOperatorName();
                            obj2 = null;
                            obj3 = null;
                            deviceId = null;
                            mcc = telephonyManager.getCallState();
                            mnc = telephonyManager.getDataActivity();
                            networkType = telephonyManager.getNetworkType();
                            simSlotIndex = telephonyManager.getPhoneType();
                            subscriptionId = telephonyManager.getSimState();
                            isNetworkRoaming = telephonyManager.isNetworkRoaming();
                            if (m1105a("android.permission.READ_PHONE_STATE")) {
                                obj = telephonyManager.getLine1Number();
                                obj2 = telephonyManager.getDeviceId();
                                obj3 = telephonyManager.getDeviceSoftwareVersion();
                                simSerialNumber = telephonyManager.getSimSerialNumber();
                                obj4 = telephonyManager.getSubscriberId();
                                deviceId = simSerialNumber;
                            } else {
                                obj4 = null;
                            }
                            obj5 = "";
                            obj6 = "";
                            if (simOperator.length() >= 3) {
                                obj5 = simOperator.substring(0, 3);
                                obj6 = simOperator.substring(3);
                            }
                            jSONObject = new JSONObject();
                            jSONObject.put("carrierName", iccId);
                            jSONObject.put("countryCode", simCountryIso);
                            jSONObject.put("mcc", obj5);
                            jSONObject.put("mnc", obj6);
                            jSONObject.put("callState", mcc);
                            jSONObject.put("dataActivity", mnc);
                            jSONObject.put("networkType", networkType);
                            jSONObject.put("phoneType", simSlotIndex);
                            jSONObject.put("simState", subscriptionId);
                            jSONObject.put("isNetworkRoaming", isNetworkRoaming);
                            if (num3 != null) {
                                jSONObject.put("phoneCount", num3.intValue());
                            }
                            if (num2 != null) {
                                jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
                            }
                            if (num != null) {
                                jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
                            }
                            if (m1105a("android.permission.READ_PHONE_STATE")) {
                                jSONObject.put("phoneNumber", obj);
                                jSONObject.put("deviceId", obj2);
                                jSONObject.put("deviceSoftwareVersion", obj3);
                                jSONObject.put("simSerialNumber", deviceId);
                                jSONObject.put("subscriberId", obj4);
                            }
                            jSONObject.put("cards", jSONArray2);
                            callbackContext.success(jSONObject);
                            return true;
                        }
                    } catch (JSONException e4) {
                        jSONException = e4;
                        num = null;
                        jSONArray2 = null;
                        jSONException.printStackTrace();
                        num3 = num4;
                        obj = null;
                        simCountryIso = telephonyManager.getSimCountryIso();
                        simOperator = telephonyManager.getSimOperator();
                        iccId = telephonyManager.getSimOperatorName();
                        obj2 = null;
                        obj3 = null;
                        deviceId = null;
                        mcc = telephonyManager.getCallState();
                        mnc = telephonyManager.getDataActivity();
                        networkType = telephonyManager.getNetworkType();
                        simSlotIndex = telephonyManager.getPhoneType();
                        subscriptionId = telephonyManager.getSimState();
                        isNetworkRoaming = telephonyManager.isNetworkRoaming();
                        if (m1105a("android.permission.READ_PHONE_STATE")) {
                            obj4 = null;
                        } else {
                            obj = telephonyManager.getLine1Number();
                            obj2 = telephonyManager.getDeviceId();
                            obj3 = telephonyManager.getDeviceSoftwareVersion();
                            simSerialNumber = telephonyManager.getSimSerialNumber();
                            obj4 = telephonyManager.getSubscriberId();
                            deviceId = simSerialNumber;
                        }
                        obj5 = "";
                        obj6 = "";
                        if (simOperator.length() >= 3) {
                            obj5 = simOperator.substring(0, 3);
                            obj6 = simOperator.substring(3);
                        }
                        jSONObject = new JSONObject();
                        jSONObject.put("carrierName", iccId);
                        jSONObject.put("countryCode", simCountryIso);
                        jSONObject.put("mcc", obj5);
                        jSONObject.put("mnc", obj6);
                        jSONObject.put("callState", mcc);
                        jSONObject.put("dataActivity", mnc);
                        jSONObject.put("networkType", networkType);
                        jSONObject.put("phoneType", simSlotIndex);
                        jSONObject.put("simState", subscriptionId);
                        jSONObject.put("isNetworkRoaming", isNetworkRoaming);
                        if (num3 != null) {
                            jSONObject.put("phoneCount", num3.intValue());
                        }
                        if (num2 != null) {
                            jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
                        }
                        if (num != null) {
                            jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
                        }
                        if (m1105a("android.permission.READ_PHONE_STATE")) {
                            jSONObject.put("phoneNumber", obj);
                            jSONObject.put("deviceId", obj2);
                            jSONObject.put("deviceSoftwareVersion", obj3);
                            jSONObject.put("simSerialNumber", deviceId);
                            jSONObject.put("subscriberId", obj4);
                        }
                        jSONObject.put("cards", jSONArray2);
                        callbackContext.success(jSONObject);
                        return true;
                    } catch (Exception e5) {
                        exception = e5;
                        num = null;
                        jSONArray2 = null;
                        exception.printStackTrace();
                        num3 = num4;
                        obj = null;
                        simCountryIso = telephonyManager.getSimCountryIso();
                        simOperator = telephonyManager.getSimOperator();
                        iccId = telephonyManager.getSimOperatorName();
                        obj2 = null;
                        obj3 = null;
                        deviceId = null;
                        mcc = telephonyManager.getCallState();
                        mnc = telephonyManager.getDataActivity();
                        networkType = telephonyManager.getNetworkType();
                        simSlotIndex = telephonyManager.getPhoneType();
                        subscriptionId = telephonyManager.getSimState();
                        isNetworkRoaming = telephonyManager.isNetworkRoaming();
                        if (m1105a("android.permission.READ_PHONE_STATE")) {
                            obj = telephonyManager.getLine1Number();
                            obj2 = telephonyManager.getDeviceId();
                            obj3 = telephonyManager.getDeviceSoftwareVersion();
                            simSerialNumber = telephonyManager.getSimSerialNumber();
                            obj4 = telephonyManager.getSubscriberId();
                            deviceId = simSerialNumber;
                        } else {
                            obj4 = null;
                        }
                        obj5 = "";
                        obj6 = "";
                        if (simOperator.length() >= 3) {
                            obj5 = simOperator.substring(0, 3);
                            obj6 = simOperator.substring(3);
                        }
                        jSONObject = new JSONObject();
                        jSONObject.put("carrierName", iccId);
                        jSONObject.put("countryCode", simCountryIso);
                        jSONObject.put("mcc", obj5);
                        jSONObject.put("mnc", obj6);
                        jSONObject.put("callState", mcc);
                        jSONObject.put("dataActivity", mnc);
                        jSONObject.put("networkType", networkType);
                        jSONObject.put("phoneType", simSlotIndex);
                        jSONObject.put("simState", subscriptionId);
                        jSONObject.put("isNetworkRoaming", isNetworkRoaming);
                        if (num3 != null) {
                            jSONObject.put("phoneCount", num3.intValue());
                        }
                        if (num2 != null) {
                            jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
                        }
                        if (num != null) {
                            jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
                        }
                        if (m1105a("android.permission.READ_PHONE_STATE")) {
                            jSONObject.put("phoneNumber", obj);
                            jSONObject.put("deviceId", obj2);
                            jSONObject.put("deviceSoftwareVersion", obj3);
                            jSONObject.put("simSerialNumber", deviceId);
                            jSONObject.put("subscriberId", obj4);
                        }
                        jSONObject.put("cards", jSONArray2);
                        callbackContext.success(jSONObject);
                        return true;
                    }
                }
                num3 = num4;
            } catch (JSONException e6) {
                jSONException = e6;
                num = null;
                num2 = null;
                jSONArray2 = null;
                jSONException.printStackTrace();
                num3 = num4;
                obj = null;
                simCountryIso = telephonyManager.getSimCountryIso();
                simOperator = telephonyManager.getSimOperator();
                iccId = telephonyManager.getSimOperatorName();
                obj2 = null;
                obj3 = null;
                deviceId = null;
                mcc = telephonyManager.getCallState();
                mnc = telephonyManager.getDataActivity();
                networkType = telephonyManager.getNetworkType();
                simSlotIndex = telephonyManager.getPhoneType();
                subscriptionId = telephonyManager.getSimState();
                isNetworkRoaming = telephonyManager.isNetworkRoaming();
                if (m1105a("android.permission.READ_PHONE_STATE")) {
                    obj4 = null;
                } else {
                    obj = telephonyManager.getLine1Number();
                    obj2 = telephonyManager.getDeviceId();
                    obj3 = telephonyManager.getDeviceSoftwareVersion();
                    simSerialNumber = telephonyManager.getSimSerialNumber();
                    obj4 = telephonyManager.getSubscriberId();
                    deviceId = simSerialNumber;
                }
                obj5 = "";
                obj6 = "";
                if (simOperator.length() >= 3) {
                    obj5 = simOperator.substring(0, 3);
                    obj6 = simOperator.substring(3);
                }
                jSONObject = new JSONObject();
                jSONObject.put("carrierName", iccId);
                jSONObject.put("countryCode", simCountryIso);
                jSONObject.put("mcc", obj5);
                jSONObject.put("mnc", obj6);
                jSONObject.put("callState", mcc);
                jSONObject.put("dataActivity", mnc);
                jSONObject.put("networkType", networkType);
                jSONObject.put("phoneType", simSlotIndex);
                jSONObject.put("simState", subscriptionId);
                jSONObject.put("isNetworkRoaming", isNetworkRoaming);
                if (num3 != null) {
                    jSONObject.put("phoneCount", num3.intValue());
                }
                if (num2 != null) {
                    jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
                }
                if (num != null) {
                    jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
                }
                if (m1105a("android.permission.READ_PHONE_STATE")) {
                    jSONObject.put("phoneNumber", obj);
                    jSONObject.put("deviceId", obj2);
                    jSONObject.put("deviceSoftwareVersion", obj3);
                    jSONObject.put("simSerialNumber", deviceId);
                    jSONObject.put("subscriberId", obj4);
                }
                jSONObject.put("cards", jSONArray2);
                callbackContext.success(jSONObject);
                return true;
            } catch (Exception e7) {
                exception = e7;
                num = null;
                num2 = null;
                jSONArray2 = null;
                exception.printStackTrace();
                num3 = num4;
                obj = null;
                simCountryIso = telephonyManager.getSimCountryIso();
                simOperator = telephonyManager.getSimOperator();
                iccId = telephonyManager.getSimOperatorName();
                obj2 = null;
                obj3 = null;
                deviceId = null;
                mcc = telephonyManager.getCallState();
                mnc = telephonyManager.getDataActivity();
                networkType = telephonyManager.getNetworkType();
                simSlotIndex = telephonyManager.getPhoneType();
                subscriptionId = telephonyManager.getSimState();
                isNetworkRoaming = telephonyManager.isNetworkRoaming();
                if (m1105a("android.permission.READ_PHONE_STATE")) {
                    obj = telephonyManager.getLine1Number();
                    obj2 = telephonyManager.getDeviceId();
                    obj3 = telephonyManager.getDeviceSoftwareVersion();
                    simSerialNumber = telephonyManager.getSimSerialNumber();
                    obj4 = telephonyManager.getSubscriberId();
                    deviceId = simSerialNumber;
                } else {
                    obj4 = null;
                }
                obj5 = "";
                obj6 = "";
                if (simOperator.length() >= 3) {
                    obj5 = simOperator.substring(0, 3);
                    obj6 = simOperator.substring(3);
                }
                jSONObject = new JSONObject();
                jSONObject.put("carrierName", iccId);
                jSONObject.put("countryCode", simCountryIso);
                jSONObject.put("mcc", obj5);
                jSONObject.put("mnc", obj6);
                jSONObject.put("callState", mcc);
                jSONObject.put("dataActivity", mnc);
                jSONObject.put("networkType", networkType);
                jSONObject.put("phoneType", simSlotIndex);
                jSONObject.put("simState", subscriptionId);
                jSONObject.put("isNetworkRoaming", isNetworkRoaming);
                if (num3 != null) {
                    jSONObject.put("phoneCount", num3.intValue());
                }
                if (num2 != null) {
                    jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
                }
                if (num != null) {
                    jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
                }
                if (m1105a("android.permission.READ_PHONE_STATE")) {
                    jSONObject.put("phoneNumber", obj);
                    jSONObject.put("deviceId", obj2);
                    jSONObject.put("deviceSoftwareVersion", obj3);
                    jSONObject.put("simSerialNumber", deviceId);
                    jSONObject.put("subscriberId", obj4);
                }
                jSONObject.put("cards", jSONArray2);
                callbackContext.success(jSONObject);
                return true;
            }
            obj = null;
            simCountryIso = telephonyManager.getSimCountryIso();
            simOperator = telephonyManager.getSimOperator();
            iccId = telephonyManager.getSimOperatorName();
            obj2 = null;
            obj3 = null;
            deviceId = null;
            mcc = telephonyManager.getCallState();
            mnc = telephonyManager.getDataActivity();
            networkType = telephonyManager.getNetworkType();
            simSlotIndex = telephonyManager.getPhoneType();
            subscriptionId = telephonyManager.getSimState();
            isNetworkRoaming = telephonyManager.isNetworkRoaming();
            if (m1105a("android.permission.READ_PHONE_STATE")) {
                obj = telephonyManager.getLine1Number();
                obj2 = telephonyManager.getDeviceId();
                obj3 = telephonyManager.getDeviceSoftwareVersion();
                simSerialNumber = telephonyManager.getSimSerialNumber();
                obj4 = telephonyManager.getSubscriberId();
                deviceId = simSerialNumber;
            } else {
                obj4 = null;
            }
            obj5 = "";
            obj6 = "";
            if (simOperator.length() >= 3) {
                obj5 = simOperator.substring(0, 3);
                obj6 = simOperator.substring(3);
            }
            jSONObject = new JSONObject();
            jSONObject.put("carrierName", iccId);
            jSONObject.put("countryCode", simCountryIso);
            jSONObject.put("mcc", obj5);
            jSONObject.put("mnc", obj6);
            jSONObject.put("callState", mcc);
            jSONObject.put("dataActivity", mnc);
            jSONObject.put("networkType", networkType);
            jSONObject.put("phoneType", simSlotIndex);
            jSONObject.put("simState", subscriptionId);
            jSONObject.put("isNetworkRoaming", isNetworkRoaming);
            if (num3 != null) {
                jSONObject.put("phoneCount", num3.intValue());
            }
            if (num2 != null) {
                jSONObject.put("activeSubscriptionInfoCount", num2.intValue());
            }
            if (num != null) {
                jSONObject.put("activeSubscriptionInfoCountMax", num.intValue());
            }
            if (m1105a("android.permission.READ_PHONE_STATE")) {
                jSONObject.put("phoneNumber", obj);
                jSONObject.put("deviceId", obj2);
                jSONObject.put("deviceSoftwareVersion", obj3);
                jSONObject.put("simSerialNumber", deviceId);
                jSONObject.put("subscriberId", obj4);
            }
            if (!(jSONArray2 == null || jSONArray2.length() == 0)) {
                jSONObject.put("cards", jSONArray2);
            }
            callbackContext.success(jSONObject);
            return true;
        } else if ("hasReadPermission".equals(str)) {
            m1104a();
            return true;
        } else if (!"requestReadPermission".equals(str)) {
            return false;
        } else {
            m1106b();
            return true;
        }
    }

    /* renamed from: a */
    private void m1104a() {
        this.f661a.sendPluginResult(new PluginResult(Status.OK, m1105a("android.permission.READ_PHONE_STATE")));
    }

    /* renamed from: b */
    private void m1106b() {
        m1107b("android.permission.READ_PHONE_STATE");
    }

    /* renamed from: a */
    private boolean m1105a(String str) {
        if (VERSION.SDK_INT < 23) {
            return true;
        }
        return this.cordova.hasPermission(str);
    }

    /* renamed from: b */
    private void m1107b(String str) {
        LOG.m1351i("CordovaPluginSim", "requestPermission");
        if (m1105a(str)) {
            this.f661a.success();
        } else {
            this.cordova.requestPermission(this, 12345, str);
        }
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length <= 0 || iArr[0] != 0) {
            this.f661a.error("Permission denied");
        } else {
            this.f661a.success();
        }
    }
}
