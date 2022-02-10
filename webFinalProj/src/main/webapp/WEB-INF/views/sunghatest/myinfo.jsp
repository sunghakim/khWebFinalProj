<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my info</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.account.getSocial_account_id() eq 'false'}">
		${account.account_id} 님 로그인 되었습니다. 
		</c:when>
		<c:otherwise>
		${account.social_account_id} 님 로그인 되었습니다. 
		</c:otherwise>
	</c:choose>
	<hr>
	<ul>
		<li><a href="/checkMyinfo">내정보 확인</a></li>
		<li><a href="/checkCarts">장바구니</a></li>
		<li><a href="/checkCoupon">쿠폰</a></li>
		<li><a href="/checkZzim">찜 목록</a></li>
		<li><a href="/checkPayedList">주문조회</a></li>
		<li><a href="/checkQuestionList">문의 및 신고</a></li>
	</ul>
</body>
</html>