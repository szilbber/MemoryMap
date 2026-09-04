package org.example.memorymap.repository;

import org.example.memorymap.entity.PersonPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonPhotoRepository extends JpaRepository<PersonPhoto, Long> {
}