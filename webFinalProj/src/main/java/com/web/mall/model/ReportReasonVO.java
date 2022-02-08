package com.web.mall.model;

public class ReportReasonVO {
	private int report_reason_id;
	private String content;
	public int getReport_reason_id() {
		return report_reason_id;
	}
	public void setReport_reason_id(int report_reason_id) {
		this.report_reason_id = report_reason_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ReportReasonVO [report_reason_id=" + report_reason_id + ", content=" + content + "]";
	}
	
}
