<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.web.model.Manage_ItemDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/Manager/Account"/>
<!DOCTYPE html>
<html>
<head>
	<title>상품 관리 페이지</title>
</head>
<body>
	<button type="button" onclick="${url}/Insert">상품 추가</button>
	<table>
		<tr>
			<th>ItemID</th>
			<th>Category_Name</th>
			<th>Item_Name</th>
			<th>Content</th>
			<th>Price</th>
			<th>Item_Size</th>
			<th>Color</th>
			<th>Amount</th>
			<th>UpdateItem</th>
			<th>DeleteItem</th>
		</tr>
		<c:forEach var="List" items="${List}">
			<tr>
				<th>${List.getItemID()}</th>
				<th>${List.getCategoryName()}</th>
				<th>${List.getName()}</th>
				<th>${List.getContent()}</th>
				<th>${List.getPrice()}</th>
				<th>${List.getItemSize()}</th>
				<th>${List.getColor()}</th>
				<th>${List.getAmount()}</th>
				<td><button type="button" onclick="location.href='${url}/Update?ItemID=${List.getItemID()}&&Page=${Page}'">상품수정</button></td>
				<td><button type="button" onclick="location.href='${url}/Delete?ItemID=${List.getItemID()}&&Page=${Page}'">상품삭제</button></td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach var="i" begin="1" end="${TotalPageCount}" step="1" varStatus="status">
		<td><a href="Item?Page=${status.current}">${status.current}</a></td>
	</c:forEach>
</body>
</html>