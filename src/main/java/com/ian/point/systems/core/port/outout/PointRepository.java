package com.ian.point.systems.core.port.outout;

import com.ian.point.systems.core.domain.model.dto.PointDto;

import java.util.Optional;

public interface PointRepository {
    PointDto save(PointDto pointDto);
    Optional<PointDto> findById(String pointId);
}
