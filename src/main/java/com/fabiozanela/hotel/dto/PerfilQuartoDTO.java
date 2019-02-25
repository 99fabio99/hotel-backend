package com.fabiozanela.hotel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fabiozanela.hotel.domain.PerfilQuarto;

public class PerfilQuartoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double valorBase;
	private Double adulto;
	private Double crianca;
	
	private List<QuartoDTO> quartoDTO = new ArrayList<>();
	private List<CaracteristicaDTO> caracteristicaDTO = new ArrayList<>();
	
	public PerfilQuartoDTO(){}
	
	public PerfilQuartoDTO(PerfilQuarto perfilQuarto) {
		this.id = perfilQuarto.getId();
		this.nome = perfilQuarto.getNome();
		this.valorBase = perfilQuarto.getValorBase();
		this.adulto = perfilQuarto.getAdulto();
		this.crianca = perfilQuarto.getCrianca();
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

	public Double getValorBase() {
		return valorBase;
	}

	public void setValorBase(Double valorBase) {
		this.valorBase = valorBase;
	}

	public Double getAdulto() {
		return adulto;
	}

	public void setAdulto(Double adulto) {
		this.adulto = adulto;
	}

	public Double getCrianca() {
		return crianca;
	}

	public void setCrianca(Double crianca) {
		this.crianca = crianca;
	}

	public List<QuartoDTO> getQuartos() {
		return quartoDTO;
	}

	public void setQuartoDTO(List<QuartoDTO> quartoDTO) {
		this.quartoDTO = quartoDTO;
	}

	public List<CaracteristicaDTO> getCaracteristicas() {
		return caracteristicaDTO;
	}

	public void setCaracteristicaDTO(List<CaracteristicaDTO> caracteristicaDTO) {
		this.caracteristicaDTO = caracteristicaDTO;
	}
	
	
}
