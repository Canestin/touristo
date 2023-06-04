package com.touristo.touristoApi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.touristo.touristoApi.model.Journey;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, UUID> {

}