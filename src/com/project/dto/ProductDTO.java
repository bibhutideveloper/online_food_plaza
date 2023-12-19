package com.project.dto;

public class ProductDTO {
	private Integer productId;
	private String productName;
	private Double productPrice;
	private Integer productCtgId;
	
	public ProductDTO() {
		
	}

	public ProductDTO(String productName) {
		super();
		this.productName = productName;
	}
	
	public ProductDTO(Integer productId, String productName, Double productPrice, Integer productCtgId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCtgId = productCtgId;
	}

	public ProductDTO(String productName, Double productPrice, Integer productCtgId) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCtgId = productCtgId;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductCtgId() {
		return productCtgId;
	}

	public void setProductCtgId(Integer productCtgId) {
		this.productCtgId = productCtgId;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCtgId=" + productCtgId + "]";
	}
	
}
