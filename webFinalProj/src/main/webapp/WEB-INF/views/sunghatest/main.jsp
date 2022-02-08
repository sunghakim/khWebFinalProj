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
		<li><a href="/googlelogin">구글 로그인</a></li>
		<li><a href="/googlelogin2">구글 로그인2</a></li>
		<li><a href="/login">로그인</a></li>
		<li><a href="/logout">로그아웃</a></li>
		<li><a href="/drop">회원탈퇴</a></li>
		<li><a href="/findMyinfo">내정보 확인</a></li>
		//네이버 - 네이버 로그인 한 후 callback 이 안됨. https 에서 http 로 변경하는 작업 필요.
		//구글 - 로그인 작업 후 net::err_connection_refused 발생해서 id_token이 send 가 안됨. 로그인, 로그아웃 작업은 잘 됨.
		원탭 방법은 에러 발생함.
	</ul>
</body>
</html>