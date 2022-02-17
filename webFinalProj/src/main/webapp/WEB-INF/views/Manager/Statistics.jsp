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
    <link rel="stylesheet" href="/resources/static/css/statistics.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <title>kh final statistics management</title>
    <!-- 상품 통계 페이지 -->
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
                        <li id="sub-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>카테고리 관리</p>
                        </li>
                        <li id="sub-3" class="click-font">
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
                        <button type="submit" class="btn list">구매 목록</button>
                    </div>
                    <div class="article-wrap">
                        <div class="article-group">
                            <article class="left-chart">
                                <div class="chart-box">
                                    <canvas id="product-chart" width="100px"></canvas>
                                </div>
                                <div class="chart-title">상품 통계 그래프</div>
                            </article>
                            <article class="right-chart">
                                <div class="chart-box">
                                    <canvas id="income-chart" width="100px"></canvas>
                                </div>
                                <div class="chart-title">수입 그래프</div>
                            </article>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <script src="/resources/static/js/common.js"></script>
    <script src="/resources/static/js/statistics.js"></script>
    
    <!-- 물어보고 작업 -->

</body>
</html>

