package com.touristo.touristoApi.service;

import com.touristo.touristoApi.model.Circuit;
import com.touristo.touristoApi.model.Journey;
import com.touristo.touristoApi.model.Site;
import com.touristo.touristoApi.repository.CircuitRepository;
import com.touristo.touristoApi.repository.SiteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CircuitServiceTest {

    @Mock
    private CircuitRepository circuitRepository;

    @Mock
    private SiteRepository siteRepository;

    @Mock
    private JourneyService journeyService;

    @InjectMocks
    private CircuitService circuitService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCircuit() {
        // Mock input parameters
        String departement = "exampleDepartement";
        Double latitude = 1.23;
        Double longitude = 4.56;
        Integer numberOfDays = 7;
        Integer numberOfSitesPerDay = 2;

        // Mock site repository
        List<Site> mockSites = new ArrayList<>();
        mockSites.add(new Site());
        when(siteRepository.findSitesByParameters(departement)).thenReturn(mockSites);

        // Mock circuit repository
        Circuit mockCircuit = new Circuit();
        when(circuitRepository.save(any(Circuit.class))).thenReturn(mockCircuit);

        // Perform the service method
        Circuit result = circuitService.createCircuit(departement, latitude, longitude, numberOfDays,
                numberOfSitesPerDay);

        // Verify site repository calls
        verify(siteRepository, times(1)).findSitesByParameters(departement);

        // Verify circuit repository calls
        verify(circuitRepository, times(1)).save(any(Circuit.class));

        // Verify the result
        assertEquals(mockCircuit, result);
    }

    @Test
    void testGetCircuitById() throws Exception {
        // Mock circuit ID
        UUID circuitId = UUID.randomUUID();

        // Mock circuit repository
        Circuit mockCircuit = new Circuit();
        when(circuitRepository.findById(circuitId)).thenReturn(Optional.of(mockCircuit));

        // Perform the service method
        Optional<Circuit> result = circuitService.getCircuitById(circuitId);

        // Verify circuit repository calls
        verify(circuitRepository, times(1)).findById(circuitId);

        // Verify the result
        assertEquals(Optional.of(mockCircuit), result);
    }

    @Test
    void testGetCircuits() {
        // Mock circuit repository
        List<Circuit> mockCircuits = new ArrayList<>();
        mockCircuits.add(new Circuit());
        when(circuitRepository.findAll()).thenReturn(mockCircuits);

        // Perform the service method
        List<Circuit> result = circuitService.getCircuits();

        // Verify circuit repository calls
        verify(circuitRepository, times(1)).findAll();

        // Verify the result
        assertEquals(mockCircuits, result);
    }
}
