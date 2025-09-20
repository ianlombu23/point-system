package com.ian.point.systems.core.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCreatePointResponse {
    private String pointId;
    private String transactionType;
    private Integer point;
}
