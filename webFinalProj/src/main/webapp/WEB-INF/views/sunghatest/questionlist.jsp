<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.web.mall.myinfo.model.QuestionVO" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>question list</title>
</head>
<body>
	<button type="button" onclick="location.href='/checkReport'">신고 상태 확인</button>
	<hr>
	<button type="button" onclick="location.href='/addQuestion'">문의하기</button>
	<hr>
	${error_msg}
	<% 
	List<QuestionVO> questionlist = (List<QuestionVO>)request.getAttribute("questionList");
	for(QuestionVO que : questionlist) { %>
		<div>
			question_id : <%= que.getQuestion_id() %>
		</div>
		<div>
			item_id : <%= que.getItem_id() %>
		</div>
		<div>
			writer_id : <%= que.getWriter_id() %>
		</div>
		<div>
			question_title : <%= que.getQuestion_title() %>
		</div>
		<div>
			question_content : <%= que.getQuestion_content() %>
		</div>
		<div>
			question_date : <%= que.getQuestion_date() %>
		</div>
		<div>
			result : <%= que.getResult() %>
		</div>
		<div>
			Answer_title : <%= que.getAnswer_title() %>
		</div>
		<div>
			anseer_content : <%= que.getAnswer_content() %>
		</div>
		<div>
			answer_date : <%= que.getAnswer_date() %>
		</div>
		<button type="button" onclick="location.href='/updateQuestion?question_id=' + <%= que.getQuestion_id() %>">수정</button>
		<button type="button" onclick="location.href='/deleteQuestion?question_id=' + <%= que.getQuestion_id() %>">삭제</button>
		<hr>
		<% } %>
</body>
</html>