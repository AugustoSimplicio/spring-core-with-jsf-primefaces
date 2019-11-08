package br.com.augusto.repository;

import java.util.List;

import br.com.augusto.domain.Estado;

public interface EstadoRepository {
	public Estado salvar(Estado estado);
	public List<Estado> listar();
	public Estado buscarPorId(Long id);
	public void deletar(Estado estado);
}
