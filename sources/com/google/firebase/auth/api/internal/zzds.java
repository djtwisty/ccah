package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseError;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.zzd;
import com.google.firebase.auth.zzq;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

public final class zzds {
    @VisibleForTesting
    private static final SparseArray<Pair<String, String>> zzmi;

    public static FirebaseException zzb(Status status) {
        int statusCode = status.getStatusCode();
        String zza = zza(zze(statusCode), status);
        switch (statusCode) {
            case FirebaseError.ERROR_INVALID_CUSTOM_TOKEN /*17000*/:
            case FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH /*17002*/:
            case FirebaseError.ERROR_INVALID_CREDENTIAL /*17004*/:
            case FirebaseError.ERROR_INVALID_EMAIL /*17008*/:
            case FirebaseError.ERROR_WRONG_PASSWORD /*17009*/:
            case FirebaseError.ERROR_USER_MISMATCH /*17024*/:
            case 17034:
            case 17035:
            case 17041:
            case 17042:
            case 17043:
            case 17044:
            case 17045:
            case 17046:
            case 17049:
            case 17051:
            case 17075:
                return new FirebaseAuthInvalidCredentialsException(zzd(statusCode), zza);
            case FirebaseError.ERROR_USER_DISABLED /*17005*/:
            case FirebaseError.ERROR_USER_NOT_FOUND /*17011*/:
            case FirebaseError.ERROR_INVALID_USER_TOKEN /*17017*/:
            case FirebaseError.ERROR_USER_TOKEN_EXPIRED /*17021*/:
                return new FirebaseAuthInvalidUserException(zzd(statusCode), zza);
            case FirebaseError.ERROR_OPERATION_NOT_ALLOWED /*17006*/:
            case FirebaseError.ERROR_APP_NOT_AUTHORIZED /*17028*/:
            case 17040:
            case 17064:
            case 17068:
            case 17071:
            case 17072:
            case 17073:
            case 17074:
                return new FirebaseAuthException(zzd(statusCode), zza);
            case FirebaseError.ERROR_EMAIL_ALREADY_IN_USE /*17007*/:
            case FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL /*17012*/:
            case FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE /*17025*/:
                return new FirebaseAuthUserCollisionException(zzd(statusCode), zza);
            case FirebaseError.ERROR_TOO_MANY_REQUESTS /*17010*/:
                return new FirebaseTooManyRequestsException(zza("We have blocked all requests from this device due to unusual activity. Try again later.", status));
            case FirebaseError.ERROR_REQUIRES_RECENT_LOGIN /*17014*/:
                return new FirebaseAuthRecentLoginRequiredException(zzd(statusCode), zza);
            case FirebaseError.ERROR_PROVIDER_ALREADY_LINKED /*17015*/:
                return new FirebaseException(zza("User has already been linked to the given provider.", status));
            case FirebaseError.ERROR_NO_SUCH_PROVIDER /*17016*/:
                return new FirebaseException(zza("User was not linked to an account with the given provider.", status));
            case FirebaseError.ERROR_NETWORK_REQUEST_FAILED /*17020*/:
                return new FirebaseNetworkException(zza("A network error (such as timeout, interrupted connection or unreachable host) has occurred.", status));
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
                return new FirebaseAuthWeakPasswordException(zzd(statusCode), zza, status.getStatusMessage());
            case 17029:
            case 17030:
                return new FirebaseAuthActionCodeException(zzd(statusCode), zza);
            case 17031:
            case 17032:
            case 17033:
                return new FirebaseAuthEmailException(zzd(statusCode), zza);
            case 17052:
                return new FirebaseTooManyRequestsException(zza);
            case 17057:
            case 17058:
            case 17062:
            case 17065:
                return new zzq(zzd(statusCode), zza);
            case 17061:
                return new FirebaseNetworkException(zza("There was a failure in the connection between the web widget and the Firebase Auth backend.", status));
            case 17063:
                return new FirebaseApiNotAvailableException(zza);
            case FirebaseError.ERROR_NO_SIGNED_IN_USER /*17495*/:
                return new FirebaseNoSignedInUserException(zza("Please sign in before trying to get a token.", status));
            case FirebaseError.ERROR_INTERNAL_ERROR /*17499*/:
                return new FirebaseException(zza("An internal error has occurred.", status));
            default:
                return new FirebaseException("An internal error has occurred.");
        }
    }

    public static FirebaseAuthUserCollisionException zza(Status status, AuthCredential authCredential, String str) {
        int statusCode = status.getStatusCode();
        FirebaseAuthUserCollisionException firebaseAuthUserCollisionException = new FirebaseAuthUserCollisionException(zzd(statusCode), zza(zze(statusCode), status));
        if ((authCredential instanceof zzd) && ((zzd) authCredential).zzay() == null && (authCredential.getProvider().equals("yahoo.com") || authCredential.getProvider().equals("hotmail.com"))) {
            return firebaseAuthUserCollisionException;
        }
        return firebaseAuthUserCollisionException.zza(authCredential).zzbo(str);
    }

    private static String zza(String str, Status status) {
        if (TextUtils.isEmpty(status.getStatusMessage())) {
            return str;
        }
        return String.format(String.valueOf(str).concat(" [ %s ]"), new Object[]{status.getStatusMessage()});
    }

    private static String zzd(int i) {
        Pair pair = (Pair) zzmi.get(i);
        return pair != null ? (String) pair.first : "INTERNAL_ERROR";
    }

    private static String zze(int i) {
        Pair pair = (Pair) zzmi.get(i);
        return pair != null ? (String) pair.second : "An internal error has occurred.";
    }

    static {
        SparseArray sparseArray = new SparseArray();
        zzmi = sparseArray;
        sparseArray.put(FirebaseError.ERROR_INVALID_CUSTOM_TOKEN, new Pair("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation."));
        zzmi.put(FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH, new Pair("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience."));
        zzmi.put(FirebaseError.ERROR_INVALID_CREDENTIAL, new Pair("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired."));
        zzmi.put(FirebaseError.ERROR_INVALID_EMAIL, new Pair("ERROR_INVALID_EMAIL", "The email address is badly formatted."));
        zzmi.put(FirebaseError.ERROR_WRONG_PASSWORD, new Pair("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password."));
        zzmi.put(FirebaseError.ERROR_USER_MISMATCH, new Pair("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user."));
        zzmi.put(FirebaseError.ERROR_REQUIRES_RECENT_LOGIN, new Pair("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request."));
        zzmi.put(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL, new Pair("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."));
        zzmi.put(FirebaseError.ERROR_EMAIL_ALREADY_IN_USE, new Pair("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account."));
        zzmi.put(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE, new Pair("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account."));
        zzmi.put(FirebaseError.ERROR_USER_DISABLED, new Pair("ERROR_USER_DISABLED", "The user account has been disabled by an administrator."));
        zzmi.put(FirebaseError.ERROR_USER_TOKEN_EXPIRED, new Pair("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again."));
        zzmi.put(FirebaseError.ERROR_USER_NOT_FOUND, new Pair("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted."));
        zzmi.put(FirebaseError.ERROR_INVALID_USER_TOKEN, new Pair("ERROR_INVALID_USER_TOKEN", "This user's credential isn't valid for this project. This can happen if the user's token has been tampered with, or if the user isn't for the project associated with this API key."));
        zzmi.put(FirebaseError.ERROR_OPERATION_NOT_ALLOWED, new Pair("ERROR_OPERATION_NOT_ALLOWED", "The given sign-in provider is disabled for this Firebase project. Enable it in the Firebase console, under the sign-in method tab of the Auth section."));
        zzmi.put(FirebaseError.ERROR_WEAK_PASSWORD, new Pair("ERROR_WEAK_PASSWORD", "The given password is invalid."));
        zzmi.put(17029, new Pair("ERROR_EXPIRED_ACTION_CODE", "The out of band code has expired."));
        zzmi.put(17030, new Pair("ERROR_INVALID_ACTION_CODE", "The out of band code is invalid. This can happen if the code is malformed, expired, or has already been used."));
        zzmi.put(17031, new Pair("ERROR_INVALID_MESSAGE_PAYLOAD", "The email template corresponding to this action contains invalid characters in its message. Please fix by going to the Auth email templates section in the Firebase Console."));
        zzmi.put(17033, new Pair("ERROR_INVALID_RECIPIENT_EMAIL", "The email corresponding to this action failed to send as the provided recipient email address is invalid."));
        zzmi.put(17032, new Pair("ERROR_INVALID_SENDER", "The email template corresponding to this action contains an invalid sender email or name. Please fix by going to the Auth email templates section in the Firebase Console."));
        zzmi.put(17034, new Pair("ERROR_MISSING_EMAIL", "An email address must be provided."));
        zzmi.put(17035, new Pair("ERROR_MISSING_PASSWORD", "A password must be provided."));
        zzmi.put(17041, new Pair("ERROR_MISSING_PHONE_NUMBER", "To send verification codes, provide a phone number for the recipient."));
        zzmi.put(17042, new Pair("ERROR_INVALID_PHONE_NUMBER", "The format of the phone number provided is incorrect. Please enter the phone number in a format that can be parsed into E.164 format. E.164 phone numbers are written in the format [+][country code][subscriber number including area code]."));
        zzmi.put(17043, new Pair("ERROR_MISSING_VERIFICATION_CODE", "The Phone Auth Credential was created with an empty sms verification Code"));
        zzmi.put(17044, new Pair("ERROR_INVALID_VERIFICATION_CODE", "The sms verification code used to create the phone auth credential is invalid. Please resend the verification code sms and be sure use the verification code provided by the user."));
        zzmi.put(17045, new Pair("ERROR_MISSING_VERIFICATION_ID", "The Phone Auth Credential was created with an empty verification ID"));
        zzmi.put(17046, new Pair("ERROR_INVALID_VERIFICATION_ID", "The verification ID used to create the phone auth credential is invalid."));
        zzmi.put(17049, new Pair("ERROR_RETRY_PHONE_AUTH", "An error occurred during authentication using the PhoneAuthCredential. Please retry authentication."));
        zzmi.put(17051, new Pair("ERROR_SESSION_EXPIRED", "The sms code has expired. Please re-send the verification code to try again."));
        zzmi.put(17052, new Pair("ERROR_QUOTA_EXCEEDED", "The sms quota for this project has been exceeded."));
        zzmi.put(FirebaseError.ERROR_APP_NOT_AUTHORIZED, new Pair("ERROR_APP_NOT_AUTHORIZED", "This app is not authorized to use Firebase Authentication. Please verifythat the correct package name and SHA-1 are configured in the Firebase Console."));
        zzmi.put(17063, new Pair("ERROR_API_NOT_AVAILABLE", "The API that you are calling is not available on devices without Google Play Services."));
        zzmi.put(17062, new Pair("ERROR_WEB_INTERNAL_ERROR", "There was an internal error in the web widget."));
        zzmi.put(17064, new Pair("ERROR_INVALID_CERT_HASH", "There was an error while trying to get your package certificate hash."));
        zzmi.put(17065, new Pair("ERROR_WEB_STORAGE_UNSUPPORTED", "This browser is not supported or 3rd party cookies and data may be disabled."));
        zzmi.put(17040, new Pair("ERROR_MISSING_CONTINUE_URI", "A continue URL must be provided in the request."));
        zzmi.put(17068, new Pair("ERROR_DYNAMIC_LINK_NOT_ACTIVATED", "Please activate Dynamic Links in the Firebase Console and agree to the terms and conditions."));
        zzmi.put(17071, new Pair("ERROR_INVALID_PROVIDER_ID", "The provider ID provided for the attempted web operation is invalid."));
        zzmi.put(17057, new Pair("ERROR_WEB_CONTEXT_ALREADY_PRESENTED", "A headful operation is already in progress. Please wait for that to finish."));
        zzmi.put(17058, new Pair("ERROR_WEB_CONTEXT_CANCELED", "The web operation was canceled by the user."));
        zzmi.put(17072, new Pair("ERROR_TENANT_ID_MISMATCH", "The provided user's tenant ID does not match the Auth instance's tenant ID."));
        zzmi.put(17073, new Pair("ERROR_UNSUPPORTED_TENANT_OPERATION", "This operation is not supported in a multi-tenant context."));
        zzmi.put(17074, new Pair("ERROR_INVALID_DYNAMIC_LINK_DOMAIN", "The provided dynamic link domain is not configured or authorized for the current project."));
        zzmi.put(17075, new Pair("ERROR_REJECTED_CREDENTIAL", "The request contains malformed or mismatching credentials"));
    }
}
