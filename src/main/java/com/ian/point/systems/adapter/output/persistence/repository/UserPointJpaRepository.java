package com.ian.point.systems.adapter.output.persistence.repository;

import com.ian.point.systems.adapter.output.persistence.entity.UserPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPointJpaRepository extends JpaRepository<UserPointEntity, UUID> {
}
