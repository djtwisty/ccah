cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "id": "cordova-plugin-firebase.FirebasePlugin",
        "file": "plugins/cordova-plugin-firebase/www/firebase.js",
        "pluginId": "cordova-plugin-firebase",
        "clobbers": [
            "FirebasePlugin"
        ]
    },
    {
        "id": "cordova-plugin-vibration.notification",
        "file": "plugins/cordova-plugin-vibration/www/vibration.js",
        "pluginId": "cordova-plugin-vibration",
        "merges": [
            "navigator.notification",
            "navigator"
        ]
    },
    {
        "id": "cordova-plugin-firebase-authentication.FirebaseAuthentication",
        "file": "plugins/cordova-plugin-firebase-authentication/www/FirebaseAuthentication.js",
        "pluginId": "cordova-plugin-firebase-authentication",
        "merges": [
            "cordova.plugins.firebase.auth"
        ]
    },
    {
        "id": "phonegap-plugin-barcodescanner.BarcodeScanner",
        "file": "plugins/phonegap-plugin-barcodescanner/www/barcodescanner.js",
        "pluginId": "phonegap-plugin-barcodescanner",
        "clobbers": [
            "cordova.plugins.barcodeScanner"
        ]
    },
    {
        "id": "cordova-plugin-uniquedeviceid.UniqueDeviceID",
        "file": "plugins/cordova-plugin-uniquedeviceid/www/uniqueid.js",
        "pluginId": "cordova-plugin-uniquedeviceid",
        "merges": [
            "window.plugins.uniqueDeviceID"
        ]
    },
    {
        "id": "cordova-plugin-sms.SMS",
        "file": "plugins/cordova-plugin-sms/www/SMS.js",
        "pluginId": "cordova-plugin-sms",
        "clobbers": [
            "window.SMS"
        ]
    },
    {
        "id": "cordova-plugin-sim.Sim",
        "file": "plugins/cordova-plugin-sim/www/sim.js",
        "pluginId": "cordova-plugin-sim",
        "merges": [
            "window.plugins.sim"
        ]
    },
    {
        "id": "cordova-plugin-sim.SimAndroid",
        "file": "plugins/cordova-plugin-sim/www/android/sim.js",
        "pluginId": "cordova-plugin-sim",
        "merges": [
            "window.plugins.sim"
        ]
    },
    {
        "id": "cordova-plugin-network-information.network",
        "file": "plugins/cordova-plugin-network-information/www/network.js",
        "pluginId": "cordova-plugin-network-information",
        "clobbers": [
            "navigator.connection",
            "navigator.network.connection"
        ]
    },
    {
        "id": "cordova-plugin-network-information.Connection",
        "file": "plugins/cordova-plugin-network-information/www/Connection.js",
        "pluginId": "cordova-plugin-network-information",
        "clobbers": [
            "Connection"
        ]
    },
    {
        "id": "cordova-plugin-inappbrowser.inappbrowser",
        "file": "plugins/cordova-plugin-inappbrowser/www/inappbrowser.js",
        "pluginId": "cordova-plugin-inappbrowser",
        "clobbers": [
            "cordova.InAppBrowser.open",
            "window.open"
        ]
    },
    {
        "id": "cordova-plugin-fullscreen.AndroidFullScreen",
        "file": "plugins/cordova-plugin-fullscreen/www/AndroidFullScreen.js",
        "pluginId": "cordova-plugin-fullscreen",
        "clobbers": [
            "AndroidFullScreen"
        ]
    },
    {
        "id": "cordova-plugin-email-composer.EmailComposer",
        "file": "plugins/cordova-plugin-email-composer/www/email_composer.js",
        "pluginId": "cordova-plugin-email-composer",
        "clobbers": [
            "cordova.plugins.email",
            "plugin.email"
        ]
    },
    {
        "id": "cordova-plugin-dialogs.notification",
        "file": "plugins/cordova-plugin-dialogs/www/notification.js",
        "pluginId": "cordova-plugin-dialogs",
        "merges": [
            "navigator.notification"
        ]
    },
    {
        "id": "cordova-plugin-dialogs.notification_android",
        "file": "plugins/cordova-plugin-dialogs/www/android/notification.js",
        "pluginId": "cordova-plugin-dialogs",
        "merges": [
            "navigator.notification"
        ]
    },
    {
        "id": "cordova-plugin-device.device",
        "file": "plugins/cordova-plugin-device/www/device.js",
        "pluginId": "cordova-plugin-device",
        "clobbers": [
            "device"
        ]
    },
    {
        "id": "cordova-plugin-datepicker.DatePicker",
        "file": "plugins/cordova-plugin-datepicker/www/android/DatePicker.js",
        "pluginId": "cordova-plugin-datepicker",
        "clobbers": [
            "datePicker"
        ]
    },
    {
        "id": "cordova-plugin-appversion.RareloopAppVersion",
        "file": "plugins/cordova-plugin-appversion/www/app-version.js",
        "pluginId": "cordova-plugin-appversion",
        "clobbers": [
            "AppVersion"
        ]
    },
    {
        "id": "phonegap-plugin-mobile-accessibility.mobile-accessibility",
        "file": "plugins/phonegap-plugin-mobile-accessibility/www/mobile-accessibility.js",
        "pluginId": "phonegap-plugin-mobile-accessibility",
        "clobbers": [
            "window.MobileAccessibility"
        ]
    },
    {
        "id": "phonegap-plugin-mobile-accessibility.MobileAccessibilityNotifications",
        "file": "plugins/phonegap-plugin-mobile-accessibility/www/MobileAccessibilityNotifications.js",
        "pluginId": "phonegap-plugin-mobile-accessibility",
        "clobbers": [
            "MobileAccessibilityNotifications"
        ]
    },
    {
        "id": "com.cordova.plugins.sms.Sms",
        "file": "plugins/com.cordova.plugins.sms/www/sms.js",
        "pluginId": "com.cordova.plugins.sms",
        "clobbers": [
            "window.sms"
        ]
    },
    {
        "id": "cordova-plugin-secure-key-store.SecureKeyStore",
        "file": "plugins/cordova-plugin-secure-key-store/www/SecureKeyStore.js",
        "pluginId": "cordova-plugin-secure-key-store",
        "clobbers": [
            "cordova.plugins.SecureKeyStore"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-whitelist": "1.3.3",
    "cordova-plugin-firebase": "0.1.25",
    "cordova-plugin-vibration": "2.1.1-dev",
    "cordova-support-google-services": "1.0.0",
    "cordova-plugin-firebase-authentication": "0.11.1",
    "cordova-plugin-compat": "1.2.0",
    "phonegap-plugin-barcodescanner": "6.0.6",
    "cordova-plugin-uniquedeviceid": "1.3.2",
    "cordova-plugin-sms": "1.0.5",
    "cordova-plugin-sim": "1.3.3",
    "cordova-plugin-network-information": "1.3.4-dev",
    "cordova-plugin-inappbrowser": "1.3.1-dev",
    "cordova-plugin-fullscreen": "1.1.0",
    "cordova-plugin-email-composer": "0.8.11",
    "cordova-plugin-dialogs": "1.2.0",
    "cordova-plugin-device": "1.1.7",
    "cordova-plugin-datepicker": "0.9.3",
    "cordova-plugin-appversion": "1.0.0",
    "phonegap-plugin-mobile-accessibility": "1.0.5-dev",
    "com.cordova.plugins.sms": "0.1.10",
    "cordova-plugin-secure-key-store": "1.5.4",
    "cordova-plugin-proguard": "1.0.0"
};
// BOTTOM OF METADATA
});