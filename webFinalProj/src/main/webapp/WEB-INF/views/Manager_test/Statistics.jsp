<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		/* Horizontal Bar Graph */
		.hGraph ul{ margin:0 50px 0 50px; padding:1px 0 0 0; border:1px solid #ddd; border-top:0; border-right:0; font-size:11px; font-family:Tahoma, Geneva, sans-serif;}
		.hGraph li{ position:relative; margin:10px 0; white-space:nowrap; vertical-align:top; list-style:none;}
		.hGraph .gTerm{ position:absolute; width:40px; top:0; left:-50px; line-height:20px; text-align:right; color:#767676; font-weight:bold;}
		.hGraph .gBar{ position:relative; display:inline-block; height:20px; border:1px solid #ccc; border-left:0; background:#e9e9e9;}
		.hGraph .gBar span{ position:absolute; width:40px; line-height:20px; top:0; right:-50px; color:#767676;}
	</style>
	<meta charset="UTF-8">
	<title>통계</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<main>
		<div>전체 상품 판매갯수 통계 (임시)</div>
		<ul class="hGraph">
			<c:forEach var="List" items="${Statistics}">
				<li><span class="hGraph gTerm">${List.getItemName()}</span><span class="gBar" style="width:${List.getAmount()/TotalCount*100}%"><span>${List.getAmount()}</span></span></li>
			</c:forEach>
		</ul>
	</main>
</body>
</html>