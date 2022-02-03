package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_SoldHistoryDTO {
	//SOLD_HISTORY_ID
	private int SoldHistoryID;
	private String AccountID;
	private String Address;
	private String RecieverName;
	private String RecieverPhone;
	private Date OrderDate;
	private int Status;
	//SOLD_DETAIL 관련
	private int SoldDetailID;
	private int ItemID;
	private int Amount;
	//ItemOption 관련
	private int ItemOptionID;//아이템 옵션을 어떻게 불러올까? join사용
	private String ItemSize;
	private String Color;
	//Refund 관련
	private int isRefund; //1이면 환불신청
	private Date RefundAskDate;
	private String RefundReason;//환불 사유에 따라 배송비는 누가 부담할지 결정하는 컬럼도 필요
	private int RefundStatus;//1: 환불 신청안함, 2: 환불확인중, 3:환불처리완료 (환불거절시 어떻게 표현?)
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

	public void setStatus(int status) {
		Status = status;
	}

	public int getSoldDetailID() {
		return SoldDetailID;
	}

	public void setSoldDetailID(int soldDetailID) {
		SoldDetailID = soldDetailID;
	}

	public int getItemID() {
		return ItemID;
	}

	public void setItemID(int itemID) {
		ItemID = itemID;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getItemOptionID() {
		return ItemOptionID;
	}

	public void setItemOptionID(int itemOptionID) {
		ItemOptionID = itemOptionID;
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
		return RefundReason;
	}

	public void setRefundReason(String refundReason) {
		RefundReason = refundReason;
	}

	public int getRefundStatus() {
		return RefundStatus;
	}

	public void setRefundStatus(int refundStatus) {
		RefundStatus = refundStatus;
	}

	public Date getRefundEndDate() {
		return RefundEndDate;
	}

	public String getRefundEndDateStr() {
		return form.format(RefundEndDate);
	}

	public void setRefundEndDate(Date refundEndDate) {
		RefundEndDate = refundEndDate;
	}
}
