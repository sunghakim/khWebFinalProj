<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <%@ include file="../common/header.jsp"%>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/review.css">
    <title>후기</title>
</head>
<body>
<%@ include file="../common/topnav.jsp"%>
<%@ include file="../common/sidenav.jsp"%>
<div>
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
                            리뷰~
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
</div>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/static/js/user/shop/review.js"></script>
<%@ include file="../common/footer.jsp"%>