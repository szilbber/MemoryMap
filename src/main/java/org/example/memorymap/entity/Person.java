package org.example.memorymap.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "death_date")
    private LocalDate deathDate;
    @Column(name = "death_year")
    private Integer deathYear;

    private String biography;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @OneToMany(mappedBy = "person")
    private Set<PersonPhoto> personPhotos = new HashSet<>();;

    @OneToOne(mappedBy = "person")
    private BurialLocation burialLocation;
}
