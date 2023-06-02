package com.touristo.touristoApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sites")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String department;
    private String name;
    private String streetName;
    private String codePostal;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
    private String historicalContext;
    private Double importance;
    private String type;

}
