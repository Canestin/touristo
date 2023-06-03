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
@Table(name = "circuits")
public class Circuit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer numberOfDays;

    @ManyToMany
    @JoinTable(name = "circuit_site", joinColumns = @JoinColumn(name = "circuit_id"), inverseJoinColumns = @JoinColumn(name = "site_id"))
    private List<Site> sites;
}
