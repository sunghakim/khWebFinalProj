<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/detail.css">
    <title>내정보</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<%@ include file="../common/sidenav.jsp"%>
<div class="body">
	<form action="/post" method="get">
    <div class="detailBody">
        <div id="detail" class="detail">
            <div class="detailHeader">
                <div class="title">첫 게시글</div>
                <div class="titleRigth">
                    <div class="view">
                        <label>조회수 <span id="view">1</span></label>
                    </div>
                    <div>
                        <label>작성자</label>
                        <label class="writer">닉네임</label>
                    </div>
                </div>
            </div>
            <div class="detailContent">
                <div class="img-box">
                    <img src="/resources/static/img/sample.png" alt="">
                </div>
                <div id="content" name="content" value="${datas.getContent()}">
                    ffafdafdafdsfas<br>
                    ffafdafdafdsfasfaf<br>
                    affaf<br>
                </div>
            </div>
            <div class="buttons">
                <button id="mod" type="button">수정</button>
                <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">신고</button>
                <button id="list" type="button">목록</button>
            </div>
        </div>
    
        <div class="comments">
            <label>댓글 (n)</label>
            <label id="cmt-unfold">댓글 펼치기</label>
        </div>
        <hr>
        <div id="comments"></div>
    </div>
	</form>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div id="modal" class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <label class="modal-title">신고하기</label>
            <form action="/post/report" method="post" >
	            <div class="modal-report">
	                <label class="report-label"><span class="point">신고 이유</span>는 무엇인가요?</label>
	                <select name="report_reason_id" id="report-why">
	                    <option value="1" selected>부적절한 게시글</option>
	                    <option value="2">욕설</option>
	                </select>
	            </div>
	            <label class="report-label"><span class="point">닉네임</span> 님의</label>
	            <label class="report-label"><span class="point">제목</span> 게시물을</label>
	            
	            	
	            	<input type="hidden" name="post_id" value="1">
		            <div class="buttons">
		                <button type="submit">신고합니다</button>
		                <button type="button">좀 더 고민해볼게요</button>
		            </div>
            </form>
        </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/community/detail.js"></script>
<%@ include file="../common/footer.jsp"%>