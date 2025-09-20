package com.ian.point.systems.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "point-system", name = "user_point")
public class UserPointEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="user_point_id")
    private UUID userPointId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "point_id")
    private UUID pointId;

    @Column(name = "transaction_id")
    private UUID transactionId;

    @Column(name = "point")
    private Integer point;

}
