package com.github.sergiooliveirabr.algorithmsapi.services.sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SortOrchestratorStrategy {

    private final Map<String, SortAlgorithmsStrategy> sortAlgorithmsStrategyMap;

    @Autowired
    public SortOrchestratorStrategy(Map<String, SortAlgorithmsStrategy> sortAlgorithmsStrategyMap) {
        this.sortAlgorithmsStrategyMap = sortAlgorithmsStrategyMap;
    }

    public void sortOrchestrator(int[] arrayToSort, String selectedStrategy) {

        SortAlgorithmsStrategy sortAlgorithmsStrategy = sortAlgorithmsStrategyMap.get(selectedStrategy);

        if (sortAlgorithmsStrategy == null) {
            throw new IllegalArgumentException("No such strategy: " + selectedStrategy);
        }
        sortAlgorithmsStrategy.sortAlgorithm(arrayToSort);
    }
}
