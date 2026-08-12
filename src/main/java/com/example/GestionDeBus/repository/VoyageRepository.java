package com.example.GestionDeBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeBus.entity.Voyage;

@Repository

public interface VoyageRepository  extends   JpaRepository<Voyage, Long>{

}
