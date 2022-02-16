<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/write.css">
    <title>후기 작성</title>
</head>
<body>
	<c:if test="${status eq 'add'}">
    	<form action="/post/add" method="post" enctype="multipart/form-data">
    </c:if>
    <c:if test="${status eq 'update'}">
    	<form action="/post/update" method="post" enctype="multipart/form-data">
    </c:if>
    <input type="hidden" name="post_id" value="${datas.getPost_id()}">
        <div class="writeHeader">
            <label class="title">제목</label>
            <input id="title" name="title" class="frm" type="text" placeholder="내용을 입력해주세요" value="${datas.getTitle()}" required>
        </div>
        <div class="writeBody">
            <textarea id="content" name="content" class="frm" placeholder="내용을 입력해주세요" required>${datas.getContent()}</textarea>
            <input type="file" name="fileUpload" >
        </div>
        <div class="writeFooter">
            <button class="common-btn" type="button">취소</button>
            <button class="point-btn" type="submit">작성완료</button>
        </div>
    </form>
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
</body>
</html>