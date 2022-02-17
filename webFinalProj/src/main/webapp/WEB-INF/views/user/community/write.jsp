<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/write.css">
    <title>후기 작성</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<%@ include file="../common/sidenav.jsp"%>
<div>
	<c:if test="${status eq 'add'}">
    	<form action="/post/add" method="post" enctype="multipart/form-data">
    </c:if>
    <c:if test="${status eq 'update'}">
    	<form action="/post/update" method="post" enctype="multipart/form-data">
    </c:if>
    <input type="hidden" name="post_id" value="${datas.getPost_id()}">
        <div class="writeHeader">
            <label class="title">제목</label>
            <input id="title" name="title" class="frm" type="text" placeholder="내용을 입력해주세요" value="${datas.getTitle()}" required>
        </div>
        <div class="writeBody">
            <textarea id="content" name="content" class="frm" placeholder="내용을 입력해주세요" required>${datas.getContent()}</textarea>
            <input type="file" name="fileUpload" >
        </div>
        <div class="writeFooter">
            <button class="common-btn" type="button">취소</button>
            <button class="point-btn" type="submit">작성완료</button>
        </div>
    </form>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<%@ include file="../common/footer.jsp"%>