package br.com.augusto.view.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.augusto.domain.Cidade;
import br.com.augusto.domain.Estado;
import br.com.augusto.domain.Logradouro;
import br.com.augusto.domain.Loja;
import br.com.augusto.repository.CidadeRepository;
import br.com.augusto.repository.EstadoRepository;
import br.com.augusto.repository.LogradouroRespository;
import br.com.augusto.repository.LojaRepository;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Setter
@Getter
public class CadastroLojaMB {
	
	private MessagesView messagesView = new MessagesView();

	@ManagedProperty(value = "#{lojaRepositoryImpl}")
	private LojaRepository lojaRepository;

	@ManagedProperty(value = "#{estadoRepositoryImpl}")
	private EstadoRepository estadoRepository;
	
	@ManagedProperty(value = "#{cidadeRepositoryImpl}")
	private CidadeRepository cidadeRepository;
	
	@ManagedProperty(value = "#{logradouroRepositoryImpl}")
	private LogradouroRespository logradouroRespository;

	private List<Cidade> cidades;
	private Cidade cidade;
	private List<Estado> estados;
	private Estado estado = new Estado();
	private Logradouro logradouro = new Logradouro();
	private Loja loja = new Loja();

	@PostConstruct
	public void init() {
		this.estados = estadoRepository.listar();
		
	}
	
	public void buscarCidades() {
		this.cidades = cidadeRepository.buscarPorEstado(estado);
	}
	
	public void salvar() {
		System.out.println("CNPJ ----------" +this.loja.getCnpj());
		
		this.logradouro.setCidade(this.cidade);
		
		logradouro =  logradouroRespository.salvar(logradouro);
		
		loja.setLogradouro(logradouro);
		
		lojaRepository.salvar(this.loja);
		
		getMessagesView().sucessoCadastro();
		
		limparFormulario();
	}
	
	public void limparFormulario() {
		this.loja = new Loja();
		this.estado = new Estado();
		this.logradouro = new Logradouro();
		this.cidade = new Cidade();
	}
}
