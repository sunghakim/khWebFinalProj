<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/detail.css">
<title>내정보</title>
</head>
<body>
<div>
	<input id="item_id" value="${itemData.getItem_id()}" hidden/>
    <div class="detail">

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
                <div></div>
                <hr>
            </div>
        </div>

        <div id="container"></div>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/shop/detail.js"></script>
</body>
</html>