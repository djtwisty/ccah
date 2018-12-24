jQuery(document).ready(function () {

    loadString();
    cmn_menuLocalization();
    creditCardCloseConnHelper.getLocalization();
    cmn_getWalletBalance();
    creditCardCloseConnHelper.setInnerBodyHeight();
});



var creditCardCloseConnHelper = {

    setInnerBodyHeight: function () {
        if (window.screen.availWidth < 1024) {
            var wHeight = Math.floor(($(window).height() - $(".payment-option").offset().top)) - 10;
            $(".payment-option").height(($(window).height() - ($(".payment-option").offset().top)) - 6);
            $('.wrapper-height').css({ height: wHeight });
        }
    },

    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#creditCardTitle").html(Resources.Home_CC_upperlabel_00);
        $("#closeWallet").html(Resources.close_wallet);
        $("#ccClose").html(Resources.close_subtitle);
        $("#closeWalletOutcomeTopUp").html(Resources.close_wallet_outcome_top_up);
        $("#closeWalletOutcomePurchase").html(Resources.close_wallet_outcome_purchase);
        setTimeout(function () { window.location.href = 'home.html'; }, 3000);
    },
}