<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
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
                <div class="title">${datas.getTitle()}</div>
                <div class="titleRigth">
                    <div class="view">
                        <label>${datas.getGood_number()}<span id="view">1</span></label>
                    </div>
                    <div>
                        <label>${datas.getWriter_id()}</label>
                    </div>
                </div>
            </div>
            <div class="detailContent">
                <div class="img-box">
                    <img src="/resources/static/img/sample.png" alt="">
                </div>
                <div id="content" name="content" value="">
      				${datas.getContent()}
                </div>
            </div>
            <div class="buttons">
                <button id="mod" type="button" onclick="location.href='/post/update?post_id=' + ${datas.getPost_id()} 
                ">수정</button>
                <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">신고</button>
                <button id="list" type="button"onclick="location.href='/board/list?board_id=' + ${datas.getBoard_id()}+'&page_num=1'">목록</button>
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
	            <label class="report-label"><span class="point">${datas.getWriter_id()}</span> 님의</label>
	            <label class="report-label"><span class="point">${datas.getTitle()}</span> 게시물을</label>
	            
	            	
	            	<input type="hidden" name="post_id" value="${datas.getPost_id()}">
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
<script>
	var navNum = "${nav}";
	if(navNum) {
		$('.user-nav li').removeClass('click-color');
        $('#user-nav-' + navNum).addClass('click-color');
	}
</script>
<%@ include file="../common/footer.jsp"%>