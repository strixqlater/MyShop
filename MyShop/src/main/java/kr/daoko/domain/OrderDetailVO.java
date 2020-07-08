package kr.daoko.domain;

public class OrderDetailVO {
	@Override
	public String toString() {
		return "OrderDetailVO [orderDetailsNum=" + orderDetailsNum + ", orderId=" + orderId + ", gdsCode=" + gdsCode
				+ ", cartStock=" + cartStock + "]";
	}
	private int orderDetailsNum;
	private String orderId;
	private String gdsCode;
	private int cartStock;
	
	public int getOrderDetailsNum() {
		return orderDetailsNum;
	}
	public void setOrderDetailsNum(int orderDetailsNum) {
		this.orderDetailsNum = orderDetailsNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGdsCode() {
		return gdsCode;
	}
	public void setGdsCode(String gdsCode) {
		this.gdsCode = gdsCode;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
}
