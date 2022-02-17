<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/detail.css">
    <title>내정보</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<%@ include file="../common/sidenav.jsp"%>
<div>
	<input id="item_id" value="${itemData.getItem_id()}" hidden/>
    <div class="detail">
        <div class="detail-tabs">
            <button class="detail-tab here" disabled>구매하기</button>
            <button class="detail-tab">상세보기</button>
            <button class="detail-tab">후기<span class="review-num">${reviewCount}</span></button>
            <button class="detail-tab">문의하기</button>
        </div>

        <div id="buy" class="buy">
            <div class="item-view">
                <div class="img-box">
                    <img src="${itemImageList.get(0).getDownloadPath()}" alt="">
                </div>
                <div class="item-div">
                    <div class="item-name">${itemData.getName()}</div>
                </div>
                <label class="item-price"><fmt:formatNumber value="${itemData.getPrice()}" pattern="#,###" /></label>
            </div>
            <div class="item-content">
                <div>
                
                </div>
                <hr>
            </div>
        </div>

        <div id="container"></div>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/shop/detail.js"></script>
<%@ include file="../common/footer.jsp"%>