package com.fabiozanela.hotel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fabiozanela.hotel.domain.enums.EstadoQuarto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date date;
	
	private Integer estado;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "AGENDA_QUARTO",
		joinColumns = @JoinColumn(name = "agenda_id"),
		inverseJoinColumns = @JoinColumn(name = "quarto_id")
	)
	private List<Quarto> quartos = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "AGENDA_ESTACIONAMENTO",
		joinColumns = @JoinColumn(name = "agenda_id"),
		inverseJoinColumns = @JoinColumn(name = "estacionamento_id")
	)
	private List<Estacionamento> estacionamentos = new ArrayList<>();
	
	public Agenda() {}

	public Agenda(Integer id, Date date, EstadoQuarto estado) {
		super();
		this.id = id;
		this.date = date;
		this.estado = (estado == null) ? null : estado.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public List<Estacionamento> getEstacionamentos() {
		return estacionamentos;
	}

	public void setEstacionamentos(List<Estacionamento> estacionamentos) {
		this.estacionamentos = estacionamentos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
