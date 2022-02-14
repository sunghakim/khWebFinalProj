<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/questionWrite.css">
        <title>문의 작성</title>
    </head>
    <body  class="questionWrite-body">
        <div class="div">
            <form id="questionWrite" action="">
                <div class="questionWrite">
                    <div>
                        <label class="title-label">제목</label>
                        <input type="text" id="question-title" class="frm" name="title" placeholder="내용을 입력해주세요" required/>
                    </div>
                    <textarea id="question-content" class="frm" name="content" placeholder="내용을 입력해주세요" required></textarea>
                </div>
            </form>
            <div class="button-box">
                <button type="button" class="common-btn">취소</button>
                <button type="button" class="point-btn">확인</button>
            </div>
        </div>
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/questionWrite.js"></script>
</body>
</html>