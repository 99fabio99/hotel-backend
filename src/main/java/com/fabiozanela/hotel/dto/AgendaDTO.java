package com.fabiozanela.hotel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fabiozanela.hotel.domain.Agenda;
import com.fabiozanela.hotel.domain.Estacionamento;
import com.fabiozanela.hotel.domain.Quarto;
import com.fabiozanela.hotel.domain.Veiculo;
import com.fabiozanela.hotel.domain.enums.EstadoQuarto;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AgendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;
	private Integer estado;

	private List<QuartoDTO> quartos = new ArrayList<>();
	private List<EstacionamentoDTO> estacionamentos = new ArrayList<>();
	private List<VeiculoDTO> veiculos = new ArrayList<>();

	public AgendaDTO() {
	}

	public AgendaDTO(Agenda agenda) {
		this.id = agenda.getId();
		this.date = agenda.getDate();
		this.estado = agenda.getEstado();
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

	public EstadoQuarto getEstado() {
		return EstadoQuarto.toEnum(estado);

	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<QuartoDTO> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos.stream().map(obj -> new QuartoDTO(obj)).collect(Collectors.toList());
	}

	public List<EstacionamentoDTO> getEstacionamentos() {
		return estacionamentos;
	}

	public void setEstacionamentos(List<Estacionamento> estacionamentos) {
		this.estacionamentos = estacionamentos.stream().map(obj -> new EstacionamentoDTO(obj))
				.collect(Collectors.toList());
	}

	public List<VeiculoDTO> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos.stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
	}

}
