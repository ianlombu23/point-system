package com.ian.point.systems.core.domain.service;

import com.ian.point.systems.core.domain.model.dto.PointDto;
import com.ian.point.systems.core.domain.model.dto.UserPointDto;
import com.ian.point.systems.core.domain.model.request.PostUserPointRequest;
import com.ian.point.systems.core.domain.model.response.PostUserPointResponse;
import com.ian.point.systems.core.exception.CustomException;
import com.ian.point.systems.core.port.input.PostUserPointService;
import com.ian.point.systems.core.port.outout.PointRepository;
import com.ian.point.systems.core.port.outout.UserPointRepository;
import com.ian.point.systems.core.port.outout.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostUserPointServiceImpl implements PostUserPointService {

    private final UserRepository userRepository;
    private final PointRepository pointRepository;
    private final UserPointRepository userPointRepository;


    @Override
    public PostUserPointResponse postUserPoint(PostUserPointRequest postUserPointRequest) {
        validateUser(postUserPointRequest);
        PointDto point = validatePoint(postUserPointRequest);
        UserPointDto userPointSave = userPointRepository.save(UserPointDto.builder()
                .pointId(postUserPointRequest.getPointId())
                .userId(postUserPointRequest.getUserId())
                .transactionId(postUserPointRequest.getTransactionId())
                .point(point.getPoint())
                .build());

        return PostUserPointResponse.builder()
                .userPointId(userPointSave.getUserPointId())
                .userId(userPointSave.getUserId())
                .point(userPointSave.getPoint())
                .pointId(userPointSave.getPointId())
                .transactionId(userPointSave.getTransactionId())
                .build();
    }

    private void validateUser(PostUserPointRequest postUserPointRequest) {
        userRepository.findById(postUserPointRequest.getUserId())
                .orElseThrow(() -> new CustomException(
                        "4000",
                        "User Not Found",
                        HttpStatus.CONFLICT));
    }

    private PointDto validatePoint(PostUserPointRequest postUserPointRequest) {
        return pointRepository.findById(postUserPointRequest.getPointId())
                .orElseThrow(() -> new CustomException(
                        "4200",
                        "Point Not Found",
                        HttpStatus.CONFLICT));
    }
}
