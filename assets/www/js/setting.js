jQuery(document).ready(function () {
    loadString();
    cmn_menuLocalization();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    settingHelper.getLocalization();

    if (window.localStorage.getItem("DeviceLangCode") === "null" || window.localStorage.getItem("DeviceLangCode") === null || window.localStorage.getItem("DeviceLangCode") === undefined) {
        $('#selectedCountry').val(-1);
    } else if (window.localStorage.getItem("Language") === 'ca') {
        $('#selectedCountry').val(0);
    } else if (window.localStorage.getItem("Language") === 'en') {
        $('#selectedCountry').val(1);
    } else if (window.localStorage.getItem("Language") === 'es') {
        $('#selectedCountry').val(2);
    } else if (window.localStorage.getItem("Language") === 'fr') {
        $('#selectedCountry').val(3);
    } else if (window.localStorage.getItem("Language") === 'it') {
        $('#selectedCountry').val(4);
    }

    document.addEventListener("deviceready", settingHelper.onDeviceReady, false);

    if (window.localStorage.getItem('isFlashEnable') === 'true') {
        $("#flashChk").attr('checked', true);
    }

    if (window.localStorage.getItem('scannerLaunch') === 'true') {
        $("#scanQR").attr('checked', true);
    }

    if ((window.localStorage.getItem("PaymentMode") != null || window.localStorage.getItem("PaymentMode") != "") && window.localStorage.getItem("PaymentMode") === "CreditCard") {
        $("#cardChk").attr('checked', true);
    }
    else if ((window.localStorage.getItem("PaymentMode") != null || window.localStorage.getItem("PaymentMode") != "") && window.localStorage.getItem("PaymentMode") === "wallet") {
        $("#walletChk").attr('checked', true);
    }

    $('#selectedCountry').on('change', function () {

        $("body").addClass('loading');

        if (window.localStorage.getItem("DeviceLangCode") === undefined || window.localStorage.getItem("DeviceLangCode") === null || window.localStorage.getItem("DeviceLangCode") === "null") {
            window.localStorage.setItem("DeviceLangCode", window.localStorage.getItem("CountryCode"));
        }

        if ($("#selectedCountry option:selected").val() == -1) {
            window.localStorage.setItem("CountryCode", window.localStorage.getItem("DeviceLangCode"));
            window.localStorage.removeItem("DeviceLangCode");

        } else if ($("#selectedCountry option:selected").val() == 0) {
            window.localStorage.setItem("CountryCode", 'ca');
        } else if ($("#selectedCountry option:selected").val() == 1) {
            window.localStorage.setItem("CountryCode", 'en');
        } else if ($("#selectedCountry option:selected").val() == 2) {
            window.localStorage.setItem("CountryCode", 'es');
        } else if ($("#selectedCountry option:selected").val() == 3) {
            window.localStorage.setItem("CountryCode", 'fr');
        } else if ($("#selectedCountry option:selected").val() == 4) {
            window.localStorage.setItem("CountryCode", 'it');
        }
        settingHelper.updateAppSetting();

    });

    $("#cardChk").click(function () {
        if ($("#cardChk").is(':checked')) {
            $("#walletChk").attr('checked', false);
            window.localStorage.setItem("PaymentMode", "CreditCard");
        }
        else {
            window.localStorage.removeItem("PaymentMode");
        }
    });

    $("#flashChk").click(function () {
        if ($("#flashChk").is(':checked')) {
            window.localStorage.setItem('isFlashEnable', 'true');
            $("#alertStatus").html(Resources.flash_enabled);
            $('#setAlert').modal('show');
            setTimeout(function () {
                $('#setAlert').modal('hide');
            }, 2000);
        } else {
            window.localStorage.removeItem('isFlashEnable');
            $("#alertStatus").html(Resources.flash_disabled);
            $('#setAlert').modal('show');
            setTimeout(function () {
                $('#setAlert').modal('hide');
            }, 2000);
        }
    });

    $("#scanQR").click(function () {
        if ($("#scanQR").is(':checked')) {
            if (window.localStorage.getItem("VMStartMode") == "NumericCode") {
                $('#qrScanner').prop("checked", true);
                window.localStorage.setItem("VMStartMode", "QRScanner");
            }
            window.localStorage.setItem('scannerLaunch', 'true');
        } else {
            window.localStorage.removeItem('scannerLaunch');
        }
    });

    $("#backToHome").click(function () {
        window.location.href = 'home.html';
    });

    $("#walletChk").click(function () {
        if ($("#walletChk").is(':checked')) {
            $("#cardChk").attr('checked', false);
            window.localStorage.setItem("PaymentMode", "wallet");
        }
        else {
            window.localStorage.removeItem("PaymentMode");
        }
    });

    if ((window.localStorage.getItem("VMStartMode") != null || window.localStorage.getItem("VMStartMode") != "") && window.localStorage.getItem("VMStartMode") == "QRScanner") {
        $("#qrScanner").attr('checked', true);
    }
    else if ((window.localStorage.getItem("VMStartMode") != null || window.localStorage.getItem("VMStartMode") != "") && window.localStorage.getItem("VMStartMode") == "NumericCode") {
        $("#numericCode").attr('checked', true);
    }

    $("#qrScanner").change(function () {
        if ($("#qrScanner").is(":checked")) {
            window.localStorage.setItem("VMStartMode", "QRScanner");
            $('#numericCode').prop("checked", false);
        }
        else {
            $('#numericCode').prop("checked", true);
        }
    });

    $("#numericCode").change(function () {
        if ($("#numericCode").is(":checked")) {
            if (window.localStorage.getItem('scannerLaunch') === 'true') {
                $("#scanQR").attr('checked', false);
                window.localStorage.removeItem('scannerLaunch');
            }

            window.localStorage.setItem("VMStartMode", "NumericCode");
            $('#qrScanner').prop("checked", false);
        }
        else {
            $('#qrScanner').prop("checked", true);
        }
    });

});

var settingHelper = {
    _setLanguage: '',
    _istrigger: '',

    onDeviceReady: function () {
        settingHelper.setInnerBodyHeight();
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    },

    updateAppSetting: function () {
        settingHelper._setLanguage = settingHelper.saveLanguage($("#selectedCountry option:selected").val());
        var DTO =
       {
           'Language': settingHelper._setLanguage
       };

        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId");
        this._xhr = jQuery.ajax({
            method: 'PUT',
            url: url,
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(DTO),
            success: function (data, status, jqXHR) {
                $("body").removeClass('loading');
                window.localStorage.setItem("Language", settingHelper._setLanguage);
                window.location.href = "setting.html";
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

    saveLanguage: function (value) {
        if (value == 0) {
            return 'ca';
        } else if (value == 1) {
            return 'en';
        } else if (value == 2) {
            return 'es';
        } else if (value == 3) {
            return 'fr';
        } else if (value == 4) {
            return 'it';
        } else {
            return null;
        }
    },
    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#Settings_langheader").html(Resources.Settings_langheader);
        $("#Settings_mainheader").html(Resources.Settings_mainheader);
        $("#Settings_connectmode_header").html(Resources.Settings_connectmode_header);
        $("#Settings_scan_on_launch").html(Resources.Settings_scan_on_launch);
        $("#Settings_connect_descr").html(Resources.Settings_connect_descr);
        $("#Settings_connect_choice1").html(Resources.Settings_connect_choice1);
        $("#Settings_connect_choice2").html(Resources.Settings_connect_choice2);
        $("#Settings_preferences_header").html(Resources.Settings_preferences_header);
        $("#Settings_paymode_descr").html(Resources.Settings_paymode_descr);
        $("#Settings_paymentmode1").html(Resources.Home_w_upperlabel_05);
        $("#Settings_paymentmode2").html(Resources.Home_w_upperlabel_04);
        $("#flash_header").html(Resources.Settings_flash_HEADER.toUpperCase());
        $("#isflashRequired").html(Resources.Settings_flash_on_scan.toUpperCase());
        $("#backToHome").attr("aria-label", Resources.tb_HomeIcon);

    },

    setInnerBodyHeight: function () {       
            if (window.screen.availWidth < 1024) {
                var wHeight = Math.floor(($(window).height() - $(".wht-bg").offset().top) / 2) - 10;
                $('.wht-bg').css({ height: wHeight });
            }
    },
}