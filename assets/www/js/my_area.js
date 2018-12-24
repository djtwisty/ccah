
jQuery(document).ready(function () {

    loadString();
    cmn_menuLocalization();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    myAreaHelper.getLocalization();
    myAreaHelper.setInnerBodyHeight();
    $(window).resize(function () {
        myAreaHelper.setInnerBodyHeight();
    });
    myAreaHelper.GetUserDetail();
    if (window.localStorage.getItem('SavedED') == 'true') {
        $('#postBonusBanner').show();
        $('#bonusBanner').hide();
    }
    else {
        $('#postBonusBanner').hide();
        $('#bonusBanner').show();
    }


    //if (window.localStorage.getItem("Phone") != 'undefined') {
    //    $('#phoneNumber').html(window.localStorage.getItem("Phone"));
    //}
    //if (window.localStorage.getItem("Email") != 'undefined') {
    //    $('#email').val(window.localStorage.getItem("Email"));
    //}

    //if (window.localStorage.getItem('Legal_terms_registration') === 'true') {
    //    window.localStorage.removeItem('Legal_terms_registration')
    //    window.localStorage.getItem('commercialInformationChk') == 'true' ? $("#commercialInformationChk").prop('checked', true) : $("#commercialInformationChk").prop('checked', false);
    //    window.localStorage.getItem('marketStudiesChk') == 'true' ? $("#marketStudiesChk").prop('checked', true) : $("#marketStudiesChk").prop('checked', false);
    //    window.localStorage.getItem('affiliatedCompaniesChk') == 'true' ? $("#affiliatedCompaniesChk").prop('checked', true) : $("#affiliatedCompaniesChk").prop('checked', false);
    //}
    //else if (window.localStorage.getItem('TAndCInfo') != null && window.localStorage.getItem('TAndCInfo') != "null" && window.localStorage.getItem('TAndCInfo') != "") {
    //    var tnc = window.localStorage.getItem('TAndCInfo').split(';');
    //    var PP_RCI = tnc[2].split(':');
    //    if (PP_RCI[1] == "0") {
    //        window.localStorage.setItem('commercialInformationChk', false);
    //        $('#commercialInformationChk').attr('checked', false);
    //        window.localStorage.setItem('commercialInformationChk', false);
    //    } else {
    //        window.localStorage.setItem('commercialInformationChk', true);
    //        $('#commercialInformationChk').attr('checked', true);
    //        window.localStorage.setItem('commercialInformationChk', true);
    //    };
    //    var PP_PSM = tnc[3].split(':');
    //    if (PP_PSM[1] == "0") {
    //        window.localStorage.setItem('marketStudiesChk', false);
    //        $('#marketStudiesChk').attr('checked', false);
    //        window.localStorage.setItem('marketStudiesChk', false);
    //    } else {
    //        window.localStorage.setItem('marketStudiesChk', true);
    //        $('#marketStudiesChk').attr('checked', true);
    //        window.localStorage.setItem('marketStudiesChk', true);
    //    }
    //    var PP_STC = tnc[4].split(':');
    //    if (PP_STC[1] == "0") {
    //        window.localStorage.setItem('affiliatedCompaniesChk', false);
    //        $('#affiliatedCompaniesChk').attr('checked', false);
    //        window.localStorage.setItem('affiliatedCompaniesChk', false);
    //    } else {
    //        window.localStorage.setItem('affiliatedCompaniesChk', true);
    //        $('#affiliatedCompaniesChk').attr('checked', true);
    //        window.localStorage.setItem('affiliatedCompaniesChk', true);
    //    }
    //}

    $("#pvt_lck").click(function () {
        window.localStorage.setItem('linkFrom', 'myArea');
        window.localStorage.setItem('chk', 'pvcy')
        window.location.href = 'privacy.html';
    });

    $("#Tnc_lck").click(function () {
        window.localStorage.removeItem('chkVlpc');
        window.localStorage.setItem('linkFrom', 'myArea');
        window.localStorage.setItem('chk', 'tnc')
        window.location.href = 'termsAndConditions.html';
    });

    $("#closeMsg").click(function () {
        $(".errormsg").addClass('invisible');
    });

    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    $("#walletCloseBtn").click(function () {
        event.stopPropagation();
        walletconfimHelper.closeConnectionVM();
    });

    $("#walletCloseDiv").click(function () {
        event.stopPropagation();
        walletconfimHelper.closeConnectionVM();
    });

    $("#saveButton").click(function () {
        if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
            window.location.href = "login.html";
        }
        else {
            myAreaHelper._eMail = $('#email').val();
            if (myAreaHelper.validateForm()) {
                cmn_openExtModelPopup(Resources.registration_doublecheck_alert_1, "", myAreaHelper._eMail, Resources.registration_doublecheck_alert_2, true, "", Resources.Edit_button, Resources.Proceed_Button);
            }
            window.localStorage.setItem("ToDetails", "false");
            window.localStorage.setItem("ToPostBonus", "false");
        }

    });

    $('#cancelbtn').click(function (evt) {
        $('#email').val('');
    });

    /* maintain other agreements in local storages.*/
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

    $("#bannerButton").click(function () {
        if (($("#commercialInformationChk").is(':checked')) && ($("#marketStudiesChk").is(':checked'))) {
            /*Changes suggested By Nicola*/
            if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
                window.location.href = "login.html";
            }
            else {
                myAreaHelper._eMail = $('#email').val();
                if (myAreaHelper.validateForm()) {
                    cmn_openExtModelPopup(Resources.registration_doublecheck_alert_1, "", myAreaHelper._eMail, Resources.registration_doublecheck_alert_2, true, "", Resources.Edit_button, Resources.Proceed_Button);
                }
            }
            window.localStorage.setItem("ToDetails", "true");
            /*Changes suggested By Nicola*/
            // window.location.href = "my_area_details.html";
        } else {
            cmn_openModelPopup(Resources.welcome_bonus_alert_1, Resources.welcome_bonus_alert_2, Resources.welcome_bonus_alert_3, "left");
        }
    });

    $("#postBonusBtn").click(function () {
        /*Changes suggested By Nicola*/
        if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
            window.location.href = "login.html";
        }
        else {
            myAreaHelper._eMail = $('#email').val();
            if (myAreaHelper.validateForm()) {
                cmn_openExtModelPopup(Resources.registration_doublecheck_alert_1, "", myAreaHelper._eMail, Resources.registration_doublecheck_alert_2, true, "", Resources.Edit_button, Resources.Proceed_Button);
            }
        }
        window.localStorage.setItem("ToPostBonus", "true");
        /*Changes suggested By Nicola*/
        //window.location.href = "my_area_postBonus.html";
    });

    $('#alertCancel').click(function (e) {
        ext_cmn_closeModelPopup();
        myAreaHelper.save();
    });

    $('#alertOkExt').click(function (e) {
        ext_cmn_closeModelPopup();
    });

    document.addEventListener("deviceready", myAreaHelper.onDeviceReady, false);
});



var myAreaHelper = {
    _fullName: '',
    _surName: '',
    _country: '',
    _eMail: '',

    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    },


    GetUserDetail: function () {
        var uname = encodeURIComponent(window.localStorage.getItem("UserName").replace(' ', ''));
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
                        window.localStorage.setItem("Email", data.Email);
                        window.localStorage.setItem('TAndCInfo', data.TAndCInfo);
                        if (window.localStorage.getItem("Phone") != 'undefined') {
                            $('#phoneNumber').html(window.localStorage.getItem("Phone"));
                        }
                        if (window.localStorage.getItem("Email") != 'undefined') {
                            $('#email').val(window.localStorage.getItem("Email"));
                        }
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

    setInnerBodyHeight: function () {
        $("#last-transaction-cont").height(($(window).height()) - ($("#last-transaction-cont").offset().top) - 20);
    },

    validateForm: function () {
        if (this._eMail == "") {
            cmn_openModelPopup(ErrorMessasges('EnterEmailId'), "", "", "");
            return false;
        }
        else if (myAreaHelper.validateEmail(this._eMail)) {
            cmn_openModelPopup(ErrorMessasges('EnterValidEmail'), "", "", "");
            return false;
        }
        else {
            return true;
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

    getLocalization: function () {
        $("#myareabannerbeforeheader").html(Resources.myarea_banner_before_header);
        $("#myareabannerbeforebody").html(Resources.myarea_banner_before_body);
        $("#myareabannerbeforebutton").html(Resources.myarea_banner_before_button);
        $("#myareabannerafterheader").html(Resources.myarea_banner_after_header);
        $("#myareabannerafterbody").html(Resources.myarea_banner_after_body);
        $("#postBonusBtn").html(Resources.myarea_banner_after_button);

        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#accountTitle").html(Resources.AccountLeftTab);
        $("#mobilNumLabel").html(Resources.Lable_LoginNo);
        $("#my_opt_in_out_intro").html(Resources.my_opt_in_out_intro);
        $("#commercialInformationSpn").html(Resources.Additional_privacy_flag_1);
        $("#marketStudiesSpn").html(Resources.Additional_privacy_flag_2);
        $("#affiliatedCompaniesSpn").html(Resources.Additional_privacy_flag_3);
        $("#my_area_privacy_terms_links").html(Resources.my_area_privacy_terms_links);
        $("#myMenuTitle").html(Resources.mymenu_title);
        $('#name').attr('placeholder', Resources.Ac_NameLabel);
        $('#surname').attr('placeholder', Resources.Ac_SurnameLabel);
        $("#infoUtil").html(Resources.useful_info_menu);
        $('#plCtry').html(Resources.Ac_CountryLabel);
        $('#email').attr('placeholder', Resources.Ac_EmailLabel);
        $("#saveButton").html(Resources.button_save);
        $("#cancelbtn").html(Resources.button_delete);
        $("#bannerButton").html(Resources.myarea_button02);
        $("#alertOk").html(Resources.all_alert_OK_button);
        $("#backToHome").attr("aria-label", Resources.tb_HomeIcon);
    },

    save: function () {
        $("body").addClass('loading');

        window.localStorage.setItem('TAndCInfo', myAreaHelper.checkTAndCInfo());
        window.localStorage.setItem("Email", this._eMail);
        var objAccountInfo =
        {
            'Email': this._eMail,
            'UserUId': window.localStorage.getItem("UserUId"),
            'Language': window.localStorage.getItem("CountryCode"),
            'TAndCInfo': window.localStorage.getItem('TAndCInfo')
        };
        try {
            cmn_getRefreshTokenWithCallback(this.apiCall, objAccountInfo);
        }
        catch (ex) {

        }
    },

    apiCall: function (DTO) {
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
                cmn_openModelPopup(ErrorMessasges('My_account_save_confirm'), "", "", "");
                $('html, body').animate({ scrollTop: 0 }, 0);
                if (window.localStorage.getItem("ToDetails") == "true") {
                    window.location.href = "my_area_details.html";
                }
                else if (window.localStorage.getItem("ToPostBonus") == "true") {
                    window.location.href = "my_area_postBonus.html";
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
                $('html, body').animate({ scrollTop: 0 }, 0);
            }
        });
    },

    checkTAndCInfo: function () {
        return "TC:1;PP:1;PP_RCI:" + myAreaHelper.setCheckBoxesValue('#commercialInformationChk') + ";PP_PSM:" + myAreaHelper.setCheckBoxesValue('#marketStudiesChk') + ";PP_STC:" + myAreaHelper.setCheckBoxesValue('#affiliatedCompaniesChk');
    },

    setCheckBoxesValue: function (chkBox) {
        if ($(chkBox).is(':checked')) {
            return 1;
        }
        else {
            return 0;
        }
    },
}