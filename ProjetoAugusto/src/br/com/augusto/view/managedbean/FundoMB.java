package br.com.augusto.view.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.augusto.dao.FundoDAO;
import br.com.augusto.dao.Service;
import br.com.augusto.domain.Fundo;
import br.com.augusto.filtro.Filtro;
import br.com.augusto.filtro.FiltroFundoPorNome;

@ManagedBean
@SessionScoped
public class FundoMB extends AbstractMB<Fundo> {
	private String filtroInputNome;

	@Override
	public List<Filtro<Fundo>> obterFiltros() {
		List<Filtro<Fundo>> filtros = new ArrayList<Filtro<Fundo>>();
		filtros.add(new FiltroFundoPorNome(filtroInputNome));
		return filtros;
	}

	@Override
	protected Service<Fundo> novoService() {
		return new FundoDAO();
	}

	@Override
	protected Fundo novoModel() {
		return new Fundo();
	}

	public String getFiltroInputNome() {
		return filtroInputNome;
	}

	public void setFiltroInputNome(String filtroInputNome) {
		this.filtroInputNome = filtroInputNome;
	}

}
