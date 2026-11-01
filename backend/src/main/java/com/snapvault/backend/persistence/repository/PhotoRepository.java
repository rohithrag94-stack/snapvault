package com.snapvault.backend.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snapvault.backend.persistence.entity.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, UUID> {
}
