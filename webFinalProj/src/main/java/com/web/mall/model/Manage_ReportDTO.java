package com.web.mall.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_ReportDTO {
	//Report
	private int ReportID;
	private String ReporterID;
	private String ReportedAccountID;
	private int ReportedPostID;
	private Date ReportedDate;
	private String Content;
	private int Result;
	private Date ClosedDate;
	//Report_Reason
	private int ReportReasonID;
	private String ReportReasonContent;
	//Punish
	private Date StartDate;
	private Date EndDate;
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd");
	public int getReportID() {
		return ReportID;
	}
	public void setReportID(int reportID) {
		ReportID = reportID;
	}
	public String getReporterID() {
		return ReporterID;
	}
	public void setReporterID(String reporterID) {
		ReporterID = reporterID;
	}
	public String getReportedAccountID() {
		return ReportedAccountID;
	}
	public void setReportedAccountID(String reportedAccountID) {
		ReportedAccountID = reportedAccountID;
	}
	public int getReportedPostID() {
		return ReportedPostID;
	}
	public void setReportedPostID(int reportedPostID) {
		ReportedPostID = reportedPostID;
	}
	public Date getReportedDate() {
		return ReportedDate;
	}
	public String getReportedDateStr() {
		return form.format(ReportedDate);
	}
	public void setReportedDate(Date reportedDate) {
		ReportedDate = reportedDate;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getResult() {
		return Result;
	}
	public void setResult(int result) {
		Result = result;
	}
	public Date getClosedDate() {
		return ClosedDate;
	}
	public String getClosedDateStr() {
		return form.format(ClosedDate);
	}
	public void setClosedDate(Date closedDate) {
		ClosedDate = closedDate;
	}
	public int getReportReasonID() {
		return ReportReasonID;
	}
	public void setReportReasonID(int reportReasonID) {
		ReportReasonID = reportReasonID;
	}
	public String getReportReasonContent() {
		return ReportReasonContent;
	}
	public void setReportReasonContent(String reportReasonContent) {
		ReportReasonContent = reportReasonContent;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public String getStartDateStr() {
		return form.format(StartDate);
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
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
	@Override
	public String toString() {
		return "Manage_ReportDTO [ReportID=" + ReportID + ", ReporterID=" + ReporterID + ", ReportedAccountID="
			+ ReportedAccountID + ", ReportedPostID=" + ReportedPostID + ", ReportedDate=" + ReportedDate
			+ ", Content=" + Content + ", Result=" + Result + ", ClosedDate=" + ClosedDate + ", ReportReasonID="
			+ ReportReasonID + ", ReportReasonContent=" + ReportReasonContent + ", StartDate=" + StartDate + ", EndDate=" + 
			EndDate + "]";
	}
}
