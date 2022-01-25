<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.web.model.Manage_AccountDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>테스트 페이지</title>
</head>
<body>
	<table>
		<tr>
			<th>AccountID</th>
			<th>UserType</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Address</th>
			<th>NickName</th>
			<th>JoinDate</th>
		</tr>
		<c:url var="delete_url" value="/Manager/Account/Delete"/>
		<c:forEach var="List" items="${List}">
			<tr>
				<th scope="row"><c:out value="${List.getAccountID()}"/></th>
				<td>${List.getUserTypeStr()}</td>
				<td>${List.getName()}</td>
				<td>${List.getPhone()}</td>
				<td>${List.getEmail()}</td>
				<td>${List.getAddress()}</td>
				<td>${List.getNickName()}</td>
				<td>${List.getJoinDateStr()}</td>
				<td><button type="button" onclick="location.href='${delete_url}?ID=${List.getAccountID()}&&Page=${Page}'">탈퇴처리</button></td>
			</tr>
		</c:forEach>
	</table>
	<c:forEach var="i" begin="1" end="${TotalPageCount}" step="1" varStatus="status">
		<td><a href="Account?Page=${status.current}">${status.current}</a></td>
	</c:forEach>
</body>
</html>