jQuery(document).ready(function () {
    $(".swiper-container").css("display", "none");
    $(".swiper-container").css("opacity", "1");
    loadString();
    window.localStorage.setItem("isRefreshHome", false);
    $("#refreshIcon").removeClass('blue-icon');
    window.localStorage.setItem("takeBackGround", 'false');
    homeHelper.getLocalization();
    homeHelper.setInnerBodyHeight();
    getDeviceIp();
    cmn_menuLocalization();
    homeHelper.getPaymentSystems();
    if (isRedirectToAppStore || window.localStorage.getItem("isRedirectToAppStore")=="true") {
   // if (window.localStorage.getItem("isRedirectToAppStore") == "true") {
        isRedirectToAppStore = true;
        cmn_openModelPopup(Resources.UpdateStatus_2, "", "", "", "");
        
    }

    if (window.localStorage.getItem("connection_respose_dely") === 'true') {
        window.localStorage.removeItem("connection_respose_dely");
        cmn_openModelPopup(Resources.connection_timeout, "", "", "");
    }

    if (window.localStorage.getItem('ErroinVM') != null && window.localStorage.getItem('ErroinVM') != "") {
        cmn_openModelPopup(ErrorMessasges(window.localStorage.getItem('ErroinVM')), "", "", "");
        window.localStorage.removeItem('ErroinVM');
    }

    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    if (window.localStorage.getItem("notificationType") === "1") {
        window.localStorage.removeItem("notificationType");
        $('#cbp-spmenu-s2').addClass('cbp-spmenu-open');
    }

    if (window.localStorage.getItem('isFlashEnable') === 'true') {
        $('#flashIcon').attr('src', 'img/flashOn.svg');
        $('#flashIcon').attr('aria-label', Resources.tb_FlashOnIcon);
    }
    else {
        $('#flashIcon').attr('src', 'img/flashOff.svg');
        $('#flashIcon').attr('aria-label', Resources.tb_FlashOffIcon);
    }



    if (window.localStorage.getItem("VMStartMode") === undefined || window.localStorage.getItem("VMStartMode") === null) {
        window.localStorage.setItem("VMStartMode", "QRScanner");
        window.localStorage.setItem('pinTap_color_forQR', 'red');
        $('#pinTap').removeClass('bar-pinOff-icon');
        $('#pinTap').addClass('bar-pinOn-icon');
        $('#handTap').addClass('bar-hand-icon');
        $("#handTap").attr("aria-label", Resources.tb_handImage);
        $("#pinTap").attr("aria-label", Resources.tb_ToolQRSacn);
    }
    else if (window.localStorage.getItem("VMStartMode") === "QRScanner") {
        $('#pinTap').removeClass('bar-pinOff-icon');
        $('#pinTap').addClass('bar-pinOn-icon');
        $('#handTap').addClass('bar-hand-icon');
        $("#handTap").attr("aria-label", Resources.tb_handImage);
        $("#pinTap").attr("aria-label", Resources.tb_ToolQRSacn);
    }
    else {
        homeHelper._currentPage = 1;
        $('#pinTap').removeClass('bar-pinOff-icon');
        $('#pinTap').addClass('bar-pinOn-icon');
        $('#handTap').addClass('bar-qr-icon');
        $("#handTap").attr("aria-label", Resources.tb_QrIcon);
        $("#pinTap").attr("aria-label", Resources.tb_ToolManualCode);
    }

    $("#walletSection").click(function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        window.localStorage.setItem("PaymentMode", 'wallet');
        $('.switchy-slider').css("left", "0");
        homeHelper._isPaymentModeWallet = 'wallet';
        if (window.localStorage.getItem('showWalletAlert') != 'false') {
            $("#Layer2_header_card").html(Resources.wallet_selected_alert);
            $('#layer2').modal('show');
        }
        $("#ccPanel").hide();
        $("#walletPanel").show();
    });


    $("#cardSection").click(function () {
        $("#walletBal").html(Resources.Home_cc_upperlabel_01);
        window.localStorage.setItem("PaymentMode", 'CreditCard');
        $('.switchy-slider').css("left", "56px");
        homeHelper._isPaymentModeWallet = 'card';
        if (window.localStorage.getItem('showCCAlert') != 'false') {
            $("#Layer2_header_card").html(Resources.card_selected_alert);
            $('#layer2').modal('show');
        }
        $("#walletPanel").hide();
        $("#ccPanel").show();
    });

    $("#setPaymentMode").click(function () {
        if (homeHelper._isPaymentModeWallet === 'wallet') {
            homeHelper.setWalletSection();
        } else if (homeHelper._isPaymentModeWallet === 'card') {
            homeHelper.setCardSection();
        }
        $('#layer2').modal('hide');
    });

    $("#noToShow_SelectionModelChk").click(function () {
        $('#layer2').modal('hide');
        if ($("#noToShow_SelectionModelChk").is(':checked') && homeHelper._isPaymentModeWallet === 'wallet') {
            window.localStorage.setItem('showWalletAlert', 'false');
        }
        else if ($("#noToShow_SelectionModelChk").is(':checked') && homeHelper._isPaymentModeWallet === 'card') {
            window.localStorage.setItem('showCCAlert', 'false');
        }
        $("#noToShow_SelectionModelChk").attr('checked', false);
    });
    $("#closePopUp").click(function () {
        $('#layer2').modal('hide');
    });

    $("#refreshIcon").click(function () {
        window.localStorage.setItem("isRefreshHome", true);
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    });

    $("#rechargeButton").click(function () {
        window.location.href = "wallet-topup.html";
    });

    $("#cancelRechage").click(function () {
        $('#lb_message1').removeClass('headerWarrning');
        $('#lb_message2').removeClass('bodyWarrning');
        cmn_closeModelPopup_LowBal();
    });

    $("#rechargeButtonZero").click(function () {
        if ($("#noToShow_SelectionModelChkHome").is(':checked')) {
            window.localStorage.setItem('showBalanceAlert', 'false');
        }
        else {
            window.localStorage.setItem('showBalanceAlert', 'true');
        }
        window.localStorage.setItem("BottomLink", "false");
        window.location.href = "wallet-topup.html";
    });

    $("#cancelRechageZero").click(function () {
        $('#lb_message11').removeClass('headerWarrning');
        $('#lb_message21').removeClass('bodyWarrning');
        cmn_closeModelPopup_ZeroBal();
        if ($("#noToShow_SelectionModelChkHome").is(':checked')) {
            window.localStorage.setItem('showBalanceAlert', 'false');
        }
        else {
            window.localStorage.setItem('showBalanceAlert', 'true');
        }
    });

    $("#switch-me").change(function () {
        homeHelper._isSliderMoved = true;

        if (window.localStorage.getItem("PaymentMode") === 'wallet') {
            window.localStorage.setItem("PaymentMode", 'CreditCard');
        } else if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
            window.localStorage.setItem("PaymentMode", 'wallet');
        }

    });

    $('#handTap').click(function () {
        if ($('#handTap').hasClass('bar-hand-icon')) {
            $('#handTap').removeClass('bar-hand-icon');
            $('#handTap').addClass('bar-qr-icon');
            $("#handTap").attr("aria-label", Resources.tb_QrIcon);
            $("#pinTap").attr("aria-label", Resources.tb_ToolManualCode);
        } 
        else {
            $('#handTap').removeClass('bar-qr-icon');
            $('#handTap').addClass('bar-hand-icon');
            $("#handTap").attr("aria-label", Resources.tb_handImage);
            $("#pinTap").attr("aria-label", Resources.tb_ToolQRSacn);
         
        }
    });

    $('#pinTap').click(function () {

        if (window.localStorage.getItem("VMStartMode") === "QRScanner" && $('#pinTap').hasClass('bar-pinOn-icon')) {
            $("#alertStatus").html(Resources.QR_connection_default);
            $('#setAlert').modal('show');
            setTimeout(function () {
                $('#setAlert').modal('hide');
            }, 2000);
        }
        else if (window.localStorage.getItem("VMStartMode") === "QRScanner" && $('#pinTap').hasClass('bar-pinOff-icon')) {
            if (window.localStorage.getItem('scannerLaunch') === 'true') {
                window.localStorage.removeItem('scannerLaunch');
            }
            $("#alertStatus").html(Resources.manual_connection_default);
            $('#setAlert').modal('show');
            setTimeout(function () {
                $('#setAlert').modal('hide');
            }, 2000);

            window.localStorage.setItem("VMStartMode", "NumericCode");
            $('#pinTap').removeClass('bar-pinOff-icon');
            $('#pinTap').addClass('bar-pinOn-icon');
        }

        else if (window.localStorage.getItem("VMStartMode") === "NumericCode" && $('#pinTap').hasClass('bar-pinOn-icon')) {
            window.localStorage.removeItem('scannerLaunch');
            $("#alertStatus").html(Resources.manual_connection_default);
            $('#setAlert').modal('show');
            setTimeout(function () {
                $('#setAlert').modal('hide');
            }, 2000);
        }
        else if (window.localStorage.getItem("VMStartMode") === "NumericCode" && $('#pinTap').hasClass('bar-pinOff-icon')) {
            $("#alertStatus").html(Resources.QR_connection_default);
            $('#setAlert').modal('show');
            setTimeout(function () {
                $('#setAlert').modal('hide');
            }, 2000);

            window.localStorage.setItem("VMStartMode", "QRScanner");
            $('#pinTap').removeClass('bar-pinOff-icon');
            $('#pinTap').addClass('bar-pinOn-icon');
        }

    });

    $('#ccPanel').click(function () {
        window.location.href = 'creditcardInfo.html';
    });

    $('#flashIcon').click(function () {
        if (window.localStorage.getItem('isFlashEnable') === 'true') {
            window.localStorage.setItem('isFlashEnable', false);
            $("#alertStatus").html(Resources.flash_disabled);
            $('#setAlert').modal('show');
            setTimeout(function () {
                $('#setAlert').modal('hide');
            }, 2000);

            $('#flashIcon').attr('src', 'img/flashOff.svg');
            $("#flashIcon").attr("aria-label", Resources.tb_FlashOffIcon);
        }
        else {
            window.localStorage.setItem('isFlashEnable', true);
            $("#alertStatus").html(Resources.flash_enabled);
            $('#setAlert').modal('show');
            setTimeout(function () {
                $('#setAlert').modal('hide');
            }, 2000);
            $('#flashIcon').attr('src', 'img/flashOn.svg');
            $("#flashIcon").attr("aria-label", Resources.tb_FlashOnIcon);
        }
    });


    $('#payCode').bind('input', function () {
        window.localStorage.setItem("fromIssueReport", "false");
        var $this = $(this);
        if ($this.length < 5) {
            return false;
        }
    
        if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
            cmn_setPaymentMode($.trim($this.val()), "", "#buybtn", "card", "");
        }
        else if (window.localStorage.getItem("PaymentMode") === 'wallet') {
            cmn_setPaymentMode($.trim($this.val()), "#buybtn", "#buybtn", "wallet", "");
        }
    });


    /* Credit Card Section*/
    $('#payCode').each(function () {
        if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
            var $this = $(this);
            $(this).bind('input', function () {
                if (currencies.indexOf($("#payCode").val()) == -1) {
                    setTimeout(function () { cmn_setPaymentMode($.trim($this.val()), "", "#buybtn", "card", ""); }, 100);
                }

            });
        }
        if (window.localStorage.getItem("PaymentMode") === 'wallet') {
            var $this = $(this);
            $(this).bind('input', function () {
                if (currencies.indexOf($("#walletCode").val()) == -1) {
                    setTimeout(function () { cmn_setPaymentMode($.trim($this.val()), "#buybtn", "#buybtn", "wallet", ""); }, 100);

                }

            });
        }
    });

    $("#qrli").click(function () {
        document.activeElement.blur();
        event.stopPropagation();
        //alert('in home');
        window.localStorage.setItem("fromIssueReport", "false");
        if (window.localStorage.getItem("PaymentMode") === 'CreditCard' && window.localStorage.getItem("EnablePaymentCard") === "false") {
            cmn_openModelPopup(Resources.EnablePaymentCard_false, "", "", "");
        }
        else if (window.localStorage.getItem("PaymentMode") === 'wallet' && window.localStorage.getItem("EnablePaymentWallet") === "false") {
            cmn_openModelPopup(Resources.EnablePaymentWallet_false, "", "", "");
        }
        else {
            window.localStorage.setItem("isScannButtonClicked", "true")
            if (window.localStorage.getItem('isFlashEnable') === 'true') {
                homeHelper.scanWithFlashlight();
            }
            else {
                homeHelper.scanner();
            }
        }
    });

    if (localStorage["pastCode"]) {
        pastCode = JSON.parse(localStorage["pastCode"]);
        currencies = pastCode;
    } else {
        currencies = "";
    }

    $("#scanQR").click(function () {
        document.activeElement.blur();
        event.stopPropagation();
        window.localStorage.setItem("isScannButtonClicked", "true")
        if (window.localStorage.getItem('isFlashEnable') === 'true') {
            homeHelper.scanWithFlashlight();
        }
        else {
            homeHelper.scanner();
        }
    });

    $('#payCode').autocomplete({
        lookup: currencies,
        onSelect: function (suggestion) {
            if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
                cmn_setPaymentMode($.trim($('#payCode').val()), "#buybtn", "#buybtn", "card", "");
            }
            else {
                cmn_setPaymentMode($.trim($('#payCode').val()), "#buybtn", "#buybtn", "wallet", "");
            }
        }
    });

    $("#buybtn").click(function () {
        event.stopPropagation();
        window.localStorage.setItem("fromIssueReport", "false");
        if (window.localStorage.getItem("PaymentMode") === 'CreditCard' && window.localStorage.getItem("EnablePaymentCard") === "false") {
            cmn_openModelPopup(Resources.EnablePaymentCard_false, "", "", "");
        }
        else if (window.localStorage.getItem("PaymentMode") === 'wallet' && window.localStorage.getItem("EnablePaymentWallet") === "false") {
            cmn_openModelPopup(Resources.EnablePaymentWallet_false, "", "", "");
        }
        else {
            if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
                homeHelper.buyMethod();
            } else {
                if ($('#walletbtn').is(':disabled')) {
                    return;
                }
                if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
                    window.location.href = "login.html";
                }
                else {
                    window.localStorage.setItem('PaymentType', 'confirmWallet');
                    cmn_getRefreshTokenWithCallback(homeHelper.connect_toVM);
                }
            }
        }

    });

    $("#favCode").click(function () {
        if ($("#favCode").hasClass('hrt-drk-icon')) {
            $("#payCode").val($.trim(window.localStorage.getItem("favVMCode")));
            if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
                cmn_setPaymentMode($.trim(window.localStorage.getItem("favVMCode")), "#buybtn", "#buybtn", "card", "scanner");
            } else {
                cmn_setPaymentMode($.trim(window.localStorage.getItem("favVMCode")), "#buybtn", "#buybtn", "wallet", "scanner");
            }

        } else if ($("#favCode").hasClass('hrt-line-icon')) {
            window.location.href = "favourites.html";
        }
    });

    $('#lblBalance').click(function () {
        window.location.href = 'wallet-topup.html';
    });

    $("#guide").click(function () {
        homeHelper.openGuide();
    });

    $('.closeBtn').click(function () {
        $('.swiper-wrapper').removeAttr('style');
        $('.swiper-slide').removeClass('swiper-slide-prev');
        $('.swiper-slide').removeClass('swiper-slide-active');
        $('.swiper-slide').removeClass('swiper-slide-next');
        $(".swiper-container").css("display", "none");
    });

    $('.double-arrow').before().click(function (e) {
        if ($('#handTap').hasClass('bar-hand-icon')) {
            if (e.offsetX + 15 > $('.double-arrow')[0].offsetWidth) {
                $('#scanGuide')[0].swiper.slideNext();
            }
            if (e.offsetX < 15) {
                $('#scanGuide')[0].swiper.slidePrev();

            }
        }
        else {
            if (e.offsetX + 15 > $('.double-arrow')[12].offsetWidth) {
                $('#manualGuide')[0].swiper.slideNext();
            }
            if (e.offsetX < 15) {
                $('#manualGuide')[0].swiper.slidePrev();

            }
        }
    });

    $('.single-arrow-left').before().click(function (e) {
        if ($('#handTap').hasClass('bar-hand-icon')) {
            if (e.offsetX < 15) {
                $('#scanGuide')[0].swiper.slidePrev();
            }
        }
        else {
            if (e.offsetX < 15) {
                $('#manualGuide')[0].swiper.slidePrev();
            }
        }
    });

    $('.wallet-wrap').before().click(function (e) {
        if ($('#handTap').hasClass('bar-hand-icon')) {
            if (e.offsetX + 15 > $('.double-arrow')[0].offsetWidth) {
                $('#scanGuide')[0].swiper.slideNext();
            }
        }
        else {
            if (e.offsetX + 15 > $('.double-arrow')[12].offsetWidth) {
                $('#manualGuide')[0].swiper.slideNext();
            }
        }
    });
    document.addEventListener("deviceready", homeHelper.onDeviceReady, false);

    if (window.localStorage.getItem('isFirstLaunch') !== 'false') {
        window.localStorage.setItem('isFirstLaunch', 'false');
        homeHelper.openGuide();
    }

    //cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);

});


var homeHelper = {
    _isBalanceChanged: '',
    _isFirst: '',
    _isSliderMoved: '',
    _isPaymentModeWallet: '',
    _currentPage: '',
    _ipAddress: '',

    onDeviceReady: function () {
        getFirebaseToken();
        getdeviceDetails();
        homeHelper.setInnerBodyHeight();
        openNotification();
        //fullScreen();
        window.localStorage.setItem("AppVersion", AppVersion.version);
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
        if (window.localStorage.getItem("deviceInfoSaved") != 'true' || (homeHelper.isAppVersionUpdated(window.localStorage.getItem("installedAppVersion") == null ? 0 : window.localStorage.getItem("installedAppVersion"), window.localStorage.getItem("AppVersion"))) || (homeHelper.UpdateDeviceDetail())) {
            if (!cmn_checkConnection()) {
                return false;
            }
            else {
                homeHelper.saveDeviceInfo();
            }
        } else {
        }
    },

    openGuide: function () {
        if ($('#handTap').hasClass('bar-hand-icon')) {
            $("#scanGuide").css("display", "block");
            $("#scanGuide").css("width", "");
        }
        else {
            $("#manualGuide").css("display", "block");
            $("#manualGuide").css("width", "");
        }
    },

    scanWithFlashlight: function () {
        cordova.plugins.barcodeScanner.scan(
            function (result) {
                var _vmcode = return_scan_qrcode(result.text);
                $('#payCode').val(_vmcode);
                if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
                    cmn_setPaymentMode(_vmcode, "#buybtn", "#buybtn", "card", "scanner");
                } else {
                    cmn_setPaymentMode(_vmcode, "#buybtn", "#buybtn", "wallet", "scanner");
                }
            },
               function (error) {
                   if (error == "Illegal access") {

                   }
                   else {
                       alert("Scanning failed: " + error);
                   }
               },
               {
                   torchOn: true, // Android, launch with the torch switched on (if available)
                   orientation: "portrait", // Android only (portrait|landscape), default unset so it rotates with the device
               });
        //}

    },

    scanner: function () {
        cordova.plugins.barcodeScanner.scan(
                   function (result) {
                       var _vmcode = return_scan_qrcode(result.text);
                       $('#payCode').val(_vmcode);
                       //alert('in scanner');
                       if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
                           cmn_setPaymentMode(_vmcode, "#buybtn", "#buybtn", "card", "scanner");
                       } else {
                           cmn_setPaymentMode(_vmcode, "#buybtn", "#buybtn", "wallet", "scanner");
                       }
                   },
                function (error) {
                    if (error == "Illegal access") {

                    }
                    else {
                        alert("Scanning failed: " + error);
                    }

                },
                {
                    orientation: "portrait", // Android only (portrait|landscape), default unset so it rotates with the device
                });
        //}
    },

    getLocalization: function () {
        $("#Home_w_upperlabel_03").html(Resources.Home_w_upperlabel_03);
        $("#ccLabel1").html(Resources.Home_CC_upperlable_01);
        $("#ccLabel2").html(Resources.Home_CC_upperlable_01);
        $("#payCode").attr('placeholder', Resources.Home_Wallet_label02);
        $("#Home_Wallet_label05 ").html(Resources.Home_Wallet_label05);
        $("#infoHomeTitle1").html(Resources.info_HOME_Title_01);
        $("#infoHomeTitle2").html(Resources.info_HOME_Title_02);
        $("#infoLabel1").html(Resources.info_HOME_label_01);
        $("#infoLabel2").html(Resources.info_HOME_label_02);
        $("#rechargeButton").html(Resources.TopUp_Title);
        $("#rechargeButtonZero").html(Resources.TopUp_Title);
        $("#cancelRechage").html(Resources.all_alert_cancel_button);
        $("#cancelRechageZero").html(Resources.all_alert_cancel_button);
        $("#Layer2_checkbox").html(Resources.cc_wallet_warning_checkbox);
        $("#Layer3_checkbox").html(Resources.cc_wallet_warning_checkbox);
        $("#Layer2_body").html(Resources.Layer2_body);
        $("#setPaymentMode").html(Resources.all_alert_OK_button);
        $("#existingFavCode").html(Resources.Home_Wallet_label03);
        $("#Guide_common_1_1").html(Resources.Guide_common_1);
        $("#Guide_common_1_2").html(Resources.Guide_common_2);
        $("#Guide_common_1_3").html(Resources.Guide_common_3);
        $("#Guide_common_1_4").html(Resources.Guide_common_4);
        $("#Guide_1_5").html(Resources.Guide_1_5);
        $("#Guide_1_6").html(Resources.Guide_1_6);
        $("#Guide_1_7").html(Resources.Guide_1_7);
        $("#Guide_1_8").html(Resources.Guide_1_8);
        $("#Guide_common_2_1").html(Resources.Guide_common_1);
        $("#Guide_common_2_2").html(Resources.Guide_common_2);
        $("#Guide_common_2_3").html(Resources.Guide_common_3);
        $("#Guide_common_2_4").html(Resources.Guide_common_4);
        $("#Guide_2_5").html(Resources.Guide_2_5);
        $("#Guide_2_6").html(Resources.Guide_2_6);
        $("#Guide_2_7").html(Resources.Guide_2_7);
        $("#Guide_2_8").html(Resources.Guide_2_8);
        $("#Guide_2_9").html(Resources.Guide_2_9);
        $("#buybtn").html(Resources.Home_BuyButton);

        $("#refreshIcon").attr("aria-label", Resources.tb_Refresh_wallet_icon);
        $("#menuBar").attr("aria-label", Resources.tb_Open_menu_icon);      
        $("#qrli").attr("aria-label", Resources.tb_QRScanImage)

        $("#walletSection").attr("aria-label", Resources.tb_walet_select_icon);
        $("#cardSection").attr("aria-label", Resources.tb_card_select_icon);

        if (window.localStorage.getItem("favVMCode") === null || window.localStorage.getItem("favVMCode") === "") {
            $("#favCode").addClass('hrt-line-icon');
            $("#vmIcon").attr("aria-label", Resources.tb_vmIcon);
        }
        else {
            $("#favCode").addClass('hrt-drk-icon');
            $("#vmIcon").attr("aria-label", Resources.tb_vmDarkIcon);
        }
    },

    setInnerBodyHeight: function () {

        if (window.matchMedia('(max-width: 320px)').matches && window.matchMedia('(max-height : 480px)').matches) {
            var wHeight = Math.floor(($(window).height() - $(".payment-option").offset().top) / 2) + 130;
            //$(".payment-option").height(($(window).height() - ($(".payment-option").offset().top)) - 5);
            $('.home-wrapper-height').css({ height: wHeight });
        }
        else if (window.matchMedia('(min-width: 768px)').matches) {
            var wHeight = Math.floor(($(window).height() - $(".payment-option").offset().top) / 2) + 250;
            //$(".payment-option").height(($(window).height() - ($(".payment-option").offset().top)) - 5);
            $('.home-wrapper-height').css({ height: wHeight });
        }
        else {
            if (window.screen.availWidth < 1024) {
                var wHeight = Math.floor(($(window).height() - $(".payment-option").offset().top) / 2) + 150;
                // $(".payment-option").height(($(window).height() - ($(".payment-option").offset().top)) - 5);
                $('.home-wrapper-height').css({ height: wHeight });//350

            }
        }
    },

    setWalletSection: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#ccPanel").hide();
        $("#walletPanel").show();
    },

    setCardSection: function () {
        $("#walletBal").html(Resources.Home_cc_upperlabel_01);
        $("#walletPanel").hide();
        $("#ccPanel").show();
    },

    buyMethod: function () {
        if ($('#buybtn').is(':disabled')) {
            return;
        }
        $("body").addClass("imageLoading");
        window.localStorage.setItem("PaymentType", "confirmBuy");
        if (window.localStorage.getItem("CreditCardInfoSave") != null && window.localStorage.getItem("CreditCardInfoSave") === "true") {
            if (window.localStorage.getItem("ipifyIp") != null) {
                homeHelper._ipAddress = window.localStorage.getItem("ipifyIp");
            }
            else if (window.localStorage.getItem("jsonIp") != null) {
                homeHelper._ipAddress = window.localStorage.getItem("jsonIp");
            }
            else if (window.localStorage.getItem("telizIp") != null) {
                homeHelper._ipAddress = window.localStorage.getItem("telizIp");
            }
            var amount = 5.00 * 1000;
            cmn_getRefreshTokenWithCallback(homeHelper.payAmount, amount);
        }
        else {
            window.location.href = 'creditcardInfo.html';
        }
    },

    payAmount: function (amount) {
        $("body").addClass("imageLoading");
        var vm = window.localStorage.getItem("VendingId");
        var url = StageUrl + '/vmachines/' + vm + '/payments';
        var body = {
            'Type': 'payment',
            'Amount': amount,
            'UserCurrentIP': homeHelper._ipAddress
        }
        try {
            var timeOutVar = setTimeout(function () {
                clearTimeout(timeOutVar);
                window.localStorage.setItem("connection_respose_dely", true);
                window.location.href = "home.html";
            }, 30000);

            this._xhr = jQuery.ajax({
                method: 'POST',
                url: url,
                dataType: 'json',
                contentType: 'application/json',
                headers: {
                    'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
                },
                data: JSON.stringify(body),
                success: function (data, status, jqXHR) {
                    if (status == "success") {
                        clearTimeout(timeOutVar);
                        window.localStorage.setItem('payCode', data.PayCode);
                        window.location.href = 'creditcard-confirm.html';
                    }
                },
                error: function (jqXHR, status, error) {
                    $("body").removeClass("imageLoading");
                    clearTimeout(timeOutVar);
                    if (jqXHR.responseJSON.Message == "The request is invalid.") {
                        cmn_openModelPopup(Resources.wallet_topup_IP_alert, "", "", "");
                    }
                    else if (jqXHR.responseJSON.ErrorCode === "UserLastTransactionIsRejected") {
                        cmn_openModelPopup(Resources.UserLastTransactionIsRejected, "", "", "");
                    }
                    else if (jqXHR.responseJSON.ErrorCode === undefined) {
                        cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                    }
                    else {
                        cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                    }
                }
            });
        }
        catch (ex) {

        }
    },

    connect_toVM: function () {
        $("body").addClass("imageLoading");
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/wallets/connect';
        var objWalletCode =
        {
            'StickerId': $('#payCode').val()
        };

        var timeOutVar = setTimeout(function () {
            window.localStorage.setItem("connection_respose_dely", true);
            $("body").removeClass("imageLoading");
            window.location.href = "home.html";
        }, 30000);

        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(objWalletCode),

            success: function (data, status, jqXHR) {
                if (status == "success") {
                    clearTimeout(timeOutVar);
                    var merchantData = JSON.parse(window.localStorage.getItem("MerchantData"));
                    if (merchantData.Wallets.length > 1) {
                        var count = 0;                       
                        for (i = 0; i < merchantData.Wallets.length; i++) {
                            if (merchantData.Wallets[i].MerchantUId != null) {
                                if (merchantData.Wallets[i].WalletBalance > 0) {
                                    count++;
                                }
                            }
                        }
                        if (count >= 1) {
                            window.localStorage.setItem("showSharedWallet", "true");
                        }
                        else {
                            window.localStorage.setItem("showSharedWallet", "false");
                        }
                    }
                    window.localStorage.setItem("MerchantType", data.MerchantType);
                    window.localStorage.setItem("VMSpecificMerchant", data.MerchantName);
                    window.localStorage.setItem('WalletTransactionId', data.WalletTransactionId);
                    window.location.href = 'wallet-confirm.html';
                }
            },

            error: function (jqXHR, status, error) {
                clearTimeout(timeOutVar);
                $("body").removeClass("imageLoading");
                if (jqXHR.responseJSON.ErrorCode == "GenericError") {
                    cmn_openModelPopup("GenericError", "", "", "");
                }
                else if (jqXHR.responseJSON.ErrorCode === "TransactionUnavailable") {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
                else if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }
        });
    },

    saveDeviceInfo: function () {
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/deviceinfos';
        if (window.localStorage.getItem("CarrierName") === null) {
            window.localStorage.setItem("CarrierName", "*NONE*");
        }
        if (window.localStorage.getItem("CarrierName2") === null) {
            window.localStorage.setItem("CarrierName2", "*NONE*");
        }
        var objDetails = {
            'UDI': (window.localStorage.getItem("UDI") == "undefined" || window.localStorage.getItem("UDI") == null || window.localStorage.getItem("UDI").toUpperCase() == "NULL") ? window.localStorage.getItem("RandomNo") : window.localStorage.getItem("UDI"),
            'LoginId': window.localStorage.getItem("UserName"),
            'DeviceManufacturer': window.localStorage.getItem("Manufacturer"),
            'DeviceModel': window.localStorage.getItem("Model"),
            'CarrierName': window.localStorage.getItem("CarrierName"),
            'AppRelease': window.localStorage.getItem("AppVersion"),
            'OSName': window.localStorage.getItem("Platform"),
            'OSVersion': window.localStorage.getItem("AndroidVersion"),
            'FirebaseToken': window.localStorage.getItem("token"),
            'CarrierName2': window.localStorage.getItem("CarrierName2")
        };

        window.localStorage.setItem("DeviceDetails", JSON.stringify(objDetails));
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(objDetails),
            success: function (data, status, jqXHR) {
                window.localStorage.setItem("deviceInfoSaved", true);
                window.localStorage.setItem("installedAppVersion", window.localStorage.getItem("AppVersion"))
                if (data.UpdateStatus == 1) {
                    isRedirectToAppStore = false;
                    window.localStorage.setItem("isRedirectToAppStore", "false");
                    cmn_openModelPopup(Resources.UpdateStatus_1, "", "", "", "");
                }
                else if (data.UpdateStatus == 2) {
                    //window.localStorage.setItem("isRedirectToAppStore", "true");
                    isRedirectToAppStore = true;
                    cmn_openModelPopup(Resources.UpdateStatus_2, "", "", "", "");
                }
                else {
                    window.localStorage.setItem("isRedirectToAppStore", "false");
                }
            },
            error: function (jqXHR, status, error) {
                window.localStorage.removeItem("DeviceDetails");
                if (jqXHR.responseJSON.ErrorCode == "GenericError") {
                    cmn_openModelPopup("GenericError", "", "", "");
                }
                else if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            }

        });

    },

    isAppVersionUpdated: function (installedVersion, currentVersion) {
        if (parseFloat(installedVersion) < parseFloat(currentVersion)) {
            return true;

        }
        else {
            return false;
        }
    },



    UpdateDeviceDetail: function () {
        if (window.localStorage.getItem("DeviceDetails") != null) {
            var jsonObj = JSON.parse(window.localStorage.getItem("DeviceDetails"));
            if (jsonObj.CarrierName != null && jsonObj.CarrierName != window.localStorage.getItem("CarrierName") && window.localStorage.getItem("CarrierName") === null) {
                window.localStorage.setItem("CarrierName", "*NONE*");
            }
            if (jsonObj.CarrierName2 != null && jsonObj.CarrierName2 != window.localStorage.getItem("CarrierName2") && window.localStorage.getItem("CarrierName2") === null) {
                window.localStorage.setItem("CarrierName2", "*NONE*");
            }
            if (window.localStorage.getItem("UDI") === "null" || window.localStorage.getItem("UDI") === "undefined") {
                window.localStorage.setItem("UDI", jsonObj.UDI);
            }
            if ((jsonObj.UDI != window.localStorage.getItem("UDI")) || (jsonObj.LoginId != window.localStorage.getItem("UserName")) || (jsonObj.DeviceManufacturer != window.localStorage.getItem("Manufacturer"))
               || (jsonObj.DeviceModel != window.localStorage.getItem("Model")) || (jsonObj.CarrierName != window.localStorage.getItem("CarrierName")) || (jsonObj.OSName != window.localStorage.getItem("Platform"))
               || (jsonObj.OSVersion != window.localStorage.getItem("AndroidVersion")) || (jsonObj.FirebaseToken != window.localStorage.getItem("token")) || (jsonObj.CarrierName2 != window.localStorage.getItem("CarrierName2"))
               ) {
                return true;
            }

            else {
                return false;
            }
        }
        else {
            return true;
        }
    },



    getPaymentSystems: function () {
        $("body").addClass("loading");
        var url = StageUrl + '/users/paymentsystems';
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
                    homeHelper.setPaySystem(data);
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass("loading");
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openExtModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
                else if (jqXHR.responseJSON.ErrorMessage.indexOf("Error recahrging wallet") > -1) {
                    cmn_openExtModelPopup(Resources.top_up_failure, "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
                else {
                    cmn_openExtModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "", false, "", Resources.all_alert_OK_button, Resources.all_alert_cancel_button);
                }
            }
        });
    },

    setPaySystem: function (data) {
        if (data["PaySysList"] !== null && data["PaySysList"] !== '') {
            for (i = 0; i < data["PaySysList"].length; i++) {
                if (data["PaySysList"][i]["Name"] === "CreditCard") {
                    if (data["PaySysList"][i]["EnablePayment"] === false) {
                        window.localStorage.setItem("EnablePaymentCard", false);
                    }
                    else {
                        window.localStorage.setItem("EnablePaymentCard", true);
                    }
                }
                else if (data["PaySysList"][i]["Name"] === "Wallet") {
                    if (data["PaySysList"][i]["EnablePayment"] == false) {
                        window.localStorage.setItem("EnablePaymentWallet", false);
                    }
                    else {
                        window.localStorage.setItem("EnablePaymentWallet", true);
                    }
                }
            }
        }
        $("body").removeClass("loading");
    }
}

