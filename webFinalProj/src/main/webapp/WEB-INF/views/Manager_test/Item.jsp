<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 관리</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
<<<<<<< HEAD
	<main>
		<div>
			<span>
				<a>Previous</a>
			</span>
			<c:forEach var="page" begin="1" end="${TotalPageCount}" step="1">
				<span>
					<a href="${pageType}?Page=${page}">${page}</a>
				</span>
			</c:forEach>
			<span>
				<a href="#">Next</a>
			</span>
=======
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
>>>>>>> refs/remotes/origin/최진휘
		</div>
		<a href="${pageType}/Insert">상품 추가</a>
		<table border="1" style="border_collapse: collapse;">
			<thead>
				<tr>
					<th>상품 이름</th>
					<th>가격</th>
					<th>상품 카테고리</th>
					<th>상품 사이즈</th>
					<th>상품 색깔</th>
					<th>재고량</th>
					<th colspan='3'>기능</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.getName()}</td>
						<td>${List.getPrice()}</td>
						<td>${List.getItemCategoryName()}</td>
						<td>${List.getItemSize()}</td>
						<td>${List.getColor()}</td>
						<td>${List.getAmount()}</td>
						<td><a href="${pageType}/Detail?ItemID=${List.getItemID()}&&ItemOptionID=${List.getItemOptionID()}&&ItemCategoryID=${List.getItemCategoryID()}">상세보기</a></td>
						<td><a href="${pageType}/Update?ItemID=${List.getItemID()}&&ItemOptionID=${List.getItemOptionID()}&&ItemCategoryID=${List.getItemCategoryID()}">수정</a></td>
						<td><a href="${pageType}/Delete?ItemID=${List.getItemID()}&&ItemOptionID=${List.getItemOptionID()}&&ItemCategoryID=${List.getItemCategoryID()}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>