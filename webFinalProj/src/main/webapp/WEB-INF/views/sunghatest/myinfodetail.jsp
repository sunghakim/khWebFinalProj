<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my info detail</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.account.getSocial_account_id() eq 'false'}">
		${account.account_id} 님 로그인 되었습니다. 
		</c:when>
		<c:otherwise>
		${account.social_account_id} 님 로그인 되었습니다. 
		</c:otherwise>
	</c:choose>
	${error_msg}
	<hr>
	<c:choose>
		<c:when test="${sessionScope.account.getSocial_account_id() eq 'false'}">
		id : ${account.account_id} 
		password : ${account.password}
		</c:when>
		<c:otherwise>
		id : ${account.social_account_id} 
		</c:otherwise>
	</c:choose>
	name : ${account.name}
	phone : ${account.phone}
	email : ${account.email}
	address : ${account.address}
	nickname : ${account.nickname}
	joindate : ${account.joindate}
	<hr>
	정보수정
	<form action="/checkMyinfo" method="post">
		<c:choose>
			<c:when test="${sessionScope.account.getSocial_account_id() eq 'false'}">
				<div>
					<input type="hidden" name="account_id" value="${account.account_id}">
				</div>
				<div>
					password : <input type="password" name="password" value="${account.password}">
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<input type="hidden" name="account_id" value="${account.social_account_id}">
				</div>
			</c:otherwise>
		</c:choose>
		<div>
			phone : <input type="text" name="phone" value="${account.phone}">
		</div>
		<div>
			email : <input type="email" name="email" value="${account.email}">
		</div>
		<div>
			address : <input type="text" name="address" value="${account.address}">
		</div>
		<div>
			nickname : <input type="text" name="nickname" value="${account.nickname}">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>