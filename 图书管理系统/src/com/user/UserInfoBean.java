package com.user;

import java.util.Date;

/**
 * @author Cendz
 *保存用户个人信息的JavaBean
 *
 */
public class UserInfoBean {
	private int    id;
	private String userName;
	private String password;
	private String sex;
	private String birthday;
	private String papertype;
	private String paperNO;
	private String tel;
	private String email;
	private String remark;
	private Date   regeditTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPapertype() {
		return papertype;
	}
	public void setPapertype(String papertype) {
		this.papertype = papertype;
	}
	public String getPaperNO() {
		return paperNO;
	}
	public void setPaperNO(String paperNO) {
		this.paperNO = paperNO;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getRegeditTime() {
		return regeditTime;
	}
	public void setRegeditTime(Date regeditTime) {
		this.regeditTime = regeditTime;
	}
	
}
