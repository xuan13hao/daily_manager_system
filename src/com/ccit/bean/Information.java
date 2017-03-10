package com.ccit.bean;

import java.sql.Date;

public class Information {
private int id;
private int userId;
private String startTime;
private String endTime;
private String content;
private Date dateTime;
private int isChecked;



public Information(int userId, String startTime, String endTime,
		String content, Date dateTime, int isChecked) {
	super();
	this.userId = userId;
	this.startTime = startTime;
	this.endTime = endTime;
	this.content = content;
	this.dateTime = dateTime;
	this.isChecked = isChecked;
}



public Information(int id, int userId, String startTime, String endTime,
		String content, Date dateTime, int isChecked) {
	super();
	this.id = id;
	this.userId = userId;
	this.startTime = startTime;
	this.endTime = endTime;
	this.content = content;
	this.dateTime = dateTime;
	this.isChecked = isChecked;
}



public Information() {
	
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public int getUserId() {
	return userId;
}



public void setUserId(int userId) {
	this.userId = userId;
}



public String getStartTime() {
	return startTime;
}



public void setStartTime(String startTime) {
	this.startTime = startTime;
}



public String getEndTime() {
	return endTime;
}



public void setEndTime(String endTime) {
	this.endTime = endTime;
}



public String getContent() {
	return content;
}



public void setContent(String content) {
	this.content = content;
}



public Date getDateTime() {
	return dateTime;
}



public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
}



public int getIsChecked() {
	return isChecked;
}



public void setIsChecked(int i) {
	this.isChecked = i;
}


}