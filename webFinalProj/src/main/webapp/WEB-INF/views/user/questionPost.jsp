<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="./common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/questionPost.css">
    <title>문의 결과?</title>
</head>
<body  class="questionPost-body">
<%@ include file="./common/topnav.jsp"%>
<div>
    <div class="div">
        <div class="questionPostHeader">
            <div>
                <label class="title">문의 title</label>
            </div>
            <div>
                <label class="date-label">답변완료되면 답변 완료된 날짜</label>
                <label class="state">답변중/답변완료</label>
            </div>
        </div>
        <div class="questionPostBody">
            <div class="question-box">
                배송문의 관련 질문~
            </div>
            <div class="answer-box">
                문의에 대한 답변~
            </div>
        </div>
        <div class="button-box">
            <button type="button">확인</button>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<%@ include file="./common/footer.jsp"%>