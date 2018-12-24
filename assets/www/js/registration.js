jQuery(document).ready(function () {
    loadString();
    document.addEventListener("deviceready", getdeviceDetails, false);
    document.addEventListener("deviceready", registerHelper.deviceReady, false);
    registerHelper.getLocalization();
    $("#reg-cont").height(($(window).height()) - ($("#reg-cont").offset().top) - 3);
    $(".regs-form-cont").height(($(window).height()) - ($(".regs-form-cont").offset().top) - 45);

    $('.click_h').on('click', function () {
        var top = $("#popup-pos").offset().top;
        $('.popup-info').css({
            top: top,
            position: 'absolute',
        });
    });

    

    $('#registrationbtn').click(function (evt) {
        event.stopPropagation();
        registerHelper.registerUser();
    });

    $("#tncLink").bind("click", function () {
        registerHelper.setFieldsValue();
        window.localStorage.setItem('linkFrom', 'register');
        window.localStorage.setItem('chkVlnc', 'tnc');
        window.localStorage.removeItem('chkVlpc');
        window.location.href = 'termsAndConditions.html';
    });

    $("#acceptTermsChk").click(function () {
        if ($("#acceptTermsChk").is(':checked')) {
            if ($("#acceptPrivacy").is(':checked')) {
                window.localStorage.setItem('acceptPrivacy', true);
            }
            else {
                window.localStorage.setItem('acceptPrivacy', false);
            }
            registerHelper.setFieldsValue();
        }
        else {
            window.localStorage.setItem('acceptTermsChk', false);
        }
    });

    $("#closeMsg").click(function () {
        $(".errormsg").addClass('invisible');
    });

    $("#privacyLink").bind("click", function () {
        registerHelper.setFieldsValue();
        window.localStorage.setItem('linkFrom', 'register');
        window.localStorage.setItem('chkVlpc', 'pvc');
        window.localStorage.removeItem('chkVlnc');
        window.location.href = 'privacy.html';
    });

    $("#acceptPrivacy").click(function () {
        if ($("#acceptPrivacy").is(':checked')) {
            if ($("#acceptTermsChk").is(':checked')) {
                window.localStorage.setItem('acceptTermsChk', true);
            }
            else {
                window.localStorage.setItem('acceptTermsChk', false);
            }

            registerHelper.setFieldsValue();
        }
        else {
            window.localStorage.setItem('acceptPrivacy', false);
        }
    });

    $("#acceptAge").click(function () {
        if ($("#acceptAge").is(':checked')) {
            if ($("#acceptAge").is(':checked')) {
                window.localStorage.setItem('acceptAge', true);
            }
            else {
                window.localStorage.setItem('acceptAge', false);
            }
            registerHelper.setFieldsValue();
        }
        else {
            window.localStorage.setItem('acceptAge', false);
        }
    });

    /* maintain other agreements in local storages.*/
    //$("#commercialInformationChk").click(function () {
    //    if ($("#commercialInformationChk").is(':checked')) {
    //        window.localStorage.setItem('commercialInformationChk', true);
    //    }
    //    else {
    //        window.localStorage.setItem('commercialInformationChk', false);
    //    }
    //});

    //$("#marketStudiesChk").click(function () {
    //    if ($("#marketStudiesChk").is(':checked')) {
    //        window.localStorage.setItem('marketStudiesChk', true);
    //    }
    //    else {
    //        window.localStorage.setItem('marketStudiesChk', false);
    //    }
    //});

    //$("#affiliatedCompaniesChk").click(function () {
    //    if ($("#affiliatedCompaniesChk").is(':checked')) {
    //        window.localStorage.setItem('affiliatedCompaniesChk', true);
    //    }
    //    else {
    //        window.localStorage.setItem('affiliatedCompaniesChk', false);
    //    }
    //});

    $("#acceptPrivacy, #acceptTermsChk,#acceptAge").click(function () {
        registerHelper.enableRegisterButton();
    });

    $('#cancelbtn').click(function (evt) {
        $('#regMobileNumber').val('');
        $('#passwordreg').val('');
        $('#confirmPassword').val('');
        $('#defaultReal').val('');
        $('#acceptTermsChk').attr('checked', false);
        $('#acceptPrivacy').attr('checked', false);
        $('#acceptAge').attr('checked', false);
        $("#registrationbtn").attr('disabled', 'disabled');
        $("#registrationbtn").removeClass('orng_btn');
        $("#registrationbtn").addClass("regdisable_btn");

    });

    $("#infoDiv").click(function () {
        $("#infoPt").removeClass('invisible');
    });

    $("#closeBtn").click(function () {
        $("#infoPt").addClass('invisible');
    });

    $("#headerLogin").click(function () {
        window.location.href = 'login.html';
    });

    $("#headerFAQ").click(function () {
        window.location.href = 'faq.html';
    });

    $("#regMobileNumber").on("focusout", function (e) {
        if ($("#regMobileNumber").val() != '') {
            registerHelper.validatePhoneNumber($("#regMobileNumber").val().replace(' ', ''));
        }
    });

    $('#alertCancel').click(function (e) {
        ext_cmn_closeModelPopup();
        registerHelper.Register();
    });

    $('#alertOkExt').click(function (e) {
        ext_cmn_closeModelPopup();
    });
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
            setValues();
        }, function (error) {

        }, "Password");
    },

    registerUser: function () {
        document.activeElement.blur();
        if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
            window.location.href = "login.html";
        } else {
            var captchaText = window.localStorage.getItem('captchaValue');
            registerHelper._phoneNumber = $('#regMobileNumber').val().replace(' ', '');
            registerHelper._password = $('#passwordreg').val();
            registerHelper._confirmPassword = $('#confirmPassword').val();
            registerHelper._pin = $('#requestPin').val();
            registerHelper._emailId = $('#textemail').val();
            if (registerHelper.validateForm()) {
                cmn_openExtModelPopup(Resources.registration_doublecheck_alert_1, this._phoneNumber, this._emailId, Resources.registration_doublecheck_alert_2, true, "", Resources.Edit_button, Resources.Proceed_Button);
            }
        }
    },

    enableRegisterButton: function () {
        if (($("#acceptPrivacy").is(':checked')) && ($("#acceptTermsChk").is(':checked')) && ($("#acceptAge").is(':checked'))) {
            $("#registrationbtn").removeAttr('disabled');
            $("#registrationbtn").removeClass("disable_btn");
        }
        else {
            $("#registrationbtn").attr('disabled', 'disabled');
            $("#registrationbtn").addClass("disable_btn");
        }
    },

    getLocalization: function () {
        $("#headerLogin").html(Resources.Header_Login2);
        $("#headerFAQ").html(Resources.Header_FAQ);
        $("#lblLoginNo").html(Resources.Lable_LoginNo);
        $("#lblemail").html(Resources.Reg_email);
        $("#lblPwd").html(Resources.Reg_PassLable);
        $("#lblConPwd").html(Resources.Reg_ConfPassLable);
        $("#regPassLength").html(Resources.Register_page_passlength);
        $("#rememberMe").html(Resources.Login_Rememberme);
        $("#acceptTermsSpn").html(Resources.Reg_AcceptTandC);

        $("#tncLink").html(Resources.Reg_AcceptTandCLink);
        $("#privacySpn").html(Resources.Reg_AcceptPrivacy);

        $("#privacyLink").html(Resources.Reg_AcceptPrivacyLink);
        $("#commercialInformationSpn").html(Resources.Additional_privacy_flag_1);
        $("#marketStudiesSpn").html(Resources.Additional_privacy_flag_2);

        $("#affiliatedCompaniesSpn").html(Resources.Additional_privacy_flag_3);

        $("#lblRegInfo").html(Resources.info_REGISTRATION_title);
        $("#lblRegInfo1").html(Resources.info_REGISTRATION_label1);
        $("#lblRegInfo2").html(Resources.info_REGISTRATION_label2);
        //$("#registrationbtn").html(Resources.Save_Button);
        $("#registrationbtn").html(Resources.Registration_next_button);
        $("#ageSpn").html(Resources.Reg_16years);

        $("#headerFAQ").attr('aria-label', Resources.tb_Header_FAQ);
        $("#imgI").attr('aria-label', Resources.tb_Information_SignUp);

    },

    setFieldsValue: function () {
        window.localStorage.setItem("UserName", $('#regMobileNumber').val());

        cmn_EncyrptPassword("Password", $('#passwordreg').val());

        window.localStorage.setItem("email", $('#textemail').val());
        if ($("#acceptTermsChk").is(':checked')) {
            window.localStorage.setItem('acceptTermsChk', true);
        }
        else {
            window.localStorage.setItem('acceptTermsChk', false);
        }

        if ($("#acceptPrivacy").is(':checked')) {
            window.localStorage.setItem('acceptPrivacy', true);
        }
        else {
            window.localStorage.setItem('acceptPrivacy', false);
        }
        if ($("#acceptAge").is(':checked')) {
            window.localStorage.setItem('acceptAge', true);
        }
        else {
            window.localStorage.setItem('acceptAge', false);
        }
    },

    validateForm: function () {

        var passwordPattern = (/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#.@$!_*?&-])[A-Za-z\d#.@$!_*?&-]{8,16}$/);

        if (this._phoneNumber == "" || this._phoneNumber == "+1") {
            cmn_openModelPopup(ErrorMessasges('EnterMobileNumber'), "", "", "");
            return false;
        }
        else if (this._emailId == "") {
            cmn_openModelPopup(ErrorMessasges('EnterEmailId'), "", "", "");
            return false;
        }
        else if (registerHelper.validateEmail(this._emailId)) {
            cmn_openModelPopup(ErrorMessasges('EnterValidEmail'), "", "", "");
            return false;
        }
        else if (this._password == "") {
            cmn_openModelPopup(ErrorMessasges('EnterPassword'), "", "", "");
            return false;
        }
            //else if (this._phoneNumber.length < 13) {
            //    cmn_openModelPopup(ErrorMessasges('MobileNumber_minimum_length'), "", "", "");
            //    return false;
            //}
            //else if (this._phoneNumber.length > 13) {
            //    cmn_openModelPopup(ErrorMessasges('MobileNumber_max_length'), "", "", "");
            //    return false;
            //}

        else if (!this._password.match(passwordPattern)) {
            cmn_openModelPopup(ErrorMessasges('Password_requirement'), "", "", "");
            return false;
        }
        else if (this._confirmPassword == "") {
            cmn_openModelPopup(ErrorMessasges('EnterConfirmPassword'), "", "", "");
            return false;
        }
        else if (this._password != this._confirmPassword) {
            cmn_openModelPopup(ErrorMessasges('PasswordMissMatch'), "", "", "");
            return false;
        }
        else
            return true;
    },
    validatePin: function () {

        if (this._phoneNumber == "") {
            cmn_openModelPopup(ErrorMessasges('EnterMobileNumber'), "", "", "");
            return false;
        }
        else
            return true;
    },

    validatePhoneNumber: function (inputtxt) {
        if (inputtxt.substring(0, 2) === '+1') {
            var phoneno = /^(\+[\d]{0}|0)?[1-9]\d{8,14}$/;
        } else {
            var phoneno = /^(\+[\d]{1,2}|0)?[1-9]\d{8,12}$/;
        }
        if (phoneno.test(inputtxt)) {
            return true;
        }
        else {
            cmn_openModelPopup(ErrorMessasges('invalid_mobile_number'), "", "", "");
            $("#regMobileNumber").val('');
            return false;
        }
    },

    numericValidate: function (field) {

        if (!field.match(/^[\-\+]?[\d\,]*\.?[\d]*$/)) {
            alert("only Numerics allow");
            return false;
        }

    },

    validateEmail: function (sEmail) {
        var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        if (filter.test(sEmail)) {
            return false;
        }
        else {
            return true;
        }
    },

    isNumberKey: function (evt) {
        var charCode = (evt.which) ? evt.which : event.keyCode
        if (charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

        return true;
    },
    Register: function () {
        try {
            $("body").addClass('loading');
            window.localStorage.setItem("UserName", this._phoneNumber);
            cmn_EncyrptPassword("Password", this._password);
            window.localStorage.setItem("Email", this._emailId);
            // alert(window.localStorage.getItem('acceptTermsChk'));
            window.location.href = "registerSignup.html";
            //this.serviceCall(accessToken, url, objRegister);
        }
        catch (ex) {

        }
    },
    setValues: function () {
        if (window.localStorage.getItem('Legal_terms_registration') == 'true') {

            window.localStorage.getItem('acceptTermsChk') == 'true' ? $("#acceptTermsChk").prop('checked', true) : $("#acceptTermsChk").prop('checked', false);
            window.localStorage.getItem('acceptPrivacy') == 'true' ? $("#acceptPrivacy").prop('checked', true) : $("#acceptPrivacy").prop('checked', false);
            window.localStorage.getItem('acceptAge') == 'true' ? $("#acceptAge").prop('checked', true) : $("#acceptAge").prop('checked', false);

            if (window.localStorage.getItem('chkVlnc') == 'tnc' && window.localStorage.getItem('isAcceptCondition') == 'true') {
                $("#acceptTermsChk").prop('checked', true);
            }

            if (window.localStorage.getItem('chkVlpc') == 'pvc' && window.localStorage.getItem('isAcceptCondition') == 'true') {
                $("#acceptPrivacy").prop('checked', true);
            }

            //window.localStorage.getItem('commercialInformationChk') == 'true' ? $("#commercialInformationChk").prop('checked', true) : $("#commercialInformationChk").prop('checked', false);
            //window.localStorage.getItem('marketStudiesChk') == 'true' ? $("#marketStudiesChk").prop('checked', true) : $("#marketStudiesChk").prop('checked', false);
            //window.localStorage.getItem('affiliatedCompaniesChk') == 'true' ? $("#affiliatedCompaniesChk").prop('checked', true) : $("#affiliatedCompaniesChk").prop('checked', false);

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
            window.localStorage.removeItem('acceptPrivacy');
            window.localStorage.removeItem('acceptTermsChk');
            window.localStorage.removeItem('acceptAge');

        }
    }
    /*
    RegisterCallback: function (status, data) {
        window.localStorage.setItem('pinRequestTime', new Date());
        if (status == 'success') {
            var serviceUrl = StageUrl + '/pins';
            var accessToken = cmn_GetValuesFromAndroidFunction("AccessToken");
            var objJson =
         {
             'UserName': window.localStorage.getItem("UserName")
         }
            try {
                this._xhr = jQuery.ajax({
                    method: 'POST',
                    url: serviceUrl,
                    crossDomain: true,
                    dataType: 'json',
                    contentType: 'application/json',
                    headers: {
                        'Authorization': accessToken
                    },
                    data: JSON.stringify(objJson),

                    success: function (data, status, jqXHR) {
                        if (status == "success") {
                            window.localStorage.setItem("PinId", data.PinId);
                            window.localStorage.setItem("Password", registerHelper._password);
                            window.localStorage.setItem('UserName', registerHelper._phoneNumber);
                            window.location.href = 'pin_validation.html';
                            verifyMobileNumber();
                            return;
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
            catch (ex) {
            }

        }
    },*/


}
