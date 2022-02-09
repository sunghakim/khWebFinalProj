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
		<li><a href="/googlelogin2">구글 로그인2</a></li>
		<li><a href="/kakaologin">카카오 로그인</a></li>
		<li><a href="/login">로그인</a></li>
		<li><a href="/logout">로그아웃</a></li>
		<li><a href="/drop">회원탈퇴</a></li>
		<li><a href="/findMyinfo">내정보 확인</a></li>
		//네이버 - 네이버 로그인 한 후 http://localhost/callback?code=oVLADyjX2r0I9M7hNj&state=777640506381595077152993687370738700917으로 이동하려하지만 
		사이트에 연결할 수 없음. 에러 발생. ERR_CONNECTION_REFUSED
		https 에서 http 로 변경하는 작업 필요.
	</ul>
</body>
</html>