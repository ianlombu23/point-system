package com.ian.point.systems.core.port.input;

import com.ian.point.systems.core.domain.model.request.PostUserPointRequest;
import com.ian.point.systems.core.domain.model.response.PostUserPointResponse;

public interface PostUserPointService {
    PostUserPointResponse postUserPoint(PostUserPointRequest postUserPointRequest);
}
