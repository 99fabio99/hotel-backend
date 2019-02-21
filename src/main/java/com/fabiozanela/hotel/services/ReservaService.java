package com.fabiozanela.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Reserva;
import com.fabiozanela.hotel.repositories.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	public List<Reserva> findAll(){
		return reservaRepository.findAll();
	}
}
