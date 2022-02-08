package com.web.mall.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_NoticeDTO {
//POST DTO와 동일함, 통합필요, 임시DTO
	private int PostID;
	private int WriterID;
	private int BoardID = 0;
	private String Title;
	private String Content;
	private int PostViews;
	private int GoodNumber;
	private Date PostingDate;
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd");
	
	public int getPostID() {
		return PostID;
	}
	public void setPostID(int postID) {
		PostID = postID;
	}
	public int getWriterID() {
		return WriterID;
	}
	public void setWriterID(int writerID) {
		WriterID = writerID;
	}
	public int getBoardID() {
		return BoardID;
	}
	public void setBoardID(int boardID) {
		BoardID = boardID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getPostViews() {
		return PostViews;
	}
	public void setPostViews(int postViews) {
		PostViews = postViews;
	}
	public int getGoodNumber() {
		return GoodNumber;
	}
	public void setGoodNumber(int goodNumber) {
		GoodNumber = goodNumber;
	}
	public Date getPostingDate() {
		return PostingDate;
	}
	public String getPostingDateStr() {
		return form.format(PostingDate);
	}
	public void setPostingDate(Date postingDate) {
		PostingDate = postingDate;
	}
	@Override
	public String toString() {
		return "Manage_NoticeDTO [PostID=" + PostID + ", WriterID=" + WriterID + ", BoardID=" + BoardID + ", Title="
				+ Title + ", Content=" + Content + ", PostViews=" + PostViews + ", GoodNumber=" + GoodNumber
				+ ", PostingDate=" + PostingDate + "]";
	}
}
