$(document).on('show.bs.modal', function (event) {
    if (!event.relatedTarget) {
        $('.modal').not(event.target).modal('hide');
    };
    if ($(event.relatedTarget).parents('.modal').length > 0) {
        $(event.relatedTarget).parents('.modal').modal('hide');
    };
});

$(document).on('shown.bs.modal', function (event) {
    if ($('body').hasClass('modal-open') == false) {
        $('body').addClass('modal-open');
    };
});