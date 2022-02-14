<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<table border="1" style="border_collapse: collapse;">
		<thead>
			<tr>
				<th>상품 ID</th>
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
					<td>${List.getItemID()}</td>
					<td>${List.getName()}</td>
					<td>${List.getPrice()}</td>
					<td>${List.getItemCategoryName()}</td>
					<td>${List.getItemSize()}</td>
					<td>${List.getColor()}</td>
					<td>${List.getAmount()}</td>
					<td><a href="${pageType}/Detail?ItemID=${List.getItemID()}&&ItemOptionID=${List.getItemOptionID()}&&ItemCategoryID=${List.getItemCategoryID()}">상세보기</a></td>
					<td><a href="${pageType}/Update?ItemID=${List.getItemID()}&&ItemOptionID=${List.getItemOptionID()}&&ItemCategoryID=${List.getItemCategoryID()}">수정/추가입고</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>