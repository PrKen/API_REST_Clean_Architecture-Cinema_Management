package com.example.infrastructure.repository;

import com.example.infrastructure.entity.SalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSalleRepository extends JpaRepository<SalleEntity, Long> {
}
