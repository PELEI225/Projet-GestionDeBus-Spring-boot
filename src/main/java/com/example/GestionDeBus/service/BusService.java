package com.example.GestionDeBus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionDeBus.entity.Bus;
import com.example.GestionDeBus.repository.BusRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusService {
    private final BusRepository busRepository;

    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }

    public Bus getBusById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus non trouvé avec id : " + id));

        
    }
    public Bus createBus(Bus bus){
        return busRepository.save(bus);  
    
    }
    public Bus updateBus(Long id, Bus busDetails) {
        Bus bus = getBusById(id);
        bus.setImmatriculation(busDetails.getImmatriculation());
        bus.setCapacite(busDetails.getCapacite());
        bus.setEtat(busDetails.getEtat());
        return busRepository.save(bus);
    }

    public void deleteBus(Long id) {
        Bus bus = getBusById(id);
        busRepository.delete(bus);
    }
}
