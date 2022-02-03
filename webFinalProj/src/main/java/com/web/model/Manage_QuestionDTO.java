package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_QuestionDTO {
	private String QuestionID;
	private int ItemID;
	private String WriterID;
	private String QuestionTitle;
	private String QuestionContent;
	private Date QuestionDate;
	private int Result;
	private String AnswerTitle;
	private String AnswerContent;
	private Date AnswerDate;
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd");
	
	public String getQuestionID() {
		return QuestionID;
	}
	public void setQuestionID(String questionID) {
		QuestionID = questionID;
	}
	public int getItemID() {
		return ItemID;
	}
	public void setItemID(int itemID) {
		ItemID = itemID;
	}
	public String getWriterID() {
		return WriterID;
	}
	public void setWriterID(String writerID) {
		WriterID = writerID;
	}
	public String getQuestionTitle() {
		return QuestionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		QuestionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return QuestionContent;
	}
	public void setQuestionContent(String questionContent) {
		QuestionContent = questionContent;
	}
	public Date getQuestionDate() {
		return QuestionDate;
	}
	public String getQuestionDateStr() {
		return form.format(QuestionDate);
	}
	public void setQuestionDate(Date questionDate) {
		QuestionDate = questionDate;
	}
	public int getResult() {
		return Result;
	}
	public void setResult(int result) {
		Result = result;
	}
	public String getAnswerTitle() {
		return AnswerTitle;
	}
	public void setAnswerTitle(String answerTitle) {
		AnswerTitle = answerTitle;
	}
	public String getAnswerContent() {
		return AnswerContent;
	}
	public void setAnswerContent(String answerContent) {
		AnswerContent = answerContent;
	}
	public Date getAnswerDate() {
		return AnswerDate;
	}
	public String getAnswerDateStr() {
		return form.format(AnswerDate);
	}
	public void setAnswerDate(Date answerDate) {
		AnswerDate = answerDate;
	}
	@Override
	public String toString() {
		return "Manage_QuestionDTO [QuestionID=" + QuestionID + ", ItemID=" + ItemID + ", WriterID=" + WriterID
				+ ", QuestionTitle=" + QuestionTitle + ", QuestionContent=" + QuestionContent + ", QuestionDate="
				+ QuestionDate + ", Result=" + Result + ", AnswerTitle=" + AnswerTitle + ", AnswerContent="
				+ AnswerContent + ", AnswerDate=" + AnswerDate + "]";
	}
}
