package com.touristo.touristoApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "circuits")
public class Circuit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer numberOfDays;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "circuit_id")
    private List<Journey> journeys;
}
