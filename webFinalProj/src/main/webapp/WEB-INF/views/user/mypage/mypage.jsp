<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://use.fontawesome.com/releases/v5.15.0/js/all.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/static/css/mypage.css">
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <title>Document</title>
</head>
<body>
    <div class="mypage-area" >
        <div id="non-user" class="user">
            <button class="btn"><i class="fas fa-shopping-cart"></i>장바구니</button><br>
            <button class="btn"><i class="fas fa-truck"></i>주문조회</button><br>
            <button class="btn"><i class="fas fa-exclamation-triangle"></i>1:1 문의</button>
            <div class="home">
                <label><span class="point">쇼핑</span>가기</label>
            </div>
        </div>
        <div id="user" class="user">
            <div class="ttxt">
                <label><span class="point">MY</span>PAGE</label>
            </div>
            <button class="btn"><i class="fas fa-user"></i>내 정보</button>
            <button class="btn"><i class="fas fa-heart"></i>찜 목록</button><br>
            <button class="btn"><i class="fas fa-shopping-cart"></i>장바구니</button>
            <button class="btn"><i class="fas fa-truck"></i>주문조회</button><br>
            <button class="btn"><i class="far fa-credit-card"></i>쿠폰</button>
            <button class="btn"><i class="fas fa-exclamation-triangle"></i>문의 및 신고</button><br>
            <div class="home">
                <label><span class="point">쇼핑</span>가기<label>
            </div>
        </div>
    </div>
    <script>
        $("#non-user").hide();
    </script>
</body>
</html>