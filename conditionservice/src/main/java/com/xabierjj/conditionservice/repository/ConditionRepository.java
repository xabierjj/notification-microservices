package com.xabierjj.conditionservice.repository;

import com.xabierjj.conditionservice.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
    List<Condition> findByAssetAndNotifiedFalseAndDirectionAndThresholdLessThanEqual(
        String asset,
        Condition.Direction direction,
        Double currentPrice
    );
    

    List<Condition> findByAssetAndNotifiedFalseAndDirectionAndThresholdGreaterThanEqual(
        String asset,
        Condition.Direction direction,
        Double currentPrice
    );
    

}
