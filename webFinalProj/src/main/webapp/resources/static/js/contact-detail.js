$('.back').click(() => {
    $(location).attr('href', '/Manager/Question');
})

$('.cancel').click(() => {
	e.preventDefault();
    $(location).attr('href', '/Manager/Question');
})

$(document).ready(function () {
    $('.admin-nav-sub').slideToggle();
    $('.admin-nav-sub').addClass('click-bg');
    $('#sub-5').addClass('click-font');

    $('#admin-nav-3 .fas').removeClass('fa-chevron-circle-right');
    $('#admin-nav-3 .fas').addClass('fa-chevron-circle-down');
})