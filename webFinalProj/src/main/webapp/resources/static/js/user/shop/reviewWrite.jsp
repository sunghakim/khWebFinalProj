<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/reviewWrite.css">
    <title>후기 작성</title>
</head>
<body>
    <form>
        <div class="writeHeader">
            <label class="title">평가</label>
            <ul class="stars">
                <li class="star">☆</li>
                <li class="star">☆</li>
                <li class="star">☆</li>
                <li class="star">☆</li>
                <li class="star">☆</li>
            </ul>
            <input id="eval" type="text" value="0" required hidden/>
        </div>
        <div class="writeBody">
            <label class="title">후기</label>
            <label id="content-count"><span id="count">0</span>/150</label>
            <textarea id="content" class="frm" placeholder="내용을 입력해주세요" required/></textarea>
            <input type="file" />
        </div>
        <div class="writeFooter">
            <button class="common-btn" type="button">취소</button>
            <button class="point-btn" type="button">작성완료</button>
        </div>
    </form>
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/shop/reviewWrite.js"></script>
</body>
</html>