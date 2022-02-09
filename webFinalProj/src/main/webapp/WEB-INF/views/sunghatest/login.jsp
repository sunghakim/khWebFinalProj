<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	${error_msg}

	<form action="/login" method="post">
		<div>
			id : <input type="text" name="account_id" value="${accountVO.account_id}">
		</div>
		<div>
			password : <input type="password" name="password">
		</div>
		<div>
			user_type : <input type="hidden" name="user_type" value="1">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>