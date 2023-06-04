package com.touristo.touristoApi.repository;

import com.touristo.touristoApi.model.Circuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CircuitRepository extends JpaRepository<Circuit,UUID > {

}
