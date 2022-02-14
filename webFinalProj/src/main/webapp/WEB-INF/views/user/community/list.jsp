<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/list.css">
        <title>커뮤니티</title>
    </head>
    <body>
        <div class="list">
            <div>
                <div>
                    <label class="title">인기글</label>
                </div>
                <div>
                    <button type="button">글쓰기</button>
                </div>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>좋아요</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="noti">
                        <td>공지</td>
                        <td colspan="3">제목</td>
                    </tr>
                    <tr class="post">
                        <td>번호</td>
                        <td>제목</td>
                        <td>작성자</td>
                        <td>좋아요</td>
                    </tr>
                </tbody>
            </table>    
        </div>
        <div class="paging">

        </div>
    
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
</body>
</html>