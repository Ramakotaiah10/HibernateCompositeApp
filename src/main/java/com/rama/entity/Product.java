package com.rama.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT2_DTLS")
public class Product {
	
	@EmbeddedId
	private  ProductCompositePK pkId; 

	@Column(name = "PNAME")
	private String productName;
	
	@Column(name = "PPRICE")
	private double productPrice;

	public ProductCompositePK getPkId() {
		return pkId;
	}

	public void setPkId(ProductCompositePK pkId) {
		this.pkId = pkId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [pkId=" + pkId + ", productName=" + productName + ", productPrice=" + productPrice + "]";
	}
	
}
