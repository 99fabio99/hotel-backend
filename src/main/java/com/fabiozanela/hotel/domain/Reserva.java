package com.fabiozanela.hotel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicio;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFim;
	
	private String observacao;
	private Integer numeroAdultos;
	private Integer numeroCriancas;
	
	@OneToMany(mappedBy="reserva", cascade= CascadeType.ALL)
	private List<Agenda> agendas = new ArrayList<>();
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="reserva")
	private Pagamento pagamento;
	
	@OneToMany(mappedBy="id.reserva")
	private Set<ItemConsumido> itens = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	public Reserva() {
	}

	public Reserva(Integer id, Date dataInicio, Date dataFim, String observacao, Integer numeroAdultos,
			Integer numeroCriancas, Cliente cliente) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.observacao = observacao;
		this.numeroAdultos = numeroAdultos;
		this.numeroCriancas = numeroCriancas;
		this.cliente = cliente;
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

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemConsumido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemConsumido> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
