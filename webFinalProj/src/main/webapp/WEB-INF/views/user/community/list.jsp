<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
               <label class="title">인기글</label>
           </div>
           <div>
               <button type="button">글쓰기</button>
           </div>
       </div>
       <hr>
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
               <tr class="noti">
                   <td>공지</td>
                   <td colspan="3">제목</td>
               </tr>
               <tr class="post">
                   <td>번호</td>
                   <td>제목</td>
                   <td>작성자</td>
                   <td>좋아요</td>
               </tr>
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
                   <th>작성자</th>
                   <th>좋아요</th>
               </tr>
           </thead>
           <tbody>
               <tr class="post">
                   <td>번호</td>
                   <td>제목</td>
                   <td>작성자</td>
                   <td>좋아요</td>
               </tr>
           </tbody>
       </table>    
   </div>
   <div class="paging">
 </div>
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