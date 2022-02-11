<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지 상세보기</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/Manager_test/module/top-navigation.jsp" flush="false"/>
	</header>
	<main>
		<div>
			<span>
				<button type="button" onclick="location.href='${pageType}/Insert'">공지 작성</button>
			</span>
			<span>
				<button type="button" onclick="location.href='${pageType}/Update?PostID=${Notice.getPostID()}'">공지 수정</button>
			</span>
			<span>
				<button type="button" onclick="location.href='${pageType}/Delete?PostID=${Notice.getPostID()}'">공지 삭제</button>
			</span>
		</div>
		<div>
			<div>
				<h6>게시글 번호: ${Notice.getPostID()}</h6>
			</div>
			<div>
				<h6>작성자: ${Notice.getWriterID()}</h6>
			</div>
			<div>
				<h6>게시판 번호: ${Notice.getBoardID()}</h6>
			</div>
			<div>
				<h6>공지 제목: ${Notice.getTitle()}</h6>
			</div>
			<div>
				<h6>내용: ${Notice.getContent()}</h6>
			</div>
			<div>
				<h6>조회수: ${Notice.getPostViews()}</h6>
			</div>
			<div>
				<h6>좋아요: ${Notice.getGoodNumber()}</h6>
			</div>
			<div>
				<h6>작성 일자: ${Notice.getPostingDateStr()}</h6>
			</div>
		</div>
		<c:if test="Post.getFileName() != null">
			<h6>첨부파일:
				<a href="${viewPostVO.getFileURL()}" download>${viewPostVO.getFileName()}</a>
			</h6>
		</c:if>
	</main>
</body>
</html>