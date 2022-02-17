<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="./common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/questionPost.css">
    <title>문의 상세</title>
</head>
<body  class="questionPost-body">
<%@ include file="./common/topnav.jsp"%>
<div>
    <div class="div">
        <div class="questionPostHeader">
            <div>
                <label class="title">${question.question_title}</label>
            </div>
            <div>
                <label class="date-label">${question.answer_date}</label>
                    <c:choose>
                    	<c:when test="${question.result eq 0}">
                    		<label class="state">답변중</label>
                    	</c:when>
                    	<c:otherwise>
                    		<label class="state">답변완료</label>
                    	</c:otherwise>
                    </c:choose>
            </div>
        </div>
        <div class="questionPostBody">
            <div class="question-box">
                ${question.question_content}
            </div>
            <div class="answer-box">
                ${question.answer_content}
            </div>
        </div>
        <div class="button-box">
            <button type="button" onclick="location.href='/mypage/checkQuestionList'">확인</button>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<%@ include file="./common/footer.jsp"%>