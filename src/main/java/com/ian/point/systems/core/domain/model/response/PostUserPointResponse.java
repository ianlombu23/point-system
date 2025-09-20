package com.ian.point.systems.core.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostUserPointResponse {
    private String userPointId;
    private String userId;
    private String pointId;
    private String transactionId;
    private Integer point;
}
