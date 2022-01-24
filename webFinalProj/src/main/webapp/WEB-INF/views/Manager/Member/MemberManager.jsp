<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="js_url" value="/static/js"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="/WEB-INF/views/module/index.jsp" flush="false"/>
	<title>커뮤니티 관리 페이지</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/module/top-navigation.jsp" flush="false"/>
	</header>
	<nav>
		<jsp:include page="/WEB-INF/views/module/Manager-navigation.jsp" flush="false">
			<jsp:param name="active" value="Member"/>
		</jsp:include>
	</nav>
	<main class="container">
		<div class="card">
			<div class="card-body">
				<form action="#" method="post">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">닉네임</th>
								<th scope="col">이메일</th>
								<th scope="col">권한레벨</th>
								<th scope="col">가입일</th>
								<th scope="col">최근방문일</th>
								<th scope="col">작성한 게시글 수</th>
								<th scope="col">작성한 댓글 수</th>
								<th scope="col">작성한 게시글 인기율</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="Accounts" items="${AccountList}">
								<tr>
									<td><a href="/Manager/Member/MemberDetail?AccountID=<c:out value="${Accounts.getID()}"/>"><c:out value="${Accounts.getID()}"/></a></td>
									<td><c:out value="${Accounts.getNickname()}"/></td>
									<td><c:out value="${Accounts.getEMail()}"/></td>
									<td><c:out value="${Accounts.getUserLevel()}"/></td>
									<td><c:out value="${Accounts.getJoinDateStr()}"/></td>
									<td><c:out value="${Accounts.getLastestVisitDateStr()}"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</main>
</body>
</html>