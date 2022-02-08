<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src="${js_url}/Main.js"></script>
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
			<c:forEach var="pageCount" begin="1" end="${TotalPageCount%10}" items="${TotalPageCount}" varStatus="status">
				<span>
					<a href="/${pageType}?PageCount=${pageCount}">1</a>
				</span>
			</c:forEach>
			<span>
				<a href="#">Next</a>
			</span>
		</div>
		<table>
			<thead>
				<tr>
					<c:forEach var="PageCategories" items="${PageCategories}" varStatus="status">
						<th scope="col">${PageCategories.get(status.index)}</th>
					</c:forEach>
				</tr>
			</thead>
			<!-- 
				list에 hashmap을 저장하여 dto를 유연화한다.
			 -->
			<tbody>
				<tr>
					<c:forEach var="list" items="${list}">
						<c:forEach var="map" items="${list}" varStatus="status">
							<td>${map.get(status.count)}</td>
						</c:forEach>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</main>
</body>
</html>