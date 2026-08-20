package com.example.GestionDeBus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionDeBus.entity.Paiement;
import com.example.GestionDeBus.entity.Reservation;
import com.example.GestionDeBus.repository.PaiementRepository;
import com.example.GestionDeBus.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaiementService {

    private final PaiementRepository paiementRepository;
    private final ReservationRepository reservationRepository;

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement getPaiementById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec id : " + id));
    }

    public Paiement createPaiement(Long reservationId, Paiement paiement) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée avec id : " + reservationId));

        paiement.setReservation(reservation);

        return paiementRepository.save(paiement);
    }

    public Paiement updatePaiement(Long id, Paiement paiementDetails) {
        Paiement paiement = getPaiementById(id);
        paiement.setMontant(paiementDetails.getMontant());
        paiement.setDatePaiement(paiementDetails.getDatePaiement());
        paiement.setMethode(paiementDetails.getMethode());
        return paiementRepository.save(paiement);
    }

    public void deletePaiement(Long id) {
        Paiement paiement = getPaiementById(id);
        paiementRepository.delete(paiement);
    }
}
