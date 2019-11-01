package br.com.augusto.dao;

import java.util.List;

public interface Service<T> {
	public List<T> listar();
	public void salvar(T t);
	public T findById(T t);
	public void editar(T t);
	public boolean deletar(T t);
}
