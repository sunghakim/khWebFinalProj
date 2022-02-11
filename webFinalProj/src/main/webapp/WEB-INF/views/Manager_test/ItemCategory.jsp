<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>카테고리 관리</title>
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
		<form action="${pageType}/Insert" method="post">
			<input type="text" name="ItemCategoryName" placeholder="입력..." required>
			<button type="submit">카테고리 추가</button>
		</form>
		<table border="1" style="border_collapse: collapse;">
			<thead>
				<tr>
					<th>카테고리 이름</th>
					<th>표시여부</th>
					<th colspan='3'>기능</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.getItemCategoryName()}</td>
						<td>${List.getNavShowStr()}</td>
						<c:if test="${List.getNavShow() eq 'F'.charAt(0)}">
							<td><a href="${pageType}/Update?ItemCategoryID=${List.getItemCategoryID()}&&NavShow=T">보이기</a></td>
						</c:if>
						<c:if test="${List.getNavShow() eq 'T'.charAt(0)}">
							<td><a href="${pageType}/Update?ItemCategoryID=${List.getItemCategoryID()}&&NavShow=F">숨기기</a></td>
						</c:if>
						<!--<td><a href="${pageType}/Update?ItemCategoryID=${List.getItemCategoryID()}&&ItemCategoryName=입력한 이름">이름수정</a></td>-->
						<td><a href="${pageType}/Delete?ItemCategoryID=${List.getItemCategoryID()}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>