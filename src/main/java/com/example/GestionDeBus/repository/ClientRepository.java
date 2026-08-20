package com.example.GestionDeBus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionDeBus.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}