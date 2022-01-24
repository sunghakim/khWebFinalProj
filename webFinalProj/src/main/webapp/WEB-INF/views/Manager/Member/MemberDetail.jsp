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
				<div class="mb-3">
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">아이디</li>
						<li class="list-group-item">${MemberDetail.getID()}</li>
					</ul>
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">닉네임</li>
						<li class="list-group-item">${MemberDetail.getNickname()}</li>
					</ul>
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">이메일</li>
						<li class="list-group-item">${MemberDetail.getEMail()}</li>
					</ul>
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">권한레벨</li>
						<li class="list-group-item">${MemberDetail.getUserLevel()}</li>
					</ul>
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">가입일</li>
						<li class="list-group-item">${MemberDetail.getJoinDateStr()}</li>
					</ul>
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">최근 방문일자</li>
						<li class="list-group-item">${MemberDetail.getLastestVisitDateStr()}</li>
					</ul>
				</div>
				<div class="mb-3">
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">작성한 게시글</li>
						<li class="list-group-item">${111}</li>
					</ul>
				</div>
				<div class="mb-3">
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item">작성한 댓글</li>
						<li class="list-group-item">${2222}</li>
					</ul>
				</div>
			</div>
		</div>
	</main>
</body>
</html>