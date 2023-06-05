package com.touristo.touristoApi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.touristo.touristoApi.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touristo.touristoApi.model.Journey;
import com.touristo.touristoApi.repository.JourneyRepository;

import jakarta.transaction.Transactional;

@Service
public class JourneyService {

    @Autowired
    JourneyRepository journeyRepository;

    @Transactional
    public Journey createJourney(List<Site> sites) {

        Journey journey = new Journey();
        journey.setSites(sites);
        System.out.println("return journeyRepository.save(journey)");
        return journeyRepository.save(journey);
    }

    public Optional<Journey> getJourneyById(UUID journeyId) {
        return journeyRepository.findById(journeyId);
    }

    public List<Journey> getJourneys() {
        List<Journey> sites = journeyRepository.findAll();
        return sites;
    }
}
