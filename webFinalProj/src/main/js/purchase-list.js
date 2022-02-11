$('.stats').click(() => {
    $(location).attr('href', 'statistics.html');
})

$(document).ready(function () {
    $('.admin-nav-sub').slideToggle();
    $('.admin-nav-sub').addClass('click-bg');
    $('#sub-3').addClass('click-font');

    $('#admin-nav-3 .fas').removeClass('fa-chevron-circle-right');
    $('#admin-nav-3 .fas').addClass('fa-chevron-circle-down');
})