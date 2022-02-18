<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/list.css">
        <title>커뮤니티</title>
    </head>
    <body>
    <%@ include file="../common/topnav.jsp"%>
	<%@ include file="../common/sidenav.jsp"%>
	<div class="body">
		<div class="list common">
            <div>
                <div>
                	<c:if test="${list eq 'list'}">
                    	<label class="title">최신글</label>
                    </c:if>
                    
               		<c:if test="${good eq 'good'}">
                    	<label class="title">인기글</label>
                    </c:if>
                </div>
                <div>
                    <button type="button" onclick="location.href='/post/add'">글쓰기</button>
                </div>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>좋아요</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="datas" items="${datas}">
               		<tr class="post" onclick="location.href='/post?post_id='+ ${datas.getPost_id()}">
                   		<td>${datas.getPost_id()}</td>
                   		<td>${datas.getTitle()}</td>
                   		<td>${datas.getWriter_id()}</td>
                   		<td>${datas.getGood_number()}</td>
               		</tr>
               	</c:forEach>
           		</tbody>
           		</table>    
   			</div>
   			<div class="list notice" style="display:none;">
       		<div>
           		<div>
               		
                    	<label class="title">공지</label>
                    
           		</div>
       		</div>
       		<hr>
       		<table>
           		<thead>
               		<tr>
                   		<th>번호</th>
                   		<th>제목</th>
                   		<th>관리자</th>
                   		<th>좋아요</th>
               		</tr>
           		</thead>
                <tbody>
                	<c:forEach var="datas" items="${datas}">
	                    <tr class="post" onclick="location.href='/post?post_id='+ ${datas.getPost_id()}">
	                        <td>${datas.getPost_id()}</td>
	                        <td>${datas.getTitle()}</td>
	                        <td>${datas.getWriter_id()}</td>
	                        <td>${datas.getGood_number()}</td>
	                    </tr>
                    </c:forEach>
                </tbody>
            </table>    
        </div>
        <div class="paging">

        </div>
    </div>  
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script>
	var boardId = "${board_id}";
	
	if(boardId == 0){
		$('.click-color').removeClass('click-color');
        $('#user-nav-2').addClass('click-color');
        
        $('.list.notice').show();
        $('.list.common').hide();
	} else {
		$('.click-color').removeClass('click-color');
        $('#user-nav-7').addClass('click-color');
        
        $('.list.notice').hide();
        $('.list.common').show();
	}
</script>
<%@ include file="../common/footer.jsp"%>
