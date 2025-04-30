package com.xabierjj.conditionservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder.Default;

@Entity
@Table(name = "conditions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String asset;

    private Double threshold;

    @Enumerated(EnumType.STRING)
    private Direction direction;

    @Default
    private boolean notified = false;

    public enum Direction {
        ABOVE,
        BELOW
    }
}
