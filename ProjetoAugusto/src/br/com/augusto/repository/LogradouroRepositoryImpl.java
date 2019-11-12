package br.com.augusto.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import br.com.augusto.domain.Logradouro;

@Repository
public class LogradouroRepositoryImpl implements LogradouroRespository{

	@Override
	public Logradouro salvar(Logradouro logradouro) {
		Logradouro logradouroSalvo = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			logradouroSalvo = entityManager.merge(logradouro);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logradouroSalvo;
	}

}
