package com.fabiozanela.hotel.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabiozanela.hotel.domain.PerfilQuarto;
import com.fabiozanela.hotel.dto.PerfilQuartoDTO;
import com.fabiozanela.hotel.services.PerfilQuartoService;

@RestController
@RequestMapping(value="/perfisQuarto")
public class PerfilQuartoResource {
	
	@Autowired
	private PerfilQuartoService perfilQuartoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PerfilQuartoDTO>> find(){
		return ResponseEntity.ok().body(perfilQuartoService.findAll());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PerfilQuartoDTO objDto) {
		PerfilQuarto obj = perfilQuartoService.fromDTO(objDto);
		obj = perfilQuartoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PerfilQuartoDTO objDto, @PathVariable Integer id) {
		PerfilQuarto obj = perfilQuartoService.fromDTO(objDto);
		obj.setId(id);
		obj = perfilQuartoService.update(obj);
		return ResponseEntity.noContent().build();
	}

}
