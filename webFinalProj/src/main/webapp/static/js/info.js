$.fn.formReset = function() {
    $(this).parent().siblings("td").find("input").hide();
    $(this).parent().siblings("td").find("label").show();
};

$(document).ready(function(){
    // 닉네임 변경
    $("#nick-Btn").on("click", function(){
        let name = $("#nick-Btn").text();
        let value = $("#nick").text();

        if(name == '변경하기') {
            $("#nick").hide();
            $("#nick-Input").val(value);
            $("#nick-Input").show();
            $("#nick-Btn").text('중복확인');
            $(this).next().show();
        } else if(name == '중복확인') {
            value = $("#nick input").val();
            alert(value);
        }
    });

    $("#phone-Input").on("keydown", function() {
        $("#phone-Input").val($("#phone-Input").val().replace(/\s/g,''));
        let regExp1 = /(010|011|016|017|018|019)-([0-9]{3,4})-/g;
        let regExp2 = /[^0-9]]/g;

        if(regExp1.test($("#phone-Input").val())){
            $("#phone-Input").attr("maxlength", "13");
        } else if(!regExp2.test($("#phone-Input").val())){
            $("#phone-Input").attr("maxlength", "11");
        }
    });

    // 전화번호 변경
    $("#phone-Btn").on("click", function() {
        let name = $("#phone-Btn").text();
        let value = $("#phone").text();

        if(name == '수정하기') {
            $("#phone").hide();
            $("#phone-Input").val(value);
            $("#phone-Input").show();
            $("#phone-Btn").text('확인');
            $(this).next().show();
        } else if(name == '확인') {
            let regExp = /^(010|011|016|017|018|019)-?([0-9]{3,4})-?([0-9]{4})$/;
            let phone = $("#phone-Input").val();
            
            if(regExp.test(phone)){
                phone =  $("#phone-Input").val().replace(/(\d{3})-?(\d{3,4})-?(\d{4})$/, "$1-$2-$3");
                $("#phone-Input").val(phone);
                $("#phone").text(phone);
                alert(phone);
                $(this).formReset();
                $("#phone-Btn").text('수정하기');
                $(this).next().hide();
            } else {
                alert("휴대폰 번호 입력바람");
            }
        }
    });


    // 이메일 변경
    $("#email-Btn").on("click", function() {
        let name = $("#email-Btn").text();
        let value = $("#email").text();

        if(name == '수정하기') {
            $("#email").hide();
            $("#email-Input").val(value);
            $("#email-Input").show();
            $("#email-Btn").text('확인');
            $(this).next().show();
        } else if(name == '확인') {
            let regExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            let email = $("#email-Input").val();
            if(regExp.test(email)){
                $("#email input").val(email);
                $("#email").text(email);
                alert(email);
                $(this).formReset();
                $("#email-Btn").text('수정하기');
                $(this).next().hide();
            } else {
                alert("이메일 형식을 지키길 바람");
            }
        }
    });

    // 우편번호
    $("#postalCode-Btn").on("click", function() {
        let name = $("#postalCode-Btn").text();
        let value = $("#postalCode").text();

        if(name == '수정하기') {
            $("#postalCode").hide();
            $("#postalCode-Input").val(value);
            $("#postalCode-Input").show();
            $("#postalCode-Btn").text('확인');
            $(this).next().show();
        } else if(name == '확인') {
            let regExp = /^\d{3}-?\d{3}$/u;
            let postalCode = $("#postalCode-Input").val();
            if(regExp.test(postalCode)){
                $("#postalCode input").val(postalCode);
                $("#postalCode").text(postalCode);
                alert(postalCode);
                $(this).formReset();
                $("#postalCode-Btn").text('수정하기');
                $(this).next().hide();
            } else {
                alert("이메일 형식을 지키길 바람");
            }
        }
    });

    // 주소지
    $("#address1-Btn").on("click", function() {
        let name = $("#address1-Btn").text();
        let value = $("#address1").text();

        if(name == '수정하기') {
            $("#address1").hide();
            $("#address1-Input").val(value);
            $("#address1-Input").show();
            $("#address1-Btn").text('확인');
            $(this).next().show();
        } else if(name == '확인') {
            let address1 = $("#address1-Input").val();
            $("#address1 input").val(address1);
            $("#address1").text(address1);
            alert(address1);
            $(this).formReset();
            $("#address1-Btn").text('수정하기');
            $(this).next().hide();
        }
    });

    // 상세주소
    $("#address2-Btn").on("click", function() {
        let name = $("#address2-Btn").text();
        let value = $("#address2").text();

        if(name == '수정하기') {
            $("#address2").hide();
            $("#address2-Input").val(value);
            $("#address2-Input").show();
            $("#address2-Btn").text('확인');
            $(this).next().show();
        } else if(name == '확인') {
            let address2 = $("#address2-Input").val();
            $("#address2 input").val(address2);
            $("#address2").text(address2);
            alert(address2);
            $(this).formReset();
            $("#address2-Btn").text('수정하기');
            $(this).next().hide();
        }
    });


    $(".back").on("click", function() {
        $(this).hide();
        $(this).formReset();
        if($(this).prev().attr('id') == $("#nick-Btn").attr('id')) {
            $("#nick-Btn").text('변경하기');
        } else {
            $(this).prev().text('수정하기');
        }
    });

    // 비밀번호 변경
    $('.modal').on('hidden.bs.modal', function (e) {
        console.log('modal close');
        $(this).find('form')[0].reset();
        $("#pwd1").show();
        $("#pwd2").hide();
        $("#pwdNext").text('next >');
        $("#pwdNext").removeAttr("data-bs-dismiss");
    });

    $("#pwdNext").on("click", function() {
        let txtPwd = $("#txtPwd").val();
        let pwd = $("#pwd").val();
        let txt = $("#pwdNext").text();

        if(txt == "next >"){
            if(txtPwd == pwd) {
                alert(pwd);
                $("#pwd1").hide();
                $("#pwd2").show();
                $("#pwdNext").text('확인');
                $("#pwdNext").attr("data-bs-dismiss", "modal");
            } else {
                $("#pwd").attr("placeholder", "내용을 입력해주세요");
                $("#pwd").empty();
                $("#pwd").focus();
            } 

        } else if(txt == "확인"){
            let after = $("#newPwd").val();
            $("#txtPwd").val(after);
            alert(after);
        }
    });

    $("#checkPwd").keyup(function() {
        let newPwd = $("#newPwd").val();
        let check = $(this).val();
    
        if(newPwd == check) {
            $("#check").text('일치함');
        } else {
            $("#check").text('일치하지 않음');
        }
    });

    $("#submit").on("click", function() {
        $("#update-Info").submit();
    });
    
  });
