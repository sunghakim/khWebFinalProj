<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h6>파일 업로드</h6>
	<form action="Upload.do" method="post" enctype="multipart/form-data">
	    <input type="file" name="uploadFile">
	    <button type="submit">업로드</button>
	</form>
	
</body>
</html>