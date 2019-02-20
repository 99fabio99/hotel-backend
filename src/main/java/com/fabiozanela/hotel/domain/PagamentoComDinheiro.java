package com.fabiozanela.hotel.domain;

import javax.persistence.Entity;

import com.fabiozanela.hotel.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComBoleto")
public class PagamentoComDinheiro  extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Double valor;
	
	public PagamentoComDinheiro() {}

	public PagamentoComDinheiro(Integer id, EstadoPagamento estado, Reserva reserva, Double valor) {
		super(id, estado, reserva);
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
