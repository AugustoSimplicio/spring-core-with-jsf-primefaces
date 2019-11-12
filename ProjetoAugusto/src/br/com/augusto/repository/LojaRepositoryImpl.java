package br.com.augusto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.domain.Loja;

@Repository
public class LojaRepositoryImpl implements LojaRepository {

	@Override
	public Loja salvar(Loja loja) {
		Loja lojaSalva = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			
			entityManager.getTransaction().begin();
			lojaSalva = entityManager.merge(loja);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		return lojaSalva;
	}

	@Override
	public List<Loja> listar() {
		List<Loja> lojas = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<Loja> query = entityManager.createQuery("select l from Loja l", Loja.class);
			lojas = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		return lojas;
	}
}
