package br.com.augusto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.augusto.domain.Cidade;
import br.com.augusto.domain.Estado;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public void salvar(Cidade cidade) {
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(cidade);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Cidade> listar() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Cidade> typedQuery = entityManager.createQuery("select f from Cidade", Cidade.class);
		typedQuery = entityManager.createNamedQuery("Cidade.findAll", Cidade.class);
		List<Cidade> cidades = typedQuery.getResultList();
		entityManager.close();
		entityManagerFactory.close();
		return cidades;
	}

	@Override
	public Cidade buscarPorId(Long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Cidade cidadeEncontrada = entityManager.find(Cidade.class, id);
		entityManager.close();
		entityManagerFactory.close();
		return cidadeEncontrada;
	}

	@Override
	public void deletar(Cidade cidade) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.remove(cidade);
		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public List<Cidade> buscarPorEstado(Estado estado) {
		List<Cidade> cidades = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			TypedQuery<Cidade> typedQuery = entityManager
					.createQuery("select c from Cidade c where c.estado = :estado", Cidade.class)
					.setParameter("estado", estado);
			cidades = typedQuery.getResultList();
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cidades;
	}

}
