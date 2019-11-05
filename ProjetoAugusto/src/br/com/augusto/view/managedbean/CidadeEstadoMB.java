package br.com.augusto.view.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.augusto.domain.Cidade;
import br.com.augusto.domain.Estado;
import br.com.augusto.repository.EstadoRepository;

@ManagedBean
@ViewScoped
public class CidadeEstadoMB {

	@ManagedProperty(value = "#{estadoRepositoryImpl}")
	private EstadoRepository estadoRepository;
	
	private Estado estado = new Estado();
	private Cidade cidade = new Cidade();

	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void salvar() {
		estadoRepository.salvar(estado, cidade);
	}

	public void setEstadoRepository(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
