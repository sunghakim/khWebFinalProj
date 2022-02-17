<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="./common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/questionWrite.css">
    <title>문의 작성</title>
</head>
<body>
<%@ include file="./common/topnav.jsp"%>
<div class="questionWrite-body">
    <div class="div">
        <form id="questionWrite" action="/mypage/addQuestion" method="post" enctype="multipart/form-data">
            <div class="questionWrite">
                <div>
                    <label class="title-label">제목</label>
                    <input type="text" id="question-title" class="frm" name="question_title" placeholder="내용을 입력해주세요" required/>
                </div>
                <textarea id="question-content" class="frm" name="question_content" placeholder="내용을 입력해주세요" required></textarea>
            </div>
        <div class="button-box">
            <button id="question-write-cancel" type="button" class="common-btn">취소</button>
            <button id="question-write-submit" type="submit" class="point-btn">확인</button>
        </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/questionWrite.js"></script>
<%@ include file="./common/footer.jsp"%>