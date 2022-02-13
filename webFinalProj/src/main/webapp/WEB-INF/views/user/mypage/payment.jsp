<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>
    
        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/payment.css">
        <title>결제</title>
    </head>
    <body  class="payment">
    <div>
        <div class="paymentHeader">
            <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
            <label><h1>결제</h1></label>
        </div>
        <div class="paymentBody">
            <div class="left">
                <div class="list">
                    <label class="title">구매 물품</label>
                    <hr class="margin-top">
                    <div class="list-table">
                        <table>
                            <tr>
                                <td>
                                    <label class="name">상품명</label>
                                    -
                                    <label class="option">옵션</label>
                                    <label><span  class="num">2</span>개</label>
                                </td>
                                <td>
                                    <label><span  class="price">44,444</span>원</label>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="total-price">
                    <label class="title">결제 금액</label>
                    <hr class="margin-top">
                    <div class="price-Table">
                        <div>
                            <label>총 상품 금액</label>
                            <label><span id="before">67,222</span> 원</label>
                        </div>
                        <div>
                            <label>쿠폰 할인</label>
                            <label>- <span id="sale">0</span> 원</label>
                        </div>
                        <div>
                            <label>배송비</label>
                            <label><span id="delibery">0</span> 원</label>
                        </div>
                    </div>
                    <hr>
                    <div class="price-text">
                        <label>총 결제 금액</label>
                        <label><span id="total">67,222</span> 원</label>
                    </div>
                </div>
            </div>
            <div class="vertical-line"></div>
            <form action="">
                <div class="right">
                    <div class="coupon">
                        <label class="title">쿠폰</label>
                        <hr class="margin-top">
                        <div>
                            <input id="coupon-id" type="text" name="coupon-id" hidden/>
                            <div class="coupon-label">
                                <label id="coupon-Name">선택한 쿠폰이 없습니다</label>
                            </div>
                            <button type="button" id="coupon-Btn">사용</button>
                        </div>
                        <div id="coupon-List">
                            <table>
                                <tr>
                                    <td class="couponList-name">쿠폰1 이름</td>
                                    <td class="couponList-btn"><button type="button" id="take">사용</button></td>
                                </tr>
                                <tr>
                                    <td class="couponList-name">쿠폰2 이름</td>
                                    <td class="couponList-btn"><button type="button" id="take">사용</button></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="address">
                        <label class="title">배송지 정보</label>
                        <hr class="margin-top">
                        <div class="address-div">
                            <table class="address-table">
                                <tr>
                                    <th>수령인</th>
                                    <td><input type="text" name="name" /></td>
                                </tr>
                                <tr>
                                    <th>휴대폰</th>
                                    <td><input type="text" name="phone" /></td>
                                </tr>
                                <tr>
                                    <th>우편번호</th>
                                    <td><input type="text" name="postalCode" /></td>
                                </tr>
                                <tr>
                                    <th>주소지</th>
                                    <td><input type="text" name="address1" /></td>
                                </tr>
                                <tr>
                                    <th>상세주소</th>
                                    <td><input type="text" name="address2"/></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="select-button">
                        <select class="select" name="select">
                            <option value="" selected hidden>결제방식</option>
                            <option value="1" >계좌이체</option>
                            <option value="2" >무통장이체</option>
                            <option value="3" >카드결제</option>
                        </select>
                        <button type="button" id="submit">결제하기</button>
                    </div>
                </div>
            </form>
        </div>    
    </div>
    
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/mypage/payment.js"></script>
</body>
</html>