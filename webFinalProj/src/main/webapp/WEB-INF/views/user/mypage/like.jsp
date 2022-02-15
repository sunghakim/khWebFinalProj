<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>
    
        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/like.css">
        <title>결제</title>
    </head>
    <body  class="like-body">
    <div>
        <div class="likeHeader">
            <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
            <label><h1>찜 목록</h1></label>
        </div>
        <% int index = 0; %>
    	<c:forEach var="zzim" items="${zzimList}">
        <div class="likeBody">
            <div class="like-item">
                <img class="like-img" src="/resources/static/img/sample.png" alt="...">
                <div class="like-btn"><i class="fa-solid fa-heart"></i></div>
                <div class="like-text">
                ${itemList.get(index).getName()}<br>${itemList.get(index).getPrice()}
                </div>
            </div>
        </div> 
        <% index++; %>
        </c:forEach>   
    </div>
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <!-- <script type="text/javascript" src="/resources/static/js/user/mypage/like.js"></script> -->
</body>
</html>