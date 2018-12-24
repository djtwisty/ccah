jQuery(document).ready(function () {
    var qs = splshLgHelper.getQueryStrings();
    window.localStorage.setItem("notificationType", qs["type"]);
    document.addEventListener("deviceready", splshLgHelper.onDeviceReady, false);
    loadString();
    if (!cmn_checkConnection()) {
        splshLgHelper.noNetwork = false;
        return false;
    }
    if (window.localStorage.getItem("AppLanguageSet") !== 'true') {
        splshLgHelper.localization();
    }
    splshLgHelper.pageScreen();

    $("#alertOk").click(function () {
        alert(splshLgHelper.noNetwork);
        if (!splshLgHelper.noNetwork) {
            window.location.href = 'login.html';
        } else {
            navigator.app.exitApp();
        }
    });
});

var splshLgHelper = {
    noNetwork: true,

    onDeviceReady: function () {
        getdeviceDetails();
        openNotification();
        //fullScreen();

    },

    localization: function () {
        var lang = navigator.language.split("-");
        var current_lang = (lang[0]);
        window.localStorage.setItem("CountryCode", current_lang);

    },

    getQueryStrings: function () {
        var assoc = {};
        var decode = function (s) { return decodeURIComponent(s.replace(/\+/g, " ")); };
        var queryString = location.search.substring(1);
        var keyValues = queryString.split('&');

        for (var i in keyValues) {
            var key = keyValues[i].split('=');
            if (key.length > 1) {
                assoc[decode(key[0])] = decode(key[1]);
            }
        }

        return assoc;
    },

    pageScreen: function () {
        if (window.localStorage.getItem("takeBackGround") != 'true') {
            if (window.localStorage.getItem('UserUId') != null && window.localStorage.getItem('RememberPwd') == 'checked') {
                u_name = localStorage.getItem("_phoneNumber");
                u_pwd = localStorage.getItem("_password");

                if (u_name != "" || u_name != null || u_name != "null" || u_name != "undefined" !=
                u_pwd != "" || u_pwd != null || u_pwd != "null" || u_pwd != "undefined"
                ) {
                    window.localStorage.setItem("continueLogin", "Yes");
                    if (!cmn_checkConnection()) {
                        return false;
                    }
                    if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {

                        if ((window.localStorage.getItem('HasMoreThan16Years') === "false") || (window.localStorage.getItem('HasMoreThan16Years') === false)) {
                            window.location.href = "importantNotice.html";
                        }
                        else {
                            getAccessTokenFromBackGround();
                        }

                    }
                    else {
                        if ((window.localStorage.getItem('HasMoreThan16Years') === "false") || (window.localStorage.getItem('HasMoreThan16Years') === false)) {
                            window.location.href = "importantNotice.html";
                        }
                        else {
                            getNonViewedPromo_frmBackGround(true)
                        }
                    }
                }
                else {
                    window.localStorage.setItem("continueLogin", "No");
                    window.location.href = 'login.html';
                }
            }
            else {
                window.localStorage.setItem("continueLogin", "No");
                window.location.href = 'login.html';
            }
        }

    },

    getAccessTokenFromBackGround: function () {
        try {
            var status = cmn_AuthenticationAPI();
            jQuery.support.cors = true;

            var timeOutVar = setTimeout(function () {
                cmn_openModelPopup(ErrorMessasges("UserTimeExpired"), "", "", "");
            }, 15000);

            if (status = "success") {
                clearTimeout(timeOutVar);
                window.localStorage.setItem("TokenExpire", GetTokenExpiration(cmn_GetValueOfTokenExpire() - 300));
                AndroidFunction.showToast();
                window.location.href = 'home.html';
            }
            else {
                clearTimeout(timeOutVar);
                $("body").removeClass("loading");
                cmn_openModelPopup(ErrorMessasges(status), "", "", "");
                window.localStorage.removeItem("_password")
                window.localStorage.removeItem("Password")
                window.location.href = "login.html";
            }
        }
        catch (ex) {

        }
    },
}






