package com.fabiozanela.hotel.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiozanela.hotel.domain.Empresa;
import com.fabiozanela.hotel.domain.PerfilQuarto;
import com.fabiozanela.hotel.domain.Quarto;
import com.fabiozanela.hotel.dto.QuartoNewDTO;
import com.fabiozanela.hotel.repositories.EmpresaRepository;
import com.fabiozanela.hotel.repositories.PerfilQuartoRepository;
import com.fabiozanela.hotel.repositories.QuartoRepository;
import com.fabiozanela.hotel.services.exceptions.ObjectNotFoundException;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository quartoRepository;

	@Autowired
	private PerfilQuartoRepository perfilQuartoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<Quarto> findAll() {
		return quartoRepository.findAll();
	}

	public Quarto findById(Integer id) {
		return quartoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public Quarto insert(QuartoNewDTO objDTO) {
		PerfilQuarto objPerfilQuarto = perfilQuartoRepository.findById(objDTO.getPerfilQuarto().getId()).get();
		Empresa objEmpresa = empresaRepository.findById(1).get();
		Quarto obj = new Quarto(objDTO.getId(), objDTO.getNome(), objEmpresa, objPerfilQuarto);

		obj = quartoRepository.save(obj);
		objPerfilQuarto.getQuartos().add(obj);
		objEmpresa.getQuartos().add(obj);

		perfilQuartoRepository.save(objPerfilQuarto);
		empresaRepository.save(objEmpresa);

		return obj;
	}

	public Quarto update(QuartoNewDTO objDTO) {
		Quarto obj = quartoRepository.findById(objDTO.getId()).get();
		if (objDTO.getPerfilQuarto() != null) {
			if (obj.getPerfilQuarto().getId() != objDTO.getPerfilQuarto().getId()) {
				PerfilQuarto objPerfilQuarto = perfilQuartoRepository.findById(objDTO.getPerfilQuarto().getId()).get();
				PerfilQuarto objPerfilQuartoAux = perfilQuartoRepository.findById(objDTO.getPerfilQuarto().getId())
						.get();
				objPerfilQuartoAux.getQuartos().remove(obj);
				objPerfilQuarto.getQuartos().add(obj);
				obj.setNome(objDTO.getNome());
				perfilQuartoRepository.saveAll(Arrays.asList(objPerfilQuarto, objPerfilQuartoAux));
				return quartoRepository.save(obj);
			}
		}
		obj.setNome(objDTO.getNome());
		return quartoRepository.save(obj);

	}

	public Quarto convertaParaClasse(QuartoNewDTO objDTO) {
		PerfilQuarto objPerfilQuarto = perfilQuartoRepository.findById(objDTO.getPerfilQuarto().getId()).get();
		Empresa objEmpresa = empresaRepository.findById(1).get();
		return new Quarto(objDTO.getId(), objDTO.getNome(), objEmpresa, objPerfilQuarto);
	}
}
