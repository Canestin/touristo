package com.touristo.touristoApi.service;


import com.touristo.touristoApi.model.Circuit;
import com.touristo.touristoApi.model.Journey;
import com.touristo.touristoApi.model.Site;
import com.touristo.touristoApi.repository.CircuitRepository;
import com.touristo.touristoApi.repository.JourneyRepository;
import com.touristo.touristoApi.repository.SiteRepository;
import com.touristo.touristoApi.repository.SiteRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CircuitService {

    @Autowired
    CircuitRepository circuitRepository;

    @Autowired
    SiteRepositoryImpl siteRepository;

    @Transactional
    public Circuit createCircuit(String city, Optional<String> codeDepartment, Optional<String> type,
                                 Integer numberOfDays, Optional<Integer> numberOfSitesPerDay,
                                 Optional<String> historicalContext, Double latitude, Double longitude) {
        System.out.println(city+" "+ codeDepartment);
        Site home = new Site();
        home.setId(UUID.randomUUID());
        home.setName("Home");
        home.setLatitude(latitude);
        home.setLongitude(longitude);

        List<Site> sites = siteRepository.findSitesByParameters(city, codeDepartment.orElse(null), type.orElse(null),
                numberOfDays, numberOfSitesPerDay.orElse(5), historicalContext.orElse(null));
        System.out.println(sites);

        Circuit circuit = new Circuit();
        circuit.setNumberOfDays(numberOfDays);
        circuit.setJourneys(new ArrayList<>()); // Initialize the list of journeys in the circuit

        int siteIndex = 0;
        for (int i = 0; i < numberOfDays; i++) {
            Journey journey = new Journey();
            journey.setSites(new ArrayList<>()); // Initialize the list of sites in the journey

            for (int j = 0; j < numberOfSitesPerDay.orElse(5); j++) {
                if (siteIndex < sites.size()) {
                    Site site = sites.get(siteIndex);
                    journey.getSites().add(site);
                    siteIndex++;
                }
            }

            circuit.getJourneys().add(journey);
        }

       return circuitRepository.save(circuit);

    }


    public Optional<Circuit> getCircuitById(UUID id) throws Exception {
        Optional<Circuit> circuit = circuitRepository.findById(id);
        return circuit;
    }

    public  List<Circuit> getCircuits(){
        List<Circuit> circuits = circuitRepository.findAll();
        return circuits;
    }


}

