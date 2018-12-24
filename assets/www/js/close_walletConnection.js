jQuery(document).ready(function () {

    loadString();
    cmn_menuLocalization();
    walletCloseConnHelper.getLocalization();
    cmn_getWalletBalance();
    walletCloseConnHelper.setInnerBodyHeight();
});

var walletCloseConnHelper = {
    setInnerBodyHeight: function () {
        if (window.screen.availWidth < 1024) {
            var wHeight = Math.floor(($(window).height() - $(".payment-option").offset().top)) - 10;
            $(".payment-option").height(($(window).height() - ($(".payment-option").offset().top)) - 6);
            $('.wrapper-height').css({ height: wHeight });
        }
    },

    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#homeWalletTitle").html(Resources.Home_Wallet_title);
        $("#closeWallet").html(Resources.close_wallet);
        $("#confirmBuyProceed").html(Resources.ConfirmBuy_proceed);
        $("#closeWalletOutcomeTopUp").html(Resources.close_subtitle);
        setTimeout(function () { window.location.href = 'home.html'; }, 3000);
    },
}