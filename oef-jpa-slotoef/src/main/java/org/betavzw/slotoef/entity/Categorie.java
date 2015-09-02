package org.betavzw.slotoef.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Categorie implements Serializable {

	/**
	 * Generated version of serialized object
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Database id van de categorie. Primary key.
	 */
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id private int id;
	
	/**
	 * Naam van de categorie
	 */
	private String naam;

	/**
	 * De producten die behoren tot deze categorie
	 */
	@OneToMany(mappedBy="categorie")
	private Set<Product> producten = new HashSet<>();
	
	/**
	 * De accountmanager voor deze categorie
	 */
	@OneToOne
	private AccountManager accountManager;

	public Categorie() {
		// Hibernate
	}

	public Categorie(String naam) {
		this.naam = naam;
	}

	public String toString() {
		return naam + " heeft als manager " + accountManager.getNaam();
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

	public Set<Product> getProducten() {
		return producten;
	}

	public void setProducten(Set<Product> producten) {
		this.producten = producten;
	}

	public void addProduct(Product product) {
		product.setCategorie(this);
		producten.add(product);
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	
	public AccountManager getAccountManager() {
		return accountManager;
	}

}