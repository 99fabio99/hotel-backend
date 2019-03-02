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

import com.fabiozanela.hotel.domain.Quarto;
import com.fabiozanela.hotel.dto.QuartoNewDTO;
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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Quarto> findById( @PathVariable Integer id) {
		Quarto obj = quartoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody QuartoNewDTO objDto) {
		Quarto obj = quartoService.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody QuartoNewDTO objDto,  @PathVariable Integer id) {
		objDto.setId(id);
		Quarto obj = quartoService.update(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
