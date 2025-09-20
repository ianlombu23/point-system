package com.ian.point.systems.adapter.input.rest.point;

import com.ian.point.systems.core.domain.model.request.PostCreatePointRequest;
import com.ian.point.systems.core.domain.model.request.PostCreateUserRequest;
import com.ian.point.systems.core.domain.model.request.PostUserPointRequest;
import com.ian.point.systems.core.domain.model.response.PostCreatePointResponse;
import com.ian.point.systems.core.domain.model.response.PostCreateUserResponse;
import com.ian.point.systems.core.domain.model.response.PostUserPointResponse;
import com.ian.point.systems.core.port.input.PostCreatePointService;
import com.ian.point.systems.core.port.input.PostCreateUserService;
import com.ian.point.systems.core.port.input.PostUserPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point/v1")
@RequiredArgsConstructor
public class PointController {

    private final PostCreatePointService postCreatePointService;
    private final PostCreateUserService postCreateUserService;
    private final PostUserPointService postUserPointService;

    @PostMapping(value = "")
    public PostCreatePointResponse postCreatePoint(@RequestBody PostCreatePointRequest postCreatePointRequest) {
        return postCreatePointService.postCreateUser(postCreatePointRequest);
    }

    @PostMapping(value = "/user")
    public PostCreateUserResponse postCreateUser(@RequestBody PostCreateUserRequest postCreateUserRequest) {
        return postCreateUserService.postCreateUser(postCreateUserRequest);
    }

    @PostMapping(value = "/user-point/submit")
    public PostUserPointResponse postCreateUser(@RequestBody PostUserPointRequest postUserPointRequest) {
        return postUserPointService.postUserPoint(postUserPointRequest);
    }
}
