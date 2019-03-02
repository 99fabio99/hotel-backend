package com.fabiozanela.hotel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Categoria;
import com.fabiozanela.hotel.domain.Item;
import com.fabiozanela.hotel.dto.ItemDTO;
import com.fabiozanela.hotel.dto.ItemNewDTO;
import com.fabiozanela.hotel.repositories.CategoriaRepository;
import com.fabiozanela.hotel.repositories.EmpresaRepository;
import com.fabiozanela.hotel.repositories.ItemRepository;
import com.fabiozanela.hotel.services.exceptions.DataIntegrityException;
import com.fabiozanela.hotel.services.exceptions.ObjectNotFoundException;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<ItemDTO> findAll(){
		return itemRepository.findAll().stream().map(obj -> new ItemDTO(obj)).collect(Collectors.toList());
	}
	
	public Item findById(Integer id) {
		Optional<Item> obj = itemRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	public Item insert(ItemNewDTO objDTO) {
		objDTO.setId(null);
		Item obj = convertaParaClasse(objDTO);
		obj.setEmpresa(empresaRepository.findById(1).get());
		obj = itemRepository.save(obj);
		obj.getCategoria().getItens().add(obj);
		categoriaRepository.save(obj.getCategoria());
		return obj;
		
	}
	
	public Item update(ItemNewDTO objDTO) {
		Item obj = convertaParaClasse(objDTO);
		obj.setEmpresa(empresaRepository.findById(1).get());
		obj = itemRepository.save(obj);
		obj.getCategoria().getItens().add(obj);
		categoriaRepository.save(obj.getCategoria());
		return obj;
	}
	
	public void delete(Integer id) {
		Item obj = findById(id);
		try {
			Categoria objCategoria = categoriaRepository.findById(obj.getCategoria().getId()).get();
			objCategoria.getItens().remove(obj);
			categoriaRepository.save(objCategoria);
			itemRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma item que esteja sendo utilizado");
		}
	}
	
	public Item convertaParaClasse(ItemNewDTO obj) {
		return new Item(obj.getId(), obj.getNome(), obj.getValor(), obj.getCodigoBarro(), obj.getQuantidade(), null, obj.getCategoria());
	}
}
