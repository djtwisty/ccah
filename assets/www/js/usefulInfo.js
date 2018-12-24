jQuery(document).ready(function () {
    
    loadString();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    cmn_menuLocalization();
    usefullInfoHelper.getLocalization();
   
    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });
    usefullInfoHelper.setScreenImages();
    document.addEventListener("deviceready", usefullInfoHelper.onDeviceReady, false);
   
});



var usefullInfoHelper = {

    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    },

    getLocalization: function () {
    	$("#welcomLable").html(Resources.Tutorial_welcome);
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
    	$("#backToHome").attr("aria-label", Resources.tb_HomeIcon);
    },

    setScreenImages: function () {
        if(window.localStorage.getItem("CountryCode") == "fr")
        {
            $("#Useful_Info_01").attr('src',"img/fr/Useful_Info_01.png");
            $("#Useful_Info_02").attr('src', "img/fr/Useful_Info_02.png");
            $("#Useful_Info_03").attr('src',"img/fr/Useful_Info_03.png");
            $("#Useful_Info_04").attr('src', "img/fr/Useful_Info_04.png");
            $("#Useful_Info_05").attr('src', "img/fr/Useful_Info_05.png");
            $("#Useful_Info_06").attr('src', "img/fr/Useful_Info_06.png");
        }
        else if (window.localStorage.getItem("CountryCode") == "en") {
            $("#Useful_Info_01").attr('src', "img/en/Useful_Info_01.png");
            $("#Useful_Info_02").attr('src', "img/en/Useful_Info_02.png");
            $("#Useful_Info_03").attr('src', "img/en/Useful_Info_03.png");
            $("#Useful_Info_04").attr('src', "img/en/Useful_Info_04.png");
            $("#Useful_Info_05").attr('src', "img/en/Useful_Info_05.png");
            $("#Useful_Info_06").attr('src', "img/en/Useful_Info_06.png");
        }
        else if (window.localStorage.getItem("CountryCode") == "es" || window.localStorage.getItem("CountryCode") == "ca") {
            $("#Useful_Info_01").attr('src', "img/es/Useful_Info_01.png");
            $("#Useful_Info_02").attr('src', "img/es/Useful_Info_02.png");
            $("#Useful_Info_03").attr('src', "img/es/Useful_Info_03.png");
            $("#Useful_Info_04").attr('src', "img/es/Useful_Info_04.png");
            $("#Useful_Info_05").attr('src', "img/es/Useful_Info_05.png");
            $("#Useful_Info_06").attr('src', "img/es/Useful_Info_06.png");
        }
        else {
            $("#Useful_Info_01").attr('src', "img/it/Useful_Info_01.png");
            $("#Useful_Info_02").attr('src', "img/it/Useful_Info_02.png");
            $("#Useful_Info_03").attr('src', "img/it/Useful_Info_03.png");
            $("#Useful_Info_04").attr('src', "img/it/Useful_Info_04.png");
            $("#Useful_Info_05").attr('src', "img/it/Useful_Info_05.png");
            $("#Useful_Info_06").attr('src', "img/it/Useful_Info_06.png");
        }
    }

}