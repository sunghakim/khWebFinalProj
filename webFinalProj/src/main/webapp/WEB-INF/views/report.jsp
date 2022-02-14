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
    <!-- �Ű� ���� ������ -->
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
                            	<li id="change">������ �α׾ƿ�</li>
                        	</ul>
                        	</c:when>
                        	<c:when test="${sessionScope.account.user_type eq 1 }">
                        		<ul class="header-ul" id="logout-ul">
                        			<li id="logout">�α׾ƿ�</li>
                        		</ul>
                        	</c:when>
                        	<c:when test="${sessionScope.account.user_type eq 2 }">
                        		<ul class="header-ul" id="noMember-logout-ul">
                        			<li id="noMember-logout">�α׾ƿ�</li>
                        		</ul>
                        	</c:when>
                        	<c:otherwise>
	                        	<ul class="header-ul" id="user-ul">
	                            	<li id="cart">��ٱ���&nbsp;&nbsp;|&nbsp;&nbsp;</li>
	                            	<li id="join">ȸ������&nbsp;&nbsp;|&nbsp;&nbsp;</li>
	                            	<li id="member-login">ȸ�� �α���&nbsp;&nbsp;|&nbsp;&nbsp;</li>
	                            	<li id="non-member-login">��ȸ�� �α���&nbsp;&nbsp;|&nbsp;&nbsp;</li>
	                            	<li id="admin-change">������ �α���</li>
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
                            <p>ȸ�� ����</p>
                        </li>
                        <li id="admin-nav-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>�Ű� ����</p>
                        </li>
                        <li id="admin-nav-3">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>����Ʈ ����</p>
                        </li>
                    </ul>
                    <ul class="admin-nav-sub">
                        <li id="sub-1">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>��ǰ ����</p>
                        </li>
                        <li id="sub-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>ī�װ��� ����</p>
                        </li>
                        <li id="sub-3">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>��� Ȯ��</p>
                        </li>
                        <li id="sub-4">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>���� ���</p>
                        </li>
                        <li id="sub-5">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>���� ����</p>
                        </li>
                        <li id="sub-6">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>ȯ�� ����</p>
                        </li>
                        <li id="sub-7">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>���� ����</p>
                        </li>
                    </ul>
                </div>
            </nav>
           	<section>
                <div class="article-container">
                    <div class="btns">
                        <button class="btn all">��ü����</buttonype=>
                        <button class="btn before">�Ű� ó�� ��</button>
                        <button class="btn done">ó�� �Ϸ�</button>
                    </div>
                    <div class="article-wrap">
                        <ul class="title">
                            <li>�Ű� ���� ID</li>
							<li>�Ű��� ID</li>
							<li>�Ű����� ID</li>
							<li>�Ű����� �Խñ� ID</li>
							<li>�Ű��� ��¥</li>
							<li>�Ű� ����</li>
							<li>ó�� ��Ȳ</li>
							<li>��ġ�Ϸ�� ��¥</li>
							<li>�Ű� ���� ID</li>
							<li>�Ű� ����</li>
							<li>���� ���� ������</li>
							<li>���� ���� ������</li>
							<li>���</li>
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
							<li><a href="${pageType}/Update?ReportID=${List.getReportID()}&&ReportedAccountID=${List.getReportedAccountID()}&&Result=2">Ȱ�� ���� ó��</a></li>
							<li><a href="${pageType}/Update?ReportID=${List.getReportID()}&&Result=3">���� ����� �Ⱒ</a></li>
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