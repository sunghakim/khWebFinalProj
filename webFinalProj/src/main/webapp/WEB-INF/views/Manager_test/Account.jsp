<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${PageName}회원 관리</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<main>
		<div>
			<span>
				<a>Previous</a>
			</span>
			<c:forEach var="page" begin="1" end="${TotalPageCount}" step="1">
				<span>
					<a href="${pageType}?Page=${page}">${page}</a>
				</span>
			</c:forEach>
			<span>
				<a href="#">Next</a>
			</span>
		</div>
		<table border="1" style="border_collapse: collapse;">
			<thead>
				<tr>
					<th>ID</th>
					<th>권한</th>
					<th>이름</th>
					<th>휴대폰 번호</th>
					<th>이메일</th>
					<th>주소</th>
					<th>우편번호</th>
					<th>닉네임</th>
					<th>가입일</th>
					<th>기능</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.getAccountID()}</td>
						<td>${List.getUserTypeStr()}</td>
						<td>${List.getName()}</td>
						<td>${List.getPhone()}</td>
						<td>${List.getEmail()}</td>
						<td>${List.getAddress()}</td>
						<td>${List.getAddressNumber()}</td>
						<td>${List.getNickName()}</td>
						<td>${List.getJoinDateStr()}</td>
						<td><a href="${pageType}/Delete?ID=${List.getAccountID()}">탈퇴처리</a></td>
						<!-- 삭제전 정말 삭제할지 경고문 띄우기 -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>