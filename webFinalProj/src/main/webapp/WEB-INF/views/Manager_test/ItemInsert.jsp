<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 추가 / 수정</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<main>
		<c:if test="${status eq 'insert'}">
			<form action="${pageType}/Insert" method="post" enctype="multipart/form-data">
		</c:if>
		<c:if test="${status eq 'update'}">
			<form action="${pageType}/Update" method="post" enctype="multipart/form-data">
		</c:if>
			<input type="hidden" name="ItemID" value="${Item.getItemID()}" required>
			<div>
				<label>상품 이름</label>
				<input type="text" name="Name" value="${Item.getName()}" required>
			</div>
			<div>
				<label>가격</label>
				<input type="number" name="Price" value="${Item.getPrice()}" required>
			</div>
			<input type="hidden" name="ItemOptionID" value="${Item.getItemOptionID()}" required>
			<div>
				<label>사이즈</label>
				<input type="text" name="ItemSize" value="${Item.getItemSize()}" required>
			</div>
			<div>
				<label>색깔</label>
				<input type="text" name="Color" value="${Item.getColor()}" required>
			</div>
			<div>
				<label>수량(재고량)</label>
				<input type="number" name="Amount" value="${Item.getAmount()}" required>
			</div>
			<input type="hidden" name="ItemCategoryID" value="${Item.getItemCategoryID()}">
			<div>
				<label>카테고리</label>
				<select id="CategoryList" name="ItemCategoryID" required>
					<c:forEach var="List" items="${ItemCategoryList}">
						<c:if test="${List.getItemCategoryName() eq Item.getItemCategoryName()}">
							<option value="${List.getItemCategoryID()}" selected>${List.getItemCategoryName()}</option>
						</c:if>
						<c:if test="${List.getItemCategoryName() ne Item.getItemCategoryName()}">
							<option value="${List.getItemCategoryID()}">${List.getItemCategoryName()}</option>
						</c:if>
					</c:forEach>
				</select>
				<!--<input type="text" name="ItemCategoryName" value="${Item.getItemCategoryName()}" placeholder="카테고리" required>-->
			</div>
			<div>
				<label>상세 설명</label>
				<textarea rows="10" name="Content" required>${Item.getContent()}</textarea>
			</div>
			<div>
				<label>첨부파일</label>
				<input type="file" name="UploadFile">
			</div>
			<button type="submit">저장</button>
			<button type="button" onclick="location.href='${pageType}'">상품관리 페이지로 돌아가기</button>
		</form>
	</main>
</body>
</html>