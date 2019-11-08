package br.com.augusto.repository;

import java.util.List;

import br.com.augusto.domain.Cidade;
import br.com.augusto.domain.Estado;

public interface CidadeRepository {
	public void salvar(Cidade cidade);
	public List<Cidade> listar();
	public Cidade buscarPorId(Cidade cidade);
	public void deletar(Cidade cidade);
	public List<Cidade> buscarPorEstado(Estado estado);
}
