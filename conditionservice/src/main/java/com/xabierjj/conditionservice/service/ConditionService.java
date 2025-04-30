package com.xabierjj.conditionservice.service;

import com.xabierjj.conditionservice.dto.ConditionRequest;
import com.xabierjj.conditionservice.model.Condition;
import com.xabierjj.conditionservice.model.Condition.Direction;
import com.xabierjj.conditionservice.repository.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionService {

    private final ConditionRepository repository;

    public Condition createCondition(ConditionRequest request) {
        Condition condition = Condition.builder()
                .userId(request.getUserId())
                .asset(request.getAsset().toUpperCase())
                .threshold(request.getThreshold())
                .direction(request.getDirection())
                .notified(false)
                .build();
        return repository.save(condition);
    }

    public List<Condition> getMatchingConditions(String asset, double currentPrice) {
        asset = asset.toUpperCase();
        List<Condition> triggered = new ArrayList<>();

        List<Condition> above = repository.findByAssetAndNotifiedFalseAndDirectionAndThresholdLessThanEqual(
                "BTC", Direction.ABOVE, currentPrice);
        List<Condition> below = repository.findByAssetAndNotifiedFalseAndDirectionAndThresholdGreaterThanEqual(
                "BTC", Direction.BELOW, currentPrice);
        triggered.addAll(below);
        triggered.addAll(above);
        return triggered;
    }

    public void markAsNotified(Condition condition) {
        condition.setNotified(true);
        repository.save(condition);
    }
}
