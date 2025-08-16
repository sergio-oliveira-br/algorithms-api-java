package com.github.sergiooliveirabr.algorithmsapi.services.linearsearch;

import com.github.sergiooliveirabr.algorithmsapi.exception.StrategyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FindMinOrMaxOrchestrator {

    private final Map<String, FindMinOrMaxInterface> findMinMaxOrchestratorMap;

    public FindMinOrMaxOrchestrator(Map<String, FindMinOrMaxInterface> findMinMaxOrchestrator) {
        this.findMinMaxOrchestratorMap = findMinMaxOrchestrator;
    }

    public int executeStrategy(String StrategyName, int[] array) {

        FindMinOrMaxInterface strategy = findMinMaxOrchestratorMap.get(StrategyName);

        if (strategy == null) {
            throw new StrategyNotFoundException("Strategy " + StrategyName + " not found");
        }
        return strategy.findMinOrMax(array);
    }
}
