package com.touristo.touristoApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "journeys")
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToMany
    @JoinTable(name = "journey_site", joinColumns = @JoinColumn(name = "journey_id"), inverseJoinColumns = @JoinColumn(name = "site_id"))
    private List<Site> sites;
}
