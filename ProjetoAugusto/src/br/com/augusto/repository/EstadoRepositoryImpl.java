package br.com.augusto.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import br.com.augusto.domain.Cidade;
import br.com.augusto.domain.Estado;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository{
	

	@Override
	public Cidade salvar(Estado estado, Cidade cidade) {
		Cidade cidadeGravada = new Cidade();
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("systemadmin");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			cidade.setEstado(estado);
			cidadeGravada =  entityManager.merge(cidade);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cidadeGravada;
	}

	@Override
	public List<Estado> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado buscarPorId(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Estado estado) {
		// TODO Auto-generated method stub
		
	}
	
}
