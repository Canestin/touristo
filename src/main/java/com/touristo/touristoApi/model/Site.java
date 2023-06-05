package com.touristo.touristoApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String city;
    private Integer code_departement;
    private String description;
    private String historical_context;
    private Double importance;
    private Double latitude;
    private Double longitude;
    private String name;
    private String type;

}
