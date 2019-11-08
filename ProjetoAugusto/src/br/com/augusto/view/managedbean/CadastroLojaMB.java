package br.com.augusto.view.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import br.com.augusto.domain.Cidade;
import br.com.augusto.domain.Estado;
import br.com.augusto.domain.Loja;
import br.com.augusto.repository.CidadeRepository;
import br.com.augusto.repository.EstadoRepository;
import br.com.augusto.repository.LojaRepository;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Setter
@Getter
public class CadastroLojaMB {

	@ManagedProperty(value = "#{lojaRepositoryImpl}")
	private LojaRepository lojaRepository;

	@ManagedProperty(value = "#{estadoRepositoryImpl}")
	private EstadoRepository estadoRepository;
	
	@ManagedProperty(value = "#{cidadeRepositoryImpl}")
	private CidadeRepository cidadeRepository;

	private List<Cidade> cidades;
	private Cidade cidade;
	private List<Estado> estados;
	private Estado estado = new Estado();

	private Loja loja;

	@PostConstruct
	public void init() {
		this.estados = estadoRepository.listar();
		
	}
	
	public void buscarCidades() {
		this.cidades = cidadeRepository.buscarPorEstado(estado);
	}

}
