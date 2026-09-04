package org.example.memorymap.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "burial_locations")
public class BurialLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(name = "is_exact", nullable = false)
    private Boolean isExact;

    private String description;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @OneToMany(mappedBy = "burialLocation")
    private Set<GravePhoto> gravePhotos = new HashSet<>();;

}