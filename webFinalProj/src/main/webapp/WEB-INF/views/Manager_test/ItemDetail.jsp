<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 상세보기</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<main>
		<div>
			<span>
				<button type="button" onclick="location.href='${pageType}/Insert'">상품 추가</button>
			</span>
			<span>
				<button type="button" onclick="location.href='${pageType}/Update?ItemID=${Item.getItemID()}&&ItemOptionID=${Item.getItemOptionID()}&&ItemCategoryID=${Item.getItemCategoryID()}'">상품 수정</button>
			</span>
		</div>
		<div>
			<div>
				<h6>상품 이름: ${Item.getName()}</h6>
			</div>
			<div>
				<h6>가격: ${Item.getPrice()}</h6>
			</div>
			<div>
				<h6>상품 카테고리: ${Item.getItemCategoryName()}</h6>
			</div>
			<div>
				<h6>상품 사이즈: ${Item.getItemSize()}</h6>
			</div>
			<div>
				<h6>상품 색깔: ${Item.getColor()}</h6>
			</div>
			<div>
				<h6>재고량: ${Item.getAmount()}</h6>
			</div>
			<div>
				<h6>상세 설명: ${Item.getContent()}</h6>
			</div>
		</div>
		<c:if test="${ImageList ne null}">
			<h6>첨부파일:<!-- IE, Edge, Safari, Opera 미지원... ㅜㅜ -->
				<c:forEach var="List" items="${ImageList}">
					<a href="${List.getDownloadPath()}" download="${List.getFileName()}">
						<img src="${List.getDownloadPath()}" style="width:100px; height:100px;">
						${List.getFileName()}
					</a>
				</c:forEach>
			</h6>
		</c:if>
	</main>
</body>
</html>