<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/question.css">
    <title>상품문의</title>
</head>
<body>
    <div class="questionBody">
        <div class="div-box">
            <div>
                <div>
                    <label class="title">상품 문의</label>
                </div>
                <div>
                    <button id="button" type="button">문의하기</button>
                </div>
            </div>
            <hr>
            <table>
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>제목</th>
                        <th>상태</th>
                        <th>날짜</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="post">
                        <td>번호</td>
                        <td>제목</td>
                        <td>상태</td>
                        <td>날짜</td>
                    </tr>
                </tbody>
            </table>    
        </div>
    </div>

<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
</body>
</html>