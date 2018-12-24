jQuery(document).ready(function () {

    loadString();
    cmn_menuLocalization();
    issueReportingHelper.getLocalization();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    issueReportingHelper.setInnerBodyHeight();
    if (window.localStorage.getItem('ErroinVM') != null && window.localStorage.getItem('ErroinVM') != "") {
        cmn_openModelPopup(ErrorMessasges(window.localStorage.getItem('ErroinVM')), "", "", "");
        window.localStorage.removeItem('ErroinVM');
    }
    var uniqueId = issueReportingHelper.getParameterByName('id'); //The Unique Transaction id that has come from transaction screen
    window.localStorage.setItem("LastTransactionId", uniqueId);
    var StickerId = issueReportingHelper.getParameterByName('StickerId');
    var date = issueReportingHelper.getParameterByName('date');
    var time = issueReportingHelper.getParameterByName('time');
    if (StickerId === "null") {
        $('#machinecode').val("");
    }
    else {
        $('#machinecode').val(StickerId);
    }
    if (date != null) {
        var date = date.split("/").reverse().join("-");
        $("#datepicker-date").val(date);
    }
    else {
        $("#datepicker-date").val("");
    }
    if (time != null) {
        $("#datepicker-time").val(time);
    }
    else {
        $("#datepicker-time").val("");
    }

    $('#datepicker-time').click(function (e) {
        issueReportingHelper.getCurrentTime();
    });
    $('#datepicker-date').click(function (e) {
        issueReportingHelper.getCurrentDate();
    });

    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    $("#qrli").click(function () {
        document.activeElement.blur();
        event.stopPropagation();
        window.localStorage.setItem("isScannButtonClicked", "true");
        window.localStorage.setItem("fromIssueReport", "true");
        issueReportingHelper.scanner();
    });
    issueReportingHelper.enableReportButton();
    //$('#machinecode').bind('input', function () {
    //    var $this = $(this);
    //    if ($this.length < 5) {
    //        return false;
    //    }
    //    else {
    //        alert('VM');
    //        issueReportingHelper.enableReportButton();
    //    }
    //});

    $("#machinecode").keyup(function () {
        issueReportingHelper.enableReportButton();
    });
    $(".dd1").change(function () {
        issueReportingHelper.enableReportButton();
    });

    $("#reportButton").click(function () {
        issueReportingHelper.insertCustomerIssue();
    });

    $("#issueClassDD").change(function () {
        $('#issueCategoryDD').empty();
        issueReportingHelper.getIssueCategories(window.localStorage.getItem("CountryCode"), $("#issueClassDD option:selected").val());
    });

    $('#machinecode').bind('input', function () {
        if ($('#machinecode').val().length < 5) {
            return false;
        }
        window.localStorage.setItem("fromIssueReport", "true");
        if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
            cmn_setPaymentMode($.trim($('#machinecode').val()), "", "#buybtn", "card", "");
        }
        else if (window.localStorage.getItem("PaymentMode") === 'wallet') {
            cmn_setPaymentMode($.trim($('#machinecode').val()), "#buybtn", "#buybtn", "wallet", "");
        }
    });

    $("#alertOk").click(function () {
        issueReportingHelper.redirectToHomepage();
    });

    //cmn_getRefreshTokenWithCallback(issueReportingHelper.getIssueClasses);
    document.addEventListener("deviceready", issueReportingHelper.onDeviceReady, false);
});



var issueReportingHelper = {
    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
        cmn_getRefreshTokenWithCallback(issueReportingHelper.getIssueClasses);
    },

    enableReportButton: function () {
        var classValue = $("#issueClassDD option:selected").val();
        var catValue = $("#issueCategoryDD option:selected").val();
        if (classValue == 2) {
            if (catValue != "" && catValue > 0 && $('#machinecode').val() != "" && $('#machinecode').val() != null) {
                $("#reportButton").attr('disabled', false);
                $("#reportButton").removeClass('disable_btn');
            }
            else {
                $("#reportButton").attr('disabled', 'disabled');
                $("#reportButton").addClass('disable_btn');
            }
        }
        else if (classValue == 1) {
            if (catValue != "" && catValue > 0) {
                $("#reportButton").attr('disabled', false);
                $("#reportButton").removeClass('disable_btn');

            }
            else {
                $("#reportButton").attr('disabled', 'disabled');
                $("#reportButton").addClass('disable_btn');
            }
        }
        else {
            $("#reportButton").attr('disabled', 'disabled');
            $("#reportButton").addClass('disable_btn');
        }
    },
    getCurrentTime: function () {
        var options = {
            date: new Date(),
            mode: 'time',
            androidTheme: 4
        };

        function onSuccess(date) {
            var time = date.getHours() + ":" + date.getMinutes();
            $('#datepicker-time').val(time);
        }

        function onError(error) { // Android only 
            // alert('Error: ' + error);
        }

        datePicker.show(options, onSuccess, onError);
    },

    getCurrentDate: function () {
        var datefield = new Date();
        var currentMonth = datefield.getMonth();
        var currentDate = datefield.getDate();
        var currentYear = datefield.getFullYear();
        var options = {
            mode: 'date',         // 'date' or 'time', required
            date: new Date(),     // date or timestamp, default: current date
            minDate: (new Date(currentYear, currentMonth, currentDate - 30)).valueOf(),
            maxDate: Date.parse(new Date()),   // date or timestamp
            androidTheme: 4
        };

        function onSuccess(date) {
            var datevalue = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
            $('#datepicker-date').val(datevalue);
        }

        function onError(error) { // Android only 
            // alert('Error: ' + error);
        }
        datePicker.show(options, onSuccess, onError);

    },

    getParameterByName: function (name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    },

    formatDate: function (date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();
        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [year, month, day].join('-');
    },

    setInnerBodyHeight: function () {
        if (window.screen.availWidth < 1024) {
            var wHeight = Math.floor(($(window).height() - $("#vending-machine-code-cont").offset().top)) - 10;
            $("#vending-machine-code-cont").height(($(window).height() - ($("#vending-machine-code-cont").offset().top)) - 6);
            $('#vending-machine-code-cont').css({ height: wHeight });
        }
    },

    scanner: function () {
        cordova.plugins.barcodeScanner.scan(
            function (result) {
                var _vmcode = return_scan_qrcode(result.text);
                $('#machinecode').val(_vmcode);
                       if (window.localStorage.getItem("PaymentMode") === 'CreditCard') {
                           cmn_setPaymentMode(_vmcode, "#buybtn", "#buybtn", "card", "");
                       } else {
                           cmn_setPaymentMode(_vmcode, "#buybtn", "#buybtn", "wallet", "");
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
    },

    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#accountTitle").html(Resources.report_issue_header);
        $("#reportButton").html(Resources.report_issue_sendbutton);
        $("#datepicker-date").attr("placeholder", Resources.report_issue_date);
        $("#datepicker-time").attr("placeholder", Resources.report_issue_time);
        $("#moredetails").attr("placeholder", Resources.report_issue_textbox);
        $("#machinecode").attr("placeholder", Resources.Home_Wallet_label02);
        $("#qrli").attr("aria-label", Resources.tb_QRScanImage);
        $("#backToHome").attr("aria-label", Resources.tb_HomeIcon);
    },

    /*Method to fetch list of Issue Classes.*/
    getIssueClasses: function () {
        var countryCode = '';
        countryCode = window.localStorage.getItem("CountryCode");
        $("body").addClass('loading');
        var url = StageUrl + '/users/localization';
        this._xhr = jQuery.ajax({
            method: 'GET',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                $("body").removeClass('loading');
                for (i = 0; i < data.Issues.Classes.length; i++) {
                    $("#issueClassDD").append("<option value=" + data.Issues.Classes[i].IssueClassId + ">" + data.Issues.Classes[i].Description + "</option>");
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        });
    },

    /*Method to fetch list of Issue Categories.*/
    getIssueCategories: function (countryCode, issueClassVal) {
        $("body").addClass('loading');
        var url = StageUrl + '/users/localization?localeId=' + countryCode;
        this._xhr = jQuery.ajax({
            method: 'GET',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                $("body").removeClass('loading');
                $('#issueCategoryDD').empty();
                for (i = 0; i < data.Issues.Classes.length; i++) {
                    if (data.Issues.Classes[i].IssueClassId == issueClassVal) {
                        $("#issueCategoryDD").append('<option value="' + 0 + '">' + " " + '</option>');
                        for (j = 0; j < data.Issues.Classes[i].Categories.length; j++) {
                            $("#issueCategoryDD").append("<option value=" + data.Issues.Classes[i].Categories[j].IssueCategoryId + ">" + data.Issues.Classes[i].Categories[j].Description + "</option>");
                        }
                    }
                    else {
                        //Do Nothing
                    }
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        });
    },


    insertCustomerIssue: function () {
        var url = StageUrl + '/applications/issues';
        var currentDate = new Date();
        if (($("#datepicker-date").val() == "") || ($("#datepicker-date").val() == null)) {
           var datevalue = currentDate.getFullYear() + "-" + (currentDate.getMonth() + 1) + "-" + currentDate.getDate();
           $("#datepicker-date").val(datevalue)
        }
        if (($("#datepicker-time").val() == "") || ($("#datepicker-time").val() == null)) {
            var time = currentDate.getHours() + ":" + currentDate.getMinutes() + ":" + currentDate.getSeconds().toFixed(2);
            $("#datepicker-time").val(time)
        }
        var objIssueReportData =
       {
           "Reported": $("#datepicker-date").val() + ' ' + $("#datepicker-time").val(),
           "StickerId": $("#machinecode").val(),
           "TransactionId": window.localStorage.getItem("LastTransactionId"),
           "IssueClassId": $("#issueClassDD option:selected").val(),
           "IssueCategoryId": $("#issueCategoryDD option:selected").val(),
           "Message": $("#moredetails").val()
       };
        //alert(JSON.stringify(objIssueReportData));
        this._xhr = jQuery.ajax({
            method: 'POST',
            url: url,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            data: JSON.stringify(objIssueReportData),
            success: function (data, status, jqXHR) {
                if (status == "success") {
                    cmn_openModelPopup(Resources.report_issue_confirm, "", "", "");
                    $("#datepicker-date").val("");
                    $("#datepicker-time").val("");
                    $("#machinecode").val("");
                    $("#moredetails").val("");
                    $('#issueCategoryDD').empty();
                    $('#issueClassDD').val(0);
                }
            },

            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        });
    },

    redirectToHomepage: function () {
        window.location = 'home.html';
    },
}