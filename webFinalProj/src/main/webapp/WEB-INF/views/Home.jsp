<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.web.mall.model.Manage_ImageDTO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h6>파일 업로드</h6>
	<form action="Upload.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="ReferencesID" value="0">
		<input type="hidden" name="IDType" value="ITEM">
	    <input type="file" name="uploadFile" multiple="multiple">
	    <button type="submit">업로드</button>
	</form>
	
	<h6>파일 다운로드</h6>
	<c:if test="${dto != null}">
		<!-- 다운로드 응답이 지연되는 원인 찾기 -->
		<a href="${dto.getFullPath()}" download>
			<img src="${dto.getFullPath()}">
		</a>
	</c:if>
</body>
</html>