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

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/question.css">
        <title>문의 및 신고</title>
    </head>
    <body  class="question-body">
        <div>
        <div class="questionHeader">
            <div>
                <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
                <label><h1>문의 및 신고</h1></label>
            </div>
            <div class="tab-buttons">
                <button id="question" class="tab-btn here" type="button">문의</button>
                <button id="report" class="tab-btn" type="button">신고</button>
            </div>
        </div>
        <div class="questionBody">
            <div class="div-one">
                <div>
                    <div>
                        <label class="sub-title">1:1 문의</label>
                    </div>
                    <div>
                        <button type="button">문의하기</button>
                    </div>
                </div>
                <hr>
                <table class="one-on-one">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>제목</th>
                            <th>상태</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="myQue" items="${myQuestionList}">
                        <tr class="post">
                            <td>${myQue.question_id}</td>
                            <td>${myQue.question_title}</td>
                            <c:choose>
                            <c:when test="${myQue.result eq 0}">
                            	<td>답변중</td>
                           	</c:when>
                           	<c:otherwise>
                           		<td>답변완료</td>
                           	</c:otherwise>
                           	</c:choose>
                            <td>${myQue.question_date}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>    
            </div>
            <div class="div-prod">
                <label class="sub-title">상품 문의 내역</label>
                <hr>
                <table class="product">
                    <thead>
                        <tr>
                            <th>상품명</th>
                            <th>제목</th>
                            <th>상태</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
                    <tbody>
                    <% int index = 0; %>
                    <c:forEach var="itemQue" items="${itemQuestionList}">
                        <tr class="post">
                            <td><label class="product-link">${itemList.get(index).getName()}</label></td>
                            <td>${itemQue.question_title}</td>
                            <c:choose>
                            <c:when test="${itemQue.result eq 0}">
                            	<td>답변중</td>
                           	</c:when>
                           	<c:otherwise>
                           		<td>답변완료</td>
                           	</c:otherwise>
                           	</c:choose>
                            <td>${itemQue.question_date}</td>
                        </tr>
                        <% index++; %>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        </div>
    
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/mypage/question.js"></script>
</body>
</html>