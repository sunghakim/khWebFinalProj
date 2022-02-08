package com.web.mall.model;

import java.sql.Date;

public class ReportVO {
	private int report_id;
	private int report_reason_id;
	private String reporter_id;
	private String reported_account_id;
	private int reported_post_id;
	private Date reported_date;
	private String content;
	private int result;
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
	public String getReported_account_id() {
		return reported_account_id;
	}
	public void setReported_account_id(String reported_account_id) {
		this.reported_account_id = reported_account_id;
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
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Date getClosed_date() {
		return closed_date;
	}
	public void setClosed_date(Date closed_date) {
		this.closed_date = closed_date;
	}
	@Override
	public String toString() {
		return "ReportVO [report_id=" + report_id + ", report_reason_id=" + report_reason_id + ", reporter_id="
				+ reporter_id + ", reported_account_id=" + reported_account_id + ", reported_post_id="
				+ reported_post_id + ", reported_date=" + reported_date + ", content=" + content + ", result=" + result
				+ ", closed_date=" + closed_date + "]";
	}
	
	
}
