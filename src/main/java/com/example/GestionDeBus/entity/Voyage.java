package com.example.GestionDeBus.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name= "voyage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Voyage {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne
    @JoinColumn(name= "bus_id" , nullable= false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(name= "chauffeur_id" , nullable= false)
    private Chauffeur chauffeur;

    @ManyToOne
    @JoinColumn(name= "ligne_id" , nullable= false)
    private Ligne ligne;
    

    @Column(nullable= false)
    private LocalDateTime dateDepart;

    @Column(nullable= false)
    private LocalDateTime dateArrivee;

    @Column(nullable= false)
    private double prix;






}
