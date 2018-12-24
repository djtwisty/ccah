jQuery(document).ready(function () {
    //window.localStorage.setItem("CountryCode", "en");
    loadString();
    privatewalletHelper.getLocalization();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    cmn_menuLocalization();
    privatewalletHelper.setInnerBodyHeight();

    $("#topupButton").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "wallet-topup.html";
    });

    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    document.addEventListener("deviceready", privatewalletHelper.onDeviceReady, false);
    //cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);


});

var privatewalletHelper = {
    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    },

    setInnerBodyHeight: function () {
        if (window.screen.availWidth < 1024) {
            var wHeight = Math.floor(($(window).height() - $(".payment-option").offset().top)) - 10;
            $(".payment-option").height(($(window).height() - ($(".payment-option").offset().top)) - 6);
            $('.wrapper-height').css({ height: wHeight });
        }
    },

    getLocalization: function () {
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#pvtwalletpageLbl").html(Resources.wallet_chart_header);
        $("#pvtwalletcaption").html(Resources.wallet_chart_cc_main_caption);
        $("#topupButton").html(Resources.wallet_chart_topup_button);
    },

    getGraphData: function () {
        var data = JSON.parse(window.localStorage.getItem("MerchantData"));
        if (data != null) {
            for (i = 0; i < data.Wallets.length; i++) {
                if (data.Wallets[i].MerchantUId == null) {
                    window.localStorage.setItem("CoffeeCappBalance", (data.Wallets[i].WalletBalance / 1000).toFixed(2));
                    window.localStorage.setItem("CoffeeCappName", (data.Wallets[i].WalletName));
                }
                else {
                    window.localStorage.setItem("MerchantName" + [i], (data.Wallets[i].WalletName));
                    window.localStorage.setItem("MerchantBalance" + [i], (data.Wallets[i].WalletBalance / 1000).toFixed(2));

                }
            }
        }

    },

    //drawChart: function () {
    //    var data = new google.visualization.DataTable();
    //    data.addColumn('string', 'Month');
    //    data.addColumn('number', 'Sales');
    //    data.addColumn({ type: 'string', role: 'color' });
    //    //    var data = new google.visualization.DataTable({
    //    //        cols: [
    //    //          { label: 'Type', type: 'string' },
    //    //          { label: 'Amount', type: 'number' }
    //    //           //{ role: 'color', type: 'string' }
    //    //        ]
    //    //    });
    //        var walletData = JSON.parse(window.localStorage.getItem("MerchantData"));
    //        if (walletData != null) {

    //            //For adding merchant slice
    //            for (i = 0; i < walletData.Wallets.length; i++) {
    //                if (walletData.Wallets[i].MerchantUId != null) {
    //                    data.addRow([
    //                                   { v: Resources.wallet_chart_merchant_caption + ' ' + walletData.Wallets[i].WalletName + '(*) ' + (walletData.Wallets[i].WalletBalance / 1000).toFixed(2) },
    //                                   { v: (walletData.Wallets[i].WalletBalance / 1000)},
    //                                    { v: 'yellow' }

    //                    ]);
    //                }
    //            }

    //            //For adding coffeecApp slice
    //            for (i = 0; i < walletData.Wallets.length; i++) {
    //                if (walletData.Wallets[i].MerchantUId == null) {
    //                    data.addRow([
    //                                   { v: Resources.wallet_chart_cc_slice_caption + ' ' + (walletData.Wallets[i].WalletBalance / 1000).toFixed(2) },
    //                                   { v: (walletData.Wallets[i].WalletBalance / 1000) },
    //                                   { v: 'gold' }
    //                    ]);
    //                }
    //            }
    //        }

    //    //    //var slicesColor = {};

    //    //    //for (var i = 0; i < data.getNumberOfRows() ; i++) {
    //    //    //     I assume the label is in the first column of each row here
    //    //    //     this is based on string matching, but you can define any criteria you want
    //    //    //    slicesColor[i] = { color: myColors[data.getValue(i, 0)] };
    //    //    //}
    //    //    // create color map
    //    //    //var colors = {
    //    //    //    'Cash': 'green',
    //    //    //    'Finance': 'red',
    //    //    //    'Lease': 'black'
    //    //    //};
    //    //    //// build slices
    //    //    //var slices = [];
    //    //    //for (var i = 0; i < data.getNumberOfRows() ; i++) {
    //    //    //    slices.push({
    //    //    //        color: colors[data.getValue(i, 0)]
    //    //    //    });
    //    //    //}
    //    var options = {
    //        // title: 'Most Requested Sponsors',
    //        width: '50px',
    //        pieSliceText: ['none'],
    //        chartArea: { left: 30, top: 40, width: "80%", height: "100px" },
    //        legend: { position: 'labeled', color: 'black', textStyle: { fontName: 'Roboto-Regular', fontSize: 13 } }
    //        //slices: slicesColor
    //        //slices: { 0: { color: '#ec6e08' }, 1: { color: '#A8A8A8' }, 2: { color: '#16aeec' } }
    //        //colors: [ '#ec6e08', '#A8A8A8', '#16aeec']
    //    };

    //    var chart = new google.visualization.PieChart(document.getElementById('chart'));
    //    chart.draw(data, options);

    //    for (var i in chart.chartData) {
    //        var row = chart.chartData[i];
    //        var color = chart.colors[i];
    //        var percent = Math.round(row.percents * 100) / 100;
    //        var value = row.value;
    //        legend.innerHTML += '<div class="legend-item" id="legend-item-' + i + '" onclick="toggleSlice(' + i + ');" onmouseover="hoverSlice(' + i + ');" onmouseout="blurSlice(' + i + ');" style="color: ' + color + ';"><div class="legend-marker" style="background: ' + color + '"></div>' + row.title + '<div class="legend-value">' + value + ' | ' + percent + '%</div></div>';
    //    }
    //},



        drawChart: function () {
         privatewalletHelper.getGraphData();
        var data = google.visualization.arrayToDataTable([
          ['Type', 'Amount'],
         [Resources.wallet_chart_merchant_caption + ' ' +  window.localStorage.getItem("MerchantName1")  + '(*) ' + window.localStorage.getItem("MerchantBalance1"), parseFloat(window.localStorage.getItem("MerchantBalance1"))],
        // [Resources.wallet_chart_merchant_caption + ' ' + window.localStorage.getItem("MerchantName1") + '(*) ' + window.localStorage.getItem("MerchantBalance1"), 0.55],
         [Resources.wallet_chart_merchant_caption + ' ' + window.localStorage.getItem("MerchantName2") + '(*) ' + window.localStorage.getItem("MerchantBalance2"), parseFloat(window.localStorage.getItem("MerchantBalance2"))],
        [Resources.wallet_chart_cc_slice_caption + ' ' + window.localStorage.getItem("CoffeeCappBalance"), parseFloat(window.localStorage.getItem("CoffeeCappBalance"))]

        ]);
        var options = {
            // title: 'Most Requested Sponsors',
            width: '50px',
            pieSliceText: ['none'],
            chartArea: { left: 30, top: 40, width: "85%", height: "100px" },
            legend: { position: 'labeled', color: 'black', textStyle: { fontName: 'Roboto-Regular',fontSize:13 } },
            colors: ['#ec6e08', '#A8A8A8', '#16aeec']
        };

    var chart = new google.visualization.PieChart(document.getElementById('chart'));
    chart.draw(data, options);
    }
}