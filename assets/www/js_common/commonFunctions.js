var isLock = false;
var isRedirctToLogin = false;
var repTimer = 50;
var sPath = window.location.pathname;
var transactionTimeout;
var sPage = sPath.substring(sPath.lastIndexOf('/') + 1);

document.addEventListener("backbutton", onBackKeyDown, false);

function onBackKeyDown() {
    if (sPage === "login.html" || sPage === "wallet-confirm.html" || sPage === "creditcard-confirm.html" || sPage === "close_creditcardConnection.html" || sPage === "close_walletConnection.html" || sPage === "scanner_Layer1.html") {
        e.preventDefault();
        return false;
    }
    else if (sPage === "pin_validation.html") {
        window.location.href = "login.html";
        return false;
    }
    else if (sPage === "close_walletConnection.html") {
        e.preventDefault();
        return false;
    }
    else if (sPage == "home.html") {
        window.localStorage.setItem("takeBackGround", 'true');
        navigator.app.exitApp();
        return;
    }
    history.go(-1);
    navigator.app.backHistory();
}

/*Method to Check QR Code*/
function return_scan_qrcode(post) {

    if (post.indexOf('https://') > -1 || post.indexOf('http://') > -1) {
        var qrcode_url = post.slice(post.indexOf('/stickers/') + 10).split('?')[0];
        return qrcode_url
    }
    else {
        return post;
    }
}


/*Method to launch qr sacnner on wallet/card button.*/
function cmn_launchCameraForHome(page) {
    $("body").addClass("whiteLoading");
    if (window.localStorage.getItem('isFlashEnable') === 'true') {
        cordova.plugins.barcodeScanner.scan(
               function (result) {
                   scannResultonlaunchCamera(result, page)
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
                   scannResultonlaunchCamera(result, page)
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

function scannResultonlaunchCamera(result, page) {
    var _vmcode = return_scan_qrcode(result.text);
    if (result.cancelled && (page == "CreditCard")) {
        window.location.href = "home.html";
    }
    else if (result.cancelled && (page == "wallet")) {
        $("body").addClass("whiteLoading");
        window.location.href = "home.html";
    } else
        if (page == "CreditCard") {
            cmn_setPaymentMode(_vmcode, "", "", "card", "scanner");
        } else if (page == "wallet") {
            cmn_setPaymentMode(_vmcode, "", "", "wallet", "scanner");
        }
        else {
            window.location.href = 'home.html';
        }
}


/*Method to launch camera after comming in front from background 
and scann and redirect to selected home. */
function cmn_launchCameraOnResume() {
    if (window.localStorage.getItem("isScannButtonClicked") == "false") {
        if (window.localStorage.getItem("scannerLaunch") != 'true') {
            window.location.href = 'home.html';
        }
        else {
            if (window.localStorage.getItem('isFlashEnable') === 'true') {
                cordova.plugins.barcodeScanner.scan(
                     function (result) {
                         scannResultOnCameraResume(result);
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
            } else {
                cordova.plugins.barcodeScanner.scan(
                      function (result) {
                          scannResultOnCameraResume(result);
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
    else {
        $("body").removeClass("whiteLoading");
        $("body").removeClass("imageLoading");
        window.localStorage.setItem("isScannButtonClicked", "false");
    }
}

function scannResultOnCameraResume(result) {
    var _vmcode = return_scan_qrcode(result.text);
    if (result.cancelled) {
        window.location.href = "home.html";
    }
    else if (window.localStorage.getItem("PaymentMode") === "CreditCard") {
        cmn_setPaymentMode(_vmcode, "", "", "card", "scanner");
    } else if (window.localStorage.getItem("PaymentMode") === "wallet") {
        cmn_setPaymentMode(_vmcode, "", "", "wallet", "scanner");
    }
    else {
        window.location.href = 'home.html';
    }
}

/*Method to save favorite VM*/
function cmn_saveVMCode(favCode) {
    if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
        window.location.href = "login.html";
    }
    else {
        if (window.localStorage.getItem("favVMCode") !== null) {
            $("body").addClass("loading");
            document.addEventListener("deviceready", deleteContents, false);
            window.localStorage.setItem("favVMCode", favCode);
            setTimeout(function () {
                document.addEventListener("deviceready", writeToFile, false);
                cmn_openModelPopup(Resources.favVMCodeCorrect, "", "", "");
                $("#extFavli").removeClass('disable_div');
                $("#favCodeLink").html(Resources.Home_Wallet_label04_alt);
            }, 2000);
            $("body").removeClass("loading");
        }
        else {
            window.localStorage.setItem("favVMCode", favCode);
            document.addEventListener("deviceready", writeToFile, false);
            cmn_openModelPopup(Resources.favVMCodeCorrect, "", "", "");
            $("#extFavli").removeClass('disable_div');
            $("#favCodeLink").html(Resources.Home_Wallet_label04_alt);
            $("body").removeClass("loading");
        }
    }
}

function cmn_setPaymentMode(cval, divCtr, btnCtr, silo, scanner) {
    /*Check for network Connection*/
    if (!cmn_checkConnection()) {
        isRedirctToLogin = true;
        return false;
    }
    //alert(window.localStorage.getItem("fromIssueReport"));
    cmn_getRefreshTokenScanningCode(cval, divCtr, btnCtr, silo, scanner);

}





function api_CalltoValidateVM(cval, divCtr, btnCtr, silo, scanner) {
    var accessToken = cmn_GetValuesFromAndroidFunction("AccessToken");
    if (cval.length == 5) {
        document.activeElement.blur();
        if (silo == 'wallet' && scanner == "scanner") {
            cmn_connect_toVM(cval);
            return false;
        }
        else if (silo == 'card' && scanner == "scanner") {
            if (window.localStorage.getItem("CreditCardInfoSave") != null && window.localStorage.getItem("CreditCardInfoSave") === "true") {
                window.localStorage.setItem("VendingId", cval);
                var amount = 5.00 * 1000;
                cmn_payAmount(amount, 'payment');
                return false;
            } else {
                window.location.href = 'creditcardInfo.html';
            }
        } else {
            $(".autocomplete-suggestions").css("display", "none");
            $("body").addClass("loading");

            window.localStorage.setItem("VendingId", cval);
            var url = StageUrl + '/vmachines/' + cval + '/settings';

            $.ajax({
                method: 'GET',
                url: url,
                dataType: "json",
                headers: {
                    'Authorization': accessToken
                },
                success: function (data, status, jqXHR) {
                    cmn_setPreviousCode(cval, "#payCode");
                    readJsonData(data, status, cval, divCtr, btnCtr, silo, scanner);
                },
                error: function (data, status, jqXHR) {
                    $("body").removeClass("imageLoading");
                    $("body").removeClass("loading");
                    window.localStorage.setItem('ErroinVM', data.responseJSON.ErrorCode);
                    if (silo == 'card') {
                        if (window.localStorage.getItem("fromIssueReport") == "true") {
                            window.location.href = "issue_reporting.html";
                        }
                        else {
                            window.location.href = 'home.html';
                        }
                        return;
                    } else if (silo == 'wallet') {
                        if (window.localStorage.getItem("fromIssueReport") == "true") {
                            window.location.href = "issue_reporting.html";
                        }
                        else {
                            window.location.href = 'home.html';
                        }
                        return;
                    }
                    else {
                        window.localStorage.removeItem('ErroinVM');
                        return;
                    }
                }
            });
        }
    }
    else {
        if (silo == 'card' && scanner == "scanner" && cval.length > 0) {
            window.localStorage.setItem('ErroinVM', "VMNotExists");
            window.location.href = "home.html";
        }
        if (silo == 'wallet' && scanner == "scanner" && cval.length > 0) {
            window.localStorage.setItem('ErroinVM', "VMNotExists");
            window.location.href = "home.html";
        }

        if (window.localStorage.getItem("fromIssueReport") == "true") {
            if ((silo == 'wallet' || silo == 'card') && scanner == "" && cval.length > 0) {
                window.localStorage.setItem('ErroinVM', "VMNotExists");
                window.location.href = "issue_reporting.html";
            }
        }

        if (window.localStorage.getItem("favVMCode") !== null && cval.length === 0) {
            $("#favli").removeClass('disable_div');
            $("body").removeClass("imageLoading");
            $("body").removeClass("loading");
        }

        $(btnCtr).prop('disabled', true);
        $(btnCtr).addClass('disable_btn');
        $("#favli").addClass('disable_div');
        $("body").removeClass("imageLoading");
        $("body").removeClass("loading");
    }
}

/*Methdo  to set buy and pay buttons enable/disable as per VM code status.*/
function readJsonData(data, status, cval, divCtr, btnCtr, silo, scanner) {
    var hasReadData = false;
    if (status == "success") {
        for (i = 0; i < data["Configurations"].length; i++) {
            if (data["Configurations"][i]["Key"] == "GwIsConfigured4MDB" && data["Configurations"][i]["Value"] == 'false') {
                hasReadData = false;
                $("body").removeClass("imageLoading");
                $("body").removeClass("loading");
                break;
            }
            else if (data["Configurations"][i]["Key"] == "GwIsEnabled" && data["Configurations"][i]["Value"] == 'false') {
                hasReadData = true;
                if (scanner == "scanner" && silo == 'card') {
                    window.localStorage.setItem('ErroinVM', "GwIsDisabled");
                    window.location.href = "home.html";
                }
                else if (scanner == "scanner" && silo == 'wallet') {
                    window.localStorage.setItem('ErroinVM', "GwIsDisabled");
                    window.location.href = "home.html";
                }
                else {
                    $("body").removeClass("imageLoading");
                    $("body").removeClass("loading");
                    $(btnCtr).prop('disabled', 'disabled');
                    $(btnCtr).addClass('disable_btn');
                    $("#favli").addClass('disable_div');
                    cmn_openModelPopup(ErrorMessasges('GwIsDisabled'), "", "", "");
                    break;
                }
            }
            else if (silo == 'card' && (data["Configurations"][i]["Key"] == "GwIsConfigured4Payment" && data["Configurations"][i]["Value"] == 'true')) {
                hasReadData = true;
                if (scanner == "scanner") {
                    if (window.localStorage.getItem("CreditCardInfoSave") != null && window.localStorage.getItem("CreditCardInfoSave") === "true") {
                        var amount = 5.00 * 1000;
                        cmn_payAmount(amount, 'payment');
                        return;
                    } else {
                        window.location.href = 'creditcardInfo.html';
                    }

                } else {
                    $(btnCtr).prop('disabled', false);
                    $(btnCtr).removeClass('disable_btn');
                    $("#favli").removeClass('disable_div');
                    $("body").removeClass("imageLoading");
                    $("body").removeClass("loading");
                }
            }
            else if (silo == 'wallet' && (data["Configurations"][i]["Key"] == "GwIsConfigured4Wallet" && data["Configurations"][i]["Value"] == 'true')) {
                hasReadData = true;
                if (scanner == "scanner") {
                    cmn_connect_toVM(cval);
                    return;
                }
                else {
                    $(btnCtr).prop('disabled', false);
                    $(btnCtr).removeClass('disable_btn');
                    $("#favli").removeClass('disable_div');
                    $("body").removeClass("imageLoading");
                    $("body").removeClass("loading");
                }
            }
        }
        if (!hasReadData) {
            if (window.localStorage.getItem("PaymentMode") === "CreditCard") {
                window.localStorage.setItem('ErroinVM', ErrorMessasges('no_buy_available'));
                window.location.href = "home.html";
            }
            else if (window.localStorage.getItem("PaymentMode") === "wallet") {
                window.localStorage.setItem('ErroinVM', ErrorMessasges('no_buy_available'));
                window.location.href = "home.html";
            }
            else {
                cmn_openModelPopup(ErrorMessasges('no_buy_available'), "", "", "");
                $("body").removeClass("imageLoading");
                $("body").removeClass("loading");
            }
        }
    }
}

function cmn_connect_toVM(code) {
    //alert('hi');
    $("body").removeClass("whiteLoading");
    $("body").addClass("imageLoading");

    var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/wallets/connect';
    var objWalletCode =
    {
        'StickerId': code
    };

    var timeOutVar = setTimeout(function () {
        window.localStorage.setItem("connection_respose_dely", true);
        window.location.href = "home.html";
    }, 30000);

    this._xhr = jQuery.ajax({
        method: 'POST',
        url: url,

        dataType: 'json',
        contentType: 'application/json',
        headers: {
            'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
        },
        data: JSON.stringify(objWalletCode),
        success: function (data, status, jqXHR) {
            if (status == "success") {
                clearTimeout(timeOutVar);
                var merchantData = JSON.parse(window.localStorage.getItem("MerchantData"));
                if (merchantData.Wallets.length > 1) {
                    var count = 0;
                    for (i = 0; i < merchantData.Wallets.length; i++) {
                        if (merchantData.Wallets[i].MerchantUId != null) {
                            if (merchantData.Wallets[i].WalletBalance > 0) {
                                count++;
                            }
                        }
                    }
                    if (count >= 1) {
                        window.localStorage.setItem("showSharedWallet", "true");
                    }
                    else {
                        window.localStorage.setItem("showSharedWallet", "false");
                    }
                }
                window.localStorage.setItem("MerchantType", data.MerchantType);
                window.localStorage.setItem("VMSpecificMerchant", data.MerchantName);
                window.localStorage.setItem('WalletTransactionId', data.WalletTransactionId);
                window.location.href = 'wallet-confirm.html';
            }
        },

        error: function (jqXHR, status, error) {
            //alert('err');
            $("body").removeClass("imageLoading");
            $("body").removeClass("whiteLoading");
            clearTimeout(timeOutVar);
            if (jqXHR.responseJSON.ErrorCode === undefined) {
                window.localStorage.setItem('ErroinVM', jqXHR.responseText);
                if (window.localStorage.getItem("fromIssueReport") == "true") {
                    window.location.href = "issue_reporting.html";
                }
                else {
                    window.location.href = "home.html";
                }

            }
            else if (jqXHR.responseJSON.ErrorCode == "GenericError") {
                window.localStorage.setItem('ErroinVM', "GenericError");
                if (window.localStorage.getItem("fromIssueReport") == "true") {
                    window.location.href = "issue_reporting.html";
                }
                else {
                    window.location.href = "home.html";
                }
            }
            else {
                window.localStorage.setItem('ErroinVM', jqXHR.responseJSON.ErrorCode);
                if (window.localStorage.getItem("fromIssueReport") == "true") {
                    window.location.href = "issue_reporting.html";
                }
                else {
                    window.location.href = "home.html";
                }
            }

        }
    });
}

function cmn_payAmount(amount, type) {
    $("body").removeClass("whiteLoading");
    $("body").addClass("imageLoading");
    if (window.localStorage.getItem("ipifyIp") != null) {
        var ipAddress = window.localStorage.getItem("ipifyIp");
    }
    else if (window.localStorage.getItem("jsonIp") != null) {
        var ipAddress = window.localStorage.getItem("jsonIp");
    }
    else if (window.localStorage.getItem("telizIp") != null) {
        var ipAddress = window.localStorage.getItem("telizIp");
    }

    var vm = window.localStorage.getItem("VendingId");
    var url = StageUrl + '/vmachines/' + vm + '/payments';
    var body = {
        'Type': type,
        'Amount': amount,
        'UserCurrentIP': ipAddress
    }

    try {
        var timeOutVar = setTimeout(function () {
            window.localStorage.setItem("connection_respose_dely", true);
            if (window.localStorage.getItem("fromIssueReport") == "true") {
                window.location.href = "issue_reporting.html";
            }
            else {
                window.location.href = "home.html";
            }
        }, 30000);

        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(body),
            success: function (data, status, jqXHR) {
                if (status == "success") {
                    clearTimeout(timeOutVar);
                    window.localStorage.setItem('payCode', data.PayCode);
                    window.location.href = 'creditcard-confirm.html';

                }
            },
            error: function (jqXHR, status, error) {
                clearTimeout(timeOutVar);
                if (jqXHR.responseJSON.ErrorCode === "UserLastTransactionIsRejected") {
                    cmn_openModelPopup(Resources.UserLastTransactionIsRejected, "", "", "");
                    $("#alertOk").click(function () {
                        if (window.localStorage.getItem("fromIssueReport") == "true") {
                            window.location.href = "issue_reporting.html";
                        }
                        else {
                            window.location.href = "home.html";
                        }
                    });
                }
                else if (jqXHR.responseJSON.ErrorCode === undefined) {
                    window.localStorage.setItem('ErroinVM', jqXHR.responseText);
                    if (window.localStorage.getItem("fromIssueReport") == "true") {
                        window.location.href = "issue_reporting.html";
                    }
                    else {
                        window.location.href = "home.html";
                    }
                }
                else {
                    window.localStorage.setItem('ErroinVM', jqXHR.responseJSON.ErrorCode);
                    if (window.localStorage.getItem("fromIssueReport") == "true") {
                        window.location.href = "issue_reporting.html";
                    }
                    else {
                        window.location.href = "home.html";
                    }
                }
            }
        });
    }
    catch (ex) {

    }
}

function cmn_GetAccessAndExpirationToken(cval, divCtr, btnCtr, silo, scanner) {
    cmn_setPaymentMode(cval, divCtr, btnCtr, silo, scanner);
}

/*Common method to get wallet balance.*/
function cmn_getWalletBalance() {
    if ((window.localStorage.getItem('PaymentType') === null) || (window.localStorage.getItem('PaymentType') !== 'confirmWallet'))
        $("body").addClass("loading");
    if (window.localStorage.getItem("isRefreshHome") === 'true') {
        $("#refreshIcon").addClass('blue-icon');
    }
    var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/wallets/balance';
    this._xhr = jQuery.ajax({
        method: 'GET',
        url: url,

        dataType: 'json',
        contentType: 'application/json',
        headers: {
            'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
        },
        success: function (data, status, jqXHR) {
            if (window.localStorage.getItem("isRefreshHome") === 'true') {
                $("#refreshIcon").removeClass('blue-icon');
                window.localStorage.setItem("isRefreshHome", false);
            }

            if (window.localStorage.getItem("CountryCode") == 'it' || window.localStorage.getItem("CountryCode") == 'es' || window.localStorage.getItem("CountryCode") == 'null' || window.localStorage.getItem("CountryCode") == null) {
                var balance = (data.Balance / 1000).toFixed(2);
                window.localStorage.setItem('currentBalance', (data.Balance / 1000).toFixed(2));
                $('#lblBalance').html(balance.replace('.', ','));
            }
            else {
                window.localStorage.setItem('currentBalance', (data.Balance / 1000).toFixed(2));
                $('#lblBalance').html((data.Balance / 1000).toFixed(2));
            }

            //data.Wallets[0].WalletBalance = 1111;
            //data.Wallets[0].WalletName = "MyWallet 0111";
            //data.Wallets[1].WalletBalance = 2000;
            //data.Wallets[1].WalletName = "Test";
            window.localStorage.setItem("MerchantData", JSON.stringify(data));
            // alert(JSON.stringify(data));
            $("body").removeClass("loading");

            if (sPage === "home.html") {
                cmn_checkBalanceWarning();
            }
        },
        error: function (jqXHR, status, error) {
            $("body").removeClass("loading");
            if (window.localStorage.getItem("isRefreshHome") === 'true') {
                $("#refreshIcon").removeClass('blue-icon');
                window.localStorage.setItem("isRefreshHome", false);
            }
            if (jqXHR.responseJSON.ErrorCode === undefined) {
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
            }
            else {
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        }
    });
}

/*Method to check last comparision date for low credit warning pop up.*/
function cmn_checkBalanceWarning() {
    if (window.localStorage.getItem('lastWarningPopUp') !== undefined && window.localStorage.getItem('lastWarningPopUp') != null) {
        var prvChk = window.localStorage.getItem('lastWarningPopUp');
        var reservedDateUTC = Date.UTC(new Date(prvChk).getYear(), new Date(prvChk).getMonth(), new Date(prvChk).getDate());
        var currentDateUTC = Date.UTC(new Date().getYear(), new Date().getMonth(), new Date().getDate());
        if (currentDateUTC > reservedDateUTC) {
            cmn_lowBalanceMessage();
        }

    } else {
        cmn_lowBalanceMessage();
    }
}

/*Method to pup up, low credit warning.*/
function cmn_lowBalanceMessage() {
    window.localStorage.setItem('lastWarningPopUp', new Date());
    $('#lb_message11').addClass('headerWarrning');
    $('#lb_message21').addClass('bodyWarrning');
    var w_Balance = $('#lblBalance').html().replace(',', '.');
    if (parseFloat(w_Balance) <= 0.00 && (window.localStorage.getItem('showBalanceAlert') == 'true' || window.localStorage.getItem('showBalanceAlert') == null)) {
        cmn_openExtModelPopup_ZeroBal(Resources.top_up_zero_header, Resources.top_up_zero_body, "", true, 'left');

    } else if (parseFloat(w_Balance) <= 1.00) {
        cmn_openExtModelPopup_LowBal(Resources.top_up_minlimit_header, Resources.top_up_minlimit_body, "", true, 'left');
    }
}



function cmn_soundAlertonDeviceReady() {
    playBeep();
    vibrateFun();
}

function playBeep() {
    navigator.notification.beep(1);
}

function vibrateFun() {

    navigator.vibrate(1000);
}

/*Common method to set menu in role.*/
function cmn_setRoleMenu(intSlide) {
    $('.center').slick({
        centerMode: true,
        centerPadding: '15px',
        slidesToShow: 3,
        initialSlide: intSlide,
        responsive: [
          {
              settings: {
                  arrows: false,
                  centerMode: true,
                  centerPadding: '40px',
                  slidesToShow: 3,
                  initialSlide: 5
              }
          },
        ]
    });
}

/*Method to get token during scanner.*/
function cmn_getRefreshTokenScanningCode(cval, divCtr, btnCtr, silo, scanner) {
    if (IsTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"), 300)) {
        var status = cmn_AuthenticationAPI();

        if (status = "success") {
            window.localStorage.setItem("TokenExpire", GetTokenExpiration(cmn_GetValueOfTokenExpire() - 300));
            AndroidFunction.showToast();
            api_CalltoValidateVM(cval, divCtr, btnCtr, silo, scanner);
        }
        else {
            cmn_openModelPopup(ErrorMessasges(status), "", "", "");
        }
    }
    else if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
        var status = cmn_AuthenticationAPIUsingRefreshToken(cmn_GetValuesFromAndroidFunction("RefreshToken"));

        if (status = "success") {
            window.localStorage.setItem("TokenExpire", GetTokenExpiration(cmn_GetValueOfTokenExpire() - 300));
            AndroidFunction.showToast();
            api_CalltoValidateVM(cval, divCtr, btnCtr, silo, scanner);
        }
        else {
            cmn_openModelPopup(ErrorMessasges(status), "", "", "");
        }
    }
    else {
        api_CalltoValidateVM(cval, divCtr, btnCtr, silo, scanner);
    }
}

/*Used in before every service call to check the expiration of token and get the refresh token */
function cmn_getRefreshTokenWithCallback(callback, dataObject) {
    /*Check for network Connection*/
    if (!cmn_checkConnection()) {
        return false;
    }
    if (IsTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"), 300)) {
        var status = cmn_AuthenticationAPI();

        if (status = "success") {
            window.localStorage.setItem("TokenExpire", GetTokenExpiration(cmn_GetValueOfTokenExpire() - 300));
            AndroidFunction.showToast();
            callback(dataObject);
        }
        else {
            cmn_openModelPopup(ErrorMessasges(status), "", "", "");
        }
    }
    else if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
        var status = cmn_AuthenticationAPIUsingRefreshToken(cmn_GetValuesFromAndroidFunction("RefreshToken"));

        if (status = "success") {
            window.localStorage.setItem("TokenExpire", GetTokenExpiration(cmn_GetValueOfTokenExpire() - 300));
            isLock = false;
            callback(dataObject);
        }
        else {
            cmn_openModelPopup(ErrorMessasges(status), "", "", "");
        }
    }
    else {
        callback(dataObject);
    }
}

$("#alertOk").click(function () {
    if (isRedirctToLogin) {
        isRedirctToLogin = false;
        window.location.href = "login.html";
    }
    else if (isRedirectToAppStore) {
        //else if (window.localStorage.getItem("isRedirectToAppStore")=="true") {
        isRedirectToAppStore = true;
        window.localStorage.setItem("isRedirectToAppStore", "true");
        navigator.app.loadUrl("https://play.google.com/store/apps/details?id=com.yourvoice.ccApp", { openExternal: true });
        window.location.href = "login.html";
    }
    else {
        window.localStorage.setItem("isRedirectToAppStore", "false");
    }
    cmn_closeModelPopup();
});

function cmn_openModelPopup(msg1, msg2, msg3, align) {
    if (align == "left") {
        $("#innerDiv").addClass("modal-inner-div-left");
    }
    else {
        $("#innerDiv").removeClass("modal-inner-div-left");
    }

    $("#message1").html(msg1);
    $("#message2").html(msg2);
    $("#message3").html(msg3);
    $("#alertOk").html(Resources.all_alert_OK_button);
    $('#ct_modal_popup').modal({ keyboard: false, backdrop: 'static' });
    $('#ct_modal_popup').modal('show');
}

function cmn_openExtModelPopup(message1, message2, message3, message4, cancel, align, okText, cancelText) {
    if (align == "left") {
        $("#innerDiv").addClass("modal-inner-div-left");
    }
    else {
        $("#innerDiv").removeClass("modal-inner-div-left");
    }

    $("#ext_message1").html(message1);
    $("#ext_message2").html(message2);
    $("#ext_message3").html(message3);
    $("#ext_message4").html(message4);
    $("#alertOkExt").html(okText);
    if (cancel == false) {
        $("#alertCancel").hide();
    } else {
        $("#alertCancel").show();
        $("#alertCancel").html(cancelText);
    }
    $('#ext_ct_modal_popup').modal({ keyboard: false, backdrop: 'static' });
    $('#ext_ct_modal_popup').modal('show');
}

function cmn_openExtModelPopup_LowBal(message1, message2, message3, cancel, align) {
    if (align == "left") {
        $("#innerDiv").addClass("modal-inner-div-left");
    }
    else {
        $("#innerDiv").removeClass("modal-inner-div-left");
    }

    $("#lb_message1").html(message1);
    $("#lb_message2").html(message2);
    $("#lb_message3").html(message3);

    $("#alertOkExt").html(Resources.all_alert_OK_button);
    if (cancel == false) {
        $("#alertCancel").hide();
    } else {
        $("#alertCancel").show();
        $("#alertCancel").html(Resources.all_alert_cancel_button);
    }

    $('#low-balance').modal({ keyboard: false, backdrop: 'static' });
    $('#low-balance').modal('show');
}
function cmn_openExtModelPopup_ZeroBal(message1, message2, message3, cancel, align) {
    if (align == "left") {
        $("#innerDiv").addClass("modal-inner-div-left");
    }
    else {
        $("#innerDiv").removeClass("modal-inner-div-left");
    }

    $("#lb_message11").html(message1);
    $("#lb_message21").html(message2);
    $("#lb_message31").html(message3);

    $("#alertOkExt").html(Resources.all_alert_OK_button);
    if (cancel == false) {
        $("#alertCancel").hide();
    } else {
        $("#alertCancel").show();
        $("#alertCancel").html(Resources.all_alert_cancel_button);
    }

    $('#zero-balance').modal({ keyboard: false, backdrop: 'static' });
    $('#zero-balance').modal('show');
}

function cmn_closeModelPopup() {
    //$('#ct_modal_popup').modal();
    //$('#ct_modal_popup').modal({ keyboard: false });
    $('#ct_modal_popup').modal('hide');
}

function cmn_closeModelPopup_LowBal() {
    $('#low-balance').modal();
    $('#low-balance').modal({ keyboard: false });
    $('#low-balance').modal('hide');
}
function cmn_closeModelPopup_ZeroBal() {
    $('#zero-balance').modal();
    $('#zero-balance').modal({ keyboard: false });
    $('#zero-balance').modal('hide');
}

function ext_cmn_closeModelPopup() {
    $('#ext_ct_modal_popup').modal();
    $('#ext_ct_modal_popup').modal({ keyboard: false });
    $('#ext_ct_modal_popup').modal('hide');
}


/* Method to create collection of last 3 VM codes.*/
function cmn_setPreviousCode(code, ctrl) {
    var pastCode = new Array();
    if (localStorage["pastCode"]) {
        pastCode = JSON.parse(localStorage["pastCode"]);
        currencies = pastCode;
    }
    if (pastCode.indexOf(code) == -1) {
        // If not, put it first and...
        pastCode.unshift(code);
        //  ...pop one at the end if array is too big
        if (pastCode.length > 3) {
            pastCode.pop();
        }
        localStorage["pastCode"] = JSON.stringify(pastCode);
        $(ctrl).autocomplete({
            lookup: JSON.parse(localStorage["pastCode"]),
            onSelect: function (suggestion) {
                api_CalltoValidateVM($(ctrl).val(), '', '', '', '');
            }
        });
    }
}

/*Method to check not viewed notification.*/
function cmn_checkNotViewedNotifications() {
    cmn_getRefreshTokenWithCallback(checkNotViewedNotifications_BL);
}

function checkNotViewedNotifications_BL() {
    $("body").addClass("loading");
    var url = StageUrl + '/notifications/notviewed/count?notificationtype=3 ';
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
                window.localStorage.setItem('PromoCount', data.Total);
                cmn_setPromoCountOnMenu(data.Total);
                AndroidFunction.showBadge(data.Total.toString());
                $("body").removeClass("loading");
            }
        },
        error: function (jqXHR, status, error) {
            $("#outer-notification-circle").css('display', 'none');
            $("#inner-notification-circle").css('display', 'none');
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

function cmn_setPromoCountOnMenu(Total) {
    if (Total > 0) {
        $("#outer-notification-circle").css('display', 'block');
        $("#inner-notification-circle").css('display', 'block');
        $("#out-prmCnt").text(Total);
        $("#inr-prmCnt").text(Total);
    } else {
        $("#outer-notification-circle").css('display', 'none');
        $("#inner-notification-circle").css('display', 'none');
    }
}

function cmn_getDeviceGlobalization() {
    navigator.globalization.getPreferredLanguage(function (language) {
        var lang = language.value.split("-");
        var current_lang = (lang[0]);
        window.localStorage.setItem("CountryCode", current_lang);
    },
   function () { cmn_openModelPopup("Error getting language", "", "", ""); });

}



/*Get Private Wallet Balance*/
function cmn_getPrivateWalletBalance() {
    if ((window.localStorage.getItem('PaymentType') === null) || (window.localStorage.getItem('PaymentType') !== 'confirmWallet'))
        $("body").addClass("loading");
    if (window.localStorage.getItem("isRefreshHome") === 'true') {
        $("#refreshIcon").addClass('blue-icon');
    }
    var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/wallets/balance';
    this._xhr = jQuery.ajax({
        method: 'GET',
        url: url,

        dataType: 'json',
        contentType: 'application/json',
        headers: {
            'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
        },
        success: function (data, status, jqXHR) {
            if (window.localStorage.getItem("isRefreshHome") === 'true') {
                $("#refreshIcon").removeClass('blue-icon');
                window.localStorage.setItem("isRefreshHome", false);
            }

            if (window.localStorage.getItem("CountryCode") == 'it' || window.localStorage.getItem("CountryCode") == 'es' || window.localStorage.getItem("CountryCode") == 'null' || window.localStorage.getItem("CountryCode") == null) {
                var balance = (data.Balance / 1000).toFixed(2);
                window.localStorage.setItem('currentBalance', (data.Balance / 1000).toFixed(2));
                $('#lblBalance').html(balance.replace('.', ','));
            }
            else {
                window.localStorage.setItem('currentBalance', (data.Balance / 1000).toFixed(2));
                $('#lblBalance').html((data.Balance / 1000).toFixed(2));
            }
            for (i = 0; i < data.Wallets.length; i++) {
                if (data.Wallets[i].MerchantUId == null) {
                    window.localStorage.setItem("CoffeeCappBalance", (data.Wallets[i].WalletBalance / 1000).toFixed(2));
                    window.localStorage.setItem("CoffeeCappName", (data.Wallets[i].WalletName));
                }
                else {
                    window.localStorage.setItem("MerchantName" + [i], (data.Wallets[i].WalletName));
                    window.localStorage.setItem("MerchantBalance" + [i], (data.Wallets[i].WalletBalance / 1000));
                }
            }
            $("body").removeClass("loading");

            if (sPage === "home.html") {
                cmn_checkBalanceWarning();
            }
        },
        error: function (jqXHR, status, error) {
            $("body").removeClass("loading");
            if (window.localStorage.getItem("isRefreshHome") === 'true') {
                $("#refreshIcon").removeClass('blue-icon');
                window.localStorage.setItem("isRefreshHome", false);
            }
            if (jqXHR.responseJSON.ErrorCode === undefined) {
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
            }
            else {
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        }
    });
}

function cmn_GetValueOfTokenExpire() {
    return AndroidFunction.GetValue("TokenExpire");
}

function cmn_GetValuesFromAndroidFunction(key) {
    var value = "";
    if (key == "TokenExpire") {
        value = window.localStorage.getItem("TokenExpire");
    }
    else if (key == "AccessToken") {
        value = AndroidFunction.GetValue(key);
        value = "Bearer " + value;
    }

    else if (key == "RefreshToken") {
        value = AndroidFunction.GetValue(key);
    }
    return value;
}

// This is returning the status either success or error description
function cmn_CallingAuthenticationAPI(userName, password) {
    var status = AndroidFunction.AuthenticationToken(userName, password);
    return status;
}


function cmn_AuthenticationAPI() {
    var status = AndroidFunction.AuthenticationToken();
    return status;
}

function cmn_AuthenticationAPIUsingRefreshToken(refreshToken) {
    var status = AndroidFunction.RfreshToken(refreshToken);
    return status;
}

function cmn_AuthenticationAPIByRecoveringToken(refreshToken) {
    var status = AndroidFunction.RecoverToken();
    return status;
}

function cmn_EncyrptPassword(key, password) {
    cordova.plugins.SecureKeyStore.set(function (res) {
        window.localStorage.setItem(key, key);
    }, function (error) {
        alert(error);
    }, key, password);
}




