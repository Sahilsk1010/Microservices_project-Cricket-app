package com.example.admin_service.repositories;

//package com.example.user_service.repository;

import com.example.admin_service.model.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {
    List<UserTeam> findByUserId(Long userId);
}
