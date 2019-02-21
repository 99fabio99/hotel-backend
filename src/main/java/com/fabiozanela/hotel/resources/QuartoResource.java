package com.fabiozanela.hotel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.hotel.domain.Quarto;
import com.fabiozanela.hotel.services.QuartoService;

@RestController
@RequestMapping(value="/quartos")
public class QuartoResource {
	
	@Autowired
	private QuartoService quartoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Quarto>> find(){
		return ResponseEntity.ok().body(quartoService.findAll());
	}

}
