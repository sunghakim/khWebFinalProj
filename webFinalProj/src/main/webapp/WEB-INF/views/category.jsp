<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="widli=device-widli, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/resources/static/css/common.css">
    <link rel="stylesheet" href="/resources/static/css/admin-common.css">
    <link rel="stylesheet" href="/resources/static/css/category.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>kh final category management</title>
    <!-- 카테고리 관리 -->
</head>
<body>
	<div class="wrapper">
        <header>
                <div class="header-wrap">
                    <h2 class="logo">logo</h2>
                    <div class="ul-wrap">
                    <ul class="header-ul" id="logout-ul">
                        	 <li id="logout">관리자 로그아웃</li>
                    </ul>
                    </div>
                </div>
            </header>
        <div class="content">
            <nav>
                <div class="nav-wrap">
                    <ul class="user-nav">
                        <li id="user-nav-1" class="click-color">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Shop</p>
                        </li>
                        <li id="user-nav-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Notice</p>
                        </li>
                        <li id="user-nav-3">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Outer</p>
                        </li>
                        <li id="user-nav-4">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Shirts</p>
                        </li>
                        <li id="user-nav-5">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Jeans</p>
                        </li>
                        <li id="user-nav-6">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Accessary</p>
                        </li>
                        <li id="user-nav-7">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Community</p>
                        </li>
                    </ul>
                    <ul class="admin-nav">
                        <li id="admin-nav-1">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>회원 관리</p>
                        </li>
                        <li id="admin-nav-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>신고 관리</p>
                        </li>
                        <li id="admin-nav-3" class="click-color">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>사이트 관리</p>
                        </li>
                    </ul>
                    <ul class="admin-nav-sub">
                        <li id="sub-1">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>상품 관리</p>
                        </li>
                        <li id="sub-2" class="click-font">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>카테고리 관리</p>
                        </li>
                        <li id="sub-3">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>통계 확인</p>
                        </li>
                        <li id="sub-4">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>쿠폰 목록</p>
                        </li>
                        <li id="sub-5">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>개인 문의</p>
                        </li>
                        <li id="sub-6">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>환불 관리</p>
                        </li>
                        <li id="sub-7">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>공지 관리</p>
                        </li>
                    </ul>
                </div>
            </nav>
            <section>
                <div class="article-container">
                    <div class="btns">
                    	<form action="${pageType}/Insert" method="post" accept-charset="UTF-8">
                    		<input type="text" class="btn input" placeholder="  등록할 카테고리 이름" name="ItemCategoryName">
                        	<button type="submit" class="btn regist">카테고리 등록</button>
                    	</form>
                        
                    </div>
                    <div class="article-wrap">
                        <ul class="title">
                            <li class="li-1">카테고리 이름</li>
                            <li class="li-2">기능</li>
                        </ul>
                        <div class="line"></div>
                        <c:forEach var="List" items="${List}">
	                        <ul class="list">
	                            <li class="li-1">${List.getItemCategoryName()}</li>
	                            <li class="li-2">
	                                <a href="${pageType}/Update?ItemCategoryID=${List.getItemCategoryID()}&NavShow=F" class="modify">&nbsp;수정&nbsp;</a>
	                                <a href="${pageType}/Delete?ItemCategoryID=${List.getItemCategoryID()}" class="delete">&nbsp;삭제&nbsp;</a>
	                            </li>
	                        </ul>
	                    </c:forEach>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <script src="/resources/static/js/common.js"></script>
    <script src="/resources/static/js/category.js"></script>
</body>
</html>