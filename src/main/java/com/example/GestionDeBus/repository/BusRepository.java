package com.example.GestionDeBus.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeBus.entity.Bus;

@Repository

public interface BusRepository extends JpaRepository<Bus , Long>{

}
