package com.fabiozanela.hotel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fabiozanela.hotel.domain.Cliente;
import com.fabiozanela.hotel.domain.Pagamento;
import com.fabiozanela.hotel.domain.Reserva;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataFim;

	private String observacao;
	private Integer numeroAdultos;
	private Integer numeroCriancas;
	private Pagamento pagamento;

	private List<AgendaDTO> agendas = new ArrayList<>();
	
	private Cliente cliente;
	
	public ReservaNewDTO() {}

	public ReservaNewDTO(Reserva reserva) {
		this.id = reserva.getId();
		this.dataInicio = reserva.getDataInicio();
		this.dataFim = reserva.getDataFim();
		this.observacao = reserva.getObservacao();
		this.numeroAdultos = reserva.getNumeroAdultos();
		this.numeroCriancas = reserva.getNumeroCriancas();
		this.pagamento = reserva.getPagamento();
		this.cliente = reserva.getCliente();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getNumeroAdultos() {
		return numeroAdultos;
	}

	public void setNumeroAdultos(Integer numeroAdultos) {
		this.numeroAdultos = numeroAdultos;
	}

	public Integer getNumeroCriancas() {
		return numeroCriancas;
	}

	public void setNumeroCriancas(Integer numeroCriancas) {
		this.numeroCriancas = numeroCriancas;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public List<AgendaDTO> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<AgendaDTO> agendas) {
		this.agendas = agendas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
