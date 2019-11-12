package br.com.augusto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;

@Entity
@Data
@NamedQueries( {
	@NamedQuery(name = "Cidade.findAll", query = "select f from Cidade f"),
	@NamedQuery(name = "Cidade.findOne", query = "select c from Cidade c where c.id = 1") }) 
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@ManyToOne
	private Estado estado;
}
