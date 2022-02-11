<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠폰 관리</title>
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
		<a href="${pageType}/Insert">쿠폰 추가</a>
		<table border="1" style="border_collapse: collapse;">
			<thead>
				<tr>
					<th>쿠폰 이름</th>
					<th>시작 일자</th>
					<th>종료 일자</th>
					<th>할인율</th>
					<th>남은 쿠폰 갯수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.getName()}</td>
						<td>${List.getStartDateStr()}</td>
						<td>${List.getEndDateStr()}</td>
						<td>${List.getDiscount()}%</td>
						<td>${List.getAmount()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>