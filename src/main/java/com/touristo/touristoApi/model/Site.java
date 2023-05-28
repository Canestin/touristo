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
    private String latitude;
    private String longitude;
    private String historicalContext;
    private Double importance;
    private String type;

    // public Site(String department, String name, String streetName, String
    // codePostal, String country,
    // String latitude, String longitude, String historicalContext, String
    // importance, String type) {
    // this.department = department;
    // this.name = name;
    // this.streetName = streetName;
    // this.codePostal = codePostal;
    // this.country = country;
    // this.latitude = latitude;
    // this.longitude = longitude;
    // this.historicalContext = historicalContext;
    // this.importance = importance;
    // this.type = type;
    // }
}
