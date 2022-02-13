<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/mypage/report.css">
        <title>문의 및 신고</title>
    </head>
    <body  class="report-body">
        <div>
        <div class="reportHeader">
            <div>
                <a href="#"><i id="backPage" class="fa-solid fa-angles-left"></i></a>
                <label><h1>문의 및 신고</h1></label>
            </div>
            <div class="tab-buttons">
                <button id="question" class="tab-btn" type="button">문의</button>
                <button id="report" class="tab-btn here" type="button">신고</button>
            </div>
        </div>
        <div class="reportBody">
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>신고</th>
                            <th>사유</th>
                            <th>신고 날짜</th>
                            <th>신고 결과</th>
                            <th>조치 완료</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="report">
                            <td>몇번 게시물 신고</td>
                            <td>신고 사유</td>
                            <td>신고한 날짜</td>
                            <td>신고 진행 상태</td>
                            <td>조치된 날짜</td>
                        </tr>
                    </tbody>
                </table>    
            </div>
        </div>
        </div>
    
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/mypage/question.js"></script>
</body>
</html>