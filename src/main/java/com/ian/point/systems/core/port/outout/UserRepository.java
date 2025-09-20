package com.ian.point.systems.core.port.outout;

import com.ian.point.systems.core.domain.model.dto.UserDto;

import java.util.Optional;

public interface UserRepository {
    UserDto save(UserDto userDto);
    Optional<UserDto> findById(String userId);
}
