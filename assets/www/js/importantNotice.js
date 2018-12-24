jQuery(document).ready(function () {
    loadString();
    conditionHelper.getLocalization();
    //window.localStorage.setItem("CountryCode", "it");
    conditionHelper.enableAcceptButton();
    $("#acceptTermsChkNotice, #acceptPrivacyNotice, #acceptAgeNotice").click(function () {
        conditionHelper.enableAcceptButton();
    });

    $('#pvcAge').click(function () {
        cmn_getRefreshTokenWithCallback(conditionHelper.savePrivacy);
        //conditionHelper.savePrivacy();
    });

    $("#tncLinkNotice").click(function () {
        window.localStorage.removeItem('chkVlnc');
        window.localStorage.setItem('linkFrom', 'importantNotice');
        window.localStorage.setItem('chk', 'tnc')
        window.location.href = 'termsAndConditions.html';
    });

    $("#privacyLinkNotice").click(function () {
        window.localStorage.setItem('linkFrom', 'importantNotice');
        window.localStorage.setItem('chk', 'pvcy')
        window.location.href = 'privacy.html';
    });

    if (window.localStorage.getItem("CountryCode") == "it") {
        $("#one").addClass("onestyle");
        $("#two").addClass("twostyle");
        $("#three").addClass("threestyle");
    }
    else if (window.localStorage.getItem("CountryCode") == "en") {
        $("#one").addClass("onestyleen");
        $("#two").addClass("twostyleen");
        $("#three").addClass("threestyleen");
    }
    else if (window.localStorage.getItem("CountryCode") == "es") {
        $("#one").addClass("onestylees");
        $("#two").addClass("twostylees");
        $("#three").addClass("threestylees");
    }
    else if (window.localStorage.getItem("CountryCode") == "fr") {
        $("#one").addClass("onestylefr");
        $("#two").addClass("twostylefr");
        $("#three").addClass("threestylefr");
    }
    else {
        $("#one").addClass("onestylecat");
        $("#two").addClass("twostylecat");
        $("#three").addClass("threestylecat");
    }


});

var conditionHelper = {
    //isClickable: false,
    enableAcceptButton: function () {
        if (($("#acceptTermsChkNotice").is(':checked')) && ($("#acceptPrivacyNotice").is(':checked')) && ($("#acceptAgeNotice").is(':checked'))) {
            $("#pvcAge").removeAttr('disabled');
            $("#pvcAge").removeClass("disable_btn");
        }
        else {
            $("#pvcAge").attr('disabled', 'disabled');
            $("#pvcAge").addClass("disable_btn");
        }
    },

    getLocalization: function () {
        $("#ntc_h1").html(Resources.new_terms_page_header);
        $("#ntc_p1").html(Resources.new_terms_page_block1);
        $("#ntc_p2").html(Resources.new_terms_page_block2);
        $("#ntc_p3").html(Resources.new_terms_page_block3);
        $("#acceptTermsSpnNotice").html(Resources.Reg_AcceptTandC);
        $("#tncLinkNotice").html(Resources.Reg_AcceptTandCLink);
        $("#privacySpnNotice").html(Resources.Reg_AcceptPrivacy);
        $("#privacyLinkNotice").html(Resources.Reg_AcceptPrivacyLink);
        $("#acceptAgeSpnNotice").html(Resources.Reg_16years);
        $("#pvcAge").html(Resources.new_terms_page_button);

    },

    savePrivacy: function () {
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId");
        var objImpNotice =
       {
           'UserUId': window.localStorage.getItem("UserUId"),
           'Language': window.localStorage.getItem("CountryCode"),
           'TAndCInfo': conditionHelper.checkTAndCInfo(),
           'HasAcceptedTAndC': true,
           'HasMoreThan16Years': 1//conditionHelper.setCheckBoxesValueAge('#acceptAgeNotice')
       };
        //alert(JSON.stringify(objImpNotice));
        this._xhr = jQuery.ajax({
            method: 'PUT',
            url: url,
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(objImpNotice),
            success: function (data, status, jqXHR) {
                //alert(status);
                if (status == "success") {
                    window.localStorage.setItem("HasAcceptedTAndC", true);
                    window.localStorage.setItem("HasMoreThan16Years", true);
                    window.location.href = "home.html";
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
    },

    checkTAndCInfo: function () {
        return "TC:" + conditionHelper.setCheckBoxesValue('#acceptTermsChkNotice') + ";PP:" + conditionHelper.setCheckBoxesValue('#acceptPrivacyNotice') + ";PP_RCI:" + conditionHelper.setCheckBoxesValueCurrent('PP_RCI') + ";PP_PSM:" + conditionHelper.setCheckBoxesValueCurrent('PP_PSM') + ";PP_STC:" + conditionHelper.setCheckBoxesValueCurrent('PP_STC');
    },

    setCheckBoxesValue: function (chkBox) {
        if ($(chkBox).is(':checked')) {
            return 1;
        }
        else {
            return 0;
        }
    },

    //setCheckBoxesValueAge: function (chkBox) {
    //    if ($(chkBox).is(':checked')) {
    //        return 1;
    //    }
    //    else {
    //        return 0;
    //    }
    //},

    setCheckBoxesValueCurrent: function (chkBox) {
        if (window.localStorage.getItem(chkBox) == "true") {
            return 1;
        }
        else {
            return 0;
        }
    },
}

