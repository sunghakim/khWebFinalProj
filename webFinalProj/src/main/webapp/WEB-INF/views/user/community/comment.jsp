<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <div id="cmt-write" class="cmt-write">
            <textarea name="" id="" placeholder="내용을 입력해주세요"></textarea>
            <button id="newSubmit" type="button">등록</button>
        </div>
        <hr>
        <div class="comment">
            <label>닉네임(아이디)</label>
            <div class="cmt-box">
                <div id="cmt">내가 쓴 댓글</div>
                <div class="default-btn">
                    <button class="cmt-mod" class="button" type="button">수정</button>
                    <button class="cmt-del" class="button" type="button">삭제</button>
                </div>
                <div class="mod-btn" style="display: none;">
                    <button class="rtn" class="button" type="button">취소</button>
                    <button class="udt" class="button" type="button">확인</button>
                </div>
            </div>
        </div>
        <hr>
        <div class="comment">
            <label>닉네임(아이디)</label>
            <div class="cmt-box">
                <div id="cmt">누군가 쓴 댓글</div>
            </div>
        </div>
        <hr>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/community/detail.js"></script>
<%@ include file="../common/footer.jsp"%>