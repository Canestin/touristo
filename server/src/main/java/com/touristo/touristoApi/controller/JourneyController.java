package com.touristo.touristoApi.controller;

import com.touristo.touristoApi.model.Journey;
import com.touristo.touristoApi.model.Site;
import com.touristo.touristoApi.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/journeys")
public class JourneyController {

    private final JourneyService journeyService;

    @Autowired
    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @PostMapping
    public ResponseEntity<Journey> createJourney(@RequestBody List<Site> sites) {
        Journey createdJourney = journeyService.createJourney(sites);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJourney);
    }

    @GetMapping("/{journeyId}")
    public ResponseEntity<Journey> getJourneyById(@PathVariable UUID journeyId) {
        Optional<Journey> journey = journeyService.getJourneyById(journeyId);
        return journey.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Journey>> getAllJourneys() {
        List<Journey> journeys = journeyService.getJourneys();
        return ResponseEntity.ok(journeys);
    }
}
