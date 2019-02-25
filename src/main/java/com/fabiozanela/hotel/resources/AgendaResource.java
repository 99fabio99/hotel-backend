package com.fabiozanela.hotel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.hotel.dto.AgendaDTO;
import com.fabiozanela.hotel.services.AgendaService;

@RestController
@RequestMapping(value="/agendas")
public class AgendaResource {
	
	@Autowired
	private AgendaService agendaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> find(){
		return ResponseEntity.ok().body(agendaService.findAll());
	}

}
