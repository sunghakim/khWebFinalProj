<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my info detail</title>
</head>
<body>
	${account.account_id} 님 로그인 되었습니다.
	${error_msg}
	<hr>
	id : ${account.account_id}
	password : ${account.password}
	user_type : ${account.user_type}
	name : ${account.name}
	phone : ${account.phone}
	email : ${account.email}
	address : ${account.address}
	nickname : ${account.nickname}
	joindate : ${account.joindate}
	<hr>
	정보수정
	<form action="/checkMyinfo" method="post">
		<div>
			<input type="hidden" name="account_id" value="${account.account_id}">
		</div>
		<div>
			password : <input type="password" name="password" value="${account.password}">
		</div>
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