package com.touristo.touristoApi.controller;

import com.touristo.touristoApi.DTO.ResponseDTO;
import com.touristo.touristoApi.model.Circuit;
import com.touristo.touristoApi.service.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/circuits")
public class CircuitController {

    @Autowired
    CircuitService circuitService;

    @PostMapping
    public ResponseEntity<ResponseDTO> createCircuit(@RequestBody Circuit circuit) {
        ResponseDTO response = circuitService.createCircuit(circuit);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{circuitId}")
    public ResponseEntity<Circuit> getCircuitById(@PathVariable UUID circuitId) {
        Circuit circuit = circuitService.getCircuitById(circuitId);
        return ResponseEntity.ok(circuit);
    }

    @GetMapping
    public ResponseEntity<List<Circuit>> listCircuits() {
        List<Circuit> circuits = circuitService.listCircuits();
        return ResponseEntity.ok(circuits);
    }
}
