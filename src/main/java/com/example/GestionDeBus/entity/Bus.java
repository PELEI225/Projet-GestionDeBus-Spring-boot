package com.example.GestionDeBus.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="bus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Bus {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id ;

@Column(nullable =false , unique =true)
private String immatriculation;

@Column(nullable = false)
private int capacite;

@Column(nullable = false)
private String etat;

}