<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/post/add" method ="post" enctype="multipart/form-data">
		<div>
			<label>제목</label>
			<input type ="text" name="title"> 
		</div>
		<div>
			<label>내용</label>
			<textarea name="content"></textarea>
		</div>
		<div>
			<input type="file" name="fileUpload" value="파일첨부">
		</div>
		<div>
			<button type="submit">작성완료</button>
			<button type="button">취소</button>
		</div>
	</form>
	<a href="/resources/images/찜목록.PNG" download>이미지</a>
	<img src="/resources/images/찜목록.PNG">
	
</body>
</html>