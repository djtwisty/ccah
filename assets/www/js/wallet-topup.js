jQuery(document).ready(function () {
    //window.localStorage.setItem("CountryCode", "en");
    loadString();
    getDeviceIp();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    wallettopupHelper.getLocalization();
    cmn_menuLocalization();
    window.localStorage.removeItem('chatCashRegister');
    wallettopupHelper.setInnerBodyHeight();
    wallettopupHelper.getPaymentSystems();
    
    if (window.localStorage.getItem("BottomLink") == "true") {
        $("#walletbottomlink").show();
    }
    else {
        $("#walletbottomlink").hide();
    }

    $('#walletbottomlink').click(function () {
        window.location.href = "private-wallet.html";
    });
    if ((window.localStorage.getItem('resultOfExternalLink') != null)) {

        var result = window.localStorage.getItem('resultOfExternalLink').toString();
        window.localStorage.removeItem('resultOfExternalLink');
        if (result === 'OK') {
            cmn_openExtModelPopup(Resources.cnc_top_up_OK, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
        }
        else if (result === 'KO:USR_CANC') {
            cmn_openExtModelPopup(Resources.cnc_top_up_KO_2, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
        } else {
            cmn_openExtModelPopup(Resources.cnc_top_up_KO_3, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
        }
    }

    if (window.localStorage.getItem("CountryCode") === 'it') {
        $("#chatCasebtn").css('visibility', 'visible');
    } else {
        $("#chatCasebtn").css('visibility', 'collapse');
    }

    $('.click_h').on('click', function () {
        var top = $("#popup-pos").offset().top;


        $('.popup-info').css({
            top: top,
            position: 'absolute',

        });
    });

    if (window.localStorage.getItem("ipifyIp") != null) {
        wallettopupHelper._ipAddress = window.localStorage.getItem("ipifyIp");
    }
    else if (window.localStorage.getItem("jsonIp") != null) {
        wallettopupHelper._ipAddress = window.localStorage.getItem("jsonIp");
    }
    else if (window.localStorage.getItem("telizIp") != null) {
        wallettopupHelper._ipAddress = window.localStorage.getItem("telizIp");
    }

    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    $('#chatCasebtn').click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        if (window.localStorage.getItem('chatCashRegister') === 'true') {
            wallettopupHelper.setChatAndCashAPI();
        }
        else if (window.localStorage.getItem('chatCashRegister') === 'false') {
            window.localStorage.setItem('cnc_disabled', true);
            cmn_openExtModelPopup(Resources.cnc_disabled, "", "", "", true, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
        }

    });

    $('#topUpbtn').click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        //window.fabric.Crashlytics.addLog("clicked on Top up button..!");
        //window.fabric.Crashlytics.sendNonFatalCrash("cc Error");

        if (parseFloat($('#lblBalance').text().trim()) + 5.0 > 25) {
            cmn_openModelPopup(Resources.top_up_maxlimit, "", "", false, "");
        }
        else {
            if (window.localStorage.getItem("CreditCardInfoSave") != null && window.localStorage.getItem("CreditCardInfoSave") === "true") {
                wallettopupHelper._alertType = "ok_cancel_Alert";
                cmn_openExtModelPopup(Resources.wallet_topup_alert_msg, "", "", "", true, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
            }
            else {
                window.location.href = 'creditcardInfo.html';
            }
        }
    });

    $('#alertCancel').click(function (e) {
        wallettopupHelper._alertType = "";
        ext_cmn_closeModelPopup();
        return false;
    });

    $('#alertOkExt').click(function (e) {
        ext_cmn_closeModelPopup();

        //TODO

        if (window.localStorage.getItem('cnc_disabled') === 'true') {
            window.localStorage.removeItem('cnc_disabled');
            wallettopupHelper.registerForChatCash();
        } else if (wallettopupHelper._alertType == "ok_cancel_Alert") {
            setTimeout(function () {
                wallettopupHelper._alertType = "";
                var amount = 5.00 * 1000;
                cmn_getRefreshTokenWithCallback(wallettopupHelper.topupRecharge, amount);

            }, 300);
        }
    });

    $("#insertCoin_Btn").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.localStorage.setItem('FromWalletTopUp', true);
        window.location.href = "home.html";
    });

    $("#firstTopup").change(function () {
        if ($("#firstTopup").is(":checked")) {
            $('#secondTopup').prop("checked", false);
        }
        else {
            $('#secondTopup').prop("checked", true);
        }
    });

    $("#secondTopup").change(function () {
        if ($("#secondTopup").is(":checked")) {
            $('#firstTopup').prop("checked", false);
        }
        else {
            $('#firstTopup').prop("checked", true);
        }
    });
    document.addEventListener("deviceready", wallettopupHelper.onDeviceReady, false);
});

var wallettopupHelper = {
    _ipAddress: '',
    _alertType: '',

    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    },

    setInnerBodyHeight: function () {
        if (window.screen.availWidth < 1024) {
            var wHeight = Math.floor(($(window).height() - $(".payment-option").offset().top)) - 10;
            $(".payment-option").height(($(window).height() - ($(".payment-option").offset().top)) - 6);
            $('.wrapper-height').css({ height: wHeight });
        }
    },

    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#walletpageLbl").html(Resources.walletpage_01);
        $("#walletpageLbl1").html(Resources.walletpage_02);
        $("#walletpageLbl2").html(Resources.walletpage_03);
        $("#machineBtn").html(Resources.walletpage_04);
        $("#walletpageLbl4").html(Resources.walletpage_05);
        $("#walletpageLbl5").html(Resources.walletpage_06);
        $("#walletpage_button1_line1").html(Resources.walletpage_button1_line1);
        $("#walletpage_button1_line2").html(Resources.walletpage_button1_line2);
        $("#walletpage_button2_line1").html(Resources.walletpage_button2_line1);
        $("#walletpage_button2_line2").html(Resources.walletpage_button2_line2);
        $("#walletpage_button3_line1").html(Resources.walletpage_button3_line1);
        $("#walletpage_button3_line2").html(Resources.walletpage_button3_line2);
        $("#walletbottomlink").html(Resources.walletpage_bottom_link);
        $("#backToHome").attr("aria-label", Resources.tb_HomeIcon);
    },

    getPaymentSystems: function () {
        $("body").addClass("loading");
        var url = StageUrl + '/users/paymentsystems';
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
                    wallettopupHelper.setPaySystem(data);
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass("loading");
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openExtModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
                else if (jqXHR.responseJSON.ErrorMessage.indexOf("Error recahrging wallet") > -1) {
                    cmn_openExtModelPopup(Resources.top_up_failure, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
                else {
                    cmn_openExtModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
            }
        });
    },

    setPaySystem: function (data) {
        if (data["PaySysList"] !== null && data["PaySysList"] !== '') {
            for (i = 0; i < data["PaySysList"].length; i++) {
                if (data["PaySysList"][i]["Name"] === "Cash") {
                    wallettopupHelper.setButtonAppearance("#insertCoin_Btn", data["PaySysList"][i]["EnableWalletRecharge"]);
                }
                else if (data["PaySysList"][i]["Name"] === "CreditCard") {
                    wallettopupHelper.setButtonAppearance("#topUpbtn", data["PaySysList"][i]["EnableWalletRecharge"]);
                }

                else if (data["PaySysList"][i]["Name"] === "Chat&Cash") {
                    if (data["PaySysList"][i]["EnableWalletRecharge"] === true) {
                        window.localStorage.setItem('chatCashRegister', true);
                    } else {
                        window.localStorage.setItem('chatCashRegister', false);
                    }
                    $("#chatCasebtn").removeClass('smll disable_btn');
                    $("#chatCasebtn").attr('disabled', false);
                }
            }
        }
        $("body").removeClass("loading");
    },

    setButtonAppearance: function (buttonName, value) {
        if (value) {
            $(buttonName).removeClass('smll disable_btn'); $(buttonName).attr('disabled', false);
        } else {
            $(buttonName).addClass('smll disable_btn'); $(buttonName).attr('disabled', true);
        }
    },

    setChatAndCashAPI: function () {
        var DTO =
          {
              'PlatformType': 0,
              'CCType': 4,
              'Amount': 5000
          };

        $("body").addClass("loading");
        var url = StageUrl + '/chatandcash/init';
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(DTO),

            success: function (data, status, jqXHR) {
                $("body").removeClass('loading');
                if (data.RedirectUri != null) {
                    window.localStorage.setItem('redirectToBankPage', data.RedirectUri);
                    window.location.href = "bankPage.html";
                }
                else {
                    cmn_openExtModelPopup(Resources.cnc_top_up_KO_1, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                var errorMessage = jqXHR.responseJSON.ErrorMessage;
                if (errorMessage == null) {
                    cmn_openExtModelPopup(Resources.ServerError, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
                else if (errorMessage.substr(0, errorMessage.indexOf('|')).trim() === 'CreditOverflow') {
                    cmn_openExtModelPopup(Resources.cnc_top_up_KO_4, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
                else {
                    cmn_openExtModelPopup(Resources.cnc_top_up_KO_1, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
            }
        });
    },

    registerForChatCash: function () {
        window.localStorage.removeItem('chatCashRegister');
        navigator.app.loadUrl("https://play.google.com/store/apps/details?id=com.lynxspa.youp2p&hl=it", { openExternal: true });
    },

    topupRecharge: function (amount) {
        //window.fabric.Crashlytics.addLog("Inside rechage method with ipAddress: " + wallettopupHelper._ipAddress);
        //window.fabric.Crashlytics.addLog(window.localStorage.getItem("FirstName") + ": " + window.localStorage.getItem("Email"));
        $("body").addClass("loading");
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/wallets/recharge';
        var body = {
            'Amount': amount,
            'UserCurrentIP': wallettopupHelper._ipAddress
        };

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
                    $("body").removeClass("loading");
                    $("body").addClass("walletTopProcessing");

                    setTimeout(function () { window.location.href = 'home.html'; }, 3000);
                }
            },
            error: function (jqXHR, status, error) {
                cmn_getWalletBalance();
                if (jqXHR.responseJSON.Message == "The request is invalid.") {
                    cmn_openExtModelPopup(ErrorMessasges(Resources.wallet_topup_IP_alert), "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }

                else if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openExtModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
                else if (jqXHR.responseJSON.ErrorMessage.indexOf("Error recahrging wallet") > -1) {
                    cmn_openExtModelPopup(Resources.top_up_failure, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
                    /*Some other issues handled*/
                else if (jqXHR.responseJSON.ErrorCode === "SPConfirmNthTrxRejected") {
                    var ErrorMsg = jqXHR.responseJSON.ErrorMessage;
                    switch (ErrorMsg) {
                        case "E05":
                            cmn_openExtModelPopup(Resources.SPConfirmNthTrxRejected_code_E05, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                            break;
                        case "E12":
                            cmn_openExtModelPopup(Resources.SPConfirmNthTrxRejected_code_E12, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                            break;
                        case "E51":
                            cmn_openExtModelPopup(Resources.SPConfirmNthTrxRejected_codeE51, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                            break;
                        case "E54":
                            cmn_openExtModelPopup(Resources.SPConfirmNthTrxRejected_codeE54, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                            break;
                        default:
                            cmn_openExtModelPopup(Resources.SPConfirmNthTrxRejected_all_other_codes, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                            break;
                    }
                }
                else {
                    cmn_openExtModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
            }
        });
    }
}