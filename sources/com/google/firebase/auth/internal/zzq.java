package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.zxing.aztec.encoder.Encoder;
import java.util.Arrays;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.LangUtils;

public final class zzq {
    public static Status zzcu(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Status(FirebaseError.ERROR_INTERNAL_ERROR);
        }
        String[] split = str.split(":", 2);
        split[0] = split[0].trim();
        if (split.length > 1 && split[1] != null) {
            split[1] = split[1].trim();
        }
        List asList = Arrays.asList(split);
        if (asList.size() > 1) {
            return zzc((String) asList.get(0), (String) asList.get(1));
        }
        return zzc((String) asList.get(0), null);
    }

    private static Status zzc(String str, String str2) {
        int i;
        Object obj = -1;
        switch (str.hashCode()) {
            case -2065866930:
                if (str.equals("INVALID_RECIPIENT_EMAIL")) {
                    obj = 27;
                    break;
                }
                break;
            case -2014808264:
                if (str.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
                    obj = 46;
                    break;
                }
                break;
            case -2001169389:
                if (str.equals("INVALID_IDP_RESPONSE")) {
                    obj = 3;
                    break;
                }
                break;
            case -1944433728:
                if (str.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
                    obj = 44;
                    break;
                }
                break;
            case -1800638118:
                if (str.equals("QUOTA_EXCEEDED")) {
                    obj = 38;
                    break;
                }
                break;
            case -1774756919:
                if (str.equals("WEB_NETWORK_REQUEST_FAILED")) {
                    obj = 40;
                    break;
                }
                break;
            case -1587614300:
                if (str.equals("EXPIRED_OOB_CODE")) {
                    obj = 24;
                    break;
                }
                break;
            case -1583894766:
                if (str.equals("INVALID_OOB_CODE")) {
                    obj = 23;
                    break;
                }
                break;
            case -1458751677:
                if (str.equals("MISSING_EMAIL")) {
                    obj = 28;
                    break;
                }
                break;
            case -1421414571:
                if (str.equals("INVALID_CODE")) {
                    obj = 33;
                    break;
                }
                break;
            case -1345867105:
                if (str.equals("TOKEN_EXPIRED")) {
                    obj = 22;
                    break;
                }
                break;
            case -1232010689:
                if (str.equals("INVALID_SESSION_INFO")) {
                    obj = 35;
                    break;
                }
                break;
            case -1112393964:
                if (str.equals("INVALID_EMAIL")) {
                    obj = 6;
                    break;
                }
                break;
            case -863830559:
                if (str.equals("INVALID_CERT_HASH")) {
                    obj = 39;
                    break;
                }
                break;
            case -828507413:
                if (str.equals("NO_SUCH_PROVIDER")) {
                    obj = null;
                    break;
                }
                break;
            case -736207500:
                if (str.equals("MISSING_PASSWORD")) {
                    obj = 29;
                    break;
                }
                break;
            case -646022241:
                if (str.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                    obj = 19;
                    break;
                }
                break;
            case -595928767:
                if (str.equals("TIMEOUT")) {
                    obj = 13;
                    break;
                }
                break;
            case -333672188:
                if (str.equals("OPERATION_NOT_ALLOWED")) {
                    obj = 16;
                    break;
                }
                break;
            case -294485423:
                if (str.equals("WEB_INTERNAL_ERROR")) {
                    obj = 41;
                    break;
                }
                break;
            case -75433118:
                if (str.equals("USER_NOT_FOUND")) {
                    obj = 8;
                    break;
                }
                break;
            case -40686718:
                if (str.equals("WEAK_PASSWORD")) {
                    obj = 15;
                    break;
                }
                break;
            case 15352275:
                if (str.equals("EMAIL_NOT_FOUND")) {
                    obj = 7;
                    break;
                }
                break;
            case 269327773:
                if (str.equals("INVALID_SENDER")) {
                    obj = 26;
                    break;
                }
                break;
            case 278802867:
                if (str.equals("MISSING_PHONE_NUMBER")) {
                    obj = 30;
                    break;
                }
                break;
            case 408411681:
                if (str.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
                    obj = 49;
                    break;
                }
                break;
            case 483847807:
                if (str.equals("EMAIL_EXISTS")) {
                    obj = 9;
                    break;
                }
                break;
            case 491979549:
                if (str.equals("INVALID_ID_TOKEN")) {
                    obj = 12;
                    break;
                }
                break;
            case 492072102:
                if (str.equals("WEB_STORAGE_UNSUPPORTED")) {
                    obj = 42;
                    break;
                }
                break;
            case 542728406:
                if (str.equals("PASSWORD_LOGIN_DISABLED")) {
                    obj = 17;
                    break;
                }
                break;
            case 605031096:
                if (str.equals("REJECTED_CREDENTIAL")) {
                    obj = 50;
                    break;
                }
                break;
            case 786916712:
                if (str.equals("INVALID_VERIFICATION_PROOF")) {
                    obj = 36;
                    break;
                }
                break;
            case 799258561:
                if (str.equals("INVALID_PROVIDER_ID")) {
                    obj = 45;
                    break;
                }
                break;
            case 819646646:
                if (str.equals("CREDENTIAL_MISMATCH")) {
                    obj = 1;
                    break;
                }
                break;
            case 844240628:
                if (str.equals("WEB_CONTEXT_CANCELED")) {
                    obj = 47;
                    break;
                }
                break;
            case 922685102:
                if (str.equals("INVALID_MESSAGE_PAYLOAD")) {
                    obj = 25;
                    break;
                }
                break;
            case 989000548:
                if (str.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                    obj = 21;
                    break;
                }
                break;
            case 1072360691:
                if (str.equals("INVALID_CUSTOM_TOKEN")) {
                    obj = 2;
                    break;
                }
                break;
            case 1094975491:
                if (str.equals("INVALID_PASSWORD")) {
                    obj = 10;
                    break;
                }
                break;
            case 1107081238:
                if (str.equals("<<Network Error>>")) {
                    obj = 14;
                    break;
                }
                break;
            case 1141576252:
                if (str.equals("SESSION_EXPIRED")) {
                    obj = 37;
                    break;
                }
                break;
            case 1199811910:
                if (str.equals("MISSING_CODE")) {
                    obj = 32;
                    break;
                }
                break;
            case 1226505451:
                if (str.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                    obj = 11;
                    break;
                }
                break;
            case 1388786705:
                if (str.equals("INVALID_IDENTIFIER")) {
                    obj = 5;
                    break;
                }
                break;
            case 1433767024:
                if (str.equals("USER_DISABLED")) {
                    obj = 4;
                    break;
                }
                break;
            case 1442968770:
                if (str.equals("INVALID_PHONE_NUMBER")) {
                    obj = 31;
                    break;
                }
                break;
            case 1494923453:
                if (str.equals("INVALID_APP_CREDENTIAL")) {
                    obj = 18;
                    break;
                }
                break;
            case 1497901284:
                if (str.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                    obj = 20;
                    break;
                }
                break;
            case 1803454477:
                if (str.equals("MISSING_CONTINUE_URI")) {
                    obj = 43;
                    break;
                }
                break;
            case 1898790704:
                if (str.equals("MISSING_SESSION_INFO")) {
                    obj = 34;
                    break;
                }
                break;
            case 2082564316:
                if (str.equals("UNSUPPORTED_TENANT_OPERATION")) {
                    obj = 48;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                i = FirebaseError.ERROR_NO_SUCH_PROVIDER;
                break;
            case 1:
                i = FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH;
                break;
            case 2:
                i = FirebaseError.ERROR_INVALID_CUSTOM_TOKEN;
                break;
            case 3:
                i = FirebaseError.ERROR_INVALID_CREDENTIAL;
                break;
            case 4:
                i = FirebaseError.ERROR_USER_DISABLED;
                break;
            case 5:
            case 6:
                i = FirebaseError.ERROR_INVALID_EMAIL;
                break;
            case 7:
            case 8:
                i = FirebaseError.ERROR_USER_NOT_FOUND;
                break;
            case 9:
                i = FirebaseError.ERROR_EMAIL_ALREADY_IN_USE;
                break;
            case 10:
                i = FirebaseError.ERROR_WRONG_PASSWORD;
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                i = FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE;
                break;
            case 12:
                i = FirebaseError.ERROR_INVALID_USER_TOKEN;
                break;
            case 13:
            case 14:
                i = FirebaseError.ERROR_NETWORK_REQUEST_FAILED;
                break;
            case 15:
                i = FirebaseError.ERROR_WEAK_PASSWORD;
                break;
            case 16:
            case 17:
                i = FirebaseError.ERROR_OPERATION_NOT_ALLOWED;
                break;
            case 18:
                i = FirebaseError.ERROR_APP_NOT_AUTHORIZED;
                break;
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                i = FirebaseError.ERROR_REQUIRES_RECENT_LOGIN;
                break;
            case 20:
            case 21:
                i = FirebaseError.ERROR_TOO_MANY_REQUESTS;
                break;
            case 22:
                i = FirebaseError.ERROR_USER_TOKEN_EXPIRED;
                break;
            case 23:
                i = 17030;
                break;
            case 24:
                i = 17029;
                break;
            case 25:
                i = 17031;
                break;
            case 26:
                i = 17032;
                break;
            case 27:
                i = 17033;
                break;
            case 28:
                i = 17034;
                break;
            case 29:
                i = 17035;
                break;
            case 30:
                i = 17041;
                break;
            case 31:
                i = 17042;
                break;
            case HTTP.SP /*32*/:
                i = 17043;
                break;
            case Encoder.DEFAULT_EC_PERCENT /*33*/:
                i = 17044;
                break;
            case 34:
                i = 17045;
                break;
            case 35:
                i = 17046;
                break;
            case 36:
                i = 17049;
                break;
            case LangUtils.HASH_OFFSET /*37*/:
                i = 17051;
                break;
            case 38:
                i = 17052;
                break;
            case 39:
                i = 17064;
                break;
            case 40:
                i = 17061;
                break;
            case 41:
                i = 17062;
                break;
            case 42:
                i = 17065;
                break;
            case 43:
                i = 17040;
                break;
            case 44:
                i = 17068;
                break;
            case 45:
                i = 17071;
                break;
            case 46:
                i = 17057;
                break;
            case 47:
                i = 17058;
                break;
            case 48:
                i = 17073;
                break;
            case 49:
                i = 17074;
                break;
            case 50:
                i = 17075;
                break;
            default:
                i = FirebaseError.ERROR_INTERNAL_ERROR;
                break;
        }
        if (i != FirebaseError.ERROR_INTERNAL_ERROR) {
            return new Status(i, str2);
        }
        if (str2 != null) {
            return new Status(i, new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(":").append(str2).toString());
        }
        return new Status(i, str);
    }
}
