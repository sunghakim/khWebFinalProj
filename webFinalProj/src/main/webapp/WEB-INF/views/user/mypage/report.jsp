<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/report.css">
        <title>문의 및 신고</title>
    </head>
    <body  class="report-body">
        <div>
        <div class="reportHeader">
            <div>
                <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
                <label><h1>문의 및 신고</h1></label>
            </div>
            <div class="tab-buttons">
                <button id="question" class="tab-btn" type="button">문의</button>
                <button id="report" class="tab-btn here" type="button">신고</button>
            </div>
        </div>
        <div class="reportBody">
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>신고</th>
                            <th>사유</th>
                            <th>신고 날짜</th>
                            <th>신고 결과</th>
                            <th>조치 완료</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="report" items="${reportList}">
                        <tr class="report">
                            <td>${report.reported_post_id}</td>
                            <c:forEach var="reason" items="reportReason">
                            	<c:if test="${report.report_reason_id eq reason.report_reason_id}">
                            		<td>${reason.content}</td>
                            	</c:if>
                            </c:forEach>
                            <td>${report.reported_date}</td>
                            <c:choose>
	                            <c:when test="${report.result eq 1}">
	                            	<td>진행중</td>
	                           	</c:when>
	                           	<c:when test="${report.result eq 2}">
	                            	<td>활동제한</td>
	                           	</c:when>
	                           	<c:otherwise>
	                           		<td>사유불충분</td>
	                           	</c:otherwise>
                           	</c:choose>
                            <td>${report.closed_date}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>    
            </div>
        </div>
        </div>
    
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/mypage/question.js"></script>
</body>
</html>