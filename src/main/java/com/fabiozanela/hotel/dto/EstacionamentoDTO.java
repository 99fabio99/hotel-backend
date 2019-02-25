package com.fabiozanela.hotel.dto;

import java.io.Serializable;

import com.fabiozanela.hotel.domain.Estacionamento;

public class EstacionamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numero;
	private String bloco;
	
	public EstacionamentoDTO() {}
	
	public EstacionamentoDTO(Estacionamento estacionamento) {
		this.id = estacionamento.getId();
		this.numero = estacionamento.getNumero();
		this.bloco = estacionamento.getBloco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	
}
