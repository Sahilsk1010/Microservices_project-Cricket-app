package com.cricket.bowler_service.repositories;

import com.cricket.bowler_service.model.Bowler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlerRepository extends JpaRepository<Bowler, Integer> {
    // Custom query methods can be added here if needed
}

