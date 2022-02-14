<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.web.mall.model.ZzimListVO" %>
<%@page import="com.web.mall.model.ItemDTO" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zzim</title>
</head>
<body>
	${error_msg}
	<% 
	List<ZzimListVO> zzimlist = (List<ZzimListVO>)request.getAttribute("zzimList");
	List<ItemDTO> itemlist = (List<ItemDTO>)request.getAttribute("itemList");
	for(int i = 0; i < zzimlist.size(); i++) { %>
		<div>
			zzim_list_id : <%= zzimlist.get(i).getZzim_list_id() %>
		</div>
		<div>
			account_id : <%= zzimlist.get(i).getAccount_id() %>
		</div>
		<div>
			item_id : <%= zzimlist.get(i).getItem_id() %>
			<div>
				item name : <%= itemlist.get(i).getName() %>
			</div>
			<div>
				item content : <%= itemlist.get(i).getContent() %>
			</div>
		</div>
		<button type="button" onclick="location.href='/deleteZzimItem?zzim_list_id=' + <%= zzimlist.get(i).getZzim_list_id() %>">삭제</button>
		<hr>
		<% } %>
</body>
</html>