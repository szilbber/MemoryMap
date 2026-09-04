package org.example.memorymap.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "grave_photos")
public class GravePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "burial_id", nullable = false)
    private BurialLocation burialLocation;

    @Column(name = "file_url")
    private String fileUrl;

}