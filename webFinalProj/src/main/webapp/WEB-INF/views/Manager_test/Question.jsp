<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문의 관리</title>
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
		<table border="1" style="border_collapse: collapse;">
			<thead>
				<tr>
					<th>문의 번호</th>
					<th>상품 번호</th>
					<th>문의자 ID</th>
					<th>문의 제목</th>
					<th>문의 날짜</th>
					<th>문의 진행 상태</th>
					<th colspan='2'>기능</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.getQuestionID()}</td>
						<td>${List.getItemID()}</td>
						<td>${List.getWriterID()}</td>
						<td>${List.getQuestionTitle()}</td>
						<td>${List.getQuestionDateStr()}</td>
						<td>${List.getResultStr()}</td>
						<td><a href="${pageType}/Detail?QuestionID=${List.getQuestionID()}">상세보기</a></td>
						<td><a href="${pageType}/Update?QuestionID=${List.getQuestionID()}">답변하기</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>