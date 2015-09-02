package org.betavzw.slotoef.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	/**
	 * De database id van het product
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id private int id;
	
	/**
	 * De naam van het product
	 */
	private String naam;
	
	/**
	 * De prijs van het product
	 */
	private BigDecimal prijs;
	
	/**
	 * De categorie waartoe dit product behoort
	 */
	@ManyToOne()
	private Categorie categorie;
	
	/**
	 * De bestelling
	 */
	@OneToMany(mappedBy="product")
	private Set<Bestelling> bestellingen;
	
	public Product() {
		// Hibernate constructor
	}

	public Product(String naam, BigDecimal prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", naam=" + naam + ", prijs=" + prijs
				+ "]";
	}

	public int getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public Set<Bestelling> getBestelling() {
		return bestellingen;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}