package com.web.mall.model;

import java.sql.Date;

public class ReviewVO {
	private int review_id;
	private int item_id;
	private String writer_id;
	private Date post_date;
	private String content;
	private int score;
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
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
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ReviewVO [review_id=" + review_id + ", item_id=" + item_id + ", writer_id=" + writer_id + ", post_date="
				+ post_date + ", content=" + content + ", score=" + score + "]";
	}
	
	
}
