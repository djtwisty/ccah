
jQuery(document).ready(function () {
    var menuRight = document.getElementById('cbp-spmenu-s2'),
           showRight = document.getElementById('showRight'),
               body = document.body;

    showRight.onclick = function () {
        classie.toggle(this, 'active');
        classie.toggle(menuRight, 'cbp-spmenu-open');
        disableOther('showRight');
    };

    function disableOther(button) {
        if (window.localStorage.getItem("FirstName") != null && window.localStorage.getItem("FirstName") != undefined && window.localStorage.getItem("FirstName") != 'null') {
            $("#userName").html(Resources.Promo_page_line1 + ' ' + window.localStorage.getItem("FirstName").toUpperCase());
        }
        else {
            $("#userName").html(Resources.Promo_page_line1);
        }
        $('#versionId').html('coffee cApp - rel ' + (window.localStorage.getItem("AppVersion") != null ? window.localStorage.getItem("AppVersion") : ''));
        if (button !== 'showRight') {
            classie.toggle(showRight, 'disabled');
        }

    }

    $('#removeIcon').click(function () {
        $('#cbp-spmenu-s2').removeClass('cbp-spmenu-open');
    });

    $("#infoUtilDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "usefulInfo.html";
    });

    $("#logoutDiv").click(function () {
        cmn_removeLocalStorages();
        window.location.href = "login.html";

    });

    $("#areaMnDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "my_area.html";
    });

    $("#favMnDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "favourites.html";
    });

    $("#ccardDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "creditcardInfo.html";
    });

    $("#infoMnDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "contact.html";
    });

    $("#walletDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        if ((window.localStorage.getItem('PaymentType') === null) || (window.localStorage.getItem('PaymentType') !== 'confirmWallet'))
            $("body").addClass("loading");
        if (window.localStorage.getItem("isRefreshHome") === 'true') {
            $("#refreshIcon").addClass('blue-icon');
        }
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/wallets/balance';
        this._xhr = jQuery.ajax({
            method: 'GET',
            url: url,

            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                if (window.localStorage.getItem("isRefreshHome") === 'true') {
                    $("#refreshIcon").removeClass('blue-icon');
                    window.localStorage.setItem("isRefreshHome", false);
                }

                if (window.localStorage.getItem("CountryCode") == 'it' || window.localStorage.getItem("CountryCode") == 'es' || window.localStorage.getItem("CountryCode") == 'null' || window.localStorage.getItem("CountryCode") == null) {
                    var balance = (data.Balance / 1000).toFixed(2);
                    window.localStorage.setItem('currentBalance', (data.Balance / 1000).toFixed(2));
                    $('#lblBalance').html(balance.replace('.', ','));
                }
                else {
                    window.localStorage.setItem('currentBalance', (data.Balance / 1000).toFixed(2));
                    $('#lblBalance').html((data.Balance / 1000).toFixed(2));
                }
                if (data.Wallets.length > 1) {
                    var count=0;
                    for (i = 0; i < data.Wallets.length; i++) {
                        if(data.Wallets[i].WalletBalance > 0)
                        {
                            count++;
                        }
                    }
                    if (count > 1)
                    {
                        window.localStorage.setItem("BottomLink", "true");
                        window.location.href = "private-wallet.html";
                    }
                    else {
                        window.localStorage.setItem("BottomLink", "false");
                        window.location.href = "wallet-topup.html";
                    }
                }
                else {
                    window.localStorage.setItem("BottomLink", "false");
                    window.location.href = "wallet-topup.html";
                }
                $("body").removeClass("loading");

                if (sPage === "home.html") {
                    cmn_checkBalanceWarning();
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass("loading");
                if (window.localStorage.getItem("isRefreshHome") === 'true') {
                    $("#refreshIcon").removeClass('blue-icon');
                    window.localStorage.setItem("isRefreshHome", false);
                }
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }
        });
    });

    $("#promoDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "promo-page.html";
    });

    $("#settingDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "setting.html";
    });

    $("#trnDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "last-transaction.html";
    });

    $("#issueDiv").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "issue_reporting.html";
    });
});


function cmn_menuLocalization() {
    $("#areaMenu").html(Resources.accountMenu);
    $("#trnMenu").html(Resources.last_transaction_menu);
    $("#infoMenu").html(Resources.infoMenu);
    $("#crCardMenu").html(Resources.cardInfoMenu);
    $("#walletMenu").html(Resources.myWalletMenu);
    $("#favMenu").html(Resources.favoriteMenu);
    $("#accountMenu").html(Resources.accountMenu);
    $("#settingMenu").html(Resources.settings_menu);
    $("#logoutMenu").html(Resources.logoutMenu);
    $("#promoMenu").html(Resources.promo_label_menu);
    $("#infoUtil").html(Resources.useful_info_menu);
    $("#issueMenu").html(Resources.report_issue_menu);
}


function checkNotViewedNotifications_AppMenu() {
    $("body").addClass("loading");
    var url = StageUrl + '/notifications/notviewed/count?notificationtype=3 ';
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
                window.localStorage.setItem('PromoCount', data.Total);
                if (data.Total > 0) {
                    $("#outer-notification-circle").css('display', 'block');
                    $("#inner-notification-circle").css('display', 'block');
                    AndroidFunction.showBadge(data.Total.toString());
                    $("#outer-notification-circle").text(data.Total);
                    $("#inner-notification-circle").text(data.Total);
                } else {
                    AndroidFunction.showBadge(data.Total.toString());
                    $("#outer-notification-circle").css('display', 'none');
                    $("#inner-notification-circle").css('display', 'none');
                }
                $("body").removeClass("loading");
            }
        },
        error: function (jqXHR, status, error) {
            $("#outer-notification-circle").css('display', 'none');
            $("#inner-notification-circle").css('display', 'none');
            $("body").removeClass("loading");
            if (jqXHR.responseJSON.ErrorCode === undefined) {
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
            }
            else {
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        }
    });
}

(function (window) {

    'use strict';
    function classReg(className) {
        return new RegExp("(^|\\s+)" + className + "(\\s+|$)");
    }


    var hasClass, addClass, removeClass;

    if ('classList' in document.documentElement) {
        hasClass = function (elem, c) {
            return elem.classList.contains(c);
        };
        addClass = function (elem, c) {
            elem.classList.add(c);
        };
        removeClass = function (elem, c) {
            elem.classList.remove(c);
        };
    }
    else {
        hasClass = function (elem, c) {
            return classReg(c).test(elem.className);
        };
        addClass = function (elem, c) {
            if (!hasClass(elem, c)) {
                elem.className = elem.className + ' ' + c;
            }
        };
        removeClass = function (elem, c) {
            elem.className = elem.className.replace(classReg(c), ' ');
        };
    }

    function toggleClass(elem, c) {
        var fn = hasClass(elem, c) ? removeClass : addClass;
        fn(elem, c);
    }

    window.classie = {
        // full names
        hasClass: hasClass,
        addClass: addClass,
        removeClass: removeClass,
        toggleClass: toggleClass,
        // short names
        has: hasClass,
        add: addClass,
        remove: removeClass,
        toggle: toggleClass
    };

})(window);