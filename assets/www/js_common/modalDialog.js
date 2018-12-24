jQuery(document).ready(function () {

    $("#alertOk").click(function () {
        cmn_closeModelPopup();
    });
});

function cmn_openModelPopup(message1, message2,cancel) {
    $("#alertHeader").html(Resources.all_alert_dialogue_header);

    $("#msg1").html(message1);
    $("#msg2").html(message2);
    
    $("#alertOk").html(Resources.all_alert_OK_button);
    if (cancel == false) {
        $("#alertCancel").hide();
    } else {
        $("#alertCancel").show();
        $("#alertCancel").html(Resources.all_alert_cancel_button);
    }
    $('#ct_modal_popup').modal();
    $('#ct_modal_popup').modal({ keyboard: false });
    $('#ct_modal_popup').modal('show');
}

function cmn_closeModelPopup() {
    $('#ct_modal_popup').modal();
    $('#ct_modal_popup').modal({ keyboard: false });
    $('#ct_modal_popup').modal('hide');
}



function cmn_openModelPopup4TU(message1, message2, cancel) {
    $("#alertHeader4TU").html(Resources.all_alert_dialogue_header);

    $("#msg14TU").html(message1);
    $("#msg24TU").html(message2);

    $("#alertOk4TU").html(Resources.all_alert_OK_button);
    if (cancel == false) {
        $("#alertCancel4TU").hide();
    } else {
        $("#alertCancel4TU").show();
        $("#alertCancel4TU").html(Resources.all_alert_cancel_button);
    }
    $('#ct_modal_popup4TU').modal();
    $('#ct_modal_popup4TU').modal({ keyboard: false });
    $('#ct_modal_popup4TU').modal('show');
}
function cmn_closeModelPopup4TU() {
    $('#ct_modal_popup4TU').modal();
    $('#ct_modal_popup4TU').modal({ keyboard: false });
    $('#ct_modal_popup4TU').modal('hide');
}
