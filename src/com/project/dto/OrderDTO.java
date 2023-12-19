package com.project.dto;

public class OrderDTO {
	private Integer orderId;
	private Integer customerId;
	private Integer cartId;
	private String address;
	private Double totalBill;
	private String transactionType;
	
	public OrderDTO() {
		
	}
	
	public OrderDTO(Integer customerId, Integer cartId, String address, Double totalBill, String transactionType) {
		super();
		this.customerId = customerId;
		this.cartId = cartId;
		this.address = address;
		this.totalBill = totalBill;
		this.transactionType = transactionType;
	}
	
	public OrderDTO(Integer orderId) {
		super();
		this.setOrderId(orderId);
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "OrderDTO [customerId=" + customerId + ", cartId=" + cartId + ", address=" + address + ", totalBill="
				+ totalBill + ", transactionType=" + transactionType + "]";
	}
	
}
