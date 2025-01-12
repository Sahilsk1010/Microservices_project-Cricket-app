package com.cricket.field_service.repositories;

import com.cricket.field_service.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {
    // Custom query methods can be added here if needed
}
