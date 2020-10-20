package br.ufrpe.joanam2.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory entityManagerFactory = null;
	
	static {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("joanam2");			
		}
	}
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
