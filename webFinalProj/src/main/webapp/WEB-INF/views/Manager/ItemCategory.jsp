<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.web.model.Manage_ItemDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/Manager/Account"/>
<!DOCTYPE html>
<html>
<head>
	<title>상품 카테고리 관리 페이지</title>
</head>
<body>
	<table>
		<tr>
			<th>ItemCategoryID</th>
			<th>Name</th>
			<th>Nav_Show</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="List" items="${List}">
			<tr>
				<th>${List.getItemCategoryID()}</th>
				<th>${List.getName()}</th>
				<th>${List.getNavShowStr()}</th>
				<td><button type="button" onclick="location.href='${url}/Update?ID=${List.getItemCategoryID()}&&Page=${Page}'">상품 카테고리 수정</button></td>
				<td><button type="button" onclick="location.href='${url}/Delete?ID=${List.getItemCategoryID()}&&Page=${Page}'">상품 카테고리 삭제</button></td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach var="i" begin="1" end="${TotalPageCount}" step="1" varStatus="status">
		<td><a href="Item?Page=${status.current}">${status.current}</a></td>
	</c:forEach>
</body>
</html>