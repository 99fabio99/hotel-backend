package com.fabiozanela.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiozanela.hotel.domain.Caracteristica;
import com.fabiozanela.hotel.domain.Reserva;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Integer>{

}
