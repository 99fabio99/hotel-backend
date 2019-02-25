package com.fabiozanela.hotel.dto;

import java.io.Serializable;

import com.fabiozanela.hotel.domain.Veiculo;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String placa;
	private String modelo;
	private String cor;
	private Integer ano;

	public VeiculoDTO() {}
	
	public VeiculoDTO(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.placa = veiculo.getPlaca();
		this.modelo = veiculo.getModelo();
		this.cor = veiculo.getCor();
		this.ano = veiculo.getAno();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
}
