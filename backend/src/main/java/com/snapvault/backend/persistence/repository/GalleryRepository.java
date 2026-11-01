package com.snapvault.backend.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snapvault.backend.persistence.entity.GalleryEntity;

public interface GalleryRepository extends JpaRepository<GalleryEntity, UUID> {
}
