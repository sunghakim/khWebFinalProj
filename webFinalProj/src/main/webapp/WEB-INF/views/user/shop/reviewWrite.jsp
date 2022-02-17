<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/reviewWrite.css">
    <title>후기 작성</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<%@ include file="../common/sidenav.jsp"%>
<div class="body">
<form>
    <div class="writeHeader">
        <label class="title">평가</label>
        <ul class="stars">
            <li class="star"><i class="fa-regular fa-star"></i></li>
            <li class="star"><i class="fa-regular fa-star"></i></li>
            <li class="star"><i class="fa-regular fa-star"></i></li>
            <li class="star"><i class="fa-regular fa-star"></i></li>
            <li class="star"><i class="fa-regular fa-star"></i></li>
        </ul>
        <input id="eval" type="text" value="0" required hidden/>
    </div>
    <div class="writeBody">
        <label class="title">후기</label>
        <label id="content-count"><span id="count">0</span>/150</label>
        <textarea id="content" class="frm" placeholder="내용을 입력해주세요" required/></textarea>
        <input type="file" />
    </div>
    <div class="writeFooter">
        <button class="common-btn" type="button">취소</button>
        <button class="point-btn" type="button">작성완료</button>
    </div>
</form>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/shop/reviewWrite.js"></script>
<%@ include file="../common/footer.jsp"%>