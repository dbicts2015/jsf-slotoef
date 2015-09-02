package org.betavzw.slotoef.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountManager implements Serializable {

	/**
	 * Generated version of serialized object
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Database id van de account manager. Primary key
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id private int id;

	/**
	 * De naam van de account manager
	 */
	private String naam;

	public AccountManager() {
		// Hibernate
	}

	public AccountManager(String naam) {
		this.naam = naam;
	}

	@Override
	public String toString() {
		return "AccountManager [id=" + id + ", naam=" + naam + "]";
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

}