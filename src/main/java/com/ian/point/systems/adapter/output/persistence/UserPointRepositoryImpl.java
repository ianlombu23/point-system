package com.ian.point.systems.adapter.output.persistence;

import com.ian.point.systems.adapter.output.persistence.entity.UserPointEntity;
import com.ian.point.systems.adapter.output.persistence.repository.UserPointJpaRepository;
import com.ian.point.systems.core.domain.model.dto.UserPointDto;
import com.ian.point.systems.core.port.outout.UserPointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserPointRepositoryImpl implements UserPointRepository {

    private final UserPointJpaRepository userPointJpaRepository;

    @Override
    public UserPointDto save(UserPointDto userPointDto) {
        UserPointEntity userPointSave = userPointJpaRepository.save(UserPointEntity.builder()
                .userId(UUID.fromString(userPointDto.getUserId()))
                .pointId(UUID.fromString(userPointDto.getPointId()))
                .transactionId(UUID.fromString(userPointDto.getTransactionId()))
                .point(userPointDto.getPoint())
                .build());

        return UserPointDto.builder()
                .userPointId(userPointSave.getUserPointId().toString())
                .pointId(userPointSave.getPointId().toString())
                .userId(userPointSave.getUserId().toString())
                .transactionId(userPointSave.getTransactionId().toString())
                .point(userPointSave.getPoint())
                .build();
    }
}
