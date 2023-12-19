package com.project.dto;

public class CartDTO {
	private Integer customerId;
	private Integer productId;
	private Integer productQuantity;
	private Double totalPrice;
	private String paymentStatus;
	
	public CartDTO() {
		
	}

	public CartDTO(Integer customerId, Integer productId, Integer productQuantity, Double totalPrice, String paymentStatus) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.totalPrice = totalPrice;
		this.paymentStatus = paymentStatus;
		
	}
	
	public CartDTO(Integer productId) {
		super();
		this.productId = productId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "CartDTO [customerId=" + customerId + ", productId=" + productId + ", totalPrice=" + totalPrice
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}
