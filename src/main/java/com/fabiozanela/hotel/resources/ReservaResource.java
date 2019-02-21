package com.fabiozanela.hotel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.hotel.domain.Reserva;
import com.fabiozanela.hotel.services.ReservaService;

@RestController
@RequestMapping(value="/reservas")
public class ReservaResource {
	
	@Autowired
	private ReservaService reservaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Reserva>> find(){
		return ResponseEntity.ok().body(reservaService.findAll());
	}

}
