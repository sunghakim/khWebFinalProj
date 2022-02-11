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