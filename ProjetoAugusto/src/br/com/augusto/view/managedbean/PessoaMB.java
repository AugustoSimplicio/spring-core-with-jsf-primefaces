package br.com.augusto.view.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.augusto.dao.PessoaDAO;
import br.com.augusto.dao.Service;
import br.com.augusto.dao.Teste;
import br.com.augusto.domain.Pessoa;
import br.com.augusto.domain.enums.TipoPessoaEnum;
import br.com.augusto.filtro.Filtro;
import br.com.augusto.filtro.FiltroPessoaPorCpf;
import br.com.augusto.filtro.FiltroPessoaPorEmail;
import br.com.augusto.filtro.FiltroPessoaPorNome;

@ManagedBean
@SessionScoped
public class PessoaMB extends AbstractMB<Pessoa> {

	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> resultados = new ArrayList<Pessoa>();
	private String filtroInputCpf;
	private String filtroInputNome;
	private String filtroInputEmail;
	
	@ManagedProperty(value = "teste")
	private Teste teste;
	
	@Override
	public List<Filtro<Pessoa>> obterFiltros() {
		List<Filtro<Pessoa>> filtros = new ArrayList<Filtro<Pessoa>>();
		filtros.add(new FiltroPessoaPorNome(filtroInputNome));
		filtros.add(new FiltroPessoaPorCpf(filtroInputCpf));
		filtros.add(new FiltroPessoaPorEmail(filtroInputEmail));
		return filtros;
	}

	public String getFiltroInputEmail() {
		return filtroInputEmail;
	}

	@Override
	protected Pessoa novoModel() {
		return new Pessoa();
	}

	@Override
	protected Service<Pessoa> novoService() {
		return new PessoaDAO();
	}

	public void setFiltroInputEmail(String filtroInputEmail) {
		this.filtroInputEmail = filtroInputEmail;
	}

	public List<Pessoa> getFiltroPessoas() {
		return resultados;
	}

	public void setFiltroPessoas(List<Pessoa> filtroPessoas) {
		this.resultados = filtroPessoas;
	}

	public String getFiltroCpf() {
		return filtroInputCpf;
	}

	public void setFiltroCpf(String filtroCpf) {
		this.filtroInputCpf = filtroCpf;
	}

	public String getFiltroNome() {
		return filtroInputNome;
	}

	public void setFiltroNome(String filtroNome) {
		this.filtroInputNome = filtroNome;
	}

	public TipoPessoaEnum[] getTipos() {
		return TipoPessoaEnum.values();
	}

	public boolean isPessoaFisica() {
		return TipoPessoaEnum.FISICA.equals(pessoa.getTipoPessoa());
	}

	public boolean isPessoaJuridica() {
		return TipoPessoaEnum.JURIDICA.equals(pessoa.getTipoPessoa());
	}

	@PostConstruct
	public void init() {
		System.out.println(" Bean executado! ");
	}

	public void limparFormulario() {
		pessoa = new Pessoa();
	}
}
