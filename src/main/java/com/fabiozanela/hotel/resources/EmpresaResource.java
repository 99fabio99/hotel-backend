package com.fabiozanela.hotel.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiozanela.hotel.domain.Empresa;
import com.fabiozanela.hotel.services.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {
	
	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Empresa> find(){
		return ResponseEntity.ok().body(empresaService.find());
	}

}
