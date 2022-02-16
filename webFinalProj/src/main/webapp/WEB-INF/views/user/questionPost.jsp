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

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/questionPost.css">
        <title>문의 상세</title>
    </head>
    <body  class="questionPost-body">
        <div class="div">
            <div class="questionPostHeader">
                <div>
                    <label class="title">${question.question_title}</label>
                </div>
                <div>
                    <label class="date-label">${question.answer_date}</label>
                    <c:choose>
                    	<c:when test="${question.result eq 0}">
                    		<label class="state">답변중</label>
                    	</c:when>
                    	<c:otherwise>
                    		<label class="state">답변완료</label>
                    	</c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="questionPostBody">
                <div class="question-box">
                    ${question.question_content}
                </div>
                <div class="answer-box">
                    ${question.answer_content}
                </div>
            </div>
            <div class="button-box">
                <button type="button" onclick="location.href='/mypage/checkQuestionList'">확인</button>
            </div>
        </div>
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
</body>
</html>>