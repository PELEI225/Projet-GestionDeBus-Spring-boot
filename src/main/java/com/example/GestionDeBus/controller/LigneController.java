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
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.example.GestionDeBus.entity.Ligne;
import com.example.GestionDeBus.service.LigneService;

@RestController
@RequestMapping("/api/ligne")
@RequiredArgsConstructor
public class LigneController {

    private  final LigneService ligneService;

      @GetMapping
    public ResponseEntity<List<Ligne>> getAllLignes() {
        return ResponseEntity.ok(ligneService.getAllLignes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ligne> getLigneById(@PathVariable Long id) {
        return ResponseEntity.ok(ligneService.getLigneById(id));
    }



    @PostMapping
    
    public ResponseEntity<Ligne> createLigne(@RequestBody Ligne   ligne){
    
    return ResponseEntity.ok(ligneService.createLigne(ligne));

    }

    @PutMapping("/{id}")

    public ResponseEntity<Ligne> updateLigne(@PathVariable Long id, @RequestBody Ligne ligne){

        return ResponseEntity.ok(ligneService.updateLigne(id, ligne));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigne(@PathVariable Long id){

        ligneService.deleteLigne(id);
        return ResponseEntity.noContent().build();
    }

        
    

    

}
