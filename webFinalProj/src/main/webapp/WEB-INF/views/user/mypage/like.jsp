<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/like.css">
    <title>결제</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<div class="like-body">
	<div>
	    <div class="likeHeader">
	        <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
	        <label><h1>찜 목록</h1></label>
	    </div>
	    <% int index = 0; %>
		<c:forEach var="zzim" items="${zzimList}">
	    <div class="likeBody" onclick="location.href='/itemDetail/main?item_id=' + ${zzim.item_id}">
	        <div class="like-item">
	            <img class="like-img" src="${imageList.get(index).getDownloadPath()}" alt="...">
	            <div class="like-btn"><i class="fa-solid fa-heart"></i></div>
	            <div class="like-text">
	            ${itemList.get(index).getName()}<br>${itemList.get(index).getPrice()}
	            </div>
	        </div>
	    </div> 
	    <% index++; %>
	    </c:forEach>   
	</div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/mypage/like.js">
<%@ include file="../common/footer.jsp"%>
