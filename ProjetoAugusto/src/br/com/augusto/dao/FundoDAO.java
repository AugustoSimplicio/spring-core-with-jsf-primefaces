package br.com.augusto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.augusto.domain.Fundo;

@SessionScoped
public class FundoDAO implements Service<Fundo> {

	public void salvar(Fundo f) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		
		try {
			if (f != null) {
				entityManager.getTransaction().begin();
				entityManager.persist(f);
				entityManager.getTransaction().commit();
				entityManager.close();
				entityManagerFactory.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Fundo> listar() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Fundo> fundos = new ArrayList<Fundo>();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select f from Fundo f");
			fundos = query.getResultList();
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return fundos;
	}

	public Fundo findById(Fundo findFundo) {
		Fundo f = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Fundo> fundos = listar();
		for (Fundo fundo : fundos) {
			if (fundo.equals(findFundo)) {
				f = fundo;
			}
		}
		entityManager.close();
		entityManagerFactory.close();
		return f;
	}

	public boolean deletar(Fundo fundo) {
		boolean removido = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			if (fundo != null) {

				entityManager.getTransaction().begin();
				entityManager.remove(entityManager.getReference(Fundo.class, fundo.getId()));
				entityManager.getTransaction().commit();
				entityManager.close();
				entityManagerFactory.close();
				removido = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return removido;
	}

	@Override
	public void editar(Fundo fundoEditado) {
		boolean editado = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			if (fundoEditado != null) {
				entityManager.getTransaction().begin();
				entityManager.merge(entityManager.getReference(Fundo.class, fundoEditado.getId()));
				entityManager.getTransaction().commit();
				entityManager.close();
				entityManagerFactory.close();
				editado = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
