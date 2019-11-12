package br.com.augusto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.augusto.domain.enums.TipoEndereco;
import lombok.Data;

@Entity
@Data
public class Logradouro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@OneToOne
	private Cidade cidade;
	private TipoEndereco endereco;
}
