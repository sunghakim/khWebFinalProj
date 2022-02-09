<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.web.mall.model.QuestionVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add question</title>
</head>
<body>
	${error_msg}
	<% if(((QuestionVO)request.getAttribute("questionVo")) != null) { %>
	<form action="/updateQuestion" method="post">
	<div>
			question_id : null <input type="hidden" name="question_id" value="${questionVo.question_id}">
		</div>
		<div>
			item_id : null <input type="hidden" name="item_id" value="${questionVo.item_id}">
		</div>
	<% } else { %>
	<form action="/addQuestion" method="post">
	<div>
			question_id : null <input type="hidden" name="question_id" value="0">
		</div>
		<div>
			item_id : null <input type="hidden" name="item_id" value="0">
		</div>
	<% } %>
		
		<div>
			writer_id : ${account.account_id} <input type="hidden" name="writer_id" value="${account.account_id}">
		</div>
		<% if(((QuestionVO)request.getAttribute("questionVo")) != null) { %>
			<div>
				question title : <input type="text" name="question_title" value="${questionVo.question_title}" readonly>
			</div>
		<% }
		else { %>
			<div>
				question title : <input type="text" name="question_title" value="">
			</div>
		<% } %>
		<div>
			question content : <input type="text" name="question_content" value="${questionVo.question_content}">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>