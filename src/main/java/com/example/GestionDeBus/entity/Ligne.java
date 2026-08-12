package com.example.GestionDeBus.entity;

import java.lang.annotation.Inherited;

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
@Table(name ="ligne")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ligne {

    


    @Id 
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String villeDepart ;

    @Column(nullable = false)
    private String villeArrivee ;

    @Column(nullable = false)
    private int distanceKm ;

}
