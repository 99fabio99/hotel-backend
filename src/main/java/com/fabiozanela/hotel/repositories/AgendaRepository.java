package com.fabiozanela.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiozanela.hotel.domain.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer>{

}
