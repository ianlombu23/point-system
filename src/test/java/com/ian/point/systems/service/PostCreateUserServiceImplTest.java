package com.ian.point.systems.service;

import com.ian.point.systems.core.domain.model.dto.UserDto;
import com.ian.point.systems.core.domain.model.request.PostCreateUserRequest;
import com.ian.point.systems.core.domain.model.response.PostCreateUserResponse;
import com.ian.point.systems.core.domain.service.PostCreateUserServiceImpl;
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

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PostCreateUserServiceImplTest {

    @InjectMocks
    private PostCreateUserServiceImpl postCreateUserService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testSuccessCreateUser() {
        PostCreateUserRequest mockRequest = PostCreateUserRequest.builder()
                .userName("ian lombu")
                .build();

        UserDto mockUser = UserDto.builder()
                .userId(UUID.randomUUID().toString())
                .userName(mockRequest.getUserName())
                .build();

        when(userRepository.save(Mockito.any())).thenReturn(mockUser);

        PostCreateUserResponse response = postCreateUserService.postCreateUser(mockRequest);
        assertNotNull(response);
        assertEquals(mockRequest.getUserName(), response.getUserName());
    }
}
