package kr.daoko.domain;

import java.sql.Date;

public class GoodsVO {
	private String gdsCode;
	private String gdsName;
	private String cateCode;
	private int gdsPrice;
	private String gdsDesc;
	private String gdsImg;
	private Date gdsDate;
	
	public String getGdsCode() {
		return gdsCode;
	}
	public void setGdsCode(String gdsCode) {
		this.gdsCode = gdsCode;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public String getGdsDesc() {
		return gdsDesc;
	}
	public void setGdsDesc(String gdsDesc) {
		this.gdsDesc = gdsDesc;
	}
	public String getGdsImg() {
		return gdsImg;
	}
	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}
	public Date getGdsDate() {
		return gdsDate;
	}
	public void setGdsDate(Date gdsDate) {
		this.gdsDate = gdsDate;
	}
}
