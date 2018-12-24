jQuery(document).ready(function () {
    loadString();
   // window.localStorage.setItem("CountryCode", "en");
    conditionHelper.getLocalization();
    if (window.localStorage.getItem('commercialInformationChk') !== null && window.localStorage.getItem('commercialInformationChk') !== 'undefined')
        window.localStorage.getItem('commercialInformationChk') == 'true' ? $("#agreeCommercialInfoBtn").attr('checked', true) : $("#noagreeCommercialInfoBtn").attr('checked', true);

    if (window.localStorage.getItem('marketStudiesChk') !== null && window.localStorage.getItem('marketStudiesChk') !== 'undefined')
        window.localStorage.getItem('marketStudiesChk') == 'true' ? $("#agreeMarketStudiesBtn").attr('checked', true) : $("#noagreeMarketStudiesBtn").attr('checked', true);

    if (window.localStorage.getItem('affiliatedCompaniesChk') !== null && window.localStorage.getItem('affiliatedCompaniesChk') !== 'undefined')
        window.localStorage.getItem('affiliatedCompaniesChk') == 'true' ? $("#affiliatedCompaniesChk").attr('checked', true) : $("#noaffiliatedCompaniesChk").attr('checked', true);

    if (window.localStorage.getItem('linkFrom') === 'myArea') {
        window.localStorage.getItem('chkVlpc') == 'pvc' ? $("#backToReg").html(Resources.Privacy_close_button) : $("#backToReg").html(Resources.TnC_close_button);
    } else {
        window.localStorage.getItem('chkVlpc') == 'pvc' ? $("#backToReg").html(Resources.Privacy_close_button) : $("#backToReg").html(Resources.TnC_close_button);
    }


    $('#backToReg').click(function () {
        window.localStorage.setItem('Legal_terms_registration', 'true')
        if (window.localStorage.getItem('linkFrom') === 'myArea') {
            window.localStorage.removeItem('linkFrom')
            window.localStorage.removeItem('chk');
            window.location.href = "my_area.html";
        }
        else if (window.localStorage.getItem('linkFrom') === 'importantNotice') {
            window.localStorage.removeItem('linkFrom')
            window.localStorage.removeItem('chk');
            window.location.href = "importantNotice.html";
        }
        else {
            window.localStorage.setItem('isAcceptCondition', true);
            window.location.href = "register.html";
        }
    });

    $('#backToMain').click(function () {
        if (conditionHelper.isClickable) {
            window.localStorage.setItem('Legal_terms_registration', 'true')
            window.location.href = "register.html";
        }
    });

    $("#CommercialInfo input")
    .on('change', function () {

        if ($('input[name="agreeCommercialInfoBtn"]:checked', '#CommercialInfo').val() === 'accept') {
            window.localStorage.setItem('commercialInformationChk', true);

        }
        else {
            window.localStorage.setItem('commercialInformationChk', false);
        }
    });

    $("#MarketStudies input")
    .on('change', function () {
        if ($('input[name="agreeMarketStudiesBtn"]:checked', '#MarketStudies').val() === 'accept') {
            window.localStorage.setItem('marketStudiesChk', true);
        }
        else {
            window.localStorage.setItem('marketStudiesChk', false);
        }
    });

    $("#affiliatedCompanies input")
    .on('change', function () {
        if ($('input[name="affiliatedCompaniesChk"]:checked', '#affiliatedCompanies').val() === 'accept') {
            window.localStorage.setItem('affiliatedCompaniesChk', true);
        }
        else {
            window.localStorage.setItem('affiliatedCompaniesChk', false);
        }
    });
});

var conditionHelper = {
    isClickable: false,


    getLocalization: function () {
        if (window.localStorage.getItem('chkVlpc') === 'pvc' || window.localStorage.getItem('chk') === 'pvcy') {
            $("#pvc_header").html(Resources.pvc_header);
            $("#pvc_heading").html(Resources.pvc_heading);
            $("#pvc_hdng_a").html(Resources.pvc_hdng_a);
            $("#pvc_hdng_b").html(Resources.pvc_hdng_b);
            $("#pvc_hdng_c").html(Resources.pvc_hdng_c);
            $("#pvc_heading_dtl").html(Resources.pvc_heading_dtl);
            $("#pvc_heading1").html(Resources.pvc_heading1);
            $("#pvc_heading1_dtl").html(Resources.pvc_heading1_dtl);
            $("#pvc_heading2").html(Resources.pvc_heading2);
            $("#pvc_heading2_dtl").html(Resources.pvc_heading2_dtl);
            $("#pvc_hdng2_a").html(Resources.pvc_hdng2_a);
            $("#pvc_hdng2_b").html(Resources.pvc_hdng2_b);
            $("#pvc_hdng2_c").html(Resources.pvc_hdng2_c);
            $("#pvc_heading2_dtl_ext").html(Resources.pvc_heading2_dtl_ext);

            $("#pvc_heading3").html(Resources.pvc_heading3);
            $("#pvc_heading3_dtl").html(Resources.pvc_heading3_dtl);
            $("#pvc_heading4").html(Resources.pvc_heading4);
            $("#pvc_heading4_dlt").html(Resources.pvc_heading4_dlt);
            $("#pvc_hdng4_a").html(Resources.pvc_hdng4_a);
            $("#pvc_hdng4_b").html(Resources.pvc_hdng4_b);
            $("#pvc_hdng4_c").html(Resources.pvc_hdng4_c);
            $("#pvc_heading4_dtl_ext").html(Resources.pvc_heading4_dtl_ext);
            $("#pvc_heading5").html(Resources.pvc_heading5);
            $("#pvc_heading5_dtl").html(Resources.pvc_heading5_dtl);
            $("#pvc_hdng5_a").html(Resources.pvc_hdng5_a);
            $("#pvc_hdng5_b").html(Resources.pvc_hdng5_b);
            $("#pvc_hdng5_c").html(Resources.pvc_hdng5_c);
            $("#pvc_hdng5_d").html(Resources.pvc_hdng5_d);
            $("#pvc_hdng5_e").html(Resources.pvc_hdng5_e);
            $("#pvc_heading6").html(Resources.pvc_heading6);
            $("#pvc_heading6_dtl").html(Resources.pvc_heading6_dtl);
            $("#pvc_heading7").html(Resources.pvc_heading7);
            $("#pvc_heading7_dtl").html(Resources.pvc_heading7_dtl);
            $("#pvc_heading8").html(Resources.pvc_heading8);
            $("#pvc_heading8_dtl").html(Resources.pvc_heading8_dtl);
            $("#pvc_heading9").html(Resources.pvc_heading9);
            $("#pvc_heading9_dtl").html(Resources.pvc_heading9_dtl);
            $("#pvc_header3").html(Resources.pvc_header3);
            $("#pvc_header3_dtl").html(Resources.pvc_header3_dtl);
            //$("#agreeCommercialInfoBtnLBL1").html(Resources.agreeCommercialInfoBtnLBL1);
            //$("#noagreeCommercialInfoBtnLBL1").html(Resources.noagreeCommercialInfoBtnLBL1);
            $("#pvc_header3_dtl1").html(Resources.pvc_header3_dtl1);
            $("#agreeCommercialInfoBtnLBL1").html(Resources.agreeCommercialInfoBtnLBL1);
            $("#noagreeCommercialInfoBtnLBL1").html(Resources.noagreeCommercialInfoBtnLBL1);
            $("#pvc_header3_dtl2").html(Resources.pvc_header3_dtl2);
            $("#agreeCommercialInfoBtnLBL2").html(Resources.agreeCommercialInfoBtnLBL2);
            $("#noagreeCommercialInfoBtnLBL2").html(Resources.noagreeCommercialInfoBtnLBL2);
            $("#pvc_header3_dtl3").html(Resources.pvc_header3_dtl3);
            $("#agreeCommercialInfoBtnLBL3").html(Resources.agreeCommercialInfoBtnLBL3);
            $("#noagreeCommercialInfoBtnLBL3").html(Resources.noagreeCommercialInfoBtnLBL3);
        }
        else {
            $("#tc_title").html(Resources.tc_title);
            $("#tc_h1").html(Resources.tc_h1);
            $("#tc_p1_1").html(Resources.tc_p1_1);
            $("#tc_p1_2").html(Resources.tc_p1_2);
            $("#tc_h2").html(Resources.tc_h2);
            $("#tc_p2_1").html(Resources.tc_p2_1);
            $("#tc_p2_1_1").html(Resources.tc_p2_1_1);
            $("#tc_p2_1_2").html(Resources.tc_p2_1_2);
            $("#tc_p2_2").html(Resources.tc_p2_2);
            $("#tc_p2_3").html(Resources.tc_p2_3);
            $("#tc_p2_4").html(Resources.tc_p2_4);
            $("#tc_p2_5").html(Resources.tc_p2_5);
            $("#tc_h3").html(Resources.tc_h3);
            $("#tc_p3_1").html(Resources.tc_p3_1);
            $("#tc_p3_2").html(Resources.tc_p3_2);
            $("#tc_p3_3").html(Resources.tc_p3_3);
            $("#tc_p3_4").html(Resources.tc_p3_4);

            $("#tc_p3_5").html(Resources.tc_p3_5);
            $("#tc_p3_5_1").html(Resources.tc_p3_5_1);
            $("#tc_p3_5_2").html(Resources.tc_p3_5_2);
            $("#tc_p3_6").html(Resources.tc_p3_6);
            $("#tc_p3_7").html(Resources.tc_p3_7);
            $("#tc_p3_8").html(Resources.tc_p3_8);
            $("#tc_p3_9").html(Resources.tc_p3_9);
            $("#tc_h4").html(Resources.tc_h4);
            $("#tc_p4_1").html(Resources.tc_p4_1);
            $("#tc_p4_2").html(Resources.tc_p4_2);
            $("#tc_p4_2_1").html(Resources.tc_p4_2_1);
            $("#tc_p4_2_2").html(Resources.tc_p4_2_2);
            $("#tc_h5").html(Resources.tc_h5);
            $("#tc_p5_1").html(Resources.tc_p5_1);
            $("#tc_p5_2").html(Resources.tc_p5_2);

            $("#tc_h6").html(Resources.tc_h6);
            $("#tc_p6_1").html(Resources.tc_p6_1);
            $("#tc_p6_2").html(Resources.tc_p6_2);
            $("#tc_p6_2_1").html(Resources.tc_p6_2_1);
            $("#tc_p6_2_2").html(Resources.tc_p6_2_2);
            $("#tc_p6_2_3").html(Resources.tc_p6_2_2);

            $("#tc_h7").html(Resources.tc_h7);
            $("#tc_p7_1").html(Resources.tc_p7_1);
            $("#tc_p7_2").html(Resources.tc_p7_2);
            $("#tc_p7_3").html(Resources.tc_p7_3);
            $("#tc_p7_4").html(Resources.tc_p7_4);
            $("#tc_p7_5").html(Resources.tc_p7_5);
            $("#tc_p7_6").html(Resources.tc_p7_6);
            $("#tc_p7_7").html(Resources.tc_p7_7);
            $("#tc_p7_8").html(Resources.tc_p7_8);
            $("#tc_h8").html(Resources.tc_h8);
            $("#tc_p8_1").html(Resources.tc_p8_1);
            $("#tc_p8_2").html(Resources.tc_p8_2);
            $("#tc_p8_3").html(Resources.tc_p8_3);
            $("#tc_p8_4").html(Resources.tc_p8_4);
            $("#tc_p8_5").html(Resources.tc_p8_5);
            $("#tc_p8_6").html(Resources.tc_p8_6);

            $("#tc_h9").html(Resources.tc_h9);
            $("#tc_p9_1").html(Resources.tc_p9_1);
            $("#tc_p9_2").html(Resources.tc_p9_2);
            $("#tc_h10").html(Resources.tc_h10);
            $("#tc_p10_1").html(Resources.tc_p10_1);
            $("#tc_p10_2").html(Resources.tc_p10_2);
            $("#tc_p10_3").html(Resources.tc_p10_3);
            $("#tc_p10_4").html(Resources.tc_p10_4);
            $("#tc_p10_5").html(Resources.tc_p10_5);
            $("#tc_p10_6").html(Resources.tc_p10_6);
            $("#tc_p10_7").html(Resources.tc_p10_7);
            $("#tc_p10_7_1").html(Resources.tc_p10_7_1);
            $("#tc_p10_7_2").html(Resources.tc_p10_7_2);
            $("#tc_p10_8").html(Resources.tc_p10_8);

            $("#tc_h11").html(Resources.tc_h11);
            $("#tc_p11_1").html(Resources.tc_p11_1);
            $("#tc_p11_2").html(Resources.tc_p11_2);
            $("#tc_p11_3").html(Resources.tc_p11_3);
            $("#tc_h12").html(Resources.tc_h12);
            $("#tc_p12_1").html(Resources.tc_p12_1);
            $("#tc_p12_1_1").html(Resources.tc_p12_1_1);
            $("#tc_p12_2").html(Resources.tc_p12_2);
            $("#tc_p12_2_1").html(Resources.tc_p12_2_1);
            $("#tc_p12_3").html(Resources.tc_p12_3);
            $("#tc_p12_4").html(Resources.tc_p12_4);

            $("#tc_h13").html(Resources.tc_h13);
            $("#tc_p13_1").html(Resources.tc_p13_1);
            $("#tc_p13_2").html(Resources.tc_p13_2);
            $("#tc_h14").html(Resources.tc_h14);
            $("#tc_p14_1").html(Resources.tc_p14_1);
            $("#tc_h15").html(Resources.tc_h15);
            $("#tc_p15_1").html(Resources.tc_p15_1);
            $("#tc_p15_1_1").html(Resources.tc_p15_1_1);
        }
    },
}

