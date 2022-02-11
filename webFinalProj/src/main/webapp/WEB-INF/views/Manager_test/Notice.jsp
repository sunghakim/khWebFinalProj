<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지 관리</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
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

		</div>
		<a href="${pageType}/Insert">공지 작성</a>
		<table border="1" style="border_collapse: collapse;">
			<thead>
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>게시판</th>
					<th>공지 제목</th>
					<th>조회수</th>
					<th>좋아요</th>
					<th>작성 날짜</th>
					<th colspan='3'>기능</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.getPostID()}</td>
						<td>${List.getWriterID()}</td>
						<td>${List.getBoardID()}</td>
						<td>${List.getTitle()}</td>
						<td>${List.getPostViews()}</td>
						<td>${List.getGoodNumber()}</td>
						<td>${List.getPostingDateStr()}</td>
						<td><a href="${pageType}/Detail?PostID=${List.getPostID()}">상세보기</a></td>
						<td><a href="${pageType}/Update?PostID=${List.getPostID()}">수정</a></td>
						<td><a href="${pageType}/Delete?PostID=${List.getPostID()}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>