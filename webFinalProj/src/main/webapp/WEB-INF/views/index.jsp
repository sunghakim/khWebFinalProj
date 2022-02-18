<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
    <html>
    
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="/resources/static/css/common.css">
        <link rel="stylesheet" href="/resources/static/css/index.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://accounts.google.com/gsi/client" async defer></script>
        <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
        <script>
            document.domain = "localhost";
         
            /** API 서비스 제공항목 확대 (2017.02) **/
        	function jusoCallBack(roadFullAddr,zipNo){
        		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
        		console.log(roadFullAddr);
        		document.form.roadFullAddr.value = roadFullAddr;
        		document.form.zipNo.value = zipNo;
        	}
        </script>
        <title>사달라</title>
        <!-- 메인 페이지 -->
    </head>
    
    <body>
    
        <!-- 회원가입 모달 -->
        <div class="join-modal modal-back" id="join-modal">
            <div style="display: block;" class="join-modal modal-front">
                <p class="title">4 $</p>
                <form id="form" name="form" method="post" action="/join">
                    <div class="radio-box">
                        <input type="radio" value="0" class="size-radio" id="admin" name="user_type"><label
                            for="admin">관리자</label>
                        <input type="radio" value="1" class="size-radio" id="user" name="user_type"><label
                            for="user">회원</label>
                        <div class="join-text text">
                            <div class="join-alert" id="join-radio">체크해주세요.</div>
                        </div>
                    </div>
                    <div class="join-id">
                        <div class="join-div-wrap">
                            <input id="join-id" type="text" maxlegth="20" placeholder="아이디를 입력하세요" name="account_id">
                        </div>
                        <div class="join-text text">
                            <div class="join-form" id="join-id-form">아이디는 20자 이하로 작성해주세요. 대소문자를 구분합니다.</div>
                            <div class="join-alert" id="join-id-null">아이디를 입력해주세요.</div>
                            <div class="join-alert" id="join-id-wrong">잘못된 아이디 방식입니다. 다시 작성해주세요.</div>
                        </div>
                    </div>
                    <div class="join-password">
                        <input id="join-pwd" type="password" maxlegth="20" placeholder="비밀번호를 입력하세요" name="password">
                        <div class="join-text text">
                            <div class="join-form" id="join-pwd-form">비밀번호는 20자 이하로 작성해주세요.</div>
                            <div class="join-alert" id="join-pwd-wrong">잘못된 비밀번호 방식입니다. 다시 작성해주세요.</div>
                            <div class="join-alert " id="join-pwd-null">비밀번호를 입력해주세요.</div>
                        </div>
                    </div>
                    <div class="join-password-check">
                        <input id="join-pwd-check" type="password" maxlegth="20" placeholder="비밀번호를 입력하세요">
                        <div class="join-text text">
                            <div class="join-form" id="join-pwd-check-form">비밀번호를 한 번 더 입력해주세요.</div>
                            <div class="join-alert" id="join-pwd-check-null">비밀번호를 입력해주세요.</div>
                            <div class="join-alert" id="join-pwd-check-yes">비밀번호가 일치합니다.</div>
                            <div class="join-alert" id="join-pwd-check-no">비밀번호가 일치하지 않습니다.</div>
                        </div>
                    </div>
                    <div class="join-name">
                        <input type="text" id="join-name" placeholder="이름을 입력하세요" name="name">
                        <div class="join-text text">
                            <div class="join-alert" id="join-name-null">이름을 입력해주세요.</div>
                        </div>
                    </div>
                    <div class="join-nickname">
                        <div class="join-div-wrap">
                            <input type="text" id="join-nickname" placeholder="닉네임을 입력하세요" name="nickname">
                        </div>
                        <div class="join-text text">
                            <div class="join-alert" id="join-nic-null">닉네임을 입력해주세요.</div>
                        </div>
                    </div>
                    <div class="join-phone">
                        <input type="text" id="join-phone" maxlength="13" placeholder="핸드폰 번호를 입력하세요. 010-1234-1234" name="phone">
                        <div class="join-text text">
                            <div class="join-alert" id="join-phone-wrong">핸드폰 번호를 올바르게 입력하세요.</div>
                            <div class="join-alert" id="join-phone-null">핸드폰 번호를 입력해주세요.</div>
                        </div>
                    </div>
                    <div class="join-email">
                        <input type="email" id="join-email" placeholder="이메일을 입력하세요" name="email">
                        <div class="join-text text">
                            <div class="join-alert" id="join-email-null">이메일을 입력해주세요.</div>
                        </div>
                    </div>
                    <div class="join-address">
                    	<input type="hidden" id="confmKey" name="confmKey" value="">
                    	<button type="button" class="btn" id="address-num-btn">우편번호</button>
                        <input style="width: 210px" type="text" name="zipNo" placeholder="우편번호" id="zipNo">
                        <input type="text" id="roadFullAddr" placeholder="주소" name="address" >
                        <div class="join-text text">
                            <div class="join-alert" id="join-address-num-null">우편번호를 확인하세요.</div>
                            <div class="join-alert" id="join-address-null">주소를 입력해주세요.</div>
                        </div>
                        
                    </div>
    
                    <div class="yes">
                        쇼핑몰 회원가입 시 쇼핑몰 약관에 동의하는 것으로 간주됩니다.
                    </div>
                    <div class="join-btns">
                        <button type="submit" id="join-submit">회원가입</button>
                        <button class="exit">닫기</button>
                    </div>
                </form>
            </div>
        </div>
    
        <!-- 회원 로그인 모달 -->
        <div class="login-modal modal-back" id="login-modal">
            <div class="login-modal modal-front login-front">
                <p class="title">L O G I N</p>
                <form method="post" action="/login">
                    <div class="login-id">
                        <input id="login-id" type="text" maxlegth="20" placeholder="아이디를 입력하세요" name="account_id">
                        <div class="login-text text">
                            <div class="login-form" id="login-id-form">아이디는 20자 이하로 작성해주세요. 대소문자를 구분합니다.</div>
                            <div class="login-alert" id="login-id-null">아이디를 입력해주세요.</div>
                            <div class="login-alert" id="login-id-wrong">잘못된 아이디입니다. 다시 입력하세요.</div>
                        </div>
                    </div>
                    <div class="login-password">
                        <input id="login-pwd" type="password" maxlegth="20" placeholder="비밀번호를 입력하세요" name="password">
                        <div class="login-text text">
                            <div class="login-form" id="login-pwd-form">비밀번호는 20자 이하로 작성해주세요.</div>
                            <div class="login-alert" id="login-pwd-null">비밀번호를 입력해주세요.</div>
                            <div class="login-alert" id="login-pwd-wrong">잘못된 비밀번호입니다. 다시 입력하세요.</div>
                        </div>
                    </div>
                    <div class="login-btns">
                        <button type="submit" id="login-submit">로그인</button>
                        <button class="exit">닫기</button>
                    </div>
                    <div class="other-login-btns">
                        <div class="other-login-title">외부로그인</div>
                        <div id="g_id_onload"
                            data-client_id="494231445138-2h489p3ollojmgeb6531mas1508c9eb0.apps.googleusercontent.com"
                            data-auto_prompt="false" data-auto_select="false"
                            data-login_uri="/google/auth">
                        </div>
                        <div class="g_id_signin" data-type="standard" data-size="large" data-theme="outline"
                            data-text="sign_in_with" data-shape="rectangular" data-logo_alignment="left">
                        </div>
                        <a id="custom-login-btn" href="javascript:loginWithKakao()">
                            <img src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
                                alt="카카오 로그인 버튼" />
                        </a>
                    </div>
                    <input type="hidden" value="1" name="user_type"/>
                </form>
            </div>
        </div>
    
        <!-- 비회원 로그인 모달 -->
        <div class="login-modal modal-back" id="noMember-login-modal">
            <div class="login-modal modal-front login-front" id="nonMember-front">
                <p class="title">L O G I N</p>
                <form method="post" action="/login">
                	<div class="login-name">
                        <input type="text" id="login-name" placeholder="이름을 입력하세요" name="name">
                        <div class="login-text text">
                        <div class="login-alert" id="login-name-null">이름을 입력해주세요.</div>
                    </div>
                    </div>
                    <div class="login-phone">
                        <input type="text" id="login-phone" placeholder="이메일을 입력하세요." name="email">
                        <div class="login-text text">
                            <div class="login-form" id="login-phone-form">본인 확인용으로 사용됩니다.</div>
                            <div class="login-alert" id="login-phone-null">이메일을 입력해주세요.</div>
                            <div class="login-alert" id="login-phone-wrong">잘못된 이메일 주소입니다. 다시 입력하세요.</div>
                        </div>
                    </div>
                    <div class="login-password">
                        <input id="login-check-pwd" type="password" maxlegth="20" placeholder="비밀번호를 입력하세요" name="password">
                        <div class="login-text text">
                            <div class="login-form" id="login-chkPwd-form">비밀번호는 20자 이하로 작성해주세요.</div>
                            <div class="login-alert" id="login-chkPwd-null">비밀번호를 입력해주세요.</div>
                        </div>
                    </div>
                    <div class="login-btns">
                        <button type="submit" id="noMember-login-submit">로그인</button>
                        <button class="exit">닫기</button>
                    </div>
                    <input type="hidden" value="2" name="user_type"/>
                </form>
            </div>
        </div>

        <!-- 관리자 로그인 모달 -->
        <div class="login-modal modal-back" id="admin-login-modal">
            <div class="login-modal modal-front login-front" id="admin-front">
                <p class="title">L O G I N</p>
                <form method="post" action="/login">
                    <div class="login-id">
                        <input id="admin-id" type="text" maxlegth="20" placeholder="아이디를 입력하세요" name="account_id">
                        <div class="login-text text">
                            <div class="login-form" id="admin-id-form">아이디는 20자 이하로 작성해주세요. 대소문자를 구분합니다.</div>
                            <div class="login-alert" id="admin-id-null">아이디를 입력해주세요.</div>
                            <div class="login-alert" id="admin-id-wrong">잘못된 아이디입니다. 다시 입력하세요.</div>
                        </div>
                    </div>
                    <div class="login-password">
                        <input id="admin-pwd" type="password" maxlegth="20" placeholder="비밀번호를 입력하세요" name="password">
                        <div class="login-text text">
                            <div class="login-form" id="admin-pwd-form">비밀번호는 20자 이하로 작성해주세요.</div>
                            <div class="login-alert" id="admin-pwd-null">비밀번호를 입력해주세요.</div>
                            <div class="login-alert" id="admin-pwd-wrong">잘못된 비밀번호입니다. 다시 입력하세요.</div>
                        </div>
                    </div>
                    <div class="login-btns">
                        <button type="submit" id="admin-submit">로그인</button>
                        <button class="exit">닫기</button>
                    </div>
                    <input type="hidden" value="0" name="user_type"/>
                </form>
            </div>
        </div>
    
        <div class="wrapper">
            <header>
                <div class="header-wrap">
                    <h2 class="logo">logo</h2>
                    <div class="ul-wrap">
                    <c:choose>
                    	<c:when test="${sessionScope.usertype eq 'social'}">
                    		<ul class="header-ul" id="logout-ul">
			                    <li id="cart">마이페이지&nbsp;&nbsp;|&nbsp;&nbsp;</li>
		                        <li id="logout">로그아웃</li>
		                    </ul>
                    	</c:when>
                    	<c:otherwise>
		                    <c:choose>
			                    <c:when test="${sessionScope.account.user_type eq 0 }">
			                    	<script>
			                    		$(() => {
			                    			$(location).attr('href', '/Manager/Account');
			                    		})
			                    	</script>
		                        	</c:when>
		                        	<c:when test="${sessionScope.account.user_type eq 1 }">
		                        		<ul class="header-ul" id="logout-ul">
			                            	<li id="cart">마이페이지&nbsp;&nbsp;|&nbsp;&nbsp;</li>
		                        			<li id="logout">로그아웃</li>
		                        		</ul>
		                        	</c:when>
		                        	<c:when test="${sessionScope.account.user_type eq 2 }">
		                        		<ul class="header-ul" id="noMember-logout-ul">
		                        			<li id="cart">마이페이지&nbsp;&nbsp;|&nbsp;&nbsp;</li>
		                        			<li id="noMember-logout">로그아웃</li>
		                        		</ul>
		                        	</c:when>
		                        	<c:otherwise>
			                        	<ul class="header-ul" id="user-ul">
			                            	<li id="join">회원가입&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			                            	<li id="member-login">회원 로그인&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			                            	<li id="non-member-login">비회원 로그인&nbsp;&nbsp;|&nbsp;&nbsp;</li>
			                            	<li id="admin-change">관리자 로그인</li>
			                        	</ul>
		                        	</c:otherwise>
			                    </c:choose>
			               </c:otherwise>
		               </c:choose>
                    </div>
                </div>
            </header>
            <~!--div class="content">
                <nav>
                    <div class="nav-wrap">
                        <ul class="user-nav">
                            <li id="user-nav-1" class="click-color">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>${navList.get(0).getItemCategoryName()}</p>
                            </li>
                            <li id="user-nav-2">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>${navList.get(1).getItemCategoryName()}</p>
                            </li>
                            <li id="user-nav-3">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>${navList.get(2).getItemCategoryName()}</p>
                            </li>
                            <li id="user-nav-4">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>${navList.get(3).getItemCategoryName()}</p>
                            </li>
                            <li id="user-nav-5">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>${navList.get(4).getItemCategoryName()}</p>
                            </li>
                            <li id="user-nav-6">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>${navList.get(5).getItemCategoryName()}</p>
                            </li>
                            <li id="user-nav-7">
                                <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                                <p>${navList.get(6).getItemCategoryName()}</p>
                            </li>
                        </ul-->
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
                        <div class="article-wrap">
                        	<c:forEach var="List" items="${ItemList}" varStatus="status">
								<article class="article-before" id="before-${status.count}">
							        <a href="/itemDetail/main?item_id=${List.getItem_id()}">
								        <p class="head-text">${List.getName()}</p>
								        <img class="img" src="#">
							        </a>
							    </article>
							</c:forEach>
							<c:forEach var="i" begin="${5 - ItemConut}" end="${1 + ItemConut}" step="1" varStatus="status">
								<article class="article-before" id="before-${i}">
	                                <p>아직 상품이 없습니다.</p>
	                                <img class="img" >
	                            </article>
							</c:forEach>
                            <!--article class="article-after" id="after-1">
                                <p>Segment Title</p>
                                <div class="gallery-wrap">
                                    <div class="gallery-group">
                                        <div class="gall-img i1"></div>
                                        <div class="gall-img i2"></div>
                                        <div class="gall-img i3"></div>
                                    </div>
                                </div>
                                <button class="btns left"><i class="fas fa-chevron-left"></i></button>
                                <button class="btns right"><i class="fas fa-chevron-right"></i></button>
                            </article>
                            <article class="article-after" id="after-2">
                                <p>Segment Title</p>
                                <div class="gallery-wrap">
                                    <div class="gallery-group">
                                        <div class="gall-img i1"></div>
                                        <div class="gall-img i2"></div>
                                        <div class="gall-img i3"></div>
                                    </div>
                                </div>
                                <button class="btns left"><i class="fas fa-chevron-left"></i></button>
                                <button class="btns right"><i class="fas fa-chevron-right"></i></button>
                            </article>
                            <article class="article-after" id="after-3">
                                <p>Segment Title</p>
                                <div class="gallery-wrap">
                                    <div class="gallery-group">
                                        <div class="gall-img i1"></div>
                                        <div class="gall-img i2"></div>
                                        <div class="gall-img i3"></div>
                                    </div>
                                </div>
                                <button class="btns left"><i class="fas fa-chevron-left"></i></button>
                                <button class="btns right"><i class="fas fa-chevron-right"></i></button>
                            </article>
                            <article class="article-after" id="after-4">
                                <p>Segment Title</p>
                                <div class="gallery-wrap">
                                    <div class="gallery-group">
                                        <div class="gall-img i1"></div>
                                        <div class="gall-img i2"></div>
                                        <div class="gall-img i3"></div>
                                    </div>
                                </div>
                                <button class="btns left"><i class="fas fa-chevron-left"></i></button>
                                <button class="btns right"><i class="fas fa-chevron-right"></i></button>
                            </article-->
                        </div>
                    </div>
                </section>
            </div>
        </div>
    
        <script src="/resources/static/js/common.js"></script>
        <script src="/resources/static/js/index.js"></script>
    </body>
    
    </html>