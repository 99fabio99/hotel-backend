package com.fabiozanela.hotel.dto;

import java.io.Serializable;

import com.fabiozanela.hotel.domain.Caracteristica;

public class CaracteristicaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CaracteristicaDTO() {}
	
	public CaracteristicaDTO(Caracteristica caracteristica) {
		this.id = caracteristica.getId();
		this.nome = caracteristica.getNome();
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
