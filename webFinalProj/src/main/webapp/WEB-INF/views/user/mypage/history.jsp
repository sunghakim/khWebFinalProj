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

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/history.css">
        <title>주문 조회</title>
    </head>
    <body  class="history-body">
        <div>
        <div class="historyHeader">
            <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
            <label><h1>주문 조회</h1></label>
        </div>
        <div class="historyBody">
            <table class="history">
                <thead>
                    <tr>
                        <th>주문번호</th>
                        <th>제목</th>
                        <th>주문날짜</th>
                        <th colspan="2">상태</th>
                    </tr>
                </thead>
                <tbody>
                <% int index = 0; %>
                <c:forEach var="sold" items="${soldList}">
                    <tr id="modal" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                        <td>${sold.sold_history_id}</td>
                        <td>${detailList.get(index).getItem_id()} 외 ${detailNumber.get(index)} 개</td>
                        <td>${sold.order_date}</td>
                        <c:choose>
                            <c:when test="${sold.status eq 0}">
                            	<td>배송준비중</td>
                           	</c:when>
                           	<c:when test="${sold.status eq 1}">
                            	<td>배송중</td>
                           	</c:when>
                           	<c:otherwise>
                           		<td>배송완료</td>
                           	</c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${detailList.get(index).getIs_refund() eq 0}">
                            	<td>환불신청안함</td>
                           	</c:when>
                           	<c:otherwise>
                           		<td>환불신청함</td>
                           	</c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
    
        <div>
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-body">
                        <div class="product-list">
                            <div id="product" class="product">
                                <div class="img-box">
                                    <img src="/resources/static/img/sample.png" alt="">
                                </div>
                                <div class="colum-obj">
                                    <div id="product-name">상품명</div>
                                    <div class="row-obj">
                                        <div class="colum-obj">
                                            <div id="option">사이즈/색상</div>
                                            <div id="num">수량</div>
                                        </div>
                                        <div><button id="refund" type="button">환불신청</button></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="modal-footer" class="modal-footer">
                        <button type="button" id="delibery-state" class="btn btn-primary">배송현황</button>
                        <button type="button" id="history-return" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
                    </div>
                  </div>
                </div>
              </div>
        </div>
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/mypage/history.js"></script>
</body>
</html>