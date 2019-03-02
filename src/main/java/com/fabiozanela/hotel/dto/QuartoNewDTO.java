package com.fabiozanela.hotel.dto;

import java.io.Serializable;

import com.fabiozanela.hotel.domain.PerfilQuarto;
import com.fabiozanela.hotel.domain.Quarto;

public class QuartoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	private PerfilQuarto perfilQuarto;
	
	public QuartoNewDTO() {}

	public QuartoNewDTO(Quarto quarto) {
		super();
		this.id = quarto.getId();
		this.nome = quarto.getNome();
		this.perfilQuarto = quarto.getPerfilQuarto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PerfilQuarto getPerfilQuarto() {
		return perfilQuarto;
	}

	public void setPerfilQuarto(PerfilQuarto perfilQuarto) {
		this.perfilQuarto = perfilQuarto;
	}
	
	

}
