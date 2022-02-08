<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="css/index.css">
    <title>kh Final</title>
</head>

<body>
    <div class="join-modal modal-back">
        <div class="join-modal modal-front">
            <p class="title">J O I N</p>
            <form method="" action="">
                <div class="join-id">
                    <div class="join-div-wrap">
                        <input type="text" maxlegth="20" placeholder="아이디를 입력하세요">
                        <button class="overlap-check"><i class="fas fa-check-circle"></i></button>
                    </div>
                    <div class="join-text">
                        <div class="join-form" id="join-id-form">아이디는 20자 이하로 작성해주세요. 대소문자를 구분합니다.</div>
                        <div class="join-alert" id="join-id-null">아이디를 입력해주세요.</div>
                        <div class="join-overlap">중복된 아이디입니다. 다시 입력하세요.</div>
                    </div>

                </div>
                <div class="join-password">
                    <input type="password" maxlegth="20" placeholder="비밀번호를 입력하세요">
                    <div class="join-text">
                        <div class="join-form" id="join-pwd-form">비밀번호는 20자 이하로 작성해주세요.</div>
                        <div class="join-alert" id="join-pwd-null">비밀번호를 입력해주세요.</div>
                    </div>
                </div>
                <div class="join-password-check">
                    <input type="password" maxlegth="8" placeholder="비밀번호를 입력하세요">
                    <div class="join-text">
                        <div class="join-form" id="join-password-check-form">비밀번호를 한 번 더 입력해주세요.</div>
                        <div class="join-alert" id="join-password-check-no">비밀번호가 일치하지 않습니다.</div>
                    </div>
                </div>
                <div class="join-name">
                    <input type="text" placeholder="이름을 입력하세요">
                </div>
                <div class="join-phone">
                    <input type="text" maxlength="13" placeholder="핸드폰번호를 입력하세요">
                </div>
                <div class="join-email">
                    <input type="email" placeholder="이메일을 입력하세요">
                </div>
                <div class="join-address">
                    <input type="text" placeholder="주소를 입력하세요">
                </div>
                <div class="join-nickname">
                    <div class="join-div-wrap">
                        <input type="text" placeholder="닉네임을 입력하세요">
                        <button class="overlap-check"><i class="fas fa-check-circle"></i></button>
                    </div>
                    <div class="join-text join-overlap overNic">중복된 닉네임입니다. 다시 입력하세요.</div>
                </div>

                <div class="yes">
                    쇼핑몰 회원가입 시 쇼핑몰 약관에 동의하는 것으로 간주됩니다.
                </div>
                <div class="join-btns">
                    <button>회원가입</button>
                    <button>닫기</button>
                </div>
            </form>
        </div>
    </div>

    <div class="login-modal modal-back">
        <div class="login-modal modal-front login-front">
            <p class="title">L O G I N</p>
            <form method="" action="">
                <div class="login-id">
                    <input type="text" maxlegth="20" placeholder="아이디를 입력하세요">
                    <div class="login-text">
                        <div class="login-form" id="login-id-form">아이디는 20자 이하로 작성해주세요. 대소문자를 구분합니다.</div>
                        <div class="login-alert" id="login-id-wrong">잘못된 아이디입니다. 다시 입력하세요.</div>
                    </div>
                </div>
                <div class="login-password">
                    <input type="password" maxlegth="20" placeholder="비밀번호를 입력하세요">
                    <div class="login-text">
                        <div class="login-form" id="login-pwd-form">비밀번호는 20자 이하로 작성해주세요.</div>
                        <div class="login-alert" id="login-pwd-wrong">잘못된 비밀번호입니다. 다시 입력하세요.</div>
                    </div>
                </div>
                <div class="login-btns">
                    <button>로그인</button>
                    <button>닫기</button>
                </div>
            </form>
        </div>
    </div>

    <div class="wrapper">
        <header>
            <div class="header-wrap">
                <h2 class="logo">logo</h2>
                <ul class="header-ul">
                    <li><i class="fas fa-shopping-bag"></i>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li><i class="fas fa-sign-in-alt"></i>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li><i class="fas fa-toggle-on"></i>&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li><i class="fas fa-user-cog"></i></li>
                </ul>
            </div>
        </header>
        <div class="content">
            <nav>
                <div class="nav-wrap">
                    <ul class="user-nav">
                        <li id="user-nav-1">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Shop</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Notice</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Outer</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Shirts</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Jeans</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Accessary</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Community</p>
                        </li>
                    </ul>
                    <ul class="admin-nav">
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>회원 관리</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>신고 관리</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>사이트 관리</p>
                        </li>
                    </ul>
                    <ul class="admin-nav-sub">
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>상품 관리</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>카테고리 관리</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>통계 확인</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>쿠폰 목록</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>개인 문의</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>환불 관리</p>
                        </li>
                        <li>
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>공지 관리</p>
                        </li>
                    </ul>
                </div>
            </nav>
            <section>
                <div class="article-wrap">
                    <article>
                        <p>Segment<br>Title</p>
                        <div class="img"></div>
                    </article>
                    <article>
                        <p>Segment<br>Title</p>
                        <div class="img"></div>
                    </article>
                    <article>
                        <p>Segment<br>Title</p>
                        <div class="img"></div>
                    </article>
                    <article>
                        <p>Segment<br>Title</p>
                        <div class="img"></div>
                    </article>
                </div>
            </section>
        </div>
    </div>
</body>

</html>