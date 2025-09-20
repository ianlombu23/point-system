package com.ian.point.systems.service;

import com.ian.point.systems.core.domain.model.dto.PointDto;
import com.ian.point.systems.core.domain.model.enums.TranscationType;
import com.ian.point.systems.core.domain.model.request.PostCreatePointRequest;
import com.ian.point.systems.core.domain.model.response.PostCreatePointResponse;
import com.ian.point.systems.core.domain.service.PostCreatePointServiceImpl;
import com.ian.point.systems.core.port.outout.PointRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PostCreatePointServiceImplTest {

    @InjectMocks
    private PostCreatePointServiceImpl postCreatePointService;

    @Mock
    private PointRepository pointRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testSuccessCreatePoint() {
        PostCreatePointRequest mockRequest = PostCreatePointRequest.builder()
                .point(10)
                .transactionType(TranscationType.QRIS.name())
                .build();

        PointDto mockPointSave = PointDto.builder()
                .transactionType(mockRequest.getTransactionType())
                .point(mockRequest.getPoint())
                .pointId(UUID.randomUUID().toString())
                .build();

        when(pointRepository.save(Mockito.any())).thenReturn(mockPointSave);

        PostCreatePointResponse response = postCreatePointService.postCreateUser(mockRequest);
        assertNotNull(response);
        assertEquals(mockPointSave.getPoint(), response.getPoint());
        assertEquals(mockPointSave.getTransactionType(), response.getTransactionType());
        assertNotNull(response.getPointId());
    }
}
