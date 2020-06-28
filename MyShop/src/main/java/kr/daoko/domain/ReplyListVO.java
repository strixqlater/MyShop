package kr.daoko.domain;

import java.util.Date;

public class ReplyListVO {
	private String gdsCode;
	private int repNum;
	private String repCon;
	private Date repDate;
	private String userName;
	
	public String getGdsCode() {
		return gdsCode;
	}
	public void setGdsCode(String gdsCode) {
		this.gdsCode = gdsCode;
	}
	public int getRepNum() {
		return repNum;
	}
	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}
	public String getRepCon() {
		return repCon;
	}
	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
