<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/basket.css">
    <title>장바구니</title>
</head>
<body  class="basket">
<div>
    <div class="basketHeader">
        <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
        <label><h1>장바구니</h1></label>
    </div>
    <div class="form">
    <form id="go-payment">
        <div class="div-back">
        <c:forEach var="i" items="${itemList}" varStatus="status">
            <div class="product">
                <input type="checkbox" class="item" name="item_id" value="${i.getItem_id()}" checked>
                <div>
                    <div>
                        <img>
                        <div class="data">
                            <h5>${i.getName()}</h5>
                            <c:set var="itemOpt" value="${itemOptionList[status.index].getItem_size()}'/'${itemOptionList[status.index].getColor()}"/>
                            <label>${itemOpt}</label><br>
                            <c:set var="price" value="${itemOptionList[status.index].getAmount()} * ${i.getPrice()}" />
                            <label class="price"></label>
                        </div>
                    </div>
                    <div class="count">
                        <button type="button"><i class="fa-solid fa-plus"></i></button>
                        <h4>${itemOptionList[status.index].getAmount()}</h4>
                        <button type="button"><i class="fa-solid fa-minus"></i></button>
                        <button id="delete" type="button"><i id="xmark" class="fa-solid fa-xmark"></i></button>
                    </div>
                </div>
            </div>
         </c:forEach>
        </div>
    </form>
    </div>
    <hr>
    <div class="basketFooter">
        <div>
            <h3>총 금액</h3>
            <h3 id="total">0원</h3>
        </div>
        <button id="submit">바로구매</button>
    </div>
</div>

    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/mypage/basket.js"></script>
</body>
</html>