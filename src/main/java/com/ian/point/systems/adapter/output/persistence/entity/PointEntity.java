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
@Table(schema = "point-system", name = "point")
public class PointEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="point_id")
    private UUID pointId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "point")
    private Integer point;

}
