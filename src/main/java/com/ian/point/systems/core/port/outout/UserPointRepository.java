package com.ian.point.systems.core.port.outout;

import com.ian.point.systems.core.domain.model.dto.UserPointDto;

public interface UserPointRepository {
    UserPointDto save(UserPointDto userPointDto);
}