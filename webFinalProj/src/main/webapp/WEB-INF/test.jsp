<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>메인 페이지</title>
</head>
<body>
	<main class="container">
		<c:if test="${sessionScope.AccountVO eq null}">
			<form>
				<div>
					<input type="text" name="ID" placeholder="아이디" required>
				</div>
				<div>
					<input type="password" name="Password" placeholder="비밀번호" autocomplete="new-password" required>
				</div>
				<button type="submit">로그인</button>
			</form>
		</c:if>
		<c:if test="${sessionScope.AccountVO ne null}">
    	<span>
			<button type="submit" onclick="location.href='/Board'">로그아웃</button>
		</span>
		<span>
			<button type="submit" onclick="location.href='/Board'">관리자 페이지</button>
		</span>
		</c:if>
	</main>
</body>
</html>
