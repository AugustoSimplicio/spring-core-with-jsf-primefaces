package br.com.augusto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.augusto.domain.Estado;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository {

	@Override
	public Estado salvar(Estado estado) {
		Estado estadoGravada = new Estado();
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			estadoGravada = entityManager.merge(estado);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoGravada;
	}

	@Override
	public List<Estado> listar() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Estado> query = entityManager.createQuery("select e from Estado e", Estado.class);
		List<Estado> estados = query.getResultList();
		entityManager.close();
		entityManagerFactory.close();
		return estados;
	}

	@Override
	public Estado buscarPorId(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Estado estadoRetornado = entityManager.find(Estado.class, id);
		entityManager.close();
		entityManagerFactory.close();
		return estadoRetornado;
	}

	@Override
	public void deletar(Estado estado) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Estado estadoRemover = buscarPorId(estado.getId());
		entityManager.remove(estadoRemover);
		entityManager.close();
		entityManagerFactory.close();
	}
}
