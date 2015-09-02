package org.betavzw.slotoef.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bestelling implements Serializable {

	/**
	 * Generated version of serialized object
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * De id
	 */
	@EmbeddedId
	private Id id;
	
	/**
	 * De hoeveelheid producten die zijn besteld
	 */
	private int aantal;
	
	/**
	 * De klant van deze bestelling. Elke bestelling kan maar één klant hebben, maar
	 * een klant kan meerdere bestellingen hebben
	 */
	@ManyToOne
	@JoinColumn(name="klantId", insertable=false, updatable=false)
	private Klant klant;
	
	/**
	 * De producten die bij deze bestelling horen
	 */
	@ManyToOne
	@JoinColumn(name="productId", insertable=false, updatable=false)
	private Product product;

	public Bestelling() {
		// Hibernate
	}

	public Bestelling(Product product, Klant klant) {
		this.klant = klant;
		this.product = product;
		this.id = new Id(product.getId(), klant.getKlantId());
	}

	@Override
	public String toString() {
		return "Bestelling [id=" + id + ", aantal=" + aantal + "]";
	}

	public Id getId() {
		return id;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}