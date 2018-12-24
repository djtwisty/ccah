jQuery(document).ready(function () {
    loadString();
    pinHelper._accessToken = cmn_GetValuesFromAndroidFunction("AccessToken");
    pinHelper._userName = window.localStorage.getItem("UserName");
    document.addEventListener("deviceready", pinHelper.deviceReady, false);

    pinHelper.getLocalization();
    $("#lblValidationHeader").append(" " + window.localStorage.getItem("UserName"));
    document.addEventListener("deviceready", function () {
        window.localStorage.setItem('pinRequestTime', new Date());
        pinHelper.verifyMobileNumber();
    }, false);

    $("#backToHome").click(function () {
        cmn_removeLocalStorages();
        window.location.href = 'login.html';
    });

    var smsfilter = {
        box: 'inbox',
        // following 4 filters should NOT be used together, they are OR relationship
        read: 0, // 0 for unread SMS, 1 for SMS already read
        // _id: 1234, // specify the msg id
        ///  address: _pinSMSNumber, // sender's phone number
        // address: '+919910910647',
        // address: 'coffeecApp',
        // body: '12457', // content to match
        // following 2 filters can be used to list page up/down
        indexFrom: 0, // start from index 0
        maxCount: 5, // count of SMS to return each time
    };

    //var timerVar = setInterval(function () {
    //    if (SMS) SMS.listSMS(smsfilter,
    //          function (data) {
    //              if (Array.isArray(data)) {
    //                  for (var i in data) {
    //                      var sms = data[i];
    //                      if (pinHelper.isPinArrivedAfterRequest(sms.date) && ((sms.body.toLowerCase().indexOf("coffeecapp") > -1) || (sms.body.toLowerCase().indexOf("coffee capp") > -1))) {
    //                          var smsBody = sms.body.split(' ');
    //                          if ((smsBody.length >= 3) && (smsBody[0].length === 6) && (pinHelper.isInteger(parseInt(smsBody[0])))) {
    //                              var otp = smsBody[0];
    //                              clearTimeout(timerVar);
    //                              $("body").addClass('loading');
    //                              $("#requestPin").val(otp);
    //                              pinHelper.signInWithVerificationId(otp);
    //                              break;
    //                          }
    //                      }
    //                  }
    //              }
    //              else { }
    //          }, function (err) {
    //              clearTimeout(timerVar);                 
    //              cmn_openModelPopup('error list sms: ' + err, "", "", "");
    //          });
    //}, 3000);

    $('#validatePinBtn').click(function (evt) {
        $("body").addClass('loading');
        pinHelper.signInWithVerificationId($.trim($('#requestPin').val()));
    });

    $('#resendPin').click(function () {
        pinHelper.re_sendPinSMS();
    });

    $('#PINvalidationtrylaterbutton').click(function (e) {
        //clearTimeout(timerVar);
        cmn_removeLocalStorages();
        navigator.app.exitApp();
    });

});



var pinHelper = {
    _userName: '',
    _password: '',
    _accessToken: '',

    deviceReady: function () {
        cordova.plugins.SecureKeyStore.get(function (res) {
            pinHelper._password = res;
        }, function (error) {

        }, "Password");
    },

    getLocalization: function () {
        $("#registrationHeader").html(Resources.Header_Register);
        $("#lblValidationHeader").html(Resources.PINvalidation_header);
        $("#lblPinInfo").html(Resources.SmsPinInfo_Label);
        $("#validatePinBtn").html(Resources.BtnValidatePin);
        $('#resendPin').html(Resources.RegenerateSMS);
        $('#SmsPinInfoLabel2').html(Resources.SmsPinInfo_Label2);
        $('#PINvalidationtrylaterbutton').html(Resources.PINvalidation_trylater_button);
    },


    isInteger: function (x) {
        return (typeof x === 'number') && (x % 1 === 0);
    },

    isPinArrivedAfterRequest: function (smsDate) {
        var pinRequestTime = new Date(window.localStorage.getItem('pinRequestTime'));
        var pinRequestTimeUTC = Date.UTC(pinRequestTime.getUTCFullYear(), pinRequestTime.getUTCMonth(), pinRequestTime.getUTCDate(), pinRequestTime.getUTCHours(), pinRequestTime.getUTCMinutes(), pinRequestTime.getUTCSeconds());
        if (pinRequestTimeUTC < smsDate) {
            window.localStorage.removeItem('pinRequestTime');
            return true;
        } else {
            return false;

        }
    },

    validatePinNumber: function (serviceUrl, body, callBack) {
        //window.fabric.Crashlytics.addLog("Successfully entered in Validate function");
        var timeOutVar = setTimeout(function () {
            cmn_openModelPopup(ErrorMessasges('ServerError'), "", "", "");
        }, 15000);
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: serviceUrl,
            beforeSend: function () {
                $("body").addClass('loading');
            },
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': pinHelper._accessToken
            },
            data: JSON.stringify(body),

            success: function (data, status, jqXHR) {
                //window.fabric.Crashlytics.addLog("Successfully verified user in DB. Result returns from API is: " + data.ErrorCode);
                //window.fabric.Crashlytics.sendNonFatalCrash("cc DB PIN Error");
                clearTimeout(timeOutVar);
                if (data.Result == 0) {
                    callBack(status, data);
                }
                else if (data.ErrorCode == 'PinNotExists') {
                    $("body").removeClass('loading');
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
                else if (data.ErrorCode == 'ServerError') {
                    $("body").removeClass('loading');
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            },
            error: function (jqXHR, status, error) {
                //window.fabric.Crashlytics.addLog("Verification error from DB. Result returns from API is: " + jqXHR.responseJSON.ErrorCode);
                //window.fabric.Crashlytics.sendNonFatalCrash("cc DB PIN Error");
                clearTimeout(timeOutVar);
                $("body").removeClass('loading');
                if (jqXHR.responseJSON.ErrorCode === undefined) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseText), "", "", "");
                }
                else if (jqXHR.status != 0) {
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
                else if (jqXHR.status == 0) {
                    cmn_openModelPopup(Resources.noNetwork, "", "", "");
                }
            }

        });
    },

    newTokenCallBack: function (status, data) {
        try {
            var status = cmn_CallingAuthenticationAPI(pinHelper._userName, pinHelper._password);

            if (status = "success") {
                   window.localStorage.setItem("TokenExpire", GetTokenExpiration(cmn_GetValueOfTokenExpire() - 300));
                pinHelper.getUserDetail();               
            }
            else {
                $("body").removeClass("loading");
                cmn_openModelPopup(ErrorMessasges(status), "", "", "");
            }
        }
        catch (ex) {

        }
    },

    getUserDetail: function () {
        var uname = encodeURIComponent(window.localStorage.getItem("UserName"));
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
                        window.localStorage.setItem("Country", data.Country);
                        window.localStorage.setItem("EmailConfirmed", data.EmailConfirmed);
                        window.localStorage.setItem("PhoneConfirmed", data.PhoneConfirmed);
                        if (data.EmailConfirmed && data.PhoneConfirmed) {
                            window.location.href = 'home.html';
                        }
                        else {
                            window.location.href = 'email-validation.html'
                        }
                    }
                },
                error: function (jqXHR, status, error) {
                    $("body").removeClass('loading');
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.error_description), "", "", "");
                }
            });
        }
        catch (ex) {

        }
    },

    /*Do Not Delete
    re_sendPinSMS: function () {
        var serviceUrl = StageUrl + '/pins';
        var objJson = {
            'UserName': window.localStorage.getItem("UserName")
        }
        var accessToken = cmn_GetValuesFromAndroidFunction("AccessToken");

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
    },
    */

    verifyMobileNumber: function () {
        document.addEventListener("deviceready", function () {
            cordova.plugins.firebase.auth.verifyPhoneNumber(pinHelper._userName, 0, function (verificationId) {
            //cordova.plugins.firebase.auth.verifyPhoneNumber("+919999028295", 0, function (verificationId) {
            //cordova.plugins.firebase.auth.verifyPhoneNumber(pinHelper._userName, 15000, function (verificationId) {
                //window.fabric.Crashlytics.addLog("OTP sent by :" + window.localStorage.getItem("UserName"));             
                window.localStorage.setItem('verificationId', verificationId);
            });
        }, false);
    },

    signInWithVerificationId: function (verificationCode) {
       
        document.addEventListener("deviceready", function () {
            cordova.plugins.firebase.auth.signInWithVerificationId(window.localStorage.getItem('verificationId'), verificationCode, function (userInfo) {
                //window.fabric.Crashlytics.addLog("OTP verified.");
                //window.fabric.Crashlytics.addLog("Call PIN validation API");
                //window.fabric.Crashlytics.sendNonFatalCrash("cc Firebase PIN Error");
                var serviceUrl = StageUrl + '/pins/validate';
                var objPinValidation = {
                    'PinCode': "FBASE",//$('#requestPin').val(),
                    'UserName': pinHelper._userName
                }
                pinHelper.validatePinNumber(serviceUrl, objPinValidation, pinHelper.newTokenCallBack);
            },
            function (error) {
                $("body").removeClass('loading');
                cmn_openModelPopup(error,"", "", "");
            })
        }, false);



    }
     

}