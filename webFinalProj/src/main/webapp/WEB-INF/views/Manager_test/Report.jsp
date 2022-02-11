<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>신고 관리</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
<<<<<<< HEAD
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
=======
	<%
	BoardDTO Board = new BoardDTO();
	%>
	<c:if test="{request.getAttribute(\"Board\") =! null">
		<%
		Board = (BoardDTO)request.getAttribute("Board");
		%>	
	</c:if>
	<main class="container">
		<div class="card">
			<div class="card-body">
				<ul class="list-group list-group-horizontal">
					<li class="list-group-item">${Board.getID()}</li>
					<li class="list-group-item">게시판 생성일: ${Board.getCreationDateStr()}</li>
					<li class="list-group-item">게시판 설명: ${Board.getDescription()}</li>
				</ul>
				<form action="#" method="post" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" class="form-control" placeholder="게시글 검색" aria-label="Search" style="width: 200px; display: inline;">
					<button class="btn btn-primary" type="submit" onclick="location.href='/#'" style="display: inline;">검색</button>
					<select class="form-select form-select-sm" aria-label="" size="1" style="width: 120px; display: inline;">
						<option value="Title">게시글 제목</option>
						<option value="Writer">작성자</option>
					</select>
					<button class="btn btn-primary" type="button" onclick="location.href='/Post/Posting'"style="display: inline;">게시글 작성</button>
				</form>
			</div>
>>>>>>> refs/remotes/origin/최진휘
		</div>
		<table border="1" style="border_collapse: collapse;">
			<thead>
				<tr>
					<th>신고 고유 ID</th>
					<th>신고자 ID</th>
					<th>신고당한 ID</th>
					<th>신고당한 게시글 ID</th>
					<th>신고한 날짜</th>
					<th>신고 내용</th>
					<th>처리 상황</th>
					<th>조치완료된 날짜</th>
					<th>신고 사유 ID</th>
					<th>신고 내용</th>
					<th>권한 제한 시작일</th>
					<th>권한 제한 종료일</th>
					<th colspan='2'>기능</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.getReportID()}</td>
						<td>${List.getReporterID()}</td>
						<td>${List.getReportedAccountID()}</td>
						<td>${List.getReportedPostID()}</td>
						<td>${List.getReportedDateStr()}</td>
						<td>${List.getContent()}</td>
						<th>${List.getResultStr()}</th>
						<td>${List.getClosedDateStr()}</td>
						<td>${List.getReportReasonID()}</td>
						<td>${List.getReportReasonContent()}</td>
						<td>${List.getStartDateStr()}</td>
						<td>${List.getEndDateStr()}</td>
						<c:if test="${List.getResult() eq 1}">
							<td><a href="${pageType}/Update?ReportID=${List.getReportID()}&&ReportedAccountID=${List.getReportedAccountID()}&&Result=2">활동 제한 처리</a></td>
							<td><a href="${pageType}/Update?ReportID=${List.getReportID()}&&Result=3">사유 불충분 기각</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>