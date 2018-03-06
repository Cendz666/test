package com.lendInfo;

import java.sql.Date;

public class LendInfoBean {
	private int id;
	private int libId;
	private int readerId;
	private Date startTime;
	private int addDays;
	private int returned;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLibId() {
		return libId;
	}
	public void setLibId(int libId) {
		this.libId = libId;
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
	public int getAddDays() {
		return addDays;
	}
	public void setAddDays(int addDays) {
		this.addDays = addDays;
	}
	public int getReturned() {
		return returned;
	}
	public void setReturned(int returned) {
		this.returned = returned;
	}
}
