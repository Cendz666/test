package com.manager;

import java.sql.Date;

public class LookHistoryBean {
	private int  lendInfoId;
	private int  readerId;
	private Date startTime;
	
	public int getLendInfoId() {
		return lendInfoId;
	}
	public void setLendInfoId(int lendInfoId) {
		this.lendInfoId = lendInfoId;
	}
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
}
