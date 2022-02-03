<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.web.mall.myinfo.model.ReportVO" %>
<%@page import="com.web.mall.myinfo.model.ReportReasonVO" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>report list</title>
</head>
<body>
	<button type="button" onclick="location.href='/checkQuestionList'">문의 목록 확인</button>
	<hr>
	<% 
	List<ReportVO> reportlist = (List<ReportVO>)request.getAttribute("reportList");
	List<ReportReasonVO> reportreason = (List<ReportReasonVO>)request.getAttribute("reportReason");
	for(ReportVO report : reportlist) { %>
		<div>
			report_id : <%= report.getReport_id() %>
		</div>
		<div>
			report_reason_id : <%= report.getReport_reason_id() %>
			<% for(ReportReasonVO reason : reportreason) {
				if(reason.getReport_reason_id() == report.getReport_reason_id()) { %>
					report_reason : <%= reason.getContent() %>
				<% }
				
			} %>
		</div>
		<div>
			reporter_id : <%= report.getReporter_id() %>
		</div>
		<div>
			reported_account_id : <%= report.getReported_account_id() %>
		</div>
		<div>
			reported_post_id : <%= report.getReported_post_id() %>
		</div>
		<div>
			reported_date : <%= report.getReported_date() %>
		</div>
		<div>
			content : <%= report.getContent() %>
		</div>
		<div>
			result : <%= report.getResult() %>
		</div>
		<div>
			closed_date : <%= report.getClosed_date() %>
		</div>
		<hr>
		<% } %>
</body>
</html>