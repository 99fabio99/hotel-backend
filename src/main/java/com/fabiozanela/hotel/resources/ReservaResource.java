package com.fabiozanela.hotel.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabiozanela.hotel.domain.Reserva;
import com.fabiozanela.hotel.dto.ReservaNewDTO;
import com.fabiozanela.hotel.services.ReservaService;

@RestController
@RequestMapping(value="/reservas")
public class ReservaResource {
	
	@Autowired
	private ReservaService reservaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ReservaNewDTO>> find(){
		return ResponseEntity.ok().body(reservaService.findAll());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ReservaNewDTO objDto) throws ParseException {
		Reserva obj = reservaService.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

}
