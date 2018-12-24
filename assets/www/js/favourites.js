jQuery(document).ready(function () {

    loadString();
    favouritHelper.getLocalization();
    cmn_setPromoCountOnMenu(window.localStorage.getItem('PromoCount'));
    cmn_menuLocalization();
    favouritHelper.setInnerBodyHeight();
  
    $("#backToHome").click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    $("#saveFavVMbtn").click(function () {
        if ($('#favcode').val() == "") {
            cmn_openModelPopup(ErrorMessasges('EnterfavVMCode'), "", "", "");
            $('#favcode').focus();
            return false;
        }

        cmn_getRefreshTokenWithCallback(favouritHelper.varifyVMCode);
    });

    $("#deleteBtn").click(function () {
        event.stopPropagation();
        favouritHelper.deleteFavouritCode();
    });

    $('#favcode').each(function () {
        var $this = $(this);
        $(this).bind('input', function () {
            favouritHelper.chkVMCodeLength();
        });
    });

    document.addEventListener("deviceready", favouritHelper.onDeviceReady, false);
});

var favouritHelper = {
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
        if (window.localStorage.getItem("favVMCode") != null && window.localStorage.getItem("favVMCode") != "") {
            $('#favCodelbl').html(window.localStorage.getItem("favVMCode"));
            $('#deleteBtn').attr('disabled', false);
            $('#deleteBtn').removeClass('disable_btn');

        }
        else {
            $('#favCodelbl').html(Resources.fav_no_code);
            $('#deleteBtn').attr('disabled', 'disabled');
            $('#deleteBtn').addClass('disable_btn');
        }
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#favHeader").html(Resources.favorite_header);
        $("#favTopLevel").html(Resources.favTopLevel_01);
        $('#favTopLevelHeading').html(Resources.favTopLevel);
        $('#deleteBtn').html(Resources.button_delete);
        $('#saveFavVMbtn').html(Resources.button_save);
        $("#backToHome").attr("aria-label", Resources.tb_HomeIcon);
    },

    chkVMCodeLength: function () {
        var vmId = $('#favcode').val();
        if (vmId.length > 4) {
            document.activeElement.blur();
            $(this).blur();
        }
    },

    deleteFavouritCode: function () {
        $("body").addClass("loading");
        document.addEventListener("deviceready", deleteContents, false);
        window.localStorage.removeItem("favVMCode");
        cmn_openModelPopup(Resources.favVMCodeDeleted, "", "", "");
        $('#favCodelbl').html(Resources.fav_no_code);
        $('#deleteBtn').attr('disabled', 'disabled');
        $('#deleteBtn').addClass('disable_btn');
        $("body").removeClass("loading");
    },

    varifyVMCode: function () {
           $("body").addClass('loading');
           var accessToken = cmn_GetValuesFromAndroidFunction("AccessToken");
            var vmId = $('#favcode').val();
            if (vmId.length > 4) {
                document.activeElement.blur();
                $(this).blur();
                window.localStorage.setItem("VendingId", vmId);
                var url = StageUrl + '/vmachines/' + vmId + '/settings';

                $.ajax({
                    method: 'GET',
                    url: url,
                    dataType: "json",
                    headers: {
                        'Authorization': accessToken
                    },
                    success: function (data, status, jqXHR) {
                        cmn_saveVMCode($('#favcode').val());
                        setTimeout(function () { window.location.href = 'home.html'; }, 3000);
                    },
                    error: function (data, status, jqXHR) {
                        $("body").removeClass("loading");
                        cmn_openModelPopup(Resources.favVMCodeIncorrect, "", "", "");
                    }
                });
            }
            else {
                $("body").removeClass("loading");
                cmn_openModelPopup(Resources.favVMCodeIncorrect, "", "", "");
            }
    }
}