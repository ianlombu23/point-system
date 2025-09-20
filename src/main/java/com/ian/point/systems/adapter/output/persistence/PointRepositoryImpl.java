package com.ian.point.systems.adapter.output.persistence;

import com.ian.point.systems.adapter.output.persistence.entity.PointEntity;
import com.ian.point.systems.adapter.output.persistence.repository.PointJpaRepository;
import com.ian.point.systems.core.domain.model.dto.PointDto;
import com.ian.point.systems.core.port.outout.PointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class PointRepositoryImpl implements PointRepository {

    private final PointJpaRepository pointJpaRepository;

    @Override
    public PointDto save(PointDto pointDto) {
        PointEntity pointSave = pointJpaRepository.save(PointEntity.builder()
                .transactionType(pointDto.getTransactionType())
                .point(pointDto.getPoint())
                .build());

        return PointDto.builder()
                .pointId(pointSave.getPointId().toString())
                .transactionType(pointSave.getTransactionType())
                .point(pointSave.getPoint())
                .build();
    }

    @Override
    public Optional<PointDto> findById(String pointId) {
        return pointJpaRepository.findById(UUID.fromString(pointId))
                .map(point -> PointDto.builder()
                        .pointId(point.getPointId().toString())
                        .point(point.getPoint())
                        .transactionType(point.getTransactionType())
                        .build());
    }
}
