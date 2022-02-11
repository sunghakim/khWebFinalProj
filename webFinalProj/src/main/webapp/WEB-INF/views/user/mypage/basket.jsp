<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/basket.css">
    <title>장바구니</title>
</head>
<body  class="basket">
<div>
    <div class="basketHeader">
        <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
        <label><h1>장바구니</h1></label>
    </div>
    <div class="form">
    <form id="go-payment">
        <div class="div-back">
            <div class="product">
                <input type="checkbox" class="item" name="상품명id" value="상품명id-1" checked>
                <div>
                    <div>
                        <img>
                        <div class="data">
                            <h5>상품명1234</h5>
                            <label>상품 옵션</label><br>
                            <label class="price">111111</label>
                        </div>
                    </div>
                    <div class="count">
                        <button type="button"><i class="fa-solid fa-plus"></i></button>
                        <h4>0</h4>
                        <button type="button"><i class="fa-solid fa-minus"></i></button>
                        <button id="delete" type="button"><i id="xmark" class="fa-solid fa-xmark"></i></button>
                    </div>
                </div>
            </div>
            <div class="product">
                <input type="checkbox" class="item" name="상품명id" value="상품명id-1" checked>
                <div>
                    <div>
                        <img>
                        <div class="data">
                            <h5>상품명1234</h5>
                            <label>상품 옵션</label><br>
                            <label class="price">222222</label>
                        </div>
                    </div>
                    <div class="count">
                        <button type="button"><i class="fa-solid fa-plus"></i></button>
                        <h4>0</h4>
                        <button type="button"><i class="fa-solid fa-minus"></i></button>
                        <button id="delete" type="button"><i id="xmark" class="fa-solid fa-xmark"></i></button>
                    </div>
                </div>
            </div>
            <div class="product">
                <input type="checkbox" class="item" name="상품명id" value="상품명id-1" checked>
                <div>
                    <div>
                        <img>
                        <div class="data">
                            <h5>상품명1234</h5>
                            <label>상품 옵션</label><br>
                            <label class="price">33333</label>
                        </div>
                    </div>
                    <div class="count">
                        <button type="button"><i class="fa-solid fa-plus"></i></button>
                        <h4>0</h4>
                        <button type="button"><i class="fa-solid fa-minus"></i></button>
                        <button id="delete" type="button"><i id="xmark" class="fa-solid fa-xmark"></i></button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    </div>
    <hr>
    <div class="basketFooter">
        <div>
            <h3>총 금액</h3>
            <h3 id="total">0원</h3>
        </div>
        <button id="submit">바로구매</button>
    </div>
</div>

    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/basket.js"></script>
</body>
</html>