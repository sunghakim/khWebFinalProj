<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	${account.account_id} 님 로그인 되었습니다.
	${error_msg}
	<hr>
	<ul>
		<li><a href="/join">회원가입</a></li>
		<li><a href="/naverlogin">네이버 로그인</a></li>
		<li><a href="/login">로그인</a></li>
		<li><a href="/logout">로그아웃</a></li>
		<li><a href="/drop">회원탈퇴</a></li>
		<li><a href="/findMyinfo">내정보 확인</a></li>
	</ul>
</body>
</html>