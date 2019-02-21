package com.fabiozanela.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Empresa;
import com.fabiozanela.hotel.domain.Quarto;
import com.fabiozanela.hotel.repositories.QuartoRepository;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository quartoRepository;
	
	public List<Quarto> findAll(){
		return quartoRepository.findAll();
	}
}
