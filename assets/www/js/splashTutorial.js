jQuery(document).ready(function () {

    document.addEventListener("deviceready", function () {
        if (!cmn_checkConnection()) {
            splshTutHelper.noNetwork = false;
            return false;
        }
        getFirebaseToken();

        if (window.localStorage.getItem("AppLanguageSet") !== 'true') {
            splshTutHelper.localization();
        }
        openNotification();
        loadString();
        
    }, false);


    splshTutHelper.pageScreen();
    $("#alertOk").click(function () {
        if (!splshTutHelper.noNetwork) {
            window.location.href = 'login.html';
        } else {
            navigator.app.exitApp();
        }
    });
});

var splshTutHelper = {
    noNetwork: true,
    localization: function () {
        var lang = navigator.language.split("-");
        var current_lang = (lang[0]);
        window.localStorage.setItem("CountryCode", current_lang);
        window.localStorage.setItem("AppLanguageSet", true);

    },

    pageScreen: function () {
        window.localStorage.setItem("continueLogin", "No");
        window.location.href = 'tutorial.html';
    }
}



