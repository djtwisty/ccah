jQuery(document).ready(function () {

    tutorialHelper.localization();
    loadString();
   
    document.addEventListener("deviceready", function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        getFirebaseToken();
        getdeviceDetails();
        openNotification();
       
       
    }, false);
    tutorialHelper.getLocalization();
    tutorialHelper.setScreenImages();
    $("#tutorialsCont").owlCarousel({
        slideSpeed: 300,
        paginationSpeed: 400,
        singleItem: true
    });

    $("#alertOk").click(function () {
         navigator.app.exitApp();
     });

});
   
var tutorialHelper = {
    localization: function () {
        var lang = navigator.language.split("-");
        var current_lang = (lang[0]);
        window.localStorage.setItem("CountryCode", current_lang);
        window.localStorage.setItem("AppLanguageSet", true);

    },

    getLocalization: function () {
        $("#lblWelcomTut").html(Resources.Tutorial_welcome);
        $("#lblWelcomTut1").html(Resources.Tutorial_welcome);
        $("#lblWelcomTut2").html(Resources.Tutorial_welcome);
        $("#skipToLogin1").html(Resources.Tutorial_skip_label);
        $("#skipToLogin2").html(Resources.Tutorial_skip_label);
        $("#skipToLogin3").html(Resources.Tutorial_skip_label);
    },

    setScreenImages: function () {
        if (window.localStorage.getItem("CountryCode") == "fr") {
            $("#Useful_Info_01").attr('src', "img/fr/Useful_Info_01.png");
            $("#Useful_Info_02").attr('src', "img/fr/Useful_Info_02.png");
            $("#Useful_Info_03").attr('src', "img/fr/Useful_Info_03.png");
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