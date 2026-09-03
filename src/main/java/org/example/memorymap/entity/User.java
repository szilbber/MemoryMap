package org.example.memorymap.entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @ManyToMany
    @JoinTable(
            name = "user_family",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "family_id")
    )
    private Set<Family> families;

}
