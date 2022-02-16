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
    <link rel="stylesheet" href="/resources/static/css/contact-detail.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>kh final contact-detail management</title>
    <!-- ���� �� ������  -->
</head>
<body>
	<div class="wrapper">
        <header>
                <div class="header-wrap">
                    <h2 class="logo">logo</h2>
                    <div class="ul-wrap">
                    <ul class="header-ul" id="logout-ul">
                        	 <li id="logout">������ �α׾ƿ�</li>
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
                            <p>ȸ�� ����</p>
                        </li>
                        <li id="admin-nav-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>�Ű� ����</p>
                        </li>
                        <li id="admin-nav-3" class="click-color">
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
                            <p>ī�װ� ����</p>
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
                        <li id="sub-5" class="click-font">
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
                    <div class="article-wrap">
                   	<form action="${pageType}/Update" method="post" accept-charset="UTF-8">
                        <div class="btns">
                            <button class="btn back">���� ���</button>
                            <button type="submit" class="btn regist">�亯 ���</button>
                        </div>
                        <article class="up">
                            <div>
                                <p class="big-title">����</p>
                            </div>
                            <div class="line"></div>
                            <ul class="title">
                                <li>��ǰ ��ȣ</li>
                                <li>������ �� ����</li>
                                <li>������ ID</li>
                                <li>���� �Ͻ�</li>
                            </ul>
                            <div class="line"></div>
                            <ul class="list">
                                <li>${Question.getItemID()}</li>
                                <li>${Question.getQuestionTitle()}</li>
                                <li>${Question.getWriterID()}</li>
                                <li>${Question.getQuestionDateStr()}</li>
                            </ul>
                        </article>
                        <article class="down">
                            <div>
                                <p class="big-title">1:1 ����</p>
                            </div>
                            <div class="line"></div>
                            <div class="detail-box user">
                                <p class="box-title">��������</p>
                                <div class="cols">${Question.getQuestionContent()}</div>
                            </div>
                            <div class="detail-box admin">
                            		<p class="box-title">�亯����</p>
                               	 	<div class="cols"></div>
	                            <c:if test="${Question.getResult() eq 0}">
	                            	<textarea class="answer" name="AnswerContent" value="${Question.getAnswerContent()}" required></textarea>
								</c:if>
								<c:if test="${Question.getResult() eq 1}">
									<textarea class="answer" value="${Question.getAnswerContent()}" readonly></textarea>
								</c:if>
                            </div>
                        </article>
                        <input type="hidden" name="QuestionID" value="${Question.getQuestionID()}">
                        </form>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <script src="/resources/static/js/common.js"></script>
    <script src="/resources/static/js/contact-detail.js"></script>
</body>
</html>