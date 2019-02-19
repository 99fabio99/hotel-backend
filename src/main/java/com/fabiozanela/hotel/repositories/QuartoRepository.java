package com.fabiozanela.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiozanela.hotel.domain.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer>{

}
