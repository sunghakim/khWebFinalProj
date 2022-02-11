package com.web.mall.model;

import java.sql.Date;

public class ReportDTO {

	
	private int report_id;
	private int report_reason_id;
	private String reporter_id;
	private String account_id;
	private int reported_post_id;
	private Date reported_date;
	private String content;
	private int Result;
	private Date closed_date;
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	public int getReport_reason_id() {
		return report_reason_id;
	}
	public void setReport_reason_id(int report_reason_id) {
		this.report_reason_id = report_reason_id;
	}
	public String getReporter_id() {
		return reporter_id;
	}
	public void setReporter_id(String reporter_id) {
		this.reporter_id = reporter_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public int getReported_post_id() {
		return reported_post_id;
	}
	public void setReported_post_id(int reported_post_id) {
		this.reported_post_id = reported_post_id;
	}
	public Date getReported_date() {
		return reported_date;
	}
	public void setReported_date(Date reported_date) {
		this.reported_date = reported_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getResult() {
		return Result;
	}
	public void setResult(int result) {
		Result = result;
	}
	public Date getClosed_date() {
		return closed_date;
	}
	public void setClosed_date(Date closed_date) {
		this.closed_date = closed_date;
	}
	
	
}
