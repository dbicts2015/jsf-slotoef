package org.betavzw.slotoef.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Id implements Serializable {

	/**
	 * Generated version of serialized object
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * De id van het product
	 */
	private int productId;

	/**
	 * De klant id
	 */
	private int klantId;

	public Id() {
		// Hibernate
	}

	public Id(int productId, int klantId) {
		this.productId = productId;
		this.klantId = klantId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + klantId;
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Id other = (Id) obj;
		if (klantId != other.klantId)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getKlantId() {
		return klantId;
	}

	public void setKlantId(int klantId) {
		this.klantId = klantId;
	}

}