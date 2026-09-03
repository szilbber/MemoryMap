package org.example.memorymap.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "families")
    private Set<User> users;
}