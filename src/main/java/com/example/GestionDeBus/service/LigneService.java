package com.example.GestionDeBus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionDeBus.entity.Ligne;
import com.example.GestionDeBus.repository.LigneRepository;
import lombok.RequiredArgsConstructor;
@Service 
@RequiredArgsConstructor
public class LigneService {

    private final LigneRepository ligneRepository;

    public List<Ligne> getAllLignes(){

        return ligneRepository.findAll();
    }

public Ligne getLigneById(Long id) {

    return ligneRepository.findById(id)
                           .orElseThrow(() -> new RuntimeException("Ligne non trouvé avec id : " + id));
}
 
public Ligne createLigne(Ligne ligne) {

    return ligneRepository.save(ligne);
}


public Ligne updateLigne(Long id , Ligne ligneDetails) {

    Ligne ligne  = getLigneById(id);

    ligne.setVilleDepart(ligneDetails.getVilleDepart());
    ligne.setVilleArrivee(ligneDetails.getVilleArrivee());
    ligne.setDistanceKm(ligneDetails.getDistanceKm());
    return ligneRepository.save(ligne);
}

public void deleteLigne(Long id) {

    Ligne ligne = getLigneById(id);
    ligneRepository.delete(ligne);
}

}
