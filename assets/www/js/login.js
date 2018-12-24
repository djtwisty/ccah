jQuery(document).ready(function () {
    loadString();

    loginHelper.getLocalization();
    document.addEventListener("deviceready", loginHelper.deviceReady, false);
    document.addEventListener("backbutton", loginHelper.onBackKeyDown, false);
    if (window.matchMedia('(min-width: 768px)').matches) {
        $("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) - 20);
    }
    else {
        $("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) - 10);
    }

    window.localStorage.setItem("isScannButtonClicked", 'false')
    

    $('.click_h').on('click', function () {
        var top = $("#popup-pos").offset().top;


        $('.popup-info').css({
            top: top,
            position: 'absolute',
        });
    });

    

    $("#password").keyup(function (event) {
        if (event.keyCode == 13) {
            document.activeElement.blur();

        }

    });

    $('#loginbtn').click(function (evt) {

        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        document.activeElement.blur();
        $("body").addClass('loading');
        /*comment this line for browser debugging*/
       // document.addEventListener("deviceready", onDeviceReady, window.localStorage.setItem("AppVersion", AppVersion.version), false);
        var number = $('#mobileNumber').val().replace(' ', '');
        loginHelper._number = number;
        window.localStorage.setItem("UserName", loginHelper._number);
        loginHelper._password = $('#password').val();
        cmn_EncyrptPassword("_password",loginHelper._password);

        if (loginHelper.validateForm()) {
            RememberMe();
            loginHelper.Login()
        }
        else {
            $("body").removeClass('loading');
        }

    });

    $("#rememberme").click(function () {
        if ($("#rememberme").is(':checked')) {
            RememberMe();
        }
        else {
            window.localStorage.removeItem("_phoneNumber");
            window.localStorage.removeItem("_phoneNumber");
            $('#rememberme').attr('checked', false);
            window.localStorage.setItem('RememberPwd', 'unChecked');
            window.localStorage.setItem("continueLogin", 'No');
        }
    });


    $('#newUserBtn').click(function (evt) {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }

        $("body").addClass('loading');
        _isPinValidation = false;
        RememberMe();
        Registration();
    });

    $("#infoDiv").click(function () {
        $('#loginInfo').removeClass('invisible');
        $('#rmifo').removeClass('invisible');
        $('#fgmeinfo').removeClass('invisible');
        $('#newUserinfo').removeClass('invisible');
        $("#infoPt").removeClass('invisible');
    });

    $("#closeBtn").click(function () {
        $('#loginInfo').addClass('invisible');
        $('#rmifo').addClass('invisible');
        $('#fgmeinfo').addClass('invisible');
        $('#newUserinfo').addClass('invisible');
        $("#infoPt").addClass('invisible');
    });


    $('#headerFAQ').click(function (evt) {
        window.location.href = 'faq.html';
    });

    $('#linkClickHere').click(function (evt) {
        /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }

        if ($('#mobileNumber').val().replace(' ', '') == "") {
            cmn_openModelPopup(ErrorMessasges('MobileNoToRetrivePwd'), "", "", "");
            return false;
        }
        else if ($('#mobileNumber').val().length < 6) {
            cmn_openModelPopup(ErrorMessasges('EnterValidMobileNumber'), "", "", "");
        } else {
            loginHelper.RecoverPassword();
        }
    });

    $('#menu').click(function (e) {
        $('#menuList').removeClass('hidden');
    });

    $("#alertOk").click(function () {
        $("body").removeClass("loading");
    });

});

var loginHelper = {
    _winHeight: '',
    _number: '',
    _password: '',
    _isKillDueToDelay: false,
    _isPinValidation: false,
    _passwordValue:'',


    isTalkBackRunningCallback: function (boolean) {
        if (boolean) {
            MobileAccessibility.speak('Hello coffee app top.');
            setTimeout(function () {
                if (MobileAccessibility.isChromeVoxActive()) {
                } else {

                    /* Notify the user of a potential problem */
                    MobileAccessibility.speak('Hello coffee app.');
                }
            }, 5000);
            // Do something to improve the behavior of the application while a screen reader is active.
        }
        else {
            alert("Screen reader: OFF");
        }
    },


    deviceReady: function () {
        getFirebaseToken();
        openNotification();
       // onDeviceReady();
        cordova.plugins.SecureKeyStore.get(function (res) {
            _passwordValue = res;
            if (window.localStorage.getItem('_phoneNumber') != undefined) {
                $('#mobileNumber').val(window.localStorage.getItem('_phoneNumber'));
                $('#mobileNumber').data('plugin_intlTelInput')._updateFlagFromInputVal();
                $('#password').val(_passwordValue);
                $('#rememberme').attr('checked', true);
                if (window.localStorage.getItem('UserUId') != null) {
                    loginHelper._number = $('#mobileNumber').val().replace(' ', '');
                    loginHelper._password = $('#password').val();
                    loginHelper.Login();
                }
            }
            else {
                $('#Password').val('');
                $('#rememberme').attr('checked', false);
            }

        }, function (error) {

        }, "_password");

       // _passwordValue = cmn_DecyrptPassword("_password");
        window.localStorage.setItem("AppVersion", AppVersion.version);
    },

    scanWithFlashlight: function () {
        cordova.plugins.barcodeScanner.scan(
          function (result) {
              loginHelper.scanResult(result);
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
    },

    scanner: function () {
        cordova.plugins.barcodeScanner.scan(
           function (result) {
               loginHelper.scanResult(result);
           },
        function (error) {
            alert("Scanning failed: " + error);
        },
        {
            orientation: "portrait", // Android only (portrait|landscape), default unset so it rotates with the device
        });
    },

    scanResult: function (result) {
        var _vmcode = return_scan_qrcode(result.text);
        if (result.cancelled) {
            window.location.href = "home.html";
        }
        else if (window.localStorage.getItem("PaymentMode") === "CreditCard") {
            cmn_setPaymentMode(_vmcode, "", "", "card", "scanner");
        } else if (window.localStorage.getItem("PaymentMode") === "wallet") {
            cmn_setPaymentMode(_vmcode, "", "", "wallet", "scanner");
        }
        else {
            window.location.href = 'home.html';
        }
    },

    onBackKeyDown: function () {
        window.localStorage.setItem("takeBackGround", 'true');
        navigator.app.exitApp();
    },

    enableRegisterButton: function () {
        if (($("#acceptPrivacy").is(':checked')) && ($("#acceptTermsChk").is(':checked'))) {
            $("#registrationbtn").removeAttr('disabled');
            $("#registrationbtn").removeClass("regdisable_btn");
            $("#registrationbtn").addClass('orng_btn');
        }
        else {
            $("#registrationbtn").attr('disabled', 'disabled');
            $("#registrationbtn").removeClass('orng_btn');
            $("#registrationbtn").addClass("regdisable_btn");
        }
    },

    validateForm: function () {

        if (this._number == "") {
            cmn_openModelPopup(ErrorMessasges('EnterMobileNumber'), "", "", "");
            return false;
        }
        else if (this._password == "") {
            cmn_openModelPopup(ErrorMessasges('EnterPassword'), "", "", "");
            return false;
        }
        else
            return true;
    },

    getLocalization: function () {
        $("#headerLogin").html(Resources.Header_Login);
        $("#lblLoginNo").html(Resources.Lable_LoginNo);
        $("#lblPassword").html(Resources.Lable_LoginPwd);
        $("#lblRememberme").html(Resources.Login_Rememberme);
        $("#lblForgetPassword").html(Resources.Login_ForgerPwd);
        $("#linkClickHere").html(Resources.Link_Clickhere);
        $("#loginbtn").html(Resources.Login_Button);
        $("#newUserBtn").html(Resources.New_user_button);
        $("#headerFAQ").html(Resources.Header_FAQ);
        $("#lblInfo").html(Resources.Info_LOGIN_Title);
        $("#lblInfo1").html(Resources.Info_LOGIN_label_1);
        $("#lblInfo2").html(Resources.Info_LOGIN_label_2);
        $("#lblInfo3").html(Resources.Info_LOGIN_label_3);
        $("#lblInfo4").html(Resources.Info_LOGIN_label_4);
        $("#headerFAQ").attr('aria-label', Resources.tb_Header_FAQ);
        $("#imgI").attr('aria-label', Resources.tb_Information_login);
        $("#linkClickHere").attr('aria-label', Resources.tb_Link_Clickhere);

    },

    NumericValidate: function (field) {

        if (!field.match(/^[\-\+]?[\d\,]*\.?[\d]*$/)) {
            alert("only Numerics allow");
            return false;
        }

    },

    isNumberKey: function (evt) {
        var charCode = (evt.which) ? evt.which : event.keyCode
        if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

        return true;
    },

    Login: function () {
        $("body").addClass('loading');
        var status = cmn_CallingAuthenticationAPI($('#mobileNumber').val().replace(' ', ''), $('#password').val());
        this.Authentication(status);
    },

    Authentication: function (status) {
        try {
            var timeOutVar = setTimeout(function () {
                loginHelper._isKillDueToDelay = true;
                cmn_openModelPopup(ErrorMessasges("UserTimeExpired"), "", "", "");
            }, 15000);

            if (status == "success") {
                clearTimeout(timeOutVar);
                if (!loginHelper._isKillDueToDelay) {
                    this.RedirectToMain(status)
                } else {
                    loginHelper._isKillDueToDelay = false;
                }
            }
            else {
                clearTimeout(timeOutVar);
                if (loginHelper._isKillDueToDelay) {
                    loginHelper._isKillDueToDelay = false;
                    return false;
                }
                $("body").removeClass("loading");
                if (status == 'UserIsDisabled') {
                    loginHelper.Re_register();
                }
                else {
                    cmn_openModelPopup(ErrorMessasges(status), "", "", "");
                }
            }
        }
        catch (ex) {

        }
    },

    RedirectToMain: function (status) {
        if (status == "success") {
               window.localStorage.setItem("TokenExpire", GetTokenExpiration(cmn_GetValueOfTokenExpire() - 300));
            /*Comment this line for Browser debugging*/
            AndroidFunction.showToast();
            loginHelper.GetUserDetail();
        }
    },

    GetUserDetail: function () {
        var uname = encodeURIComponent(loginHelper._number);
        var url = StageUrl + '/users/?uname=' + uname;
        try {
            this._xhr = jQuery.ajax({
                method: 'GET',
                url: url,
                dataType: 'json',
                headers: {
                    'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
                },
                success: function (data, status, jqXHR) {
                    if (status == "success") {
                        window.localStorage.setItem("UserUId", data.UserUId);
                        window.localStorage.setItem("FirstName", data.FirstName);
                        window.localStorage.setItem("SurName", data.LastName);
                        window.localStorage.setItem("Email", data.Email);
                        window.localStorage.setItem("Phone", data.Phone);
                        window.localStorage.setItem("Country", data.Country);
                        window.localStorage.setItem('Language', data.Language);
                        window.localStorage.setItem("CountryCode",  data.Language);
                        window.localStorage.setItem('EmailConfirmed', data.EmailConfirmed);
                        window.localStorage.setItem('PhoneConfirmed', data.PhoneConfirmed);
                        window.localStorage.setItem('TAndCInfo', data.TAndCInfo);
                        window.localStorage.setItem('HasAcceptedTAndC', data.HasAcceptedTAndC);
                        window.localStorage.setItem('HasMoreThan16Years', data.HasMoreThan16Years);
                        // window.localStorage.setItem("CountryCode","en")
                        /**/
                        if (window.localStorage.getItem('Legal_terms_registration') === 'true') {
                            window.localStorage.removeItem('Legal_terms_registration')
                            window.localStorage.getItem('commercialInformationChk') == 'true' ? $("#commercialInformationChk").prop('checked', true) : $("#commercialInformationChk").prop('checked', false);
                            window.localStorage.getItem('marketStudiesChk') == 'true' ? $("#marketStudiesChk").prop('checked', true) : $("#marketStudiesChk").prop('checked', false);
                            window.localStorage.getItem('affiliatedCompaniesChk') == 'true' ? $("#affiliatedCompaniesChk").prop('checked', true) : $("#affiliatedCompaniesChk").prop('checked', false);
                        }
                        else if (window.localStorage.getItem('TAndCInfo') != null && window.localStorage.getItem('TAndCInfo') != "null" && window.localStorage.getItem('TAndCInfo') != "") {
                            var tnc = window.localStorage.getItem('TAndCInfo').split(';');
                            var PP_RCI = tnc[2].split(':');
                            if (PP_RCI[1] == "0") {
                                window.localStorage.setItem('commercialInformationChk', false);
                                $('#commercialInformationChk').attr('checked', false);
                                window.localStorage.setItem('commercialInformationChk', false);
                            } else {
                                window.localStorage.setItem('commercialInformationChk', true);
                                $('#commercialInformationChk').attr('checked', true);
                                window.localStorage.setItem('commercialInformationChk', true);
                            };
                            var PP_PSM = tnc[3].split(':');
                            if (PP_PSM[1] == "0") {
                                window.localStorage.setItem('marketStudiesChk', false);
                                $('#marketStudiesChk').attr('checked', false);
                                window.localStorage.setItem('marketStudiesChk', false);
                            } else {
                                window.localStorage.setItem('marketStudiesChk', true);
                                $('#marketStudiesChk').attr('checked', true);
                                window.localStorage.setItem('marketStudiesChk', true);
                            }
                            var PP_STC = tnc[4].split(':');
                            if (PP_STC[1] == "0") {
                                window.localStorage.setItem('affiliatedCompaniesChk', false);
                                $('#affiliatedCompaniesChk').attr('checked', false);
                                window.localStorage.setItem('affiliatedCompaniesChk', false);
                            } else {
                                window.localStorage.setItem('affiliatedCompaniesChk', true);
                                $('#affiliatedCompaniesChk').attr('checked', true);
                                window.localStorage.setItem('affiliatedCompaniesChk', true);
                            }
                        }
                        /**/
                        var splitstring = data.TAndCInfo.split('PP:');
                        var PP = (splitstring[1].split(';'))[0];
                        if (PP == 1) {
                            window.localStorage.setItem('AcceptPrivacy', true);
                        }
                        else {
                            window.localStorage.setItem('AcceptPrivacy', false);
                        }

                        var firstPvc = splitstring[1].split('PP_RCI:');
                        var PP_RCI = (firstPvc[1].split(';'))[0];
                        if (PP_RCI == 1) {
                            window.localStorage.setItem('PP_RCI', true);
                        }
                        else {
                            window.localStorage.setItem('PP_RCI', false);
                        }

                        var secondPvc = splitstring[1].split('PP_PSM:');
                        var PP_PSM = (secondPvc[1].split(';'))[0];
                        if (PP_PSM == 1) {
                            window.localStorage.setItem('PP_PSM', true);
                        }
                        else {
                            window.localStorage.setItem('PP_PSM', false);
                        }

                        var thirdPvc = splitstring[1].split('PP_STC:');
                        var PP_STC = (thirdPvc[1].split(';'))[0];
                        if (PP_STC == 1) {
                            window.localStorage.setItem('PP_STC', true);
                        }
                        else {
                            window.localStorage.setItem('PP_STC', false);
                        }

                        if ((window.localStorage.getItem('HasMoreThan16Years') === "false") || (window.localStorage.getItem('HasMoreThan16Years') === false)) {
                            window.location.href = "importantNotice.html";
                        }
                        else if (data.EmailConfirmed && data.PhoneConfirmed) {
                            loginHelper.GetCreditCardInfo();
                        }
                        else if (!data.EmailConfirmed && !data.PhoneConfirmed) {
                            window.localStorage.setItem('callPinAPI', true);
                            window.location.href = "pin_validation.html";
                        }
                        else if (!data.PhoneConfirmed) {
                            window.localStorage.setItem('callPinAPI', true);
                            window.location.href = "pin_validation.html";
                        }
                        else if (!data.EmailConfirmed) {
                            window.location.href = "email-validation.html";
                        }
                        else {
                            loginHelper.Re_register();
                        }
                    }
                },
                error: function (jqXHR, status, error) {
                    $("body").removeClass("loading");
                    if (jqXHR.responseJSON.ErrorCode === "UserNotExists") {
                        cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                    } else {
                        cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.error_description), "", "", "");
                    }
                }
            });
        }
        catch (ex) {

        }
    },

    GetCreditCardInfo: function () {
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/cards';
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
                    if (data['Cards'] != null && data['Cards'][0]['IsEnabled'] == true) {
                        window.localStorage.setItem("CreditCardInfoSave", "true");
                    } else {
                        window.localStorage.setItem("CreditCardInfoSave", "false");

                    }
                    loginHelper.checkNotViewedNotifications_FrmLogin();
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass("loading");
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.error_description), "", "", "");
            }
        });
    },

    Re_register: function () {
        _isPinValidation = true
        Registration();
    },

    /*Method to check promo pup-up*/
    checkPromoPupUp_Lgn: function () {
        var url = StageUrl + '/notifications/newer/count?notificationtype=3 ';
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
                    if (data.Total > 0) {
                        window.location.href = 'login_promo.html';
                    } else {
                        loginHelper.redirectToHome();
                    }
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass("loading");
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.error_description), "", "", "");
            }
        });
    },

    /*Method to choose Home page.*/
    redirectToHome: function () {
        if (window.localStorage.getItem("notificationType") === "3") {
            window.localStorage.removeItem("notificationType");
            window.location.href = 'promo-page.html';
        } else if (window.localStorage.getItem("notificationType") === "1") {
            window.location.href = 'home.html';
        }
        else if (window.localStorage.getItem("scannerLaunch") === 'true') {
            $("body").removeClass("loading");
            $("body").addClass("whiteLoading");
            loginHelper.setHomePage();
        }
        else {
            window.location.href = 'home.html';
        }
    },

    /*Method to set credit or wallet as home page.*/
    setHomePage: function () {
        if (window.localStorage.getItem('isFlashEnable') === 'true') {
            loginHelper.scanWithFlashlight();
        }
        else {
            loginHelper.scanner();
        }
    },

    RecoverPassword: function () {
        try {
            $("body").addClass('loading');
            var status = cmn_AuthenticationAPIByRecoveringToken();
            jQuery.support.cors = true;

            if (status = "success") {
                
                    var objJsonBody = { UserName: $('#mobileNumber').val().replace(' ', '') };
                    this._xhr = jQuery.ajax({
                        method: 'POST',
                        url: StageUrl + '/users/resetpwd',
                        contentType: 'application/json',
                        headers: {
                            'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
                        },
                        data: JSON.stringify(objJsonBody),
                        success: function (data, status, jqXHR) {
                            if (status == "success") {
                                $("body").removeClass('loading');
                                cmn_openModelPopup(ErrorMessasges('PasswordReset'), "", "", "");
                                // cmn_openModelPopup(ErrorMessasges('PasswordSendSucessfully'), "", "", "");
                            }
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
            }
            else {
                $("body").removeClass('loading');
                cmn_openModelPopup(ErrorMessasges(status), "", "", "");
            }
        } catch (ex) {

        }
    },


    checkNotViewedNotifications_FrmLogin: function () {
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
                    loginHelper.checkPromoPupUp_Lgn();
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

}
