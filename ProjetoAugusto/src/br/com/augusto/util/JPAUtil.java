package br.com.augusto.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory ENTITYMANAGERFACTORY = Persistence
			.createEntityManagerFactory("pessoa");

	public EntityManager getEntityManager() {
		return ENTITYMANAGERFACTORY.createEntityManager();
	}

}
