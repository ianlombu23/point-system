package com.ian.point.systems.core.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class PointDto {
    private String pointId;
    private String transactionType;
    private Integer point;
}
