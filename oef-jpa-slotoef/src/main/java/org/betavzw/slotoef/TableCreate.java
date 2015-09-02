package org.betavzw.slotoef;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TableCreate {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("slotoef");
		EntityManager manager = factory.createEntityManager();
		
		manager.close();
	}
	
}