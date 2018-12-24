jQuery(document).ready(function () {
    loadString();
    FaqHelper.setInnerBodyHeight();
    FaqHelper.getLocalization();
    $("#headerRegistartion").click(function () {
    	 /*Check for network Connection*/
        if (!cmn_checkConnection()) {
            return false;
        }
        _isPinValidation = false;
        Registration();
    });

    $(window).resize(function () {
        FaqHelper.setInnerBodyHeight();
    });

    $('.togle-div').click(function () {
        var hasUpClass = $(this).find('i').hasClass("fa-chevron-up");

        $('.togle-div').find('i').each(function () {
            $(this).removeClass("fa-chevron-up");
            $(this).addClass("fa-chevron-down");

        });
        if (!hasUpClass) {
            $(this).find('i').removeClass("fa-chevron-down");
            $(this).find('i').addClass("fa-chevron-up");
        }
    });

    $("#backToHome").click(function () {
        window.location.href = "login.html";
    });

    $("#alertOk").click(function () {
        $("body").removeClass("loading");
    });

});

var FaqHelper = {
    setInnerBodyHeight: function () {
        $("#wht-bg-cont").height(($(window).height()) - ($("#wht-bg-cont").offset().top) - 20);
    },

    getLocalization: function () {
        $("#headerRegistartion").html(Resources.Header_Register);
        $("#headerFAQ").html(Resources.Header_FAQ);
        $("#qust1").html(Resources.qust1 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans1").html(Resources.ans1);
        $("#qust2").html(Resources.qust2 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans2").html(Resources.ans2);
        $("#qust3").html(Resources.qust3 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans3").html(Resources.ans3);
        $("#qust4").html(Resources.qust4 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans4").html(Resources.ans4);
        $("#qust5").html(Resources.qust5 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans5").html(Resources.ans5);
        $("#qust6").html(Resources.qust6 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans6").html(Resources.ans6);
        $("#qust7").html(Resources.qust7 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans7").html(Resources.ans7);
        $("#qust8").html(Resources.qust8 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans8").html(Resources.ans8);
        $("#qust9").html(Resources.qust9 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans9").html(Resources.ans9);
        $("#qust10").html(Resources.qust10 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans10").html(Resources.ans10);
        $("#qust11").html(Resources.qust11 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans11").html(Resources.ans11);
        $("#qust12").html(Resources.qust12 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans12").html(Resources.ans12);
        $("#qust13").html(Resources.qust13 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans13").html(Resources.ans13);
        $("#qust14").html(Resources.qust14 + "<i class= 'dd-arw fa fa-chevron-down'></i>");
        $("#ans14").html(Resources.ans14);




    }

}