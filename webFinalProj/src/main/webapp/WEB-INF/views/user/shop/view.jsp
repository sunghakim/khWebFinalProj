<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/view.css">
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
            <button class="detail-tab">후기<span class="review-num"></span></button>
            <button class="detail-tab">문의하기</button>
        </div>

        <div id="buy" class="buy">
            <div class="item-view">
                <div class="img-box">
                    <img src="${itemData.getFile_url()}" alt="">
                </div>
                <div class="item-div">
                    <div class="item-name">${itemData.getName()}</div>
                    <div id="like-line">
                        <label id="like-num">?</label>
                        <label id="like-state">하트모양</label>
                    </div>
                </div>
                <label class="item-price"><fmt:formatNumber value="${itemData.getPrice()}" pattern="#,###" /></label>
            </div>
            <div class="item-opt">
                <div>
                    <label style="color: rgb(180, 180, 180);">옵션</label>
                    <div class="opt opt-size">
                        <select id="option-size" name="item_size">
                            <option value="" selected hidden>사이즈</option>
                            <c:forEach var="i" items="${optionList}" varStatus="status">
	                            <option value="${status.count}" >${i.getItem_size()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="opt opt-color">
                        <select id="option-color" name="color" disabled>
                            <option value="" selected hidden>색상</option>
                            <c:forEach var="i" items="${optionList}">
                            	<option value="0" class="oc-${i.getItem_size()}" hidden>${i.getColor()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <hr>
                <div class="item-box">
                    
                </div>
                <hr>
                <div class="total-price">
                    <div>총 금액</div>
                    <div><span id="total">0</span>원</div>
                </div>
                <div class="buttons">
                    <div><button id="basket" type="button">장바구니에 담기</button></div>
                    <div><button id="payment" type="button">구매하기</button></div>
                </div>
            </div>
        </div>

        <div id="container"></div>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/shop/detail.js"></script>
<%@ include file="../common/footer.jsp"%>