<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/review.css">
    <title>후기</title>
</head>
<body>
    <div class="reviewHeader">
        <div>
            <label class="title">구매 후기</label>
            <label class="header-text">총 <span class="point">3</span> 개의 리뷰가 있습니다.</label>
        </div>
        <div>
            <button id="write-btn" type="button">후기 작성</button>
        </div>
    </div>
    <hr>
    <div class="reviewList">
        <div class="review">
            <div class="text-box">
                <div class="review-area">
                    <div class="eval-date">
                        <label class="eval">★★★★★</label>
                        -
                        <label class="date">2022.02.14</label>
                        <label class="write-type">작성</label>
                    </div>
                    <div class="review-content">
                        <p>
                            백 오십자를 작성해ㅑㅇ하는데 저번에 무슨 글씨 썻더라.. 하나도 몰그ㅔㅆ어 집에 가고 싶어요 아저씨 우는 손님이 처음인가요?
                            달리몀ㄴ 뭘 잊는거더라 아무튼 이제 90자 썼는데 이거 어떡하죠?
                            리뷰를 사람들이 어떻게 적을지 감이 안잡히네요.. 하...
                            이거 내일까지 아니
                        </p>
                    </div>
                </div>
                <div id="mod-del" class="review-button">
                    <button class="mod" type="button">수정</button>
                    <button class="del" type="button">삭제</button>
                </div>
                <div id="rtn-udt" class="review-button" style="display: none;">
                    <button class="rtn" type="button">취소</button>
                    <button class="udt" type="button">확인</button>
                </div>
            </div>
            <div class="img-box">
                <img class="review-img" src="/resources/static/img/sample.png" alt="" data-bs-toggle="modal" data-bs-target="#exampleModal">
            </div>
        </div>
        <hr>

        <div class="review">
            <div class="text-box">
                <div class="review-area">
                    <div class="eval-date">
                        <label class="eval">★★★☆☆</label>
                        -
                        <label class="date">2022.02.13</label>
                        <label class="write-type">작성</label>
                    </div>
                    <div class="review-content">
                        <p>어쩌구 저쩌구어쩌구 저쩌구어쩌구 저쩌구어쩌구 저쩌구
                            어쩌구 저쩌구어쩌구 저쩌구어쩌구 저쩌구어쩌구 저쩌구
                            어쩌구 저쩌구어쩌구 저쩌구어쩌구 저쩌구어쩌구 저쩌구
                            어쩌구 저쩌구어쩌구 저쩌구어쩌구 저쩌구어쩌구 저쩌구</p>
                    </div>
                </div>
            </div>
            <div class="img-box">
                <img class="review-img" src="/resources/static/img/sample.png" alt=""  data-bs-toggle="modal" data-bs-target="#exampleModal">
            </div>
        </div>
        <hr>

        <div class="review">
            <div class="text-box">
                <div class="review-area">
                    <div class="eval-date">
                        <label class="eval">★★★★★</label>
                        -
                        <label class="date">2022.02.12</label>
                        <label class="write-type">작성</label>
                    </div>
                    <div class="review-content">
                        <p>어쩌구 저쩌구</p>
                    </div>
                </div>
                <div id="mod-del" class="review-button">
                    <button class="mod" type="button">수정</button>
                    <button class="del" type="button">삭제</button>
                </div>
                <div id="rtn-udt" class="review-button" style="display: none;">
                    <button class="rtn" type="button">취소</button>
                    <button class="udt" type="button">확인</button>
                </div>
            </div>
            <div class="img-box">
                <img class="review-img" src="/resources/static/img/sample.png" alt="" data-bs-toggle="modal" data-bs-target="#exampleModal">
            </div>
        </div>
        <hr>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div id="modal" class="modal-dialog modal-dialog-centered" data-bs-dismiss="modal">
        <div class="modal-content">
            <div id="modal-img" class="modal-body"></div>
            <div id="modal-content" class="modal-footer"></div>
        </div>
        </div>
    </div>

    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/shop/review.js"></script>
</body>
</html>