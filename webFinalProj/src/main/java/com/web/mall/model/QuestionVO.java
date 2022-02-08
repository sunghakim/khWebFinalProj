package com.web.mall.model;

import java.sql.Date;

public class QuestionVO {
	private int question_id;
	private int item_id;
	private String writer_id;
	private String question_title;
	private String question_content;
	private Date question_date;
	private int result;
	private String answer_title;
	private String answer_content;
	private Date answer_date;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public Date getQuestion_date() {
		return question_date;
	}
	public void setQuestion_date(Date question_date) {
		this.question_date = question_date;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getAnswer_title() {
		return answer_title;
	}
	public void setAnswer_title(String answer_title) {
		this.answer_title = answer_title;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public Date getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}
	@Override
	public String toString() {
		return "QuestionVO [question_id=" + question_id + ", item_id=" + item_id + ", writer_id=" + writer_id
				+ ", question_title=" + question_title + ", question_content=" + question_content + ", question_date="
				+ question_date + ", result=" + result + ", answer_title=" + answer_title + ", answer_content="
				+ answer_content + ", answer_date=" + answer_date + "]";
	}
	
}
