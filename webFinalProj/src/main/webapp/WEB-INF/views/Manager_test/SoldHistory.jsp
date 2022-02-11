<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>판매 내역</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
<<<<<<< HEAD
	<main>
		<div>
			<span>
				<a>Previous</a>
			</span>
			<c:forEach var="page" begin="1" end="${TotalPageCount}" step="1">
				<span>
					<a href="${pageType}?Page=${page}">${page}</a>
				</span>
			</c:forEach>
			<span>
				<a href="#">Next</a>
			</span>
=======
	<%
	BoardDTO Board = new BoardDTO();
	%>
	<c:if test="{request.getAttribute(\"Board\") =! null">
		<%
		Board = (BoardDTO)request.getAttribute("Board");
		%>	
	</c:if>
	<main class="container">
		<div class="card">
			<div class="card-body">
				<ul class="list-group list-group-horizontal">
					<li class="list-group-item">${Board.getID()}</li>
					<li class="list-group-item">게시판 생성일: ${Board.getCreationDateStr()}</li>
					<li class="list-group-item">게시판 설명: ${Board.getDescription()}</li>
				</ul>
				<form action="#" method="post" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" class="form-control" placeholder="게시글 검색" aria-label="Search" style="width: 200px; display: inline;">
					<button class="btn btn-primary" type="submit" onclick="location.href='/#'" style="display: inline;">검색</button>
					<select class="form-select form-select-sm" aria-label="" size="1" style="width: 120px; display: inline;">
						<option value="Title">게시글 제목</option>
						<option value="Writer">작성자</option>
					</select>
					<button class="btn btn-primary" type="button" onclick="location.href='/Post/Posting'"style="display: inline;">게시글 작성</button>
				</form>
			</div>
>>>>>>> refs/remotes/origin/최진휘
		</div>
		<table border="1" style="border_collapse: collapse;">
			<thead>
				<tr>
					<th>판매내역 ID</th>
					<th>구매자 ID</th>
					<th>배송지</th>
					<th>받은 사람 이름</th>
					<th>받은 사람 휴대폰 번호</th>
					<th>주문 일자</th>
					<th>배송 상태</th>
					<th>판매상세내역ID</th>
					<th>상품이름</th>
					<th>판매갯수</th>
					<th>사이즈</th>
					<th>컬러</th>
					<th>상품가격</th>
					<th>환불여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.getSoldHistoryID()}</td>
						<td>${List.getAccountID()}</td>
						<td>${List.getAddress()}</td>
						<td>${List.getRecieverName()}</td>
						<td>${List.getRecieverPhone()}</td>
						<td>${List.getOrderDateStr()}</td>
						<th>${List.getStatusStr()}</th>
						<td>${List.getSoldDetailID()}</td>
						<td>${List.getItemName()}</td>
						<td>${List.getAmount()}</td>
						<td>${List.getItemSize()}</td>
						<td>${List.getColor()}</td>
						<td>${List.getPrice()}</td>
						<td>${List.getRefundStatusStr()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>