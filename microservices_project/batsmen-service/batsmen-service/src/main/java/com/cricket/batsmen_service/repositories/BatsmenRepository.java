package com.cricket.batsmen_service.repositories;

import com.cricket.batsmen_service.model.Batsmen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatsmenRepository extends JpaRepository<Batsmen, Integer> {
    // Custom query methods can be added here if needed
}
