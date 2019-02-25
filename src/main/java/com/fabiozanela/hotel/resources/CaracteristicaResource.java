package com.fabiozanela.hotel.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabiozanela.hotel.domain.Caracteristica;
import com.fabiozanela.hotel.dto.CaracteristicaDTO;
import com.fabiozanela.hotel.services.CaracteristicaService;

@RestController
@RequestMapping(value="/caracteristicas")
public class CaracteristicaResource {
	
	@Autowired
	private CaracteristicaService caracteristicaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CaracteristicaDTO>> find(){
		List<Caracteristica> listCaracteristica = caracteristicaService.findAll();
		List<CaracteristicaDTO> listCaracteristicaDTO = listCaracteristica.stream().map(obj -> new CaracteristicaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listCaracteristicaDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CaracteristicaDTO objDto) {
		Caracteristica obj = caracteristicaService.fromDTO(objDto);
		obj = caracteristicaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
