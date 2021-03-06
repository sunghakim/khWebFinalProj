package com.web.mall.model;

import java.sql.Date;

public class CommentsDTO {
	private int comment_id;
	private int post_id;
	private String writer_id;
	private Date posting;
	private String content;
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	
	public Date getPosting() {
		return posting;
	}
	public void setPosting(Date posting) {
		this.posting = posting;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
