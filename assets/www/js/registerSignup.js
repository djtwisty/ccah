jQuery(document).ready(function () {
    loadString();
    document.addEventListener("deviceready", getdeviceDetails, false);
    document.addEventListener("deviceready", registerHelper.deviceReady, false);
    registerHelper.getLocalization();
    $("#reg-cont").height(($(window).height()) - ($("#reg-cont").offset().top) - 3);
    $(".regs-form-cont").height(($(window).height()) - ($(".regs-form-cont").offset().top) - 45);
    //window.localStorage.setItem("CountryCode", 'en');

   

    $('#registrationbtn').click(function (evt) {
        event.stopPropagation();
        registerHelper.Register();
    });

    $("#closeMsg").click(function () {
        $(".errormsg").addClass('invisible');
    });


    /* maintain other agreements in local storages.*/
    $("#acceptAgeNoticeChk").click(function () {
        if ($("#acceptAgeNoticeChk").is(':checked')) {
            window.localStorage.setItem('acceptAgeNoticeChk', true);
        }
        else {
            window.localStorage.setItem('acceptAgeNoticeChk', false);
        }
    });

    $("#commercialInformationChk").click(function () {
        if ($("#commercialInformationChk").is(':checked')) {
            window.localStorage.setItem('commercialInformationChk', true);
        }
        else {
            window.localStorage.setItem('commercialInformationChk', false);
        }
    });

    $("#marketStudiesChk").click(function () {
        if ($("#marketStudiesChk").is(':checked')) {
            window.localStorage.setItem('marketStudiesChk', true);
        }
        else {
            window.localStorage.setItem('marketStudiesChk', false);
        }
    });

    $("#affiliatedCompaniesChk").click(function () {
        if ($("#affiliatedCompaniesChk").is(':checked')) {
            window.localStorage.setItem('affiliatedCompaniesChk', true);
        }
        else {
            window.localStorage.setItem('affiliatedCompaniesChk', false);
        }
    });

    //$("#acceptAgeNoticeChk").click(function () {
    //    registerHelper.enableRegisterButton();
    //});
});

var registerHelper = {

    _phoneNumber: '',
    _password: '',
    _confirmPassword: '',
    _pin: '',
    _enteredCaptcha: '',
    _emailId: '',
    _country: '',
    _countryUId: '',
    _passwordValue: '',

    deviceReady: function () {
        cordova.plugins.SecureKeyStore.get(function (res) {
            _passwordValue = res;
            setFieldsValue();
        }, function (error) {

        }, "Password");
    },


    //enableRegisterButton: function () {
    //    if (($("#acceptAgeNoticeChk").is(':checked'))) {
    //        $("#registrationbtn").removeAttr('disabled');
    //        $("#registrationbtn").removeClass("disable_btn");
    //    }
    //    else {
    //        $("#registrationbtn").attr('disabled', 'disabled');
    //        $("#registrationbtn").addClass("disable_btn");
    //    }
    //},

    getLocalization: function () {
        $("#headerFirstpage").html(Resources.Trn_pevBtn);
        $("#registerIntro").html(Resources.Reg_page2_intro);
        $("#regPassLength").html(Resources.Register_page_passlength);
        $("#rememberMe").html(Resources.Login_Rememberme);
        $("#commercialInformationSpn").html(Resources.Additional_privacy_flag_1);
        $("#marketStudiesSpn").html(Resources.Additional_privacy_flag_2);
        $("#affiliatedCompaniesSpn").html(Resources.Additional_privacy_flag_3);
        $("#registrationbtn").html(Resources.Save_Button);
        $("#ageSpn").html(Resources.Reg_16years);
        $("#ntc_p3").html(Resources.new_terms_page_block3);
        $("#acceptAgeSpnNotice").html(Resources.Reg_16years);
    },

    Register: function () {
        try {
            $("body").addClass('loading');
            var accessToken = cmn_GetValuesFromAndroidFunction("AccessToken");
            var url = StageUrl + '/users'
            var objRegister =
            {
                'UserName': window.localStorage.getItem("UserName"),
                'Password': _passwordValue,
                'PhoneNumber': window.localStorage.getItem("UserName"),
                'IsEnabled': false,
                'Email': window.localStorage.getItem("Email"),
                'HasAcceptedTAndC': true,
                'Description': 'New Registration',
                'TAndCInfo': registerHelper.checkTAndCInfo(),
                'Country': registerHelper.getCountry(),
                'Language': registerHelper.getCountryLanguage(),
                'TimeZone': 'Central European Time',
                'HasMoreThan16Years': registerHelper.setCheckBoxAgeValue('acceptAge')
            };
            this.serviceCall(accessToken, url, objRegister);
        }
        catch (ex) {

        }
    },

    checkTAndCInfo: function () {
        return "TC:" + registerHelper.setCheckBoxesValue('acceptTermsChk') + ";PP:" + registerHelper.setCheckBoxesValue('acceptPrivacy') + ";PP_RCI:" + registerHelper.setCheckBoxesValueCurrent('#commercialInformationChk') + ";PP_PSM:" + registerHelper.setCheckBoxesValueCurrent('#marketStudiesChk') + ";PP_STC:" + registerHelper.setCheckBoxesValueCurrent('#affiliatedCompaniesChk');//+ ";PVC:" + registerHelper.setCheckBoxesValueCurrent('#acceptAgeNoticeChk');
    },

    setCheckBoxAgeValue: function (chkBox) {
        if (window.localStorage.getItem(chkBox) == "true") {
            return 1;
        }
        else {
            return 0;
        }
    },

    setCheckBoxesValueCurrent: function (chkBox) {
        if ($(chkBox).is(':checked')) {
            return 1;
        }
        else {
            return 0;
        }
    },
    setCheckBoxesValue: function (chkBox) {
        if (window.localStorage.getItem(chkBox) == "true") {
            return 1;
        }
        else {
            return 0;
        }
    },

    getCountryLanguage: function () {
        if (window.localStorage.getItem("CountryCode") == 'it') {
            return 'it';
        } else if (window.localStorage.getItem("CountryCode") == 'es') {
            return 'es';
        } else if (window.localStorage.getItem("CountryCode") == 'en') {
            return 'en';
        } else if (window.localStorage.getItem("CountryCode") == 'fr') {
            return 'fr';
        } else if (window.localStorage.getItem("CountryCode") == 'ca') {
            return 'ca';
        } else {
            return 'en';
        }
    },

    /*As per 5th August 2016 issue on ASAMA "Country setting on registration" country is set 'unknown' for en   */
    getCountry: function () {
        if (window.localStorage.getItem("CountryCode") == 'it') {
            return 'Italy';
        } else if (window.localStorage.getItem("CountryCode") == 'es') {
            return 'Spain';
        } else if (window.localStorage.getItem("CountryCode") == 'fr') {
            return 'France';
        } else if (window.localStorage.getItem("CountryCode") == 'en') {
            return 'unknown';
        } else if (window.localStorage.getItem("CountryCode") == 'ca') {
            return 'Spain';
        } else {
            return 'unknown';
        }
    },

    serviceCall: function (accessToken, url, DTO) {
        //window.location.href = 'pin_validation.html';
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': accessToken
            },
            data: JSON.stringify(DTO),
            success: function (data, status, jqXHR) {
                window.location.href = 'pin_validation.html';
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

    setFieldsValue: function () {
        if (window.localStorage.getItem('Legal_terms_registration') == 'true') {
            window.localStorage.getItem('acceptAgeNoticeChk') == 'true' ? $("#acceptAgeNoticeChk").prop('checked', true) : $("#acceptAgeNoticeChk").prop('checked', false);
            window.localStorage.getItem('commercialInformationChk') == 'true' ? $("#commercialInformationChk").prop('checked', true) : $("#commercialInformationChk").prop('checked', false);
            window.localStorage.getItem('marketStudiesChk') == 'true' ? $("#marketStudiesChk").prop('checked', true) : $("#marketStudiesChk").prop('checked', false);
            window.localStorage.getItem('affiliatedCompaniesChk') == 'true' ? $("#affiliatedCompaniesChk").prop('checked', true) : $("#affiliatedCompaniesChk").prop('checked', false);

            $('#regMobileNumber').val(window.localStorage.getItem("UserName"));
            $('#passwordreg').val(registerHelper._passwordValue);
            $('#confirmPassword').val(registerHelper._passwordValue);
            $('#textemail').val(window.localStorage.getItem("email"));

            registerHelper.enableRegisterButton();
            window.localStorage.removeItem('Legal_terms_registration');

            window.localStorage.removeItem('UserName');
            window.localStorage.removeItem('Password');
            window.localStorage.removeItem('email');
            window.localStorage.removeItem('chkVlpc');
            window.localStorage.removeItem('chkVlnc');
            window.localStorage.removeItem('isAcceptCondition');
        }
        else {
            window.localStorage.removeItem('commercialInformationChk');
            window.localStorage.removeItem('marketStudiesChk');
            window.localStorage.removeItem('affiliatedCompaniesChk');
            window.localStorage.removeItem('acceptAgeNoticeChk');

        }
    },
}
