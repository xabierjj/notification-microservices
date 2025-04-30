package com.xabierjj.conditionservice.dto;

import com.xabierjj.conditionservice.model.Condition.Direction;
import lombok.Data;

@Data
public class ConditionRequest {
    private String userId;
    private String asset;
    private Double threshold;
    private Direction direction;
}
