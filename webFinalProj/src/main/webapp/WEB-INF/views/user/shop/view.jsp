<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/view.css">
    <title>내정보</title>
</head>
<body>
    <div class="detail">
        <div class="detail-tabs">
            <button class="detail-tab here" disabled>구매하기</button>
            <button class="detail-tab">상세보기</button>
            <button class="detail-tab">후기<span class="review-num">(3)</span></button>
            <button class="detail-tab">문의하기</button>
        </div>

        <div id="buy" class="buy">
            <div class="item-view">
                <div class="img-box">
                    <img src="/resources/static/img/sample.png" alt="">
                </div>
                <div class="item-div">
                    <div class="item-name">상품명</div>
                    <div id="like-line">
                        <label id="like-num">좋아요 수</label>
                        <label id="like-state">하트모양</label>
                    </div>
                </div>
                <label class="item-price">가격</label>
            </div>
            <div class="item-opt">
                <div>
                    <label style="color: rgb(180, 180, 180);">옵션</label>
                    <div class="opt opt-size">
                        <select id="option-size">
                            <option value="" selected hidden>사이즈</option>
                            <option value="1" >size1</option>
                            <option value="2" >size2</option>
                        </select>
                    </div>
                    <div class="opt opt-color">
                        <select id="option-color" disabled>
                            <option value="" selected hidden>색상</option>
                            <option value="1">검정</option>
                            <option value="2">하양</option>
                        </select>
                    </div>
                </div>
                <hr>
                <div class="item-box">
                    
                </div>
                <hr>
                <div class="total-price">
                    <div>총 금액</div>
                    <div><span id="total">0</span>원</div>
                </div>
                <div class="buttons">
                    <div><button id="basket" type="button">장바구니에 담기</button></div>
                    <div><button id="payment" type="button">구매하기</button></div>
                </div>
            </div>
        </div>

        <div id="container"></div>
    </div>
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/shop/detail.js"></script>
</body>
</html>