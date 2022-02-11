<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="resources/static/css/common.css">
    <link rel="stylesheet" href="resources/static/css/index.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>kh Final main</title>
    <!-- 메인 페이지 -->
</head>

<body>
    <div class="join-modal modal-back" id="join-modal">
        <div class="join-modal modal-front">
            <p class="title">J O I N</p>
            <form method="post" action="/join">
                <div class="join-id">
                    <div class="join-div-wrap">
                        <input id="account_id" type="text" maxlegth="20" placeholder="아이디를 입력하세요">
                        <button class="overlap-check">중복 확인</button>
                    </div>
                    <div class="join-text">
                        <div class="join-form" id="join-id-form">아이디는 20자 이하로 작성해주세요. 대소문자를 구분합니다.</div>
                        <div class="join-alert" id="join-id-null">아이디를 입력해주세요.</div>
                        <div class="join-alert" id="join-id-wrong">잘못된 아이디 방식입니다. 다시 작성해주세요.</div>
                        <div class="join-alert" id="join-id-overlap">중복된 아이디입니다. 다시 입력하세요.</div>
                    </div>
                </div>
                <div class="join-password">
                    <input id="password" type="password" maxlegth="20" placeholder="비밀번호를 입력하세요">
                    <div class="join-text">
                        <div class="join-form" id="join-pwd-form">비밀번호는 20자 이하로 작성해주세요.</div>
                        <div class="join-alert" id="join-pwd-wrong">잘못된 비밀번호 방식입니다. 다시 작성해주세요.</div>
                        <div class="join-alert" id="join-pwd-null">비밀번호를 입력해주세요.</div>
                    </div>
                </div>
                <div class="join-password-check">
                    <input id="join-pwd-check" type="password" maxlegth="8" placeholder="비밀번호를 입력하세요">
                    <div class="join-text">
                        <div class="join-form" id="join-pwd-check-form">비밀번호를 한 번 더 입력해주세요.</div>
                        <div class="join-alert" id="join-pwd-check-yes">비밀번호가 일치합니다.</div>
                        <div class="join-alert" id="join-pwd-check-no">비밀번호가 일치하지 않습니다.</div>
                    </div>
                </div>
                <div class="join-name">
                    <input id="name" type="text" placeholder="이름을 입력하세요">
                </div>
                <div class="join-nickname">
                    <div class="join-div-wrap">
                        <input type="text" placeholder="닉네임을 입력하세요">
                        <button class="overlap-check">중복 확인</button>
                    </div>
                    <div class="join-text">
                        <div class="join-alert" id="join-nic-overlap">중복된 닉네임입니다. 다시 입력하세요.</div>
                    </div>
                </div>
                <div class="join-phone">
                    <input type="text" maxlength="13" placeholder="핸드폰 번호를 입력하세요. 010-1234-1234">
                </div>
                <div class="join-email">
                    <input type="email" placeholder="이메일을 입력하세요">
                </div>
                <div class="join-address">
                    <input type="text" placeholder="주소를 입력하세요">
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

    <div class="login-modal modal-back" id="login-modal">
        <div class="login-modal modal-front login-front">
            <p class="title">L O G I N</p>
            <form method="" action="">
                <div class="login-id">
                    <input id="login-id" type="text" maxlegth="20" placeholder="아이디를 입력하세요">
                    <div class="login-text">
                        <div class="login-form" id="login-id-form">아이디는 20자 이하로 작성해주세요. 대소문자를 구분합니다.</div>
                        <div class="login-alert" id="login-id-null">아이디를 입력해주세요.</div>
                        <div class="login-alert" id="login-id-wrong">잘못된 아이디입니다. 다시 입력하세요.</div>
                    </div>
                </div>
                <div class="login-password">
                    <input id="login-pwd" type="password" maxlegth="20" placeholder="비밀번호를 입력하세요">
                    <div class="login-text">
                        <div class="login-form" id="login-pwd-form">비밀번호는 20자 이하로 작성해주세요.</div>
                        <div class="login-alert" id="login-pwd-null">비밀번호를 입력해주세요.</div>
                        <div class="login-alert" id="login-pwd-wrong">잘못된 비밀번호입니다. 다시 입력하세요.</div>
                    </div>
                </div>
                <div class="login-btns">
                    <button type="submit" id="login-submit">로그인</button>
                    <button class="exit">닫기</button>
                </div>
            </form>
        </div>
    </div>

    <div class="wrapper">
        <header>
            <div class="header-wrap">
                <h2 class="logo">logo</h2>
                <div class="ul-wrap">
                    <ul class="header-ul" id="user-ul">
                        <li><i class="fas fa-shopping-bag" id="member-cart"></i>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                        <li><i class="fas fa-sign-in-alt" id="member-join"></i>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                        <li><i class="fas fa-toggle-on" id="member-login"></i>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                        <li><i class="fas fa-user-cog" id="admin-change"></i></li>
                    </ul>
                    <ul class="header-ul" id="admin-ul">
                        <li><i class="fas fa-store" id="member-change"></i></li>
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
                        <article class="article-before" id="before-1">
                            <p>Segment<br>Title</p>
                            <div class="img"></div>
                        </article>
                        <article class="article-before" id="before-2">
                            <p>Segment<br>Title</p>
                            <div class="img"></div>
                        </article>
                        <article class="article-before" id="before-3">
                            <p>Segment<br>Title</p>
                            <div class="img"></div>
                        </article>
                        <article class="article-before" id="before-4">
                            <p>Segment<br>Title</p>
                            <div class="img"></div>
                        </article>
                        <article class="article-after" id="after-1">
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
                        </article>
                    </div>
                </div>
            </section>
        </div>
    </div>

    <script src="resources/static/js/common.js"></script>
    <script src="recources/static/js/index.js"></script>
</body>

</html>