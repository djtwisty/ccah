/// <reference path="../close_walletConnection.html" />
jQuery(document).ready(function () {
    loadString();
    walletconfimHelper.getLocalization();
    $(window).resize(function () {
        walletconfimHelper.setInnerBodyHeight();
    });
    walletconfimHelper.setInnerBodyHeight();
    document.addEventListener("deviceready", cmn_soundAlertonDeviceReady, false);

    if (window.localStorage.getItem("MerchantType") == "2" && (window.localStorage.getItem('showConnectionAlert') == 'true' || window.localStorage.getItem('showConnectionAlert') == null)) {
        window.localStorage.removeItem("MerchantType");
        $("#Layer2_header_card").html(Resources.private_wallet_alert + window.localStorage.getItem("VMSpecificMerchant"));
        $('#layer2').modal('show');
    }
    else if ((window.localStorage.getItem("MerchantType") == "1") && (window.localStorage.getItem('showSharedWallet') == 'true') && (window.localStorage.getItem('showSharedWalletAlert') == 'true' || window.localStorage.getItem('showSharedWalletAlert') == null)) {
        window.localStorage.removeItem("MerchantType");
        $("#Layer3_header_card").html(Resources.private_wallet_alert_2);
        $('#layer3').modal('show');
    }

    $("#setPaymentMode").click(function () {
        $('#layer2').modal('hide');
        if ($("#noToShow_SelectionModelChkWallet").is(':checked')) {
            window.localStorage.setItem('showConnectionAlert', 'false');
        }
        else {
            window.localStorage.setItem('showConnectionAlert', 'true');
        }
    });

    $("#setPaymentMode1").click(function () {
        $('#layer3').modal('hide');
        if ($("#noToShow_SharedWallet").is(':checked')) {
            window.localStorage.setItem('showSharedWalletAlert', 'false');
        }
        else {
            window.localStorage.setItem('showSharedWalletAlert', 'true');
        }
    });


    $("#walletCloseBtn").click(function () {
        event.stopPropagation();
        cmn_getRefreshTokenWithCallback(walletconfimHelper.closeConnectionVM);
    });
    walletconfimHelper.vibrationTimer = setInterval(vibrateFun, 5000);
    walletconfimHelper.timer = setInterval(walletconfimHelper.checkTransactionCompleted_BL, 3000);
});



var walletconfimHelper = {
    timer: '',
    vibrationTimer: '',
    isCallApi: false,

    getLocalization: function () {
        $("#homeWalletTitle").html(Resources.Home_Wallet_title);
        $("#confirmBuyProceed").html(Resources.ConfirmBuy_proceed);
        $("#ConfirmBuy_selection").html(Resources.ConfirmBuy_selection);
        $("#ConfirmBuy_wallet").html(Resources.ConfirmBuy_wallet);
        $("#walletCloseBtn").html(Resources.Wallet_close_button);
        $("#setPaymentMode").html(Resources.all_alert_OK_button);
        $("#Layer2_checkbox").html(Resources.cc_wallet_warning_checkbox);
        $("#setPaymentMode1").html(Resources.all_alert_OK_button);
        $("#Layer3_checkbox").html(Resources.cc_wallet_warning_checkbox);
    },

    setInnerBodyHeight: function () {
        $("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) - 20);
        $("#mid-cont").height(($(window).height()) - ($("#mid-cont").offset().top) - 80);
    },

    closeConnectionVM: function () {
        clearTimeout(walletconfimHelper.timer);
        $("body").addClass("loading");
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/wallets/disconnect';
        var objDisconnectWallet =
        {
            "WalletTransactionId": window.localStorage.getItem('WalletTransactionId')
        };
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(objDisconnectWallet),

            success: function (data, status, jqXHR) {
                if (status == "success") {
                    $("body").removeClass("loading");
                    window.location.href = 'close_walletConnection.html';
                }
            },

            error: function (jqXHR, status, error) {
                $("body").removeClass("loading");
                window.location.href = 'close_walletConnection.html';
            }
        });
    },
    checkTransactionCompleted: function () {
        cmn_getRefreshTokenWithCallback(walletconfimHelper.checkTransactionCompleted_BL)
    },
    checkTransactionCompleted_BL: function () {
        if (walletconfimHelper.isCallApi) {
            return;
        }

        walletconfimHelper.isCallApi = true
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/payments?count=1&sortby=0&sortorder=1&status=0&trxid=' + window.localStorage.getItem('WalletTransactionId') + '&explodewtrx=false&wallettrx=true';
        this._xhr = jQuery.ajax({
            method: 'GET',
            url: url,
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                walletconfimHelper.isCallApi = false;
                if (data['Transactions'][0]['Status'] != "Initialized") {
                     walletconfimHelper.closeConnectionVM();
                }
            },
            error: function (jqXHR, status, error) {
                walletconfimHelper.isCallApi = false;
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }
        });
    }
}