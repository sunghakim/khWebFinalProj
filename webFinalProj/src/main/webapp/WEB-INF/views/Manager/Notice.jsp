<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.web.model.Manage_ItemDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url" value="/Manager/Account"/>
<!DOCTYPE html>
<html>
<head>
	<title>공지사항 관리 페이지</title>
</head>
<body>
	<button type="button" onclick="/Manager/Notice/Insert">공지사항 작성</button>
	<table>
		<tr>
			<th>PostID</th>
			<th>WriterID</th>
			<th>Title</th>
			<th>PostViews</th>
			<th>GoodNumber</th>
			<th>PostingDate</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="List" items="${List}">
			<tr>
				<th>${List.getPostID()}</th>
				<th>${List.getWriterID()}</th>
				<th>${List.getTitle()}</th>
				<th>${List.getPostViews()}</th>
				<th>${List.getGoodNumber()}</th>
				<th>${List.getPostingDateStr()}</th>
				<td><button type="button" onclick="location.href='${url}/Update?ID=${List.getPostID()}&&Page=${Page}'">수정</button></td>
				<td><button type="button" onclick="location.href='${url}/Delete?ID=${List.getPostID()}&&Page=${Page}'">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach var="i" begin="1" end="${TotalPageCount}" step="1" varStatus="status">
		<td><a href="Item?Page=${status.current}">${status.current}</a></td>
	</c:forEach>
</body>
</html>