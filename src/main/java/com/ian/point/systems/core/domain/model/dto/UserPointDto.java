package com.ian.point.systems.core.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserPointDto {
    private String userPointId;
    private String userId;
    private String pointId;
    private String transactionId;
    private Integer point;
}
