<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/review.css">
<title>후기</title>
</head>
<body>
<div class="review-body">
    <div class="reviewHeader">
        <div>
            <label class="title">구매 후기</label>
            <label class="header-text">총 <span class="point">${reviewCount}</span> 개의 리뷰가 있습니다.</label>
        </div>
        <div>
            <button id="write-btn" type="button" onclick="location.href='/itemDetail/reviewWrite?item_id=' + ${item_id}">후기 작성</button>
        </div>
    </div>
    <hr>
    <div class="reviewList">
	    <c:forEach var="review" items="${reviewList}" varStatus="status">
	        <div class="review">
	            <div class="text-box">
	                <div class="review-area">
	                    <div class="eval-date">
	                        <label class="eval">
	                        	<c:forEach var="star" begin="1" end="${review.getScore()}" step="1">
	                        		<i class="fa-solid fa-star"></i>
	                        	</c:forEach>
	                        	<c:forEach var="notStar" begin="${5-review.getScore()}" end="0" step="-1">
	                        		<i class="fa-light fa-star"></i>
	                        	</c:forEach>
	                       	</label>
	                        -
	                        <label class="date">${review.getPost_date()}</label>
	                        <label class="write-type">작성</label>
	                    </div>
	                    <div class="review-content">
	                        <p>${review.getContent()}</p>
	                    </div>
	                </div>
	                <c:if test="${sessionScope.account.getAccount_id() eq review.writer_id}">
		                <div id="mod-del" class="review-button">
		                    <button class="mod" type="button">수정</button>
		                    <button class="del" type="button">삭제</button>
		                </div>
		                <div id="rtn-udt" class="review-button" style="display: none;">
		                    <button class="rtn" type="button">취소</button>
		                    <button class="udt" type="button">확인</button>
		                </div>
	                </c:if>
	            </div>
	            <div class="img-box">
	                <img class="review-img" src="${reviewImageList[status.index].getFileURL()}" alt="" data-bs-toggle="modal" data-bs-target="#exampleModal">
	            </div>
	        </div>
	        <hr>
		</c:forEach>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div id="modal" class="modal-dialog modal-dialog-centered" data-bs-dismiss="modal">
        <div class="modal-content">
            <div id="modal-img" class="modal-body"></div>
            <div id="modal-content" class="modal-footer"></div>
        </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/shop/review.js"></script>
</body>
</html>