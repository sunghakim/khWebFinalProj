<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.web.mall.model.ShoppingListVO" %>
<%@page import="com.web.mall.model.ItemDTO" %>
<%@page import="com.web.mall.model.ItemOptionDTO" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart</title>
</head>
<body>
${error_msg}
	<% 
	List<ShoppingListVO> shoplist = (List<ShoppingListVO>)request.getAttribute("shoppingList");
	List<ItemDTO> itemlist = (List<ItemDTO>)request.getAttribute("itemList");
	List<ItemOptionDTO> itemOplist = (List<ItemOptionDTO>)request.getAttribute("itemOptionList");
	for(int i = 0; i < shoplist.size(); i++) { %>
		<div>
			shopping_list_id : <%= shoplist.get(i).getShopping_list_id() %>
		</div>
		<div>
			account_id : <%= shoplist.get(i).getAccount_id() %>
		</div>
		<div>
			item_id : <%= shoplist.get(i).getItem_id() %>
			<div>
				item name : <%= itemlist.get(i).getName() %>
			</div>
			<div>
				item content : <%= itemlist.get(i).getContent() %>
			</div>
		</div>
		<div>
			amount : <%= shoplist.get(i).getAmount() %>
			<input type="number" name="amount">
		</div>
		<div>
			item_option_id : <%= shoplist.get(i).getItem_option_id() %>
			<div>
				item_option_size : <%= itemOplist.get(i).getItem_size() %>
			</div>
			<div>
				item_option_color : <%= itemOplist.get(i).getColor() %>
			</div>
		</div>
		<button type="button" onclick="location.href='/updateCartItem?shopping_list_id=' + <%= shoplist.get(i).getShopping_list_id() %> + '&amount=100'">수정</button>
		<button type="button" onclick="location.href='/deleteCartItem?shopping_list_id=' + <%= shoplist.get(i).getShopping_list_id() %>">삭제</button>
		<hr>
		<% } %>
</body>
</html>