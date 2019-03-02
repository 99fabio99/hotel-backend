package com.fabiozanela.hotel.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Categoria;
import com.fabiozanela.hotel.dto.CategoriaDTO;
import com.fabiozanela.hotel.repositories.CategoriaRepository;
import com.fabiozanela.hotel.services.exceptions.DataIntegrityException;
import com.fabiozanela.hotel.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<CategoriaDTO> findAll(){
		return categoriaRepository.findAll().stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	}
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	public Categoria insert(CategoriaDTO objDTO) {
		objDTO.setId(null);
		Categoria obj = convertaParaClasse(objDTO);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update(CategoriaDTO objDTO) {
		Categoria obj = convertaParaClasse(objDTO);
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			categoriaRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public Categoria convertaParaClasse(CategoriaDTO obj) {
		return new Categoria(obj.getId(), obj.getNome());
	}
}
