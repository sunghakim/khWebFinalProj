<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="widli=device-widli, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/resources/static/css/common.css">
    <link rel="stylesheet" href="/resources/static/css/admin-common.css">
    <link rel="stylesheet" href="/resources/static/css/report.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>kh final report management</title>
    <!-- 신고 관리 페이지 -->
</head>
<body>
	<div class="wrapper">
        <header>
                <div class="header-wrap">
                    <h2 class="logo">logo</h2>
                    <div class="ul-wrap">
                    <c:choose>
	                    <c:when test="${sessionScope.account.user_type eq 0 }">
	                    	<ul class="header-ul" id="admin-ul">
                            	<li id="change">관리자 로그아웃</li>
                        	</ul>
                        	</c:when>
                        	<c:when test="${sessionScope.account.user_type eq 1 }">
                        		<ul class="header-ul" id="logout-ul">
                        			<li id="logout">로그아웃</li>
                        		</ul>
                        	</c:when>
                        	<c:when test="${sessionScope.account.user_type eq 2 }">
                        		<ul class="header-ul" id="noMember-logout-ul">
                        			<li id="noMember-logout">로그아웃</li>
                        		</ul>
                        	</c:when>
                        	<c:otherwise>
	                        	<ul class="header-ul" id="user-ul">
	                            	<li id="cart">장바구니&nbsp;&nbsp;|&nbsp;&nbsp;</li>
	                            	<li id="join">회원가입&nbsp;&nbsp;|&nbsp;&nbsp;</li>
	                            	<li id="member-login">회원 로그인&nbsp;&nbsp;|&nbsp;&nbsp;</li>
	                            	<li id="non-member-login">비회원 로그인&nbsp;&nbsp;|&nbsp;&nbsp;</li>
	                            	<li id="admin-change">관리자 로그인</li>
	                        	</ul>
                        	</c:otherwise>
	                    </c:choose>
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
                        <li id="admin-nav-1" class="click-color">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>회원 관리</p>
                        </li>
                        <li id="admin-nav-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>신고 관리</p>
                        </li>
                        <li id="admin-nav-3">
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
                        <li id="sub-2">
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
                        <button class="btn all">전체보기</buttonype=>
                        <button class="btn before">신고 처리 전</button>
                        <button class="btn done">처리 완료</button>
                    </div>
                    <div class="article-wrap">
                        <ul class="title">
                            <li>신고 고유 ID</li>
							<li>신고자 ID</li>
							<li>신고당한 ID</li>
							<li>신고당한 게시글 ID</li>
							<li>신고한 날짜</li>
							<li>신고 내용</li>
							<li>처리 상황</li>
							<li>조치완료된 날짜</li>
							<li>신고 사유 ID</li>
							<li>신고 내용</li>
							<li>권한 제한 시작일</li>
							<li>권한 제한 종료일</li>
							<li>기능</li>
                        </ul>
                        <div class="line"></div>
			<c:forEach var="List" items="${List}">
					<ul class="list">
						<li>${List.getReportID()}</li>
						<li>${List.getReporterID()}</li>
						<li>${List.getReportedAccountID()}</li>
						<li>${List.getReportedPostID()}</li>
						<li>${List.getReportedDateStr()}</li>
						<li>${List.getContent()}</li>
						<li>${List.getResultStr()}</li>
						<li>${List.getClosedDateStr()}</li>
						<li>${List.getReportReasonID()}</li>
						<li>${List.getReportReasonContent()}</li>
						<li>${List.getStarliateStr()}</li>
						<li>${List.getEndDateStr()}</li>
						<c:if test="${List.getResult() eq 1}">
							<li><a href="${pageType}/Update?ReportID=${List.getReportID()}&&ReportedAccountID=${List.getReportedAccountID()}&&Result=2">활동 제한 처리</a></li>
							<li><a href="${pageType}/Update?ReportID=${List.getReportID()}&&Result=3">사유 불충분 기각</a></li>
						</c:if>
					</ul>
				</c:forEach>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <script src="/resources/static/js/common.js"></script>
    <script src="/resources/static/js/report.js"></script>
</body>
</html>