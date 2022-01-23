package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_PurchaseDTO {
	//SoldHistory
	private int SoldHistoryID;
	private String AccountID;
	private String Address;
	private String ReceiverName;
	private String ReceiverPhone;
	private Date OrderDate;
	private int Status;
	//SoldDetail
	private int SoldDetailID;
	private int ItemID;
	private int Amount;
	//Refund
	private int isRefund;
	private Date RefundAskDate;
	private String RefundReason;
	private int RefundStatus;
	private Date EndDate;
	//ItemOption
	private String ItemSize;
	private String Color;
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
	public String getReceiverName() {
		return ReceiverName;
	}
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	public String getReceiverPhone() {
		return ReceiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		ReceiverPhone = receiverPhone;
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
	public Date getEndDate() {
		return EndDate;
	}
	public String getEndDateStr() {
		return form.format(EndDate);
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
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
	@Override
	public String toString() {
		return "Manage_PurchaseDTO [SoldHistoryID=" + SoldHistoryID + ", AccountID=" + AccountID + ", Address="
				+ Address + ", ReceiverName=" + ReceiverName + ", ReceiverPhone=" + ReceiverPhone + ", OrderDate="
				+ OrderDate + ", Status=" + Status + ", SoldDetailID=" + SoldDetailID + ", ItemID=" + ItemID
				+ ", Amount=" + Amount + ", isRefund=" + isRefund + ", RefundAskDate=" + RefundAskDate
				+ ", RefundReason=" + RefundReason + ", RefundStatus=" + RefundStatus + ", EndDate=" + EndDate
				+ ", ItemSize=" + ItemSize + ", Color=" + Color + "]";
	}
	
}
