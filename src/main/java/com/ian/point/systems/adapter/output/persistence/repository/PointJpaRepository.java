package com.ian.point.systems.adapter.output.persistence.repository;

import com.ian.point.systems.adapter.output.persistence.entity.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PointJpaRepository extends JpaRepository<PointEntity, UUID> {
}
