package com.fabiozanela.hotel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PerfilQuarto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Double valorBase;
	private Double adulto;
	private Double crianca;
	
	@JsonIgnore
	@OneToMany(mappedBy="perfilQuarto")
	private List<Quarto> quartos = new ArrayList<>(); 
	
	@JsonIgnore
	@ManyToMany(mappedBy="perfilQuartos")
	private List<Caracteristica> caracteristicas = new ArrayList<>();
	
	public PerfilQuarto() {
		
	}

	public PerfilQuarto(Integer id, String nome, Double valorBase, Double adulto, Double crianca) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorBase = valorBase;
		this.adulto = adulto;
		this.crianca = crianca;
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

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilQuarto other = (PerfilQuarto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
