package com.fabiozanela.hotel.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiozanela.hotel.domain.Agenda;
import com.fabiozanela.hotel.domain.Quarto;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer>{

	@Transactional(readOnly=true)
	public List<Agenda> findByDateAndQuartosIn(Date date, Quarto quartos);
	
	@Transactional(readOnly=true)
	public Agenda findByQuartosIn(Quarto quartos);
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Agenda obj WHERE obj.date BETWEEN :dateInicio AND :dateFim")
	public List<Agenda> findByAgendaDate(@Param("dateInicio") Date dateInicio, @Param("dateFim")Date dateFim);
	
	
	
}
