<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="URL" value="/Manager_test"/>

<div>
	<span>
		<a href="${URL}/Account">회원관리</a>
	</span>
	<span>
		<a href="${URL}/Report">신고관리</a>
	</span>
	<span>
		<a href="${URL}/Item">상품관리</a>
	</span>
	<span>
		<a href="${URL}/Item/Category">카테고리관리</a>
	</span>
	<span>
		<a href="${URL}/Statistics">통계확인</a>
	</span>
	<span>
		<a href="${URL}/SoldHistory">판매내역</a>
	</span>
	<span>
		<a href="${URL}/Coupon">쿠폰목록</a>
	</span>
	<span>
		<a href="${URL}/Question">개인문의</a>
	</span>
	<span>
		<a href="${URL}/Refund">환불목록</a>
	</span>
	<span>
		<a href="${URL}/Notice">공지관리</a>
	</span>
</div>