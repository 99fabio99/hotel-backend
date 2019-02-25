package com.fabiozanela.hotel.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Caracteristica;
import com.fabiozanela.hotel.domain.PerfilQuarto;
import com.fabiozanela.hotel.dto.CaracteristicaDTO;
import com.fabiozanela.hotel.dto.PerfilQuartoDTO;
import com.fabiozanela.hotel.dto.QuartoDTO;
import com.fabiozanela.hotel.repositories.CaracteristicaRepository;
import com.fabiozanela.hotel.repositories.PerfilQuartoRepository;

@Service
public class PerfilQuartoService {

	@Autowired
	private PerfilQuartoRepository perfilQuartoRepository;
	
	@Autowired
	private CaracteristicaRepository caracteristicaRepository;
	
//	@Autowired
//	private QuartoRepository quartoRepository;
	
	public List<PerfilQuartoDTO> findAll(){
		List<PerfilQuarto> perfisQuarto = perfilQuartoRepository.findAll();
		List<PerfilQuartoDTO> perfilQuartoDTO = new ArrayList<>();
		
		for(PerfilQuarto perfilQuarto : perfisQuarto) {
			PerfilQuartoDTO aux = new PerfilQuartoDTO(perfilQuarto);
			
			List<QuartoDTO> listQuartoDTO = perfilQuarto.getQuartos().stream().map(obj -> new QuartoDTO(obj)).collect(Collectors.toList());
			aux.setQuartoDTO(listQuartoDTO);
			
			List<CaracteristicaDTO> listCaracteristicaDTO = perfilQuarto.getCaracteristicas().stream().map(obj -> new CaracteristicaDTO(obj)).collect(Collectors.toList());
			aux.setCaracteristicaDTO(listCaracteristicaDTO);
			
			perfilQuartoDTO.add(aux);
		}
		return perfilQuartoDTO;
	}
	
	public PerfilQuarto fromDTO(PerfilQuartoDTO objDTO) {
		PerfilQuarto perfilQuarto = new PerfilQuarto(objDTO.getId(), objDTO.getNome(), objDTO.getValorBase(), objDTO.getAdulto(), objDTO.getCrianca());
		for(CaracteristicaDTO aux : objDTO.getCaracteristicas()){
			Caracteristica obj = caracteristicaRepository.findById(aux.getId()).get();
			perfilQuarto.getCaracteristicas().add(obj);
			obj.getPerfilQuartos().add(perfilQuarto);
		}
		return perfilQuarto;
	}
	
	public PerfilQuarto insert(PerfilQuarto obj) {
		obj.setId(null);
		obj = perfilQuartoRepository.save(obj);
		caracteristicaRepository.saveAll(obj.getCaracteristicas());
		return obj;
	}
	
	public PerfilQuarto update(PerfilQuarto obj) {
		return perfilQuartoRepository.save(obj);
	}
}
