<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/home.css">
    <title>커뮤니티</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<%@ include file="../common/sidenav.jsp"%>
<div class="body">
<div> 
   <div class="cmmu-hot">
       <div class="div-box">
           <div>
               <div>
                   <label class="title">인기글</label>
               </div>
               <div>
                   <button type="button">글쓰기</button>
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
                   <tr class="post">
                       <td>번호</td>
                       <td>제목</td>
                       <td>작성자</td>
                       <td>좋아요</td>
                   </tr>
               </tbody>
           </table>    
       </div>
   </div>
   <div class="cmmu-noti">
       <div class="div-box">
           <div>
               <div>
                   <label class="title">공지</label>
               </div>
           </div>
           <table>
               <tbody>
                   <tr class="post">
                       <td>이벤트나.. 뭐...</td>
                   </tr>
               </tbody>
           </table>    
       </div>
   </div>
   <div class="cmmu-last">
       <div class="div-box">
           <div>
               <div>
                   <label class="title">최신글</label>
               </div>
               <div>
                   <label id="more">더보기 <i class="fa-solid fa-angle-right"></i></label>
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
                   <tr class="post">
                       <td>번호</td>
                       <td>제목</td>
                       <td>작성자</td>
                       <td>좋아요</td>
                   </tr>
               </tbody>
           </table>    
       </div>
   </div>
</div>
</div>    
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<<script>
	var navNum = "${nav}";
	if(navNum) {
		$('.user-nav li').removeClass('click-color');
        $('#user-nav-' + navNum).addClass('click-color');
	}
</script>
<%@ include file="../common/footer.jsp"%>