package br.com.augusto.repository;

import java.util.List;

import br.com.augusto.domain.Loja;

public interface LojaRepository {
	public Loja salvar(Loja loja);
	public List<Loja> listar();
}
