package com.example.GestionDeBus.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeBus.entity.Voyage;
import com.example.GestionDeBus.service.VoyageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/voyage")
@RequiredArgsConstructor
public class VoyageController {

    private final VoyageService voyageService;

    @GetMapping
    public ResponseEntity<List<Voyage>> getAllVoyages() {
        return ResponseEntity.ok(voyageService.getAllVoyages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voyage> getVoyageById(@PathVariable Long id) {
        return ResponseEntity.ok(voyageService.getVoyageById(id));
    }

    @PostMapping
    public ResponseEntity<Voyage> createVoyage(
            @RequestParam Long busId,
            @RequestParam Long chauffeurId,
            @RequestParam Long ligneId,
            @RequestBody Voyage voyage) {

        return ResponseEntity.ok(voyageService.createVoyage(busId, chauffeurId, ligneId, voyage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voyage> updateVoyage(@PathVariable Long id, @RequestBody Voyage voyage) {
        return ResponseEntity.ok(voyageService.updateVoyage(id, voyage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoyage(@PathVariable Long id) {
        voyageService.deleteVoyage(id);
        return ResponseEntity.noContent().build();
    }
}
