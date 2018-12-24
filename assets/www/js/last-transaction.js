jQuery(document).ready(function () {
    loadString();
    
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    cmn_menuLocalization();

    lastTransaction.getLocalization();

    //lastTransaction.setInnerBodyHeight();
    $(window).resize(function () {
        lastTransaction.setInnerBodyHeight();
    });

    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });
    //cmn_getRefreshTokenWithCallback(lastTransaction.getLatestTransactions);
    document.addEventListener("deviceready", lastTransaction.onDeviceReady, false);

});

function convertUTCDateToLocalDate(date) {
    var newDate = new Date(date);
    var offset = date.getTimezoneOffset();
    if (offset > 0) {
        newDate.setMinutes(date.getMinutes() + date.getTimezoneOffset());
    }
    else {
        newDate.setMinutes(date.getMinutes() - date.getTimezoneOffset());
    }
    return newDate;
}

var lastTransaction = {
    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(lastTransaction.getLatestTransactions);
    },

    setInnerBodyHeight: function () {
        $(".slick-slide").height(($(window).height()) - ($(".slick-slide").offset().top) - 76);
        //$("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) -26);
        $("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) - 20);
        //$("#last-transaction-cont").height(($(window).height()) - ($("#last-transaction-cont").offset().top) - 50);
    },

    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#lastTransactionHeader").html(Resources.last_transaction_header);
        $("#transDate").html(Resources.Trn_date);
        $('#trnAmount').html(Resources.trn_Amount);
        $('#trnSHeader').html(Resources.Trn_Source_header);
        $('#trnPOS').html(Resources.Trn_PointOfSale);
        $('#trnMarchant').html(Resources.Trn_merchant);
        $("#trnTypeHeader").html(Resources.Trn_Type_header);
        $("#noItems").html(Resources.last_transaction_nodata);
        $("#imgtext").html(Resources.report_issue_header);
        $("#backToHome").attr("aria-label", Resources.tb_HomeIcon);

    },

    getLatestTransactions: function () {
        $("body").addClass('loading');
        var url = StageUrl + '/users/' + window.localStorage.getItem("UserUId") + '/payments?count=10';
        this._xhr = jQuery.ajax({
            method: 'GET',
            url: url,
            crossDomain: true,
            dataType: 'json',
            contentType: 'application/json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                $('.single-item').slick({
                    dots: true,
                    totalSlideCount: data["Transactions"].length// cardinfoHelper.totalTransactions
                });
                lastTransaction.setInnerBodyHeight();
                lastTransaction.addlatestTransaction(data);
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

    addlatestTransaction: function (data) {
        if (data["Transactions"] !== null && data["Transactions"] !== '') {

            totalTransactions = data["Transactions"].length;
            if (totalTransactions < 1) {
                $("body").removeClass('loading');
                $("#noItems").removeClass('invisible');
                cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
                return;
            }

            for (i = 0; i < data["Transactions"].length; i++) {
                $("body").addClass('loading');
                var id = i;
                var cDate = data['Transactions'][i]['UpdateTime'];

                var dateStr = cDate.substring(0, 10);
                var dateParts = dateStr.split('-');
                var timeStr = cDate.substring(11, 19);
                var timeParts = timeStr.split(':');

                cDate = convertUTCDateToLocalDate(new Date(dateParts[0], dateParts[1] - 1, dateParts[2], timeParts[0], timeParts[1], timeParts[2]));
                var date = '/Date(' + Date.parse(cDate) + ')/';

                if (date.substring(0, 6) == "/Date(") {
                    var dt = new Date(parseInt(date.substring(6, date.length - 2)));
                    var dtString = dt.getDate() + "/" + (dt.getMonth() + 1) + "/" + dt.getFullYear();
                    var time = (dt.getHours() < 10 ? '0' : '') + dt.getHours() + ':' + (dt.getMinutes() < 10 ? '0' : '') + dt.getMinutes();
                }

                var des = data['Transactions'][i]['Description'];
                var vMachine = data['Transactions'][i]['StickerId'];
                var amt = data['Transactions'][i]['Amount'];
                var merchant = data['Transactions'][i]['MerchantId'];
                var action = lastTransaction.setAction(data['Transactions'][i]['Action']);
                var oSource = data['Transactions'][i]['Source'];
                var source = lastTransaction.setSource(data['Transactions'][i]['Source']);
                var uid = data['Transactions'][i]['Id'];
                var StickerId = data['Transactions'][i]['StickerId'];//window.localStorage.setItem("StickerId", data['Transactions'][i]['StickerId']);
                var CreateTime = data['Transactions'][i]['CreateTime'];// window.localStorage.setItem("CreateTime", data['Transactions'][i]['CreateTime']);

                if (window.localStorage.getItem("CountryCode") == 'it' || window.localStorage.getItem("CountryCode") == 'null' || window.localStorage.getItem("CountryCode") == null) {
                    amt = lastTransaction.numberFormation((amt / 1000).toFixed(2), ",", ".");

                } else if (window.localStorage.getItem("CountryCode") == 'es') {
                    amt = lastTransaction.numberFormation((amt / 1000).toFixed(2), ",", ".");
                }
                else {
                    amt = lastTransaction.numberFormation((amt / 1000).toFixed(2), ".", ",");
                }

                var amount = amt;
                lastTransaction.createTransactionLabels(dtString, time, des, amount, vMachine, merchant, action, source, oSource, ++id, uid, StickerId, CreateTime);
            }

        }
        else {
            $("#noItems").Class('invisible');
            $('#nxtBtn').hide();
            $('#sptrNP').removeClass('seperator-bdr');
            $('#prvBtn').hide();

        }
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    },

    numberFormation: function (x, deci, sep) {
        var parts = x.toString().split(".");
        parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, sep);
        return parts.join(deci);
    },

    setAction: function (field) {
        switch (field.toLocaleLowerCase()) {
            case 'Purchase'.toLocaleLowerCase():
                return Resources.Trn_Type_1;
                break;
            case 'KeyTopUp'.toLocaleLowerCase():
                return Resources.Trn_Type_2;
                break;
            case 'WalletTopUp'.toLocaleLowerCase():
                return Resources.Trn_Type_3;
                break;
            case 'WalletWithdraw'.toLocaleLowerCase():
                return Resources.Trn_Type_4;
                break;
        }
    },

    setSource: function (field) {
        switch (field.toLocaleLowerCase()) {
            case 'CreditCard'.toLocaleLowerCase():
                return Resources.Trn_Source_1;
                break;
            case 'Wallet'.toLocaleLowerCase():
                return Resources.Trn_Source_2;
                break;
            case 'Cash'.toLocaleLowerCase():
                return Resources.Trn_Source_3;
                break;
            case 'Bonus'.toLocaleLowerCase():
                return Resources.Trn_Source_4;
                break;
            case 'Loss'.toLocaleLowerCase():
                return Resources.Trn_Source_5;
                break;
            case 'ChatAndCash'.toLocaleLowerCase():
                return Resources.Trn_Source_6;
                break;
        }
    },

    createTransactionLabels: function (date, time, des, amount, vMachine, merchant, action, source, oSource, i, uid, StickerId, CreateTime) {
        if (i == 1) {
            lastTransaction.createListView(i, '#div1', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 2) {
            lastTransaction.createListView(i, '#div2', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 3) {
            lastTransaction.createListView(i, '#div3', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 4) {
            lastTransaction.createListView(i, '#div4', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 5) {
            lastTransaction.createListView(i, '#div5', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 6) {
            lastTransaction.createListView(i, '#div6', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 7) {
            lastTransaction.createListView(i, '#div7', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 8) {
            lastTransaction.createListView(i, '#div8', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 9) {
            lastTransaction.createListView(i, '#div9', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }
        if (i == 10) {
            lastTransaction.createListView(i, '#div10', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        }




        //if (i == 1) {
        //    lastTransaction.createListView(i, '#trn1', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}

        //if (i == 2) {
        //    $("#trn2").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn2', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}
        //if (i == 3) {
        //    $("#trn3").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn3', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}
        //if (i == 4) {
        //    $("#trn4").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn4', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);

        //}
        //if (i == 5) {
        //    $("#trn5").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn5', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}
        //if (i == 6) {
        //    $("#trn6").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn6', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}
        //if (i == 7) {
        //    $("#trn7").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn7', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}
        //if (i == 8) {
        //    $("#trn8").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn8', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}
        //if (i == 9) {
        //    $("#trn9").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn9', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}
        //if (i == 10) {
        //    $("#trn10").append('<div class="border-btm">')
        //    lastTransaction.createListView(i, '#trn10', date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime);
        //}

    },

    createListView: function (i, cdiv, date, time, des, vMachine, merchant, amount, action, source, oSource, uid, StickerId, CreateTime) {
        switch (i > 0) {
            case ((merchant === null && vMachine === null) && (oSource == "Loss" || oSource == "Bonus")):
                return $(cdiv).append('<li><div class="row"><div class="col-xs-6">' + Resources.Trn_date + '</div><div class="col-xs-6">' + date + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_time + '</div><div class="col-xs-6">' + time + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.trn_Amount + '</div><div class="col-xs-6 orng-txt">' + amount + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Source_header + '</div><div class="col-xs-6">' + source + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_description_header + '</div><div class="col-xs-6">' + des + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_PointOfSale + '</div><div class="col-xs-6">&nbsp;</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_merchant + '</div><div class="col-xs-6">&nbsp;</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Type_header + '</div><div class="col-xs-6">' + action + '</div></div></li>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + time + '\',\'' + date + '\')">' + '<p class="issuetext">' + Resources.report_issue_header + '</p>');



                //return $(cdiv).append('<p><strong><span>' + Resources.Trn_date + '</span><span>&nbsp;' + date + '</span></strong></p><p><strong><span>' + Resources.Trn_time + '</span><span>&nbsp;' + time + '</span></strong></p><p><span>' + Resources.trn_Amount + '</span><span>&nbsp;' + amount + '&euro;&nbsp;</span></p><p><span>' + Resources.Trn_Source_header + '</span><span>&nbsp;' + source + '</span></p><p><span>' + Resources.Trn_description_header + '</span><span>&nbsp;' + des + '</span></p><p><span>' + Resources.Trn_PointOfSale + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_merchant + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_Type_header + '</span><span>&nbsp;' + action + '</span></p>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + CreateTime + '\')">');
                break;
            case (merchant === null && vMachine === null):
                return $(cdiv).append('<li><div class="row"><div class="col-xs-6">' + Resources.Trn_date + '</div><div class="col-xs-6">' + date + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_time + '</div><div class="col-xs-6">' + time + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.trn_Amount + '</div><div class="col-xs-6 orng-txt">' + amount + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Source_header + '</div><div class="col-xs-6">' + source + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_PointOfSale + '</div><div class="col-xs-6">&nbsp;</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_merchant + '</div><div class="col-xs-6">&nbsp;</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Type_header + '</div><div class="col-xs-6">' + action + '</div></div></li>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + time + '\',\'' + date + '\')">' + '<p class="issuetext">' + Resources.report_issue_header + '</p>');


                //return $(cdiv).append('<p><strong><span>' + Resources.Trn_date + '</span><span>&nbsp;' + date + '</span></strong></p><p><strong><span>' + Resources.Trn_time + '</span><span>&nbsp;' + time + '</span></strong></p><p><span>' + Resources.trn_Amount + '</span><span>&nbsp;' + amount + '&euro;&nbsp;</span></p><p><span>' + Resources.Trn_Source_header + '</span><span>&nbsp;' + source + '</span></p><p><span>' + Resources.Trn_PointOfSale + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_merchant + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_Type_header + '</span><span>&nbsp;' + action + '</span></p>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage( \'' + uid + '\',\'' + StickerId + '\',\'' + CreateTime + '\')">');
               
                break;
            case ((merchant === null) && (oSource == "Loss" || oSource == "Bonus")):
                return $(cdiv).append('<li><div class="row"><div class="col-xs-6">' + Resources.Trn_date + '</div><div class="col-xs-6">' + date + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_time + '</div><div class="col-xs-6">' + time + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.trn_Amount + '</div><div class="col-xs-6 orng-txt">' + amount + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Source_header + '</div><div class="col-xs-6">' + source + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_description_header + '</div><div class="col-xs-6">' + des + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_PointOfSale + '</div><div class="col-xs-6">' + vMachine + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_merchant + '</div><div class="col-xs-6">&nbsp;</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Type_header + '</div><div class="col-xs-6">' + action + '</div></div></li>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + time + '\',\'' + date + '\')">' + '<p class="issuetext">' + Resources.report_issue_header + '</p>');


                //return $(cdiv).append('<p><strong><span>' + Resources.Trn_date + '</span><span>&nbsp;' + date + '</span></strong></p><p><strong><span>' + Resources.Trn_time + '</span><span>&nbsp;' + time + '</span></strong></p><p><span>' + Resources.trn_Amount + '</span><span>&nbsp;' + amount + '&euro;&nbsp;</span></p><p><span>' + Resources.Trn_Source_header + '</span><span>&nbsp;' + source + '</span></p><p><span>' + Resources.Trn_description_header + '</span><span>&nbsp;' + des + '</span></p><p><span>' + Resources.Trn_PointOfSale + '</span><span>&nbsp;' + vMachine + '</span></p><p><span>' + Resources.Trn_merchant + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_Type_header + '</span><span>&nbsp;' + action + '</span></p>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + CreateTime + '\')">');
                break;
            case (merchant === null):
                return $(cdiv).append('<li><div class="row"><div class="col-xs-6">' + Resources.Trn_date + '</div><div class="col-xs-6">' + date + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_time + '</div><div class="col-xs-6">' + time + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.trn_Amount + '</div><div class="col-xs-6 orng-txt">' + amount + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Source_header + '</div><div class="col-xs-6">' + source + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_PointOfSale + '</div><div class="col-xs-6">' + vMachine + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_merchant + '</div><div class="col-xs-6">&nbsp;</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Type_header + '</div><div class="col-xs-6">' + action + '</div></div></li>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + time + '\',\'' + date + '\')">' + '<p class="issuetext">' + Resources.report_issue_header + '</p>');


                //return $(cdiv).append('<p><strong><span>' + Resources.Trn_date + '</span><span>&nbsp;' + date + '</span></strong></p><p><strong><span>' + Resources.Trn_time + '</span><span>&nbsp;' + time + '</span></strong></p><p><span>' + Resources.trn_Amount + '</span><span>&nbsp;' + amount + '&euro;&nbsp;</span></p><p><span>' + Resources.Trn_Source_header + '</span><span>&nbsp;' + source + '</span></p><p><span>' + Resources.Trn_PointOfSale + '</span><span>&nbsp;' + vMachine + '</span></p><p><span>' + Resources.Trn_merchant + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_Type_header + '</span><span>&nbsp;' + action + '</span></p>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + CreateTime + '\')">');
                break;
            case ((vMachine === null) && (oSource == "Loss" || oSource == "Bonus")):
                return $(cdiv).append('<li><div class="row"><div class="col-xs-6">' + Resources.Trn_date + '</div><div class="col-xs-6">' + date + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_time + '</div><div class="col-xs-6">' + time + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.trn_Amount + '</div><div class="col-xs-6 orng-txt">' + amount + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Source_header + '</div><div class="col-xs-6">' + source + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_description_header + '</div><div class="col-xs-6">' + des + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_PointOfSale + '</div><div class="col-xs-6">&nbsp;</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_merchant + '</div><div class="col-xs-6">' + merchant + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Type_header + '</div><div class="col-xs-6">' + action + '</div></div></li>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + time + '\',\'' + date + '\')">' + '<p class="issuetext">' + Resources.report_issue_header + '</p>');


                //return $(cdiv).append('<p><strong><span>' + Resources.Trn_date + '</span><span>&nbsp;' + date + '</span></strong></p><p><strong><span>' + Resources.Trn_time + '</span><span>&nbsp;' + time + '</span></strong></p><p><span>' + Resources.trn_Amount + '</span><span>&nbsp;' + amount + '&euro;&nbsp;</span></p><p><span>' + Resources.Trn_Source_header + '</span><span>&nbsp;' + source + '</span></p><p><span>' + Resources.Trn_description_header + '</span><span>&nbsp;' + des + '</span></p><p><span>' + Resources.Trn_PointOfSale + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_merchant + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_Type_header + '</span><span>&nbsp;' + action + '</span></p>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + CreateTime + '\')">');
                break;

            case (vMachine === null):
                return $(cdiv).append('<li><div class="row"><div class="col-xs-6">' + Resources.Trn_date + '</div><div class="col-xs-6">' + date + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_time + '</div><div class="col-xs-6">' + time + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.trn_Amount + '</div><div class="col-xs-6 orng-txt">' + amount + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Source_header + '</div><div class="col-xs-6">' + source + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_PointOfSale + '</div><div class="col-xs-6">&nbsp;</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_merchant + '</div><div class="col-xs-6">' + merchant + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Type_header + '</div><div class="col-xs-6">' + action + '</div></div></li>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + time + '\',\'' + date + '\')">' + '<p class="issuetext">' + Resources.report_issue_header + '</p >');


                //return $(cdiv).append('<p><strong><span>' + Resources.Trn_date + '</span><span>&nbsp;' + date + '</span></strong></p><p><strong><span>' + Resources.Trn_time + '</span><span>&nbsp;' + time + '</span></strong></p><p><span>' + Resources.trn_Amount + '</span><span>&nbsp;' + amount + '&euro;&nbsp;</span></p><p><span>' + Resources.Trn_Source_header + '</span><span>&nbsp;' + source + '</span></p><p><span>' + Resources.Trn_PointOfSale + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_merchant + '</span><span>&nbsp;' + merchant + '</span></p><p><span>' + Resources.Trn_Type_header + '</span><span>&nbsp;' + action + '</span></p>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + CreateTime + '\')">');
                break;

            case (oSource == "Loss" || oSource == "Bonus"):
                return $(cdiv).append('<li><div class="row"><div class="col-xs-6">' + Resources.Trn_date + '</div><div class="col-xs-6">' + date + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_time + '</div><div class="col-xs-6">' + time + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.trn_Amount + '</div><div class="col-xs-6 orng-txt">' + amount + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Source_header + '</div><div class="col-xs-6">' + source + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_description_header + '</div><div class="col-xs-6">' + des + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_PointOfSale + '</div><div class="col-xs-6">' + vMachine + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_merchant + '</div><div class="col-xs-6">' + merchant + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Type_header + '</div><div class="col-xs-6">' + action + '</div></div></li>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + time + '\',\'' + date + '\')">' + '<p class="issuetext">' + Resources.report_issue_header + '</p>');


                //return $(cdiv).append('<p><strong><span>' + Resources.Trn_date + '</span><span>&nbsp;' + date + '</span></strong></p><p><strong><span>' + Resources.Trn_time + '</span><span>&nbsp;' + time + '</span></strong></p><p><span>' + Resources.trn_Amount + '</span><span>&nbsp;' + amount + '&euro;&nbsp;</span></p><p><span>' + Resources.Trn_Source_header + '</span><span>&nbsp;' + source + '</span></p><p><span>' + Resources.Trn_description_header + '</span><span>&nbsp;' + des + '</span></p><p><span>' + Resources.Trn_PointOfSale + '</span><span>&nbsp;' + vMachine + '</span></p><p><span>' + Resources.Trn_merchant + '</span><span>&nbsp;</span></p><p><span>' + Resources.Trn_Type_header + '</span><span>&nbsp;' + action + '</span></p>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + CreateTime + '\')">');
                break;
            default:
                return $(cdiv).append('<li><div class="row"><div class="col-xs-6">' + Resources.Trn_date + '</div><div class="col-xs-6">' + date + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_time + '</div><div class="col-xs-6">' + time + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.trn_Amount + '</div><div class="col-xs-6 orng-txt">' + amount + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Source_header + '</div><div class="col-xs-6">' + source + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_PointOfSale + '</div><div class="col-xs-6">' + vMachine + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_merchant + '</div><div class="col-xs-6">' + merchant + '</div></div></li><li><div class="row"><div class="col-xs-6">' + Resources.Trn_Type_header + '</div><div class="col-xs-6">' + action + '</div></div></li>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + time + '\',\'' + date + '\')">' + '<p class="issuetext">' + Resources.report_issue_header + '</p>');


                //return $(cdiv).append('<p><strong><span>' + Resources.Trn_date + '</span><span>&nbsp;' + date + '</span></strong></p><p><strong><span>' + Resources.Trn_time + '</span><span>&nbsp;' + time + '</span></strong></p><p><span>' + Resources.trn_Amount + '</span><span>&nbsp;' + amount + '&euro;&nbsp;</span></p><p><span>' + Resources.Trn_Source_header + '</span><span>&nbsp;' + source + '</span></p><p><span>' + Resources.Trn_PointOfSale + '</span><span>&nbsp;' + vMachine + '</span></p><p><span>' + Resources.Trn_merchant + '</span><span>&nbsp;' + merchant + '</span></p><p><span>' + Resources.Trn_Type_header + '</span><span>&nbsp;' + action + '</span></p>' + '<img id="issue1" class="issue-repo" src="img/report-issue.png" onclick="lastTransaction.redirectToIssuepage(\'' + uid + '\',\'' + StickerId + '\',\'' + CreateTime + '\')">');
                break;
        }
    },

    redirectToIssuepage: function (uid, StickerId, time,date) {
        window.location = 'issue_reporting.html?id=' + uid + '&StickerId=' + StickerId + '&time=' + time + '&date=' + date;
    },
}

