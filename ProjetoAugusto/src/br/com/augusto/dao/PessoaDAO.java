package br.com.augusto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.augusto.domain.Pessoa;

public class PessoaDAO implements Service<Pessoa> {
	
	public void salvar(Pessoa p) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			if (p != null) {
				entityManager.getTransaction().begin();
				entityManager.persist(p);
				entityManager.getTransaction().commit();
				entityManager.close();
				entityManagerFactory.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Pessoa> listar() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select p from Pessoa p");
			pessoas = query.getResultList();
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return pessoas;
	}

	public Pessoa findById(Pessoa findPessoa) {
		Pessoa p = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Pessoa> pessoas = listar();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.equals(findPessoa)) {
				p = pessoa;
			}
		}
		entityManager.close();
		entityManagerFactory.close();
		return p;
	}

	public boolean deletar(Pessoa pessoa) {
		boolean removido = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			if (pessoa != null) {

				entityManager.getTransaction().begin();
				entityManager.remove(entityManager.getReference(Pessoa.class, pessoa.getId()));
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
	public void editar(Pessoa pessoaEditada) {
		boolean editado = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			if (pessoaEditada != null) {
				entityManager.getTransaction().begin();
				entityManager.merge(entityManager.getReference(Pessoa.class, pessoaEditada.getId()));
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
