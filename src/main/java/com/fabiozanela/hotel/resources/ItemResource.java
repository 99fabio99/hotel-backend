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

import com.fabiozanela.hotel.domain.Item;
import com.fabiozanela.hotel.dto.ItemDTO;
import com.fabiozanela.hotel.dto.ItemNewDTO;
import com.fabiozanela.hotel.services.ItemService;

@RestController
@RequestMapping(value="/itens")
public class ItemResource {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ItemDTO>> find(){
		return ResponseEntity.ok().body(itemService.findAll());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ItemNewDTO objDto) {
		Item obj = itemService.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ItemNewDTO objDto, @PathVariable Integer id) {
		objDto.setId(id);
		itemService.update(objDto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		itemService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
