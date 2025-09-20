package com.ian.point.systems.adapter.output.persistence;


import com.ian.point.systems.adapter.output.persistence.entity.UserEntity;
import com.ian.point.systems.adapter.output.persistence.repository.UserJpaRepository;
import com.ian.point.systems.core.domain.model.dto.UserDto;
import com.ian.point.systems.core.port.outout.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImp implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userSave = userJpaRepository.save(UserEntity.builder()
                .userName(userDto.getUserName())
                .build());

        return UserDto.builder()
                .userId(userSave.getUserId().toString())
                .userName(userSave.getUserName())
                .build();
    }

    @Override
    public Optional<UserDto> findById(String userId) {
        return userJpaRepository.findById(UUID.fromString(userId))
                .map(user -> UserDto.builder()
                        .userId(user.getUserId().toString())
                        .userName(user.getUserName())
                        .build());
    }
}
