
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

import com.example.GestionDeBus.entity.Bus;
import com.example.GestionDeBus.service.BusService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/bus")
@RequiredArgsConstructor

public class BusController {
    
    private final BusService busService;

@GetMapping

public ResponseEntity<List<Bus>>getAllBus() {

    return ResponseEntity.ok(busService.getAllBus());

}
@GetMapping("/{id}")
public  ResponseEntity<Bus> getBusById(@PathVariable Long id){

    return ResponseEntity.ok(busService.getBusById(id));
}
@PostMapping
public ResponseEntity<Bus>createBus(@RequestBody Bus bus){

    return ResponseEntity.ok(busService.createBus(bus));
}
@PutMapping("/{id}")
public ResponseEntity<Bus>updateBus(@PathVariable Long id , @RequestBody Bus bus) {

    return ResponseEntity.ok(busService.updateBus(id, bus));
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBus(@PathVariable Long id){
    busService.deleteBus(id);
    return ResponseEntity.noContent().build();
}
}
