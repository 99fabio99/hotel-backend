package com.fabiozanela.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiozanela.hotel.domain.PerfilQuarto;

@Repository
public interface PerfilQuartoRepository extends JpaRepository<PerfilQuarto, Integer>{

}
