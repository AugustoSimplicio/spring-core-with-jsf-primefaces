package br.com.augusto.view.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.augusto.domain.Cidade;
import br.com.augusto.domain.Estado;
import br.com.augusto.repository.CidadeRepository;
import br.com.augusto.repository.EstadoRepository;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped	
@Setter
@Getter
public class CadastroCidadeMB {

	@ManagedProperty(value = "#{estadoRepositoryImpl}")
	private EstadoRepository estadoRepository;

	private List<Estado> estados;
	
	private EstadoConverte estadoConverte;

	@ManagedProperty(value = "#{cidadeRepositoryImpl}")
	private CidadeRepository cidadeRepository;

	private Estado estado = new Estado();
	private Cidade cidade = new Cidade();

	public void salvar() {
		System.out.println(this.estado);
		Estado estado =  estadoRepository.buscarPorId(this.estado.getId());
		cidade.setEstado(estado);
		cidadeRepository.salvar(cidade);
		cidade = new Cidade();
	}

	@PostConstruct
	public void init() {
		this.estados = estadoRepository.listar();
	}
}
