<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
       
        <title>주문 상세 조회</title>
    </head>
    <body  class="history-body">
        <div>
        <% int index = 0; %>
        	<c:forEach var="payed" items="${detailList}">
	        <div class="historyHeader">
	            <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
	            <label><h1>주문 상세 조회</h1></label>
	        </div>
	        <div class="historyBody">
	            <div class="modal-body">
					<div class="product-list">
						<div id="product" class="product">
							<div class="img-box">
								<%-- <img src="${imageList.get(index).get(0).getDownloadPath()}" alt=""> --%>
							</div>
							<div class="colum-obj">
								<div id="product-name">${itemList.get(index).getName()}</div>
								<div class="row-obj">
					    			<div class="colum-obj">
					    				<c:forEach var="op" items="${itemOptionList.get(index)}">
					    					<c:if test="${op.item_option_id eq payed.item_option_id}">
					        					<div id="option">${op.item_size}/${op.color}</div>
					        				</c:if>
					        			</c:forEach>
					        			<div id="num">${payed.amount}</div>
					    			</div>
					    			<div><button id="refund" type="button" onclick="location.href='/mypage/doRefund?sold_detail_id=' + ${payed.sold_detail_id}">환불신청</button></div>
								</div>
							</div>
					    </div>
					</div>
				</div>
			</div>
			<hr>
			<% index++; %>
			</c:forEach>
			<button type="button" id="delibery-state" class="btn btn-primary" onclick="location.href='/mypage/whereItem?sold_history_id=' + ${detailList.get(0).getSold_history_id()}">배송현황</button>
	    	<button type="button" id="history-return" class="btn btn-secondary" data-bs-dismiss="modal" onclick="location.href='/mypage/checkPayedList'">확인</button>
		</div>
</body>
</html>