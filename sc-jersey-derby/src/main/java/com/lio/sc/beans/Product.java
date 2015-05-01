package com.lio.sc.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private Long productId; 
	private String productName; 
	private Long supplierId; 
	private Long categoryId; 
	private String unit; 
	private Double price;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", supplierId=" + supplierId + ", categoryId="
				+ categoryId + ", unit=" + unit + ", price=" + price + "]";
	} 
	
}
