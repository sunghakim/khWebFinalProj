<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="${js_url}/Main.js"></script>
	<title>통계 확인</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manage_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<%
	BoardDTO Board = new BoardDTO();
	%>
	<c:if test="{request.getAttribute(\"Board\") =! null">
		<%
		Board = (BoardDTO)request.getAttribute("Board");
		%>	
	</c:if>
	<main class="container">
		<div class="card">
			<div class="card-body">
				<ul class="list-group list-group-horizontal">
					<li class="list-group-item">${Board.getID()}</li>
					<li class="list-group-item">게시판 생성일: ${Board.getCreationDateStr()}</li>
					<li class="list-group-item">게시판 설명: ${Board.getDescription()}</li>
				</ul>
				<form action="#" method="post" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" class="form-control" placeholder="게시글 검색" aria-label="Search" style="width: 200px; display: inline;">
					<button class="btn btn-primary" type="submit" onclick="location.href='/#'" style="display: inline;">검색</button>
					<select class="form-select form-select-sm" aria-label="" size="1" style="width: 120px; display: inline;">
						<option value="Title">게시글 제목</option>
						<option value="Writer">작성자</option>
					</select>
					<button class="btn btn-primary" type="button" onclick="location.href='/Post/Posting'"style="display: inline;">게시글 작성</button>
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<div>
					<nav aria-label="...">
						<ul class="pagination">
							<li class="page-item disabled">
								<a class="page-link">Previous</a>
							</li>
							<li class="page-item active" aria-current="page">
								<a class="page-link" href="/Board?PageCount=1">1</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="/Board?PageCount=2">2</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="/Board?PageCount=3">3</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">Next</a>
							</li>
						</ul>
					</nav>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">게시글 번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
							<th scope="col">선호도</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Posts" items="${PostList}">
							<tr>
								<th scope="row"><c:out value="${Posts.getID()}"/></th>
								<td><a href="/Post/viewPost?PostID=${Posts.getID()}">${Posts.getTitle()}</a></td>
								<td>${Posts.getWriter()}</td>
								<td>${Posts.getPostingDateStr()}</td>
								<td>${Posts.getPostViews()}</td>
								<td>${Posts.getFavorite()}/${Posts.getDislike()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</main>
</body>
</html>