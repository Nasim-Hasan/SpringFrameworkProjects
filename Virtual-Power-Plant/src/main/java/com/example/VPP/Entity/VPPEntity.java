package com.example.VPP.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name = "VPP")
@Getter
@Setter
@NoArgsConstructor
public class VPPEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "capacity")
    private long capacity;
    @Column(name = "avg_capacity")
    private double avgCapacity;
    @Column(name = "total_capacity")
    private long totalCapacity;
}
