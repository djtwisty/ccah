jQuery(document).ready(function () {
	loadString();
	LoginpromoHelper.setScreenImage();
	LoginpromoHelper.getLocalization();
	$('#closepopup').click(function () {
	clearTimeout(LoginpromoHelper.timer);
	LoginpromoHelper.redirectToHome();
	});

	LoginpromoHelper.timer = setInterval(LoginpromoHelper.redirectToHome, 5000);
	});

var LoginpromoHelper = {
    timer: '',

    getLocalization: function () {        
    	if(window.localStorage.getItem("FirstName") == undefined ||window.localStorage.getItem("FirstName") == 'null'){
        $("#promosplashline1").html(Resources.Promo_splash_line1);
    	}
    	else{
    		$("#promosplashline1").html(Resources.Promo_splash_line1 + ' ' + window.localStorage.getItem("FirstName").toUpperCase());
    	}
        $("#promosplashline2").html(Resources.Promo_splash_line2);
		},

setScreenImage: function () {
        if (window.localStorage.getItem("CountryCode") == "fr") {
            $("#promoPopup").attr('src', "img/fr/promo_pop-up_FR.png");
        }
        else if (window.localStorage.getItem("CountryCode") == "en") {
            $("#promoPopup").attr('src', "img/en/promo_pop-up_EN.png");
        }
        else if (window.localStorage.getItem("CountryCode") == "es") {
            $("#promoPopup").attr('src', "img/es/promo_pop-up_ES.png");
        }
        else {
            $("#promoPopup").attr('src', "img/it/promo_pop-up_ITA.png");
        }
    },
    setInnerBodyHeight: function () {
        if (window.screen.availWidth < 1024) {
            var wHeight = Math.floor(($(window).height() - $(".payment-option").offset().top)) - 10;
            $(".payment-option").height(($(window).height() - ($(".payment-option").offset().top)) - 6);
            $('.wrapper-height').css({ height: wHeight });
        }
    },
    /*Method to choose Home page.*/
    redirectToHome: function () {
        window.location.href = 'home.html';
    },
}