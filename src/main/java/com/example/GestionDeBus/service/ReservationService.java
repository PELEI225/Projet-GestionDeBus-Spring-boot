
package com.example.GestionDeBus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionDeBus.entity.Client;
import com.example.GestionDeBus.entity.Reservation;
import com.example.GestionDeBus.entity.Voyage;
import com.example.GestionDeBus.repository.ClientRepository;
import com.example.GestionDeBus.repository.ReservationRepository;
import com.example.GestionDeBus.repository.VoyageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final VoyageRepository voyageRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée avec id : " + id));
    }

    public Reservation createReservation(Long clientId, Long voyageId, Reservation reservation) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec id : " + clientId));

        Voyage voyage = voyageRepository.findById(voyageId)
                .orElseThrow(() -> new RuntimeException("Voyage non trouvé avec id : " + voyageId));

        reservation.setClient(client);
        reservation.setVoyage(voyage);

        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Reservation reservation = getReservationById(id);
        reservation.setNombrePlaces(reservationDetails.getNombrePlaces());
        reservation.setDateReservation(reservationDetails.getDateReservation());
        reservation.setStatut(reservationDetails.getStatut());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = getReservationById(id);
        reservationRepository.delete(reservation);
    }
}
