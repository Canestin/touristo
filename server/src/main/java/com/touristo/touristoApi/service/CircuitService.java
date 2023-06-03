package com.touristo.touristoApi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.touristo.touristoApi.DTO.ResponseDTO;
import com.touristo.touristoApi.model.Circuit;
import com.touristo.touristoApi.repository.CircuitRepository;

import jakarta.transaction.Transactional;

@Service
public class CircuitService {

    @Autowired
    CircuitRepository circuitRepository;

    @Transactional
    public ResponseDTO createCircuit(Circuit circuit) {
        circuitRepository.save(circuit);

        ResponseDTO responseDTO = new ResponseDTO("success", "circuit successfully created");
        return responseDTO;
    }

    public Circuit getCircuitById(UUID circuitId) {
        Optional<Circuit> optionalCircuit = circuitRepository.findById(circuitId);
        if (optionalCircuit.isPresent()) {
            return optionalCircuit.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "site not found with ID: " + circuitId);
        }
    }

    public List<Circuit> listCircuits() {
        List<Circuit> sites = circuitRepository.findAll();
        return sites;
    }
}
