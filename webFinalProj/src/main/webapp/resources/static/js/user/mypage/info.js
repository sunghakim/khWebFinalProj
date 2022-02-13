$.fn.formReset = function() {
    $(this).parent().siblings("td").find("input").hide();
    $(this).parent().siblings("td").find("label").show();
};

document.domain = "localhost";
function goPopup(){
// IE에서 opener관련 오류가 발생하는 경우, window에 이름을 명시해줍니다.
	window.name = "jusoPopup";
// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusoPopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
    var pop = window.open("/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

/** API 서비스 제공항목 확대 (2017.02) **/
function jusoCallBack(roadFullAddr,zipNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.form.roadFullAddr.value = roadFullAddr;
	document.form.zipNo.value = zipNo;
}

$(document).ready(function(){
    // 닉네임 변경
    $("#nick-Btn").on("click", function(){
        let name = $("#nick-Btn").text();
        let value = $("#nick").text();

        if(name == '변경하기') {
            $("#nick").hide();
            $("#name").val(value);
            $("#name").show();
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
        let value = $("#phone-label").text();

        if(name == '수정하기') {
            $("#phone-label").hide();
            $("#phone").val(value);
            $("#phone").show();
            $("#phone-Btn").text('확인');
            $(this).next().show();
        } else if(name == '확인') {
            let regExp = /^(010|011|016|017|018|019)-?([0-9]{3,4})-?([0-9]{4})$/;
            let phone = $("#phone").val();
            
            if(regExp.test(phone)){
                phone =  $("#phone").val().replace(/(\d{3})-?(\d{3,4})-?(\d{4})$/, "$1-$2-$3");
                $("#phone").val(phone);
                $("#phone-label").text(phone);
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
        let value = $("#email-label").text();

        if(name == '수정하기') {
            $("#email-label").hide();
            $("#email").val(value);
            $("#email").show();
            $("#email-Btn").text('확인');
            $(this).next().show();
        } else if(name == '확인') {
            let regExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            let email = $("#email-Input").val();
            if(regExp.test(email)){
                $("#email-label input").val(email);
                $("#email-label").text(email);
                alert(email);
                $(this).formReset();
                $("#email-Btn").text('수정하기');
                $(this).next().hide();
            } else {
                alert("이메일 형식을 지키길 바람");
            }
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
        let txtPwd = $("#password").val();
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
            $("#password").val(after);
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
        $("#form").submit();
    });
    
  });
