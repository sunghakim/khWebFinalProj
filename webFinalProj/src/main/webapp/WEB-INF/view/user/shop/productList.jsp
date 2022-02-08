<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/static/js/common.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="/static/css/productList.css">
    <title>Document</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	// 이미지 클릭
	$('.img').click(function() {
	    $.ajax({
	        type : "GET",
	        url : "/shop/detail.jsp",
	        dataType : "html",
	        error : function(){
	            alert("통신실패!!!!");
	        },
	        success : function(Parse_data){
	            $(".article-wrap").html(Parse_data);
	            alert(Parse_data);
	        }
	         
	    });
	});

});
</script>
    <div class="menuLine">
        <ul id="listMenu" class="listMenu">
            <li>BEST</li>
            <li>티셔츠</li>
            <li>셔츠/블라우스</li>
        </ul>
    </div>
    <div class="listContext">
	     <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
		  <div class="carousel-indicators">
		    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
		    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
		  </div>
		  <div class="carousel-inner">
		    <div class="carousel-item active" data-bs-interval="10000">
		      <img src="/static/img/QR.PNG" class="d-block w-100" alt="...">
		      <div class="carousel-caption d-none d-md-block">
		        <h5>LIKE~1번</h5>
		        <p>상품명 + 가격</p>
		      </div>
		    </div>
		    <div class="carousel-item" data-bs-interval="2000">
		      <img src="/static/img/QR.PNG" class="d-block w-100" alt="...">
		      <div class="carousel-caption d-none d-md-block">
		        <h5>LIKE~2번</h5>
		        <p>상품명 + 가격</p>
		      </div>
		    </div>
		    <div class="carousel-item">
		      <img src="/static/img/QR.PNG" class="d-block w-100" alt="...">
		      <div class="carousel-caption d-none d-md-block">
		        <h5>LIKE~3번</h5>
		        <p>상품명 + 가격</p>
		      </div>
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  </button>
		</div>
        
        <div class="productList">
            <div class="product">
            	<div class="img">
  					<img src="/static/img/sample.png" alt="...">
  				</div>
  				<div>
  					<label>상품명</label>
  					<label>가격</label>
				</div>
			</div>
			
			<div class="product">
            	<div class="img">
  					<img src="/static/img/sample.png" alt="...">
  				</div>
  				<div>
  					<label>상품명</label>
  					<label>가격</label>
				</div>
			</div>
			
			<div class="product">
            	<div class="img">
  					<img src="/static/img/sample.png" alt="...">
  				</div>
  				<div>
  					<label>상품명</label>
  					<label>가격</label>
				</div>
			</div>
			
			<div class="product">
            	<div class="img">
  					<img src="/static/img/sample.png" alt="...">
  				</div>
  				<div>
  					<label>상품명</label>
  					<label>가격</label>
				</div>
			</div>
			
			<div class="product">
            	<div class="img">
  					<img src="/static/img/sample.png" alt="...">
  				</div>
  				<div>
  					<label>상품명</label>
  					<label>가격</label>
				</div>
			</div>
			
			<div class="product">
            	<div class="img">
  					<img src="/static/img/sample.png" alt="...">
  				</div>
  				<div>
  					<label>상품명</label>
  					<label>가격</label>
				</div>
			</div>
        </div>
        <div>
            페이징
        </div>
    </div>
</body>
</html>