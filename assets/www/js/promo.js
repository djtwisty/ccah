jQuery(document).ready(function () {
    loadString();
    cmn_menuLocalization();
    promoHelper.getLocalization();
    promoHelper.setInnerBodyHeight();
    cmn_getWalletBalance();
    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    document.addEventListener("deviceready", promoHelper.onDeviceReady, false);

});

var promoHelper = {
    startIndex: 0,
    count: 20,
    firstText: '',
    linkText: '',

    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
        checkNotViewedNotifications_AppMenu();
        promoHelper.getActivePromotion(0);
    },

    setInnerBodyHeight: function () {
        $("#promotion-cont").height(($(window).height()) - ($("#promotion-cont").offset().top) - 45);
    },
    getLocalization: function () {
        $("#homeLogo").attr("aria-label", Resources.tb_HomeIcon);
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#promo_page_bottom_link").html(Resources.promo_page_bottom_link);
        if (window.localStorage.getItem("FirstName") == undefined || window.localStorage.getItem("FirstName") == 'null') {
            $("#userWelcome").html(Resources.Promo_page_line1);
        }
        else {
            $("#userWelcome").html(Resources.Promo_page_line1 + ' ' + window.localStorage.getItem("FirstName").toUpperCase());
        }
        $("#promopageline2").html(Resources.Promo_page_line2);
    },

    /*Method to get the active promotion*/
    getActivePromotion: function (startId) {
        $("body").addClass("loading");
        var url = StageUrl + '/notifications?count=' + promoHelper.count + '&startindex=' + startId + '&locale=' + window.localStorage.getItem("CountryCode") + '&notificationtype=3&activenotifications=true&starttime=' + new Date().toISOString() + '&endtime=' + new Date().toISOString();

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

                    if (data.TotalNotificationsNumber <= 1) {
                        $("#outer-promotion-cont").append('<div class="text-center home-mid-content"><p id="promo_page_bottom_link" ></p></div>');
                        $("#promo_page_bottom_link").html(Resources.promo_page_bottom_link);
                    }
                    if (data.NextNotificationUId != null) {
                        promoHelper.createListView(data);
                        promoHelper.startIndex = promoHelper.startIndex + promoHelper.count;
                        promoHelper.getActivePromotion(promoHelper.startIndex);
                    }
                    else {
                        promoHelper.startIndex = 0;
                        promoHelper.createListView(data);
                        $("body").removeClass("loading");
                        if (data.TotalNotificationsNumber > 1) {
                            $("#promotion-cont").append('<div class="text-center home-mid-content"><p id="promo_page_bottom_link" ></p></div>');
                            $("#promo_page_bottom_link").html(Resources.promo_page_bottom_link);
                        }
                    }
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass("loading");
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }
        });
    },

    createListView: function (data) {
        for (i = 0; i < data["Notifications"].length; i++) {
            for (j = 0; j < data["Notifications"][i]["NotificationData"].length; j++) {
                if (data["Notifications"][i]["NotificationData"][j]["Type"] == 1 && data["Notifications"][i]["NotificationData"][0]["Url"] != null) {
                    if (data["Notifications"][i]["IsViewed"] == false) {
                        if (data["Notifications"][i]["NotificationData"][j]["MimeType"] == 'text/html') {
                            if (window.localStorage.getItem("CountryCode") === 'it' || window.localStorage.getItem("CountryCode") === 'fr') {
                                $("#promotion-cont").append('<div style="position:relative; width:100%; height:95%;  z-index:2; margin-bottom:2px;"><div class="linkcont" onclick="promoHelper.redirectToContentPage(\'' + data["Notifications"][i]["NotificationData"][1]["Url"] + '\',\'' + data["Notifications"][i]["NotificationUId"] + '\');"></div><span class="new-tag"></span><div class="promo-add-cont-html"><object style="display:block;height:100%;width:100%" data="' + data["Notifications"][i]["NotificationData"][0]["Url"] + '"></object></div></div>');

                            } else {
                                $("#promotion-cont").append('<div style="position:relative; width:100%; height:80%;  z-index:2; margin-bottom:2px;"><div class="linkcont" onclick="promoHelper.redirectToContentPage(\'' + data["Notifications"][i]["NotificationData"][1]["Url"] + '\',\'' + data["Notifications"][i]["NotificationUId"] + '\');"></div><span class="new-tag"></span><div class="promo-add-cont-html"><object style="display:block;height:100%;width:100%" data="' + data["Notifications"][i]["NotificationData"][0]["Url"] + '"></object></div></div>');

                            }
                        }
                        else {
                            $("#promotion-cont").append('<div onclick="promoHelper.redirectToContentPage(\'' + data["Notifications"][i]["NotificationData"][1]["Url"] + '\',\'' + data["Notifications"][i]["NotificationUId"] + '\');" class="promo-add-cont-img"><span class="new-tag new-tag-img"></span><img class="img-responsive" src="' + data["Notifications"][i]["NotificationData"][0]["Url"] + '"/></div>');
                        }
                    }
                    else {
                        if (data["Notifications"][i]["NotificationData"][j]["MimeType"] == 'text/html') {
                            if (window.localStorage.getItem("CountryCode") === 'it' || window.localStorage.getItem("CountryCode") === 'fr') {
                                $("#promotion-cont").append('<div style="position:relative; width:100%; height:95%;  z-index:2; margin-bottom:2px;"><div class="linkcont" onclick="promoHelper.redirectToContentPage(\'' + data["Notifications"][i]["NotificationData"][1]["Url"] + '\',\'' + data["Notifications"][i]["NotificationUId"] + '\');"></div><div class="promo-add-cont-html"><object style="display:block;height:100%;width:100%" data="' + data["Notifications"][i]["NotificationData"][0]["Url"] + '"></object></div></div>');

                            } else {
                                $("#promotion-cont").append('<div style="position:relative; width:100%; height:80%;  z-index:2; margin-bottom:2px;"><div class="linkcont" onclick="promoHelper.redirectToContentPage(\'' + data["Notifications"][i]["NotificationData"][1]["Url"] + '\',\'' + data["Notifications"][i]["NotificationUId"] + '\');"></div><div class="promo-add-cont-html"><object style="display:block;height:100%;width:100%" data="' + data["Notifications"][i]["NotificationData"][0]["Url"] + '"></object></div></div>');

                            }
                        }
                        else {
                            $("#promotion-cont").append('<div onclick="promoHelper.redirectToContentPage(\'' + data["Notifications"][i]["NotificationData"][1]["Url"] + '\',\'' + data["Notifications"][i]["NotificationUId"] + '\');" class="promo-add-cont-img"><img class="img-responsive" src="' + data["Notifications"][i]["NotificationData"][0]["Url"] + '"/></div>');
                        }
                    }
                }
            }
        }
    },

    /*Method to redirect Content Page.*/
    redirectToContentPage: function (redirectUri, notificationId) {
        var dataObject = {
            "redirectUri": redirectUri,
            "notificationId": notificationId
        };
        cmn_getRefreshTokenWithCallback(this.redirectToContentPage_BL, dataObject);
    },

    openPromoLink: function () {
        var ref = window.open('http://coffeecapp.it/regolamento.html', '_blank', 'location=no');

    },

    redirectToContentPage_BL: function (dataObject) {
        document.addEventListener("deviceready", function () {
            promoHelper.setViewedPromotion(dataObject.notificationId);
            var ref = window.open(dataObject.redirectUri, '_blank', 'location=no');
            ref.addEventListener('loadstart', function (event) {
                // if (event.url == 'https://mpay.venpay.it/promotion.aspx') {
                if (event.url == 'https://mpay.bitx.com/promotion.aspx') {
                    ref.close(); window.location.href = "promo-page.html";
                }
            });
        }, false);
    },

    /*Method to set Viewed promotion*/
    setViewedPromotion: function (notificationId) {
        var url = StageUrl + '/notifications/' + notificationId + '/viewed';
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,

            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                $("#promotion-cont").empty();
                promoHelper.getActivePromotion(0);
                checkNotViewedNotifications_AppMenu();
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass("loading");
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