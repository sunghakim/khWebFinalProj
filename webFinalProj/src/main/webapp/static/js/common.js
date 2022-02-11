// 정규표현식
var idReg = /^[A-za-z0-9]{1,20}/g;
var pwdReg = /[A-Za-z0-9]{1,20}/;
var phoneReg = /^\d{3}-\d{3,4}-\d{4}$/;

// 회원가입
$('#member-join').click(() => {
    $('#join-modal').show();
})

$('input').focusout(() => {
    $('#join-id-form').hide();
    $('#join-pwd-form').hide();
    $('#join-pwd-check-form').hide();
})

$('#join-id').click(() => {
    $('#join-id').val('');
    $('#join-id-form').show();
    $('.join-alert').hide();
})

$('#join-pwd').click(() => {
    $('#join-pwd').val('');
    $('#join-pwd-form').show();
    $('.join-alert').hide();
})

$('#join-pwd-check').click(() => {
    $('#join-pwd-check').val('');
    $('#join-pwd-check-form').show();
    $('.join-alert').hide();
})

$('#join-submit').click((e) => {
    let inputId = $('#join-id').val();
    let inputPwd = $('#join-pwd').val();

    if (inputId == '') {
        e.preventDefault();
        $('#join-id-form').hide();
        $('#join-id-null').show();

    } else if (idReg.test(inputId) == false) {
        e.preventDefault();
        $('#join-id-form').hide();
        $('#join-id-wrong').show();
    }

    if (inputPwd == '') {
        e.preventDefault();
        $('#join-pwd-form').hide();
        $('#join-pwd-null').show();
    } else if (pwdReg.test(inputPwd) == false) {
        e.preventDefault();
        $('#join-pwd-form').hide();
        $('#join-pwd-wrong').show();
    }
})

// 로그인
$('#member-login').click(() => {
    $('#login-modal').show();
})

$('#login-id').click(() => {
    $('#login-id').val('');
    $('#login-id-form').show();
    $('.login-alert').hide();
})

$('#login-pwd').click(() => {
    $('#login-pwd').val('');
    $('#login-pwd-form').show();
    $('.login-alert').hide();
})

$('input').focusout(() => {
    $('#login-id-form').hide();
    $('#login-pwd-form').hide();
})

$('#login-submit').click((e) => {
    let inputId = $('#login-id').val();
    let inputPwd = $('#login-pwd').val();

    if (inputId == '') {
        e.preventDefault();
        $('#login-id-form').hide();
        $('#login-id-null').show();

    } else if (idReg.test(inputId) == false) {
        e.preventDefault();
        $('#login-id-form').hide();
        $('#login-id-wrong').show();
    }

    if (inputPwd == '') {
        e.preventDefault();
        $('#login-pwd-form').hide();
        $('#login-pwd-null').show();
    } else if (pwdReg.test(inputPwd) == false) {
        e.preventDefault();
        $('#login-pwd-form').hide();
        $('#login-pwd-wrong').show();
    }
})

// 모달창 닫기
$('.modal-back').click((e) => {
    if (e.target == e.currentTarget) {
        $('.modal-back').hide();
        $('input').val('');
    }
})

$('.exit').click(() => {
    $('.modal-back').hide();
    $('input').val('');
})

// header-ul
$('#admin-change').click(() => {
    $('#user-ul').hide();
    $('#admin-ul').show();
    $('.user-nav').hide();
    $('.admin-nav').show();
})

$('#member-change').click(() => {
    $('#admin-ul').hide();
    $('#user-ul').show();
    $('.admin-nav').hide();
    $('.admin-nav-sub').hide();
    $('.user-nav').show();
})

// 이동
$('#admin-change').click(() => {
    $(location).attr('href', 'user.html');
})

$('#member-change').click(() => {
    $(location).attr('href', 'index.html');
})

$('#admin-nav-1').click(() => {
    $(location).attr('href', 'user.html');
})

$('#admin-nav-2').click(() => {
    $(location).attr('href', 'report.html');
})

$('#admin-nav-3').click(() => {
    $(location).attr('href', 'product-list.html');
})

$('#sub-1').click(() => {
    $(location).attr('href', 'product-list.html');
})

$('#sub-2').click(() => {
    $(location).attr('href', 'category.html');
})

$('#sub-3').click(() => {
    $(location).attr('href', 'statistics.html');
})

$('#sub-4').click(() => {
    $(location).attr('href', 'coupon-list.html');
})

$('#sub-5').click(() => {
    $(location).attr('href', 'contact-list.html');
})

$('#sub-6').click(() => {
    $(location).attr('href', 'repond.html');
})

$('#sub-7').click(() => {
    $(location).attr('href', 'notice-list.html');
})

// 카테고리 이벤트
for (let i = 1; i <= $('.user-nav li').length; i++) {
    $('#user-nav-' + i).click(() => {
        $('.user-nav li').removeClass('click-color');
        $('#user-nav-' + i).addClass('click-color');
    })
}

for (let i = 1; i <= $('.admin-nav li').length; i++) {
    $('#admin-nav-' + i).click(() => {
        $('.admin-nav li').removeClass('click-color');
        $('#admin-nav-' + i).addClass('click-color');
    })
}

for (let i = 1; i <= $('.admin-nav-sub li').length; i++) {
    $('#sub-' + i).click(() => {
        $('.admin-nav-sub li').removeClass('click-font');
        $('#sub-' + i).addClass('click-font');
    })
}