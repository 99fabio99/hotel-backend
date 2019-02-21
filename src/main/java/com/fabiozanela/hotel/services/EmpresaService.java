package com.fabiozanela.hotel.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Empresa;
import com.fabiozanela.hotel.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa find(){
		Optional<Empresa> emp = empresaRepository.findById(1);
		return emp.get();

	}
}
