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
@Table(name ="chauffeur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chauffeur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    
    @Column(nullable = false)
    private String nom ;

    @Column(nullable= false)
    private String prenom;

    

    @Column(nullable= false)
    private String numeroPermis;

}
    

