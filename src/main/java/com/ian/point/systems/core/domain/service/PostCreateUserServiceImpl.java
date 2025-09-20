package com.ian.point.systems.core.domain.service;

import com.ian.point.systems.core.domain.model.dto.UserDto;
import com.ian.point.systems.core.domain.model.request.PostCreateUserRequest;
import com.ian.point.systems.core.domain.model.response.PostCreateUserResponse;
import com.ian.point.systems.core.port.input.PostCreateUserService;
import com.ian.point.systems.core.port.outout.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostCreateUserServiceImpl implements PostCreateUserService {

    private final UserRepository userRepository;

    @Override
    public PostCreateUserResponse postCreateUser(PostCreateUserRequest postCreateUserRequest) {
        UserDto user = userRepository.save(UserDto.builder()
                .userName(postCreateUserRequest.getUserName())
                .build());

        return PostCreateUserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }
}
