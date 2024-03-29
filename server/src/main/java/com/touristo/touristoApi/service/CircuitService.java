package com.touristo.touristoApi.service;

import com.touristo.touristoApi.model.Circuit;
import com.touristo.touristoApi.model.Journey;
import com.touristo.touristoApi.model.Site;
import com.touristo.touristoApi.repository.CircuitRepository;
import com.touristo.touristoApi.repository.SiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    SiteRepository siteRepository;

    @Autowired
    JourneyService journeyService;

    @Transactional
    public Circuit createCircuit(String departement, Double latitude, Double longitude, Integer numberOfDays,
            Integer numberOfSitesPerDay, String type, String historicalContext) {
        // System.out.println(city+" "+ codeDepartment);

        Site home = new Site();
        home.setName("Home");
        home.setLatitude(latitude);
        home.setLongitude(longitude);
        siteRepository.save(home);
        List<Site> sites;
        System.out.println(historicalContext);

        // departement *
        // departemt & type
        // departement & hC
        // d & hc & t
        if ("all".equals(historicalContext)) {
            if (type.isEmpty()) {
                sites = siteRepository.findSitesByParameters(departement);
            } else {
                sites = siteRepository.findSitesByDeptAndType(departement, type);
            }

        } else {
            if (type.isEmpty()) {
                sites = siteRepository.findSitesByDeptAndHistoricalContext(departement, historicalContext);
            } else {
                sites = siteRepository.findSitesByDeptAndHistoricalContextAndType(departement, historicalContext, type);
            }
        }

        System.out.println(sites);

        Circuit circuit = new Circuit();
        circuit.setNumberOfDays(numberOfDays);
        circuit.setJourneys(new ArrayList<>()); // Initialize the list of journeys in the circuit

        int siteIndex = 0;
        for (int i = 0; i < numberOfDays; i++) {
            Journey journey = new Journey();
            journey.setSites(new ArrayList<>()); // Initialize the list of sites in the journey

            for (int j = 0; j < numberOfSitesPerDay; j++) {

                if (siteIndex < sites.size()) {
                    Site site = sites.get(siteIndex);
                    journey.getSites().add(site);
                    siteIndex++;
                }
            }

            journey.getSites().add(home);
            TSPService tspService = new TSPService(journey.getSites(), home);
            journey.setSites(tspService.solveTSP());
            journey = journeyService.createJourney(journey.getSites());

            circuit.getJourneys().add(journey);

        }

        return circuitRepository.save(circuit);

    }

    public Optional<Circuit> getCircuitById(UUID id) throws Exception {
        Optional<Circuit> circuit = circuitRepository.findById(id);
        return circuit;
    }

    public List<Circuit> getCircuits() {
        List<Circuit> circuits = circuitRepository.findAll();
        return circuits;
    }

}
