package com.fabiozanela.hotel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.hotel.domain.Estacionamento;
import com.fabiozanela.hotel.services.EstacionamentoService;

@RestController
@RequestMapping(value="/estacionamentos")
public class EstacionamentoResource {
	
	@Autowired
	private EstacionamentoService estacionamentoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Estacionamento>> find(){
		return ResponseEntity.ok().body(estacionamentoService.findAll());
	}

}
