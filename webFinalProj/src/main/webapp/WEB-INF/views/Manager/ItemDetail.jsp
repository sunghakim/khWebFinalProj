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
    <!-- ��ǰ ��� Ȯ�� ������ -->
</head>

<body>
    <div class="wrapper">
<header>
                <div class="header-wrap">
                    <h2 class="logo">logo</h2>
                    <div class="ul-wrap">
                    <ul class="header-ul" id="logout-ul">
                            <li id="logout">������ �α׾ƿ�</li>
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
                            <p>ȸ�� ����</p>
                        </li>
                        <li id="admin-nav-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>�Ű� ����</p>
                        </li>
                        <li id="admin-nav-3" class="click-color">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;</div>
                            <p>����Ʈ ����</p>
                        </li>
                    </ul>
                    <ul class="admin-nav-sub">
                        <li id="sub-1">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>��ǰ ����</p>
                        </li>
                        <li id="sub-2">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>ī�װ� ����</p>
                        </li>
                        <li id="sub-3">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>��� Ȯ��</p>
                        </li>
                        <li id="sub-4">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>���� ���</p>
                        </li>
                        <li id="sub-5">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>���� ����</p>
                        </li>
                        <li id="sub-6">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>ȯ�� ����</p>
                        </li>
                        <li id="sub-7">
                            <div class="icon">&nbsp;&nbsp;<i class="fas fa-chevron-circle-right"></i>&nbsp;
                            </div>
                            <p>���� ����</p>
                        </li>
                    </ul>
                </div>
            </nav>
			<section>
            	<div class="article-container">
                	<div class="btns">
                	<c:if test="${status eq 'update'}">
                    	<button type="submit" class="btn regist" id="ok" form="item-submit">���</button>
                  		<button class="btn cancel" id="no">��� ���</button>
                  	</c:if>
                  	<c:if test="${status eq 'insert'}">
                    	<button type="submit" class="btn regist" id="ok" form="item-submit">���</button>
                  		<button class="btn cancel" id="no">��� ���</button>
                  	</c:if>
                  	<c:if test="${status eq 'detail'}">
                    	<button class="btn cancel" id="no">�������</button>
                  	</c:if>
               		</div>
               		<c:if test="${status eq 'insert'}">
                           <form id="item-submit" action="/Manager/Item/Insert" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                     </c:if>
                     <c:if test="${status eq 'update'}">
                           <form id="item-submit" action="/Manager/Item/Update" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
                           <input type="hidden" name="ItemID" value="${Item.getItemID()}" required>
                           <input type="hidden" name="ItemOptionID" value="${Item.getItemOptionID()}" required>
                     </c:if>
                    <div class="article-wrap">
                        <article class="img-group">
                     		<c:if test="${Image eq null}">
								<img class="img" id="img"></img>
							</c:if>
							<c:if test="${Image ne null}">
								<img class="img" id="img" src="${Image.getDownloadPath()}"></img>
								<input type="hidden" name="deleteImages" value="${Image.getImageIDtoInt()}"/>
							</c:if>
                            <div class="img-btns">
                            	<c:if test="${status eq 'update'}">
                    				<button class="btn submit" id="inputShow">�̹��� ����</button>
                  				</c:if>
                  				<c:if test="${status eq 'insert'}">
                    				<button class="btn submit" id="inputShow">�̹��� �߰�</button>
                  				</c:if>
                                <!--button class="btn remove" id="inputDelete">�̹��� ����</button-->
                            </div>
                        </article>
							<input style="display: none;" type="file" name="uploadImages" id="file" class="file" accept=".bmp, .gif, .jpg, .jpeg, .png" >
								<article class="product-content">
									<div class="title">
										<span class="headpart">�̸�</span>
										<c:if test="${status eq 'detail'}">
											<span class="bodypart">${Item.getName()}</span>
										</c:if>
										<c:if test="${status ne 'detail'}">
											<input type="text" name="Name" value="${Item.getName()}" required>
										</c:if>
									</div>
								<div class="price">
									<span class="headpart">����</span>
									<c:if test="${status eq 'detail'}">
										<span class="bodypart">${Item.getPrice()}</span>
									</c:if>
									<c:if test="${status ne 'detail'}">
										<input type="number" name="Price" value="${Item.getPrice()}" required>
									</c:if>
								</div>
                               <div class="size">
                                   <span class="headpart">������</span>
                                   <c:if test="${status eq 'detail'}">
                                      <span class="bodypart">${Item.getItemSize()}</span>
                                   </c:if>
                                   <c:if test="${status ne 'detail'}">
                                      <input type="text" name="ItemSize" value="${Item.getItemSize()}" required>
                                     </c:if>
                               </div>
                               <div class="color">
                                   <span class="headpart">����</span>
                                   <c:if test="${status eq 'detail'}">
                                      <span class="bodypart">${Item.getColor()}</span>
                                   </c:if>
                                   <c:if test="${status ne 'detail'}">
                                      <input type="text" name="Color" value="${Item.getColor()}" required>
                                   </c:if>
                               </div>
                               <div class="amount">
                                   <span class="headpart">����</span>
                                   <c:if test="${status eq 'detail'}">
                                      <span class="bodypart">${Item.getAmount()}</span>
                                   </c:if>
                                   <c:if test="${status ne 'detail'}">
                                      <input name="Amount" type="number" value="${Item.getAmount()}" required>
                                   </c:if>
                               </div>
                               <div class="category">
                           <span class="headpart">ī�װ�</span>
                                   <c:if test="${status eq 'detail'}">
                                      <span class="bodypart">${Item.getItemCategoryName()}</span>
                                   </c:if>
                           <c:if test="${status ne 'detail'}">
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
                           </c:if>
                        </div>
							<div class="segment">
								<span class="headpart">�� ����</span>
								<br>
									<c:if test="${status eq 'detail'}">
										<span class="bodypart">${Item.getContent()}</span>
									</c:if>
									<c:if test="${status eq 'update'}">
										<textarea rows="10" name="Content" required>${Item.getContent()}</textarea>
										<input type="hidden" name="ReferencesID" value="${Notice.getPostID()}">
									</c:if>
									<c:if test="${status eq 'insert'}">
										<textarea rows="10" name="Content" required>${Item.getContent()}</textarea>
									</c:if>
                               </div>
									<input type="hidden" name="IDType" value="ITEM">
                           </article>
                         </form>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <script src="/resources/static/js/common.js"></script>
    <script src="/resources/static/js/product-detail.js"></script>
</body>

</html>