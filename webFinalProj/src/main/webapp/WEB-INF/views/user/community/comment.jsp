<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/comment.css">
    <title>내정보</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<%@ include file="../common/sidenav.jsp"%>
<div>
    <div class="commentBody">
    	<form action="post/comments/add" method="post">
	        <div id="cmt-write" class="cmt-write">
	            <textarea name="content" id="" placeholder="내용을 입력해주세요"></textarea>
	            <button id="newSubmit" type="submit">등록</button>
	        </div>
        </form>
        <hr>
        
        <div class="comment">
        	<c:forEach var="datas" items="${datas}"> 
	            <label>${datas.getWriter_id()}</label>
	            <div class="cmt-box">
	                <div id="cmt">${datas.getContent()}</div>
	                <div class="default-btn">
	                    <button class="cmt-mod" class="button" type="button">수정</button>
	                    <button class="cmt-del" class="button" type="button">삭제</button>
	                </div>
	                <div class="mod-btn" style="display: none;">
	                    <button class="rtn" class="button" type="button">취소</button>
	                    <button class="udt" class="button" type="submit">확인</button>
	                </div>
	            </div>
            </c:forEach>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/community/detail.js"></script>
<%@ include file="../common/footer.jsp"%>