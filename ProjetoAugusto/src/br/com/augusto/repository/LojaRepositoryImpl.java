package br.com.augusto.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import br.com.augusto.domain.Loja;

@Repository
public class LojaRepositoryImpl implements LojaRepository {

	@Override
	public Loja salvar(Loja loja) {
		Loja lojaSalva = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			lojaSalva = entityManager.merge(loja);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lojaSalva;
	}

}
