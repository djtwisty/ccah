jQuery(document).ready(function () {
    loadString();
    emailValidationHelper._accessToken = cmn_GetValuesFromAndroidFunction("AccessToken");
    emailValidationHelper._userName = window.localStorage.getItem("UserName");
    
    $('#validEmail').val(window.localStorage.getItem("Email"));
    emailValidationHelper.getLocalization();

    $("#emailValidationbtn").click(function (evt) {
        if (!CheckTokenExpiration(cmn_GetValuesFromAndroidFunction("TokenExpire"))) {
            window.location.href = "login.html";
        }
        else {
            if ($('#validEmail').val() == "") {
                cmn_openModelPopup(ErrorMessasges("EnterEmailId"), "", "", "");
            }
            else if (!emailValidationHelper.validateEmail($('#validEmail').val())) {
                var userId = encodeURIComponent(window.localStorage.getItem("UserUId"));
                var serviceUrl = StageUrl + '/users/' + userId + '/emails/validate';
                var objmailValidation = {
                    'EmailAddress': $('#validEmail').val()
                }
                emailValidationHelper.validateEmailId(serviceUrl, objmailValidation);
            }
            else {
                cmn_openModelPopup(ErrorMessasges("EnterValidEmail"), "", "", "");
            }
        }
    });

    $("#validEmail").focus(function () {
        clearTimeout(emailValidationHelper._timeOutVar);
    });

    $("#backToLogin").click(function () {
        cmn_removeLocalStorages();
        window.location.href = 'login.html';
    });
});



var emailValidationHelper = {
    _accessToken: '',
    _timeOutVar:'',


    getLocalization: function () {
        $("#headerRegistartion").html(Resources.Header_Register);
        $("#lblEmailValdHeader").html(Resources.eMAILvalidation_header);
        $("#lblEmailVald1").html(Resources.eMAILvalidation_label_1);
        $("#lblEmailVald2").html(Resources.eMAILvalidation_label_2);
        $("#lblEmailVald3").html(Resources.eMAILvalidation_label_3);
        $("#emailValidationbtn").html(Resources.eMAILvalidation_button);
        $("#backToLogin").html(Resources.eMAILvalidation_login_link);
        emailValidationHelper._timeOutVar = setTimeout(function () { cmn_removeLocalStorages(); window.location.href = 'login.html'; }, 10000);
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

    validateEmailId: function (serviceUrl, body) {
        $("body").addClass('loading');
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: serviceUrl,
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': emailValidationHelper._accessToken
            },
            data: JSON.stringify(body),

            success: function (data, status, jqXHR) {
                if (status = "Success") {
                    cmn_removeLocalStorages();
                    window.location.href = 'login.html';
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
}