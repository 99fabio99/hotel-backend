package com.fabiozanela.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiozanela.hotel.domain.ItemConsumido;

@Repository
public interface ItemConsumidoRepository extends JpaRepository<ItemConsumido, Integer>{

}
