package com.fabiozanela.hotel.dto;

import java.io.Serializable;

import com.fabiozanela.hotel.domain.Quarto;

public class QuartoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public QuartoDTO() {}
	
	public QuartoDTO(Quarto quarto) {
		this.id = quarto.getId();
		this.nome = quarto.getNome();
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
	
}
