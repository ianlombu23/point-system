package com.ian.point.systems.core.port.input;

import com.ian.point.systems.core.domain.model.request.PostCreateUserRequest;
import com.ian.point.systems.core.domain.model.response.PostCreateUserResponse;

public interface PostCreateUserService {
    PostCreateUserResponse postCreateUser(PostCreateUserRequest postCreateUserRequest);
}
