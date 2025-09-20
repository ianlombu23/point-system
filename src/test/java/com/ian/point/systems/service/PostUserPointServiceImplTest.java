package com.ian.point.systems.service;

import com.ian.point.systems.core.domain.model.dto.PointDto;
import com.ian.point.systems.core.domain.model.dto.UserDto;
import com.ian.point.systems.core.domain.model.dto.UserPointDto;
import com.ian.point.systems.core.domain.model.request.PostUserPointRequest;
import com.ian.point.systems.core.domain.model.response.PostUserPointResponse;
import com.ian.point.systems.core.domain.service.PostUserPointServiceImpl;
import com.ian.point.systems.core.port.outout.PointRepository;
import com.ian.point.systems.core.port.outout.UserPointRepository;
import com.ian.point.systems.core.port.outout.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PostUserPointServiceImplTest {

    @InjectMocks
    private PostUserPointServiceImpl userPointService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private PointRepository pointRepository;
    @Mock
    private UserPointRepository userPointRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testSuccessSaveUserPoint() {
        PostUserPointRequest mockRequest = PostUserPointRequest.builder()
                .userId(UUID.randomUUID().toString())
                .pointId(UUID.randomUUID().toString())
                .transactionId(UUID.randomUUID().toString())
                .build();

        UserDto mockUser = UserDto.builder()
                .userId(mockRequest.getUserId())
                .userName("ian lombu")
                .build();

        PointDto mockPoint = PointDto.builder()
                .pointId(mockRequest.getPointId())
                .point(10)
                .build();

        UserPointDto userPointSave = UserPointDto.builder()
                .userPointId(UUID.randomUUID().toString())
                .userId(mockUser.getUserId())
                .point(mockPoint.getPoint())
                .pointId(mockPoint.getPointId())
                .transactionId(mockRequest.getTransactionId())
                .build();

        when(userRepository.findById(Mockito.any())).thenReturn(Optional.of(mockUser));
        when(pointRepository.findById(Mockito.any())).thenReturn(Optional.of(mockPoint));
        when(userPointRepository.save(Mockito.any())).thenReturn(userPointSave);

        PostUserPointResponse response = userPointService.postUserPoint(mockRequest);
        assertNotNull(response);
        assertEquals(mockUser.getUserId(), response.getUserId());
        assertEquals(mockPoint.getPointId(), response.getPointId());
        assertEquals(mockPoint.getPoint(), response.getPoint());
        assertEquals(mockRequest.getTransactionId(), response.getTransactionId());
    }
}
