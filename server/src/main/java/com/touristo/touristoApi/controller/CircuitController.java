package com.touristo.touristoApi.controller;

import com.touristo.touristoApi.model.Circuit;
import com.touristo.touristoApi.service.CircuitService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/circuits")
public class CircuitController {

    private final CircuitService circuitService;

    @Autowired
    public CircuitController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    @PostMapping
    public Circuit createCircuit(
            @RequestParam String departement,
            @RequestParam Double latitude,
            @RequestParam Double longitude
    ) {
      return circuitService.createCircuit(departement, latitude, longitude);
    }

    @GetMapping("/{circuitId}")
    public ResponseEntity<Circuit> getCircuitById(@PathVariable UUID circuitId) throws Exception {
        Optional<Circuit> circuit = circuitService.getCircuitById(circuitId);
        return circuit.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Circuit>> getAllCircuits() {
        List<Circuit> circuits = circuitService.getCircuits();
        return ResponseEntity.ok(circuits);
    }

    @Getter
    public static class CircuitRequest {
        private String city;
        private String codeDepartment;
        private String type;
        private Integer numberOfDays;
        private Integer numberOfSitesPerDay;
        private String historicalContext;
        private Double latitude;
        private Double longitude;

    }
}
