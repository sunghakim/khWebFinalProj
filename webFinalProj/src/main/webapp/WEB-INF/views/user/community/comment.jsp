<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/comment.css">
    <title>내정보</title>
</head>
<body>
    <div class="commentBody">
        <div id="cmt-write" class="cmt-write">
            <textarea name="" id="" placeholder="내용을 입력해주세요"></textarea>
            <button id="newSubmit" type="button">등록</button>
        </div>
        <hr>
        <div class="comment">
            <label>닉네임(아이디)</label>
            <div class="cmt-box">
                <div id="cmt">내가 쓴 댓글</div>
                <div class="default-btn">
                    <button class="cmt-mod" class="button" type="button">수정</button>
                    <button class="cmt-del" class="button" type="button">삭제</button>
                </div>
                <div class="mod-btn" style="display: none;">
                    <button class="rtn" class="button" type="button">취소</button>
                    <button class="udt" class="button" type="button">확인</button>
                </div>
            </div>
        </div>
        <hr>
        <div class="comment">
            <label>닉네임(아이디)</label>
            <div class="cmt-box">
                <div id="cmt">누군가 쓴 댓글</div>
            </div>
        </div>
        <hr>
    </div>

    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/community/detail.js"></script>
</body>
</html>