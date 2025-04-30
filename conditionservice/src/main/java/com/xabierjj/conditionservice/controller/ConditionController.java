package com.xabierjj.conditionservice.controller;

import com.xabierjj.conditionservice.dto.ConditionRequest;
import com.xabierjj.conditionservice.model.Condition;
import com.xabierjj.conditionservice.service.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/conditions")
@RequiredArgsConstructor
public class ConditionController {

    private final ConditionService service;

    @PostMapping
    public ResponseEntity<Condition> create(@RequestBody ConditionRequest request) {
        return ResponseEntity.ok(service.createCondition(request));
    }


}
