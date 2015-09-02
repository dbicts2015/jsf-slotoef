package org.betavzw.slotoef.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.betavzw.slotoef.entity.AccountManager;

@Named("manager")
@ApplicationScoped
public class AccountManagerBean implements Serializable {

	/**
	 * De versie id van het geserialiseerd object
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * De entity manager voor het beheren van de database
	 */
	@PersistenceContext private EntityManager manager;
	
	/**
	 * De gebruikers transactie
	 */
	@Resource private UserTransaction transaction;
	
	/**
	 * De ingevoerde naam van de account manager
	 */
	private String naam;

	/**
	 * Voegt een AccountManager toe aan de database
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		/*
		 * Begin de transactie
		 */
		transaction.begin();
		
		/*
		 * Persist het object
		 */
		manager.persist(new AccountManager(naam));
		
		/*
		 * Commit de transactie
		 */
		transaction.commit();
	}

	public List<AccountManager> getManagers() {
		return manager.createQuery("from AccountManager", AccountManager.class).getResultList();
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

}