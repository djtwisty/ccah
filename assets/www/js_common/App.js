/// <reference path="../js_localizations/MPResources.it-IT.js" />

/* New Staging server Authentication.*/
//var StageUrl = 'http://sapis.venpay.it/public/mpay/v1';


/* New Production server Authentication.*/
var StageUrl = 'https://apis.venpay.it/public/mpay/v1';


var ipAddressLink = 'http://www.telize.com/jsonip';
var isKillDueToDelayApp = false;
var _isPinValidation = false;//to check is redirect to pin validation screen.
var isRedirectToAppStore = false;

function Authorization() {
    var userId = window.localStorage.getItem("userId");
    if (userId <= 0) {
        window.location.href = 'login.html';
        return false;
    }
    return true;
}

function openNotification() {
    window.FirebasePlugin.onNotificationOpen(function (notification) {
        if ((notification.tap) && (notification.url != null && ((notification.url.toString().indexOf("https://") > -1) || (notification.url.toString().indexOf("http://") > -1)))) {
            window.localStorage.setItem('surveyLink', notification.url);
            window.location.href = 'survey.html';
            return false;
        }
        else {
            if ((window.localStorage.getItem('HasMoreThan16Years') === "false") || (window.localStorage.getItem('HasMoreThan16Years') === false) || (window.localStorage.getItem('HasMoreThan16Years') == null) || (window.localStorage.getItem('HasMoreThan16Years') == "null")) {
                window.location.href = "importantNotice.html";
            }
            else {

            }
        }
    }, function (error) {
        alert(error);
    });
}

function loadString() {

    var countryID = window.localStorage.getItem("CountryCode");

    if (countryID == 'it') {
        localFileName = "js_localizations/MPResources.it-IT.js";
    } else if (countryID == 'es') {
        localFileName = "js_localizations/MPResources.es-ES.js";
    }
    else if (countryID == 'en') {
        localFileName = "js_localizations/MPResources.js";
    }
    else if (countryID == 'fr') {
        localFileName = "js_localizations/MPResources.fr-FR.js";
    }
    else if (countryID == 'ca') {
        localFileName = "js_localizations/MPResources.ca-CA.js";
    }
    else {
        localFileName = "js_localizations/MPResources.js";
    }

    $.ajaxSetup({ async: false });
    $.getScript(localFileName);
    $.ajaxSetup({ async: true });

}

function getDeviceIp() {
    $.getJSON("https://api.ipify.org/?format=json",
	        function (data) {
	            window.localStorage.setItem("ipifyIp", data.ip);
	        });

    $.getJSON("http://jsonip.appspot.com",
               function (data) {
                   window.localStorage.setItem("jsonIp", data.ip);
               });

    /* funtion to get ip of device */
    $.getJSON("http://www.telize.com/jsonip",
            function (data) {
                window.localStorage.setItem("telizIp", data.ip);
            });
}

function ErrorMessasges(keyName) {

    if (keyName == null) {
        return null;
    }
    switch (keyName) {
        case 'UserNotExists':
            return Resources.UserNotExists;
            break;
        case 'UserIsDisabled':
            return Resources.UserIsDisabled
            break;
        case 'UserCanChangeOnlyHisData':
            return Resources.UserCanChangeOnlyHisData;
            break;
        case 'UserCredentialsAreIncorrect':
            return Resources.UserCredentialsAreIncorrect;
            break;
        case 'UserAlreadyHaveValidCard':
            return Resources.UserAlreadyHaveValidCard;
            break;
        case 'SPInitFirstTrxError':
            return Resources.SPInitFirstTrxError;
            break;
        case 'ServerError':
            return Resources.ServerError;
            break;
        case 'UserNotExistValidCard':
            return Resources.UserNotExistValidCard;
            break;
        case 'SPUnsubscribeCardError':
            return Resources.SPUnsubscribeCardError;
            break;
        case 'AppNotExists':
            return Resources.AppNotExists;
            break;
        case 'AppIsDisabled':
            return Resources.AppIsDisabled;
            break;
        case 'UserAlreadyEnabled':
            return Resources.UserAlreadyEnabled;
            break;
        case 'UserNotExistValidMobilePhone':
            return Resources.UserNotExistValidMobilePhone;
            break;
        case 'PinNotExists':
            return Resources.PinNotExists;
            break;
        case 'UserNameAlreadyExists':
            return Resources.UserNameAlreadyExists;
            break;
        case 'UserCanGetOnlyHisData':
            return Resources.UserCanGetOnlyHisData;
            break;
        case 'TrxAmountNotBetweenLimits':
            return Resources.TrxAmountNotBetweenLimits;
            break;
        case 'TooManyGwRelatedToVM':
            return Resources.TooManyGwRelatedToVM;
            break;
        case 'GwIsDisabled':
            return Resources.GwIsDisabled;
            break;
        case 'GwIsNotConnected':
            return Resources.GwIsNotConnected;
            break;
        case 'GwIsNotConfigured4MDB':
            return Resources.GwIsNotConfigured4MDB;
            break;
        case 'GwIsNotConfigured4Payment':
            return Resources.GwIsNotConfigured4Payment;
            break;
        case 'GwIsNotConfigured4Recharge':
            return Resources.GwIsNotConfigured4Recharge;
            break;
        case 'NoneGwRelatedToVM':
            return Resources.NoneGwRelatedToVM;
            break;
        case 'VMNotExists':
            return Resources.VMNotExists;
            break;
        case 'SPInitNthTrxError':
            return Resources.SPInitNthTrxError;
            break;
        case 'CmdToGwError':
            return Resources.CmdToGwError;
            break;
        case 'CreditCardDeleted':
            return Resources.CreditCardDeleted;
            break;
        case 'My_account_save_confirm':
            return Resources.My_account_save_confirm;
            break;
        case 'UserIsInUse':
            return Resources.UserIsInUse;
            break;
        case 'TabToChange':
            return Resources.TabToChange;
            break;
        case 'CaptchaMissmatch':
            return Resources.CaptchaMissmatch;
            break;
        case 'ClientCredentialsAreIncorrect':
            return Resources.ClientCredentialsAreIncorrect;
            break;
        case 'UserInfoUpdated':
            return Resources.UserInfoUpdated;
            break;
        case 'UserTimeExpired':
            return Resources.UserTimeExpired;
            break;
        case 'PasswordSendSucessfully':
            return Resources.PasswordSendSucessfully;
            break;
        case 'PasswordReset':
            return Resources.PasswordReset;
            break;
        case 'MobileNoToRetrivePwd':
            return Resources.MobileNoToRetrivePwd;
            break;
        case 'EnterMobileNumber':
            return Resources.EnterMobileNumber;
            break;
        case 'EnterValidMobileNumber':
            return Resources.EnterValidMobileNumber;
            break;
        case 'EnterPassword':
            return Resources.EnterPassword;
            break;
        case 'EnterConfirmPassword':
            return Resources.EnterConfirmPassword;
            break;
        case 'PasswordMissMatch':
            return Resources.PasswordMissMatch;
            break;
        case 'EnterCaptcha':
            return Resources.EnterCaptcha;
            break;
        case 'EnterUserName':
            return Resources.EnterUserName;
            break;
        case 'EnterSurName':
            return Resources.EnterSurName;
            break;
        case 'EnterCountryName':
            return Resources.EnterCountryName;
            break;
        case 'EnterEmailId':
            return Resources.EnterEmailId;
            break;
        case 'invalidEmail':
            return Resources.invalidEmail;
            break;
        case 'EnterValidEmail':
            return Resources.EnterValidEmail;
            break;
        case 'EnterValidPin':
            return Resources.EnterValidPin;
            break;
        case 'EnterfavVMCode':
            return Resources.EnterfavVMCode;
            break;
        case 'otherThan5digitsPIN':
            return Resources.otherThan5digitsPIN;
            break;
        case 'TrxInitError':
            return Resources.TrxInitError;
            break;
        case 'TrxAlreadyAlive':
            return Resources.TrxAlreadyAlive;
            break;
        case 'Password_minimum_lenght':
            return Resources.Password_minimum_lenght;
            break;
        case 'RegenerateSMS_confirmation':
            return Resources.RegenerateSMS_confirmation;
            break;
        case 'no_buy_available':
            return Resources.no_buy_available;
            break;
        case 'no_topup_available':
            return Resources.no_topup_available;
            break;
        case 'invalid_mobile_number':
            return Resources.invalid_mobile_number;
            break;
        case 'MaxPinCreationLimitReached':
            return Resources.MaxPinCreationLimitReached;
            break;
        case 'TransactionUnavailable':
            return Resources.TransactionUnavailable;
            break;
        case 'CPIBeginSessionFailure':
            return Resources.CPIBeginSessionFailure;
            break;
        case 'Password_max_lenght':
            return Resources.Password_max_lenght;
            break;
        case 'Password_requirement':
            return Resources.Password_requirement;
            break;
        case 'authorization_has_been_denied_4_this_request':
            return Resources.authorization_has_been_denied_4_this_request;
            break;
        default:
            return keyName;

    }
}

function Registration() {
    $("body").addClass('loading');
    this.Access_Token(this.RegistrationCallback);
}

function RegistrationCallback(status) {
    if (status == 'success') {
           window.localStorage.setItem("TokenExpire", GetTokenExpiration(cmn_GetValueOfTokenExpire() - 300));
        if (!_isPinValidation) {
            $("body").removeClass('loading');
            window.location.href = 'register.html';
        }
        else {
            window.localStorage.setItem("UserName", $('#mobileNumber').val().replace(' ', ''));
            cmn_EncyrptPassword("Password", $('#password').val());
            this.readUserInfoByName();
        }
    }
}

function readUserInfoByName() {
    var uname = encodeURIComponent(window.localStorage.getItem("UserName"));
    var url = StageUrl + '/users/?uname=' + uname;
    this._xhr = jQuery.ajax({
        method: 'GET',
        url: url,
        dataType: 'json',
        headers: {
            'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
        },

        success: function (data, status, jqXHR) {
            if (status == "success") {
                $("body").removeClass("loading");
                window.localStorage.setItem("Email", data.Email);
                if (!data.EmailConfirmed && !data.PhoneConfirmed) {
                    window.localStorage.setItem('callPinAPI', true);
                    window.location.href = "pin_validation.html";
                }
                else if (!data.PhoneConfirmed) {
                    window.localStorage.setItem('callPinAPI', true);
                    window.location.href = "pin_validation.html";
                }
                else if (!data.EmailConfirmed) {
                    window.location.href = "email-validation.html";
                } else if (data.EmailConfirmed && data.PhoneConfirmed) {
                    cmn_openModelPopup(ErrorMessasges('UserIsDisabled'), "", "", "");
                }
            }
        },

        error: function (jqXHR, status, error) {
            if (status == 'error') {
                $("body").removeClass("loading");
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }
        }
    });
}

function Access_Token(callBackfun) {
    var timeOutVar = setTimeout(function () {
        isKillDueToDelayApp = true;
        cmn_openModelPopup(ErrorMessasges("UserTimeExpired"), "", "", "");
    }, 15000);

    try {
        var status = cmn_AuthenticationAPIByRecoveringToken();

        if (status = "success") {
            clearTimeout(timeOutVar);
            if (!isKillDueToDelayApp) {
                callBackfun(status)
            } else {
                isKillDueToDelayApp = false;
            }
        }
        else {
            if (isKillDueToDelayApp) {
                isKillDueToDelayApp = false;
                return false;
            }

            $("body").removeClass("loading");
            cmn_openModelPopup(ErrorMessasges(status), "", "", "");
        }
    }
    catch (ex) {

    }
}

function RememberMe() {
    if ($('#rememberme').prop('checked') || window.localStorage.getItem('rememberMe') === 'true') {
        window.localStorage.setItem('_phoneNumber', $('#mobileNumber').val());
        cmn_EncyrptPassword("_password", $('#password').val());     
        window.localStorage.setItem('RememberPwd', 'checked');
    }
    else {
        window.localStorage.removeItem("_phoneNumber");
        window.localStorage.removeItem("_phoneNumber");
        $('#rememberme').attr('checked', false);
        window.localStorage.setItem('RememberPwd', 'unChecked');
        window.localStorage.setItem("continueLogin", 'No');
    }
}

function GetTokenExpiration(expir_in) {
    var expirIn = Math.floor(expir_in / 60);
    var cTime = new Date();
    cTime.setMinutes(cTime.getMinutes() + expirIn);
    return cTime;
}

function CheckTokenExpiration(expTime) {
    if (cmn_GetValuesFromAndroidFunction("TokenExpire") === null || cmn_GetValuesFromAndroidFunction("TokenExpire") === "") {
        return true;
    }
    var expDate = new Date(expTime);
    var currentDate = new Date();
    var cTime = new Date();

    var expTimeUTC = Date.UTC(expDate.getYear(), expDate.getMonth(), expDate.getDate(), expDate.getHours(), expDate.getMinutes(), expDate.getSeconds());
    var cTimeUTC = Date.UTC(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate(), currentDate.getHours(), currentDate.getMinutes(), currentDate.getSeconds());
    if (cTimeUTC > expTimeUTC) {
        return false;
    } else {
        return true;
    }
}
function IsTokenExpiration(expTime, extraSec) {
    if (cmn_GetValuesFromAndroidFunction("TokenExpire") === null || cmn_GetValuesFromAndroidFunction("TokenExpire") === "") {
        return true;
    }
    var expDate = new Date(expTime);
    var expirIn = Math.floor(extraSec / 60);
    expDate.setMinutes(expDate.getMinutes() + expirIn);
    var currentDate = new Date();
    var cTime = new Date();

    var expTimeUTC = Date.UTC(expDate.getYear(), expDate.getMonth(), expDate.getDate(), expDate.getHours(), expDate.getMinutes(), expDate.getSeconds());
    var cTimeUTC = Date.UTC(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate(), currentDate.getHours(), currentDate.getMinutes(), currentDate.getSeconds());
    if (cTimeUTC > expTimeUTC) {
        return true;
    } else {
        return false;
    }
}
function RedirectOnTokenExp(lblmsg) {
    cmn_openModelPopup(ErrorMessasges("UserTimeExpired"), "", "", "");
}

/*Method to check promo pup-up*/
function checkPromoPupUp() {
    var url = StageUrl + '/notifications/newer/count?notificationtype=3 ';
    var timeOutVar = setTimeout(function () {
        cmn_openModelPopup(ErrorMessasges("UserTimeExpired"), "", "", "");
    }, 15000);

    this._xhr = jQuery.ajax({
        method: 'GET',
        url: url,

        dataType: 'json',
        contentType: 'application/json',
        headers: {
            'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
        },
        success: function (data, status, jqXHR) {
            if (status == "success") {
                clearTimeout(timeOutVar);
                if (data.Total > 0) {
                    window.location.href = 'login_promo.html';
                } else {
                    setHomePage();
                }
            }
        },
        error: function (jqXHR, status, error) {
            $("body").removeClass("loading");
            clearTimeout(timeOutVar);
            window.location.href = 'home.html';
        }
    });
}

/*Method to set credit or wallet as home page.*/
function setHomePage() {
    if (window.localStorage.getItem("notificationType") === "1") {
        window.location.href = 'home.html';
    }
    else if (window.localStorage.getItem("scannerLaunch") != 'true') {
        window.location.href = 'home.html';
    }
    else {
        window.localStorage.setItem("isScannButtonClicked", "true")
        $("body").addClass("whiteLoading");
        if (window.localStorage.getItem('isFlashEnable') === 'true') {
            cordova.plugins.barcodeScanner.scan(
              function (result) {
                  scannResult(result);
              },
       function (error) {
           if (error == "Illegal access") {

           }
           else {
               alert("Scanning failed: " + error);
           }
       }, {
           torchOn: true, // Android, launch with the torch switched on (if available)
           orientation: "portrait", // Android only (portrait|landscape), default unset so it rotates with the device
       });
        }
        else {
            cordova.plugins.barcodeScanner.scan(
             function (result) {
                 scannResult(result);
             },
      function (error) {
          if (error == "Illegal access") {

          }
          else {
              alert("Scanning failed: " + error);
          }
      },
        {
            orientation: "portrait", // Android only (portrait|landscape), default unset so it rotates with the device
        });
        }
    }
}

function scannResult(result) {
    var _vmcode = return_scan_qrcode(result.text);
    if (result.cancelled) {
        window.location.href = "home.html";
    }
    else if (window.localStorage.getItem("PaymentMode") === "CreditCard") {
        cmn_GetAccessAndExpirationToken(_vmcode, "", "", "card", "scanner");
    } else if (window.localStorage.getItem("PaymentMode") === "wallet") {
        cmn_GetAccessAndExpirationToken(_vmcode, "", "", "wallet", "scanner");
    }
}

function getCreditCardInfo() {
    var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/cards';
    this._xhr = jQuery.ajax({
        method: 'GET',
        url: url,
        dataType: 'json',
        contentType: 'application/json',
        headers: {
            'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
        },
        success: function (data, status, jqXHR) {
            if (status == "success") {
                if (data['Cards'] != null && data['Cards'][0]['IsEnabled'] == true) {
                    window.localStorage.setItem("CreditCardInfoSave", "true");
                } else {
                    window.localStorage.setItem("CreditCardInfoSave", "false");

                }
                loadString();
                $("body").removeClass("loading");
            }
        },
        error: function (jqXHR, status, error) {
            $("body").removeClass("loading");
            if (jqXHR.responseJSON.ErrorCode === undefined) {
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
            }
            else {
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        }
    });
}

function cmn_checkConnection() {
    //return true;     /*UnComment when used to debug in browser*/
    var networkState = navigator.connection.type;
    var states = {};
    states[Connection.UNKNOWN] = 'Unknown connection';
    states[Connection.ETHERNET] = 'Ethernet connection';
    states[Connection.WIFI] = 'WiFi connection';
    states[Connection.CELL_2G] = 'Cell 2G connection';
    states[Connection.CELL_3G] = 'Cell 3G connection';
    states[Connection.CELL_4G] = 'Cell 4G connection';
    states[Connection.CELL] = 'Cell generic connection';
    states[Connection.NONE] = 'No network connection';
    if (states[networkState] == 'No network connection') {
        cmn_openModelPopup(Resources.no_connection_alert_line1, Resources.no_connection_alert_line2, "", "left");
        return false;
    }
    else {
        return true;
    }
}

function cmn_removeLocalStorages() {
    window.localStorage.removeItem('currentBalance');
    window.localStorage.removeItem("PaymentType");
    window.localStorage.removeItem("TokenExpire");
    window.localStorage.removeItem("_errorMessage");
    window.localStorage.removeItem("jsonIp");
    window.localStorage.removeItem("telizIp");
    window.localStorage.removeItem("VendingId");
    window.localStorage.removeItem("UserUId");
    window.localStorage.removeItem("FirstName");
    window.localStorage.removeItem("SurName");
    window.localStorage.removeItem("Email");
    window.localStorage.removeItem("Country");
    window.localStorage.removeItem("PinId");
    window.localStorage.removeItem("CreditCardId");
    window.localStorage.removeItem("captchaValue");
    window.localStorage.removeItem("CreditCardInfoSave");
    window.localStorage.removeItem("favVMCodeToSave");
    window.localStorage.removeItem("favVMCode");
    window.localStorage.removeItem('PhoneConfirmed');
    window.localStorage.removeItem('EmailConfirmed');
    window.localStorage.removeItem('takeBackGround');
    window.localStorage.removeItem('isRefreshHome');
    window.localStorage.removeItem("AppVersion");
    window.localStorage.removeItem("RandomNo");
    window.localStorage.removeItem("EnablePaymentCard");
    window.localStorage.removeItem("EnablePaymentWallet");
    window.localStorage.removeItem("ToDetails");
    window.localStorage.removeItem("ToPostBonus");
    window.localStorage.removeItem("HasAcceptedTAndC");
    window.localStorage.removeItem("AcceptPrivacy");
    window.localStorage.removeItem("HasMoreThan16Years");

    window.localStorage.removeItem("BottomLink");
    window.localStorage.removeItem("PvtWalletScreen");
    window.localStorage.removeItem("LastTransactionId");
    //window.localStorage.removeItem("PaymentIssue");

    window.localStorage.removeItem("CoffeeCappName");
    window.localStorage.removeItem("CoffeeCappBalance");
    window.localStorage.removeItem('showConnectionAlert');
    window.localStorage.removeItem("MerchantType");
    window.localStorage.removeItem("MerchantData");
    window.localStorage.removeItem("MerchantName1");
    window.localStorage.removeItem("MerchantBalance1");
    window.localStorage.removeItem("MerchantName2");
    window.localStorage.removeItem("MerchantBalance2");
    window.localStorage.removeItem('showBalanceAlert');
    window.localStorage.removeItem('VMSpecificMerchant');

    window.localStorage.removeItem("showSharedWallet");
    window.localStorage.removeItem("showSharedWalletAlert");

    window.localStorage.removeItem("isRedirectToAppStore");
    window.localStorage.removeItem("fromIssueReport");
}



function getdeviceDetails() {
    window.localStorage.setItem("CordovaVersion", device.cordova);
    window.localStorage.setItem("Model", device.model);
    window.localStorage.setItem("Platform", device.platform);
    window.localStorage.setItem("uuid", device.uuid);
    window.localStorage.setItem("AndroidVersion", device.version);
    window.localStorage.setItem("Manufacturer", device.manufacturer);
    window.localStorage.setItem("AppVersion", AppVersion.version);
    window.plugins.sim.getSimInfo(successCallback, errorCallback);
}


function successCallback(result) {
    window.localStorage.removeItem("CarrierName");
    window.localStorage.removeItem("CarrierName2");
    if (result.deviceId === null || typeof result.deviceId === "undefined" || result.deviceId.toUpperCase() === "NULL") {
        if (window.localStorage.getItem("RandomNo") == null) {
            var digits = Math.floor(Math.random() * 900000000000) + 100000000000;
            digits = "GEN" + digits;
            window.localStorage.setItem("RandomNo", digits);
        }
        window.localStorage.setItem("UDI", device.uuid);
    }
    else {
        window.localStorage.setItem("UDI", result.deviceId);
    }
    if (result["cards"] === undefined) {
        window.localStorage.setItem("CarrierName", "*NONE*");
        window.localStorage.setItem("CarrierName2", "*NONE*");
        return false;
    }
    else {
        for (i = 0; i < result["cards"].length; i++) {
            if (i === 0) {
                window.localStorage.setItem("CarrierName", result["cards"][i]['carrierName']);
            } else {
                window.localStorage.setItem("CarrierName2", result["cards"][i]['carrierName']);
            }
        }
    }
}


function errorCallback(error) {
    alert(error);
}


function getFirebaseToken() {
    window.FirebasePlugin.getToken(function (token) {
        window.localStorage.setItem('token', token);
    }, function (error) {
        alert(error);
    });
}

function fullScreen() {
    AndroidFullScreen.immersiveMode(successFunction, errorFunction);
}

function successFunction(result) {
    //alert(result);
}


function errorFunction(error) {
    alert(error);
}

