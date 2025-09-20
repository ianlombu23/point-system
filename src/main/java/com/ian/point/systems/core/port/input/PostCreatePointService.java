package com.ian.point.systems.core.port.input;

import com.ian.point.systems.core.domain.model.request.PostCreatePointRequest;
import com.ian.point.systems.core.domain.model.response.PostCreatePointResponse;

public interface PostCreatePointService {
    PostCreatePointResponse postCreateUser(PostCreatePointRequest postCreatePointRequest);
}
