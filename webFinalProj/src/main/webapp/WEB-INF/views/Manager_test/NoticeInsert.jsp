<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지 추가 / 수정</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<main>
		<c:if test="${status eq 'insert'}">
			<form action="${pageType}/Insert" method="post" enctype="multipart/form-data">
		</c:if>
		<c:if test="${status eq 'update'}">
			<form action="${pageType}/Update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="PostID" value="${Notice.getPostID()}" required>
		</c:if>
			<div>
				<label>공지 제목</label>
				<input type="text" name="Title" value="${Notice.getTitle()}" required>
			</div>
			<div>
				<label>내용</label>
				<textarea rows="10" name="Content" required>${Notice.getContent()}</textarea>
			</div>
			<c:if test="${status eq 'update'}">
				<input type="hidden" name="ReferencesID" value="${Notice.getPostID()}">
			</c:if>
			<input type="hidden" name="IDType" value="NOTICE">
		    <input type="file" accept=".bmp, .gif, .jpg, .jpeg, .png" name="uploadImages" multiple="multiple">
		    <c:if test="${ImageList ne null}">
				<div>
					<label>첨부파일 목록(체크후 저장시 삭제)</label>
					<c:forEach var="List" items="${ImageList}">
						 <div><input type='checkbox' name='deleteImages' value='${List.getImageID()}'/>${List.getFileName()}</div>
					</c:forEach>
				</div>
			</c:if>
			<button type="submit">저장</button>
			<button type="button" onclick="location.href='${pageType}'">공지관리 페이지로 돌아가기</button>
		</form>
	</main>
</body>
</html>