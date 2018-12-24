jQuery(document).ready(function () {
    loadString();
    $('.pie_progress').asPieProgress({
        namespace: 'pie_progress'
    });

    myareaDetailHelper.fillDate();

    var obj = window.localStorage.getItem("UserObjec");
    $('.pie_progress--slow').asPieProgress({
        namespace: 'pie_progress',
        goal: 1000,
        min: 0,
        max: 1000,
        speed: 200,
        size: 100,
        easing: 'linear'
    });
    myareaDetailHelper.getLocalization();
    myareaDetailHelper.setInnerBodyHeight();
    $(window).resize(function () {
    });
    $('#resize-div-cont').click(function () {
        if ($(".arrow-cont").hasClass("menu-bar-img")) {
            $(".arrow-cont").addClass("menu-remove-img").removeClass("menu-bar-img");
            $("#header-hide").slideToggle("fast");
        }
        else {
            $("#header-hide").slideToggle("fast");
            $(".arrow-cont").addClass("menu-bar-img").removeClass("menu-remove-img");
        }

    })

    $('.click_h').on('click', function () {
        var top = $("#popup-pos").offset().top;
        var left = $("#popup-pos").offset().left;

        $('.popup-info').css({

            top: top,
            position: 'absolute',

        });
    });
    if (window.localStorage.getItem("Phone") != 'undefined') {
        $('#telNo').html(window.localStorage.getItem("Phone"));
    }
    if (window.localStorage.getItem("Email") != 'undefined') {
        $('#emailSpn').html(window.localStorage.getItem("Email"));
    }

    $('.form-group').focusout(function () {
        myareaDetailHelper.setProgressStatus();
    });

    $('#backMain').click(function () {
        if (!cmn_checkConnection()) {
            return false;
        }
        window.location.href = "home.html";
    });

    $("#cnclBtn").click(function () {
        window.location.href = 'my_area.html';
    });
    $("#saveBtn").click(function () {
        if (($("#countryDD option:selected").val() == "109") && myareaDetailHelper._percentageVal == 100) {
            myareaDetailHelper.upateExtraDetails();
        } else if (($("#countryDD option:selected").val() != "109") && myareaDetailHelper._percentageVal == 80) {
            myareaDetailHelper.upateExtraDetails();
        } else {
            cmn_openModelPopup(Resources.extra_detail_alert, "", "", "");
        }
    });

    $("#countryDD").change(function () {
        myareaDetailHelper.resetDistricts(0);
    });

    $("#provinciaDD").change(function () {
        myareaDetailHelper.resetCities(0)
    });
    document.addEventListener("deviceready", myareaDetailHelper.onDeviceReady, false);
});

var myareaDetailHelper = {
    _ipAddress: '',
    _isMail: '',
    _doB: '',
    _percentageVal: '',
    _isFeatching: '',
    _birthDistrictUId: '',
    _birthCityUId: '',

    onDeviceReady: function () {
        openNotification();
        //fullScreen();
        cmn_getRefreshTokenWithCallback(myareaDetailHelper.getCountries, 0);
        cmn_getRefreshTokenWithCallback(myareaDetailHelper.getProfessionList, 0);
        cmn_getRefreshTokenWithCallback(cmn_getWalletBalance);
    },

    setInnerBodyHeight: function () {
        $("#last-transaction-cont").height(($(window).height()) - ($("#last-transaction-cont").offset().top) - 20);
    },

    /*Method to localize strings.*/
    getLocalization: function () {
        $("#extprofileheader").html(Resources.ext_profile_header);
        $("#extprofilebody").html(Resources.ext_profile_body); 
        $("#extprofileclose").html(Resources.ext_profile_close);
        $("#walletBal").html(Resources.Home_w_upperlabel_01);
        $("#accountTitle").html(Resources.AccountLeftTab);
        $("#tel").html(Resources.extra_details_tel);
        $("#email").html(Resources.extra_details_email);
        $("#extDetailHeader").html(Resources.extra_details_header);
        $("#cmpltInfo").html(Resources.extra_details_header2);
        $("#acName").html(Resources.Ac_NameLabel);
        $("#surName").html(Resources.Ac_SurnameLabel);
        $("#edDOB").html(Resources.extra_details_birthdate);
        $("#edBC").html(Resources.extra_details_birthcountry);
        $("#edPv").html(Resources.extra_details_birthprovince);
        $("#edBct").html(Resources.extra_details_birthcity);
        $("#edSex").html(Resources.extra_details_sex);
        $("#edProf").html(Resources.extra_details_job);
        //$("#cnclBtn").html("ANNULLA");//Resources.button_delete);
        $("#cnclBtn").html(Resources.my_area_cancel_button);
        $("#saveBtn").html(Resources.button_save);
        $("#extprofilepageclose").html(Resources.ext_profile_page_close);
        $("#mailOpt").html(Resources.ext_profile_male);
        $("#femailOpt").html(Resources.ext_profile_female);
        $("#dateLbl").html(Resources.ext_profile_day);
        $("#monthLbl").html(Resources.ext_profile_monty);
        $("#yearLbl").html(Resources.ext_profile_year);

    },

    fillDate: function () {
        //dateDD
        for (i = 1; i <= 31; i++) {
            if (i < 10) {
                $("#dateDD").append('<option value= 0' + i + '>0' + i + '</option>');
            } else {
                $("#dateDD").append('<option value= ' + i + '>' + i + '</option>');
            }
        }
        myareaDetailHelper.fillMonth();
    },

    fillMonth: function () {
        for (i = 1; i <= 12; i++) {
            if (i < 10) {
                $("#monthDD").append('<option value= 0' + i + '>0' + i + '</option>');
            } else {
                $("#monthDD").append('<option value= ' + i + '>' + i + '</option>');
            }
        }
        myareaDetailHelper.fillYear();
    },

    fillYear: function () {
        var year = 1980;
        for (i = 1; i <= 30; i++) {
            $("#yearDD").append('<option value= ' + year + '>' + year + '</option>');
            year += 1;
        }
    },

    /*Method to featch list of countries.*/
    getCountries: function (startid) {
        var countryCode = '';
        if (window.localStorage.getItem("CountryCode") == 'ca')
            countryCode = 'es';
        else
            countryCode = window.localStorage.getItem("CountryCode");
        $("body").addClass('loading');
        var url = StageUrl + '/countries?locale=' + countryCode + '&count=10&sortby=0&sortorder=0&startid=' + startid;
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
                for (i = 0; i < data["Countries"].length; i++) {
                    $("#countryDD").append("<option value=" + data['Countries'][i]['CountryUId'] + ">" + data['Countries'][i]['CountryName'] + "</option>");
                }

                if (data.NextCountryUId != null) {
                    cmn_getRefreshTokenWithCallback(myareaDetailHelper.getCountries, data.NextCountryUId);
                }
                else if (data.NextCountryUId == null) {
                    cmn_getRefreshTokenWithCallback(myareaDetailHelper.getDistricts, 0);
                    cmn_getRefreshTokenWithCallback(myareaDetailHelper.getuserDetail);
                }

            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        });
    },

    resetDistricts: function (startid) {
        $('#provinciaDD').empty()
        cmn_getRefreshTokenWithCallback(myareaDetailHelper.getDistricts, startid);
    },
    /*Method to featch list of Districts as per Country.*/
    getDistricts: function (startid) {
        if ($("#countryDD option:selected").val() != "109") {
            $("#provinciaDD").attr('disabled', true);
            $("#citiesDD").attr('disabled', true);
            $('#provinciaDD').empty();
            $('#citiesDD').empty();
            if (myareaDetailHelper._isFeatching) {
                myareaDetailHelper._isFeatching = false;
                myareaDetailHelper.setProgressStatus();
                $("body").removeClass('loading');
            }
            return;
        }
        else {
            $("#provinciaDD").attr('disabled', false);
            $("#citiesDD").attr('disabled', false);

            var url = StageUrl + '/districts?countryuid=' + $("#countryDD option:selected").val() + '&count=10&sortby=0&sortorder=0&startid=' + startid;
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
                    if (data["Districts"].length == 0) {
                        $('#provinciaDD').empty()
                        $('#citiesDD').empty()
                    }
                    else {
                        for (i = 0; i < data["Districts"].length; i++) {
                            $("#provinciaDD").append("<option value=" + data['Districts'][i]['DistrictUId'] + ">" + data['Districts'][i]['Name'] + "</option>");
                        }
                    }
                    if (data.NextDistrictUId != null) {
                        myareaDetailHelper.getDistricts(data.NextDistrictUId);
                    }
                    else if (data.NextDistrictUId == null) {
                        if (myareaDetailHelper._isFeatching) {
                            if (myareaDetailHelper._birthDistrictUId != null) {
                                $('#provinciaDD').val(myareaDetailHelper._birthDistrictUId);
                                myareaDetailHelper.getCities(0);
                            } else {
                                $('#provinciaDD').val(0);
                                myareaDetailHelper.setProgressStatus();
                                $("body").removeClass('loading');
                            }
                        }
                        else {
                            myareaDetailHelper.getCities(0);
                        }
                    }
                },
                error: function (jqXHR, status, error) {
                    $("body").removeClass('loading');
                    cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                }
            });
        }
    },

    resetCities: function (startid) {
        $('#citiesDD').empty();
        cmn_getRefreshTokenWithCallback(myareaDetailHelper.getCities, startid);
    },

    /*Method to featch list of cities as per Distric.*/
    getCities: function (startid) {
        var url = StageUrl + '/cities?districtuid=' + $("#provinciaDD option:selected").val() + '&count=10&sortby=0&sortorder=0&startid=' + startid;
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
                if (data["Cities"].length == 0) {
                    $('#citiesDD').empty()
                }
                else {
                    for (i = 0; i < data["Cities"].length; i++) {
                        $("#citiesDD").append("<option value=" + data['Cities'][i]['CityUId'] + ">" + data['Cities'][i]['Name'] + "</option>");
                    }
                }

                if (data.NextCityUId != null) {
                    cmn_getRefreshTokenWithCallback(myareaDetailHelper.getCities, data.NextCityUId);
                }
                else {
                    if (myareaDetailHelper._isFeatching) {
                        myareaDetailHelper._isFeatching = false;
                        if (myareaDetailHelper._birthCityUId != null) {
                            $('#citiesDD').val(myareaDetailHelper._birthCityUId);
                        } else {
                            $('#citiesDD').val(0);
                        }
                        myareaDetailHelper.setProgressStatus();
                        $("body").removeClass('loading');
                    }
                }

            },
            error: function (jqXHR, status, error) {
                myareaDetailHelper.setProgressStatus();
                $("body").removeClass('loading');
            }

        });
    },

    /*Method to featch list of professions.*/
    getProfessionList: function (startid) {
        var countryCode = '';
        if (window.localStorage.getItem("CountryCode") == 'ca')
            countryCode = 'es';
        else
            countryCode = window.localStorage.getItem("CountryCode");
        var url = StageUrl + '/jobs?locale=' + countryCode + '&count=10&sortby=0&sortorder=0&startid=' + startid;
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
                if (data["Jobs"].length == 0) {
                    $('#professionDD').empty()
                }
                else {
                    for (i = 0; i < data["Jobs"].length; i++) {
                        $("#professionDD").append("<option value=" + data['Jobs'][i]['JobUId'] + ">" + data['Jobs'][i]['Description'] + "</option>");
                    }
                }

                if (data.NextJobUId != null) {
                    cmn_getRefreshTokenWithCallback(myareaDetailHelper.getProfessionList, data.NextJobUId);
                }
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }

        });

    },

    upateExtraDetails: function () {
        $("body").addClass('loading');
       if ($("#sexDD option:selected").val() == "1") {
            myareaDetailHelper.isMail = true;
        } else if (($("#sexDD option:selected").val() == "2")) {
            myareaDetailHelper.isMail = false;
        } else {
            myareaDetailHelper.isMail = null;
        }

        var objAccountInfo =
        {
            "FirstName": $('#userName').val(),
            "LastName": $('#userSurName').val(),
            "BirthCountryUId": $("#countryDD option:selected").val(),
            "BirthDistrictUId": $("#provinciaDD option:selected").val(),
            "BirthCityUId": $("#citiesDD option:selected").val(),
            "JobUId": $("#professionDD option:selected").val(),
            "BirthDate": myareaDetailHelper._doB,
            "IsMale": myareaDetailHelper.isMail,
        };
        cmn_getRefreshTokenWithCallback(myareaDetailHelper.updateUserAPI, objAccountInfo);
    },

    updateUserAPI: function (DTO) {
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
                window.localStorage.setItem('SavedED', 'true');

                window.location.href = 'my_area.html';
            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
            }
        });
    },

    setPercentage: function () {
        var count = 3
        if ($("#userName").val().length > 0) {
            ++count;
        }
        if ($("#userSurName").val().length > 0) {
            ++count;
        }
        if ($("#provinciaDD option:selected").val() > 0) {
            ++count;
        }
        if ($("#citiesDD option:selected").val() > 0) {
            ++count;
        }

        if ($("#professionDD option:selected").val() > 0) {
            ++count;
        }
        if ($("#sexDD option:selected").val() > 0) {
            ++count;
        }
        if (myareaDetailHelper._doB.length >= 10) {
            ++count;
        }
        return count;
    },

    getuserDetail: function () {
        var uname = encodeURIComponent(window.localStorage.getItem("UserName"));
        var url = StageUrl + '/users/?uname=' + uname;
        this._xhr = jQuery.ajax({
            method: 'GET',
            url: url,
            dataType: 'json',
            headers: {
                'Authorization': cmn_GetValuesFromAndroidFunction("AccessToken")
            },
            success: function (data, status, jqXHR) {
                myareaDetailHelper.fillUserDetails(data);

            },
            error: function (jqXHR, status, error) {
                $("body").removeClass('loading');
                cmn_openModelPopup(ErrorMessasges(jqXHR.responseJSON.ErrorCode), "", "", "");
                $('html, body').animate({ scrollTop: 0 }, 0);
            }
        });

    },

    fillUserDetails: function (data) {
        myareaDetailHelper._isFeatching = true;
        myareaDetailHelper._birthDistrictUId = data.BirthDistrictUId;
        myareaDetailHelper._birthCityUId = data.BirthCityUId;
        
        if(data.FirstName != null){
        $("#userName").val(data.FirstName.trim());
        }
        if(data.LastName != null){
        $("#userSurName").val(data.LastName.trim());
        }
        if (data.BirthDate != null) {
            var dt = myareaDetailHelper.isoDateReviver(data.BirthDate);
            $('#dateDD').val(myareaDetailHelper.getFormattedPartTime(new Date(dt).getDate()));
            $('#monthDD').val(myareaDetailHelper.getFormattedPartTime(new Date(dt).getMonth() + 1));
            $('#yearDD').val(new Date(dt).getFullYear());
        }
               
        if (data.BirthCountryUId != null) {
            $('#countryDD').val(data.BirthCountryUId);
            cmn_getRefreshTokenWithCallback(myareaDetailHelper.getDistricts, 0);
        }
        else if (data.Country == 'Italy') {
            $('#countryDD').val('109');
            cmn_getRefreshTokenWithCallback(myareaDetailHelper.getDistricts, 0);
        }
        else if (data.Country == 'Spain'){
            $('#countryDD').val('209');
            cmn_getRefreshTokenWithCallback(myareaDetailHelper.getDistricts, 0);
        }
        else if ((data.BirthCountryUId == null) && (data.Country != 'Spain') && (data.Country != 'Italy')){
            cmn_getRefreshTokenWithCallback(myareaDetailHelper.getDistricts, 0);
        }

        if (data.BirthDistrictUId != null) {
            if ($("#provinciaDD option:selected").val() != undefined) {
                cmn_getRefreshTokenWithCallback(myareaDetailHelper.getCities, 0);
            }
        }

        if (data.IsMale != null) {
            data.IsMale == true ? $('#sexDD').val('1') : $('#sexDD').val('2');
        }
        if (data.JobUId != null) {
            $('#professionDD').val(data.JobUId);
        }
    },

    isoDateReviver: function (value) {
        if (typeof value === 'string') {
            var a = /^(\d{4})-(\d{2})-(\d{2})T(\d{2}):(\d{2}):(\d{2}(?:\.\d*)?)(?:([\+-])(\d{2})\:(\d{2}))?Z?$/.exec(value);
            if (a) {
                var utcMilliseconds = Date.UTC(+a[1], +a[2] - 1, +a[3], +a[4], +a[5], +a[6]);
                return new Date(utcMilliseconds);
            }
        }
        return value;
    },

    getFormattedPartTime: function (partTime) {
        if (partTime < 10)
            return "0" + partTime;
        return partTime;
    },

    checkAllFields: function () {
        if ($("#userName").val().length == 0) {
            alert("Enter Name");
            return false;
        }
        else if ($("#userSurName").val().length == 0) {
            alert("Enter sur Name");
            return false;
        }
        else if ($("#provinciaDD option:selected").is(':enabled') && $("#provinciaDD option:selected").val() == 0) {
            alert("Select provinc");
            return false;
        }
        else if ($("#citiesDD option:selected").is(':enabled') && $("#citiesDD option:selected").val() == 0) {
            alert("Select city");
            return false;
        }

        else if ($("#professionDD option:selected").val() == 0) {
            alert("Select professional");
            return false;
        }
        else if ($("#sexDD option:selected").val() == 0) {
            alert("Select gender");
            return false;
        }
        else if (myareaDetailHelper._doB.length == 10) {
            alert("Select DoB");
            return false;
        }
        else {
            return true;
        }
    },

    setProgressStatus: function () {
        myareaDetailHelper._doB = $("#yearDD").val() + '-' + $("#monthDD option:selected").text() + '-' + $("#dateDD option:selected").text();
        myareaDetailHelper._percentageVal = myareaDetailHelper.setPercentage() * 10;
        $('.pie_progress').asPieProgress('go', myareaDetailHelper._percentageVal);
 }
}




