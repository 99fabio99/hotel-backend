package com.fabiozanela.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Caracteristica;
import com.fabiozanela.hotel.dto.CaracteristicaDTO;
import com.fabiozanela.hotel.repositories.CaracteristicaRepository;

@Service
public class CaracteristicaService {

	@Autowired
	private CaracteristicaRepository caracteristicaRepository;
	
	public List<Caracteristica> findAll(){
		return caracteristicaRepository.findAll();
	}
	
	public Caracteristica fromDTO(CaracteristicaDTO objDTO) {
		return new Caracteristica(objDTO.getId(), objDTO.getNome());
	}
	
	public Caracteristica insert(Caracteristica obj) {
		obj.setId(null);
		return caracteristicaRepository.save(obj);
	}
}
