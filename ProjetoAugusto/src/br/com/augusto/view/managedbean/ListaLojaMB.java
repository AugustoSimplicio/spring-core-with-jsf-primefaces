package br.com.augusto.view.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.augusto.domain.Loja;
import br.com.augusto.repository.LojaRepository;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class ListaLojaMB {
	
	@ManagedProperty(value = "#{lojaRepositoryImpl}")
	private LojaRepository lojaRepository;
	private List<Loja> lojas;
	
	
	public void listarLojas() {
		lojas = lojaRepository.listar();
	}
	
	@PostConstruct
	public void init() {
		listarLojas();
	}

}
