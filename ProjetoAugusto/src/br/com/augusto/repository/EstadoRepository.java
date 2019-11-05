package br.com.augusto.repository;

import java.util.List;

import br.com.augusto.domain.Cidade;
import br.com.augusto.domain.Estado;

public interface EstadoRepository {
	public Cidade salvar(Estado estado, Cidade cidade);
	public List<Estado> listar();
	public Estado buscarPorId(Estado estado);
	public void deletar(Estado estado);
}
