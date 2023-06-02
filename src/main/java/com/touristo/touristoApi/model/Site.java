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
    private Integer code_departement;
    private String name;
    private String description;
    private String city;
    private Double latitude;
    private Double longitude;
    private String historical_context;
    private Double importance;
    private String type;
}
