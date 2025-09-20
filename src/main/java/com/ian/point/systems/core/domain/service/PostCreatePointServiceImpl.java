package com.ian.point.systems.core.domain.service;

import com.ian.point.systems.core.domain.model.dto.PointDto;
import com.ian.point.systems.core.domain.model.request.PostCreatePointRequest;
import com.ian.point.systems.core.domain.model.response.PostCreatePointResponse;
import com.ian.point.systems.core.port.input.PostCreatePointService;
import com.ian.point.systems.core.port.outout.PointRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostCreatePointServiceImpl implements PostCreatePointService {

    private final PointRepository pointRepository;

    @Override
    public PostCreatePointResponse postCreateUser(PostCreatePointRequest postCreatePointRequest) {
        PointDto point = pointRepository.save(PointDto.builder()
                .point(postCreatePointRequest.getPoint())
                .transactionType(postCreatePointRequest.getTransactionType())
                .build());

        return PostCreatePointResponse.builder()
                .pointId(point.getPointId())
                .point(point.getPoint())
                .transactionType(point.getTransactionType())
                .build();
    }
}
