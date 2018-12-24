jQuery(document).ready(function () {
    loadString();
    cmn_menuLocalization();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    ccInfoHelper.getLocalization();
    ccInfoHelper.setInnerBodyHeight();
   
    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    $("#btnCreditCardInfo").click(function () {
        if ($("#btnCreditCardInfo").hasClass('disable_btn')) {
            return;
        }
        else {
            ccInfoHelper.registerCreditCard();
        }
    });

    $("input").on('click', function () {
        if ($("#btnCreditCardInfo").hasClass('disable_btn')) {
            return;
        }
        else {
            ccInfoHelper.registerCreditCard();
        }
    });

    $('#removeBtn').click(function () {
        event.stopPropagation();
        $("#removeBtn").attr('disabled', true);
        ccInfoHelper.removeCreditCard();
    });
    document.addEventListener("deviceready", ccInfoHelper.onDeviceReady, false);
});



var ccInfoHelper = {

    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(ccInfoHelper.getCreditCardInfo);
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
        $("#ccUpperLabel").html(Resources.Home_w_upperlabel_04);
        $("#ccInfoLabel").html(Resources.cardInfo_label);
        $("#btnCreditCardInfo").html(Resources.AddCredit_Button);
        $("#myCreditCard").html(Resources.CCMyCreditCard_Labe);
        $("#cardInfoLabel").html(Resources.cardInfo_label_02);
        $("#removeBtn").html(Resources.RemoveCard_Button);
        $("#registeredCardLabel").html(Resources.registered_card_label);
        $("#backToHome").attr("aria-label", Resources.tb_HomeIcon);
    },

    getCreditCardInfo: function () {
        $("body").addClass('loading');
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
                    ccInfoHelper.setCreditCardNumber(data);
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }
        });
    },

    setCreditCardNumber: function (data) {

        if (data['Cards'] != null && data['Cards'][0]['IsEnabled'] == true) {
            window.localStorage.setItem('CreditCardId', data['Cards'][0]['UId']);
            window.localStorage.setItem("CreditCardInfoSave", "true");
            var cn = data['Cards'][0]['ExtInfo'];
            document.getElementById('txtCreditCard').value = 'XXXX XXXX XXXX ' + cn;

            $("#btnCreditCardInfo").attr('disabled', 'disabled');
            $("#btnCreditCardInfo").addClass('disable_btn');
            $("#removeBtn").attr('disabled', false);
            $("#removeBtn").removeClass('disable_btn');

        }
        else {
            $("#btnCreditCardInfo").attr('disabled', false);
            $("#btnCreditCardInfo").removeClass('disable_btn');
            $("#removeBtn").attr('disabled', 'disabled');
            $("#removeBtn").addClass('disable_btn');
        }
        
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    },

    registerCreditCard: function () {
        cmn_getRefreshTokenWithCallback(this.registerCreditCard_BL);
    },

    registerCreditCard_BL: function () {
        var currentUrl = 'https://mpay.venpay.it/CreditCardInfo.aspx';
        var objBody = {
            'ReturnPageUri': currentUrl
        };
        var url = StageUrl + '/cards/init';
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            beforeSend: function () {
                $("body").addClass('loading');
            },
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(objBody),
            success: function (data, status, jqXHR) {
                if (status == "success") {
                    $("body").removeClass('loading');
                    window.localStorage.setItem("BankUrl", data.RedirectUri);
                    document.addEventListener("deviceready", function () {
                        var ref = window.open(data.RedirectUri, '_blank', 'location=no');
                        ref.addEventListener('loadstart', function (event) {
                            if (event.url == 'https://mpay.venpay.it/CreditCardInfo.aspx') {
                                ref.close(); window.location.href = "creditcardInfo.html";
                            }
                        });
                    }, false);
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }
        });
    },

    removeCreditCard: function () {
        cmn_getRefreshTokenWithCallback(this.removeCreditCard_BL);
    },

    removeCreditCard_BL: function () {
       var url = StageUrl + '/cards/' + window.localStorage.getItem("CreditCardId");
        this._xhr = jQuery.ajax({
            method: 'DELETE',
            url: url,
            crossDomain: true,
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                if (status == "success") {
                    $('#txtCreditCard').val('');
                    $("#btnCreditCardInfo").attr('disabled', false);
                    $("#btnCreditCardInfo").removeClass('disable_btn');
                    $("#removeBtn").attr('disabled', 'disabled');
                    $("#removeBtn").addClass('disable_btn');
                    $("body").removeClass('loading');
                    cmn_openModelPopup(ErrorMessasges('CreditCardDeleted'), "", "", "");
                    false;
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                $("#removeBtn").attr('disabled', false);
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }
        });
    },

}