jQuery(document).ready(function () {
    loadString();
    creditCard_confirmHelper.getLocalization();
    $(window).resize(function () {
        creditCard_confirmHelper.setInnerBodyHeight();
    });
    creditCard_confirmHelper.setInnerBodyHeight();
    document.addEventListener("deviceready", cmn_soundAlertonDeviceReady, false);

    $("#closeButton").click(function () {
        creditCard_confirmHelper.closeConnection();
    });

    creditCard_confirmHelper.vibrationTimer = setInterval(vibrateFun, 5000);
});

var creditCard_confirmHelper = {
    vibrationTimer: '',
    
    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#creditCrdTtl").html(Resources.Home_CC_upperlabel_00);
        $("#ccLabel1").html(Resources.ConfirmBuy_2_3_Heading1);
      //  $("#ccLabel2").html(Resources.ConfirmBuy_selection_2);
        $("#ccLabel3").html(Resources.Home_cc_lowerlabel);
        $("#closeButton").html(Resources.Wallet_close_button);
        $("#confirmBuyProceed").html(Resources.ConfirmBuy_proceed);
    },

    setInnerBodyHeight: function () {
        $("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) - 20);
        $("#mid-cont").height(($(window).height()) - ($("#mid-cont").offset().top) - 80);
    },

    closeConnection: function () {
        $("body").addClass("loading");
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/payments/disconnect';
        var objDisconnectCard =
        {
            "TransactionId":window.localStorage.getItem('payCode')
        };
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(objDisconnectCard),

            success: function (data, status, jqXHR) {
                if (status == "success") {
                    window.localStorage.removeItem('payCode');
                    $("body").removeClass("loading");
                    window.location.href = 'close_creditcardConnection.html';
                }
            },

            error: function (jqXHR, status, error) {
                window.localStorage.removeItem('payCode');
                window.location.href = 'close_creditcardConnection.html';
            }
        });
    }
}