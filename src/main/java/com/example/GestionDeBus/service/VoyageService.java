package com.example.GestionDeBus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionDeBus.entity.Bus;
import com.example.GestionDeBus.entity.Chauffeur;
import com.example.GestionDeBus.entity.Ligne;
import com.example.GestionDeBus.entity.Voyage;
import com.example.GestionDeBus.repository.BusRepository;
import com.example.GestionDeBus.repository.ChauffeurRepository;
import com.example.GestionDeBus.repository.LigneRepository;
import com.example.GestionDeBus.repository.VoyageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoyageService {

    private final VoyageRepository voyageRepository;
    private final BusRepository busRepository;
    private final ChauffeurRepository chauffeurRepository;
    private final LigneRepository ligneRepository;

    public List<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    public Voyage getVoyageById(Long id) {
        return voyageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voyage non trouvé avec id : " + id));
    }

    public Voyage createVoyage(Long busId, Long chauffeurId, Long ligneId, Voyage voyage) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus non trouvé avec id : " + busId));

        Chauffeur chauffeur = chauffeurRepository.findById(chauffeurId)
                .orElseThrow(() -> new RuntimeException("Chauffeur non trouvé avec id : " + chauffeurId));

        Ligne ligne = ligneRepository.findById(ligneId)
                .orElseThrow(() -> new RuntimeException("Ligne non trouvée avec id : " + ligneId));

        voyage.setBus(bus);
        voyage.setChauffeur(chauffeur);
        voyage.setLigne(ligne);

        return voyageRepository.save(voyage);
    }

    public Voyage updateVoyage(Long id, Voyage voyageDetails) {
        Voyage voyage = getVoyageById(id);
        voyage.setDateDepart(voyageDetails.getDateDepart());
        voyage.setDateArrivee(voyageDetails.getDateArrivee());
        voyage.setPrix(voyageDetails.getPrix());
        return voyageRepository.save(voyage);
    }

    public void deleteVoyage(Long id) {
        Voyage voyage = getVoyageById(id);
        voyageRepository.delete(voyage);
    }
}
