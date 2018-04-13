$(function () {
    $('#searchInput').keyup(function () {
        if ($(this).val() == '' || !($(this).val().indexOf('olx.ua') >=0)) {

            $('#searchConfirmButton').prop('disabled', true);
        } else {
            $('#searchConfirmButton').prop('disabled', false);
        }
    });
});