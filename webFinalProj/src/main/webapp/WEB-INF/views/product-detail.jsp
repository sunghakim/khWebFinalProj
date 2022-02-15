<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/resources/static/css/common.css">
    <link rel="stylesheet" href="/resources/static/css/admin-common.css">
    <link rel="stylesheet" href="/resources/static/css/product-detail.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>kh final product-list management</title>
    <!-- 상품 목록 확인 페이지 -->
</head>

<body>
    <div class="wrapper">
<header>
                <div class="header-wrap">
                    <h2 class="logo">logo</h2>
                    <div class="ul-wrap">
                    <ul class="header-ul" id="logout-ul">
                        	 <li id="logout">관리자 로그아웃</li>
                    </ul>
                    </div>
                </div>
            </header>
        <div class="content">
            <nav>
                <div class="nav-wrap">
                    <ul class="user-nav">
                        <li id="user-nav-1" class="click-color">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Shop</p>
                        </li>
                        <li id="user-nav-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Notice</p>
                        </li>
                        <li id="user-nav-3">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Outer</p>
                        </li>
                        <li id="user-nav-4">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Shirts</p>
                        </li>
                        <li id="user-nav-5">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Jeans</p>
                        </li>
                        <li id="user-nav-6">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Accessary</p>
                        </li>
                        <li id="user-nav-7">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>Community</p>
                        </li>
                    </ul>
                    <ul class="admin-nav">
                        <li id="admin-nav-1">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>회원 관리</p>
                        </li>
                        <li id="admin-nav-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>신고 관리</p>
                        </li>
                        <li id="admin-nav-3" class="click-color">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>사이트 관리</p>
                        </li>
                    </ul>
                    <ul class="admin-nav-sub">
                        <li id="sub-1">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>상품 관리</p>
                        </li>
                        <li id="sub-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>카테고리 관리</p>
                        </li>
                        <li id="sub-3">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>통계 확인</p>
                        </li>
                        <li id="sub-4">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>쿠폰 목록</p>
                        </li>
                        <li id="sub-5">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>개인 문의</p>
                        </li>
                        <li id="sub-6">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>환불 관리</p>
                        </li>
                        <li id="sub-7">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>공지 관리</p>
                        </li>
                    </ul>
                </div>
            </nav>
                        <section>
                <div class="article-container">
             
                    <div class="article-wrap">
                        <article class="img-group">
                       <%-- <c:if test="${status eq 'status'}"> --%>
		                       <c:choose>
		                       		<c:when test="${status eq 'status'}">
		                            	<img class="img" id="img"></img>
		                            </c:when>
		                            
		                            <c:otherwise>
		                            	<c:choose>
		                            		<c:when test="${imgList ne null }">
		                            			<!-- 수정시 이미지 저장 위치 파악 필요 -->
		                            		</c:when>
		                            		
		                            		<c:otherwise>
		                            			<img class="img" id="img"></img>
		                            		</c:otherwise>
		                            	</c:choose>
		                            </c:otherwise>
		                       </c:choose>
                       <%-- </c:if> --%>
                            <div class="img-btns">
                                <button class="btn submit" id="inputShow">이미지 등록</button>
                                <button class="btn remove" id="inputDelete">이미지 삭제</button>
                            </div>
                            <c:if test="${status eq 'insert'}">
									<form action="${pageType}/Insert" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
							</c:if>
							<c:if test="${status eq 'update'}">
									<form action="${pageType}/Update" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
									<input type="hidden" name="ItemID" value="${Item.getItemID()}" required>
									<input type="hidden" name="ItemOptionID" value="${Item.getItemOptionID()}" required>
							</c:if>
                            <%-- <form action="${pageType}/Insert" method="post" enctype="multipart/form-data" accept-charset="UTF-8"> --%>
                        </article>
                       		<input style="display: none;" type="file" name="file" id="file" class="file">
	                        <article class="product-content">
	                            <div class="title">
	                                <span>이름</span>
	                                <input type="text" name="Name" value="${Item.getName()}" required>
	                            </div>
	                            <div class="price">
	                                <span>가격</span>
	                                <input type="number" name="Price" value="${Item.getPrice()}" required>
	                            </div>
	                            <div class="size">
	                                <span>사이즈</span>
	                                <c:choose>
	                                	<c:when test="${Item.getItemSize() eq 'S'}">
		                                	<input checked="checked" type="radio" name="ItemSize" value="S" class="size-radio" id="size-s"><label for="size-s">S</label>
		                                	<input type="radio" name="ItemSize" value="M" class="size-radio" id="size-m"><label for="size-m">M</label>
		                                	<input type="radio" name="ItemSize" value="L" class="size-radio" id="size-l"><label for="size-l">L</label>
		                            	</c:when>
			                            <c:when test="${Item.getItemSize() eq 'M'}">
			                                <input type="radio" name="ItemSize" value="S" class="size-radio" id="size-s"><label for="size-s">S</label>
			                                <input checked="checked" type="radio" name="ItemSize" value="M" class="size-radio" id="size-m"><label for="size-m">M</label>
			                                <input type="radio" name="ItemSize" value="L" class="size-radio" id="size-l"><label for="size-l">L</label>
			                            </c:when>
			                            <c:when test="${Item.getItemSize() eq 'L'}">
			                                <input type="radio" name="ItemSize" value="S" class="size-radio" id="size-s"><label for="size-s">S</label>
			                                <input type="radio" name="ItemSize" value="M" class="size-radio" id="size-m"><label for="size-m">M</label>
			                                <input checked="checked" type="radio" name="ItemSize" value="L" class="size-radio" id="size-l"><label for="size-l">L</label>
			                            </c:when>
			                            <c:otherwise>
			                            	<input type="radio" name="ItemSize" value="S" class="size-radio" id="size-s"><label for="size-s">S</label>
			                                <input type="radio" name="ItemSize" value="M" class="size-radio" id="size-m"><label for="size-m">M</label>
			                                <input type="radio" name="ItemSize" value="L" class="size-radio" id="size-l"><label for="size-l">L</label>
			                            </c:otherwise>
	                                </c:choose>
	                            </div>
	                            <div class="color">
	                                <span>색깔</span>
	     							<c:choose>
	                                	<c:when test="${Item.getColor() eq 'red'}">
		                                	<input checked="checked" type="radio" name="Color" value="red" class="color-radio" id="color-red"><label for="color-red">빨</label>
		                                	<input type="radio" name="Color" value="orange" class="color-radio" id="color-or"><label for="color-or">주</label>
		                                	<input type="radio" name="Color" value="yellow" class="color-radio" id="color-ye"><label for="color-ye">노</label>
		                            	</c:when>
			                            <c:when test="${Item.getColor() eq 'orange'}">
			                                <input type="radio" name="Color" value="red" class="color-radio" id="color-red"><label for="color-red">빨</label>
		                                	<input checked="checked" type="radio" name="Color" value="orange" class="color-radio" id="color-or"><label for="color-or">주</label>
		                                	<input type="radio" name="Color" value="yellow" class="color-radio" id="color-ye"><label for="color-ye">노</label>
			                            </c:when>
			                            <c:when test="${Item.getColor() eq 'yellow'}">
			                                <input type="radio" name="Color" value="red" class="color-radio" id="color-red"><label for="color-red">빨</label>
		                                	<input type="radio" name="Color" value="orange" class="color-radio" id="color-or"><label for="color-or">주</label>
		                                	<input checked="checked" type="radio" name="Color" value="yellow" class="color-radio" id="color-ye"><label for="color-ye">노</label>
			                            </c:when>
			                            <c:otherwise>
			                            	<input type="radio" name="Color" value="red" class="color-radio" id="color-red"><label for="color-red">빨</label>
		                                	<input type="radio" name="Color" value="orange" class="color-radio" id="color-or"><label for="color-or">주</label>
		                                	<input type="radio" name="Color" value="yellow" class="color-radio" id="color-ye"><label for="color-ye">노</label>
			                            	</c:otherwise>
	                                </c:choose>
	                            </div>
	                            <div class="amount">
	                                <span>수량</span>
	                                <input name="Amount" type="number" value="${Item.getAmount()}" required>
	                            </div>
	                            <div class="category">
									<span>카테고리</span>
									<select id="CategoryList" name="ItemCategoryID" required>
										<c:forEach var="List" items="${ItemCategoryList}">
											<c:if test="${List.getItemCategoryName() eq Item.getItemCategoryName()}">
												<option value="${List.getItemCategoryID()}" selected>${List.getItemCategoryName()}</option>
											</c:if>
											<c:if test="${List.getItemCategoryName() ne Item.getItemCategoryName()}">
												<option value="${List.getItemCategoryID()}">${List.getItemCategoryName()}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
	                            <div class="segment">
	                                <div>상세 설명</div>
	                                <textarea rows="10" name="Content" required>${Item.getContent()}</textarea>
	                            </div>
	                        </article>
                       
                    </div>
                </div>
	                        <div class="btns">
		                        <button type="submit" class="btn regist" id="ok">등록</button>
		                        <button class="btn cancel" id="no">등록 취소</button>
                    		</div>
                    		</form>
            </section>
        </div>
    </div>
    <script src="/resources/static/js/common.js"></script>
    <script src="/resources/static/js/product-detail.js"></script>
</body>

</html>