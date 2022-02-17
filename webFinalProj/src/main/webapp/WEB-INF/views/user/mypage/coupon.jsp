<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/coupon.css">
    <title>쿠폰</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<div class="coupon-body">
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
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
    $("a[href='#']:eq(0)").on("click", function() {
		history.back();
	});
});
</script>
<%@ include file="../common/footer.jsp"%>