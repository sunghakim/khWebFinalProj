<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.web.mall.model.GiveCouponVO" %>
<%@page import="com.web.mall.model.CouponVO" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>coupon</title>
</head>
<body>
	${error_msg}
	<% 
	List<GiveCouponVO> givenCouponList = (List<GiveCouponVO>)request.getAttribute("couponList");
	List<CouponVO> couponList = (List<CouponVO>)request.getAttribute("couponInfo");
	for(int i = 0; i < givenCouponList.size(); i++) { %>
		<div>
			give_coupon_id : <%= givenCouponList.get(i).getGive_coupon_id() %>
		</div>
		<div>
			account_id : <%= givenCouponList.get(i).getAccount_id() %>
		</div>
		<div>
			coupon_id : <%= givenCouponList.get(i).getCoupon_id() %>
			<div>
				coupon name : <%= couponList.get(i).getName() %>
			</div>
			<div>
				start date : <%= couponList.get(i).getStart_date() %>
			</div>
			<div>
				end date : <%= couponList.get(i).getEnd_date() %>
			</div>
			<div>
				discount : <%= couponList.get(i).getDiscount() %>%
			</div>
		</div>
		<hr>
		<% } %>
</body>
</html>