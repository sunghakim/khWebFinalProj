<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>문의 상세보기</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<main>
		<div>
			<div>
				<h6>문의 번호: ${Question.getQuestionID()}</h6>
			</div>
			<div>
				<h6>상품 번호: ${Question.getItemID()}</h6>
			</div>
			<div>
				<h6>문의자 ID: ${Question.getWriterID()}</h6>
			</div>
			<div>
				<h6>문의 제목: ${Question.getQuestionTitle()}</h6>
			</div>
			<div>
				<h6>문의 내용: ${Question.getQuestionContent()}</h6>
			</div>
			<div>
				<h6>문의 날짜: ${Question.getQuestionDateStr()}</h6>
			</div>
			<div>
				<h6>문의 진행 상태: ${Question.getResultStr()}</h6>
			</div>
		</div>
		<c:if test="${Question.getResult() eq 0}">
			<form action="${pageType}/Update" method="post">
				<input type="hidden" name="QuestionID" value="${Question.getQuestionID()}">
				<div>
					<label>답변 제목</label>
					<input type="text" name="AnswerTitle" required>
				</div>
				<div>
					<label>답변 내용</label>
					<textarea rows="10" name="AnswerContent" required></textarea>
				</div>
				<button type="submit">답변하기</button>
			</form>
		</c:if>
		<c:if test="${Question.getResult() eq 1}">
			<div>
				<div>
					<div>답변 제목: ${Question.getAnswerTitle()}</div>
				</div>
				<div>
					<div>답변 내용: ${Question.getAnswerContent()}</div>
				</div>
				<div>
					<div>답변 일자: ${Question.getAnswerDateStr()}</div>
				</div>
			</div>
		</c:if>
	</main>
</body>
</html>