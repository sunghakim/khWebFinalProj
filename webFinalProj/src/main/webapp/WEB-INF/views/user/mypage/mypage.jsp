<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://use.fontawesome.com/releases/v5.15.0/js/all.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/mypage.css">
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <title>마이페이지</title>
</head>
<body>
    <div class="mypage-area" >
        <div id="non-user" class="user">
            <a class="link" href="/mypage/checkCarts"><button class="btn"><i class="fas fa-shopping-cart"></i>장바구니</button></a><br>
            <a class="link" href="/mypage/checkPayedList"><button class="btn"><i class="fas fa-truck"></i>주문조회</button></a><br>
            <a class="link" href="/mypage/checkQuestionList"><button class="btn"><i class="fas fa-exclamation-triangle"></i>1:1 문의</button></a>
            <div class="home"><label><a class="link" href="#" onClick="history.back()"><span class="point">쇼핑</span>가기</a></label></div>
        </div>
        <div id="user" class="user">
            <div class="ttxt">
                <label><span class="point">MY</span>PAGE</label>
            </div>
            <a class="link" href="/checkMyinfo"><button class="btn"><i class="fas fa-user"></i>내 정보</button></a>
            <a class="link" href="/mypage/checkZzim"><button class="btn"><i class="fas fa-heart"></i>찜 목록</button></a><br>
            <a class="link" href="/mypage/checkCarts"><button class="btn"><i class="fas fa-shopping-cart"></i>장바구니</button></a>
            <a class="link" href="/mypage/checkPayedList"><button class="btn"><i class="fas fa-truck"></i>주문조회</button></a><br>
            <a class="link" href="/mypage/checkCoupon"><button class="btn"><i class="far fa-credit-card"></i>쿠폰</button></a>
            <a class="link" href="/mypage/checkQuestionList"><button class="btn"><i class="fas fa-exclamation-triangle"></i>문의 및 신고</button></a><br>
            <div class="home"><label><a class="link" href="#" onClick="history.back()"><span class="point">쇼핑</span>가기</a><label></div>
        </div>
    </div>
    <script>
       var sessionUserType = '${sessionScope.usertype}';
       var accountUserType = '${sessionScope.account.getSocial_account_id()}';
       if(sessionUserType == "web"){
         if(accountUserType == 2) {
             $("#non-user").show();
             $("#user").hide();
          } else {          
             $("#user").show();
              $("#non-user").hide();
          }
       } else if(sessionUserType == "social") {
          $("#user").show();
           $("#non-user").hide();
       }
    </script>
</body>
</html>