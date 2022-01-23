package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_ReportDTO {
	private int ID;
	private int ReportReasonID;
	private String ReporterID;
	private int ReportedPostID;
	private Date ReportDate;
	private String Content;
	private int Result;
	private Date ClosedDate;
	
	//PUNISH테이블에 있는 내용입니다(조인문으로 불러오기)
	private Date StartDate;
	private Date EndDate;
	
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd");
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getReportReasonID() {
		return ReportReasonID;
	}
	public void setReportReasonID(int reportReasonID) {
		ReportReasonID = reportReasonID;
	}
	public String getReporterID() {
		return ReporterID;
	}
	public void setReporterID(String reporterID) {
		ReporterID = reporterID;
	}
	public int getReportedPostID() {
		return ReportedPostID;
	}
	public void setReportedPostID(int reportedPostID) {
		ReportedPostID = reportedPostID;
	}
	public Date getReportedPostDate() {
		return ReportedPostDate;
	}
	public String getReportedPostDateStr() {
		return form.format(ReportedPostDate);
	}
	public void setReportedPostDate(Date reportedPostDate) {
		ReportedPostDate = reportedPostDate;
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
	@Override
	public String toString() {
		return "Manage_ReportDTO [ID=" + ID + ", ReportReasonID=" + ReportReasonID + ", ReporterID=" + ReporterID
				+ ", ReportedPostID=" + ReportedPostID + ", ReportedPostDate=" + ReportedPostDate + ", Content="
				+ Content + ", Result=" + Result + ", ClosedDate=" + ClosedDate + "]";
	}
}
