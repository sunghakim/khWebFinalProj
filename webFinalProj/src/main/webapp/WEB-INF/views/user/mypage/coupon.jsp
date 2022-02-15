<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>
    
        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/coupon.css">
        <title>쿠폰</title>
    </head>
    <body  class="coupon-body">
    <div>
        <div class="couponHeader">
            <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
            <label><h1>쿠폰</h1></label>
        </div>
        <div class="couponBody">
        <% int index = 0; %>
        	<c:forEach var="coup" items="${couponList}">
            <div class="coupon">
                <img class="coupon-img" src="/resources/static/img/sample.png" alt="...">

                <div class="coupon-text">
                    <div class="coupon-name">
                        <label>${couponInfo.get(index).getName()}</label>
                    </div>
                    <div class="coupon-bottom">
                        <div class="coupon-date">
                            <label class="start-date">${couponInfo.get(index).getStart_date()}</label>
                            <label class="last-date">${couponInfo.get(index).getEnd_date()}</label>
                        </div>
                        <div class="coupon-sale">
                            <label>${couponInfo.get(index).getDiscount()} %</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="coupon" style="visibility: hidden"></div>
            <% index++; %>
            </c:forEach>
        </div>    
    </div>
    
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
</body>
</html>