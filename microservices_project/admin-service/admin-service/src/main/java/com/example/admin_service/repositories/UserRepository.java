package com.example.admin_service.repositories;

//package com.example.user_service.repository;

import com.example.admin_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
