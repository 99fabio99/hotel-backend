package com.fabiozanela.hotel.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.hotel.domain.Cliente;
import com.fabiozanela.hotel.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> find(){
		return ResponseEntity.ok().body(clienteService.findAll());
	}

}
