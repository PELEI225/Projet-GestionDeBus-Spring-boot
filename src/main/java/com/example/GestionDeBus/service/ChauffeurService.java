package com.example.GestionDeBus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionDeBus.entity.Chauffeur;
import com.example.GestionDeBus.entity.Voyage;
import com.example.GestionDeBus.repository.ChauffeurRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChauffeurService {

    private final ChauffeurRepository chauffeurRepository;

    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurRepository.findAll();
    }

    public Chauffeur getChauffeurById(Long id) {
        return chauffeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur non trouvé avec id : " + id));
    }

    public Chauffeur createChauffeur(Chauffeur chauffeur) {
        return chauffeurRepository.save(chauffeur);
    }

    public Chauffeur updateChauffeur(Long id, Chauffeur chauffeurDetails) {
        Chauffeur chauffeur = getChauffeurById(id);
        chauffeur.setNom(chauffeurDetails.getNom());
        chauffeur.setPrenom(chauffeurDetails.getPrenom());
        chauffeur.setNumeroPermis(chauffeurDetails.getNumeroPermis());
        return chauffeurRepository.save(chauffeur);
    }

    public void deleteChauffeur(Long id) {
        Chauffeur chauffeur = getChauffeurById(id);
        chauffeurRepository.delete(chauffeur);
    }
}
