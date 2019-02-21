package com.fabiozanela.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Estacionamento;
import com.fabiozanela.hotel.repositories.EstacionamentoRepository;

@Service
public class EstacionamentoService {

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	public List<Estacionamento> findAll(){
		return estacionamentoRepository.findAll();
	}
}
