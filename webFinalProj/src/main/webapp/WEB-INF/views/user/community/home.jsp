<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>  
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

        <link type="text/css" rel="stylesheet" href="/resources/static/css/user/community/home.css">
        <title>커뮤니티</title>
    </head>
    <body>
    
    
        <div class="cmmu-hot">
            <div class="div-box">
                <div>
                    <div>
                        <label class="title">인기글</label>
                    </div>
                   
                    <div>
                        <button type="button" onclick="location.href='/post/add'">글쓰기</button>
                    </div>
                    
                </div>
            
                <div>
                        <label id="more" onclick="location.href='/board/goodlist?page_num=1'">더보기<i class="fa-solid fa-angle-right"></i></label>
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
                    	<c:forEach var="good" items="${good}">
	                        <tr class="post" onclick="location.href='/post?post_id=' + ${good.getPost_id()}">
	                            <td>${good.getPost_id()}</td>
	                            <td>${good.getTitle()}</td>
	                            <td>${good.getWriter_id()}</td>
	                            <td>${good.getGood_number()}</td>
	                        </tr>
                        </c:forEach>
                        
                    </tbody>
                </table>    
            </div>
        </div>
        <div class="cmmu-noti">
            <div class="div-box">
                <div>
                    <div>
                        <label class="title">공지</label>
                    </div>
                    <div>
                        <label id="more" onclick="location.href='/board/list?board_id=0&page_num=1'">더보기 <i class="fa-solid fa-angle-right"></i></label>
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
                    	
                       <c:forEach var="notice" items="${notice}">
	                        <tr class="post" onclick="location.href='/post?post_id=' + ${notice.getPost_id()}">
	                            <td>${notice.getPost_id()}</td>
	                            <td>${notice.getTitle()}</td>
	                            <td>${notice.getWriter_id()}</td>
	                            <td>${notice.getGood_number()}</td>
	                        </tr>
                        </c:forEach>
                      
                    </tbody>
                </table>    
            </div>
        </div>
        <div class="cmmu-last">
            <div class="div-box">
                <div>
                    <div>
                        <label class="title">최신글</label>
                    </div>
                    <div>
                        <label id="more" onclick="location.href='/board/list?board_id=1&page_num=1'">더보기 <i class="fa-solid fa-angle-right"></i></label>
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
                    	
                       <c:forEach var="recent" items="${recent}">
	                        <tr class="post" onclick="location.href='/post?post_id=' + ${recent.getPost_id()}">
	                            <td>${recent.getPost_id()}</td>
	                            <td>${recent.getTitle()}</td>
	                            <td>${recent.getWriter_id()}</td>
	                            <td>${recent.getGood_number()}</td>
	                        </tr>
	                   
                        </c:forEach>
                    </tbody>
                </table>    
            </div>
        </div>
    
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
</body>
</html>