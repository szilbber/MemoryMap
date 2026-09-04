package org.example.memorymap.repository;

import org.example.memorymap.entity.BurialLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurialLocationRepository extends JpaRepository<BurialLocation, Long> {
}