// 정규표현식
var idReg = /^(?=.*[A-Za-z0-9]).{2,20}$/;
var pwdReg = /^(?=.*[A-Za-z0-9]).{2,20}$/;
var phoneReg = /^\d{3}-\d{3,4}-\d{4}$/;

// 회원가입
$('#join').click(() => {
    $('#join-modal').show();
})

// $('input').focusout(() => {
//     $('#join-id-form').hide();
//     $('#join-pwd-form').hide();
//     $('#join-pwd-check-form').hide();
// })

$('#join-id').click(() => {
    $('#join-id-form').show();
    $('.join-alert').hide();
})

$('#join-id').focusout(() => {
    let inputId = $('#join-id').val();

    if (inputId == '') {
        $('.join-form').hide();
        $('#join-id-null').show();
    } else if (idReg.test(inputId) === false) {
        $('.join-form').hide();
        $('#join-id-wrong').show();
    } else {
        $('.join-form').hide();
        $('.join-alert').hide();
    }
})

$('#join-pwd').click(() => {
    $('#join-pwd-form').show();
    $('.join-alert').hide();
})

$('#join-pwd').focusout(() => {
    let inputPwd = $('#join-pwd').val();

    if (inputPwd == '') {
        $('.join-form').hide();
        $('#join-pwd-null').show();
    } else if (pwdReg.test(inputPwd) === false) {
        $('#join-pwd-form').hide();
        $('#join-pwd-wrong').show();
    } else {
        $('.join-form').hide();
        $('.join-alert').hide();
    }
})

$('#join-pwd-check').click(() => {
    $('#join-pwd-check-form').show();
    $('.join-alert').hide();
})

$('#join-pwd-check').focusout(() => {
    let inputPwd = $('#join-pwd').val();
    let inputPwdCheck = $('#join-pwd-check').val();

    if (inputPwdCheck == '') {
        $('.join-form').hide();
        $('#join-pwd-check-null').show();
    } else if (inputPwd === inputPwdCheck) {
        $('#join-pwd-check-form').hide();
        $('#join-pwd-check-yes').show();
        $('#join-pwd-check-no').hide();
    } else {
        $('#join-pwd-check-form').hide();
        $('#join-pwd-check-yes').hide();
        $('#join-pwd-check-no').show();
    }
})

$('#join-name').click(() => {
    $('.join-alert').hide();
})

$('#join-name').focusout(() => {
    if ($('#join-name').val() == '') $('#join-name-null').show();
})

$('#join-nickname').click(() => {
    $('.join-alert').hide();
})

$('#join-nickname').focusout(() => {
    if ($('#join-nickname').val() == '') $('#join-nic-null').show();
})

$('#join-email').click(() => {
    $('.join-alert').hide();
})

$('#join-email').focusout(() => {
    if ($('#join-email').val() == '') $('#join-email-null').show();
})

$('#address-num-btn').click(() => {
    $('.join-alert').hide();
})

$('#join-address-text').click(() => {
    $('.join-alert').hide();

    let inputNum = $('#join-address-number').val();

    if (inputNum == '') {
        $('#join-address-num-null').show();
    } else {
        $('#join-address-num-null').hide();
    }
})

$('#join-address-text').focusout(() => {
    let inputText = $('#join-address-text').val();
    if (inputText == '') {
        $('#join-address-num-null').hide();
        $('#join-address-null').show();
    } else {
        $('#join-address-null').hide();
        $('#join-address-num-null').hide();
    }
})

$('#join-phone').click(() => {
    $('.join-form').hide();
})

$('#join-phone').focusout(() => {
    let inputPhone = $('#join-phone').val();

    if (inputPhone == '') {
        $('.join-form').hide();
        $('#join-phone-null').show();
    } else if (phoneReg.test(inputPhone) === false) {
        $('#join-phone-form').hide();
        $('#join-phone-wrong').show();
    } else {
        $('.join-form').hide();
        $('#join-phone-null').hide();
        $('#join-phone-wrong').hide();
    }
})

$('#join-submit').click((e) => {
    let inputId = $('#join-id').val();
    let inputPwd = $('#join-pwd').val();

    if (inputId == '') {
        e.preventDefault();
        // $('#join-id-form').hide();
        $('#join-id-null').show();

    } else if (idReg.test(inputId) == false) {
        e.preventDefault();
        // $('#join-id-form').hide();
        $('#join-id-wrong').show();
    }

    if (inputPwd == '') {
        e.preventDefault();
        $('#join-pwd-null').show();
    } else if (pwdReg.test(inputPwd) == false) {
        e.preventDefault();
        // $('#join-pwd-form').hide();
        $('#join-pwd-wrong').show();
    }

    if ($('#join-pwd-check').val() == '') {
        e.preventDefault();
        $('#join-pwd-check-null').show();
    }

    if ($('#join-name').val() == '') {
        e.preventDefault();
        $('#join-name-null').show();
    }

    if ($('#join-nickname').val() == '') {
        e.preventDefault();
        $('#join-nic-null').show();
    }

    if ($('#join-email').val() == '') {
        e.preventDefault();
        $('#join-email-null').show();
    }

    if ($('#join-address-number').val() == '') {
        e.preventDefault();
        $('#join-address-num-null').show();
    }

    if ($('#join-address-text').val() == '') {
        e.preventDefault();
        $('#join-address-null').show();
    }

    if ($('input[id="admin"]').is(':checked') == false && $('input[id="user"]').is(':checked') == false) {
        e.preventDefault();
        $('#join-radio').show();
    }
})

// 회원 로그인
$('#member-login').click(() => {
    $('#login-modal').show();
})

$('#login-id').click(() => {
    $('.login-alert').hide();
    $('#login-id-form').show();
})

$('#login-id').focusout(() => {
    let inputId = $('#login-id').val();

    if (inputId == '') {
        $('#login-id-form').hide();
        $('#login-id-null').show();
    } else {
        $('.login-form').hide();
        $('.login-alert').hide();
    }
})

$('#login-pwd').click(() => {
    $('.login-alert').hide();
    $('#login-pwd-form').show();
})

$('#login-pwd').focusout(() => {
    let inputPwd = $('#login-pwd').val();

    if (inputPwd == '') {
        $('#login-pwd-form').hide();
        $('#login-pwd-null').show();
    } else {
        $('.login-form').hide();
        $('.login-alert').hide();
    }
})

$('#login-submit').click((e) => {
    let inputId = $('#login-id').val();
    let inputPwd = $('#login-pwd').val();

    if (inputId == '' && inputPwd == '') {
        e.preventDefault();
        $('#login-id-null').show();
        $('#login-pwd-null').show();
    } else if (inputId == '') {
        e.preventDefault();
        $('#login-id-null').show();
    } else if (inputPwd == '') {
        e.preventDefault();
        $('#login-pwd-null').show();
    }
})

// 비회원 로그인
$('#non-member-login').click(() => {
    $('#noMember-login-modal').show();
})

$('#login-name').focusout(() => {
    let inputName = $('#login-name').val();

    if(inputName == '') {
        $('#login-name-null').show();
    } else {
        $('#login-name-null').show();
    }
})

$('#login-phone').click(() => {
    $('.login-alert').hide();
    $('#login-phone-form').show();
})

$('#login-phone').focusout(() => {
    let inputPhone = $('#login-phone').val();

    if (inputPhone == '') {
        $('#login-phone-form').hide();
        $('#login-phone-null').show();
    } else if (phoneReg.test(inputPhone) === false) {
        $('#login-phone-form').hide();
        $('#login-phone-null').hide();
        $('#login-phone-wrong').show();
    } else {
        $('#login-phone-null').hide();
        $('#login-phone-wrong').hide();
        $('#login-phone-form').hide();
    }
})

$('#login-check-pwd').click(() => {
    $('.login-alert').hide();
    $('#login-chkPwd-form').show();
})

$('#login-check-pwd').focusout(() => {
    let inputPwd = $('#login-check-pwd').val();

    if (inputPwd == '') {
        $('#login-chkPwd-form').hide();
        $('#login-chkPwd-null').show();
    } else {
		$('#login-chkPwd-form').hide();
        $('#login-chkPwd-null').hide();
    }
})

$('#noMember-login-submit').click((e) => {
    let inputPhone = $('#login-phone').val();
    let inputPwd = $('#login-check-pwd').val();
    let inputName = $('#login-name').val();

	console.log(inputPhone);
	console.log(inputPwd);

    if (inputPhone == '' && inputPwd == '' && inputName == '') {
        e.preventDefault();
        $('#login-phone-null').show();
        $('#login-chkPwd-null').show();
        $('#login-name-null').show();
    } else if (inputPhone == '') {
        e.preventDefault();
        $('#login-phone-null').show();
    } else if (inputPwd == '') {
        e.preventDefault();
        $('#login-chkPwd-null').show();
    } else if (inputName == '') {
        e.preventDefault();
        $('#login-name-null').show();
    }else {
        $('#join').hide();
        $('#member-login').hide();
        $('#non-member-login').hide();
        $('#admin-change').hide();
        $('#logout').show();
        $('#cart').show();
        $('.modal-back').hide();
    }
})

// 관리자 로그인
$('#admin-change').click(() => {
    $('#admin-login-modal').show();
})

$('#admin-id').click(() => {
    $('.login-alert').hide();
    $('#admin-id-form').show();
})

$('#admin-id').focusout(() => {
    let inputId = $('#admin-id').val();

    if (inputId == '') {
        $('#admin-id-form').hide();
        $('#admin-id-null').show();
    } else {
        $('.login-form').hide();
        $('.login-alert').hide();
    }
})

$('#admin-pwd').click(() => {
    $('.login-alert').hide();
    $('#admin-pwd-form').show();
})

$('#admin-pwd').focusout(() => {
    let inputPwd = $('#admin-pwd').val();

    if (inputPwd == '') {
        $('#admin-pwd-form').hide();
        $('#admin-pwd-null').show();
    } else {
        $('.login-form').hide();
        $('.login-alert').hide();
    }
})

$('#admin-submit').click((e) => {
    let inputId = $('#admin-id').val();
    let inputPwd = $('#admin-pwd').val();

    if (inputId == '' && inputPwd == '') {
        e.preventDefault();
        $('#admin-id-null').show();
        $('#admin-pwd-null').show();
    } else if (inputId == '') {
        e.preventDefault();
        $('#admin-id-null').show();
    } else if (inputPwd == '') {
        e.preventDefault();
        $('#admin-pwd-null').show();
    } else {
        $('#join').hide();
        $('#member-login').hide();
        $('#non-member-login').hide();
        $('#admin-change').hide();
        $('#logout').hide();
        $('#cart').hide();
        $('.modal-back').hide();
        $('#change').show();
    }
})


// 모달창 닫기
$('.modal-back').click((e) => {
    if (e.target == e.currentTarget) {
        $('.modal-back').hide();
        $('input').val('');
        $('.text').hide();
    }
})

$('.exit').click((e) => {
    e.preventDefault();
    $('.modal-back').hide();
    $('input').val('');
    $('.text').hide();
})

$('#change').click(() => {
    $('#admin-ul').hide();
    $('#user-ul').show();
    $('.admin-nav').hide();
    $('.admin-nav-sub').hide();
    $('.user-nav').show();
})

// 이동
$('#cart').click(() => {
	$(location).attr('href', '/mypage');	
})

$('#noMember-logout').click(() => {
	$(location).attr('href', '/logout');
})

$('#logout').click(() => {
	$(location).attr('href', '/logout');
})

$('#change').click(() => {
	$(location).attr('href', '/logout');	
})

$('#admin-nav-1').click(() => {
	$(location).attr('href', '/Manager/Account');
})

$('#admin-nav-2').click(() => {
	$(location).attr('href', '/Manager/Report');
})

$('#admin-nav-3').click(() => {
	$(location).attr('href', '/Manager/Item');
})

$('#sub-1').click(() => {
	$(location).attr('href', '/Manager/Item');
})

$('#sub-2').click(() => {
	$(location).attr('href', '/Manager/ItemCategory');
})

$('#sub-3').click(() => {
	$(location).attr('href', '/Manager/Statistics');
})

$('#sub-4').click(() => {
	$(location).attr('href', '/Manager/Coupon');
})

$('#sub-5').click(() => {
	$(location).attr('href', '/Manager/Question');
})

$('#sub-6').click(() => {
	$(location).attr('href', '/Manager/Refund');
})

$('#sub-7').click(() => {
	$(location).attr('href', '/Manager/Notice');
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

// header-ul 변경

$('#logout').click(() => {
    $('#join').show();
    $('#member-login').show();
    $('#non-member-login').show();
    $('#admin-change').show();
    $('#logout').hide();
    $('#cart').hide();
})

// 카카오 로그인
function loginWithKakao() {
    Kakao.Auth.login({
        success: function (response) {
            Kakao.API.request({
                url: '/v2/user/me',
                data: {
                    property_keys: ["id", "kakao_account.email", "properties.nickname"]
                },
                success: function (response) {
                    var data = {
                        id: response.id,
                        email: response.kakao_account.email,
                        nickname: response.properties.nickname
                    };
                    $.ajax({
                        type: "POST",
                        url: "/kakaologin/doing",
                        data: data,
                        dataType: "json",
                        success: function (result) {
                            console.log(result);
                            console.log("finish");
                            console.log(location.hostname);
                            const res = $.trim(result.res);
                            if (res.includes("redirect:")) {
                                const splits = res.substring(9);
                                window.location.replace(splits);
                            } else {
                                const splits = res.substring(11);
                                window.location.href = "../" + splits;
                            }
                        },
                        error: function (request, error) {
                            console.log("에러");
                            console.log("code: " + request.status + "\n message" + request.responseText + "\n error: " + error);
                        },
                    });
                },
                fail: function (error) {
                    console.log(error);
                    console.log("fail");
                },
            });
        },
        fail: function (error) {
            console.log(error);
        },
    });
}

// 버튼
$('#address-num-btn').click((e) => {
    window.name = "jusoPopup";
    var pop = window.open("/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes");   
        	
})

$('.overlap-check').click((e) => {
    e.preventDefault();
})

// 토글
$('#admin-nav-3').click(() => {
    $('.admin-nav-sub').slideToggle();
    $('.admin-nav-sub').addClass('click-bg');
    $('#sub-1').addClass('click-font');

    $('#admin-nav-3 .fas').removeClass('fa-chevron-circle-right');
    $('#admin-nav-3 .fas').addClass('fa-chevron-circle-down');
})