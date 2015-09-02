package org.betavzw.slotoef.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Klant implements Serializable {

	/**
	 * Generated version of serialized object
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Database id van klant. Primary key
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int klantid;

	/**
	 * De naam van de klant
	 */
	private String klantnaam;

	/**
	 * De bestellingen van deze klant
	 */
	@OneToMany(mappedBy = "klant")
	private Set<Bestelling> bestellingen = new HashSet<>();

	public Klant() {
		// Hibernate
	}

	@Override
	public String toString() {
		return "Klant [klantid=" + klantid + ", klantnaam=" + klantnaam + "]";
	}

	public Klant(String klantnaam) {
		this.klantnaam = klantnaam;
	}

	public int getKlantId() {
		return klantid;
	}

	public String getKlantNaam() {
		return klantnaam;
	}

	public void setKlantNaam(String klantnaam) {
		this.klantnaam = klantnaam;
	}

}
