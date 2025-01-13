package com.example.admin_service.repositories;
//import
import com.example.admin_service.model.Match;
import com.example.admin_service.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}


