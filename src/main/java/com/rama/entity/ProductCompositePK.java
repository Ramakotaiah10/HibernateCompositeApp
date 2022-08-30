package com.rama.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductCompositePK  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "PID")
	private Integer pdrouctId;
	
	@Column(name = "PCATEGORY")
	private String procustCategory;

	public Integer getPdrouctId() {
		return pdrouctId;
	}

	public void setPdrouctId(Integer pdrouctId) {
		this.pdrouctId = pdrouctId;
	}

	public String getProcustCategory() {
		return procustCategory;
	}

	public void setProcustCategory(String procustCategory) {
		this.procustCategory = procustCategory;
	}

	@Override
	public String toString() {
		return "ProductCompositePK [pdrouctId=" + pdrouctId + ", procustCategory=" + procustCategory + "]";
	}

}
