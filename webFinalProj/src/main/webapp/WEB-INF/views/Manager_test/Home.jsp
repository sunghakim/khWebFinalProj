<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<h6>다중파일 업로드</h6>
	<form action="multiUpload.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="ReferencesID" value="0">
		<input type="hidden" name="IDType" value="ITEM">
	    <input type="file" name="uploadFiles" multiple="multiple">
	    <button type="submit">업로드</button>
	</form>
	
	<c:if test="${List != null}">
		<h6>다중파일 다운로드</h6>
		<c:forEach var="dto" items="${List}">
		<a href="${dto.getDownloadPath()}" download="${dto.getFileName()}">
			<img src="${dto.getDownloadPath()}">
		</a>
		</c:forEach>
	</c:if>
</body>
</html>