package br.com.augusto.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.SessionScoped;

import br.com.augusto.domain.Fundo;
@SessionScoped
public class FundoDAO implements Service<Fundo> {

	private static List<Fundo> fundos = new ArrayList<Fundo>();

	public void salvar(Fundo p) {
		Random random = new Random();
		int numero = random.nextInt(1000);
		p.setId(numero);
		FundoDAO.fundos.add(p);
	}

	public List<Fundo> getPessoas() {
		return fundos;
	}

	public Fundo findById(Fundo findFundo) {
		Fundo retornoFundo = null;
		for (Fundo fundo : fundos) {
			if (fundo.equals(findFundo)) {
				retornoFundo = fundo;
			}
		}
		return retornoFundo;
	}
	public void editar(Fundo fundoEditado) {
		for (Fundo fundo : fundos) {
			if(fundo.equals(fundoEditado)) {
				fundo = fundoEditado;
			}
		}
	}
	public boolean deletar(Fundo fundo) {
		return fundos.remove(findById(fundo));
	}
}
