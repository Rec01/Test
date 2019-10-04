package com.example.test3.repository;

import com.example.test3.model.EntityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с БД
 */
@Repository
public interface EntityDataRepository extends JpaRepository<EntityData, String> {

}
