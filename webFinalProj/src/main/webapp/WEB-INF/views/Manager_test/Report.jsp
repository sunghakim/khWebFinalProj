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