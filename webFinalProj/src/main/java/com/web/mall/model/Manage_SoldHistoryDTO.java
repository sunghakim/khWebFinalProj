package com.web.mall.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_SoldHistoryDTO {
	//Manage_RefundDTO, Manage_StatisticsDTO 역할을 같이한다.
	
	//SOLD_HISTORY
	private int SoldHistoryID;
	private String AccountID;
	private String Address;
	private String RecieverName;
	private String RecieverPhone;
	private Date OrderDate;
	private int Status;
	//SOLD_DETAIL 관련
	private int SoldDetailID;
	private int Amount;
	//ITEM 관련
	private String Name;
	private int Price;
	//ITEM_OPTION 관련
	private String ItemSize;
	private String Color;
	//SOLD_HISTORY(Refund) 관련
	private int isRefund;
	private Date RefundAskDate;
	private String RefundReason;
	private int RefundStatus;
	private Date RefundEndDate;
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd");
	
	public int getSoldHistoryID() {
		return SoldHistoryID;
	}
	public void setSoldHistoryID(int soldHistoryID) {
		SoldHistoryID = soldHistoryID;
	}
	public String getAccountID() {
		return AccountID;
	}
	public void setAccountID(String accountID) {
		AccountID = accountID;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getRecieverName() {
		return RecieverName;
	}
	public void setRecieverName(String recieverName) {
		RecieverName = recieverName;
	}
	public String getRecieverPhone() {
		return RecieverPhone;
	}
	public void setRecieverPhone(String recieverPhone) {
		RecieverPhone = recieverPhone;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public String getOrderDateStr() {
		return form.format(OrderDate);
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public int getStatus() {
		return Status;
	}
	public String getStatusStr() {
		switch(Status) {
		case(0):
			return "배송준비중";
		case(1):
			return "배송중";
		case(2):
			return "배송완료";
		default:
			return "에러";
		}
	}
	public void setStatus(int status) {
		Status = status;
	}

	public int getSoldDetailID() {
		return SoldDetailID;
	}
	public void setSoldDetailID(int soldDetailID) {
		SoldDetailID = soldDetailID;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getItemSize() {
		return ItemSize;
	}
	public void setItemSize(String itemSize) {
		ItemSize = itemSize;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getIsRefund() {
		return isRefund;
	}
	public String getIsRefundStr() {
		switch(isRefund) {
		case(1):
			return "환불신청안함";
		case(2):
			return "환불신청함";
		default:
			return "에러";
		}
	}
	
	public void setIsRefund(int isRefund) {
		this.isRefund = isRefund;
	}
	public Date getRefundAskDate() {
		return RefundAskDate;
	}
	public String getRefundAskDateStr() {
		return form.format(RefundAskDate);
	}
	public void setRefundAskDate(Date refundAskDate) {
		RefundAskDate = refundAskDate;
	}
	public String getRefundReason() {
		if (RefundReason == null) {
			return "에러";
		}
		return RefundReason;
	}
	public void setRefundReason(String refundReason) {
		RefundReason = refundReason;
	}
	public int getRefundStatus() {
		return RefundStatus;
	}
	public String getRefundStatusStr() {
		switch(RefundStatus) {
		case(1):
			return "환불신청안함";
		case(2):
			return "환불 검토중";
		case(3):
			return "환불 처리(단순변심)";
		case(4):
			return "환불 처리(물건파손)";
		case(5):
			return "상품 교환";
		case(6):
			return "환불 거부";
		default:
			return "에러";
		}
	}
	public void setRefundStatus(int refundStatus) {
		RefundStatus = refundStatus;
	}
	public Date getRefundEndDate() {
		return RefundEndDate;
	}
	public String getRefundEndDateStr() {
		if (RefundEndDate == null) {
			return "환불 검토중";
		}
		return form.format(RefundEndDate);
	}
	public void setRefundEndDate(Date refundEndDate) {
		RefundEndDate = refundEndDate;
	}
	@Override
	public String toString() {
		return "Manage_SoldHistoryDTO [SoldHistoryID=" + SoldHistoryID + ", AccountID=" + AccountID + ", Address="
			+ Address + ", RecieverName=" + RecieverName + ", RecieverPhone=" + RecieverPhone + ", OrderDate="
			+ OrderDate + ", Status=" + Status + ", SoldDetailID=" + SoldDetailID + ", Amount=" + Amount
			+ ", Name=" + Name + ", Price=" + Price + ", ItemSize=" + ItemSize + ", Color=" + Color
			+ ", isRefund=" + isRefund + ", RefundAskDate=" + RefundAskDate + ", RefundReason=" + RefundReason
			+ ", RefundStatus="	+ RefundStatus + ", RefundEndDate=" + RefundEndDate + "]";
	}
}
