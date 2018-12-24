jQuery(document).ready(function () {
    loadString();
    cmn_menuLocalization();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    contactHelper.getLocalization();
    //cmn_getWalletBalance();
    contactHelper.setInnerBodyHeight();

    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    $("#menu").click(function () {
        $(".slider").slick("slickGoTo", parseInt(2));
        cmn_openMenu();
    });

    $("#closemenu").click(function () {
        cmn_closeMenu();
    });

    $("#contact_Btn").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        if (window.localStorage.getItem("CountryCode") === "es" || window.localStorage.getItem("CountryCode") === "ca")
        { document.location.href = "tel:+34 933773017"; }
        else if (window.localStorage.getItem("CountryCode") === "fr")
        { document.location.href = "tel:+33 134118080"; }
        else
        { document.location.href = "tel:+39 02 5752 4006"; }

    });

    // This footer will show for all the languages : Nicola
    //if (window.localStorage.getItem("CountryCode") === "it") {
    //    $("#venpaytext").show();
    //}
    //else {
    //    $("#venpaytext").hide();
    //}

    $("#email_Btn").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        //cordova.plugins.email.open({ to: 'ktyagi@q3tech.com', subject: "app token", body: window.localStorage.getItem('token') });
        cordova.plugins.email.open({ to: 'coffeecapp@venpay.it' });
    });

    $("#wwwLink_Btn").click(function () {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }

        navigator.app.loadUrl("http://www.coffeecapp.it", { openExternal: true });
    });

    document.addEventListener("deviceready", contactHelper.onDeviceReady, false);

    /* Uncomment for Browser Testing*/
    //cmn_getRefreshTokenWithCallback(contactHelper.getLatestTransactions());
});

var contactHelper = {
    contactHelper: '',

    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
        cmn_getRefreshTokenWithCallback(contactHelper.getLatestTransactions());
    },

    setInnerBodyHeight: function () {

        if (window.matchMedia('(max-width: 320px)').matches && window.matchMedia('(max-height : 480px)').matches) {
            $("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) - 9);
        }
        else {
            $("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) - 30);
        }
    },

    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#infoHeader").html(Resources.infoMenu_header);
        $("#contpageLabel2").html(Resources.contactpage_label02B);
        $("#contpageLabel2B").html(Resources.contactpage_label02B);
        $("#contpageLabel2").attr("href", " " + Resources.contactpage_label02B);
        $("#emailId").html(Resources.contactpage_label03B);
        $("#contpageLabel4").html(Resources.contactpage_label04);
        $("#wwwLink").html(Resources.contactpage_label04B);
        $("#contpageLabel5").html(Resources.contactpage_label05);
        $("#venpaytext").html(Resources.contactpage_footer);
        $("#backToHome").attr("aria-label", Resources.tb_HomeIcon);
    },

    getLatestTransactions: function () {
        $("body").addClass('loading');
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/payments?count=10';
        this._xhr = jQuery.ajax({
            method: 'GET',
            url: url,
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                var occurences = data["Transactions"].reduce(function (r, row) {
                    r[row.MerchantId] = ++r[row.MerchantId] || 1;
                    return r;
                }, {});

                var result = Object.keys(occurences).map(function (key) {
                    return { key: key, value: occurences[key] };
                });

                var i = 0, max = 0, merchantName = "", imageURL = "http://www.coffeecapp.it/merchants/";
                for (i = 0; i < result.length ; i++) {
                    if (max < result[i].value) {
                        max = result[i].value;
                        merchantName = result[i].key;
                    }
                }
                
                if (merchantName.length != 0 && merchantName != undefined && merchantName != "") {
                    merchantName = merchantName.replace(/\s+/g, '');
                    merchantName = merchantName.replace(/\./g, '');
                    merchantName = merchantName.toLowerCase();
                    imageURL = imageURL + merchantName + '/svg';
                    contactHelper.createimageControl(imageURL);
                }
                $("body").removeClass('loading');
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

    createimageControl: function (thisImg) {
        var img = document.createElement("IMG");
        img.src = thisImg;
        img.className = 'contact-merchange-logo'
        document.getElementById('wht-bg-cont').appendChild(img);
    }

}