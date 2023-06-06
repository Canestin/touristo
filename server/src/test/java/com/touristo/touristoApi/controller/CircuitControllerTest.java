package com.touristo.touristoApi.controller;

import com.touristo.touristoApi.model.Circuit;
import com.touristo.touristoApi.service.CircuitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CircuitControllerTest {

    @Mock
    private CircuitService circuitService;

    @InjectMocks
    private CircuitController circuitController;

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

        // Mock circuit creation
        Circuit mockCircuit = new Circuit();
        when(circuitService.createCircuit(departement, latitude, longitude, numberOfDays, numberOfSitesPerDay))
                .thenReturn(mockCircuit);

        // Perform the API call
        Circuit result = circuitController.createCircuit(departement, latitude, longitude, numberOfDays,
                numberOfSitesPerDay);

        // Verify the circuit service was called with the correct parameters
        verify(circuitService, times(1)).createCircuit(departement, latitude, longitude, numberOfDays,
                numberOfSitesPerDay);

        // Verify the result matches the mock circuit
        assertEquals(mockCircuit, result);
    }

    @Test
    void testGetCircuitById() throws Exception {
        // Mock circuit ID
        UUID circuitId = UUID.randomUUID();

        // Mock circuit retrieval
        Circuit mockCircuit = new Circuit();
        when(circuitService.getCircuitById(circuitId)).thenReturn(Optional.of(mockCircuit));

        // Perform the API call
        ResponseEntity<Circuit> response = circuitController.getCircuitById(circuitId);

        // Verify the circuit service was called with the correct circuit ID
        verify(circuitService, times(1)).getCircuitById(circuitId);

        // Verify the response is OK and contains the mock circuit
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCircuit, response.getBody());
    }

    @Test
    void testGetCircuitById_NotFound() throws Exception {
        // Mock circuit ID
        UUID circuitId = UUID.randomUUID();

        // Mock circuit retrieval returning an empty optional
        when(circuitService.getCircuitById(circuitId)).thenReturn(Optional.empty());

        // Perform the API call
        ResponseEntity<Circuit> response = circuitController.getCircuitById(circuitId);

        // Verify the circuit service was called with the correct circuit ID
        verify(circuitService, times(1)).getCircuitById(circuitId);

        // Verify the response is not found
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testGetAllCircuits() {
        // Mock circuit list
        List<Circuit> mockCircuits = new ArrayList<>();
        mockCircuits.add(new Circuit());
        mockCircuits.add(new Circuit());
        when(circuitService.getCircuits()).thenReturn(mockCircuits);

        // Perform the API call
        ResponseEntity<List<Circuit>> response = circuitController.getAllCircuits();

        // Verify the circuit service was called to get all circuits
        verify(circuitService, times(1)).getCircuits();

        // Verify the response is OK and contains the mock circuits
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCircuits, response.getBody());
    }
}
