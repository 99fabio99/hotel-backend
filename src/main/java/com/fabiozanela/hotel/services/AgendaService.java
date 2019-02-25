package com.fabiozanela.hotel.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Agenda;
import com.fabiozanela.hotel.dto.AgendaDTO;
import com.fabiozanela.hotel.repositories.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;
	
	public List<AgendaDTO> findAll(){
		List<Agenda> agenda = agendaRepository.findAll();
		List<AgendaDTO> listDTO = new ArrayList<>();//agenda.stream().map(obj -> new AgendaDTO(obj)).collect(Collectors.toList());
		for(Agenda aux : agenda) {
			AgendaDTO objDTO = new AgendaDTO(aux);
			objDTO.setQuartos(aux.getQuartos());
			objDTO.setEstacionamentos(aux.getEstacionamentos());
			objDTO.setVeiculos(aux.getVeiculos());
			listDTO.add(objDTO);
		}
		
		return listDTO;
	}
}
