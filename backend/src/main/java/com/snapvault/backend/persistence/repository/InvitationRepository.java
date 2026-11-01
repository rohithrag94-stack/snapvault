package com.snapvault.backend.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snapvault.backend.persistence.entity.InvitationEntity;

public interface InvitationRepository extends JpaRepository<InvitationEntity, UUID> {
}
