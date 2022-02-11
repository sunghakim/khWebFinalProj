<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠폰 추가 / 수정</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<main>
		<form action="${pageType}/Insert" method="post">
			<div>
				<label>쿠폰 이름</label>
				<input type="text" name="Name" required>
			</div>
			<div>
				<label>시작 일자</label>
				<input type="date" name="StartDate" required>
			</div>
			<div>
				<label>종료 일자</label>
				<input type="date" name="EndDate" required>
			</div>
			<div>
				<label>할인율(%)</label>
				<input type="number" name="Discount" placeholder="1~99 숫자 입력" required>
			</div>
			<div>
				<label>쿠폰 갯수</label>
				<input type="number" name="Amount" required>
			</div>
			<button type="submit">쿠폰 추가</button>
			<button type="button" onclick="location.href='${pageType}'">쿠폰관리 페이지로 돌아가기</button>
		</form>
	</main>
</body>
</html>