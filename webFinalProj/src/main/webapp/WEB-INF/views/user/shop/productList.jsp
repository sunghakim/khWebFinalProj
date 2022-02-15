<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>

    <link type="text/css" rel="stylesheet" href="/resources/static/css/user/shop/productList.css">
    <title>Document</title>
</head>
<body class="body">
    <div class="menuLine">
        <ul id="listMenu" class="listMenu">
            <li class="button here">BEST</li>
        </ul>
    </div>

    <div id="best" style="display: none;">
        <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="2000">
                    <div class="flex-colum">
                        <div class="best-title">
                            <label>LIKE  <i class="fa-solid fa-heart"></i></label>
                        </div>
                        <div class="like-section">
                            <div class="img-frame">
                                <div class="best-item">
                                    <img class="best-img" src="/resources/static/img/sample.png" alt="...">
                                    <div class="best-btn"><i class="fa-regular fa-heart fa-xl"></i></div>
                                    <div class="best-text">
                                        상품명<br>가격
                                    </div>
                                </div>
                            </div>
                            <div class="img-frame">
                                <div class="best-item">
                                    <img class="best-img" src="/resources/static/img/sample.png" alt="...">
                                    <div class="best-btn"><i class="fa-solid fa-heart fa-xl"></i></div>
                                    <div class="best-text">
                                        상품명<br>가격
                                    </div>
                                </div>
                            </div>
                            <div class="img-frame">
                                <div class="best-item">
                                    <img class="best-img" src="/resources/static/img/sample.png" alt="...">
                                    <div class="best-btn"><i class="fa-solid fa-heart fa-xl"></i></div>
                                    <div class="best-text">
                                        상품명<br>가격
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="flex-colum">
                        <div class="best-title">
                            <label>REVIEW  <i class="fa-solid fa-thumbs-up"></i></label>
                        </div>
                        <div class="review-section">
                            <div class="img-frame">
                                <div class="best-item">
                                    <img class="best-img" src="/resources/static/img/sample.png" alt="...">
                                    <div class="best-btn"><i class="fa-solid fa-heart fa-xl"></i></div>
                                    <div class="best-text">
                                        상품명<br>가격
                                    </div>
                                </div>
                            </div>
                            <div class="img-frame">
                                <div class="best-item">
                                    <img class="best-img" src="/resources/static/img/sample.png" alt="...">
                                    <div class="best-btn"><i class="fa-regular fa-heart fa-xl"></i></div>
                                    <div class="best-text">
                                        상품명<br>가격
                                    </div>
                                </div>
                            </div>
                            <div class="img-frame">
                                <div class="best-item">
                                    <img class="best-img" src="/resources/static/img/sample.png" alt="...">
                                    <div class="best-btn"><i class="fa-regular fa-heart fa-xl"></i></div>
                                    <div class="best-text">
                                        상품명<br>가격
                                    </div>
                                </div>
                            </div>
                        </div>
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
    </div>

    <div id="listContext" style="display: none;">
        
        <div class="productList">
        	<c:forEach var="i" items="${datas}">
	            <div class="product-item">
	                <img class="product-img" src="${i.getFile_url()}" alt="${i.getFile_name()}">
	                <div class="product-btn"><i class="fa-solid fa-heart"></i></div>
	                <div class="product-text">${i.getName()}<br><fmt:formatNumber value="${i.getPrice()}" pattern="#,###" /></div>
	                <input type="text" value="${i.getItem_id()}" hidden/>
	            </div>   		
        	</c:forEach>
        </div>
        <div>
            <ul>
                <li class="page">페이징 어떻게 되려나</li>
            </ul>
        </div>
    </div>
    <script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="/resources/static/js/user/shop/productList.js"></script>
</body>
</html>