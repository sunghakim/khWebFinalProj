<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/basket.css">
    <title>장바구니</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<div class="basket">
 <div>
    <div class="basketHeader">
        <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
        <label><h1>장바구니</h1></label>
    </div>
    <div class="form">
        <div class="div-back">
        <c:set var="total" value="0" />
        <c:forEach var="i" items="${itemList}" varStatus="status">
            <div class="product">
                <input type="checkbox" class="item" name="item_id" value="${shoppingList[status.index].getShopping_list_id()}" checked>
                <div class="item-box">
                    <div class="data-box">
                        <img>
                        <div class="data">
                            <h5>${i.getName()}</h5>
                            <c:set var="itemOpt" value="${itemOptionList[status.index].getItem_size()} / ${itemOptionList[status.index].getColor()}"/>
                            <label>${itemOpt}</label><br>
                            <c:set var="price" value="${itemOptionList[status.index].getAmount() * i.getPrice()}" />
                            <c:set var="total" value="${total + price}" />
                            <label class="price"><fmt:formatNumber value="${price}" pattern="#,###" /></label>
                            <input class="item-price" value="${i.getPrice()}" hidden/>
                        </div>
                    </div>
                    <div class="count">
                        <button class="plus" type="button"><i class="fa-solid fa-plus"></i></button>
                        <h4>${itemOptionList[status.index].getAmount()}</h4>
                        <button class="minus" type="button"><i class="fa-solid fa-minus"></i></button>
                        <button class="delete" type="button"><i id="xmark" class="fa-solid fa-xmark"></i></button>
                    </div>
                </div>
            </div>
         </c:forEach>
        </div>
    </div>
    <hr>
    <div class="basketFooter">
        <div>
            <h3>총 금액</h3>
            <h3><span id="total"><fmt:formatNumber value="${total}" pattern="#,###" /></span>원</h3>
        </div>
        <button id="submit">바로구매</button>
    </div>
  </div>
</div>

    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/mypage/basket.js"></script>
<%@ include file="../common/footer.jsp"%>